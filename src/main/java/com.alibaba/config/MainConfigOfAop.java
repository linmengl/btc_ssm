package com.alibaba.config;

import com.alibaba.bean.aop.AspectJTest;
import com.alibaba.bean.aop.MathCalculate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {

	@Bean
	public MathCalculate mathCalculate() {
		return new MathCalculate();
	}

	@Bean
	public AspectJTest aspectJTest() {
		return new AspectJTest();
	}
}
