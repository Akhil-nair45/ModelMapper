package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.Service.EmployeeService;
import com.example.demo.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo er;
	
	
	@Override
	public Employee addEmp(Employee emp) {
		return er.save(emp);
	}

	@Override
	public List<Employee> findAll() {
		return er.findAll();
	}

	@Override
	public Employee findById(Long id) {
		return er.findById(id).get();
	}

}
