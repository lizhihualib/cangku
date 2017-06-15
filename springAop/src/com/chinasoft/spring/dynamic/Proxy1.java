package com.chinasoft.spring.dynamic;

public class Proxy1 implements SubObjct{
	private SubObjct subObjct;
	
	public Proxy1(SubObjct subObjct) {
		
		this.subObjct = subObjct;
	}
	@Override
	public void sayHello(String str) {
		// TODO Auto-generated method stub
		System.out.println("在放调用之前打印");
		subObjct.sayHello(str);
		System.out.println("在放调用之后打印");
	}

}
