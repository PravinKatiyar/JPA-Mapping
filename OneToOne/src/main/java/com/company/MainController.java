package com.company;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private AddressRepo addressRepo;

	
	@GetMapping("/")
	public String sendResponse() {
		System.out.println("Its working");
		return "Its working!!";
	}
	@PostMapping("/address")
	public Address createAddress(@RequestBody Address add) {
		System.out.println("Create address called!!");
		return addressRepo.save(add);
	}
	
	@PostMapping("/employee/{addId}")
	public Employee createEmployee(@RequestBody Employee emp, @PathVariable int addId) {
		Address addr= addressRepo.findById(addId);
		addr.setEmployee(emp);
		return employeeRepo.save(emp);
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmployees(){
		return employeeRepo.findAll();
	}

	@GetMapping("/address")
	public List<Address> getAddress(){
		return addressRepo.findAll();
	}

}
