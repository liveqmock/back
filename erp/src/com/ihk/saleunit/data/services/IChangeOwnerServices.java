package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ChangeOwner;
import com.ihk.saleunit.data.pojo.ChangeOwnerCond;

/**
 * ChangeOwner的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IChangeOwnerServices {
	/**
	 * 新增ChangeOwner
	 * @param changeOwner
	 */
	public void addChangeOwner(ChangeOwner changeOwner) throws RuntimeException;

	/**
	 * 删除一条ChangeOwner
	 * @param id
	 */
	public void deleteChangeOwner(int id) throws RuntimeException;

	/**
	 * 修改ChangeOwner
	 * @param changeOwner
	 */
	public void updateChangeOwner(ChangeOwner changeOwner) throws RuntimeException;

	/**
	 * 查找一条ChangeOwner
	 * @return ChangeOwner
	 * @param id 主键id
	 */
	public ChangeOwner findChangeOwnerById(int id) throws RuntimeException;

	/**
	 * 分页查找ChangeOwner
	 * @param cond 查询条件
	 * @return ChangeOwner列表
	 */
	public List<ChangeOwner> findChangeOwnerPage(ChangeOwnerCond cond) throws RuntimeException;

	/**
	 * 查找全部ChangeOwner
	 * @param cond 查询条件
	 * @return ChangeOwner列表
	 */
	public List<ChangeOwner> findChangeOwner(ChangeOwnerCond cond) throws RuntimeException;
}