package com.ihk.customer.collection.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.collection.pojo.VipCustFollow;
import com.ihk.customer.collection.pojo.VipCustFollowCond;

/**
 * VipCustFollow的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IVipCustFollowServices {

	/**
	 * 新增VipCustFollow
	 * @param vipCustFollow
	 */
	public void addVipCustFollow(VipCustFollow vipCustFollow) throws RuntimeException;

	/**
	 * 删除一条VipCustFollow
	 * @param id
	 */
	public void deleteVipCustFollow(int id) throws RuntimeException;

	/**
	 * 修改VipCustFollow
	 * @param vipCustFollow
	 */
	public void updateVipCustFollow(VipCustFollow vipCustFollow) throws RuntimeException;

	/**
	 * 查找一条VipCustFollow
	 * @return VipCustFollow
	 * @param id 主键id
	 */
	public VipCustFollow findVipCustFollowById(int id) throws RuntimeException;
    
	/**
	 * 分页查找VipCustFollow
	 * @param cond 查询条件
	 * @return VipCustFollow列表
	 */
	public List<VipCustFollow> findVipCustFollowPage(VipCustFollowCond cond) throws RuntimeException;
    
	/**
	 * 查找全部VipCustFollow
	 * @param cond 查询条件
	 * @return VipCustFollow列表
	 */
	public List<VipCustFollow> findVipCustFollow(VipCustFollowCond cond) throws RuntimeException;
}