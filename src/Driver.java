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
			// Admin Menu
			case 1:
				int adminOption = adminMenu();
				switch (adminOption) {
				// Creation Menu
				case 1:
					int addOption = addEmployeeMenu();
					switch (addOption) {
					case 1:
						addEmployee(addOption);
						break;
					case 2:
						addEmployee(addOption);
						break;
					case 3:
						addEmployee(addOption);
						break;
					case 4:
						addEmployeeToManager();
						break;
					}
					break;
				// Update Menu
				case 2:
					int editOption = editEmployeeMenu();
					switch (editOption) {
					case 1:
						editAdminWorker();
						break;
					case 2:
						editSalesWorker();
						break;
					case 3:
						editManager();
						break;
					}
					break;
				// Delete Menu
				case 3:
					int delOption = deleteEmployeeMenu();
					switch (delOption) {
					case 1:
						deleteAdminWorker();
						break;
					case 2:
						deleteSalesWorker();
						break;
					case 3:
						deleteManager();
						break;
					}
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

			// Search Menu
			case 3:
				int searchOption = searchMenu();
				switch (searchOption) {
				case 1:
					searchBy(searchOption);
					break;
				case 2:
					searchBy(searchOption);
					break;				
				}
				break;

			// Account Menu
			case 4:
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
			case 5:
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
	private void addEmployeeToManager() {
		Manager manager = null;

		listManagers();
		StdOut.println("Choose Manager to add employees to: ");
		int managerIndex = StdIn.readInt();
		StdIn.readLine();
		if (employees.size() > 0) {
			if (employees.get(managerIndex).getClass() == Manager.class) {
				manager = (Manager) employees.get(managerIndex);

				StdOut.println("Choose Employee To add:");
				listEmployees(2);
				int empIndex = StdIn.readInt();
				StdIn.readLine();

				Employee toAdd = employees.get(empIndex);

				if (manager.getMinions().size() > 0) {
					manager.getMinions().add(toAdd);
				}
				
				StdOut.println("Employee: " + toAdd.getFirstName() 
						     + " added to " + manager.getFirstName());
				
			} else {
				StdOut.println("Not A Manager!");
				StdOut.println("Choose the index of a valid one!");
				addEmployeeToManager();
			}
		} else {
			StdOut.println("No Employees in System!");
			StdOut.println("Add Employees now (y/n)?");
			String response = StdIn.readString();
			StdIn.readLine();
			if (response.equals("y")) {
				addEmployee(1);
			}
		}

	}

	/**
	 * Method that asks the user to enter the first and last
	 * name, the hourly rate and depending on what type of employee
	 * is to be created will take in a value for a fixed bonus or a 
	 * percentage for a performance bonus.
	 * 
	 * @param choice The type of employee to be created.
	 */
	public void addEmployee(int choice) {
		StdOut.println("Enter Employee's First Name: ");
		String firstName = StdIn.readLine();
		StdOut.println("Enter Employee's Surname: ");
		String lastName = StdIn.readLine();
		
		// Checks if title is duplicated if there are modules in the arraylist
		if (employees.size() > 0) {
			for (Employee emp : employees) {
				if (((emp.getFirstName().equals(firstName)) && (emp.getLastName().equals(lastName)))) {
					StdOut.println("Dublicated Employee Names!");
					addEmployee(choice);
				}
			}
		}
		StdOut.println("Enter Hourly Rate: ");
		double hourlyRate = StdIn.readDouble();
		StdIn.readLine();
		
		switch (choice) {
		case 1:
			StdOut.println("Enter fixed bonus amount: ");
			double fixedBonus = StdIn.readDouble();
			StdIn.readLine();			
			AdminWorker admin = new AdminWorker(firstName, lastName, hourlyRate, fixedBonus);
			employees.add(admin);
			break;
		case 2:
			StdOut.println("Enter bonus Percentage: ");
			StdOut.println("Must be between 0 and 20 inclusive.");	
			double perfBonus = StdIn.readDouble();
			StdIn.readLine();
			if (!(perfBonus > 0 && perfBonus <= 20)) {
				StdOut.println("Not a Valid Range.");
				StdOut.println("Must be between 0 and 20.");
				StdOut.println("Enter new bonus percentage: ");	
				perfBonus = StdIn.readDouble();
				StdIn.readLine();
			}
			SalesWorker sales = new SalesWorker(firstName, lastName, hourlyRate, perfBonus);
			employees.add(sales);			
			break;
		case 3:
			Manager manager = new Manager(firstName, lastName, hourlyRate);
			employees.add(manager);
			break;
		default:
			StdOut.println("Invalid choice.");
			break;
		}			
	}
	
	private void deleteManager() {
		// TODO Auto-generated method stub
		
	}

	private void deleteSalesWorker() {
		// TODO Auto-generated method stub
		
	}

	private void deleteAdminWorker() {
		// TODO Auto-generated method stub
		
	}

	private void editManager() {
		// TODO Auto-generated method stub
		
	}

	private void editSalesWorker() {
		// TODO Auto-generated method stub
		
	}

	private void editAdminWorker() {
		// TODO Auto-generated method stub
		
	}	

	private int deleteEmployeeMenu() {
		return 0;
		// TODO Auto-generated method stub
		
	}

	private int editEmployeeMenu() {
		return 0;
		// TODO Auto-generated method stub
		
	}

	private int addEmployeeMenu() {
		
		StdOut.println("-------------");
		StdOut.println("ADD EMPLOYEE MENU");
		StdOut.println("-------------");
		StdOut.println("1 - Add Admin Worker");
		StdOut.println("2 - Add Sales Worker");
		StdOut.println("3 - Add Manager");		
		StdOut.println("4 - Add Employee To Manager");
		StdOut.println("-------------------");
		StdOut.println("0 - Exit");
		
		int addMenuOption = StdIn.readInt();
		StdIn.readLine();
		
		return addMenuOption;
				
	}

	private void searchBy(int searchOption) {
		// TODO Auto-generated method stub
		
	}

	private int searchMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 */
	private void printAverage() {
		StdOut.println("This will only take into account the salaries that" +
				      " have already been individually calculated.");
		StdOut.println("Average Salary for " + employees.size() + " people: ");
		StdOut.print(calcAverage());
	}

	/**
	 * 
	 */
	private void printSalaries() {
		StdOut.println("This will only take into account the salaries that" +
				" have already been individually calculated.");
		StdOut.println("Total Salary: �" + calcSalaries());		
	}

	/**
	 * 
	 */
	private void printSalary() {
		listEmployees(1);
		
		StdOut.println("Enter Index of Employee whose salary " 
		             + " is to be calculated: ");
		int index = StdIn.readInt();
		StdIn.readLine();
		
		if ((index >= 0) && (index < employees.size())) {
			
			Employee tempEmp = employees.get(index);
			
			StdOut.println("Enter the amount of hours the employee has worked: ");
			int hours = StdIn.readInt();
			StdIn.readLine();			
			
			StdOut.println(tempEmp.getFirstName() + "'s Salary is: �");			
			StdOut.print(tempEmp.calculateSalary(hours));
			StdOut.println("After " + hours + " work.");
			
		} else {
			StdOut.println("Invalid Index!");
			printSalary();
		}		
	}

	/**
	 * @param type Type of Employees to List, 1 = All, 2 removes Managers
	 */
	private void listEmployees(int type) {
		if (employees.size() > 0) {
			StdOut.println("--------------");
			StdOut.println("EMPLOYEE LIST");
			StdOut.println("--------------");
			for (int index = 0; index < employees.size(); index += 1) {

				if (type == 1) {
					StdOut.println("Index: " + index + "\n"
							+ employees.get(index) + "\n");
				}

				else if (type == 2
						&& !(employees.get(index).getClass() == Manager.class)) {
					StdOut.println("Index: " + index + "\n"
							+ employees.get(index) + "\n");
				}

			}
			StdOut.println("-----------");
		} else {
			StdOut.println("No Employees in System!");
			StdOut.println("Add Employees now (y/n)?");
			String response = StdIn.readString();
			StdIn.readLine();
			if (response.equals("y")) {
				addEmployee(1);
			}
		}
	}
	
	/**
	 * 
	 */
	private void listManagers() {
		if (employees.size() > 0) {			
			
			//Tries to create an arrayList of Managers
			//To see if they can be listed or not
			ArrayList<Employee> managers = managerArray();			

			if (managers.size() > 0) {
				StdOut.println("--------------");
				StdOut.println("MANAGER LIST");
				StdOut.println("--------------");

				for (int index = 0; index < employees.size(); index += 1) {
					Employee potentMan = employees.get(index);

					//Go through employees and grabs its index in
					//employees list
				    if (potentMan.getClass() == Manager.class) {
				    	StdOut.println("Index: " + index + "\n"
								+ potentMan + "\n");				    	
				    }
				}				
				StdOut.println("-----------");
			} else {
				StdOut.println("There are no Managers.");
				StdOut.println("Add Manager now (y/n)?");
				String response = StdIn.readString();
				StdIn.readLine();
				if (response.equals("y")) {
					addEmployee(3);
				}
			}
		} else {
			StdOut.println("No Employees in System!");
			StdOut.println("Add Employees now (y/n)?");
			String response = StdIn.readString();
			StdIn.readLine();
			if (response.equals("y")) {
				adminMenu();
			}
		}
	}

	/**
	 * @return
	 */
	private ArrayList<Employee> managerArray() {
		ArrayList<Employee> temp = new ArrayList<Employee>();
		
		for (int index = 0; index < employees.size(); index += 1) {
			Employee potentMan = employees.get(index);

			// TODO Find out if instanceof or .getClass() is better
			
		    if (potentMan.getClass() == Manager.class) {
		    	temp.add(potentMan);
		    }
		}		
		return temp;
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

		for (int i = 0; i < temp.size(); i += 1) {
			for (int j = (i + 1); j < temp.size(); j += 1) {
				switch (option) {
				// Sorting by First Name
				case 1:
					if ((temp.get(j).getFirstName()).compareToIgnoreCase(temp
							.get(i).getFirstName()) < 0) {

						Employee emp = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, emp);
					}
					break;
				//Sorting By Surname	
				case 2:
					if ((temp.get(j).getLastName()).compareToIgnoreCase(temp
							.get(i).getLastName()) < 0) {

						Employee emp = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, emp);
					}
					break;
			    //Sorting by Hourly Rate
				case 3:
					if (temp.get(j).getHourlyRate() < temp.get(i)
							.getHourlyRate()) {

						Employee emp = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, emp);
					}
					break;
				}
			}
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
	 * @return
	 */
	private int adminMenu() {
		StdOut.println("-------------");
		StdOut.println("ADMIN MENU");
		StdOut.println("-------------");
		StdOut.println("1 - Add Employee Menu");
		StdOut.println("2 - Edit Employee Menu");
		StdOut.println("3 - Delete Employee Menu");		
		StdOut.println("-------------------");
		StdOut.println("0 - Exit");
		
		int adminOption = StdIn.readInt();
		StdIn.readLine();

		return adminOption;
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
