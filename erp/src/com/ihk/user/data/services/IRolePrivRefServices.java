package com.ihk.user.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.user.data.pojo.RolePrivRef;
import com.ihk.user.data.pojo.RolePrivRefCond;

/**
 * RolePrivRef的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IRolePrivRefServices {
	/**
	 * 新增RolePrivRef
	 * @param rolePrivRef
	 */
	public void addRolePrivRef(RolePrivRef rolePrivRef) throws RuntimeException;

	/**
	 * 删除一条RolePrivRef
	 * @param id
	 */
	public void deleteRolePrivRef(int id) throws RuntimeException;

	/**
	 * 修改RolePrivRef
	 * @param rolePrivRef
	 */
	public void updateRolePrivRef(RolePrivRef rolePrivRef) throws RuntimeException;

	/**
	 * 查找一条RolePrivRef
	 * @return RolePrivRef
	 * @param id 主键id
	 */
	public RolePrivRef findRolePrivRefById(int id) throws RuntimeException;

	/**
	 * 分页查找RolePrivRef
	 * @param cond 查询条件
	 * @return RolePrivRef列表
	 */
	public List<RolePrivRef> findRolePrivRefPage(RolePrivRefCond cond) throws RuntimeException;

	/**
	 * 查找全部RolePrivRef
	 * @param cond 查询条件
	 * @return RolePrivRef列表
	 */
	public List<RolePrivRef> findAll()throws RuntimeException;
	
	/**
	 * 查找，记录数
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public int findRolePrivRefCount(RolePrivRefCond cond)throws RuntimeException;
	
}