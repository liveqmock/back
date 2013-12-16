package com.ihk.customer.collection.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.collection.IVipCustdealMapper;
import com.ihk.customer.collection.pojo.VipCustdeal;
import com.ihk.customer.collection.pojo.VipCustdealCond;
import com.ihk.customer.collection.services.IVipCustdealServices;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * VipCustdeal的Services实现(业务实现)
 * @author 
 *
 */
@Service("vipCustdealServices")
@SuppressWarnings("unchecked")
public class VipCustdealServices implements IVipCustdealServices {
	/**
	 * vipCustdeal数据访问接口
	 */
	@Autowired	 IVipCustdealMapper vipCustdealMapper;

	/**
	 * 删除一条VipCustdeal
	 * @param id
	 */
	public void deleteVipCustdeal(int id) throws RuntimeException {
		vipCustdealMapper.deleteVipCustdeal(new PojoDeleteCond(id));
	}

	/**
	 * 新增VipCustdeal
	 * @param vipCustdeal
	 */
	public void addVipCustdeal(VipCustdeal vipCustdeal) throws RuntimeException {		
		vipCustdealMapper.addVipCustdeal(vipCustdeal);
	}

	/**
	 * 查找一条VipCustdeal
	 * @return VipCustdeal
	 * @param id 主键id
	 */
	@Override
	public VipCustdeal findVipCustdealById(int id) throws RuntimeException {
		return vipCustdealMapper.findVipCustdealById(id);
	}
	
	/**
	 * 查找符合条件的记录条数VipCustdeal
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findVipCustdealCount(VipCustdealCond cond) throws RuntimeException {
		return vipCustdealMapper.findVipCustdealCount(cond);
	}

	/**
	 * 修改VipCustdeal
	 * @param vipCustdeal
	 */
	@Override
	public void updateVipCustdeal(VipCustdeal vipCustdeal) throws RuntimeException {
		vipCustdealMapper.updateVipCustdeal(vipCustdeal);		
	}
	    
	/**
	 * 分页查找VipCustdeal
	 * @param cond 查询条件
	 * @return VipCustdeal列表
	 */
	public List<VipCustdeal> findVipCustdealPage(VipCustdealCond cond) throws RuntimeException {
		int recordCount = vipCustdealMapper.findVipCustdealCount(cond);
		
		cond.recordCount = recordCount;
				
		return vipCustdealMapper.findVipCustdealPage(cond);
	}
        
	/**
	 * 查找全部VipCustdeal
	 * @param cond 查询条件
	 * @return VipCustdeal列表
	 */
	public List<VipCustdeal> findVipCustdeal(VipCustdealCond cond) throws RuntimeException {
    	return vipCustdealMapper.findVipCustdeal(cond);
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map> findVipCustdealgroup(VipCustdealCond cond) throws RuntimeException{
		return vipCustdealMapper.findVipCustdealgroup(cond);
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map> findVipCustdealCustIdgroup(VipCustdealCond cond) throws RuntimeException{
		return vipCustdealMapper.findVipCustdealCustIdgroup(cond);
	}
	
	/**
	 * 查看详细
	 * @param cond 查询条件
	 * @return VipCustdeal列表
	 */
	public List<Map> findVipCustAndDeal(VipCustdealCond cond) throws RuntimeException{
		return vipCustdealMapper.findVipCustAndDeal(cond);
	}
}
