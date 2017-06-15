package com.chinasoft.spring.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler{
	
	private Object subObjct;
	public DynamicProxy(Object subObjct) {
		
		this.subObjct = subObjct;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//
		System.out.println("在方法执行之前打印");
		
		System.out.println("method:"+method.getName());
		
		//方法的执行时
		method.invoke(subObjct, args);
		
		System.out.println("在方法执行之后调用");
		
		return null;
	}

}
