package kont2018;

public class DiceScore {
	
	private final Dice dice;
	private final int score;
	
    /**
    * Initialises a DiceScore object with the provided data
    * @param scoringDice the Dice object containing
    * only the die values contibuting to the score
    * @param score the score itself
    */
    public DiceScore(Dice dice, int score) {
        this.dice = dice;
        this.score = score;
    }
    
    public Dice getDice() {
    		return this.dice;
    }
    
    public int getScore() {
    	return this.score;
    }


}
