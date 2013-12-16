package com.ihk.customer.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.data.pojo.CustomerRed;
import com.ihk.customer.data.pojo.CustomerRedCond;

/**
 * CustomerRed的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ICustomerRedServices {
	/**
	 * 新增CustomerRed
	 * @param customerRed
	 */
	public void addCustomerRed(CustomerRed customerRed) throws RuntimeException;

	/**
	 * 删除一条CustomerRed
	 * @param id
	 */
	public void deleteCustomerRed(int id) throws RuntimeException;

	/**
	 * 修改CustomerRed
	 * @param customerRed
	 */
	public void updateCustomerRed(CustomerRed customerRed) throws RuntimeException;

	/**
	 * 查找一条CustomerRed
	 * @return CustomerRed
	 * @param id 主键id
	 */
	public CustomerRed findCustomerRedById(int id) throws RuntimeException;

	/**
	 * 分页查找CustomerRed
	 * @param cond 查询条件
	 * @return CustomerRed列表
	 */
	public List<CustomerRed> findCustomerRedPage(CustomerRedCond cond) throws RuntimeException;

	/**
	 * 查找全部CustomerRed
	 * @param cond 查询条件
	 * @return CustomerRed列表
	 */
	public List<CustomerRed> findCustomerRed(CustomerRedCond cond) throws RuntimeException;
	
	
	/**
	 * 约定  project_Id 在is_deleted=0 的情况下 是唯一的
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public CustomerRed findCustomerRedByProjectId(int projectId) throws RuntimeException;
	
	/**
	 * 查找客户标红，转换成map返回
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public Map<String, String> findCustomerRedByProjectIdForMap(int projectId) throws RuntimeException;
}