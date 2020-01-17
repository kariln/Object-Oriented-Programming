package inheritance;

//import java.util.ArrayList;
import java.util.Iterator;

//import encapsulation.Card;

public class CardDeck extends CardContainerImpl implements Iterable<Card>{

		// array to hold Card objects, filled in the constructor
		//protected ArrayList<Card> cards;

		public CardDeck(int suitSize) {
			super(52);
			for (int i = 0; i < Card.SUITS.length(); i++) {
				for (int face = 1; face <= suitSize; face++) {
					Card card = new Card(Card.SUITS.charAt(i), face);
					cards.add(card);
				}
			}
		}

		@Override
		public String toString() {
			return "[Deck " + cards.toString().substring(1);
		}

		public void shufflePerfectly() {
			int halfSize = cards.size() / 2;
			for (int i = 0; i < halfSize; i++) {
				Card card = cards.remove(halfSize + i);
				cards.add(i * 2 + 1, card);
			}
		}

		@Override
		public Iterator<Card> iterator() {
			return new CardContainerIterator(this);
		}
	}


