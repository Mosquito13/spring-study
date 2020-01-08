package com.mosquito.springdemo;

public class HockeyCoach implements Coach {

	private FortuneService fortuneService;
	
	private String team;
	
	private String player;
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public void setPlayer(String player) {
		this.player = player;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Team: " + team + ", Player: " + player + ", Drill: Hit 100 slap shots";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
