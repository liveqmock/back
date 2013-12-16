package com.ihk.customer.collection.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.collection.pojo.VipCustItem;
import com.ihk.customer.collection.pojo.VipCustItemCond;

/**
 * VipCustItem的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IVipCustItemServices {

	/**
	 * 新增VipCustItem
	 * @param vipCustItem
	 */
	public void addVipCustItem(VipCustItem vipCustItem) throws RuntimeException;

	/**
	 * 删除一条VipCustItem
	 * @param id
	 */
	public void deleteVipCustItem(int id) throws RuntimeException;

	/**
	 * 修改VipCustItem
	 * @param vipCustItem
	 */
	public void updateVipCustItem(VipCustItem vipCustItem) throws RuntimeException;

	/**
	 * 查找一条VipCustItem
	 * @return VipCustItem
	 * @param id 主键id
	 */
	public VipCustItem findVipCustItemById(int id) throws RuntimeException;
    
	/**
	 * 分页查找VipCustItem
	 * @param cond 查询条件
	 * @return VipCustItem列表
	 */
	public List<VipCustItem> findVipCustItemPage(VipCustItemCond cond) throws RuntimeException;
    
	/**
	 * 查找全部VipCustItem
	 * @param cond 查询条件
	 * @return VipCustItem列表
	 */
	public List<VipCustItem> findVipCustItem(VipCustItemCond cond) throws RuntimeException;
}