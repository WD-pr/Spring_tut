package com.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeApp {

	/*
	 * Testing bean scope. Default bean scope is set to 'singleton', if changed
	 * to 'prototype' object instance is created each time it is referenced.
	 */	
	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("scopeApplicationContext.xml");
		
		Coach coach = context.getBean("coach",Coach.class);
		Coach secondCoach = context.getBean("coach",Coach.class);
				
		
		System.out.printf("Pointing to the same coach? %b \n",coach == secondCoach);
		
		context.close();
		
	}

}
