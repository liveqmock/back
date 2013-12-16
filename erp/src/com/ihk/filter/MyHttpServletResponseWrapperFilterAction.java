package com.ihk.filter;

import com.ihk.utils.SupperAction;

/**
 * 测试
 * @author dtc
 * 2012-12-4,上午11:49:25
 */
public class MyHttpServletResponseWrapperFilterAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	public String myWrapper() throws Exception{
		
		return "myWrapper";
	}
	
	public String myDeal() throws Exception{
		
		return "myDeal";
	}
	

}
