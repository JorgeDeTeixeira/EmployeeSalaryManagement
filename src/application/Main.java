package application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		List<Employee> employees = new ArrayList<>();

		System.out.print("How many employees will be registered: ");
		int n = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i + 1));
			System.out.print("Id: ");
			Integer id = scanner.nextInt();
			scanner.nextLine();
			while (hasId(employees, id)) {
				System.out.print("Id already taken! Try again: ");
				id = scanner.nextInt();
				scanner.nextLine();
			}
			System.out.print("Name: ");
			String name = scanner.nextLine();
			System.out.print("Salary: ");
			BigDecimal salary = scanner.nextBigDecimal();
			while (salary.compareTo(BigDecimal.ZERO) <= 0) {
				System.out.print("Salary must be positive! Try again: ");
				salary = scanner.nextBigDecimal();
			}

			employees.add(new Employee(id, name, salary));
		}

		System.out.print("Enter the employee id that will have salary increase: ");
		Integer idSalary = scanner.nextInt();
		scanner.nextLine();

		Employee emp = employees.stream().filter(x -> x.getId().equals(idSalary)).findFirst().orElse(null);

		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage:");
			double percentage = scanner.nextDouble();
			scanner.nextLine();
			while (percentage <= 0) {
				System.out.println("Percentage must be positive! Try again: ");
				percentage = scanner.nextDouble();
				scanner.nextLine();
			}
			emp.increaseSalary(percentage);
		}

		System.out.println("List of employees:");
		for (Employee e : employees) {
			System.out.println(e);
		}

		scanner.close();
	}

	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
		return emp != null;
	}
}
