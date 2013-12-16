package com.ihk.filter;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihk.setting.data.pojo.ActionRecordLog;
import com.ihk.setting.data.services.IActionRecordLogServices;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.common.setup.RecordActionUtils;
import com.ihk.utils.log.CompareUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

public class ActionCountFilter implements Filter{

	private String[] recordAction; //需要统计的action
	
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		try {
			String requestAction = request.getServletPath();
			
			String tmp = requestAction.substring(requestAction.indexOf("/")+1,requestAction.length()).replaceAll("/", "_").toUpperCase();
			tmp = tmp.substring(0, tmp.indexOf("."));
			Set<String> keys = RecordActionUtils.getRecordAction().keySet();
			
			for(String key : keys){
				if(CommonUtils.isStrEmpty(key)){
					continue;
				}
				
				if(tmp.equals(key)){
					
					ActionRecordLog log = new ActionRecordLog();
					int userId = -1;
					try {
						
						IActionRecordLogServices actionRecordLogServices= MyPropertyUtils.getActionRecordLogServices();
						
						Object obj = request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
						if(obj != null){
							
							UserAccount user = (UserAccount) obj;
							userId = user.getId();
							log.setUserId(userId);
							log.setLogType(key);
							log.setLogTime(new Date());
							log.setLogDesc(CompareUtils.getIpAddr(request));
							log.setProjectId(user.getProjectId());
							actionRecordLogServices.addActionRecordLog(log);
						}
						
					} catch (Exception e) {
					}
					
					break;
				}
				
			}
			
		} catch (Exception e) {
		}
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
