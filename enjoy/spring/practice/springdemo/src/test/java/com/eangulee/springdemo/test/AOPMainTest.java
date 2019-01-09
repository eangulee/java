package com.eangulee.springdemo.test;

import static org.junit.Assert.*;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eangulee.springdemo.aop.Calculator;
import com.eangulee.springdemo.config.AOPMainConfig;
import com.eangulee.springdemo.config.MainConfig;
import com.eangulee.springdemo.model.Person;

public class AOPMainTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AOPMainConfig.class);

		Calculator calc = app.getBean(Calculator.class);
		calc.div(3, 2);
		app.close();
	}
}
