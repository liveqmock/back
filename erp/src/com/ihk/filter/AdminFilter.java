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

import com.ihk.utils.CommonUtils;

/**
 * 权限过滤器,避免没有登录而直接通过url来访问
 * @author dtc
 * 2012-9-27
 */
public class AdminFilter implements Filter {
	
	/**
	 * 排除的url
	 */
	private String[] exUrls;
	
	/**
	 * 手机浏览器文件头
	 */
	private String[] phoneUserAgents;
	
	public void setPhoneUserAgents(String[] phoneUserAgents) {
		this.phoneUserAgents = phoneUserAgents;
	}
	
	public String[] getPhoneUserAgents() {
		return phoneUserAgents;
	}
	
	public void setExUrls(String[] exUrls) {
		this.exUrls = exUrls;
	}
	
	public String[] getExUrls() {
		return exUrls;
	}
	
	@Override
	public void destroy() {

	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		//排除的url
		String exUrl = filterConfig.getInitParameter("exUrl");
		String[] exUrls = exUrl.split(CommonUtils.FILTER_LIMIT);
		setExUrls(exUrls);
		
		//手机浏览器文件头
		String phoneUserAgent = filterConfig.getInitParameter("phoneUserAgent");
		String[] phoneUserAgents = phoneUserAgent.split(CommonUtils.FILTER_LIMIT);
		setPhoneUserAgents(phoneUserAgents);
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String url = req.getRequestURL().toString();
		String path = url.substring(url.lastIndexOf("/")+1);
		
		//不拦截这些,避免出现死循环,login.jsp,loginUserAccount.action,image.jsp
		if(CommonUtils.isHave(exUrls, path)){
			
			chain.doFilter(request, response);
			return ;
		}
		
		Object obj = req.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
		if(obj == null){
			
			//req.getRequestDispatcher("/login.jsp").forward(request, response);  这种方式会出现地址栏重叠的情况,从而登陆不了
			
			//增加一层是否手机的判断
			if(isPhone(req)){
				//表示为手机
				
				String adddr = req.getContextPath() + "/m/customer/login.jsp";
				res.sendRedirect(adddr);
				
				return ;
			}
			
			String adddr = req.getContextPath() + "/login.jsp";
			res.sendRedirect(adddr);
			
		}else{
			
		    chain.doFilter(request, response);
		    
		}

	}
	
	/**
	 * 判断是否手机请求
	 * iphone,ipod,symbian,android,itouch
	 * @param req
	 * @return
	 */
	private boolean isPhone(HttpServletRequest req){
		
		String userAgent = req.getHeader("User-Agent");
		
		if(CommonUtils.isStrEmpty(userAgent)){
			
			return false;
		}
		
		userAgent = userAgent.toLowerCase();
		
		boolean isPhone = false;
		
		for(String phoneUserAgent : phoneUserAgents){
			
			if(userAgent.contains(phoneUserAgent)){
				
				isPhone = true;
				break;
			}
		}
		
		return isPhone;
	}
	
}
