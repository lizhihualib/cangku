package com.chinasoft.spring.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class Test {
	public static void main(String[] args) {
		//要代理的真实对象
		SubObjct realObject=new SubObjectImpl();
		//代理对象，指明将要代理哪个真实对象
		InvocationHandler handler=new DynamicProxy(realObject);
		//通过Proxy的newProxyInstance方法来创建我们的代理的对象
		//
		SubObjct subObjct=(SubObjct) Proxy.newProxyInstance(handler.getClass().getClassLoader(), 
				realObject.getClass().getInterfaces(), 
				handler);
	
		subObjct.sayHello("的说法是电风扇");
		
		Buy realBuy=new BuyApple();
		InvocationHandler handler1=new DynamicProxy(realBuy);
		Buy buy=(Buy) Proxy.newProxyInstance(handler1.getClass().getClassLoader(), 
				realBuy.getClass().getInterfaces(), 
				handler1);
		buy.buy();
		
	}
}
