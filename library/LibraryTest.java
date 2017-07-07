package library;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import library.Book;
import library.Library;
import library.OverdueNotice;
import library.Patron;

import org.junit.Before;
import org.junit.Test;

public class LibraryTest {

	Library testing;
	int todaysdate;
	Book testbook;
	Book testbook1;
	Patron patrontesting;
	Patron patrontesting1;

	@Before
	public void setUp() throws Exception {

		testing = new Library();// create new library called testing
		patrontesting = new Patron("Rob", testing);//create Patron object
		patrontesting1 = new Patron("Ray",testing); //create Patron object
		testing.patron = patrontesting;
		testbook = new Book("Robin Hood", "Jackson Smith"); //Create books
		testbook1 = new Book("Huck Finn", "Mark Twain");
		testing.book = testbook;
		HashMap<String, Patron> testinghm = new HashMap<String, Patron>();//HashMap type
		//Fill the dictionary
		testinghm.put("Rob", patrontesting);
	}

	@Test
	public void testopen() {

		ArrayList<Book> btest = new ArrayList<Book>();

		// put stuff in my record hashmap
		testing.record.put("Rob", patrontesting);
		patrontesting.take(testbook);
		patrontesting.take(testbook1);

		// these books are overdue
		testbook.CheckOut(0);
		testbook1.CheckOut(2);
        //add the books to the Arraylist
		btest.add(testbook1);
		btest.add(testbook);
        //make new Arraylist of OverdueNotice type
		ArrayList<OverdueNotice> returned = new ArrayList<OverdueNotice>();
		returned = testing.open(); //Apply open function
		assertEquals(1, returned.size()); //It should return 1 book
	}

	@Test
	public void testcreateOverdueNotices() {

		testing.todaysdate = 1;
	
		// put stuff my record hashmap
		testing.record.put("Rob", patrontesting);
		patrontesting.take(testbook);
		testing.record.put("Ray", patrontesting1);
		patrontesting1.take(testbook1);

		// this book is overdue
		testbook.CheckOut(0);

		//create ArrayList 
		ArrayList<OverdueNotice> returned = new ArrayList<OverdueNotice>();
		//Apply method
		returned = testing.createOverdueNotices();
		
		assertEquals(1, returned.size()); //Check size of output
		testbook1.CheckOut(0); //CheckOut this book also
		returned = testing.createOverdueNotices(); //Apply method
		assertEquals(2, returned.size()); //Check size of output
		

	}

	@Test
	public void testissueCard() {

		assertEquals("Anthony", testing.issueCard("Anthony").getName()); //This issues card name of input and returns its object
		assertEquals("Avantika", testing.issueCard("Avantika").getName()); //This issues card name of input and returns its object
		assertEquals("Zairah", testing.issueCard("Zairah").getName()); //This issues card name of input and returns its object
	}

	@Test
	public void testserve() {
        // Add contents in the HashMap record made in Library class.
		testing.record.put("Rob", patrontesting);
		testing.record.put("Ray", patrontesting1);
		
		//Make patron objects
		Patron rob = testing.serve("Rob");
		assertEquals("Rob", rob.getName()); //Test the name of the object
		Patron ray = testing.serve("Ray");
		assertEquals("Ray", ray.getName()); //Test the name of the object

	}

	@Test
	public void testcheckIn() {

		// creating a dummy arraylist
		ArrayList<Integer> t1 = new ArrayList<Integer>();
		t1.add(1);
		t1.add(2);

		//putting data in bookNos
		testing.bookNos.put(1, testbook);
		testing.bookNos.put(2, testbook1);
		assertEquals(2, testing.checkIn(t1).size()); //Checks the size of the test
		t1.add(3);
		assertEquals(3, testing.checkIn(t1).size()); //Checks the size of the test
	}
	
	

	@Test
	public void testSearch() {
        //Making ArrayList and add books in it
		ArrayList<Book> btest = new ArrayList<Book>();
		btest.add(testbook);
		btest.add(testbook1);
		//New Library object
		Library lib = new Library(btest);
		assertEquals(1, lib.search("robi").size());//Checks if robi input string gives 1 output
		assertEquals(1,lib.search("hood").size());//Checks if hood input string gives 1 output
	}
	
	
	@Test
	public void testcheckOut() {
		
		testing.bookNos= new HashMap<Integer, Book>();
		
		//creating the temporary arraylist
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(1);
		test.add(2);
		
		//Adding data in the bookNos hashMap
		testing.bookNos.put(1, testbook);
		testing.bookNos.put(2, testbook1);
		
		assertEquals(2, testing.checkOut(test).size()); //Checking size of the test output
	}
}
