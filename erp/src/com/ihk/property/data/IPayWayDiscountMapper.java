package com.ihk.property.data;

import java.util.List;

import com.ihk.property.data.pojo.PayWayDiscount;
import com.ihk.property.data.pojo.PayWayDiscountCond;
import com.ihk.utils.base.PojoDeleteCond;
 
public interface IPayWayDiscountMapper {

	public void addPayWayDiscount(PayWayDiscount payWayDiscount) ;

	public void deletePayWayDiscount(PojoDeleteCond cond) throws RuntimeException;

	public void updatePayWayDiscount(PayWayDiscount payWayDiscount) throws RuntimeException;
	
	public PayWayDiscount findPayWayDiscountById(int id) throws RuntimeException;
	
	public List<PayWayDiscount> findPayWayDiscountPage(PayWayDiscountCond cond) ;
    
	public List<PayWayDiscount> findPayWayDiscount(PayWayDiscountCond cond) ;
    
	public int findPayWayDiscountCount(PayWayDiscountCond cond) ;
	
	public List<PayWayDiscount> findPayWayDiscountByPayWayId(int payWayId) throws RuntimeException;
	
	public void deletePayWayDiscountByPayWayId(int payWayId) throws RuntimeException;
	
	public List<PayWayDiscount> findPayWayDiscountByUnitDiscountId(int discountId) throws RuntimeException;
}
