package com.mosquito.springstudy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mosquito.springstudy.entity.Customer;

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

		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();

		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();

		Customer c = this.getCustomer(id);

		session.delete(c);
	}

	@Override
	public List<Customer> searchCustomer(String search) {
		if (search == null || search.trim().length() == 0) {
			return this.getCustomers();
		}
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery(
				"from Customer where lower(firstName) like :search or lower(lastName) like :search order by lastName",
				Customer.class);
		
		query.setParameter("search", "%" + search.toLowerCase() + "%");
		
		return query.getResultList();
	}
}
