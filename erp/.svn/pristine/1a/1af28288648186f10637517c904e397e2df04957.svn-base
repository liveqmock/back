package com.ihk.customer.data;

import java.util.List;
import java.util.Map;

import com.ihk.customer.data.pojo.CustomerKnown;
import com.ihk.customer.data.pojo.CustomerKnownCond;
 
/**
 * CustomerKnown数据访问接口Mapper
 * @author 
 *
 */ 
public interface ICustomerKnownMapper {

	/**
	 * 新增CustomerKnown
	 * @param customerKnown
	 */
	public void addCustomerKnown(CustomerKnown customerKnown) ;

	/**
	 * 根据条件删除CustomerKnown
	 * @param cond 删除条件
	 */
	public void deleteCustomerKnown(int id) throws RuntimeException;

	/**
	 * 修改CustomerKnown
	 * @param customerKnown
	 */
	public void updateCustomerKnown(CustomerKnown customerKnown) throws RuntimeException;

	/**
	 * 查找一条CustomerKnown
	 * @return CustomerKnown
	 * @param id 主键id
	 */
	public CustomerKnown findCustomerKnownById(int id) throws RuntimeException;

	/**
	 * 分页查找CustomerKnown
	 * @param cond 查询条件
	 * @return CustomerKnown列表
	 */
	public List<CustomerKnown> findCustomerKnownPage(CustomerKnownCond cond) ;

	/**
	 * 查找符合条件的记录条数CustomerKnown
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCustomerKnownCount(CustomerKnownCond cond) ;
	
	/**
	 * 查找同一客户下的CustomerKnown
	 */
	public List<CustomerKnown> findCustomerKnownByCustomerId(int id);
	
	/**
	 * 删除同一客户下的CustomerKnown
	 * @param id
	 */
	public void deleteCustomerKnownByCustomerId(int id);

	/**
	 * 查找全部
	 * @return
	 */
	public List<CustomerKnown> findAllCustomerKnown() ;
}
