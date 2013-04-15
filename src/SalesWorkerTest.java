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
		this.s1 = new SalesWorker("Johnny", "Bravo", 11.75, 6);
		this.s2 = new SalesWorker("Peregrin", "Took", 9.50, 12);
		this.s3 = new SalesWorker("Jack", "Ryan", -13.00, -16);
		this.s4 = new SalesWorker("Jimmy", "McNulty", 8.60, 24);
	}

	@Test
	public void testConstructor() {
		assertNotNull(this.s1);
		assertEquals(11.75, this.s1.getHourlyRate(), DELTA);
		assertEquals("Peregrin", this.s2.getFirstName());		
		assertEquals(0, this.s3.getHourlyRate(), DELTA);	
		assertEquals(0, this.s3.getPerfBonus(), DELTA);
		assertEquals(0, this.s4.getPerfBonus(), DELTA);
	}
	
	@Test
	public void testSettersAndGetters() {
		this.s1.setLastName("Bennet");
		assertEquals("Bennet", this.s1.getLastName());
		
		this.s2.setFirstName("Pippin");
		assertEquals("Pippin", this.s2.getFirstName());
				
		this.s1.setHourlyRate(14.50);
		assertEquals(14.50, this.s1.getHourlyRate(), DELTA);
		
		this.s1.setHourlyRate(-15);
		assertEquals(14.50, this.s1.getHourlyRate(), DELTA);
		
		this.s2.setPerfBonus(-15);
		assertEquals(12, this.s2.getPerfBonus(), DELTA);
		this.s2.setPerfBonus(22);
		assertEquals(12, this.s2.getPerfBonus(), DELTA);
	}
	
	@Test
	public void testCalculateSalary() {
		//With OverTime
		assertEquals(298.92, this.s1.calculateSalary(24), DELTA);
		//Without OverTime
		assertEquals(537.32, this.s2.calculateSalary(45), DELTA);
		
		//Calc when hours is 0
		assertEquals(0, this.s1.calculateSalary(0), DELTA);
		
		//Calc When Bonus is 0
		assertEquals(86, this.s4.calculateSalary(10), DELTA);
	}

}
