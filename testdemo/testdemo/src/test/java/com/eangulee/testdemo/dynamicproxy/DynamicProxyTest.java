package com.eangulee.testdemo.dynamicproxy;

import com.eangulee.testdemo.dynamicproxy.HoseeDynamic;
import com.eangulee.testdemo.dynamicproxy.HoseeDynamicimpl;
import com.eangulee.testdemo.dynamicproxy.MyProxy;

public class DynamicProxyTest {
	public static void main(String[] args) {
		MyProxy myproxy = new MyProxy();
		HoseeDynamicimpl dynamicimpl = new HoseeDynamicimpl();
		HoseeDynamic proxy = (HoseeDynamic) myproxy.bind(dynamicimpl);
		System.out.println(proxy.sayHi());
	}
}
