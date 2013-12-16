package com.ihk.customer.collection;

import java.util.List;

import com.ihk.customer.collection.pojo.VipCustFollow;
import com.ihk.customer.collection.pojo.VipCustFollowCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * VipCustFollow数据访问接口Mapper
 * @author 
 *
 */ 
public interface IVipCustFollowMapper {

	/**
	 * 新增VipCustFollow
	 * @param vipCustFollow
	 */
	public void addVipCustFollow(VipCustFollow vipCustFollow) ;

	/**
	 * 根据条件删除VipCustFollow
	 * @param cond 删除条件
	 */
	public void deleteVipCustFollow(PojoDeleteCond cond) throws RuntimeException;


	/**
	 * 修改VipCustFollow
	 * @param vipCustFollow
	 */
	public void updateVipCustFollow(VipCustFollow vipCustFollow) throws RuntimeException;
	
    
	/**
	 * 查找一条VipCustFollow
	 * @return VipCustFollow
	 * @param id 主键id
	 */
	public VipCustFollow findVipCustFollowById(int id) throws RuntimeException;
	    
	/**
	 * 分页查找VipCustFollow
	 * @param cond 查询条件
	 * @return VipCustFollow列表
	 */
	public List<VipCustFollow> findVipCustFollowPage(VipCustFollowCond cond) ;
        
	/**
	 * 查找全部VipCustFollow
	 * @param cond 查询条件
	 * @return VipCustFollow列表
	 */
	public List<VipCustFollow> findVipCustFollow(VipCustFollowCond cond) ;
    
	/**
	 * 查找符合条件的记录条数VipCustFollow
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findVipCustFollowCount(VipCustFollowCond cond) ;
}
