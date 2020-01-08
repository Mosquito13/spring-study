package com.mosquito.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("myBaseballCoach", Coach.class);
		Coach anotherCoach = context.getBean("myBaseballCoach", Coach.class);
			
		System.out.println("\n== Constructor injection ==");
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println("Coach 1: " + coach + ", Coach 2: " + anotherCoach);
		System.out.println("Coaches are equal: " + (coach == anotherCoach));
		
		coach = context.getBean("myHockeyCoach", Coach.class);
		anotherCoach = context.getBean("myHockeyCoach", Coach.class);
		
		System.out.println("\n== Setter injection ==");
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println("Coach 1: " + coach + ", Coach 2: " + anotherCoach);
		System.out.println("Coaches are equal: " + (coach == anotherCoach));
		
		context.close();
	}

}
