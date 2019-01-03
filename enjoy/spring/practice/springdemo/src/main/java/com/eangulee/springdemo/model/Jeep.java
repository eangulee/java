package com.eangulee.springdemo.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Jeep {
	
	public Jeep() {
		System.out.println("this is jeep's constructor function.");		
	}

	@PostConstruct
	public void init() {
		System.out.println("this is jeep's init function.");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("this is jeep's destroy function.");
	}
}
