package com.mosquito.springstudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.mosquito.springstudy")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	@Bean
	public FortuneService randomFortuneService() {
		return new RandomFortuneService();
	}
	
	@Bean
	public Coach soccerCoach() {
		return new SoccerCoach(randomFortuneService());
	}
	
}
