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

    public void lookAroundRoom(Room room){
        System.out.println("It looks like you're in a " + room.name);
        System.out.println(room.description);
        System.out.print("There are " + doorsInRoom.size() + "Paths. ");
        for (doorsEnum paths : doorsInRoom){
            System.out.print(paths + ", ");
        }
    }

    public Room getRoomByPlayerPosition(Character player, List<Room> allRooms){
        Room currentRoom;
        // look through all the rooms
        for (Room room : allRooms) {
            // if you find a room with the same coordinates as the player
            if (room.position[0] == player.position[0] &&
                    room.position[1] == player.position[1] &&
                        room.position[2] == player.position[2]){
                currentRoom = room;
                return currentRoom;
            }
        }
        // Player is out of bounds. Return the first room in roomArrayList
        return allRooms.get(0);
    }

    public boolean isValidDirection(Character player, List<Room> roomList){
        Room currentRoom = getRoomByPlayerPosition(player, roomList);

        for (int i = 0; i < player.getPosition().length; i++){

        }
        System.out.println("You try to go");
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
