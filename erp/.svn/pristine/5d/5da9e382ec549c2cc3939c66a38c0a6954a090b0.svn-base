package com.ihk.customer.data.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.data.ICustomerLogMapper;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerLog;
import com.ihk.customer.data.pojo.CustomerLogCond;
import com.ihk.customer.data.services.ICustomerLogServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;

/**
 * CustomerLog的Services实现(业务实现)
 * @author 
 *
 */
@Service("customerLogServices")
public class CustomerLogServices implements ICustomerLogServices {
	/**
	 * customerLog数据访问接口
	 */
	@Autowired	 
	ICustomerLogMapper customerLogMapper;
	/**
	 * customer业务访问接口
	 */
	@Autowired
	ICustomerServices customerServices;

	/**
	 * 删除一条CustomerLog
	 * @param id
	 */
	public void deleteCustomerLog(int id) throws RuntimeException {
		customerLogMapper.deleteCustomerLog(id);
	}

	/**
	 * 新增CustomerLog
	 * @param customerLog
	 */
	public void addCustomerLog(CustomerLog customerLog) throws RuntimeException {		
		customerLogMapper.addCustomerLog(customerLog);
	}

	/**
	 * 查找一条CustomerLog
	 * @return CustomerLog
	 * @param id 主键id
	 */
	@Override
	public CustomerLog findCustomerLogById(int id) throws RuntimeException {
		return customerLogMapper.findCustomerLogById(id);
	}

	/**
	 * 修改CustomerLog
	 * @param customerLog
	 */
	@Override
	public void updateCustomerLog(CustomerLog customerLog) throws RuntimeException {
		customerLogMapper.updateCustomerLog(customerLog);		
	}

	/**
	 * 分页查找CustomerLog
	 * @param cond 查询条件
	 * @return CustomerLog列表
	 */
	public List<CustomerLog> findCustomerLogPage(CustomerLogCond cond) throws RuntimeException {
		int recordCount = customerLogMapper.findCustomerLogCount(cond);
		
		cond.recordCount = recordCount;
				
		return customerLogMapper.findCustomerLogPage(cond);
	}
    
	/**
	 * 查找全部CustomerLog
	 * @param cond 查询条件
	 * @return CustomerLog列表
	 */
	public List<CustomerLog> findCustomerLog(CustomerLogCond cond) throws RuntimeException {
    	return customerLogMapper.findCustomerLog(cond);
	}

	/**
	 * 添加customer修改信息到log
	 */
	@Override
	public void addCustomerToCustomerLog(int customerId) throws RuntimeException {
		
		Customer customer = customerServices.getCustomerById(customerId);
		
		Map<String, Object> map = CommonUtils.getPojoMap(customer); 
		map.put("logCreatedId", SessionUser.getUserId());
		map.put("logCreatedTime", new Date());
		customerLogMapper.addCustomerToCustomerLog(map);
	}
}
