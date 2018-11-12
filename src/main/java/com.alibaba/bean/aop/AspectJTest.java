package com.alibaba.bean.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectJTest {

	@Pointcut("execution(* com.alibaba.bean.aop.TestAop.testAop(..))")
//	@Pointcut("execution(public int com.alibaba.bean.aop.TestAop.testAop(..))")
	public void pointCut(){}

	@Before("pointCut()")
	public void beforeTest(JoinPoint joinPoint){
		System.out.println("beforeTest……{"+joinPoint.getSignature().getName()+"}方法执行………………");
	}

	@After(value = "pointCut()")
	public void afterTest(){
		System.out.println("afterTest……方法执行………………");
	}

	@AfterReturning(value = "pointCut()",returning = "result")
	public void afterReturningTest(JoinPoint joinPoint,Object result){
		System.out.println(joinPoint.getSignature().getName()+"--afterReturningTest……方法执行………………,返回值为{"+result+"}");
	}

	@Around("pointCut()")
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
