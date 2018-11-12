package com.alibaba.bean.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestEvent {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyListener.class);
		MyEvent myEvent = new MyEvent("hello", "msgggg");
		context.publishEvent(myEvent);
	}
}
