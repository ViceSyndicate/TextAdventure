import java.util.Locale;
import java.util.Scanner;

public class GameStart {

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
        String[] inputArray = input.split(" ");

        for (int i = 0; i < inputArray.length; i++){
            if (inputArray[i].contains("go")){
                switch (inputArray[++i]) {
                    case "north":

                    case "east":

                    case "south":
                        
                    case "west":

                    default:
                }
            }
        }


        switch (input) {
            case "help":
                // List commands
                ;

            case "go":
        }

        exitGame();
    }

    public void exitGame(){
        System.exit(0);
    }
}
