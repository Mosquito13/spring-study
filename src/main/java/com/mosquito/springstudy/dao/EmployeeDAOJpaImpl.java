package com.mosquito.springstudy.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mosquito.springstudy.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		return entityManager.createQuery("from Employee", Employee.class).getResultList();
	}

	@Override
	public Employee findById(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public void save(Employee employee) {
		Employee e = entityManager.merge(employee);
		
		employee.setId(e.getId());
	}

	@Override
	public void deleteById(int id) {
		Employee e = entityManager.find(Employee.class, id);
		
		entityManager.remove(e);
	}

}
