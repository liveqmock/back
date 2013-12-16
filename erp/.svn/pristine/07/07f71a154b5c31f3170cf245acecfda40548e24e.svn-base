package com.ihk.user.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.user.data.IRoleMapper;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.RoleCond;
import com.ihk.user.data.services.IRoleServices;

@Service("roleServices")
public class RoleServices implements IRoleServices {
	@Autowired	 IRoleMapper roleMapper;

	public void deleteRole(int id) throws RuntimeException {
		roleMapper.deleteRole(id);
	}

	public void addRole(Role role) throws RuntimeException {		
		roleMapper.addRole(role);
	}

	@Override
	public Role findRoleById(int id) throws RuntimeException {
		return roleMapper.findRoleById(id);
	}

	@Override
	public void updateRole(Role role) throws RuntimeException {
		roleMapper.updateRole(role);		
	}
	
	public List<Role> findRolePage(RoleCond cond) throws RuntimeException {
		int recordCount = roleMapper.findRoleCount(cond);
		
		cond.recordCount = recordCount;
				
		return roleMapper.findRolePage(cond);
	}

	@Override
	public List<Role> findRole() throws Exception {
		return roleMapper.findRole();
	}

	@Override
	public List<Role> findRolesLikeName(String name) throws Exception {
		return roleMapper.findRolesLikeName(name);
	}
}
