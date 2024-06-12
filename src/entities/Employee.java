package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Employee {
	private String name;
	private Integer id;
	private BigDecimal salary;

	public Employee() {

	}

	public Employee(Integer id, String name, BigDecimal salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void increaseSalary(double percentage) {
		if (percentage > 0) {
			BigDecimal increase = salary.multiply(BigDecimal.valueOf(percentage).divide(BigDecimal.valueOf(100)));
			salary = salary.add(increase).setScale(2, RoundingMode.HALF_EVEN);
		} else {
			throw new IllegalArgumentException("Percentage must be positive.");
		}
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + salary.setScale(2, RoundingMode.HALF_EVEN);
	}

}
