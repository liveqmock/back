package com.ihk.user.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.RoleCond;

/**
 * Role的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IRoleServices {
	/**
	 * 新增Role
	 * @param role
	 */
	public void addRole(Role role) throws RuntimeException;

	/**
	 * 删除一条Role
	 * @param id
	 */
	public void deleteRole(int id) throws RuntimeException;

	/**
	 * 修改Role
	 * @param role
	 */
	public void updateRole(Role role) throws RuntimeException;

	/**
	 * 查找一条Role
	 * @return Role
	 * @param id 主键id
	 */
	public Role findRoleById(int id) throws RuntimeException;

	/**
	 * 分页查找Role
	 * @param cond 查询条件
	 * @return Role列表
	 */
	public List<Role> findRolePage(RoleCond cond) throws RuntimeException;

	/**
	 * 查找全部Role
	 * @return Role列表
	 */
	public List<Role> findRole() throws Exception;
	
	/**
	 * 根据name 查找
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Role> findRolesLikeName(String name) throws Exception;
}