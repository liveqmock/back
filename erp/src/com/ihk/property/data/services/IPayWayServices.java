package com.ihk.property.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.PayWay;
import com.ihk.property.data.pojo.PayWayCond;

/**
 * PayWay的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IPayWayServices {

	/**
	 * 新增PayWay
	 * @param payWay
	 */
	public void addPayWay(PayWay payWay) throws RuntimeException;

	/**
	 * 删除一条PayWay
	 * @param id
	 */
	public void deletePayWay(int id) throws RuntimeException;

	/**
	 * 修改PayWay
	 * @param payWay
	 */
	public void updatePayWay(PayWay payWay) throws RuntimeException;

	/**
	 * 查找一条PayWay
	 * @return PayWay
	 * @param id 主键id
	 */
	public PayWay findPayWayById(int id) throws RuntimeException;

	/**
	 * 分页查找PayWay
	 * @param cond 查询条件
	 * @return PayWay列表
	 */
	public List<PayWay> findPayWayPage(PayWayCond cond) throws RuntimeException;

	/**
	 * 查找全部PayWay
	 * @param cond 查询条件
	 * @return PayWay列表
	 */
	public List<PayWay> findPayWay(PayWayCond cond) throws RuntimeException;
	
	/*
	 * KN
	 * */
	public PayWay findPayWayByNameAndProId(Map p ) throws RuntimeException;
}