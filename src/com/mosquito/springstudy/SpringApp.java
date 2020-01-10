package com.mosquito.springstudy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach1 = context.getBean("hockeyCoach", Coach.class);
		Coach coach2 = context.getBean("hockeyCoach", Coach.class);
		
		System.out.println("\n== Singleton Scope ==");
		System.out.println(coach1.getDailyWorkout());
		System.out.println(coach1.getDailyFortune());
		System.out.println("Coach 1: " + coach1);
		System.out.println("Coach 2: " + coach2);
		System.out.println("Are equal: " + (coach1 == coach2));
		

		coach1 = context.getBean("soccerCoach", Coach.class);
		coach2 = context.getBean("soccerCoach", Coach.class);
		
		System.out.println("\n== Prototype Scope ==");
		System.out.println(coach1.getDailyWorkout());
		System.out.println(coach1.getDailyFortune());
		System.out.println("Coach 1: " + coach1);
		System.out.println("Coach 2: " + coach2);
		System.out.println("Are equal: " + (coach1 == coach2));
		
		context.close();
	}

}
