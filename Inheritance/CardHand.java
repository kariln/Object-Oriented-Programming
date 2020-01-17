package inheritance;

//import java.util.ArrayList;
import java.util.Iterator;


public class CardHand extends CardContainerImpl implements Iterable<Card>{

		// array to hold Card objects, filled in the constructor
		//protected ArrayList<Card> cards;

		public CardHand(int max) {
			super(max);

		}

		@Override
		public String toString() {
			return "[Hand " + cards.toString().substring(1);
		}

		public void addCard(Card card) {
			
			if (this.getCardCount()>=this.maxCardCount) {
				throw new IllegalStateException("For mange kort");
			}
			this.cards.add(card);
		}

		public Card play(int i) {
			return cards.remove(i);
		}

		@Override
		public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
		}



}
