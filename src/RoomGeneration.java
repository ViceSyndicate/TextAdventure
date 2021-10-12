import Items.Weapon;

import java.util.ArrayList;
import java.util.List;

public class RoomGeneration {
    ArrayList<Room> roomList = new ArrayList<Room>();
    List<doorsEnum> roomDoors = new ArrayList<doorsEnum>();
    Position roomCoordinates = new Position(50, 50, 50);

    public ArrayList<Room> generateRooms(){
        roomDoors.add(doorsEnum.NORTH);
        Room spawnRoom = new Room("Cave", roomDoors, roomCoordinates);
        roomList.add(spawnRoom);
        roomDoors.clear();

        roomCoordinates.x ++;
        roomDoors.add(doorsEnum.EAST);
        roomDoors.add(doorsEnum.SOUTH);
        Room tunnel = new Room("Tunnel", roomDoors, roomCoordinates);
        roomList.add(tunnel);

        roomDoors.clear();
        roomCoordinates.y ++;
        roomDoors.add(doorsEnum.WEST);
        Room bigCave = new Room("Big Tunnel", roomDoors, roomCoordinates);
        roomList.add(bigCave);

        // Make some enemies
        Position monsterSpawnCoordinates = new Position(51, 50, 50);
        Character enemy1 = new Character("Mammoth", 24, 9, monsterSpawnCoordinates, 80);
        Character enemy2 = new Character("Will-O'-Wisp", 5, 28, monsterSpawnCoordinates, 20);

        bigCave.charArrayList.add(enemy1);
        bigCave.charArrayList.add(enemy2);

        // Add a mace to the room
        Weapon mace = new Weapon("Mace",1, 6);
        mace.setDescription("Bonk em with this");
        bigCave.itemsInRoom.add(mace);
        Weapon BFG = new Weapon("BFG", 12, 24);
        BFG.setDescription("You should not have this.");
        bigCave.itemsInRoom.add(BFG);

        return roomList;
    }
}


