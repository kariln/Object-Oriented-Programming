package stateandbehavior;

public class UpOrDownCounter {
//	
//	UpOrDownCounter(int start, int end) - initialiserer objektet med angitte start- og slutt-verdier, hvor alts� slutt kan v�re st�rre eller mindre enn start, slik at telleren teller henholdsvis opp eller ned. Lik start og slutt-verdi skal utl�se unntak av typen IllegalArgumentException (se Koding av valideringsmetoder).
//
//	int getCounter() - returnerer telleren
//	boolean count() - beveger telleren i retning av slutt-verdien og returnerer true s� lenge den ikke har n�dd den, alts� om telleren har mer igjen, og false ellers.
//	
	
	private int counter;
	private int start;
	private int end;
	private int delta;
	
	//konstrukt�r
	UpOrDownCounter(int start, int end) {
		this.start = start;
		this.end = end;
		this.counter = start;
		this.delta = signum(start,end);
	}
	
	public int signum(int start,int end) {
		if (start > end) {
			return -1;
		}
		
		else if (start < end) {
			return 1;
		}
		
		else {
			return 0;
		}
	}
	
	public int getCounter() {
		return counter;
	}
	
	public boolean count() {
		//hvis b�de start og counter er mindre eller st�rre enn end
		if (signum(start,end) ==signum(counter,end)) {
			counter = counter + delta;
		}
		//returnerer true hvis start er ulik end og  hvis counteren ikke har n�dd end
		return start != end && counter != end;
	}

}

