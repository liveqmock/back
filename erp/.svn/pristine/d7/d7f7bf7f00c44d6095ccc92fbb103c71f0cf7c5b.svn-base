package com.ihk.saleunit.action.new_;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * 
 * @author yzj
 * 检查拦截器，自动去除左右空格
 *
 */
public class CheckInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8200519540685908861L;

	@Override
	public void destroy() {
	
	}

	@Override
	public void init() {
			
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map map=invocation.getInvocationContext().getParameters();
		Set keys = map.keySet();
        Iterator iters = keys.iterator();
        while(iters.hasNext()){
        	Object key = iters.next();
        	Object value = map.get(key);
        	map.put(key, transfer((String[])value));
        }
		return invocation.invoke();
	}
	
	private String[] transfer(String[] params){
		for(int i=0;i<params.length;i++){
			if(StringUtils.isEmpty(params[i]))continue;
			params[i]=params[i].trim();
		}
		return params;
	}

}
