import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AdminWorkerTest
{
	
	//Accepted Error in double comparisons
	//Due to doubles not being exact
	private static final double DELTA = 0.1;
	
	AdminWorker a1, a2, a3;

	@Before
	public void setUp() throws Exception {
		a1 = new AdminWorker("Jesse", "Pinkman", 12.00, 5);
		a1.setHoursWorked(35);
		a2 = new AdminWorker("Elizabeth", "Comstock", 13.50, 15);
		a2.setHoursWorked(46);
		a3 = new AdminWorker("Gordon", "Freeman", -10.75, -40);
		a3.setHoursWorked(20);
	}

	@Test
	public void testConstructor() {
		assertEquals(12.00, a1.getHourlyRate(), DELTA);
		assertEquals("Elizabeth", a2.getFirstName());
		assertEquals(15, a2.getBonus(), DELTA);
		assertEquals(0, a3.getHourlyRate(), DELTA);
		assertEquals(0, a3.getBonus(), DELTA);
	}
	
	@Test
	public void testSettersAndGetters() {
		a1.setHourlyRate(-10.00);
		assertEquals(12.00, a1.getHourlyRate(), DELTA);
		a1.setFirstName("Todd");
		assertEquals("Todd", a1.getFirstName());
		
		assertEquals(35, a1.getHoursWorked(), DELTA);
		a1.setHoursWorked(-5);
		assertEquals(35, a1.getHoursWorked(), DELTA);
		
		a2.setBonus(-5);
		assertEquals(15, a2.getBonus(), DELTA);
		a2.setLastName("DeWitt");
		assertEquals("DeWitt", a2.getLastName());
	}
	
	@Test
	public void testCalculateSalaryse() {		
		assertEquals(425, a1.calculateSalary(), DELTA);
		//Overtime
		assertEquals(723.75, a2.calculateSalary(), DELTA);
		//Test @ 0 Hours worked
		a2.setHoursWorked(0);
		assertEquals(0, a2.calculateSalary(), DELTA);
		//Test with invalid constructor 
		assertEquals(0, a3.calculateSalary(), DELTA);
	}

}
