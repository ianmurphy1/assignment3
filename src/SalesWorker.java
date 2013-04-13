
/**
 * @author Ian
 *
 */
public class SalesWorker extends Employee {

	private double perfBonus;
	private boolean hasManager;
	
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
		this.hasManager = false;
	}

	/**
	 * @return the perfBonus
	 */
	public double getPerfBonus() {
		return perfBonus;
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
	 * @return the hasManager
	 */
	public boolean hasManager() {
		return hasManager;
	}

	/**
	 * @param hasManager the hasManager to set
	 */
	public void setHasManager(boolean hasManager) {
		this.hasManager = hasManager;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Employee#calculateSalary(double)
	 */
	@Override
	public double calculateSalary(double numHours) {
		double tempSal = 0;
		
		if (numHours > 0) {
			tempSal = super.calculateSalary(numHours) * (1 + (perfBonus / 100));
		}
		
		this.setSalary(tempSal);
		
		return this.getSalary();		
	}	
	

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee Type: SalesWorker" + "/n" + super.toString() + "/n" 
	         + "Performance Bonus: " + perfBonus;
	}

}
