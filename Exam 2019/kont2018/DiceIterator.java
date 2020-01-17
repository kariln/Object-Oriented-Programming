package kont2018;

import java.util.Iterator;

public class DiceIterator implements Iterator<Integer>{
	
	private final Dice dice;
	private int intnum = 0;
	
	public DiceIterator(Dice dice) {
		this.dice = dice;
	}

	@Override
	public boolean hasNext() {
		return intnum < dice.getDieCount();
	}

	@Override
	public Integer next() {
		int value = dice.getDieValue(intnum);
		intnum++;
		return value;
	}
	
	

}
