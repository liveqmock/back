package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.PayWayDiscount;
import com.ihk.property.data.pojo.PayWayDiscountCond;

@Transactional 
public interface IPayWayDiscountServices {
	public void addPayWayDiscount(PayWayDiscount payWayDiscount) throws RuntimeException;

	public void deletePayWayDiscount(int id) throws RuntimeException;

	public void updatePayWayDiscount(PayWayDiscount payWayDiscount) throws RuntimeException;

	public PayWayDiscount findPayWayDiscountById(int id) throws RuntimeException;
    
	public List<PayWayDiscount> findPayWayDiscountPage(PayWayDiscountCond cond) throws RuntimeException;
    
	public List<PayWayDiscount> findPayWayDiscount(PayWayDiscountCond cond) throws RuntimeException;
	
	public List<PayWayDiscount> findPayWayDiscountByPayWayId(int payWayId) throws RuntimeException;
	
	public void deletePayWayDiscountByPayWayId(int payWayId) throws RuntimeException;
	
	public List<PayWayDiscount> findPayWayDiscountByUnitDiscountId(int discountId) throws RuntimeException;
}