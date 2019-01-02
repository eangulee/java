package com.eangulee.jedisdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.eangulee.jedisdemo.model.Person;

@ComponentScan(value="com.eangulee.jedisdemo")
@Configuration//标记为一个配置类===配置文件 
public class MainConfig {
//	@Lazy//懒加载，也不是延迟加载，而是用到该方法时（取当前bean）才实例化
	@Scope("prototype")//默认是单例，prototype为多实例
	@Bean("pppp")//bean的名字，默认不指定时为person(方法名)
	public Person person() {
		System.out.println("load test");
		return new Person("eangulee",30);
	}
}
