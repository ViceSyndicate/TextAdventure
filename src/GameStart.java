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

        Character enemy1 = new Character("Mammoth", 24, 9);
        Character enemy2 = new Character("Will-O'-Wisp", 5, 28);

        Room room1 = new Room("Entrance");
        roomList.add(room1);

        room1.charArrayList.add(enemy1);
        room1.charArrayList.add(enemy2);

        room1.charList.add(enemy1);
        room1.charList.add(enemy2);

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
        }
    }

    public void exitGame(){
        System.exit(0);
    }
}
