package com.ihk.saleunit.action.common.compro_perpro_area_build;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ihk.constanttype.ContComProAreaBuildKey;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyAreaCond;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 公司项目-->楼盘项目-->分区-->楼栋(考虑多选)
 * @author dtc
 * 2013-2-25,上午11:10:07
 */
public class MyComboTreeCompanyPropertyProjectAreaBuildTemplate {
	
	/**
	 * 加载comboTree
	 * @param request
	 * @return
	 */
	public static String initComboTree(HttpServletRequest request){
		
		JSONArray retArr = new JSONArray(); //返回json数组
		
		String typeId = request.getParameter("id");
		
		if(CommonUtils.isStrEmpty(typeId)){
			//初始加载,获取权限公司项目
			
			List<CompanyProject> comProList = PermissionUtils.getCompanyProjectListByXKZX();
			
			if(!CommonUtils.isCollectionEmpty(comProList)){
				
				Collections.sort(comProList, new MyComparatorProject());
				
				for(CompanyProject project : comProList){
					
					JSONObject comJson = new JSONObject();
					comJson.put("id", ContComProAreaBuildKey.COMPRO + "_" + project.getId());
					comJson.put("text", project.getProjectName());
					comJson.put("state", "closed"); //easyui默认为open
					
					retArr.add(comJson);
				}
				
			}
			
		}else{
			//点击获取
			
			String[] typeAndId = typeId.split("_");
			
			String type = typeAndId[0];
			String id = typeAndId[1];
			
			int valId = Integer.parseInt(id);
			
			if(ContComProAreaBuildKey.COMPRO.equals(type)){
				//公司项目-->楼盘项目
				
				PropertyProjectCond cond = new PropertyProjectCond();
				cond.setCompanyProjectId(valId);
				
				List<PropertyProject> proList = MyPropertyUtils.getPropertyProjectServices().findPropertyProject(cond);
				if(!CommonUtils.isCollectionEmpty(proList)){
					
					for(PropertyProject project : proList){
						
						JSONObject comJson = new JSONObject();
						comJson.put("id", ContComProAreaBuildKey.PERPRO + "_" + project.getId());
						comJson.put("text", project.getPropertyName());
						comJson.put("state", "closed"); //easyui默认为open
						
						retArr.add(comJson);
					}
				}
				
				
			}else if(ContComProAreaBuildKey.PERPRO.equals(type)){
				//楼盘项目-->分区
				PropertyAreaCond cond = new PropertyAreaCond();
				cond.setPropertyId(valId);
				
				List<PropertyArea> areaList = MyPropertyUtils.getPropertyAreaServices().findPropertyArea(cond);
				if(!CommonUtils.isCollectionEmpty(areaList)){
					
					for(PropertyArea area : areaList){
						
						JSONObject comJson = new JSONObject();
						comJson.put("id", ContComProAreaBuildKey.AREA + "_" + area.getId());
						comJson.put("text", area.getAreaName());
						comJson.put("state", "closed"); //easyui默认为open
						
						retArr.add(comJson);
					}
				}
				
				
			}else if(ContComProAreaBuildKey.AREA.equals(type)){
				//分区-->楼栋
				PropertyBuildCond cond = new PropertyBuildCond();
				cond.setAreaId(id);
				
				List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuild(cond);
				if(!CommonUtils.isCollectionEmpty(buildList)){
					
					for(PropertyBuild build : buildList){
						
						JSONObject comJson = new JSONObject();
						comJson.put("id", ContComProAreaBuildKey.BUILD + "_" + build.getId());
						comJson.put("text", build.getBuildName());
						//comJson.put("state", "closed"); //easyui默认为open
						
						retArr.add(comJson);
					}
				}
				
			}
			
		}
		
		String ret = retArr.toString();
		
		return ret;
	}
	
}

/**
 * CompanyProject按projectName排序
 * @author dtc
 * 2013-2-25,下午03:35:22
 */
class MyComparatorProject implements Comparator<CompanyProject>{
	
	@Override
	public int compare(CompanyProject pro1, CompanyProject pro2) {
		
		return pro1.getProjectName().compareTo(pro2.getProjectName());
	}
	
}
