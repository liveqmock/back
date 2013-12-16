package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IInvoiceMapper;
import com.ihk.saleunit.data.pojo.Invoice;
import com.ihk.saleunit.data.pojo.InvoiceCond;
import com.ihk.saleunit.data.services.IInvoiceServices;

/**
 * Invoice的Services实现(业务实现)
 * @author 
 *
 */
@Service("invoiceServices")
@SuppressWarnings("unchecked")
public class InvoiceServices implements IInvoiceServices {
	/**
	 * invoice数据访问接口
	 */
	@Autowired	 IInvoiceMapper invoiceMapper;

	/**
	 * 删除一条Invoice
	 * @param id
	 */
	public void deleteInvoice(int id) throws RuntimeException {
		invoiceMapper.deleteInvoice(id);
	}

	/**
	 * 新增Invoice
	 * @param invoice
	 */
	public void addInvoice(Invoice invoice) throws RuntimeException {		
		invoiceMapper.addInvoice(invoice);
	}

	/**
	 * 查找一条Invoice
	 * @return Invoice
	 * @param id 主键id
	 */
	@Override
	public Invoice findInvoiceById(int id) throws RuntimeException {
		return invoiceMapper.findInvoiceById(id);
	}

	/**
	 * 修改Invoice
	 * @param invoice
	 */
	@Override
	public void updateInvoice(Invoice invoice) throws RuntimeException {
		invoiceMapper.updateInvoice(invoice);		
	}

	/**
	 * 分页查找Invoice
	 * @param cond 查询条件
	 * @return Invoice列表
	 */
	public List<Invoice> findInvoicePage(InvoiceCond cond) throws RuntimeException {
		int recordCount = invoiceMapper.findInvoiceCount(cond);
		
		cond.recordCount = recordCount;
				
		return invoiceMapper.findInvoicePage(cond);
	}

	/**
	 * 查找全部Invoice
	 * @param cond 查询条件
	 * @return Invoice列表
	 */
	public List<Invoice> findInvoice(InvoiceCond cond) throws RuntimeException {
    	return invoiceMapper.findInvoice(cond);
	}
}
