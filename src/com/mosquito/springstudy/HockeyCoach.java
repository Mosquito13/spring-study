package com.mosquito.springstudy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {

	private FortuneService fortuneService;
	
	@PostConstruct
	public void doAfterConstructAnyName() {
		System.out.println("I'm @PostConstruct method");
	}
	
	@PreDestroy
	public void doBeforeDestroyAnyName() {
		System.out.println("I'm @PreDestroy method");
	}
	
	@Autowired
	public HockeyCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Hit 100 slap shots";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
