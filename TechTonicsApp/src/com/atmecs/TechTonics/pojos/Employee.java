package com.atmecs.TechTonics.pojos;

public class Employee {
	private String employeeEmail;
	private String employeeName;
	private String employeePassword;
	public Employee(String employeeEmail, String employeeName, String employeePassword) {
		super();
		this.employeeEmail = employeeEmail;
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
	}
	
	public Employee(String employeeEmail, String employeePassword) {
		super();
		this.employeeEmail = employeeEmail;
		this.employeePassword = employeePassword;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	@Override
	public String toString() {
		return "Employee [employeeEmail=" + employeeEmail + ", employeeName=" + employeeName + ", employeePassword="
				+ employeePassword + "]";
	}
	
}
