package com.ihk.utils;

import org.apache.log4j.Logger;

/**
 * easyui框架下的action操作共用帮助类,ajax dialog
 * 请使用ActionTemplate.java
 * @author dtc
 * 2012-12-11,下午06:20:45
 */
public abstract class ActionMethodModifyUtils{
	
	private static final Logger logger = Logger.getLogger(ActionMethodModifyUtils.class); 
	
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
	 * 用于easyui ajax dialog,默认是不开启事务的<br>
	 * easyui的弹出框,推荐改用ActionTemplate
	 */
	public ActionMethodModifyUtils() {
		this.isTransation = false;
	}
	
	/**
	 * 用于easyui ajax dialog,设置是否开启事务
	 * @param isTransation
	 */
	public ActionMethodModifyUtils(boolean isTransation){
		this.isTransation = isTransation;
	}

	/**
	 * 调用方法,判断是否使用事务
	 * 可以利用action中的setUpAjaxForSucc及setUpAjaxForFail方法设置自定义成功失败返回值
	 * 
	 * @param action
	 * @return
	 */
	public String doModify(SupperAction action){
		
		try {
			
			if(isTransation){
				
				new MyTransationTemplate() {
					
					@Override
					protected void doExecuteCallback() throws Exception {
						
						modifyMethod();
						
					}
				}.execute();
				
			}else{
				
				modifyMethod();
			}
			
			action.setUpEasyuiAjaxForWriteOut(true);
		} catch (Exception e){
			
			logger.error(e);
			
			action.setUpEasyuiAjaxForWriteOut(false);
		}
		
		return null;
	}
	
	/**
	 * 具体业务要实现的方法
	 * @throws Exception
	 */
	protected abstract void modifyMethod() throws Exception;

}
