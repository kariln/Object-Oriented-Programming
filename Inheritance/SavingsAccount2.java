package inheritance;

public class SavingsAccount2 extends AbstractAccount{
	
	protected int withdrawls;
	protected double fee;
	protected double balance;

	public SavingsAccount2(int withdrawls, double fee) {
		super(balance);
		this.withdrawls = withdrawls;
		this.fee = fee;
		
	}

	@Override
	public void internalWithdraw(double uttak) {
		if (this.withdrawls > 0 && (this.balance -uttak)>=0 && uttak >=0) {
			this.withdrawls -= 1;
			this.balance -= uttak;
		}
		else if((this.balance - uttak - this.fee)>= 0 && uttak >= 0) {
			this.balance -= uttak+this.fee;
		}
		else if (uttak < 0) {
			throw new IllegalArgumentException("Kan ikke ta ut et negativt beløp");
		}
		else {
			throw new IllegalStateException("Ikke nok penger til å utføre uttak!");
		}
		
		
	}

}
