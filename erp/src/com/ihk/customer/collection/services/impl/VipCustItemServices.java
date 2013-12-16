package com.ihk.customer.collection.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.collection.IVipCustItemMapper;
import com.ihk.customer.collection.pojo.VipCustItem;
import com.ihk.customer.collection.pojo.VipCustItemCond;
import com.ihk.customer.collection.services.IVipCustItemServices;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * VipCustItem的Services实现(业务实现)
 * @author 
 *
 */
@Service("vipCustItemServices")
@SuppressWarnings("unchecked")
public class VipCustItemServices implements IVipCustItemServices {
	/**
	 * vipCustItem数据访问接口
	 */
	@Autowired	 IVipCustItemMapper vipCustItemMapper;

	/**
	 * 删除一条VipCustItem
	 * @param id
	 */
	public void deleteVipCustItem(int id) throws RuntimeException {
		vipCustItemMapper.deleteVipCustItem(new PojoDeleteCond(id));
	}

	/**
	 * 新增VipCustItem
	 * @param vipCustItem
	 */
	public void addVipCustItem(VipCustItem vipCustItem) throws RuntimeException {		
		vipCustItemMapper.addVipCustItem(vipCustItem);
	}

	/**
	 * 查找一条VipCustItem
	 * @return VipCustItem
	 * @param id 主键id
	 */
	@Override
	public VipCustItem findVipCustItemById(int id) throws RuntimeException {
		return vipCustItemMapper.findVipCustItemById(id);
	}

	/**
	 * 修改VipCustItem
	 * @param vipCustItem
	 */
	@Override
	public void updateVipCustItem(VipCustItem vipCustItem) throws RuntimeException {
		vipCustItemMapper.updateVipCustItem(vipCustItem);		
	}
	    
	/**
	 * 分页查找VipCustItem
	 * @param cond 查询条件
	 * @return VipCustItem列表
	 */
	public List<VipCustItem> findVipCustItemPage(VipCustItemCond cond) throws RuntimeException {
		int recordCount = vipCustItemMapper.findVipCustItemCount(cond);
		
		cond.recordCount = recordCount;
				
		return vipCustItemMapper.findVipCustItemPage(cond);
	}
        
	/**
	 * 查找全部VipCustItem
	 * @param cond 查询条件
	 * @return VipCustItem列表
	 */
	public List<VipCustItem> findVipCustItem(VipCustItemCond cond) throws RuntimeException {
    	return vipCustItemMapper.findVipCustItem(cond);
	}
}
