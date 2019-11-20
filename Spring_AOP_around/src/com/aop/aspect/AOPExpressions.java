package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

/* Pointcut declarations for reusing purpose in advices.
 * With public access modifiers may be referenced from other classes. */
	
	@Pointcut("execution(* com.aop.dao.*.*(..))")
	public void daoPackage() {}
	
	@Pointcut("execution(* com.aop.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.aop.dao.*.set*(..))")
	public void setter() {}
	
	// Combined pointcut
	@Pointcut("daoPackage() && !(getter() || setter())")
	public void daoPackageNoGetterSetter() {}
	
	
}
