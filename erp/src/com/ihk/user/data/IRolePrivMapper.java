package com.ihk.user.data;

import java.util.List;
import java.util.Map;

import com.ihk.user.data.pojo.RolePriv;
import com.ihk.user.data.pojo.RolePrivCond;

/**
 * RolePriv数据访问接口Mapper
 * @author 
 *
 */ 
public interface IRolePrivMapper {

	/**
	 * 新增RolePriv
	 * @param rolePriv
	 */
	public void addRolePriv(RolePriv rolePriv) ;

	/**
	 * 根据条件删除RolePriv
	 * @param cond 删除条件
	 */
	public void deleteRolePriv(int id) throws RuntimeException;
	public void deleteRolePrivByRoleId(int id) throws RuntimeException;

	/**
	 * 修改RolePriv
	 * @param rolePriv
	 */
	public void updateRolePriv(RolePriv rolePriv) throws RuntimeException;

	/**
	 * 查找一条RolePriv
	 * @return RolePriv
	 * @param id 主键id
	 */
	public RolePriv findRolePrivById(int id) throws RuntimeException;

	public List<RolePriv> findRolePrivByRoleId(int roleId) throws RuntimeException;

	/**
	 * 分页查找RolePriv
	 * @param cond 查询条件
	 * @return RolePriv列表
	 */
	public List<RolePriv> findRolePrivPage(RolePrivCond cond) ;

	/**
	 * 查找符合条件的记录条数RolePriv
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findRolePrivCount(RolePrivCond cond) ;

	/**
	 * 查找全部RolePriv
	 * @param cond 查询条件
	 * @return RolePriv列表
	 */
	public List<RolePriv> findAll() ;
	
	/**
	 * 根据roleId删除
	 * @param pr
	 * @throws RuntimeException
	 */
	public void delBy_roleId_roleCode(RolePriv pr)throws RuntimeException;
	
	/**
	 * 查找
	 * @param pr
	 * @return
	 */
	public int findBy_roleId_roleCode(RolePriv pr);
	
	/**
	 * 查找
	 * @return
	 */
	public List<Map<String,String>> find_roleId_roleName_isHavePriv();
	
	/**
	 * 根据role_name查找
	 * @param hoo
	 * @return
	 */
	public List<Map<String,String>> find_roleId_roleName_likeRoleName(String hoo);
	
	/**
	 * 查找有权限的数量
	 * @return
	 */
	public int find_roleId_roleName_isHavePriv_count();
}
