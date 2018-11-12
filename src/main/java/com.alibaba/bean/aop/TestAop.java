package com.alibaba.bean.aop;

import lombok.Data;

@Data
public class TestAop {
	private String msg = "aaa";

	public void test(){
		System.out.println("test 方法执行…………");
	}

}
