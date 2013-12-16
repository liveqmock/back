package com.ihk.sale.action.guangzhou;


import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.RoleCond;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.IRoleServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.user.data.services.IUserRoleServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.GuangZhouUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;


/**
 * 录入用户
 *
 */
public class InputUserAccount extends SupperAction{
	private static final long serialVersionUID = 1L;
	
	@Autowired IUserAccountServices iUserAccountServices;
	@Autowired ICompanyProjectServices iCompanyProjectServices;
	@Autowired IRoleServices iRoleServices;
	@Autowired IUserRoleServices iUserRoleServices;
	
	private String RESULT_INPUT = "input";
	private String MASSG1 = "没有权限";
	private String MASSG2 = "请设置至少 6 位的密码";
	private String MASSG3 = "表单项不能为空";
	private String MASSG4 = "已经有这个账户了,请重新设定账户";
	private String IS_DELETED_NO = "0";
	
	private UserAccount inputUser ;
	private UserAccount saveUser ;//保存不成功回传值
	private List<CompanyProject> projectList;
//	private LinkedHashMap<String, String> selCompany;
//	private LinkedHashMap<String, String> selProject;
//	private List<CompanyProject> proList;
	private List<Role> roleList;
	
	private String role1;
	private String role2;
	
	/*************************************************************************/
	


	/**新建用户*/
	public String indexInput(){
		initSelect();
//		if(!isHaveAddUser()){
//			addActionMessage("没有新建用户的权限");
//		}
		return RESULT_INPUT;
	}
	
	/**提交新建用户*/
	public String inputUserAccount(){
		initSelect();
//		if(!isHaveAddUser()){
//			addActionMessage("没有新建用户的权限");
//			return RESULT_INPUT;
//		}
		if(inputUser == null){
			inputUser = new UserAccount();
		}
		if(!vilFrom()){
			return RESULT_INPUT;
		}
		if(!vilRole()){
			return RESULT_INPUT;
		}
		boolean haveName =  iUserAccountServices.valUserByName(inputUser);
		if(haveName){
			this.addActionMessage(MASSG4);
			return RESULT_INPUT;
		}
		inputUser = this.initUpdateUser(inputUser);
		iUserAccountServices.saveUserAccount(inputUser);
		try {
			inputUser = iUserAccountServices.findUserAccountByUserName(inputUser.getUserName());
			addRole(inputUser);
		} catch (Exception e) {
			
			e.printStackTrace();
			this.addActionMessage("账户:"+inputUser.getUserName()+"姓名:"+inputUser.getRealName()+"已录入成功"+"权限需要重新设置");
			inputUser = null;
			return RESULT_INPUT;
		}
		
		this.addActionMessage("账户:"+inputUser.getUserName()+"姓名:"+inputUser.getRealName()+"已录入成功");
		inputUser = null;
		return RESULT_INPUT;
	}
	
	
	private void  initSelect(){
		initSelProject();
	}
	
	private boolean vilFrom(){
		//表单数据验证
		if(this.role1 != null && !this.role1.trim().equals("")){
			if(inputUser.getProjectId() == 0){
				this.addActionMessage("必须选择项目");
				return false;
			}
		}
		if(inputUser.getUserName() == null){
			this.addActionMessage(MASSG3);
			return false;
		}
		if(inputUser.getUserName().trim().equals("")){
			this.addActionMessage(MASSG3);
			return false;
		}
		if(inputUser.getUserPwd() == null || inputUser.getUserPwd().length() < 6){
			this.addActionMessage(MASSG2);
			return false;
		}
		if(inputUser.getRealName() == null || inputUser.getRealName().trim().equals("")){
			this.addActionMessage("姓名不能为空");
			return false;
		}
		
		return true;
	}
	
	private boolean vilRole(){
		//有=true;没=false;验证权限  project >> add_user
//		if(!PermissionUtils.hasPermission(inputUser.getProjectId() ,PrivCode.LOCK_SALE ,DevFlag.HENGDA)){
//			addActionMessage(MASSG1);
//			return false;
//		}
		return true;
	}
	
	private boolean vilProject(){
		boolean vil = true;
		List<Integer> prolist = PermissionUtils.getUserProjectIdList();
		int test1 = prolist.indexOf(new Integer(inputUser.getProjectId()));
		if(test1 == -1){
			addActionMessage(MASSG2);
			vil = false;
		}
		return vil;
	}
	private boolean isHaveAddUser(){
		
		if(projectList == null){
			projectList = new ArrayList<CompanyProject>();
			return  false;
		}
		return  true;
	}
	
	private void addRole(UserAccount inputRole){
		//新建用户添加权限
		//1 根据项目ID 和 管理 录入 找到角色
		//2 根据role1 2 判断 加进去
		UserRole userRole ;
	
		
		userRole = new UserRole();
		userRole.setCreatedId(SessionUser.getUserId());
		userRole.setCreatedTime(inputRole.getCreatedTime());
		userRole.setIsDeleted("0");
		userRole.setModId(SessionUser.getUserId());
		userRole.setModTime(inputRole.getCreatedTime());
		
		userRole.setUserId(inputRole.getId());
		userRole.setProjectId(inputRole.getProjectId());
		userRole.setCompanyId(17);
		if(this.role1 == null || this.role1.trim().equals("") || inputRole.getProjectId() == 0){
			userRole.setRoleId(11);  //~~~~~~~~~~直接保存权限11 为销售人员
			userRole.setProjectId(0); //~~~~~~~~~~直接保存项目为广州1
			this.iUserRoleServices.addUserRole(userRole);
			return ;
		}
		
		String temp[]=this.role1.split(",");
		for (String userroleid:temp){
			userRole.setRoleId(Integer.parseInt(userroleid.trim()));
		
			this.iUserRoleServices.addUserRole(userRole);
		}
	
		
		
	}
	private UserAccount initUpdateUser(UserAccount tpuser){
		//补全信息
		Date thisDate = new Date();
		tpuser.setAccountType("1");
		//tpuser.setCompanyId(17);
		CompanyProject pro = iCompanyProjectServices.findCompanyProjectById(tpuser.getProjectId());
		tpuser.setCompanyId(pro.getCompanyId());
		tpuser.setCreatedId(SessionUser.getUserId());
		tpuser.setCreatedTime(thisDate);
		tpuser.setModId(SessionUser.getUserId());
		tpuser.setModTime(thisDate);
		tpuser.setIsDeleted(IS_DELETED_NO);
		return tpuser;
	}
	private void initSelProject(){
		this.projectList = GuangZhouUtils.getGuangZhouCompanyProject();//加权限后改为符合权限的prolist
		this.roleList = GuangZhouUtils.getGuangZhouRole();
	}


	

	public UserAccount getInputUser() {
		return inputUser;
	}

	public void setInputUser(UserAccount inputUser) {
		this.inputUser = inputUser;
	}

	public List<CompanyProject> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<CompanyProject> projectList) {
		this.projectList = projectList;
	}

	public String getRole1() {
		return role1;
	}

	public void setRole1(String role1) {
		this.role1 = role1;
	}

	public String getRole2() {
		return role2;
	}

	public void setRole2(String role2) {
		this.role2 = role2;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	
	
	
}
