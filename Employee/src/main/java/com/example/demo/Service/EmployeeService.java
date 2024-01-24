package com.example.demo.Service;

import java.util.List;

import com.example.demo.entities.Employee;

public interface EmployeeService {

	public Employee addEmp(Employee emp);
	
	public List<Employee> findAll();
	
	public Employee findById(Long id);
	
}
