package com.ihk.customer.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.data.pojo.CustomerLog;
import com.ihk.customer.data.pojo.CustomerLogCond;

/**
 * CustomerLog的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ICustomerLogServices {
	/**
	 * 新增CustomerLog
	 * @param customerLog
	 */
	public void addCustomerLog(CustomerLog customerLog) throws RuntimeException;

	/**
	 * 删除一条CustomerLog
	 * @param id
	 */
	public void deleteCustomerLog(int id) throws RuntimeException;

	/**
	 * 修改CustomerLog
	 * @param customerLog
	 */
	public void updateCustomerLog(CustomerLog customerLog) throws RuntimeException;

	/**
	 * 查找一条CustomerLog
	 * @return CustomerLog
	 * @param id 主键id
	 */
	public CustomerLog findCustomerLogById(int id) throws RuntimeException;

	/**
	 * 分页查找CustomerLog
	 * @param cond 查询条件
	 * @return CustomerLog列表
	 */
	public List<CustomerLog> findCustomerLogPage(CustomerLogCond cond) throws RuntimeException;

	/**
	 * 查找全部CustomerLog
	 * @param cond 查询条件
	 * @return CustomerLog列表
	 */
	public List<CustomerLog> findCustomerLog(CustomerLogCond cond) throws RuntimeException;
	
	/**
	 * 添加客户到客户修改日志
	 * @param customerId
	 * @throws RuntimeException
	 */
	public void addCustomerToCustomerLog(int customerId) throws RuntimeException;
}