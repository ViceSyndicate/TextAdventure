import Items.ItemContainer;
import Items.Weapon;

public class Character {
    private String name;
    private int hp = 100;
    private int strength ;
    private int dexterity;
    Weapon heldWeapon;
    public Position position;
    ItemContainer bag = new ItemContainer("Backpack", 10);
    boolean isDead = false;
    // Strength + HP + Strength Items.Weapon Dmg
    // Agility + Dodge + Agile Items.Weapon Dmg
    int strengthModifier;
    int dexterityModifier;

    public int attack(){
        int modifier = 0;
        if (this.heldWeapon == null){
            if (1 + strengthModifier < 0) { return 0; }
            return 1 + strengthModifier; //
        } else {
            switch (heldWeapon.getModifier()) {
                case DEXTERITY:
                    modifier = dexterityModifier;
                    break;
                case STRENGTH:
                    modifier = strengthModifier;
                    break;
                case FINESS:
                    if (dexterityModifier >= strengthModifier) modifier = dexterityModifier;
                    else modifier = strengthModifier;
            }
            int range = heldWeapon.getMaxDamage() - heldWeapon.getMinDamage() +1;
            return (int)(Math.random() * range ) + heldWeapon.getMinDamage() + modifier;
        }
    }

    public void takeDamage(int damage){
        if (!isDead())
            this.hp = this.hp - damage;
        if (isDead())
            System.out.println("The " + this.name + " is dead.");

    }

    public boolean isDead(){
        if (hp < 1) isDead = true;
        return isDead;
    }

    public String getName(){
        return this.name;
    }

    public int getDexterity() {
        return dexterity;
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
        dexterity = characterStatGenerator();
        strengthModifier = SetModifierBasedOnStatValue(strength);
        dexterityModifier = SetModifierBasedOnStatValue(dexterity);
        // Spawn player with a 10 slot bag.
        ItemContainer bag = new ItemContainer("Backpack", 10);
        this.position = new Position(position);
    }

    //ABILITY SCORES ANO MOOIFIERS
    //Score Modifier Score Modifier
    //1     -5|  16-17 +3
    //2-3   -4|  18-19 +4
    //4-5   -3|  20-21 +5
    //6-7   -2|  22-23 +6
    //8-9   -1|  24-25 +7
    //10-11 +0|  26-27 +8
    //12-13 +1|  28-29 +9
    //14-15 +2|  30    +10

    private int SetModifierBasedOnStatValue(int baseNumber){
        int modifier = 0;
        switch (baseNumber) {
            case 1: modifier = -5; break;
            case 2, 3: modifier = -4; break;
            case 4, 5: modifier = -3; break;
            case 6, 7: modifier = -2; break;
            case 8, 9: modifier = -1; break;
            case 10, 11: modifier = 0; break;
            case 12, 13: modifier = 1; break;
            case 14, 15: modifier = 2; break;
            case 16, 17: modifier = 3; break;
            case 18, 19: modifier = 4; break;
            case 20: modifier = 5; break;
        }
        return modifier;
    }

    public Character(String charName, int strength, int dexterity, Position position, int hp){
        name = charName;
        this.strength = strength;
        this.dexterity = dexterity;
        this.dexterityModifier = SetModifierBasedOnStatValue(this.dexterity);
        this.strengthModifier = SetModifierBasedOnStatValue(this.strength);
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
