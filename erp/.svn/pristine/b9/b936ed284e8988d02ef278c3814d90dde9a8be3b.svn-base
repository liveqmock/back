package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.SaleUnitReceipt;
import com.ihk.saleunit.data.pojo.SaleUnitReceiptCond;

import com.ihk.utils.base.PojoDeleteCond;
 
public interface ISaleUnitReceiptMapper {

	public void addSaleUnitReceipt(SaleUnitReceipt saleUnitReceipt) ;

	public void deleteSaleUnitReceipt(PojoDeleteCond cond) throws RuntimeException;

	public void updateSaleUnitReceipt(SaleUnitReceipt saleUnitReceipt) throws RuntimeException;
	
	public SaleUnitReceipt findSaleUnitReceiptById(int id) throws RuntimeException;
	
	public List<SaleUnitReceipt> findSaleUnitReceiptPage(SaleUnitReceiptCond cond) ;
    
	public List<SaleUnitReceipt> findSaleUnitReceipt(SaleUnitReceiptCond cond) ;
    
	public int findSaleUnitReceiptCount(SaleUnitReceiptCond cond) ;
    
    /**
	 * ajax分页list
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public List<SaleUnitReceipt> findSaleUnitReceiptForAjax(SaleUnitReceiptCond cond) ;
    
    /**
	 * ajax分页count
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public int findSaleUnitReceiptCountForAjax(SaleUnitReceiptCond cond) ;
    
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
	 * @param cond
	 * @throws RuntimeException
	 */
	public void updateSaleUnitReceiptCheckFeeId(SaleUnitReceiptCond cond) throws RuntimeException;

    /**
     * 设置应收的对佣id
     * @param cond
     * @throws RuntimeException
     */
	public void updateSaleUnitReceiptCheckCommissionId(SaleUnitReceiptCond cond) throws RuntimeException;

}
