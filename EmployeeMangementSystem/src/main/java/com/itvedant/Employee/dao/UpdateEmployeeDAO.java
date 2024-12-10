package com.itvedant.Employee.dao;

public class UpdateEmployeeDAO {
	
	
	private String name;
	private Integer age;
	private Float salary;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "UpdateEmployeeDAO [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	

}
