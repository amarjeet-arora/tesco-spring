package com.java.employees.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
 import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.java.employees.model.Employee;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)

public class DaoTest {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Test
	public void testCreate() {
		Employee employee= new Employee("admin","manager");
		employeeRepository.save(employee);
		Iterable<Employee> emps= employeeRepository.findAll();
		Assertions.assertThat(emps).extracting(Employee::getFirstName).containsOnly("admin");
		employeeRepository.deleteAll();
		
		Assertions.assertThat(employeeRepository.findAll()).isEmpty();
	}
	

}
