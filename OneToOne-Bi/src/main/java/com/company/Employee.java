
package com.company;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*Parent ----One-to-One*/


@Entity
@Table(name = "employeedetails")


public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "emp_id")
	private Long emp_id;
	
	
	@JsonBackReference 
	@OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Address address;

	@Column(name = "EmployeeName")
	private String employeeName;

	@Column(name = "EmployeeCode")
	private String employeeCode;

	@Column(name = "Designation")
	private String designation;

	
	

	public Employee() {
		super();
	}

	public Employee(Long id, String employeeName, String employeeCode, String designation) {
		super();
		this.emp_id = id;
		this.employeeName = employeeName;
		this.employeeCode = employeeCode;
		this.designation = designation;
	}

	public Long getId() {
		return emp_id;
	}

	public void setId(Long id) {
		this.emp_id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
