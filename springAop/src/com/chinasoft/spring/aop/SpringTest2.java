package com.chinasoft.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring aop 面向切面编程
 * 		aop 面向切面编程
 *  		它允许程序员对横切关注点或横切典型的职责分界线的行为（例如日志和事务管理）进行模块化
 * 			aop是面向切面编程，定义一个切面，像一把刀一样，将程序暂时阻断，可以在方法执行之前，或者执行的过程中，
 * 		或者方法执行完成时插入一段我们想要的代码，通常我们可以用来做事务管理和日志管理（如性能监测，访问控制，事务管理、缓存、对象池管理）
 * 	
 * 		advice 通知（切面）
 * 			before advice方法执行之前调用
 * 			after  advice方法执行之后调用
 * 			after-throwing  advice方法执行过程中抛出异常时调用
 *          around advice方法执行前后和抛出异常时调用
 *          
 * 		JoinPoint org.aspectj.lang.JoinPoint包
 * 			JoinPoint包含的对象有
 * 				target:通过joinPoint.getTarget()获取的是切入点的对象
 * 				name:joinPoint.getTarget().getClass().getName()获取切入点对象全路径
 * 				method: joinPoint.getSignature().getName()获取切入点的方法
 * @author Administrator
 *
 */
public class SpringTest2 {
	
	public void print(){
		System.out.println("打印方法。。。。");
		
	}
	private String print1(){
		System.out.println("打印1方法。。。。");
		return "";
	}
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("classpath:spring.xml");
		SpringTest2 test=(SpringTest2)applicationContext.getBean("springTest2");
		test.print1();
	}
}
