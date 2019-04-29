package com.eangulee.springdemo.test;

import static org.junit.Assert.*;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eangulee.springdemo.config.MainConfig;
import com.eangulee.springdemo.model.Person;

public class MainTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainConfig.class);

		Person eangulee = (Person)app.getBean("eangulee");		
		System.out.println(eangulee.toString());
		
		Person person =  (Person)app.getBean("getperson");
		System.out.println(person.toString());
				
		System.out.println("getApplicationName:"+app.getApplicationName());
		System.out.println("getDisplayName:"+app.getDisplayName());
		
		String[] names = app.getBeanDefinitionNames();
		for(String name:names)
		{
			System.out.println("---->"+name);			
		}		
		app.close();
	}
}
