package com.mosquito.springstudy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mosquito.springstudy.dao.AccountDAO;
import com.mosquito.springstudy.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		accountDAO.addAccount();
		membershipDAO.addAccount();
		membershipDAO.xesque();
		
		context.close();
	}

}
