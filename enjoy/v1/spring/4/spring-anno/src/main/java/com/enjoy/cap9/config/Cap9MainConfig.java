package com.enjoy.cap9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.enjoy.cap9.dao.TestDao;

@Configuration
@ComponentScan({"com.enjoy.cap9.controller","com.enjoy.cap9.service"})
public class Cap9MainConfig {
	//spring进行自装配的时候默认首选的bean
	@Primary
	@Bean("testDao2")
	public TestDao testDao(){
		TestDao testDao = new TestDao();
		testDao.setFlag("2");
		return testDao;
	}
//	
//	@Bean("testDao1")
//	public TestDao testDao1(){
//		TestDao testDao = new TestDao();
//		return testDao;
//	}
}
