package kont2018;

import java.util.Arrays;

/**
* Implementation of DiceScorer that gives a specific score til a so-called straight,
* which is when all values give a series of consecutive values, e.g. 1, 2, 3.
* All the die values must be used, so with six dice, the only possibility is 1, 2, 3, 4, 5, 6.
* With five dice, there are two possibilities, 1, 2, 3, 4, 5 and 2, 3, 4, 5, 6.
*/
public class Straight implements DiceScorer {
  
    private final int score;
  
    /**
    * Initializes this Straight object with the specific score.
    * @param score
    */
    public Straight(int score) {
        this.score = score;
    }
  
    /**
    * Checks that all die values in the provided Dice form a series of consecutive values.
    * If this is the case returns a DiceScore object with a Dice with
    * the die values contributing to the score (necessarily all of them) and
    * the corresponding score.
    */
    @Override
    public DiceScore getScore(Dice dice) {
        int start = -1;
        int end = -1;
    	for (int dieValue = 1; dieValue <= 6; dieValue++) {
    		if (dice.getValueCount(dieValue) > 1) {
    			return null;
    		}
    		else if (dieValue == 1 && start == -1){
    			start = dieValue;
    			
    			//return new DiceScore(new Dice(Arrays.asList(value)),score);
    		}
    		
    		else if (start != 0 && dice.getValueCount(dieValue) == 0 && end == -1) {
    			end = dieValue;
    		}
    		
    		else if (end != -1 && dice.getValueCount(dieValue) != 0) {
    			return null;
    		}
    		
    	}
    	
    	return new DiceScore(dice,score);
    }
}