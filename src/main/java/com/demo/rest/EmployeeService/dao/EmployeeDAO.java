package com.demo.rest.EmployeeService.dao;

import java.util.List;

import com.demo.rest.EmployeeService.pojo.Employee;

public interface EmployeeDAO {

	void addEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee findEmployee(int id);
	void deleteEmployee(int id);
	void updateEmpl(int id, Employee employee);
}