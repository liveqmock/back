package com.ihk.utils.method;

import java.util.Date;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;

/**
 * easyui框架下的action操作共用模板类,可以自定义成功失败返回信息并在页面进行获取
 * @author dtc
 * 2013-5-7,上午11:41:05
 */
public class ActionAjaxMethodModifyTemplate {
	
	/**
	 * 是否使用事务,默认为false
	 */
	private boolean isTransation;
	
	public boolean isTransation() {
		return isTransation;
	}

	public void setTransation(boolean isTransation) {
		this.isTransation = isTransation;
	}
	
	/**
	 * 用于easyui ajax dialog,默认是不开启事务的
	 */
	public ActionAjaxMethodModifyTemplate() {
		this.isTransation = false;
	}
	
	/**
	 * 用于easyui ajax dialog,设置是否开启事务
	 * @param isTransation
	 */
	public ActionAjaxMethodModifyTemplate(boolean isTransation){
		this.isTransation = isTransation;
	}
	
	/**
	 * 调用方法,判断是否使用事务
	 * 使用者自处理异常的接口
	 * @param action
	 * @param callBack
	 * @return
	 */
	public String doModify(SupperAction action, final ActionAjaxMethodModifyCallback callBack){
		
		try {
			
			if(isTransation){
				
				new MyTransationTemplate() {
					
					@Override
					protected void doExecuteCallback() throws Exception {
						
						callBack.modifyMethod();
						
					}
				}.execute();
				
			}else{
				
				callBack.modifyMethod();
			}
			
			action.setUpEasyuiAjaxForWriteOut();
		} catch (Exception e){
			
			action.getRequest().getSession().setAttribute("__action_modify_exception__", 
					CommonUtils.getDateLocalString(new Date()) + "<br/>" +
					CustomerUtils.getActionNameFromRequest(action.getRequest()) + "<br/>" +
					e); //把对应的异常保存到session,方便调试查看
			
			callBack.modifyMethodException(e);
			
			action.setUpEasyuiAjaxForWriteOut(false);
		}
		
		return null;
	}
	
	/**
	 * 调用方法,判断是否使用事务
	 * 使用默认异常处理接口,仍然可以自定义成功与异常的输出信息
	 * @param action
	 * @param callBack
	 * @return
	 */
	public String doModify(SupperAction action, final ActionAjaxMethodModifyNoThrowsExceptionCallback callBack){
		
		try{
			
			if(isTransation){
				
				new MyTransationTemplate() {
					
					@Override
					protected void doExecuteCallback() throws Exception {
						
						callBack.modifyMethod();
						
					}
				}.execute();
				
			}else{
				
				callBack.modifyMethod();
			}
			
			action.setUpEasyuiAjaxForWriteOut();
			
		}catch (Exception e) {
			
			action.getRequest().getSession().setAttribute("__action_modify_exception__", 
					CommonUtils.getDateLocalString(new Date()) + "<br/>" +
					CustomerUtils.getActionNameFromRequest(action.getRequest()) + "<br/>" +
					e); //把对应的异常保存到session,方便调试查看
			
			action.setUpEasyuiAjaxForWriteOut(false);
		}
		
		return null;
	}
	
}
