import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GameStart {

    ArrayList<Room> roomList = new ArrayList<Room>();

    public void initialization(){

        Character player = new Character("TestChar");
        System.out.println("Your Strength is: " + player.getStrength());
        System.out.println("Your Agility is: " + player.getAgility());

        Weapon dagger = new Weapon("Dagger", 1,4);
        dagger.description = "Short Pointy Sword.";
        Weapon mace = new Weapon("Mace",1, 6);
        mace.description = "Bonk em with this";

        int[] spawnPosition = {51, 50, 50};
        Character enemy1 = new Character("Mammoth", 24, 9);
        Character enemy2 = new Character("Will-O'-Wisp", 5, 28);

        int[] coordinates = {50, 50, 50};
        List<doorsEnum> roomDoors = new ArrayList<doorsEnum>();
        roomDoors.add(doorsEnum.NORTH);
        Room spawnRoom = new Room("Entrance", roomDoors, coordinates);

        // Clear the doors and change x coordinates of this room.
        roomDoors.clear();
        roomDoors.add(doorsEnum.NORTH);
        roomDoors.add(doorsEnum.EAST);
        roomDoors.add(doorsEnum.WEST);
        coordinates[0]++;
        Room room2 = new Room("Tunnel", roomDoors, coordinates);

        roomList.add(spawnRoom);
        roomList.add(room2);


        spawnRoom.charArrayList.add(enemy1);
        spawnRoom.charArrayList.add(enemy2);



        gameLoop();
    }

    public void gameLoop(){

        System.out.println("You wake up in a dimly lit cave");
        System.out.println("You can interact with this game using text commands.");
        System.out.println("Write 'help' for some commands");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase(Locale.ROOT);
        String[] commandParts = input.split(" ");

        for (int i = 0; i < commandParts.length; i++){
            if (commandParts[i].contains("go") && commandParts.length > i+1 ){
                switch (commandParts[i++]) {
                    case "north":
                        // check if there's a door there
                        System.out.println("second word should be north");
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
        }
    }

    public void exitGame(){
        System.exit(0);
    }
}
