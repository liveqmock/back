package com.ihk.test;

import java.lang.reflect.Method;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 方法拦截器测试类
 * @author dtc
 * 2012-9-29
 */
public class MyMethodInterceptor implements MethodInterceptor{
	

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Method method = invocation.getMethod();
		String name = method.getName();
		
		System.out.println("method name: " + name);
		
		/*if("findSaleMonitorForSearchTime".equals(name)){
			Cache cache= CacheManager.getInstance().getCache(name);
			if(cache != null){
				return cache.get("key").getValue();
			}
		}*/
		
		return invocation.proceed();  //invocation.proceed()获取所拦截的方法的返回值
	}
	
	
	//--
	private String methodName;
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public String getMethodName() {
		return methodName;
	}


}
