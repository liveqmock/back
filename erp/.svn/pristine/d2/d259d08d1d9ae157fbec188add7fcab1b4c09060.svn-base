package com.ihk.user.data.pojo;

import java.util.List;

import com.ihk.utils.SearchCond;

/**
 * Role的查询条件
 * @author peter.kuang
 *
 */
public class RoleCond extends SearchCond{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String roleName;  //用于数据库查找
	private List<Integer> roleIds;	
	private int projectId;
	
	private String projectName; //项目名称,用于提示框查找,格式如:天銮(1),其中括号中的1为projectId
	private String fmRoleName; //用于页面显示
	private String devFlag;//guangzhou hengda==
    private int orderIndex;
    private int companyId;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setFmRoleName(String fmRoleName) {
		this.fmRoleName = fmRoleName;
	}

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getDevFlag() {
		return devFlag;
	}

	public void setDevFlag(String devFlag) {
		this.devFlag = devFlag;
	}

	public String getFmRoleName() {
		return fmRoleName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public List<Integer> getRoleIds() {
		return roleIds;
	}
	
	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}
	
	
	public int getProjectId() {
		return projectId;
	}
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
		
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
