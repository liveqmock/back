package com.ihk.filter;

import javax.servlet.http.HttpServletRequest;

import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;

import com.ihk.utils.CacheUtils;

/**
 * 继承ehcache的SimplePageCachingFilter,重写其calculateKey方法,根据实际业务来返回cache的key
 * 该类主要用于页面缓存
 * @author dtc
 * 2012-11-27,下午03:00:22
 */
public class MySimplePageCachingFilter extends SimplePageCachingFilter{
	
	/**
	 * 只需重写该方法,过来ts参数及不考虑SessionUser.userId
	 */
	@Override
	protected String calculateKey(HttpServletRequest request) {
		
		return CacheUtils.getCacheKey(request);
	}
	
}
