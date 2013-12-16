package com.ihk.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.pojo.IdcardLocation;
import com.ihk.saleunit.data.pojo.ContractCustomerCond;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.CityCond;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.ProvinceCond;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.pojo.RegionCond;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.IProvinceServices;
import com.ihk.setting.data.services.IRegionServices;

public class ProvinceCityRegionUtils {
	
	private static IProvinceServices provinceServices;
	private static ICityServices cityServices;
	private static IRegionServices regionServices;
	
	private static ProvinceCityRegionUtils provinceCityRegionUtils;

	public static IProvinceServices getProvinceServices() {
		return provinceServices;
	}


	public void setProvinceServices(IProvinceServices provinceServices) {
		ProvinceCityRegionUtils.provinceServices = provinceServices;
	}


	public static ICityServices getCityServices() {
		return cityServices;
	}


	public void setCityServices(ICityServices cityServices) {
		ProvinceCityRegionUtils.cityServices = cityServices;
	}


	public static IRegionServices getRegionServices() {
		return regionServices;
	}


	public void setRegionServices(IRegionServices regionServices) {
		ProvinceCityRegionUtils.regionServices = regionServices;
	}
	
	@SuppressWarnings("static-access")
	public void init() {
		provinceCityRegionUtils = this;
		provinceCityRegionUtils.provinceServices = this.provinceServices;
		provinceCityRegionUtils.cityServices = this.cityServices;
		provinceCityRegionUtils.regionServices = this.regionServices;
	}


	//通过输入文字获取省市区的id,售前
	public static void setHomeAndWorkDetailToIdByName(CustomerCond cond){
		if(cond.getHomeProvince()!=null && !"".equals(cond.getHomeProvince())){
			if(provinceServices.findProvineByName(cond.getHomeProvince())!=null && !"".equals(provinceServices.findProvineByName(cond.getHomeProvince()))){
				cond.setHomeProvinceStr(cond.getHomeProvince());
				ProvinceCond pcCond = new ProvinceCond();
				pcCond.setProvinceName(cond.getHomeProvince());
				List<Province> pList=provinceServices.findProvince(pcCond);
				List<Integer> idList = new ArrayList<Integer>();
				for(Province p:pList){
					idList.add(p.getProvinceId());
				}
				cond.setHomeProvinceIds(idList);
			}
		}
		if(cond.getWorkProvince()!=null && !"".equals(cond.getWorkProvince())){
			if(provinceServices.findProvineByName(cond.getWorkProvince())!=null && !"".equals(provinceServices.findProvineByName(cond.getWorkProvince()))){
				cond.setWorkProvinceStr(cond.getWorkProvince());
				ProvinceCond pcCond = new ProvinceCond();
				pcCond.setProvinceName(cond.getWorkProvince());
				List<Province> pList=provinceServices.findProvince(pcCond);
				List<Integer> idList = new ArrayList<Integer>();
				for(Province p:pList){
					idList.add(p.getProvinceId());
				}
				cond.setWorkProvinceIds(idList);
				
			}
		}
		if(cond.getHomeCity()!=null && !"".equals(cond.getHomeCity())){
			if(cityServices.findCityByName(cond.getHomeCity())!=null && !"".equals(cityServices.findCityByName(cond.getHomeCity()))){
				cond.setHomeCityStr(cond.getHomeCity());
				CityCond cCond = new CityCond();
				cCond.setCityName(cond.getHomeCity());
				List<City> cList=cityServices.findCity(cCond);
				List<Integer> idList = new ArrayList<Integer>();
				for(City c:cList){
					idList.add(c.getCityId());
				}
				cond.setHomeCityIds(idList);
			}
		}
		if(cond.getWorkCity()!=null && !"".equals(cond.getWorkCity())){
			if(cityServices.findCityByName(cond.getWorkCity())!=null && !"".equals(cityServices.findCityByName(cond.getWorkCity()))){
				cond.setWorkCityStr(cond.getWorkCity());
				CityCond cCond = new CityCond();
				cCond.setCityName(cond.getWorkCity());
				List<City> cList=cityServices.findCity(cCond);
				List<Integer> idList = new ArrayList<Integer>();
				for(City c:cList){
					idList.add(c.getCityId());
				}
				cond.setWorkCityIds(idList);
			}
		}
		if(cond.getHomeRegion()!=null && !"".equals(cond.getHomeRegion())){
			if(regionServices.findRegionByNameStr(cond.getHomeRegion())!=null && !"".equals(regionServices.findRegionByNameStr(cond.getHomeRegion()))){
				cond.setHomeRegionStr(cond.getHomeRegion());
				RegionCond rCond = new RegionCond();
				rCond.setRegionName(cond.getHomeRegion());
				List<Region> rList=regionServices.findRegion(rCond);
				List<Integer> idList = new ArrayList<Integer>();
				for(Region r:rList){
					idList.add(r.getRegionId());
				}
				cond.setHomeRegionIds(idList);
			}
		}
		if(cond.getWorkRegion()!=null && !"".equals(cond.getWorkRegion())){
			if(regionServices.findRegionByNameStr(cond.getWorkRegion())!=null && !"".equals(regionServices.findRegionByNameStr(cond.getWorkRegion()))){
				cond.setWorkRegionStr(cond.getWorkRegion());
				RegionCond rCond = new RegionCond();
				rCond.setRegionName(cond.getWorkRegion());
				List<Region> rList=regionServices.findRegion(rCond);
				List<Integer> idList = new ArrayList<Integer>();
				for(Region r:rList){
					idList.add(r.getRegionId());
				}
				cond.setWorkRegionIds(idList);
			}
		}
	}
	
	
	
	//通过输入文字获取省市区的id,售后
		public static void setHomeAndWorkDetailToIdByNameContractCustomer(ContractCustomerCond cond){
			if(cond.getHomeProvince()!=null && !"".equals(cond.getHomeProvince())){
				if(provinceServices.findProvineByName(cond.getHomeProvince())!=null && !"".equals(provinceServices.findProvineByName(cond.getHomeProvince()))){
					cond.setHomeProvinceStr(cond.getHomeProvince());
					ProvinceCond pcCond = new ProvinceCond();
					pcCond.setProvinceName(cond.getHomeProvince());
					List<Province> pList=provinceServices.findProvince(pcCond);
					List<Integer> idList = new ArrayList<Integer>();
					for(Province p:pList){
						idList.add(p.getProvinceId());
					}
					cond.setHomeProvinceIds(idList);
				}
			}
			if(cond.getHouseholdProvince()!=null && !"".equals(cond.getHouseholdProvince())){
				if(provinceServices.findProvineByName(cond.getHouseholdProvince())!=null && !"".equals(provinceServices.findProvineByName(cond.getHouseholdProvince()))){
					cond.setHouseholdProvinceStr(cond.getHouseholdProvince());
					ProvinceCond pcCond = new ProvinceCond();
					pcCond.setProvinceName(cond.getHouseholdProvince());
					List<Province> pList=provinceServices.findProvince(pcCond);
					List<Integer> idList = new ArrayList<Integer>();
					for(Province p:pList){
						idList.add(p.getProvinceId());
					}
					cond.setHouseholdProvinceIds(idList);
					
				}
			}
			if(cond.getHomeCity()!=null && !"".equals(cond.getHomeCity())){
				if(cityServices.findCityByName(cond.getHomeCity())!=null && !"".equals(cityServices.findCityByName(cond.getHomeCity()))){
					cond.setHomeCityStr(cond.getHomeCity());
					CityCond cCond = new CityCond();
					cCond.setCityName(cond.getHomeCity());
					List<City> cList=cityServices.findCity(cCond);
					List<Integer> idList = new ArrayList<Integer>();
					for(City c:cList){
						idList.add(c.getCityId());
					}
					cond.setHomeCityIds(idList);
				}
			}
			if(cond.getHouseholdCity()!=null && !"".equals(cond.getHouseholdCity())){
				if(cityServices.findCityByName(cond.getHouseholdCity())!=null && !"".equals(cityServices.findCityByName(cond.getHouseholdCity()))){
					cond.setHouseholdCityStr(cond.getHouseholdCity());
					CityCond cCond = new CityCond();
					cCond.setCityName(cond.getHouseholdCity());
					List<City> cList=cityServices.findCity(cCond);
					List<Integer> idList = new ArrayList<Integer>();
					for(City c:cList){
						idList.add(c.getCityId());
					}
					cond.setHouseholdCityIds(idList);
				}
			}
			if(cond.getHomeRegion()!=null && !"".equals(cond.getHomeRegion())){
				if(regionServices.findRegionByNameStr(cond.getHomeRegion())!=null && !"".equals(regionServices.findRegionByNameStr(cond.getHomeRegion()))){
					cond.setHomeRegionStr(cond.getHomeRegion());
					RegionCond rCond = new RegionCond();
					rCond.setRegionName(cond.getHomeRegion());
					List<Region> rList=regionServices.findRegion(rCond);
					List<Integer> idList = new ArrayList<Integer>();
					for(Region r:rList){
						idList.add(r.getRegionId());
					}
					cond.setHomeRegionIds(idList);
				}
			}
			if(cond.getHouseholdRegion()!=null && !"".equals(cond.getHouseholdRegion())){
				if(regionServices.findRegionByNameStr(cond.getHouseholdRegion())!=null && !"".equals(regionServices.findRegionByNameStr(cond.getHouseholdRegion()))){
					cond.setHouseholdRegionStr(cond.getHouseholdRegion());
					RegionCond rCond = new RegionCond();
					rCond.setRegionName(cond.getHouseholdRegion());
					List<Region> rList=regionServices.findRegion(rCond);
					List<Integer> idList = new ArrayList<Integer>();
					for(Region r:rList){
						idList.add(r.getRegionId());
					}
					cond.setHouseholdRegionIds(idList);
				}
			}
		}
	
		/**
		 * 根据省市区的中文列表获取对应的id(Json格式，用于AJAX返回)
		 * @param locationList
		 * @param map
		 * @throws IOException
		 */
		public static String getJsonProvinceCityRegionFromMap(List<IdcardLocation> locationList , Map<String,String> map) throws IOException{
			Province province=null;
			if(locationList.get(0).getAreaProvince().length()>0){
				province = provinceServices.findProvineByName(locationList.get(0).getAreaProvince());
			}
			City city = null;
			if(locationList.get(0).getAreaCity().length()>0){
				city = cityServices.findCityByName(locationList.get(0).getAreaCity());
			}
			Region region = null;
			if(locationList.get(0).getAreaRegion().length()>0){
				region = regionServices.findRegionByNameStr(locationList.get(0).getAreaRegion());
			}
			if(province!=null)
			map.put("province", province.getProvinceId()+"");
			if(city!=null)
			map.put("city", city.getCityId()+"");
			if(region!=null)
			map.put("region", region.getRegionId()+"");
			return CommonUtils.getMapJson(map);
	}
}
