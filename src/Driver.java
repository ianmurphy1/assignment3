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
					printByFirst();
					break;
				case 2:
					printByLast;
					break;
				case 3:
					printByRate();
					break;				
				}
				break;

			// Account Menu
			case 3:
				int accountOption = accountMenu();
				switch (accountOption) {
				case 1:
					calcIndSalary();
					break;
				case 2:
					calcAllSalary();
					break;
				case 3:
					calcAllAverage();
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
    private double toTwoDecimalPlaces(double num)
    {
        return (int) (num * 100) / 100.0;
    }
	
}
