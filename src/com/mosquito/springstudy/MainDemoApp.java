package com.mosquito.springstudy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mosquito.springstudy.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		accountDAO.addAccount();
		
		context.close();
	}

}
