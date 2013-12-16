package com.ihk.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.data.ICustomerFocusMapper;
import com.ihk.customer.data.ICustomerKnownMapper;
import com.ihk.customer.data.pojo.CustomerFocus;
import com.ihk.customer.data.pojo.CustomerKnown;
import com.ihk.setting.data.ICodeDtlMapper;
import com.ihk.setting.data.ICodeTypeMapper;
import com.ihk.setting.data.IProjectCodeMapper;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.CityCond;
import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.pojo.CodeType;
import com.ihk.setting.data.pojo.ProjectCode;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.ProvinceCond;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.pojo.RegionCond;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.IProvinceServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.user.data.ICompanyProjectMapper;
import com.ihk.user.data.IUserAccountMapper;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.UserAccount;

/**
 * 系统启动的时候,进行一些相关数据的缓存,主要用于数据下载
 * @author dtc
 * 2012-9-29
 */
public class DownloadCache {
	
	@Autowired	 ICodeTypeMapper codeTypeMapper;
	@Autowired	 ICodeDtlMapper codeDtlMapper;
	@Autowired	 IProjectCodeMapper projectCodeMapper;
	
	private IProvinceServices provinceServices;
	private ICityServices cityServices;
	private IRegionServices regionServices;
	@Autowired	 ICustomerKnownMapper customerKnownMapper;
	@Autowired	 ICustomerFocusMapper customerFocusMapper;
	@Autowired	 ICompanyProjectMapper companyProjectMapper;
	@Autowired	 IUserAccountMapper userAccountMapper;
	
	private static DownloadCache downloadCache;
	
	public static DownloadCache getDownloadCache() {
		return downloadCache;
	}
	
	public static void setDownloadCache(DownloadCache downloadCache) {
		DownloadCache.downloadCache = downloadCache;
	}
	
	public IProvinceServices getProvinceServices() {
		return provinceServices;
	}

	public void setProvinceServices(IProvinceServices provinceServices) {
		this.provinceServices = provinceServices;
	}
	
	public ICityServices getCityServices() {
		return cityServices;
	}

	public void setCityServices(ICityServices cityServices) {
		this.cityServices = cityServices;
	}

	public IRegionServices getRegionServices() {
		return regionServices;
	}

	public void setRegionServices(IRegionServices regionServices) {
		this.regionServices = regionServices;
	}
	
	/**
	 * 省份
	 */
	public static void init_PROVINCE_CACHE(){
		List<Province> allProvinces = downloadCache.provinceServices.findProvince(new ProvinceCond());
		for(Province pro : allProvinces){
			CacheUtils.add(CacheFrontName.PROVINCE_CACHE, pro.getProvinceId() + "", pro);
		}
	}

	/**
	 * 城市
	 */
	public static void init_CITY_CACHE(){
		List<City> allCitys = downloadCache.cityServices.findCity(new CityCond());
		for(City city : allCitys){
			CacheUtils.add(CacheFrontName.CITY_CACHE, city.getCityId() + "", city);
		}		
	}

	/**
	 * 区域
	 */
	public static void init_REGION_CACHE(){
		List<Region> allRegions = downloadCache.regionServices.findRegion(new RegionCond());
		for(Region region : allRegions){
			CacheUtils.add(CacheFrontName.REGION_CACHE, region.getRegionId() + "", region);
		}		
	}

	/**
	 * code_type
	 */
	public static void init_CODE_TYPE_CACHE(){
		List<CodeType> typeList = downloadCache.codeTypeMapper.findAllCodeType();
		for(CodeType type : typeList){
			CacheUtils.add(CacheFrontName.CODE_TYPE_CACHE, type.getTypeName(), type);
		}		
	}

	/**
	 * code_dtl
	 */
	public static void init_CODE_DTL_CACHE(){
		List<CodeDtl> dtlList = downloadCache.codeDtlMapper.findAllCodeDtl();
		
		String key = "";
		for(CodeDtl dtl : dtlList){
			key = dtl.getTypeName() +"_"+ dtl.getCodeVal();
			
			CacheUtils.add(CacheFrontName.CODE_DTL_CACHE, key, dtl);
		}		
	}

	/**
	 * project_code
	 */
	public static void init_PROJECT_CODE_CACHE(){
		List<ProjectCode> proList = downloadCache.projectCodeMapper.findAllProjectCode();
		
		String key = "";
		for(ProjectCode pro : proList){
			key = pro.getTypeName() +"_"+ pro.getCodeVal() +"_"+ pro.getProjectId();
			
			CacheUtils.add(CacheFrontName.PROJECT_CODE_CACHE, key, pro);
		}		
		
	}

	/**
	 * customer_known
	 */
	public static void init_CUSTOMER_KNOWN_CACHE(){
		
		List<CustomerKnown> customerKnownList = downloadCache.customerKnownMapper.findAllCustomerKnown();
		
		/**
		for(CustomerKnown customerKnown : customerKnownList){
			String customerId = String.valueOf(customerKnown.getCustomerId());
			String key = customerId;

			List<CustomerKnown> list = (List<CustomerKnown>)CacheUtils.getValueByCacheNameAndKey(CacheFrontName.CUSTOMER_KNOWN_CACHE, key);
			if(list==null){
				list = new ArrayList<CustomerKnown>();
			}

			list.add(customerKnown);
			
			CacheUtils.add(CacheFrontName.CUSTOMER_KNOWN_CACHE, key, list);
		}	
		*/
		
		if(CommonUtils.isCollectionEmpty(customerKnownList))
			return ;
		
		//先放到map中
		Map<Integer, List<CustomerKnown>> map = new HashMap<Integer, List<CustomerKnown>>();
		int customerId = 0;
		List<CustomerKnown> list = null;
		
		for(CustomerKnown customerKnown : customerKnownList){
			
			customerId = customerKnown.getCustomerId();
			
			if(map.containsKey(customerId)){
				
				list = map.get(customerId);
				
			}else{
				
				list = new ArrayList<CustomerKnown>();
			}
			
			list.add(customerKnown);
			map.put(customerId, list);
		}
		
		//再增加到缓存中
		Set<Integer> keys = map.keySet();
		for(Integer key : keys){
			
			CacheUtils.add(CacheFrontName.CUSTOMER_KNOWN_CACHE, key+"", map.get(key));
		}
		
	}

	/**
	 * customer_focus
	 */
	public static void init_CUSTOMER_FOCUS_CACHE(){
		
		List<CustomerFocus> customerFocusList = downloadCache.customerFocusMapper.findAllCustomerFocus();
		
		/**
		for(CustomerFocus customerFocus : customerFocusList){
			String customerId = String.valueOf(customerFocus.getCustomerId());
			String key = customerId;

			List<CustomerFocus> list = (List<CustomerFocus>)CacheUtils.getValueByCacheNameAndKey(CacheFrontName.CUSTOMER_FOCUS_CACHE, key);
			if(list==null){
				list = new ArrayList<CustomerFocus>();
			}

			list.add(customerFocus);
			
			CacheUtils.add(CacheFrontName.CUSTOMER_FOCUS_CACHE, key, list);
		}		
		*/
		
		if(CommonUtils.isCollectionEmpty(customerFocusList))
			return ;
		
		//先放到map中
		Map<Integer, List<CustomerFocus>> map = new HashMap<Integer, List<CustomerFocus>>();
		int customerId = 0;
		List<CustomerFocus> list = null;
		
		for(CustomerFocus customerFocus : customerFocusList){
			
			customerId = customerFocus.getCustomerId();
			
			if(map.containsKey(customerId)){
				
				list = map.get(customerId);
				
			}else{
				
				list = new ArrayList<CustomerFocus>();
			}
			
			list.add(customerFocus);
			map.put(customerId, list);
		}
		
		//再增加到缓存中
		Set<Integer> keys = map.keySet();
		for(Integer key : keys){
			
			CacheUtils.add(CacheFrontName.CUSTOMER_FOCUS_CACHE, key+"", map.get(key));
		}
	}

	/**
	 * company_project
	 */
	public static void init_COMPANY_PROJECT_CACHE(){
		List<CompanyProject> list = downloadCache.companyProjectMapper.findCompanyProject();
		for(CompanyProject obj : list){
			CacheUtils.add(CacheFrontName.COMPANY_PROJECT_CACHE, obj.getId() + "", obj);
		}			
	}

	/**
	 * user_account
	 */
	public static void init_USER_ACCOUNT_CACHE(){
		List<UserAccount> list = downloadCache.userAccountMapper.findAllUserAccount();
		for(UserAccount obj : list){
			CacheUtils.add(CacheFrontName.USER_ACCOUNT_CACHE, obj.getId() + "", obj);
		}			
	}
	
	/**
	 * 在系统启动的时候,就把省,市,区 缓存起来,每一次对这些表进行操作的时候,都要把对应的缓存清空
	 */
	public void init(){
		
		downloadCache = this;

		init_PROVINCE_CACHE();
		init_CITY_CACHE();
		init_REGION_CACHE();
		
		init_CODE_TYPE_CACHE();
		init_CODE_DTL_CACHE();
		init_PROJECT_CODE_CACHE();
		
		init_CUSTOMER_KNOWN_CACHE();
		init_CUSTOMER_FOCUS_CACHE();
		
		init_COMPANY_PROJECT_CACHE();
		init_USER_ACCOUNT_CACHE();
	}

	/**
	 * 根据枚举值，重新初始化缓存
	 * @param cacheFrontName
	 * @throws Exception
	 */
	public static void initCacheByEnum(CacheFrontName cacheFrontName) throws Exception{
		initCache(cacheFrontName.toString());
	}
	
	/**
	 * 页面重新初始化缓存
	 * @param downloadCacheName
	 * @throws Exception
	 */
	public static void initCache(String downloadCacheName) throws Exception{		
		if(CustomerUtils.isStrEmpty(downloadCacheName)){
			downloadCache.init();
			
		}else{			
			if(CacheFrontName.PROVINCE_CACHE.equalsIgnoreCase(downloadCacheName)){
				
				init_PROVINCE_CACHE();
			}
			else if(CacheFrontName.CITY_CACHE.equalsIgnoreCase(downloadCacheName)){
				
				init_CITY_CACHE();
			}
			else if(CacheFrontName.REGION_CACHE.equalsIgnoreCase(downloadCacheName)){
				
				init_REGION_CACHE();
			}
			else if(CacheFrontName.CODE_TYPE_CACHE.equalsIgnoreCase(downloadCacheName)){
				
				init_CODE_TYPE_CACHE();
			}
			else if(CacheFrontName.CODE_DTL_CACHE.equalsIgnoreCase(downloadCacheName)){
				
				init_CODE_DTL_CACHE();
			}
			else if(CacheFrontName.PROJECT_CODE_CACHE.equalsIgnoreCase(downloadCacheName)){
				
				init_PROJECT_CODE_CACHE();
			}
			else if(CacheFrontName.USER_ACCOUNT_CACHE.equalsIgnoreCase(downloadCacheName)){
				
				init_USER_ACCOUNT_CACHE();
			}
			else if(CacheFrontName.CUSTOMER_FOCUS_CACHE.equalsIgnoreCase(downloadCacheName)){
				
				init_CUSTOMER_KNOWN_CACHE();
			}else if(CacheFrontName.CUSTOMER_KNOWN_CACHE.equalsIgnoreCase(downloadCacheName)){
				
				init_CUSTOMER_FOCUS_CACHE();
			}else if(CacheFrontName.COMPANY_PROJECT_CACHE.equalsIgnoreCase(downloadCacheName)){
				
				init_COMPANY_PROJECT_CACHE();
			}
			else {
				throw new Exception("没有对应的CacheFrontName...");
			}
			
		}
		
		
	}
	
}
