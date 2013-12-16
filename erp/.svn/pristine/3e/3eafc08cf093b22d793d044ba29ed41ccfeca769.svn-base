package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ArAmount;
import com.ihk.saleunit.data.pojo.ArAmountCond;

/**
 * ArAmount的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IArAmountServices {

	/**
	 * 新增ArAmount
	 * @param arAmount
	 */
	public void addArAmount(ArAmount arAmount) throws RuntimeException;

	/**
	 * 删除一条ArAmount
	 * @param id
	 */
	public void deleteArAmount(int id) throws RuntimeException;

	/**
	 * 修改ArAmount
	 * @param arAmount
	 */
	public void updateArAmount(ArAmount arAmount) throws RuntimeException;

	/**
	 * 查找一条ArAmount
	 * @return ArAmount
	 * @param id 主键id
	 */
	public ArAmount findArAmountById(int id) throws RuntimeException;
    
	/**
	 * 查找总记录
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public int findArAmountCount(ArAmountCond cond) throws RuntimeException;
	
	/**
	 * 分页查找ArAmount
	 * @param cond 查询条件
	 * @return ArAmount列表
	 */
	public List<ArAmount> findArAmountPage(ArAmountCond cond) throws RuntimeException;
    
	/**
	 * 查找全部ArAmount
	 * @param cond 查询条件
	 * @return ArAmount列表
	 */
	public List<ArAmount> findArAmount(ArAmountCond cond) throws RuntimeException;
}