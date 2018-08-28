package com.demo.rest.EmployeeService.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

//import org.springframework.hateoas.Link;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Repository;

import com.demo.rest.EmployeeService.exception.EmployeeNotFound;
import com.demo.rest.EmployeeService.pojo.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private List<Employee> employeeList = new ArrayList<>();
	Employee mayur = new Employee("Satyen", 100, "Trainer");
	Employee alok = new Employee("Alok", 102, "Associate");
	Employee gaurav = new Employee("Gaurav", 103, "A4");
	
	/*{
		addInitial();
	}
	
	public void addInitial() {
		Link linkMay = ControllerLinkBuilder.linkTo(TestEmployee.class)
				.slash("/employees/" + mayur.getEmployeeId()).withSelfRel();
		Link linkAlok = ControllerLinkBuilder.linkTo(TestEmployee.class)
				.slash("/employees/" + alok.getEmployeeId()).withSelfRel();
		Link linkGau = ControllerLinkBuilder.linkTo(TestEmployee.class)
				.slash("/employees/" + gaurav.getEmployeeId()).withSelfRel();
		mayur.add(linkMay);
		alok.add(linkAlok);
		gaurav.add(linkGau);
		employeeList.add(mayur);
		employeeList.add(alok);
		employeeList.add(gaurav);
	}*/
	
	
	public void addEmployee(Employee employee){
		
		/*Link link = ControllerLinkBuilder.linkTo(TestEmployee.class)
				.slash("/employees/" + employee.getEmployeeName()).withSelfRel();
		employee.add(link);*/
		try{
	
			 employeeList.add(employee);
			
		}catch(EmployeeNotFound exception) {
			throw new EmployeeNotFound("Employee Not Found");
		}
		
		employeeList.add(employee);
	}

	public List<Employee> getAllEmployees() {
	
			try {
				employeeList.size();
			} catch(EmployeeNotFound exception){
				throw new EmployeeNotFound("Employee Not Found");
			}
			
			return employeeList;
	}
	
	public Employee findEmployee(int id){
		try {
				
			employeeList.stream()
					.filter(emp -> emp.getEmployeeId() == id).findFirst().get();
			
		} catch(NoSuchElementException exception) {
			throw new EmployeeNotFound("No Employee Present");
			}
		
		return employeeList.stream()
				.filter(emp -> emp.getEmployeeId() == id).findFirst().get();	
	}

	public void deleteEmployee(int id){

		Predicate<Employee> checkId = emp -> emp.getEmployeeId() == id;
		
		try {
			employeeList.removeIf(checkId);
		}catch(NoSuchElementException exception) {
			throw new EmployeeNotFound("No Employee Present");
			}
		
		employeeList.removeIf(checkId);
	}
	
	public void updateEmpl(int id, Employee employee){
/*for(int i=0; i<employeeList.size(); i++) {
			
			Employee uEmp = employeeList.get(i);
			if(uEmp.getEmployeeId() == id) {
				employeeList.set(i,employee);
			}
		}*/
		try {
			
			employeeList.stream().anyMatch(emp -> emp.getEmployeeId() == id);
		} catch(NoSuchElementException exception) {
			throw new EmployeeNotFound("No Employee Present");
			}
		
		for(int i=0; i<employeeList.size(); i++) {
					
			Employee uEmp = employeeList.get(i);
				if(uEmp.getEmployeeId() == id) {
					employeeList.set(i,employee);
				}
			}
		}

}
