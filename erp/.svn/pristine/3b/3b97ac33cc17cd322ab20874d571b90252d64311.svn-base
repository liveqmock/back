package com.ihk.saleunit.action.easyui.confirm;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitChangeTypeFrom;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IUnitDiscountServices;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.exception.UnitChangeException;
import com.ihk.utils.financial.FinancialUtils;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;
import com.ihk.utils.saleunit.PayWayUtils;
import com.ihk.utils.saleunit.UnitChangeUtils;
import com.ihk.utils.saleunit.UnitSaleStateUtils;
import com.ihk.utils.saleunitnew.UnitOperRecordUtils;

/**
 * 居于easyui的成交
 * @author dtc
 * 2013-6-19,下午02:40:15
 */
@SuppressWarnings("rawtypes")
public class EasyUIConfirmAction extends SupperAction {

	private static final long serialVersionUID = 7248562448774259048L;
	
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IContractCustomerServices contractCustomerServices;
	@Autowired
	IUnitDiscountServices discountServices;
	
	/**
	 * 跳到新增成交界面
	 * @return
	 * @throws Exception
	 */
	public String toCreateConfirmDialog() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		
		init(unitId);
		
		return "toCreateConfirmDialog";
	}
	
	/**
	 * 保存成交
	 * @return
	 * @throws Exception
	 */
	public String saveEasyUIConfirm() throws Exception{
		
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				PropertyUnit getUnit = unitServices.findPropertyUnitById(confirm.getUnitId());
				
				//增加之前应该判断该单元是否可以认购
				boolean isCanChange = UnitChangeUtils.isCanChange(ContUnitChangeTypeFrom.CONFIRM, unit);
				if(!isCanChange)
					throw new UnitChangeException();
				
				//增加单元应付款单unit_pay_bill
				FinancialUtils.addUnitPayBillByPayWayIdAndUnitId(confirm);
				
				//判断"建筑单价","套内单价","标准总价","建筑面积","套内面积"是否变化,变化了要一并修改
				modifyUnitSomeMoney(getUnit, unit);
				
				//修改房间的状态
				UnitSaleStateUtils.changeSaleState(unitServices, confirm.getUnitId(), ContUnitSaleState.CONFIRM);
				
				//增加认购
				CommonPojoUtils.initPojoCommonFiled(confirm);
				confirm.setPhone("");
				confirmServices.addConfirm(confirm);
				
				//增加成交客户
				//ContractCustomerUtils.modifyCustomer(confirm.getId(), ContConfirmType.CONFIRM, customerId);
				
				String[] customerIds=customerId.split(",");
				for(int i=0;i<customerIds.length;i++){
					//修改对应客户的状态
					contractCustomerServices.updateContractCustomerConfirmType(Integer.parseInt(customerIds[i]), ContConfirmType.CONFIRM);

					//修改MainId
					contractCustomerServices.updateContractCustomerMainId(Integer.parseInt(customerIds[i]), confirm.getId());
				}
				
				//设置折扣单中的main_id
				unitDiscountId = request.getParameter("unitDiscountId");
				if(!CommonUtils.isStrZeroEmpty(unitDiscountId)){
					discountServices.updateUnitDiscountMainId(Integer.parseInt(unitDiscountId), confirm.getId(), ContConfirmType.CONFIRM);
				}
				
			}
			
			@Override
			public void modifyMethodException(Exception e) {
				
				setUpEasyuiAjaxForFail(e.getMessage());
			}
		});
		
		return null;
	}
	
	/**
	 * 跳到查看或修改页面
	 * @return
	 * @throws Exception
	 */
	public String toShowConfirmDialog() throws Exception{
		
		int confirmId = Integer.parseInt(request.getParameter("confirmId"));
		
		confirm = confirmServices.findConfirmById(confirmId);
		confirmCustomer = contractCustomerServices.findContractCustomerById(confirm.getCustomerId());
		
		init(confirm.getUnitId());
		
		return "toShowConfirmDialog";
	}
	
	/**
	 * 修改成交
	 * @return
	 * @throws Exception
	 */
	public String updateEasyUIConfirm() throws Exception{
		
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				PropertyUnit getUnit = unitServices.findPropertyUnitById(confirm.getUnitId());
				
				Confirm oldConfirm = confirmServices.findConfirmById(confirm.getId());
				
				
				
				//判断"付款方式","成交总价"是否有修改,
				modifySumMoneyOrPayWay(oldConfirm, confirm);
				
				CommonPojoUtils.initPojoForUpdate(oldConfirm, confirm);
				
				confirmServices.updateConfirm(confirm);
				
				//判断"建筑单价","套内单价","标准总价","建筑面积","套内面积"是否变化
				modifyUnitSomeMoney(getUnit, unit);
				
				//修改成交
			 	
			 	
			 	
			 	//要先判断客户是否有变化,(允许查看认购时修改客户,后续需要删除)
			 	//ContractCustomerUtils.modifyCustomer(confirm.getId(), ContConfirmType.CONFIRM, customerId);
			 	
			 	//允许查看认购时修改客户，后续需要删除
			 	List<ContractCustomer> ccList= contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirm.getId(), ContConfirmType.CONFIRM);
			 	List<Integer> idList=new ArrayList<Integer>(); 
			 	for(ContractCustomer cc:ccList){
			 		idList.add(cc.getId());
			 	}
			 	String[] customerIds=customerId.split(",");
			 	List<Integer> newIdList=new ArrayList<Integer>(); 
				for(int i=0;i<customerIds.length;i++){
					//修改对应客户的状态
					if("".equals(customerIds[i])){
						continue;
					}
					contractCustomerServices.updateContractCustomerConfirmType(Integer.parseInt(customerIds[i]), ContConfirmType.CONFIRM);
					//修改MainId
					contractCustomerServices.updateContractCustomerMainId(Integer.parseInt(customerIds[i]), confirm.getId());
					
					newIdList.add(Integer.parseInt(customerIds[i]));
				}
				
				//修改对应客户的状态
				for(int i=0;i<idList.size();i++){
					if(!newIdList.contains(idList.get(i))){
						contractCustomerServices.deleteContractCustomer(idList.get(i));
					}	
				}
				//判断成交是否有被修改
//				if(oldConfirm.equals(confirm)){
					UnitOperRecordUtils.addOperRecord(confirm.getUnitId(), ContUnitSaleState.MODIFY_CONFIRM, confirm.getId());
//				}
			}

			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
			}
		});
		
		return null;
	}
	
	/**
	 * 初始化
	 * @param unitId
	 */
	private void init(int unitId){
		
		//如果为临定状态,应该把对应的客户查找出来
		unit = unitServices.findPropertyUnitById(unitId);
		if(ContUnitSaleState.CONFIRM_BOOK.equals(unit.getSaleState())){
			
			ConfirmBook book = unit.getConfirmBook();
			if(book != null){
				confirmCustomer = contractCustomerServices.findContractCustomerById(book.getCustomerId());
			}
			
		}
		
		selPayType = PayWayUtils.getSelPayWayByUnitId(unitId);
		date = CommonUtils.getNowForString();
		
		selPriceWay = DescUtils.getInitSelForGuangZhou(selPriceWay, EnumCodeTypeName.PROPERTY_PRICE_WAY, true);
		selIsMerge = DescUtils.getInitSelEmptyAndTrueFalse(selIsMerge, false);
		
		selCustomerGender = DescUtils.getInitSelEmptyAndGender(selCustomerGender);
		selCustomerIdCardType = DescUtils.getInitSelForGuangZhou(selCustomerIdCardType, EnumCodeTypeName.SALEUNIT_IDCARD_TYPE, true);
		
		selPropertyType = DescUtils.getInitSelForGuangZhou(selPropertyType, EnumCodeTypeName.SALEUNIT_PROPERTY_TYPE, true);
		
		confirmType = ContConfirmType.CONFIRM;
		
		isHaveReceipt = FinancialUtils.isUnitPayBillListHaveReceiptByUnitId(unitId);
		
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
	
	/**
	 * 判断"成交总价","付款方式"是否有修改
	 * @param oldConfirm
	 * @param confirm
	 * @throws Exception 
	 */
	private void modifySumMoneyOrPayWay(Confirm oldConfirm, Confirm confirm) throws Exception{
		
		if(oldConfirm.getSumMoney().compareTo(confirm.getSumMoney()) == 0 
				&& oldConfirm.getPayWayId() == confirm.getPayWayId()){
			//表示没有修改
			
			return ;
		}
		
		/**
		int oldConfirmUnitId = oldConfirm.getUnitId();
		if(FinancialUtils.isUnitPayBillListHaveReceiptByUnitId(oldConfirmUnitId)){
			
			throw new Exception("旧的成交单已有对应的实收,不能修改付款方式或成交总价");
		}
		*/
		
		FinancialUtils.addUnitPayBillByPayWayIdAndUnitId(confirm);
		
	}
	
	////
	/**
	 * 对应的成交
	 */
	private Confirm confirm;
	
	/**
	 * 对应的单元
	 */
	private PropertyUnit unit; 
	
	/**
	 * 对应客户的id连接
	 */
	private String customerId;
	
	/**
	 * 单元折扣id
	 */
	private String unitDiscountId;
	
	/**
	 * 成交合同客户
	 */
	private ContractCustomer confirmCustomer;
	
	/**
	 * 付款方式(根据楼栋,从表pay_way中获取)
	 */
	private LinkedHashMap<String, String> selPayType; //付款方式(根据楼栋,从表pay_way中获取)
	
	/**
	 * 计价方式
	 */
	private LinkedHashMap selPriceWay; //计价方式
	
	/**
	 * 是否并入合同(是否二手成交,是否一二手联动,是否关系户共用)
	 */
	private LinkedHashMap selIsMerge; //是否并入合同(是否二手成交,是否一二手联动,是否关系户共用)
	
	/**
	 * 新建客户,性别
	 */
	private LinkedHashMap selCustomerGender; //新建客户,性别
	
	/**
	 * 新建客户,证件类型
	 */
	private LinkedHashMap selCustomerIdCardType; //新建客户,证件类型
	
	/**
	 * 房产类型
	 */
	private LinkedHashMap selPropertyType; //房产类型
	
	/**
	 * 成交类型
	 */
	private String confirmType;
	
	/**
	 * 认购日期
	 */
	private String date; //认购日期
	
	/**
	 * 该单元是否有已收
	 */
	private boolean isHaveReceipt;
	
	public boolean getIsHaveReceipt() {
		return isHaveReceipt;
	}

	public void setHaveReceipt(boolean isHaveReceipt) {
		this.isHaveReceipt = isHaveReceipt;
	}
	
	public ContractCustomer getConfirmCustomer() {
		return confirmCustomer;
	}

	public void setConfirmCustomer(ContractCustomer confirmCustomer) {
		this.confirmCustomer = confirmCustomer;
	}

	public LinkedHashMap<String, String> getSelPayType() {
		return selPayType;
	}

	public void setSelPayType(LinkedHashMap<String, String> selPayType) {
		this.selPayType = selPayType;
	}

	public LinkedHashMap getSelPriceWay() {
		return selPriceWay;
	}

	public void setSelPriceWay(LinkedHashMap selPriceWay) {
		this.selPriceWay = selPriceWay;
	}

	public LinkedHashMap getSelIsMerge() {
		return selIsMerge;
	}

	public void setSelIsMerge(LinkedHashMap selIsMerge) {
		this.selIsMerge = selIsMerge;
	}

	public LinkedHashMap getSelCustomerGender() {
		return selCustomerGender;
	}

	public void setSelCustomerGender(LinkedHashMap selCustomerGender) {
		this.selCustomerGender = selCustomerGender;
	}

	public LinkedHashMap getSelCustomerIdCardType() {
		return selCustomerIdCardType;
	}

	public void setSelCustomerIdCardType(LinkedHashMap selCustomerIdCardType) {
		this.selCustomerIdCardType = selCustomerIdCardType;
	}

	public LinkedHashMap getSelPropertyType() {
		return selPropertyType;
	}

	public void setSelPropertyType(LinkedHashMap selPropertyType) {
		this.selPropertyType = selPropertyType;
	}

	public String getConfirmType() {
		return confirmType;
	}

	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUnitDiscountId() {
		return unitDiscountId;
	}

	public void setUnitDiscountId(String unitDiscountId) {
		this.unitDiscountId = unitDiscountId;
	}
	
}
