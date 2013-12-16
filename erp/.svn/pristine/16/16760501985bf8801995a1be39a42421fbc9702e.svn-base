package com.ihk.tag.projecttext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.projecttext.ProjectTextUtils;

/**
 * 自定义下拉框
 * @author dtc
 * 2012-8-9
 */
public class MyProjectTextTag extends SimpleTagSupport{
	
	private String id;
	
	private String name;
	
	private String cssStyle;
	
	private String typeName;
	
	private String value; //更新的时候选中的值
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
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

	public String getCssStyle() {
		return cssStyle;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	@Override
	public void doTag() throws JspException, IOException {
		
		//为了作为级联下拉框,typeName可以为空,可以参照add_unit_pay_bill.jsp
		/*if(CommonUtils.isStrEmpty(typeName)){
			
			throw new IOException("标签typeName不能为空");
		}*/
		
		JspWriter writer = getJspContext().getOut();
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<select valueField=\"").append(ProjectTextUtils.PROJECT_TEXT_VALUE)
			.append("\" textField=\"").append(ProjectTextUtils.PROJECT_TEXT_TEXT).append("\" ")
			.append("id=\"")
			.append(id).append("\"").append(" name=\"")
			.append(name).append("\" ").append("class=\"easyui-combobox\" ");
		
		if(!CommonUtils.isStrEmpty(cssStyle)){
			sb.append("style=\"").append(cssStyle).append("\" ");
		}
		sb.append(">");
		
		Map<String, String> map = ProjectTextUtils.getProjectTextForMapByTypeName(typeName);
		
		if(map != null && map.size()>0){
			
			if(!CommonUtils.isStrEmpty(value) && !map.containsKey(value)){
				map.put(value, value);
			}
			map.put(ProjectTextUtils.ADD_NEW_VALUE_LIMIT, ProjectTextUtils.ADD_NEW_TEXT_LIMIT);
		}else{
			
			map = new HashMap<String, String>();
			map.put("", CommonUtils.EMPTY);
			if(!CommonUtils.isStrEmpty(value)){
				map.put(value, value);
			}
			map.put(ProjectTextUtils.ADD_NEW_VALUE_LIMIT, ProjectTextUtils.ADD_NEW_TEXT_LIMIT);
		}
		
		sb.append(CommonUtils.getSelectContent(map, value));
		
		sb.append("</select>");
		
		//typeName转成hidden,id为select的id_typeName
		sb.append("<input type=\"hidden\" id=\"").append(id).append("_typeName\" value=\"").append(typeName).append("\"/>");
		
		writer.println(sb.toString());
		
	}

}
