package Items;

public class Weapon extends Item {
    int minDamage;
    int maxDamage;
    WeaponDamageModifier modifier;

    public Weapon(String name, int minimumDamage, int maximumDamage, WeaponDamageModifier type){
        this.name = name;
        this.minDamage = minimumDamage;
        this.maxDamage = maximumDamage;
        this.modifier = type;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getMinDamage() {
        return minDamage;
    }
}
