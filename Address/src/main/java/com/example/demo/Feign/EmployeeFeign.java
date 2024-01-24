package com.example.demo.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Employee-feign",url = "http://localhost:7777/Employee/")
public interface EmployeeFeign {

	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll();
	
	@GetMapping("/find/{eid}")
	public ResponseEntity<?> findById(@PathVariable Long id);
}
