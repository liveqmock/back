package com.ihk.saleunit.data;

import java.util.List;
import java.util.Map;

import com.ihk.saleunit.data.pojo.CustomerEvent;
import com.ihk.saleunit.data.pojo.CustomerEventCond;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * CustomerEvent数据访问接口Mapper
 * @author 
 *
 */ 
public interface ICustomerEventMapper {

	/**
	 * 新增CustomerEvent
	 * @param customerEvent
	 */
	public void addCustomerEvent(CustomerEvent customerEvent) ;

	/**
	 * 根据条件删除CustomerEvent
	 * @param cond 删除条件
	 */
	public void deleteCustomerEvent(PojoDeleteCond cond) throws RuntimeException;


	/**
	 * 修改CustomerEvent
	 * @param customerEvent
	 */
	public void updateCustomerEvent(CustomerEvent customerEvent) throws RuntimeException;

	/**
	 * 查找一条CustomerEvent
	 * @return CustomerEvent
	 * @param id 主键id
	 */
	public CustomerEvent findCustomerEventById(int id) throws RuntimeException;

	/**
	 * 分页查找CustomerEvent
	 * @param cond 查询条件
	 * @return CustomerEvent列表
	 */
	public List<CustomerEvent> findCustomerEventPage(CustomerEventCond cond) ;

	/**
	 * 查找全部CustomerEvent
	 * @param cond 查询条件
	 * @return CustomerEvent列表
	 */
	public List<CustomerEvent> findCustomerEvent(CustomerEventCond cond) ;

	/**
	 * 查找符合条件的记录条数CustomerEvent
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCustomerEventCount(CustomerEventCond cond) ;
}
