package com.eangulee.springdemo.config;

import org.springframework.beans.factory.FactoryBean;

import com.eangulee.springdemo.model.Person;

public class EanguleeFactoryBean implements FactoryBean<Person> {

	@Override
	public Person getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Person("eangulee",20);
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Person.class;
	}
	
	public boolean isSingleton() {
		return true;
	}
}
