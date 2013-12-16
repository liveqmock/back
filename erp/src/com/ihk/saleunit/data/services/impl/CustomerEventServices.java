package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.ICustomerEventMapper;
import com.ihk.saleunit.data.pojo.CustomerEvent;
import com.ihk.saleunit.data.pojo.CustomerEventCond;
import com.ihk.saleunit.data.services.ICustomerEventServices;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * CustomerEvent的Services实现(业务实现)
 * @author 
 *
 */
@Service("customerEventServices")
@SuppressWarnings("unchecked")
public class CustomerEventServices implements ICustomerEventServices {
	/**
	 * customerEvent数据访问接口
	 */
	@Autowired	 ICustomerEventMapper customerEventMapper;

	/**
	 * 删除一条CustomerEvent
	 * @param id
	 */
	public void deleteCustomerEvent(int id) throws RuntimeException {
		customerEventMapper.deleteCustomerEvent(new PojoDeleteCond(id));
	}

	/**
	 * 新增CustomerEvent
	 * @param customerEvent
	 */
	public void addCustomerEvent(CustomerEvent customerEvent) throws RuntimeException {		
		customerEventMapper.addCustomerEvent(customerEvent);
	}

	/**
	 * 查找一条CustomerEvent
	 * @return CustomerEvent
	 * @param id 主键id
	 */
	@Override
	public CustomerEvent findCustomerEventById(int id) throws RuntimeException {
		return customerEventMapper.findCustomerEventById(id);
	}

	/**
	 * 修改CustomerEvent
	 * @param customerEvent
	 */
	@Override
	public void updateCustomerEvent(CustomerEvent customerEvent) throws RuntimeException {
		customerEventMapper.updateCustomerEvent(customerEvent);		
	}

	/**
	 * 分页查找CustomerEvent
	 * @param cond 查询条件
	 * @return CustomerEvent列表
	 */
	public List<CustomerEvent> findCustomerEventPage(CustomerEventCond cond) throws RuntimeException {
		int recordCount = customerEventMapper.findCustomerEventCount(cond);
		
		cond.recordCount = recordCount;
				
		return customerEventMapper.findCustomerEventPage(cond);
	}

	/**
	 * 查找全部CustomerEvent
	 * @param cond 查询条件
	 * @return CustomerEvent列表
	 */
	public List<CustomerEvent> findCustomerEvent(CustomerEventCond cond) throws RuntimeException {
    	return customerEventMapper.findCustomerEvent(cond);
	}
}
