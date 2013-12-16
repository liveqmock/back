package com.ihk.user.action;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.Priv;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.RoleCond;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserPrivCond;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.pojo.UserRoleCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.IRoleServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.user.data.services.IUserRoleServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;
/**
 * 用户角色表的相关操作
 * 该类大部分都已经没有再起作用
 */
public class UserRoleAction extends SupperAction {

	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IRoleServices roleServices;
	@Autowired
	ICompanyProjectServices comProServices;
	@Autowired
	IUserRoleServices userRoleServices;
	@Autowired
	IUserAccountServices userAccountServices;
	
	/**
	 * 查找角色  
	 * */
	public String queryRoles() throws Exception{
		
		String from = request.getParameter("from");  //按条件搜索时就为空
		HttpSession session = request.getSession();
		
		if("left".equals(from)){
			//点击左边或顶上的"查询客户"
			session.removeAttribute("roleCond"); //清空该session
			roleCond = new RoleCond(); 
			
		}else{
			
			if("return".equals(from)){
				//表示点击了 返回
				Object getCond = session.getAttribute("roleCond");
				roleCond = (RoleCond) getCond;
				
			}
			
			if(roleCond == null){ //登陆
				roleCond = new RoleCond();
				
			}
			
		}
		
		String deleteSession = request.getParameter("deleteSession");
		if(!"false".equals(deleteSession)){
			//说明不是从删除后跳过来的,要清空session
			session.removeAttribute("suggestion");
		}
		
		String action = CustomerUtils.getActionNameFromRequest(request);
		Pager page = new Pager(ActionContext.getContext(),pageSize,action);
		
		//在使用RoleCond之前先进行相关的设置
		String fmRoleName = roleCond.getFmRoleName();
		roleCond.setRoleName(CommonUtils.getCompleteName(fmRoleName));
		
		String projectName = roleCond.getProjectName();
		roleCond.setProjectId(CommonUtils.getCompleteId(projectName));
		
		page.setCond(roleCond);
		
		roleList = roleServices.findRolePage(roleCond);
		
		session.setAttribute("roleList", roleList);
		session.setAttribute("roleCond", roleCond);
		
		this.setShowPage(page.toHtmlString());
		
		return "queryRole";
	}
	
	/**初始化角色界面*/
	public String doSomeForAddRole() throws Exception{
		HttpSession session = request.getSession();

		session.removeAttribute("suggestion");
		
		return "toAdd";
	}
	
	
	/**
	 * 增加角色
	 * */
	public String addRole() throws Exception{
		UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
		Date date = new Date();
		
		role.setCreatedId(user.getId());
		role.setCreatedTime(date);
		role.setIsDeleted(CommonUtils.NORMAL);
		role.setModId(user.getId());
		role.setModTime(date);
		
		boolean isSucc = false;
		
		try{
			String projectName = request.getParameter("projectName");
			
			int projectId = CommonUtils.getCompleteId(projectName);
			if(projectId == 0){
				//说明传过来的值有问题
				setSuggestion("项目名称不合法");
				return "addRole";
			}
			
			role.setProjectId(projectId);
			roleServices.addRole(role);
			isSucc = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(isSucc){
			setSuggestion(CommonUtils.SUCCSUGG);
		}else{
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return "addRole";
	}
	
	public String queryRoleById() throws Exception{
		HttpSession session = request.getSession();
		
		String roleId = request.getParameter("id");
		int id = Integer.parseInt(roleId);
		
		Role role = roleServices.findRoleById(id);
		CompanyProject comPro = comProServices.findCompanyProjectById(role.getProjectId());
		StringBuffer sb = new StringBuffer();
		sb.append(comPro.getProjectName())
			.append("(")  
			.append(comPro.getId())				
			.append(")\n")
			;
		
		removeSuggestion();
		session.setAttribute("role", role);
		session.setAttribute("projectName", sb.toString());
		
		return "queryRoleById";
	}
	
	/**
	 * 更新角色
	 * */
	public String updateRole() throws Exception{
		boolean isSucc = true;
		HttpSession session = request.getSession();
		
		try{
			int id = role.getId();
			
			UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
			Date date = new Date();
			
			Role oldRole = roleServices.findRoleById(id);
			role.setCreatedId(oldRole.getCreatedId());
			role.setCreatedTime(oldRole.getCreatedTime());
			role.setIsDeleted(oldRole.getIsDeleted());
			role.setModId(user.getId());
			role.setModTime(date);
			
			String projectName = request.getParameter("projectName");
			int projectId = CommonUtils.getCompleteId(projectName);
			if(projectId == 0){
				//说明传过来的值有问题
				setSuggestion("项目名称不合法");
				return "updateRole";
			}
		
			role.setProjectId(projectId);
			roleServices.updateRole(role);
			
			session.setAttribute("role", role);
			
			CompanyProject comPro = comProServices.findCompanyProjectById(role.getProjectId());
			StringBuffer sb = new StringBuffer();
			sb.append(comPro.getProjectName())
				.append("(")  
				.append(comPro.getId())				
				.append(")\n")
				;
			session.setAttribute("projectName", sb.toString());
			
		}catch(Exception e){
			e.printStackTrace();
			isSucc = false;
		}
		
		if(isSucc){
			setSuggestion(CommonUtils.SUCCSUGG);
		}else{
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return "updateRole";
	}
	
	/**
	 * 删除角色
	 * */
	@Deprecated
	public String deleteRoles() throws Exception{
		String getIdStr = request.getParameter("ids");
		String[] idsStr = getIdStr.split("_");
		
		try{
			for(String idStr : idsStr){
				int id = Integer.parseInt(idStr);
				roleServices.deleteRole(id); //标示删除
			}
			setSuggestion(CommonUtils.SUCCSUGG);
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return "deleteRole";
	}
	
	/**
	 * 查找用户角色
	 * */
	public String queryUserRoles() throws Exception{
		String from = request.getParameter("from");  //按条件搜索时就为空
		HttpSession session = request.getSession();
		
		if("left".equals(from)){
			//点击左边或顶上的"查询客户"
			session.removeAttribute("userRoleCond"); //清空该session
			userRoleCond = new UserRoleCond(); 
			
		}else{
			
			if("return".equals(from)){
				//表示点击了 返回
				Object getCond = session.getAttribute("userRoleCond");
				userRoleCond = (UserRoleCond) getCond;
				
			}
			
			if(userRoleCond == null){ //登陆
				userRoleCond = new UserRoleCond();
				
			}
			
		}
		
		String deleteSession = request.getParameter("deleteSession");
		if(!"false".equals(deleteSession)){
			//说明不是从删除后跳过来的,要清空session
			session.removeAttribute("suggestion");
		}
		
		String action = CustomerUtils.getActionNameFromRequest(request);
		Pager page = new Pager(ActionContext.getContext(),pageSize,action);
		
		String userName = userRoleCond.getUserName();
		userRoleCond.userId = CommonUtils.getCompleteUserIdByUserName(userName) + "";
		
		page.setCond(userRoleCond);
		
		userRoleList = userRoleServices.findUserRolePage(userRoleCond);
		
		session.setAttribute("userRoleList", userRoleList);
		session.setAttribute("userRoleCond", userRoleCond);
		
		this.setShowPage(page.toHtmlString());
		
		return "queryUserRole";
	}
	
	/**
	 * 增加用户角色
	 * */
	@Deprecated
	public String doSomeForAddUserRole() throws Exception{
		
		removeSuggestion();
		
		return "toAddUserRole";
	}
	
	/**
	 * 查找用户角色
	 * */
	@Deprecated
	public String queryUserRoleById() throws Exception{
		HttpSession session = request.getSession();
		
		String userRoleId = request.getParameter("id");
		int id = Integer.parseInt(userRoleId);
		
		UserRole userRole = userRoleServices.findUserRoleById(id);
		
		removeSuggestion();
		session.setAttribute("userRole", userRole);
				
		return "queryUserRoleById";
	}
	
	/**
	 * 查找用户角色
	 * */
	@Deprecated
	public String addUserRole() throws Exception{
		String userName = request.getParameter("userName");
		String roleName = request.getParameter("roleName");
		
		int userId = CommonUtils.getCompleteUserIdByUserName(userName);
		int roleId = CommonUtils.getCompleteId(roleName);
		
		userRole = new UserRole();  //因为不是从页面注入的,所有其为null
		userRole.setUserId(userId);
		userRole.setRoleId(roleId);
		
		
		//避免刷新增加
		if(userRole.getUserId() == 0 || userRole.getRoleId() == 0){
			setSuggestion("用户或角色不合法");
			return "addUserRole";
		}
		
		
		//先判断该用户是否有该role
		List<UserRole> urList = userRoleServices.findUserRoleByUserId(userRole.getUserId());
		boolean isHaveRole = false;
		for(UserRole ur : urList){
			int existsRoleId = ur.getRoleId();
			if(existsRoleId == userRole.getRoleId()){
				isHaveRole = true;
				break;
			}
		}
		
		if(isHaveRole){
			setSuggestion("该用户已经拥有该角色");
			return "addUserRole";
		}
		
		UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
		Date date = new Date();
		
		userRole.setCreatedId(user.getId());
		userRole.setCreatedTime(date);
		userRole.setIsDeleted(CommonUtils.NORMAL);
		userRole.setModId(user.getId());
		userRole.setModTime(date);
		
		boolean isSucc = false;
		
		try{
			userRoleServices.addUserRole(userRole);
			isSucc = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(isSucc){
			setSuggestion(CommonUtils.SUCCSUGG);
		}else{
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return "addUserRole";
	}
	
	/**
	 * 删除用户角色
	 * */
	@Deprecated
	public String deleteUserRoles() throws Exception{
		String getIdStr = request.getParameter("ids");
		String[] idsStr = getIdStr.split("_");
		
		try{
			for(String idStr : idsStr){
				int id = Integer.parseInt(idStr);
				userRoleServices.deleteUserRole(id); //标示删除
			}
			setSuggestion(CommonUtils.SUCCSUGG);
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return "deleteUserRole";
	}
	
	/**
	 * 更新用户角色
	 * */
	public String updateUserRole() throws Exception{
		String roleName = request.getParameter("roleName");
		int roleId = CommonUtils.getCompleteId(roleName);
		
		if(roleId == 0){
			setSuggestion("角色不合法");
			return "updateUserRole";
		}
		
		//先判断该用户是否有该role
		List<UserRole> urList = userRoleServices.findUserRoleByUserId(userRole.getUserId());
		boolean isHaveRole = false;
		for(UserRole ur : urList){
			int existsRoleId = ur.getRoleId();
			if(existsRoleId == roleId){
				isHaveRole = true;
				break;
			}
		}
		
		if(isHaveRole){
			setSuggestion("该用户已经拥有该角色");
			return "updateUserRole";
		}
		
		
		boolean isSucc = true;
		HttpSession session = request.getSession();
		
		try{
			int id = userRole.getId();
			
			UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
			Date date = new Date();
			
			UserRole oldUserRole = userRoleServices.findUserRoleById(id);
			userRole.setCreatedId(oldUserRole.getCreatedId());
			userRole.setCreatedTime(oldUserRole.getCreatedTime());
			userRole.setIsDeleted(oldUserRole.getIsDeleted());
			userRole.setModId(user.getId());
			userRole.setModTime(date);
			
			userRole.setRoleId(roleId);
			
			userRoleServices.updateUserRole(userRole);
			
			session.setAttribute("userRole", userRole);
			
			
		}catch(Exception e){
			e.printStackTrace();
			isSucc = false;
		}
		
		if(isSucc){
			setSuggestion(CommonUtils.SUCCSUGG);
		}else{
			setSuggestion(CommonUtils.FAILSUGG);
		}
				
		return "updateUserRole";
	}
	
	/**
	 * 查找用户所拥有的权限
	 * */
	@Deprecated
	@SuppressWarnings("unchecked")
	public String queryUserPrivs() throws Exception{
		
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("userName");
		
		if(!CustomerUtils.isStrEmpty(userName)){
			//显示
			int userId = CommonUtils.getCompleteUserIdByUserName(userName);
			if(userId == 0){
				setSuggestion("用户名称不合法");
				return null;
			}
			
			userPrivList = PermissionUtils.findUserPriv(userId);
		}
		
		session.setAttribute("userName", userName);
		
		return "queryUserPriv";
	}
	
	
	/**
	 * 查找用户
	 * */
	public String searchUser() throws Exception{
		StringBuffer sb = new StringBuffer();
		
		String userName = request.getParameter("q");
		
		List<UserAccount> users = userAccountServices.findUserAccountsLikeName(userName);
		for(UserAccount user : users){
			sb.append(user.getRealName())
				.append("(")  
				.append(user.getUserName())				
				.append(")\n")
				;
		}
		
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	/**
	 * 查找角色
	 * */
	public String searchRole() throws Exception{
		StringBuffer sb = new StringBuffer();
		
		String roleName = request.getParameter("q");
		
		List<Role> roles = roleServices.findRolesLikeName(roleName);
		for(Role role : roles){
			sb.append(role.getRoleName())
				.append("(")  
				.append(role.getId())//用户增加id的获取				
				.append(")\n")
				;
		}
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	/**
	 * 查找项目
	 * */
	public String searchProject() throws Exception{
		StringBuffer sb = new StringBuffer();
		
		String projectName = request.getParameter("q");
		
		List<CompanyProject> comPros = comProServices.findCompanyProjectsLikeName(projectName);
		
		for(CompanyProject comPro : comPros){
			sb.append(comPro.getProjectName())
				.append("(")  
				.append(comPro.getId())				
				.append(")\n")
				;
		}
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	
	
	
	
	
	
	///////////////////
	
	private String suggestion; //操作提示
	
	private Role role;
	private List<Role> roleList;
	private RoleCond roleCond;
	
	private UserRole userRole;
	private List<UserRole> userRoleList;
	private UserRoleCond userRoleCond;
	
	private List<Priv> privList;
	private UserPrivCond userPrivCond;
	
	private List<Map<String, String>> userPrivList;
	
	private LinkedHashMap<Integer, String> selProject; //role所属项目
	private LinkedHashMap<Integer, String> selRole; //user role所属role
	private LinkedHashMap<Integer, String> selUser; //用户
	
	public void setSelProject(LinkedHashMap<Integer, String> selProject) {
		this.selProject = selProject;
	}
	
	public LinkedHashMap<Integer, String> getSelProject() {
		return selProject;
	}
	
	public void initSelProject() throws Exception{
		if(this.selProject == null){
			selProject = new LinkedHashMap<Integer, String>();
			
			selProject.put(0, CommonUtils.ALL);
			
			List<CompanyProject> comPros = comProServices.findCompanyProject();
			for(CompanyProject comPro : comPros){
				Integer projectId = comPro.getId();
				String projectName = comPro.getProjectName();
				
				selProject.put(projectId, projectName);				
			}
		}
	}
	
	public void setSelRole(LinkedHashMap<Integer, String> selRole) {
		this.selRole = selRole;
	}
	
	public LinkedHashMap<Integer, String> getSelRole() {
		return selRole;
	}
	
	public void initSelRole() throws Exception{
		if(selRole == null){
			selRole = new LinkedHashMap<Integer, String>();
			selRole.put(0, CommonUtils.ALL);
			
			List<Role> roles = roleServices.findRole();
			for(Role role : roles){
				Integer id = role.getId();
				String roleName = role.getRoleName();
				
				selRole.put(id, roleName);
			}
		
		}
	}
	
	public void setSelUser(LinkedHashMap<Integer, String> selUser) {
		this.selUser = selUser;
	}
	
	public LinkedHashMap<Integer, String> getSelUser() {
		return selUser;
	}
	
	public void initSelUser() throws Exception{
		if(selUser == null){
			selUser = new LinkedHashMap<Integer, String>();
			selUser.put(0, CommonUtils.ALL);
			
			List<UserAccount> users = userAccountServices.findUserAccounts();
			for(UserAccount user : users){
				Integer id = user.getId();
				String realName = user.getRealName();
				
				selUser.put(id, realName);
			}
		}
	}
	
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
		request.getSession().setAttribute("suggestion", suggestion);
	}
	
	public String getSuggestion() {
		return suggestion;
	}
	
	public void setRoleCond(RoleCond roleCond) {
		this.roleCond = roleCond;
	}
	
	public RoleCond getRoleCond() {
		return roleCond;
	}
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	public List<Role> getRoleList() {
		return roleList;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public Role getRole() {
		return role;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	public UserRoleCond getUserRoleCond() {
		return userRoleCond;
	}

	public void setUserRoleCond(UserRoleCond userRoleCond) {
		this.userRoleCond = userRoleCond;
	}

	public List<Priv> getPrivList() {
		return privList;
	}

	public void setPrivList(List<Priv> privList) {
		this.privList = privList;
	}

	public UserPrivCond getUserPrivCond() {
		return userPrivCond;
	}

	public void setUserPrivCond(UserPrivCond userPrivCond) {
		this.userPrivCond = userPrivCond;
	}
	
	public void setUserPrivList(List<Map<String, String>> userPrivList) {
		this.userPrivList = userPrivList;
	}
	
	public List<Map<String, String>> getUserPrivList() {
		return userPrivList;
	}
	

}
