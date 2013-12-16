package com.ihk.user.data;

import java.util.List;

import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.pojo.UserRoleCond;

/**
 * UserRole数据访问接口Mapper
 * @author 
 *
 */ 
public interface IUserRoleMapper {

	/**
	 * 新增UserRole
	 * @param userRole
	 */
	public void addUserRole(UserRole userRole) ;

	/**
	 * 根据条件删除UserRole
	 * @param cond 删除条件
	 */
	public void deleteUserRole(int id) throws RuntimeException;

	/**
	 * 根据条件删除UserRole
	 * @param cond 删除条件
	 */
	public void deleteUserRoleByUserIdAndRoleId(UserRole userRole);

	/**
	 * 根据条件删除
	 * @param userRole
	 */
	public void deleteUserRoleByCond(UserRoleCond cond);

	/**
	 * 根据条件删除UserRole
	 * @param cond 删除条件
	 */
	public void deleteUserRoleByUserIdAndRoleIdAndProjectId(UserRole userRole);

	/**
	 * 修改UserRole
	 * @param userRole
	 */
	public void updateUserRole(UserRole userRole) throws RuntimeException;

	/**
	 * 查找一条UserRole
	 * @return UserRole
	 * @param id 主键id
	 */
	public UserRole findUserRoleById(int id) throws RuntimeException;

	/**
	 * 分页查找UserRole
	 * @param cond 查询条件
	 * @return UserRole列表
	 */
	public List<UserRole> findUserRolePage(UserRoleCond cond) ;

	/**
	 * 查找符合条件的记录条数UserRole
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findUserRoleCount(UserRoleCond cond) ;
	

	/**
	 * 跟进用户与权限去查项目id(不包括公司递归)
	 * @param cond
	 * @return
	 */
	public List<Integer> findProjectIdsByUserPriv(UserRoleCond cond) ;//跟进用户与权限去查项目id(不包括公司递归)
	
	/**
	 * 根据用户与权限去查公司id
	 * @param cond
	 * @return
	 */
	public List<Integer> findCompanyIdsByUserPriv(UserRoleCond cond) ;//跟进用户与权限去查公司id
	

	/**
	 * 根据用户与权限去查公司id
	 * 该公司的所有项目的权限
	 * @param cond
	 * @return
	 */
	public List<Integer> findCompanyIdsByUserPriv_All(UserRoleCond cond) ;//跟进用户与权限去查公司id
	
	/**
	 * 根据userId查找用户角色
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<UserRole> findUserRoleByUserId(int id) throws RuntimeException;
	
	/**
	 * 根据条件查询用户
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<UserAccount> findRoleByCond(UserRoleCond cond) throws RuntimeException;
	
	/**
	 * 得到查询的条目
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public int findRoleByCondCount(UserRoleCond cond) throws RuntimeException;
	
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
