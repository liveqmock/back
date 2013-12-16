package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ChangeOwnerDetail;
import com.ihk.saleunit.data.pojo.ChangeOwnerDetailCond;

/**
 * ChangeOwnerDetail的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IChangeOwnerDetailServices {
	/**
	 * 新增ChangeOwnerDetail
	 * @param changeOwnerDetail
	 */
	public void addChangeOwnerDetail(ChangeOwnerDetail changeOwnerDetail) throws RuntimeException;

	/**
	 * 删除一条ChangeOwnerDetail
	 * @param id
	 */
	public void deleteChangeOwnerDetail(int id) throws RuntimeException;

	/**
	 * 修改ChangeOwnerDetail
	 * @param changeOwnerDetail
	 */
	public void updateChangeOwnerDetail(ChangeOwnerDetail changeOwnerDetail) throws RuntimeException;

	/**
	 * 查找一条ChangeOwnerDetail
	 * @return ChangeOwnerDetail
	 * @param id 主键id
	 */
	public ChangeOwnerDetail findChangeOwnerDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找ChangeOwnerDetail
	 * @param cond 查询条件
	 * @return ChangeOwnerDetail列表
	 */
	public List<ChangeOwnerDetail> findChangeOwnerDetailPage(ChangeOwnerDetailCond cond) throws RuntimeException;

	/**
	 * 查找全部ChangeOwnerDetail
	 * @param cond 查询条件
	 * @return ChangeOwnerDetail列表
	 */
	public List<ChangeOwnerDetail> findChangeOwnerDetail(ChangeOwnerDetailCond cond) throws RuntimeException;
}