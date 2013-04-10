import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class DriverTest
{
	Manager m1, m2;
	AdminWorker a1, a2;
	SalesWorker s1, s2;
	ArrayList<Employee> employees;
	
	final static double DELTA = 0.1;
	
	double totalSalary;

	@Before
	public void setUp() throws Exception {
		
		this.employees = new ArrayList<Employee>();
		
		m1 = new Manager("Paul", "Murphy", 24.50);
		m2 = new Manager("Booker", "DeWitt", 20.00);
		
		a1 = new AdminWorker("Jesse", "Pinkman", 12.00, 5);
		a2 = new AdminWorker("Elizabeth", "Comstock", 13.50, 15);
		
		s1 = new SalesWorker("Johnny", "Bravo", 11.75, 6);
		s2 = new SalesWorker("Peregrin", "Took", 9.50, 12);
		
		//Adding Managers to the list last so a sort isn't 
		//required (for now) when calculating wages. 
		employees.add(s2);
		employees.add(s1);
		employees.add(a1);
		employees.add(a2);
		employees.add(m2);
		employees.add(m1);
		
		m1.getMinions().add(a1);
		m1.getMinions().add(s1);
		
		m2.getMinions().add(a2);
		m2.getMinions().add(s2);
		
		s2.calculateSalary(15);
		s1.calculateSalary(24);
		a2.calculateSalary(20);
		a1.calculateSalary(26);
		m1.calculateSalary(22);
	    m2.calculateSalary(28);	
	}

	@Test
	public void testCalculateSalaries() {
		totalSalary = 0;
		
		for (Employee emp: employees) {
			totalSalary += emp.getSalary();
		}
		
		assertEquals(2170.11, totalSalary, DELTA);		
	}
	
	@Test
	public void testHighestSalary() {
		Employee curHighest = employees.get(0);
		
		for (Employee emp: employees) {
			if (emp.getSalary() > curHighest.getSalary()) {
				curHighest = emp;
			}
		}
		
		assertEquals("Booker", curHighest.getFirstName());
	}
	
	@Test
	public void testSortAlpha() {
		
	}
	
	@Test
	public void testSortWage() {
		
	}
}
