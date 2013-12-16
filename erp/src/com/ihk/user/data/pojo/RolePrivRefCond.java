package com.ihk.user.data.pojo;

import java.util.Date;
import java.util.List;

import com.ihk.utils.SearchCond;

/**
 * RolePrivRef的查询条件
 * @author peter.kuang
 *
 */
public class RolePrivRefCond extends SearchCond{

	private String roleId;	
	private List<Integer> roleIds;	
    private String refRoleId;
    
	public String getRefRoleId() {
		return refRoleId;
	}
	public void setRefRoleId(String refRoleId) {
		this.refRoleId = refRoleId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public List<Integer> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}
	
	
	
	
}
