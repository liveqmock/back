package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IOtherExpensesMapper;
import com.ihk.saleunit.data.pojo.OtherExpenses;
import com.ihk.saleunit.data.pojo.OtherExpensesCond;
import com.ihk.saleunit.data.services.IOtherExpensesServices;

import com.ihk.utils.base.PojoDeleteCond;

@Service("otherExpensesServices")
public class OtherExpensesServices implements IOtherExpensesServices {
	@Autowired	 IOtherExpensesMapper otherExpensesMapper;

	public void deleteOtherExpenses(int id) throws RuntimeException {
		otherExpensesMapper.deleteOtherExpenses(new PojoDeleteCond(id));
	}

	public void addOtherExpenses(OtherExpenses otherExpenses) throws RuntimeException {		
		otherExpensesMapper.addOtherExpenses(otherExpenses);
	}

	@Override
	public OtherExpenses findOtherExpensesById(int id) throws RuntimeException {
		return otherExpensesMapper.findOtherExpensesById(id);
	}

	@Override
	public void updateOtherExpenses(OtherExpenses otherExpenses) throws RuntimeException {
		otherExpensesMapper.updateOtherExpenses(otherExpenses);		
	}
	
	@Override
	public List<OtherExpenses> findOtherExpensesPage(OtherExpensesCond cond) throws RuntimeException {
		int recordCount = otherExpensesMapper.findOtherExpensesCount(cond);
		
		cond.recordCount = recordCount;
				
		return otherExpensesMapper.findOtherExpensesPage(cond);
	}
    
	@Override
	public List<OtherExpenses> findOtherExpenses(OtherExpensesCond cond) throws RuntimeException {
    	return otherExpensesMapper.findOtherExpenses(cond);
	}

	@Override
	public List<OtherExpenses> findOtherExpensesForAjax(OtherExpensesCond cond)
			throws RuntimeException {
		return otherExpensesMapper.findOtherExpensesForAjax(cond);
	}

	@Override
	public int findOtherExpensesCountForAjax(OtherExpensesCond cond)
			throws RuntimeException {
		return otherExpensesMapper.findOtherExpensesCountForAjax(cond);
	}
	
	@Override
	public List<Map> findOtherExpensesByProjectIds(Map list)
			throws RuntimeException {
		return otherExpensesMapper.findOtherExpensesByProjectIds(list);
	}
}
