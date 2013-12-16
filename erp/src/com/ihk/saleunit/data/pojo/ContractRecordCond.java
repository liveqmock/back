package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.util.List;

import com.ihk.utils.SearchCond;

/**
 * ContractRecord的查询条件
 * @author peter.kuang
 *
 */
public class ContractRecordCond extends SearchCond{
	
	private List<Integer> ids;
	
	private String contractNoLike;	
    
	private Date date1;
	private Date date2;
	
	private String customerNameLike;
	
	private String saleUser;
	
	public List<Integer> getIds() {
		return ids;
	}

	public ContractRecordCond setIds(List<Integer> ids) {
		this.ids = ids;
		return this;
	}

	public String getContractNoLike() {
		return contractNoLike;
	}

	public void setContractNoLike(String contractNoLike) {
		this.contractNoLike = contractNoLike;
	}
	
	
}
