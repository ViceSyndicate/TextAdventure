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
    String name;
    String description;
    int[] position = new int[3];
    public List<doorsEnum> doorsInRoom = new ArrayList<doorsEnum>();

    // varje rum hanterar sina egna dörrar och när spelaren vill gå ngt håll
    // Så frågar main klassen om det finns en dörr i direktionen spelaren vill gå.

    public Room getRoomByPlayerPosition(Character player, Room[] allRooms){
        for (Room room : allRooms) {
            if (room.position[0] == )
        }
        Room currentRoom;
    }

    public boolean isValidDirection(Character player, doorsEnum direction){

        for (int i = 0; i < player.getPosition().length; i++){

        }

        System.out.println("You try to go" + direction);


            // needs to track if there are adjacent rooms.
            return false;
    }

    // Add other lists of different items later.
    Item[] itemsInRoom;

    ArrayList charArrayList = new ArrayList<>();

    public int[] getPosition() {
        return position;
    }

    public Room (String name, List<doorsEnum> paths, int[] position){
        this.name = name; // Is this bad practice? to name the ctor var the same as the rooms name.
        this.doorsInRoom = paths;
        this.position = position;
    }
}
