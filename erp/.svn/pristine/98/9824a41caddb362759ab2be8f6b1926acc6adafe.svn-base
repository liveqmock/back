package com.ihk.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.beanutils.PropertyUtils;

import com.ihk.utils.CommonUtils;

/**
 * 自定义checkbox list,弥补struts2 checkboxlist 标签不能获取${}标签值的问题
 * @author dtc
 * 2012-11-27,下午05:22:46
 */
public class MyCheckBoxListTag extends SimpleTagSupport{
	
	/**
	 * 要遍历的pojo list,不应该为空
	 */
	private List<?> list;
	
	/**
	 * input的id前缀,如果为空就拿name做为前缀,可以为空
	 */
	private String id;
	
	/**
	 * 不能为空
	 */
	private String name;
	
	/**
	 * input value的字段名,不能为空
	 */
	private String valueField;
	
	/**
	 * label text的字段名,不能为空
	 */
	private String textField;
	
	/**
	 * 上个页面选中的项目id
	 */
	private String selectedId;
	
	public String getSelectedId() {
		return selectedId;
	}
	
	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
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

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public String getTextField() {
		return textField;
	}

	public void setTextField(String textField) {
		this.textField = textField;
	}
	
	public List<?> getList() {
		return list;
	}
	
	public void setList(List<?> list) {
		this.list = list;
	}

	@Override
	public void doTag() throws JspException, IOException {
		
		/**
		 * <input id="knownFrom-1" type="checkbox" value="11" name="knownFrom">
		 *	<label class="checkboxLabel" for="knownFrom-1">高档酒店陌拜</label>
		 */
		
		StringBuffer sb = new StringBuffer();
		
		try{
			
			if(!CommonUtils.isCollectionEmpty(list)){
				
				if(CommonUtils.isStrEmpty(id)){
					id = name;
				}
				
				String[] ids = null;
				if(!CommonUtils.isStrZeroEmpty(selectedId)){
					
					ids = selectedId.split(",");
				}
				
				int size = list.size();
				
				for(int i=0; i<size; i++){
					
					Object obj = list.get(i);
					
					Object valueObj = PropertyUtils.getProperty(obj, valueField);
					String value = valueObj == null ? "" : valueObj.toString();
					
					Object textObj = PropertyUtils.getProperty(obj, textField);
					String text = textObj == null ? "" : textObj.toString();
					
					String objStr = obj.toString();
					int beginIndex = objStr.indexOf("@") + 1;
					String inputId = objStr.substring(beginIndex, objStr.length());
					sb.append("<input id='").append(inputId).append("' type='checkbox' ")
						.append("value='").append(value).append("' name='").append(name).append("'")
						.append(isChecked(ids, value))
						.append(" label='").append(text).append("'/>")
						.append("<label for='").append(inputId).append("'>").append(text).append("</label>")
						;
					
				}
				
			}
			
		}catch(Exception e){
			sb.delete(0, sb.length());
		}
		
		JspWriter writer = getJspContext().getOut();
		writer.println(sb.toString());
	}
	
	/**
	 * 判断传入的id是否处于被选中的状态
	 * @param ids
	 * @param id
	 * @return
	 */
	private static String isChecked(String[] ids, String id){
		
		if(ids == null || ids.length <= 0)
			return "";
		
		for(String tmpId : ids){
			
			if(tmpId.equals(id)){
				return " checked='checked' ";
			}
		}
		
		return "";
	}
	
}
