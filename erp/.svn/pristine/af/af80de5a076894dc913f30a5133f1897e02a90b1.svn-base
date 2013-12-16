package com.ihk.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 自定义代理调用类(类似spring的ioc)
 * @author dtc
 * 2012-9-29
 */
public class CustomerProcessorHandler implements InvocationHandler {
	private Object target;
	
	public void setTarget(Object target) {
		this.target = target;
	}
	
	public Object getTarget() {
		return target;
	}
	
	CustomerProcessorHandler(Object target){
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("customer 业务调用之前-----");
		
		Object result = method.invoke(target, args);
		
		System.out.println("customer 业务调用之后*****");
		
		return result;
	}

}
