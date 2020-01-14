package com.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.dao.EmployeeRepository;
import com.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	//@Qualifier("employeeDAOJpaImpl")
	private EmployeeRepository employeeDAO;
	
	@Override
	//@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	//@Transactional
	public Employee findById(int id) {
		Optional<Employee> result = employeeDAO.findById(id);
		
		Employee employee = null;
				
		if (result.isPresent()) {
			employee = result.get();
		}else {
			throw new RuntimeException("The employee is not found!");
		}
				
		
		return employee;
	}

	@Override
	//@Transactional
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	//@Transactional
	public void deleteById(int id) {
		employeeDAO.deleteById(id);
	}

}
