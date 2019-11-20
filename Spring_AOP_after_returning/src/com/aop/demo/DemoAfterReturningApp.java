package com.aop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.dao.AccountDAO;


public class DemoAfterReturningApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class, JavaLoggerConiguration.class );

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
	
		List<Account> accounts = accountDAO.findAccounts();
		
		System.out.println("\nMAIN AFTER RETURNING: ");
		System.out.println(accounts);
		
		context.close();
		
	}

}
