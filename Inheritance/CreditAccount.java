package inheritance;

public class CreditAccount extends AbstractAccount{
	
	protected double creditLine;
	
	public CreditAccount(double credit) {
		//skal egentlig bare ha et argument i konstuktøren. Hvordan skal jeg da få inn både balance og credit?
		super(balance);
		this.setCreditLine(credit);
	}

	@Override
	public void internalWithdraw(double uttak) {
		if ((this.getSaldo()-uttak) >= 0 && uttak >= 0) {
			this.balance -= uttak;
		}
		
		else if (uttak < 0){
			throw new IllegalArgumentException("Må ta ut et positivt beløp!");
		}
		
		else {
			throw new IllegalStateException("Kan ikke ta ut mer penger enn saldoen");
		}
	}
	
	public double getSaldo() {
		return this.balance + this.creditLine;
	}
	
	public void setCreditLine(double credit) {
		if (credit >= 0 && (credit+balance) > 0) {
			this.creditLine = credit;
		}
		
		else if (!(credit >= 0)){
			throw new IllegalArgumentException("Kredittgrensen må være større eller lik null!");
		}
		
		else {
			throw new IllegalStateException("Kan ikke sette en kredittgrense som ikke dekker eksisterende balanse");
		}
	}
	
	public double getCreditLine() {
		return this.creditLine;
	}

}
