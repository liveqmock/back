package com.ihk.customer.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;

/**
 * 项目默认的省市
 * @author dtc
 * 2013-3-4,下午04:09:11
 */
public class SelProjectDefaultProvinceAndCity extends SupperAction{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICompanyProjectServices companyProjectServices;
	@Autowired
	ICityServices cityService;
	@Autowired
	IRegionServices regionServices;
	
	/**
	 * 获取项目对应的默认省份id
	 * @return
	 * @throws Exception
	 */
	public String getSelProjectDefaultProvince() throws Exception{
		
		String out = "";
		
		try{
			
			int projectId = Integer.parseInt(request.getParameter("projectId"));
		
			CompanyProject project = companyProjectServices.findCompanyProjectById(projectId);
			
			int provinceId = project.getProvinceId();
			
			if(provinceId != 0){
				out = provinceId + "";
			}
			
		}catch (Exception e) {
			
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}

	/**
	 * 获取项目对应的默认城市下拉框
	 * @return
	 * @throws Exception
	 */
	public String getSelProjectDefaultCity() throws Exception{
		
		String content = "<option value=\"\">" + CommonUtils.EMPTY + "</option>"; //默认值
		
		try{
		
			int projectId = Integer.parseInt(request.getParameter("projectId"));
			
			CompanyProject project = companyProjectServices.findCompanyProjectById(projectId);
			
			int provinceId = project.getProvinceId();
			int cityId = project.getCityId();
			
			if(provinceId != 0){
				
				List<City> cityList = cityService.findCityByProvinceId(provinceId);
				
				Map<String, String> cityMap = new LinkedHashMap<String, String>();
				
				for(City city : cityList){
					cityMap.put(city.getCityId() + "", city.getCityName());
				}
				
				content = CommonUtils.getSelectContent(cityMap, cityId+"", true);
				
			}
			
		}catch (Exception e) {
		}
		
		CustomerUtils.writeResponse(response, content);
		
		return null;
	}
	
	/**
	 * 获取项目对应的默认区域下拉框
	 * @return
	 * @throws Exception
	 */
	public String getSelProjectDefaultRegion() throws Exception{
		
		String content = "<option value=\"\">" + CommonUtils.EMPTY + "</option>"; //默认值
		
		try{
		
			int projectId = Integer.parseInt(request.getParameter("projectId"));
			
			CompanyProject project = companyProjectServices.findCompanyProjectById(projectId);
			
			int cityId = project.getCityId();
			
			if(cityId != 0){
				
				List<Region> regionList = regionServices.findRegionByCityId(cityId);
				
				Map<String, String> regionMap = new LinkedHashMap<String, String>();
				
				for(Region region : regionList){
					regionMap.put(region.getRegionId() + "", region.getRegionName());
				}
				
				content = CommonUtils.getSelectContent(regionMap, true);
				
			}
			
		}catch (Exception e) {
		}
		
		CustomerUtils.writeResponse(response, content);
		
		return null;
	}

}
