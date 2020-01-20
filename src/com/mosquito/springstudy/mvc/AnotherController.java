package com.mosquito.springstudy.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/another")
public class AnotherController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "form";
	}
	
}
