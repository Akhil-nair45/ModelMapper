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

import com.example.demo.Entities.Address;
import com.example.demo.Service.AddressService;

@RestController
@RequestMapping("/Address")
public class AddressController {

	
	@Autowired
	private AddressService as;
	
	
	@PostMapping("/save")
	public ResponseEntity<?> saveAddress(@RequestBody Address add)
	{
		return new ResponseEntity<>(as.saveAdd(add),HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll()
	{
		return new ResponseEntity<>(as.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id)
	{
		return new ResponseEntity<>(as.findById(id),HttpStatus.OK);
	}
}
