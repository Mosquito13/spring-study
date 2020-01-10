package com.mosquito.springstudy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("hockeyCoach", Coach.class);
		
		System.out.println("\n== Constructor injection ==");
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		coach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println("\n== Setter injection ==");
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		coach = context.getBean("soccerCoach", Coach.class);
		
		System.out.println("\n== Method injection ==");
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		coach = context.getBean("trackCoach", Coach.class);
		
		System.out.println("\n== Field injection ==");
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		context.close();
	}

}
