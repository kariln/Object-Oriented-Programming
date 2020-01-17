package patterns.observable;

import java.util.*;

public class Stock {
	
	private String ticker;
	private double price;
	Set <StockListener> lyttere = new HashSet<StockListener>();
	
	public Stock(String ticker, double price) {
		this.ticker = ticker;
		this.price = price;
	}
	
	public void addStockListener(StockListener observatoer) {
	//legger til observatører
		lyttere.add(observatoer);
	}
	
	public void removeStockListener(StockListener observatoer) {
	//fjerner observatører	
		lyttere.remove(observatoer);
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price > 0) {
			double oldPrice = this.price;
			this.price = price;
			for (StockListener lytter : lyttere) {
				lytter.stockPriceChanged(this, oldPrice,this.price);
			}
		}
		
		else {
			throw new IllegalArgumentException("Prisen er ugyldig");
		}
	}

}
