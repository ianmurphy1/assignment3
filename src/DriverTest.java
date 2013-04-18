import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DriverTest
{
	Manager m1, m2;
	AdminWorker a1, a2;
	SalesWorker s1, s2, s3;
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
		s3 = new SalesWorker("Samwell", "Tarly", 10.50, 12);

		// Adding Managers to the list last so a sort isn't
		// required (for now) when calculating wages.
		employees.add(s1);
		employees.add(s2);
		employees.add(s3);
		employees.add(a1);
		employees.add(a2);
		employees.add(m2);
		employees.add(m1);
		

		m1.getMinions().add(a1);
		m1.getMinions().add(s1);

		m2.getMinions().add(a2);
		m2.getMinions().add(s2);
		
		s2.setHoursWorked(15);
		s1.setHoursWorked(24);
		a2.setHoursWorked(20);
		a1.setHoursWorked(26);
		m1.setHoursWorked(22);
		m2.setHoursWorked(28);

		for (Employee emp: employees) {
			emp.calculateSalary();
		}
	}

	@Test
	public void testCalculateSalaries() {
		totalSalary = 0;

		for (Employee emp : employees) {
			totalSalary += emp.getSalary();
		}
		
		double averageSalary = (totalSalary / employees.size());

		assertEquals(2170.11, totalSalary, DELTA);
		assertEquals(310.01, averageSalary, DELTA);
	}

	@Test
	public void testHighestSalary() {
		Employee curHighest = employees.get(0);

		for (Employee emp : employees) {
			if (emp.getSalary() > curHighest.getSalary()) {
				curHighest = emp;
			}
		}

		assertEquals("Booker", curHighest.getFirstName());
	}

	@Test
	public void testSortFirstName() {
		
		ArrayList<Employee> temp = employees;
		
		assertEquals("Johnny", temp.get(0).getFirstName());
		
		for (int i = 0; i < temp.size(); i += 1) {

			for (int j = (i + 1); j < temp.size(); j += 1) {

				if ((temp.get(j).getFirstName()).compareToIgnoreCase(
						             temp.get(i).getFirstName()) < 0) {
					
					Employee emp = temp.get(i);
					temp.set(i, temp.get(j));	
					temp.set(j, emp);
				}
			}
		}
		
		assertEquals("Booker", temp.get(0).getFirstName());
		assertEquals("Elizabeth", temp.get(1).getFirstName());
		assertEquals("Paul", temp.get(4).getFirstName());
		assertEquals("Samwell", temp.get(6).getFirstName());
	}
	
	@Test
	public void testSortHourlyRate() {
		
		ArrayList<Employee> temp = new ArrayList<Employee>(employees);
		
		for (int i = 0; i < temp.size(); i += 1) {			
			for (int j = (i + 1); j < temp.size(); j += 1) {
				if (temp.get(j).getHourlyRate() < temp.get(i).getHourlyRate()) {
					
					Employee emp = temp.get(i);
					temp.set(i, temp.get(j));	
					temp.set(j, emp);
				}
			}
		}
		
		assertEquals("Samwell", temp.get(1).getFirstName());
		assertEquals("Booker", temp.get(5).getFirstName());
	}
	
	@Test
	public void testManagerSort() {
		
		ArrayList<Employee> tempEmps = new ArrayList<Employee>();
		
		for (int index = 0; index < employees.size(); index += 1) {
			
			Employee potentMan = employees.get(index);
			
			/*if (potentMan.getClass() == Manager.class) {
				tempEmps.add(employees.get(index));
			}*/
			
			if (potentMan instanceof Manager) {
				tempEmps.add(potentMan);
			}
		}
		
		
		//Booker because he was added first.
		assertEquals("Booker", tempEmps.get(0).getFirstName());
		assertEquals(2, tempEmps.size());
	}
	
	@Test
	public void testSortingLoops() {
		
		int option = 1;
		
		ArrayList<Employee> temp = employees;
		Employee emp = null;

		for (int i = 0; i < temp.size(); i += 1) {
			for (int j = (i + 1); j < temp.size(); j += 1) {
				switch(option) {
				//Sorting by First Name
				case 1:
					if ((temp.get(j).getFirstName()).compareToIgnoreCase(temp
								.get(i).getFirstName()) < 0) {

							emp = temp.get(i);
							temp.set(i, temp.get(j));
							temp.set(j, emp);
						}
					break;
				case 2:
					if ((temp.get(j).getLastName()).compareToIgnoreCase(temp
							.get(i).getLastName()) < 0) {

						emp = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, emp);
					}
					break;
				case 3:
					if (temp.get(j).getHourlyRate() < temp.get(i)
							.getHourlyRate()) {
						
						emp = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, emp);
					}
					break;
					}
											
				}
			}
		
		if (option == 1) {
			assertEquals("Booker", temp.get(0).getFirstName());
			assertEquals("Elizabeth", temp.get(1).getFirstName());
			assertEquals("Paul", temp.get(4).getFirstName());
			assertEquals("Samwell", temp.get(6).getFirstName());
		} else if (option == 3) {
			assertEquals("Samwell", temp.get(1).getFirstName());
			assertEquals("Booker", temp.get(5).getFirstName());
		}		
	}
	
	@Test
	public void testDeleteEmployee() {

		ArrayList<Manager> temp = new ArrayList<Manager>();

		for (int index = 0; index < employees.size(); index += 1) {
			Employee potentMan = employees.get(index);			

			if (potentMan.getClass() == Manager.class) {
				temp.add((Manager) potentMan);
			}
		}
		
		assertEquals(7, employees.size());

		Manager delFromThis = (Manager) employees.get(6);
		assertEquals(2, delFromThis.getMinions().size());

		Employee delThis = employees.get(4);

		if (delThis.hasManager()) {

			String name = (delThis.getFirstName() + delThis.getLastName());

			for (Manager man : temp) {
				for (int i = 0; i < temp.size(); i += 1) {

					String compare = (man.getMinions().get(i).getFirstName() + man
							.getMinions().get(i).getLastName());

					if (name.equalsIgnoreCase(compare)) {
						man.getMinions().remove(delThis);
					}
				}
			}

			employees.remove(delThis);
			assertEquals(6, employees.size());
			assertEquals(1, delFromThis.getMinions().size());
		}
	}
}
