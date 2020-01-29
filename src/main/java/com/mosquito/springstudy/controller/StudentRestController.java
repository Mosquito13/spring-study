package com.mosquito.springstudy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mosquito.springstudy.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> s = new ArrayList<>();
		
		s.add(new Student("xesque", "bresque"));
		s.add(new Student("cresque", "dresque"));
		
		return s;
	}
	
}
