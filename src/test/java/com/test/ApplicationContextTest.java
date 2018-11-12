package com.test;

import com.alibaba.bean.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class ApplicationContextTest {
	@Test
	public void testApplicationContext(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		User user = (User) applicationContext.getBean("user");
		System.out.println(user);
	}


	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal("55");
		BigDecimal multiply = bigDecimal.pow(2);
		System.out.println(multiply.toString());
	}
}
