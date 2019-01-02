package com.eangulee.jedisdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;

import com.eangulee.jedisdemo.model.Person;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(value = "com.eangulee.jedisdemo", includeFilters = {
		@Filter(type = FilterType.CUSTOM, classes = { MainFilter.class }) }, useDefaultFilters = false)
public class MainScanConfig {
	@Scope("prototype") // 默认是单例，prototype为多实例
	@Bean("pppp") // bean的名字，默认不指定时为person(方法名)
	public Person person() {
		System.out.println("load test");
		return new Person("eangulee", 30);
	}
}
