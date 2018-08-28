package com.demo.rest.EmployeeService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Hello world!
 *
 */
import org.springframework.context.annotation.Bean;
import com.demo.rest.EmployeeService.dao.EmployeeDAOImpl;
import com.demo.rest.EmployeeService.pojo.Employee;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
    
    @Bean
    public static CommandLineRunner initialPopulate(EmployeeDAOImpl dao) {
    	
    	return (args) -> {
    		dao.addEmployee(new Employee ("Mayur Tripathi", 1, "Trainee"));
    		dao.addEmployee(new Employee("Satyen Singh", 2, "Trainer"));
    		dao.addEmployee(new Employee("Alok Ranjan", 3, "Trainee"));
    		dao.addEmployee(new Employee("Gaurav", 4, "Trainee"));
    		dao.addEmployee(new Employee("Udit", 5, "Trainee"));
    		dao.addEmployee(new Employee("Rahul", 6, "Trainee"));
    		dao.addEmployee(new Employee("Ripu", 7, "Trainee"));
    		dao.addEmployee(new Employee("Unknown", 8, "deisgnation"));
    		
    	};
    }
}
