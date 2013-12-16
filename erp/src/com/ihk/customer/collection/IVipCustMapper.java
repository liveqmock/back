package com.ihk.customer.collection;

import java.util.List;

import com.ihk.customer.collection.pojo.VipCust;
import com.ihk.customer.collection.pojo.VipCustCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * VipCust数据访问接口Mapper
 * @author 
 *
 */ 
public interface IVipCustMapper {

	/**
	 * 新增VipCust
	 * @param vipCust
	 */
	public int addVipCust(VipCust vipCust) ;

	/**
	 * 根据条件删除VipCust
	 * @param cond 删除条件
	 */
	public void deleteVipCust(PojoDeleteCond cond) throws RuntimeException;


	/**
	 * 修改VipCust
	 * @param vipCust
	 */
	public void updateVipCust(VipCust vipCust) throws RuntimeException;
	
    
	/**
	 * 查找一条VipCust
	 * @return VipCust
	 * @param id 主键id
	 */
	public VipCust findVipCustById(int id) throws RuntimeException;
	    
	/**
	 * 分页查找VipCust
	 * @param cond 查询条件
	 * @return VipCust列表
	 */
	public List<VipCust> findVipCustPage(VipCustCond cond) ;
        
	/**
	 * 查找全部VipCust
	 * @param cond 查询条件
	 * @return VipCust列表
	 */
	public List<VipCust> findVipCust(VipCustCond cond) ;
    
	/**
	 * 查找符合条件的记录条数VipCust
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findVipCustCount(VipCustCond cond) ;
}
