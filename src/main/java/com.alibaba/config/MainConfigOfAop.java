package com.alibaba.config;

import com.alibaba.bean.aop.TestAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {

	@Bean
	public TestAop testAop(){
		return new TestAop();
	}
}
