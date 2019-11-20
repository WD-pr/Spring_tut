package com.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.spring.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.spring.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.spring.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() ||  forServicePackage() ||  forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n\t @Before the method: " + method);
		
		for (Object arg : joinPoint.getArgs()) {
			logger.info("\t -> argument: " + arg);
				
		}
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="result"
			)
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n\t @@AfterReturning the method: " + method);
		
		logger.info("\t -> result: " + result);
	}
	
}
