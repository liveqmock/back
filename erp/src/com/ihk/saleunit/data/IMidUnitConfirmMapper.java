package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.MidUnitConfirm;
import com.ihk.saleunit.data.pojo.MidUnitConfirmCond;

import com.ihk.utils.base.PojoDeleteCond;
 
public interface IMidUnitConfirmMapper {

	public void addMidUnitConfirm(MidUnitConfirm midUnitConfirm) ;

	public void deleteMidUnitConfirm(PojoDeleteCond cond) throws RuntimeException;

	public void updateMidUnitConfirm(MidUnitConfirm midUnitConfirm) throws RuntimeException;
	
	public MidUnitConfirm findMidUnitConfirmById(int id) throws RuntimeException;
	
	public List<MidUnitConfirm> findMidUnitConfirmPage(MidUnitConfirmCond cond) ;
    
	public List<MidUnitConfirm> findMidUnitConfirm(MidUnitConfirmCond cond) ;
    
	public int findMidUnitConfirmCount(MidUnitConfirmCond cond) ;
    
    /**
	 * ajax分页list
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public List<MidUnitConfirm> findMidUnitConfirmForAjax(MidUnitConfirmCond cond) ;
    
    /**
	 * ajax分页count
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public int findMidUnitConfirmCountForAjax(MidUnitConfirmCond cond) ;
}
