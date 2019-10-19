package com.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleApp {

	/*
	 * Testing bean lifecycle - defined init and destroy method. 
	 * 
	 * Spring does not manage the complete lifecycle of a 'prototype' bean: the container
	 * instantiates, configures, and otherwise assembles a prototype object, and
	 * hands it to the client, with no further record of that prototype instance.
	 * 
	 * Initialization lifecycle callback methods are called on all
	 * objects regardless of scope, in the case of 'prototypes', configured
	 * destruction lifecycle callbacks are not called.
	 */

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lifecycleApplicationContext.xml");

		Coach coach = context.getBean("coach", Coach.class);

		context.close();

	}

}
