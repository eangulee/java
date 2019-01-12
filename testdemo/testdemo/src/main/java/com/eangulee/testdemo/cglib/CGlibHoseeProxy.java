package com.eangulee.testdemo.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGlibHoseeProxy {
	Object obj;

	public Object bind(final Object target) {
		this.obj = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(obj.getClass());
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				System.out.println("I'm proxy!");
				Object res = method.invoke(target, args);
				return res;
			}
		});
		return enhancer.create();
	}
}
