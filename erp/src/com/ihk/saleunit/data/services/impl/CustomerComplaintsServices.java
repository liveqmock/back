package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.ICustomerComplaintsMapper;
import com.ihk.saleunit.data.pojo.CustomerComplaints;
import com.ihk.saleunit.data.pojo.CustomerComplaintsCond;
import com.ihk.saleunit.data.services.ICustomerComplaintsServices;

/**
 * CustomerComplaints的Services实现(业务实现)
 * @author 
 *
 */
@Service("customerComplaintsServices")
@SuppressWarnings("unchecked")
public class CustomerComplaintsServices implements ICustomerComplaintsServices {
	/**
	 * customerComplaints数据访问接口
	 */
	@Autowired	 ICustomerComplaintsMapper customerComplaintsMapper;

	/**
	 * 删除一条CustomerComplaints
	 * @param id
	 */
	public void deleteCustomerComplaints(int id) throws RuntimeException {
		customerComplaintsMapper.deleteCustomerComplaints(id);
	}

	/**
	 * 新增CustomerComplaints
	 * @param customerComplaints
	 */
	public void addCustomerComplaints(CustomerComplaints customerComplaints) throws RuntimeException {		
		customerComplaintsMapper.addCustomerComplaints(customerComplaints);
	}

	/**
	 * 查找一条CustomerComplaints
	 * @return CustomerComplaints
	 * @param id 主键id
	 */
	@Override
	public CustomerComplaints findCustomerComplaintsById(int id) throws RuntimeException {
		return customerComplaintsMapper.findCustomerComplaintsById(id);
	}

	/**
	 * 修改CustomerComplaints
	 * @param customerComplaints
	 */
	@Override
	public void updateCustomerComplaints(CustomerComplaints customerComplaints) throws RuntimeException {
		customerComplaintsMapper.updateCustomerComplaints(customerComplaints);		
	}

	/**
	 * 分页查找CustomerComplaints
	 * @param cond 查询条件
	 * @return CustomerComplaints列表
	 */
	public List<CustomerComplaints> findCustomerComplaintsPage(CustomerComplaintsCond cond) throws RuntimeException {
		int recordCount = customerComplaintsMapper.findCustomerComplaintsCount(cond);
		
		cond.recordCount = recordCount;
				
		return customerComplaintsMapper.findCustomerComplaintsPage(cond);
	}

	/**
	 * 查找全部CustomerComplaints
	 * @param cond 查询条件
	 * @return CustomerComplaints列表
	 */
	public List<CustomerComplaints> findCustomerComplaints(CustomerComplaintsCond cond) throws RuntimeException {
    	return customerComplaintsMapper.findCustomerComplaints(cond);
	}
}
