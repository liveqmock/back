package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.CustomerEvent;
import com.ihk.saleunit.data.pojo.CustomerEventCond;

/**
 * CustomerEvent的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface ICustomerEventServices {
	/**
	 * 新增CustomerEvent
	 * @param customerEvent
	 */
	public void addCustomerEvent(CustomerEvent customerEvent) throws RuntimeException;

	/**
	 * 删除一条CustomerEvent
	 * @param id
	 */
	public void deleteCustomerEvent(int id) throws RuntimeException;

	/**
	 * 修改CustomerEvent
	 * @param customerEvent
	 */
	public void updateCustomerEvent(CustomerEvent customerEvent) throws RuntimeException;

	/**
	 * 查找一条CustomerEvent
	 * @return CustomerEvent
	 * @param id 主键id
	 */
	public CustomerEvent findCustomerEventById(int id) throws RuntimeException;

	/**
	 * 分页查找CustomerEvent
	 * @param cond 查询条件
	 * @return CustomerEvent列表
	 */
	public List<CustomerEvent> findCustomerEventPage(CustomerEventCond cond) throws RuntimeException;

	/**
	 * 查找全部CustomerEvent
	 * @param cond 查询条件
	 * @return CustomerEvent列表
	 */
	public List<CustomerEvent> findCustomerEvent(CustomerEventCond cond) throws RuntimeException;
}