package com.test;

import com.alibaba.bean.aop.MathCalculate;
import com.alibaba.config.MainConfigOfAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
	@Test
	public void aopTest(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
		MathCalculate calculate = applicationContext.getBean(MathCalculate.class);
		int res = calculate.calculate(5,3);
		System.out.println(res);
	}
}
