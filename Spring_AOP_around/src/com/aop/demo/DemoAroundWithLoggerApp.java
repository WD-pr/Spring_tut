package com.aop.demo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.dao.AccountDAO;
import com.aop.service.TrafficFortuneService;

public class DemoAroundWithLoggerApp {

	/* Using the same logger as Spring - to avoid streaming issues*/
	private static Logger logger = Logger.getLogger(DemoAroundWithLoggerApp.class.getName());
	
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class,
				JavaLoggerConiguration.class);

		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		logger.info("\nMAIN PROGRAM: Around Demo");

		boolean tripWire = true;
		String result = fortuneService.getFortune(tripWire);

		logger.info("\nRESULT: " + result);

		logger.info("FINISHED");
		
		context.close();

	}

}
