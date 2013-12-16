package com.ihk.saleunit.action.contract_record;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.ContractRecord;
import com.ihk.saleunit.data.pojo.ContractRecordCond;
import com.ihk.saleunit.data.services.IContractRecordServices;
import com.ihk.utils.SupperAction;

/**
 * 查看主table
 * */
public class ContractRecordForShowAction extends SupperAction{

	
	@Autowired IContractRecordServices contractRecordServices;
	
	private List<ContractRecord> contRecTableList;
	private ContractRecordCond cond;
	
	public String showTable(){
		if(cond ==null)cond = new ContractRecordCond();
		
		contRecTableList = contractRecordServices.findContractRecord(cond);
		
		return "suc";
	}

	public List<ContractRecord> getContRecTableList() {
		return contRecTableList;
	}

	public void setContRecTableList(List<ContractRecord> contRecTableList) {
		this.contRecTableList = contRecTableList;
	}

	public ContractRecordCond getCond() {
		return cond;
	}

	public void setCond(ContractRecordCond cond) {
		this.cond = cond;
	}
	
	
	
}
