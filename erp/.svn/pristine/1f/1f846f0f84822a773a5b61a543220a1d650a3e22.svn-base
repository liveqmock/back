package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ChangeOut;
import com.ihk.saleunit.data.pojo.ChangeOutCond;

/**
 * ChangeOut的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IChangeOutServices {
	/**
	 * 新增ChangeOut
	 * @param changeOut
	 */
	public void addChangeOut(ChangeOut changeOut) throws RuntimeException;

	/**
	 * 删除一条ChangeOut
	 * @param id
	 */
	public void deleteChangeOut(int id) throws RuntimeException;

	/**
	 * 修改ChangeOut
	 * @param changeOut
	 */
	public void updateChangeOut(ChangeOut changeOut) throws RuntimeException;

	/**
	 * 查找一条ChangeOut
	 * @return ChangeOut
	 * @param id 主键id
	 */
	public ChangeOut findChangeOutById(int id) throws RuntimeException;

	/**
	 * 分页查找ChangeOut
	 * @param cond 查询条件
	 * @return ChangeOut列表
	 */
	public List<ChangeOut> findChangeOutPage(ChangeOutCond cond) throws RuntimeException;

	/**
	 * 查找全部ChangeOut
	 * @param cond 查询条件
	 * @return ChangeOut列表
	 */
	public List<ChangeOut> findChangeOut(ChangeOutCond cond) throws RuntimeException;
}