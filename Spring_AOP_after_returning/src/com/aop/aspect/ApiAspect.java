package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAspect {

	
	@Before("com.aop.aspect.AOPExpressions.daoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n\t Executing @Before Advice");
	}
}
