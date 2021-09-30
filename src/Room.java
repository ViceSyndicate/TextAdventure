import Items.Item;

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

    // varje rum hanterar sina egna dörrar och när spelaren vill gå ngt håll
    // Så frågar main klassen om det finns en dörr i direktionen spelaren vill gå.

    public boolean isValidDirection(){
        // needs to track if there are adjacent rooms.
        return false;
    }

    String name;
    String description;
    int[] position = new int[3];
    public List<doorsEnum> paths = new ArrayList<doorsEnum>();

    // Add other lists of different items later.
    Item[] itemsInRoom;

    ArrayList charArrayList = new ArrayList<>();

    public int[] getPosition() {
        return position;
    }

    public Room (String name, List<doorsEnum> paths, int[] position){
        this.name = name; // Is this bad practice? to name the ctor var the same as the rooms name.
        this.paths = paths;
        this.position = position;
    }
}
