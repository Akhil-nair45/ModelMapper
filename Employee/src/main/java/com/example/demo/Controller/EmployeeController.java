package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.EmployeeService;
import com.example.demo.entities.Employee;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private EmployeeService es;
	
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp)
	{
		return new ResponseEntity<>(es.addEmp(emp),HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll()
	{
		return new ResponseEntity<>(es.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/find/{eid}")
	public ResponseEntity<?> findById(@PathVariable Long id)
	{
		return new ResponseEntity<>(es.findById(id),HttpStatus.OK);
	}
}
