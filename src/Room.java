import java.util.ArrayList;
import java.util.List;

public class Room {
    String name;
    String description;
    public enum doors {NORTH, EAST, SOUTH, WEST}

    // It seems a List is more suitable but keeping ArrayList for learning purposes.
    ArrayList charArrayList = new ArrayList<>();
    List<Character> charList = new ArrayList<>();

    public Room (String name){
        this.name = name; // Is this bad practice? to name the ctor var the same as the rooms name.
    }
}
