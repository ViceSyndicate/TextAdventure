import java.util.ArrayList;
import java.util.List;

enum doorsEnum {
    NORTH,
    EAST,
    SOUTH,
    WEST,
    UP,
    DOWN
};

public class Room {
    String name;
    String description;
    int[] coordinates = new int[2];
    public List<doorsEnum> paths = new ArrayList<doorsEnum>();

    // Add other lists of different items later.
    Weapon[] weaponsInRoom;

    ArrayList charArrayList = new ArrayList<>();


    public Room (String name, List<doorsEnum> paths, int[] coordinates){
        this.name = name; // Is this bad practice? to name the ctor var the same as the rooms name.
        this.paths = paths;
        this.coordinates = coordinates;
    }
}
