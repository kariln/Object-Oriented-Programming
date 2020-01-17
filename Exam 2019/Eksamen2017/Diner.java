package minegenkode.Eksamen2017;

import java.util.ArrayList;
import java.util.Collection;

public class Diner {
	/**
	 * A place where groups of guests can buy a meal
	 */
	
	private Collection<Table> tables;
	private Collection<Seating> seatings;
	
		public Diner(Table...tables2) {
			for(Table table : tables2) {
				tables.add(table);
			}
			
			seatings = new ArrayList<Seating>();
		}
		
	       /**
	       * Tells whether a Table is occupied.
	       * @param table the Table to check
	       * @return true if anyone is sitting at the provided Table
	       */
	       public boolean isOccupied(Table table) {
	              for(Seating seat : seatings) {
	            	  if (seat.getTable().equals(table)) {
	            		  return true;
	            	  }
	              }
	              
	              return false;
	       }
	       
	       /**
	       * Computes the guest capacity,
	        * either the remaining (includeOccupied == false) or total (includeOccupied == true).
	       * @param includeOccupied controls whether to include tables that are occupied.
	       * @return the guest capacity
	       */
	       public int getCapacity(boolean includeOccupied) {
	    	   		
	              if (includeOccupied == false) {
	            	  int freeCap = 0;
	            	  for(Table table : tables) {
	            		 if (!isOccupied(table)) {
	            			 freeCap += table.getCapacity();
	            		 }
	            	  }
	            	  return freeCap;
	            	  
	              }
	              
	              else {
	            	int totCap = 0;
	  	    	   	for (Table table : tables) {
	  	    	   		totCap += table.getCapacity();
	  	    	   	}
	            	  return totCap;
	              }
	       }
	       
	       /**
	       * Adds a table to this Diner
	       * @param table
	       */
	       public void addTable(Table table) {
	              tables.add(table);
	       }
	  
	       /**
	       * Removes a Table from this Diner.
	       * If the table is occupied an IllegalArgumentException exception should be thrown.
	       * @param table
	       * @throws IllegalArgumentException
	       */
	       public void removeTable(Table table) {
	    	   if (isOccupied(table)) {
	    		   throw new IllegalStateException("Cannot remove an occupied table!");
	    	   }
	    	   if (!tables.contains(table)) {
	    		   throw new IllegalArgumentException("The table doesn't exist in this diner!");
	    	   }
	           tables.remove(table);
	       }
	       
	       /**
	       * Merges two tables, i.e. replaces two tables with one table.
	       * lostCapacity is the difference between the old capacity and the new.
	       * This number is typically positive, since seats are lost when moving two tables
	        * close to each other.
	       * @param table1
	       * @param table2
	       * @param lostCapacity
	       * @throws IllegalArgumentException if any of the tables are occupied
	       */
	       public void mergeTables(Table table1, Table table2, int lostCapacity) {
	           if (table1 == table2) {
	        	   throw new IllegalArgumentException("The tables are the same.");
	           }
	           Table table3 = new Table(this.getCapacity(false)-lostCapacity);
	           tables.remove(table1);
	           tables.remove(table2);
	           tables.add(table3);
	       }
	  
	       /**
	       * Splits a table into two, i.e. replaces one tables with two tables.
	       * The two capacities are the capacities of the two new tables.
	       * @param table
	       * @param capacity1
	       * @param capacity2
	       * @throws IllegalArgumentException if the table is occupied
	       */
	       public void splitTable(Table table, int capacity1, int capacity2) {
	             Table table1 = new Table(capacity1);
	             Table table2 = new Table(capacity2);
	             tables.add(table1);
	             tables.add(table2);
	             tables.remove(table);
	       }
	  
	       /**
	       * Tells whether a table has the provided capacity,
	       * i.e. if that number of new guests can be seated there.
	       * Note that a table cannot be shared among different groups.
	       * @param table
	       * @param capacity
	       * @return true of capacity number of guests can be seated here, false otherwise.
	       */
	       public boolean hasCapacity(Table table, int capacity) {
	              ...
	       }
	  
	       /**
	       * Returns the tables that has the provided capacity.
	       * The tables should be sorted with the one with the least capacity (but enough) first.
	       * @param capacity
	       * @return the tables that has the provided capacity
	       */
	       public Collection<Table> findAvailableTables(int capacity) {
	              ...
	       }
	       
	       /**
	       * Finds a suitable, existing table for the provided group, and creates
	       * (but doesn't add) a corresponding Seating.
	       * The chosen table should be the one with the least capacity.
	       * @param group the group to be seated
	       * @return the newly created Seating
	       */
	       public Seating createSeating(Group group) {
	              ...
	       }
	       
	       /**
	       * Creates and adds a Seating for the provided group, using the createSeating method.
	       * @param group
	       * @return true if a Seating was created and added, false otherwise.
	       */
	       public boolean addSeating(Group group) {
	              ...
	       }
	       
	       /**
	       * Removes the seating for the provided table (number), if one exists
	       * @param tableNum the number of the table to be removed
	       */
	       public void removeSeating(int tableNum) {
	              ...
	       }
	       
	       public static void main(String args[]) {
	    	   System.out.println("hei");
	       }
	}
	  
	
