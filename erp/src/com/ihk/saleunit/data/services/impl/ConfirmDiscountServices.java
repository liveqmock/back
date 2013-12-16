package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IConfirmDiscountMapper;
import com.ihk.saleunit.data.pojo.ConfirmDiscount;
import com.ihk.saleunit.data.pojo.ConfirmDiscountCond;
import com.ihk.saleunit.data.services.IConfirmDiscountServices;
import com.ihk.utils.base.PojoDeleteCond;

@Service("confirmDiscountServices")
public class ConfirmDiscountServices implements IConfirmDiscountServices {
	@Autowired	 IConfirmDiscountMapper confirmDiscountMapper;

	public void deleteConfirmDiscount(int id) throws RuntimeException {
		confirmDiscountMapper.deleteConfirmDiscount(new PojoDeleteCond(id));
	}

	public void addConfirmDiscount(ConfirmDiscount confirmDiscount) throws RuntimeException {		
		confirmDiscountMapper.addConfirmDiscount(confirmDiscount);
	}

	@Override
	public ConfirmDiscount findConfirmDiscountById(int id) throws RuntimeException {
		return confirmDiscountMapper.findConfirmDiscountById(id);
	}

	@Override
	public void updateConfirmDiscount(ConfirmDiscount confirmDiscount) throws RuntimeException {
		confirmDiscountMapper.updateConfirmDiscount(confirmDiscount);		
	}
	
	public List<ConfirmDiscount> findConfirmDiscountPage(ConfirmDiscountCond cond) throws RuntimeException {
		int recordCount = confirmDiscountMapper.findConfirmDiscountCount(cond);
		
		cond.recordCount = recordCount;
				
		return confirmDiscountMapper.findConfirmDiscountPage(cond);
	}
    
	public List<ConfirmDiscount> findConfirmDiscount(ConfirmDiscountCond cond) throws RuntimeException {
    	return confirmDiscountMapper.findConfirmDiscount(cond);
	}

	@Override
	public void deleteConfirmDiscountByUnitDiscountId(int unitDiscountId)
			throws RuntimeException {
		confirmDiscountMapper.deleteConfirmDiscountByUnitDiscountId(unitDiscountId);
	}

}
