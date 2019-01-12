package com.eangulee.testdemo.cglib;

public class CGlibProxyTest {
	public static void main(String[] args) {
		CGlibHosee cGlibHosee = new CGlibHosee();
		CGlibHoseeProxy cGlibHoseeProxy = new CGlibHoseeProxy();
		CGlibHosee proxy = (CGlibHosee) cGlibHoseeProxy.bind(cGlibHosee);
		System.out.println(proxy.sayhi());
	}
}
