public class Character {
    private String name;
    private int hp = 100;
    private int strength;
    private int agility;
    // Strength + HP + Strength Weapon Dmg
    // Agility + Dodge + Agile Weapon Dmg

    // returns a random value between minAttackVal and maxAttackVal.
    // Since we're working with dice the min value will always be 1, so I could
    // write this code shorter but this is more flexible. So I'm keeping it just in case.
    public int attack(int minAttackVal, int maxAttackVal){
        int range = maxAttackVal - minAttackVal +1;
        return (int)(Math.random() * range ) + minAttackVal;
    }

    public int getAgility() {
        return agility;
    }

    public int getStrength() {
        return strength;
    }

    public Character(String charName){
        name = charName;
        strength = characterStatGenerator();
        agility = characterStatGenerator();
    }

    // rolls 4 Six Sided die, ignores the lowest roll, and adds them together.
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
