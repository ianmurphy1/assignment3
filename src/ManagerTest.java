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
		m1 = new Manager("Paul", "Murphy", 24.50);
		m1.setHoursWorked(10);
		m2 = new Manager("Booker", "DeWitt", 20.00);
		m2.setHoursWorked(-50);
		m3 = new Manager("Zach", "Comstock", -35.41);
		
		//Here for testing array
		a1 = new AdminWorker("Jesse", "Pinkman", 12.00, 5);
		a2 = new AdminWorker("Elizabeth", "Comstock", 13.50, 15);
		
		s1 = new SalesWorker("Anna", "DeWitt", 8.35, 15);
		s2 = new SalesWorker("Jaqen", "H'ghar", 10, 3);		
	}

	@Test
	public void testConstructor() {
		assertNotNull(m1);
		assertEquals("Booker", m2.getFirstName());
		assertEquals(24.50, m1.getHourlyRate(), DELTA);
		assertEquals(0, m3.getHourlyRate(), DELTA);				
	}
	
	@Test
	public void testSettersAndGetters() {
		assertEquals(20, m2.getHourlyRate(), DELTA);
		m2.setHourlyRate(12.50);
		assertEquals(12.50, m2.getHourlyRate(), DELTA);
		
		m1.setHourlyRate(-2.50);
		assertEquals(24.50, this.m1.getHourlyRate(), DELTA);
		
		assertEquals(10, m1.getHoursWorked(), DELTA);
		assertEquals(0, m2.getHoursWorked(), DELTA);
		
		m3.setFirstName("Ned");
		m3.setLastName("Stark");
		assertEquals("Ned", this.m3.getFirstName());
		assertEquals("Stark", this.m3.getLastName());
	}
	
	@Test
	public void testArray () {		
		
		m1.getMinions().add(a1);
		m1.getMinions().add(a2);
		m1.getMinions().add(s1);
		m1.getMinions().add(s2);
		
		assertEquals(4, m1.getMinions().size());
		assertEquals("Elizabeth", m1.getMinions().get(1).getFirstName());
		
		m1.getMinions().get(3).setFirstName("Joe");
		assertEquals("Joe", m1.getMinions().get(3).getFirstName());
		
		m1.getMinions().remove(3);
		assertEquals(3, m1.getMinions().size());
	}
	
	@Test
	public void testSalary() {
		
		m1.getMinions().add(a1);
		m1.getMinions().add(a2);
		m1.getMinions().add(s1);
		m1.getMinions().add(s2);				
		
		
		//Test with employees
		m1.getMinions().get(0).setHoursWorked(20);
		m1.getMinions().get(0).calculateSalary();
		m1.setHoursWorked(15);
		assertEquals(369.95, m1.calculateSalary(), DELTA);
		
		m1.getMinions().get(3).setHoursWorked(16);	
		m1.getMinions().get(3).calculateSalary();
		m1.setHoursWorked(15);
		assertEquals(371.59, m1.calculateSalary(), DELTA);
		
	    //Test @ 0 Hours worked
		m1.setHoursWorked(0);
		assertEquals(0, this.m1.calculateSalary(), DELTA);
		
		//Test without employees
		m2.setHoursWorked(40);
		assertEquals(810, this.m2.calculateSalary(), DELTA);
		
		
	}

}
