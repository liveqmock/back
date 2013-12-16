package com.ihk.user.manager;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContAccountType;
import com.ihk.constanttype.ContRoleId;
import com.ihk.constanttype.ContUserId;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.pojo.UserRoleCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.IRoleServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.user.data.services.IUserRoleServices;
import com.ihk.user.data.services.impl.UserAccountServices;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;

/**
 * 用户管理类
 * 新建用户等
 * */
public class UserAccountInputAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	@Autowired IUserAccountServices userAccountServices;
	@Autowired IUserRoleServices userRoleServices;
	@Autowired ICompanyProjectServices companyProjectServices;
	@Autowired IRoleServices roleServices;
	private UserAccount userAccount;
	private UserAccount webUserAccount;
	private String userRoleIds;//查询页面选择的多个id
	
	private String unBind;
	/**
	 * 用户管理主页面
	 * */
	public String index(){
		init();
		return "index";
	}
	
	/**
	 * 新建用户
	 * @param userAccount 新建用户pojo
	 * */
	public String form(){			
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {			
			@Override
			public void modifyMethodException(Exception e) {				
				setUpEasyuiAjaxForFail(e.getMessage());				
			}
			
			@Override
			public void modifyMethod() throws Exception {				
				init();
				
				if(userAccount.getUserName()==null||userAccount.getUserName().trim().equals("")){					
					throw new Exception("注册失败.用户名不能为空.");
				}
				
				if(userAccount.getUserPwd() == null || userAccount.getUserPwd().trim().equals("")){				
					throw new Exception("注册失败.密码不能为空.");
				}
				
				if(userAccount.getRealName() == null || userAccount.getRealName().trim().equals("")){			
					throw new Exception("注册失败.姓名不能为空.");
				}
				
				//去掉空格
				userAccount.setUserName(userAccount.getUserName().trim());
				userAccount.setRealName(userAccount.getRealName().trim());
				
				if(valUserName(userAccount.getUserName())) {		
					throw new Exception("注册失败.用户名重复.");
				}
				userAccount = initUpdateUser(userAccount);
				userAccountServices.saveUserAccount(userAccount);
				addRole(userAccount);
				
			}
		});		
		
		return null;
	}
	
	private List<UserRole> userRoleList; 
	private int userId;
	/**
	 * update用户界面
	 * @param userId 选择的用户ID
	 * @param userAccount 操作的用户pojo
	 * @param projectList list
	 * */
	public String updateUser(){
		this.removeSuggestion();
		this.userAccount = this.userAccountServices.findUserAccountById(this.userId);
		addUserRole = new UserRole();
		addUserRole.setProjectId(userAccount.getProjectId());
		
		//this.projectList = GuangZhouUtils.getGuangZhouCompanyProject();//加权限后改为符合权限的prolist
		UserRoleCond cond = new UserRoleCond();
		cond.setUserId(this.userId+"");
		this.userRoleList = this.userRoleServices.findUserRolePage(cond);
		if(ContAccountType.UNBIND_CHECK.equals(userAccount.getAccountType())){
			unBind = ContAccountType.UNBIND_CHECK;
		}else
			unBind = ContAccountType.MANAGER;
		return "updateUser";
	}
	
	/**
	 * 修改用户信息
	 * @param userAccount pojo
	 * ps: 修改密码需要注意  因为要md5加密 如果没有设定密码空 则会把已经加密的密码再次加密
	 * */
	public String updateUserForm(){
		
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
			}
			
			@Override
			public void modifyMethod() throws Exception {
				
				if(userAccount.getRealName() == null || userAccount.getRealName().trim().equals("")){
					webUserAccount = userAccount;
					userId = userAccount.getId();
					
					throw new Exception("注册失败.姓名不能为空");
				}
				
					

				//提取数据库的原有信息，然后每个字段都保存
				UserAccount toSaveUser = userAccountServices.findUserAccountById(userAccount.getId());
				toSaveUser.setRealName(userAccount.getRealName());
				toSaveUser.setMobilePhone(userAccount.getMobilePhone());
				toSaveUser.setJobNumber(userAccount.getJobNumber());
				toSaveUser.setProjectId(userAccount.getProjectId());
				toSaveUser.setCompanyId(DescUtils.getCompanyIdByProjectId(userAccount.getProjectId())); //公司联动修改
				toSaveUser.setRemark(userAccount.getRemark());
				if(unBind.equals(ContAccountType.UNBIND_CHECK))
					toSaveUser.setAccountType(ContAccountType.UNBIND_CHECK);
				else
					toSaveUser.setAccountType(ContAccountType.MANAGER);
				toSaveUser.setModId(SessionUser.getUserId());
				toSaveUser.setModTime(new Date());
				
				toSaveUser.setUserPwd("");//在不用修改密码的时候 要设定密码为空
				userAccountServices.updateUserAccount(toSaveUser);
				userId = toSaveUser.getId();

			}
		});
		
		return null;
	}

	static final String INIT_PWD = "a123456";
	public int initId;
	
	/**
	 * 2012-10-25 
	 * 初始化密码 为a123456
	 * */
	public String initPwd() throws IOException{
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
			}
			
			@Override
			public void modifyMethod() throws Exception {
				UserAccount initUser =  userAccountServices.findUserAccountById(initId);
				initUser.setUserPwd(INIT_PWD);
				userAccountServices.updateUserAccount(initUser,UserAccountServices.UPDATE_USER_ACCOUNT_TYPE_PWD);
			}
		});
		
		return null;
	}
	
	/**
	 * @param initId 删除用ID
	 * @throws IOException 
	 * */
	public String delUser() throws IOException{
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
			}
			
			@Override
			public void modifyMethod() throws Exception {
				if(initId != 0){
					userAccountServices.deleteUserAccount(initId);
				}
			}
		});
		
		return null;
	}

	/**
	 * @param initId 恢复用户
	 * @throws IOException 
	 * */
	public String undoDelUser() throws IOException{
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
			}
			
			@Override
			public void modifyMethod() throws Exception {
				if(initId != 0){
					userAccountServices.undoDeleteUserAccount(initId);
				}
			}
		});
		
		return null;
	}
	

	
	private UserRole addUserRole;
	/**
	 * 新建权限
	 * @param addUserRole 新建权限pojo 
	 * @throws 注入基本的pojo数据出现错误
	 * */
	public String addUserRold(){
		addUserRole.setIsDeleted("0");
		addUserRole.setCreatedId(SessionUser.getUserId());
		addUserRole.setModId(SessionUser.getUserId());
		addUserRole.setCreatedTime(new Date());
		addUserRole.setModTime(new Date());
		this.addUserRole.setCompanyId(DescUtils.getCompanyIdByProjectId(this.addUserRole.getProjectId()));
		if(addUserRole.getRoleId() == ContRoleId.SALEROLE_ID){//如果是新增销售 测该权限没有项目
			addUserRole.setProjectId(0);
		}
		this.userRoleServices.addUserRole(this.addUserRole);
		this.userId = addUserRole.getUserId();
		this.setSuggestion("操作成功,增加权限");
		return updateUser();
	}
	
	private int userRoleId;
	/**
	 * 删除一个用户角色
	 * @param userId 删除的用户ID
	 * @param userRoleId 删除的权限ID
	 * */
	public String delUserRole(){
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
			}
			
			@Override
			public void modifyMethod() throws Exception {
				userRoleServices.deleteUserRole(userRoleId);
			}
		});
		
		return null;
	}

	/**
	 * 删除多个角色
	 * @return
	 */
	public String delUserRoles(){
		ActionTemplate.executeAjaxMethod(true,this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
			}
			
			@Override
			public void modifyMethod() throws Exception {
				if(SessionUser.getUserId()!=ContUserId.ADMIN){
					throw new Exception();					
				}

				String tempids[]=userRoleIds.split("_");
				for (String strId:tempids){
					int id=0;
					try{
						id = Integer.parseInt(strId);
					}
					catch(Exception e){
						continue;
					}
					userRoleServices.deleteUserRole(id);
				}
			}
		});
		
		return null;
	}
	
	/**是否重账号名称
	 * @return true 有重复
	 * */
	private boolean valUserName(String username){
		UserAccount temp = new UserAccount();
		temp.setUserName(username);
		boolean haveName =  userAccountServices.valUserByName(temp);
		return haveName;
	}
	
	/**
	 * 补全新建用户信息
	 * */
	private UserAccount initUpdateUser(UserAccount tpuser){
		Date thisDate = new Date();
		tpuser.setAccountType("1");
		CompanyProject pro = companyProjectServices.findCompanyProjectById(tpuser.getProjectId());
		tpuser.setCompanyId(pro.getCompanyId());
		tpuser.setCreatedId(SessionUser.getUserId());
		tpuser.setCreatedTime(thisDate);
		tpuser.setModId(SessionUser.getUserId());
		tpuser.setModTime(thisDate);
		tpuser.setIsDeleted("0");
		return tpuser;
	}
	
	/**
	 * 在新建用户的时候 初始化 销售权限
	 * */
	private void addRole(UserAccount inputRole){
		UserRole userRole ;
		userRole = new UserRole();
		userRole.setRoleId(ContRoleId.SALEROLE_ID);  //~~~~~~~~~~直接保存权限11 为销售人员
		userRole.setProjectId(0);
		userRole.setCreatedId(SessionUser.getUserId());
		userRole.setCreatedTime(inputRole.getCreatedTime());
		userRole.setIsDeleted("0");
		userRole.setModId(SessionUser.getUserId());
		userRole.setModTime(inputRole.getCreatedTime());
		userRole.setUserId(inputRole.getId());
		userRole.setProjectId(0);
		userRole.setCompanyId(DescUtils.getCompanyIdByProjectId(inputRole.getProjectId()));
		this.userRoleServices.addUserRole(userRole);
	}
	
	private void init(){
		//this.projectList = GuangZhouUtils.getGuangZhouCompanyProject();//加权限后改为符合权限的prolist
		webUserAccount = new UserAccount();
	}
	

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public UserAccount getWebUserAccount() {
		return webUserAccount;
	}

	public void setWebUserAccount(UserAccount webUserAccount) {
		this.webUserAccount = webUserAccount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	public UserRole getAddUserRole() {
		return addUserRole;
	}

	public void setAddUserRole(UserRole addUserRole) {
		this.addUserRole = addUserRole;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public int getInitId() {
		return initId;
	}

	public void setInitId(int initId) {
		this.initId = initId;
	}

	/**
	 * @return 要删除的userRoleId
	 */
	public String getUserRoleIds() {
		return userRoleIds;
	}

	/**
	 * @param 要删除的userRoleId
	 */
	public void setUserRoleIds(String userRoleIds) {
		this.userRoleIds = userRoleIds;
	}

	public String getUnBind() {
		return unBind;
	}

	public void setUnBind(String unBind) {
		this.unBind = unBind;
	}
	
}
