package com.ihk.utils.saleunitnew;

import com.ihk.setting.data.services.IOperLogServices;

/**
 * 操作日志,用于认购与签约中的退房
 * @author dtc
 * 2012-6-25
 */
public class UnitOprLogUtils {
	
	private static IOperLogServices operLogServices;
	
	public void setOperLogServices(IOperLogServices operLogServices) {
		UnitOprLogUtils.operLogServices = operLogServices;
	}
	
	public static IOperLogServices getOperLogServices() {
		return operLogServices;
	}

}
