package inheritance;

import java.util.ArrayList;

public class CardContainerImpl implements CardContainer{
	
	protected ArrayList<Card> cards;
	protected int maxCardCount;
	
	public CardContainerImpl(int max) {
		cards = new ArrayList<Card>();
		this.maxCardCount = max;
	}

	@Override
	public int getCardCount() {
		return cards.size();
	}

	@Override
	public Card getCard(int i) {
		if (i < 0 || i >= getCardCount()) {
			throw new IllegalStateException(String.format("%s is an illegal card index, when the size of the deck is %s", i, getCardCount()));
		}
		return cards.get(i);
	}

	public int getMaxCardCount() {
		return maxCardCount;
	}

	public void setMaxCardCount(int maxCardCount) {
		this.maxCardCount = maxCardCount;
	}

}
