package com.ihk.customer.data;

import java.util.List;
import java.util.Map;

import com.ihk.customer.data.pojo.FollowRoom;
import com.ihk.customer.data.pojo.FollowRoomCond;

/**
 * FollowRoom数据访问接口Mapper
 * @author 
 *
 */ 
public interface IFollowRoomMapper {

	/**
	 * 新增FollowRoom
	 * @param followRoom
	 */
	public void addFollowRoom(FollowRoom followRoom) ;

	/**
	 * 根据条件删除FollowRoom
	 * @param cond 删除条件
	 */
	public void deleteFollowRoom(int id) throws RuntimeException;

	/**
	 * 修改FollowRoom
	 * @param followRoom
	 */
	public void updateFollowRoom(FollowRoom followRoom) throws RuntimeException;

    
	/**
	 * 查找一条FollowRoom
	 * @return FollowRoom
	 * @param id 主键id
	 */
	public FollowRoom findFollowRoomById(int id) throws RuntimeException;

	/**
	 * 分页查找FollowRoom
	 * @param cond 查询条件
	 * @return FollowRoom列表
	 */
	public List<FollowRoom> findFollowRoomPage(FollowRoomCond cond) ;

	/**
	 * 查找符合条件的记录条数FollowRoom
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findFollowRoomCount(FollowRoomCond cond) ;
}
