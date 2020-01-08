package com.mosquito.springdemo;

public class BaseballCoach implements Coach {

	private FortuneService fortuneService;

	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return "Xesque: " + fortuneService.getFortune();
	}

	public void initMethodAnyName() {
		System.out.println("BaseballCoach init");
	}
	
	public void destroyMethodAnyName() {
		System.out.println("BaseballCoach destroy");
	}
}
