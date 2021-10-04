package Items;

import java.util.ArrayList;

public class ItemContainer extends Item{
    String name;
    public ArrayList<Item> container = new ArrayList<Item>();
    int size;

    // create A empty container with a set size nr
    public ItemContainer(String name, int size){
        this.name = name;
        this.size = size;
    }
    // Creates a container with a list of item
    public ItemContainer(String name, ArrayList<Item> container, int size){
        this.name = name;
        this.container = container;
        this.size = size;
    }

    public void addItemToContainer(Item item){
        if (container.size() < size)
            container.add(item);
        else
            System.out.println("The container can't fit any more items.");
    }

    public void lookThroughContainer (){
        System.out.println("The " + name + " contains:");
        System.out.println("--------------------");
        for (Item item: container) {
            System.out.println(item.name);
        }
    }
}
