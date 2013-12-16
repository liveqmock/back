package com.ihk.utils.method;

/**
 * 调用者不处理异常(使用默认处理异常机制),只需处理正常业务
 * @author dtc
 * 2013-6-6,上午09:20:33
 */
public interface ActionAjaxMethodModifyNoThrowsExceptionCallback {
	
	/**
	 * 具体业务要实现的方法
	 * @throws Exception
	 */
	public void modifyMethod() throws Exception;
	
}
