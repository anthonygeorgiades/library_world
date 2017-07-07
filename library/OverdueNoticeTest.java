package library;

import static org.junit.Assert.*;
import library.Book;
import library.Library;
import library.OverdueNotice;
import library.Patron;

import org.junit.Before;
import org.junit.Test;

public class OverdueNoticeTest {

	Book testing; //define 1 book
	Book testing1; //define another book
	Book testing2; //define anotheranother book
	Patron testingpatron; //define patron
	Patron testing1patron; //define another patron
	Library testLibrary; //define library 
	int todaysDate; //define today's date

	@Before
	public void setUp() throws Exception {
		testLibrary = new Library(); //create new library defined above
		testing = new Book("Robin Hood", "Jackson Smith"); //create book with given parameters
		testingpatron = new Patron("John Smith", testLibrary); //create patron with given parameters with above library
		testing1patron = new Patron ("random", testLibrary); //create another patron with given parameters with this library
		testing1 = new Book("Huck Finn", "Mark Twain"); //create another book with given parameters
		testing2 = new Book("randommade", "made up");//create yet another book with given parameters
		testing.CheckOut(10); //assign due out date to this book
		testing1.CheckOut(12); //assign due out date to this book
		testing2.CheckOut(11); //assign due out date to this book
		todaysDate = 12; //set today's date
		testingpatron.books.add(testing); //add this book to this patron
		testingpatron.books.add(testing1); //add this book to this patron
		testing1patron.books.add(testing2); //add this book to this patron

	}
	
	@Test
	public void testOverdueNotice() {
		OverdueNotice newnotice = new OverdueNotice(testingpatron, todaysDate);	//create new notice for this patron with this date
		assertEquals(newnotice.todaysDate, 12); //check that this notice passes by checking that the date is correct
		assertEquals(newnotice.patron, testingpatron); //check that this notice passes by checking that the patron is correct
		assertNotEquals(newnotice.patron, testing1patron); //check that this notice is not correct since not assigned to this patron yet
		OverdueNotice newnotice2 = new OverdueNotice(testing1patron, todaysDate); //new notice for second patron
		assertEquals(newnotice2.patron, testing1patron); //create new notice for this patron with this date
		assertEquals(newnotice2.todaysDate, 12);  //check that this notice passes by checking that the date is correct
		assertNotEquals(newnotice2.patron, testingpatron); //check that this notice is not correct since not assigned to this patron 

	}

	@Test
	public void testToString() {
		OverdueNotice newnotice = new OverdueNotice(testingpatron, todaysDate);	
		assertEquals(newnotice.toString(), "This is a friendly overdue notice. The following books are checked out with their "
		+ "appropriate due date: Robin Hood, 10. Huck Finn, 12. Please note that the following are overdue: "
		+ "Robin Hood, 10. "); //check that string from first notice for first patron is correct
		OverdueNotice newnotice2 = new OverdueNotice(testing1patron, todaysDate);	
		assertEquals(newnotice2.toString(), "This is a friendly overdue notice. The following books are checked out with their "
		+ "appropriate due date: randommade, 11. Please note that the following are overdue: "
		+ "randommade, 11. "); //check that string from first notice for first patron is correct
		
	}

}
