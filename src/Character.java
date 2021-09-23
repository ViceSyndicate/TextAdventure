public class Character {
    private String name;
    private int hp = 100;
    private int[] stats;
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
        strength = 8;
        agility = 8;
        characterStatGenerator();
    }

    public void characterStatGenerator(){
        int[] sumOfRolls = new int[4];

        int minRoll = 1;
        int maxRoll = 6;
        int range = maxRoll - minRoll +1;
        for (int i = 0; i < 4; i++){
            int diceResult = (int)(Math.random() * range ) + minRoll;
            sumOfRolls[i] = diceResult;
        }
        // now remove smallest val in array

        for (int i = 0; i < sumOfRolls.length; i++){

        }



        //roll 4d6, ignore the lowest roll, and add them together.
        // For example, if you roll a 4 5 2 6, you ignore the 2, and you’ve got 15.
        //You do that 6 times, pool them all together,
        // and distribute them however you’d like
        // (this is to avoid a Wizard having an awkwardly high Strength because you rolled well the first time).

    }
}
