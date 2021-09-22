public class Weapon {
    String name;
    int minDamage;
    int maxDamage;

    public int attack(){
        int range = maxDamage - minDamage +1;
        int randomDamageNumber = (int)(Math.random() * range ) + minDamage;
        return randomDamageNumber;
    }

    public Weapon(String name, int minimumDamage, int maximumDamage){
        name = name;
        minDamage = minimumDamage;
        maxDamage = maximumDamage;
    }
}
