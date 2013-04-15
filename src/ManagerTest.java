import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ManagerTest
{
	//Accepted Error in double comparisons
	//Due to doubles not being exact
	private static final double DELTA = 0.1;
	
	Manager m1, m2, m3;
	AdminWorker a1, a2;
	SalesWorker s1, s2;

	@Before
	public void setUp() throws Exception {
		//Testing These Mostly
		this.m1 = new Manager("Paul", "Murphy", 24.50);
		this.m2 = new Manager("Booker", "DeWitt", 20.00);
		this.m3 = new Manager("Zach", "Comstock", -35.41);
		
		//Here for testing array
		this.a1 = new AdminWorker("Jesse", "Pinkman", 12.00, 5);
		this.a2 = new AdminWorker("Elizabeth", "Comstock", 13.50, 15);
		
		this.s1 = new SalesWorker("Anna", "DeWitt", 8.35, 15);
		this.s2 = new SalesWorker("Jaqen", "H'ghar", 10, 3);		
	}

	@Test
	public void testConstructor() {
		assertNotNull(this.m1);
		assertEquals("Booker", this.m2.getFirstName());
		assertEquals(24.50, this.m1.getHourlyRate(), DELTA);
		assertEquals(0, this.m3.getHourlyRate(), DELTA);				
	}
	
	@Test
	public void testSettersAndGetters() {
		assertEquals(20, this.m2.getHourlyRate(), DELTA);
		this.m2.setHourlyRate(12.50);
		assertEquals(12.50, this.m2.getHourlyRate(), DELTA);
		
		this.m1.setHourlyRate(-2.50);
		assertEquals(24.50, this.m1.getHourlyRate(), DELTA);
		
		this.m3.setFirstName("Ned");
		this.m3.setLastName("Stark");
		assertEquals("Ned", this.m3.getFirstName());
		assertEquals("Stark", this.m3.getLastName());
	}
	
	@Test
	public void testArray () {		
		
		this.m1.getMinions().add(this.a1);
		this.m1.getMinions().add(this.a2);
		this.m1.getMinions().add(this.s1);
		this.m1.getMinions().add(this.s2);
		
		assertEquals(4, this.m1.getMinions().size());
		assertEquals("Elizabeth", this.m1.getMinions().get(1).getFirstName());
		
		this.m1.getMinions().get(3).setFirstName("Joe");
		assertEquals("Joe", this.m1.getMinions().get(3).getFirstName());
		
		this.m1.getMinions().remove(3);
		assertEquals(3, this.m1.getMinions().size());
	}
	
	@Test
	public void testSalary() {
		
		this.m1.getMinions().add(this.a1);
		this.m1.getMinions().add(this.a2);
		this.m1.getMinions().add(this.s1);
		this.m1.getMinions().add(this.s2);				
		
		
		//Test with employees
		this.m1.getMinions().get(0).calculateSalary(20);		
		assertEquals(369.95, this.m1.calculateSalary(15), DELTA);
		this.m1.getMinions().get(3).calculateSalary(16);	
		assertEquals(371.59, this.m1.calculateSalary(15), DELTA);
		
	    //Test @ 0 Hours worked
		assertEquals(0, this.m1.calculateSalary(0), DELTA);
		
		//Test without
		assertEquals(810, this.m2.calculateSalary(40), DELTA);
		
		
	}

}
