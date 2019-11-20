package com.aop.aspect;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
	
	
	/*
	 * @After advice is executed after specified method execution. 
	 * Executes regardless of the outcome, in case of method success and a failure 
	 * - performs like a finally block.
	 * Advice is executed before @AfterThrowing advice.  
	 */

	@After("execution(* com.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

		String method = joinPoint.getSignature().toShortString();

		System.out.println("\n\t Executing @After (finally) Advice on: " + method);

	}
	
	
	/*
	 * @AfterThrowing advice is executed after an exception is thrown in a specified
	 * method. Enables logging before exceptions propagation to the main program. 
	 * throwing - specifies optional name for method exception
	 */

	@AfterThrowing(pointcut = "execution(* com.aop.dao.AccountDAO.findAccounts(..))", throwing = "exp")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exp) {

		String method = joinPoint.getSignature().toShortString();

		System.out.println("\n\t Executing @AfterThrowing Advice on: " + method);
		System.out.println("\t Exception: " + exp);


	}
	

	/*
	 * @AfterReturning advice is executed after successful execution of specified
	 * method. Enables result modification before returning it to the method caller.
	 * returning - specifies optional name for method result
	 */

	@AfterReturning(pointcut = "execution(* com.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

		String method = joinPoint.getSignature().toShortString();

		System.out.println("\n\t Executing @AfterReturning Advice");
		System.out.println("\t Result: " + result);

		// RESULT MODIFICATION
		convertAccountNamesToUpperCase(result);

		System.out.println("\t Result after modification : " + result);

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		result.forEach(a -> {
			String name = a.getName().toUpperCase();
			a.setName(name);
		});
		
	}

	/*
	 * Adding @Before advice for specified method using pointcut expression language
	 * Examples execution(public * addAccount()) execution(void addAccount())
	 * execution(* add*()) execution(* com.aop.dao.AccountDAO.addAccount())
	 * execution(* *()) execution(* com.aop.*.AccountDAO.addAccount()) execution(*
	 * com.aop.dao.*.*()) - any class and any method in a specified package
	 * execution(void addAccount(*)) - one argument of any type execution(void
	 * addAccount(..)) - any number argument of any type execution(*
	 * add*(com.aop.demo.Account)) - need fully qualified class name execution(*
	 * add*(com.aop.demo.Account, boolean)) execution(* add*(com.aop.demo.Account,
	 * ..))
	 */

	@Before("com.aop.aspect.AOPExpressions.daoPackageNoGetterSetter()")
	public void performAdvice(JoinPoint joinPoint) {

		System.out.println("\t Executing Perform Advice");

		MethodSignature methodSign = (MethodSignature) joinPoint.getSignature();

		System.out.println("Method: " + methodSign);

		for (Object arg : joinPoint.getArgs()) {
			System.out.println(arg);

			if (arg instanceof Account) {

				Account account = (Account) arg;

				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());

			}
		}

	}

}
