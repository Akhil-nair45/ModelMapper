package com.example.demo.Entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Dto.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long aid;
	private String state;
	private String city;
	private long pincode;
	
	@Transient
	private List<Employee> employees;
	
}
