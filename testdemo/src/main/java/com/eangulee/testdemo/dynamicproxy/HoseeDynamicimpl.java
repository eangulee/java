package com.eangulee.testdemo.dynamicproxy;

public class HoseeDynamicimpl implements HoseeDynamic {
	private static String st = "";

	@Override
	public String sayHi() {
		return st + "Welcome eangulee's blog";
	}

	static {

		st = "i am static ,";

	}
}
