package com.ihk.sale.action;

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
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 修改用户信息
 */
public class UpdateUserAccount extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired IUserAccountServices iUserAccountServices;
	@Autowired ICompanyProjectServices iCompanyProjectServices;
	
	private int PWDLENTH = 6;
	private String MASSG1 = "请设置至少 6 位的密码";
	private String MASSG2 = "没有相应的权限";
	private String UPDATE = "update";
	
	private List<CompanyProject> prolist;
	private String proid;
	private UserAccount updateUser;
	private String updatetype;
	/**search user jsp ACTION> id = ${id}*/
	private String id;
	private UserAccount selectUser;
	
	private String role1;//单个项目角色 录入  y/n
	private String role2;//管理 
	/*************************updateUser***************************************************/
	
	/**修改页面跳转*/
	public String indexUpdate(){
		initlist();
		try {
			this.selectUser = iUserAccountServices.findUserAccountById(Integer.parseInt(id));
			if(!PermissionUtils.hasPermission(selectUser.getProjectId() ,EnumPrivCode.LOCK_SALE ,EnumDevFlag.HENGDA)){
				addActionMessage(MASSG2+"(修改该项目)");
				selectUser = new UserAccount();
				return UPDATE;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return UPDATE;
		}
		return UPDATE;
	}
	
	/**修改用户数据*/
	private String TYPE_PWD="updatepwd";//只修改密码
	public String updateUser(){
		initlist();
		this.selectUser = iUserAccountServices.findUserAccountById(Integer.parseInt(id));
		if(!vilRoleByUpdateUser(selectUser) || !vilRoleByUpdateUser(updateUser)){
			return UPDATE;
		}
		if(updatetype.equals(TYPE_PWD)){
			if(updateUser.getUserPwd() == null || updateUser.getUserPwd().trim().length() < PWDLENTH){
				this.addActionMessage(MASSG1);
				return UPDATE;
			}
			selectUser.setUserPwd(updateUser.getUserPwd());
			selectUser.setModId(SessionUser.getUserId());
			selectUser.setModTime(new Date());
			iUserAccountServices.updateUserAccount(selectUser);
			addActionMessage("修改密码成功");
			return UPDATE;
		}
		if(updateUser.getRealName() == null || updateUser.getRealName().trim().equals("")){
			this.addActionMessage("姓名不能为空");
			return UPDATE;
		}
		if(!updateUser.getUserPwd().equals("")){
			if(updateUser.getUserPwd() == null || updateUser.getUserPwd().trim().length() < PWDLENTH){
				this.addActionMessage(MASSG1);
				return UPDATE;
			}
			selectUser.setUserPwd(updateUser.getUserPwd());
		}
		if(updateUser.getUserPwd().trim().equals("")){
			selectUser.setUserPwd("");
		}else{
			selectUser.setUserPwd(updateUser.getUserPwd());
		}
		if(selectUser.getProjectId() != updateUser.getProjectId() && updateUser.getProjectId() != -1){//如果修改了项目 一起修改公司
			CompanyProject pro = iCompanyProjectServices.findCompanyProjectById(updateUser.getProjectId());
			updateUser.setCompanyId(pro.getCompanyId());
			selectUser.setCompanyId(updateUser.getCompanyId());
			selectUser.setProjectId(updateUser.getProjectId());
		}
		selectUser.setModId(SessionUser.getUserId());
		selectUser.setModTime(new Date());
		selectUser.setRealName(updateUser.getRealName());
		iUserAccountServices.updateUserAccount(selectUser);

		addActionMessage("修改成功");
		return UPDATE;
	}
	
	private boolean vilRoleByUpdateUser(UserAccount u1){
		//if 登陆的用户 有 修改用户的权限 add_user 根据项目ID  
		if(updateUser.getProjectId() == -1){
			return true;
		}
		if(!PermissionUtils.hasPermission(u1.getProjectId() ,EnumPrivCode.LOCK_SALE ,EnumDevFlag.HENGDA)){
			addActionMessage(MASSG2+"(修改该项目)");
			return false;
		}
		return true;
	}
	

	private void initlist(){
		prolist = PermissionUtils.getUserProjectList();
		CompanyProject p = new CompanyProject();
		p.setProjectName("选择项目");
		p.setId(-1);
		prolist.add(0, p);
	}
//	private boolean vilProjectByUpdateUser(){
//		boolean vil = true;
//		//if 要修改的人的project属于登陆的人所管辖projectId = true		
//		List<Integer> prolist = PermissionUtils.getUserProjectIdList();
//		int test1 = prolist.indexOf(new Integer(selectUser.getProjectId()));
//		if(test1 == -1){
//			addActionMessage(MASSG2);
//			vil = false;
//		}
//		return vil;
//	}
////////////////////////////////setget
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

	public List<CompanyProject> getProlist() {
		return prolist;
	}

	public void setProlist(List<CompanyProject> prolist) {
		this.prolist = prolist;
	}

	public String getProid() {
		return proid;
	}

	public void setProid(String proid) {
		this.proid = proid;
	}

	public String getUpdatetype() {
		return updatetype;
	}

	public void setUpdatetype(String updatetype) {
		this.updatetype = updatetype;
	}


	public UserAccount getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(UserAccount updateUser) {
		this.updateUser = updateUser;
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
	
}
