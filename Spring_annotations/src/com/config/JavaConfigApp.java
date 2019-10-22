package com.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class, com.log.JavaLoggerConiguration.class);

		// Retrieve bean using java bean configuration code
		
		Coach coach = context.getBean("skiCoach", Coach.class);

		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.toString());

		System.out.println("\t ----------");
		
		// Retrieve bean using component scan
		
		com.demo.Coach secondCoach = context.getBean("swimmingCoach", com.demo.Coach.class);

		System.out.println(secondCoach.getDailyWorkout());
		System.out.println(secondCoach.getDailyFortune());
		System.out.println(secondCoach.toString());

		
		context.close();
	}

}
