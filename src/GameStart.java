import Items.Item;
import Items.ItemContainer;
import Items.Weapon;

import java.io.IOException;
import java.util.*;

public class GameStart {

    public void initialization(){

        // Make a character and set spawnPosition
        Position playerPosition = new Position(50, 50, 50);
        Character player = new Character("TestCharacter", playerPosition);
        System.out.println("Your Strength is: " + player.getStrength());
        System.out.println("Your Agility is: " + player.getAgility());

        // Make a player weapon
        Weapon dagger = new Weapon("Dagger", 1,4);
        dagger.setDescription("Short Pointy Sword.");
        player.bag.container.add(dagger);

        // Make a test item
        Item banana = new Item();
        banana.setName("Banana");
        banana.setDescription("Skala banan! Skala banan! Skala banan! Skala banan!");
        player.bag.container.add(banana);




        RoomGeneration roomGenerator = new RoomGeneration();
        ArrayList<Room> roomList = roomGenerator.generateRooms();
        // Add some enemies to the Cave
        //bigCave.charArrayList.add(enemy1);
        //bigCave.charArrayList.add(enemy2);

        gameLoop(player, roomList);
    }

    public void gameLoop(Character player, ArrayList<Room> roomList){

        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e){
            System.out.println("Shit went wrong");
            e.printStackTrace();
        }

        Room currentRoom = roomList.get(0);
        System.out.println("You wake up in a dimly lit cave");
        System.out.println("You can interact with this game using text commands.");
        System.out.println("Write 'help' for some commands");


        while(true){

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toLowerCase(Locale.ROOT);
            String[] commandParts = input.split(" ");

            if (commandParts[0].equalsIgnoreCase("go")){
                for (int i = 0; i < commandParts.length; i++){
                    if (commandParts[i].equalsIgnoreCase("go") && commandParts.length > i+1 ){
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
                }
            }


            if (commandParts[0].equalsIgnoreCase("exit") || commandParts[0].equalsIgnoreCase("quit")){
                exitGame();
            }
            if(commandParts[0].equalsIgnoreCase("help")) {
                System.out.println("1. Go + North, East, South, West, Up & Down To enter another room.");
                System.out.println("2. look to see what's in the current room.");
                System.out.println("Attack to attack using the weapon you have equipped.");
                System.out.println("Quit or Exit to close the game down.");
            }
            if (commandParts[0].equalsIgnoreCase("look")){
                // currentRoom = currentRoom.getRoomByPlayerPosition(player, roomList);
                // This seems hacky, currentRoom calls its own function with itself.
                // Is this bad practice?
                currentRoom.lookAroundRoom(currentRoom);
            }
            // Currently picks up at least 2 items and +1 for every word after a space because the loop runs several times.
            // I need this to only run once per command...
            if (commandParts[0].equalsIgnoreCase("take") && commandParts.length > 0){
                for (int i = 0;  i < currentRoom.itemsInRoom.size(); i++){
                    if (commandParts[1].equalsIgnoreCase(currentRoom.itemsInRoom.get(i).getName())){
                        player.bag.addItemToContainer(currentRoom.itemsInRoom.get(i));
                        System.out.println("Added " + currentRoom.itemsInRoom.get(i).getName() + " To the bag!");
                        currentRoom.itemsInRoom.remove(i);
                    }
                }
            }
            if (commandParts[0].equalsIgnoreCase("inventory")){
                System.out.println("Your bag Contains");
                System.out.println("---------------------------");
                for (int x = 0; x < player.bag.container.size(); x++){
                    System.out.println(player.bag.container.get(x).getName());
                }
            }

            if (commandParts[0].equalsIgnoreCase("equip") && commandParts.length > 0 && player.heldWeapon == null){
                for(int i = 0; i < player.bag.container.size(); i++){
                    if (commandParts[1].equalsIgnoreCase(player.bag.container.get(i).getName()) &&
                            player.bag.container.get(i) instanceof Weapon){
                        player.heldWeapon = (Weapon)player.bag.container.get(i);
                        player.bag.container.remove(i);
                    }
                    if (commandParts[1].equalsIgnoreCase(player.bag.container.get(i).getName()) && !(player.bag.container.get(i) instanceof Weapon))
                        System.out.println("That is not a weapon.");
                }
                if (!(player.heldWeapon == null)){
                    System.out.println("You're now Holding a " + player.heldWeapon.getName());
                }
            }
            if (commandParts[0].equalsIgnoreCase("unequip") && commandParts.length > 0 && player.heldWeapon != null){
                player.bag.container.add(player.heldWeapon);
                player.heldWeapon = null;
                System.out.println("You put your weapon in your bag.");
            }
            if (commandParts[0].equalsIgnoreCase("holding") || commandParts[0].equalsIgnoreCase("hand")){
                if (player.heldWeapon == null) {
                    System.out.println("You're unarmed.");
                } else {
                    System.out.println("You're holding a " + player.heldWeapon.getName());
                    System.out.println(player.heldWeapon.getDescription());
                }

            }

        }
    }
    public void exitGame(){
        System.exit(0);
    }
}
