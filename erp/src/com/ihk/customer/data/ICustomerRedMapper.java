package com.ihk.customer.data;

import java.util.List;
import java.util.Map;

import com.ihk.customer.data.pojo.CustomerRed;
import com.ihk.customer.data.pojo.CustomerRedCond;

/**
 * CustomerRed数据访问接口Mapper
 * @author 
 *
 */ 
public interface ICustomerRedMapper {

	/**
	 * 新增CustomerRed
	 * @param customerRed
	 */
	public void addCustomerRed(CustomerRed customerRed) ;

	/**
	 * 根据条件删除CustomerRed
	 * @param cond 删除条件
	 */
	public void deleteCustomerRed(int id) throws RuntimeException;

	/**
	 * 修改CustomerRed
	 * @param customerRed
	 */
	public void updateCustomerRed(CustomerRed customerRed) throws RuntimeException;

    
	/**
	 * 查找一条CustomerRed
	 * @return CustomerRed
	 * @param id 主键id
	 */
	public CustomerRed findCustomerRedById(int id) throws RuntimeException;

	/**
	 * 分页查找CustomerRed
	 * @param cond 查询条件
	 * @return CustomerRed列表
	 */
	public List<CustomerRed> findCustomerRedPage(CustomerRedCond cond) ;

	/**
	 * 查找全部CustomerRed
	 * @param cond 查询条件
	 * @return CustomerRed列表
	 */
	public List<CustomerRed> findCustomerRed(CustomerRedCond cond) ;

	/**
	 * 查找符合条件的记录条数CustomerRed
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCustomerRedCount(CustomerRedCond cond) ;
	
	/**
	 * 根据项目查找客户标红的设置情况
	 * 约定  project_Id 在is_deleted=0 的情况下 是唯一的 
	 * 
	 */
	public CustomerRed findCustomerRedByProjectId(int projectId) throws RuntimeException;
	
	/**
	 * 根据项目id查找客户标红,转换成Map
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public Map<String, String> findCustomerRedByProjectIdForMap(int projectId) throws RuntimeException;
}
