package kont2018;

/**
* Implementation of DiceScorer that gives a specific score
* when no other DiceScore object applies.
* Requires that a certain number of dice have been thrown.
*/
public class Nothing implements DiceScorer {
  
    private final int numDice;
    private final int score;
    private final DiceScorer[] scorers;
  
    /**
    * Initializes this Nothing object with the minimum required number of dice,
     * the specific score given and the other DiceScorer objects.
    * @param numDice the min. number of dice required for this rule to apply
    * @param score the specific score to give
    * @param diceScorers the (other) rules to check
    */
    public Nothing(final int numDice, final int score, final DiceScorer... diceScorers) {
    	//diceScorers er en tabell med DiceScorer-objekter
        this.numDice = numDice;
        this.score = score;
        this.scorers = diceScorers;
   }
  
    /**
    * Checks that no (other) DiceScore object apply,
    * in case a specific score is given.
    */
    @Override
    public DiceScore getScore(Dice dice) {
    	int tmp_score = 0;
        for (DiceScorer score : scorers) {
        	tmp_score = (score.getScore(dice)).getScore();
        	if (tmp_score != 0) {
        		return null;
        	}
        
        }
    return new DiceScore(dice,score);
    }
}
