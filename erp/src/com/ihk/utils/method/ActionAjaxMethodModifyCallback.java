package com.ihk.utils.method;

/**
 * easyui框架下的action操作共用模板类的返回接口
 * @author dtc
 * 2013-5-7,上午11:43:28
 */
public interface ActionAjaxMethodModifyCallback extends ActionAjaxMethodModifyNoThrowsExceptionCallback{
	
	/**
	 * 捕获业务抛出的异常<br/>
	 * @param e 异常从modifyMethod中捕获<br/>
	 * 例如可以调用SupperAction中的setUpEasyuiAjaxForFail(e.getMessage());	直接显示报错消息
	 */
	public void modifyMethodException(Exception e);

}
