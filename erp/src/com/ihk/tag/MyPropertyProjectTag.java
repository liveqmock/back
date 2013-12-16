package com.ihk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

/**
 * 
 * 楼盘项目标签
 * @author dtc
 *
 */
public class MyPropertyProjectTag extends MyBasePropertyTag {
	
	@Override
	public void doTag() throws JspException, IOException {
		
		/**
		 * <input type="text" id="projectName" name="buildCond.propertyName" value="${buildCond.propertyName}"/>	
		 * <input type="hidden" id="hiddenProjectId" name="buildCond.propertyId" value="${buildCond.propertyId}"/>
		 */
		
		JspWriter writer = getJspContext().getOut();
		
		writer.println(getInputTagContent());
		
	}

}
