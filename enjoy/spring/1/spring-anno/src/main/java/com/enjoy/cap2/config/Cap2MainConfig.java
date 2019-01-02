package com.enjoy.cap2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import com.enjoy.cap1.Person;
import com.enjoy.cap2.controller.OrderController;

@Configuration
@ComponentScan(value="com.enjoy.cap2", includeFilters={		
		@Filter(type=FilterType.CUSTOM, classes={JamesTypeFilter.class})		
}, useDefaultFilters=false)


public class Cap2MainConfig {
	//��������ע��һ��bean, ����Ϊ����ֵ������, 
	@Bean
	public Person person01(){
		return new Person("james",20);
	}
}