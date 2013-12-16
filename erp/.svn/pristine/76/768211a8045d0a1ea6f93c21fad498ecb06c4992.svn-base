package com.ihk.utils;

import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * 公用的分页action 工具类(使用ActionTemplate代替该类)
 * @author dtc
 *
 */
@Deprecated
public abstract class CommonPageActionUtils {
	
	public CommonPageActionUtils(SupperAction action, SearchCond cond){
		
		String actionUrl = CustomerUtils.getActionNameFromRequest(action.request);
		
		Pager page = new Pager(ActionContext.getContext(), action.pageSize, actionUrl);
		page.setCond(cond);
		
		initActionList();
		
		action.setShowPage(page.toHtmlString());
		
		action.request.getSession().setAttribute(CommonUtils.COND, cond);
		
	}
	
	public abstract void initActionList(); //分页查找的list

}
