package com.demo.rest.EmployeeService.pojo;

import org.springframework.hateoas.ResourceSupport;

public class Employee extends ResourceSupport{

	private String employeeName;
	private int employeeId;
	private String designation;
	
	
	public Employee(String employeeName, int employeeId, String designation) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.designation = designation;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
