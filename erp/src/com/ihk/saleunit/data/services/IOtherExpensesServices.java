package com.ihk.saleunit.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.OtherExpenses;
import com.ihk.saleunit.data.pojo.OtherExpensesCond;

@Transactional 
public interface IOtherExpensesServices {
	public void addOtherExpenses(OtherExpenses otherExpenses) throws RuntimeException;

	public void deleteOtherExpenses(int id) throws RuntimeException;

	public void updateOtherExpenses(OtherExpenses otherExpenses) throws RuntimeException;

	public OtherExpenses findOtherExpensesById(int id) throws RuntimeException;
    
	public List<OtherExpenses> findOtherExpensesPage(OtherExpensesCond cond) throws RuntimeException;
    
	public List<OtherExpenses> findOtherExpenses(OtherExpensesCond cond) throws RuntimeException;
	
	/**
	 * ajax分页list
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<OtherExpenses> findOtherExpensesForAjax(OtherExpensesCond cond) throws RuntimeException;
	
	/**
	 * ajax分页count
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public int findOtherExpensesCountForAjax(OtherExpensesCond cond) throws RuntimeException;
	
	public List<Map> findOtherExpensesByProjectIds(Map ids) throws RuntimeException;
	
}