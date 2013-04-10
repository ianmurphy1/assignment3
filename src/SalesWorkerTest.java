import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SalesWorkerTest
{
	//Accepted Error in double comparisons
	//Due to doubles not being exact
	private static final double DELTA = 0.1;
	
	SalesWorker s1, s2, s3, s4;

	@Before
	public void setUp() throws Exception {
		s1 = new SalesWorker("Johnny", "Bravo", 11.75, 6);
		s2 = new SalesWorker("Peregrin", "Took", 9.50, 12);
		s3 = new SalesWorker("Jack", "Ryan", -13.00, -16);
		s4 = new SalesWorker("Jimmy", "McNulty", 8.60, 24);
	}

	@Test
	public void testConstructor() {
		assertNotNull(s1);
		assertEquals(11.75, s1.getHourlyRate(), DELTA);
		assertEquals("Peregrin", s2.getFirstName());		
		assertEquals(0, s3.getHourlyRate(), DELTA);	
		assertEquals(0, s3.getPerfBonus(), DELTA);
		assertEquals(0, s4.getPerfBonus(), DELTA);
	}
	
	@Test
	public void testSettersAndGetters() {
		s1.setLastName("Bennet");
		assertEquals("Bennet", s1.getLastName());
		
		s2.setFirstName("Pippin");
		assertEquals("Pippin", s2.getFirstName());
				
		s1.setHourlyRate(14.50);
		assertEquals(14.50, s1.getHourlyRate(), DELTA);
		
		s1.setHourlyRate(-15);
		assertEquals(14.50, s1.getHourlyRate(), DELTA);
		
		s2.setPerfBonus(-15);
		assertEquals(12, s2.getPerfBonus(), DELTA);
		s2.setPerfBonus(22);
		assertEquals(12, s2.getPerfBonus(), DELTA);
	}
	
	@Test
	public void testCalculateSalary() {
		//With OverTime
		assertEquals(298.92, s1.calculateSalary(24), DELTA);
		//Without OverTime
		assertEquals(537.32, s2.calculateSalary(45), DELTA);
		
		//Calc when hours is 0
		assertEquals(0, s1.calculateSalary(0), DELTA);
		
		//Calc When Bonus is 0
		assertEquals(86, s4.calculateSalary(10), DELTA);
	}

}
