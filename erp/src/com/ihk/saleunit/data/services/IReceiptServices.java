package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.Receipt;
import com.ihk.saleunit.data.pojo.ReceiptCond;

/**
 * Receipt的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IReceiptServices {
	/**
	 * 新增Receipt
	 * @param receipt
	 */
	public void addReceipt(Receipt receipt) throws RuntimeException;

	/**
	 * 删除一条Receipt
	 * @param id
	 */
	public void deleteReceipt(int id) throws RuntimeException;

	/**
	 * 修改Receipt
	 * @param receipt
	 */
	public void updateReceipt(Receipt receipt) throws RuntimeException;

	/**
	 * 查找一条Receipt
	 * @return Receipt
	 * @param id 主键id
	 */
	public Receipt findReceiptById(int id) throws RuntimeException;

	/**
	 * 分页查找Receipt
	 * @param cond 查询条件
	 * @return Receipt列表
	 */
	public List<Receipt> findReceiptPage(ReceiptCond cond) throws RuntimeException;

	/**
	 * 查找全部Receipt
	 * @param cond 查询条件
	 * @return Receipt列表
	 */
	public List<Receipt> findReceipt(ReceiptCond cond) throws RuntimeException;
	
	/**
	 * 根据unitId 查找
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public List<Receipt> findReceiptByUnitId(int unitId) throws RuntimeException;
}