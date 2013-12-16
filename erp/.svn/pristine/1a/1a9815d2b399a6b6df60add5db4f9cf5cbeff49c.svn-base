package com.ihk.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ihk.constanttype.ContProjectId;
import com.ihk.constanttype.ContUserId;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.constanttype.EnumTextTypeName;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerFocus;
import com.ihk.customer.data.pojo.CustomerKnown;
import com.ihk.customer.data.pojo.CustomerRed;
import com.ihk.customer.data.services.ICustomerFocusServices;
import com.ihk.customer.data.services.ICustomerFollowServices;
import com.ihk.customer.data.services.ICustomerKnownServices;
import com.ihk.customer.data.services.ICustomerRedServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Appoint;
import com.ihk.saleunit.data.pojo.AppointCustomer;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IAppointBillDetailServices;
import com.ihk.saleunit.data.services.IAppointBillServices;
import com.ihk.saleunit.data.services.IAppointCustomerServices;
import com.ihk.saleunit.data.services.IAppointServices;
import com.ihk.saleunit.data.services.IConfirmBookServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.setting.data.services.IProvinceServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.pojo.Priv;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.ICompanyServices;
import com.ihk.user.data.services.IPrivServices;
import com.ihk.user.data.services.IRoleServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.cache.MyCacheTemplate;
import com.ihk.utils.cache.MyCacheTemplateCallback;
import com.ihk.utils.common.setup.IgnoreCompanyUserAccountIdUtils;


/**
 * 显示描述的静态类
 * 例如通过id取得name；通过codeVal取得codeDesc
 * @author dtc
 * 2012-9-29
 */
@SuppressWarnings({ "rawtypes", "unchecked", "static-access"})
public class DescUtils {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(DescUtils.class);

	private static IUserAccountServices userAccountServices;
	private static ICodeTypeServices codeTypeServices;
	private ICompanyServices companyServices;
	private ICompanyProjectServices companyProjectServices;
	private static ICustomerServices customerServices;
	private IRoleServices roleServices;
	private IPrivServices privServices;
	private ICustomerRedServices customerRedServices;
	
	private static IProvinceServices provinceServices;
	private static ICityServices cityServices;
	private static IRegionServices regionServices;
	
	private ICustomerKnownServices customerKnownServices;
	private ICustomerFocusServices customerFocusServices;
	
	private IPropertyProjectServices propertyProjectServices;
	private IPropertyBuildServices propertyBuildServices;
	
	private static IPropertyAreaServices propertyAreaServices; //利用static直接公布对应的services
	private IPropertyUnitServices propertyUnitServices;
	private IPropertyAreaServices ipropertyAreaServices;
	
	private IAppointCustomerServices appointCustomerServices;
	private IContractCustomerServices contractCustomerServices;
	
	private IAppointServices appointServices;
	private static IAppointBillServices appointBillServices;
	private static IAppointBillDetailServices appointBillDetailServices;
	
	private static IQuestionTopicServices questionTopicServices;
	
	
	private IContractServices contractServices;
	private static ICustomerFollowServices customerFollowServices;
	
	
	public static ICustomerFollowServices getCustomerFollowServices() {
		return customerFollowServices;
	}

	public void setCustomerFollowServices(
			ICustomerFollowServices customerFollowServices) {
		DescUtils.customerFollowServices = customerFollowServices;
	}

	public IContractServices getContractServices() {
		return contractServices;
	}

	public void setContractServices(IContractServices contractServices) {
		this.contractServices = contractServices;
	}

	public IConfirmServices getConfirmServices() {
		return confirmServices;
	}

	public void setConfirmServices(IConfirmServices confirmServices) {
		this.confirmServices = confirmServices;
	}

	public IConfirmBookServices getConfirmBookServices() {
		return confirmBookServices;
	}

	public void setConfirmBookServices(IConfirmBookServices confirmBookServices) {
		this.confirmBookServices = confirmBookServices;
	}


	private IConfirmServices confirmServices;
	private IConfirmBookServices confirmBookServices;
	
	private static DescUtils descUtils;
	
	public static IAppointBillServices getAppointBillServices() {
		return appointBillServices;
	}

	public void setAppointBillServices(
			IAppointBillServices appointBillServices) {
		DescUtils.appointBillServices = appointBillServices;
	}

	public static IAppointBillDetailServices getAppointBillDetailServices() {
		return appointBillDetailServices;
	}

	public void setAppointBillDetailServices(
			IAppointBillDetailServices appointBillDetailServices) {
		DescUtils.appointBillDetailServices = appointBillDetailServices;
	}

	public void setPropertyAreaServices(
			IPropertyAreaServices propertyAreaServices) {
		DescUtils.propertyAreaServices = propertyAreaServices;
	}
	
	public static IPropertyAreaServices getPropertyAreaServices() {
		return propertyAreaServices;
	}
	
	public void setContractCustomerServices(
			IContractCustomerServices contractCustomerServices) {
		this.contractCustomerServices = contractCustomerServices;
	}
	
	public IContractCustomerServices getContractCustomerServices() {
		return contractCustomerServices;
	}
	
	public void setAppointCustomerServices(
			IAppointCustomerServices appointCustomerServices) {
		this.appointCustomerServices = appointCustomerServices;
	}
	
	public IAppointCustomerServices getAppointCustomerServices() {
		return appointCustomerServices;
	}
	


	public IPropertyAreaServices getIpropertyAreaServices() {
		return ipropertyAreaServices;
	}

	public void setIpropertyAreaServices(IPropertyAreaServices ipropertyAreaServices) {
		this.ipropertyAreaServices = ipropertyAreaServices;
	}

	public void setPropertyProjectServices(
			IPropertyProjectServices propertyProjectServices) {
		this.propertyProjectServices = propertyProjectServices;
	}
	
	public IPropertyProjectServices getPropertyProjectServices() {
		return propertyProjectServices;
	}
	
	public IPropertyUnitServices getPropertyUnitServices() {
		return propertyUnitServices;
	}

	public void setPropertyUnitServices(IPropertyUnitServices propertyUnitServices) {
		this.propertyUnitServices = propertyUnitServices;
	}

	public void setAppointServices(IAppointServices appointServices) {
		this.appointServices = appointServices;
	}
	
	public IAppointServices getAppointServices() {
		return appointServices;
	}

	public IPropertyBuildServices getPropertyBuildServices() {
		return propertyBuildServices;
	}

	public void setPropertyBuildServices(
			IPropertyBuildServices propertyBuildServices) {
		this.propertyBuildServices = propertyBuildServices;
	}

	public void setUserAccountServices(IUserAccountServices userAccountServices) {
		DescUtils.userAccountServices = userAccountServices;
	}

	public void setCodeTypeServices(ICodeTypeServices codeTypeServices) {
		DescUtils.codeTypeServices = codeTypeServices;
	}

	public void setCompanyServices(ICompanyServices companyServices) {
		this.companyServices = companyServices;
	}

	public void setCompanyProjectServices(
			ICompanyProjectServices companyProjectServices) {
		this.companyProjectServices = companyProjectServices;
	}
	
	public void setCustomerServices(ICustomerServices customerServices) {
		DescUtils.customerServices = customerServices;
	}
	
	public void setRoleServices(IRoleServices roleServices) {
		this.roleServices = roleServices;
	}
	
	public IRoleServices getRoleServices() {
		return roleServices;
	}	
	
	public IPrivServices getPrivServices() {
		return privServices;
	}

	public void setPrivServices(IPrivServices privServices) {
		this.privServices = privServices;
	}

	public ICustomerRedServices getCustomerRedServices() {
		return customerRedServices;
	}

	public void setCustomerRedServices(ICustomerRedServices customerRedServices) {
		this.customerRedServices = customerRedServices;
	}

	public static IUserAccountServices getUserAccountServices() {
		return userAccountServices;
	}

	public static  ICodeTypeServices getCodeTypeServices() {
		return codeTypeServices;
	}

	public ICompanyServices getCompanyServices() {
		return companyServices;
	}

	public ICompanyProjectServices getCompanyProjectServices() {
		return companyProjectServices;
	}

	public static ICustomerServices getCustomerServices() {
		return customerServices;
	}
	
	public static IProvinceServices getProvinceServices() {
		return provinceServices;
	}

	public void setProvinceServices(IProvinceServices provinceServices) {
		this.provinceServices = provinceServices;
	}

	public static  ICityServices getCityServices() {
		return cityServices;
	}

	public void setCityServices(ICityServices cityServices) {
		this.cityServices = cityServices;
	}

	public static  IRegionServices getRegionServices() {
		return regionServices;
	}

	public void setRegionServices(IRegionServices regionServices) {
		this.regionServices = regionServices;
	}
	
	public ICustomerKnownServices getCustomerKnownServices() {
		return customerKnownServices;
	}

	public void setCustomerKnownServices(
			ICustomerKnownServices customerKnownServices) {
		this.customerKnownServices = customerKnownServices;
	}

	public ICustomerFocusServices getCustomerFocusServices() {
		return customerFocusServices;
	}

	public void setCustomerFocusServices(
			ICustomerFocusServices customerFocusServices) {
		this.customerFocusServices = customerFocusServices;
	}

	public static IQuestionTopicServices getQuestionTopicServices() {
		return questionTopicServices;
	}

	public void setQuestionTopicServices(
			IQuestionTopicServices questionTopicServices) {
		DescUtils.questionTopicServices = questionTopicServices;
	}

	public void init() {
		descUtils = this;
		descUtils.userAccountServices = this.userAccountServices;
		descUtils.codeTypeServices = this.codeTypeServices;
		descUtils.companyServices = this.companyServices;
		descUtils.companyProjectServices = this.companyProjectServices;
		descUtils.customerServices = this.customerServices;
		descUtils.roleServices = this.roleServices;
		descUtils.privServices = this.privServices;
		descUtils.customerRedServices = this.customerRedServices;
		
		descUtils.provinceServices = this.provinceServices;
		descUtils.cityServices = this.cityServices;
		descUtils.regionServices = this.regionServices;
		
		descUtils.customerKnownServices = this.customerKnownServices;
		descUtils.customerFocusServices = this.customerFocusServices;
		
		descUtils.appointServices = this.appointServices;
		descUtils.propertyProjectServices = this.propertyProjectServices;
		
		descUtils.propertyBuildServices = this.propertyBuildServices;
		descUtils.propertyUnitServices = this.propertyUnitServices;
		descUtils.ipropertyAreaServices = this.ipropertyAreaServices;
		
		descUtils.appointCustomerServices = this.appointCustomerServices;
		descUtils.contractCustomerServices = this.contractCustomerServices;
		descUtils.contractServices = this.contractServices;
		descUtils.confirmServices = this.confirmServices;
		descUtils.confirmBookServices = this.confirmBookServices;

		descUtils.questionTopicServices = this.questionTopicServices;
		descUtils.customerFollowServices = this.customerFollowServices;
	}
	
	/**
	 * 角色名称
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public static String getRoleName(int roleId) throws Exception{
		Role role = descUtils.roleServices.findRoleById(roleId);
		if(role==null){
			return "";
		}
		return role.getRoleName();
	}

	/**
	 * 权限名称
	 * @param privId
	 * @return
	 * @throws Exception
	 */
	public static String getPrivName(int privId) throws Exception{
		Priv priv = descUtils.privServices.findPrivById(privId);
		if(priv==null){
			return "";
		}
		return priv.getPrivName();
	}

	
	/**
	 * @param userId 根据传入userId得到该id real_name
	 * @return 如果没有找到返回"" 
	 * */
	public static String getUserRealName(final int userId) {
		if(userId == 0){
			return "";
		}
		
		Object obj = MyCacheTemplate.cache(CacheFrontName.USER_ACCOUNT_CACHE, userId + "", new MyCacheTemplateCallback() {
			
			@Override
			public Object doCache() throws Exception {
				return descUtils.userAccountServices.findUserAccountById(userId);
			}
		});

		/**
		Object obj = CacheUtils.getValueByCacheNameAndKey(CacheFrontName.USER_ACCOUNT_CACHE, userId + "");
		*/
		return obj==null?"":((UserAccount)obj).getRealName();
		
		/**
		UserAccount user = descUtils.userAccountServices.findUserAccountById(userId);
		return user == null ? "" : user.getRealName();
		*/
	}
	
	/**
	 * @param userName 根据传入name得到该UserAccount实体
	 * @return 如果没有找到返回null,找到了返回相应的实现
	 * */
	public static UserAccount getUserAccountByUserName(String userName) {
		if(userName.trim().equals("")){
			return null;
		}
		try {
			UserAccount getUser = descUtils.userAccountServices.findUserAccountByUserName(userName);
            if(getUser==null)  return new UserAccount();
			return getUser;
		} catch (Exception e) {
			return null;
		}	
	}
	
	
	public static UserAccount getUserAccountById(int userId){
		try {
			UserAccount getUser = descUtils.userAccountServices.findUserAccountById(userId);
            if(getUser==null)  return new UserAccount();
			return getUser;
		} catch (Exception e) {
			return new UserAccount();
		}
		
		
		
	}
	
	/**getproperty by id*/
	public static PropertyUnit getUnitById(int id){
		if (id == 0 )return null;
		try {
			return descUtils.propertyUnitServices.findPropertyUnitById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * 显示company名
	 * 
	 * @param user_account
	 *            .company_id
	 * */
	public static String getCompanyRealName(int companyId)  {
		// Company getCompany =
		// descUtils.userAccountServices.findUserAccountById(userId);
		String realName;
		try{
			Company getCompany = descUtils.companyServices
					.findCompanyById(companyId);
			realName = getCompany.getCompanyName();
		}
		catch(Exception ex ){
			realName = "";
		}
		return realName;
	}

	/**
	 * 显示projectName
	 * @param companyProjectId
	 * @return
	 */
	public static String getCompanyProjectRealName(final int companyProjectId){
		if(companyProjectId==0){
			return "";
		}

		/**
		Object obj = CacheUtils.getValueByCacheNameAndKey(CacheFrontName.COMPANY_PROJECT_CACHE, CompanyProjectId + "");
		*/
		
		Object obj = MyCacheTemplate.cache(CacheFrontName.COMPANY_PROJECT_CACHE, companyProjectId + "", new MyCacheTemplateCallback() {
			
			@Override
			public Object doCache() throws Exception {
				return descUtils.companyProjectServices.findCompanyProjectById(companyProjectId);
			}
		});
		
		return obj==null?"":((CompanyProject)obj).getProjectName();
		
	}
	
	/**
	 * 根据id得到公司项目
	 * @param CompanyProjectId
	 * @return
	 */
	public static CompanyProject getCompanyProjectByProjectId(int CompanyProjectId){
		CompanyProject pro = null;
		try{
			 pro = descUtils.companyProjectServices.findCompanyProjectById(CompanyProjectId);
		}
		catch(Exception ex ){
		
		}
		return pro;
	}

	/**
	 * 根据公司id获取代表的项目<br>
	 * 例如字典表，是根据项目的，而统计中想统计出来
	 * @param companyId
	 * @return
	 */
	public static CompanyProject getCompanyProjectByCompanyId(int companyId){
		CompanyProject pro = null;
		try{
			 List<CompanyProject> list = descUtils.companyProjectServices.findCompanyProjectsByCompanyId(companyId);
			 
			 if(!CommonUtils.isCollectionEmpty(list)){
				 pro = list.get(0);
			 }
		}
		catch(Exception ex ){
		
		}
		return pro;
	}

	/**
	 *  显示数据字典的值
	 * @param typeName
	 * @param codeVal
	 * @param projectId
	 * @return
	 */
	public static String getCodeDesc(EnumCodeTypeName typeName, String codeVal,
			int projectId) {
		return descUtils.codeTypeServices.findCodeDescByCodeVal(typeName, codeVal, projectId);
	}
	
	public static String getDescProjectOrderIndex(int companyProjectId) throws Exception {
		CompanyProject pro = descUtils.companyProjectServices
			.findCompanyProjectById(companyProjectId);
		return pro.getOrderIndex() + "";
	}
	
	/**
	 * 根据项目ID找到公司的真实名称
	 * @param projectId
	 * */
	public static String getCompanyNameByProjectId(int projectId){
		if(projectId==0){
			return "";
		}
		int companyId = getCompanyIdByProjectId(projectId);
		
		return getCompanyRealName(companyId);
	}
	
	public static int getCompanyIdByProjectId(int projectId){
		if(projectId==0){
			return 0;
		}
		int companyId = descUtils.companyProjectServices.findCompanyProjectById(projectId).getCompanyId();
		
		return companyId;
	}
	

	/**
	 * 得到公司项目的名称
	 * @param projectId
	 * @return
	 */
	public static String getProjectNameByProjectId(int projectId){
		CompanyProject companyProject = descUtils.companyProjectServices.findCompanyProjectById(projectId);
		
		if(companyProject!=null){
			return companyProject.getProjectName();
		}
		
		return "";
	}
	
	/**
	 * 根据公司id及项目名称模糊查找项目列表
	 * 如果为admin就不考虑公司id
	 * @param name
	 * @param companyId
	 * @return
	 */
	public static List<CompanyProject> findCompanyProjectsLikeNameAndCompanyId(String name, int companyId){
		
		List<CompanyProject> projects = new ArrayList<CompanyProject>();
		
		try {
			CompanyProjectCond cond = new CompanyProjectCond();
			cond.setName(name);
			
			if(IgnoreCompanyUserAccountIdUtils.getIds().contains(SessionUser.getUserId())){
			//if(SessionUser.getUserId() == ContUserId.ADMIN){
				
				cond.setCompanyId(0);
			}else{
				
				cond.setCompanyId(companyId);
			}
			
			projects = descUtils.companyProjectServices.findCompanyProjectsLikeNameAndCompanyId(cond);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return projects;
		
	}
	
	public static LinkedHashMap getInitSelForGuangZhou(LinkedHashMap sel, EnumCodeTypeName codeType){
		
		return getInitSelForGuangZhou(sel, codeType, false);
	}
	
	public static LinkedHashMap getInitSelForGuangZhou(LinkedHashMap sel, EnumCodeTypeName codeType, String projectId){
		
		return getInitSelForGuangZhou(sel, codeType, false, projectId);
	}
	
	
	public static LinkedHashMap getInitSelForProjectText(LinkedHashMap sel, EnumTextTypeName codeType, boolean isPutEmpty){
		if(sel == null){
			sel = descUtils.codeTypeServices.findTextListForSel(codeType, SessionUser.getProjectId(), isPutEmpty);
		}
		return sel;
	}
	
	/**
	 * 通过登陆者的项目id来获取对应的下拉框的值,为了兼容旧的代码,(出现异常的时候默认是拿广州公司的,可能会出现问题)?
	 * @param sel
	 * @param codeType
	 * @param isPutEmpty
	 * @return
	 */
	public static LinkedHashMap getInitSelForGuangZhou(LinkedHashMap sel, EnumCodeTypeName codeType, boolean isPutEmpty){
		
		if(sel == null){
			
			if(ContProjectId.isOldHuiJing(SessionUser.getProjectId())){
				//如果为汇景新城
				
				sel = descUtils.codeTypeServices.findCodeListForSel(codeType, ContProjectId.OLD_HUI_JING, isPutEmpty); 
			}else if(ContProjectId.isQiaoXin(SessionUser.getProjectId())){
				//侨鑫
				
				sel = descUtils.codeTypeServices.findCodeListForSel(codeType, ContProjectId.QIAO_XIN, isPutEmpty);
			}else if(ContProjectId.SHAN_YU_HU == SessionUser.getProjectId()){
				//中信山语湖
				
				sel = descUtils.codeTypeServices.findCodeListForSel(codeType, ContProjectId.SHAN_YU_HU, isPutEmpty);
			}else{
				
				//应该保证新增的项目都要有对应的project_code,如果为空就默认为广州								
				sel = descUtils.codeTypeServices.findCodeListForSel(codeType, SessionUser.getProjectId(), isPutEmpty);
				
				if(isPutEmpty){
					
					if(sel == null || sel.size() == 1){
						sel = descUtils.codeTypeServices.findCodeListForSel(codeType, ContProjectId.GUANG_ZHOU, isPutEmpty);
					}
				}else{
					
					if(sel == null || sel.size() == 0){
						sel = descUtils.codeTypeServices.findCodeListForSel(codeType, ContProjectId.GUANG_ZHOU, isPutEmpty);
					}
					
				}
				
			}
			
		}
		
		return sel;
	}
	
	
	/**
	 * 通过选择的项目id来获取对应的下拉框的值,为了兼容旧的代码,(出现异常的时候默认是拿广州公司的,可能会出现问题)?
	 * @param sel
	 * @param codeType
	 * @param isPutEmpty
	 * @return
	 */
	public static LinkedHashMap getInitSelForGuangZhou(LinkedHashMap sel, EnumCodeTypeName codeType, boolean isPutEmpty, String projectId){
		
		if(sel == null){
			
			if(ContProjectId.isOldHuiJing(Integer.valueOf(projectId))){
				//如果为汇景新城
				
				sel = descUtils.codeTypeServices.findCodeListForSel(codeType, ContProjectId.OLD_HUI_JING, isPutEmpty); 
			}else if(ContProjectId.isQiaoXin(Integer.valueOf(projectId))){
				//侨鑫
				
				sel = descUtils.codeTypeServices.findCodeListForSel(codeType, ContProjectId.QIAO_XIN, isPutEmpty);
			}else if(ContProjectId.SHAN_YU_HU == Integer.valueOf(projectId)){
				//中信山语湖
				
				sel = descUtils.codeTypeServices.findCodeListForSel(codeType, ContProjectId.SHAN_YU_HU, isPutEmpty);
			}else{
				
				//应该保证新增的项目都要有对应的project_code,如果为空就默认为广州								
				sel = descUtils.codeTypeServices.findCodeListForSel(codeType, Integer.parseInt(projectId), isPutEmpty);
				
				if(isPutEmpty){
					
					if(sel == null || sel.size() == 1){
						sel = descUtils.codeTypeServices.findCodeListForSel(codeType, ContProjectId.GUANG_ZHOU, isPutEmpty);
					}
				}else{
					
					if(sel == null || sel.size() == 0){
						sel = descUtils.codeTypeServices.findCodeListForSel(codeType, ContProjectId.GUANG_ZHOU, isPutEmpty);
					}
					
				}
				
			}
			
		}
		
		return sel;
	}
	
	
	/**
	 * 根据公司id来获取对应的下拉框,如果登陆者的公司id和参数companyId相等,那么就去查
	 * @param sel
	 * @param codeType
	 * @param isPutEmpty
	 * @param companyIdList
	 * @return
	 */
	public static LinkedHashMap getInitSelForGuangZhou(LinkedHashMap sel, EnumCodeTypeName codeType, boolean isPutEmpty, Integer ... companyIdList){
		
		int companyId = SessionUser.getCompanyId();
		
		boolean isHave = false;
		for(int getCompanyId : companyIdList){
			
			if(companyId == getCompanyId){
				isHave = true;
				break;
			}
		}
		
		if(isHave){
			
			int projectId = ContProjectId.getDefaultProjectIdByCompanyId(companyId);
			return descUtils.codeTypeServices.findCodeListForSel(codeType, projectId, isPutEmpty);		
			
		}else{
			
			return getInitSelForGuangZhou(sel, codeType, isPutEmpty);
		}
		
	}
	
	public static LinkedHashMap getInitSelForGuangZhou(LinkedHashMap sel, EnumCodeTypeName codeType, boolean isPutEmpty, Customer customer){
		
		if(sel == null){
			sel = descUtils.codeTypeServices.findCodeListForSel(codeType, customer.getProjectId(), isPutEmpty);
		}
		
		return sel;
	}
	
	
	public static LinkedHashMap getInitSelOnlyEmpty(LinkedHashMap sel){
		
		if(sel == null){
			sel = new java.util.LinkedHashMap();
			sel.put("", CommonUtils.EMPTY);
		}
		
		return sel;
	}
	
	/**
	 * 获取是与否的下拉框
	 * @param sel
	 * @return
	 */
	public static LinkedHashMap getInitSelEmptyAndTrueFalse(LinkedHashMap sel){
		
		return getInitSelEmptyAndTrueFalse(sel, true);
		
	}
	
	public static LinkedHashMap getInitSelEmptyAndTrueFalse(LinkedHashMap sel, boolean isPutEmpty){
		
		if(sel == null){
			sel = new java.util.LinkedHashMap();
			
			if(isPutEmpty){
				sel.put("", CommonUtils.EMPTY);
			}
			sel.put(CommonUtils.FALSE_STR, CommonUtils.FALSE);
			sel.put(CommonUtils.TRUE_STR, CommonUtils.TRUE);
		}
		
		return sel;
	}
	
	public static String getTrueOrFalseStr(String trueOrFalse){
		
		if(CommonUtils.TRUE_STR.equals(trueOrFalse))
			return CommonUtils.TRUE;
		
		return CommonUtils.FALSE;
	}
	
	public static LinkedHashMap getInitSelEmptyAndGender(LinkedHashMap sel){
		
		return getInitSelForGuangZhou(sel, EnumCodeTypeName.GENDER, true);
		
	}
	
	public static CompanyProject findCompanyProjectIsExistsByProjectNameAndCompanyId(String projectName, int companyId){
		
		CompanyProject project;
		try {
			if(IgnoreCompanyUserAccountIdUtils.isIgnore()){
				companyId = 0;
			}
			project = descUtils.companyProjectServices.findCompanyProjectIsExistsByProjectNameAndCompanyId(projectName, companyId);
		} catch (Exception e) {
			e.printStackTrace();
			project = null;
		}
		
		return project;
	}
	
	public static CustomerRed findCustomerRedByProjectId(int projectId){
		
		return descUtils.customerRedServices.findCustomerRedByProjectId(projectId);
	}
	
	public static Map<String, String> findCustomerRedByProjectIdForMap(int projectId){
		
		return descUtils.customerRedServices.findCustomerRedByProjectIdForMap(projectId);
	}
	
	// 电话检验
	public static List<Customer> findPhoneIsExistsByUserId(String phone, int userId){
		
		try {
			return descUtils.customerServices.findPhoneIsExistsByUserId(phone, userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Customer> findHomePhoneIsExistsByUserId(String homePhone, int userId){
		
		try {
			return descUtils.customerServices.findHomePhoneIsExistsByUserId(homePhone, userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 判断电话是否在项目中已经存在
	 * @param phone
	 * @param projectId
	 * @return
	 */
	@Deprecated
	public static boolean isExistPhoneByProjectId(String phone, String projectId){
		
		try {
			List<Map<String,String>> userList = descUtils.customerServices.findPhoneIsExistsByProjectId(phone,Integer.valueOf(projectId));
			
			if(!CommonUtils.isCollectionEmpty(userList)){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
	
	public static List<Customer> findPhoneIsExistsByUserId(String phone, int userId, String projectId){
		
		try {
			return descUtils.customerServices.findPhoneIsExistsByUserId(phone, userId, projectId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Customer> findHomePhoneIsExistsByUserId(String homePhone, int userId, String projectId){
		
		try {
			return descUtils.customerServices.findHomePhoneIsExistsByUserId(homePhone, userId, projectId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Province findProvinceById(int id){
		if(id<=0){
			return new Province();
		}
		Object obj = CacheUtils.getValueByCacheNameAndKey(CacheFrontName.PROVINCE_CACHE, id + "");
		
		if(obj == null){
			
			Province retPro = descUtils.provinceServices.findProvinceById(id);
			return retPro == null ? new Province() : retPro;
		}else{
			
			return (Province) obj;
		}
		
	}
	
	public static City findCityById(int id){
		if(id<=0){
			return new City();
		}
		Object obj = CacheUtils.getValueByCacheNameAndKey(CacheFrontName.CITY_CACHE, id + "");
		
		if(obj == null){
			
			City retCity = descUtils.cityServices.findCityById(id);
			return retCity == null ? new City() : retCity;
		}else{
			
			return (City) obj;
		}
		
		
	}

	public static Region findRegionById(int id){
		if(id<=0){
			return new Region();
		}
		Object obj = CacheUtils.getValueByCacheNameAndKey(CacheFrontName.REGION_CACHE, id + "");
		
		if(obj == null){
			
			Region retRegion = descUtils.regionServices.findRegionById(id);
			return retRegion == null ? new Region() : retRegion;
		}else{
			
			return (Region) obj;
		}
		
	}
	
	public static List<CustomerKnown> findCustomerKnownByCustomerId(int id){
		Object obj = CacheUtils.getValueByCacheNameAndKey(CacheFrontName.CUSTOMER_KNOWN_CACHE, id + "");
		
		if(obj != null){
			try {
				return (List<CustomerKnown>)obj;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<CustomerKnown>(); 
	}
	
	public static List<CustomerFocus> findCustomerFocusByCustomerId(int id){
		Object obj = CacheUtils.getValueByCacheNameAndKey(CacheFrontName.CUSTOMER_FOCUS_CACHE, id + "");
		
		if(obj != null){
			try {
				return (List<CustomerFocus>)obj;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<CustomerFocus>(); 
	}
	
	public static String findPropertyNameByAppointId(int appointId){
		
		Appoint appoint = descUtils.appointServices.findAppointById(appointId);
		PropertyProject project = descUtils.propertyProjectServices.findPropertyProjectById(appoint.getPropertyId());
		if(project == null){
			
			return "";
		}else{
			
			return project.getPropertyName();
		}
		
	}
	
	public static String findPropertyNameById(int id){
		
		PropertyProject project = descUtils.propertyProjectServices.findPropertyProjectById(id);
		if(project == null){
			
			return "";
		}else{
			
			return project.getPropertyName();
		}
		
	}
	
	public static PropertyProject findPropertyProject(int id){
		return descUtils.propertyProjectServices.findPropertyProjectById(id);
	}
	
	/**
	 * 根据单元id获取对应的楼盘项目
	 * @param unitId
	 * @return
	 */
	public static PropertyProject findPropertyProjectByUnitId(int unitId){
		
		try{
			
			PropertyUnit unit = descUtils.propertyUnitServices.findPropertyUnitById(unitId);
			PropertyBuild build = descUtils.propertyBuildServices.findPropertyBuildById(unit.getBuildId());
			PropertyProject project = descUtils.propertyProjectServices.findPropertyProjectById(build.getPropertyId());
			
			return project == null ? new PropertyProject() : project;
		}catch(Exception e){
			
			return new PropertyProject();
		}
		
	}
	
	public static PropertyBuild findPropertyBuildByUnitId(int unitId){
		return getBuildById(findPropertyUnitByUnitId(unitId).getBuildId());
	}
	
	public static PropertyArea findPropertyAreaByAreaId(int areaId){
		if(areaId == 0)return new PropertyArea();
		PropertyArea tarea = descUtils.ipropertyAreaServices.findPropertyAreaById(areaId);
		return tarea;
	}
	
	public static PropertyBuild getBuildById(int buildId){
		PropertyBuild pro = null;
		try{
			
			pro = descUtils.propertyBuildServices.findPropertyBuildById(buildId);
		}catch(Exception e){
		}
		
		return pro == null ? new PropertyBuild() : pro;
	}
	
	/**
	 * 根据单元id获取对应的单元
	 * @param unitId
	 * @return
	 */
	public static PropertyUnit findPropertyUnitByUnitId(int unitId){
		
		try{
			
			PropertyUnit unit = descUtils.propertyUnitServices.findPropertyUnitById(unitId);
			
			return unit == null ? new PropertyUnit() : unit;
		}catch(Exception e){
			
			return new PropertyUnit();
		}
		
	}
	
	public static AppointCustomer findAppointCustomerById(int customerId){
		
		try{
			
			return descUtils.appointCustomerServices.findAppointCustomerById(customerId);
		}catch(Exception e){
			
			return null;
		}
		
	}
	
	public static ContractCustomer findContractCustomerById(int customerId){
		
		try{
			
			return descUtils.contractCustomerServices.findContractCustomerById(customerId);
		}catch(Exception e){
			
			return null;
		}
		
	}
	
	
	public static Date findConfirmTypeDate(int mainId , String confirmType){
		try{
			if(confirmType.equals("1")){
				return descUtils.confirmServices.findConfirmById(mainId).getWorkDate();
			}
			if(confirmType.equals("2")){
				return descUtils.contractServices.findContractById(mainId).getSignDate();
			}
			if(confirmType.equals("3")){
				return descUtils.confirmBookServices.findConfirmBookById(mainId).getCreatedTime();
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
		
	}
	
	public static String findConfirmTypeSalesStr(int mainId , String confirmType){
		try{
			if(confirmType.equals("1")){
				return descUtils.confirmServices.findConfirmById(mainId).getSalesName();
			}
			if(confirmType.equals("2")){
				return descUtils.contractServices.findContractById(mainId).getSalesName();
			}
			if(confirmType.equals("3")){
				return descUtils.confirmBookServices.findConfirmBookById(mainId).getSalesName();
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
		
	}
	
	public static String findConfirmTypePayWay(int mainId , String confirmType){
		try{
			if(confirmType.equals("1")){
				return descUtils.confirmServices.findConfirmById(mainId).getPayWay();
			}
			if(confirmType.equals("2")){
				return descUtils.contractServices.findContractById(mainId).getPayTypeStr();
			}
			if(confirmType.equals("3")){
				return null;
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
		
	}
	
	public static String findAreaName(int mainId , String confirmType){
		try{
			if(confirmType.equals("1")){
				return propertyAreaServices.findPropertyAreaById(descUtils.propertyBuildServices.findPropertyBuildById(descUtils.confirmServices.findConfirmById(mainId).getUnit().getBuildId()).getAreaId()).getAreaName();
			}
			if(confirmType.equals("2")){
				return propertyAreaServices.findPropertyAreaById(descUtils.propertyBuildServices.findPropertyBuildById(descUtils.contractServices.findContractById(mainId).getUnit().getBuildId()).getAreaId()).getAreaName();
			}
			if(confirmType.equals("3")){
				return propertyAreaServices.findPropertyAreaById(descUtils.propertyBuildServices.findPropertyBuildById(descUtils.confirmBookServices.findConfirmBookById(mainId).getUnit().getBuildId()).getAreaId()).getAreaName();
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
		
	}
	
	
	public static String findBuildName(int mainId , String confirmType){
		try{
			if(confirmType.equals("1")){
				return descUtils.confirmServices.findConfirmById(mainId).getPropertyBuildName();
			}
			if(confirmType.equals("2")){
				return descUtils.contractServices.findContractById(mainId).getPropertyBuildName();
			}
			if(confirmType.equals("3")){
				return descUtils.confirmBookServices.findConfirmBookById(mainId).getPropertyBuildName();
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
		
	}
		
	public static String findUnitNo(int mainId , String confirmType){
		try{
			if(confirmType.equals("1")){
				return descUtils.confirmServices.findConfirmById(mainId).getUnit().getUnitNo();
			}
			if(confirmType.equals("2")){
				return descUtils.contractServices.findContractById(mainId).getUnit().getUnitNo();
			}
			if(confirmType.equals("3")){
				return descUtils.confirmBookServices.findConfirmBookById(mainId).getUnit().getUnitNo();
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
		
	}
	
	public static BigDecimal findBuildArea(int mainId , String confirmType){
		try{
			if(confirmType.equals("1")){
				return descUtils.confirmServices.findConfirmById(mainId).getUnit().getBuildArea();
			}
			if(confirmType.equals("2")){
				return descUtils.contractServices.findContractById(mainId).getUnit().getBuildArea();
			}
			if(confirmType.equals("3")){
				return null;
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
	}
	
	
	public static BigDecimal findSumMoney(int mainId , String confirmType){
		try{
			if(confirmType.equals("1")){
				return descUtils.confirmServices.findConfirmById(mainId).getSumMoney();
			}
			if(confirmType.equals("2")){
				return descUtils.contractServices.findContractById(mainId).getSumMoney();
			}
			if(confirmType.equals("3")){
				return null;
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
	}
	
	
	public static List<PropertyProject> getPropertyProjectByCompanyProjectId(int companyProjectId){
		try{
			List<PropertyProject> lpp=descUtils.getPropertyProjectServices().findPropertyProjectByCompanyProjectId(companyProjectId);
			return lpp;
		}catch(Exception e){
			return null;
		}
	}
	/**
	 * 获取跟进日期最后的一条记录
	 * @param cutomerId
	 * @return
	 */
	public static Date getCustomerFollowCreatedTime(int customerId){
		if(customerFollowServices.findCustomerFollowByCustomerIdNewestRecord(customerId)==null){
			return null;
		}
		return customerFollowServices.findCustomerFollowByCustomerIdNewestRecord(customerId).getCreatedTime();
	}
	
	
}