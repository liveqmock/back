package com.ihk.saleunit.action.contract;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumChangeType;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.saleunit.data.pojo.ApprovalChange;
import com.ihk.saleunit.data.pojo.ChangeOut;
import com.ihk.saleunit.data.pojo.ChangeOwner;
import com.ihk.saleunit.data.pojo.ChangeOwnerDetail;
import com.ihk.saleunit.data.pojo.ChangePrice;
import com.ihk.saleunit.data.pojo.ChangeUnit;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.PropertyOwner;
import com.ihk.saleunit.data.pojo.PropertyOwnerCond;
import com.ihk.saleunit.data.services.IApprovalChangeServices;
import com.ihk.saleunit.data.services.IChangeOutServices;
import com.ihk.saleunit.data.services.IChangeOwnerDetailServices;
import com.ihk.saleunit.data.services.IChangeOwnerServices;
import com.ihk.saleunit.data.services.IChangePriceServices;
import com.ihk.saleunit.data.services.IChangeUnitServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IPropertyOwnerServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 合同变更表格
 * @author peter.kuang
 *
 */
public class GuangZhouContractChangeFormAction  extends SupperAction{
	private static final long serialVersionUID = 1L;
	
	@Autowired IApprovalChangeServices iApprovalChangeServices;
	@Autowired IContractServices iContractServices;
	@Autowired IPropertyOwnerServices iPropertyOwnerServices;
	@Autowired IChangeOwnerDetailServices iChangeOwnerDetailServices;
	private Contract contract; //select POJO
	
	@Autowired IChangePriceServices IChangePriceServices;
	@Autowired IChangeOutServices IChangeOutServices;
	@Autowired IChangeUnitServices IChangeUnitServices;
	@Autowired IChangeOwnerServices IChangeOwnerServices;

	private ChangePrice priceForm;
	private ChangeOut outForm;
	private ChangeUnit unitForm;
	private ChangeOwner ownerForm;
	
	
	/**
	 * ajax request for input_change
	 * *
	**price
	*need some select option*/
	private LinkedHashMap selPriceWay;
	private LinkedHashMap selPayType;
	public String priceFormIndex(){
		this.contract = this.iContractServices.findContractById(this.contract.getId());
		priceInit();
		return "suc";
	}
	
	public String priceFormSubmit(){
		this.contract = this.iContractServices.findContractById(this.contract.getId());
		priceForm.setPriceWay1(contract.getPriceWay());
		 //priceForm.setPayType1(contract.getPayType()); //---
		 priceForm.setPayType1(contract.getPayWayId() + "");
		 priceForm.setDiscountPercent1(contract.getDiscountPercent());
		 priceForm.setBuildPrice1(contract.getBuildPrice());
		 priceForm.setInsideUnitPrice1(contract.getInsideUnitPrice());
		 priceForm.setDiscountDesc1(contract.getDiscountDesc());
		 priceForm.setSumMoney1(contract.getSumMoney());
		 priceForm.setRenovateDesc1(contract.getRenovateDesc());
		 priceForm.setRenovatePrice1(contract.getRenovatePrice());
		 priceForm.setIsMerge1(contract.getIsMerge());
		 priceForm.setRenovateMoney1(contract.getRenovateMoney());
		// priceForm.setAgreeNo1(contract.getAgreeNo());
		 priceForm.setShouldDeposit1(contract.getShouldDeposit());
	//	 priceForm.setAgreeMoney1(contract.getAgreeMoney());
		
		priceForm.setMainId(this.contract.getId());
		priceForm.setConfirmType("2");
		priceForm.setApplyUser(SessionUser.getUserId());
		priceForm.setApplyDate(new Date());
		priceForm.setApplyState("1");
		priceForm.setCreatedId(SessionUser.getUserId());
		priceForm.setCreatedTime(priceForm.getApplyDate());
		priceForm.setModId(priceForm.getCreatedId());
		priceForm.setModTime(priceForm.getCreatedTime());
		priceForm.setIsDeleted("0");
		this.IChangePriceServices.addChangePrice(priceForm);
		
	
		
		priceInit();
		addActionMessage("申请成功!");
		
		return "suc";
	}
	
	private void priceInit(){
		selPriceWay = DescUtils.getInitSelForGuangZhou(selPriceWay,EnumCodeTypeName.PROPERTY_PRICE_WAY,true);
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType,EnumCodeTypeName.PROPERTY_PAY_TYPE,true);;
	}
	/**end~~~~~*/
	
	/**unit*/
	public String unitFormIndex(){
		this.contract = this.iContractServices.findContractById(this.contract.getId());
		return "suc";
	}
	public String unitFormSubmit(){
		this.contract = this.iContractServices.findContractById(this.contract.getId());
		
		this.unitForm.setModId(SessionUser.getUserId());
		this.unitForm.setCreatedId(this.unitForm.getModId());
		this.unitForm.setCreatedTime(new Date());
		this.unitForm.setModTime(this.unitForm.getCreatedTime());
		this.unitForm.setIsDeleted("0");
		this.unitForm.setApplyUser(SessionUser.getUserId());
		this.unitForm.setApplyDate(new Date());
		this.unitForm.setUnitId1(contract.getUnitId());
		this.unitForm.setConfirmType("2");
		this.unitForm.setMainId(this.contract.getId());
		this.IChangeUnitServices.addChangeUnit(unitForm);
		addActionMessage("申请成功!");
		return "suc";
	}
	/**unit end*/
	
	/**owner*/
	private List<PropertyOwner> ownerList;	
	public String ownerFormIndex(){
		this.contract = this.iContractServices.findContractById(this.contract.getId());
		PropertyOwnerCond onerCond = new PropertyOwnerCond();
		onerCond.setMainId(contract.getId()+"");
		onerCond.setConfirmType("2");
		ownerList = iPropertyOwnerServices.findPropertyOwner(onerCond);
		request.getSession().setAttribute("changeOwnerList", ownerList);
		
		return "suc";
		
	}
	private PropertyOwner ownerForAdd;
	@SuppressWarnings("unchecked")
	public String addOwnerForaddChangeForThisConfirmOwner(){
		this.contract = this.iContractServices.findContractById(this.contract.getId());
		//需要和审批申请一样的条件  confirm.id    
		PropertyOwnerCond onerCond = new PropertyOwnerCond();
		onerCond.setMainId(contract.getId()+"");
		onerCond.setConfirmType("2");
		ownerList = iPropertyOwnerServices.findPropertyOwner(onerCond);
		
		//增加Sessions里保存的changeOwnerList
		List<PropertyOwner> tt = (List<PropertyOwner>) request.getSession().getAttribute("changeOwnerList");
		tt.add(ownerForAdd);
		request.getSession().setAttribute("changeOwnerList", tt);
		return "owner";
	}
	public String ownerFormSubmit(){
		this.ownerForm.setModId(SessionUser.getUserId());
		this.ownerForm.setCreatedId(this.ownerForm.getModId());
		this.ownerForm.setCreatedTime(new Date());
		this.ownerForm.setModTime(this.ownerForm.getCreatedTime());
		this.ownerForm.setIsDeleted("0");
		this.ownerForm.setApplyUser(SessionUser.getUserId());
		this.ownerForm.setApplyDate(new Date());
		this.ownerForm.setApplyState("1");
		this.ownerForm.setConfirmType("2");
		this.ownerForm.setMainId(this.contract.getId());
		
		List<PropertyOwner> ff = null;
		try {
			ff =  (List<PropertyOwner>) request.getSession().getAttribute("changeOwnerList");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		if(ff == null || ff .size() == 0){
			addActionMessage ("申请失败, 没有修改权益人");
			return "suc";
		}
		this.IChangeOwnerServices.addChangeOwner(ownerForm);
		
		ChangeOwnerDetail temp = new ChangeOwnerDetail(); 
		temp.setIsDeleted("0");
		temp.setCreatedTime(new Date());
		temp.setModTime(temp.getCreatedTime());
		temp.setCreatedId(SessionUser.getUserId());
		temp.setModId(temp.getCreatedId());
		temp.setChangeId(ownerForm.getId());
		for(PropertyOwner cc : ff){		   
			temp.setCustomerName(cc.getCustomerName());
			temp.setIdcardNo(cc.getIdcardNo());
			temp.setPhone(cc.getPhone());
			temp.setRightPercent(cc.getRightPercent());
			temp.setAgentName(cc.getAgentName());
			temp.setAgentNation(cc.getAgentNation());
			temp.setCardNum(cc.getCardNum());
			temp.setAgentPhone(cc.getAgentPhone());
			
			iChangeOwnerDetailServices.addChangeOwnerDetail(temp);
		}
		addActionMessage("申请成功!");
		
		return "suc";
	}
	/**owner end*/
	
	/**out */
	public String outFormIndex(){
		this.contract = this.iContractServices.findContractById(this.contract.getId());
		return "suc";
		
	}
	public String outFormSubmit(){
		this.contract = this.iContractServices.findContractById(this.contract.getId());
		
		this.outForm.setModId(SessionUser.getUserId());
		this.outForm.setCreatedId(this.outForm.getModId());
		this.outForm.setCreatedTime(new Date());
		this.outForm.setModTime(this.outForm.getCreatedTime());
		this.outForm.setIsDeleted("0");
		this.outForm.setApplyUser(SessionUser.getUserId());
		this.outForm.setApplyDate(new Date());
		
		this.outForm.setApplyState("1");
		this.outForm.setConfirmType("2");
		this.outForm.setMainId(this.contract.getId());
		this.IChangeOutServices.addChangeOut(outForm);
		addActionMessage("申请成功!");
		return "suc";
	}
	
	
	/**out end*/

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public ChangePrice getPriceForm() {
		return priceForm;
	}

	public void setPriceForm(ChangePrice priceForm) {
		this.priceForm = priceForm;
	}

	public ChangeOut getOutForm() {
		return outForm;
	}

	public void setOutForm(ChangeOut outForm) {
		this.outForm = outForm;
	}

	public ChangeUnit getUnitForm() {
		return unitForm;
	}

	public void setUnitForm(ChangeUnit unitForm) {
		this.unitForm = unitForm;
	}

	public ChangeOwner getOwnerForm() {
		return ownerForm;
	}

	public void setOwnerForm(ChangeOwner ownerForm) {
		this.ownerForm = ownerForm;
	}

	public LinkedHashMap getSelPriceWay() {
		return selPriceWay;
	}

	public void setSelPriceWay(LinkedHashMap selPriceWay) {
		this.selPriceWay = selPriceWay;
	}

	public LinkedHashMap getSelPayType() {
		return selPayType;
	}

	public void setSelPayType(LinkedHashMap selPayType) {
		this.selPayType = selPayType;
	}

	public List<PropertyOwner> getOwnerList() {
		return ownerList;
	}

	public void setOwnerList(List<PropertyOwner> ownerList) {
		this.ownerList = ownerList;
	}

	public PropertyOwner getOwnerForAdd() {
		return ownerForAdd;
	}

	public void setOwnerForAdd(PropertyOwner ownerForAdd) {
		this.ownerForAdd = ownerForAdd;
	}
	
	
	
}
