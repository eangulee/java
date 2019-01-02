package com.eangulee.jedisdemo.test;

import static org.junit.Assert.*;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eangulee.jedisdemo.config.MainConfig;
import com.eangulee.jedisdemo.model.Person;

public class MainTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainConfig.class);
		
		Person person = app.getBean(Person.class);
		System.out.println(person.toString());
				
		System.out.println("getApplicationName:"+app.getApplicationName());
		System.out.println("getDisplayName:"+app.getDisplayName());
		
		String[] names = app.getBeanDefinitionNames();
		for(String name:names)
		{
			System.out.println("---->"+name);			
		}		
	}
}
