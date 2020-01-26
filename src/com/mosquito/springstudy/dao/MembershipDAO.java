package com.mosquito.springstudy.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public int addAccount() {
		System.out.println(getClass() + ": addAccount");
		
		return 1;
	}
	
	public void xesque() {
		this.addAccount();
	}
	
}
