package com.ihk.customer.data;

import java.util.List;
import java.util.Map;

import com.ihk.customer.data.pojo.CustomerLog;
import com.ihk.customer.data.pojo.CustomerLogCond;
 
/**
 * CustomerLog数据访问接口Mapper
 * @author 
 *
 */ 
public interface ICustomerLogMapper {

	/**
	 * 新增CustomerLog
	 * @param customerLog
	 */
	public void addCustomerLog(CustomerLog customerLog) ;

	/**
	 * 根据条件删除CustomerLog
	 * @param cond 删除条件
	 */
	public void deleteCustomerLog(int id) throws RuntimeException;

	/**
	 * 修改CustomerLog
	 * @param customerLog
	 */
	public void updateCustomerLog(CustomerLog customerLog) throws RuntimeException;
	
	/**
	 * 查找一条CustomerLog
	 * @return CustomerLog
	 * @param id 主键id
	 */
	public CustomerLog findCustomerLogById(int id) throws RuntimeException;

	/**
	 * 分页查找CustomerLog
	 * @param cond 查询条件
	 * @return CustomerLog列表
	 */
	public List<CustomerLog> findCustomerLogPage(CustomerLogCond cond) ;

	/**
	 * 查找全部CustomerLog
	 * @param cond 查询条件
	 * @return CustomerLog列表
	 */
	public List<CustomerLog> findCustomerLog(CustomerLogCond cond) ;

	/**
	 * 查找符合条件的记录条数CustomerLog
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCustomerLogCount(CustomerLogCond cond) ;
	
	//public void addCustomerToCustomerLog(Customer c);
	
	/**
	 * 把客户修改信息添加到CustomerLog
	 */
	public void addCustomerToCustomerLog(Map<String, Object> map);
	
}
	
