package com.ihk.permission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.ihk.constanttype.EnumCompanyProjectType;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyCond;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.RoleCond;
import com.ihk.user.data.pojo.RolePriv;
import com.ihk.user.data.pojo.RolePrivCond;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.pojo.UserRoleCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.ICompanyServices;
import com.ihk.user.data.services.IFuncTreeServices;
import com.ihk.user.data.services.IPrivFuncServices;
import com.ihk.user.data.services.IPrivServices;
import com.ihk.user.data.services.IRolePrivServices;
import com.ihk.user.data.services.IRoleServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.user.data.services.IUserRoleServices;
import com.ihk.user.data.services.impl.RoleServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.PermissionCacheName;
import com.ihk.utils.SessionUser;
import com.ihk.utils.cache.MyCacheTemplate;
import com.ihk.utils.cache.MyCacheTemplateCallback;
import com.ihk.utils.common.setup.RoleSetUpUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 权限工具类
 * @author peter 
 */
public class PermissionUtils {
	private static final Logger logger = Logger.getLogger(PermissionUtils.class); 	
		
	
	/**
	 * 是否管理员或者创建者
	 * @param ownerId 记录所属用户id
	 * @return
	 */
    @Deprecated
	public static boolean isAdminOrOwner(int ownerId){		
		if(SessionUser.isAdmin()==true || ownerId==SessionUser.getUserId()){
			return true;
		}
		return false;
	}	
    
    /**
     * 检验是否管理员或者创建者
     * @param loggerMessage 日志消息
     * @param ownerId 记录所属用户id
     */
	public static void doCheckAdminOrOwner(String loggerMessage,int ownerId){	
		if(isAdminOrOwner(ownerId)==false){
			String messageTips = "permission.doCheckAdminOrOwner:"+loggerMessage+"-ownerId"+ownerId+"-loginUserId"+SessionUser.getUserIdStr();
			logger.error(messageTips);
		}
	}	
	
	/**
	 * 检验是否已经登录
	 * @param loggerMessage
	 */
	public static void doCheckLogin(String loggerMessage){	
		if(SessionUser.isLogined()==false){
			String messageTips = "permission.doCheckLogin:"+loggerMessage+"-loginUserId"+SessionUser.getUserIdStr();
			logger.error(messageTips);
			throw new RuntimeException(messageTips);
		}
	}
	
	
	
	private IUserAccountServices userAccountServices;
	private ICompanyServices companyServices;
	private ICompanyProjectServices companyProjectServices;
	private IUserRoleServices	userRoleServices;
	private IRoleServices	roleServices;
	private IPrivServices	privServices;
	private IRolePrivServices	rolePrivServices;
	private IPrivFuncServices	privFuncServices;
	private IFuncTreeServices	funcTreeServices;
	private IPropertyProjectServices	propertyProjectServices;
	
	private static PermissionUtils permissionUtils;

	public void setUserAccountServices(IUserAccountServices userAccountServices) {
		this.userAccountServices = userAccountServices;
	}

	public void setCompanyServices(ICompanyServices companyServices) {
		this.companyServices = companyServices;
	}

	public void setCompanyProjectServices(
			ICompanyProjectServices companyProjectServices) {
		this.companyProjectServices = companyProjectServices;
	}
	
	public void setUserRoleServices(
			IUserRoleServices userRoleServices) {
		this.userRoleServices = userRoleServices;
	}
	
	public void setRoleServices(IRoleServices roleServices) {
		this.roleServices = roleServices;
	}
	
	public void setPrivServices(IPrivServices privServices) {
		this.privServices = privServices;
	}
	
	public void setRolePrivServices(IRolePrivServices rolePrivServices) {
		this.rolePrivServices = rolePrivServices;
	}
	
	public void setPrivFuncServices(IPrivFuncServices privFuncServices) {
		this.privFuncServices = privFuncServices;
	}
	
	public void setFuncTreeServices(IFuncTreeServices funcTreeServices) {
		this.funcTreeServices = funcTreeServices;
	}
	
	public void setPropertyProjectServices(IPropertyProjectServices propertyProjectServices) {
		this.propertyProjectServices = propertyProjectServices;
	}

	/**
	 * 静态方法的初始化,用于applicationContext
	 */
	public void init() {
		permissionUtils = this;
		permissionUtils.userAccountServices = this.userAccountServices;
		permissionUtils.companyServices = this.companyServices;
		permissionUtils.companyProjectServices = this.companyProjectServices;
		permissionUtils.userRoleServices = this.userRoleServices;		
		permissionUtils.roleServices = this.roleServices;		
		permissionUtils.rolePrivServices = this.rolePrivServices;	
		permissionUtils.privServices = this.privServices;	
		permissionUtils.privFuncServices = this.privFuncServices;		
		permissionUtils.funcTreeServices = this.funcTreeServices;		
		permissionUtils.propertyProjectServices = this.propertyProjectServices;		
	}
	
	/**
	 * 当前用户可以录客的项目
	 * */
	public static List<CompanyProject> getAddCustomerCompanyProject(){
		int companyId = SessionUser.getCompanyId();
		List<CompanyProject> proList = permissionUtils.companyProjectServices.findCompanyProjectsByCompanyId(companyId);
		return proList;
	}
	
	/**
	 * 当前用户拥有的角色
	 */
	public static List<Role> getUserRoleList()  {
		return getUserRoleListByUid(SessionUser.getUserId());
	}
	
	/**
	 * 当前用户是否具有该角色
	 * @param roleId 角色
	 * */
	public  static boolean isHaveThisRole(int roleId){
		List<Role> rr = getUserRoleList();
		boolean res = false;
		
		if(rr == null || rr.size() == 0)return false;
		
		for(Role r : rr){
			if(r.getId() == roleId){
				res = true;
				break;
			}
		}
		
		return res;
	}
	


	/**
	 * 指定用户拥有的角色
	 * @param userId 用户id
	 * @return 角色列表
	 */
	public static List<Role> getUserRoleListByUid(int userId)  {
		UserRoleCond cond = new UserRoleCond();
		cond.userId = String.valueOf(userId);
		List<UserRole> roleList = permissionUtils.userRoleServices.findUserRolePage(cond);
		
		RoleCond roleCond = new RoleCond();
		List listRoleIds = new ArrayList();
		for(int i=0;i<roleList.size();i++){
			UserRole role = roleList.get(i);
			listRoleIds.add(role.getRoleId());
		}
		roleCond.setRoleIds(listRoleIds);
		if(roleCond.getRoleIds()==null || roleCond.getRoleIds().size()==0){
			return null;
		}
		
		return permissionUtils.roleServices.findRolePage(roleCond);
	}
	
	/**
	 * 当前用户，在指定项目中拥有的角色
	 * @param projectId 项目id
	 * @return 角色列表
	 */
	public static List<Role> getUserRoleListByProjectId(int projectId)  {
		return getUserRoleListByProjectIdUid(projectId,SessionUser.getUserId());
	}

	/**
	 * 指定用户，在指定项目中拥有的角色
	 * @param projectId 项目id
	 * @param userId 用户id
	 * @return 角色列表
	 */
	public static List<Role> getUserRoleListByProjectIdUid(int projectId,int userId)  {
		UserRoleCond cond = new UserRoleCond();
		cond.userId = String.valueOf(userId);
		cond.setProjectId(String.valueOf(projectId));
		List<UserRole> roleList = permissionUtils.userRoleServices.findUserRolePage(cond);
		
		RoleCond roleCond = new RoleCond();
		List listRoleIds = new ArrayList();
		for(int i=0;i<roleList.size();i++){
			UserRole role = roleList.get(i);
			listRoleIds.add(role.getRoleId());
		}
		roleCond.setRoleIds(listRoleIds);
		if(roleCond.getRoleIds()==null || roleCond.getRoleIds().size()==0){
			return null;
		}
		
		return permissionUtils.roleServices.findRolePage(roleCond);
	}
	
	
	/**
	 * 当前角色,指定项目，是否拥有指定角色
	 * @param projectId
	 * @param roleId
	 * @return
	 */
	public static boolean isHaveRoleByProjectId(int projectId,int roleId){
		return isHaveRoleByUserIdAndProjectId(projectId,SessionUser.getUserId(),roleId);
	}
	
	/**
	 * 指定用户，指定项目，是否拥有指定角色
	 * @param projectId
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public static boolean isHaveRoleByUserIdAndProjectId(int projectId,int userId,int roleId){
		List<Role> roles = getUserRoleListByProjectIdUid(projectId, userId);
		for (Role role : roles) {
			if(role.getId()==roleId)
				return true;
		}
		return false;
	}
	
	/**
	 * 当前用户，指定角色Id查找拥有的项目id列表
	 */
	public static String findProjectIdByRoleId(int roleId){
		List<Integer> projectIds = findProjectIdByRoleIdAndUserId(SessionUser.getUserId(),roleId);
		StringBuilder builder = new StringBuilder("-1,");
		for (Integer integer : projectIds) {
			builder.append(integer+",");
		}
		return projectIds.toString();
	}
	
	
	/**
	 * 根据用户Id,角色Id查找拥有的项目id列表
	 * 
	 */
	
	public static List<Integer> findProjectIdByRoleIdAndUserId(int userId,int roleId){
		StringBuilder builder = new StringBuilder("-1,");
		UserRoleCond cond = new UserRoleCond();
		cond.setRoleId(roleId+"");
		cond.setUserId(userId+"");
		List<UserRole>  userRoles = permissionUtils.userRoleServices.findUserRolePage(cond);
		List<Integer> companyIds = new ArrayList<Integer>();
		List<Integer> projectIds = new ArrayList<Integer>();
		for (UserRole userRole : userRoles) {
			companyIds.add(userRole.getCompanyId());
		}
		if(companyIds.size()!=0){
			CompanyProjectCond projectCond  = new CompanyProjectCond();
			projectCond.setCompanyIds(companyIds);
			List<CompanyProject> companyProjects =  permissionUtils.companyProjectServices.findCompanyProjectByCond(projectCond);
			for (CompanyProject companyProject : companyProjects) {
				projectIds.add(companyProject.getId());
			}
		}
		return projectIds;
	}
	
	/**
	 * 指定用户,指定角色 ，查询用户角色关系列表
	 * @param userId 用户ID
	 * @param roleId 角色ID
	 * @return 用户角色关系列表
	 */
	public static List<UserRole> getUserRoleListByUserIdAndRoleId(int userId,int roleId)  {
		UserRoleCond cond = new UserRoleCond();
		cond.setUserId(userId+"");
		cond.setRoleId(roleId+"");
		List<UserRole> roleList = permissionUtils.userRoleServices.findUserRolePage(cond);
		
		//去除重复项目
		List<UserRole> retRoleList = new LinkedList<UserRole>();
		Map<String,UserRole> map = new HashMap<String,UserRole>();
		for(UserRole role : roleList){			
			int projectId = role.getProjectId();
			String key = "p:"+projectId+"c:"+role.getCompanyId();
			if(map.get(key) != null){
				continue;
			}
			map.put(key, role);
		}
		
		Set<String> tt = map.keySet();
		
		for (String t : tt) {
			retRoleList.add(map.get(t));
		}
		
		return retRoleList;
	}
	
	/**
	 * 角色是否有指定权限
	 * @param roleId 角色id
	 * @param privId 权限id
	 * @return 
	 */
	private static boolean isHavePrivCode(int roleId,int privId){		
		RolePrivCond privCond = new RolePrivCond();
		List listRoleIdsPriv = new ArrayList();		
		listRoleIdsPriv.add(roleId);			
		privCond.setRoleIds(listRoleIdsPriv);
		
		if(privCond.getRoleIds()==null || privCond.getRoleIds().size()==0){
			return false;
		}
		privCond.setPrivId(String.valueOf(privId));
		List<RolePriv> privList = permissionUtils.rolePrivServices.findRolePrivPage(privCond);
		
		if(privList!=null && privList.size()>0){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 当前用户，指定权限，指定开发代号，拥有的角色
	 * @param privCode 权限代码
	 * @param devFlag 开发编号
	 * @return 角色列表
	 */
	public static List<Role> getUserRoleList(EnumPrivCode privCode,EnumDevFlag devFlag)  {
		return getUserRoleListByUid(privCode,devFlag,SessionUser.getUserId());
	}
	
	/**
	 * 指定用户，指定权限，指定开发代号，拥有的角色
	 * @param privCode 权限代码
	 * @param devFlag 开发编号
	 * @param userId 用户id
	 * @return 角色列表
	 */
	public static List<Role> getUserRoleListByUid(EnumPrivCode privCode,EnumDevFlag devFlag,int userId)  {
		List<Role> roleList = getUserRoleListByUid(userId);
		if(roleList==null){
			return null;
		}
		int privId = permissionUtils.privServices.findIdByCodeDevFlag(privCode,devFlag);
				
		List listRoleIds = new ArrayList();
		for(int i=0;i<roleList.size();i++){
			Role role = roleList.get(i);
			if(isHavePrivCode(role.getId(),privId)){
				listRoleIds.add(role.getId());
			}
		}	
				
		RoleCond roleCond = new RoleCond();		
		
		roleCond.setRoleIds(listRoleIds);
		if(roleCond.getRoleIds()==null || roleCond.getRoleIds().size()==0){
			return null;
		}
		return permissionUtils.roleServices.findRolePage(roleCond);
	}
	
	/**
	 * 该方法废弃,使用getCompanyProjectListByXKZX()替代
	 * 当前用户,拥有的公司项目列表
	 * @return 项目列表
	 */
	@Deprecated
	public static List<CompanyProject> getUserProjectList()  {
		return getUserProjectListByUid(SessionUser.getUserId());
	}
	
	/**
	 * 指定用户，拥有的公司项目列表
	 * @param userId 用户id
	 * @return 项目列表
	 */
	public static List<CompanyProject> getUserProjectListByUid(int userId)  {
		List listProjectIds = getUserProjectIdListByUid(userId);
		if(listProjectIds!=null){
			CompanyProjectCond cond = new CompanyProjectCond();
			cond.setProjectIds(listProjectIds);
			return permissionUtils.companyProjectServices.findCompanyProjectPage(cond);
		}
		
		return null;		
	}

	/**
	 * 当前用户，指定权限，拥有的公司项目id列表
	 * @param privCode 权限代号
	 * @return 项目id列表
	 */
	public static List<Integer> getUserProjectIdList(EnumPrivCode privCode)  {
		return getUserProjectIdListByUid(SessionUser.getUserId(),privCode);
	}
	
	/**
	 * 指定用户，指定权限，拥有的公司项目id列表
	 * @param userId 用户id
	 * @param privCode 权限代号
	 * @return 项目id列表
	 */
	public static List<Integer> getUserProjectIdListByUid(int userId,EnumPrivCode privCode)  {
		UserRoleCond cond = new UserRoleCond();
		cond.setUserId(String.valueOf(userId));
		cond.setPrivCode(privCode.toString());
		return permissionUtils.userRoleServices.findProjectIdsByUserPriv(cond);
	}
	

	/**
	 * 指定用户，指定权限，拥有的公司id列表
	 * @param userId 用户id
	 * @param privCode 权限代号
	 * @return 项目id列表
	 */
	public static List<Integer> getUserCompanyIdListByUid(int userId,EnumPrivCode privCode)  {
		UserRoleCond cond = new UserRoleCond();
		cond.setUserId(String.valueOf(userId));
		cond.setPrivCode(privCode.toString());
		return permissionUtils.userRoleServices.findCompanyIdsByUserPriv(cond);
	}
	
	/**
	 * 当前用户，拥有的公司项目id列表
	 * @return 项目id列表
	 */
	public static List<Integer> getUserProjectIdList()  {
		return getUserProjectIdListByUid(SessionUser.getUserId());
	}
	
	/**
	 * 指定用户,拥有的公司项目id列表
	 * @param userId 用户id
	 * @return 项目id列表
	 */
	public static List<Integer> getUserProjectIdListByUid(int userId)  {
		UserRoleCond cond = new UserRoleCond();
		cond.userId = String.valueOf(userId);
		List<UserRole> roleList = permissionUtils.userRoleServices.findUserRolePage(cond);

		List<Integer> listProjectIds = new ArrayList();
		if(roleList!=null && roleList.size()>0){
			for(int i=0;i<roleList.size();i++){
				UserRole userRole = roleList.get(i);
				if(userRole.getProjectId()>0){
					if(!listProjectIds.contains(userRole.getProjectId())){
						listProjectIds.add(userRole.getProjectId());
					}
				}
				if(userRole.getCompanyId()>0){
					List<Integer> lCompanys = getAllSubCompanyIdsByCompany(userRole.getCompanyId());
					
					
					List<Integer> lProject = getCompanyProjectIdsByCompanys(lCompanys);
					for(int j=0;j<lProject.size();j++){
						if(!listProjectIds.contains(lProject.get(j))){
							listProjectIds.add(lProject.get(j));
						}					
					}
				}
			}
		}

		if(listProjectIds.size()==0){
			listProjectIds.add(-1);
		}
		
		return listProjectIds;		
	}
	
	/**
	 * 取得公司所有的子项目id（包括子公司递归）
	 * @param companyIds 公司ids
	 * @return 项目id列表
	 */
	public static List<Integer> getCompanyAllProjectIdsByCompanys(List<Integer> companyIds){
		List<Integer> listProjectIds = new ArrayList();
		List<Integer> lProject = getCompanyProjectIdsByCompanysIncludeIsDeleted(companyIds);
		for(int j=0;j<lProject.size();j++){
			if(!listProjectIds.contains(lProject.get(j))){
				listProjectIds.add(lProject.get(j));
			}					
		}
		
		return listProjectIds;
	}

	/**
	 * 取得公司的所有递归子公司(包括公司自己本身)
	 * @param companyId
	 * @return
	 */
	private static List<Integer> getAllSubCompanyIdsByCompany(int companyId){
		List<Integer> listCompanyIds = new ArrayList();
		listCompanyIds.add(companyId);
		
		List<Integer> listFirstChilds = getSubCompanyIdsByCompany(companyId);
		for(int i=0;i<listFirstChilds.size();i++){
			if(!listCompanyIds.contains(listFirstChilds.get(i))){
				listCompanyIds.add(listFirstChilds.get(i));
			}			
		}

		boolean flag = true;
		if(listCompanyIds.size()<2){
			flag = false;
		}
		
		while(flag){
			flag = false;
			List<Integer> listSecondChilds = getSubCompanyIdsByCompany(listCompanyIds);
			
			for(int i=0;i<listSecondChilds.size();i++){
				if(!listCompanyIds.contains(listSecondChilds.get(i))){
					listCompanyIds.add(listSecondChilds.get(i));
					flag = true;
				}			
			}
		}
		
		return listCompanyIds;		
	}

	/**
	 * 取得公司直接下属的所有公司id（不包括自己）
	 * @param companyId
	 * @return
	 */
	private static List<Integer> getSubCompanyIdsByCompany(int companyId){
		List<Integer> listCompanyIds = new ArrayList();
		CompanyCond cond = new CompanyCond();
		cond.setParentId(companyId);
		List<Company> companyList = permissionUtils.companyServices.findCompanyPage(cond);
		
		if(companyList!=null && companyList.size()>0){
			for(int i=0;i<companyList.size();i++){
				Company company = companyList.get(i);
				if(!listCompanyIds.contains(company.getId())){
					listCompanyIds.add(company.getId());
				}
			}			
		}
		
		return listCompanyIds;		
	}
	

	/**
	 * 取得多个公司直接下属的所有公司id（不包括自己）
	 * @param companyIds
	 * @return
	 */
	private static List<Integer> getSubCompanyIdsByCompany(List<Integer> companyIds){
		List<Integer> listCompanyIds = new ArrayList();
		CompanyCond cond = new CompanyCond();
		cond.setParentIds(companyIds);
		List<Company> companyList = permissionUtils.companyServices.findCompanyPage(cond);
		
		if(companyList!=null && companyList.size()>0){
			for(int i=0;i<companyList.size();i++){
				Company company = companyList.get(i);
				if(!listCompanyIds.contains(company.getId())){
					listCompanyIds.add(company.getId());
				}
			}			
		}
		
		return listCompanyIds;		
	}
	

	/**
	 * 取得多个公司下属的所有项目id
	 * @param companyIds
	 * @return
	 */
	private static List<Integer> getCompanyProjectIdsByCompanys(List<Integer> companyIds){
		CompanyProjectCond condProject = new CompanyProjectCond();
		condProject.setCompanyIds(companyIds);
		List<CompanyProject> projectList = permissionUtils.companyProjectServices.findCompanyProjectPage(condProject);

		List<Integer> listProjectIds = new ArrayList();
		if(projectList!=null && projectList.size()>0){
			for(int i=0;i<projectList.size();i++){
				CompanyProject project = projectList.get(i);
				listProjectIds.add(project.getId());				
			}					
		}
		
		return listProjectIds;
	}
	
	
	/**
	 * 取得多个公司下属的所有项目id,包括已删除的项目
	 * @param companyIds
	 * @return
	 */
	private static List<Integer> getCompanyProjectIdsByCompanysIncludeIsDeleted(List<Integer> companyIds){
		CompanyProjectCond condProject = new CompanyProjectCond();
		condProject.setCompanyIds(companyIds);
		List<CompanyProject> projectList = permissionUtils.companyProjectServices.findCompanyProjectPageIncludeIsDeleted(condProject);

		List<Integer> listProjectIds = new ArrayList();
		if(projectList!=null && projectList.size()>0){
			for(int i=0;i<projectList.size();i++){
				CompanyProject project = projectList.get(i);
				listProjectIds.add(project.getId());				
			}					
		}
		
		return listProjectIds;
	}
	
	/**
	 * 取得公司下属的所有项目id
	 * @param companyId
	 * @return
	 */
	private static List<Integer> getCompanyProjectIdsByCompany(int companyId){
		CompanyProjectCond condProject = new CompanyProjectCond();
		condProject.setCompanyId(companyId);
		List<CompanyProject> projectList = permissionUtils.companyProjectServices.findCompanyProjectPage(condProject);

		List<Integer> listProjectIds = new ArrayList();
		if(projectList!=null && projectList.size()>0){
			for(int i=0;i<projectList.size();i++){
				CompanyProject project = projectList.get(i);
				listProjectIds.add(project.getId());				
			}					
		}
		
		return listProjectIds;
	}
	
	
	/**
	 * 当前用户拥有的公司列表（用户所有能看的公司）
	 * @return
	 */
	public static List<Company> getUserCompanyList()  {
		return getUserCompanyListByUid(SessionUser.getUserId());
	}
	
	/**
	 * 指定用户拥有的公司列表(取得项目，然后再反查出公司)
	 */
	public static List<Company> getUserCompanyListByUid(int userId)  {
		List<Integer> listIds = getUserCompanyIdListByUid(userId);
		if(listIds!=null && listIds.size()>0){
			CompanyCond cond = new CompanyCond();
			cond.setCompanyIds(listIds);
			return permissionUtils.companyServices.findCompanyPage(cond);
		}
		
		return null;		
	}
	
	/**
	 * 当前用户拥有的公司id列表
	 * @return
	 */
	public static List<Integer> getUserCompanyIdList()  {
		return getUserCompanyIdListByUid(SessionUser.getUserId());
	}
	
	/**
	 * 指定用户拥有的公司id列表
	 * @param userId
	 * @return
	 */
	public static List<Integer> getUserCompanyIdListByUid(int userId)  {
		List<Integer> projectIds =getUserProjectIdListByUid(userId);
		CompanyProjectCond cond = new CompanyProjectCond();

		if(projectIds==null || projectIds.size()==0){
			return null;
		}
		cond.setProjectIds(projectIds);
		List<CompanyProject> projectList = permissionUtils.companyProjectServices.findCompanyProjectPage(cond);
		
		if(projectList!=null && projectList.size()>0){
			List<Integer> companyIds = new ArrayList();
			for(int i=0;i<projectList.size();i++){
				CompanyProject companyProject = projectList.get(i);
				int cid = companyProject.getCompanyId();
				if(!companyIds.contains(cid)){
					companyIds.add(cid);
				}
			}
			
			return companyIds;
		}
		
		return null;		
	}
	
	/**
	 * 当前用户对应所有项目的权限
	 * @return
	 */
	public static List<RolePriv> getUserPrivList()  {
		return getUserPrivListByUid(SessionUser.getUserId());
	}
	
	/**
	 * 指定用户对应所有项目的权限
	 * @param userId
	 * @return
	 */
	public static List<RolePriv> getUserPrivListByUid(int userId)  {
		List<Role> roleList = getUserRoleListByUid(userId) ;
		if(roleList!=null && roleList.size()>0){			
			RolePrivCond cond = new RolePrivCond();
			List listRoleIds = new ArrayList();
			for(int i=0;i<roleList.size();i++){
				Role role = roleList.get(i);
				listRoleIds.add(role.getId());
			}			
			
			cond.setRoleIds(listRoleIds);
			return permissionUtils.rolePrivServices.findRolePrivPage(cond);
		}
		
		return null;		
	}	
	
//	//当前用户拥有的功能树
//	public static List<PrivFunc> getUserPrivFuncList()  {
//		return getUserPrivFuncListByUid(SessionUser.getUserId());
//	}
	
//	//指定用户拥有的功能树
//	public static List<PrivFunc> getUserPrivFuncListByUid(int userId)  {
//		List<RolePriv> privList = getUserPrivListByUid(userId) ;
//		if(privList!=null && privList.size()>0){
//			PrivFuncCond cond = new PrivFuncCond();
//			List listPrivCodes = new ArrayList();
//			for(int i=0;i<privList.size();i++){
//				RolePriv role = privList.get(i);
//				listPrivCodes.add(role.getPrivCode());
//			}
//			cond.setPrivCodes(listPrivCodes);
//			return permissionUtils.privFuncServices.findPrivFuncPage(cond);
//		}
//		
//		return null;		
//	}
//	
//	//当前用户的功能树列表(过滤重复)用于显示左边功能树	
//	public static List<FuncTree> getUserFuncTreeList()  {
//		return getUserFuncTreeListByUid(SessionUser.getUserId());
//	}
//		
//	public static List<FuncTree> getUserFuncTreeListByUid(int userId)  {
//		List<PrivFunc> privList = getUserPrivFuncListByUid(userId) ;
//		if(privList!=null && privList.size()>0){
//			FuncTreeCond cond = new FuncTreeCond();
//			List listTreeCodes = new ArrayList();
//			for(int i=0;i<privList.size();i++){
//				PrivFunc priv = privList.get(i);
//				listTreeCodes.add(priv.getTreeCode());
//			}
//			cond.setTreeCodes(listTreeCodes);
//			cond.setOrderByFiled("11");
//			return permissionUtils.funcTreeServices.findFuncTreePage(cond);
//		}
//		
//		return null;		
//	}
	
	/**
	 * 当前用户是否具备某项目的某权限
	 * @param projectId
	 * @param privCode
	 * @param devFlag
	 * @return
	 */
	public static boolean hasPermission(int projectId,EnumPrivCode privCode,EnumDevFlag devFlag)  {		
		return hasPermissionByUid(projectId,privCode,devFlag,SessionUser.getUserId());
	}
	
	/**
	 * 指定用户是否具备某项目的某权限
	 * @param projectId
	 * @param privCode
	 * @param devFlag
	 * @param userId
	 * @return
	 */
	public static boolean hasPermissionByUid(int projectId,EnumPrivCode privCode,EnumDevFlag devFlag,int userId)  {		
		List<CompanyProject> projectList = getUserProjectListByUid(privCode,devFlag,userId);
		
		if(projectList!=null && projectList.size()>0){
			for(int i=0;i<projectList.size();i++){
				CompanyProject project = projectList.get(i);
				if(project.getId()==projectId){
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	/**
	 * 当前用户拥有的某权限的项目列表
	 * @param privCode
	 * @param devFlag
	 * @return
	 */
	public static List<CompanyProject> getUserProjectList(EnumPrivCode privCode,EnumDevFlag devFlag)  {
		return getUserProjectListByUid(privCode,devFlag,SessionUser.getUserId());
	}
	
	/**
	 * 指定用户拥有的某权限的项目列表
	 * ?目前此方法,只要项目有指定权限,都会返回到列表
	 * @param privCode
	 * @param devFlag
	 * @param userId
	 * @return
	 */
	public static List<CompanyProject> getUserProjectListByUid(EnumPrivCode privCode,EnumDevFlag devFlag,int userId)  {
		List<Role> roleList = getUserRoleListByUid(privCode,devFlag,userId) ;

		if(roleList!=null && roleList.size()>0){
			UserRoleCond cond = new UserRoleCond();
			cond.setUserId(String.valueOf(userId));
			
			List listRoleIds = new ArrayList();
			for(int i=0;i<roleList.size();i++){
				Role role = roleList.get(i);
				listRoleIds.add(role.getId());
			}
			cond.setRoleIds(listRoleIds);
			List<UserRole> userRoleList = permissionUtils.userRoleServices.findUserRolePage(cond);
			
			if(userRoleList!=null && userRoleList.size()>0){
				CompanyProjectCond condProject = new CompanyProjectCond();
				
				List listProjectIds = new ArrayList();
				for(int i=0;i<userRoleList.size();i++){
					UserRole userRole = userRoleList.get(i);
					listProjectIds.add(userRole.getProjectId());
				}
				condProject.setProjectIds(listProjectIds);
				return permissionUtils.companyProjectServices.findCompanyProjectPage(condProject);
			}
		}
		
		return null;		
	}
	
	/**
	 * 当前用户具有同类别的项目列表（例如恒大项目sale）
	 * @param projectType
	 * @return
	 */
    @Deprecated
	public static List<CompanyProject> getUserProjectListByType(EnumCompanyProjectType projectType)  {
		return getUserProjectListByTypeUid(projectType,SessionUser.getUserId());
	}

	/**
	 * 指定用户具有同类别的项目列表（例如恒大项目sale）
	 * @param projectType
	 * @param userId
	 * @return
	 */
    @Deprecated
	public static List<CompanyProject> getUserProjectListByTypeUid(EnumCompanyProjectType projectType,int userId)  {
		List<Role> roleList = getUserRoleListByUid(userId) ;
		if(roleList!=null && roleList.size()>0){
			CompanyProjectCond cond = new CompanyProjectCond();
			List listProjectIds = new ArrayList();
			for(int i=0;i<roleList.size();i++){
				Role role = roleList.get(i);
				listProjectIds.add(role.getProjectId());
			}
			cond.setProjectIds(listProjectIds);
			
			if(projectType==EnumCompanyProjectType.SALE){
				cond.setIsSale(CommonUtils.TRUE_STR);
			}
			if(projectType==EnumCompanyProjectType.CRM){
				cond.setIsCrm(CommonUtils.TRUE_STR);
			}
			return permissionUtils.companyProjectServices.findCompanyProjectPage(cond);
		}
		
		return null;		
	}
	
	/**
	 * 当前用户是否具备某权限（只要有任一角色有权限，则视为有权限）
	 * @param privCode
	 * @param devFlag
	 * @return
	 */
	public static boolean hasPermission(EnumPrivCode privCode,EnumDevFlag devFlag)  {	
		//return hasPermissionByUid(privCode,devFlag,SessionUser.getUserId());
		
		//改方法在left.jsp中多次调用,且每一次都要重复查询多次,把该方法放到session中
		
		int userId = SessionUser.getUserId();
		String sessionKey = privCode.toString() + "_" + devFlag.toString() + "_" + userId;
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object sessionValue = session.getAttribute(sessionKey);
		if(sessionValue != null){
			
			return (Boolean) sessionValue;
		}else{
			
			boolean isHave = hasPermissionByUid(privCode, devFlag, userId);
			session.setAttribute(sessionKey, isHave);
			
			return isHave;
		}
		
	}
	
	/**
	 * 指定用户是否具备某权限（只要有任一角色有权限，则视为有权限）
	 * @param privCode
	 * @param devFlag
	 * @param userId
	 * @return
	 */
	public static boolean hasPermissionByUid(EnumPrivCode privCode,EnumDevFlag devFlag,int userId)  {		
		List<Role> roleList = getUserRoleListByUid(privCode,devFlag,userId);
		
		if(roleList!=null && roleList.size()>0){
				return true;
		}
		return false;
	}
	
	/**
	 * 指定用户的实际权限列表
	 * @param userId
	 * @return
	 */
	public static List findUserPriv(int userId)  {
		return permissionUtils.privServices.findUserPriv(userId);
	}
	
	/**
	 * 当前用户是否跨公司(有多个公司操作权)
	 * @return
	 */
	public static boolean isMultiCompany(){
		return isMultiCompanyByUid(SessionUser.getUserId());
	}
	
	/**
	 * 指定用户是否跨公司(有多个公司操作权)
	 * @param userId
	 * @return
	 */
	public static boolean isMultiCompanyByUid(int userId){
		List list = getUserCompanyIdListByUid(userId);
		if(list!=null && list.size()>1){
			return true;
		}
		return false;
	}
	
	/**
	 * 当前用户是否跨项目(多个项目的操作权)
	 * @return
	 */
	public static boolean isMultiProject(){
		return isMultiProjectByUid(SessionUser.getUserId());
	}
	
	/**
	 * 指定用户是否跨项目(多个项目的操作权)
	 * @param userId
	 * @return
	 */
	public static boolean isMultiProjectByUid(int userId){
		List list = getUserProjectIdListByUid(userId);
		if(list!=null && list.size()>1){
			return true;
		}
		return false;
	}
	

	/**
	 * 销控role对应的CompanyProject id
	 * 销控中心拥有的公司项目
	 */
	public static List<Integer> getProjectIdListByXKZX(){
		
		List<CompanyProject> proList = getCompanyProjectListByXKZX();
		
		List<Integer> retList = new ArrayList<Integer>();
		
		if(!CommonUtils.isCollectionEmpty(proList)){
			
			for(CompanyProject pro : proList){
				if(pro!=null){
					retList.add(pro.getId());
				}
			}
		}
		
		return retList;
	}


	/**
	 * 销控role对应的CompanyProject name
	 * 销控中心拥有的公司项目
	 */
	public static List<String> getProjectNameListByXKZX(){
		
		List<CompanyProject> proList = getCompanyProjectListByXKZX();
		
		List<String> retList = new LinkedList<String>();
		
		if(!CommonUtils.isCollectionEmpty(proList)){
			
			for(CompanyProject pro : proList){
				if(pro!=null){				
					retList.add(pro.getProjectName());
				}
			}
		}
		
		return retList;
	}

	/**
	 * 销控中心能查看的公司项目
	 * 报表里面能查看的公司项目
	 * @return
	 */
	public static List<CompanyProject> getCompanyProjectListByXKZX(){

		List<Integer> projectIds = PermissionUtils.getUserProjectIdList(EnumPrivCode.SALEUNIT_CENTER_RETRIEVE);

		return getCompanyProjectListByIds(projectIds);
		//return getCompanyProjectListByRoleId(RoleSetUpUtils.getXkzxRoleId());
	}	
	
	/**
	 * 认筹管理能查看的公司项目
	 * 
	 * @return
	 */
	public static List<CompanyProject> getCompanyProjectListByRCGL(){

		List<Integer> projectIds = PermissionUtils.getUserProjectIdList(EnumPrivCode.SALEUNIT_INIT_RETRIEVE);

		return getCompanyProjectListByIds(projectIds);
		//return getCompanyProjectListByRoleId(RoleSetUpUtils.getXkzxRoleId());
	}

	/**
	 * 当前用户，销控role对应的楼盘项目列表
	 * 销控中心拥有的楼盘项目
	 */
	public static List<PropertyProject> getPropertyProjectListByXKZX(){		
		List<Integer> companyProjectIdList = getProjectIdListByXKZX();
		
		PropertyProjectCond cond = new PropertyProjectCond();
		
		if(companyProjectIdList==null || companyProjectIdList.size()==0){
			return null;
		}
		
		cond.setCompanyProjectIds(companyProjectIdList);
		
		return permissionUtils.propertyProjectServices.findPropertyProject(cond);	
		
	}
	
	/**
	 * 获取当前客户销控role对应的公司,楼盘项目map
	 * @return
	 */
	public static Map<Company, List<PropertyProject>> getCompanyAndPropertyProjectMapByXKZX(){
		
		Map<Company, List<PropertyProject>> map = new HashMap<Company, List<PropertyProject>>();
		
		List<CompanyProject> projectList = getCompanyProjectListByXKZX(); //销控中心权限的公司项目
		if(CommonUtils.isCollectionEmpty(projectList)){
			return map;
		}
		
		Set<Integer> comIdSet = new HashSet<Integer>(); //所有的公司
		Map<Integer, List<PropertyProject>> intMap = new HashMap<Integer, List<PropertyProject>>(); //公司id,楼盘项目list
		
		List<PropertyProject> propertyList = null;
		
		for(CompanyProject pro : projectList){
			
			int comId = pro.getCompanyId();
			if(!comIdSet.contains(comId)){
				comIdSet.add(comId);
			}
			
			propertyList = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectByCompanyProjectId(pro.getId());
			if(!CommonUtils.isCollectionEmpty(propertyList)){
				
				if(intMap.containsKey(comId)){
					//如果已经包含就拿出来,增加好再放进map
					List<PropertyProject> tmpPropertyProjectList = intMap.get(comId);
					propertyList.addAll(tmpPropertyProjectList);
					
				}
				
				intMap.put(comId, propertyList);
			}
		}
		
		for(int comId : comIdSet){
			
			Company company = MyPropertyUtils.getCompanyServices().findCompanyById(comId);
			
			List<PropertyProject> endList = intMap.get(comId);
			
			if(CommonUtils.isCollectionEmpty(endList))
				continue;
			
			map.put(company, endList);
		}
		
		return map;
	}
	
	/**
	 * 售前客户角色
	 * @return
	 */
	public static List<CompanyProject> getCompanyProjectListBySQKH(){
		
		final List<Integer> projectIds = PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD);
		
		return getCompanyProjectListByIds(projectIds);
	}

	/**
	 * 人员授权角色
	 * @return
	 */
	public static List<CompanyProject> getCompanyProjectListByRYSQ(){
		
		final List<Integer> projectIds = PermissionUtils.getUserProjectIdList(EnumPrivCode.SYSTEM_USER_CREATE);
		
		return getCompanyProjectListByIds(projectIds);
	}

	/**
	 * 根据角色id获取对应的项目列表
	 * @param roleId
	 * @return
	 */
	public static List<CompanyProject> getCompanyProjectListByRoleId(int roleId){
		
		final List<UserRole> roleList = getUserRoleListByUserIdAndRoleId(SessionUser.getUserId(), roleId);
		
		//重复的projectId通过map来进行过滤，实现不重复
		List<Integer> projectIds = new LinkedList<Integer>();
		Map map = new HashMap();
		for(UserRole role : roleList){
			
			int projectId = role.getProjectId();
			map.put(projectId, projectId);
		}
		
		Collection<Integer> c = map.values();
		Iterator it = c.iterator();
		for (; it.hasNext();) {
			projectIds.add(Integer.parseInt(it.next().toString()));
		}
		
		return getCompanyProjectListByIds(projectIds);
		
	}
	
	/**
	 * 根据项目id list获取对应的项目list
	 * @param projectIds
	 * @return
	 */
	public static List<CompanyProject> getCompanyProjectListByIds(final List<Integer> projectIds){
		
		final List<CompanyProject> retList = new LinkedList<CompanyProject>();
		
		if(CommonUtils.isCollectionEmpty(projectIds))
			return retList;
		
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					for(Integer projectId : projectIds){
						
						CompanyProject project = permissionUtils.companyProjectServices.findCompanyProjectById(projectId);
						
						if(project!=null){
							retList.add(project);
						}		
						
					}
					
				}
			}.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retList;
	}
	
	/**
	 * 左边导航树的选择的Map<projectId, projectName>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getUserRoleMapForLayoutLeft(){
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		Object retMap = MyCacheTemplate.cache(PermissionCacheName.USERROLE_MAP_FOR_LAYOUTLEFT, SessionUser.getUserIdStr(), new MyCacheTemplateCallback() {
			
			@Override
			public Object doCache() throws Exception {
				
				Map<String, String> retMap = null;
				
				List<UserRole> roleList = getUserRoleForLayoutLeft();
				
				if(!CommonUtils.isCollectionEmpty(roleList)){
					
					retMap = new LinkedHashMap<String, String>();
					
					for(UserRole role : roleList){
						
						retMap.put(role.getProjectId()+"", role.getDescProjectId());
					}
				}
				
				return retMap;
			}
		});		
		
		if(retMap != null){
			
			map = (Map<String, String>) retMap;
		}
		
		return map;
	}
	
	/**
	 * 左边导航树的选择
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public static List<UserRole> getUserRoleForLayoutLeft(){
		
		List<UserRole> retList = null;
		
		Object retObject = MyCacheTemplate.cache(PermissionCacheName.USERROLE_FOR_LAYOUTLEFT, SessionUser.getUserIdStr(), new MyCacheTemplateCallback() {
			
			@Override
			public Object doCache() throws Exception {
				
				return _getUserRoleForLayoutLeft();
			}
		});
		
		if(retObject != null){
			retList = (List<UserRole>) retObject;
		}

		return retList;
	}
	
	/**
	 * 左边导航树的选择(真正的查询方法)
	 * @return
	 */
	private static List<UserRole> _getUserRoleForLayoutLeft(){
		
		List<UserRole> urList = PermissionUtils.getUserRoleListByUserIdAndRoleId(SessionUser.getUserId(), RoleSetUpUtils.getXkzxRoleId());
		//选择一个默认的楼栋
		
		if(urList == null){//没有销控权限的
			urList = new ArrayList<UserRole>();
		}
		if(urList.size() == 0){//没有销控权限的
			UserRole r = new UserRole();
			r.setProjectId(SessionUser.getProjectId());
			urList.add(r);
		}
		
		if(urList.size() == 0)return null;//没有权限的
		
		CompanyProjectCond cond = new CompanyProjectCond();
		List<Integer> proids = new ArrayList<Integer>();
		for(UserRole r : urList){
			proids.add(r.getProjectId());
		}
		
		cond.setProjectIds(proids);
		cond.setOrderByFiled("order");
		
		List<CompanyProject> pros = MyPropertyUtils.getCompanyProjectServices().findCompanyProjectPage(cond);
		
		List<UserRole> orderUserRole = new ArrayList<UserRole>();
		for(CompanyProject c : pros){

			for(UserRole r : urList){
				if(c.getId() == r.getProjectId()){
					orderUserRole.add(r);
				}
			}
		}
		
		urList = orderUserRole;
		
		return urList;
	}
	

	/**
	 * 当前用户的报表权限是否跨公司：首页的多公司管理员判别
	 * @return
	 */
	public static boolean isReportMultiCompany(){		
		return isReportMultiCompany(SessionUser.getUserId());
	}
	
	/**
	 * 当前用户的报表权限是否跨公司：首页的多公司管理员判别
	 * @param userId
	 * @return
	 */
	public static boolean isReportMultiCompany(int userId){
		List<Integer> idList = getReportMultiCompanyList(userId);//getUserCompanyIdListByUid(userId, EnumPrivCode.REPORT_SALEUNIT_STAT);
		if(idList!=null && idList.size()>1){
			return true;
		}
		return false;
	}
	
	/**
	 * 报表中能够跨公司的数目
	 * @param userId
	 * @return
	 */
	public static List<Integer> getReportMultiCompanyList(int userId){
		return getUserCompanyIdListByUid(userId, EnumPrivCode.REPORT_SALEUNIT_STAT);
	}


	/**
	 * 当前用户的报表权限是否跨项目：首页的多项目管理员判别
	 * @return
	 */
	public static boolean isReportMultiProject(){		
		return isReportMultiProject(SessionUser.getUserId());
	}
	
	/**
	 * 当前用户的报表权限是否跨项目：首页的多项目管理员判别
	 * 如果是多公司管理员，本方法也返回false
	 * @param userId
	 * @return
	 */
	public static boolean isReportMultiProject(int userId){
		if(isReportMultiCompany(userId)){
			return false;
		}
		List<Integer> idList = getUserProjectIdListByUid(userId, EnumPrivCode.REPORT_SALEUNIT_STAT);
		if(idList!=null && idList.size()>1){
			return true;
		}
		return false;
	}
	
	/**
	 * 当前用户的报表权限是否单项目：首页的单项目管理员判别
	 * @return
	 */
	public static boolean isReportOneProject(){		
		return isReportOneProject(SessionUser.getUserId());
	}
	
	/**
	 * 当前用户的报表权限是否单项目：首页的单项目管理员判别
	 * @param userId
	 * @return
	 */
	public static boolean isReportOneProject(int userId){
		List<Integer> idList = getUserProjectIdListByUid(userId, EnumPrivCode.REPORT_SALEUNIT_STAT);
		if(idList!=null && idList.size()==1){
			return true;
		}
		return false;
	}

	/**
	 * 当前用户的报表权限是否纯销售人员：首页的纯销售人员判别
	 * @return
	 */
	public static boolean isReportOnlySale(){		
		return isReportOnlySale(SessionUser.getUserId());
	}
	
	/**
	 * 当前用户的报表权限是否纯销售人员：首页的纯销售人员判别
	 * @param userId
	 * @return
	 */
	public static boolean isReportOnlySale(int userId){
		List<Integer> idList = getUserProjectIdListByUid(userId, EnumPrivCode.REPORT_SALEUNIT_STAT);
		if(idList==null || idList.size()<1){
			return true;
		}
		return false;
	}
	
	/**
	 * 根据公司id获取登陆用户能看到的该公司下的公司项目id
	 * @param companyId
	 * @return
	 */
	public static List<CompanyProject> getUserCompanyProjectByCompanyId(int companyId){
		
		List<CompanyProject> retList = new ArrayList<CompanyProject>();
		
		List<CompanyProject> projectList = getCompanyProjectListByXKZX();
		
		if(!CommonUtils.isCollectionEmpty(projectList)){
			
			for(CompanyProject pro : projectList){
				
				if(pro.getCompanyId() == companyId){
					
					retList.add(pro);
				}
			}
			
		}
		
		return retList;
	}
}