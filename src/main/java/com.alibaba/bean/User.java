package com.alibaba.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by ml on 2018/11/4.
 */
@Component
public class User implements InitializingBean,DisposableBean {

    public void destroy() throws Exception {
        System.out.println("user---destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("user---afterPropertiesSet");
    }


    @PostConstruct
    public void init(){
        System.out.println("user-----init");
    }

    @PreDestroy
    public void destroys(){
        System.out.println("user-----destroys");
    }
}
