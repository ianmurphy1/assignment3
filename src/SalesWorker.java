
/**
 * @author Ian Murphy
 *
 */
public class SalesWorker extends Employee {

	private double perfBonus;
	private double monthlySales;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param hourlyRate
	 * @param perfBonus
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
	 * @param perfBonus the perfBonus to set
	 */
	public void setPerfBonus(double perfBonus) {
		if(perfBonus >= 0 && perfBonus <= 20) {
			this.perfBonus = perfBonus;
		}
	}

	/**
	 * @return the perfBonus
	 */
	public double getPerfBonus() {
		return this.perfBonus;
	}

	/**
	 * @param monthlySales the monthlySales to set
	 */
	public void setMonthlySales(double monthlySales) {
		this.monthlySales = monthlySales;
	}

	/**
	 * @return the monthlySales
	 */
	public double getMonthlySales() {
		return this.monthlySales;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Employee#calculateSalary(double)
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
	

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee Type: SalesWorker" + "\n" + super.toString() 
	         + "Performance Bonus: " + this.perfBonus + "%";
	}

}
