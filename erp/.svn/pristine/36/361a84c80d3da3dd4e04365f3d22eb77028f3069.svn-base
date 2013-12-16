package com.ihk.customer.data.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.data.pojo.FollowRoom;
import com.ihk.customer.data.pojo.FollowRoomCond;

/**
 * FollowRoom的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IFollowRoomServices extends Serializable {

	/**
	 * 新增FollowRoom
	 * @param followRoom
	 */
	public void addFollowRoom(FollowRoom followRoom) throws RuntimeException;

	/**
	 * 删除一条FollowRoom
	 * @param id
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
	@SuppressWarnings("rawtypes")
	public List findFollowRoomPage(FollowRoomCond cond) throws RuntimeException;
}