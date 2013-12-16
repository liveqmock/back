package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.SaleUnitReceipt;
import com.ihk.saleunit.data.pojo.SaleUnitReceiptCond;

@Transactional 
public interface ISaleUnitReceiptServices {
	public void addSaleUnitReceipt(SaleUnitReceipt saleUnitReceipt) throws RuntimeException;

	public void deleteSaleUnitReceipt(int id) throws RuntimeException;

	public void updateSaleUnitReceipt(SaleUnitReceipt saleUnitReceipt) throws RuntimeException;

	public SaleUnitReceipt findSaleUnitReceiptById(int id) throws RuntimeException;
    
	public List<SaleUnitReceipt> findSaleUnitReceiptPage(SaleUnitReceiptCond cond) throws RuntimeException;
    
	public List<SaleUnitReceipt> findSaleUnitReceipt(SaleUnitReceiptCond cond) throws RuntimeException;
    
    /**
	 * ajax分页list
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public List<SaleUnitReceipt> findSaleUnitReceiptForAjax(SaleUnitReceiptCond cond) throws RuntimeException;
    
    /**
	 * ajax分页count
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public int findSaleUnitReceiptCountForAjax(SaleUnitReceiptCond cond) throws RuntimeException;
    
    /**
	 * 根据unitId 查找
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public List<SaleUnitReceipt> findReceiptListByUnitId(int unitId) throws RuntimeException;
	
	/**
	 * 根据billId 查找
	 * @param billId
	 * @return
	 * @throws RuntimeException
	 */
	public List<SaleUnitReceipt> findReceiptListByBillId(int billId) throws RuntimeException;
	
	/**
	 * 设置应收的对佣id
	 * @param receiptId
	 * @param checkFeeId
	 * @throws RuntimeException
	 */
	public void updateSaleUnitReceiptCheckFeeId(int receiptId, int checkFeeId) throws RuntimeException;

    /**
     * 设置应收的对佣id
     * @param checkFeeId
     * @throws RuntimeException
     */
	public void updateSaleUnitReceiptCheckCommissionId(int checkFeeId) throws RuntimeException;

}