package com.config;

import org.springframework.beans.factory.annotation.Value;

public class SkiJumpCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${email}")
	private String email;
	
	@Value("${team}")
	private String team;
	
	public SkiJumpCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Jump over 120 meters at least 5 times";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public String toString() {
		return "SkiJumpCoach [email=" + email + ", team=" + team + "]";
	}
	

}
