package com.ihk.saleunit.action.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyAreaCond;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.action.common.com_pro_property.MyComboTreeCompanyProjectPropertyTemplate;
import com.ihk.saleunit.action.common.compro_perpro_area_build.MyComboTreeCompanyPropertyProjectAreaBuildTemplate;
import com.ihk.saleunit.action.common.proareabuild.MyComboTreeCompanyPropertyProjectTemplate;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.ProvinceCond;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.IProvinceServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CacheFrontName;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.cache.MyCacheTemplate;
import com.ihk.utils.cache.MyCacheTemplateCallback;
import com.ihk.utils.common.tag.CheckboxTagBean;
import com.ihk.utils.common.tag.CheckboxTagUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.ihk.utils.saleunitnew.PropertyUnitUtils;

/**
 * sale_unit下,一些公用action
 * @author dtc
 * 2012-8-23
 */
@SuppressWarnings("unchecked")
public class CommonAction extends SupperAction{

	private static final long serialVersionUID = -6133439440704406011L;
	
	@Autowired
	ICompanyProjectServices companyProjectServices;
	@Autowired
	IProvinceServices provinceServices;
	@Autowired
	ICityServices cityServices;
	@Autowired
	IRegionServices regionServices;
	@Autowired
	IPropertyUnitServices propertyUnitServices;
	@Autowired
	IPropertyBuildServices propertyBuildServices;
	
	/**
	 * 获取单元的全名
	 * @return
	 * @throws Exception
	 */
	public String getUnitAllName() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		
		String allName = PropertyUnitUtils.getUnitAllNameByUnitId(unitId);
		
		CustomerUtils.writeResponse(response, allName);
		
		return null;
	}
	
	public String getUnitAllNameForChip() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		
		PropertyUnit pu = propertyUnitServices.findPropertyUnitById(unitId);
		if(pu.getChip1()==3&&pu.getChip2()==2&&pu.getChip1()==1){
			CustomerUtils.writeResponse(response, "full_chip");//认筹已满
			return null;
		}
		if(ContUnitSaleState.CONFIRM.equals(pu.getSaleState())||ContUnitSaleState.CONTRACT.equals(pu.getSaleState())){
			CustomerUtils.writeResponse(response, "not_sale");//成交或合同单元
			return null;
		}
		String allName = PropertyUnitUtils.getUnitAllNameByUnitId(unitId);
		CustomerUtils.writeResponse(response, allName);
		return null;
	}
	
	public String getUnitBuildAreaForChip() throws Exception{
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		PropertyUnit pu = propertyUnitServices.findPropertyUnitById(unitId);
		PropertyBuild pb = propertyBuildServices.findPropertyBuildById(pu.getBuildId());
		Map<String,String> jsonMap = new HashMap<String,String>();
		jsonMap.put("buildId", pu.getBuildId()+"");
		jsonMap.put("areaId", pb.getAreaId()+"");
		String json = CommonUtils.getMapJson(jsonMap);
		CustomerUtils.writeResponse(response, json);
		return null;
	}
	
	/**
	 * 项目弹出框action
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public String modifyProject() throws Exception{
		
		//List<CompanyProject> projects = companyProjectServices.findCompanyProjectsByCompanyId(SessionUser.getCompanyId());
		
		String projectId = request.getParameter("projectId");
		String projectName = request.getParameter("projectName");
		String roleId = request.getParameter("roleId"); //报表为19
		
		List<CompanyProject> projects  = PermissionUtils.getCompanyProjectListByRoleId(Integer.parseInt(roleId));
		
		List<CheckboxTagBean> changeList = CheckboxTagUtils.parStringToCheckboxList(projectId, projectName);
		projectBeanTrList = CheckboxTagUtils.initCheckboxTagTrListByPojoList(projects, "id", "projectName", "companyId", 4, changeList);
		
		return "modifyProject";
	}

	/**
	 * 消控中心角色的多选项目
	 * @return
	 * @throws Exception
	 */
	public String modifyProjectXKZX() throws Exception{
		
		projectBeanTrList = new MyProjectBeanTrListTemplate() {
			
			@Override
			public List<CompanyProject> doExecuteCallback() {
				
				return PermissionUtils.getCompanyProjectListByXKZX();
			}
			
		}.initTrList(request);
		
		return "modifyProjectXKZX";
	}
	
	/**
	 * 售前客户角色的多选项目
	 * @return
	 * @throws Exception
	 */
	public String modifyProjectSQKH() throws Exception{
		
		/*
		projectBeanTrList = new MyProjectBeanTrListTemplate() {
			
			@Override
			public List<CompanyProject> doExecuteCallback() {
				
				return PermissionUtils.getCompanyProjectListBySQKH();
			}
			
		}.initTrList(request);
		*/
		
		map = new MyCompanyProjectChangeTemplate() {
			
			@Override
			public List<CompanyProject> doExecuteCallback() {
				
				return PermissionUtils.getCompanyProjectListBySQKH();
			}
		}.initMap(request);
		
		return "modifyProjectSQKH";
	}
	
	/**
	 * modifyProjectSQKH对应的ajax action
	 * @return
	 * @throws Exception
	 */
	public String modifyProjectSQKHajax() throws Exception{
		
		String out = new MyComboTreeCompanyProjectTemplate() {
			
			@Override
			public List<CompanyProject> doExecuteCallback() {
				
				return PermissionUtils.getCompanyProjectListBySQKH();
			}
		}.initComboTree(request, "sqkh");
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}

	/**
	 * modifyProjectRYSQ对应的ajax action
	 * @return
	 * @throws Exception
	 */
	public String modifyProjectRYSQajax() throws Exception{
		
		String out = new MyComboTreeCompanyProjectTemplate() {
			
			@Override
			public List<CompanyProject> doExecuteCallback() {
				
				//Collections.sor
				
				return PermissionUtils.getCompanyProjectListByRYSQ();
			}
		}.initComboTree(request, "rysq");
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * modifyProjectXKZX对应的ajax action
	 * @return
	 * @throws Exception
	 */
	public String modifyProjectXKZXajax() throws Exception{
		
		String out = new MyComboTreeCompanyProjectTemplate() {
			
			@Override
			public List<CompanyProject> doExecuteCallback() {
				
				return PermissionUtils.getCompanyProjectListByXKZX();
			}
		}.initComboTree(request, "xkzx");
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 公司-->楼盘项目的单选,多选下拉树
	 * @return
	 * @throws Exception
	 */
	public String modifyProjectXKZXforPropertyajax() throws Exception{
		
		return modifyProjectXKZXforPropertyAjax();
	}
	
	/**
	 * modifyProjectXKZX对应的楼盘项目ajax action
	 * @return
	 * @throws Exception
	 */
	public String modifyProjectXKZXforPropertyAjax() throws Exception{
		
		String out = MyComboTreeCompanyPropertyProjectTemplate.initComboTree(request);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * modifyProjectXKZX对应的分区ajax action
	 * @return
	 * @throws Exception
	 */
	public String modifyProjectXKZXforAreaAjax() throws Exception{
		
		String propertyId = request.getParameter("projectId"); //选择的项目id
		String areaId = request.getParameter("areaId"); //选择的分区
		
		if(!CommonUtils.isIntString(propertyId)){
			
			CustomerUtils.writeResponse(response, CommonUtils.getMapJsonForEmpty("id", "text"));
			return null;
		}
		
		PropertyAreaCond cond = new PropertyAreaCond();
		cond.setPropertyId(Integer.parseInt(propertyId));
		List<PropertyArea> areaList = MyPropertyUtils.getPropertyAreaServices().findPropertyArea(cond);
		
		if(CommonUtils.isCollectionEmpty(areaList)){
			
			CustomerUtils.writeResponse(response, CommonUtils.getMapJsonForEmpty("id", "text"));
			return null;
		}
		
		//利用json
		JSONArray arr = new JSONArray();
		
		JSONObject tmp = new JSONObject();
		tmp.put("id", "");
		tmp.put("text", CommonUtils.EMPTY);
		arr.add(tmp);
		
		for(PropertyArea area : areaList){
			
			tmp = new JSONObject();
			
			tmp.put("id", area.getId());
			tmp.put("text", area.getAreaName());
			
			if((area.getId()+"").equals(areaId)){
				
				tmp.put("selected", true);
			}
			
			arr.add(tmp);
			
		}
		
		String out = arr.toString();
		
		
		/*Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("", CommonUtils.EMPTY);
		
		for(PropertyArea area : areaList){
			
			map.put(area.getId() + "", area.getAreaName());
		}
		
		String out = CommonUtils.getMapJsonSetUpKeyAndValueName(map, "id", "text");*/
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * modifyProjectXKZX对应的楼栋ajax action
	 * @return
	 * @throws Exception
	 */
	public String modifyProjectXKZXforBuildAjax() throws Exception{
		
		String areaId = request.getParameter("areaId");
		String buildId = request.getParameter("buildId");
		
		if(CommonUtils.isStrZeroEmpty(areaId)){
			
			CustomerUtils.writeResponse(response, CommonUtils.getMapJsonForEmpty("id", "text"));
			return null;
		}
		
		List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildByAreaId(Integer.parseInt(areaId));
		
		if(CommonUtils.isCollectionEmpty(buildList)){
			
			CustomerUtils.writeResponse(response, CommonUtils.getMapJsonForEmpty("id", "text"));
			return null;
		}
		
		//利用json
		JSONArray arr = new JSONArray();
		
		JSONObject tmp = new JSONObject();
		tmp.put("id", "");
		tmp.put("text", CommonUtils.EMPTY);
		arr.add(tmp);
		
		for(PropertyBuild build : buildList){
			
			tmp = new JSONObject();
			
			tmp.put("id", build.getId());
			tmp.put("text", build.getBuildName());
			
			if((build.getId()+"").equals(buildId)){
				
				tmp.put("selected", true);
			}
			
			arr.add(tmp);
			
		}
		
		String out = arr.toString();
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 清空combox的值,只剩下[{"":"请选择"}]
	 * @return
	 * @throws Exception
	 */
	public String emptyCombobox() throws Exception{
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJsonForEmpty("id", "text"));
		
		return null;
	}
	
	/**
	 * 公司项目-->楼盘项目-->分区-->楼栋(考虑多选)
	 * @return
	 * @throws Exception
	 */
	public String modifyCompanyPropertyProjectAreaBuildAjax() throws Exception{
		
		String out = MyComboTreeCompanyPropertyProjectAreaBuildTemplate.initComboTree(request);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 公司的单选或多选
	 * @return
	 * @throws Exception
	 */
	public String modifyCompanyXKZXajax() throws Exception{
		
		String out = MyComboTreeCompanyPropertyProjectTemplate.getCompanyComboTreeOnly(request);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 公司,公司项目,楼盘项目单选或多选
	 * @return
	 * @throws Exception
	 */
	public String modifyCompanyProjectPropertyajax() throws Exception{
		
		String out = MyComboTreeCompanyProjectPropertyTemplate.initComboTree(request);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 获取省份的下拉框值
	 * @return
	 * @throws Exception
	 */
	public String getProvinceAjax() throws Exception{
		
		String provinceId = request.getParameter("provinceId");
		
		List<Province> provinceList = (List<Province>) MyCacheTemplate.cache(CacheFrontName.PROVINCE_CITY_REGION_CACHE_NAME + "Province", provinceId, 
				new MyCacheTemplateCallback() {
			
			@Override
			public Object doCache() throws Exception {
				
				return provinceServices.findProvince(new ProvinceCond());
			}
		});
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("", CommonUtils.EMPTY);
		
		if(!CommonUtils.isCollectionEmpty(provinceList)){
			
			for(Province pro : provinceList){
				
				map.put(pro.getProvinceId()+"", pro.getProvinceName());
			}
		}
		
		String out = CommonUtils.getMapJsonSetUpKeyAndValueNameByCheck(map, provinceId);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 获取城市的下拉框值
	 * @return
	 * @throws Exception
	 */
	public String getCityAjax() throws Exception{
		
		final String provinceId = request.getParameter("provinceId");
		String cityId = request.getParameter("cityId");
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("", CommonUtils.EMPTY);
		
		if(CommonUtils.isStrZeroEmpty(provinceId)){
			//如果cityId为空,就直接返回
			
			CustomerUtils.writeResponse(response, CommonUtils.getMapJsonSetUpKeyAndValueNameByCheck(map, ""));
			return null;
		}
		
		List<City> cityList = (List<City>) MyCacheTemplate.cache(CacheFrontName.PROVINCE_CITY_REGION_CACHE_NAME + "City", provinceId + cityId, 
				new MyCacheTemplateCallback() {
					
			@Override
			public Object doCache() throws Exception {
				
				return cityServices.findCityByProvinceId(Integer.parseInt(provinceId));
			}
		});
		
		if(!CommonUtils.isCollectionEmpty(cityList)){
			
			for(City city : cityList){
				
				map.put(city.getCityId()+"", city.getCityName());
			}
		}
		
		String out = CommonUtils.getMapJsonSetUpKeyAndValueNameByCheck(map, cityId);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 获取区域的下拉框值
	 * @return
	 * @throws Exception
	 */
	public String getRegionAjax() throws Exception{
		
		final String cityId = request.getParameter("cityId");
		String regionId = request.getParameter("regionId");
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("", CommonUtils.EMPTY);
		
		if(CommonUtils.isStrZeroEmpty(cityId)){
			//如果cityId为空,就直接返回
			
			CustomerUtils.writeResponse(response, CommonUtils.getMapJsonSetUpKeyAndValueNameByCheck(map, ""));
			return null;
		}
		
		List<Region> regionList = (List<Region>) MyCacheTemplate.cache(CacheFrontName.PROVINCE_CITY_REGION_CACHE_NAME + "Region", cityId + regionId, 
				new MyCacheTemplateCallback() {
					
			@Override
			public Object doCache() throws Exception {
				
				return regionServices.findRegionByCityId(Integer.parseInt(cityId));
			}
		});
		
		if(!CommonUtils.isCollectionEmpty(regionList)){
			
			for(Region region : regionList){
				
				map.put(region.getRegionId()+"", region.getRegionName());
			}
		}
		
		String out = CommonUtils.getMapJsonSetUpKeyAndValueNameByCheck(map, regionId);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	////
	
	/**
	 * 项目checkbox
	 */
	private List<CheckboxTagBean[]> projectBeanTrList; //项目checkbox
	
	/**
	 * 公司select及项目table
	 */
	private Map<Company, List<CompanyProject>> map;
	
	
	public void setMap(Map<Company, List<CompanyProject>> map) {
		this.map = map;
	}
	
	public Map<Company, List<CompanyProject>> getMap() {
		return map;
	}
	
	public void setProjectBeanTrList(List<CheckboxTagBean[]> projectBeanTrList) {
		this.projectBeanTrList = projectBeanTrList;
	}
	
	public List<CheckboxTagBean[]> getProjectBeanTrList() {
		return projectBeanTrList;
	}
	
	public String getListCategoryByQuestionId() throws IOException{
		String content = ""; //默认值
		String questionId = request.getParameter("questionId");
		
		try{
			LinkedHashMap<String, String> listSelCategory = CustomerUtils.getListSelCategoryByQuestionId(Integer.parseInt(questionId==null?"0":questionId));
			StringBuffer sb = new StringBuffer();
			if(listSelCategory.keySet().size() > 0){
				Set<String> keys = listSelCategory.keySet();
				for(String key : keys){
					String value = listSelCategory.get(key);
					if(key.matches("^[0-9]*$")){
						sb.append("<option value=\"")
						.append(key)
						.append("\">")
						.append("*"+value)
						.append("</option>")
						;
					}else{
						sb.append("<option value=\"")
						.append(key)
						.append("\">")
						.append(value)
						.append("</option>")
						;
					}
				}
				
			}
			String getContent = sb.toString();
			if(!CustomerUtils.isStrEmpty(getContent)){
				content = getContent;
			}	
			
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		CustomerUtils.writeResponse(response, content);
		
		return null;
	}
	
}
