package inheritance;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CardContainerIterator implements Iterator<Card>{
	
	//variabler
	//int counter = 0;
	CardContainer cardcontainer;
	private int indeks;
	
	//lager konstruktør
	public CardContainerIterator(CardContainer cc) {
		cardcontainer = cc;
		indeks = 0;
	}
	
	@Override
	public boolean hasNext() {
		//hvordan kan jeg finne ett kort i cardcontainer?
		
		if (this.indeks < cardcontainer.getCardCount()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Card next() {
		// TODO Auto-generated method stub
		
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		
		else{
			
			Card neste = cardcontainer.getCard(indeks);
			indeks = indeks+1;
			return neste;
			
		}
		
	}

}
