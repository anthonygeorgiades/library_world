package library;

import static org.junit.Assert.*;

import java.util.ArrayList;

import library.Book;
import library.Library;
import library.Patron;

import org.junit.Before;
import org.junit.Test;

public class PatronTest {
	Patron testing; //create 1 patron to test
	Patron testing1; //create another patron to test
	Library testLibrary = new Library(); //create a library 
	Library test1Library = new Library(); //create another library 
	ArrayList<Book> books; 
	Book testBook = new Book("Huck Finn", "Mark Twain"); //create a testbook 
	Book test1Book = new Book("Robin Hood", "Jackson Smith"); //create another testbook
	Book test2Book = new Book("Random", "DNE"); //create another testbook that will never be assigned to a patron

	@Before
	public void setUp() throws Exception {
		testing = new Patron("John Smith", testLibrary); //set testing patron to given name John Smith at the first library
		testing1 = new Patron("Janice Five", test1Library); //set the next patron to the second library 
		testing.books.add(testBook); //adding the testbook to the first patrons collection of books
		testing1.books.add(testBook); //adding the testbook to the second patrons collection of books
		testing.books.add(test1Book); //adding the test1book or other test book to the first patrons collection of books
		
	}

	@Test
	public void testPatron() {
		assertEquals(testing.getName(), "John Smith"); //get the name of the first patron, which we set above
		assertEquals(testing1.getName(), "Janice Five"); //get the name of the second patron, which we set above
		assertNotEquals(testing1.getName(), "John Smith"); //check that name is not this
		assertTrue(testing.library==testLibrary); //check that the library for patron testing is testlibrary
		assertTrue(testing1.library==test1Library); //check that the library for patron testing1 is test1library	
		assertFalse(testing1.library==testLibrary); //check that the library for patron testing1 is not testlibrary
		assertFalse(testing.library==test1Library); //check that the library for patron testing is not test1library
		assertTrue(testing.books != null); //check that testing does not have an empty list of books
		assertFalse(testing.books == null); //check that testing does not have an empty list of books
		assertTrue(testing1.books != null); //check that testing1 does not have an empty list of books
		assertFalse(testing1.books == null); //check that testing1 does not have an empty list of books
		assertTrue(testing.books.contains(testBook)); //check that testings list of books contains testbook
		assertFalse(testing1.books.contains(test1Book)); //check that testing1 list of books doesnt contain test1book
		assertTrue(testing.books.contains(test1Book)); //check that testing list of books  contains test1book
		assertTrue(testing1.books.contains(testBook)); //check that testings list of books contains test1book
		assertFalse(testing1.books.contains(test2Book)); //check that testing1 list of books doesnt contain test2book

	}

	@Test
	public void testGetName() {
		assertEquals(testing.getName(), "John Smith"); //get the name of the first patron, which we set above
		assertEquals(testing1.getName(), "Janice Five"); //get the name of the second patron, which we set above
		assertNotEquals(testing1.getName(), "John Smith"); //check that name is not this		
	}

	@Test
	public void testTake() {
		Book newtestBook = new Book("Random book", "Random Author"); //create new testbook that isnt in list 
		assertFalse(testing.books.contains(newtestBook)); //check that this random book isn't in list
		testing.books.add(newtestBook); //now add it to the list 
		assertTrue(testing.books.contains(newtestBook)); //now check that it is now in the list
		assertFalse(testing1.books.contains(newtestBook)); //check that it was not added to other patron
		testing1.books.add(newtestBook); //now add it to the list 
		assertTrue(testing.books.contains(newtestBook)); //now check that it is STILL in the list
		assertTrue(testing1.books.contains(newtestBook)); //now check that it is also added to testing1

	}

	@Test
	public void testGiveBack() {
		testing.books.remove(testBook); //remove testbook from first patron
		testing.books.remove(test1Book); //remove test1book from first patron
		Book newtestBook = new Book("Random book", "Random Author"); //create new testbook with this paramater
		testing.books.add(newtestBook); //add this to patron 1
		assertFalse(testing.books.contains(testBook)); //check that list doesn't contain first book since we removed it
		assertFalse(testing.books.contains(test1Book)); //check that list doesn't contain first book since we removed it
		assertTrue(testing1.books.contains(testBook)); //should still be in testing 1 collection
		assertFalse(testing1.books.contains(test1Book)); //check that list doesn't contain this book since it never did
		assertTrue(testing.books.contains(newtestBook)); //now check that it is in this patron's list
		assertFalse(testing1.books.contains(newtestBook)); //check it's not in this list since it was never added
		assertTrue(testing.books.size() ==1 ); //check that book size is 1 after starting at 2, removing 2, and adding 1
		assertTrue(testing1.books.size() ==1 ); //check that testing book size still 1
		assertFalse(testing1.books.size() ==2 ); //check that testing book isnt 2
		assertFalse(testing.books.size() ==2 ); //check that testing book isnt 2
		Book anathaone = new Book("Yet another book", "Again"); //create new testbook with this paramater
		testing.books.add(anathaone); //add new book to testing patron
		assertTrue(testing.books.size() ==2 ); //check that size is now 2
		testing1.books.add(anathaone);  //add this book to second patron
		assertTrue(testing1.books.size() ==2 ); //check that size is now 2
		testing.books.remove(anathaone); //remove anathaone from first patron
		testing.books.remove(newtestBook); //remove newtestBook from first patron
		assertTrue(testing.books.size() ==0 ); //check that size is now 0
		testing1.books.add(testBook); //add  book to testing2 patron		
		testing1.books.remove(testBook); //remove  book to testing2 patron
		testing1.books.add(newtestBook); //add  book to testing2 patron	
		assertTrue(testing1.books.size() ==3 ); //check that size is now 3
		assertFalse(testing1.books.size() ==4 ); //check that size isn't 4
		testing1.books.remove(test1Book); //add  book to testing2 patron
		testing1.books.add(newtestBook); //add  duplicate copy
		assertTrue(testing1.books.size() ==4); //check that size is now 4

	}

	@Test
	public void testGetBooks() {
		assertTrue(testing.getBooks().contains(testBook)); //assert that it contains right book
		assertTrue(testing.getBooks().contains(test1Book)); //assert that it contains right book
		assertTrue(testing1.getBooks().contains(testBook)); //assert that it contains right book
		assertFalse(testing1.getBooks().contains(test2Book)); //assert that list doesn't contain this book as it wasn't checked out


	}

	@Test
	public void testToString() {
		assertEquals(testing.toString(), "John Smith"); //check that it returns proper name
		assertEquals(testing1.toString(), "Janice Five"); //check that it returns proper name
		assertNotEquals(testing.toString(), "John"); //check that it returns proper name  by entering wrong name
		assertNotEquals(testing1.toString(), "John"); //check that it returns proper name by entering wrong name


	}

}
