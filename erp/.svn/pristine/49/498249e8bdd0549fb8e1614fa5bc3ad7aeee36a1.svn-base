package com.ihk.utils.code;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 
 * 利用装饰模式来处理请求参数,在过滤器中使用(用了tomcat,好像可以不用使用)
 * @author dtc
 *
 */
public class UrlCodeHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public UrlCodeHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {  
		
		String value = super.getParameter(name);
		
		return UrlCodeUtils.myDecode(value);
	}
	

}
