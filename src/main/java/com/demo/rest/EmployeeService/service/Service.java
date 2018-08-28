package com.demo.rest.EmployeeService.service;

import java.util.List;

import com.demo.rest.EmployeeService.exception.EmployeeNotFound;
import com.demo.rest.EmployeeService.pojo.Employee;

public interface Service {

	void addEmployee(Employee employee) throws EmployeeNotFound;
	List<Employee> viewAllEmployees() throws EmployeeNotFound;
	Employee getEmployee(int id);
	void deleteEmployee(int id);
	void updateEmpl(int id, Employee employee);
}