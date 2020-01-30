package com.mosquito.springstudy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mosquito.springstudy.entity.Employee;
import com.mosquito.springstudy.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.findById(id);
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee e) {
		e.setId(0);
		
		employeeService.save(e);
		
		return e;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee e) {
		employeeService.save(e);
		
		return e;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		employeeService.deleteById(id);
		
		return "Deleted employee with id: " + id;
	}
	
}
