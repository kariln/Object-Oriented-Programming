package stateandbehavior;

public class Digit {
	public int tall;
	public int siffer;
	
	public Digit(int number) {
		this.tall = number;
	}
	
	public int getValue() {
		return siffer;
	}
	
	public int getBase() {
		return tall;
	}

	
	public boolean increment() {
		this.siffer += 1;
		if (this.siffer >= this.tall) {
				this.siffer = 0;
				return true;}
		else {
			return false;}
	}
	
	public void Main(String[] args) {
		increment();
	}
	
	public String toString() {
		return String.valueOf("0123456789ABCDEFGHIJKLMNOPGQRSTUVWXYZ".charAt(siffer));
	}


}
