package com.ihk.utils.common.listener;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.ihk.user.data.pojo.UserAccount;
import com.ihk.utils.CommonUtils;

/**
 * session绑定监听器(该监听器为唯一不用在web.xml中配置)<br/>
 * 如果一个对象实现了HttpSessionBindingListener接口,<br/>
 * 当这个对象被绑定到session中或者从session中被删除时,Servlet容器会通知这个对象,<br/>
 * (即如果把MyHttpSessionBindingListener放到session中,会调用valueBound();移出session会调用valueUnbound())<br/>
 * 而这个对象在接收到通知后,可以做一些初始化或清除状态的操作。<br/>
 * @author dtc
 * 2012-9-28
 */
public abstract class MyHttpSessionBindingListener implements HttpSessionBindingListener {
	
	public MyHttpSessionBindingListener() {
	}
	
	/**
	 * 登陆成功并放到session的用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		
		HttpSession session = event.getSession();
		
		String sessionId = session.getId();
		long creationTime = session.getCreationTime();
		long lastAccessedTime = session.getLastAccessedTime();
		
		HttpSessionBindingListenerKeyBean bean = new HttpSessionBindingListenerKeyBean(sessionId, creationTime, lastAccessedTime);
		
		ServletContext application = session.getServletContext();
		
		Object obj = application.getAttribute(CommonUtils.APPLICATION_KEY);
		
		Map<HttpSessionBindingListenerKeyBean, UserAccount> map = null;
		
		if(obj == null){
			//第一次
			map = new LinkedHashMap<HttpSessionBindingListenerKeyBean, UserAccount>();
			
		}else{
			
			map = (Map<HttpSessionBindingListenerKeyBean, UserAccount>) obj;
		}
		
		UserAccount user = userBoundOrUn();
		map.put(bean, user);
		
		application.setAttribute(CommonUtils.APPLICATION_KEY, map);
		
	}

	/**
	 * 退出或超时并移出session的用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		
		HttpSession session = event.getSession();
		
		String sessionId = session.getId();
		
		HttpSessionBindingListenerKeyBean bean = new HttpSessionBindingListenerKeyBean(sessionId);
		
		ServletContext application = session.getServletContext();
		
		Object obj = application.getAttribute(CommonUtils.APPLICATION_KEY);
		if(obj == null)
			return ;
		
		Map<HttpSessionBindingListenerKeyBean, UserAccount> map = (Map<HttpSessionBindingListenerKeyBean, UserAccount>) obj;
		
		map.remove(bean);
		
		application.setAttribute(CommonUtils.APPLICATION_KEY, map);
		
	}
	
	/**
	 * 登陆或退出的客户
	 * @return
	 */
	public abstract UserAccount userBoundOrUn();
	
}