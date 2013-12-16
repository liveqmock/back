package com.ihk.property.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IPayWayDiscountMapper;
import com.ihk.property.data.pojo.PayWayDiscount;
import com.ihk.property.data.pojo.PayWayDiscountCond;
import com.ihk.property.data.services.IPayWayDiscountServices;

import com.ihk.utils.base.PojoDeleteCond;

@Service("payWayDiscountServices")
public class PayWayDiscountServices implements IPayWayDiscountServices {
	@Autowired	 IPayWayDiscountMapper payWayDiscountMapper;

	public void deletePayWayDiscount(int id) throws RuntimeException {
		payWayDiscountMapper.deletePayWayDiscount(new PojoDeleteCond(id));
	}

	public void addPayWayDiscount(PayWayDiscount payWayDiscount) throws RuntimeException {		
		payWayDiscountMapper.addPayWayDiscount(payWayDiscount);
	}

	@Override
	public PayWayDiscount findPayWayDiscountById(int id) throws RuntimeException {
		return payWayDiscountMapper.findPayWayDiscountById(id);
	}

	@Override
	public void updatePayWayDiscount(PayWayDiscount payWayDiscount) throws RuntimeException {
		payWayDiscountMapper.updatePayWayDiscount(payWayDiscount);		
	}
	
	public List<PayWayDiscount> findPayWayDiscountPage(PayWayDiscountCond cond) throws RuntimeException {
		int recordCount = payWayDiscountMapper.findPayWayDiscountCount(cond);
		
		cond.recordCount = recordCount;
				
		return payWayDiscountMapper.findPayWayDiscountPage(cond);
	}
    
	public List<PayWayDiscount> findPayWayDiscount(PayWayDiscountCond cond) throws RuntimeException {
    	return payWayDiscountMapper.findPayWayDiscount(cond);
	}

	@Override
	public List<PayWayDiscount> findPayWayDiscountByPayWayId(int payWayId)
			throws RuntimeException {
		return payWayDiscountMapper.findPayWayDiscountByPayWayId(payWayId);
	}

	@Override
	public void deletePayWayDiscountByPayWayId(int payWayId)
			throws RuntimeException {
		payWayDiscountMapper.deletePayWayDiscountByPayWayId(payWayId);
	}

	@Override
	public List<PayWayDiscount> findPayWayDiscountByUnitDiscountId(
			int discountId) throws RuntimeException {
		return payWayDiscountMapper.findPayWayDiscountByUnitDiscountId(discountId);
	}
}
