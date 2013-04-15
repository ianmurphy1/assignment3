/**
 * @author Ian
 * 
 */
public abstract class Employee
{

	final static double NORMAL_WORKWEEK = 39.5;

	private String firstName;
	private String lastName;
	private double hourlyRate;
	private double numHours;
	private double salary;
	private boolean hasManager;
	
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param hourlyRate
	 */
	public Employee(String firstName, String lastName, double hourlyRate) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		if (hourlyRate >= 0) {
			this.hourlyRate = hourlyRate;
		} else {
			this.hourlyRate = 0;
		}
		
		this.numHours = 0;
		
		this.salary = 0;
		
		this.hasManager = false;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the hourlyRate
	 */
	public double getHourlyRate() {
		return this.hourlyRate;
	}

	/**
	 * @param hourlyRate
	 *            the hourlyRate to set
	 */
	public void setHourlyRate(double hourlyRate) {
		if (hourlyRate >= 0) {
			this.hourlyRate = toTwoDecimalPlaces(hourlyRate);
		}
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return this.salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		if (salary >= 0) {
			this.salary = toTwoDecimalPlaces(salary);
		}
	}

	/**
	 * @return the numHours
	 */
	public double getNumHours() {
		return this.numHours;
	}

	/**
	 * @param numHours the numHours to set
	 */
	public void setNumHours(double numHours) {
		if (numHours >= 0) {
			this.numHours = toTwoDecimalPlaces(numHours);
		}
	}

	/**
	 * @return the hasManager
	 */
	public boolean hasManager() {
		return this.hasManager;
	}

	/**
	 * @param hasManager the hasManager to set
	 */
	public void setHasManager(boolean hasManager) {
		this.hasManager = hasManager;
	}

	/**
	 * @param numHours
	 * @return
	 */
	public double calculateSalary(double numHours) {
		
		if (numHours >= 0) {
			if (numHours <= NORMAL_WORKWEEK) {
				this.salary = numHours * this.hourlyRate;
			} else if (numHours > NORMAL_WORKWEEK) {
				this.salary = (NORMAL_WORKWEEK * this.hourlyRate)
						+ calculateOvertime(numHours);
			}
			
			//If changing every time calSal() is called
			this.setNumHours(numHours);
			
			//If a running total of all hours worked is to be done
			//double newTotal = (this.getNumHours() + numHours);
			//this.setNumHours(newTotal);						
		}
		return toTwoDecimalPlaces(this.salary);
	}

	/**
	 * @param numHours
	 * @return
	 */
	private double calculateOvertime(double numHours) {
		double overtime;
		overtime = ((numHours - NORMAL_WORKWEEK) * (this.hourlyRate * 2));
		return toTwoDecimalPlaces(overtime);
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "First Name: " + this.firstName + "\n" 
	         + "Last Name: " + this.lastName + "\n"
			 + "Hourly Rate: E" + this.hourlyRate + "\n"
			 + "Worked " + this.numHours + " Hours Last Week.\n" ;
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
