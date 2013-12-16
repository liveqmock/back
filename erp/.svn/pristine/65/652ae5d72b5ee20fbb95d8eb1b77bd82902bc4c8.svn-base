package com.ihk.saleunit.action.replace_unit;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.ReplaceUnit;
import com.ihk.saleunit.data.pojo.UnitOperRecord;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IReplaceUnitServices;
import com.ihk.saleunit.data.services.IUnitDiscountServices;
import com.ihk.saleunit.data.services.IUnitOperRecordServices;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.common.unit.CommonUnitPojo;
import com.ihk.utils.common.unit.CommonUnitPojoUtils;
import com.ihk.utils.financial.FinancialUtils;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;
import com.ihk.utils.saleunit.UnitSaleStateUtils;

public class GuangZhouAppointNewReplaceUnitAction extends SupperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4572479016168359145L;

	private int unitId;

	private PropertyUnit unit;
	
	private Confirm confirm;
	
	private ReplaceUnit replaceUnit;
	
	private int hiddenUnitId;
	
	private UnitOperRecord unitOperRecord;
	
	private String unitDiscountId;
	

	public void setUnitDiscountId(String unitDiscountId) {
		this.unitDiscountId = unitDiscountId;
	}
	
	public String getUnitDiscountId() {
		return unitDiscountId;
	}
	
	//private Date confirmDate;
	
	public UnitOperRecord getUnitOperRecord() {
		return unitOperRecord;
	}

	public void setUnitOperRecord(UnitOperRecord unitOperRecord) {
		this.unitOperRecord = unitOperRecord;
	}
	

	public int getHiddenUnitId() {
		return hiddenUnitId;
	}

	public void setHiddenUnitId(int hiddenUnitId) {
		this.hiddenUnitId = hiddenUnitId;
	}

	public ReplaceUnit getReplaceUnit() {
		return replaceUnit;
	}

	public void setReplaceUnit(ReplaceUnit replaceUnit) {
		this.replaceUnit = replaceUnit;
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
	
	private int propertyProjectId;
	
	public void setPropertyProjectId(int propertyProjectId) {
		this.propertyProjectId = propertyProjectId;
	}
	
	public int getPropertyProjectId() {
		return propertyProjectId;
	}

	@Autowired
	private IPropertyUnitServices unitServices;
	@Autowired
	private IConfirmServices confirmServices;
	@Autowired
	private IReplaceUnitServices replaceUnitServices;
	@Autowired
	private IUnitOperRecordServices unitOperRecordServices;
	@Autowired
	private IContractCustomerServices contractCustomerServices;
	@Autowired
	private IUnitDiscountServices discountServices;
	
	private void init() {
		unit = unitServices.findPropertyUnitById(unitId);
		confirm=confirmServices.findConfirmByUnitId(unitId);
	}
	
	/**
	 * 
	 * 新增换房
	 */
	public String addChangeUnit() {
		this.init();
		return "add_change_unit";
	}
	
	/**
	 * 提交换房
	 * @return
	 * @throws Exception 
	 */
	public String submitChangeUnit() throws Exception{
		//String succ="true";
		
			ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
				
				@Override
				public void modifyMethod() throws Exception {
					init();
					CommonPojoUtils.initPojoCommonFiled(replaceUnit);
					CommonUnitPojo pojo=CommonUnitPojoUtils.getPojoByUnitId(unitId);
					replaceUnit.setUnitId1(pojo.getUnitId());
					replaceUnit.setBuildId1(pojo.getBuildId());
					replaceUnit.setCompanyProjectId1(pojo.getCompanyProjectId());
					replaceUnit.setPropertyProjectId1(pojo.getPropertyProjectId());
					replaceUnit.setAreaId1(pojo.getAreaId());
					replaceUnit.setConfirmId1(confirm.getId());
					confirmServices.deleteConfirm(confirm.getId());//删除原认购表
					
					
					Confirm newConfirm=(Confirm)request.getSession().getAttribute("confirmChangeUnit");
					String customerId=(String)request.getSession().getAttribute("customerIdChangeUnit");
					
					
					PropertyUnit getUnit = unitServices.findPropertyUnitById(newConfirm.getUnitId());
					
					//增加之前应该判断该单元是否可以认购
//					boolean isCanChange = UnitChangeUtils.isCanChange(ContUnitChangeTypeFrom.CONFIRM, unit);
//					if(!isCanChange)
//						throw new UnitChangeException();
					
					//判断"建筑单价","套内单价","标准总价","建筑面积","套内面积"是否变化,变化了要一并修改
					modifyUnitSomeMoney(getUnit, unit);
					
					//修改房间的状态
					UnitSaleStateUtils.changeSaleState(unitServices, newConfirm.getUnitId(), ContUnitSaleState.CONFIRM);
					
					//增加单元应付款单unit_pay_bill
					FinancialUtils.addUnitPayBillByPayWayIdAndUnitId(newConfirm.getPayWayId(), newConfirm.getUnitId(),newConfirm.getSalePrice(), newConfirm.getWorkDate());
					FinancialUtils.addUnitPayBillByPayWayIdAndUnitId(newConfirm);
					
					//修改对应客户的状态
//					contractCustomerServices.updateContractCustomerConfirmType(newConfirm.getCustomerId(), ContConfirmType.CONFIRM);
					
					//增加认购
					CommonPojoUtils.initPojoCommonFiled(newConfirm);
					//confirmServices.addConfirm(confirm);
					
					
					//设置折扣单中的main_id
					unitDiscountId = request.getParameter("unitDiscountId");
					if(!CommonUtils.isStrZeroEmpty(unitDiscountId)){
						discountServices.updateUnitDiscountMainId(Integer.parseInt(unitDiscountId), confirm.getId(), ContConfirmType.CONFIRM);
					}
					//setUpAjaxForSucc(confirm.getId() + "");
					newConfirm.setPhone("");
					confirmServices.addConfirm(newConfirm);
					String[] customerIds=customerId.split(",");
					for(int i=0;i<customerIds.length;i++){
						
						ContractCustomer contractCustomer=contractCustomerServices.findContractCustomerById(Integer.parseInt(customerIds[i]));
						contractCustomer.setIsValid("1");
						contractCustomerServices.updateContractCustomer(contractCustomer);
						contractCustomer.setIsValid("0");
						contractCustomer.setMainId(newConfirm.getId());
						contractCustomerServices.addContractCustomer(contractCustomer);
						
						
						//修改对应客户的状态
//						contractCustomerServices.updateContractCustomerConfirmType(Integer.parseInt(customerIds[i]), ContConfirmType.CONFIRM);
						//修改MainId
//						contractCustomerServices.updateContractCustomerMainId(Integer.parseInt(customerIds[i]), newConfirm.getId());
					}
					
					CommonUnitPojo pojo2=CommonUnitPojoUtils.getPojoByUnitId(replaceUnit.getUnitId2());
					replaceUnit.setUnitId2(pojo2.getUnitId());
					replaceUnit.setBuildId2(pojo2.getBuildId());
					replaceUnit.setCompanyProjectId2(pojo2.getCompanyProjectId());
					replaceUnit.setPropertyProjectId2(pojo2.getPropertyProjectId());
					replaceUnit.setAreaId2(pojo2.getAreaId());
					replaceUnit.setConfirmId2(newConfirm.getId());
					
					
					
					replaceUnitServices.addReplaceUnit(replaceUnit);
					unit.setSaleState(ContUnitSaleState.SALE_ABLE);
					unitServices.updatePropertyUnit(unit);
					
					unitOperRecord=new UnitOperRecord();
					unitOperRecord.setUnitId(unitId);
					CommonPojoUtils.initPojoCommonFiled(unitOperRecord);
					CommonUnitPojoUtils.initPojoCommonFiled(unitOperRecord);
					unitOperRecord.setOperType(ContUnitSaleState.CHANGE_UNIT);
					unitOperRecord.setMainId(replaceUnit.getId());
					
					if(unitOperRecordServices.findUnitOperRecordByUnitIdOfMaxId(unitId)!=null){
						unitOperRecord.setParentId(unitOperRecordServices.findUnitOperRecordByUnitIdOfMaxId(unitId).getId());//待修改
					}else{
						unitOperRecord.setParentId(0);
					}
					unitOperRecordServices.addUnitOperRecord(unitOperRecord);
					
					request.getSession().removeAttribute("confirmChangeUnit");
					request.getSession().removeAttribute("customerIdChangeUnit");
				}
				
				@Override
				public void modifyMethodException(Exception e) {
					setUpEasyuiAjaxForFail("请先新建成交");
				}
			});
			return null;
		
	}
	
	
	
	/**
	 * 选择新单元
	 * @return
	 */
	
	public String chooseNewUnit(){
		
		//2013.5.28,dtc增加对数管理下的单元选择
		String type = request.getParameter("type");
		if("checkfeeForAllRefund".equals(type)){
			return "choose_new_unit_checkfee";
		}
		
		//2013.6.27,dtc增加部分回款
		if("checkfeeForPartRefund".equals(type)){
			return "choose_new_unit_checkfee_part";
		}
		
		return "choose_new_unit";
	}
	
	
	/**
	 * 判断"建筑单价","套内单价","标准总价","建筑面积","套内面积"是否变化
	 * @param oldUnit
	 * @param newUnit
	 */
	private void modifyUnitSomeMoney(PropertyUnit oldUnit, PropertyUnit newUnit){
		
		if(oldUnit.getBuildPrice().compareTo(newUnit.getBuildPrice()) == 0
				&& oldUnit.getInsidePrice().compareTo(newUnit.getInsidePrice()) == 0
				&& oldUnit.getSumPrice().compareTo(newUnit.getSumPrice()) == 0
				&& oldUnit.getBuildArea().compareTo(newUnit.getBuildArea()) == 0
				&& oldUnit.getInsideArea().compareTo(newUnit.getInsideArea()) == 0){
			//表示没有修改
			
			return;
		}
		
		oldUnit.setBuildPrice(newUnit.getBuildPrice());
		oldUnit.setInsidePrice(newUnit.getInsidePrice());
		oldUnit.setSumPrice(newUnit.getSumPrice());
		
		oldUnit.setBuildArea(newUnit.getBuildArea());
		oldUnit.setInsideArea(newUnit.getInsideArea());
		
		oldUnit.setModId(SessionUser.getUserId());
		oldUnit.setModTime(new Date());
		
		unitServices.updatePropertyUnit(oldUnit);
	}
	
	

	
	
	
}
