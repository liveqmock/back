package com.ihk.utils.contract.unit;

import javax.servlet.http.HttpServletRequest;

import com.ihk.utils.CommonUtils;

/**
 * 主要是为了在利用旧的页面,action能正确跳转
 * @author dtc
 * 2013-1-10,下午02:12:25
 */
public class ContractUrlUtils {
	
	/**
	 * 如果符合新增的跳转url就直接跳转,否则就跳转旧的
	 * @param request
	 * @param oldRet
	 */
	public static String unitInfo(HttpServletRequest request, String oldRet){
		
		String urlFrom = request.getParameter("urlFrom");
		
		if(CommonUtils.isStrEmpty(urlFrom))
			return oldRet;
		
		if("contractUnit".equals(urlFrom)){
			
			return "unitInfoForContractManager";
		}
		
		return oldRet;
	}
	
}
