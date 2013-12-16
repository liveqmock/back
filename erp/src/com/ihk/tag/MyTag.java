package com.ihk.tag;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.ihk.utils.CommonUtils;

/**
 * 自定义标签
 * <%@ taglib prefix="my" uri="/WEB-INF/my.tld" %> 
 * <my:format value="${allShouldPay}"/>
 * @author dtc
 * 2012-8-2
 */
public class MyTag extends SimpleTagSupport{
	
	private String type; //类型
	
	private Object value; //具体的值
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		
		JspWriter writer = getJspContext().getOut();
		
		writer.println(format(type, value));
		
	}
	
	private String format(String type, Object value){
		
		String ret = "";
		
		try{
			ret = realFormat(type, value);
		}catch (Exception e) {
			ret = "";
		}
		
		return ret;
		
	}
	
	/**
	 * 实际调用的格式化方法
	 * @param type
	 * @param value
	 * @return
	 */
	private String realFormat(String type, Object value) throws Exception{
		
		String ret = "";
		
		if(CommonUtils.isStrEmpty(type) && value != null && !"".equals(value)){
			//金额格式化,显示两位数
			
			DecimalFormat df = new DecimalFormat("###,##0.00");
			ret = df.format(value);
			
		}else if("intPercent".equals(type)){
			//整数比例
			
			BigDecimal out = new BigDecimal(value.toString());
			ret = out.intValue() + "";
		}
		
		return ret;
	}
	
}
