package com.ihk.sale.action.guangzhou;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.RoleCond;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.pojo.UserRoleCond;
import com.ihk.user.data.services.IRoleServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.user.data.services.IUserRoleServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.GuangZhouUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.exception.PrivException;
import com.opensymphony.xwork2.ActionContext;


/**
 * 查找用户
 */
public class SearchUserAccount extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired IUserAccountServices iUserAccountServices;
	@Autowired IUserRoleServices iUserRoleServices;
	@Autowired IRoleServices iRoleServices;
	
	private List<UserAccount> userlist;
	private UserAccountCond searchCond;//搜索表单条件
	private List<UserAccount> alluserlist; 
	
	private String projectName;
	private List<Role> roleList;
	private String ids;
	private String proId;
	private String roleId;
	private String copyUserId;

	
	/**初始化查询用户界面*/
	public String searchUserIndex(){
		/**=权限*/
		List<Integer> prlist = PermissionUtils.getUserProjectIdList(EnumPrivCode.SYSTEM_USER_CREATE);
		if(prlist == null || prlist.size() == 0){
			addActionMessage("没有管理用户权限");
			return "index";
		}
		if(SessionUser.getUserId() == 2){//admin 看所有 
			prlist.add(new Integer(0));
		}
		searchCond = new UserAccountCond();
		searchCond.setProjectIds(prlist);
		this.initSearch();
		return "search";
	}
	/**点击搜索表单*/
	public String searchUserForm(){
//		if( !isHaveSearchRole()){
//			addActionMessage("没有查看权限");
//			return "search";
//		}
		/**=权限*/
		List<Integer> prlist = PermissionUtils.getUserProjectIdList(EnumPrivCode.SYSTEM_USER_CREATE);
		if(prlist == null || prlist.size() == 0){
			addActionMessage("没有管理用户权限");
			return "index";
		}
		if(SessionUser.getUserId() == 2){//admin 看所有 
			prlist.add(new Integer(0));
		}
		if(searchCond == null){
			searchCond = new UserAccountCond();
		}	
		searchCond.setProjectIds(prlist);
		initSearch();
//		searchCondSave.setUserName(searchCond.getUserName());
		return "search";
	}
	
	
	/**删除用户权限*/
	public String delUserRole(){
		String tempids[]=ids.split("_");
		UserRole delUserRole = new UserRole();
		for (String id:tempids){
			delUserRole.setUserId(Integer.parseInt(id));
			delUserRole.setRoleId(Integer.parseInt(this.roleId));
			delUserRole.setProjectId(Integer.parseInt(this.proId));
			this.iUserRoleServices.deleteUserRoleByUserIdAndRoleIdAndProjectId(delUserRole);
		}
		if(searchCond==null){
			searchCond = new UserAccountCond();
		}
		
		this.initSearch();
		return "search";
	}
	
	/**删除用户*/
	public  String delUserAccount(){
		String tempids[]=ids.split("_");
		for (String id:tempids){
			this.iUserAccountServices.deleteUserAccount(Integer.parseInt(id));
		}
		if(searchCond==null){
			searchCond = new UserAccountCond();
		}
		
		this.initSearch();
		return "search";
	}
	
	/**赋予用户权限*/
	public  String addUserRole(){
		String tempids[]=ids.split("_");
		UserRole addUserRole = new UserRole();
		for (String id:tempids){
			addUserRole.setUserId(Integer.parseInt(id));
			addUserRole.setRoleId(Integer.parseInt(this.roleId));
			addUserRole.setProjectId(Integer.parseInt(this.proId));
			addUserRole.setCompanyId(
					DescUtils.getCompanyIdByProjectId(Integer.parseInt(this.proId)));
			addUserRole.setIsDeleted("0");
			addUserRole.setCreatedId(SessionUser.getUserId());
			addUserRole.setModId(SessionUser.getUserId());
			addUserRole.setCreatedTime(new Date());
			addUserRole.setModTime(addUserRole.getCreatedTime());
		
			this.iUserRoleServices.addUserRole(addUserRole);//如果有就不存
		}
		if(searchCond==null){
			searchCond = new UserAccountCond();
		}
		
		this.initSearch();
		return "search";
	}
	
	/**复制用户权限*/
	public  String copyUserRole(){
		String tempids[]=ids.split("_");
		UserRole delUserRole = new UserRole();
		//根据复制原 拿到USER ROLE LIST
		UserRoleCond cond = new UserRoleCond();
		//cond.setUserId(this.copyUserId);
		List<UserRole> temUserRoleList = iUserRoleServices.findUserRolePage(cond);
		if(temUserRoleList == null){
			return "search";
		}
		for (String id:tempids){
			//1 删除用户所有权限 
			//2 直接复制所有权限 iUserRoleServices.copyRole(role Id ,Role Id)
			for (UserRole r:temUserRoleList) {
				r.setUserId(Integer.parseInt(id));
				r.setIsDeleted("0");
				r.setCreatedId(SessionUser.getUserId());
				r.setModId(SessionUser.getUserId());
				r.setCreatedTime(new Date());
				r.setModTime(r.getCreatedTime());
				this.iUserRoleServices.addUserRole(r);
			}
			
		}
		if(searchCond==null){
			searchCond = new UserAccountCond();
		}
		
		this.initSearch();
		return "search";
	
	}
	
	private void initSearch(){
		if(1==1){
			//peter:20130529,统一用户管理列表为struts-user-manager.xml,其他原有的用户管理关闭；需要开放的话，需要重新测试是否串了位置（广州项目与恒大项目）
			throw new PrivException("页面调整，无法访问，请与开发人员联系");
		}
		//根据使用用户  可以查看权限的 项目列表  /**=权限*/
//		searchCond.setProjectIds(PermissionUtils.getUserProjectIdList());//可以查看的项目列表 现在写死 等权限好了加入
		
//		
//		List<Integer> proint = new ArrayList<Integer>();
//		proint.add(new Integer(5)); proint.add(new Integer(6)); proint.add(new Integer(7));
//		searchCond.setProjectIds(proint);
	//	alluserlist = iUserAccountServices.findUserAccountPage(searchCond);
		String action = CustomerUtils.getActionNameFromRequest(request);
		Pager page = new Pager(ActionContext.getContext(),15,action);	
		searchCond.recordCount = iUserAccountServices.findUserAccountCount(searchCond);
		page.setCond(searchCond);
		this.userlist = iUserAccountServices.findUserAccountPage(searchCond); 	
//		for (int i = 0; i < userlist.size(); i++) {
//			userlist.get(i).initSelectUserRoleList();
//		}
		
	//得到所有广州所有权限的list
//		RoleCond roleCond = new RoleCond();
//		roleCond.setDevFlag("guangzhou");
//		this.roleList = this.iRoleServices.findRolePage(roleCond);
//		Role firstRole = new Role();
//		firstRole.setRoleName("全部");
//		roleList.add(0, firstRole);
		this.roleList = GuangZhouUtils.getGuangZhouRole();
		
		this.setShowPage(page.toHtmlString());

	}
	private boolean isHaveSearchRole(){
		List<CompanyProject> projectList = PermissionUtils.getUserProjectListByUid(EnumPrivCode.LOCK_SALE,EnumDevFlag.HENGDA, SessionUser.getUserId());
		if(projectList == null){
			
			return  false;
		}
		return true;
	}
/////////////////////////////////////////////////setget
	public List<UserAccount> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<UserAccount> userlist) {
		this.userlist = userlist;
	}
	public UserAccountCond getSearchCond() {
		return searchCond;
	}
	public void setSearchCond(UserAccountCond searchCond) {
		this.searchCond = searchCond;
	}

	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public void setCopyUserId(String copyUserId) {
		this.copyUserId = copyUserId;
	}
	public List<UserAccount> getAlluserlist() {
		return alluserlist;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
}
