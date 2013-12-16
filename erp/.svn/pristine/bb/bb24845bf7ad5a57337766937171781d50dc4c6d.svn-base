package com.ihk.sale.action.guangzhou;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;


import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.pojo.UserRoleCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.user.data.services.IUserRoleServices;
import com.ihk.utils.GuangZhouUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 修改用户
 */
public class UpdateUserAccount extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired IUserAccountServices iUserAccountServices;
	@Autowired ICompanyProjectServices iCompanyProjectServices;
	@Autowired IUserRoleServices iUserRoleServices; 
	
	private String id; //user id
	private  UserAccount selectUser; //id = user id
	private List<UserRole> selectUserRoleList;//user_id = id
	private String ids;  //user role id   for del
	private List<Role> roleList;
	private String proId;//for del one user role
	private String rolId;//for del one user role
	private List<CompanyProject> proList;
	private String pwd;//for update pwd
		
	private  UserAccount updateUser;//for updateUser 
	private UserRoleCond userRoleCond;//for search userrole

	/**index*/
	public String indexUpdate(){
		request.getSession().removeAttribute("userRoleCond");
		userRoleCond = new UserRoleCond();
		this.initSelectUserInfo(id);
		return "update";
	}
	
	/**search userrole by projectid and roleid*/
	public String searchUserRole(){
		
		this.initSelectUserInfo(id);
		HttpSession session = request.getSession();
		session.setAttribute("userRoleCond", userRoleCond);
		return "update";
	}
	
	/**del userrole    by user role id */
	public String delUserRoles(){
		String tempids[]=ids.split("_");
		for (String userroleid:tempids){
			iUserRoleServices.deleteUserRole( Integer.parseInt(userroleid));
		}
		initSearchcond();
		this.initSelectUserInfo(id);
		
		return "update";
	}
	
	/**
	 * del user role by user_id ,project_id,role_id
	 * */
	public String delUserRole(){
		UserRole t = new UserRole();
		t.setUserId(Integer.parseInt(this.id));
		t.setProjectId(Integer.parseInt(this.proId));
		t.setRoleId(Integer.parseInt(this.rolId));
		iUserRoleServices.deleteUserRoleByUserIdAndRoleIdAndProjectId(t);
		return "update";
	}
	
	/**
	 * add user role by user_id ,project_id,role_id
	 * */
	public String addUserRole(){
		if(id == null || id.trim().equals("") || 
				rolId == null || rolId.trim().equals("")){
			this.initSelectUserInfo(id);
			addActionMessage("请添加正确的权限");
			return "update";
		}
		if( (proId == null || proId.trim().equals("")) && !rolId.equals("11")){
			addActionMessage("请添加正确的权限");
			this.initSelectUserInfo(id);
			return "update";
		}
		UserRole t = new UserRole();
		t.setUserId(Integer.parseInt(this.id));
		t.setCreatedId(SessionUser.getUserId());
		t.setCreatedTime(new Date());
		t.setModId(t.getCreatedId());
		t.setModTime(t.getCreatedTime());
		t.setIsDeleted("0");
		String temppro[];
		if(proId == null || proId.trim().equals("")){
			proId = "0";
		}
		temppro=this.proId.split(",");
		String temp[]=this.rolId.split(",");
		for (String userroleid:temp){
			t.setRoleId(Integer.parseInt(userroleid.trim()));
			for(String protemp : temppro){
				if(t.getRoleId() == 11){
					t.setProjectId(0);//销售权限没有project_id
				}else{
					t.setProjectId(Integer.parseInt(protemp.trim()));
				}
				t.setCompanyId(17);//所有广州权限加上公司ID
				this.iUserRoleServices.addUserRole(t);
			}
			
		}
		addActionMessage("权限添加成功!");
		this.initSelectUserInfo(id);
		return "update";
	}
	
	/**update pwd by       user id, pwd*/
	public String updateUserPwd(){
		if(pwd == null || pwd.trim().equals("") ){
			this.initSelectUserInfo(id);
			addActionMessage("空密码不能保存");
			return "update";
		}
		if(this.cnotFormat(this.id)){
			this.initSelectUserInfo(id);
			addActionError("错误的用户");
			return "update";
		}
		this.selectUser = this.iUserAccountServices.findUserAccountById(Integer.parseInt(this.id));
		selectUser.setUserPwd(this.pwd);
		selectUser.setModId(SessionUser.getUserId());
		selectUser.setModTime(new Date());
	
		iUserAccountServices.updateUserAccount(selectUser);
		initSearchcond();
		this.initSelectUserInfo(id);
		
			addActionMessage("修改密码成功");
		
		
		return "update";
	}
	
	/**update user set user-realname user-mobiphone  by updateUser(mobiphone,realname,jobNumber) */
	public String updateUser(){
		if(this.cnotFormat(this.id)){
			addActionError("错误的用户");
			return "update";
		}
		if(updateUser == null){
			initSearchcond();
			this.initSelectUserInfo(id);
			return "update";
		}
		if((updateUser.getMobilePhone() == null || updateUser.getMobilePhone().trim().equals("")) &&
				(updateUser.getRealName() == null || updateUser.getRealName().trim().equals("")) &&
					(updateUser.getJobNumber() == null ||updateUser.getJobNumber().trim().equals("")) &&
					(updateUser.getProjectId() == 0)
					){
			addActionMessage("不能跟新空信息");
			initSearchcond();
			this.initSelectUserInfo(id);
			return "update";
		}
		this.selectUser = this.iUserAccountServices.findUserAccountById(Integer.parseInt(this.id));
	
		selectUser.setModId(SessionUser.getUserId());
		selectUser.setModTime(new Date());
		selectUser.setUserPwd("");
		if(updateUser.getMobilePhone() != null && !updateUser.getMobilePhone().trim().equals("")){
			addActionMessage("电话修改成功");
			selectUser.setMobilePhone(this.updateUser.getMobilePhone());
		}
		if(updateUser.getRealName() != null && !updateUser.getRealName().trim().equals("")){
			addActionMessage("姓名修改成功");
			selectUser.setRealName(this.updateUser.getRealName());
		}
		if(updateUser.getJobNumber() != null && !updateUser.getJobNumber().trim().equals("")){
			addActionMessage("工号修改成功");
			selectUser.setJobNumber(this.updateUser.getJobNumber());
		}
		if(updateUser.getProjectId() != 0 ){
			addActionMessage("所属项目修改成功");
			selectUser.setProjectId(this.updateUser.getProjectId());
			int comp = iCompanyProjectServices.findCompanyProjectById(this.updateUser.getProjectId()).getCompanyId();
			selectUser.setCompanyId(comp);
		}
		iUserAccountServices.updateUserAccount(selectUser);
		initSearchcond();
		this.initSelectUserInfo(id);
		return "update";
	}
	
	/**add all user role by id and loguser's proList and roleList*/
	public String addAllUserRole(){
		return "update";
	}
	
	/**修改默认密码*/
	public String fristindex(){
		return null;
	}
	
	/**提交修改密码表单*/
	public String fristindexForm(){
		return null;
	}
	
	private void initSearchcond(){
		Object o = request.getSession().getAttribute("userRoleCond");
		if(o != null){
			this.userRoleCond = (UserRoleCond) o;
		}
	}
	
	private String pwdTip;
	private void  initSelectUserInfo(String userId) {
		if(cnotFormat(id)){
			return ;
		}
		if(userRoleCond == null){
			userRoleCond = new UserRoleCond();
		}
		try {
			this.selectUser = iUserAccountServices.findUserAccountById(Integer.parseInt(id));
			userRoleCond.setUserId(this.id);
			this.selectUserRoleList = iUserRoleServices.findUserRolePage(this.userRoleCond);
			if(selectUser.getUserPwd().equals("dc483e80a7a0bd9ef71d8cf973673924") || selectUser.getUserPwd().equals("e10adc3949ba59abbe56e057f20f883e")){
				pwdTip = "密码是原始密码";
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		roleList = GuangZhouUtils.getGuangZhouRole();
		this.proList = GuangZhouUtils.getGuangZhouCompanyProject();
	}
	
	private boolean cnotFormat(String id){
		 
		  if(id == null || id.trim().equals("")){
			  return true;
		  }
		   try{
			   @SuppressWarnings("unused")
			int temp = 0; 
		       temp = Integer.parseInt(id);
		     }catch(Exception e){
		       return true;
		    }
		  return false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserAccount getSelectUser() {
		return selectUser;
	}

	public void setSelectUser(UserAccount selectUser) {
		this.selectUser = selectUser;
	}

	public List<UserRole> getSelectUserRoleList() {
		return selectUserRoleList;
	}

	public void setSelectUserRoleList(List<UserRole> selectUserRoleList) {
		this.selectUserRoleList = selectUserRoleList;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRolId() {
		return rolId;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public UserAccount getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(UserAccount updateUser) {
		this.updateUser = updateUser;
	}

	public void setRolId(String rolId) {
		this.rolId = rolId;
	}

	public UserRoleCond getUserRoleCond() {
		return userRoleCond;
	}

	public void setUserRoleCond(UserRoleCond userRoleCond) {
		this.userRoleCond = userRoleCond;
	}

	public List<CompanyProject> getProList() {
		return proList;
	}

	public void setProList(List<CompanyProject> proList) {
		this.proList = proList;
	}

	public String getPwdTip() {
		return pwdTip;
	}

	public void setPwdTip(String pwdTip) {
		this.pwdTip = pwdTip;
	}
	
}
