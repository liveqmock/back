package com.ihk.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 
 * 楼盘楼栋标签
 * @author dtc
 *
 */
public class MyPropertyBuildTag extends MyBasePropertyTag {
	
	@Override
	public void doTag() throws JspException, IOException {
		
		JspWriter writer = getJspContext().getOut();
		
		Map<String, String> map = new HashMap<String, String>();
		
		String relyValue = getRelyValue(); //此处为楼盘area的id
		if(!CommonUtils.isStrZeroEmpty(relyValue)){
			
			List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildByAreaId(Integer.parseInt(relyValue));
			
			for(PropertyBuild build : buildList){
				map.put(build.getId()+"", build.getBuildName());
			}
			
		}
		
		writer.println(getSelectTagContent(map));
	}

}
