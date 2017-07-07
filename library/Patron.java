package library;

import java.util.ArrayList;

public class Patron {

	//Instance Variables needed
	//Each patron has a name, library, and list of books associated 
	public String name;
	public Library library;
	public Book book;
	public ArrayList<Book> books; //declaration of book list associated with a given patron as an arraylist
	
	
	//Methods
	
	/**
	 * This is the constructor that constructs a patron with the given name, and no books
	 * The patron must also have a reference to the Library object that he/she uses
	 * @param name assigned to Patron
	 * @param library assigned to patron
	 */
	public Patron(String name, Library library){
		this.name = name; //set this.name to name
		this.library=library; //set this.library to library
		this.books=new ArrayList<Book>(); //set this.books to the array of books 
	}

	/**
	 * This method literally returns the name of the patron as a string
	 * @return name as string by getting name
	 */
	public String getName(){
		return name;

	}

	/**
	 * This method will add this book to the list of books checked out by this Patron
	 * @param book will be added to the array of books associated with the patron
	 */
	public void take(Book book){
		this.books.add(book);
	}
	
	/**
	 * This method removes this book object from the list of books checked out by this Patron by removing from array
	 * @param book
	 */
	public void giveBack(Book book){
		this.books.remove(book);
	}
	
	/**
	 * This method simply returns the list of Book objects checked out to this Patron (may be an empty list).
	 * @return the books by getting books which comes from the arraylist
	 */
	public ArrayList<Book> getBooks(){
		return books;
	}
	
	/**
	 * This method literally returns the name of the patron, as a string of course
	 */
	public String toString(){
		return name;	
	}
		
	
	
	
}
