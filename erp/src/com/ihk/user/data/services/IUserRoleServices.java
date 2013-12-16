package com.ihk.user.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.pojo.UserRoleCond;

/**
 * UserRole的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IUserRoleServices {
	/**
	 * 新增UserRole
	 * @param userRole
	 */
	public void addUserRole(UserRole userRole) throws RuntimeException;

	/**
	 * 删除一条UserRole
	 * @param id
	 */
	public void deleteUserRole(int id) throws RuntimeException;

	/**
	 * 修改UserRole
	 * @param userRole
	 */
	public void updateUserRole(UserRole userRole) throws RuntimeException;
	
	/**
	 * 删除
	 * @param userRole
	 * @throws RuntimeException
	 */
	public void deleteUserRoleByUserIdAndRoleId(UserRole userRole) throws RuntimeException;

	/**
	 * 查找一条UserRole
	 * @return UserRole
	 * @param id 主键id
	 */
	public UserRole findUserRoleById(int id) throws RuntimeException;
    
	/**
	 * 查找，分页
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<UserRole> findUserRolePage(UserRoleCond cond) throws RuntimeException;
	
	/**
	 * 查找用户的 角色
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<UserRole> findUserRoleByUserId(int id) throws RuntimeException;

	/**
	 * 根据权限查找项目id列表
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Integer> findProjectIdsByUserPriv(UserRoleCond cond) throws RuntimeException; //跟进用户与权限去查项目id(包括公司递归)
	
	/**
	 * 根据权限查找公司id列表
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Integer> findCompanyIdsByUserPriv(UserRoleCond cond) throws RuntimeException;//跟进用户与权限去查公司id

	/**
	 * 根据权限查找公司id列表
	 * 只查询project_id=0,该公司所有项目的权限
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Integer> findCompanyIdsByUserPriv_All(UserRoleCond cond) throws RuntimeException;//跟进用户与权限去查公司id
	
	/**
	 * 删除用户角色
	 * @param userRole
	 */
	public void deleteUserRoleByUserIdAndRoleIdAndProjectId(UserRole userRole);
	
	/**
	 * 根据条件查看用户列表	
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<UserAccount> findRoleByCond(UserRoleCond cond)throws RuntimeException;
	/**
	 * 根据条件查看用户列表条目	
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public int findRoleByCondCount(UserRoleCond cond)throws RuntimeException;
	
	/**
	 * 替换角色
	 * @param userRole
	 * @throws RuntimeException
	 */
	public void replaceRole(UserRoleCond cond)throws RuntimeException;
	
	
	/**
	 * 根据用户Id,角色Id查找拥有的项目id列表
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Integer> findProjectIdByRoleIdAndUserId(UserRoleCond cond) throws RuntimeException;
}