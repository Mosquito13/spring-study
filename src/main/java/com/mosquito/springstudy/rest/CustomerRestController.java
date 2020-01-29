package com.mosquito.springstudy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mosquito.springstudy.entity.Customer;
import com.mosquito.springstudy.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomers(@PathVariable int customerId) {
		Customer c = customerService.getCustomer(customerId);
		
		if (c == null) {
			throw new CustomerNotFoundException("Customer not found with id: " + customerId);
		}
		
		return c;
	}
	
	@PostMapping("/customers")
	public Customer postCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		
		customerService.saveCustomer(customer);
		
		return customer;
	}
}
