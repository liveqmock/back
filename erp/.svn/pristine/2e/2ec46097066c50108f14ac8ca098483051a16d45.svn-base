package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.ConfirmDiscount;
import com.ihk.saleunit.data.pojo.ConfirmDiscountCond;
import com.ihk.utils.base.PojoDeleteCond;
 
public interface IConfirmDiscountMapper {

	public void addConfirmDiscount(ConfirmDiscount confirmDiscount) ;

	public void deleteConfirmDiscount(PojoDeleteCond cond) throws RuntimeException;

	public void updateConfirmDiscount(ConfirmDiscount confirmDiscount) throws RuntimeException;
	
	public ConfirmDiscount findConfirmDiscountById(int id) throws RuntimeException;
	
	public List<ConfirmDiscount> findConfirmDiscountPage(ConfirmDiscountCond cond) ;
    
	public List<ConfirmDiscount> findConfirmDiscount(ConfirmDiscountCond cond) ;
    
	public int findConfirmDiscountCount(ConfirmDiscountCond cond) ;
	
	/**
	 * 根据单元折扣id,删除认购合同单的完整折扣
	 * @param unitDiscountId
	 * @throws RuntimeException
	 */
	public void deleteConfirmDiscountByUnitDiscountId(int unitDiscountId) throws RuntimeException;
	
}
