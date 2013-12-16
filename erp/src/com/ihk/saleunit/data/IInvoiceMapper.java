package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.Invoice;
import com.ihk.saleunit.data.pojo.InvoiceCond;

/**
 * Invoice数据访问接口Mapper
 * @author 
 *
 */  
public interface IInvoiceMapper {

	/**
	 * 新增Invoice
	 * @param invoice
	 */
	public void addInvoice(Invoice invoice) ;

	/**
	 * 根据条件删除Invoice
	 * @param cond 删除条件
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
	public List<Invoice> findInvoicePage(InvoiceCond cond) ;

	/**
	 * 查找全部Invoice
	 * @param cond 查询条件
	 * @return Invoice列表
	 */
	public List<Invoice> findInvoice(InvoiceCond cond) ;

	/**
	 * 查找符合条件的记录条数Invoice
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findInvoiceCount(InvoiceCond cond) ;
}
