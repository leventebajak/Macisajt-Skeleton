/**
 * Szabotőr csapat játékosait megvalósító osztály. Felelőssége a csövek kilyukasztása.
 */
public class Saboteur extends Player {

    /**
     * Szabotőr konstruktor.
     *
     * @param name a kiíráskor használt név
     */
    public Saboteur(String name) {
        super(name);
    }

    /**
     * A jelenlegi mező csúszóssá tételének megkísérlése.
     */
    public void makeItSlippery() {
        component.makeItSlippery();
    }

    /**
     * Új szabotőr létrehozása a megadott névvel és csomóponttal.
     *
     * @param args a parancs elvárt paraméterei: {@code new saboteur <szabotőr neve> <kezdő csomópont neve>}
     * @return a létrehozott szabotőr referenciája
     * @throws IllegalArgumentException érvénytelen paraméter
     */
    public static Saboteur NEW(String[] args) throws IllegalArgumentException {
        if (args.length != 4) throw new IllegalArgumentException("Érvénytelen paraméter!");
        if (Prototype.OBJECTS.containsKey(args[2])) throw new IllegalArgumentException("A név már foglalt!");
        if (!Prototype.OBJECTS.containsKey(args[3]))
            throw new IllegalArgumentException("Nem létezik komponens a megadott névvel!");
        try {
            Component component = (Component) Prototype.OBJECTS.get(args[3]);
            Saboteur saboteur = new Saboteur(args[2]);
            if (component.accept(saboteur)) saboteur.component = component;
            else {
                Prototype.OBJECTS.remove(args[2]);
                throw new IllegalArgumentException("A komponens nem tudja fogadni a szabotőrt!");
            }
            return saboteur;
        } catch (ClassCastException ignored) {
            throw new IllegalArgumentException("Nem létezik komponens a megadott névvel!");
        }
    }

    /**
     * Szabotőr tulajdonságainak lekérdezése.
     *
     * @param args a parancs elvárt paraméterei: {@code stat <objektum neve> [tulajdonság neve]}
     * @return a lekérdezett tulajdonság értéke
     * @throws IllegalArgumentException érvénytelen paraméter
     */
    @Override
    public String stat(String[] args) throws IllegalArgumentException {
        if (args.length == 2) {
            return this + "\nableToMove: " + ableToMove + "\nableToMoveIn: " + ableToMoveIn + "\ncomponent: " + component.name;
        }
        if (args.length != 3) throw new IllegalArgumentException("Érvénytelen paraméter!");
        return switch (args[2].strip().toLowerCase()) {
            case "abletomove" -> "ableToMove: " + ableToMove;
            case "abletomovein" -> "ableToMoveIn: " + ableToMoveIn;
            case "component" -> "component: " + component.name;
            default -> throw new IllegalArgumentException("A szabotőrnek nincs ilyen nevű tulajdonsága!");
        };
    }

    /**
     * Szabotőr tulajdonságainak beállítása.
     *
     * @param args a parancs elvárt paraméterei: {@code set <objektum neve> <tulajdonság neve> <új érték>}
     * @throws IllegalArgumentException érvénytelen paraméter
     */
    @Override
    public void set(String[] args) throws IllegalArgumentException {
        if (args.length != 4) throw new IllegalArgumentException("Hiányzó paraméter!");
        args[3] = args[3].strip();
        switch (args[2].strip().toLowerCase()) {
            case "abletomove" -> {
                switch (args[3]) {
                    case "true" -> ableToMove = true;
                    case "false" -> ableToMove = false;
                    default -> throw new IllegalArgumentException("Érvénytelen a megadott érték!");
                }
            }
            case "abletomovein" -> {
                try {
                    int value = Integer.parseInt(args[3]);
                    if (!(0 <= value && value <= 5)) throw new IllegalArgumentException();
                    ;
                    ableToMoveIn = value;
                    ableToMove = ableToMoveIn == 0;
                } catch (IllegalArgumentException ignored) {
                    throw new IllegalArgumentException("Érvénytelen a megadott érték!");
                }
            }
            case "component" -> {
                try {
                    if (!Prototype.OBJECTS.containsKey(args[3])) throw new IllegalArgumentException();
                    var newComponent = (Component) Prototype.OBJECTS.get(args[3]);
                    if (newComponent instanceof Spring) throw new IllegalArgumentException();
                    if (newComponent instanceof Pipe && ((Pipe) newComponent).getOccupied())
                        throw new IllegalArgumentException();
                    component = newComponent;
                } catch (ClassCastException | IllegalArgumentException ignored) {
                    throw new IllegalArgumentException("Érvénytelen a megadott érték!");
                }
            }
            default -> throw new IllegalArgumentException("Érvénytelen a megadott érték!");
        }
    }

    /**
     * Szabotőr paraméterként kapott nevű képességének használata.
     *
     * @param args a parancs elvárt paraméterei: {@code playeruse <játékos neve> <képesség neve>}
     * @throws IllegalArgumentException érvénytelen paraméter
     */
    @Override
    public void playerUse(String[] args) throws IllegalArgumentException {
        if (args.length < 3) throw new IllegalArgumentException("Hiányzó paraméter!");
        switch (args[2].strip().toLowerCase()) {
            case "redirect" -> {
                if (args.length < 5) throw new IllegalArgumentException("Hiányzó paraméter!");
                try {
                    redirect((Pipe) Prototype.OBJECTS.get(args[3]), (Pipe) Prototype.OBJECTS.get(args[4]));
                } catch (ClassCastException ignored) {
                    throw new IllegalArgumentException("Az objektum nem cső!");
                }
            }
            case "leak" -> leak();
            case "makeitsticky" -> makeItSticky();
            case "makeitslippery" -> makeItSlippery();
            default -> throw new IllegalArgumentException("Érvénytelen paraméter!");
        }
    }
}
