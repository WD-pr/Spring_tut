
package com.demo;

public class SwimmingCoach implements Coach{

	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getDailyWorkout(){
		return "Swim for 30 min";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public String toString() {
		return "SwimmingCoach [fortuneService=" + fortuneService + ", emailAddress=" + emailAddress + ", team=" + team
				+ "]";
	}
	
	
}
