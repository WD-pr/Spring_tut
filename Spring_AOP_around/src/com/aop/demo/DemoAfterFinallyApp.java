package com.aop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.dao.AccountDAO;


public class DemoAfterFinallyApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class, JavaLoggerConiguration.class );

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = null;
		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nMAIN AFTER THROWING: ");
		System.out.println(accounts);
		
		context.close();
		
	}

}
