package com.ihk.customer.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.data.IRecommendRoomMapper;
import com.ihk.customer.data.pojo.RecommendRoom;
import com.ihk.customer.data.pojo.RecommendRoomCond;
import com.ihk.customer.data.services.IRecommendRoomServices;

/**
 * RecommendRoom的Services实现(业务实现)
 * @author 
 *
 */
@Service("recommendRoomServices")
@SuppressWarnings("unchecked")
public class RecommendRoomServices implements IRecommendRoomServices {
	/**
	 * recommendRoom数据访问接口
	 */
	@Autowired	 IRecommendRoomMapper recommendRoomMapper;

	/**
	 * 删除一条RecommendRoom
	 * @param id
	 */
	public void deleteRecommendRoom(int id) throws RuntimeException {
		recommendRoomMapper.deleteRecommendRoom(id);
	}

	/**
	 * 新增RecommendRoom
	 * @param recommendRoom
	 */
	public void addRecommendRoom(RecommendRoom recommendRoom) throws RuntimeException {		
		recommendRoomMapper.addRecommendRoom(recommendRoom);
	}

	/**
	 * 查找一条RecommendRoom
	 * @return RecommendRoom
	 * @param id 主键id
	 */
	@Override
	public RecommendRoom findRecommendRoomById(int id) throws RuntimeException {
		return recommendRoomMapper.findRecommendRoomById(id);
	}

	/**
	 * 修改RecommendRoom
	 * @param recommendRoom
	 */
	@Override
	public void updateRecommendRoom(RecommendRoom recommendRoom) throws RuntimeException {
		recommendRoomMapper.updateRecommendRoom(recommendRoom);		
	}

	/**
	 * 分页查找RecommendRoom
	 * @param cond 查询条件
	 * @return RecommendRoom列表
	 */
	public List findRecommendRoomPage(RecommendRoomCond cond) throws RuntimeException {
		int recordCount = recommendRoomMapper.findRecommendRoomCount(cond);
		
		cond.recordCount = recordCount;
				
		return recommendRoomMapper.findRecommendRoomPage(cond);
	}

	/**
	 * 根据CustomerId进行查找
	 */
	@Override
	public List<RecommendRoom> findRecommendRoomByCustomerId(int id)
			throws Exception {
		return recommendRoomMapper.findRecommendRoomByCustomerId(id);
	}

	/**
	 * 根据CustomerId进行删除
	 */
	@Override
	public void deleteRecommendRoomByCustomerId(int id) throws Exception {
		recommendRoomMapper.deleteRecommendRoomByCustomerId(id);
		
	}
}
