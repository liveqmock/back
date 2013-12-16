package com.ihk.user.data.pojo;

import java.util.Date;
import java.io.Serializable;

import com.ihk.utils.DescUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 用户拥有的角色的实体类
 * 如果只是有projectId,没有companyId，视为不对的数据
 * @author 
 *
 */
public class UserRole implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int roleId;
	private int userId;
	private int companyId;
	private int projectId;
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
	 * 取得RoleId(角色)
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * 设置roleId(角色)
	 * @param roleId (角色)
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
    
	/**
	 * 取得UserId(用户)
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * 设置userId(用户)
	 * @param userId (用户)
	 */
	public void setUserId(int userId) {
		this.userId = userId;
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
    
	
	public UserRole(){};


	/**
	 * 
	 * @param id ()
	 * @param roleId (角色)
	 * @param userId (用户)
	 * @param companyId (所属公司)
	 * @param projectId (所属项目)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public UserRole(    
		int id,
        		int roleId,
        		int userId,
        		int companyId,
        		int projectId,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.roleId = roleId;
		this.userId = userId;
		this.companyId = companyId;
		this.projectId = projectId;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param roleId (角色)
	 * @param userId (用户)
	 * @param companyId (所属公司)
	 * @param projectId (所属项目)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public UserRole(    
		int roleId,
        		int userId,
        		int companyId,
        		int projectId,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.roleId = roleId;
		this.userId = userId;
		this.companyId = companyId;
		this.projectId = projectId;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	

	//getuseraccount
	private UserAccount userAccount;
		
	public UserAccount getUserAccount(){
		return userAccount;
	}
	public void  initUserAccount(){
		if(userId != 0){
			this.userAccount = DescUtils.getUserAccountById(this.userId);
		}
	}
	
	///
	
	/**
	 * 获取项目中文名称
	 */
	public String getProjectName(){
		
		CompanyProject project = MyPropertyUtils.getCompanyProjectServices().findCompanyProjectById(this.getProjectId());
		if(project == null)
			return "";
		
		return project.getProjectName();
	}
	
	/**
	 * 获取对应的项目的中文及拼音: 大学小筑dxxz
	 */
	public String getProjectNameAndPinyin(){
		
		CompanyProject project = MyPropertyUtils.getCompanyProjectServices().findCompanyProjectById(this.getProjectId());
		if(project == null)
			return "";
		
		return project.getProjectName() + project.getPinyin();
	}

	/**
	 * 公司名称
	 * @return
	 */
	public String getDescCompanyId(){
		return DescUtils.getCompanyRealName(this.companyId);
	}
	
	/**
	 * 项目名称
	 * @return
	 */
	public String getDescProjectId(){
		return DescUtils.getCompanyProjectRealName(this.projectId);
	}
	
	public String getDescRoleName(){
		try{
			return DescUtils.getRoleName(this.getRoleId());
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	public String getDescUserRealName(){
		try{
			return DescUtils.getUserRealName(this.userId);
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	public String getDescUserName(){
		try{
			return DescUtils.getUserAccountById(this.userId).getUserName();
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	
	public String getDescModName(){
		try{
			return DescUtils.getUserRealName(this.modId);
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	
	///
}
