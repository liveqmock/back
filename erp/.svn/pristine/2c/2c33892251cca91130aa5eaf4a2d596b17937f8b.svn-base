package com.ihk.customer.collection;

import java.util.List;

import com.ihk.customer.collection.pojo.VipCustomer;
import com.ihk.customer.collection.pojo.VipCustomerCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * VipCustomer数据访问接口Mapper
 * @author 
 *
 */ 
public interface IVipCustomerMapper {

	/**
	 * 新增VipCustomer
	 * @param vipCustomer
	 */
	public void addVipCustomer(VipCustomer vipCustomer) ;

	/**
	 * 根据条件删除VipCustomer
	 * @param cond 删除条件
	 */
	public void deleteVipCustomer(PojoDeleteCond cond) throws RuntimeException;


	/**
	 * 修改VipCustomer
	 * @param vipCustomer
	 */
	public void updateVipCustomer(VipCustomer vipCustomer) throws RuntimeException;
	
    
	/**
	 * 查找一条VipCustomer
	 * @return VipCustomer
	 * @param id 主键id
	 */
	public VipCustomer findVipCustomerById(int id) throws RuntimeException;
	    
	/**
	 * 分页查找VipCustomer
	 * @param cond 查询条件
	 * @return VipCustomer列表
	 */
	public List<VipCustomer> findVipCustomerPage(VipCustomerCond cond) ;
        
	/**
	 * 查找全部VipCustomer
	 * @param cond 查询条件
	 * @return VipCustomer列表
	 */
	public List<VipCustomer> findVipCustomer(VipCustomerCond cond) ;
    
	/**
	 * 查找符合条件的记录条数VipCustomer
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findVipCustomerCount(VipCustomerCond cond) ;
}
