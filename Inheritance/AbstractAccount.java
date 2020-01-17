package inheritance;

public abstract class AbstractAccount {
	
	protected double balance;
	
	public AbstractAccount(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double innskudd) {
		if (innskudd >= 0) {
			this.balance += innskudd;
		}
		
		else {
			throw new IllegalArgumentException("Innskuddet m� v�re positivt!");
		}
		
	}
	
	public void withdraw(double uttak) {
		
		if ( uttak >= 0) {
			this.internalWithdraw(uttak);
		}
		
		else {
			throw new IllegalArgumentException("Uttaket m� v�re positivt!");
		}
	}
	
	public abstract void internalWithdraw(double mengde);
	
	public double getBalance() {
		return this.balance;
	}

}
