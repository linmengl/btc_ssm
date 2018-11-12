package com.test;

import com.alibaba.bean.aop.TestAop;
import com.alibaba.config.MainConfigOfAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
	@Test
	public void aopTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
		TestAop testAop = context.getBean(TestAop.class);
		testAop.testAop();
	}
}
