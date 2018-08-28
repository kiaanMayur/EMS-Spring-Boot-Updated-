package com.demo.rest.EmployeeService.test;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rest.EmployeeService.pojo.Employee;
import com.demo.rest.EmployeeService.service.ServiceImpl;

@RestController
public class TestEmployee {
	@Autowired
	private ServiceImpl service;
	//private EmployeeDAOImpl dao = new EmployeeDAOImpl();
	

	@RequestMapping(value="/employee", method=RequestMethod.POST, consumes="application/json")
	public void addEmployee(@RequestBody Employee employee) {
		
		service.addEmployee(employee);
	}
	
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	public ResponseEntity<List<Employee>> viewAll() {
		ResponseEntity<List<Employee>> response;
		
		try {
			List<Employee> employees = service.viewAllEmployees();
			
		} catch(NoSuchElementException exception) {
			response = new ResponseEntity<List<Employee>>(service.viewAllEmployees(), HttpStatus.NOT_FOUND);
		}
		response = new ResponseEntity<List<Employee>>(service.viewAllEmployees(), HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value="/employees/{id}", method=RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		ResponseEntity<Employee> response;
		
		try {
			Employee employees = service.getEmployee(id);
			
		} catch(NoSuchElementException exception) {
			response = new ResponseEntity<Employee>(service.getEmployee(id), HttpStatus.NOT_FOUND);
		}
		response = new ResponseEntity<Employee>(service.getEmployee(id), HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value="/employees/{id}", method=RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);
	}
	
	@RequestMapping(value="/employees/{id}", method=RequestMethod.PUT)
	public void updateEmpl(@PathVariable int id,@RequestBody Employee employee){
		service.updateEmpl(id, employee);
	}
	
}
