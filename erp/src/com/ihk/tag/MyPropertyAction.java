package com.ihk.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyAreaCond;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;

/**
 * 项目,分区,楼栋,级联下拉框
 * @author dtc
 * 2012-9-29
 */
public class MyPropertyAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPropertyAreaServices areaServices;
	@Autowired
	IPropertyBuildServices buildServices;
	
	public String getAreaListByPropertyId() throws Exception{
		
		String propertyId = request.getParameter("propertyId");
		
		PropertyAreaCond cond = new PropertyAreaCond();
		cond.setPropertyId(Integer.parseInt(propertyId));
		
		List<PropertyArea> areaList = areaServices.findPropertyArea(cond);
		
		Map<String, String> map = new HashMap<String, String>();
		for(PropertyArea area : areaList){
			map.put(area.getId()+"", area.getAreaName());
		}
		
		String content = CommonUtils.getSelectContent(map, true);
		
		CustomerUtils.writeResponse(response, content);
		
		return null;
	}
	
	public String getBuildListByAreaId() throws Exception{
		
		int areaId = Integer.parseInt(request.getParameter("areaId"));
		
		List<PropertyBuild> buildList = buildServices.findPropertyBuildByAreaId(areaId);
		
		Map<String, String> map = new HashMap<String, String>();
		for(PropertyBuild build : buildList){
			map.put(build.getId()+"", build.getBuildName());
		}
		
		String content = CommonUtils.getSelectContent(map, true);
		
		CustomerUtils.writeResponse(response, content);
		
		return null;
	}
	

}
