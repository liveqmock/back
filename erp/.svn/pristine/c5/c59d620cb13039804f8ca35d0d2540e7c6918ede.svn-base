package com.ihk.customer.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContCompanyId;
import com.ihk.constanttype.ContProjectId;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.autocomplete.AutoCompleteMapCallback;
import com.ihk.utils.autocomplete.AutoCompleteUtils;
import com.ihk.utils.saleunit.UnitChangeUtils;

/**
 *  获取项目
 *  统一返回报表的项目下拉框
 */
public class ProjectListAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPropertyProjectServices propertyProServices;
	@Autowired 
	IPropertyBuildServices propertyBuildServices;
	@Autowired
	IPropertyUnitServices propertyUnitServices;
	
	private final static String LIMIT = "|";
	private final static String LINE = "\n";
	
	/**
	 * 左边项目智能提示框
	 * @return
	 * @throws Exception
	 */
	public String leftProjects() throws Exception{
		
		AutoCompleteUtils.doComplete(this, new AutoCompleteMapCallback() {
			
			@Override
			public Map<String, String> complete(String search) throws Exception {
				
				/**
				 * 返回给页面使用的map
				 */
				Map<String, String> retMap = new LinkedHashMap<String, String>();
				
				/**
				 * 使用了缓存的map
				 */
				Map<String, String> getMap = PermissionUtils.getUserRoleMapForLayoutLeft();
				
				if(getMap != null){
					
					Set<String> keys = getMap.keySet();
					
					for(String key : keys){
						
						String value = getMap.get(key);
						if(value.contains(search)){
							
							retMap.put(key, value);
						}
					}
				}
				
				return retMap;
			}
		});
		
		return null;
	}
	
	/**
	 * 左边项目easyui
	 * @return
	 * @throws Exception
	 */
	public String leftProjectsEasyui() throws Exception{
		
		String out = "[]";
		
		Map<String, String> getMap = PermissionUtils.getUserRoleMapForLayoutLeft();
		
		if(!CommonUtils.isMapEmpty(getMap)){
			
			out = CommonUtils.getMapJsonSetUpKeyAndValueName(getMap, "id", "value");
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	public String searchProject() throws Exception{
		
		StringBuffer sb = new StringBuffer();
		
		String name = request.getParameter("q");
		//name = new String(name.getBytes("ISO8859-1"), "UTF-8");
		
		//如果name="",查找所有,并按project_name排序
		if(name != null){
			name = name.trim();
		}
		
		//List<CompanyProject> projects = DescUtils.findCompanyProjectsLikeNameAndCompanyId(name, ContCompanyId.GUANG_ZHOU);
		
		List<CompanyProject> projects = DescUtils.findCompanyProjectsLikeNameAndCompanyId(name, SessionUser.getCompanyId());
		for(CompanyProject project : projects){
			sb.append(project.getProjectName()==null ? "" : project.getProjectName().trim())
				.append(LIMIT)
				.append(project.getId())
				.append(LINE)
				;
		}
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	
	public String searchProjectByExactName() throws Exception{
		String name = request.getParameter("projectName");
		if(name != null){
			name = name.trim();
		}
		CompanyProject project = DescUtils.findCompanyProjectIsExistsByProjectNameAndCompanyId(name, SessionUser.getCompanyId());
		if(project!=null){
			Map<String,String> map = new HashMap<String,String>();
			map.put("hiddenId", project.getId()+"");
			map.put("hiddenCompanyId", project.getCompanyId()+"");
			CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		}
		return null;
	}
	
	
	
	public String getProjectIdByProjectName() throws Exception{
		String projectName = request.getParameter("projectName");
		
		//CompanyProject project = DescUtils.findCompanyProjectIsExistsByProjectNameAndCompanyId(projectName, ContCompanyId.GUANG_ZHOU);
		CompanyProject project = DescUtils.findCompanyProjectIsExistsByProjectNameAndCompanyId(projectName, SessionUser.getCompanyId());
		
		if(project != null){
			//表示该项目存在
			
			CustomerUtils.writeResponse(response, project.getId() + "");
		}else{
			//表示项目不存在,返回0
			CustomerUtils.writeResponse(response, "0");
		}
		
		return null;
	}
	
	//searchPropertyProject getProjectIdByProjectNameForProperty
	public String searchPropertyProject() throws Exception{
		
		StringBuffer sb = new StringBuffer();
		
		String name = request.getParameter("q");
		//name = new String(name.getBytes("ISO8859-1"), "UTF-8");
		
		//如果name="",查找所有,并按project_name排序
		if(name != null){
			name = name.trim();
		}
		
		List<PropertyProject> propertyProList = propertyProServices.findPropertyProjectsLikeName(name);
		
		for(PropertyProject project : propertyProList){
			sb.append(project.getPropertyName()==null ? "" : project.getPropertyName().trim())
				.append(LIMIT)
				.append(project.getId())
				.append(LINE)
				;
		}
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	public String getProjectIdByProjectNameForProperty() throws Exception{
		
		String projectName = request.getParameter("projectName");
		
		PropertyProject project = propertyProServices.findPropertyProjectIsExistsByProjectName(projectName);
		
		if(project != null){
			//表示该项目存在
			
			CustomerUtils.writeResponse(response, project.getId() + "");
		}else{
			//表示项目不存在,返回0
			CustomerUtils.writeResponse(response, "0");
		}
		
		return null;
	}
	
	/**查找BUILD*/
	public String searchPropertyBuild() throws Exception{
		
		StringBuffer sb = new StringBuffer();
		
		String name = request.getParameter("q");
		//name = new String(name.getBytes("ISO8859-1"), "UTF-8");
		
		//如果name="",查找所有,并按project_name排序
		if(name != null){
			name = name.trim();
		}
		
		List<PropertyBuild> buildList = this.propertyBuildServices.findPropertyBuildsLikeName(name);
		
		for(PropertyBuild project : buildList){
			sb.append(project.getBuildName()==null ? "" : project.getBuildName().trim())
				.append(LIMIT)
				.append(project.getId())
				.append(LINE)
				;
		}
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	/**查找BUILDID*/
	public String getBuildIdByBuildNameForProperty() throws Exception{
		
		String projectName = request.getParameter("projectName");
		
		PropertyBuild project = propertyBuildServices.findBuildIsExistsByBuildName(projectName);
		
		if(project != null){
			//表示该项目存在
			
			CustomerUtils.writeResponse(response, project.getId() + "");
		}else{
			//表示项目不存在,返回0
			CustomerUtils.writeResponse(response, "0");
		}
		
		return null;
	}
	
	/**
	 * 根据楼盘项目id,获取对应的楼栋(用于下拉框)
	 */
	public String getBuildListFromPropertyId() throws Exception{
		
		int propertyId = Integer.parseInt(request.getParameter("propertyId"));
		
		List<PropertyBuild> buildList = propertyBuildServices.findPropertyBuildByPropertyId(propertyId);
	
		Map<String, String> map = new HashMap<String, String>();
		
		for(PropertyBuild build : buildList){
			
			map.put(build.getId() + "", build.getBuildName());
		}
		
		String content = CommonUtils.getSelectContent(map, true);
		
		CustomerUtils.writeResponse(response, content);
		
		return null;
	}
	
	/**
	 * 根据楼盘项目id,获取对应的楼栋(用于联想提示框)
	 * @return
	 * @throws Exception
	 */
	public String getBuildListFromPropertyIdForAuto() throws Exception{
		
		String propertyIdStr = request.getParameter("otherData");
		int propertyId = 0;
		if(!CustomerUtils.isStrEmpty(propertyIdStr) && !"0".equals(propertyIdStr)){
			try{
				
				propertyId = Integer.parseInt(propertyIdStr);
			}catch(Exception e){
			}
		}
		
		StringBuffer sb = new StringBuffer();
		
		String name = request.getParameter("q");
		
		if(name != null){
			name = name.trim();
		}
		
		List<PropertyBuild> buildList = new ArrayList<PropertyBuild>();
		
		if(propertyId == 0){
			
			buildList = this.propertyBuildServices.findPropertyBuildsLikeName(name);
		}else{
			
			buildList = this.propertyBuildServices.findPropertyBuildsLikeNameAndPropertyProjectId(name, propertyId);
		}
		
		for(PropertyBuild build : buildList){
			sb.append(build.getBuildName()==null ? "" : build.getBuildName().trim())
				.append(LIMIT)
				.append(build.getId())
				.append(LINE)
				;
		}
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	public String getOtherDataByUnitId() throws Exception{
		
		String typeFrom = request.getParameter("typeFrom");
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		
		PropertyUnit unit = propertyUnitServices.findPropertyUnitById(unitId);
		
		//roomType areaState buildArea insideArea buildPrice insidePrice 
		//priceWay sumPrice buildPrice renovateDesc renovatePrice renovateMoney
		
		List<String> fields = new ArrayList<String>();
		fields.add("buildArea");
		fields.add("insideArea");
		fields.add("buildPrice");
		fields.add("insidePrice");
		
		fields.add("sumPrice");
		fields.add("buildPrice");
		fields.add("renovateDesc");
		fields.add("renovatePrice");
		fields.add("renovateMoney");
		
		fields.add("id");
		fields.add("unitNo");
		
		Map<String, String> map = CommonUtils.getPojoMap(unit, fields);
		map.put("roomType", DescUtils.getCodeDesc(EnumCodeTypeName.PROPERTY_ROOM_TYPE, unit.getRoomType(), ContProjectId.GUANG_ZHOU));
		map.put("areaState", DescUtils.getCodeDesc(EnumCodeTypeName.PROPERTY_AREA_STATE, unit.getAreaState(), ContProjectId.GUANG_ZHOU));
		map.put("priceWay", DescUtils.getCodeDesc(EnumCodeTypeName.PROPERTY_PRICE_WAY, unit.getPriceWay(), ContProjectId.GUANG_ZHOU));
		
		map.put("saleState", DescUtils.getCodeDesc(EnumCodeTypeName.PROPERTY_SALE_STATE, unit.getSaleState(), ContProjectId.GUANG_ZHOU));
		map.put("saleType", DescUtils.getCodeDesc(EnumCodeTypeName.PROPERTY_SALE_TYPE, unit.getSaleType(), ContProjectId.GUANG_ZHOU));
		
		map.put("canChange", UnitChangeUtils.isCanChange(typeFrom, unit) + "");
		
		String out = CommonUtils.getMapJson(map);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	public String projectIsExists() throws Exception{
		
		String projectName = request.getParameter("projectName");
		
		CompanyProject project = DescUtils.findCompanyProjectIsExistsByProjectNameAndCompanyId(projectName, ContCompanyId.GUANG_ZHOU);
		
		StringBuffer jsonData = new StringBuffer();
		
		if(project != null){
			//表示该项目存在
			Map<String, String> map = DescUtils.findCustomerRedByProjectIdForMap(project.getId());
			String toRed = "";
			if(map != null){
				toRed = fieldMatch(map);
			}
			
			jsonData.append("{\"isExists\":\"true\",\"redFiled\":\"")
				.append(toRed)
				.append("\",\"projectId\":\"")
				.append(project.getId())
				.append("\"}")
				;
			
		}else{
			//表示不存在
			jsonData.append("{\"isExists\":\"false\"}");
			
		}
		
		CustomerUtils.writeResponse(response, jsonData.toString());
		
		return null;
	}
	
	public String getRedsByProjectId() throws Exception{
		
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		Map<String, String> map = DescUtils.findCustomerRedByProjectIdForMap(projectId);
		String toRed = "";
		if(map != null){
			toRed = fieldMatch(map);
		}
		
		StringBuffer out = new StringBuffer();
		
		out.append("{\"redFiled\":\"")
			.append(toRed)
			.append("\"}")
			;
		
		CustomerUtils.writeResponse(response, out.toString());
		
		return null;
	}
	
	private String fieldMatch(Map<String, String> map){
		List<String> fieldList = new ArrayList<String>(); //要匹配的字段,页面根据name去匹配
		fieldList.add("customer_visitCount");
		fieldList.add("customer_gender");
		fieldList.add("nationality");
		fieldList.add("idcardNo");
		fieldList.add("trafficDesc");
		fieldList.add("customer_age");
		fieldList.add("address");
		fieldList.add("postcode");
		fieldList.add("customer_familyType");
		fieldList.add("customer_familyIncome");
		fieldList.add("customer_jobType");
		fieldList.add("customer_jobIndustry");
		fieldList.add("intentUnit1");
		fieldList.add("intentUnit2");
		fieldList.add("customer_buyAim");
		fieldList.add("customer_payType");
		fieldList.add("areaNum");
		fieldList.add("customer_intentBuynum");
		fieldList.add("customer_roomType");
		
		fieldList.add("knownFrom");
		fieldList.add("focusPoint");
		
		StringBuffer sb = new StringBuffer();
		
		for(String field : fieldList){
			for(String key : map.keySet()){
				String toKey = key.replace("_", "");
				if(field.toUpperCase().contains(toKey.toUpperCase())){
					Object obj = map.get(key);
					if(obj != null && "1".equals(obj.toString())){
						sb.append(field).append("|");
						break;
					}
				}
			}
		}
		
		return sb.toString();
	}
	

}
