package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IApPaymentMapper;
import com.ihk.saleunit.data.pojo.ApPayment;
import com.ihk.saleunit.data.pojo.ApPaymentCond;
import com.ihk.saleunit.data.services.IApPaymentServices;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * ApPayment的Services实现(业务实现)
 * @author 
 *
 */
@Service("apPaymentServices")
@SuppressWarnings("unchecked")
public class ApPaymentServices implements IApPaymentServices {
	/**
	 * apPayment数据访问接口
	 */
	@Autowired	 IApPaymentMapper apPaymentMapper;

	/**
	 * 删除一条ApPayment
	 * @param id
	 */
	public void deleteApPayment(int id) throws RuntimeException {
		apPaymentMapper.deleteApPayment(new PojoDeleteCond(id));
	}

	/**
	 * 新增ApPayment
	 * @param apPayment
	 */
	public void addApPayment(ApPayment apPayment) throws RuntimeException {		
		apPaymentMapper.addApPayment(apPayment);
	}

	/**
	 * 查找一条ApPayment
	 * @return ApPayment
	 * @param id 主键id
	 */
	@Override
	public ApPayment findApPaymentById(int id) throws RuntimeException {
		return apPaymentMapper.findApPaymentById(id);
	}

	/**
	 * 修改ApPayment
	 * @param apPayment
	 */
	@Override
	public void updateApPayment(ApPayment apPayment) throws RuntimeException {
		apPaymentMapper.updateApPayment(apPayment);		
	}
	    
	/**
	 * 分页查找ApPayment
	 * @param cond 查询条件
	 * @return ApPayment列表
	 */
	public List<ApPayment> findApPaymentPage(ApPaymentCond cond) throws RuntimeException {
		int recordCount = apPaymentMapper.findApPaymentCount(cond);
		
		cond.recordCount = recordCount;
				
		return apPaymentMapper.findApPaymentPage(cond);
	}
        
	/**
	 * 查找全部ApPayment
	 * @param cond 查询条件
	 * @return ApPayment列表
	 */
	public List<ApPayment> findApPayment(ApPaymentCond cond) throws RuntimeException {
    	return apPaymentMapper.findApPayment(cond);
	}
	
	/**
	 * 查找总数
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public int findApPaymentCount(ApPaymentCond cond) throws RuntimeException {
		return apPaymentMapper.findApPaymentCount(cond);
	}
}
