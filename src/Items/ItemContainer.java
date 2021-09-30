package Items;

import java.util.ArrayList;

public class ItemContainer extends Item{
    ArrayList<Item> container;
    int size;

    public ItemContainer(int size){
        this.size = size;
    }
    // Creates a container with a list of item
    public ItemContainer(ArrayList<Item> container){
        this.container = container;
    }

    public void AddItemsToContainer(Item item){
        container.add(item);
    }
}
