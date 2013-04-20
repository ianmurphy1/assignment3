import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	ArrayList<Employee> employees;
	List<Employee> merged;
	public MergeSort() {
		this.employees = new ArrayList<Employee>();
	}
	
	public static void main(String[] args) {
		MergeSort app = new MergeSort();
		app.load();
		app.run();
	}
	
	public void run() {
		merged = new ArrayList<Employee>(newSort(employees, 1));
		
		printList(merged);	
		printList(employees);
	}

	private void printList(List<Employee> merged) {		
		for (Employee emp: merged) {
			StdOut.println();
			StdOut.println(emp);
			StdOut.println("Index: " + employees.indexOf(emp));
			}
	}

	/**
	 * 1st part of the merge/sort, this part takes in the list
	 * to be sorted and splits into 2 parts recursively. Then it calls 
	 * the merge part of the system to sort and stitch all the lists together 
	 * and returns it as a sorted list based on the type that was passed
	 * into it at the start.
 	 * 
	 * @param emps List of Employees To Sort
	 * @param sortType Type of sort to be carried out
	 * @return List of Sorted Employees
	 */
	public List<Employee> newSort(List<Employee> emps, int sortType) {		
		
		if (emps.size() > 1) {
			int half = (emps.size() / 2);
			
			List<Employee> left = emps.subList(0, half);
			List<Employee> right = emps.subList(half, emps.size());
								
			return mergeSort(newSort(left, sortType), newSort(right, sortType), sortType);
		} else {
			return emps;
		}	
	}
	
	/**
	 * Merging and sorting part of the sort that takes the split lists from
	 * the newSort() method, sorts them and then returns the completed list
	 * back to the newSort().
	 * 
	 * @param left The left hand side of the List
	 * @param right Right Hand side of List
	 * @param sortType The type of sorting to do
	 * @return The merged list.
	 */
	public List<Employee> mergeSort(List<Employee> left, List<Employee> right, int sortType) {
		
		ArrayList<Employee> finish = new ArrayList<Employee>();
		
		int sizeCount = (left.size() + right.size());		
		
		String thisOne = "";
		String thatOne = "";
		double tryThisOne = 0;
		double tryThatOne = 0;
		int i = 0;
		int j = 0;
		
		for (int counter = 0; counter < sizeCount; counter += 1) {
			switch (sortType) {
			case 1:
				if (i < left.size()) {
					thisOne = left.get(i).getFirstName();
				}
				if (j < right.size()) {
					thatOne = right.get(j).getFirstName();
				}				
				break;
			case 2:
				if (i < left.size()) {
					thisOne = left.get(i).getLastName();
				}
				if (j < right.size()) {
					thatOne = right.get(j).getLastName();
				}				
				break;
			case 3:				
				if (i < left.size()) {
					tryThisOne = left.get(i).getHourlyRate();
				}
				if (j < right.size()) {
					tryThatOne = right.get(j).getHourlyRate();
				}
				break;		
			}			
			
			if ((i < left.size()) && (j < right.size()) && (sortType != 3)) {
				if (thisOne.compareToIgnoreCase(thatOne) < 0) {
					finish.add(left.get(i));
					i += 1;
				} else if (thatOne.compareToIgnoreCase(thisOne) < 0) {
					finish.add(right.get(j));
					j += 1;
				}
			} else if ((i < left.size()) && (j < right.size()) && (sortType == 3)) {
				
				if (tryThisOne < tryThatOne) {
					finish.add(left.get(i));
					i += 1;
				} else if (tryThatOne < tryThisOne) {
					finish.add(right.get(j));
					j += 1;
				}
			} else if (!(i < left.size())) {
				finish.add(right.get(j));
				j += 1;
			} else if (!(j < right.size())) {
				finish.add(left.get(i));
				i += 1;
			}
		}		
		return finish;
	}
	
	@SuppressWarnings("unchecked")
	public void load() {
		ArrayList<Employee> temp = ((ArrayList<Employee>) StdStream
				.readFromFile("employees.xml"));
		this.employees = temp;
	}	
}
