package com.alibaba.bean.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectJTest {

	@Pointcut("execution(* *.test(..))")
	public void test(){}

	@Before("test()")
	public void beforeTest(){
		System.out.println("beforeTest……方法执行………………");
	}
	@After(value = "test()")
	public void afterTest(){
		System.out.println("afterTest……方法执行………………");
	}

	@Around("test()")
	public void aroundTest(ProceedingJoinPoint joinPoint){
		System.out.println("aroundTest……方法执行前………………");
		try {
			joinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		System.out.println("aroundTest……方法执行后………………");
	}

}
