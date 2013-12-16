package com.ihk.saleunit.data.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * ArAmount的查询条件
 * @author 
 *
 */
public class ArAmountCond extends SearchCond{

	private static final long serialVersionUID = 1L;

    private int tranId ;
    private int build_id ;
    private String impdate;

    private String str_sort;
    private String str_order;

    public String getStr_sort() {
        return str_sort;
    }

    public void setStr_sort(String str_sort) {
        this.str_sort = str_sort;
    }

    public String getStr_order() {
        return str_order;
    }

    public void setStr_order(String str_order) {
        this.str_order = str_order;
    }

    /**
     * 认购合同ID
     * @return  int
     */
    public int getTranId() {
        return tranId;
    }

    public void setTranId(int tranId) {
        this.tranId = tranId;
    }

    public int getBuild_id() {
        return build_id;
    }

    public void setBuild_id(int build_id) {
        this.build_id = build_id;
    }

    public String getImpdate() {
        return impdate;
    }

    public void setImpdate(String impdate) {
        this.impdate = impdate;
    }

    /*
	private String companyId;	
    
	public String getSearchName() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
    */
}
