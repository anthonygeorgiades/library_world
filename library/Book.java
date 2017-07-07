package library;

public class Book {
	
	//Instance Variables needed for class Book include title, author, and dueDate of book 
	public String title;
	public String author;
	public int dueDate; //-1 if the book is not checked out
	
	/**
	 * This is the Constructor, simply creates the book by assigning title, author, and dueDate
	 * It saves the provided information. When created, this book is not checked out.
	 * @param title- book title inputed as string
	 * @param author- book author inputed as string
	 * book is created by having a title and author, as well as a dueDate
	 */
	public Book(String title, String author){
		this.title = title;
		this.author = author;	
		dueDate = -1; //set dueDate to -1 since the book is not checked out
		
	}
	
	/**
	 * this method simply returns (as a string) the title of the book by using the getTitle
	 * @return title of book which was established in previous method
	 */
	public String getTitle(){
		return title;
		
	}

	/**
	 * this method simply returns (as a string) the author of the book by using the getAuthor
	 * @return author of book which was established in previous method
	 */
	public String getAuthor(){
		return author;
		
	}
	
	/**
	 * this method simply returns (as an int) the dueDate of the book by using the getDueDate
	 * @return the dueDate of the book, which was set to -1 in the previous method
	 */
	public int getDueDate(){
		return dueDate;
		
	}
	
	/**
	 * This method sets the due date of this Book to the specified dateed date.
	 * @param date set as an integer passed in date set as due date 
	 */
	public void CheckOut(int date){
		dueDate = date;
		
	}
	
	/**
	 * This method sets the due date of this Book to -1 p
	 */
	public void checkIn(){
		dueDate=-1;
		
	}
	
	/**
	 * This method simply returns a string of the form title, by author, where title and author are classified above
	 */
	public String toString(){
		return title + ", by " + author;		
	}
	

}
