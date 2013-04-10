import java.util.ArrayList;


/**
 * @author Ian
 *
 */
public class Driver
{
	private ArrayList<Employee> employees;
	
	/**
	 * 
	 */
	public Driver() {
		this.employees = new ArrayList<Employee>();
	}

	/**
	 * @return the employees
	 */
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}	
	
}
