package com.ihk.tag;

import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.ihk.utils.CommonUtils;

/**
 * 
 * 标签的基础类
 * @author dtc
 *
 */
public class MyBasePropertyTag extends SimpleTagSupport {
	
	protected final static String TEXT_START = "<input type=\"text\" ";
	protected final static String HIDDEN_START = "<input type=\"hidden\" ";
	
	protected final static String INPUT_END = " />";
	
	protected final static String SELECT_START = "<select style=\"width:auto\" ";
	protected final static String SELECT_END = "</select>";
	
	protected final static String OPTION_START = "<option ";
	protected final static String OPTION_END = "</option>";
	
	protected final static String SPACE = " ";
	
	private String id;
	private String name;
	private String value;
	
	private String hiddenId;
	private String hiddenName;
	private String hiddenValue;
	
	private String relyValue; //依赖值
	
	public void setRelyValue(String relyValue) {
		this.relyValue = relyValue;
	}
	
	public String getRelyValue() {
		return relyValue == null ? "" : relyValue;
	}
	
	public String getId() {
		return id == null ? "" : id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name == null ? "" : name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value == null ? "" : value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getHiddenId() {
		return hiddenId == null ? "" : hiddenId;
	}

	public void setHiddenId(String hiddenId) {
		this.hiddenId = hiddenId;
	}

	public String getHiddenName() {
		return hiddenName == null ? "" : hiddenName;
	}

	public void setHiddenName(String hiddenName) {
		this.hiddenName = hiddenName;
	}

	public String getHiddenValue() {
		return hiddenValue == null ? "" : hiddenValue;
	}

	public void setHiddenValue(String hiddenValue) {
		this.hiddenValue = hiddenValue;
	}
	
	protected String getInputTagContent(){
		
		StringBuffer sb = new StringBuffer();
		sb.append(TEXT_START)
			.append("id=\"").append(getId()).append("\"").append(SPACE)
			.append("name=\"").append(getName()).append("\"").append(SPACE)
			.append("value=\"").append(getValue()).append("\"").append(SPACE)
			.append(INPUT_END);
			;
		
		sb.append(HIDDEN_START)
			.append("id=\"").append(getHiddenId()).append("\"").append(SPACE)
			.append("name=\"").append(getHiddenName()).append("\"").append(SPACE)
			.append("value=\"").append(getHiddenValue()).append("\"").append(SPACE)
			.append(INPUT_END)
			;
		
		return sb.toString();
	}
	
	//<s:select list="selPayType"  name="confirm.payType" cssStyle="width:auto" id="payType"/>
	/**
	 * <select id="propertyType" style="width:auto" name="contract.propertyType">
		<option value="">请选择</option>
		<option selected="selected" value="1">预售楼</option>
		<option value="2">现楼</option>
		<option value="3">其他</option>
		</select>
	 * 
	 */
	
	protected String getSelectTagContent(){
		
		return getSelectTagContent(null);
	}
	
	protected String getSelectTagContent(Map<String, String> selectMap){
		
		StringBuffer sb = new StringBuffer();
		
		if(selectMap == null || selectMap.size() <= 0){
			
			sb.append(SELECT_START)
				.append("id=\"").append(id).append("\"").append(SPACE)
				.append("name=\"").append(getName()).append("\"").append(SPACE)
				.append(">")
				.append(OPTION_START).append("value=\"\">").append(CommonUtils.EMPTY).append(OPTION_END)
				.append(SELECT_END)
				;
			
		}else{
			
			sb.append(SELECT_START)
				.append("id=\"").append(id).append("\"").append(SPACE)
				.append("name=\"").append(getName()).append("\"").append(SPACE)
				.append(">")
				.append(OPTION_START).append("value=\"\">").append(CommonUtils.EMPTY).append(OPTION_END)
				;
			
			Set<String> keys = selectMap.keySet();
			for(String key : keys){
				
				if(key.equals(getValue())){
					//<option selected="selected" value="1">预售楼</option>
					sb.append(OPTION_START)
						.append("value=\"").append(key).append("\"").append(SPACE)
						.append("selected=\"selected\"").append(">").append(selectMap.get(key))
						.append(OPTION_END)
						;
					
				}else{
					
					sb.append(OPTION_START)
						.append("value=\"").append(key).append("\"").append(">").append(selectMap.get(key))
						.append(OPTION_END)
						;
					
				}
			}
			
			sb.append(SELECT_END);
			
		}
		
		return sb.toString();
	}
	
	

}
