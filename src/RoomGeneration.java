import Items.Weapon;
import Items.WeaponDamageModifier;

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
        roomDoors.add(doorsEnum.WEST);
        Room tunnel = new Room("Tunnel", roomDoors, roomCoordinates);
        roomList.add(tunnel);

        roomDoors.clear();
        roomCoordinates.y = 49;
        roomDoors.add(doorsEnum.WEST);
        roomDoors.add(doorsEnum.EAST);
        Room tunnel2 = new Room("Tunnel", roomDoors, roomCoordinates);
        roomList.add(tunnel2);

        roomDoors.clear();
        roomCoordinates.y = 48;
        roomDoors.add(doorsEnum.EAST);
        Room tunnel3 = new Room("Tunnel", roomDoors, roomCoordinates);
        roomList.add(tunnel3);

        roomDoors.clear();
        roomCoordinates.y = 51;
        roomDoors.add(doorsEnum.WEST);
        Room bigCave = new Room("Big Tunnel", roomDoors, roomCoordinates);
        roomList.add(bigCave);

        // Make some enemies
        Position monsterSpawnCoordinates = new Position(50, 50, 50);
        Character enemy1 = new Character("Mammoth", 24, 9, monsterSpawnCoordinates, 80);
        Character enemy2 = new Character("Will-O'-Wisp", 5, 28, monsterSpawnCoordinates, 20);
        Weapon wand1 = new Weapon("Wand", 4, 8, WeaponDamageModifier.DEXTERITY);
        enemy2.bag.addItemToContainer(wand1);
        enemy2.heldWeapon = wand1;

        spawnRoom.charArrayList.add(enemy1);
        spawnRoom.charArrayList.add(enemy2);

        // Add a mace to the room
        Weapon mace = new Weapon("Mace",1, 6, WeaponDamageModifier.STRENGTH);
        mace.setDescription("Bonk em with this");
        spawnRoom.itemsInRoom.add(mace);

        return roomList;
    }
}


