package com.ihk.sale.action.guangzhou;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyCond;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.ICompanyServices;
import com.ihk.user.data.services.IRoleServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.user.data.services.IUserRoleServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * user_role表操作 根据所选的项目  所选的USER_ACCOUNT
 * 2011-12-21 
 * */
public class SetUserRoleByUserAction extends SupperAction{
	
	private static final long serialVersionUID = 1L;
	@Autowired ICompanyServices companyServices;
	@Autowired ICompanyProjectServices companyProjectServices;
	@Autowired IUserAccountServices userAccountServices;
	@Autowired IRoleServices roleServices;
	@Autowired IUserRoleServices userRoleServices;
	private String roleId;//user_role .role_id
//	private List<UserAccount> userList;//user_id ,user_realName
	private List<Role> roleListToCan;//可以赋
	private List<Role> roleListToHave;//已有
	private String selectId;
	private String companyId = "4";
	private String id;
	private UserAccount roleUser;
	private List<Company> companyList;
	/***************************************JSP=set_role.jsp*******************************************/
	/**初次转到此页面*/
	public String roleJsp(){
		init();
		request.getSession().removeAttribute("SessionSelectId");
		request.getSession().removeAttribute("SessionroleUser");
		return "setrole";
	}
	/**搜索提交*/
	public String search() throws Exception{
		init();
		inirole();
		initByCompanyId(companyId);
		sessionToSave();
		return "setrole";
	}
	/**赋权*/
	public String addRole()throws Exception{
		sessionToGet();
		
		UserRole tempUserRole =  new UserRole();
		
		tempUserRole.setUserId(Integer.parseInt(this.selectId));
		tempUserRole.setRoleId(Integer.parseInt(this.id));
		
		tempUserRole.setIsDeleted(CommonUtils.NORMAL);
		tempUserRole.setCreatedId(SessionUser.getUserId());
		tempUserRole.setCreatedTime(new Date());
		tempUserRole.setModTime(new Date());
		tempUserRole.setModId(SessionUser.getUserId());
		
		userRoleServices.addUserRole(tempUserRole);
		
		init();
		inirole();
		initByCompanyId(companyId);
		return "setrole";
	}
	/**删除权限*/
	public String delRole()throws Exception{
		sessionToGet();
		
		UserRole tempUserRole =  new UserRole();
		
		tempUserRole.setUserId(Integer.parseInt(this.selectId));
		tempUserRole.setRoleId(Integer.parseInt(this.id));	
		
		tempUserRole.setModTime(new Date());
		tempUserRole.setModId(SessionUser.getUserId());
		
		userRoleServices.deleteUserRoleByUserIdAndRoleId(tempUserRole);
		
		init();
		inirole();
		initByCompanyId(companyId);
		return "setrole";
	}
	/********************************************private mothed***********************************/
	/**保存选择表单的值*/
	private void sessionToSave(){
		HttpSession session = request.getSession();
		this.roleUser = userAccountServices.findUserAccountById(Integer.parseInt(selectId));
		session.setAttribute("SessionCompanyId", this.companyId);
		session.setAttribute("SessionroleUser", roleUser);
		session.setAttribute("SessionSelectId", selectId);
	}
	/**获取表单的值*/
    private void sessionToGet(){
    	HttpSession session = request.getSession();
    	this.companyId = (String)session.getAttribute("SessionCompanyId");
    	this.roleUser = (UserAccount)session.getAttribute("SessionroleUser");
    	this.selectId = (String)session.getAttribute("SessionSelectId");
	}
	/**已经有的和可以赋的权限初始化*/
	private void inirole() throws Exception{
		List<UserRole> userRoleList = userRoleServices.findUserRoleByUserId(Integer.parseInt(this.selectId) );
		List<Role> allrole = roleServices.findRole();
		roleListToHave = new ArrayList<Role>();
		roleListToCan = new ArrayList<Role>();
		boolean tip = true;
		for (int i = 0; i < allrole.size(); i++) {
			tip = true;
			for (int j = 0; j < userRoleList.size(); j++) {
				if(userRoleList.get(j).getRoleId() == allrole.get(i).getId()){
					roleListToHave.add(allrole.get(i));
					tip = false;
					break;
				}
			}
			if(tip){
				roleListToCan.add(allrole.get(i));
			}
		}
//		this.initByCompanyId(this.companyId);
	}
	/**加入了company的判断 根据公司选择权限*/
	private void initByCompanyId(String cid)throws Exception{
		
		List<Role> temp = new ArrayList<Role>();
		int intcid = Integer.parseInt(cid);
		List<CompanyProject> tlist =  companyProjectServices.findCompanyProjectsByCompanyId(intcid);
		boolean tip = false;
		if(roleListToCan != null){
			for (int i = 0; i < roleListToCan.size(); i++) {
			
				tip = false;
				for (int j = 0; j < tlist.size(); j++) {
					if(tlist.get(j).getId() == roleListToCan.get(i).getProjectId()){
//						System.out.println("tlist id = "+tlist.get(j).getId()+"    roleListToHave.get(i).getProjectId()= " + roleListToHave.get(i).getProjectId());
						
						tip = true;
						break;
					}
				}
				if(tip){
					temp.add(roleListToCan.get(i));
				}
			}
		}
		roleListToCan = temp;
		
	}
	private void init(){
		UserAccountCond usercond =  new UserAccountCond();
		CompanyCond co =  new CompanyCond();
	
		co.setParentId(1);
		this.companyList = companyServices.findCompanyPage(co);
//		userList = userAccountServices.findHDuser();
	}
	/************************set get***************************************************************/
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getSelectId() {
		return selectId;
	}
	public void setSelectId(String selectId) {
		this.selectId = selectId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
//	public List<UserAccount> getUserList() {
//		return userList;
//	}
	public List<Role> getRoleListToCan() {
		return roleListToCan;
	}
	public List<Role> getRoleListToHave() {
		return roleListToHave;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserAccount getRoleUser() {
		return roleUser;
	}
	public List<Company> getCompanyList() {
		return companyList;
	}
	
	

	
}
