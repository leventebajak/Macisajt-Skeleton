import java.awt.Color;
import java.awt.Graphics;

/**
 * A városok ciszternáit megvalósító osztály.
 * Felelőssége a beérkező víz gyűjtése és a szerelők pontszámának növelése.
 * Továbbá új csöveket hozhat létre.
 */
public class Cistern extends Node {

    @Override
    public void drawOnMap(Graphics g) {
        // TODO: ciszterna felrajzolása a center attribútum használatával
    	g.setColor(Color.RED);
        int radius = 15; 
        
        int x = center.X() - radius;
        int y = center.Y() - radius;
        
        g.fillOval(x, y, radius * 2, radius * 2);
    }

    @Override
    public boolean intersect(Point point) {
        // TODO: metszet eldöntése
        return false;
    }

    /**
     * Ez a függvény a kör végén hívódik meg. A ciszterna az összes csatlakoztatott csőből vizet szív be és a
     * beszívott víz mennyiségével növeli a szerelő csapat pontszámát. Véletlenszerűen új csövet is létrehozhat,
     * de az egyszerű tesztelhetőség kedvéért a prototípusban mindig létrejön egy új cső.
     */
    public void step() {
        for (var pipe : pipes) {
            int removedWater = pipe.removeWater(1);
            this.addWater(removedWater);
        }

        boolean createNewPipe = Math.random() * 100 <= 33;
        if (createNewPipe) {
            Pipe newPipe = new Pipe();
            newPipe.addNeighbor(this);
            this.addNeighbor(newPipe);
            PIPELINE_SYSTEM.addComponent(newPipe);
        }
    }

    /**
     * A szerelő csapat pontszámának növelése.
     *
     * @param amount a bejövő víz mennyisége
     * @return minden esetben a paraméterként kapott szám
     */
    public int addWater(int amount) {
        PIPELINE_SYSTEM.collectWater(Math.min(amount, PIPELINE_SYSTEM.flowRate));
        return amount;
    }

    /**
     * Ennek a függvénynek a törzse üres, mert a ciszternából nem szívható víz.
     *
     * @param amount a kimenő víz mennyisége
     * @return minden esetben 0
     */
    public int removeWater(int amount) {
        return 0;
    }

    /**
     * A ciszterna fogadja a játékost.
     * Ha a belépő játékosnál nincs pumpa akkor kap egyet.
     *
     * @param player a fogadott játékos
     * @return Ha sikerült hozzáadni akkor igaz, egyébként hamis
     */
    @Override
    public boolean accept(Player player) {
        if (super.accept(player)) {
            player.receivePump();
            return true;
        }
        return false;
    }

    /**
     * A szerelő megfogja a csőnek azt a végét, amelyik nem a ciszternához csatlakozik.
     *
     * @param pipe a cső amit megfog a játékos
     * @return a megfogási kísérlet sikeressége
     */
    @Override
    public boolean grabPipe(Pipe pipe) {
        if (pipe.getOccupied() || pipe.getNeighbors() != 1) return false;

        // A csőnek a szabad végét vesszük fel, ezért a ciszterna a szomszédja marad,
        // de valahogy jelölni kell a cső felvételét.
        pipe.setOccupied(true);
        return true;
    }
}