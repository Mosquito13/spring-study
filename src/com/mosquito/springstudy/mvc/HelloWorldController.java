package com.mosquito.springstudy.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	@RequestMapping("/processFormChangeRequest")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		
		model.addAttribute("name", name.toUpperCase());
		
		return "helloworld";
	}

}
