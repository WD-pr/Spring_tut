package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aop.demo.Account;

/* @Order annotation specifies precedence of aspect execution. 
 * Lower number has higher priority. Negative numbers are allowed.*/

@Aspect
@Component
@Order(2)
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
	

	@Before("com.aop.aspect.AOPExpressions.daoPackageNoGetterSetter()")
	public void performAdvice(JoinPoint joinPoint) {
		
		System.out.println("\t Executing Perform Advice");
	
		MethodSignature methodSign = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + methodSign);
		
		for(Object arg : joinPoint.getArgs()) {
			System.out.println(arg);
			
			if(arg instanceof Account) {
				
				Account account = (Account) arg;
				
				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());
				
			}
		}
		
	}

	
}
