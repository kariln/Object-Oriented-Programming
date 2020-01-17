package inheritance;

public class DebitAccount extends AbstractAccount{

	public DebitAccount() {
		super(0);
	}

	@Override
	public void internalWithdraw(double uttak) {

		if (this.balance > uttak && uttak >= 0) {
			this.balance -= uttak;
		}
		
		else if (uttak < 0){
			throw new IllegalArgumentException("M� ta ut et positivt bel�p!");
		}
		
		else {
			throw new IllegalStateException("Man kan ikke ta ut mer penger enn man har fra en debitkonto!");
		}
	}

}
