package com.ihk.sale.action.guangzhou;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.RoleCond;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.pojo.UserRoleCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.IRoleServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.user.data.services.IUserRoleServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 *根据选择的项目权限进行  人员的权限设定 页面的下拉框用Ajax
 *
 * JSP= set_userRole_byProject.jsp
 */
public class SetUserRoleByProjectAction extends SupperAction{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired IUserAccountServices iUserAccountServices;
	@Autowired IRoleServices        iRoleServices;
	@Autowired IUserRoleServices    iUserRoleServices;
	@Autowired ICompanyProjectServices iCompanyProjectServices;
	
	private Role              selectRole;                 //选择的权限
	private List<UserAccount> rightUserList;              //right用户列表 没有该权限 但是属于恒大项目的用户列表           
	private List<UserRole>    leftUserList;               //left用户列表 拥有选择好权限的用户列表 属于恒大
	private UserAccountCond   rightUserCond;              //查询右边 userlist
	private UserAccountCond   leftUserCond;               //查询左边 userlist
	private String            id;
	private List<CompanyProject> projectList;
	private String            roleType;
	private String            selectRoleId;
	

	private String RETURN_STRING = "setrole";
	private String IS_NOT_DELETID = "0";
	private String IS_DELETED = "1";
	
	/**index set_userRole_byProject*/
	public String index(){
		leftUserCond = new UserAccountCond();
		
		rightUserCond = new UserAccountCond();
	
		CompanyProjectCond cond = new CompanyProjectCond();
		cond.setIsSale("1");
		this.projectList =  iCompanyProjectServices.findCompanyProjectPage(cond);
		return RETURN_STRING;
	}
	
	/**根据选择的角色查询拥有的人员*/
	public String searchRole(){
		sessionSaveCond();
		initSelectRole();
		initJsp();
		return RETURN_STRING;
	}
	
	/**根据名字 和选择的公司 查询没有这个权限的人员*/
	public String searchUserByNotHaveThisRole(){
		initJsp();
		return RETURN_STRING;
	}
	
	/**删除人员的该权限*/
	public String delUser(){
		sessionGetCond();
		this.selectRole = this.iRoleServices.findRoleById(Integer.parseInt(this.selectRoleId));
		UserRole userRole = new UserRole();
		userRole.setUserId(Integer.parseInt(this.id));
		userRole.setRoleId(Integer.parseInt(this.selectRoleId));
		this.iUserRoleServices.deleteUserRoleByUserIdAndRoleId(userRole);
		initJsp();
		return RETURN_STRING;
	}
	
	/**赋予人员该权限*/
	public String addUser(){
		sessionGetCond();;
		this.selectRole = this.iRoleServices.findRoleById(Integer.parseInt(this.selectRoleId));
		UserRole userRole = new UserRole();
		Date now = new Date();
		
		userRole.setUserId(Integer.parseInt(this.id));
		userRole.setRoleId(Integer.parseInt(this.selectRoleId));
		
		userRole.setIsDeleted(this.IS_NOT_DELETID);
		userRole.setCreatedId(SessionUser.getUserId());
		userRole.setCreatedTime(now);
		userRole.setModId(SessionUser.getUserId());
		userRole.setModTime(now);
		
		this.iUserRoleServices.addUserRole(userRole);
		initJsp();
		return RETURN_STRING;
	}
	
	//init 页面需要的
	private void initJsp(){
		CompanyProjectCond cond = new CompanyProjectCond();
		cond.setIsSale("1");
		this.projectList =  iCompanyProjectServices.findCompanyProjectPage(cond);
		
		
		
	
		this.leftUserList = this.findLeftUserList();
		this.rightUserList = this.findRightUserList();
		
	}
	//
	private void initSelectRole(){
		String rolelike ="";
		if(this.roleType.equals("2")){
			rolelike = "管理";
		}else{
			rolelike = "录入";
		}
		RoleCond rcond = new RoleCond();
		rcond.setProjectId(Integer.parseInt(this.leftUserCond.getProjectId()));
		rcond.setRoleName(rolelike);
		this.selectRole = this.iRoleServices.findRolePage(rcond).get(0);
		this.selectRoleId=selectRole.getId()+"";
		
	}
	
	//保存查询条件
	private void sessionSaveCond(){
		HttpSession session = request.getSession();
		session.setAttribute("leftUserCond", this.leftUserCond);
		session.setAttribute("rightUserCond", this.rightUserCond);
		session.setAttribute("roleType", this.roleType);
	}
	//取出查询条件
	private void sessionGetCond(){
		HttpSession session = request.getSession();
		this.leftUserCond = (UserAccountCond) session.getAttribute("leftUserCond");
		this.rightUserCond = (UserAccountCond) session.getAttribute("rightUserCond");
		this.roleType = (String) session.getAttribute("roleType");
	}
	
	//根据查询人员的列表显示出没有这个权限的人员
	private List<UserAccount> findRightUserList(){
		if(rightUserCond == null)rightUserCond = new UserAccountCond();
		List<UserAccount> temp =iUserAccountServices.findGuangZhouUser(this.rightUserCond);
		List<UserAccount> reTemp = new ArrayList<UserAccount>();
		boolean tip =false;
		for (int i = 0; i < temp.size(); i++) {
			tip = true;
			for (int j = 0; j < this.leftUserList.size(); j++) {
				if(leftUserList.get(j).getUserId() == temp.get(i).getId()){
					tip = false;
				}
			}
			if(tip)reTemp.add(temp.get(i));
		}
		
		return reTemp;
	}
	
	//根据选择的权限查询出拥有这个权限的人员
	private List<UserRole> findLeftUserList(){
		if(selectRoleId == null){
			return null;
		}
		if(selectRoleId.equals("")){
			return null;
		}
		List<UserRole> userRL;
		UserRoleCond userRLCond = new UserRoleCond();
		userRLCond.setRoleId(selectRoleId);
		userRL = this.iUserRoleServices.findUserRolePage(userRLCond);
		for (int i = 0; i < userRL.size(); i++) {
			userRL.get(i).initUserAccount();
		}
		return userRL;
//		if(leftUserCond == null)rightUserCond = new UserAccountCond();
//		return iUserAccountServices.findUserAccountPage(this.leftUserCond);
	}

	public Role getSelectRole() {
		return selectRole;
	}

	public void setSelectRole(Role selectRole) {
		this.selectRole = selectRole;
	}

	public List<UserAccount> getRightUserList() {
		return rightUserList;
	}

	public void setRightUserList(List<UserAccount> rightUserList) {
		this.rightUserList = rightUserList;
	}


	public List<UserRole> getLeftUserList() {
		return leftUserList;
	}

	public void setLeftUserList(List<UserRole> leftUserList) {
		this.leftUserList = leftUserList;
	}

	public UserAccountCond getRightUserCond() {
		return rightUserCond;
	}

	public void setRightUserCond(UserAccountCond rightUserCond) {
		this.rightUserCond = rightUserCond;
	}

	public UserAccountCond getLeftUserCond() {
		return leftUserCond;
	}

	public void setLeftUserCond(UserAccountCond leftUserCond) {
		this.leftUserCond = leftUserCond;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<CompanyProject> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<CompanyProject> projectList) {
		this.projectList = projectList;
	}
	
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getSelectRoleId() {
		return selectRoleId;
	}

	public void setSelectRoleId(String selectRoleId) {
		this.selectRoleId = selectRoleId;
	}
	
	
}
