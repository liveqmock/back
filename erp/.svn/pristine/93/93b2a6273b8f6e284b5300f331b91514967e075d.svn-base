package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.CustomerComplaints;
import com.ihk.saleunit.data.pojo.CustomerComplaintsCond;

/**
 * CustomerComplaints的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface ICustomerComplaintsServices {
	/**
	 * 新增CustomerComplaints
	 * @param customerComplaints
	 */
	public void addCustomerComplaints(CustomerComplaints customerComplaints) throws RuntimeException;

	/**
	 * 删除一条CustomerComplaints
	 * @param id
	 */
	public void deleteCustomerComplaints(int id) throws RuntimeException;

	/**
	 * 修改CustomerComplaints
	 * @param customerComplaints
	 */
	public void updateCustomerComplaints(CustomerComplaints customerComplaints) throws RuntimeException;

	/**
	 * 查找一条CustomerComplaints
	 * @return CustomerComplaints
	 * @param id 主键id
	 */
	public CustomerComplaints findCustomerComplaintsById(int id) throws RuntimeException;

	/**
	 * 分页查找CustomerComplaints
	 * @param cond 查询条件
	 * @return CustomerComplaints列表
	 */
	public List<CustomerComplaints> findCustomerComplaintsPage(CustomerComplaintsCond cond) throws RuntimeException;

	/**
	 * 查找全部CustomerComplaints
	 * @param cond 查询条件
	 * @return CustomerComplaints列表
	 */
	public List<CustomerComplaints> findCustomerComplaints(CustomerComplaintsCond cond) throws RuntimeException;
}