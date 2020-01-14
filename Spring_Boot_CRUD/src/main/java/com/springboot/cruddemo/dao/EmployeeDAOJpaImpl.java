package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

		TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {

		Employee employee = entityManager.find(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {

		Employee dbEmployee = entityManager.merge(employee);
		
		// to return generated id in case of saving employee
		employee.setId(dbEmployee.getId());
		
	}

	@Override
	public void deleteById(int id) {

		
		Query query = entityManager.createQuery("delete from Employee where id =: employeeId");
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

}
