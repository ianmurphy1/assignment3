/**
 * The employees class represents an Employee.
 * Information about an Employee is stored and retrieved from here.
 * This class works as a super class for other more specific employees.
 * 
 * @author Ian Murphy
 * 
 */
public abstract class Employee
{
	//Assignment Specified Fields

	final static double NORMAL_WORKWEEK = 39.5;	
	
   	private String firstName;	
	private String lastName;	
	private double hourlyRate;	
	private double hoursWorked;	
	
	//My Own
	private double salary;
	private boolean hasManager;
	
	
	/**
	 * Contructor for objects of class employee.
	 * 
	 * @param firstName Employees First Name
	 * @param lastName Employee's Surname
	 * @param hourlyRate Employee's Hourly Rate
	 */
	public Employee(String firstName, String lastName, double hourlyRate) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		if (hourlyRate >= 0) {
			this.hourlyRate = hourlyRate;
		} else {
			this.hourlyRate = 0;
		}
		
		this.hoursWorked = 0;
		
		this.salary = 0;
		
		this.hasManager = false;
	}

	/**
	 * Getter that reurns the employee's 1st name.
	 * 
	 * @return The Employee's First Name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter that allows the changing of the employee's 
	 * 1st name.
	 * 
	 * @param firstName
	 *            The First Name to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter that returns the Employee's last Name
	 * 
	 * @return Employee's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter that can be used to change the last name of 
	 * the employee.
	 * 
	 * @param lastName New Last Name to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter Used to return the Hourly Rate that the employee has.
	 * 
	 * @return Employee's Hourly Rate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * Mutator that allows the Hourly Rate of an employee to 
	 * be changed, must be set to above 0.
	 * 
	 * @param hourlyRate The Employee's New Hourly Rate
	 */
	public void setHourlyRate(double hourlyRate) {
		if (hourlyRate >= 0) {
			this.hourlyRate = toTwoDecimalPlaces(hourlyRate);
		}
	}

	/**
	 * A getter that returns the salary of an employee.
	 * 
	 * @return Employee's Salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Setter to change the salary of the employee.
	 * 
	 * @param salary Employee's new salary.
	 */
	public void setSalary(double salary) {
		if (salary >= 0) {
			this.salary = toTwoDecimalPlaces(salary);
		}
	}

	/**
	 * Getter that returns the amount of hours an employee has 
	 * worked.
	 * 
	 * @return Number of Hours and Employee has worked.
	 */
	public double getHoursWorked() {
		return hoursWorked;
	}

	/**
	 * Setter that changes the number of hours that an employee
	 * has worked.
	 * 
	 * @param numHours the numHours to set
	 */
	public void setHoursWorked(double numHours) {
		if (numHours >= 0) {
			this.hoursWorked = toTwoDecimalPlaces(numHours);
		}
	}

	/**
	 * Accessor method that returns whether or not an employee
	 * has a manager. 
	 * 
	 * @return Whether an Employee has a manager.
	 */
	public boolean hasManager() {
		return hasManager;
	}

	/**
	 * Mutator that allows the changing of whether an employee
	 * has a manager or not.
	 * 
	 * @param hasManager Whether an Employee has a manager.
	 */
	public void setHasManager(boolean hasManager) {
		this.hasManager = hasManager;
	}

	/**
	 * Method that calculates an Employees basic salary
	 * based on the number hours that they work. 
	 *  
	 * @return The calculated value of an employee.
	 */
	public double calculateSalary() {
		
		if (hoursWorked >= 0) {
			if (hoursWorked <= NORMAL_WORKWEEK) {
				salary = hoursWorked * hourlyRate;
			} else if (hoursWorked > NORMAL_WORKWEEK) {
				salary = (NORMAL_WORKWEEK * hourlyRate)
						+ calculateOvertime();
			}					
		}
		return toTwoDecimalPlaces(salary);
	}

	/**
	 * Method that will calculate the amount to be added 
	 * on to an Employee's salary. Only called when an Employee's 
	 * work week is greater than 39.5 Hours.
	 * 
	 * @return Salary due to overtime.
	 */
	private double calculateOvertime() {
		double overtime;
		overtime = ((hoursWorked - NORMAL_WORKWEEK) * (hourlyRate * 2));
		return toTwoDecimalPlaces(overtime);
	}

	/** 
	 * Method that returns all infor about an Employee in String Form
	 */
	@Override
	public String toString() {
		return "First Name: " + firstName + "\n" 
	         + "Last Name: " + lastName + "\n"
			 + "Hourly Rate: E" + hourlyRate + "\n"
			 + "Worked " + hoursWorked + " Hours Last Week.\n" ;
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
