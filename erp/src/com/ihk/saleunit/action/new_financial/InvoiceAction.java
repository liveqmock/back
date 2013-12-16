package com.ihk.saleunit.action.new_financial;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Invoice;
import com.ihk.saleunit.data.pojo.InvoiceCond;
import com.ihk.saleunit.data.services.IInvoiceServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 发票
 */
public class InvoiceAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	@Autowired IPropertyUnitServices propertyUnitServices;
	@Autowired IInvoiceServices invoiceServices;
	
	private int id;//unit id
	private Invoice selectInvoice;
	private List<Invoice> listInvoice;
	private int invoiceId;//选中的发票ID
	
	public String tabInfo(){
		PropertyUnit seleUnit = propertyUnitServices.findPropertyUnitById(id);
		
		
		InvoiceCond cond = new InvoiceCond();
		cond.setUnitId(id+"");
		listInvoice = invoiceServices.findInvoice(cond);
		return "suc";
	}
	
	public String dialogAdd(){
		return "suc";
	}
	
	public String dialogAddForm(){
		try {
			CommonPojoUtils.initPojoCommonFiled(selectInvoice);
			selectInvoice.setIsVoid("0");
			selectInvoice.setUnitId(id);
			invoiceServices.addInvoice(selectInvoice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "suc";
	}
	
	public String dialogUpdate(){
		selectInvoice = invoiceServices.findInvoiceById(invoiceId);
		return "suc";
	}
	
	public String dialogUpdateForm(){
		Invoice tselectInvoice = invoiceServices.findInvoiceById(invoiceId);
		tselectInvoice.setInvoiceNo(selectInvoice.getInvoiceNo());
		tselectInvoice.setInvoiceMoney(selectInvoice.getInvoiceMoney());
		tselectInvoice.setInvoeceDate(selectInvoice.getInvoeceDate());
		tselectInvoice.setRemark(selectInvoice.getRemark());
		tselectInvoice.setReceiveMan(selectInvoice.getReceiveMan());
		tselectInvoice.setReceiveDate(selectInvoice.getReceiveDate());
		tselectInvoice.setReceiveManDo(selectInvoice.getReceiveManDo());
		tselectInvoice.setReceiveDateDo(selectInvoice.getReceiveDateDo());
		tselectInvoice.setModId(SessionUser.getUserId());
		tselectInvoice.setModTime(new Date());
		
		invoiceServices.updateInvoice(tselectInvoice);
		return "suc";
	}
	
	
	public String invoiceDel(){
		invoiceServices.deleteInvoice(invoiceId);
		return null;
	}
	
	public String invoiceDis(){
		Invoice tinvoice = invoiceServices.findInvoiceById(invoiceId);
		tinvoice.setIsVoid("1");
		tinvoice.setModId(SessionUser.getUserId());
		tinvoice.setModTime(new Date());
		invoiceServices.updateInvoice(tinvoice);
		return null;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Invoice getSelectInvoice() {
		return selectInvoice;
	}

	public void setSelectInvoice(Invoice selectInvoice) {
		this.selectInvoice = selectInvoice;
	}

	public List<Invoice> getListInvoice() {
		return listInvoice;
	}

	public void setListInvoice(List<Invoice> listInvoice) {
		this.listInvoice = listInvoice;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	
	
	
}
