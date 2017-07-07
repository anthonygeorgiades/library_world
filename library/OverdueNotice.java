package library;

import java.util.ArrayList;

public class OverdueNotice {
	
	//Instance Variables
	public Patron patron;
	public int todaysDate;
	
	/**
	 * Constructs an overdue notice for the given Patron
	 * Save the patron in an instance variable, and saves today's date in another instance variable
	 * @param patron as inputed in method
	 * @param todaysDate as inputed in method
	 */
	public OverdueNotice(Patron patron, int todaysDate){
		this.patron = patron; //set this.patron to patron
		this.todaysDate = todaysDate; //set this.todaysdate to todaydate
	}
	
	/**
	 * This method returns as a String, in a nice, humanly readable format, an overdue notice
	 * list all the books currently checked out by the patron along with due date
	 * then list books that are overdue
	 */
	public String toString(){
		ArrayList<Book> bookList = patron.getBooks(); //first call the getBooks method for the patron and label it as new object BookList
		//Create a string called return value which establishes the first part of the notice from the library listing all books and due dates
		String returnValue = "This is a friendly overdue notice. The following books are checked out with their appropriate due date: ";
		//Create a string called return value which establishes the second part of the notice from the library listing all books overdue of those books and their due dates
		String overdueValue = "Please note that the following are overdue: "; 
		for (Book book: bookList){ //create a for loop that loops through each book in the defined booklist
			returnValue += book.getTitle() + ", "; //add the book title plus a comma and space to the returnvalue created above
			returnValue += book.getDueDate() + ". "; //add the book's due date plus a period and space to the returnvalue created above
			if (todaysDate > book.dueDate){ //now loop through each book to see if they are overdue by comparing today's date to book.duedate or due date of the book. 
				overdueValue  += book.getTitle() + ", "; //add overdue books to the second part of the notice by adding the title then comma and space
				overdueValue  += book.getDueDate() + ". "; //title then due date here
			}

		}
		returnValue += overdueValue; //add the second part of notice, now compiled with the appropriate overdue books, to the first part of notice
		return returnValue; //return the entire notice now containing both parts
	
	} 
	
}
	


 