package telran.people.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.people.Company;
import telran.people.Employee;

class CompanyTest {
	Company company;
	
	Employee [] employees = {
		
		new Employee(1235, "Igor", 1985, "QA", 5000),
		new Employee(1234, "Alex", 1982, "bigBoss", 50000),
		new Employee(1237, "Alina", 2000, "developer", 10000),
		new Employee(1236, "Oleg", 2000, "developer", 15000)
	};
	@BeforeEach
	void setUp() throws Exception {
		company = new Company(employees);
	}

	@Test
	void getAllEmployeesTest() {
		Employee [] expected = {
				new Employee(1234, "Alex", 1982, "bigBoss", 50000),
				new Employee(1235, "Igor", 1985, "QA", 5000),
				new Employee(1236, "Oleg", 2000, "developer", 15000),
				new Employee(1237, "Alina", 2000, "developer", 10000)
					
		};
		
		assertArrayEquals(expected, company.getAllEmployees(Comparator.naturalOrder())); 

	}
	
	@Test
	void getEmployeesByAgeTest() {
		Employee [] expected = {
				new Employee(1237, "Alina", 2000, "developer", 10000),
				new Employee(1236, "Oleg", 2000, "developer", 15000)
				
					
		};
		assertArrayEquals(expected, company.getEmployeesByAge(1998, 2001));
	}
	
	@Test
	void getEmployeesBySalaryTest() {
		Employee [] expected = {
				
				new Employee(1236, "Oleg", 2000, "developer", 15000),
				new Employee(1234, "Alex", 1982, "bigBoss", 50000),
				
					
		};
		assertArrayEquals(expected, company.getEmployeesBySalary(15000, 50000));
	}
	
	@Test
	void getEmployeesByDepartmentTest() {
		Employee [] expected = {
				
				new Employee(1236, "Oleg", 2000, "developer", 15000),
				new Employee(1237, "Alina", 2000, "developer", 10000)
				
		};
		assertArrayEquals(expected, company.getEmployeesByDepartment("developer"));
	}
	
	@Test
	void addEmployeeTest() {
		Employee [] expected = {
				
				new Employee(1235, "Igor", 1985, "QA", 5000),
				new Employee(1234, "Alex", 1982, "bigBoss", 50000),
				new Employee(1237, "Alina", 2000, "developer", 10000),
				new Employee(1236, "Oleg", 2000, "developer", 15000),
				new Employee(1238, "Maximus", 1990, "manager", 10000)
				
		};
		Employee empl = new Employee(1238, "Maximus", 1990, "manager", 10000);
		assertTrue(company.addEmployee(empl));
	}
	
	@Test
	void removeEmployeesIfTest() {
		Employee [] expected = {
				
				new Employee(1235, "Igor", 1985, "QA", 5000),
				new Employee(1234, "Alex", 1982, "bigBoss", 50000),
				new Employee(1237, "Alina", 2000, "developer", 10000)
				
				
		};
		Employee empl = new Employee(1236, "Oleg", 2000, "developer", 15000);
		assertTrue(company.removeEmployeesIf(empl));
	}
	
	@Test
	void getEmployeeTest() {
		Employee expected = new Employee(1235, "Igor", 1985, "QA", 5000);
		
		assertEquals(expected, company.getEmployee(1235));
	}
	
	

}
