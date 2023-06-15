package telran.people.test;

import java.util.function.Predicate;

import telran.people.Employee;

public class EmployeePredicate implements Predicate<Employee> {
	private int yearFrom;
	private int yearTo;
	private int salaryFrom;
	private int salaryTo;
	private String department;
	private Integer id;
	

	public boolean testByAge(Employee t) {
		
		return t.getBirthYear() >= yearFrom && t.getBirthYear() <= yearTo;
	}
	
public boolean testById(Employee t) {
		
		return t.getId() == id ;
	}
	
public boolean testBySalary(Employee t) {
		
		return t.getSalary() >= salaryFrom && t.getSalary() <= salaryTo;
	}

public boolean testByDepartment(Employee t) {
	
	return t.getDepartment().equals(department);
}

	@Override
	public boolean test(Employee t) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public EmployeePredicate( int salaryFrom, int salaryTo, int foo) { // ???
		this.salaryFrom = salaryFrom;
		this.salaryTo = salaryTo;
	}
	
	public EmployeePredicate(int yearFrom, int yearTo) {
		this.yearFrom = yearFrom;
		this.yearTo = yearTo;
		
	}

	public EmployeePredicate(String department) {
		this.department = department;
	}

	public EmployeePredicate(int id) {
		this.id = id;
	}

	

}
