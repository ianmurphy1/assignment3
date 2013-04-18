
/**
 * 
 * Class that stores information that is specific to a 
 * SalesWorker object. This class is sub-class of the Employee super class.
 * 
 * @author Ian Murphy
 *
 */
public class SalesWorker extends Employee {

	private double perfBonus;
	private double monthlySales;
	
	/**
	 * Constructor for Objects of class SalesWorker.
	 * 
	 * @param firstName Sales Woker's First Name
	 * @param lastName Sales Woker's Last Name
	 * @param hourlyRate Sales Woker's Hourly Rate
	 * @param perfBonus Sales Woker's Performance Bonus
	 */
	public SalesWorker(String firstName, String lastName, double hourlyRate, double perfBonus) {
		super(firstName, lastName, hourlyRate);	
		if(perfBonus >= 0 && perfBonus <= 20) {
			this.perfBonus = perfBonus;
		} else {
			this.perfBonus = 0;
		}
		this.monthlySales = 0;
	}

	/**
	 * Method that allows the performance bonus of a SalesWorker
	 * to changed. Bonus has to be above 0 and is limited to being 
	 * greater than 20%.
	 * 
	 * @param perfBonus New performance bonus.
	 */
	public void setPerfBonus(double perfBonus) {
		if(perfBonus >= 0 && perfBonus <= 20) {
			this.perfBonus = perfBonus;
		}
	}

	/**
	 * Getter that is used to return the Sales Worker's Bonus.
	 * 
	 * @return The SalesWorker's %Bonus
	 */
	public double getPerfBonus() {
		return perfBonus;
	}

	/**
	 * Setter that allows the changing of the amount of
	 * monthly sales a Sales Worker Carries out.
	 * 
	 * @param monthlySales New Monthly Sales Amount
	 */
	public void setMonthlySales(double monthlySales) {
		this.monthlySales = monthlySales;
	}

	/**
	 * Getter that returns the amount of sales that a Sales Worker 
	 * has carried out.
	 * 
	 * @return the monthlySales
	 */
	public double getMonthlySales() {
		return monthlySales;
	}

	/**
	 * Method that calculates and returns the salary of the 
	 * Sales Worker.
	 * 
	 * @see Employee#calculateSalary()
	 */
	@Override
	public double calculateSalary() {
		double tempSal = 0;	
		
		double tempHours = this.getHoursWorked();
		
		if (tempHours > 0) {
			tempSal = super.calculateSalary() * (1 + (this.perfBonus / 100));
		}
		
		this.setSalary(tempSal);
		
		return this.getSalary();		
	}	
	

	/** 
	 * Method used to return the information about an Employee
	 * as a String.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee Type: SalesWorker" + "\n" + super.toString() 
	         + "Performance Bonus: " + this.perfBonus + "%";
	}

}
