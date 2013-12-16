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
import javax.servlet.http.HttpSession;

import com.ihk.utils.CommonUtils;

/**
 * url过滤器,避免跨项目跳转访问(没有使用到)
 * @author dtc
 * 2012-9-27
 */
public class UrlFilter implements Filter {
	
	/**
	 * 排除的url
	 */
	private String[] exUrls;
	
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
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		Object filterProjectObj = session.getAttribute("filterProject");
		
		//下面的内容参考org.apache.struts2.views.util.UrlHelper
		String uri = (String) request.getAttribute("javax.servlet.forward.request_uri");

        // If the attribute wasn't found, default to the value in the request object
        if (uri == null) {
            uri = request.getRequestURI();
        }
        
        String action = uri.substring(uri.lastIndexOf("/") + 1);
        
        if(CommonUtils.isHave(exUrls, action)){
        	chain.doFilter(req, res);
        	return ;
        }
        
        String actionFront = uri.substring(uri.lastIndexOf('/') + 1, uri.lastIndexOf('!'));
        String projectName = actionFront.substring(actionFront.lastIndexOf('_') + 1);
        
        if(filterProjectObj == null){
        	//req.getRequestDispatcher("/login.jsp").forward(request, response);  这种方式会出现地址栏重叠的情况,从而登陆不了
			
			String adddr = request.getContextPath() + "/login.jsp";
			response.sendRedirect(adddr);
			
			return ;
        } 
        
        String filterProject = filterProjectObj.toString();
        if(!filterProject.equals(projectName)){
        	String adddr = request.getContextPath() + "/login.jsp";
			response.sendRedirect(adddr);
        	
			return ;
        }
		
		chain.doFilter(req, res);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String exUrl = filterConfig.getInitParameter("exUrl");
		String[] exUrls = exUrl.split(CommonUtils.FILTER_LIMIT);
		setExUrls(exUrls);

	}

}
