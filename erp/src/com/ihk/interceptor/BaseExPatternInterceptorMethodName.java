package com.ihk.interceptor;

import java.util.List;

/**
 * 基础拦截器
 * @author dtc
 * 2012-9-27
 */
public class BaseExPatternInterceptorMethodName {
	
	private static List<String> baseExPatternInterceptor; //基础过滤方法
	
	public void setBaseExPatternInterceptor(
			List<String> baseExPatternInterceptor) {
		BaseExPatternInterceptorMethodName.baseExPatternInterceptor = baseExPatternInterceptor;
	}
	
	public static List<String> getBaseExPatternInterceptor() {
		return baseExPatternInterceptor;
	}

}
