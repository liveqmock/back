package com.ihk.utils.request;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;

/**
 * HttpServletRequest帮助类
 * @author dtc
 * 2013-10-31,下午03:52:45
 */
public class HttpRequestUtils {
	
	/**
	 * 获取HttpServletRequest
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		
		return request;
	}

}
