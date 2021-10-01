package Items;

import java.util.ArrayList;

public class ItemContainer extends Item{
    ArrayList<Item> container;
    int size;

    // create a empty container with a set size nr
    public ItemContainer(int size){
        this.size = size;
    }
    // Creates a container with a list of item
    public ItemContainer(ArrayList<Item> container){
        this.container = container;
    }

    public void addItemsToContainer(Item item){
        if (container.size() < size)
            container.add(item);
        else
            System.out.println("The container can't fit any more items.");
    }

    public void lookThroughContainer (){
        System.out.println("The chest contains:");
        System.out.println("--------------------");
        for (Item item: container) {
            System.out.println(item.name);
        }
    }
}
