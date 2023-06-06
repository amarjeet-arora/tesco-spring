package com.java.employees.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.employees.dao.EmployeeRepository;
import com.java.employees.model.Employee;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
	
	@InjectMocks
	EmployeeService service;
	@Mock
	EmployeeRepository repository;
	
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void  testFindEmployee() {
		List<Employee> list= new ArrayList<Employee>();
		Employee e1= new Employee("john", "john");
		Employee e2= new Employee("Alex", "Alex");
		Employee e3= new Employee("steve", "steve");
		list.add(e1);list.add(e2);list.add(e3);
		
		Mockito.when(repository.findAll()).thenReturn(list);
		List<Employee> empList= service.findAll();
		assertEquals(3, empList.size());
		
	}
	void testCreateandSave() {
		Employee e1= new Employee("john", "john");
		service.save(e1);
		Mockito.verify(repository,Mockito.times(1)).save(e1);
	}

}
