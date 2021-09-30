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
        Room spawnRoom = new Room("Entrance", roomDoors, roomCoordinates);

        // Clear the doors and change x coordinates of this room.
        roomDoors.clear();
        roomDoors.add(doorsEnum.NORTH);
        roomDoors.add(doorsEnum.EAST);
        roomDoors.add(doorsEnum.WEST);
        roomCoordinates[0]++;

        Room room2 = new Room("Cave", roomDoors, roomCoordinates);
        Room room1 = new Room("Tunnel", roomDoors, roomCoordinates);

        roomList.add(spawnRoom);
        roomList.add(room1);

        spawnRoom.charArrayList.add(enemy1);
        spawnRoom.charArrayList.add(enemy2);

        gameLoop(player);
    }

    public void gameLoop(Character player){

        System.out.println("You wake up in a dimly lit cave");
        System.out.println("You can interact with this game using text commands.");
        System.out.println("Write 'help' for some commands");



        while(true){

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toLowerCase(Locale.ROOT);
            String[] commandParts = input.split(" ");

            for (int i = 0; i < commandParts.length; i++){
                if (commandParts[i].contains("go") && commandParts.length > i+1 ){
                    switch (commandParts[i++]) {
                        case "north":
                            // check if there's a door there
                            System.out.println("second word should be north");
                            int[] newCoordinates = player.getPosition();
                            newCoordinates[0] ++;
                        case "east":
                            System.out.println("second word should be east");
                        case "south":
                            System.out.println("second word should be south");
                        case "west":
                            System.out.println("second word should be west");
                        default:
                            System.out.println("there was no landmark direction after 'go'");
                    }
                }
                if (commandParts[i].contains("exit") || commandParts[i].contains("quit")){
                    exitGame();
                }
                if(commandParts[i].contains("help")) {
                    System.out.println("1. Go + North, East, South, West, Up & Down");
                    System.out.println("To enter another room.");
                    System.out.println("Attack to attack using the weapon you have equipped.");
                    System.out.println("quit or exit to close the game down.");
                }
                if (commandParts[0].contains("look")){
                    for (int x = 0; i < roomList.size(); i++){
                        // need to check all 3 values in the array.. this is getting absurd. Ask if there's a better way.
                        if (roomList.get(x).getPosition()[0] == player.getPosition()[0]){
                            System.out.println(roomList.get(x).description);
                        } else {
                            System.out.println("It seems there is no description for this room...");
                        }
                    }
                }
            }
        }
    }

    public void exitGame(){
        System.exit(0);
    }
}
