package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDao;

	// Add an employee
	@PostMapping("/employees")
	public Employee creatEmployee(@Valid @RequestBody Employee emp) {
		return employeeDao.save(emp);
	}

	// Get list of employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	// Get one employee
	@GetMapping("/notes/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long empid) {
		Employee emp = employeeDao.findOne(empid);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().build();
		}
	}
	
	//Update an employee details
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid, @Valid @RequestBody Employee empDetails){
		Employee emp = employeeDao.findOne(empid);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}else {
			emp.setName(empDetails.getName());
			emp.setDesignation(empDetails.getDesignation());
			emp.setExpertise(empDetails.getExpertise());
			Employee updateEmployee = employeeDao.save(emp);
			return ResponseEntity.ok().body(updateEmployee);
		}
	}
	
	//Delete an employee
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		Employee emp = employeeDao.findOne(empid);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}else {
			employeeDao.delete(emp);
			return ResponseEntity.ok().build();
		}
	}

}
