package com.ihk.customer.data.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.data.pojo.RecommendRoom;
import com.ihk.customer.data.pojo.RecommendRoomCond;

/**
 * RecommendRoom的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IRecommendRoomServices extends Serializable {

	/**
	 * 新增RecommendRoom
	 * @param recommendRoom
	 */
	public void addRecommendRoom(RecommendRoom recommendRoom) throws RuntimeException;

	/**
	 * 删除一条RecommendRoom
	 * @param id
	 */
	public void deleteRecommendRoom(int id) throws RuntimeException;

	/**
	 * 修改RecommendRoom
	 * @param recommendRoom
	 */
	public void updateRecommendRoom(RecommendRoom recommendRoom) throws RuntimeException;

	/**
	 * 查找一条RecommendRoom
	 * @return RecommendRoom
	 * @param id 主键id
	 */
	public RecommendRoom findRecommendRoomById(int id) throws RuntimeException;

	/**
	 * 分页查找RecommendRoom
	 * @param cond 查询条件
	 * @return RecommendRoom列表
	 */
	@SuppressWarnings("rawtypes")
	public List findRecommendRoomPage(RecommendRoomCond cond) throws RuntimeException;
	
	/**
	 * 根据customerId 进行查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<RecommendRoom> findRecommendRoomByCustomerId(int id) throws Exception;
	
	/**
	 * 根据customerId 进行删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteRecommendRoomByCustomerId(int id) throws Exception;
}