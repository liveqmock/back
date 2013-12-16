package com.ihk.user.data.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ihk.permission.PermissionUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.common.listener.MyHttpSessionBindingListener;
import com.ihk.utils.useraccount.UserAccountUtils;

/**
 * UserAccount的实体类
 * @author 
 *
 */
public class UserAccount extends MyHttpSessionBindingListener implements Serializable{
	
	private static final long serialVersionUID = 7239602541786111597L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
	private int id;
	private String userName;
	private transient String userPwd; //为了安全,密码字段不能序列化,这样保持在客户机那边也不能反序列化该字段
	private String mobilePhone;
	private int companyId;
	private int projectId;
	private int departmentId;
	private int teamId;
	private String realName;
	private String accountType;
	private String jobNumber;
	private String innerUserName;
	private String remark;
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;

	/**
	 * 取得Id()
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置id()
	 * @param id ()
	 */
	public void setId(int id) {
		this.id = id;
	}
    
	/**
	 * 取得UserName(用户名)
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置userName(用户名)
	 * @param userName (用户名)
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
    
	/**
	 * 取得UserPwd(密码)
	 */
	public String getUserPwd() {
		return userPwd;
	}

	/**
	 * 设置userPwd(密码)
	 * @param userPwd (密码)
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
    
	/**
	 * 取得MobilePhone(手机号)
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * 设置mobilePhone(手机号)
	 * @param mobilePhone (手机号)
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
    
	/**
	 * 取得CompanyId(所属公司)
	 */
	public int getCompanyId() {
		return companyId;
	}

	/**
	 * 设置companyId(所属公司)
	 * @param companyId (所属公司)
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
    
	/**
	 * 取得ProjectId(所属项目)
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * 设置projectId(所属项目)
	 * @param projectId (所属项目)
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
    
	/**
	 * 取得DepartmentId(所属部门)
	 */
	public int getDepartmentId() {
		return departmentId;
	}

	/**
	 * 设置departmentId(所属部门)
	 * @param departmentId (所属部门)
	 */
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
    
	/**
	 * 取得TeamId(所属组别)
	 */
	public int getTeamId() {
		return teamId;
	}

	/**
	 * 设置teamId(所属组别)
	 * @param teamId (所属组别)
	 */
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
    
	/**
	 * 取得RealName(真实姓名)
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * 设置realName(真实姓名)
	 * @param realName (真实姓名)
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
    
	/**
	 * 取得AccountType()
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * 设置accountType()
	 * @param accountType ()
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
    
	/**
	 * 取得JobNumber(工号)
	 */
	public String getJobNumber() {
		return jobNumber;
	}

	/**
	 * 设置jobNumber(工号)
	 * @param jobNumber (工号)
	 */
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
    
	/**
	 * 取得InnerUserName(内网用户名)
	 */
	public String getInnerUserName() {
		return innerUserName;
	}

	/**
	 * 设置innerUserName(内网用户名)
	 * @param innerUserName (内网用户名)
	 */
	public void setInnerUserName(String innerUserName) {
		this.innerUserName = innerUserName;
	}
    
	/**
	 * 取得Remark(备注)
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置remark(备注)
	 * @param remark (备注)
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
	/**
	 * 取得IsDeleted(是否删除)
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 设置isDeleted(是否删除)
	 * @param isDeleted (是否删除)
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
    
	/**
	 * 取得CreatedId(创建人)
	 */
	public int getCreatedId() {
		return createdId;
	}

	/**
	 * 设置createdId(创建人)
	 * @param createdId (创建人)
	 */
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
    
	/**
	 * 取得CreatedTime(创建时间)
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * 设置createdTime(创建时间)
	 * @param createdTime (创建时间)
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
    
	/**
	 * 取得ModId(修改人)
	 */
	public int getModId() {
		return modId;
	}

	/**
	 * 设置modId(修改人)
	 * @param modId (修改人)
	 */
	public void setModId(int modId) {
		this.modId = modId;
	}
    
	/**
	 * 取得ModTime(修改时间)
	 */
	public Date getModTime() {
		return modTime;
	}

	/**
	 * 设置modTime(修改时间)
	 * @param modTime (修改时间)
	 */
	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}
    
	
	public UserAccount(){
		super();
	};


	/**
	 * 
	 * @param id ()
	 * @param userName (用户名)
	 * @param userPwd (密码)
	 * @param mobilePhone (手机号)
	 * @param companyId (所属公司)
	 * @param projectId (所属项目)
	 * @param departmentId (所属部门)
	 * @param teamId (所属组别)
	 * @param realName (真实姓名)
	 * @param accountType ()
	 * @param jobNumber (工号)
	 * @param innerUserName (内网用户名)
	 * @param remark (备注)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public UserAccount(    
		int id,
        		String userName,
        		String userPwd,
        		String mobilePhone,
        		int companyId,
        		int projectId,
        		int departmentId,
        		int teamId,
        		String realName,
        		String accountType,
        		String jobNumber,
        		String innerUserName,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.userName = userName;
		this.userPwd = userPwd;
		this.mobilePhone = mobilePhone;
		this.companyId = companyId;
		this.projectId = projectId;
		this.departmentId = departmentId;
		this.teamId = teamId;
		this.realName = realName;
		this.accountType = accountType;
		this.jobNumber = jobNumber;
		this.innerUserName = innerUserName;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param userName (用户名)
	 * @param userPwd (密码)
	 * @param mobilePhone (手机号)
	 * @param companyId (所属公司)
	 * @param projectId (所属项目)
	 * @param departmentId (所属部门)
	 * @param teamId (所属组别)
	 * @param realName (真实姓名)
	 * @param accountType ()
	 * @param jobNumber (工号)
	 * @param innerUserName (内网用户名)
	 * @param remark (备注)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public UserAccount(    
		String userName,
        		String userPwd,
        		String mobilePhone,
        		int companyId,
        		int projectId,
        		int departmentId,
        		int teamId,
        		String realName,
        		String accountType,
        		String jobNumber,
        		String innerUserName,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.userName = userName;
		this.userPwd = userPwd;
		this.mobilePhone = mobilePhone;
		this.companyId = companyId;
		this.projectId = projectId;
		this.departmentId = departmentId;
		this.teamId = teamId;
		this.realName = realName;
		this.accountType = accountType;
		this.jobNumber = jobNumber;
		this.innerUserName = innerUserName;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	
	//是否超级管理员
	public boolean isPowerAdmin() {
		return false;
	}
	
	//是否超级管理员
	public boolean isAdmin() {
		if(CommonUtils.ADMIN.equals(this.accountType)){
			return true;
		}
		
		return false;
	}
	

	private List<Role> selectUserRoleList;//权限list
	
	
	public List<Role> getSelectUserRoleList() {
	
		return selectUserRoleList;
	}
	public void initSelectUserRoleList(){
		if(this.id == 0){
			selectUserRoleList = null;
		}else{
			selectUserRoleList = PermissionUtils.getUserRoleListByUid(this.id);
		}
	}

	public String getDescCompanyId() throws Exception{	
	
		return DescUtils.getCompanyRealName(companyId);
	}

	public String getDescProjectId() throws Exception {
		return DescUtils.getCompanyProjectRealName(this.projectId);
	}

	/**
	 * 状态是否已删除
	 */
	public String getDescIsDeleted() throws Exception {
		if(isDeleted.equalsIgnoreCase("1")){
			return "已删除";
		}
		else{
			return "正常";
		}
	}
	
	/**
	 * 判断是否已经改了密码
	 * a123456与123456为未改密码
	 * @return
	 */
	public String getChangePwd(){
		
		if("dc483e80a7a0bd9ef71d8cf973673924".equals(this.getUserPwd()) 
				|| "e10adc3949ba59abbe56e057f20f883e".equals(this.getUserPwd())){
			
			return "否";
		}
		
		return "是";
	}
	
	/**
	 * 获取创建日期
	 * @return
	 */
	public String getCreatedTimeStr(){
		
		return CommonUtils.getDateLocalString(this.getCreatedTime());
	}
	
	/**
	 * 获取修改日期
	 * @return
	 */
	public String getModTimeStr(){
		
		return CommonUtils.getDateLocalString(this.getModTime());
	}
	
	/**
	 * 获取用户的点击弹出
	 * @return
	 */
	public String getUserNameClick(){
		
		return "<a style='color: #1199FF;cursor: pointer;' class='ablue' onClick='dialog_update_user(" + this.getId() +  
			")'>" + this.getUserName() + "</a>";
	}
	
	/**
	 * 获取对应用户的角色
	 * @return
	 */
	public String getUserRole(){
		
		return UserAccountUtils.getUserProjectRoleString(this.getId());
	}

	@Override
	public UserAccount userBoundOrUn() {
		return this;
	}

}
