package com.ihk.user.data.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.IUserRoleMapper;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.pojo.UserRoleCond;
import com.ihk.user.data.services.IUserRoleServices;

@Service("userRoleServices")
public class UserRoleServices implements IUserRoleServices {
	@Autowired	 IUserRoleMapper userRoleMapper;

	public void deleteUserRole(int id) throws RuntimeException {
		userRoleMapper.deleteUserRole(id);
	}

	public void addUserRole(UserRole userRole) throws RuntimeException {
//		userRole.setCompanyId(0);/////////////////////////////
		userRoleMapper.addUserRole(userRole);
	}

	@Override
	public UserRole findUserRoleById(int id) throws RuntimeException {
		return userRoleMapper.findUserRoleById(id);
	}

	@Override
	public void updateUserRole(UserRole userRole) throws RuntimeException {
		userRoleMapper.updateUserRole(userRole);		
	}
	
	public List<UserRole> findUserRolePage(UserRoleCond cond) throws RuntimeException {
		int recordCount = userRoleMapper.findUserRoleCount(cond);
		
		cond.recordCount = recordCount;
				
		return userRoleMapper.findUserRolePage(cond);
	}

	@Override
	public List<UserRole> findUserRoleByUserId(int id) throws RuntimeException {
		return userRoleMapper.findUserRoleByUserId(id);
	}


	@Override
	public void deleteUserRoleByUserIdAndRoleId(UserRole userRole)
			throws RuntimeException {
		userRoleMapper.deleteUserRoleByUserIdAndRoleId(userRole);
		
	}

	public List<Integer> findProjectIdsByUserPriv(UserRoleCond cond) throws RuntimeException {	
		List<Integer> listProjectIds = new ArrayList<Integer>();
		listProjectIds = userRoleMapper.findProjectIdsByUserPriv(cond);
		List<Integer> listCompanyIds = findCompanyIdsByUserPriv_All(cond);
		if(listCompanyIds!=null && listCompanyIds.size()>0){
			List<Integer> listProjectIdsByCompany = PermissionUtils.getCompanyAllProjectIdsByCompanys(listCompanyIds) ;
			if(listProjectIdsByCompany!=null){
				for(int i=0;i<listProjectIdsByCompany.size();i++){
					if(!listProjectIds.contains(listProjectIdsByCompany.get(i))){
						listProjectIds.add(listProjectIdsByCompany.get(i));
					}			
				}
			}
		}
		
		return listProjectIds;
	}


	public List<Integer> findCompanyIdsByUserPriv(UserRoleCond cond) throws RuntimeException {				
		return userRoleMapper.findCompanyIdsByUserPriv(cond);
	}
	
	public List<Integer> findCompanyIdsByUserPriv_All(UserRoleCond cond) throws RuntimeException {				
		return userRoleMapper.findCompanyIdsByUserPriv_All(cond);
	}
	
	//for guangzhou
	@Override
	public void deleteUserRoleByUserIdAndRoleIdAndProjectId(UserRole userRole){
		userRoleMapper.deleteUserRoleByUserIdAndRoleIdAndProjectId(userRole);
	}
	@Override
	public List<UserAccount> findRoleByCond(UserRoleCond cond)
			throws RuntimeException {
		return userRoleMapper.findRoleByCond(cond);
	}
	
	@Override
	public int findRoleByCondCount(UserRoleCond cond) throws RuntimeException {
		return userRoleMapper.findRoleByCondCount(cond);
	}
	
	@Override
	public void replaceRole(UserRoleCond cond) throws RuntimeException {
		userRoleMapper.replaceRole(cond);
	}
	
	@Override
	public List<Integer> findProjectIdByRoleIdAndUserId(UserRoleCond cond)
			throws RuntimeException {
		return userRoleMapper.findProjectIdByRoleIdAndUserId(cond);
	}
}
