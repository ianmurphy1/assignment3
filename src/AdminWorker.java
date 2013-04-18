
/**
 * Class that represents AdminWorker objects, information specific
 * to objects of type AdminWorker can be stored and retrieved from here.
 * 
 * @author Ian Murphy
 *
 */
public class AdminWorker extends Employee {
	
	private double bonus;

	/**
	 * Constructor for objects of class AdminWorker
	 * Is a sub-class of Employee.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param hourlyRate
	 * @param bonus
	 */
	public AdminWorker(String firstName, String lastName, double hourlyRate, double bonus) {
		super(firstName, lastName, hourlyRate);	
		if (bonus >= 0) {
			this.bonus = bonus;
		} else {
			bonus = 0.0;
		}
	}

	/**
	 * @return the bonus
	 */
	public double getBonus() {
		return this.bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(double bonus) {
		if (bonus >= 0) {
			this.bonus = bonus;
		}
	}
	
	/** (non-Javadoc)
	 * @see Employee#calculateSalary(double)
	 */
	public double calculateSalary() {
		
		double tempSal = 0;
		double tempHours = this.getHoursWorked();
		
		if (tempHours > 0) {
			tempSal = (super.calculateSalary() + this.bonus);			
		} 
		
        this.setSalary(tempSal);
		
		return this.getSalary();
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee Type: AdminWorker" + "\n" + super.toString()  
			 + "Bonus: E" + this.bonus;
	}
}
