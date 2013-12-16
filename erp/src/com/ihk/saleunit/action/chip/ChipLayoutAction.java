package com.ihk.saleunit.action.chip;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyAreaCond;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Chip;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IChipServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.autocomplete.AutoCompleteCallback;
import com.ihk.utils.autocomplete.AutoCompleteUtils;
import com.ihk.utils.chip.ChipManagerUtils;
import com.ihk.utils.saleunit.BuildUnitUtils;

/**
 * 认筹
 * @author dtc
 * 2012-8-22
 */
public class ChipLayoutAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPropertyProjectServices propertyProjectServices;
	@Autowired
	IPropertyBuildServices buildServices;
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IPropertyAreaServices areaServices;
	@Autowired
	IContractCustomerServices contractCustomerServices;
	@Autowired
	IUserAccountServices userAccountServices;
	@Autowired
	IChipServices chipServices;
	
	public String layout() throws Exception{
		
		return "layout";
	}
	
	public String getUnitAllNameByUnitIdAndChipNo() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		
		Map<String, String> map = new HashMap<String, String>();
		
		//chip1_customer1 chip1_customer2 chip1_customer3 chip2_customer1 chip2_customer2 chip3_customer1
		
		for(int chipNo=1; chipNo<=3; chipNo++){
			
			List<Chip> chipList = chipServices.findChipByUnitIdAndChipNo(unitId, chipNo);
			
			if(!CommonUtils.isCollectionEmpty(chipList)){
				
				StringBuffer key = null;
				
				for(int i=0; i<chipList.size(); i++){
					
					key = new StringBuffer();
					key.append("chip").append(chipNo).append("_customer").append(i+1);
					
					String customerName = chipList.get(i).getCustomerName();
					String phone = chipList.get(i).getCustomerPhone();
					
					map.put(key.toString(), customerName + "(" + phone + ")");
					
				}
				
			}
			
		}
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
	
	//查找认筹客户(通过姓名)
	public String searchCustomersForChip() throws Exception{
		
		new AutoCompleteUtils(this, "customerName", "id") {
			
			@Override
			public List<?> complete() throws Exception {
				
				return contractCustomerServices.findCustomersForChip(search);
			}
		};
		
		return null;
	}
	
	//查找认筹客户(通过电话)
	public String searchCustomersFromPhoneForChip() throws Exception{
		
		new AutoCompleteUtils(this, "phone", "id") {
			
			@Override
			public List<?> complete() throws Exception {
				
				return contractCustomerServices.findCustomersFromPhoneForChip(search);
			}
		};
		
		return null;
	}
	
	//查找录入人员(通过姓名)
	public String searchUsersForChip() throws Exception{
		
		/*new AutoCompleteUtils(this, "realName", "id") {
			
			@Override
			public List<?> complete() throws Exception {
				
				return userAccountServices.findUserAccountsLikeNameByCompanyId(search);
			}
		};*/
		
		AutoCompleteUtils.doComplete(this, "realName", "id", new AutoCompleteCallback() {
			
			@Override
			public List<?> complete(String name) throws Exception {
				
				return userAccountServices.findUserAccountsLikeNameByCompanyId(name);
			}
		});
		
		
		
		
		/*String name = AutoCompleteUtils.getSearch(request);
		
		List<UserAccount> userList = userAccountServices.findUserAccountsLikeNameByCompanyId(name);
		
		String out = AutoCompleteUtils.initForList(userList, "realName", "id");
		
		CustomerUtils.writeResponse(response, out);*/
		
		return null;
	}
	
	public String saveChipCustomer() throws Exception{
		
		try{
			
			chipCustomer.setConfirmType(ContConfirmType.CHIP);
			CommonPojoUtils.initPojoCommonFiled(chipCustomer);
			
			contractCustomerServices.addContractCustomer(chipCustomer);
			
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("id", chipCustomer.getId() + "");
			map.put("name", chipCustomer.getCustomerName());
			
			CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
			
		}catch(Exception e){
			
			CustomerUtils.writeResponse(response, "");
		}
		
		return null;
	}
	
	/**
	 * 根据客户id获取对应的客户信息
	 * @return
	 * @throws Exception
	 */
	public String ajaxChipCustomerFromCustomerIdForSearch() throws Exception{
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		
		ContractCustomer customer = contractCustomerServices.findContractCustomerById(customerId); //直接找认筹客户
		
		if(customer == null){
			
			CustomerUtils.writeResponse(response, "");
		}else{
			
			CustomerUtils.writeResponse(response, CommonUtils.getMapJson(ChipManagerUtils.getAjaxChipCustomerMap(customer)));
		}
		
		return null; 
	}
	
	/**
	 * 根据认筹id获取对应的客户的相关信息
	 * @return
	 * @throws Exception
	 */
	public String ajaxChipCustomerFromChipIdForAddTempConfirm() throws Exception{
		
		Map<String, String> map = new HashMap<String, String>();
		
		int chipId = Integer.parseInt(request.getParameter("chipId"));
		
		Chip chip = chipServices.findChipById(chipId);
		ContractCustomer customer = chip.getCustomer();
		
		if(customer != null){
			
			map = ChipManagerUtils.getAjaxChipCustomerMap(customer);
		}
		
		if(chip.getChipMoney() != null){
			
			map.put("bookMoney", chip.getChipMoney().toString());
		}
		
		String out = CommonUtils.getMapJson(map);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 关闭弹出框的刷新
	 * @return
	 * @throws Exception
	 */
	public String closeDialogRefresh() throws Exception{
		
		/*String type = request.getParameter("type");
		
		if("build".equals(type)){
			
			return getUnit();
		}else if("group".equals(type)){
			
			return getGroup();
		}else if("area".equals(type)){
			
			return getAreaUnit();
		}*/
		
		return null;
	}
	
	/**
	 * 保存认筹
	 * @return
	 * @throws Exception
	 */
	public String saveChip() throws Exception{
		
		final Map<String, String> map = new HashMap<String, String>();
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					//先判断该筹单号是否合法
					boolean isAccord = ChipManagerUtils.isChipNoAccord(chip);
					if(!isAccord)
						throw new Exception("该项目下该筹单号已经存在");
					
					int customerId = chipCustomer.getId();
					
					if(customerId == 0){
						//表示新增
						
						chipCustomer.setConfirmType(ContConfirmType.CHIP);
						CommonPojoUtils.initPojoCommonFiled(chipCustomer);
						contractCustomerServices.addContractCustomer(chipCustomer);
						
						customerId = chipCustomer.getId();
					}
					
					//ChipManagerUtils.setChipNoForAdd(chip, chipServices); 改为手工填写,但要判断该项目下该筹单号是否重复
					chip.setChipType(request.getParameter("chipTypeId")); //
					
					chip.setCustomerId(customerId);
					chip.setIsVoid(CommonUtils.NORMAL);
					chip.setVoidTime(new Date());
					
					chip.setCompanyProjectId(SessionUser.getProjectId()); //设置对应的项目id
					
					//设置对应的楼盘项目id
					int proProjectId = propertyProjectServices.findPropertyProjectIdByUnitId(chip.getUnitId1());
					chip.setPropertyProjectId(proProjectId);
					
					CommonPojoUtils.initPojoCommonFiled(chip);
					
					//设置对应单元的认筹数量及单元状态
					ChipManagerUtils.setUnitChipByChip(chip);
					
					chipServices.addChip(chip);
					
					map.put("type", "true");
					
				}
			}.execute();
			
		}catch(Exception e){
			
			map.put("type", "false");
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
	
	/**
	 * 新建认筹中的选择单元
	 * @return
	 * @throws Exception
	 */
	public String changeUnitForAddChip() throws Exception{
		
		String type = request.getParameter("type");
		
		if("build".equals(type)){
			
			return getUnit();
		}else if("group".equals(type)){
			
			return getGroup();
		}else if("area".equals(type)){
			
			return getAreaUnit();
		}else if("project".equals(type)){
			
			return getProjectUnit();
		}
		
		return null;
	}
	
	/**
	 * 单元
	 * @return
	 * @throws Exception
	 */
	public String getUnit() throws Exception{
		
		buildId = request.getParameter("buildId");
		PropertyBuild bb = buildServices.findPropertyBuildById(Integer.parseInt(buildId));
		unitList = unitServices.findUnitsByBuildId(Integer.parseInt(buildId));
		
		//trList = BuildUnitUtils.initUnitMap(unitList,bb);
		trList = BuildUnitUtils.initUnitMapForChip(unitList,bb);
		
		init();
		
		return "getUnit";
	}
	
	/**
	 * 分区
	 * @return
	 * @throws Exception
	 */
	public String getAreaUnit() throws Exception{
		String areaId =  request.getParameter("areaId");
		
		List<List<String>> areaUnitList = new ArrayList<List<String>>();//区域内所有房间
		
		
		//拿到所有符合条件的BUILD
		PropertyBuildCond cond = new PropertyBuildCond();
		cond.setAreaId(areaId);
		List<PropertyBuild> buildTmlist = buildServices.findPropertyBuild(cond);
		
		List<Integer> buildIdList = new ArrayList<Integer>();
		for(PropertyBuild bb: buildTmlist){
			buildIdList.add(bb.getId());
		}
		
		int maxFloorNum = 0,minFloorNum = 0;
		PropertyUnitCond ucond = new PropertyUnitCond();
		ucond.setBuildIds(buildIdList);
		try {
			maxFloorNum = this.unitServices.findMaxFloorByBuildIdList(ucond);
			minFloorNum = this.unitServices.findMinFloorByBuildIdList(ucond);
		} catch (Exception e) {
			
			return "getAreaUnit";
		}
	
		
		for(PropertyBuild build: buildTmlist){
			
			unitList = unitServices.findUnitsByBuildId(build.getId());
			List<String> trListtmp = BuildUnitUtils.initUnitMapForChip1(unitList,maxFloorNum,minFloorNum,build);
			areaUnitList.add(trListtmp);
		}
		trList = new ArrayList<String>();
		for(List<String> hStr:areaUnitList){
			for (int i = 0; i < hStr.size(); i++) {
				if(trList.size()<=i){
					this.trList.add(hStr.get(i));
				}else{
					trList.set(i, trList.get(i) + hStr.get(i)) ;
				}
			}	
		}
		
		for (int i = 0; i < trList.size(); i++) {
			trList.set(i, "<tr>"+trList.get(i)+"</tr>");
		}
		init();
		return "getAreaUnit";
	}
	
	/**
	 * 楼盘项目
	 * @return
	 * @throws Exception
	 */
	public String getProjectUnit() throws Exception{
		String projectId =  request.getParameter("projectId");
		
		List<List<String>> areaUnitList = new ArrayList<List<String>>();//区域内所有房间
		//拿所有符合条件的Area
		PropertyAreaCond areaCond = new PropertyAreaCond();
		areaCond.setPropertyId(Integer.valueOf(projectId));
		List<PropertyArea> areaList = areaServices.findPropertyArea(areaCond);
		//拿到所有符合条件的BUILD
		List<PropertyBuild> buildTmlist = new ArrayList<PropertyBuild>();
		PropertyBuildCond cond = new PropertyBuildCond();
		for(PropertyArea pa:areaList){
			cond.setAreaId(pa.getId()+"");
			List<PropertyBuild> bTmlist = buildServices.findPropertyBuild(cond);
			buildTmlist.addAll(bTmlist);
		}
		
		List<Integer> buildIdList = new ArrayList<Integer>();
		for(PropertyBuild bb: buildTmlist){
			buildIdList.add(bb.getId());
		}
		
		int maxFloorNum = 0,minFloorNum = 0;
		PropertyUnitCond ucond = new PropertyUnitCond();
		ucond.setBuildIds(buildIdList);
		try {
			maxFloorNum = this.unitServices.findMaxFloorByBuildIdList(ucond);
			minFloorNum = this.unitServices.findMinFloorByBuildIdList(ucond);
		} catch (Exception e) {
			
			return "getProjectUnit";
		}
	
		
		for(PropertyBuild build: buildTmlist){
			
			unitList = unitServices.findUnitsByBuildId(build.getId());
			List<String> trListtmp = BuildUnitUtils.initUnitMapForChip1(unitList,maxFloorNum,minFloorNum,build);
			areaUnitList.add(trListtmp);
		}
		trList = new ArrayList<String>();
		for(List<String> hStr:areaUnitList){
			for (int i = 0; i < hStr.size(); i++) {
				if(trList.size()<=i){
					this.trList.add(hStr.get(i));
				}else{
					trList.set(i, trList.get(i) + hStr.get(i)) ;
				}
			}	
		}
		
		for (int i = 0; i < trList.size(); i++) {
			trList.set(i, "<tr>"+trList.get(i)+"</tr>");
		}
		init();
		return "getProjectUnit";
	}
	
	
	/**
	 * 组团
	 * @return
	 */
	public String getGroup(){
		
		groList = new ArrayList<List<String>>();
		String groId = request.getParameter("groId");
		unitList = unitServices.findUnitListByGroupId(Integer.parseInt(groId));
		int tpbid = 0;
		List<PropertyUnit> tpuList = new ArrayList<PropertyUnit>();
		String topName = "";
		while (unitList.size()>0){
			tpbid = unitList.get(0).getBuildId();
			topName = buildServices.findPropertyBuildById(tpbid).getBuildName();
			for( PropertyUnit u :unitList){
				if(u.getBuildId() == tpbid){
					tpuList.add(u);
				}
			}
			for(PropertyUnit u :tpuList){
				unitList.remove(u);
			}
			
			//List<String> tpList = BuildUnitUtils.initUnitMap(tpuList,new PropertyBuild());
			List<String> tpList = BuildUnitUtils.initUnitMapForChip(tpuList,new PropertyBuild());
			
			tpList.remove(0);
			tpList.add(0, topName);
			groList.add(tpList);
			tpuList.clear();
		}
		
		init();
		
		return "getGroup";
	}
	
	private void init(){
		
		try{
			build = buildServices.findPropertyBuildById(Integer.parseInt(this.getBuildId()));
		}catch(Exception e){
		}
		
		isRefresh = request.getParameter("isRefresh");
	}
	
	private String isRefresh; //主要用于页面局部刷新,是否让单元信息处于选中状态
	
	private PropertyBuild build;
	private String buildId;
	
	private String id;
	private List<String> trList; //房间的tr
	private List<PropertyUnit> unitList;
	
	private List<List<String>> groList;
	
	private ContractCustomer chipCustomer;
	
	private Chip chip;
	
	public void setChip(Chip chip) {
		this.chip = chip;
	}
	
	public Chip getChip() {
		return chip;
	}
	
	public void setChipCustomer(ContractCustomer chipCustomer) {
		this.chipCustomer = chipCustomer;
	}
	
	public ContractCustomer getChipCustomer() {
		return chipCustomer;
	}
	
	public void setGroList(List<List<String>> groList) {
		this.groList = groList;
	}
	
	public List<List<String>> getGroList() {
		return groList;
	}
	
	public String getIsRefresh() {
		return isRefresh;
	}

	public void setIsRefresh(String isRefresh) {
		this.isRefresh = isRefresh;
	}

	public PropertyBuild getBuild() {
		return build;
	}

	public void setBuild(PropertyBuild build) {
		this.build = build;
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getTrList() {
		return trList;
	}

	public void setTrList(List<String> trList) {
		this.trList = trList;
	}

	public List<PropertyUnit> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<PropertyUnit> unitList) {
		this.unitList = unitList;
	}
	

}
