package com.demo;

import org.springframework.stereotype.Component;

/*Using default bean id - swimmingCoach - instead of specified one: 
@Component("myCoach")*/
@Component
public class SwimmingCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice backstroke swimming";
	}

}
