
package com.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "employeedetails")
/*
 * Child
 */
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "Id")
	private Long id;

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
		this.id = id;
		this.employeeName = employeeName;
		this.employeeCode = employeeCode;
		this.designation = designation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
