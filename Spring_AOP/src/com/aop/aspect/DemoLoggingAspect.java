package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

	/* Adding @Before advice for specified method using pointcut expression language
	 * Examples
	 *  execution(public * addAccount())
	 *  execution(void addAccount())
	 *  execution(* add*())
	 *  execution(* com.aop.dao.AccountDAO.addAccount())
	 *  execution(* *())
	 *  execution(* com.aop.*.AccountDAO.addAccount())
	 *  execution(* com.aop.dao.*.*()) - any class and any method in a specified package
	 *  execution(void addAccount(*)) - one argument of any type
	 *  execution(void addAccount(..)) - any number argument of any type
	 *  execution(* add*(com.aop.demo.Account)) - need fully qualified class name
	 *  execution(* add*(com.aop.demo.Account, boolean))
	 *  execution(* add*(com.aop.demo.Account, ..))
	 *  */
	@Before("execution(* com.aop.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\t Executing @Before Advice");
	}
}
