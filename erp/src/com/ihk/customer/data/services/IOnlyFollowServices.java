package com.ihk.customer.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.data.pojo.OnlyFollow;
import com.ihk.customer.data.pojo.OnlyFollowCond;

@Transactional 
public interface IOnlyFollowServices {
	public void addOnlyFollow(OnlyFollow onlyFollow) throws RuntimeException;

	public void deleteOnlyFollow(int id) throws RuntimeException;

	public void updateOnlyFollow(OnlyFollow onlyFollow) throws RuntimeException;

	public OnlyFollow findOnlyFollowById(int id) throws RuntimeException;
    
	public List<OnlyFollow> findOnlyFollowPage(OnlyFollowCond cond) throws RuntimeException;
    
	public List<OnlyFollow> findOnlyFollow(OnlyFollowCond cond) throws RuntimeException;
	
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
	 * @param userId
	 * @param customerId
	 * @return
	 * @throws RuntimeException
	 */
	public List<OnlyFollow> findOnlyFollowByUserIdAndCustomerId(int userId, int customerId) throws RuntimeException;
}