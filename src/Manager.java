import java.util.ArrayList;


/**
 * Class that stores information that is specific to a Manager object. 
 * This class is sub-class of the Employee super class.
 * 
 * @author Ian Murphy
 *
 */
public class Manager extends Employee {
	
	private static final double MAN_BONUS = 0.01;
	
	//List to contain employees that a manager is over
	private ArrayList<Employee> minions;	

	/**
	 * @param firstName Manager's First Name
	 * @param lastName Manager's Last Name
	 * @param hourlyRate Manager's Hourly Rate
	 */
	public Manager(String firstName, String lastName, double hourlyRate) {
		super(firstName, lastName, hourlyRate);
		this.minions = new ArrayList<Employee>();		
	}

	/**
	 * Method that returns the List of employees the manager
	 * is over.
	 * 
	 * @return The List containing Employees.
	 */
	public ArrayList<Employee> getMinions() {
		return minions;
	}

	/**
	 * Method that allows the changing of the Manager's list of 
	 * employees.
	 * 
	 * @param employees The new list to set.
	 */
	public void setMinions(ArrayList<Employee> minions) {
		this.minions = minions;
	}
	
	/**
	 * Method that is used to calculate the salary of an
	 * Employee of type Manager by adding the specific bonus to
	 * that type of Employee onto the calculateSalary() method 
	 * contained in the Employee class.
	 * 
	 * @see Employee#calculateSalary()
	 */
	public double calculateSalary() {

		double managerBonus = 0.0;		
		double tempSal = 0.0;	
		double tempHours = this.getHoursWorked();
		
		if (tempHours > 0) {			
			for (Employee minion : minions) {
				managerBonus += (minion.getSalary() * MAN_BONUS);			
			}			
			tempSal = (super.calculateSalary() + managerBonus);				
		} 
		
        this.setSalary(tempSal);
        
		return this.getSalary();
	}

	/**
	 * Method that returns all the information about a Manager
	 * in String form.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee Type: Manager" + "\n" 
	          + super.toString() 
			  + "Over " + this.minions.size() + " Employees";
	}
}
