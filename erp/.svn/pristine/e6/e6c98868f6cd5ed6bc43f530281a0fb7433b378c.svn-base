package com.ihk.customer.data;

import java.util.List;
import java.util.Map;

import com.ihk.customer.data.pojo.OnlyFollow;
import com.ihk.customer.data.pojo.OnlyFollowCond;
import com.ihk.utils.base.PojoDeleteCond;
 
public interface IOnlyFollowMapper {

	public void addOnlyFollow(OnlyFollow onlyFollow) ;

	public void deleteOnlyFollow(PojoDeleteCond cond) throws RuntimeException;

	public void updateOnlyFollow(OnlyFollow onlyFollow) throws RuntimeException;
	
	public OnlyFollow findOnlyFollowById(int id) throws RuntimeException;
	
	public List<OnlyFollow> findOnlyFollowPage(OnlyFollowCond cond) ;
    
	public List<OnlyFollow> findOnlyFollow(OnlyFollowCond cond) ;
    
	public int findOnlyFollowCount(OnlyFollowCond cond) ;
	
	public List<OnlyFollow> findOnlyFollowByUserId(int userId) throws RuntimeException; 
	
	/**
	 * 根据客户id获取OnlyFollow list
	 * @param customerId
	 * @return
	 * @throws RuntimeException
	 */
	public List<OnlyFollow> findOnlyFollowByCustomerId(int customerId) throws RuntimeException;
	
	/**
	 * 根据用户id及客户id获取OnlyFollow list
	 * @param map
	 * @return
	 * @throws RuntimeException
	 */
	public List<OnlyFollow> findOnlyFollowByUserIdAndCustomerId(Map<String, Integer> map) throws RuntimeException;
}
