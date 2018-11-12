package com.test;

import com.alibaba.bean.User;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import java.io.InputStream;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:*.xml"})
@ContextConfiguration
public class BeanFactoryTest {


	@Test
	public void test() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//Object o = context.getBean("user");
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		User user = (User)factory.getBean("user");
		System.out.println(user);
	}

	public static void main(String[] args) {
		String arr[] = StringUtils.tokenizeToStringArray("q,d,f",",");
		for (String a:arr) {
			System.out.println(a);
		}

		int i = System.identityHashCode(arr);
		System.out.println(i);

	}

}
