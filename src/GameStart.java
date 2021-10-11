import Items.Item;
import Items.Weapon;

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






        RoomGeneration roomGenerator = new RoomGeneration();
        ArrayList<Room> roomList = roomGenerator.generateRooms();
        // Add some enemies to the Cave
        //bigCave.charArrayList.add(enemy1);
        //bigCave.charArrayList.add(enemy2);

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
                if (commandParts[0].equalsIgnoreCase("exit") || commandParts[i].contains("quit")){
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
                if (commandParts[0].equalsIgnoreCase("take") && commandParts.length > 0){
                    for ( Item item : currentRoom.itemsInRoom) {
                        if (commandParts[1].equalsIgnoreCase(item.getName())){
                            player.bag.addItemToContainer(item);
                            System.out.println("Added " + item.getName() + " To the bag!");
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
            }
        }
    }
    public void exitGame(){
        System.exit(0);
    }
}
