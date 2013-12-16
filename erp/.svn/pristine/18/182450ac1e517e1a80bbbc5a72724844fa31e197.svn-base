package com.ihk.saleunit.action.confirm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.PropertyOwner;
import com.ihk.saleunit.data.pojo.PropertyOwnerCond;
import com.ihk.saleunit.data.services.IConfirmServices;
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
	IConfirmServices confirmServices;
	
	public String search() throws Exception{
		
		int confirmId = Integer.parseInt(request.getParameter("confirmId"));
		confirm = confirmServices.findConfirmById(confirmId);
		
		final PropertyOwnerCond cond = new PropertyOwnerCond();
		cond.setConfirmType(ContConfirmType.CONFIRM);
		cond.setMainId(confirmId + "");
		
		ActionTemplate actionTemplate = new ActionTemplate(this, cond);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				ownerList = ownerServices.findPropertyOwner(cond); 
				
			}
		});
		
		return "search";
	}
	
	public String forInput() throws Exception{
		
		int confirmId = Integer.parseInt(request.getParameter("confirmId"));
		initData(confirmId);
		
		removeSuggestion();
		
		return "forInput";
	}
	
	public String input() throws Exception{
		
		try{
			
			owner.setConfirmType(ContConfirmType.CONFIRM);
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
	
	private void initData(int confirmId){
		
		confirm = confirmServices.findConfirmById(confirmId);
	}
	
	
	////

	private PropertyOwner owner;
	private Confirm confirm;
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
	
	public void setConfirm(Confirm confirm) {
		this.confirm = confirm;
	}
	
	public Confirm getConfirm() {
		return confirm;
	}

}
