package com.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationScopeApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach firstCoach = context.getBean("swimmingCoach", Coach.class);
		
		Coach secondCoach = context.getBean("swimmingCoach", Coach.class);
		
		System.out.println("Is the same object? " + (firstCoach == secondCoach));
		
		context.close();
	}

}
