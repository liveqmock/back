package com.ihk.saleunit.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.UnitSaleStateUtils;

/**
 *  修改action
 */
@SuppressWarnings("rawtypes")
public class GuangZhouConfirmUpdateAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IContractServices contractServices;
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IContractCustomerServices contractCustomerServices;
	
	public String getById() throws Exception{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		confirm = confirmServices.findConfirmById(id);
		unit = unitServices.findPropertyUnitById(confirm.getUnitId());
		
		initSel();
		
		removeSuggestion();
		
		return "getById";
	}
	
	public String updateConfirm() throws Exception{
		
		int id = confirm.getId();
		
		Confirm oldConfrim = confirmServices.findConfirmById(id);
		
		CommonPojoUtils.initPojoForUpdate(oldConfrim, confirm);
		
		try{

			confirmServices.updateConfirm(confirm);
			setSuggestion(CommonUtils.SUCCSUGG);
			
		}catch(Exception e){
			e.printStackTrace();
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		confirm = confirmServices.findConfirmById(id);
		
		initSel();
		
		return "updateConfirm";
	}
	
	/**
	 * 认购转合同
	 * @return
	 * @throws Exception
	 */
	public String changeToContract() throws Exception{
		
		final Map<String, String> map = new HashMap<String, String>();
		boolean isSucc = true;
		
		try{
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					int confirmId = Integer.parseInt(request.getParameter("confirmId"));
					
					Confirm confirm = confirmServices.findConfirmById(confirmId);
					
					//避免有人通过地址栏直接进行修改,在该处进行一下判断
					if(confirm == null || !confirm.getCanChangeToContract()){
						
						throw new Exception("非法操作.");
					}
					
					int confirmCustomerId = confirm.getCustomerId();
					ContractCustomer confirmCustomer = contractCustomerServices.findContractCustomerById(confirmCustomerId);
					
					ContractCustomer contractCustomer = new ContractCustomer();
					contractCustomer.setConfirmType(ContConfirmType.CONTRACT);
					contractCustomer.setPhone(confirmCustomer.getPhone());
					
					contractCustomer.setCustomerName(confirmCustomer.getCustomerName());
					contractCustomer.setGender(confirmCustomer.getGender());
					contractCustomer.setIdcardType(confirmCustomer.getIdcardType());
					contractCustomer.setIdcardNo(confirmCustomer.getIdcardNo());
					
					CommonPojoUtils.initPojoCommonFiled(contractCustomer);
					
					contractCustomerServices.addContractCustomer(contractCustomer);
					
					//新建一条新的合同单(可以利用commons-beanutils下的相关类去实现)
					Contract contract = new Contract();
					
					contract.setConfirmId(confirmId);
					contract.setCustomerId(contractCustomer.getId()); //要把客户增加到对应的contract_customer
					contract.setPhone(contractCustomer.getPhone());
					
					contract.setUnitId(confirm.getUnitId());
					contract.setPriceWay(confirm.getPriceWay());
					contract.setPayWayId(confirm.getPayWayId());
					
					contract.setDiscountPercent(confirm.getDiscountPercent());
					contract.setBuildPrice(confirm.getBuildPrice());
					contract.setInsideUnitPrice(confirm.getInsideUnitPrice());
					
					contract.setDiscountDesc(confirm.getDiscountDesc());
					contract.setSumMoney(confirm.getSumMoney());
					contract.setRenovateDesc(confirm.getRenovateDesc());
					
					contract.setRenovatePrice(confirm.getRenovatePrice());
					contract.setIsMerge(confirm.getIsMerge());
					contract.setRenovateMoney(confirm.getRenovateMoney());
					
					contract.setShouldDeposit(confirm.getShouldDeposit());
					contract.setSignDate(confirm.getSignDate());
					contract.setWorkDate(confirm.getWorkDate());
					
					contract.setRecommendMan(confirm.getRecommendMan());
					//contract.setSalesId(confirm.getSalesId());
					contract.setConfirmDeliveryDate(confirm.getDeliveryDate());
					
					CommonPojoUtils.initPojoCommonFiled(contract);
					
					contractServices.addContract(contract);
					
					confirmServices.updateConfirmSetContractId(confirmId, contract.getId());
					
					map.put("id", contract.getId()+"");
					
					//修改单元的状态(sale_state)
					UnitSaleStateUtils.changeSaleState(unitServices, confirm.getUnitId(), ContUnitSaleState.CONTRACT);
					
				}
			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			isSucc = false;
		}
		
		map.put("type", isSucc+"");
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
	
	
	private void initSel(){
		
		selPriceWay = DescUtils.getInitSelForGuangZhou(selPriceWay, EnumCodeTypeName.PROPERTY_PRICE_WAY, true);
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType, EnumCodeTypeName.PAY_TYPE, true);
		selIsMerge = DescUtils.getInitSelEmptyAndTrueFalse(selIsMerge);
		
	}
	
	
	////////////
	
	private Confirm confirm;
	
	private PropertyUnit unit;
	
	private LinkedHashMap selPayType; //付款方式
	private LinkedHashMap selIsMerge; //是否并入合同
	private LinkedHashMap selPriceWay; //计价方式
	
	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}
	
	public PropertyUnit getUnit() {
		return unit;
	}
	
	public void setSelPriceWay(LinkedHashMap selPriceWay) {
		this.selPriceWay = selPriceWay;
	}
	
	public LinkedHashMap getSelPriceWay() {
		return selPriceWay;
	}
	
	public void setSelIsMerge(LinkedHashMap selIsMerge) {
		this.selIsMerge = selIsMerge;
	}
	
	public LinkedHashMap getSelIsMerge() {
		return selIsMerge;
	}
	
	public void setSelPayType(LinkedHashMap selPayType) {
		this.selPayType = selPayType;
	}
	
	public LinkedHashMap getSelPayType() {
		return selPayType;
	}
	
	public void setConfirm(Confirm confirm) {
		this.confirm = confirm;
	}
	
	public Confirm getConfirm() {
		return confirm;
	}

}
