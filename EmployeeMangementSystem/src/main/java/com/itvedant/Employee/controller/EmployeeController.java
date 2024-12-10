package com.itvedant.Employee.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.Employee.dao.AddEmployeeDAO;
import com.itvedant.Employee.dao.UpdateEmployeeDAO;
import com.itvedant.Employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody AddEmployeeDAO addEmployeeDAO){
		
		
		return ResponseEntity.ok(this.employeeService.insertRecord(addEmployeeDAO));
	}
	
	@GetMapping("")
	public ResponseEntity<?> reaAall(){
		
		return ResponseEntity.ok(this.employeeService.readrecord());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		return ResponseEntity.ok(this.employeeService.findRecord(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		
		return ResponseEntity.ok(this.employeeService.deleteRecord(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody UpdateEmployeeDAO updateEmployeeDAO){
	
		return ResponseEntity.ok(this.employeeService.updateRecord(id, updateEmployeeDAO));
	}
}
