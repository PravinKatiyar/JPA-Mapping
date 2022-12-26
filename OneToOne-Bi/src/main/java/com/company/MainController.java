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
	

	@PostMapping("/address")
	public Address createAddress(@RequestBody Address add) {
		return addressRepo.save(add);
	}
	
	@PostMapping("/employee/{addId}")
	public Employee createEmployee(@RequestBody Employee emp,@PathVariable int addId) {
		Address addr= addressRepo.findById(addId);
		emp.setAddress(addr);
		addr.setEmployee(emp);
        // save both employee and address ( Cascade type - ALL)
		return employeeRepo.save(emp);
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmployees(){
		return employeeRepo.findAll();
	}
	
	@GetMapping("/getaddress")
	public List<Address> getAddress(){
		return addressRepo.findAll();
	}

}
