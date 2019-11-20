package com.aop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.dao.AccountDAO;
import com.aop.service.TrafficFortuneService;

public class DemoAroundApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class,
				JavaLoggerConiguration.class);

		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMAIN PROGRAM: Around Demo");

		String result = fortuneService.getFortune();

		System.out.println("\nRESULT: " + result);

		System.out.println("FINISHED");
		
		context.close();

	}

}
