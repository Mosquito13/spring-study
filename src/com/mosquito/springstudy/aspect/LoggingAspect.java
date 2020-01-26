package com.mosquito.springstudy.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(* com.mosquito.springstudy.dao.*.*(..))")
	private void allDaoClassMethods() {}
	
	@Pointcut("execution(* com.mosquito.springstudy.dao.*.set*(..))")
	private void allDaoClassSetter() {}
	
	@Pointcut("execution(* com.mosquito.springstudy.dao.*.get*(..))")
	private void allDaoClassGetter() {}
	
	@Pointcut("allDaoClassMethods() && !allDaoClassSetter() && !allDaoClassGetter()")
	private void allDaoClassNoSetterGetterMethod() {}
	
	@Before("allDaoClassNoSetterGetterMethod()")
	public void beforeDaoMethods() {
		System.out.println("before - advice");
	}
	
	@Before("allDaoClassNoSetterGetterMethod()")
	public void beforeDaoMethodsAnotherOne() {
		System.out.println("i'm another");
	}
	
}
