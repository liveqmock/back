package com.ihk.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.ihk.utils.CacheFrontName;
import com.ihk.utils.CacheUtils;

/**
 * codeType方法拦截器
 * @author dtc
 * 2012-9-27
 */
public class CodeTypeMethodInterceptor extends BaseMethodInterceptor implements
		MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Method method = invocation.getMethod();
		String methodName = method.getName();
		
		String cacheName = CacheFrontName.CODE_TYPE + methodName;
		
		if(!isCheck(methodName)){
			
			return invocation.proceed();
			
		}else{
			if(methodName.startsWith("find")){
				String key = CacheUtils.getCacheKey(CacheUtils.objArrToString(invocation.getArguments()));
				
				Object obj = CacheUtils.getValueByCacheNameAndKey(cacheName, key);
				if(obj == null){
					
					Object value = invocation.proceed();  //正常流程的返回值
					CacheUtils.put(cacheName, key, value);
					
					return value;
				}else{
					
					return obj;
				}
				
			}else{
				CacheUtils.removeCacheByLikeCacheName(CacheFrontName.CODE_TYPE);
				
				return invocation.proceed();
			}
		}
		
	}

}
