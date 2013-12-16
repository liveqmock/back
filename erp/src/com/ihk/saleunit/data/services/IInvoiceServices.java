package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.Invoice;
import com.ihk.saleunit.data.pojo.InvoiceCond;

/**
 * Invoice的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IInvoiceServices {
	/**
	 * 新增Invoice
	 * @param invoice
	 */
	public void addInvoice(Invoice invoice) throws RuntimeException;

	/**
	 * 删除一条Invoice
	 * @param id
	 */
	public void deleteInvoice(int id) throws RuntimeException;

	/**
	 * 修改Invoice
	 * @param invoice
	 */
	public void updateInvoice(Invoice invoice) throws RuntimeException;

	/**
	 * 查找一条Invoice
	 * @return Invoice
	 * @param id 主键id
	 */
	public Invoice findInvoiceById(int id) throws RuntimeException;

	/**
	 * 分页查找Invoice
	 * @param cond 查询条件
	 * @return Invoice列表
	 */
	public List<Invoice> findInvoicePage(InvoiceCond cond) throws RuntimeException;

	/**
	 * 查找全部Invoice
	 * @param cond 查询条件
	 * @return Invoice列表
	 */
	public List<Invoice> findInvoice(InvoiceCond cond) throws RuntimeException;
}