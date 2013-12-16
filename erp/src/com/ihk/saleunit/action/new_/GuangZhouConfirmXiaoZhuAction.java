package com.ihk.saleunit.action.new_;

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
import com.ihk.property.data.services.IPayWayServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IUnitDiscountServices;
import com.ihk.utils.ActionMethodModifyUtils;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.exception.UnitChangeException;
import com.ihk.utils.exception.UnitPayBillException;
import com.ihk.utils.financial.FinancialUtils;
import com.ihk.utils.saleunit.PayWayUtils;
import com.ihk.utils.saleunit.UnitChangeUtils;
import com.ihk.utils.saleunit.UnitSaleStateUtils;

/**
 *  大学小筑认购界面
 */
@SuppressWarnings("rawtypes")
public class GuangZhouConfirmXiaoZhuAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IContractCustomerServices contractCustomerServices;
	@Autowired
	IPayWayServices payWayServices; 
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IUnitDiscountServices discountServices;
	
	/**
	 * 跳到认购见面
	 * @return
	 * @throws Exception
	 */
	public String createXiaoZhuConfirmDialog() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		
		init(unitId);
		
		removeSuggestion();
		
		String type = request.getParameter("type");
		if("changeUnit".equals(type)){	//换房新建成交专用
			int oldUnitId = Integer.parseInt(request.getParameter("oldUnitId"));//换房原来id
			confirm=confirmServices.findConfirmByUnitId(oldUnitId);
			return "changeUnitaddConfirmDialog";
		}
		
		return "createXiaoZhuConfirmDialog";
	}
	
	/**
	 * 保存认购
	 * @return
	 * @throws Exception
	 */
	public String saveXiaoZhuConfirmDialog() throws Exception{
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					PropertyUnit getUnit = unitServices.findPropertyUnitById(confirm.getUnitId());
					
					//增加之前应该判断该单元是否可以认购
					boolean isCanChange = UnitChangeUtils.isCanChange(ContUnitChangeTypeFrom.CONFIRM, unit);
					if(!isCanChange)
						throw new UnitChangeException();
					
					//判断"建筑单价","套内单价","标准总价","建筑面积","套内面积"是否变化,变化了要一并修改
					modifyUnitSomeMoney(getUnit, unit);
					
					//修改房间的状态
					UnitSaleStateUtils.changeSaleState(unitServices, confirm.getUnitId(), ContUnitSaleState.CONFIRM);
					
					//增加单元应付款单unit_pay_bill
					//FinancialUtils.addUnitPayBillByPayWayIdAndUnitId(confirm.getPayWayId(), confirm.getUnitId(),confirm.getSalePrice(), confirm.getWorkDate());
					FinancialUtils.addUnitPayBillByPayWayIdAndUnitId(confirm);
					
					//增加认购
					CommonPojoUtils.initPojoCommonFiled(confirm);
					confirm.setPhone("");
					confirmServices.addConfirm(confirm);
					
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
					
					setSuggestion(CommonUtils.SUCCSUGG);
					
					setUpMarkToClose();
					
				}
			}.execute();
			
		}catch (UnitChangeException e) {
			
			setSuggestion(e.getMessage());
		}catch (UnitPayBillException e) {
			
			setSuggestion(e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		init(confirm.getUnitId());
		
		return "saveXiaoZhuConfirmDialog";
	}
	
	/**
	 * 换房
	 * @return
	 * @throws Exception
	 */
	public String changeUnitAddConfirmDialog() throws Exception{
		
		new ActionMethodModifyUtils(true) {
			
			@Override
			protected void modifyMethod() throws Exception {
				try{
					request.getSession().setAttribute("confirmChangeUnit", confirm);
					request.getSession().setAttribute("customerIdChangeUnit", customerId);
				}catch(Exception e){
				}

			}
		}.doModify(this);
		
		return null;
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 * @throws Exception
	 */
	public String showXiaoZhuConfirmDialog() throws Exception{
		
		int confirmId = Integer.parseInt(request.getParameter("confirmId"));
		
		confirm = confirmServices.findConfirmById(confirmId);
		confirmCustomer = contractCustomerServices.findContractCustomerById(confirm.getCustomerId());
		
		contractCustomerList = contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirm.getCustomerId(), ContConfirmType.CONFIRM);
		
		init(confirm.getUnitId());
		
		removeSuggestion();
		
		return "showXiaoZhuConfirmDialog";
	}
	
	/**
	 * 修改认购
	 * @return
	 * @throws Exception
	 */
	public String updateXiaoZhuConfirmDialog() throws Exception{
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					PropertyUnit getUnit = unitServices.findPropertyUnitById(confirm.getUnitId());
					
					//判断"建筑单价","套内单价","标准总价","建筑面积","套内面积"是否变化
					modifyUnitSomeMoney(getUnit, unit);
				 	
				 	Confirm oldConfirm = confirmServices.findConfirmById(confirm.getId());
				 	CommonPojoUtils.initPojoForUpdate(oldConfirm, confirm);
				 	confirmServices.updateConfirm(confirm);
				 	
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
					
					//System.out.println(ccList.size());
					//修改对应客户的状态
					for(int i=0;i<idList.size();i++){
						if(!newIdList.contains(idList.get(i))){
							//System.out.println(idList.get(i));
							//ContractCustomer contractCustomer=contractCustomerServices.findContractCustomerById(idList.get(i));
							contractCustomerServices.deleteContractCustomer(idList.get(i));
							//contractCustomerServices.updateContractCustomer(contractCustomer);
						}
						
					}
				 	
//				 	//允许查看成交时修改客户，后续需要删除
//				 	String[] customerIds=customerId.split(",");
//					for(int i=0;i<customerIds.length;i++){
//						//修改对应客户的状态
//						contractCustomerServices.updateContractCustomerConfirmType(Integer.parseInt(customerIds[i]), ContConfirmType.CONFIRM);
//
//						//修改MainId
//						contractCustomerServices.updateContractCustomerMainId(Integer.parseInt(customerIds[i]), confirm.getId());
//					}
				 	setSuggestion(CommonUtils.SUCCSUGG);
				 	
				 	setUpMarkToClose();
					
				}
			}.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		init(confirm.getUnitId());
		
		return "updateXiaoZhuConfirmDialog";
	}
	
	/**
	 * 获取付款方式的具体步骤
	 * @return
	 * @throws Exception
	 */
	public String getDetailTrByPayWayIdForXiaoZhu() throws Exception{
		
		int wayId = Integer.parseInt(request.getParameter("wayId"));
		
		String tr = PayWayUtils.getDetailTrByPayWayIdForXiaoZhu(wayId);
		
		CustomerUtils.writeResponse(response, tr);
		
		return null;
	}
	
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
		selIsMerge = DescUtils.getInitSelEmptyAndTrueFalse(selIsMerge);
		
		selCustomerGender = DescUtils.getInitSelEmptyAndGender(selCustomerGender);
		selCustomerIdCardType = DescUtils.getInitSelForGuangZhou(selCustomerIdCardType, EnumCodeTypeName.SALEUNIT_IDCARD_TYPE, true);
		
		selPropertyType = DescUtils.getInitSelForGuangZhou(selPropertyType, EnumCodeTypeName.SALEUNIT_PROPERTY_TYPE, true);
		
		confirmType = ContConfirmType.CONFIRM;
		
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
	
	private PropertyUnit unit; //页面的单元
	
	private LinkedHashMap<String, String> selPayType; //付款方式(根据楼栋,从表pay_way中获取)
	private LinkedHashMap selPriceWay; //计价方式
	private LinkedHashMap selIsMerge; //是否并入合同(是否二手成交,是否一二手联动,是否关系户共用)
	
	private LinkedHashMap selCustomerGender; //新建客户,性别
	private LinkedHashMap selCustomerIdCardType; //新建客户,证件类型
	
	private LinkedHashMap selPropertyType; //房产类型
	
	private String confirmType;
	
	private ContractCustomer confirmCustomer;
	
	private Confirm confirm;
	
	private String date; //认购日期
	
	private String unitDiscountId;
	
	private String customerId;
	
	private List<ContractCustomer> contractCustomerList;
	
	

	public List<ContractCustomer> getContractCustomerList() {
		return contractCustomerList;
	}

	public void setContractCustomerList(List<ContractCustomer> contractCustomerList) {
		this.contractCustomerList = contractCustomerList;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setUnitDiscountId(String unitDiscountId) {
		this.unitDiscountId = unitDiscountId;
	}
	
	public String getUnitDiscountId() {
		return unitDiscountId;
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

	public void setSelIsMerge(LinkedHashMap selIsMerge) {
		this.selIsMerge = selIsMerge;
	}
	
	public LinkedHashMap getSelIsMerge() {
		return selIsMerge;
	}
	
	public void setSelPriceWay(LinkedHashMap selPriceWay) {
		this.selPriceWay = selPriceWay;
	}
	
	public LinkedHashMap getSelPriceWay() {
		return selPriceWay;
	}
	
	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}
	
	public PropertyUnit getUnit() {
		return unit;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setConfirm(Confirm confirm) {
		this.confirm = confirm;
	}
	
	public Confirm getConfirm() {
		return confirm;
	}
	
	public void setConfirmCustomer(ContractCustomer confirmCustomer) {
		this.confirmCustomer = confirmCustomer;
	}
	
	public ContractCustomer getConfirmCustomer() {
		return confirmCustomer;
	}
	
	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
	
	public String getConfirmType() {
		return confirmType;
	}
	
	public void setSelPayType(LinkedHashMap<String, String> selPayType) {
		this.selPayType = selPayType;
	}
	
	public LinkedHashMap<String, String> getSelPayType() {
		return selPayType;
	}
	
}
