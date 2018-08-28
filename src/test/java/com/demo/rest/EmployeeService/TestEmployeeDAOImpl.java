package com.demo.rest.EmployeeService;

import static org.junit.Assert.*;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.rest.EmployeeService.dao.EmployeeDAO;
import com.demo.rest.EmployeeService.dao.EmployeeDAOImpl;
import com.demo.rest.EmployeeService.pojo.Employee;
import com.demo.rest.EmployeeService.service.Service;
import com.demo.rest.EmployeeService.service.ServiceImpl;

@RunWith(SpringRunner.class)
@TestConfiguration
public class TestEmployeeDAOImpl {
	
	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public EmployeeDAOImpl testEmployeeDAO() {
            return new EmployeeDAOImpl();
        }
    }

	private static Employee testEmployee;
	private static List<Employee> getAllEmployees;
	
	@Autowired
	private EmployeeDAOImpl dao;
	
	@BeforeClass
	public static void setEmployeeObject() {
		
		testEmployee = new Employee("Mayur", 101, "Analyst");
		getAllEmployees = new ArrayList<>();
	}
	/*@Test
	public void testAddEmployee() {
		
		dao.addEmployee(testEmployee);
		Assert.assertEquals(testEmployee, dao.findEmployee(101));
	}*/
	
	/*@Test(expected=InvalidObjectException.class)
	public void testAddEmployeeWithNull() {
		dao.addEmployee(null);
		Assert.assertEquals("Invalid Type", null);
	}
	
	@Test
	public void testGetEmployeeById() {
		
		Employee employeeByID = dao.findEmployee(101); 
		Assert.assertEquals(testEmployee, employeeByID);
	}
	
	@Test
	public void testGetAllEmployees() {
		
		getAllEmployees = dao.getAllEmployees();
		
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testDeleteEmployee() {
		dao.deleteEmployee(101);
		Assert.assertEquals("No such elements", null, dao.findEmployee(101));
	}
	
	@Test
	public void testUpdateEmployee() {
		Employee updateEmployee = new Employee("Mayur Tripathi", 101, "Analyst");
		dao.updateEmpl(101, updateEmployee);
		Assert.assertEquals(updateEmployee, dao.findEmployee(101));
	}*/

}
