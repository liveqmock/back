package com.ihk.interceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.ihk.saleunit.log.BuildingAreaUnitInitLogService;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.request.HttpRequestUtils;

/**
 * 楼栋、分区、单元操作方法过滤器
 * @author xushaojia
 *
 */
public class BuildingAreaUnitInitInterceptor implements MethodInterceptor{

	/**
	 * 拦截方法后
	 */
	private static Map<String,String> afterActionLog = new HashMap<String, String>(); 
	
	/**
	 * 拦截方法前
	 */
	private static Map<String,String> beforeActionLog = new HashMap<String, String>();
	
	static{
		afterActionLog.put("addPropertyProject", "addPropertyProjectLog");
		afterActionLog.put("addPropertyProject", "addPropertyProjectLog");
		afterActionLog.put("addPropertyArea", "addPropertyAreaLog");
		afterActionLog.put("addPropertyBuild", "addPropertyBuildLog");
		afterActionLog.put("addPropertyUnit", "addPropertyUnitLog");
		
		
		
		beforeActionLog.put("updatePropertyProject", "updatePropertyProjectLog");
		beforeActionLog.put("updatePropertyProject", "updatePropertyProjectLog");
		beforeActionLog.put("deletePropertyProject", "deletePropertyProjectLog");
		beforeActionLog.put("updatePropertyArea", "updatePropertyAreaLog");
		beforeActionLog.put("deletePropertyArea", "deletePropertyAreaLog");
		beforeActionLog.put("updatePropertyBuild", "updatePropertyBuildLog");
		beforeActionLog.put("deletePropertyBuild", "deletePropertyBuildLog");
		beforeActionLog.put("deletePropertyUnit", "deletePropertyUnitLog");
		beforeActionLog.put("updatePropertyUnit", "updatePropertyUnitLog");
		beforeActionLog.put("updatePropertyUnitSaleState", "updatePropertyUnitSaleStateLog");
	}
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		final BuildingAreaUnitInitLogService service = new BuildingAreaUnitInitLogService();
		BuildingAreaUnitInitLogService.setInvocation(invocation);
		
		final String methodName = invocation.getMethod().getName();
		
		try {
			if(beforeActionLog.containsKey(methodName)){
				Method method =  service.getClass().getMethod(beforeActionLog.get(methodName),null);
				method.invoke(service, null);
			}
		} catch (Exception e) {
		}
		Object obj =  invocation.proceed();
		//拦截方法后
		try {
			if(afterActionLog.containsKey(methodName)){
				Method method =  service.getClass().getMethod(afterActionLog.get(methodName),null);
				method.invoke(service, null);
			}
		} catch (Exception e) {
		}
		return obj;
	}

	




}
