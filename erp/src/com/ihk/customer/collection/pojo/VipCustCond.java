package com.ihk.customer.collection.pojo;

import java.util.Date;
import java.util.List;

import com.ihk.utils.SearchCond;

/**
 * VipCust的查询条件
 * @author 
 *
 */
public class VipCustCond extends SearchCond{

	private static final long serialVersionUID = 1L;
	private String idcardNo;
	private String customerNo;	
	private String customerName;
	private int companyId;
	private List<Integer> refList;   //id的集合

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public List<Integer> getRefList() {
		return refList;
	}

	public void setRefList(List<Integer> refList) {
		this.refList = refList;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
    
	public String getSearchName() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
