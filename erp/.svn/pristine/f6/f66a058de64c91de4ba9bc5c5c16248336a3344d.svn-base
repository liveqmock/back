package com.ihk.customer.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.data.ICustomerFocusMapper;
import com.ihk.customer.data.pojo.CustomerFocus;
import com.ihk.customer.data.pojo.CustomerFocusCond;
import com.ihk.customer.data.services.ICustomerFocusServices;

/**
 * CustomerFocus的Services实现(业务实现)
 * @author 
 *
 */
@Service("customerFocusServices")
public class CustomerFocusServices implements ICustomerFocusServices {
	/**
	 * customerFocus数据访问接口
	 */
	@Autowired	 ICustomerFocusMapper customerFocusMapper;

	/**
	 * 删除一条CustomerFocus
	 * @param id
	 */
	public void deleteCustomerFocus(int id) throws RuntimeException {
		customerFocusMapper.deleteCustomerFocus(id);
	}

	/**
	 * 新增CustomerFocus
	 * @param customerFocus
	 */
	public void addCustomerFocus(CustomerFocus customerFocus) throws RuntimeException {		
		customerFocusMapper.addCustomerFocus(customerFocus);
	}

	/**
	 * 查找一条CustomerFocus
	 * @return CustomerFocus
	 * @param id 主键id
	 */
	@Override
	public CustomerFocus findCustomerFocusById(int id) throws RuntimeException {
		return customerFocusMapper.findCustomerFocusById(id);
	}

	/**
	 * 修改CustomerFocus
	 * @param customerFocus
	 */
	@Override
	public void updateCustomerFocus(CustomerFocus customerFocus) throws RuntimeException {
		customerFocusMapper.updateCustomerFocus(customerFocus);		
	}

	/**
	 * 分页查找CustomerFocus
	 * @param cond 查询条件
	 * @return CustomerFocus列表
	 */
	public List<CustomerFocus> findCustomerFocusPage(CustomerFocusCond cond) throws RuntimeException {
		int recordCount = customerFocusMapper.findCustomerFocusCount(cond);
		
		cond.recordCount = recordCount;
				
		return customerFocusMapper.findCustomerFocusPage(cond);
	}

	/**
	 * 查找全部CustomerFocus
	 * @param cond 查询条件
	 * @return CustomerFocus列表
	 */
	public List<CustomerFocus> findCustomerFocus(CustomerFocusCond cond) throws RuntimeException {
    	return customerFocusMapper.findCustomerFocus(cond);
	}

	/**
	 * 根据customerId进行查找
	 */
	@Override
	public List<CustomerFocus> findCustomerFocusByCustomerId(int id) {
		return customerFocusMapper.findCustomerFocusByCustomerId(id);
	}

	/**
	 * 根据customerId进行删除
	 */
	@Override
	public void deleteCustomerFocusByCusotmerId(int id) {
		customerFocusMapper.deleteCustomerFocusByCusotmerId(id);
	}
}
