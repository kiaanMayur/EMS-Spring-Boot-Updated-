package com.demo.rest.EmployeeService.service;

import static org.junit.Assert.*;

import org.junit.Before;
//import org.junit.Test;
import org.junit.runner.RunWith;
//import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.rest.EmployeeService.dao.EmployeeDAOImpl;
//import com.demo.rest.EmployeeService.exception.ZeroValueException;
import com.demo.rest.EmployeeService.pojo.Employee;

@RunWith(SpringRunner.class)
@TestConfiguration
public class TestEmployeeServiceMethod_GetEmployeeById {

	private static final int ID = 101;
	private Employee employee;
	
	@Autowired
	private ServiceImpl service;
	
	@TestConfiguration
	static class instantiateService {
		@Bean
		public ServiceImpl getInstanceOfServiceImpl() {
			return new ServiceImpl();
		}
	}
	
	/*Mocked object of EmployeeDAOImpl*/
	@MockBean
	EmployeeDAOImpl dao;
	
	/*will execute before each test case*/
	@Before
	public void instantiateEmployee() {
		employee = new Employee("Emp_Name", 101, "Designation"); 
	}
	
	/*@Before
	public void mockingMethod() throws ZeroValueException {
		this is telling that when findEmployee method with argument will be called from mock object dao,
		then employee object should be returned 
		when(dao.findEmployee(ID)).thenReturn(employee);
		
	}
	
	@Test
	public void testGetEmployeeByIdWith_CorrectValues() throws ZeroValueException {
		assertEquals(service.getEmployee(ID), employee);
	}

	@Test(expected=ZeroValueException.class)
	public void testGetEmployeeByIdWith_ZeroValues() {
		//assertEquals(, actual);
	}*/
}
