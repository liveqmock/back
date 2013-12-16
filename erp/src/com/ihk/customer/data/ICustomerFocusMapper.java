package com.ihk.customer.data;

import java.util.List;

import com.ihk.customer.data.pojo.CustomerFocus;
import com.ihk.customer.data.pojo.CustomerFocusCond;
import com.ihk.customer.data.pojo.CustomerKnown;

/**
 * CustomerFocus数据访问接口Mapper
 * @author 
 *
 */ 
public interface ICustomerFocusMapper {

	/**
	 * 新增CustomerFocus
	 * @param customerFocus
	 */
	public void addCustomerFocus(CustomerFocus customerFocus) ;

	/**
	 * 根据条件删除CustomerFocus
	 * @param cond 删除条件
	 */
	public void deleteCustomerFocus(int id) throws RuntimeException;

	/**
	 * 修改CustomerFocus
	 * @param customerFocus
	 */
	public void updateCustomerFocus(CustomerFocus customerFocus) throws RuntimeException;

	/**
	 * 查找一条CustomerFocus
	 * @return CustomerFocus
	 * @param id 主键id
	 */
	public CustomerFocus findCustomerFocusById(int id) throws RuntimeException;

	/**
	 * 分页查找CustomerFocus
	 * @param cond 查询条件
	 * @return CustomerFocus列表
	 */
	public List<CustomerFocus> findCustomerFocusPage(CustomerFocusCond cond) ;

	/**
	 * 查找全部CustomerFocus
	 * @param cond 查询条件
	 * @return CustomerFocus列表
	 */
	public List<CustomerFocus> findCustomerFocus(CustomerFocusCond cond) ;

	/**
	 * 查找符合条件的记录条数CustomerFocus
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCustomerFocusCount(CustomerFocusCond cond) ;
	
	/**
	 * 跟进客户id获取对应的关注点
	 * @param id
	 * @return
	 */
	public List<CustomerFocus> findCustomerFocusByCustomerId(int id); //跟进客户id获取对应的关注点
	
	/**
	 * 根据customer id删除
	 * @param id
	 */
	public void deleteCustomerFocusByCusotmerId(int id); //根据customer id删除

	/**
	 * 查找全部
	 * @return
	 */
	public List<CustomerFocus> findAllCustomerFocus() ;
}
