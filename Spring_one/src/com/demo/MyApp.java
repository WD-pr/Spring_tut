package com.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		//Coach coach = context.getBean("coach", Coach.class);
		SwimmingCoach swimmingCoach = context.getBean("swimmingCoach", SwimmingCoach.class);
		SwimmingCoach swimmingCoachFile = context.getBean("swimmingCoachFile", SwimmingCoach.class);
		
		
		/*
		 * System.out.println(coach.getDailyWorkout());
		 * System.out.println(coach.getDailyFortune());
		 */
		System.out.println(swimmingCoach.getDailyWorkout());
		System.out.println(swimmingCoach.getDailyFortune());
		
		System.out.println(swimmingCoach);
		System.out.println(swimmingCoachFile);
		
		context.close();
	}

}
