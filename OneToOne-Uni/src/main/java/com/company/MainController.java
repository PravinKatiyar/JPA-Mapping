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

	@Autowired
	private CompanyRepo companyRepo;
	
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
	public Address createEmployee(@RequestBody Employee emp, @PathVariable int addId) {
		Address addr= addressRepo.findById(addId);
		addr.setEmployee(emp);
		// save both address and employee ( Cascade type - ALL)
		return addressRepo.save(addr);
	}
	
	@PostMapping("/company/{addId}")
	public Address createCompany(@RequestBody Company com, @PathVariable int addId) {
		Address addr= addressRepo.findById(addId);
		addr.setCompany(com);
		// save both address and company ( Cascade type - ALL)
		return addressRepo.save(addr);
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmployees(){
		return employeeRepo.findAll();
	}
	
	@GetMapping("/employeeNameWithCode")
	public EmployeeNameCodeDto getemployeeNameWithCode(){
		System.out.println("employeeNameWithCode called!!");
		return employeeRepo.findEmployeeNameCode((long) 1);
	}
	
	@GetMapping("/employeeNameWithCity")
	public EmployeeNameAndCityDto getemployeeNameWithCity(){
		System.out.println("getemployeeNameWithCity called!!");
		return employeeRepo.findEmployeeNameAndCity((long) 1);
	}

	@GetMapping("/address")
	public List<Address> getAddress(){
		return addressRepo.findAll();
	}
	
	@DeleteMapping("/address/{id}")
	public void deleteAddress(@PathVariable("id") int id) {
		addressRepo.deleteById(id);
	}
	

}
