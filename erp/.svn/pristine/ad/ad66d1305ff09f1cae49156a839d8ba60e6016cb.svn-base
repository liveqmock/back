package com.ihk.saleunit.action.new_init;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;

/**
 * 有关项目分区楼栋的拖拉action
 * @author dtc
 * 2013-5-30,下午03:49:05
 */
public class PropertyAreaBuildDragAction extends SupperAction{

	private static final long serialVersionUID = 181932053511780415L;
	
	@Autowired
	IPropertyBuildServices buildServices;
	@Autowired
	IPropertyAreaServices areaServices;
	
	/**
	 * 根据分区id获取楼栋的json tree
	 * @return
	 * @throws Exception
	 */
	public String modifyBuildByBrag() throws Exception{
		
		JSONArray arr = new JSONArray();
		
		int areaId = Integer.parseInt(request.getParameter("areaId"));
		
		List<PropertyBuild> buildList = buildServices.findPropertyBuildByAreaId(areaId);
		
		if(CommonUtils.isCollectionEmpty(buildList)){
			
			CustomerUtils.writeResponse(response, arr.toString());
			
			return null;
		}
		
		JSONObject json = null;
		
		for(PropertyBuild build : buildList){
			
			json = new JSONObject();
			
			json.put("id", build.getId());
			json.put("text", build.getBuildName());
			json.put("attributes", initNodeAttr(build));
			
			arr.add(json);
		}
		
		CustomerUtils.writeResponse(response, arr.toString());
		
		return null;
	}
	
	/**
	 * 设置楼栋json的attribute
	 * @param build
	 * @return
	 */
	private JSONObject initNodeAttr(PropertyBuild build){
		
		JSONObject json = new JSONObject();
		
		if(build != null){
			
			json.put("type", "build");
			json.put("id", build.getId());
		}
		
		return json;
	}

}
