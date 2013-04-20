import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * The Driver class provides a facility to store Employee
 * objects.
 * 
 * Interacting through a text-based menu system:-
 * 
 * Employees can be created, edited and deleted from the overall list. 
 * A list of all Employess can be printed to the terminal in various 
 * orders, Alphabetically by First or Second name. By the hourly rate or by 
 * the Employees index number within the employees list.
 * Employees can also be added to a manager's department. This list can
 * then be added to, deleted from and also be printed.
 * 
 * Salaries can be computed, individually, altogether and also the highest 
 * earner within the employees datbase can be calculated.
 * 
 * The current list can also be saved so that it can be loaded from at a 
 * later date.
 * 
 *  
 * @author Ian Murphy
 * 
 */
public class Driver
{
	/**
	 * Used when printing a list, passed in as the 2nd 
	 * parameter of printBy();
	 */
	//ALL prints All users of the employees also used in search
	private final static int ALL = 1;
	//EMP allows a list of the employees that
	//don't have managers to be printed
	private final static int EMP = 2;
	
	/**
	 * Used when sorting the employees list, passed in as the 1st 
	 * parameter of printBy();
	 */
	//No sort
	private final static int NONE = 1; 
	//Sort By First Name
	private final static int FIRST_N = 2;
	//Sort By Last Name
	private final static int LAST_N = 3;
	//Sort By Hourly Rate
	private final static int HOURLY = 4;
	
	//Used when Searching
	private final static int MAN = 2;
	
	
	private ArrayList<Employee> employees;

	/**
	 * Constructor for objects of class Driver.
	 * 
	 */
	public Driver() {
		this.employees = new ArrayList<Employee>();
	}

	/**
	 * Method to get the ArrayList employees
	 * 
	 * @return the employees
	 */
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	/**
	 * Setter to change the ArrayList
	 * 
	 * @param employees
	 *            the employees to set
	 */
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * Main method
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {
		Driver app = new Driver();
	    //app.constructObjects();
		app.load();
		app.run();
	}

	/**
	 * Displays the main menu and takes in the user's input to open
	 * one of the available sub-menus where the various methods 
	 * for managing the system are called.
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
					}
					break;
				// Update Menu
				case 2:
					editEmployee();
					break;
				// Delete Menu
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
					printBy(NONE, ALL);
					break;
				case 2:
					printBy(FIRST_N, ALL);
					break;
				case 3:
					printBy(LAST_N, ALL);
					break;
				case 4:
					printBy(HOURLY, ALL);
					break;				
				}
				break;

			// Search Menu
			case 3:
				int searchOption = searchMenu();
				switch (searchOption) {
				case 1:
					searchBy(ALL);
					break;
				case 2:
					searchBy(MAN);
					break;
				}
				break;

			// Account Menu
			case 4:
				int accountOption = accountMenu();
				switch (accountOption) {
				case 1:
					calcSalary();
					break;
				case 2:
					printSalaries();
					break;
				case 3:
					printAverage();
					break;
				case 4:
					printHighestEarner();
					break;
				}
				break;

			// Manager Menu
			case 5:
				int manOption = managerMenu();
				switch (manOption) {
				case 1:
					addToManager();
					break;
				case 2:
					delFromManger();
					break;
				case 3:
					printFromManager();
					break;
				}
				break;

			// Save/Load Menu
			case 6:
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
		StdOut.println("2 - Sort and Print Menu");
		StdOut.println("3 - Search Menu");
		StdOut.println("4 - Accounting Menu");
		StdOut.println("5 - Manager Admin Menu");
		StdOut.println("6 - Save and Load Menu");
		StdOut.println("-------------------");
		StdOut.println("0 - Exit");

		int option = getInt();
		
		return option;
	}

	/**
	 * Menu that displays the admin menu and returns the users option
	 * so that the chosen operation to be carried out.
	 * 
	 * @return
	 */
	private int adminMenu() {
		StdOut.println("-------------");
		StdOut.println("ADMIN MENU");
		StdOut.println("-------------");
		StdOut.println("1 - Add Employee Menu");
		StdOut.println("2 - Edit an Employee");
		StdOut.println("3 - Delete an Employee");
		StdOut.println("-------------------");
		StdOut.println("0 - Exit");

		int adminOption = getInt();

		return adminOption;
	}

	/**
	 * Method that displays and returns the menu system for 
	 * adding an employee to the employees arraylist.
	 * 
	 * @return
	 */
	private int addEmployeeMenu() {

		StdOut.println("-------------");
		StdOut.println("ADD EMPLOYEE MENU");
		StdOut.println("-------------");
		StdOut.println("1 - Add Admin Worker");
		StdOut.println("2 - Add Sales Worker");
		StdOut.println("3 - Add Manager");
		StdOut.println("-------------------");
		StdOut.println("0 - Exit");

		int addMenuOption = getInt();

		return addMenuOption;

	}

	/**
	 * Method that asks the user to enter the first and last name, the hourly
	 * rate and depending on what type of employee is to be created will take in
	 * a value for a fixed bonus or a percentage for a performance bonus.
	 * 
	 * @param choice
	 *            The type of employee to be created.
	 */
	public void addEmployee(int choice) {
		StdOut.println("Enter Employee's First Name: ");
		String firstName = getString();
		StdOut.println("Enter Employee's Surname: ");
		String lastName = getString();

		// Checks if both names are equal, if they are employee can't be
		// created
		if (employees.size() > 0) {
			for (Employee emp : employees) {
				if (((emp.getFirstName().equals(firstName)) && (emp
						.getLastName().equals(lastName)))) {
					StdOut.println("Duplicated Employee Names!");
					addEmployee(choice);
				}
			}
		}
		StdOut.println("Enter Hourly Rate: ");
		double hourlyRate = getDouble();

		switch (choice) {
		case 1:
			StdOut.println("Enter fixed bonus amount: ");
			double fixedBonus = getDouble();
			AdminWorker admin = new AdminWorker(firstName, lastName,
					hourlyRate, fixedBonus);
			employees.add(admin);
			break;
		case 2:
			StdOut.println("Enter bonus Percentage: ");
			StdOut.println("Must be between 0 and 20 inclusive.");
			double perfBonus = getDouble();
			if (!(perfBonus > 0 && perfBonus <= 20)) {
				StdOut.println("Not a Valid Range.");
				StdOut.println("Must be between 0 and 20.");
				StdOut.println("Enter new bonus percentage: ");
				perfBonus = getDouble();
			}
			SalesWorker sales = new SalesWorker(firstName, lastName,
					hourlyRate, perfBonus);
			employees.add(sales);
			break;
		case 3:
			Manager manager = new Manager(firstName, lastName, hourlyRate);
			employees.add(manager);
			break;
		}
	}

	/**
	 * Method that allows the editing of a chosen employee from the 
	 * employees arraylist.
	 */
	public void editEmployee() {

		if (employees.size() > 0) {
			printBy(NONE, ALL);
			StdOut.println("Choose Index of Employee to Edit: ");
			int index = getInt();
			if ((index >= 0) && (index < employees.size())) {
				Employee emp = employees.get(index);
				String firstName = null;
				String lastName = null;
				int type = getType(emp);

				StdOut.println("Do you want to edit 1st name (Y/N)?");
				String firstResponse = getString();
				if (firstResponse.equalsIgnoreCase("Y")) {
					StdOut.println("Enter new First Name: ");
					firstName = getString();
				}

				StdOut.println("Do you want to edit last name (Y/N)?");
				String secondResponse = getString();
				if (secondResponse.equalsIgnoreCase("Y")) {
					StdOut.println("Enter new Last Name: ");
					lastName = getString();
				}

				String testNew = (firstName + lastName);
				String testOld = (emp.getFirstName() + emp.getLastName());

				if (testNew.equalsIgnoreCase(testOld)) {
					StdOut.println("Duplicate Employee!");
					StdOut.println("Restarting...");
					editEmployee();
				} else {
					if ((firstResponse.equalsIgnoreCase("Y"))) {
						emp.setFirstName(firstName);
					}
					if (secondResponse.equalsIgnoreCase("Y")) {
						emp.setLastName(lastName);
					}
				}

				StdOut.println("Do you want to edit hourly rate (Y/N)?");
				String rateResponse = getString();
				if (rateResponse.equalsIgnoreCase("Y")) {
					StdOut.println("Enter New Hourly Rate: ");
					double hourlyRate = getDouble();
					if (hourlyRate >= 0) {
						emp.setHourlyRate(hourlyRate);
					} else {
						StdOut.println("Number needs to greater than 0!");
						StdOut.println("Enter New Value: ");
						hourlyRate = getDouble();
						emp.setHourlyRate(hourlyRate);
					}
				}

				switch (type) {
				case 1:
					StdOut.println("Nothing Left to Edit.");
					StdOut.println("If you want to add/delete employees from");
					StdOut.println("a manager, do so through the manager menu.");
					StdOut.println("---Employee's New Info---");
					StdOut.println(emp);
					break;
				case 2:
					SalesWorker salesEmp = (SalesWorker) emp;
					StdOut.println("Do you want to edit performance bonus (Y/N)?");
					String salesResponse = getString();
					if (salesResponse.equalsIgnoreCase("Y")) {
						double perfBonus = getDouble();
						if ((perfBonus >= 0) && (perfBonus <= 20)) {
							salesEmp.setPerfBonus(perfBonus);
						} else {
							StdOut.println("Number needs to greater than 0 ");
							StdOut.print("and less than or equal to 20!");
							StdOut.println("Enter New Value: ");
							perfBonus = getDouble();
							salesEmp.setHourlyRate(perfBonus);
						}
					}
					StdOut.println("---Employee's New Info---");
					StdOut.println(salesEmp);
					break;
				case 3:
					AdminWorker adminEmp = (AdminWorker) emp;
					StdOut.println("Do you want to edit fixed bonus (Y/N)?");
					String adminResponse = getString();
					if (adminResponse.equalsIgnoreCase("Y")) {
						double bonus = getDouble();
						if (bonus >= 0) {
							adminEmp.setBonus(bonus);
						} else {
							StdOut.println("Number needs to greater than 0!");
							StdOut.println("Enter New Value: ");
							bonus = getDouble();
							adminEmp.setHourlyRate(bonus);
						}
						StdOut.println("---Employee's New Info---");
						StdOut.println(adminEmp);
					}
					break;
				}
			} else {
				StdOut.println("Invalid Index!");
				StdOut.println("Choose another from this list!");
				editEmployee();
			}
		} else {
			noEmployeesResponse();
		}
	}

	/**
	 * Method that allows the deletion of an employee from
	 * the employees arraylist, also deletes it from a managers
	 * arraylist if he/she is there.
	 * 
	 */
	public void deleteEmployee() {

		if (employees.size() > 0) {

			printBy(NONE, ALL);
			StdOut.println("Choose Index of Employee to delete: ");
			int delChoice = getInt();

			if ((delChoice >= 0) && (delChoice < employees.size())) {
				StdOut.println("Are you sure you want to delete? (y/n)");
				String response = getString();

				Employee delThis = employees.get(delChoice);

				// Checking to see if employee is in a managers list
				// If he is, removed from that too
				if (response.equalsIgnoreCase("y")) {

					if (delThis.hasManager()) {
						ArrayList<Manager> managers = managerArray();

						String name = (delThis.getFirstName() + delThis
								.getLastName());

						for (Manager man : managers) {
							for (int i = 0; i < managers.size(); i += 1) {

								String compare = (man.getMinions().get(i)
										.getFirstName() + man.getMinions()
										.get(i).getLastName());

								if (name.equalsIgnoreCase(compare)) {
									man.getMinions().remove(delThis);
								}
							}
						}
					}

					employees.remove(delThis);
					StdOut.println("New List: ");
					printBy(NONE, ALL);
				}
			} else {
				StdOut.println("Invalid Index!");
				StdOut.println("Choose another from this list!");
				deleteEmployee();
			}
		} else {
			noEmployeesResponse();
		}
	}

	/**
	 * Menu that displays and returns the options for the Print And 
	 * Sort menu for the system
	 * 
	 * @return The Users Choice
	 */
	private int printMenu() {
		StdOut.println("------------------------");
		StdOut.println("SORT AND PRINT MENU");
		StdOut.println("------------------------");
		StdOut.println();
		StdOut.println("---- Sort and Print ----");
		StdOut.println("----  Employees In  ----");
		StdOut.println("-- Ascending Order By --");
		StdOut.println("1 - Index Number");
		StdOut.println("2 - First Name");
		StdOut.println("3 - Surname");
		StdOut.println("4 - Hourly Rate");
		StdOut.println("--------------------------");
		StdOut.println("0 - Exit");

		int printOption = getInt();

		return printOption;
	}

	/**
	 * Method allows the printing of an arraylist based on if that list is to be
	 * sorted in a particular way or if there is to be some restrictions in the
	 * type of employees that it returns.
	 * 
	 * @param sortOption
	 *            What to sort it as
	 * @param typeOption
	 *            Type of list to display (All or Just a group)
	 */
	public void printBy(int sortOption, int typeOption) {

		ArrayList<Employee> temp = null;

		switch (sortOption) {
		case 1:
			temp = employees;
			break;
		case 2:
			//temp = sort(FIRST_N);
			temp = new ArrayList<Employee>(sort(employees, FIRST_N));
			break;
		case 3:
			//temp = sort(LAST_N);
			temp = new ArrayList<Employee>(sort(employees, LAST_N));
			break;
		case 4:
			//temp = sort(HOURLY);
			temp = new ArrayList<Employee>(sort(employees, HOURLY));
			break;
		}

		if (temp.size() > 0) {
			StdOut.println("--------------");
			switch (sortOption) {
			case 1:
				StdOut.println("INDEX SORTED LIST");
				break;
			case 2:
				StdOut.println("FIRST NAME SORTED LIST");
				break;
			case 3:
				StdOut.println("LAST NAME SORTED LIST");
				break;
			case 4:
				StdOut.println("RATE SORTED LIST");
				break;
			}

			StdOut.println("--------------");
			StdOut.println();

			for (int index = 0; index < temp.size(); index += 1) {
								
				Employee emp = temp.get(index);
				int employeesIndex = employees.indexOf(emp);

				int empType = getType(emp);

				if (typeOption == 1) {
					StdOut.println("Index: " + employeesIndex + "\n" + emp + "\n");
				} else if ((typeOption == 2) && !(empType == 1)) {
					if (!(emp.hasManager())) {
						StdOut.println("Index: " + employeesIndex + "\n" + emp + "\n");
					}
				}			
			}
			StdOut.println("-----------");
		} else {
			noEmployeesResponse();
		}
	}
	

	/**
	 * Method that sorts through all the employees and returns the highest
	 * earner
	 * 
	 * @return The Highest Earner
	 */
	public Employee getHighestEarner() {
		Employee highestEarner = employees.get(0);

		for (Employee emp : employees) {
			if (emp.getSalary() > highestEarner.getSalary()) {
				highestEarner = emp;
			}
		}
		return highestEarner;
	}

	/**
	 * Method that prints the highest Earner once it's been returned
	 * by the getHighestEarner() method.
	 * 
	 */
	private void printHighestEarner() {
		Employee highestEarner = getHighestEarner();

		StdOut.println("-------------");
		StdOut.println("HIGHEST EARNER");
		StdOut.println("-------------");
		StdOut.println();
		StdOut.println("Highest Earner is: " + highestEarner.getFirstName());
		StdOut.print(" with E" + highestEarner.getSalary());
		StdOut.println("-------------");
		StdOut.println();
	}

	/**
	 * Menu that display the search options to a user and returns
	 * the option that they choose.
	 * 
	 * @return User's Input
	 */
	private int searchMenu() {
		StdOut.println("-------------");
		StdOut.println("SEARCH MENU");
		StdOut.println("-------------");
		StdOut.println("1 - Search Company");
		StdOut.println("2 - Search a Manager");
		StdOut.println("-------------------");
		StdOut.println("0 - Exit");

		int searchOption = getInt();

		return searchOption;
	}

	/**
	 * Method that allows the searching of an employee in the full list of
	 * employees or of a particular manager.
	 * 
	 * 
	 * @param searchOption
	 *            The type of search to be performed
	 */
	public void searchBy(int searchOption) {
		int position = 0;
		int matches = 0;
		boolean found = false;
		StdOut.println("----Searching----");
		String searchString = null;

		if (employees.size() > 0) {

			switch (searchOption) {
			// Searching All Employees
			case 1:
				StdOut.println("Enter Search Term:");
				searchString = (getString()).toLowerCase();

				for (Employee employee : employees) {
					String fullName = (employee.getFirstName() + employee
							.getLastName()).toLowerCase();

					if (fullName.contains(searchString)) {
						found = true;
						matches += 1;
						StdOut.println();
						StdOut.println("------------------");
						StdOut.println("Employee's name "
								+ employee.getFirstName()
								+ employee.getLastName());
						StdOut.println("Index is: " + position);
						StdOut.println("------------------");
					}
					position++;
				}

				if (!found) {
					StdOut.println("No Matches Found!");
				} else if (found) {
					StdOut.println(matches + " Matches Found!");
				}
				break;
			// Searching in a Manager
			case 2:
				listManagers();
				StdOut.println("Choose Index of Manager to Search: ");
				int index = getInt();
				if ((index >= 0) && (index < employees.size())) {

					int type = getType(employees.get(index));

					if (type == 1) {
						Manager manager = (Manager) employees.get(index);
						StdOut.println("Enter Search Term: ");
						searchString = (getString()).toLowerCase();

						for (Employee emp : manager.getMinions()) {
							String fullName = (emp.getFirstName() + emp
									.getLastName()).toLowerCase();

							if (fullName.contains(searchString)) {
								found = true;
								matches += 1;
								StdOut.println();
								StdOut.println("------------------");
								StdOut.println("Employee's name "
										+ emp.getFirstName() + " "
										+ emp.getLastName());
								StdOut.println("Index is: " + position);
								StdOut.println("------------------");
							}
							position++;
						}
						if (!found) {
							StdOut.println("No Matches Found!");
						} else {
							StdOut.println(matches + " Matches Found!");
						}
					} else {
						StdOut.println("Not A Manager!");
						StdOut.println("Choose the index of a valid one!");
						searchBy(2);
					}
				} else {
					StdOut.println("Not A Valid Index!");
					StdOut.println("Choose the index of a valid one!");
					searchBy(2);
				}
				break;
			}
		} else {
			noEmployeesResponse();
		}
	}

	/**
	 * Menu that displays the menu for carrying out calculations
	 * on players salaries. Also used to set the number of hours an
	 * employee has worked.
	 * 
	 * @return User's choice to carry out
	 */
	private int accountMenu() {
		StdOut.println("-------------------");
		StdOut.println("ACCOUNTS MENU");
		StdOut.println("-------------------");
		StdOut.println("1 - Calculate An Employee's Salary");
		StdOut.println("2 - Calculate All Employee's Salaries");
		StdOut.println("3 - Calculate Average Salary");
		StdOut.println("4 - Get Highest Earner");
		StdOut.println("-------------------");
		StdOut.println("0 - Exit");

		int accountOption = getInt();

		return accountOption;
	}

	/**
	 * Method to chose and calculate an employee's salary.
	 */
	public void calcSalary() {
		printBy(NONE, ALL);

		StdOut.println("Enter Index of Employee whose salary "
				     + " is to be calculated: ");
		int index = getInt();

		if ((index >= 0) && (index < employees.size())) {

			Employee tempEmp = employees.get(index);
			StdOut.println("Enter the amount of hours the employee has worked: ");

			double hours = getDouble();
			
			tempEmp.setHoursWorked(hours);

			StdOut.println(tempEmp.getFirstName() + "'s Salary is: E");
			
			StdOut.print(tempEmp.calculateSalary());
			StdOut.println("After " + hours + " work.");
			StdOut.println("New total amount of hours worked "
					+ tempEmp.getHoursWorked());
			StdOut.println();

		} else {
			StdOut.println("Invalid Index!");
			calcSalary();
		}
	}

	/**
	 * Method that Prints the salaries of all employees.
	 */
	public void printSalaries() {
		if (employees.size() > 0) {
			StdOut.println("This will only take into account the salaries that"
					+ " have already been individually calculated.");
			StdOut.println("Total Salary: E" + calcSalaries());
		} else {
			noEmployeesResponse();
		}
	}

	/**
	 * Prints the average salary of everyone in employees.
	 */
	public void printAverage() {
		StdOut.println("This will only take into account the salaries that"
				+ " have already been individually calculated.");
		if (calcAverage() > 0) {
			StdOut.println("Average Salary for " + employees.size() + " people: ");
			StdOut.print(calcAverage());
		} else {
			noEmployeesResponse();
		}		
	}

	/**
	 * Displays a menu and returns the users option.
	 * 
	 * @return User's Choice
	 */
	private int managerMenu() {
		StdOut.println("-------------");
		StdOut.println("MANAGER MENU");
		StdOut.println("-------------");
		StdOut.println("1 - Add Employee to a Manager");
		StdOut.println("2 - Delete Employee from Manager");
		StdOut.println("3 - List Employees in a Manager");
		StdOut.println("-------------------");
		StdOut.println("0 - Exit");

		int manMenuOption = getInt();

		return manMenuOption;
	}

	/**
	 * Method that allows a user to add an employee from the employees list into
	 * a managers collection.
	 */
	public void addToManager() {

		if (employees.size() > 0) {
			Manager manager = null;

			listManagers();
			StdOut.println("Choose Manager to add employees to: ");
			int managerIndex = getInt();

			if ((managerIndex >= 0) && (managerIndex < employees.size())) {

				if (employees.get(managerIndex).getClass() == Manager.class) {
					manager = (Manager) employees.get(managerIndex);

					StdOut.println("Choose Employee To Add:");
					printBy(NONE, EMP);
					int empIndex = getInt();

					Employee toAdd = employees.get(empIndex);

					manager.getMinions().add(toAdd);
					toAdd.setHasManager(true);

					StdOut.println("Employee: " + toAdd.getFirstName()
							+ " added to " + manager.getFirstName());
				} else {
					StdOut.println("Not A Manager!");
					StdOut.println("Choose the index of a valid one!");
					addToManager();
				}
			} else {
				StdOut.println("Not A Valid Index!");
				StdOut.println("Choose the index of a valid one!");
				addToManager();
			}
		} else {
			noEmployeesResponse();
		}
	}

	/**
	 * Method that prints the employees contained in a chosen managers
	 * department.
	 * 
	 */
	public void printFromManager() {
		if (employees.size() > 0) {
			Manager manager = null;

			listManagers();
			StdOut.println("Choose Manager to Print Employees: ");
			int managerIndex = getInt();

			if ((managerIndex >= 0) && (managerIndex < employees.size())) {

				int type = getType(employees.get(managerIndex));
				if (type == 1) {
					manager = (Manager) employees.get(managerIndex);
					listMinions(manager);
				} else {
					StdOut.println("Not A Manager!");
					StdOut.println("Choose the index of a valid one!");
					addToManager();
				}
			} else {
				StdOut.println("Not A Valid Index!");
				StdOut.println("Choose the index of a valid one!");
				addToManager();
			}
		} else {
			noEmployeesResponse();
		}
	}

	/**
	 * Method that allows the deletion of an employee from a managers 
	 * arraylist.
	 */
	public void delFromManger() {
		if (employees.size() > 0) {
			Manager manager = null;

			listManagers();
			StdOut.println("Choose Manager to delete employee from: ");
			int managerIndex = getInt();

			if ((managerIndex >= 0) && (managerIndex < employees.size())) {

				int type = getType(employees.get(managerIndex));

				if (type == 1) {
					manager = (Manager) employees.get(managerIndex);

					StdOut.println("Choose Index of Employee To Remove:");
					listMinions(manager);
					int empIndex = getInt();

					Employee delThis = manager.getMinions().get(empIndex);

					delThis.setHasManager(false);
					manager.getMinions().remove(empIndex);

					StdOut.println("Employee: " + delThis.getFirstName()
							+ " deleted from " + manager.getFirstName());
				} else {
					StdOut.println("Not A Manager!");
					StdOut.println("Choose the index of a valid one!");
					addToManager();
				}
			} else {
				StdOut.println("Not A Valid Index!");
				StdOut.println("Choose the index of a valid one!");
				addToManager();
			}
		} else {
			noEmployeesResponse();
		}
	}

	/**
	 * Method that displays the save and load menu and returns 
	 * that option.
	 * 
	 * @return Users operation choice
	 */
	private int saveLoadMenu() {
		StdOut.println("-------------------");
		StdOut.println("SAVE/LOAD MENU");
		StdOut.println("-------------------");
		StdOut.println("1 - Save Employees");
		StdOut.println("2 - Load Previous Save");
		StdOut.println("-------------------");
		StdOut.println("0 - Exit");

		int saveLoadOption = getInt();

		return saveLoadOption;
	}

	/**
	 * Method that saves the employees list and outputs it as an xml file which
	 * holds all the data.
	 * 
	 */
	public void save() {
		StdStream.saveToFile(employees, "employees.xml");
	}

	/**
	 * Method that loads the data stored in the employees.xml and sets the
	 * employees arraylist to be it.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void load() {
		ArrayList<Employee> temp = ((ArrayList<Employee>) StdStream
				.readFromFile("employees.xml"));
		this.setEmployees(temp);
	}

	/**
	 * Method that takes in a manager and prints the list of employees he has in
	 * his list.
	 * 
	 * @param manager
	 *            Manager's whose minions is to be printed
	 */
	public void listMinions(Manager manager) {
		int index = 0;

		for (Employee emp : manager.getMinions()) {
			StdOut.println(emp + "\nIndex at: " + index);
			index += 1;
		}
	}

	/**
	 * Method that lists all the managers inside employees if there is any
	 * managers in it.
	 */
	public void listManagers() {
		if (employees.size() > 0) {

			// Tries to create an arrayList of Managers
			// To see if they can be listed or not
			ArrayList<Manager> managers = managerArray();

			if (managers.size() > 0) {
				StdOut.println("--------------");
				StdOut.println("MANAGER LIST");
				StdOut.println("--------------");

				for (int index = 0; index < employees.size(); index += 1) {
					Employee potentMan = employees.get(index);

					int type = getType(potentMan);
					// Go through employees and grabs its index in
					// employees list
					if (type == 1) {
						StdOut.println("Index: " + index + "\n" + potentMan);
						if (index != employees.size()) {
							StdOut.println();
						}		
					}
				}
				StdOut.println("-----------");
			} else {
				noManagersResponse();
			}
		} else {
			noEmployeesResponse();
		}
	}

	/**
	 * Method that goes through the employees list and grabs those that are
	 * Managers and puts them into their own list. Used when trying to figure
	 * out if there's any Managers or used when needed to print a list of
	 * employees that belong to a particular manager.
	 * 
	 * @return Array Of Managers
	 */
	public ArrayList<Manager> managerArray() {
		ArrayList<Manager> temp = new ArrayList<Manager>();

		for (int index = 0; index < employees.size(); index += 1) {
			Employee potentMan = employees.get(index);

			int type = getType(potentMan);
			
			if (type == 1) {
				temp.add((Manager) potentMan);
			}
		}
		return temp;
	}

	/**
	 * Method that sorts through employees based on the option specified by the
	 * user from the menu system, and returns the sorted list as an array.
	 * 
	 * @param option
	 *            The type of sorting to happen
	 * @return A sorted ArrayList of the type specified
	 * @deprecated Use {@link #newSort()} instead
	 */
	public ArrayList<Employee> sort(int option) {

		//Creating copy of array as order of original needs to be maintained
		ArrayList<Employee> temp = new ArrayList<Employee>(employees);

		Employee emp = null;

		for (int i = 0; i < temp.size(); i += 1) {
			for (int j = (i + 1); j < temp.size(); j += 1) {
				switch (option) {
				// Sorting by First Name
				case FIRST_N:
					if ((temp.get(j).getFirstName()).compareToIgnoreCase(temp
							.get(i).getFirstName()) < 0) {
						emp = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, emp);
					}
					break;
				// Sorting By Surname
				case LAST_N:
					if ((temp.get(j).getLastName()).compareToIgnoreCase(temp
							.get(i).getLastName()) < 0) {

						emp = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, emp);
					}
					break;
				// Sorting by Hourly Rate
				case HOURLY:
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
		return temp;
	}	
	
	/**
	 * 1st part of the merge/sort, this part takes in the list
	 * to be sorted and splits into 2 parts recursively. Then it calls 
	 * the merge part of the system to sort and stitch all the lists together 
	 * and returns it as a sorted list based on the type that was passed
	 * into it at the start.
	 * 
	 * @param emps List of Employees To Sort
	 * @param sortType Type of sort to be carried out
	 * @return List of Sorted Employees
	 */
	public List<Employee> sort(List<Employee> emps, int sortType) {		
		
		if (emps.size() > 1) {
			int half = (emps.size() / 2);
			
			List<Employee> left = emps.subList(0, half);
			List<Employee> right = emps.subList(half, emps.size());
								
			return mergeSort(sort(left, sortType), sort(right, sortType), sortType);
		} else {
			return emps;
		}	
	}	
	
	/**
	 * Merging and sorting part of the sort that takes the split lists from
	 * the newSort() method, sorts them and then returns the completed list
	 * back to the newSort().
	 * 
	 * @param left The left hand side of the List
	 * @param right Right Hand side of List
	 * @param sortType The type of sorting to do
	 * @return The merged list.
	 */
	public List<Employee> mergeSort(List<Employee> left, List<Employee> right, int sortType) {
		
		ArrayList<Employee> finish = new ArrayList<Employee>();
		
		int sizeCount = (left.size() + right.size());		
		
		String thisOne = "";
		String thatOne = "";
		double tryThisOne = 0;
		double tryThatOne = 0;
		int i = 0;
		int j = 0;
		
		for (int counter = 0; counter < sizeCount; counter += 1) {
			switch (sortType) {
			case FIRST_N:
				if (i < left.size()) {
					thisOne = left.get(i).getFirstName();
				}
				if (j < right.size()) {
					thatOne = right.get(j).getFirstName();
				}				
				break;
			case LAST_N:
				if (i < left.size()) {
					thisOne = left.get(i).getLastName();
				}
				if (j < right.size()) {
					thatOne = right.get(j).getLastName();
				}				
				break;
			case HOURLY:				
				if (i < left.size()) {
					tryThisOne = left.get(i).getHourlyRate();
				}
				if (j < right.size()) {
					tryThatOne = right.get(j).getHourlyRate();
				}
				break;		
			}			
			
			if ((i < left.size()) && (j < right.size()) && (sortType != HOURLY)) {
				if (thisOne.compareToIgnoreCase(thatOne) < 0) {
					finish.add(left.get(i));
					i += 1;
				} else if (thatOne.compareToIgnoreCase(thisOne) < 0) {
					finish.add(right.get(j));
					j += 1;
				}
			} else if ((i < left.size()) && (j < right.size()) && (sortType == HOURLY)) {
				
				if (tryThisOne < tryThatOne) {
					finish.add(left.get(i));
					i += 1;
				} else if (tryThatOne < tryThisOne) {
					finish.add(right.get(j));
					j += 1;
				}
			} else if (!(i < left.size())) {
				finish.add(right.get(j));
				j += 1;
			} else if (!(j < right.size())) {
				finish.add(left.get(i));
				i += 1;
			}
		}		
		return finish;
	}

	/**
	 * Method that goes through all employees in the list and adds their
	 * salaries up to return the total salaries.
	 * 
	 * @return The total of all Employees
	 */
	public double calcSalaries() {
		double totalSalary = 0;

		for (Employee emp : employees) {
			totalSalary += emp.getSalary();
		}
		return toTwoDecimalPlaces(totalSalary);
	}

	/**
	 * Method that calculates the total salary for all employees and divides it
	 * by the amount of employees in the list.
	 * 
	 * @return The Average of All Employees
	 */
	public double calcAverage() {
		double averageSalary = 0.0;
		
		//To prevent division by 0
		if (employees.size() > 0) {
			averageSalary = calcSalaries() / employees.size();
		}

		return toTwoDecimalPlaces(averageSalary);
	}

	/**
	 * Prints a message to indicate that the employees list doesn't contain any
	 * Managers and asks if the user would like to add one.
	 * 
	 */
	private void noManagersResponse() {
		StdOut.println("There are no Managers.");
		StdOut.println("Add Manager now (Y/N)?");
		String response = getString();
		if (response.equalsIgnoreCase("Y")) {
			addEmployee(3);
		}
	}

	//TODO Leaving Here incase employees.xml breaks
	  /*public void constructObjects() {
	 
	  Manager m1, m2; AdminWorker a1, a2, a3; SalesWorker s1, s2, s3;
	  
	  m1 = new Manager("Paul", "Murphy", 24.50); m2 = new Manager("Booker",
	  "DeWitt", 20.00);
	  
	  a1 = new AdminWorker("Jesse", "Pinkman", 12.00, 5); a2 = new
	  AdminWorker("Elizabeth", "Comstock", 13.50, 15); a3 = new
	  AdminWorker("Jimmy", "McNulty", 13, 50);
	  
	  s1 = new SalesWorker("Johnny", "Bravo", 11.75, 6); s2 = new
	  SalesWorker("Peregrin", "Took", 9.50, 12); s3 = new
	  SalesWorker("Samwell", "Tarly", 10.50, 12);
	  
	  // Adding Managers to the list last so a sort isn't // required (for now)
	 // when calculating wages. 
	  employees.add(s1); employees.add(s2);
	  employees.add(s3); employees.add(a1); employees.add(a2);
	  employees.add(a3); employees.add(m2); employees.add(m1);
	  
	  m1.getMinions().add(a1); a1.setHasManager(true); m1.getMinions().add(s1);
	  s1.setHasManager(true);
	  
	  m2.getMinions().add(a2); a2.setHasManager(true); m2.getMinions().add(s2);
	  s2.setHasManager(true); }*/
	//TODO
	
	
	/**
	 * Method to print an automated response when the employees list is empty.
	 * If the response is "y" then the user can add an employee.
	 * 
	 */
	private void noEmployeesResponse() {
		StdOut.println("No Employees in System!");
		StdOut.println("Add Employees now (y/n)?");
		String response = getString();
		if (response.equals("y")) {
			int option = addEmployeeMenu();
			addEmployee(option);
		}
	}

	/**
	 * Method that checks what type of employee an employee is. *
	 * 
	 * @return The type an employee is
	 */
	private int getType(Employee emp) {
		int type = 0;

		if (emp.getClass() == Manager.class) {
			type = 1;
		} else if (emp.getClass() == SalesWorker.class) {
			type = 2;
		} else if (emp.getClass() == AdminWorker.class) {
			type = 3;
		}
		return type;
	}

	/**
	 * Internal method to truncate a double to two decimal places
	 * 
	 * @param num
	 *            the double number to be trucated to two decimal places
	 * @return the double number truncated to two decimal places (does not round
	 *         up and down)
	 */
	private double toTwoDecimalPlaces(double num) {
		return (int) (num * 100) / 100.0;
	}
	
	/**
	 * Method to take a users input and then return it.
	 * If a mismatch exception is encountered then it's 
	 * caught and the user may try again.
	 * 
	 * @return The String That a user has entered
	 * @throws InputMismatchException
	 */
	private String getString() throws InputMismatchException {		 	
		try {			
			String output = StdIn.readLine();
			return output;
		} catch (InputMismatchException e){
			StdIn.readLine();
			StdOut.println("Not a String!");
			StdOut.println("Go again.");			
		}		
		return null;
	}
	
	/**
	 * Method that is used to take the input of a user
	 * and returns it. If an exception is thrown then it's 
	 * caught and the user gets another chance to enter in a
	 * number.
	 * 
	 * @return Returns the Double that a user enters
	 * @throws InputMismatchException
	 */
	private double getDouble() throws InputMismatchException {		
		
		try {
			double output = StdIn.readDouble();	
			return output;
		} catch (InputMismatchException e) {
			StdIn.readLine();
			StdOut.println("Not a Double!");
			StdOut.println("Go again.");			
		}		
		return -1; 
	}	
	
	/**
	 * Method that is used to take the input of a user
	 * and return it. If an error is encountered then it's 
	 * caught and the user gets another chance to enter in a
	 * number.
	 * 
	 * @return The integer that the user enters
	 * @throws InputMismatchException
	 */
	private int getInt() throws InputMismatchException {		
		
		try {
			int output = StdIn.readInt();			
			return output;
		} catch (InputMismatchException e) {
			StdIn.readLine();
			StdOut.println("Not an int!");
			StdOut.println("Go again.");			
		}		
		return -1;
	}

}
