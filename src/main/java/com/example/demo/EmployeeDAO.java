package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	/**
	 * @param emp
	 * @return
	 */
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	/**
	 * @return
	 */
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	/**
	 * @param empid
	 * @return
	 */
	public Employee findOne(Long empid) {
		return employeeRepository.findById(empid).orElse(null);
	}
	
	
	//Delete an employee
	/**
	 * @param emp
	 */
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}

}
