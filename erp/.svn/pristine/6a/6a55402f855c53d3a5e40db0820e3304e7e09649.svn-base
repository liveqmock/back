package com.ihk.customer.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.data.ICustomerKnownMapper;
import com.ihk.customer.data.pojo.CustomerKnown;
import com.ihk.customer.data.pojo.CustomerKnownCond;
import com.ihk.customer.data.services.ICustomerKnownServices;

/**
 * CustomerKnown的Services实现(业务实现)
 * @author 
 *
 */
@Service("customerKnownServices")
@SuppressWarnings("unchecked")
public class CustomerKnownServices implements ICustomerKnownServices {
	/**
	 * customerKnown数据访问接口
	 */
	@Autowired	 ICustomerKnownMapper customerKnownMapper;

	/**
	 * 删除一条CustomerKnown
	 * @param id
	 */
	public void deleteCustomerKnown(int id) throws RuntimeException {
		customerKnownMapper.deleteCustomerKnown(id);
	}

	/**
	 * 新增CustomerKnown
	 * @param customerKnown
	 */
	public void addCustomerKnown(CustomerKnown customerKnown) throws RuntimeException {		
		customerKnownMapper.addCustomerKnown(customerKnown);
	}

	/**
	 * 查找一条CustomerKnown
	 * @return CustomerKnown
	 * @param id 主键id
	 */
	@Override
	public CustomerKnown findCustomerKnownById(int id) throws RuntimeException {
		return customerKnownMapper.findCustomerKnownById(id);
	}

	/**
	 * 修改CustomerKnown
	 * @param customerKnown
	 */
	@Override
	public void updateCustomerKnown(CustomerKnown customerKnown) throws RuntimeException {
		customerKnownMapper.updateCustomerKnown(customerKnown);		
	}

	/**
	 * 分页查找CustomerKnown
	 * @param cond 查询条件
	 * @return CustomerKnown列表
	 */
	public List findCustomerKnownPage(CustomerKnownCond cond) throws RuntimeException {
		int recordCount = customerKnownMapper.findCustomerKnownCount(cond);
		
		cond.recordCount = recordCount;
				
		return customerKnownMapper.findCustomerKnownPage(cond);
	}

	/**
	 * 根据customerId进行查找
	 */
	@Override
	public List<CustomerKnown> findCustomerKnownByCustomerId(int id)
			throws Exception {
		return customerKnownMapper.findCustomerKnownByCustomerId(id);
	}

	/**
	 * 根据customerId进行删除
	 */
	@Override
	public void deleteCustomerKnownByCustomerId(int id) throws Exception {
		customerKnownMapper.deleteCustomerKnownByCustomerId(id);
	}
}
