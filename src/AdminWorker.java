
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
	 *  
	 * @param firstName Admin Worker's 1st Name
	 * @param lastName Admin Worker's Surname
	 * @param hourlyRate Admin Worker's Hourly Rate
	 * @param bonus Admin Worker's Fixed Bonus
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
	 * A method that returns the Fixed Bonus of an Admin Worker.
	 * 
	 * @return Admin Worker's Fixed Bonus
	 */
	public double getBonus() {
		return bonus;
	}

	/**
	 * Setter that allows the bonus of an admin worker to
	 * be changed, must be above 0.
	 * 
	 * @param bonus Admin Worker's new fixed bonus.
	 */
	public void setBonus(double bonus) {
		if (bonus >= 0) {
			this.bonus = bonus;
		}
	}
	
	/**
	 * Method that calculates the salary of an admin worker.
	 *
     */
	@Override
    public double calculateSalary() {
		
		double tempSal = 0;
		double tempHours = this.getHoursWorked();
		
		if (tempHours > 0) {
			tempSal = (super.calculateSalary() + this.bonus);			
		} 
		
        this.setSalary(tempSal);
		
		return this.getSalary();
	}

	/** 
	 * Method that returns the information specific to an employee
	 * of type Admin Worker in string form.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee Type: AdminWorker" + "\n" + super.toString()  
			 + "Bonus: E" + this.bonus;
	}
}
