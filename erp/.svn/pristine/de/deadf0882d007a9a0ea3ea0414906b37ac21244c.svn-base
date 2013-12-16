package com.ihk.customer.collection.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.collection.IVipCustomerMapper;
import com.ihk.customer.collection.pojo.VipCustomer;
import com.ihk.customer.collection.pojo.VipCustomerCond;
import com.ihk.customer.collection.services.IVipCustomerServices;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * VipCustomer的Services实现(业务实现)
 * @author 
 *
 */
@Service("vipCustomerServices")
@SuppressWarnings("unchecked")
public class VipCustomerServices implements IVipCustomerServices {
	/**
	 * vipCustomer数据访问接口
	 */
	@Autowired	 IVipCustomerMapper vipCustomerMapper;

	/**
	 * 删除一条VipCustomer
	 * @param id
	 */
	public void deleteVipCustomer(int id) throws RuntimeException {
		vipCustomerMapper.deleteVipCustomer(new PojoDeleteCond(id));
	}

	/**
	 * 新增VipCustomer
	 * @param vipCustomer
	 */
	public void addVipCustomer(VipCustomer vipCustomer) throws RuntimeException {		
		vipCustomerMapper.addVipCustomer(vipCustomer);
	}

	/**
	 * 查找一条VipCustomer
	 * @return VipCustomer
	 * @param id 主键id
	 */
	@Override
	public VipCustomer findVipCustomerById(int id) throws RuntimeException {
		return vipCustomerMapper.findVipCustomerById(id);
	}

	/**
	 * 修改VipCustomer
	 * @param vipCustomer
	 */
	@Override
	public void updateVipCustomer(VipCustomer vipCustomer) throws RuntimeException {
		vipCustomerMapper.updateVipCustomer(vipCustomer);		
	}
	    
	/**
	 * 分页查找VipCustomer
	 * @param cond 查询条件
	 * @return VipCustomer列表
	 */
	public List<VipCustomer> findVipCustomerPage(VipCustomerCond cond) throws RuntimeException {
		int recordCount = vipCustomerMapper.findVipCustomerCount(cond);
		
		cond.recordCount = recordCount;
				
		return vipCustomerMapper.findVipCustomerPage(cond);
	}
        
	/**
	 * 查找全部VipCustomer
	 * @param cond 查询条件
	 * @return VipCustomer列表
	 */
	public List<VipCustomer> findVipCustomer(VipCustomerCond cond) throws RuntimeException {
    	return vipCustomerMapper.findVipCustomer(cond);
	}
}
