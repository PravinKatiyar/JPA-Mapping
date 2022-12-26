package com.company;

import org.springframework.stereotype.Component;


public class EmployeeNameCodeDto {
	String employeeName;
	String employeeCode;
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
	public EmployeeNameCodeDto(String employeeName, String employeeCode) {
		this.employeeName = employeeName;
		this.employeeCode = employeeCode;
	}
	public EmployeeNameCodeDto() {
		super();
	}
	
	
}
