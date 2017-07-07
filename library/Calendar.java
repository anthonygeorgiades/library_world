package library;

public class Calendar {
	
	/**
	 * Declare variable as private int date within the class itself 
	 */
	private int date; //declare the variable to keep track of how many days have passed
		
	
	//Constructor
	/**
	 * This is the constructor, which sets the date to 0
	 * We need only one calendar since time is the same for everyone
	 */
	public Calendar(){
		date = 0;
		
	}
	
	//Methods
	
	/**
	 * @return this method just returns an integer the current date 
	 */
	public int getDate(){
		return date;
	}
	
	/**
	 * This method just increments the date by 1, by moving ahead to the next day
	 */
	public void advance(){
		date++;
		//date = date +1;
		
	}
}
