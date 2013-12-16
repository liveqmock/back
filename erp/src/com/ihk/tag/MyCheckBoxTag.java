package com.ihk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.ihk.utils.CommonUtils;

/**
 * 自定义checkbox,为了弥补struts2checkbox标签不能满足的业务需求
 * @author dtc
 * 2012-9-29
 */
public class MyCheckBoxTag extends SimpleTagSupport{
	
	private String id;
	private String name;
	
	/**
	 * 相当于传统checkbox中的value值
	 */
	private String fieldValue; //相当于传统checkbox中的value值
	
	/**
	 * 对于该checkbox显示在页面上方框后面的描述
	 */
	private String label; //对于该checkbox显示在页面上方框后面的描述
	
	/**
	 * 判断是否让该checkbox处于选择状态,如果为true就为选择状态,为false或为空就为非选择状态
	 */
	private String check; //判断是否让该checkbox处于选择状态,如果为true就为选择状态,为false或为空就为非选择状态
	
	/**
	 * 对应的公司id
	 */
	private String comId;
	
	public void setComId(String comId) {
		this.comId = comId;
	}
	
	public String getComId() {
		return comId;
	}
	
	public void setCheck(String check) {
		this.check = check;
	}
	
	public String getCheck() {
		return check;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public void doTag() throws JspException, IOException {
		//<input type="checkbox" name="" id="" value="fieldValue" /><a href='javascript:void(0)'>label<a>
		
		if(CommonUtils.isStrEmpty(fieldValue) && CommonUtils.isStrEmpty(label))
			return ;
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<input type='checkbox' name='").append(name).append("' ")
			.append("comId='").append(comId).append("' ");
		if(!CommonUtils.isStrEmpty(id)){
			sb.append("id='").append(id).append("' ");
		}
		if("true".equalsIgnoreCase(check)){
			sb.append("checked='checked' ");
		}
		sb.append("label='").append(label.trim()).append("' ")
			.append("value='").append(fieldValue.trim()).append("'/>")
			.append("<a href='javascript:void(0)' myCheckBox='myCheckBox'>").append(label).append("</a>")
			;
		
		JspWriter writer = getJspContext().getOut();
		
		writer.println(sb.toString());
		
	}

}
