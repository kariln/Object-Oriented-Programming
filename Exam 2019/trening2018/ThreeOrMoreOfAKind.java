package minegenkode.trening2018;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ThreeOrMoreOfAKind implements DiceScorer{
	
	
	private final int[] valueCounters;
	
	//oppgaven inkluderer ikke å lage en konstruktør
	public ThreeOrMoreOfAKind() {
		this.valueCounters = new int[6];
	}

	@Override
	public Dice getScore(Dice dice) {
		
		int value = getBestValue(dice);
		if (value == 0) {
			return null;
		}
		int count = dice.getValueCount(value);
		Collection<Integer> dieValues = new ArrayList<Integer>(count);
		
		for (int i = 0 ; i < count ; i++) {
			dieValues.add(value);
		}
		
		return new Dice(dieValues, getScore(value,count));
		
	}
	
	public int getScore(final int value, int count) {
		int score = 0;
		if (value >= 3) {
			score = value *100;
		}
		
		while (count > 3) {
			score *= 2;
			count --;
		}
		
		return score;
	}
	
	   protected int getBestValue(final Dice dice) {
		      int value = 0, max = 0;
		      for (int i = 1; i <= 6; i++) {
		         int count = dice.getValueCount(i);
		         int score = getScore(i, count);
		         if (count >= 3 && score > max) {
		            value = i;
		            max = score;
		         }
		      }
		      return value;
		   }
	
	
    public static void main(String[] args) {
		System.out.println("hei");
    }

}
