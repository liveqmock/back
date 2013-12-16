package com.ihk.customer.collection.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.collection.pojo.VipCust;
import com.ihk.customer.collection.pojo.VipCustCond;


/**
 * VipCust的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IVipCustServices {

	/**
	 * 新增VipCust
	 * @param vipCust
	 */
	public int addVipCust(VipCust vipCust) throws RuntimeException;

	/**
	 * 删除一条VipCust
	 * @param id
	 */
	public void deleteVipCust(int id) throws RuntimeException;

	/**
	 * 修改VipCust
	 * @param vipCust
	 */
	public void updateVipCust(VipCust vipCust) throws RuntimeException;

	/**
	 * 查找一条VipCust
	 * @return VipCust
	 * @param id 主键id
	 */
	public VipCust findVipCustById(int id) throws RuntimeException;
    
	/**
	 * 分页查找VipCust
	 * @param cond 查询条件
	 * @return VipCust列表
	 */
	public List<VipCust> findVipCustPage(VipCustCond cond) throws RuntimeException;
    
	/**
	 * 查找全部VipCust
	 * @param cond 查询条件
	 * @return VipCust列表
	 */
	public List<VipCust> findVipCust(VipCustCond cond) throws RuntimeException;
}