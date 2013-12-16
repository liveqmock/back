package com.ihk.customer.data.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.data.pojo.CustomerKnown;
import com.ihk.customer.data.pojo.CustomerKnownCond;

/**
 * CustomerKnown的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ICustomerKnownServices extends Serializable {
	/**
	 * 新增CustomerKnown
	 * @param customerKnown
	 */
	public void addCustomerKnown(CustomerKnown customerKnown) throws RuntimeException;

	/**
	 * 删除一条CustomerKnown
	 * @param id
	 */
	public void deleteCustomerKnown(int id) throws RuntimeException;

	/**
	 * 修改CustomerKnown
	 * @param customerKnown
	 */
	public void updateCustomerKnown(CustomerKnown customerKnown) throws RuntimeException;

	/**
	 * 查找一条CustomerKnown
	 * @return CustomerKnown
	 * @param id 主键id
	 */
	public CustomerKnown findCustomerKnownById(int id) throws RuntimeException;

	/**
	 * 分页查找CustomerKnown
	 * @param cond 查询条件
	 * @return CustomerKnown列表
	 */
	@SuppressWarnings("rawtypes")
	public List findCustomerKnownPage(CustomerKnownCond cond) throws RuntimeException;
	
	/**
	 * 跟进客户id来查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<CustomerKnown> findCustomerKnownByCustomerId(int id) throws Exception;
	
	/**
	 * 根据客户id进行删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteCustomerKnownByCustomerId(int id) throws Exception;
}