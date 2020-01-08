package com.mosquito.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("myBaseballCoach", Coach.class);
	
		System.out.println("\n== Constructor injection ==");
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		coach = context.getBean("myHockeyCoach", Coach.class);
		
		System.out.println("\n== Setter injection ==");
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		context.close();
	}

}
