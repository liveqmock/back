package com.ihk.interceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.ihk.saleunit.log.UnitTransactionLogService;

/**
 * 单元交易记录日志
 * @author xushaojia
 *
 */
public class UnitTransactionLogInterceptor extends BaseMethodInterceptor implements MethodInterceptor{

	private static Map<String, String> actionLog = new HashMap<String, String>();
	
	static{
		actionLog.put("addConfirmBook", "addConfirmBookLog");//新建临定
		actionLog.put("updateConfirmBook", "updateConfirmBookLog");//修改临定
		actionLog.put("addTart", "addTartActionLog");//新建挞定
		actionLog.put("deleteTart", "deleteTartActionLog");//撤销挞定
		actionLog.put("addConfirm", "addConfirmLog");//新建成交
		actionLog.put("updateConfirm", "updateConfirmLog");//修改成交
		actionLog.put("addCancelUnit", "addCancelUnitLog");//新建退房
		actionLog.put("deleteCancelUnit", "deleteCancelUnitLog");//撤销退房
		actionLog.put("addContract", "addContractLog");//新建合同
		actionLog.put("updateContract", "updateContractLog");//修改合同
		actionLog.put("addReplaceUnit", "addReplaceUnitLog");//新建换房
		actionLog.put("addCustomerRename", "addCustomerRenameLog");//单元改名
	}
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		final String methodName = invocation.getMethod().getName();
		final UnitTransactionLogService log= new UnitTransactionLogService(invocation);

		try {
			if(actionLog.containsKey(methodName)){
				Method method = log.getClass().getMethod(actionLog.get(methodName), null);
				method.invoke(log, null);
			}
		} catch (Exception e) {
		}
		
		
		return invocation.proceed();
	}
}
