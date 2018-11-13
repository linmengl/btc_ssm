package com.alibaba.bean.aop;

import java.util.Random;

public class TestAop {

	public int getIndex(){
		System.out.println("getIndex 方法执行…………");
		return new Random().nextInt(10);
	}

}
