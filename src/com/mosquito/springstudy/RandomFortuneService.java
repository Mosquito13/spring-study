package com.mosquito.springstudy;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] fortunes = {
		"Mario",
		"Link",
		"Crash"
	};
	
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		int index = random.nextInt(fortunes.length);
		
		return fortunes[index];
	}

}
