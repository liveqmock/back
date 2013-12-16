package com.ihk.saleunit.action;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 *  修改action
 */
@SuppressWarnings("rawtypes")
public class GuangZhouContractUpdateAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IContractServices contractServices;
	@Autowired
	IPropertyUnitServices unitServices;
	
	public String getById() throws Exception{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		contract = contractServices.findContractById(id);
		unit = unitServices.findPropertyUnitById(contract.getUnitId());
		
		initSel();
		
		removeSuggestion();
		
		return "getById";
	}
	
	public String updateContract() throws Exception{
		
		int id = contract.getId();
		
		Contract oldContract = contractServices.findContractById(id);
		
		CommonPojoUtils.initPojoForUpdate(oldContract, contract);
		
		try{
			
			contractServices.updateContract(contract);
			setSuggestion(CommonUtils.SUCCSUGG);
			
		}catch(Exception e){
			e.printStackTrace();
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		contract = contractServices.findContractById(id);
		
		initSel();
		
		return "updateContract";
	}
	
	private void initSel(){
		
		selPropertyType = DescUtils.getInitSelForGuangZhou(selPropertyType, EnumCodeTypeName.SALEUNIT_PROPERTY_TYPE, true);
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType, EnumCodeTypeName.PAY_TYPE, true);
		selIsMerge = DescUtils.getInitSelEmptyAndTrueFalse(selIsMerge);
		
		selPriceWay = DescUtils.getInitSelForGuangZhou(selPriceWay, EnumCodeTypeName.PROPERTY_PRICE_WAY, true);
		
	}
	
	
	////
	private Contract contract;
	
	private PropertyUnit unit;
	
	private LinkedHashMap selPropertyType; //房产类型
	private LinkedHashMap selPayType; //付款方式
	private LinkedHashMap selIsMerge; //是否并入合同
	private LinkedHashMap selPriceWay; //计价方式
	
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
	
	public LinkedHashMap getSelPropertyType() {
		return selPropertyType;
	}

	public void setSelPropertyType(LinkedHashMap selPropertyType) {
		this.selPropertyType = selPropertyType;
	}

	public LinkedHashMap getSelPayType() {
		return selPayType;
	}

	public void setSelPayType(LinkedHashMap selPayType) {
		this.selPayType = selPayType;
	}

	public LinkedHashMap getSelIsMerge() {
		return selIsMerge;
	}

	public void setSelIsMerge(LinkedHashMap selIsMerge) {
		this.selIsMerge = selIsMerge;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	public Contract getContract() {
		return contract;
	}
	
	
	
	

}
