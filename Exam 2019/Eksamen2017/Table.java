package minegenkode.Eksamen2017;

public class Table {
	
	private static int tableCounter = 1;
	//når variabelen er static er den felles for alle objektene i klassen
	
	private final int capacity;
	private final int tableNum;
	
	/**
     * Initializes this Table with the provided capacity.
     * The table is also assigned a unique number.
     * @param capacity
     */
     public Table(int capacity) {
          this.capacity = capacity;
          this.tableNum = tableCounter++;
          //++a increments and then uses the variable.
          //a++ uses and then increments the variable.
          //trenger ikke bruke dette i en løkke
          
          
     }

     /**
     * @return the table number
     */
     public int getNum() {
         return this.tableNum;
     }
     
     public int getCapacity() {
    	 return this.capacity;
     }
	
}
