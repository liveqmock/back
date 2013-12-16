package com.ihk.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyAreaCond;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 
 * 楼盘分区标签
 * @author dtc
 *
 */
public class MyPropertyAreaTag extends MyBasePropertyTag {
	
	@Override
	public void doTag() throws JspException, IOException {
		
		JspWriter writer = getJspContext().getOut();
		
		Map<String, String> map = new HashMap<String, String>();
		
		String relyValue = getRelyValue(); //此处为楼盘项目的id
		if(!CommonUtils.isStrZeroEmpty(relyValue)){
			
			PropertyAreaCond cond = new PropertyAreaCond();
			cond.setPropertyId(Integer.parseInt(relyValue));
			
			List<PropertyArea> areaList = MyPropertyUtils.getPropertyAreaServices().findPropertyArea(cond);
			
			for(PropertyArea area : areaList){
				map.put(area.getId()+"", area.getAreaName());
			}
			
		}
		
		writer.println(getSelectTagContent(map));
	}

}
