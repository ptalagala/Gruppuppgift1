import java.util.random.RandomGenerator;

public class Dice {
    public int roll() {
        /**
         * roll a 6 sided dice. Returns a random number between 1 and 6.
         */
        RandomGenerator rand = RandomGenerator.getDefault();

        return rand.nextInt(1, 7);
    }

    
}
