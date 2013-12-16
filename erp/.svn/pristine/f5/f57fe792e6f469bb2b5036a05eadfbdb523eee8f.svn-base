package com.ihk.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihk.utils.CacheFrontName;
import com.ihk.utils.CacheUtils;
import com.ihk.utils.code.MyHttpServletResponseWrapper;

/**
 * 自定义的缓存过滤器过滤处理内容,建议用MySimplePageCachingFilter.java来代替
 * (最好使用ehcache的page cache,因为ehcache使用了gzip的压缩,而该方法只是对返回的html源码进行缓存)
 * @author dtc
 * 2012-12-4,下午04:56:16
 */
public class MyHttpServletResponseWrapperFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		MyHttpServletResponseWrapper myWrapper = new MyHttpServletResponseWrapper(res);
		
		String html = "";
		
		String cacheKey = CacheUtils.getCacheKey(req);
		Object value = CacheUtils.getValueByCacheNameAndKey(CacheFrontName.PAGE_CACHE, cacheKey);
		if(value == null){
			
			chain.doFilter(request, myWrapper);
			
			html = myWrapper.getContent(); 
			
			CacheUtils.add(CacheFrontName.PAGE_CACHE, cacheKey, html);
		}else{
			
			html = value.toString();
		}
		
	    response.getWriter().print(html);   
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
