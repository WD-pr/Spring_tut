package com.config;

public class SadFortuneService implements FortuneService{

	@Override
	public String getFortune() {
		return "It's rainy, sad day.";
	}

	
}
