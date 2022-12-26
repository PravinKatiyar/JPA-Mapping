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

@Entity
@Table(name = "address")
/*
 * Parent
 */
public class Address {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "doornumber")
	private String doorNumber;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@OneToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;

	public Address() {
		super();
	}

	public Address(int id, String doorNumber, String street, String city, Employee employee) {
		super();
		this.id = id;
		this.doorNumber = doorNumber;
		this.street = street;
		this.city = city;
		this.employee = employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

	public Employee getEmployee() {
		return employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}