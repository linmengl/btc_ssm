package com.btc.test;

import com.alibaba.bean.User;
import com.alibaba.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ml on 2018/11/4.
 */
public class SpringTest {
    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        User user = (User)applicationContext.getBean("user");
        System.out.println(user);
        applicationContext.close();

    }
}
