package com.ihk.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.ihk.utils.CacheUtils;
import com.ihk.utils.PermissionCacheName;

/**
 * PRIV方法拦截器
 * @author dtc
 * 2012-9-27
 */
public class PrivMethodInterceptor extends BaseMethodInterceptor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Method method = invocation.getMethod();
		String methodName = method.getName();
		
		String cacheName = PermissionCacheName.PRIV + methodName;
		
		if(!isCheck(methodName)){
			
			return invocation.proceed();
		}else{
			if(methodName.startsWith("find")){
				String key = CacheUtils.getCacheKey(CacheUtils.objArrToString(invocation.getArguments()));
				
				//String key = SessionUser.getUserIdStr(); //这样会有问题,因为缓存的作用域要大于session ?
				
				Object obj = CacheUtils.getValueByCacheNameAndKey(cacheName, key);
				if(obj == null){
					
					Object value = invocation.proceed();  //正常流程的返回值
					CacheUtils.put(cacheName, key, value);
					
					return value;
				}else{
					
					return obj;
				}
				
			}else{
				CacheUtils.removeCacheByLikeCacheName(PermissionCacheName.PRIV);
				
				return invocation.proceed();
			}
		}
		
		
	}

}
