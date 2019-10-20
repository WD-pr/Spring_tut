package com.demo;

import org.springframework.stereotype.Component;

@Component
public class SadFortuneService implements FortuneService{

	@Override
	public String getFortune() {
		return "It's rainy, sad day.";
	}

	
}
