import java.util.ArrayList;


/**
 * @author Ian Murphy
 *
 */
public class Manager extends Employee {
	
	private ArrayList<Employee> minions;	

	/**
	 * @param firstName
	 * @param lastName
	 * @param hourlyRate
	 */
	public Manager(String firstName, String lastName, double hourlyRate) {
		super(firstName, lastName, hourlyRate);
		this.minions = new ArrayList<Employee>();		
	}

	/**
	 * @return the employees
	 */
	public ArrayList<Employee> getMinions() {
		return this.minions;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setMinions(ArrayList<Employee> minions) {
		this.minions = minions;
	}
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see Employee#calculateSalary(double)
	 */
	public double calculateSalary() {

		double managerBonus = 0.0;		
		double tempSal = 0.0;	
		double tempHours = this.getHoursWorked();
		
		if (tempHours > 0) {
			
			for (Employee minion : this.minions) {
				managerBonus += (minion.getSalary() * 0.01);			
			}
			
			tempSal = (super.calculateSalary() + managerBonus);			
		} 
		
        this.setSalary(tempSal);
		
		return this.getSalary();
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee Type: Manager" + "\n" + super.toString() 
			 + "Over " + this.minions.size() + " Employees";
	}
}
