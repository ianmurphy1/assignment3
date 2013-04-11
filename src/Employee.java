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
	private double salary;

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
		
		this.salary = 0;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
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
		return lastName;
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
		return hourlyRate;
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
		return salary;
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
	 * @param numHours
	 * @return
	 */
	public double calculateSalary(double numHours) {
		
		if (numHours >= 0) {
			if (numHours <= NORMAL_WORKWEEK) {
				salary = numHours * hourlyRate;
			} else if (numHours > NORMAL_WORKWEEK) {
				salary = (NORMAL_WORKWEEK * hourlyRate)
						+ calculateOvertime(numHours);
			}
		}
		return toTwoDecimalPlaces(salary);
	}

	/**
	 * @param numHours
	 * @return
	 */
	private double calculateOvertime(double numHours) {
		double overtime;
		overtime = ((numHours - NORMAL_WORKWEEK) * (hourlyRate * 2));
		return toTwoDecimalPlaces(overtime);
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "First Name: " + firstName + "/n" 
	         + "Last Name: " + lastName + "/n"
			 + "Hourly Rate: " + hourlyRate;
	}
	
	/**
     * Internal method to truncate a double to two decimal places
     * 
     * @param num the double number to be trucated to two decimal places
     * @return the double number truncated to two decimal
     *         places (does not round up and down)
     */
    public double toTwoDecimalPlaces(double num)
    {
        return (int) (num * 100) / 100.0;
    }
}
