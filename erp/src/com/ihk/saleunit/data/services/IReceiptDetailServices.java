package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ReceiptDetail;
import com.ihk.saleunit.data.pojo.ReceiptDetailCond;

/**
 * ReceiptDetail的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IReceiptDetailServices {
	/**
	 * 新增ReceiptDetail
	 * @param receiptDetail
	 */
	public void addReceiptDetail(ReceiptDetail receiptDetail) throws RuntimeException;

	/**
	 * 删除一条ReceiptDetail
	 * @param id
	 */
	public void deleteReceiptDetail(int id) throws RuntimeException;

	/**
	 * 修改ReceiptDetail
	 * @param receiptDetail
	 */
	public void updateReceiptDetail(ReceiptDetail receiptDetail) throws RuntimeException;

	/**
	 * 查找一条ReceiptDetail
	 * @return ReceiptDetail
	 * @param id 主键id
	 */
	public ReceiptDetail findReceiptDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找ReceiptDetail
	 * @param cond 查询条件
	 * @return ReceiptDetail列表
	 */
	public List<ReceiptDetail> findReceiptDetailPage(ReceiptDetailCond cond) throws RuntimeException;

	/**
	 * 查找全部ReceiptDetail
	 * @param cond 查询条件
	 * @return ReceiptDetail列表
	 */
	public List<ReceiptDetail> findReceiptDetail(ReceiptDetailCond cond) throws RuntimeException;
	
	/**
	 * 根据receiptId查找
	 * @param receiptId
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReceiptDetail> findReceiptDetailByReceiptId(int receiptId) throws RuntimeException;
	
	/**
	 * 根据billId查找
	 * @param billId
	 * @return
	 * @throws RuntimeException
	 */
	public ReceiptDetail findReceiptDetailByBillId(int billId) throws RuntimeException;
}