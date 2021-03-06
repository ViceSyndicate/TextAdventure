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
    protected Position position;
    public List<doorsEnum> doorsInRoom = new ArrayList<doorsEnum>();
    ArrayList<Item> itemsInRoom = new ArrayList<>();
    ArrayList<Character> charArrayList = new ArrayList<Character>();

    // varje rum hanterar sina egna dörrar och när spelaren vill gå ngt håll
    // Så frågar main klassen om det finns en dörr i direktionen spelaren vill gå.

    public void lookAroundRoom(){
        System.out.println("It looks like you're in a " + name);
        if (description != null)
            System.out.println(description);

        if (itemsInRoom.size() > 0){
            System.out.println("There seems to be a few items in the room.");
            for (Item item : itemsInRoom)
                System.out.println(item.getName());
        }

        System.out.print("There are " + doorsInRoom.size() + " paths. ");
        for (doorsEnum paths : doorsInRoom){
            System.out.print(paths + ", ");
        }
        System.out.println();

        if (charArrayList.size() > 0){
            System.out.println("You're not alone in the room!");
            for (int i = 0; i < charArrayList.size(); i++){
                System.out.println("There's a" +
                        "[" + i + "] " + charArrayList.get(i).getName());
            }
        }
    }

    public Room getRoomByPlayerPosition(Character player, List<Room> allRooms){
        Room currentRoom;
        // look through all the rooms
        for (Room room : allRooms) {
            // if you find a room with the same coordinates as the player
            if (room.position.x == player.position.x &&
                    room.position.y == player.position.y &&
                        room.position.z == player.position.z){
                currentRoom = room;
                return currentRoom;
            }
        }
        // Player is out of bounds. Return the first room in roomArrayList
        return allRooms.get(0);
    }

    public boolean isValidDirection(Character player, List<Room> roomList, doorsEnum direction){
        Room currentRoom = getRoomByPlayerPosition(player, roomList);
        for (doorsEnum pathsFromRoom : currentRoom.doorsInRoom){
            if (direction == pathsFromRoom){
                System.out.println("You go " + direction);
                return true;
            }
        }
        System.out.println("You try to go " + direction + " but there's no path in that direction.");
        return false;
    }

    public Position getPosition() {
        return position;
    }

    public Room (String name, List<doorsEnum> paths, Position position){
        this.name = name; // Is this bad practice? to name the ctor var the same as the rooms name.
        this.doorsInRoom = new ArrayList<>(paths);
        // this.doorsInRoom = paths;
        this.position = new Position(position);
    }
}
