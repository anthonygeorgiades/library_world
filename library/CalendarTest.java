package library;

import static org.junit.Assert.*;
import library.Calendar;

import org.junit.Before;
import org.junit.Test;

public class CalendarTest {

	Calendar testing; 
	
	@Before
	public void setUp() throws Exception {
		testing = new Calendar(); //create new calendar called testing
	}
	
	@Test
	public void testCalendar() {
		assertEquals(0, testing.getDate()); //assert that the date of the calendar is equal to 0 initially
		assertNotEquals(1, testing.getDate()); //assert that the date of the calendar is not equal to 1 since it is 0
		assertNotEquals(-1, testing.getDate()); //assert that the date of the calendar is not equal to -1 since it is 0

	}

	@Test
	public void testGetDate() {
		assertEquals(0, testing.getDate()); //assert the date of the calendar being returned, which is still 0
		assertNotEquals(1, testing.getDate()); //assert the date of the calendar being returned is not equal to 1, which is still 0 and not 1 
		assertNotEquals(-1, testing.getDate()); //assert the date of the calendar being returned is not equal to -1, which is still 0 and not -1 

	}

	@Test
	public void testAdvance() {
		assertEquals(0, testing.getDate()); //assert that the date is equal to one
		testing.advance(); //advance by incrementing date by 1
		assertEquals(1, testing.getDate()); //assert that new date after advancing by 1 is now 1
		assertNotEquals(0, testing.getDate()); //assert that the date has incremented by 1 and not still 0
		assertNotEquals(2, testing.getDate()); //assert that the date has incremented by 1 and not more than that
		testing.advance(); //advance by incrementing date by 1
		assertEquals(2, testing.getDate()); //assert that the date has incremented by another 1 and now is at 2
		assertNotEquals(0, testing.getDate()); 
		assertNotEquals(1, testing.getDate()); //assert that the date has incremented by 1 and not still 1

	}
	
	

}
