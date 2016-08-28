import java.util.Scanner;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class EmployeeWorkHours {
	public static void main(String[] args) {
		int totalEmployees;		// total number of employees to process
		int totalDaysWorked;	// total number of days each employee worked
		int[] hoursWorked;		// array of hours worked per day
		Employee[] employees;	// array of Employee objects

		// invoke scanner for user input
		Scanner input = new Scanner(System.in);

		// prompt user for total number of employees and days worked
		System.out.print("Please enter total number of employees: ");
		validateInput(input);
		totalEmployees = input.nextInt();
		System.out.print("How many days in work week? ");
		validateInput(input);
		totalDaysWorked = input.nextInt();
		input.nextLine();

		// initialize array of Employee objects with index totalEmployees
		employees = new Employee[totalEmployees];

		// populate each employee object with employee name and hour worked each day
		for (int i = 0; i < employees.length; i++) {
			System.out.print("Enter employee name: ");
			String name = input.nextLine();
			hoursWorked = new int[totalDaysWorked];
			for (int j = 0; j < totalDaysWorked; j++) {
				System.out.print("Please enter hours worked on day " + (j+1) + ": ");
				validateInput(input);
				int hours = input.nextInt();
				input.nextLine();
				hoursWorked[j] = hours;
			}
			employees[i] = new Employee(name,hoursWorked);
		}

		// close Scanner input
		input.close();

		// create and ArrayList of employees
		ArrayList<Employee> list = new ArrayList<Employee>();
		for (int i = 0; i < employees.length; i++) {
			list.add(employees[i]);
		}

		// sort the ArrayList of employees by total hours worked per week
		Collections.sort(list, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return Integer.valueOf(e1.totalHoursWorked()).compareTo(e2.totalHoursWorked());
            }
        });

		// reverse the order of sorted ArrayList of employees
		Collections.reverse(list);

		// display list of employees in order of most hours worked per week
		for(Employee employee: list){
            System.out.println(employee.getName() + " worked " + employee.totalHoursWorked() + " hours");
        }
	}

	// validates user input is an integer
	public static void validateInput(Scanner in) {
		while (!in.hasNextInt()) {
			System.out.println("That's not an integer!");
			in.next();
			System.out.print("Please try again: ");
		}
	}
}
