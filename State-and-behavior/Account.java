package stateandbehavior;

public class Account {
	//tilstander
	public double balance;
	public double interestRate;
	//double har desimaltall
	
	public void deposit(double tall){
		if (tall > 0) {
			this.balance += tall;
		}
		//øker konto-beløpet med den angitte argument-verdien (et desimaltall), men kun dersom det er positivt
	}
	
	public void addInterest() {
		this.balance += balance*interestRate/100;
		//beregner renta og legger det til konto-beløpet
	}
	
	public double getBalance() {
		return balance;
		//returnerer beløpet som er på kontoen. 
	}
	
	public double getInterestRate() {
		return interestRate;
		//returnerer rentefoten
	}
	
	public void setInterestRate(double value) {
		this.interestRate = value; 
		//oppdaterer renten til å være den nye verdien
	}
	
	public void Main(double tall, double value) {
		deposit(tall);
		addInterest();
		getBalance();
		getInterestRate();
		setInterestRate(value);
	}
}
