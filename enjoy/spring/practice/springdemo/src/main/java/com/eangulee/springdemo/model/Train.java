package com.eangulee.springdemo.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Train implements InitializingBean,DisposableBean{

	public Train() {
		System.out.println("this is train's construct function.");		
	}

	//当我们的bean属性赋值和初始化完成时调用
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("this function invoke before train destroy.");		
	}
	
	//当我们bean销毁时,调用此方法
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("this function after train's afterPropertiesSet.");
	}

}
