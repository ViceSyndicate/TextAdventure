import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please type in your name: ");
        String userInput = scanner.nextLine();



        Character player = new Character(userInput);
        System.out.println("Your name is " + userInput + ". Is that right?");

        if (scanner.nextLine().toLowerCase() == "yes" || scanner.nextLine().toLowerCase() == "y"){
             // create character with userInputs name as name
        }

    }
}
