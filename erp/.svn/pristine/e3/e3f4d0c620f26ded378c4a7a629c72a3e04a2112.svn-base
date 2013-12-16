package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ConfirmDiscount;
import com.ihk.saleunit.data.pojo.ConfirmDiscountCond;

@Transactional 
public interface IConfirmDiscountServices {
	public void addConfirmDiscount(ConfirmDiscount confirmDiscount) throws RuntimeException;

	public void deleteConfirmDiscount(int id) throws RuntimeException;

	public void updateConfirmDiscount(ConfirmDiscount confirmDiscount) throws RuntimeException;

	public ConfirmDiscount findConfirmDiscountById(int id) throws RuntimeException;
    
	public List<ConfirmDiscount> findConfirmDiscountPage(ConfirmDiscountCond cond) throws RuntimeException;
    
	public List<ConfirmDiscount> findConfirmDiscount(ConfirmDiscountCond cond) throws RuntimeException;
	
	/**
	 * 根据单元折扣id,删除认购合同单的完整折扣
	 * @param unitDiscountId
	 * @throws RuntimeException
	 */
	public void deleteConfirmDiscountByUnitDiscountId(int unitDiscountId) throws RuntimeException;
	
}