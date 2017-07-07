package library;

import static org.junit.Assert.*;
import library.Book;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
	
	Book testing;
	Book testing1;

	@Before
	public void setUp() throws Exception {
		testing = new Book("Robin Hood", "Jackson Smith"); //set testing as new book classified by name and author
		testing1 = new Book("Huck Finn", "Mark Twain"); //set testing1 as new book classified by name and author
	}

	@Test
	public void testBook() {
		assertEquals(testing.getAuthor(), "Jackson Smith"); //check that author for testing is set to Jackson Smith
		assertNotEquals(testing1.getAuthor(), "Jackson Smith"); //check that author for testing1 is not author for testing
		assertEquals(testing1.getAuthor(), "Mark Twain"); //check that author for testing1 is right
		assertNotEquals(testing.getAuthor(), "Mark Twain"); //check that testing 1 author is not Mark Twain
		
		assertEquals(testing.getTitle(), "Robin Hood"); //check that title for testing is correct
		assertEquals(testing1.getTitle(), "Huck Finn"); //check that title for testing1 is correct
		assertNotEquals(testing.getTitle(), "Huck Finn"); //check that title for author testing1 is not same for testing
		assertEquals(testing.dueDate, -1); //check due date for testing as -1
		assertNotEquals(testing.dueDate, 1); //check due date is not -1
		assertEquals(testing1.dueDate, -1); //check due date for testing1 as -1
		assertNotEquals(testing.dueDate, 1); //check due date is not -1
	}

	@Test
	public void testGetTitle() {
		assertEquals(testing.getTitle(), "Robin Hood"); //check that title is returned correctly
		assertEquals(testing1.getTitle(), "Huck Finn"); //check that title is returned correctly
		assertEquals(testing.getTitle(), "Robin Hood"); //check that title for testing is correct
		assertEquals(testing1.getTitle(), "Huck Finn"); //check that title for testing1 is correct
	}

	@Test
	public void testGetAuthor() {
		assertEquals(testing.getAuthor(), "Jackson Smith"); //check that author for testing is set to Jackson Smith
		assertNotEquals(testing1.getAuthor(), "Jackson Smith"); //check that author for testing1 is not author for testing
		assertEquals(testing1.getAuthor(), "Mark Twain"); //check that author for testing1 is right
		assertNotEquals(testing.getAuthor(), "Mark Twain"); //check that testing 1 author is not Mark Twain
	}

	@Test
	public void testGetDueDate() {
		assertEquals(testing.dueDate, -1); //check due date for testing as -1
		assertNotEquals(testing.dueDate, 1); //check due date is not -1
		assertEquals(testing1.dueDate, -1); //check due date for testing1 as -1
		assertNotEquals(testing.dueDate, 1); //check due date is not -1
	}

	@Test
	public void testCheckOut() {
		testing.CheckOut(5); //set testing checkout or due date to 5
		testing1.CheckOut(10); //set testing1 checkout or due date to 10
		assertEquals(testing.dueDate, 5); //check that due date is 5
		assertNotEquals(testing.dueDate, 7); //check that due date is not 7
		assertNotEquals(testing.dueDate, 10); //check that due date is not 10
		assertEquals(testing1.dueDate, 10); //check that due date is 10
		assertNotEquals(testing1.dueDate, 5); //check that due date is not 5
	}

	@Test
	public void testCheckIn() {
		testing.checkIn();
		assertEquals(testing.dueDate, -1); //sets due date to -1 so check that due date is -1
		assertEquals(testing1.dueDate, -1); //sets due date to -1 so check that due date is -1
		assertNotEquals(testing.dueDate, 5); //check that due date is not 5
		assertNotEquals(testing1.dueDate, 10); //check that due date is not 10


	}

	@Test
	public void testToString() {
		assertEquals(testing.toString(), "Robin Hood, by Jackson Smith"); //check that string is properly returned
		assertEquals(testing1.toString(), "Huck Finn, by Mark Twain"); //check that string is properly returned
	}

}
