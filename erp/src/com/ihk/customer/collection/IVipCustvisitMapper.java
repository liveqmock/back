package com.ihk.customer.collection;

import java.util.List;

import com.ihk.customer.collection.pojo.VipCustvisit;
import com.ihk.customer.collection.pojo.VipCustvisitCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * VipCustvisit数据访问接口Mapper
 * @author 
 *
 */ 
public interface IVipCustvisitMapper {

	/**
	 * 新增VipCustvisit
	 * @param vipCustvisit
	 */
	public void addVipCustvisit(VipCustvisit vipCustvisit) ;

	/**
	 * 根据条件删除VipCustvisit
	 * @param cond 删除条件
	 */
	public void deleteVipCustvisit(PojoDeleteCond cond) throws RuntimeException;


	/**
	 * 修改VipCustvisit
	 * @param vipCustvisit
	 */
	public void updateVipCustvisit(VipCustvisit vipCustvisit) throws RuntimeException;
	
    
	/**
	 * 查找一条VipCustvisit
	 * @return VipCustvisit
	 * @param id 主键id
	 */
	public VipCustvisit findVipCustvisitById(int id) throws RuntimeException;
	    
	/**
	 * 分页查找VipCustvisit
	 * @param cond 查询条件
	 * @return VipCustvisit列表
	 */
	public List<VipCustvisit> findVipCustvisitPage(VipCustvisitCond cond) ;
        
	/**
	 * 查找全部VipCustvisit
	 * @param cond 查询条件
	 * @return VipCustvisit列表
	 */
	public List<VipCustvisit> findVipCustvisit(VipCustvisitCond cond) ;
    
	/**
	 * 查找符合条件的记录条数VipCustvisit
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findVipCustvisitCount(VipCustvisitCond cond) ;
}
