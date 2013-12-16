package com.ihk.saleunit.action.cancel_unit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.CancelUnit;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.UnitOperRecord;
import com.ihk.saleunit.data.services.ICancelUnitServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IUnitOperRecordServices;
import com.ihk.utils.ActionMethodModifyUtils;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.common.unit.CommonUnitPojoUtils;
import com.ihk.utils.saleunit.UnitSaleStateUtils;

public class GuangZhouAppointNewCancelUnitAction extends SupperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8059008075498264365L;

	
	private int unitId;

	private PropertyUnit unit;
	
	private Confirm confirm;
	
	private String customerName;
	
	private String payWay;

	private CancelUnit cancelUnit;
	
	private Contract contract;
	
	private UnitOperRecord unitOperRecord;
	
	List<ContractCustomer> contractCustomerList;

	
	
	
	public List<ContractCustomer> getContractCustomerList() {
		return contractCustomerList;
	}

	public void setContractCustomerList(List<ContractCustomer> contractCustomerList) {
		this.contractCustomerList = contractCustomerList;
	}
	
	//private Date confirmDate;
	
	public UnitOperRecord getUnitOperRecord() {
		return unitOperRecord;
	}

	public void setUnitOperRecord(UnitOperRecord unitOperRecord) {
		this.unitOperRecord = unitOperRecord;
	}
	
	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public CancelUnit getCancelUnit() {
		return cancelUnit;
	}

	public void setCancelUnit(CancelUnit cancelUnit) {
		this.cancelUnit = cancelUnit;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Confirm getConfirm() {
		return confirm;
	}

	public void setConfirm(Confirm confirm) {
		this.confirm = confirm;
	}

	public PropertyUnit getUnit() {
		return unit;
	}

	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	private int amount;
	
	private List<UnitPayBill> unitList;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public List<UnitPayBill> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<UnitPayBill> unitList) {
		this.unitList = unitList;
	}

	@Autowired
	private IPropertyUnitServices unitServices;
	@Autowired
	private IConfirmServices confirmServices;
	@Autowired
	private ICancelUnitServices cancelUnitServices;
	@Autowired
	private IContractServices contractServices;
	@Autowired
	private IUnitOperRecordServices unitOperRecordServices;
	@Autowired
	private IContractCustomerServices contractCustomerServices;

	
	private void init() {
		unit = unitServices.findPropertyUnitById(unitId);
		if(ContUnitSaleState.CONFIRM.equals(unit.getSaleState())){
			confirm=confirmServices.findConfirmByUnitId(unitId);
			contractCustomerList=contractCustomerServices.findContractCustomerByMainIdAndConfirmTypeNotValid(confirm.getId(), ContConfirmType.CONFIRM);
			payWay=confirm.getPayTypeStr();
		}
		if(ContUnitSaleState.CONTRACT.equals(unit.getSaleState())){
			confirm=confirmServices.findConfirmByUnitId(unitId);
			contract=contractServices.findContractByUnitId(unitId);
			contractCustomerList=contractCustomerServices.findContractCustomerByMainIdAndConfirmTypeNotValid(contract.getId(), ContConfirmType.CONTRACT);
		}
		
		if(confirm!=null){
			customerName=confirm.getCustomerName();
		}
	}
	
	
	/**
	 * 
	 * 新增退房
	 */
	public String addRejectUnit() {
		init();
		if(ContUnitSaleState.CONFIRM.equals(unit.getSaleState())){
			return "add_reject_unit_confirm";
		}
		if(ContUnitSaleState.CONTRACT.equals(unit.getSaleState())){
			return "add_reject_unit_contract";
		}
		return null;
	}
	
	
	public String submitCancelUnit(){
		new ActionMethodModifyUtils(true){
			@Override
			protected void modifyMethod() throws Exception {
				init();
				CommonPojoUtils.initPojoCommonFiled(cancelUnit);
				cancelUnit.setUnitId(unitId);
				cancelUnit.setMainId(confirm.getId());
				CommonUnitPojoUtils.initPojoCommonFiled(cancelUnit);
				if(ContUnitSaleState.CONFIRM.equals(unit.getSaleState())){
					cancelUnit.setConfirmType(ContConfirmType.CONFIRM);
					confirmServices.deleteConfirm(confirm.getId());//成交标为已删除	
					List<ContractCustomer> contractCustomer=contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirm.getId(), ContConfirmType.CONFIRM);
					for(ContractCustomer con:contractCustomer){
						con.setIsValid("1");
						contractCustomerServices.updateContractCustomer(con);
					}
				
				}
				if(ContUnitSaleState.CONTRACT.equals(unit.getSaleState())){
					cancelUnit.setConfirmType(ContConfirmType.CONFIRM);
					confirmServices.deleteConfirm(confirm.getId());//成交标为已删除	
					cancelUnit.setConfirmType(ContConfirmType.CONTRACT);
					contractServices.deleteContract(contract.getId());//合约标为已删除	
					List<ContractCustomer> contractCustomer=contractCustomerServices.findContractCustomerByMainIdAndConfirmType(contract.getId(), ContConfirmType.CONTRACT);
					for(ContractCustomer con:contractCustomer){
						con.setIsValid("1");
						contractCustomerServices.updateContractCustomer(con);
					}
				
				}
				cancelUnitServices.addCancelUnit(cancelUnit);
//				unit.setSaleState(ContUnitSaleState.SALE_ABLE);
//				unitServices.updatePropertyUnit(unit);
				UnitSaleStateUtils.changeSaleState(unitServices, unitId, ContUnitSaleState.SALE_ABLE);
				
				unitOperRecord=new UnitOperRecord();
				unitOperRecord.setUnitId(unitId);
				CommonPojoUtils.initPojoCommonFiled(unitOperRecord);
				CommonUnitPojoUtils.initPojoCommonFiled(unitOperRecord);
				unitOperRecord.setOperType(ContUnitSaleState.CANCEL_UNIT);
				unitOperRecord.setMainId(cancelUnit.getId());
				if(unitOperRecordServices.findUnitOperRecordByUnitIdOfMaxId(unitId)!=null){
					unitOperRecord.setParentId(unitOperRecordServices.findUnitOperRecordByUnitIdOfMaxId(unitId).getId());//待修改
				}else{
					unitOperRecord.setParentId(0);
				}
				unitOperRecordServices.addUnitOperRecord(unitOperRecord);
			}
			
		}.doModify(this);
		return null;
	}

}
