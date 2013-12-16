package com.ihk.saleunit.action.contract;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractService;
import com.ihk.saleunit.data.pojo.ContractServiceCond;
import com.ihk.saleunit.data.services.IContractServiceServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 * 销售服务
 */
@SuppressWarnings("rawtypes")
public class GuangZhouContractServiceAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IContractServiceServices contractServiceServices;
	@Autowired
	IContractServices contractServices;
	
	public String search() throws Exception{
		
		int contractId = Integer.parseInt(request.getParameter("contractId"));
		contract = contractServices.findContractById(contractId);
		
		ContractServiceCond cond = new ContractServiceCond();
		cond.setContractId(contractId + "");
		
		contractServiceList = contractServiceServices.findContractService(cond);
		
		return "search";
	}
	
	public String forInput() throws Exception{
		
		int contractId = Integer.parseInt(request.getParameter("contractId"));
		contract = contractServices.findContractById(contractId);
		
		init();
		
		removeSuggestion();
			
		return "forInput";
	}
	
	public String input() throws Exception{
		
		try{
		
			CommonPojoUtils.initPojoCommonFiled(contractService);
			contractServiceServices.addContractService(contractService);
			
			setSuggestion(CommonUtils.SUCCSUGG);
		}catch(Exception e){
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		int contractId = contractService.getContractId();
		contract = contractServices.findContractById(contractId);
		
		init();
		
		return "input";
	}
	
	public String getId() throws Exception{
		
		int contractServiceId = Integer.parseInt(request.getParameter("contractServiceId"));
		contractService = contractServiceServices.findContractServiceById(contractServiceId);
		
		init();
		
		removeSuggestion();
		
		return "getId";
	}
	
	public String update() throws Exception{
		
		int contractServiceId = contractService.getId();
		ContractService oldContractService = contractServiceServices.findContractServiceById(contractServiceId);
		
		try{
			contractService.setContractId(oldContractService.getContractId());
			CommonPojoUtils.initPojoForUpdate(oldContractService, contractService);
			
			contractServiceServices.updateContractService(contractService);
			
			setSuggestion(CommonUtils.SUCCSUGG);
		}catch(Exception e){
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		init();
		return "update";
	}
	
	private void init(){
		
		selServiceType = DescUtils.getInitSelForGuangZhou(selServiceType, EnumCodeTypeName.SALEUNIT_SERVICE_TYPE, true);
		selStepState = DescUtils.getInitSelForGuangZhou(selStepState, EnumCodeTypeName.SALEUNIT_STEP_STATE, true);
	}
	
	
	//////
	
	private List<ContractService> contractServiceList;
	private ContractService contractService;
	private Contract contract;
	
	private LinkedHashMap selServiceType; //服务项目
	private LinkedHashMap selStepState;//服务进程
	
	public void setSelServiceType(LinkedHashMap selServiceType) {
		this.selServiceType = selServiceType;
	}
	
	public LinkedHashMap getSelServiceType() {
		return selServiceType;
	}
	
	public void setSelStepState(LinkedHashMap selStepState) {
		this.selStepState = selStepState;
	}
	
	public LinkedHashMap getSelStepState() {
		return selStepState;
	}
	
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	public Contract getContract() {
		return contract;
	}
	
	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}
	
	public ContractService getContractService() {
		return contractService;
	}
	
	public void setContractServiceList(List<ContractService> contractServiceList) {
		this.contractServiceList = contractServiceList;
	}
	
	public List<ContractService> getContractServiceList() {
		return contractServiceList;
	}
	
	
	

}
