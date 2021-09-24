public class Character {
    private String name;
    private int hp = 100;
    private int strength;
    private int agility;
    // Strength + HP + Strength Weapon Dmg
    // Agility + Dodge + Agile Weapon Dmg



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

        // We subtract the lowest dice roll.
        int sum = -lowestRoll;
        for (int dice : sumOfRolls){
            System.out.print(dice);
            sum = sum + dice;
        }
        return sum;
    }
}
