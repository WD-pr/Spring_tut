package com.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.thymeleaf.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	/*
	 * Custom method using specific spring pattern. Spring Data JPA parses the
	 * method name and creates appropriate query.
	 * Doc on Query Lookup Strategies:
	 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
	 */
	
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
