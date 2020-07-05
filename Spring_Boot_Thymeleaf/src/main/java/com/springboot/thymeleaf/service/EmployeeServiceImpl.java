package com.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.thymeleaf.dao.EmployeeRepository;
import com.springboot.thymeleaf.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeDAO;
	
	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAllByOrderByLastNameAsc();
	}

	@Override
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
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeDAO.deleteById(id);
	}

}
