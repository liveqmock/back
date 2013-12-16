package com.ihk.saleunit.action.contract;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractRenovate;
import com.ihk.saleunit.data.pojo.ContractRenovateCond;
import com.ihk.saleunit.data.services.IContractRenovateServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 * 合同个性装修
 */
@SuppressWarnings("rawtypes")
public class GuangZhouContractRenovateAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IContractRenovateServices contractRenovateServices;
	@Autowired
	IContractServices contractServices;
	
	public String search() throws Exception{
		
		int contractId = Integer.parseInt(request.getParameter("contractId"));
		contract = contractServices.findContractById(contractId);
		
		ContractRenovateCond cond = new ContractRenovateCond();
		cond.setContractId(contractId + "");
		
		contractRenovateList = contractRenovateServices.findContractRenovate(cond);
		
		removeSuggestion();
		
		return "search";
	}
	
	public String forInput() throws Exception{
		
		contractId = request.getParameter("contractId");
		
		init();
		
		removeSuggestion();
			
		return "forInput";
	}
	
	public String input() throws Exception{
		
		try{
			
			CommonPojoUtils.initPojoCommonFiled(contractRenovate);
			contractRenovateServices.addContractRenovate(contractRenovate);
			setSuggestion(CommonUtils.SUCCSUGG);
			
		}catch(Exception e){
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		contractId = contractRenovate.getContractId() + "";
		init();
		
		return "input";
	}
	
	public String getId() throws Exception{
		
		int contractRenovateId = Integer.parseInt(request.getParameter("contractRenovateId"));
		contractRenovate = contractRenovateServices.findContractRenovateById(contractRenovateId);
		
		init();
		removeSuggestion();
		
		return "getId";
	}
	
	public String update() throws Exception{
		
		int contractRenovateId = contractRenovate.getId();
		ContractRenovate oldContractRenovate = contractRenovateServices.findContractRenovateById(contractRenovateId);
		
		try{
			contractRenovate.setContractId(oldContractRenovate.getContractId());
			CommonPojoUtils.initPojoForUpdate(oldContractRenovate, contractRenovate);
			
			contractRenovateServices.updateContractRenovate(contractRenovate);
			
			setSuggestion(CommonUtils.SUCCSUGG);
		}catch(Exception e){
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		init();
		
		return "update";
	}
	
	private void init(){
		
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType, EnumCodeTypeName.SALEUNIT_PAY_TYPE, true);
	}
	
	////
	private List<ContractRenovate> contractRenovateList;
	private ContractRenovate contractRenovate;
	private Contract contract;
	
	private String contractId;
	
	private LinkedHashMap selPayType;
	
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	public String getContractId() {
		return contractId;
	}
	
	public void setSelPayType(LinkedHashMap selPayType) {
		this.selPayType = selPayType;
	}
	
	public LinkedHashMap getSelPayType() {
		return selPayType;
	}
	
	public void setContractRenovateList(
			List<ContractRenovate> contractRenovateList) {
		this.contractRenovateList = contractRenovateList;
	}
	
	public List<ContractRenovate> getContractRenovateList() {
		return contractRenovateList;
	}
	
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	public Contract getContract() {
		return contract;
	}
	
	public void setContractRenovate(ContractRenovate contractRenovate) {
		this.contractRenovate = contractRenovate;
	}
	
	public ContractRenovate getContractRenovate() {
		return contractRenovate;
	}

}
