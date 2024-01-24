package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.Employee;
import com.example.demo.Entities.Address;
import com.example.demo.Feign.EmployeeFeign;
import com.example.demo.Repository.AddressRepo;
import com.example.demo.Service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	
	@Autowired
	private AddressRepo ar; 
	
	@Autowired
	private	EmployeeFeign ef;
	
	
	@Override
	public Address saveAdd(Address add) {
		return ar.save(add);
	}
	

	@Override
	public Address findById(Long id) {
		Optional<Address> addresses=ar.findById(id);
		 if (addresses.isPresent()) {
		        Address address = addresses.get();

		        // Extract the list of employees from the response entity
		        ResponseEntity<List<Employee>> employeesResponse = (ResponseEntity<List<Employee>>) ef.findAll();
		        
		        if (employeesResponse.getStatusCode() == HttpStatus.OK) {
		            List<Employee> employees = employeesResponse.getBody();

		            // Filter employees based on addId
		            List<Employee> filteredEmployees = employees.stream()
		                    .filter(employee -> employee.getAddId() == address.getAid())
		                    .collect(Collectors.toList());

		            // Set the filtered employees in the address
		            address.setEmployees(filteredEmployees);

		            return address;
		        }
		 
		 }
		 return null;
	}


	@Override
	public List<Address> findAll() {
		return ar.findAll();
	}
}



