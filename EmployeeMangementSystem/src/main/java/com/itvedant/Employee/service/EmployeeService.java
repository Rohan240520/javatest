package com.itvedant.Employee.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.itvedant.Employee.dao.AddEmployeeDAO;
import com.itvedant.Employee.dao.UpdateEmployeeDAO;
import com.itvedant.Employee.entity.Employee;
@Service
public class EmployeeService {

	private Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	
	private AtomicInteger counter = new AtomicInteger();
	
	public Employee insertRecord(AddEmployeeDAO addEmployeeDAO) {
		
		Employee emp = new Employee();
		
		emp.setId(counter.incrementAndGet());
		emp.setName(addEmployeeDAO.getName());
		emp.setAge(addEmployeeDAO.getAge());
		emp.setSalary(addEmployeeDAO.getSalary());
		
		employees.put(emp.getId(),emp);
		
		return emp;
	}
	
	public Collection<Employee> readrecord(){
		
		Collection<Employee> emp = new ArrayList<Employee>();
		
		
		emp = this.employees.values();

		return emp;
	}
	
	public Employee findRecord(Integer id) {
	
		
		Employee emp = new Employee();
		
		emp = this.employees.get(id);
		
		return emp;
		
	}
	
	public String deleteRecord(Integer id) {
		
		this.employees.get(id);
		
		return "Employee data deleted";
	}
	
	public Employee updateRecord(Integer id, UpdateEmployeeDAO updateEmployeeDAO) {
	    Employee emp = this.findRecord(id);
	    
	    if(updateEmployeeDAO.getName() != null) {
	        emp.setName(updateEmployeeDAO.getName());
	    }
	    if(updateEmployeeDAO.getAge() != null) {
	        emp.setAge(updateEmployeeDAO.getAge());
	    }
	    if(updateEmployeeDAO.getSalary() != null) {
	        emp.setSalary(updateEmployeeDAO.getSalary());
	    }
	    
	    return emp;  
	}

	
}

