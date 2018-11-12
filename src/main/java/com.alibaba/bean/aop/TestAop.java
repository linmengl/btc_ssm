package com.alibaba.bean.aop;

import java.util.Random;

public class TestAop {

	public int testAop(){
		System.out.println("test 方法执行…………");
		int index = new Random().nextInt(10);
		System.out.println(index);
		return 3;
	}

}
