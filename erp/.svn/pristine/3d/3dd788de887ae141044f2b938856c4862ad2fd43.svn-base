package com.ihk.customer.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.data.pojo.CustomerFocus;
import com.ihk.customer.data.pojo.CustomerFocusCond;

/**
 * CustomerFocus的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ICustomerFocusServices {
	/**
	 * 新增CustomerFocus
	 * @param customerFocus
	 */
	public void addCustomerFocus(CustomerFocus customerFocus) throws RuntimeException;

	/**
	 * 删除一条CustomerFocus
	 * @param id
	 */
	public void deleteCustomerFocus(int id) throws RuntimeException;

	/**
	 * 修改CustomerFocus
	 * @param customerFocus
	 */
	public void updateCustomerFocus(CustomerFocus customerFocus) throws RuntimeException;

	/**
	 * 查找一条CustomerFocus
	 * @return CustomerFocus
	 * @param id 主键id
	 */
	public CustomerFocus findCustomerFocusById(int id) throws RuntimeException;

	/**
	 * 分页查找CustomerFocus
	 * @param cond 查询条件
	 * @return CustomerFocus列表
	 */
	public List<CustomerFocus> findCustomerFocusPage(CustomerFocusCond cond) throws RuntimeException;

	/**
	 * 查找全部CustomerFocus
	 * @param cond 查询条件
	 * @return CustomerFocus列表
	 */
	public List<CustomerFocus> findCustomerFocus(CustomerFocusCond cond) throws RuntimeException;
	
	/**
	 * 跟进客户id获取对应的关注点
	 * @param id
	 * @return
	 */
	public List<CustomerFocus> findCustomerFocusByCustomerId(int id); //跟进客户id获取对应的关注点
	
	/**
	 * 根据customer id删除
	 * @param id
	 */
	public void deleteCustomerFocusByCusotmerId(int id); //根据customer id删除
}