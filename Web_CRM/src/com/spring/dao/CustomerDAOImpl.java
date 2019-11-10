package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.Customer;

/* @Repository is component inherited annotation that supports JDBC 
 * exception translation */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

		return query.getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {

		Session session = sessionFactory.getCurrentSession();

		/*
		 * In case of empty id save method is executed, otherwise is uses update method
		 */
		session.saveOrUpdate(customer);

	}

	@Override
	public Customer getCustomer(int id) {

		Session session = sessionFactory.getCurrentSession();

		Customer customer = session.get(Customer.class, id);

		return customer;
	}

	@Override
	public void deleteCustomer(int id) {

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);

		query.executeUpdate();

	}

	@Override
	public List<Customer> searchCustomers(String searchName) {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = null;
		if (searchName != null && !searchName.trim().isEmpty()) {
			query = session.createQuery("from Customer "
					+ "where lower(firstName) like :name or lower(lastName) like :name "
					+ "order by lastName", Customer.class);
			
			String name = "%" + searchName.trim().toLowerCase() + "%";
			query.setParameter("name", name);

		} else {
			query = session.createQuery("from Customer order by lastName", Customer.class);
		}
		
		return query.getResultList();
	}

}
