package telran.people;

public class Employee implements Comparable<Employee> {
	
	private int id;
	private String name;
	private int birthYear;
	private String department;
	private int salary;

	

	public Employee(int id, String name, int birthYear, String department, int salary) {
		this.id = id;
		this.name = name;
		this.birthYear = birthYear;
		this.department = department;
		this.salary = salary;
	}
	
	public int compareTo(Employee o) { // this.id - o.id? (compare by id)
		
		return this.id - o.id;
	}
	
//public int compareToByAge(Employee o1, Employee o2) { 
//		
//		return o1.birthYear - o2.birthYear < 0 ? 1 : -1;
//	}
//
//public int compareToBySalary(Employee o1, Employee o2) { 
//	
//	return o1.salary - o2.salary;
//}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public String getDepartment() {
		return department;
	}

	public int getSalary() {
		return salary;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id;
	}


}
