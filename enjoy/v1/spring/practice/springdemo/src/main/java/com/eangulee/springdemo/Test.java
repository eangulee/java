package com.eangulee.springdemo;

import com.eangulee.springdemo.config.*;
import com.eangulee.springdemo.model.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ApplicationContext app = new AnnotationConfigApplicationContext(MainConfig.class);

		ApplicationContext app = new AnnotationConfigApplicationContext(MainScanConfig.class);
		
		Person person = app.getBean(Person.class);
		System.out.println(person.toString());
		
		System.out.println(person == app.getBean(Person.class));

		String[] beanNames = app.getBeanDefinitionNames();
		for (String n : beanNames) {
			System.out.println(n);
		}
	}

}
