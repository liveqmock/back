package com.ihk.user.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.user.data.pojo.RolePriv;
import com.ihk.user.data.pojo.RolePrivCond;

/**
 * RolePriv的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IRolePrivServices {
	/**
	 * 新增RolePriv
	 * @param rolePriv
	 */
	public void addRolePriv(RolePriv rolePriv) throws RuntimeException;

	/**
	 * 删除一条RolePriv
	 * @param id
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

    public  List<RolePriv> findRolePrivByRoleId(int roleId) throws RuntimeException;
	/**
	 * 分页查找RolePriv
	 * @param cond 查询条件
	 * @return RolePriv列表
	 */
	public List findRolePrivPage(RolePrivCond cond) throws RuntimeException;
}