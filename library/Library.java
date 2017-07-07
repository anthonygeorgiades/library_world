package library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* The class Library has been made with instance variables
 * as shown below
 */

public class Library {
	private boolean okToPrint;
	public Patron patron;
	public int todaysdate;
	public Library library;
	public Book book;
	public ArrayList<Book> books;
	public boolean openlibrary;
	public String title;
	public String author;
	public HashMap<Integer, Book> bookNos = new HashMap<Integer, Book>();
	public static String input;

	/*
	 * Reading in the book and author names from the books.txt file to form an
	 * Array list of books
	 */
	private ArrayList<Book> readBookCollection() {

		File file = new File("books.txt");

		ArrayList<Book> collection = new ArrayList<Book>();

		try {

			FileReader fileReader = new FileReader(file);

			BufferedReader reader = new BufferedReader(fileReader);

			while (true) {

				String line = reader.readLine();

				if (line == null)
					break;

				line = line.trim();

				if (line.equals(""))
					continue; // ignore possible blank lines

				String[] bookInfo = line.split(" :: ");

				collection.add(new Book(bookInfo[0], bookInfo[1]));

			}

		}

		catch (IOException e) {
			System.out.println(e.getMessage());

		}

		return collection;

	}

	/*
	 * The first constructor which assigns the books variable and assign
	 * okToPrint to true
	 */

	public Library() {
		books = readBookCollection();
		okToPrint = true;
	}

	/*
	 * To make an empty HashMap to maintain book title as key and author as
	 * value
	 */
	public HashMap<String, Patron> record = new HashMap<String, Patron>();

	/*
	 * This method assigns the collection list to the books variable and sets
	 * okToPrint to false
	 */

	public Library(ArrayList<Book> collection) {
		books = collection;
		okToPrint = false;
	}

	/*
	 * The main method makes a new library object and calls the start method
	 */

	public static void main(String[] args) {
		Library mylib = new Library();
		input = args[0];
		mylib.start();
	}

	/*
	 * The method calls the method according to the input
	 */

	public void start() {

		if (openlibrary == true) {

			if (input.equals("open")) {
				open();
			} else if (input.contains("issueCard")) {

				String pname = new String();
				if (input.contains(" ")) {
					pname = input.split(" ")[1];
				} else {
					System.out.println("\nYou have entered the wrong input");
					System.exit(1);
				}
				issueCard(pname);

			} else if (input.contains("serve")) {
				String pname = new String();
				if (input.contains(" ")) {
					pname = input.split(" ")[1];
				} else {
					System.out.println("\nYou have entered the wrong input");
					System.exit(1);
				}

				serve(pname);
			} else if (input.contains("checkIn")) {

				ArrayList<Integer> num = new ArrayList<Integer>();
				if (input.contains(" ")) {
				}

				checkIn(num);

			} else if (input.contains("search")) {

				String sname = new String();
				if (input.contains(" ")) {
					sname = input.split(" ")[1];
				} else {
					System.out.println("\nYou have entered the wrong input");
					System.exit(1);
				}

				search(sname);

			} else if (input.equals("checkOut Book numbers")) {
				// checkOut(arraylist);
			} else if (input.equals("close")) {
				close();
			}
		}// open library == true

		if (input.equals("quit")) {
			quit();
		}
	}

	/*
	 * If okToPrint is true, then this method prints out the input message
	 */

	public void print(String message) {
		if (okToPrint == true) {
			System.out.print(message);
		}
	}

	/*
	 * If okToPrint is true, then this method prints out the input message in
	 * lines
	 */

	public void println(String message) {
		if (okToPrint == true) {
			System.out.println(message);
		}
	}

	/*
	 * This method makes a new Calendar object and advances the date as well as
	 * sets the library as open and prints out the overdueNotices
	 */

	public ArrayList<OverdueNotice> open() {
		Calendar mycalendar = new Calendar();
		todaysdate = mycalendar.getDate();
		todaysdate++;
		openlibrary = true;
		ArrayList<OverdueNotice> overduenotices = createOverdueNotices();
		return overduenotices;
	}

	/*
	 * This method returns the overdue notices for patrons with over due books
	 * for yesterday
	 */

	public ArrayList<OverdueNotice> createOverdueNotices() {
		// all patrons
		ArrayList<OverdueNotice> notice = new ArrayList<OverdueNotice>(
				todaysdate);
		for (Patron patron : record.values()) {
			for (Book booklist : patron.getBooks()) {
				if (booklist.getDueDate() == todaysdate - 1) {
					OverdueNotice overdue = new OverdueNotice(patron,
							todaysdate);
					notice.add(overdue);
					System.out.print("Please note that for" + patron
							+ booklist.getTitle() + "is overdue");
				}
			}
		}
		return notice;

	}

	/*
	 * A new patron object is made with the patron name and is added in the
	 * record HashMap. It also returns the object.
	 */

	public Patron issueCard(String nameOfPatron) {
		Patron name = new Patron(nameOfPatron, this);
		record.put(name.getName(), name);
		return name;
	}

	/*
	 * This method returns and prints out the list of books issued to the Patron
	 */

	public Patron serve(String nameOfPatron) {
		
		Patron values = record.get(nameOfPatron);
		patron = values;
		ArrayList<Book> booklist = values.getBooks();
		int count = 1;
		for (Book books : booklist) {
			bookNos.put(count, books);
			count++;
		}
		System.out.println(bookNos);
		return patron;
	}

	/*
	 * This method returns the booklist from the booknumber. By accessing the
	 * bookNos HashMap, it finds the book from the number key and adds it to the
	 * return ArrayList
	 */

	public ArrayList<Book> checkIn(ArrayList<Integer> bookNumbers) {
		ArrayList<Book> booklist = new ArrayList<Book>();
		for (int number : bookNumbers) {
			booklist.add(bookNos.get(number));
			for (Book book : booklist) {
				patron.giveBack(book);
			}
		}

		return booklist;
	}

	/*
	 * This method returns a list of books which contains the input String part
	 * in the title or author name
	 */

	public ArrayList<Book> search(String part) {
		ArrayList<Book> myList = new ArrayList<Book>();
		if (part.length() < 4) {
			System.out
					.println("Insufficient number of characters. Please input min 4 characters");
		} else {
			for (Book book : books) {
				if (book.getAuthor().toLowerCase().contains(part.toLowerCase())
						|| book.getTitle().toLowerCase().contains(part.toLowerCase())) {
					myList.add(book);
					int count = 1;
					for (Book books : myList) {
						bookNos.put(count, books);
						count++;
					}
				}
			}
			System.out.println(myList);
		}
		return myList;
	}

	/*
	 * This method gives the list of books checked out to the patron from the booknumbers
	 * arraylist given as input. It refers to the bookNos hashmap that has saved the books and numbers.
	 */

	public ArrayList<Book> checkOut(ArrayList<Integer> bookNumbers) {
		ArrayList<Book> booklist = new ArrayList<Book>();
		for (int number : bookNumbers) {
			booklist.add(bookNos.get(number));
			for (Book book : booklist) {
				book.CheckOut(todaysdate);
				patron.take(book);
			}
		}
		return booklist;
	}

	/*
	 * This method closes the library it sets the openlibrary boolean to false
	 */

	public void close() {
		openlibrary = false;
	}

	/*
	 * This method quits the program
	 */

	public void quit() {
		System.out.println("\nExiting the program");
		System.exit(0);
	}
}