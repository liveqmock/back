package com.ihk.customer.collection;

import java.util.List;
import java.util.Map;

import com.ihk.customer.collection.pojo.VipCustdeal;
import com.ihk.customer.collection.pojo.VipCustdealCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * VipCustdeal数据访问接口Mapper
 * @author 
 *
 */ 
public interface IVipCustdealMapper {

	/**
	 * 新增VipCustdeal
	 * @param vipCustdeal
	 */
	public void addVipCustdeal(VipCustdeal vipCustdeal) ;

	/**
	 * 根据条件删除VipCustdeal
	 * @param cond 删除条件
	 */
	public void deleteVipCustdeal(PojoDeleteCond cond) throws RuntimeException;


	/**
	 * 修改VipCustdeal
	 * @param vipCustdeal
	 */
	public void updateVipCustdeal(VipCustdeal vipCustdeal) throws RuntimeException;
	
    
	/**
	 * 查找一条VipCustdeal
	 * @return VipCustdeal
	 * @param id 主键id
	 */
	public VipCustdeal findVipCustdealById(int id) throws RuntimeException;
	    
	/**
	 * 分页查找VipCustdeal
	 * @param cond 查询条件
	 * @return VipCustdeal列表
	 */
	public List<VipCustdeal> findVipCustdealPage(VipCustdealCond cond) ;
        
	/**
	 * 查找全部VipCustdeal
	 * @param cond 查询条件
	 * @return VipCustdeal列表
	 */
	public List<VipCustdeal> findVipCustdeal(VipCustdealCond cond) ;
    
	/**
	 * 查找符合条件的记录条数VipCustdeal
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findVipCustdealCount(VipCustdealCond cond) ;
	
	/**
	 * 查询符合条件的统计结果
	 * @param cond
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> findVipCustdealgroup(VipCustdealCond cond);
	
	/**
	 * 查询符合条件的统计结果
	 * @param cond
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> findVipCustdealCustIdgroup(VipCustdealCond cond);
	/**
	 * 查询详细
	 * @param cond
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> findVipCustAndDeal(VipCustdealCond cond);
}
