package com.ihk.saleunit.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitChangeTypeFrom;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.ContractCustomerCond;
import com.ihk.saleunit.data.services.IAddonPropertyServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.utils.ActionPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.BuildUnitUtils;
import com.ihk.utils.saleunit.UnitChangeUtils;
import com.ihk.utils.saleunit.UnitSaleStateUtils;

/**
 * 录入
 */
@SuppressWarnings("rawtypes")
public class GuangZhouConfirmInputAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IAddonPropertyServices addonPropertyServices;
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IPropertyBuildServices buildServices;
	@Autowired
	IContractCustomerServices customerServices;
	
	public String confirmInputFirst() throws Exception{
		
		String propertyId = buildCond.getPropertyId();
		String areaId = buildCond.getAreaId();
		String buildId = buildCond.getBuildId();
		
		if(!CommonUtils.isStrEmpty(propertyId) && CommonUtils.isStrEmpty(areaId)){
			
			List<PropertyBuild> buildList = buildServices.findPropertyBuildByPropertyId(Integer.parseInt(propertyId));
			if(!CommonUtils.isCollectionEmpty(buildList)){
				
				List<Integer> buildIds = new ArrayList<Integer>();
				for(PropertyBuild build : buildList){
					buildIds.add(build.getId());
				}
				
				buildCond.setBuildIds(buildIds);
			}
			
		}else if(!CommonUtils.isStrEmpty(propertyId) && !CommonUtils.isStrEmpty(areaId) && CommonUtils.isStrEmpty(buildId)){
			
			List<PropertyBuild> buildList = buildServices.findPropertyBuildByAreaId(Integer.parseInt(areaId));
			if(!CommonUtils.isCollectionEmpty(buildList)){
				
				List<Integer> buildIds = new ArrayList<Integer>();
				for(PropertyBuild build : buildList){
					buildIds.add(build.getId());
				}
				
				buildCond.setBuildIds(buildIds);
			}
			
		}
		
		ActionTemplate actionTemplate = new ActionTemplate(this, buildCond);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				buildList = buildServices.findPropertyBuildPage(buildCond);
			}
		});
		
		removeSuggestion();
		
		return "confirmInputFirst";
	}
	
	public String changeBuildToSecond() throws Exception{
		
		initBuildId();
		
		unitList = unitServices.findUnitsByBuildId(Integer.parseInt(getBuildId()));
		
		trList = BuildUnitUtils.initTrAndDivTdByUnitList(unitList);
		
		/*
		unitCond = new PropertyUnitCond();
		unitCond.setBuildId(this.getBuildId());
		
		ActionTemplate actionTemplate = new ActionTemplate(this, unitCond);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				unitList = unitServices.findPropertyUnitPage(unitCond);
			}
		});
		*/
		
		return "changeBuildToSecond";
	}
	
	public String confirmInputSecond() throws Exception{
		
		initBuildId();
		
		if(unitCond == null){
			unitCond = new PropertyUnitCond();
		}
		
		ActionTemplate actionTemplate = new ActionTemplate(this, unitCond);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				unitList = unitServices.findPropertyUnitPage(unitCond);
			}
		});
		
		return "confirmInputSecond";
	}
	
	//选择房间跳到选择客户
	public String changeUnitToThird() throws Exception{
		
		initUnitId();
		
		return "changeUnitToThird";
	}
	
	public String confirmInputThird() throws Exception{
		
		if(customerCond == null){
			customerCond = new ContractCustomerCond();
		}
		
		customerCond.setConfirmType(ContConfirmType.CONFIRM);
		ActionTemplate actionTemplate = new ActionTemplate(this, customerCond);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				customerList = customerServices.findContractCustomerPage(customerCond);
			}
		});
		
		initBuildId();
		initUnitId();
		
		return "confirmInputThird";
	}
	
	public String changeCustomerToFourth() throws Exception{
		
		initUnitId();
		String customerId = request.getParameter("customerId");
		
		unit = unitServices.findPropertyUnitById(Integer.parseInt(this.getUnitId()));
		customer = customerServices.findContractCustomerById(Integer.parseInt(customerId));
		
		initSel();
		
		return "changeCustomerToFourth";
	}
	
	/**
	 * 执行录入
	 * @return
	 * @throws Exception
	 */
	public String inputConfirm() throws Exception{
		
		boolean isSucc = true;
		
		try{
			
			new MyTransationTemplate(){

				@Override
				protected void doExecuteCallback() throws Exception {
					
					CommonPojoUtils.initPojoCommonFiled(confirm);
					
					int unitId = confirm.getUnitId();
					unit = unitServices.findPropertyUnitById(unitId);
					
					//增加之前应该判断该单元是否可以认购
					boolean isCanChange = UnitChangeUtils.isCanChange(ContUnitChangeTypeFrom.CONFIRM, unit);
					if(!isCanChange)
						throw new Exception("该单元不能认购");
					confirmServices.addConfirm(confirm);
					
					//修改房间的状态
					UnitSaleStateUtils.changeSaleState(unitServices, unitId, ContUnitSaleState.CONFIRM);
					
					//增加认购,要一并把该房间的相关信息保存到 addon_property(附属房产)
					//List<PropertyUnit> addonUnit = unitServices.findAddonPropertyUnitByMainId(unitId);
					/*
					AddonProperty addProperty = new AddonProperty();
					for(PropertyUnit unit : addonUnit){
						
						addProperty.setConfirmType(ContConfirmType.CONFIRM);
						addProperty.setMainId(confirm.getId());
						addProperty.setUnitId(unit.getId());
						
						CommonPojoUtils.initPojoCommonFiled(addProperty);
						
						addonPropertyServices.addAddonProperty(addProperty);
					}*/
					
				}
				
			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			isSucc = false;
		}
		
		if(isSucc){
			
			setSuggestion(CommonUtils.SUCCSUGG);
		}else{
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		initSel();
		
		return "confirmInput";
	}
	
	/**
	 * 显示录入界面
	 * @return
	 * @throws Exception
	 */
	public String forInput() throws Exception{
		
		String deleteSession = request.getParameter("deleteSession");
		
		if(!"false".equals(deleteSession)){
			removeSuggestion();
		}
		
		if("token".equals(deleteSession)){
			setSuggestion(CommonUtils.TOKEN);
		}
		
		if(buildCond == null){
			buildCond = new PropertyBuildCond();
		}
		ActionTemplate actionTemplate = new ActionTemplate(this, buildCond);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				buildList = buildServices.findPropertyBuildPage(buildCond);
			}
		});
		
		initSel();
		
		return "forInput";
	}
	
	private void initUnitId(){
		
		unitId = request.getParameter("unitId");
	}
	
	private void initBuildId(){
		
		buildId = request.getParameter("buildId");
		try{
			build = buildServices.findPropertyBuildById(Integer.parseInt(this.getBuildId()));
		}catch(Exception e){
			build = new PropertyBuild();
		}
	}
	
	private void initSel(){
		
		selPriceWay = DescUtils.getInitSelForGuangZhou(selPriceWay, EnumCodeTypeName.PROPERTY_PRICE_WAY, true);
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType, EnumCodeTypeName.PAY_TYPE, true);
		selIsMerge = DescUtils.getInitSelEmptyAndTrueFalse(selIsMerge);
	}
		
	///////
	private Confirm confirm;
	
	private LinkedHashMap selPayType; //付款方式
	private LinkedHashMap selIsMerge; //是否并入合同
	private LinkedHashMap selPriceWay; //计价方式
	
	private PropertyBuild build;
	private PropertyBuildCond buildCond;
	private List<PropertyBuild> buildList;
	
	private PropertyUnitCond unitCond;
	private List<PropertyUnit> unitList;
	
	private String buildId; //楼栋到房间使用
	private String unitId; //房间到客户使用
	
	private ContractCustomerCond customerCond;
	private List<ContractCustomer> customerList;
	
	private PropertyUnit unit; //第四步主要信息使用
	private ContractCustomer customer; //第四步主要信息使用
	
	private List<String> trList; //房间的tr
	
	public void setTrList(List<String> trList) {
		this.trList = trList;
	}
	
	public List<String> getTrList() {
		return trList;
	}
	
	public PropertyBuild getBuild() {
		return build;
	}

	public void setBuild(PropertyBuild build) {
		this.build = build;
	}

	public PropertyBuildCond getBuildCond() {
		return buildCond;
	}

	public void setBuildCond(PropertyBuildCond buildCond) {
		this.buildCond = buildCond;
	}

	public List<PropertyBuild> getBuildList() {
		return buildList;
	}

	public void setBuildList(List<PropertyBuild> buildList) {
		this.buildList = buildList;
	}

	public PropertyUnitCond getUnitCond() {
		return unitCond;
	}

	public void setUnitCond(PropertyUnitCond unitCond) {
		this.unitCond = unitCond;
	}

	public List<PropertyUnit> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<PropertyUnit> unitList) {
		this.unitList = unitList;
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public ContractCustomerCond getCustomerCond() {
		return customerCond;
	}

	public void setCustomerCond(ContractCustomerCond customerCond) {
		this.customerCond = customerCond;
	}

	public List<ContractCustomer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<ContractCustomer> customerList) {
		this.customerList = customerList;
	}

	public PropertyUnit getUnit() {
		return unit;
	}

	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}

	public ContractCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(ContractCustomer customer) {
		this.customer = customer;
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
	
	public void setSelPriceWay(LinkedHashMap selPriceWay) {
		this.selPriceWay = selPriceWay;
	}
	
	public LinkedHashMap getSelPriceWay() {
		return selPriceWay;
	}
	
	public void setConfirm(Confirm confirm) {
		this.confirm = confirm;
	}
	
	public Confirm getConfirm() {
		return confirm;
	}
	

}
