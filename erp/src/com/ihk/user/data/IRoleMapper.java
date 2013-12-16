package com.ihk.user.data;

import java.util.List;

import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.RoleCond;

/**
 * Role数据访问接口Mapper
 * @author 
 *
 */ 
public interface IRoleMapper {

	/**
	 * 新增Role
	 * @param role
	 */
	public void addRole(Role role) ;

	/**
	 * 根据条件删除Role
	 * @param id 删除条件
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
	public List<Role> findRolePage(RoleCond cond) ;

	/**
	 * 查找符合条件的记录条数Role
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findRoleCount(RoleCond cond) ;

	/**
	 * 查找全部Role
	 * @return Role列表
	 */
	public List<Role> findRole();
	
	/**
	 * 根据 name查找
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Role> findRolesLikeName(String name) throws Exception;
}
