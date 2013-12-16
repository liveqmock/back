package com.ihk.interceptor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ihk.utils.CommonUtils;

import net.sf.ehcache.Cache;


/**
 * 
 *  拦截器的基础类,可以在基础类中配置指定的cache,及不拦截的方法...
 * 
 */
public class BaseMethodInterceptor{
	
	protected Cache cache; //可以在配置文件中指定Cache
	
	protected List<String> exPatternInterceptor; //利用正则设置不拦截的方法名, <property name="exPatternInterceptor" value=".*"/>表示所有的方法都不拦截
	
	private List<String> baseExPatternInterceptor; //基础过滤方法
	
	public void setBaseExPatternInterceptor(
			List<String> baseExPatternInterceptor) {
		this.baseExPatternInterceptor = baseExPatternInterceptor;
	}
	
	public List<String> getBaseExPatternInterceptor() {
		return baseExPatternInterceptor;
	}
	
	public void setCache(Cache cache) {
		this.cache = cache;
	}
	
	public Cache getCache() {
		return cache;
	}
	
	public void setExPatternInterceptor(List<String> exPatternInterceptor) {
		this.exPatternInterceptor = exPatternInterceptor;
	}
	
	public List<String> getExPatternInterceptor() {
		return exPatternInterceptor;
	}
	
	/**
	 * 判断方法名是否为不验证
	 * @param exPatternInterceptor
	 * @param methodName
	 * @return
	 */
	private boolean isPattern(List<String> exPatternInterceptor, String methodName){
		
		for(String exInterceptor : exPatternInterceptor){
			
			if(CommonUtils.isStrEmpty(exInterceptor))
				continue;
			
			Pattern pattern = Pattern.compile(exInterceptor);
			Matcher matcher = pattern.matcher(methodName);
			boolean isMatcher = matcher.matches();
			
			if(isMatcher){
				return true;
			}
			
		}
		
		return false;
	}
	
	/**
	 *
	 * 判断是否要进行缓存的检查,自身的过滤和基础过滤,如果exInterceptor中有就不用检查(返回false),否则就要检查(返回true)
	 * 如果不想验证基础过滤,可以单个interceptor加上<property name="exPatternInterceptor" value=".*"/>
	 * @param methodName
	 * @return
	 */
	protected boolean isCheck(String methodName){
		
		if(CommonUtils.isCollectionEmpty(exPatternInterceptor)){
			
			//要再去判断基础exInterceptor是否有,如果不想验证基础过滤,可以单个interceptor加上<property name="exPatternInterceptor" value=".*"/>
			baseExPatternInterceptor = BaseExPatternInterceptorMethodName.getBaseExPatternInterceptor();
			if(CommonUtils.isCollectionEmpty(baseExPatternInterceptor)){
				
				return true;
				
			}else{
				if(isPattern(baseExPatternInterceptor, methodName)){
					
					return false;
				}else{
					
					return true;
				}
			}
			
		}else{
			
			//单个interceptor的exPatternInterceptor有值就不去判断baseExPatternInterceptor
			if(isPattern(exPatternInterceptor, methodName)){
				
				return false;
			}else{
				
				return true;
			}
		}
	}
}
