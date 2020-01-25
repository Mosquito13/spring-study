package com.mosquito.springstudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mosquito.springstudy.entity.Customer;
import com.mosquito.springstudy.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerService.getCustomers());
		
		return "list-customers";
	}

	@GetMapping("/add")
	public String addCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		
		return "add-customer";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
}
