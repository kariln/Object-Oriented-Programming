
package minegenkode.trening2018;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
	* Represents a set of die values. A die has six possible values 1-6,
	* but the number of dice may vary from Dice instance to Dice instance.
	* In addition, a Dice-instance can have a score.
	*/
	public class Dice implements Iterable<Integer> {
	 
	   /**
	   * @param dieCount
	   * @return a collection of random integer values in the range 1-6
	   */
	   public static Collection<Integer> randomDieValues(int dieCount) {
	      Collection<Integer> dieValues = new ArrayList<Integer>(dieCount);
	      while(dieValues.size() < dieCount) {
	    	  dieValues.add((int) Math.random() * 6 +1); 
	      }
	      return dieValues;
	   }
	 
	   private final List<Integer> dieValues= new ArrayList<>();
	   private int score;
	   
	 
	   /** (part 1)
	   * Initializes this Dice with the values in dieValues, and a score.
	   * @param dieValues
	   * @param score the score to set, may be -1 for yet unknown
	   * @throws a suitable exception if the die values are outside the valid range
	   */
	   public Dice(Collection<Integer> dieValues, int score) {
	      for (int dieValue : dieValues) {
	    	  if (dieValue < 1 || dieValue >6) {
	    		  throw new IllegalArgumentException("The die value has to be between 1 and 6!");
	    	  }
	    	  else {
	    		  this.dieValues.add(dieValue);
	    	  }
	      }
	      this.score = score;
	   }
	 
	   /** (part 1)
	   * Initializes this Dice with dieCount random values (using Math.random())
	   * @param dieCount
	   */
	   public Dice(int dieCount) {
	      this(randomDieValues(dieCount),-1);
	   }
	 
	   /** (part 1)
	   * Initializes this Dice with the values in dice, and a score
	   * @param dieValues // Denne skulle vært bare "dice", ikke "dieValues"
	   * @param score the score to set, may be -1 for yet unknown
	   */
	   public Dice(Dice dice, int score) {
		   this(dice.dieValues,score);
	   }
	 
	   /** (part 2)
	   * Format: [die1, die2, ...] = score (score is omitted when < 0)
	   */
	   
	   public String toString(Dice dice) {
		   String output = "[";
		   for (int dieValue : dieValues) {
			   if (output.length() > 1) {
				   output += ", ";
			   }
			   output += dieValue;
		   }
		   output += "]";
		   if (dice.score >= 0) {
			   output += " = " + dice.getScore();;
		   }
	   }
	 
	   /** (part 2)
	   * Parses a string using the toString format (see above) and
	   * returns a corresponding Dice.
	   * @param s
	   * @return a new Dice instance initialized with die values and score from the String argument
	   */
	   public static Dice valueOf(String s) {
	      //må sjekke at man får inn en string på riktig format
		   int score = -1;
		   int scorePos = s.indexOf('=');
		   score = Integer.valueOf(s.substring(scorePos+1).trim());
		   String sub = s.substring(0,scorePos).trim();
		   
		   if (sub.startsWith("[") && sub.endsWith("]")){
			   sub = sub.substring(1,sub.length()-1);
		   }
		   
		   else {
			   throw new IllegalArgumentException("Wrong format of input!");
		   }
		   
		   String[] dieValueStrings = sub.split(",");
		   Collection<Integer> dieValues = new ArrayList<>();
		   for (String dieValue : dieValueStrings) {
			   dieValues.add(Integer.valueOf(dieValue));  
		   }
		   return new Dice(dieValues,score);
		
	   }
	 
	   /** (part 3)
	   * @return the number of die values
	   */
	   public int getDieCount() {
	      return this.dieValues.size();
	   }
	 
	   /** (part 3)
	   * @param dieNum
	   * @return the value of die number dieNum
	   */
	   public int getDieValue(int dieNum) {
	      return this.dieValues.get(dieNum);
	   }
	 
	   /** (part 3)
	   * @param value
	   * @return the number of dice with the provided value
	   */
	   public int getValueCount(int value) {
		   int number = 0;
		   for(int dieValue : this.dieValues) {
			   if (dieValue == value) {
				   number += 1;
			   }
		   }
		   
		   return number;
	   }
	 
	   /** (part 4)
	   * @return the current score
	   */
	   public int getScore() {
	      return this.score;
	   }
	 
	   /** (part 4)
	   * Sets the score, but only if it isn't already set to a non-negative value
	   * @param score
	   * @throws a suitable exception if score already is set to a non-negative value
	   */
	   public void setScore(int score) {
	      if (this.score >= 0) {
	    	  throw new IllegalStateException("The score is already set to a non-negative value. One can only set the score once.");
	      }
	      else {
	    	  this.score = score;
	      }
	   }
	 
	   @Override
	   public Iterator<Integer> iterator() {
		   return this.dieValues.iterator();
	}
	 
	   /** (part 6) // Denne ble det ikke spurt om, og det var ikke meningen at den skulle implementeres, men den kunne brukes
	   * @param dice
	   * @return true if all die values in the argument appear in this Dice
	   */
//	   public boolean contains(Dice dice) {
//	      if ()
//	   }
//	 
	   /** (part 6)
	   * @param dices a Collection of Dice // Denne linja var feil, det skulle være bare "dice a Dice"
	   * @return a new Dice instance with the all the die values this Dice and
	   * all Dice in the argument, without any specific order
	   */
	   public Dice add(Dice dice) {
		   Collection<Integer> diceValues = new ArrayList<Integer>();
		  for (int dieValue : this) {
			  diceValues.add(dieValue);
		  }
		  
		  for ( int diceValue : dice) {
			  diceValues.add(diceValue);
		  }
				
	      Dice die = new Dice(diceValues,-1);
	      return die;
	   }
	 
	   /** (part 6)
	   * @param dice
	   * @return a new Dice instance with the die values from this Dice, but
	   * without those from the argument, without any specific order
	   */
	   public Dice remove(final Dice dice) {
	      
		   Collection<Integer> dieValues = new ArrayList<Integer>(this.dieValues);
		   for (int dieValue : dice.dieValues) {
			   dieValues.remove(dieValue);
		   }
		   
		   return new Dice(dieValues, -1);
	   }
	   
	   /**
	   * Computes a set of Dice with scores for the provided Dice.
	   * @param dice
	   * @return the set of Dice with die values and corresponding scores.
	   */
	   public Collection<Dice> computeDiceScores(Dice dice) {
	      
	   }
	   
	   public static void main(String[] args) {
		   Collection<Integer> dieValues = new ArrayList<Integer>(5);
		   System.out.println(dieValues.size());
	   }

	
	}
	 
