public class GameStart {

    public void initialization(){
        Character player = new Character("TestChar");
        System.out.println("Your Strength is: " + player.getStrength());
        System.out.println("Your Agility is: " + player.getAgility());

        System.out.println(player.attack(1,4));
        System.out.println(player.attack(1,4));
        System.out.println(player.attack(1,4));
        System.out.println(player.attack(1,4));
    }

    public void gameLoop(){

    }

    public void exitGame(){
        System.exit(0);
    }
}
