package com.eangulee.springdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalculatorAspect {
	@Pointcut("execution(public int com.eangulee.springdemo.aop.Calculator.*(..))")
	public void pointCut() {
	};

	// @before代表在目标方法执行前切入, 并指定在哪个方法前切入
	@Before("pointCut()")
	public void calculatorStart() {
		System.out.println("除法运行....参数列表是:{}");
	}

	@After("pointCut()")
	public void calculatorEnd() {
		System.out.println("除法结束......");
	}

	@AfterReturning(pointcut = "pointCut()", returning = "r")
	public void calculatorReturn(Object r) {
		System.out.println("除法正常返回......运行结果是:{}" + r);
	}

	@AfterThrowing(pointcut = "pointCut()", throwing = "a")
	public void calculatorException(Throwable a) {
		System.out.println("目标方法中抛出的异常:" + a);
		System.out.println("运行异常......异常信息是:{}");
	}

	@Around("pointCut()")
	public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("@Arount:执行目标方法之前...");
		Object[] args = proceedingJoinPoint.getArgs();
		for (Object a : args) {
			System.out.println("arg:" +a);
		}
		Object obj = proceedingJoinPoint.proceed();// 相当于开始调div地
		System.out.println("@Arount:执行目标方法之后...");
		return obj;
	}

}
