package com.ihk.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 *  权限缓存中的funcTree
 * 
 */
public class FuncTreeMethodInterceptor extends BaseMethodInterceptor implements MethodInterceptor{
	

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//该方法暂时不用
		Method method = invocation.getMethod();
		String methodName = method.getName();
		
		System.out.println(methodName);
		
		return invocation.proceed();
	}

}
