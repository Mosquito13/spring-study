package com.mosquito.springstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mosquito.springstudy.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
