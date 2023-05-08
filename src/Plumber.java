/**
 * Szerelő csapat játékosait reprezentáló osztály. Felelőssége a csövek megjavítása és új pumpa lerakása.
 */
public class Plumber extends Player {

    /**
     * Az a cső, amit a szerelő felvett.
     */
    private Pipe grabbedPipe;

    /**
     * Ez az attribútum a szerelőnél lévő pumpa referenciája.
     */
    private Pump grabbedPump;

    /**
     * Szerelő konstruktor.
     *
     * @param name a kiíráskor használt név
     */
    Plumber(String name) {
        super(name);
    }

    /**
     * Pumpa átállítása, de csak akkor, ha a szerelő nem mozgat csövet.
     *
     * @param source      Az a cső, amelyből a pumpa szívja a vizet.
     * @param destination Az a cső, amelybe a pumpa pumpálja a vizet.
     */
    @Override
    public void redirect(Pipe source, Pipe destination) {
        if (grabbedPipe != null) return;
        component.redirect(source, destination);
    }

    /**
     * A jelenlegi mező megjavításának megkísérlése.
     * Csak akkor hajtható végre, ha a szerelő éppen nem mozgat csövet.
     */
    public void repair() {
        if (grabbedPipe != null) return;
        component.repair();
    }

    /**
     * A szerelőnek való pumpa adás megkísérlése.
     */
    @Override
    public void receivePump() {
        // TODO: plumber naming the created pump and saving its reference in Prototype.objects
        if (grabbedPump != null) return;
        grabbedPump = new Pump("newPump");
    }

    /**
     * A játékosnál található pumpa lerakásának megkísérlése.
     * Csak akkor hajtható végre, ha a szerelő éppen nem mozgat csövet, és van pumpa a szerelőnél.
     */
    public void placePump() {
        if (grabbedPipe != null || grabbedPump == null) return;
        if (component.placePump(grabbedPump)) grabbedPump = null;
    }

    /**
     * Egy megadott cső megfogásának megkísérlése.
     * Csak akkor hajtható végre, ha a szerelő éppen nem mozgat csövet.
     */
    public void grabPipe(Pipe pipe) {
        if (grabbedPipe != null) return;
        if (component.grabPipe(pipe)) grabbedPipe = pipe;
    }

    /**
     * A játékos által megfogott cső lerakásának megkísérlése.
     */
    public void placePipe() {
        if (grabbedPipe == null) return;
        if (component.placePipe(grabbedPipe)) grabbedPipe = null;
    }

    /**
     * A jelenlegi mező kilyukasztásának megkísérlése, ha a játékosnál nincs cső.
     */
    @Override
    public void leak() {
        if (grabbedPipe != null) return;
        super.leak();
    }

    /**
     * A jelenlegi mező ragadóssá tételének megkísérlése, ha a játékosnál nincs cső.
     */
    @Override
    public void makeItSticky() {
        if (grabbedPipe != null) return;
        super.makeItSticky();
    }

    /**
     * Új szerelő létrehozása a megadott névvel és csomópontokkal.
     *
     * @param args
     * @return
     */
    public static Plumber NEW(String[] args) {
        // TODO: new plumber
        return null;
    }

    /**
     * Szerelő tulajdonságainak lekérdezése.
     *
     * @param args
     * @return
     */
    public String stat(String[] args) {
        // TODO: stat plumber
        return null;
    }

    /**
     * Szerelő tulajdonságainak beállítása.
     *
     * @param args
     */
    public void set(String[] args) {
        // TODO: set plumber
    }

    /**
     * Szerelő paraméterként kapott nevű képességének használata.
     *
     * @param args
     */
    public void playerUse(String[] args) {
        // TODO: playeruse plumber
    }
}