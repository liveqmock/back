package com.ihk.customer.collection.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.collection.IVipCustMapper;
import com.ihk.customer.collection.pojo.VipCust;
import com.ihk.customer.collection.pojo.VipCustCond;
import com.ihk.customer.collection.services.IVipCustServices;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * VipCust的Services实现(业务实现)
 * @author 
 *
 */
@Service("vipCustServices")
@SuppressWarnings("unchecked")
public class VipCustServices implements IVipCustServices {
	/**
	 * vipCust数据访问接口
	 */
	@Autowired	 IVipCustMapper vipCustMapper;

	/**
	 * 删除一条VipCust
	 * @param id
	 */
	public void deleteVipCust(int id) throws RuntimeException {
		vipCustMapper.deleteVipCust(new PojoDeleteCond(id));
	}

	/**
	 * 新增VipCust
	 * @param vipCust
	 */
	public int addVipCust(VipCust vipCust) throws RuntimeException {		
		return vipCustMapper.addVipCust(vipCust);
	}

	/**
	 * 查找一条VipCust
	 * @return VipCust
	 * @param id 主键id
	 */
	@Override
	public VipCust findVipCustById(int id) throws RuntimeException {
		return vipCustMapper.findVipCustById(id);
	}

	/**
	 * 修改VipCust
	 * @param vipCust
	 */
	@Override
	public void updateVipCust(VipCust vipCust) throws RuntimeException {
		vipCustMapper.updateVipCust(vipCust);		
	}
	    
	/**
	 * 分页查找VipCust
	 * @param cond 查询条件
	 * @return VipCust列表
	 */
	public List<VipCust> findVipCustPage(VipCustCond cond) throws RuntimeException {
		int recordCount = vipCustMapper.findVipCustCount(cond);
		
		cond.recordCount = recordCount;
				
		return vipCustMapper.findVipCustPage(cond);
	}
        
	/**
	 * 查找全部VipCust
	 * @param cond 查询条件
	 * @return VipCust列表
	 */
	public List<VipCust> findVipCust(VipCustCond cond) throws RuntimeException {
    	return vipCustMapper.findVipCust(cond);
	}
}
