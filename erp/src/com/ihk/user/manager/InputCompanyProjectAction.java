package com.ihk.user.manager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihk.utils.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.ProvinceCond;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.IProvinceServices;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.ICompanyServices;
import com.ihk.user.data.services.IUserRoleServices;
import com.ihk.utils.exception.PrivException;
import com.ihk.utils.pinyin.PinyinBaseUtils;

/**
 * 新建项目 具体操作
 * 
 * 这里需要公司权限   分公司管理 +公司ID
 * */
public class InputCompanyProjectAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	@Autowired ICompanyProjectServices companyProjectServices;
	@Autowired ICompanyServices companyServices;
	@Autowired IUserRoleServices userRoleServices;
	
	@Autowired
	IProvinceServices provinceServices;
	@Autowired
	ICityServices cityServices;
	
	/**
	 * 新建项目弹出框
	 * 从页面来的只需要一个 项目名称
	 * */
	public String inputProjectDialog(){
		init();
		this.removeSuggestion();
		return "suc";
	}
	
	/**
	 * 新建项目提交表单
	 * 
	 * 在新建成功之后 给有该公司权限的人加上后勤权限
	 * */
	public String inputProjectForm(){
		
		if(PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_POWER_CREATE, EnumDevFlag.GUANGZHOU)==false){
			throw new PrivException("没有超级权限,不能新增项目"); 
		}

		init();
		
		inputProject.setProjectName(inputProject.getProjectName().trim()); //去掉前后不合法字符
		
		final Date now = new Date();
		CompanyProjectCond cond = new CompanyProjectCond();
		
		cond.setCompanyId(inputProject.getCompanyId());
		cond.setProjectName(inputProject.getProjectName().trim());
		int countres = this.companyProjectServices.findCompanyProjectCount(cond);
		if(countres > 0){
			this.setSuggestion("操作失败,该公司下已有此项目");
			return "suc";
		}
		
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					//项目拼音
					String pinyin = PinyinBaseUtils.getPinYinHeadChar(inputProject.getProjectName());
					inputProject.setPinyin(pinyin);
					
					inputProject.setIsDeleted("0");
					inputProject.setCreatedId(SessionUser.getUserId());
					inputProject.setCreatedTime(now);
					inputProject.setModId(SessionUser.getUserId());
					inputProject.setModTime(now);
					inputProject.setDevCode("customer_guangzhou");
					companyProjectServices.addCompanyProject(inputProject);
					
					//执行相关数据添加  code_project
					companyProjectServices.addCodeProjectByNewProject(inputProject.getId());
					
					//赋予该人员 该项目维护人员
					UserRole newUserRole = new UserRole();
					newUserRole.setIsDeleted("0");
					newUserRole.setCreatedId(SessionUser.getUserId());
					newUserRole.setModId(SessionUser.getUserId());
					newUserRole.setCreatedTime(now);
					newUserRole.setModTime(now);
					newUserRole.setUserId(SessionUser.getUserId());
					newUserRole.setRoleId(14);//项目维护人员
					newUserRole.setProjectId(inputProject.getId());
					newUserRole.setCompanyId(inputProject.getCompanyId());
					userRoleServices.addUserRole(newUserRole);
					setSuggestion("操作成功.新建项目");
					setUpMarkToClose();
					
				}
			}.execute();
		} catch (Exception e1) {
			this.setSuggestion("操作失败,请重试");
			e1.printStackTrace();
		}
		
        //清缓存
        try {

            CacheUtils.removeCacheByCacheName("comboTree_cache");
        } catch (Exception e) {
            e.printStackTrace();
        }

		return "suc";
	}
	
	/**
	 * 修改项目名称
	 * 主要是在新建项目当天 + 本人 防止文字输入错误 
	 * */
	public String updateProjectDialog(){
		
		this.removeSuggestion();
		inputProject = companyProjectServices.findCompanyProjectById(inputProject.getId());
		
		initProvinceAndCity(inputProject);
		
		Date now = new Date();
		boolean isOneDayLater = CommonUtils.isOneDayLater(inputProject.getCreatedTime(), now); //判断是否超过24h
		if(SessionUser.getUserId() == 2) return "suc";
		if(inputProject == null || inputProject.getCreatedId() != SessionUser.getUserId() || isOneDayLater){
			this.setSuggestion("不能修改,请联系管理员.");
			return "suc";
		}

        //清缓存
        try {

            CacheUtils.removeCacheByCacheName("comboTree_cache");
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "suc";
	}
	
	public String updateProjectForm(){
		String upName = inputProject.getProjectName();
		int provId = inputProject.getProvinceId();
		int cityId = inputProject.getCityId();
		
		initProvinceAndCity(inputProject);
		
		inputProject = companyProjectServices.findCompanyProjectById(inputProject.getId());
		Date now = new Date();
		boolean isOneDayLater = CommonUtils.isOneDayLater(inputProject.getCreatedTime(), now); //判断是否超过24h
		if(SessionUser.getUserId() != 2){
		if(inputProject == null || inputProject.getCreatedId() != SessionUser.getUserId() || isOneDayLater){
			this.setSuggestion("没有修改权限.");
			return "suc";
		}}
		
		if(upName == null || upName.trim().equals("")){
			this.setSuggestion("请填写项目名称.");
			return "suc";
		}
		
		inputProject.setProvinceId(provId);
		inputProject.setCityId(cityId);
		
		inputProject.setProjectName(upName.trim());
		
		//项目拼音
		String pinyin = PinyinBaseUtils.getPinYinHeadChar(inputProject.getProjectName());
		inputProject.setPinyin(pinyin);
		
		inputProject.setModId(SessionUser.getUserId());
		inputProject.setModTime(now);
		
		companyProjectServices.updateCompanyProject(inputProject);
		this.setSuggestion("修改成功.");
		this.setUpMarkToClose();
		
		initProvinceAndCity(inputProject);
		
		return "suc";
	}
	
	private void init(){
		comList = PermissionUtils.getUserCompanyList();
		
		initProvinceAndCity(null);
	}
	
	private void initProvinceAndCity(CompanyProject comProject){
		
		selProvince = new LinkedHashMap<String, String>();
		selProvince.put("", CommonUtils.EMPTY);
		
		List<Province> provinceList = provinceServices.findProvince(new ProvinceCond());
		for(Province province : provinceList){
			selProvince.put(province.getProvinceId()+"", province.getProvinceName());
		}
		
		selCity = new LinkedHashMap<String, String>();
		selCity.put("", CommonUtils.EMPTY);
			
		try {
			if(comProject != null){
				
				List<City> citys = cityServices.findCityByProvinceId(comProject.getProvinceId());
				for(City city : citys){
					selCity.put(city.getCityId()+"", city.getCityName());
				}
			}
		} catch (Exception e) {
		}
	}
	
	
	private CompanyProject inputProject;
	private List<Company> comList;
	
	/**
	 * 省份
	 */
	private Map<String, String> selProvince;
	
	/**
	 * 城市
	 */
	private Map<String, String> selCity;
	
	public Map<String, String> getSelProvince() {
		return selProvince;
	}

	public void setSelProvince(Map<String, String> selProvince) {
		this.selProvince = selProvince;
	}

	public Map<String, String> getSelCity() {
		return selCity;
	}

	public void setSelCity(Map<String, String> selCity) {
		this.selCity = selCity;
	}

	public CompanyProject getInputProject() {
		return inputProject;
	}

	public void setInputProject(CompanyProject inputProject) {
		this.inputProject = inputProject;
	}

	public List<Company> getComList() {
		return comList;
	}

	public void setComList(List<Company> comList) {
		this.comList = comList;
	}
	
}
