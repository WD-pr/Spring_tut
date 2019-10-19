package com.demo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Just run 1 km";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
