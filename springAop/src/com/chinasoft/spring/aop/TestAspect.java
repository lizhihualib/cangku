package com.chinasoft.spring.aop;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;

/**
 * 切面
 * @author Administrator
 *
 */
public class TestAspect {	
	/*public void doBefore(JoinPoint jp){
		System.out.println("在执行打印之前调用该方法");
	}
	public void doAfter(JoinPoint jp){
		System.out.println("在执行打印之后调用该方法");
	}
	public void doThrowing(JoinPoint jp){
		System.out.println("在执行时跑异常调用该方法");
	}*/
	public void doAround(JoinPoint jp){
		System.out.println("在执行打印之前调用该方法");
		
		try {
			Method method=jp.getTarget().getClass().getMethod(jp.getSignature().getName());
			method.invoke(jp.getTarget());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
			System.out.println("在执行时抛异常调用该方法");
		}
		
		System.out.println("在执行打印之后调用该方法");
	}
}
