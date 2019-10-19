package com.demo;

public class BaseballCoach implements Coach {

	private FortuneService fortuneService;

	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "Spend 50 minuts playing Baseball";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	// init method
	public void initBaseballCoach() {
		System.out.println("BaseballCoach - init");
	}

	// destroy method
	public void destroyBaseballCoach() {
		System.out.println("BaseballCoach - destroy");
	}
}
