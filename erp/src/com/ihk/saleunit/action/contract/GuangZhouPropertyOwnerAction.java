package com.ihk.saleunit.action.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.PropertyOwner;
import com.ihk.saleunit.data.pojo.PropertyOwnerCond;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IPropertyOwnerServices;
import com.ihk.utils.ActionPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;

/**
 *  权益人
 */
public class GuangZhouPropertyOwnerAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPropertyOwnerServices ownerServices;
	@Autowired
	IContractServices contractServices;
	
	public String search() throws Exception{
		
		String contractId = request.getParameter("contractId");
		contract = contractServices.findContractById(Integer.parseInt(contractId));
		
		final PropertyOwnerCond cond = new PropertyOwnerCond();
		cond.setConfirmType(ContConfirmType.CONTRACT);
		cond.setMainId(contractId + "");
		
		ActionTemplate actionTemplate = new ActionTemplate(this, cond);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				ownerList = ownerServices.findPropertyOwner(cond); 
				
			}
		});
		
		removeSuggestion();
		
		return "search";
	}
	
	public String forInput() throws Exception{
		
		int contractId = Integer.parseInt(request.getParameter("contractId"));
		initData(contractId);
		
		removeSuggestion();
		
		return "forInput";
	}
	
	public String input() throws Exception{
		
		try{
			
			owner.setConfirmType(ContConfirmType.CONTRACT);
			CommonPojoUtils.initPojoCommonFiled(owner);
			
			ownerServices.addPropertyOwner(owner);
			
			setSuggestion(CommonUtils.SUCCSUGG);
		}catch(Exception e){
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		initData(owner.getMainId());
			
		return "input";
	}
	
	public String getId() throws Exception{
		
		int propertyOwnerId = Integer.parseInt(request.getParameter("propertyOwnerId"));
		
		owner = ownerServices.findPropertyOwnerById(propertyOwnerId);
		
		initData(owner.getMainId());
		
		removeSuggestion();
		
		return "getId";
	}
	
	public String update() throws Exception{
		
		PropertyOwner oldOwner = ownerServices.findPropertyOwnerById(owner.getId());
		
		CommonPojoUtils.initPojoForUpdate(oldOwner, owner);
		
		owner.setConfirmType(oldOwner.getConfirmType());
		owner.setMainId(oldOwner.getMainId());
		
		try{
			
			ownerServices.updatePropertyOwner(owner);
			
			setSuggestion(CommonUtils.SUCCSUGG);
		}catch(Exception e){
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		owner = ownerServices.findPropertyOwnerById(oldOwner.getId());
		initData(owner.getMainId());
		
		return "update";
	}
	
	private void initData(int contractId){
		
		contract = contractServices.findContractById(contractId);
	}
	
	
	////

	private PropertyOwner owner;
	private Contract contract;
	private List<PropertyOwner> ownerList;
	
	public void setOwner(PropertyOwner owner) {
		this.owner = owner;
	}
	
	public PropertyOwner getOwner() {
		return owner;
	}
	
	public void setOwnerList(List<PropertyOwner> ownerList) {
		this.ownerList = ownerList;
	}
	
	public List<PropertyOwner> getOwnerList() {
		return ownerList;
	}
	
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	public Contract getContract() {
		return contract;
	}
	

}
