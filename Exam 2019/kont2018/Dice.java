package kont2018;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Represents a set of die values.
 */
public class Dice implements Iterable<Integer> {
    /**
     * Counters for each possible die value.
     * The counter at index i (0-5) is the counter for the die value i+1 (1-6).
     * I.e. the value at index 2 is the counter for die value 3.
     */
    private final int[] valueCounters;
  
    /**
     * Initializes this Dice with the values in dieValues.
     * @param dieValues sequence of die values, not counter values
     */
    public Dice(Iterator<Integer> dieValues) {
        this.valueCounters = new int[6];
        while (dieValues.hasNext()) {
        	int dieValue = dieValues.next();
        	if (dieValue <= 0 || dieValue >= 7) {
        		throw new IllegalArgumentException("The value of the die must be between 1 and 6");
        	}
        	valueCounters[dieValue-1] +=1;
        }
    }
 
    /**
     * Initializes this Dice with the values in dieValues.
     * @param dieValues sequence of die values, not counter values
     */
    public Dice(Iterable<Integer> dieValues) {
        this(dieValues.iterator());
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new DiceIterator(this);
    }
  
    /**
     * @return the number of die values
     */
    public int getDieCount() {
    	int dieCount = 0;
    	for (int i = 0; i < valueCounters.length ; i += 1) {
    		dieCount += valueCounters[i];
    	}
    	return dieCount;
    }
  
    /**
     * Die values are considered ordered, with the smallest die values
     * at the lowest index. The value at a specific index
     * must be computed from the counters in valueCounters.
     * @param dieNum
     * @return the value of die number dieNum
     * @throws an appropriate exception, if dieNum is out of range
     */
    public int getDieValue(int dieNum) {
    	
    	//sjekker om dieNum er i riktig intervall
    	if (dieNum <= 0 || dieNum > getDieCount()) {
    		throw new IllegalArgumentException( dieNum + " is out of range!");
    	}
    	
    	int counter = 0;
        for (int dieValue = 1; dieValue <= 6; dieValue += 1) {
        	counter += valueCounters[dieValue -1];
        	if ( dieNum < counter ) {
        		return dieValue;
        	}
        }
        
        throw new IllegalArgumentException("Feil!");
        
    }
  
    /**
     * @param value
     * @return the number of dice with the provided value
     */
    public int getValueCount(int value) {
        return valueCounters[value-1];
    }
 
    /**
     * @param dice
     * @return true if all die values in the Dice argument appear in this Dice
     */
    public boolean contains(Dice dice) {
        for (int dieValue = 1 ; dieValue <= 6 ; dieValue++) {
        	if (this.valueCounters[dieValue-1] < dice.getValueCount(dieValue)) {
        		return false;
        	}
        }
        return true;
    }
  
    /**
     * @param dice
     * @return true if this Dice and the one provided have exactly the same die values
     */
    public boolean isSame(Dice dice) {
//        for (int dieValue = 1; dieValue <= 6; dieValue++) {
//        	if (this.valueCounters[dieValue-1] != dice.getValueCount(dieValue)) {
//        		return false;
//        	}
//        }
//        return true;
    	return this.contains(dice) && dice.contains(this);
    }
  
    /**
     * @param dice a Dice object
     * @return a new Dice instance with the all the die values in
     * this Dice and the Dice argument combined
     */
    //
    public Dice add(Dice dice) {
    	//ny terning med 6 plasser med verdi 0
    	Dice result = new Dice(Arrays.asList());
    	
        for(int dieValue = 1; dieValue <= 6; dieValue++) {
        	result.valueCounters[dieValue-1] = dice.getValueCount(dieValue) + this.valueCounters[dieValue-1];
        }
        
        return result;
    }
    
    public static void toString(Dice dice) {
    	for (int dieValue = 1; dieValue <= 6; dieValue++) {
    		int count = dice.valueCounters[dieValue-1];
    		for (int i = 1; i <=count; i++) {
    			System.out.print(dieValue + " ");
    		}
    	}
    }
    
//    public static void toString(Dice dice) {
//    	for (int dieValue : dice) {
//    		System.out.print(dieValue + " ");
//    	}
//    }
  
    /**
     * @param dice
     * @return a new Dice instance with the die values from this Dice, but
     * without those from the Dice argument
     */
    public Dice remove(Dice dice) {
        Dice result = new Dice(Arrays.asList());
        for (int dieValue = 1; dieValue <= 6; dieValue ++) {
        	result.valueCounters[dieValue-1] = this.valueCounters[dieValue-1] - dice.valueCounters[dieValue-1];
        	if (result.valueCounters[dieValue-1] < 0) {
        		result.valueCounters[dieValue-1] = 0;
        	}
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	Dice t1 = new Dice(Arrays.asList(1,2,2,4));
    	Dice t2 = new Dice(Arrays.asList(1,4));
    	System.out.println("true "+t1.contains(t2));
    	Dice t3 = new Dice(Arrays.asList(2,3));
    	System.out.println("false " +t1.contains(t3));
    	System.out.println("true " + t1.isSame(t1));
    	Dice t4 = new Dice(Arrays.asList(1,2,4));
    	System.out.println("false " + t1.isSame(t4));
    	t4.remove(t2);
    	System.out.println(t4.valueCounters[1]);
    	SingleValue s1 = new SingleValue(2,50);
    	DiceScore d1 = s1.getScore(t1);
    	System.out.println(d1.getScore());
    	DiceScore d2 = s1.getScore(t2);
    	//System.out.println(d2.getScore());
    	Straight ss1 = new Straight(100);
    	DiceScore d3 = ss1.getScore(t4);
    	//System.out.println(d3.getScore());
    	DiceScore d4 = ss1.getScore(t3);
    	System.out.println(d4.getScore());
    	toString(t1);
    	t1.forEach(dieValue -> { System.out.println(dieValue + " "); });//consumer
    	
    	
    	
    	
    	
    	
    	
    }
}
