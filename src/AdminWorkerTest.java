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
		this.a1 = new AdminWorker("Jesse", "Pinkman", 12.00, 5);
		this.a2 = new AdminWorker("Elizabeth", "Comstock", 13.50, 15);
		this.a3 = new AdminWorker("Gordon", "Freeman", -10.75, -40);
		
	}

	@Test
	public void testConstructor() {
		assertEquals(12.00, this.a1.getHourlyRate(), DELTA);
		assertEquals("Elizabeth", this.a2.getFirstName());
		assertEquals(15, this.a2.getBonus(), DELTA);
		assertEquals(0, this.a3.getHourlyRate(), DELTA);
		assertEquals(0, this.a3.getBonus(), DELTA);
	}
	
	@Test
	public void testSettersAndGetters() {
		this.a1.setHourlyRate(-10.00);
		assertEquals(12.00, this.a1.getHourlyRate(), DELTA);
		this.a1.setFirstName("Todd");
		assertEquals("Todd", this.a1.getFirstName());
		
		this.a2.setBonus(-5);
		assertEquals(15, this.a2.getBonus(), DELTA);
		this.a2.setLastName("DeWitt");
		assertEquals("DeWitt", this.a2.getLastName());
	}
	
	@Test
	public void testCalculateSalary() {		
		assertEquals(425, this.a1.calculateSalary(35), DELTA);
		//Overtime
		assertEquals(723.75, this.a2.calculateSalary(46), DELTA);
		//Test @ 0 Hours worked
		assertEquals(0, this.a2.calculateSalary(0), DELTA);
		//Test with invalid constructor 
		assertEquals(0, this.a3.calculateSalary(20), DELTA);
	}

}
