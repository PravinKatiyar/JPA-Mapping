package com.company;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "address")
/*
 * Child   --->One-to-One
 */
public class Address {

	@Id
	@Column(name = "add_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int add_id;
	
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
	private Employee employee;

	@Column(name = "doornumber")
	private String doorNumber;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	

	public Address() {
		super();
	}

	public Address(int id, String doorNumber, String street, String city, Employee employee) {
		super();
		this.add_id = id;
		this.doorNumber = doorNumber;
		this.street = street;
		this.city = city;
		this.employee = employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getId() {
		return add_id;
	}

	public void setId(int id) {
		this.add_id = id;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAdd_id() {
		return add_id;
	}

	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}

	public Employee getEmployee() {
		return employee;
	}

}