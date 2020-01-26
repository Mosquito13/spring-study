package com.mosquito.springstudy.dao;

import java.util.List;

import com.mosquito.springstudy.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomer(String search);
	
}
