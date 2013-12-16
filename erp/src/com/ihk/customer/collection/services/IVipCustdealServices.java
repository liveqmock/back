package com.ihk.customer.collection.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.collection.pojo.VipCustdeal;
import com.ihk.customer.collection.pojo.VipCustdealCond;

/**
 * VipCustdeal的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IVipCustdealServices {

	/**
	 * 新增VipCustdeal
	 * @param vipCustdeal
	 */
	public void addVipCustdeal(VipCustdeal vipCustdeal) throws RuntimeException;

	/**
	 * 删除一条VipCustdeal
	 * @param id
	 */
	public void deleteVipCustdeal(int id) throws RuntimeException;

	/**
	 * 修改VipCustdeal
	 * @param vipCustdeal
	 */
	public void updateVipCustdeal(VipCustdeal vipCustdeal) throws RuntimeException;

	/**
	 * 查找一条VipCustdeal
	 * @return VipCustdeal
	 * @param id 主键id
	 */
	public VipCustdeal findVipCustdealById(int id) throws RuntimeException;
    
	/**
	 * 查找符合条件的记录条数VipCustdeal
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findVipCustdealCount(VipCustdealCond cond) throws RuntimeException;
	
	/**
	 * 分页查找VipCustdeal
	 * @param cond 查询条件
	 * @return VipCustdeal列表
	 */
	public List<VipCustdeal> findVipCustdealPage(VipCustdealCond cond) throws RuntimeException;
    
	/**
	 * 查找全部VipCustdeal
	 * @param cond 查询条件
	 * @return VipCustdeal列表
	 */
	public List<VipCustdeal> findVipCustdeal(VipCustdealCond cond) throws RuntimeException;
	
	/**
	 * 统计符合条件的结果
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> findVipCustdealgroup(VipCustdealCond cond) throws RuntimeException;
	
	/**
	 * 统计符合条件的结果
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> findVipCustdealCustIdgroup(VipCustdealCond cond);
	/**
	 * 查询详细
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map> findVipCustAndDeal(VipCustdealCond cond) throws RuntimeException;
}