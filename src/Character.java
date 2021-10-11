import Items.ItemContainer;
import Items.Weapon;

public class Character {
    private String name;
    private int hp = 100;
    private int strength;
    private int agility;
    //public int[] position;
    public Position position;
    ItemContainer bag = new ItemContainer("Backpack", 10);
    // Strength + HP + Strength Items.Weapon Dmg
    // Agility + Dodge + Agile Items.Weapon Dmg

    // returns a random value between minAttackVal and maxAttackVal.
    // Since we're working with dice the min value will always be 1, so I could
    // write this code shorter but this is more flexible. So I'm keeping it just in case.
    // An attack should also take a characters Strength or Agility in consideration
    // So that value also needs to be considered.
    public int attack(int minAttackVal, int maxAttackVal){
        int range = maxAttackVal - minAttackVal +1;
        return (int)(Math.random() * range ) + minAttackVal;
    }

    public void takeDamage(int damage){
        if (this.hp < 1)
        {
            System.out.println("The " + this.name + " is dead.");
            this.hp = this.hp - damage;
        }
    }

    public int getAgility() {
        return agility;
    }

    public int getStrength() {
        return strength;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Character(String charName, Position position){
        name = charName;
        strength = characterStatGenerator();
        agility = characterStatGenerator();
        // Spawn player with a 10 slot bag.
        ItemContainer bag = new ItemContainer("Backpack", 10);
        Weapon startingWeapon = new Weapon("Dagger", 1, 4);
        startingWeapon.setDescription("Sharp, Short and Pointy");
        bag.addItemToContainer(startingWeapon);
        this.position = new Position(position);
    }

    // If i store the enemies in a list in the room then I don't need to give them
    // coordinates. Only the player needs those.
    public Character(String charName, int strength, int agility, Position position, int hp){
        name = charName;
        this.strength = strength;
        this.agility = agility;
        this.position = position;
        this.hp = hp;
    }

    // rolls 4 Six Sided die, ignores the lowest roll, and adds them together.
    // I could modify this function to accept optional values in case I want
    // to make orcs more likely to have extra strength for example.
    public int characterStatGenerator(){

        int[] sumOfRolls = new int[4];
        int lowestRoll = 6;
        int minRoll = 1;
        int maxRoll = 6;
        int range = maxRoll - minRoll +1;

        for (int i = 0; i < 4; i++){
            int diceResult = (int)(Math.random() * range ) + minRoll;
            sumOfRolls[i] = diceResult;
            // Get the lowest dice roll to subtract later.
            if (lowestRoll > diceResult)
                lowestRoll = diceResult;
        }

        // We subtract the lowest dice roll before adding it back in to simulate discarding that roll.
        int sum = -lowestRoll;
        for (int dice : sumOfRolls){
            sum = sum + dice;
        }
        return sum;
    }
}
