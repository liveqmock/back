package com.ihk.saleunit.action.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.ihk.saleunit.data.pojo.ChangeOut;
import com.ihk.saleunit.data.pojo.ChangeOutCond;
import com.ihk.saleunit.data.pojo.ChangeOwner;
import com.ihk.saleunit.data.pojo.ChangeOwnerCond;
import com.ihk.saleunit.data.pojo.ChangePrice;
import com.ihk.saleunit.data.pojo.ChangePriceCond;
import com.ihk.saleunit.data.pojo.ChangeUnit;
import com.ihk.saleunit.data.pojo.ChangeUnitCond;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.services.IApprovalChangeServices;
import com.ihk.saleunit.data.services.IChangeOutServices;
import com.ihk.saleunit.data.services.IChangeOwnerServices;
import com.ihk.saleunit.data.services.IChangePriceServices;
import com.ihk.saleunit.data.services.IChangeUnitServices;
import com.ihk.saleunit.data.services.IContractServices;

/**
 * 合同变更
 * @author peter.kuang
 *
 */
public class GuangZhouContractChangeAction {
	
	
	@Autowired IApprovalChangeServices iApprovalChangeServices;
	@Autowired IContractServices iContractServices;
	
	private Contract contract; //select POJO
	
	@Autowired IChangePriceServices IChangePriceServices;
	@Autowired IChangeOutServices IChangeOutServices;
	@Autowired IChangeUnitServices IChangeUnitServices;
	@Autowired IChangeOwnerServices IChangeOwnerServices;
	private List<ChangePrice> changePriceList;
	private List<ChangeOut> changeOutList;
	private List<ChangeUnit> changeUnitList;
	private List<ChangeOwner> changeOwnerList;
	
	/**
	 * app change index 
	 * 
	 * contract_change.jsp
	 * */
	public String index(){
		this.init();
		return "suc";
	}
	
	/**changeList
	 * select pojo
	 * INIT
	 * */
	private void init(){
	
		this.contract = this.iContractServices.findContractById(this.contract.getId());
		
		ChangePriceCond priceCond = new ChangePriceCond();
		priceCond.setMainId(this.contract.getId());
		priceCond.setConfirmType("2");
		this.changePriceList = this.IChangePriceServices.findChangePrice(priceCond); 
		
		ChangeOutCond outCond = new ChangeOutCond();
		outCond.setMainId(this.contract.getId());
		outCond.setConfirmType("2");
		this.changeOutList = this.IChangeOutServices.findChangeOut(outCond);
		
		ChangeUnitCond unitCond =  new ChangeUnitCond();
		unitCond.setMainId(this.contract.getId());
		unitCond.setConfirmType("2");
		this.changeUnitList = this .IChangeUnitServices.findChangeUnit(unitCond);
		
		ChangeOwnerCond ownerCond = new ChangeOwnerCond();
		ownerCond.setMainId(this.contract.getId());
		ownerCond.setConfirmType("2");
		this.changeOwnerList = this.IChangeOwnerServices.findChangeOwner(ownerCond);
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public List<ChangePrice> getChangePriceList() {
		return changePriceList;
	}

	public void setChangePriceList(List<ChangePrice> changePriceList) {
		this.changePriceList = changePriceList;
	}

	public List<ChangeOut> getChangeOutList() {
		return changeOutList;
	}

	public void setChangeOutList(List<ChangeOut> changeOutList) {
		this.changeOutList = changeOutList;
	}

	public List<ChangeUnit> getChangeUnitList() {
		return changeUnitList;
	}

	public void setChangeUnitList(List<ChangeUnit> changeUnitList) {
		this.changeUnitList = changeUnitList;
	}

	public List<ChangeOwner> getChangeOwnerList() {
		return changeOwnerList;
	}

	public void setChangeOwnerList(List<ChangeOwner> changeOwnerList) {
		this.changeOwnerList = changeOwnerList;
	}
	
	
	
}
