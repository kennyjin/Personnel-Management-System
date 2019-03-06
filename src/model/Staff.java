package model;

public class Staff 
{
	int id;
	String name;
	int sex;
	String department;
	int salary;
	public Staff(int id, String name, int sex, String department, int salary) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.department = department;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getSex() {
		return sex;
	}
	public String getDepartment() {
		return department;
	}
	public int getSalary() {
		return salary;
	}
}
