import Items.Weapon;

import java.util.*;

public class GameStart {

    public ArrayList<Room> roomList = new ArrayList<Room>();

    public void initialization(){

        Character player = new Character("TestChar");
        System.out.println("Your Strength is: " + player.getStrength());
        System.out.println("Your Agility is: " + player.getAgility());

        Weapon dagger = new Weapon("Dagger", 1,4);
        dagger.setDescription("Short Pointy Sword.");
        Weapon mace = new Weapon("Mace",1, 6);
        mace.setDescription("Bonk em with this");

        int[] monsterSpawnCoordinates = {51, 50, 50};
        Character enemy1 = new Character("Mammoth", 24, 9);
        Character enemy2 = new Character("Will-O'-Wisp", 5, 28);

        int[] roomCoordinates = {50, 50, 50};
        List<doorsEnum> roomDoors = new ArrayList<doorsEnum>();
        roomDoors.add(doorsEnum.NORTH);
        Room entrance = new Room("Entrance", roomDoors, roomCoordinates);
        roomList.add(entrance);

        // Clear the doors and change x coordinates of this room.
        roomDoors.clear();
        roomDoors.add(doorsEnum.NORTH);
        roomDoors.add(doorsEnum.EAST);
        roomDoors.add(doorsEnum.WEST);
        roomCoordinates[0]++;


        Room tunnel = new Room("Tunnel", roomDoors, roomCoordinates);
        roomList.add(tunnel);
        roomDoors.add(doorsEnum.EAST);



        Room cave = new Room("Cave", roomDoors, roomCoordinates);
        cave.charArrayList.add(enemy1);
        cave.charArrayList.add(enemy2);
        roomList.add(cave);


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

                                System.out.println(player.getPosition()[0]);
                                System.out.println(currentRoom.getPosition()[0]);

                                int[] newCoordinates = player.getPosition();
                                newCoordinates[0] = newCoordinates[0]+1;
                                player.setPosition(newCoordinates);
                                currentRoom.position[0] = currentRoom.position[0]+1;
                            }
                            break;
                        case "east":
                            System.out.println("second word should be east");
                            break;
                        case "south":
                            if (currentRoom.isValidDirection(player, roomList, doorsEnum.SOUTH)){
                                int[] newCoordinates = player.getPosition();
                                newCoordinates[0] = newCoordinates[0]-1;
                                player.setPosition(newCoordinates);
                                currentRoom.position[0] = currentRoom.position[0]-1;
                            }
                            break;
                        case "west":
                            System.out.println("second word should be west");
                            break;
                        default:
                            System.out.println("there was no landmark direction after 'go'");
                    }
                }
                if (commandParts[0].contains("exit") || commandParts[i].contains("quit")){
                    exitGame();
                }
                if(commandParts[0].contains("help")) {
                    System.out.print("1. Go + North, East, South, West, Up & Down To enter another room.");
                    System.out.println("Attack to attack using the weapon you have equipped.");
                    System.out.println("Quit or Exit to close the game down.");
                }
                if (commandParts[0].contains("look")){
                    currentRoom = currentRoom.getRoomByPlayerPosition(player, roomList);
                    // This seems hacky, currentRoom calls its own function with itself.
                    // Is this bad practice?
                    currentRoom.lookAroundRoom(currentRoom);
                }
            }
        }
    }
    public void exitGame(){
        System.exit(0);
    }
}
