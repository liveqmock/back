package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IPayBillMapper;
import com.ihk.saleunit.data.pojo.PayBill;
import com.ihk.saleunit.data.pojo.PayBillCond;
import com.ihk.saleunit.data.services.IPayBillServices;

/**
 * PayBill的Services实现(业务实现)
 * @author 
 *
 */
@Service("payBillServices")
@SuppressWarnings("unchecked")
public class PayBillServices implements IPayBillServices {
	/**
	 * payBill数据访问接口
	 */
	@Autowired	 IPayBillMapper payBillMapper;

	/**
	 * 删除一条PayBill
	 * @param id
	 */
	public void deletePayBill(int id) throws RuntimeException {
		payBillMapper.deletePayBill(id);
	}

	/**
	 * 新增PayBill
	 * @param payBill
	 */
	public void addPayBill(PayBill payBill) throws RuntimeException {		
		payBillMapper.addPayBill(payBill);
	}

	/**
	 * 查找一条PayBill
	 * @return PayBill
	 * @param id 主键id
	 */
	@Override
	public PayBill findPayBillById(int id) throws RuntimeException {
		return payBillMapper.findPayBillById(id);
	}

	/**
	 * 修改PayBill
	 * @param payBill
	 */
	@Override
	public void updatePayBill(PayBill payBill) throws RuntimeException {
		payBillMapper.updatePayBill(payBill);		
	}

	/**
	 * 分页查找PayBill
	 * @param cond 查询条件
	 * @return PayBill列表
	 */
	public List<PayBill> findPayBillPage(PayBillCond cond) throws RuntimeException {
		int recordCount = payBillMapper.findPayBillCount(cond);
		
		cond.recordCount = recordCount;
				
		return payBillMapper.findPayBillPage(cond);
	}

	/**
	 * 查找全部PayBill
	 * @param cond 查询条件
	 * @return PayBill列表
	 */
	public List<PayBill> findPayBill(PayBillCond cond) throws RuntimeException {
    	return payBillMapper.findPayBill(cond);
	}
}
