package com.mosquito.springstudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mosquito.springstudy.entity.Employee;
import com.mosquito.springstudy.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public Employee findById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void save(Employee employee) {
		repository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}

}
