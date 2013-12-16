package com.ihk.saleunit.action.tart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.Tart;
import com.ihk.saleunit.data.pojo.UnitOperRecord;
import com.ihk.saleunit.data.services.IConfirmBookServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.ITartServices;
import com.ihk.saleunit.data.services.IUnitOperRecordServices;
import com.ihk.utils.ActionMethodModifyUtils;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.common.unit.CommonUnitPojoUtils;

public class GuangZhouAppointNewTartAction extends SupperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int unitId;

	private PropertyUnit unit;
	
	private String customer;
	
	private Confirm confirm;
	
	private String customerName;
	
	private Tart tart;
	
	private List<UnitPayBill> unitList;

	private int amount;
	
	private int tartId;
	
	private UnitOperRecord unitOperRecord;
	
	List<ContractCustomer> contractCustomerList;
	
	private ConfirmBook confirmBook;

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

	public int getTartId() {
		return tartId;
	}

	public void setTartId(int tartId) {
		this.tartId = tartId;
	}

	public Tart getTart() {
		return tart;
	}

	public void setTart(Tart tart) {
		this.tart = tart;
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


	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
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

	
	
	public List<UnitPayBill> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<UnitPayBill> unitList) {
		this.unitList = unitList;
	}


	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public ConfirmBook getConfirmBook() {
		return confirmBook;
	}

	public void setConfirmBook(ConfirmBook confirmBook) {
		this.confirmBook = confirmBook;
	}



	@Autowired
	private IPropertyUnitServices unitServices;
	@Autowired
	private IConfirmServices confirmServices;
	@Autowired
	private ITartServices tartServices;
	@Autowired
	private IUnitOperRecordServices unitOperRecordServices;
	@Autowired
	private IContractCustomerServices contractCustomerServices;
	@Autowired
	private IConfirmBookServices confirmBookServices;
	
	
	/**
	 * 获取单元和成交信息
	 */
	private void init() {
		unit = unitServices.findPropertyUnitById(unitId);
		confirm=confirmServices.findConfirmByUnitId(unitId);
		confirmBook=confirmBookServices.findConfirmBookByUnitId(unitId);
		//tart=tartServices.findTartByUnitId(unitId);
		if(confirm!=null){
			contractCustomerList=contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirm.getId(), ContConfirmType.CONFIRM);
			customerName=confirm.getCustomerName();
		}else if(confirmBook!=null){
			contractCustomerList=contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirmBook.getId(), ContConfirmType.CONFIRM_BOOK);
			customerName=confirmBook.getCustomerName();
		}
		
	}
	
	/**
	 * 
	 * 新增挞订
	 */
	public String addCancelContract() {
		this.init();
		return "add_cancel_contract";
	}
	
	
	/**
	 * 保存挞订信息
	 */
	public String submitTart(){
		new ActionMethodModifyUtils(true){
			@Override
			protected void modifyMethod() throws Exception {
				init();
				CommonPojoUtils.initPojoCommonFiled(tart);
				CommonUnitPojoUtils.initPojoCommonFiled(tart);
				Map<String,String> map=new HashMap<String,String>();
				map.put("id", unitId+"");
				map.put("saleState", ContUnitSaleState.SALE_ABLE);
//				PropertyUnit clone = (PropertyUnit)CommonUtils.deepClone(unit);
//				clone.setSaleState(ContUnitSaleState.SALE_ABLE);
//				unitServices.updatePropertyUnit(clone);//更新单元状态
				unitServices.updatePropertyUnitSaleState(map);
				if(confirm!=null){
					tart.setConfirmType(ContConfirmType.CONFIRM);
					confirmServices.deleteConfirm(confirm.getId());//删除原认购表
				}else if(confirmBook!=null){
					tart.setConfirmType(ContConfirmType.CONFIRM_BOOK);
					confirmServices.deleteConfirm(confirmBook.getId());//删除原临订表
				}
				tartServices.addTart(tart);//插入挞订表
				unitOperRecord=new UnitOperRecord();
				if(confirm!=null){
					unitOperRecord.setConfirmOrConfirmBook(true);
				}else if(confirmBook!=null){
					unitOperRecord.setConfirmOrConfirmBook(false);
				}
				unitOperRecord.setUnitId(unitId);
				CommonPojoUtils.initPojoCommonFiled(unitOperRecord);
				CommonUnitPojoUtils.initPojoCommonFiled(unitOperRecord);
				unitOperRecord.setOperType(ContUnitSaleState.TART);
				unitOperRecord.setMainId(tart.getId());
				if(unitOperRecordServices.findUnitOperRecordByUnitIdOfMaxId(unitId)!=null){
					unitOperRecord.setParentId(unitOperRecordServices.findUnitOperRecordByUnitIdOfMaxId(unitId).getId());//待修改
				}else{
					unitOperRecord.setParentId(0);
				}
				unitOperRecordServices.addUnitOperRecord(unitOperRecord);
				List<ContractCustomer> contractCustomer=null;
				if(confirm!=null){
					contractCustomer=contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirm.getId(), ContConfirmType.CONFIRM);
				}else if(confirmBook!=null){
					contractCustomer=contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirmBook.getId(), ContConfirmType.CONFIRM_BOOK);
				}
				for(ContractCustomer con:contractCustomer){
					con.setIsValid("1");
					contractCustomerServices.updateContractCustomer(con);
				}
			}
		}.doModify(this);
		return null;
	}
	
	
	
	
	

}
