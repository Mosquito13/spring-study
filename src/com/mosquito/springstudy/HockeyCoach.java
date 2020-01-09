package com.mosquito.springstudy;

import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Hit 100 slap shots";
	}

}
