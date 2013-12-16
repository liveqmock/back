package com.ihk.customer.collection.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.collection.pojo.VipCustomer;
import com.ihk.customer.collection.pojo.VipCustomerCond;

/**
 * VipCustomer的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IVipCustomerServices {

	/**
	 * 新增VipCustomer
	 * @param vipCustomer
	 */
	public void addVipCustomer(VipCustomer vipCustomer) throws RuntimeException;

	/**
	 * 删除一条VipCustomer
	 * @param id
	 */
	public void deleteVipCustomer(int id) throws RuntimeException;

	/**
	 * 修改VipCustomer
	 * @param vipCustomer
	 */
	public void updateVipCustomer(VipCustomer vipCustomer) throws RuntimeException;

	/**
	 * 查找一条VipCustomer
	 * @return VipCustomer
	 * @param id 主键id
	 */
	public VipCustomer findVipCustomerById(int id) throws RuntimeException;
    
	/**
	 * 分页查找VipCustomer
	 * @param cond 查询条件
	 * @return VipCustomer列表
	 */
	public List<VipCustomer> findVipCustomerPage(VipCustomerCond cond) throws RuntimeException;
    
	/**
	 * 查找全部VipCustomer
	 * @param cond 查询条件
	 * @return VipCustomer列表
	 */
	public List<VipCustomer> findVipCustomer(VipCustomerCond cond) throws RuntimeException;
}