package com.demo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = { "Watch out today", "Today is your lucky day", "It's beautiful day."};
	
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		
		return data[random.nextInt(data.length)];
	}

}
