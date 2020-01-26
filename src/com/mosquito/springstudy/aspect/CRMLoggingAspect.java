package com.mosquito.springstudy.aspect;

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

	@Pointcut("execution(* com.mosquito.springstudy.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.mosquito.springstudy.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.mosquito.springstudy.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		logger.info("=> @Before: " + joinPoint.getSignature().toShortString());

		Object[] args = joinPoint.getArgs();

		for (Object arg : args) {
			logger.info("==> " + arg);
		}
	}

	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("=> @AfterReturning: " + joinPoint.getSignature().toShortString());
		logger.info("Returning: " + result);
	}
}
