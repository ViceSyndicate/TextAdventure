public class GameStart {

    public void initialization(){
        Character player = new Character("TestChar");
        System.out.println("Your Strength is: " + player.getStrength());
        System.out.println("Your Agility is: " + player.getAgility());

        Weapon dagger = new Weapon("Dagger", 1,4);
        dagger.description = "Short Pointy Sword.";

        
        Character enemy1 = new Character("Mammoth", 24, 9);
        Character enemy2 = new Character("Will-O'-Wisp", 5, 28);

        Room room1 = new Room("Entrance");
        room1.charArrayList.add(enemy1);
        room1.charArrayList.add(enemy2);

        room1.charList.add(enemy1);
        room1.charList.add(enemy2);

        System.out.println(room1.name);
    }

    public void gameLoop(){

    }

    public void exitGame(){
        System.exit(0);
    }
}
