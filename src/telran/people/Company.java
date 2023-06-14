package telran.people;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

import telran.people.test.EmployeePredicate;

public class Company {
	Employee [] employees;

	public Company(Employee[] employees) {
		this.employees = Arrays.copyOf(employees, employees.length);
	}
	
	public Employee [] getAllEmployees( Comparator<Employee> comparator) {
		Employee [] res = Arrays.copyOf(employees, employees.length);
		Arrays.sort(res, comparator);
		return res;
		
	}
	public Employee [] getEmployeesByAge(int yearFrom, int yearTo){
		int index = 0;
		EmployeePredicate predicate = new EmployeePredicate(yearFrom, yearTo);
		Employee [] employeesByAge = new Employee[employees.length];
		for(int i = 0; i < employees.length;i++) {
			if(predicate.testByAge(employees[i])) {
				employeesByAge[index++] = employees[i];
			}
		}
		employeesByAge = Arrays.copyOf(employeesByAge, index);
		Arrays.sort(employeesByAge, Comparator.comparingInt(Employee::getBirthYear).reversed());
	    return employeesByAge;
	
	}
	
	public Employee [] getEmployeesBySalary(int salaryFrom, int salaryTo) {
		int index = 0;
		EmployeePredicate predicate = new EmployeePredicate(salaryFrom, salaryTo, 0);
		Employee [] employeesBySalary = new Employee[employees.length];
		for(int i = 0; i < employees.length;i++) {
			if(predicate.testBySalary(employees[i])) {
				employeesBySalary[index++] = employees[i];
			}
		}
		employeesBySalary = Arrays.copyOf(employeesBySalary, index);
		Arrays.sort(employeesBySalary, Comparator.comparingInt(Employee::getSalary));
	    return employeesBySalary;
	}
	
	public Employee [] getEmployeesByDepartment(String department) {
		int index = 0;
		EmployeePredicate predicate = new EmployeePredicate(department );
		Employee [] employeesByDepartment = new Employee[employees.length];
		for(int i = 0; i < employees.length;i++) {
			if(predicate.testByDepartment(employees[i])) {
				employeesByDepartment[index++] = employees[i];
			}
		}
		employeesByDepartment = Arrays.copyOf(employeesByDepartment, index);
		Arrays.sort(employeesByDepartment, Comparator.comparingInt(Employee::getId));
		return employeesByDepartment;
		
	}
	
	public boolean addEmployee(Employee employee) {
		boolean res = false;
		int index = Arrays.binarySearch(employees, employee, Comparator.comparingInt(Employee::getId));
		if (index < 0) {
	        index = -(index + 1); 
	        employees = Arrays.copyOf(employees, employees.length + 1); 
	        System.arraycopy(employees, index, employees, index + 1, employees.length - index - 1); 
	        employees[index] = employee; 
	        res = true;
	    }
	    return res;
		
	}
}
