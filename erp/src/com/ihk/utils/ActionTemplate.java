package com.ihk.utils;

import javax.servlet.http.HttpSession;

import com.ihk.utils.common.log.BaseLogger;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;
import com.ihk.utils.method.ActionAjaxMethodModifyNoThrowsExceptionCallback;
import com.ihk.utils.method.ActionAjaxMethodModifyTemplate;
import com.opensymphony.xwork2.ActionContext;

/**
 * action的模板类,主要用于easyui的分页及排序,还有新的action方法
 * @author dtc
 * 2013-5-7,上午10:47:19
 */
public class ActionTemplate {
	
	private SupperAction action;
	
	private SearchCond cond;

	public SupperAction getAction() {
		return action;
	}

	public void setAction(SupperAction action) {
		this.action = action;
	}

	public SearchCond getCond() {
		return cond;
	}

	public void setCond(SearchCond cond) {
		this.cond = cond;
	}
	
	public ActionTemplate(SupperAction action, SearchCond cond){
		
		this(action, cond, false);
	}
	
	/**
	 * isGetSession为true在新的easyui tab下会有问题
	 * @param action
	 * @param cond
	 * @param isGetSession
	 */
	public ActionTemplate(SupperAction action, SearchCond cond, boolean isGetSession){
		
		if(isGetSession){
			HttpSession session = action.request.getSession();
			
			Object sessionCond = session.getAttribute(CommonUtils.COND); //这样不对
			if(sessionCond != null){
				
				//session有对应的值
				cond = (SearchCond) sessionCond;
			}else{
				
				//session没有对应的值,且cond为null时
				if(cond == null){
					
					BaseLogger.error(ActionTemplate.class, "session没有对应的值,且cond为null");
					throw new RuntimeException("session没有对应的值,且cond为null");
				}
				
			}
		}
		
		this.action = action;
		this.cond = cond;
		
	}
	
	/**
	 * 执行分页方法,如果要修改pageSize,可以在调用executePage之前设置,如this.pageSize = 20;
	 * @param callBack
	 */
	public void executePage(ActionPageCallback callBack){
		
		String actionUrl = CustomerUtils.getActionNameFromRequest(action.request);
		
		Pager page = new Pager(ActionContext.getContext(), action.pageSize, actionUrl);
		page.setCond(cond);
		
		callBack.initActionPageList();
		
		action.setShowPage(page.toHtmlString());
		
		action.request.getSession().setAttribute(CommonUtils.COND, cond);
	}
	
	/**
	 * 类似hibernate的分页回调方法
	 * @param callBack
	 * @param newPageSize,新的pageSize
	 */
	public void executePage(ActionPageCallback callBack, int newPageSize){
		
		action.pageSize = newPageSize;
		executePage(callBack);
	}
	
	/////下面的方法为easyui的
	
	/**
	 * 没有底部的ajax分页(处理对应的异常)
	 * @param action
	 * @param cond
	 * @param callBack
	 * @return
	 */
	public static String executeAjaxPage(SupperAction action, SearchCond cond, ActionAjaxPageCallback callBack){
		
		ActionAjaxPageTemplate pageTemplate = new ActionAjaxPageTemplate(action, cond);
		pageTemplate.executeAjaxPage(callBack);
		
		return null;
	}
	
	/**
	 * 有底部的ajax分页(处理对应的异常)
	 * @param action
	 * @param cond
	 * @param callBack
	 * @return
	 */
	public static String executeAjaxPage(SupperAction action, SearchCond cond, ActionAjaxPageByFooterCallback callBack){
		
		ActionAjaxPageTemplate pageTemplate = new ActionAjaxPageTemplate(action, cond);
		pageTemplate.executeAjaxPage(callBack);
		
		return null;
		
	}
	
	/**
	 * 使用字段放射,没有底部的ajax分页(处理对应的异常)
	 * @param action
	 * @param cond
	 * @param callBack
	 * @param fields
	 * @return
	 */
	public static String executeAjaxPage(SupperAction action, SearchCond cond, 
			ActionAjaxFieldPageCallback callBack, String ... fields){
		
		ActionAjaxPageTemplate pageTemplate = new ActionAjaxPageTemplate(action, cond);
		pageTemplate.executeAjaxPage(callBack, fields);
		
		return null;
	}

	/**
	 * 使用字段放射,有底部的ajax分页(处理对应的异常)
	 * @param action
	 * @param cond
	 * @param callBack
	 * @param fields
	 * @return
	 */
	public static String executeAjaxPage(SupperAction action, SearchCond cond, 
			ActionAjaxFieldPageByFooterCallback callBack, String ... fields){
		
		ActionAjaxPageTemplate pageTemplate = new ActionAjaxPageTemplate(action, cond);
		pageTemplate.executeAjaxPage(callBack, fields);
		
		return null;
		
	}

	//------
	
	/**
	 * ajax action的调用,<br/>
	 * 可以利用action中的setUpAjaxForSucc及setUpAjaxForFail方法设置自定义成功失败返回值<br/>
	 * 如果不使用异常处理接口,可以使用ActionAjaxMethodModifyNoThrowsExceptionCallback接口
	 * @param action
	 * @param callBack
	 * @return
	 */
	public static String executeAjaxMethod(SupperAction action, ActionAjaxMethodModifyCallback callBack){
		
		return executeAjaxMethod(false, action, callBack);
	}
	
	/**
	 * ajax action的调用,<br/>
	 * 可以利用action中的setUpAjaxForSucc及setUpAjaxForFail方法设置自定义成功失败返回值<br/>
	 * 如果不使用异常处理接口,可以使用ActionAjaxMethodModifyNoThrowsExceptionCallback接口
	 * @param isTransation
	 * @param action
	 * @param callBack
	 * @return
	 */
	public static String executeAjaxMethod(boolean isTransation, SupperAction action, ActionAjaxMethodModifyCallback callBack){
		
		ActionAjaxMethodModifyTemplate template = new ActionAjaxMethodModifyTemplate(isTransation);
		template.doModify(action, callBack);
		
		return null;
	}
	
	/**
	 * ajax action的调用,<br/>
	 * 可以利用action中的setUpAjaxForSucc方法设置自定义成功返回值,使用默认的异常处理接口
	 * @param action
	 * @param callBack
	 * @return
	 */
	public static String executeAjaxMethod(SupperAction action, ActionAjaxMethodModifyNoThrowsExceptionCallback callBack){
		
		return executeAjaxMethod(false, action, callBack);
	}
	
	/**
	 * ajax action的调用,<br/>
	 * 可以利用action中的setUpAjaxForSucc方法设置自定义成功返回值,使用默认的异常处理接口
	 * @param isTransation
	 * @param action
	 * @param callBack
	 * @return
	 */
	public static String executeAjaxMethod(boolean isTransation, SupperAction action, ActionAjaxMethodModifyNoThrowsExceptionCallback callBack){
		
		ActionAjaxMethodModifyTemplate template = new ActionAjaxMethodModifyTemplate(isTransation);
		template.doModify(action, callBack);
		
		return null;
	}
	
}
