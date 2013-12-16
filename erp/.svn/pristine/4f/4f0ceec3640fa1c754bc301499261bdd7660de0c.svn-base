package com.ihk.utils.contract.unit;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 楼盘项目
 * @author dtc
 * 2013-1-22,下午02:48:10
 */
public class PropertyProjectMapUtils {
	
	/**
	 * 根据公司项目id获取对应的楼盘项目map
	 * @param companyProjectId
	 * @return
	 */
	public static Map<String, String> getMap(int companyProjectId){
	
		PropertyProjectCond cond = new PropertyProjectCond();
		cond.setCompanyProjectId(companyProjectId);
		
		List<PropertyProject> proList = MyPropertyUtils.getPropertyProjectServices().findPropertyProject(cond);
		
		Map<String, String> projectMap = new LinkedHashMap<String, String>();
		projectMap.put("", CommonUtils.EMPTY);
		
		if(!CommonUtils.isCollectionEmpty(proList)){
			
			for(PropertyProject pro : proList){
				
				projectMap.put(pro.getId()+"", pro.getPropertyName());
			}
			
		}
		
		return projectMap;
	}

}
