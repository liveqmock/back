package com.ihk.customer.collection.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.collection.IVipCustFollowMapper;
import com.ihk.customer.collection.pojo.VipCustFollow;
import com.ihk.customer.collection.pojo.VipCustFollowCond;
import com.ihk.customer.collection.services.IVipCustFollowServices;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * VipCustFollow的Services实现(业务实现)
 * @author 
 *
 */
@Service("vipCustFollowServices")
@SuppressWarnings("unchecked")
public class VipCustFollowServices implements IVipCustFollowServices {
	/**
	 * vipCustFollow数据访问接口
	 */
	@Autowired	 IVipCustFollowMapper vipCustFollowMapper;

	/**
	 * 删除一条VipCustFollow
	 * @param id
	 */
	public void deleteVipCustFollow(int id) throws RuntimeException {
		vipCustFollowMapper.deleteVipCustFollow(new PojoDeleteCond(id));
	}

	/**
	 * 新增VipCustFollow
	 * @param vipCustFollow
	 */
	public void addVipCustFollow(VipCustFollow vipCustFollow) throws RuntimeException {		
		vipCustFollowMapper.addVipCustFollow(vipCustFollow);
	}

	/**
	 * 查找一条VipCustFollow
	 * @return VipCustFollow
	 * @param id 主键id
	 */
	@Override
	public VipCustFollow findVipCustFollowById(int id) throws RuntimeException {
		return vipCustFollowMapper.findVipCustFollowById(id);
	}

	/**
	 * 修改VipCustFollow
	 * @param vipCustFollow
	 */
	@Override
	public void updateVipCustFollow(VipCustFollow vipCustFollow) throws RuntimeException {
		vipCustFollowMapper.updateVipCustFollow(vipCustFollow);		
	}
	    
	/**
	 * 分页查找VipCustFollow
	 * @param cond 查询条件
	 * @return VipCustFollow列表
	 */
	public List<VipCustFollow> findVipCustFollowPage(VipCustFollowCond cond) throws RuntimeException {
		int recordCount = vipCustFollowMapper.findVipCustFollowCount(cond);
		
		cond.recordCount = recordCount;
				
		return vipCustFollowMapper.findVipCustFollowPage(cond);
	}
        
	/**
	 * 查找全部VipCustFollow
	 * @param cond 查询条件
	 * @return VipCustFollow列表
	 */
	public List<VipCustFollow> findVipCustFollow(VipCustFollowCond cond) throws RuntimeException {
    	return vipCustFollowMapper.findVipCustFollow(cond);
	}
}
