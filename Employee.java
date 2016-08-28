public class Employee {
	private String name;
	private int[] hoursWorked;

	//delete when finished
	public Employee(String name) {
		this.name = name;
	}

	public Employee(String name, int[] hoursWorked) {
		this.name = name;
		this.hoursWorked = hoursWorked;
	}

	public String getName() {
		return name;
	}

	public int[] getHoursWorked() {
		return hoursWorked;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHoursWorked(int[] hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public int totalHoursWorked() {
		int totalHoursWorked = 0;

		for (int i = 0; i < hoursWorked.length; i++) {
			totalHoursWorked += hoursWorked[i];
		}

		return totalHoursWorked;
	}
}
