package com.company;

public class EmployeeNameAndCityDto {
	String employeeName;
	String city;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public EmployeeNameAndCityDto(String employeeName, String city) {
		super();
		this.employeeName = employeeName;
		this.city = city;
	}
	public EmployeeNameAndCityDto() {
		super();
	}
	
}
