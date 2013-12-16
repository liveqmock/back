package com.ihk.saleunit.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Appoint;
import com.ihk.saleunit.data.pojo.AppointCustomer;
import com.ihk.saleunit.data.pojo.AppointCustomerCond;
import com.ihk.saleunit.data.services.IAppointCustomerServices;
import com.ihk.saleunit.data.services.IAppointServices;
import com.ihk.utils.ActionPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.BuildUnitUtils;
import com.ihk.utils.saleunit.UnitSaleStateUtils;

/**
 * 广州预约排号新建
 */
public class GuangZhouAppointInputAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAppointServices appointServices; 
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IPropertyBuildServices buildServices;
	@Autowired
	IAppointCustomerServices customerServices;
	
	public String appointInputFirst() throws Exception{
		
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
		
		return "appointInputFirst";
	}
	
	public String changeBuildToSecond() throws Exception{
		
		initBuildId();
		
		unitList = unitServices.findUnitsByBuildId(Integer.parseInt(getBuildId()));
		
		trList = BuildUnitUtils.initTrAndDivTdByUnitList(unitList);
		
		/*unitCond = new PropertyUnitCond();
		unitCond.setBuildId(this.getBuildId());
		
		ActionTemplate actionTemplate = new ActionTemplate(this, unitCond);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				unitList = unitServices.findPropertyUnitPage(unitCond);
			}
		});*/
		
		return "changeBuildToSecond";
	}
	
	public String appointInputSecond() throws Exception{
		
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
		
		return "appointInputSecond";
	}
	
	//选择房间跳到选择客户
	public String changeUnitToThird() throws Exception{
		
		initUnitId();
		
		return "changeUnitToThird";
	}
	
	//没有选择房间直接跳到选择客户
	public String noChangeUnitToThird() throws Exception{
		
		initBuildId();
		
		return "noChangeUnitToThird";
	}
	
	public String appointInputThird() throws Exception{
		
		if(customerCond == null){
			customerCond = new AppointCustomerCond();
		}
		
		ActionTemplate actionTemplate = new ActionTemplate(this, customerCond);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				customerList = customerServices.findAppointCustomerPage(customerCond);
			}
		});
		
		initBuildId();
		initUnitId();
		
		return "appointInputThird";
	}
	
	public String changeCustomerToFourth() throws Exception{
		
		initBuildId();
		initUnitId();
		String customerId = request.getParameter("customerId");
		
		//要先判断楼栋与房间的选择情况
		String tmpUnitId = this.getUnitId();
		if(!CommonUtils.isStrEmpty(tmpUnitId)){
			
			unit = unitServices.findPropertyUnitById(Integer.parseInt(tmpUnitId));
		}
		
		fourthMap = new HashMap<String, String>();
		if(unit != null){
			
			fourthMap.put("propertyProjectName", unit.getPropertyProjectName());
			fourthMap.put("propertyProjectId", unit.getPropertyProjectId());
			
			fourthMap.put("propertyBuildName", unit.getPropertyBuildName());
			fourthMap.put("propertyBuildId", unit.getBuildId() + "");
			
			fourthMap.put("unitNo", unit.getUnitNo());
			fourthMap.put("unitId", unit.getId() + "");
		}else{
			
			fourthMap.put("propertyProjectName", build.getDescPropertyId());
			fourthMap.put("propertyProjectId", build.getPropertyId() + "");
			
			fourthMap.put("propertyBuildName", build.getBuildName());
			fourthMap.put("propertyBuildId", build.getId() + "");
		}
		
		customer = customerServices.findAppointCustomerById(Integer.parseInt(customerId));
		
		return "changeCustomerToFourth";
	}
	
	public String inputAppoint() throws Exception{
		
		boolean isSucc = true;
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					CommonPojoUtils.initPojoCommonFiled(appoint);
					appointServices.addAppoint(appoint);
					
					UnitSaleStateUtils.changeSaleState(unitServices, appoint.getUnitId(), ContUnitSaleState.APPOINT);
					
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
		
		return "appointInput";
	}
	
	public String doSomeForInputAppoint() throws Exception{
		
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
		
		return "appointForInput";
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
	///////////////
	
	private Appoint appoint;
	
	private PropertyBuild build;
	private PropertyBuildCond buildCond;
	private List<PropertyBuild> buildList;
	
	private PropertyUnitCond unitCond;
	private List<PropertyUnit> unitList;
	
	private String buildId; //楼栋到房间使用
	private String unitId; //房间到客户使用
	
	private AppointCustomerCond customerCond;
	private List<AppointCustomer> customerList;
	
	private PropertyUnit unit; //第四步主要信息使用
	private AppointCustomer customer; //第四步主要信息使用
	
	private Map<String, String> fourthMap; //第四步主要信息使用
	
	private List<String> trList; //房间的tr
	
	public void setTrList(List<String> trList) {
		this.trList = trList;
	}
	
	public List<String> getTrList() {
		return trList;
	}
	
	public void setFourthMap(Map<String, String> fourthMap) {
		this.fourthMap = fourthMap;
	}
	
	public Map<String, String> getFourthMap() {
		return fourthMap;
	}
	
	public void setBuild(PropertyBuild build) {
		this.build = build;
	}
	
	public PropertyBuild getBuild() {
		return build;
	}
	
	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}
	
	public String getBuildId() {
		return buildId;
	}
	
	public void setBuildCond(PropertyBuildCond buildCond) {
		this.buildCond = buildCond;
	}
	
	public PropertyBuildCond getBuildCond() {
		return buildCond;
	}
	
	public void setBuildList(List<PropertyBuild> buildList) {
		this.buildList = buildList;
	}
	
	public List<PropertyBuild> getBuildList() {
		return buildList;
	}
	
	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}
	
	public PropertyUnit getUnit() {
		return unit;
	}
	
	public AppointCustomer getCustomer() {
		return customer;
	}
	
	public void setCustomer(AppointCustomer customer) {
		this.customer = customer;
	}
	
	public void setCustomerList(List<AppointCustomer> customerList) {
		this.customerList = customerList;
	}
	
	public List<AppointCustomer> getCustomerList() {
		return customerList;
	}
	
	public void setCustomerCond(AppointCustomerCond customerCond) {
		this.customerCond = customerCond;
	}
	
	public AppointCustomerCond getCustomerCond() {
		return customerCond;
	}
	
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	
	public String getUnitId() {
		return unitId;
	}
	
	public void setUnitList(List<PropertyUnit> unitList) {
		this.unitList = unitList;
	}
	
	public List<PropertyUnit> getUnitList() {
		return unitList;
	}
	
	public void setUnitCond(PropertyUnitCond unitCond) {
		this.unitCond = unitCond;
	}
	
	public PropertyUnitCond getUnitCond() {
		return unitCond;
	}
	
	public void setAppoint(Appoint appoint) {
		this.appoint = appoint;
	}
	
	public Appoint getAppoint() {
		return appoint;
	}
	

}
