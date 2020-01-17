package patterns.observable;

//import java.util.ArrayList;
import java.util.*;

public class StockIndex implements StockListener{
	
	private String name;
	private double index;
	private Set <Stock> aksjer = new HashSet<Stock>();
	
	public StockIndex(String name, Stock...stocks) {
		this.name = name;
		if (stocks.equals(null)) {
			this.index = 0;
		}
		for (Stock stock : stocks) {
			aksjer.add(stock);
			stock.addStockListener(this);
			this.index += stock.getPrice(); 
		}
		
	}
	
	@Override
	public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
		// TODO Auto-generated method stub
		double delta = newValue - oldValue;
		this.index = this.index + delta;
		
	}
	
	public void addStock(Stock stock) {
		stock.addStockListener(this);
		if (!aksjer.contains(stock)) {
			this.index += stock.getPrice();
		}
		aksjer.add(stock);
		
	}
	
	public void removeStock(Stock stock) {
		stock.removeStockListener(this);
		
		if (aksjer.contains(stock)) {
			this.index -= stock.getPrice();
			aksjer.remove(stock);
		
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getIndex() {
		return index;
	}

	public void setIndex(double index) {
		this.index = index;
	}

}
