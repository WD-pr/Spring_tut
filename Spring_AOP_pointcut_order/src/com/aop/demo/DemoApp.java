package com.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.dao.AccountDAO;
import com.aop.dao.MembershipDAO;


public class DemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class, JavaLoggerConiguration.class );

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
	
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		Account account = new Account();
		account.setLevel("Platinum");
		account.setName("Eura");
		
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		
		accountDAO.setName("ffoo");
		accountDAO.setServiceCode("C200");
		
		accountDAO.getName();
		accountDAO.getServiceCode();
		
		
		membershipDAO.addMembershipAccount();
		membershipDAO.doWork();
		
		context.close();
		
	}

}
