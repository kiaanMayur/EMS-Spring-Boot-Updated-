package com.demo.rest.EmployeeService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.rest.EmployeeService.dao.EmployeeDAOImpl;
import com.demo.rest.EmployeeService.exception.EmployeeNotFound;
import com.demo.rest.EmployeeService.pojo.Employee;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	
	@Autowired
	private EmployeeDAOImpl dao;
	
/* (non-Javadoc)
 * @see com.demo.rest.EmployeeService.service.Service#addEmployee(com.demo.rest.EmployeeService.pojo.Employee)
 */
	@Override
	public void addEmployee(Employee employee) throws EmployeeNotFound{
		try {
			dao.addEmployee(employee);
		} catch(EmployeeNotFound exception) {
			throw exception;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.demo.rest.EmployeeService.service.Service#viewAllEmployees()
	 */
	@Override
	public List<Employee> viewAllEmployees(){
		try {
			return dao.getAllEmployees();
		} catch(EmployeeNotFound exception) {
			throw exception;
		}
		//return dao.getAllEmployees();
	}
	
	@Override
	public Employee getEmployee(int id) {
		
		try{
			return dao.findEmployee(id);
		} catch(EmployeeNotFound exception) {
			throw exception;
		} 
	}

	@Override
	public void deleteEmployee(int id) {
		
		try{
			dao.deleteEmployee(id);
		}catch(EmployeeNotFound exception) {
			throw exception;
		} 
	}

	@Override
	public void updateEmpl(int id, Employee employee) {
		
		try{
			dao.updateEmpl(id, employee);
		}catch(EmployeeNotFound exception) {
			throw exception;
		} 
	}
}
