import Items.Item;
import Items.Weapon;

import java.util.*;

public class GameStart {

    public ArrayList<Room> roomList = new ArrayList<Room>();

    public void initialization(){

        // Make a character and set spawnPosition
        Position playerPosition = new Position(50, 50, 50);
        Character player = new Character("TestCharacter", playerPosition);
        System.out.println("Your Strength is: " + player.getStrength());
        System.out.println("Your Agility is: " + player.getAgility());



        // Make some weapons
        Weapon dagger = new Weapon("Dagger", 1,4);
        dagger.setDescription("Short Pointy Sword.");
        Weapon mace = new Weapon("Mace",1, 6);
        mace.setDescription("Bonk em with this");
        player.bag.container.add(dagger);



        // Make some enemies
        Position monsterSpawnCoordinates = new Position(51, 50, 50);
        Character enemy1 = new Character("Mammoth", 24, 9, monsterSpawnCoordinates);
        Character enemy2 = new Character("Will-O'-Wisp", 5, 28, monsterSpawnCoordinates);



        // Create doors enum for use in roomCreation
        List<doorsEnum> roomDoors = new ArrayList<doorsEnum>();
        // add a door to the north in the arrayList of doors.
        roomDoors.add(doorsEnum.NORTH);
        // Create spawn Coordinates
        Position roomCoordinates = new Position(50, 50, 50);
        // This Entrance room should have 1 door to the north and the coordinates above.
        final Room spawn = new Room("Cave", roomDoors, roomCoordinates);
        roomList.add(spawn);

        // Clear the doors and change X coordinates to create a new room to the north.
        roomCoordinates.x++;
        roomDoors.clear();
        // create only 1 door to the east
        roomDoors.add(doorsEnum.EAST);
        final Room tunnel = new Room("Tunnel", roomDoors, roomCoordinates);
        roomList.add(tunnel);

        // set Y Coordinate to +1
        roomCoordinates.y++;
        final Room bigCave = new Room("Big Cave", roomDoors, roomCoordinates);
        bigCave.itemsInRoom.add(mace);

        // Add some enemies to the Cave
        bigCave.charArrayList.add(enemy1);
        bigCave.charArrayList.add(enemy2);
        roomList.add(bigCave);

        gameLoop(player, roomList);
    }

    public void gameLoop(Character player, ArrayList<Room> roomList){

        Room currentRoom = roomList.get(0);
        System.out.println("You wake up in a dimly lit cave");
        System.out.println("You can interact with this game using text commands.");
        System.out.println("Write 'help' for some commands");



        while(true){

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toLowerCase(Locale.ROOT);
            String[] commandParts = input.split(" ");

            for (int i = 0; i < commandParts.length; i++){
                if (commandParts[i].contains("go") && commandParts.length > i+1 ){
                    switch (commandParts[1]) {
                        case "north":
                            if (currentRoom.isValidDirection(player, roomList, doorsEnum.NORTH)){
                                player.position.x ++;
                                currentRoom = currentRoom.getRoomByPlayerPosition(player, roomList);
                            }
                            break;
                        case "east":
                            if (currentRoom.isValidDirection(player, roomList, doorsEnum.EAST)){
                                player.position.y ++;
                                currentRoom = currentRoom.getRoomByPlayerPosition(player, roomList);
                            }
                            break;
                        case "south":
                            if (currentRoom.isValidDirection(player, roomList, doorsEnum.SOUTH)){
                                player.position.x --;
                                currentRoom = currentRoom.getRoomByPlayerPosition(player, roomList);
                            }
                            break;
                        case "west":
                            if (currentRoom.isValidDirection(player, roomList, doorsEnum.WEST)){
                                player.position.y --;
                                currentRoom = currentRoom.getRoomByPlayerPosition(player, roomList);
                            }
                            break;
                        default:
                            System.out.println("there was no landmark direction after 'go'");
                    }
                }
                if (commandParts[0].contains("exit") || commandParts[i].contains("quit")){
                    exitGame();
                }
                if(commandParts[0].contains("help")) {
                    System.out.println("1. Go + North, East, South, West, Up & Down To enter another room.");
                    System.out.println("2. look to see what's in the current room.");
                    System.out.println("Attack to attack using the weapon you have equipped.");
                    System.out.println("Quit or Exit to close the game down.");
                }
                if (commandParts[0].contains("look")){
                    // currentRoom = currentRoom.getRoomByPlayerPosition(player, roomList);
                    // This seems hacky, currentRoom calls its own function with itself.
                    // Is this bad practice?
                    currentRoom.lookAroundRoom(currentRoom);
                }
                if (commandParts[0].contains("take")){
                    for ( Item item : currentRoom.itemsInRoom) {
                        if (commandParts[1].contains(item.getName())){
                            player.bag.addItemToContainer(item);
                        }
                    }
                }
                if (commandParts[0].contains("inventory")){
                    System.out.println("Your bag Contains");
                    System.out.println("---------------------------");
                    for (int x = 0; x < player.bag.container.size(); x++){
                        System.out.println(player.bag.container.get(x).getName());
                    }
                }
            }
        }
    }
    public void exitGame(){
        System.exit(0);
    }
}
