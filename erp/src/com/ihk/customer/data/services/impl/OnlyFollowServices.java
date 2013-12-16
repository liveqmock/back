package com.ihk.customer.data.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.data.IOnlyFollowMapper;
import com.ihk.customer.data.pojo.OnlyFollow;
import com.ihk.customer.data.pojo.OnlyFollowCond;
import com.ihk.customer.data.services.IOnlyFollowServices;
import com.ihk.utils.base.PojoDeleteCond;

@Service("onlyFollowServices")
public class OnlyFollowServices implements IOnlyFollowServices {
	@Autowired	 IOnlyFollowMapper onlyFollowMapper;

	public void deleteOnlyFollow(int id) throws RuntimeException {
		onlyFollowMapper.deleteOnlyFollow(new PojoDeleteCond(id));
	}

	public void addOnlyFollow(OnlyFollow onlyFollow) throws RuntimeException {		
		onlyFollowMapper.addOnlyFollow(onlyFollow);
	}

	@Override
	public OnlyFollow findOnlyFollowById(int id) throws RuntimeException {
		return onlyFollowMapper.findOnlyFollowById(id);
	}

	@Override
	public void updateOnlyFollow(OnlyFollow onlyFollow) throws RuntimeException {
		onlyFollowMapper.updateOnlyFollow(onlyFollow);		
	}
	
	public List<OnlyFollow> findOnlyFollowPage(OnlyFollowCond cond) throws RuntimeException {
		int recordCount = onlyFollowMapper.findOnlyFollowCount(cond);
		
		cond.recordCount = recordCount;
				
		return onlyFollowMapper.findOnlyFollowPage(cond);
	}
    
	public List<OnlyFollow> findOnlyFollow(OnlyFollowCond cond) throws RuntimeException {
    	return onlyFollowMapper.findOnlyFollow(cond);
	}

	@Override
	public List<OnlyFollow> findOnlyFollowByUserId(int userId)
			throws RuntimeException {
		
		return onlyFollowMapper.findOnlyFollowByUserId(userId);
	}

	@Override
	public List<OnlyFollow> findOnlyFollowByCustomerId(int customerId)
			throws RuntimeException {
		
		return onlyFollowMapper.findOnlyFollowByCustomerId(customerId);
	}

	@Override
	public List<OnlyFollow> findOnlyFollowByUserIdAndCustomerId(int userId,
			int customerId) throws RuntimeException {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("userId", userId);
		map.put("customerId", customerId);
		
		return onlyFollowMapper.findOnlyFollowByUserIdAndCustomerId(map);
	}
}
