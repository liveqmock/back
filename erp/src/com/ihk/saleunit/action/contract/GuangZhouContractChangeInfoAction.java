package com.ihk.saleunit.action.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.ChangeOut;
import com.ihk.saleunit.data.pojo.ChangeOwner;
import com.ihk.saleunit.data.pojo.ChangeOwnerDetail;
import com.ihk.saleunit.data.pojo.ChangeOwnerDetailCond;
import com.ihk.saleunit.data.pojo.ChangePrice;
import com.ihk.saleunit.data.pojo.ChangeUnit;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.PropertyOwner;
import com.ihk.saleunit.data.pojo.PropertyOwnerCond;
import com.ihk.saleunit.data.services.IChangeOutServices;
import com.ihk.saleunit.data.services.IChangeOwnerDetailServices;
import com.ihk.saleunit.data.services.IChangeOwnerServices;
import com.ihk.saleunit.data.services.IChangePriceServices;
import com.ihk.saleunit.data.services.IChangeUnitServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IPropertyOwnerServices;
import com.ihk.utils.SupperAction;


/**
 *  合同查看详细信息 
 */
public class GuangZhouContractChangeInfoAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	@Autowired IContractServices iContractServices;
	
	@Autowired IPropertyOwnerServices iPropertyOwnerServices;
	@Autowired IChangeOwnerDetailServices iChangeOwnerDetailServices;
	
	@Autowired IChangeUnitServices iChangeUnitServices;
	@Autowired IChangeOutServices iChangeOutServices;
	@Autowired IChangeOwnerServices iChangeOwnerServices;
	@Autowired IChangePriceServices iChangePriceServices;
	
	private Contract contract;//
	private String changeId;// 
	private String changeType;// price | out | owner | unit
	
	private ChangePrice changePriceInfo;
	private	ChangeUnit changeUnitInfo;
	private ChangeOut changeOutInfo;
	private ChangeOwner changeOwnerInfo;

	private List<PropertyOwner> ownerList;
	private  List<ChangeOwnerDetail> OwnerListForDetail;
	
	
	public String infoIndex(){
		int cid = Integer.parseInt(this.changeId);
		contract = iContractServices.findContractById(contract.getId());
		
		if(changeType.equals("price")){
			changePriceInfo = iChangePriceServices.findChangePriceById(cid);
			return "price";
		}
		if(changeType.equals("unit")){
			changeUnitInfo = iChangeUnitServices.findChangeUnitById(cid);
			return "unit";
		}
		if(changeType.equals("out")){
			changeOutInfo = iChangeOutServices.findChangeOutById(cid);
			return "out";
		}
		if(changeType.equals("owner")){
			changeOwnerInfo = iChangeOwnerServices.findChangeOwnerById(cid);
			
			PropertyOwnerCond onerCond = new PropertyOwnerCond();
			onerCond.setMainId(contract.getId()+"");
			onerCond.setConfirmType("2");
			ownerList = iPropertyOwnerServices.findPropertyOwner(onerCond);
			
			ChangeOwnerDetailCond ccond = new ChangeOwnerDetailCond();
			ccond.setChangeId(changeId);
			OwnerListForDetail = iChangeOwnerDetailServices.findChangeOwnerDetail(ccond);
			return "owner";
		}
		return null;
	}

	
	
	
	public List<PropertyOwner> getOwnerList() {
		return ownerList;
	}




	public void setOwnerList(List<PropertyOwner> ownerList) {
		this.ownerList = ownerList;
	}




	public List<ChangeOwnerDetail> getOwnerListForDetail() {
		return OwnerListForDetail;
	}




	public void setOwnerListForDetail(List<ChangeOwnerDetail> ownerListForDetail) {
		OwnerListForDetail = ownerListForDetail;
	}




	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}

	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	public ChangePrice getChangePriceInfo() {
		return changePriceInfo;
	}

	public void setChangePriceInfo(ChangePrice changePriceInfo) {
		this.changePriceInfo = changePriceInfo;
	}

	public ChangeUnit getChangeUnitInfo() {
		return changeUnitInfo;
	}

	public void setChangeUnitInfo(ChangeUnit changeUnitInfo) {
		this.changeUnitInfo = changeUnitInfo;
	}

	public ChangeOut getChangeOutInfo() {
		return changeOutInfo;
	}

	public void setChangeOutInfo(ChangeOut changeOutInfo) {
		this.changeOutInfo = changeOutInfo;
	}

	public ChangeOwner getChangeOwnerInfo() {
		return changeOwnerInfo;
	}

	public void setChangeOwnerInfo(ChangeOwner changeOwnerInfo) {
		this.changeOwnerInfo = changeOwnerInfo;
	}
	
	
	
}
