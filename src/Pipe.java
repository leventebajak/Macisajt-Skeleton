import java.util.ArrayList;

public class Pipe extends Component {
    private ArrayList<Node> nodes;
    private boolean occupied = false;
    private final int capacity = 1;
    private int waterLevel;

    public Pipe(String name) { super(name); }

    private void SetOccupied(boolean occupied) { this.occupied = occupied; }
    private void SetWaterLevel(int waterLevel) { this.waterLevel = waterLevel; }

    @Override
    public void Step() {}
    @Override
    public void AddNeighbor(Component component) {}
    @Override
    public void RemoveNeighbor(Component component) {}
    @Override
    public int AddWater(int amount) { return amount; }
    @Override
    public int RemoveWater(int amount) { return amount; }
    @Override
    public boolean Accept(Player player) {
        if(!occupied){
            Skeleton.Call(this, "Accept( " + player + "): Sikeres");
            SetOccupied(true);
            AddPlayer(player);
            Skeleton.Return(true);
            return true;
        } else {
            Skeleton.Call(this, "Accept( " + player + "): Sikertelen" );
            Skeleton.Return(false);
            return false;
        }
    }
    @Override
    public void Remove(Player player) {}
    @Override
    public void Repair() {}
    @Override
    public void Leak() {
        Skeleton.Call(this, "Leak()");
        SetBroken(true);
        Skeleton.Return();
    }
    @Override
    public boolean PlacePump(Pump pump) { return false; }
}
