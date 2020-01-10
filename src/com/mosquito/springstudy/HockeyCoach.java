package com.mosquito.springstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {

	private FortuneService fortuneService;
	
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
