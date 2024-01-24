package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entities.Address;

public interface AddressService {

	public Address saveAdd(Address add);
	
	public List<Address> findAll();
	
	public Address findById(Long id);
}
