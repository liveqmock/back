package com.ihk.customer.data;

import java.util.List;
import java.util.Map;

import com.ihk.customer.data.pojo.RecommendRoom;
import com.ihk.customer.data.pojo.RecommendRoomCond;

/**
 * RecommendRoom数据访问接口Mapper
 * @author 
 *
 */ 
public interface IRecommendRoomMapper {

	/**
	 * 新增RecommendRoom
	 * @param recommendRoom
	 */
	public void addRecommendRoom(RecommendRoom recommendRoom) ;

	/**
	 * 根据条件删除RecommendRoom
	 * @param cond 删除条件
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
	public List<RecommendRoom> findRecommendRoomPage(RecommendRoomCond cond) ;

	/**
	 * 查找符合条件的记录条数RecommendRoom
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findRecommendRoomCount(RecommendRoomCond cond) ;
	
	/**
	 * 跟据客户id得到RecommendRoom列表
	 * @param id 客户id
	 * @return RecommendRoom列表
	 */
	public List<RecommendRoom> findRecommendRoomByCustomerId(int id);
	
	/**
	 * 跟据客户id删除RecommendRoomB
	 * @param id 客户id
	 */
	public void deleteRecommendRoomByCustomerId(int id);
}
