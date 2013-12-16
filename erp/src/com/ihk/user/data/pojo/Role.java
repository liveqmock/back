package com.ihk.user.data.pojo;

import java.util.Date;
import java.io.Serializable;

import com.ihk.utils.DescUtils;

/**
 * Role的实体类
 * @author 
 *
 */
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String roleName;
	private int projectId;
	private String roleDesc;
	private String devFlag;
    private int orderIndex;
    private int companyId;
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

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
	 * 取得RoleName(角色名)
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 设置roleName(角色名)
	 * @param roleName (角色名)
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	 * 取得RoleDesc(角色描述)
	 */
	public String getRoleDesc() {
		return roleDesc;
	}

	/**
	 * 设置roleDesc(角色描述)
	 * @param roleDesc (角色描述)
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
    
	/**
	 * 取得DevFlag(开发标识)
	 */
	public String getDevFlag() {
		return devFlag;
	}

	/**
	 * 设置devFlag(开发标识)
	 * @param devFlag (开发标识)
	 */
	public void setDevFlag(String devFlag) {
		this.devFlag = devFlag;
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

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public Role(){}


	/**
	 * 
	 * @param id ()
	 * @param roleName (角色名)
	 * @param projectId (所属项目)
	 * @param roleDesc (角色描述)
	 * @param devFlag (开发标识)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public Role(    
		int id,
        		String roleName,
        		int projectId,
        		String roleDesc,
        		String devFlag,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.roleName = roleName;
		this.projectId = projectId;
		this.roleDesc = roleDesc;
		this.devFlag = devFlag;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param roleName (角色名)
	 * @param projectId (所属项目)
	 * @param roleDesc (角色描述)
	 * @param devFlag (开发标识)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public Role(    
		String roleName,
        		int projectId,
        		String roleDesc,
        		String devFlag,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.roleName = roleName;
		this.projectId = projectId;
		this.roleDesc = roleDesc;
		this.devFlag = devFlag;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	
	 
	//
	
	public String getDescProjectName(){
		
		try {
			return DescUtils.getCompanyProjectRealName(this.projectId);
		} catch (Exception e) {
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
