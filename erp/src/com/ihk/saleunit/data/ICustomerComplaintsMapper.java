package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.CustomerComplaints;
import com.ihk.saleunit.data.pojo.CustomerComplaintsCond;

/**
 * CustomerComplaints数据访问接口Mapper
 * @author 
 *
 */ 
public interface ICustomerComplaintsMapper {

	/**
	 * 新增CustomerComplaints
	 * @param customerComplaints
	 */
	public void addCustomerComplaints(CustomerComplaints customerComplaints) ;

	/**
	 * 根据条件删除CustomerComplaints
	 * @param cond 删除条件
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
	public List<CustomerComplaints> findCustomerComplaintsPage(CustomerComplaintsCond cond) ;

	/**
	 * 查找全部CustomerComplaints
	 * @param cond 查询条件
	 * @return CustomerComplaints列表
	 */
	public List<CustomerComplaints> findCustomerComplaints(CustomerComplaintsCond cond) ;

	/**
	 * 查找符合条件的记录条数CustomerComplaints
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCustomerComplaintsCount(CustomerComplaintsCond cond) ;
}
