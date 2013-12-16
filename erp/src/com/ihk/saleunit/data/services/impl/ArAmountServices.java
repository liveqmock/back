package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IArAmountMapper;
import com.ihk.saleunit.data.pojo.ArAmount;
import com.ihk.saleunit.data.pojo.ArAmountCond;
import com.ihk.saleunit.data.services.IArAmountServices;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * ArAmount的Services实现(业务实现)
 * @author 
 *
 */
@Service("arAmountServices")
@SuppressWarnings("unchecked")
public class ArAmountServices implements IArAmountServices {
	/**
	 * arAmount数据访问接口
	 */
	@Autowired	 IArAmountMapper arAmountMapper;

	/**
	 * 删除一条ArAmount
	 * @param id
	 */
	public void deleteArAmount(int id) throws RuntimeException {
		arAmountMapper.deleteArAmount(new PojoDeleteCond(id));
	}

	/**
	 * 新增ArAmount
	 * @param arAmount
	 */
	public void addArAmount(ArAmount arAmount) throws RuntimeException {		
		arAmountMapper.addArAmount(arAmount);
	}

	/**
	 * 查找一条ArAmount
	 * @return ArAmount
	 * @param id 主键id
	 */
	@Override
	public ArAmount findArAmountById(int id) throws RuntimeException {
		return arAmountMapper.findArAmountById(id);
	}

	/**
	 * 修改ArAmount
	 * @param arAmount
	 */
	@Override
	public void updateArAmount(ArAmount arAmount) throws RuntimeException {
		arAmountMapper.updateArAmount(arAmount);		
	}
	    
	/**
	 * 分页查找ArAmount
	 * @param cond 查询条件
	 * @return ArAmount列表
	 */
	public List<ArAmount> findArAmountPage(ArAmountCond cond) throws RuntimeException {
		int recordCount = arAmountMapper.findArAmountCount(cond);
		
		cond.recordCount = recordCount;
				
		return arAmountMapper.findArAmountPage(cond);
	}
        
	/**
	 * 查找全部ArAmount
	 * @param cond 查询条件
	 * @return ArAmount列表
	 */
	public List<ArAmount> findArAmount(ArAmountCond cond) throws RuntimeException {
    	return arAmountMapper.findArAmount(cond);
	}
	
	public int findArAmountCount(ArAmountCond cond) throws RuntimeException {
		return arAmountMapper.findArAmountCount(cond);
	}
}
