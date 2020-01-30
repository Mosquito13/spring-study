package com.mosquito.springstudy.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mosquito.springstudy.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {
		Session session = entityManager.unwrap(Session.class);

		return session.createQuery("from Employee", Employee.class).getResultList();
	}

	@Override
	public Employee findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		return session.get(Employee.class, id);
	}

	@Override
	public void save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		session.delete(this.findById(id));
	}

}
