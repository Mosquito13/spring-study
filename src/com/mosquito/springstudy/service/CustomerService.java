package com.mosquito.springstudy.service;

import java.util.List;

import com.mosquito.springstudy.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);
	
}
