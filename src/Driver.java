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
		app.load();
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

		int option = StdIn.readInt();
		StdIn.readLine();

		return option;
	}

	/**
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

		int adminOption = StdIn.readInt();
		StdIn.readLine();

		return adminOption;
	}

	/**
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

		int addMenuOption = StdIn.readInt();
		StdIn.readLine();

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
		String firstName = StdIn.readLine();
		StdOut.println("Enter Employee's Surname: ");
		String lastName = StdIn.readLine();

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
		double hourlyRate = StdIn.readDouble();
		StdIn.readLine();

		switch (choice) {
		case 1:
			StdOut.println("Enter fixed bonus amount: ");
			double fixedBonus = StdIn.readDouble();
			StdIn.readLine();
			AdminWorker admin = new AdminWorker(firstName, lastName,
					hourlyRate, fixedBonus);
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
	 * 
	 */
	public void editEmployee() {

		if (employees.size() > 0) {
			listEmployees(1);
			StdOut.println("Choose Index of Employee to Edit: ");
			int index = StdIn.readInt();
			StdIn.readInt();
			if ((index >= 0) && (index >= employees.size())) {
				Employee emp = employees.get(index);
				String firstName = null;
				String lastName = null;
				int type = getType(emp);

				StdOut.println("Do you want to edit 1st name (Y/N)?");
				String firstResponse = StdIn.readString();
				StdIn.readLine();
				if (firstResponse.equalsIgnoreCase("Y")) {
					StdOut.println("Enter new First Name: ");
					firstName = StdIn.readLine();
				}

				StdOut.println("Do you want to edit last name (Y/N)?");
				String secondResponse = StdIn.readString();
				StdIn.readLine();
				if (secondResponse.equalsIgnoreCase("Y")) {
					StdOut.println("Enter new Last Name: ");
					lastName = StdIn.readLine();
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
				String rateResponse = StdIn.readString();
				StdIn.readLine();
				if (rateResponse.equalsIgnoreCase("Y")) {
					StdOut.println("Enter New Hourly Rate: ");
					double hourlyRate = StdIn.readDouble();
					StdIn.readLine();
					if (hourlyRate >= 0) {
						emp.setHourlyRate(hourlyRate);
					} else {
						StdOut.println("Number needs to greater than 0!");
						StdOut.println("Enter New Value: ");
						hourlyRate = StdIn.readDouble();
						StdIn.readLine();
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
					String salesResponse = StdIn.readString();
					StdIn.readLine();
					if (salesResponse.equalsIgnoreCase("Y")) {
						double perfBonus = StdIn.readDouble();
						if ((perfBonus >= 0) && (perfBonus <= 20)) {
							salesEmp.setPerfBonus(perfBonus);
						} else {
							StdOut.println("Number needs to greater than 0 ");
							StdOut.print("and less than or equal to 20!");
							StdOut.println("Enter New Value: ");
							perfBonus = StdIn.readDouble();
							StdIn.readLine();
							salesEmp.setHourlyRate(perfBonus);
						}
					}
					StdOut.println("---Employee's New Info---");
					StdOut.println(salesEmp);
					break;
				case 3:
					AdminWorker adminEmp = (AdminWorker) emp;
					StdOut.println("Do you want to edit fixed bonus (Y/N)?");
					String adminResponse = StdIn.readString();
					StdIn.readLine();
					if (adminResponse.equalsIgnoreCase("Y")) {
						double bonus = StdIn.readDouble();
						if (bonus >= 0) {
							adminEmp.setBonus(bonus);
						} else {
							StdOut.println("Number needs to greater than 0!");
							StdOut.println("Enter New Value: ");
							bonus = StdIn.readDouble();
							StdIn.readLine();
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
	 * 
	 */
	public void deleteEmployee() {

		if (employees.size() > 0) {

			listEmployees(1);
			StdOut.println("Choose Index of Employee to delete: ");
			int delChoice = StdIn.readInt();
			StdIn.readInt();

			if (delChoice >= 0 && delChoice >= employees.size()) {
				StdOut.println("Are you sure you want to delete? (y/n)");
				String response = StdIn.readString();
				StdIn.readLine();

				Employee delThis = employees.get(delChoice);

				// Checking to see if employee is in a managers list
				// If he is, removed from that too
				if (response.equalsIgnoreCase("y")) {

					if (employees.get(delChoice).hasManager()) {
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
					listEmployees(1);
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
	 * @return
	 */
	private int printMenu() {
		StdOut.println("------------------------");
		StdOut.println("SORT AND PRINT MENU");
		StdOut.println("------------------------");
		StdOut.println();
		StdOut.println("---- Sort and Print ----");
		StdOut.println("----  Employees In  ----");
		StdOut.println("-- Ascending Order By --");
		StdOut.println();
		StdOut.println("1 - First Name");
		StdOut.println("2 - Surname");
		StdOut.println("3 - Hourly Rate");
		StdOut.println("-------------------");
		StdOut.println("0 - Exit");

		int printOption = StdIn.readInt();
		StdIn.readLine();

		return printOption;
	}

	/**
	 * @param printOption
	 */
	public void printBy(int printOption) {

		ArrayList<Employee> temp = null;

		switch (printOption) {
		case 1:
			temp = sort(printOption);
			break;
		case 2:
			temp = sort(printOption);
			break;
		case 3:
			temp = sort(printOption);
		}

		for (Employee emp : temp) {
			StdOut.println(emp);
			StdOut.println();
		}
	}

	/**
	 * @return
	 */
	private int searchMenu() {
		StdOut.println("-------------");
		StdOut.println("SEARCH MENU");
		StdOut.println("-------------");
		StdOut.println("1 - Search Company");
		StdOut.println("2 - Search a Manager");
		StdOut.println("-------------------");
		StdOut.println("0 - Exit");

		int searchOption = StdIn.readInt();
		StdIn.readLine();

		return searchOption;
	}

	/**
	 * @param searchOption
	 */
	public void searchBy(int searchOption) {
		int position = 0;
		boolean found = false;
		StdOut.println("----Searching----");
		String searchString = null;

		switch (searchOption) {
		// Searching All Employees
		case 1:
			StdOut.println("Enter Search Term:");
			searchString = (StdIn.readLine()).toLowerCase();

			for (Employee employee : employees) {
				String fullName = (employee.getFirstName() + employee
						.getLastName()).toLowerCase();

				if (fullName.contains(searchString)) {
					found = true;
					StdOut.println(employee.getFirstName() + " found.");
					StdOut.println("Location is: " + position);
				}
				position++;
			}
			if (!found) {
				StdOut.println("No Matches Found!");
			}
			break;
		// Searching in a Manager
		case 2:
			listManagers();
			StdOut.println("Choose Index of Manager to Search: ");
			int index = StdIn.readInt();
			StdIn.readLine();
			if ((index >= 0) && (index < employees.size())) {

				int type = getType(employees.get(index));

				if (type == 1) {
					Manager manager = (Manager) employees.get(index);
					StdOut.println("Enter Search Term: ");
					searchString = (StdIn.readLine()).toLowerCase();

					for (Employee emp : manager.getMinions()) {
						String fullName = (emp.getFirstName() + emp
								.getLastName()).toLowerCase();

						if (fullName.contains(searchString)) {
							found = true;
							StdOut.println(emp.getFirstName() + " found.");
							StdOut.println("Location is: " + position);
						}
						position++;
					}
					if (!found) {
						StdOut.println("No Matches Found!");
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
	}

	/**
	 * @return User's choice to carry out
	 */
	private int accountMenu() {
		StdOut.println("-------------------");
		StdOut.println("ACCOUNTS MENU");
		StdOut.println("-------------------");
		StdOut.println("1 - Calculate An Employee's Salary");
		StdOut.println("2 - Calculate All Employee's Salaries");
		StdOut.println("3 - Calculate Average Salary");
		StdOut.println("-------------------");
		StdOut.println("0 - Exit");

		int accountOption = StdIn.readInt();
		StdIn.readLine();

		return accountOption;
	}

	/**
	 * 
	 */
	public void printSalary() {
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

			StdOut.println(tempEmp.getFirstName() + "'s Salary is: €");
			StdOut.print(tempEmp.calculateSalary(hours));
			StdOut.println("After " + hours + " work.");

		} else {
			StdOut.println("Invalid Index!");
			printSalary();
		}
	}

	/**
	 * 
	 */
	public void printSalaries() {
		StdOut.println("This will only take into account the salaries that"
				+ " have already been individually calculated.");
		StdOut.println("Total Salary: E" + calcSalaries());
	}

	/**
	 * 
	 */
	public void printAverage() {
		StdOut.println("This will only take into account the salaries that"
				+ " have already been individually calculated.");
		StdOut.println("Average Salary for " + employees.size() + " people: ");
		StdOut.print(calcAverage());
	}

	/**
	 * @return
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

		int manMenuOption = StdIn.readInt();
		StdIn.readLine();

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
			int managerIndex = StdIn.readInt();
			StdIn.readLine();

			if ((managerIndex >= 0) && (managerIndex < employees.size())) {

				if (employees.get(managerIndex).getClass() == Manager.class) {
					manager = (Manager) employees.get(managerIndex);

					StdOut.println("Choose Employee To Add:");
					listEmployees(2);
					int empIndex = StdIn.readInt();
					StdIn.readLine();

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
			int managerIndex = StdIn.readInt();
			StdIn.readLine();

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
	 * 
	 */
	public void delFromManger() {
		if (employees.size() > 0) {
			Manager manager = null;

			listManagers();
			StdOut.println("Choose Manager to delete employee from: ");
			int managerIndex = StdIn.readInt();
			StdIn.readLine();

			if ((managerIndex >= 0) && (managerIndex < employees.size())) {

				int type = getType(employees.get(managerIndex));

				if (type == 1) {
					manager = (Manager) employees.get(managerIndex);

					StdOut.println("Choose Index of Employee To Remove:");
					listMinions(manager);
					int empIndex = StdIn.readInt();
					StdIn.readLine();

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

		int saveLoadOption = StdIn.readInt();
		StdIn.readLine();

		return saveLoadOption;
	}

	/**
	 * Method that saves the employees list and outputs it as an xml
	 * file which holds all the data.
	 * 
	 */
	public void save() {
		StdStream.saveToFile(employees, "employees.xml");
	}

	/**
	 * Method that loads the data stored in the employees.xml
	 * and sets the employees arraylist to be it.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void load() {
		this.employees = (ArrayList<Employee>) StdStream
				.readFromFile("employees.xml");
	}

	/**
	 * Method that takes in a manager and prints the list of 
	 * employees he has in his list.
	 * 
	 * @param manager Manager's whose minions is to be printed
	 */
	public void listMinions(Manager manager) {
		int index = 0;

		for (Employee emp : manager.getMinions()) {
			StdOut.println(emp + "\nIndex at: " + index);
			index += 1;
		}
	}

	/**
	 * Method that lists employees, depending on the value passed in 
	 * it will print all the employees in the array list or it only print
	 * those employees that aren't Managers.
	 * 
	 * @param type
	 *            Type of Employees to List, 1 = All, 2 Removes Managers
	 */
	public void listEmployees(int option) {
		if (employees.size() > 0) {
			StdOut.println("--------------");
			StdOut.println("EMPLOYEE LIST");
			StdOut.println("--------------");
			for (int index = 0; index < employees.size(); index += 1) {

				Employee emp = employees.get(index);

				int type = getType(emp);

				if (option == 1) {
					StdOut.println("Index: " + index + "\n"
							+ employees.get(index) + "\n");
				} else if ((option == 2) && !(type == 1)) {
					StdOut.println("Index: " + index + "\n"
							+ employees.get(index) + "\n");
				}
			}
			StdOut.println("-----------");
		} else {
			noEmployeesResponse();
		}
	}

	/**
	 * Method that lists all the managers inside employees if there is
	 * any managers in it.
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
						StdOut.println("Index: " + index + "\n" + potentMan
								+ "\n");
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

			// TODO Find out if instanceof or .getClass() is better

			if (type == 1) {
				temp.add((Manager) potentMan);
			}
		}
		return temp;
	}

	/**
	 * Method that sorts through employees based on the option
	 * specified by the user from the menu system, and returns the
	 * sorted list as an array.
	 * 
	 * @param option
	 *            The type of sorting to happen
	 * @return A sorted ArrayList of the type specified
	 */
	public ArrayList<Employee> sort(int option) {

		ArrayList<Employee> temp = employees;
		Employee emp = null;

		for (int i = 0; i < temp.size(); i += 1) {
			for (int j = (i + 1); j < temp.size(); j += 1) {
				switch (option) {
				// Sorting by First Name
				case 1:
					if ((temp.get(j).getFirstName()).compareToIgnoreCase(temp
							.get(i).getFirstName()) < 0) {

						emp = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, emp);
					}
					break;
				// Sorting By Surname
				case 2:
					if ((temp.get(j).getLastName()).compareToIgnoreCase(temp
							.get(i).getLastName()) < 0) {

						emp = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, emp);
					}
					break;
				// Sorting by Hourly Rate
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
		return temp;
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

		averageSalary = calcSalaries() / employees.size();

		return toTwoDecimalPlaces(averageSalary);
	}

	/**
	 * Prints a message to indicate that the employees list doesn't contain
	 * any Managers and asks if the user would like to add one.
	 * 
	 */
	private void noManagersResponse() {
		StdOut.println("There are no Managers.");
		StdOut.println("Add Manager now (Y/N)?");
		String response = StdIn.readString();
		StdIn.readLine();
		if (response.equalsIgnoreCase("Y")) {
			addEmployee(3);
		}
	}

	/**
	 * Method to print an automated response when the employees list is empty.
	 * If the response is "y" then the user can add an employee.
	 * 
	 */
	private void noEmployeesResponse() {
		StdOut.println("No Employees in System!");
		StdOut.println("Add Employees now (y/n)?");
		String response = StdIn.readString();
		StdIn.readLine();
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

}
