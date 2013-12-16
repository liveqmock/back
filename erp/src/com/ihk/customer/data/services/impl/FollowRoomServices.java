package com.ihk.customer.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.data.IFollowRoomMapper;
import com.ihk.customer.data.pojo.FollowRoom;
import com.ihk.customer.data.pojo.FollowRoomCond;
import com.ihk.customer.data.services.IFollowRoomServices;

/**
 * FollowRoom的Services实现(业务实现)
 * @author 
 *
 */
@Service("followRoomServices")
@SuppressWarnings("unchecked")
public class FollowRoomServices implements IFollowRoomServices {
	/**
	 * followRoom数据访问接口
	 */
	@Autowired	 IFollowRoomMapper followRoomMapper;

	/**
	 * 删除一条FollowRoom
	 * @param id
	 */
	public void deleteFollowRoom(int id) throws RuntimeException {
		followRoomMapper.deleteFollowRoom(id);
	}

	/**
	 * 新增FollowRoom
	 * @param followRoom
	 */
	public void addFollowRoom(FollowRoom followRoom) throws RuntimeException {		
		followRoomMapper.addFollowRoom(followRoom);
	}

	/**
	 * 查找一条FollowRoom
	 * @return FollowRoom
	 * @param id 主键id
	 */
	@Override
	public FollowRoom findFollowRoomById(int id) throws RuntimeException {
		return followRoomMapper.findFollowRoomById(id);
	}


	/**
	 * 修改FollowRoom
	 * @param followRoom
	 */
	@Override
	public void updateFollowRoom(FollowRoom followRoom) throws RuntimeException {
		followRoomMapper.updateFollowRoom(followRoom);		
	}

	/**
	 * 分页查找FollowRoom
	 * @param cond 查询条件
	 * @return FollowRoom列表
	 */
	public List findFollowRoomPage(FollowRoomCond cond) throws RuntimeException {
		int recordCount = followRoomMapper.findFollowRoomCount(cond);
		
		cond.recordCount = recordCount;
				
		return followRoomMapper.findFollowRoomPage(cond);
	}
}
