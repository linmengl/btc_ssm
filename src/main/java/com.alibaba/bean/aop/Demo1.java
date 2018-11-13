package com.alibaba.bean.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class Demo1 {

	@Pointcut("execution(public int com.alibaba.bean.aop.TestAop.*(..))")
	public void pointCut() {
	}


	//该方法是一个前置通知：在目标方法开始前执行
	@Before("pointCut()")
	public void beforeMethod(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());

		System.out.println("The Method" + methodName + "begins with:" + args);
	}

	//后置通知：不论该方法是否异常都执行
	@After("pointCut()")
	public void afterMethod(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();

		System.out.println("The Method" + methodName + "ends");
	}

	//返回通知:在方法正常结束时执行，可以访问到方法的返回值
	@AfterReturning(value = "pointCut()", returning = "result")
	public void afterReturning(JoinPoint joinpoint, Object result) {
		String methodName = joinpoint.getSignature().getName();

		System.out.println("The Method" + methodName + "ends with:" + result);
	}

	//异常通知:可以访问到异常对象，且可以指定在出现特定异常时再执行
	@AfterThrowing(value = "pointCut()", throwing = "ex")
	public void afterThrowing(JoinPoint joinpoint, Exception ex) {
		String methodName = joinpoint.getSignature().getName();

		System.out.println("The Method" + methodName + "occurs excetion:" + ex);
	}

	//环绕通知:需携带ProceedingJoinPoint类型参数，类似动态代理中的全过程
	//环绕通知必须有返回值
	@Around("pointCut()")
	public Object aroundMethod(ProceedingJoinPoint pjd) {
		Object result = null;
		String methodName = pjd.getSignature().getName();

		try {
			//前置通知
			System.out.println("The method" + methodName + "begins with" + Arrays.asList(pjd.getArgs()));
			//执行目标方法
			result = pjd.proceed();
			//后置通知
			System.out.println("The method " + methodName + "ends with:" + result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The Method " + methodName + "occurs excetion:" + e);
		}
		//后置通知
		System.out.println("The Method" + methodName + "ends");

		return result;
	}

}
