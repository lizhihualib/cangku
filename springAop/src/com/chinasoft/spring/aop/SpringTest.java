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
 * 
 * 		expression
 * 			execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? 
 * 					name-pattern(param-pattern) thows-pattern?)
 * 			modifiers-pattern 表示访问修饰符 ，*，public..
 * 			ret-type-pattern  方法的返回类型
 * 			declaring-type-pattern 	name-pattern 表示要切入的方法名
 * 			param-pattern 方法的参数列表
 * 			thows-pattern 要抛出的异常
 * 
 * 		动态代理（http://www.cnblogs.com/xiaoluo501395377/p/3383130.html）
 * 			InvocationHandler(interface) 代理对象
 * 				invoke(Object target,Method method,Object[] args)
 * 					target指代我们所代理的那个真实对象
 * 					method:　　指代的是我们所要调用真实对象的某个方法的Method对象
 * 					args:　　指代的是调用真实对象某个方法时接受的参数
 * 			Proxy(class) 这个类的作用就是用来动态创建一个代理对象的类
 * 				Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces,  InvocationHandler handler)
 * 					loader 类加载器
 * 					interfaces 要代理的对象的class接口
 * 					handler 代理对象
 * 
 * @author Administrator
 * 
 * 
 *
 */
public class SpringTest {
	
	public void print(){
		System.out.println("打印方法。。。。");
		throw new RuntimeException();
	}
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("classpath:spring.xml");
		SpringTest test=(SpringTest)applicationContext.getBean("springTest");
		test.print();
	}
}
