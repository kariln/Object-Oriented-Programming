package app;

//import javax.print.DocFlavor.STRING;

public class kalkulator {
	private double svar;
	//private String svar2;
	
	public kalkulator() {}

	public double gange(int tall, int number) {
		svar = tall*number;
		return svar;
	}
	
	//public String toString(double svar) {
		//String svar2 = String.valueOf(svar);
		//return svar2;
	//}

	public double dele(int tall, int number) {
		if(number != 0) {
			svar = tall/number;
			return svar;}
		else {
			throw new IllegalArgumentException("Kan ikke dele på null!");
		}
	}
	
	public double pluss(int tall, int number) {
		int svar = tall+number;
		return svar;
	}
	
	public double minus(int tall, int number) {
		int svar = tall-number;
		return svar;
	}
}
