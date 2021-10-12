package Items;

import Items.Item;

public class Weapon extends Item {
    int minDamage;
    int maxDamage;

//    public int attack(){
//        int range = maxDamage - minDamage +1;
//        int randomDamageNumber = (int)(Math.random() * range ) + minDamage;
//        return randomDamageNumber;
//    }

    public Weapon(String name, int minimumDamage, int maximumDamage){
        this.name = name;
        this.minDamage = minimumDamage;
        this.maxDamage = maximumDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getMinDamage() {
        return minDamage;
    }
}
