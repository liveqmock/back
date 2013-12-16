package com.ihk.sale.action;


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
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 录入userAccount
 * @author peter.kuang
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
	private LinkedHashMap<String, String> selCompany;
	private LinkedHashMap<String, String> selProject;
	
	private String role1;
	private String role2;
	
	/*************************************************************************/
	
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

	/**新建用户*/
	public String indexInput(){
		initSelect();
		if(!isHaveAddUser()){
			addActionMessage("没有新建用户的权限");
		}
		return RESULT_INPUT;
	}
	
	/**提交新建用户*/
	public String inputUserAccount(){
		initSelect();
		if(!isHaveAddUser()){
			addActionMessage("没有新建用户的权限");
			return RESULT_INPUT;
		}
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
		//页面所需要的各种SELECT
		projectList =   PermissionUtils.getUserProjectListByUid(EnumPrivCode.LOCK_SALE,EnumDevFlag.HENGDA, SessionUser.getUserId());
		selCompany = HengDaUtils.getSelCompany();
		initSelProject();
	
	}
	
	private boolean vilFrom(){
		//表单数据验证
		if(inputUser.getProjectId() == 0){
			this.addActionMessage("必须选择项目");
			return false;
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
		if(!PermissionUtils.hasPermission(inputUser.getProjectId() ,EnumPrivCode.LOCK_SALE ,EnumDevFlag.HENGDA)){
			addActionMessage(MASSG1);
			return false;
		}
		return true;
	}
	
	private boolean vilProject(){
		//有=true;没=false;验证所属项目 
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
		Role role;
		RoleCond roleCond;
	
		if(role1.equals("y")){//录入权限被选择
			roleCond = new RoleCond();
			roleCond.setProjectId(inputRole.getProjectId());
			roleCond.setRoleName("录入");
			List<Role> roleList =  this.iRoleServices.findRolePage(roleCond);
			//先只拿一条数据
			role =  new Role();
			if(roleList.size() > 0){
				role = roleList.get(0);
			}
			userRole = new UserRole();
			userRole.setCreatedId(SessionUser.getUserId());
			userRole.setCreatedTime(inputRole.getCreatedTime());
			userRole.setIsDeleted("0");
			userRole.setModId(SessionUser.getUserId());
			userRole.setModTime(inputRole.getCreatedTime());
			userRole.setRoleId(role.getId());
			userRole.setUserId(inputRole.getId());
			iUserRoleServices.addUserRole(userRole);
		}
		if(role2.equals("y")){
			roleCond = new RoleCond();
			roleCond.setProjectId(inputRole.getProjectId());
			roleCond.setRoleName("管理");
			List<Role> roleList =  this.iRoleServices.findRolePage(roleCond);
			//先只拿一条数据
			role =  new Role();
			if(roleList.size() > 0){
				role = roleList.get(0);
			}
			userRole = new UserRole();
			userRole.setCreatedId(SessionUser.getUserId());
			userRole.setCreatedTime(inputRole.getCreatedTime());
			userRole.setIsDeleted("0");
			userRole.setModId(SessionUser.getUserId());
			userRole.setModTime(inputRole.getCreatedTime());
			userRole.setRoleId(role.getId());
			userRole.setUserId(inputRole.getId());
			iUserRoleServices.addUserRole(userRole);
		}
	}
	private UserAccount initUpdateUser(UserAccount tpuser){
		//补全信息
		Date thisDate = new Date();
		tpuser.setAccountType("1");
		CompanyProject proTemp = iCompanyProjectServices.findCompanyProjectById( tpuser.getProjectId());
		tpuser.setCompanyId(proTemp.getCompanyId());
		tpuser.setCreatedId(SessionUser.getUserId());
		tpuser.setCreatedTime(thisDate);
		tpuser.setModId(SessionUser.getUserId());
		tpuser.setModTime(thisDate);
		tpuser.setIsDeleted(IS_DELETED_NO);
		return tpuser;
	}
	private void initSelProject(){
		selProject = new LinkedHashMap<String, String>();
		
		selProject.put("", "选择项目");
		
		/*if(!isGet){
			selProject = HengDaUtils.getProjectsByCompanyId(Integer.parseInt(saleCond.getCompanyId()));
		}*/
		
	}


	public LinkedHashMap<String, String> getSelProject() {
		return selProject;
	}

	public void setSelProject(LinkedHashMap<String, String> selProject) {
		this.selProject = selProject;
	}

	public UserAccount getInputUser() {
		return inputUser;
	}

	public void setInputUser(UserAccount inputUser) {
		this.inputUser = inputUser;
	}

	public LinkedHashMap<String, String> getSelCompany() {
		return selCompany;
	}

	public void setSelCompany(LinkedHashMap<String, String> selCompany) {
		this.selCompany = selCompany;
	}
	
	
}
