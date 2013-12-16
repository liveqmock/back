package com.ihk.saleunit.data;

import java.util.List;
import java.util.Map;

import com.ihk.saleunit.data.pojo.OtherExpenses;
import com.ihk.saleunit.data.pojo.OtherExpensesCond;

import com.ihk.utils.base.PojoDeleteCond;
 
public interface IOtherExpensesMapper {

	public void addOtherExpenses(OtherExpenses otherExpenses) ;

	public void deleteOtherExpenses(PojoDeleteCond cond) throws RuntimeException;

	public void updateOtherExpenses(OtherExpenses otherExpenses) throws RuntimeException;
	
	public OtherExpenses findOtherExpensesById(int id) throws RuntimeException;
	
	public List<OtherExpenses> findOtherExpensesPage(OtherExpensesCond cond) ;
    
	public List<OtherExpenses> findOtherExpenses(OtherExpensesCond cond) ;
    
	public int findOtherExpensesCount(OtherExpensesCond cond) ;
	
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
