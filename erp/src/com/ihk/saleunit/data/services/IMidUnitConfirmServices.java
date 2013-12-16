package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.MidUnitConfirm;
import com.ihk.saleunit.data.pojo.MidUnitConfirmCond;

@Transactional 
public interface IMidUnitConfirmServices {
	public void addMidUnitConfirm(MidUnitConfirm midUnitConfirm) throws RuntimeException;

	public void deleteMidUnitConfirm(int id) throws RuntimeException;

	public void updateMidUnitConfirm(MidUnitConfirm midUnitConfirm) throws RuntimeException;

	public MidUnitConfirm findMidUnitConfirmById(int id) throws RuntimeException;
    
	public List<MidUnitConfirm> findMidUnitConfirmPage(MidUnitConfirmCond cond) throws RuntimeException;
    
	public List<MidUnitConfirm> findMidUnitConfirm(MidUnitConfirmCond cond) throws RuntimeException;
    
    /**
	 * ajax分页list
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public List<MidUnitConfirm> findMidUnitConfirmForAjax(MidUnitConfirmCond cond) throws RuntimeException;
    
    /**
	 * ajax分页count
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public int findMidUnitConfirmCountForAjax(MidUnitConfirmCond cond) throws RuntimeException;
    
}