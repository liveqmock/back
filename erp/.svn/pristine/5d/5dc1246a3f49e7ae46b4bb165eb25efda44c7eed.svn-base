package com.ihk.customer.collection;

import java.util.List;

import com.ihk.customer.collection.pojo.VipCustItem;
import com.ihk.customer.collection.pojo.VipCustItemCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * VipCustItem数据访问接口Mapper
 * @author 
 *
 */ 
public interface IVipCustItemMapper {

	/**
	 * 新增VipCustItem
	 * @param vipCustItem
	 */
	public void addVipCustItem(VipCustItem vipCustItem) ;

	/**
	 * 根据条件删除VipCustItem
	 * @param cond 删除条件
	 */
	public void deleteVipCustItem(PojoDeleteCond cond) throws RuntimeException;


	/**
	 * 修改VipCustItem
	 * @param vipCustItem
	 */
	public void updateVipCustItem(VipCustItem vipCustItem) throws RuntimeException;
	
    
	/**
	 * 查找一条VipCustItem
	 * @return VipCustItem
	 * @param id 主键id
	 */
	public VipCustItem findVipCustItemById(int id) throws RuntimeException;
	    
	/**
	 * 分页查找VipCustItem
	 * @param cond 查询条件
	 * @return VipCustItem列表
	 */
	public List<VipCustItem> findVipCustItemPage(VipCustItemCond cond) ;
        
	/**
	 * 查找全部VipCustItem
	 * @param cond 查询条件
	 * @return VipCustItem列表
	 */
	public List<VipCustItem> findVipCustItem(VipCustItemCond cond) ;
    
	/**
	 * 查找符合条件的记录条数VipCustItem
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findVipCustItemCount(VipCustItemCond cond) ;
}
