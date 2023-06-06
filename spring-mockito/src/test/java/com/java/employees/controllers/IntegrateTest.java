package com.java.employees.controllers;

import javax.validation.ValidationException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.java.employees.model.Employee;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IntegrateTest {
	@Autowired
	EmployeeController controller;
@Test
	public void testCreateAndread() {
	Employee employee= new Employee("admin", "manager");
	
	Employee empresult= controller.create(employee);
	
	Iterable<Employee> employees= controller.read();
	Assertions.assertThat(employees).first().hasFieldOrPropertyWithValue("firstName","admin");
	controller.delete(empresult.getId());
	Assertions.assertThat(controller.read()).isEmpty();
}
@Test
public void errorHandling() {
	Assertions.assertThatExceptionOfType(ValidationException.class)
	.isThrownBy(() -> controller.somethingIsWrong());
}
}