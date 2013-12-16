package com.ihk.customer.data.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.data.ICustomerRedMapper;
import com.ihk.customer.data.pojo.CustomerRed;
import com.ihk.customer.data.pojo.CustomerRedCond;
import com.ihk.customer.data.services.ICustomerRedServices;

/**
 * CustomerRed的Services实现(业务实现)
 * @author 
 *
 */
@Service("customerRedServices")
public class CustomerRedServices implements ICustomerRedServices {
	/**
	 * customerRed数据访问接口
	 */
	@Autowired	 ICustomerRedMapper customerRedMapper;

	/**
	 * 删除一条CustomerRed
	 * @param id
	 */
	public void deleteCustomerRed(int id) throws RuntimeException {
		customerRedMapper.deleteCustomerRed(id);
	}

	/**
	 * 新增CustomerRed
	 * @param customerRed
	 */
	public void addCustomerRed(CustomerRed customerRed) throws RuntimeException {		
		customerRedMapper.addCustomerRed(customerRed);
	}

	/**
	 * 查找一条CustomerRed
	 * @return CustomerRed
	 * @param id 主键id
	 */
	@Override
	public CustomerRed findCustomerRedById(int id) throws RuntimeException {
		return customerRedMapper.findCustomerRedById(id);
	}

	/**
	 * 修改CustomerRed
	 * @param customerRed
	 */
	@Override
	public void updateCustomerRed(CustomerRed customerRed) throws RuntimeException {
		customerRedMapper.updateCustomerRed(customerRed);		
	}

	/**
	 * 分页查找CustomerRed
	 * @param cond 查询条件
	 * @return CustomerRed列表
	 */
	public List<CustomerRed> findCustomerRedPage(CustomerRedCond cond) throws RuntimeException {
		int recordCount = customerRedMapper.findCustomerRedCount(cond);
		
		cond.recordCount = recordCount;
				
		return customerRedMapper.findCustomerRedPage(cond);
	}

	/**
	 * 查找全部CustomerRed
	 * @param cond 查询条件
	 * @return CustomerRed列表
	 */
	public List<CustomerRed> findCustomerRed(CustomerRedCond cond) throws RuntimeException {
    	return customerRedMapper.findCustomerRed(cond);
	}

	/**
	 * 根据projectId查找CustomerRed
	 */
	@Override
	public CustomerRed findCustomerRedByProjectId(int projectId) throws RuntimeException {
		return customerRedMapper.findCustomerRedByProjectId(projectId);
	}

	/**
	 * 根据projectId查找CustomerRed
	 * 转换成Map
	 */
	@Override
	public Map<String, String> findCustomerRedByProjectIdForMap(int projectId)
			throws RuntimeException {
		return customerRedMapper.findCustomerRedByProjectIdForMap(projectId);
	}
}
