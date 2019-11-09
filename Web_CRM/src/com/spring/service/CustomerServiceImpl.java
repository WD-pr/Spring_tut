package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CustomerDAO;
import com.spring.entity.Customer;

/* @Service is component inherited annotation. 
 * It purpose is implementing Service Facade design pattern, creating intermediate 
 * layer for custom business logic. It integrated data from multiple sources - DAOs. */
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerDAO;
	
	/*
	 * @Transactional - Begin and end of the transaction, removed from DAOs.
	 * DAOs will run in the context of transaction defined at service layer.
	 */
	@Override
	@Transactional
	public List<Customer> getCustomers() {

		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		
		customerDAO.saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {

		return customerDAO.getCustomer(id);
	}
	
	
}
