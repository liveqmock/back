package com.ihk.utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.core.io.Resource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 主要用于获取一个具体的bean及项目绝对路径
 * @author dtc
 * 2012-9-14
 */
public class SpringUtils implements ServletContextListener {
	
	private static WebApplicationContext context;
	private static String contextPath;

	public void contextDestroyed(ServletContextEvent e) {
	}

	/**
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent e) {
		try {
			context = WebApplicationContextUtils.getRequiredWebApplicationContext(e.getServletContext());
			ServletContext servletContext = context.getServletContext();
			Resource resource = new ServletContextResource(servletContext,"/");
			contextPath = resource.getFile().getAbsolutePath();
			
		} catch(Exception t) {
			t.printStackTrace();
		}
	}
	
	/**
	 * 获取Spring配置的Bean
	 * @param id
	 * @return
	 */
	public static Object getBean(String id) {
		return context.getBean(id);
	}
	
	/**
	 * 获取项目的所在绝对路径
	 * @return
	 */
	public static String getContextPath(){
		 return contextPath;
	}

}
