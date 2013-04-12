import java.util.ArrayList;


/**
 * @author Ian
 *
 */
public class Driver
{
	private ArrayList<Employee> employees;
	
	/**
	 * 
	 */
	public Driver() {
		this.employees = new ArrayList<Employee>();
	}
	
	/**
	 * Main method
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {

		Driver app = new Driver();
		app.run();
	}


	/**
	 * 
	 */
	public void run() {
		StdOut.println("Employee Management System");
		int option = mainMenu();

		while (option != 0) {

			switch (option) {
			// Module Menu
			case 1:
				int moduleOption = adminMenu();
				switch (moduleOption) {
				case 1:
					addEmployee();
					break;				
				case 2:
					editEmployee();
					break;
				case 3:
					deleteEmployee();
					break;
				}
				break;

			// Sort Menu
			case 2:
				int printOption = printMenu();
				switch (printOption) {
				case 1:
					printBy(printOption);
					break;
				case 2:
					printBy(printOption);
					break;
				case 3:
					printBy(printOption);
					break;				
				}
				break;

			// Account Menu
			case 3:
				int accountOption = accountMenu();
				switch (accountOption) {
				case 1:
					printSalary();
					break;
				case 2:
					printSalaries();
					break;
				case 3:
					printAverage();
					break;
				}
				break;

			// Save/Load Menu
			case 4:
				int saveLoadOption = saveLoadMenu();
				switch (saveLoadOption) {
				case 1:
					save();
					break;
				case 2:
					load();
					break;
				}
				break;
			}

			option = mainMenu();
		}

		StdOut.println("Exiting...bye.");
	}
	
	
	/**
	 * 
	 */
	private void printAverage() {
		StdOut.println("Average Salary for " + employees.size() + " people: ");
		StdOut.print(calcAverage());
	}

	/**
	 * 
	 */
	private void printSalaries() {
		StdOut.println("Total Salary for all employees: ");
		StdOut.print(calcSalaries());
	}

	/**
	 * 
	 */
	private void printSalary() {
		listEmployees();
		
		StdOut.println("Enter Index of Employee whose salary " 
		             + " is to be calculated: ");
		int index = StdIn.readInt();
		StdIn.readLine();
		
		if ((index >= 0) && (index < employees.size())) {
			
			Employee tempEmployee = employees.get(index);
			
			StdOut.println("Enter the amount of hours the employee has worked: ");
			int hours = StdIn.readInt();
			StdIn.readLine();
			
			tempEmployee.calculateSalary(hours);
			
			StdOut.println(tempEmployee.getFirstName() + "'s Salary is: ");			
			StdOut.print(tempEmployee.getSalary());
			StdOut.println("After " + hours + " work.");
			
		} else {
			StdOut.println("Invalid Index!");
			printSalary();
		}		
	}

	/**
	 * 
	 */
	private void listEmployees() {
		if (employees.size() > 0) {
			StdOut.println("--------------");
			StdOut.println("EMPLOYEE LIST");
			StdOut.println("--------------");
			for (int index = 0; index < employees.size(); index += 1) {
				StdOut.println("Index: " + index + "\n" + employees.get(index)
						+ "\n");
			}
			StdOut.println("-----------");
		} else {
			StdOut.println("No Employees in System!");
			StdOut.println("Add Employees now (y/n)?");
			String response = StdIn.readString();
			StdIn.readLine();
			if (response.equals("y")) {
				addEmployee();
			}
		}
	}

	/**
	 * @param printOption
	 */
	private void printBy(int printOption) {
		
		ArrayList<Employee> temp = null;
		
		switch(printOption){
		case 1:
			temp = sort(printOption);
			break;
		case 2:
			temp = sort(printOption);
			break;
		case 3:
			temp = sort(printOption);
		}
		
		for (Employee emp: temp) {
			StdOut.println(emp);
		}
	}

	/**
	 * @param option
	 * @return
	 */
	private ArrayList<Employee> sort(int option) {

		ArrayList<Employee> temp = employees;

		switch (option) {
		case 1:
			for (int i = 0; i < temp.size(); i += 1) {
				for (int j = (i + 1); j < temp.size(); j += 1) {
					if ((temp.get(j).getFirstName()).compareToIgnoreCase(temp
							.get(i).getFirstName()) < 0) {

						Employee emp = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, emp);
					}
				}
			}
			break;
		case 2:
			for (int i = 0; i < temp.size(); i += 1) {
				for (int j = (i + 1); j < temp.size(); j += 1) {
					if ((temp.get(j).getLastName()).compareToIgnoreCase(temp
							.get(i).getLastName()) < 0) {

						Employee emp = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, emp);
					}
				}
			}
			break;
		case 3:
			for (int i = 0; i < temp.size(); i += 1) {

				for (int j = (i + 1); j < temp.size(); j += 1) {
					if (temp.get(j).getHourlyRate() < temp.get(i)
							.getHourlyRate()) {

						Employee emp = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, emp);
					}
				}
			}
			break;
		}

		return temp;
	}

	/**
	 * @return
	 */
	private double calcAverage() {
		double averageSalary = 0.0;
		
		averageSalary = calcSalaries() / employees.size();
		
		return toTwoDecimalPlaces(averageSalary);
	}

	/**
	 * @return
	 */
	private double calcSalaries() {
		double totalSalary = 0;
	
		for (Employee emp : employees) {
			totalSalary += emp.getSalary();
		}
		
		return toTwoDecimalPlaces(totalSalary);		
	}

	/**
	 * 
	 */
	private void load() {
		// TODO Auto-generated method stub		
	}

	/**
	 * 
	 */
	private void save() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return
	 */
	private int saveLoadMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	/**
	 * @return
	 */
	private int accountMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return
	 */
	private int printMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 */
	private void deleteEmployee() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	private void editEmployee() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	private void addEmployee() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return
	 */
	private int adminMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Method to display the main menu for the application and reads the menu
	 * option that the user has entered and returns it.
	 * 
	 * @return user's choice
	 */
	private int mainMenu() {
		StdOut.println("-------------");
		StdOut.println("MAIN MENU");
		StdOut.println("-------------");
		StdOut.println("1 - Admin Menu");
		StdOut.println("2 - Printing Menu");
		StdOut.println("3 - Accounts Menu");
		StdOut.println("4 - Save and Load Menu");
		StdOut.println("-------------------");
		StdOut.println("0 - Exit");

		int option = StdIn.readInt();
		StdIn.readLine();

		return option;
	}

	/**
	 * @return the employees
	 */
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	
	
	/**
     * Internal method to truncate a double to two decimal places
     * 
     * @param num the double number to be trucated to two decimal places
     * @return the double number truncated to two decimal
     *         places (does not round up and down)
     */
    private double toTwoDecimalPlaces(double num) {
        return (int) (num * 100) / 100.0;
    }
	
}
