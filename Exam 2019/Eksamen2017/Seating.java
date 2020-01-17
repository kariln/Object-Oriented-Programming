package minegenkode.Eksamen2017;

public class Seating {
	
	private final Table table;
	private final Group group;
	
    /**
    * Initializes this Seating ...
    */
    public Seating(Table table, Group group) {
           
           this.group = group;
           
           if( group.getGuestCount() > table.getCapacity()) {
        	   throw new IllegalArgumentException("The table is too small for the group!");
           }
           
           this.table = table;
    }
	
    public Table getTable() {
    	return this.table;
    }
    
    public Group getGroup() {
    	return this.group;
    }
	
}
