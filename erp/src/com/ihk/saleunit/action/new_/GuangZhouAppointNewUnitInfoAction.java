package com.ihk.saleunit.action.new_;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitChangeTypeFrom;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.constanttype.EnumOperLogType;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.ReplaceUnit;
import com.ihk.saleunit.data.pojo.UnitDiscount;
import com.ihk.saleunit.data.services.IAddonPropertyServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IReplaceUnitServices;
import com.ihk.saleunit.data.services.ITartServices;
import com.ihk.saleunit.data.services.IUnitDiscountServices;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.contract.unit.ContractUrlUtils;
import com.ihk.utils.exception.UnitChangeException;
import com.ihk.utils.saleunit.UnitChangeUtils;
import com.ihk.utils.saleunit.UnitSaleStateUtils;
import com.ihk.utils.saleunitnew.DefaultFromPropertyUtils;
import com.ihk.utils.saleunitnew.UnitConfirmContractUtils;

/**
 * 标题:房间信息
 * jsp:/crm/WebRoot/saleunit_new/guangzhou/unit_info.jsp
 */
@SuppressWarnings("rawtypes")
public class GuangZhouAppointNewUnitInfoAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IContractCustomerServices contractCustomerServices; 
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IContractServices contractServices;
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IPropertyBuildServices buildServices;
	@Autowired
	IAddonPropertyServices addonPropertyServices;
	@Autowired
	IUserAccountServices userAccountServices;
	@Autowired
	IUnitDiscountServices discountServices;
	@Autowired
	IReplaceUnitServices replaceServices;
	@Autowired
	ITartServices tartServices;
	@Autowired
	ICustomerServices customerServices;
	
	/**
	 * 单元信息
	 * @return
	 * @throws Exception
	 */
	public String unitInfo() throws Exception{
		
		selectUnit = unitServices.findPropertyUnitById(id);
		
		//判断获取销售信息
		saleName = initSaleForUnit(selectUnit);
		
		//获取置业计划的相关信息及链接
		initCalcUrl(selectUnit);
		
		//判断是否为成交单元管理过来的
		return ContractUrlUtils.unitInfo(request, "unit_info");
		
		//return "unitInfo";
	}
	
	/**
	 * 返回组合单元的详细显示
	 * <span id="showContent">已选择==&gt;&nbsp;&nbsp;金域蓝湾,东区,1单元,
	 * <span id="unitValueId">A-5-1</span><input type="hidden" value="38" id="hiddenUnitId"/></span>
	 * @return
	 * @throws Exception
	 */
	public String getUnitShowContent() throws Exception{
		
		try{
			int unitId = Integer.parseInt(request.getParameter("unitId"));
			selectUnit = unitServices.findPropertyUnitById(unitId);
			
			PropertyBuild build = buildServices.findPropertyBuildById(selectUnit.getBuildId());
			
			String out = DefaultFromPropertyUtils.initShowContent(build, selectUnit);
			
			CustomerUtils.writeResponse(response, out);
		}catch (Exception e) {
			
			CustomerUtils.writeResponse(response, "");
		}
		
		return null;
	}
	
	/**
	 * 置业计划弹出框的值
	 * @return
	 * @throws Exception
	 */
	public String getUnitInfoForCalc() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		
		selectUnit = unitServices.findPropertyUnitById(unitId);
		
		initCalcMap(selectUnit);
		
		return "getUnitInfoForCalc";
	}
	
	public String createConfirmDialog() throws Exception{
		
		String unitId = request.getParameter("unitId");
		selectUnit = unitServices.findPropertyUnitById(Integer.parseInt(unitId));
		
		initSel();
		
		confirmType = ContConfirmType.CONFIRM;
		
		removeSuggestion();
		
		return "createConfirmDialog";
	}
	
	public String saveConfirmCustomerForDialog() throws Exception{
		
		String out = "";
		
		try{
			
			CommonPojoUtils.initPojoCommonFiled(confirmCustomer);
			contractCustomerServices.addContractCustomer(confirmCustomer);
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", confirmCustomer.getId() + "");
			map.put("name", confirmCustomer.getCustomerName());
			map.put("phone", confirmCustomer.getPhone());
			
			out = CommonUtils.getMapJson(map);
			
		}catch(Exception e){
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 执行录入
	 * @return
	 * @throws Exception
	 */
	public String inputConfirm() throws Exception{
		
		try{
			
			new MyTransationTemplate(){

				@Override
				protected void doExecuteCallback() throws Exception {
					
					CommonPojoUtils.initPojoCommonFiled(confirm);
					
					int unitId = confirm.getUnitId();
					selectUnit = unitServices.findPropertyUnitById(unitId);
					
					//增加之前应该判断该单元是否可以认购
					boolean isCanChange = UnitChangeUtils.isCanChange(ContUnitChangeTypeFrom.CONFIRM, selectUnit);
					if(!isCanChange)
						throw new UnitChangeException("该单元不能认购");
					confirmServices.addConfirm(confirm);
					
					//修改房间的状态
					UnitSaleStateUtils.changeSaleState(unitServices, unitId, ContUnitSaleState.CONFIRM);
					
					//增加认购,要一并把该房间的相关信息保存到 addon_property(附属房产),已没有附属房产
					/*
					List<PropertyUnit> addonUnit = unitServices.findAddonPropertyUnitByMainId(unitId);
					
					AddonProperty addProperty = new AddonProperty();
					for(PropertyUnit unit : addonUnit){
						
						addProperty.setConfirmType(ContConfirmType.CONFIRM);
						addProperty.setMainId(confirm.getId());
						addProperty.setUnitId(unit.getId());
						
						CommonPojoUtils.initPojoCommonFiled(addProperty);
						
						addonPropertyServices.addAddonProperty(addProperty);
					}*/
					
					//设置折扣单中的main_id
					unitDiscountId = request.getParameter("unitDiscountId");
					if(!CommonUtils.isStrZeroEmpty(unitDiscountId)){
						discountServices.updateUnitDiscountMainId(Integer.parseInt(unitDiscountId), confirm.getId(), ContConfirmType.CONFIRM);
					}
					
					setSuggestion(CommonUtils.SUCCSUGG);
				}
				
			}.execute();
			
		}catch (UnitChangeException e) {
			
			setSuggestion(e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		initSel();
		initOther();
		
		confirmType = ContConfirmType.CONFIRM;
		
		return "inputConfirm";
	}
	
	//查看认购
	public String showConfirmDialog() throws Exception{
		
		int confirmId = Integer.parseInt(request.getParameter("confirmId"));
		
		confirm = confirmServices.findConfirmById(confirmId);
		selectUnit = unitServices.findPropertyUnitById(confirm.getUnitId());
		confirmCustomer = contractCustomerServices.findContractCustomerById(confirm.getCustomerId());
		
		UnitDiscount discount = discountServices.findUnitDiscountByTypeAndMainId(ContConfirmType.CONFIRM, confirmId);
		if(discount != null){
			
			unitDiscountId = discount.getId() + "";
		}else{
			
			unitDiscountId = "";
		}
		
		initSel();
		
		removeSuggestion();
		
		return "showConfirmDialog";
	}
	
	//修改认购
	public String updateConfirmDialog() throws Exception{
		
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
		
		selectUnit = unitServices.findPropertyUnitById(confirm.getUnitId());
		confirmCustomer = contractCustomerServices.findContractCustomerById(confirm.getCustomerId());
		
		initSel();
		confirmType = ContConfirmType.CONFIRM;
		
		return "updateConfirmDialog";
	}
	
	//认购转合同
	public String changeToContract() throws Exception{
		
		final Map<String, String> map = new HashMap<String, String>();
		boolean isSucc = true;
		
		try{
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					int confirmId = Integer.parseInt(request.getParameter("confirmId"));
					
					Confirm confirm = confirmServices.findConfirmById(confirmId);
					
					//避免有人通过地址栏直接进行修改,在该处进行一下判断,(退房之后该认购单标示为删除,要加上这个判断)
					if(confirm == null || !confirm.getCanChangeToContract() || CommonUtils.DELETED.equals(confirm.getIsDeleted())){
						
						map.put("error", "errorState");
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
					
					//把认购单的折扣转给对应的合同单
					unitDiscountId = request.getParameter("unitDiscountId");
					if(!CommonUtils.isStrZeroEmpty(unitDiscountId)){
						
						discountServices.updateUnitDiscountMainId(Integer.parseInt(unitDiscountId), contract.getId(), ContConfirmType.CONTRACT);
					}
					
				}
			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			isSucc = false;
			
		}
		
		map.put("type", isSucc + "");
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
		
	}
	
	//认购退房
	public String confirmCheckOut() throws Exception{
		
		boolean isSucc = true;
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					int confirmId = Integer.parseInt(request.getParameter("mainId"));
					String unitId = request.getParameter("unitId");
					
					//增加退房记录
					UnitConfirmContractUtils.addUnitCheckOutLog(EnumOperLogType.CONFIRM_CHECK_OUT, confirmId);
					
					//标示删除该认购单
					confirmServices.deleteConfirm(confirmId); 
					
					//修改对应单元的状态
					Map<String, String> map = new HashMap<String, String>();
					map.put("saleState", ContUnitSaleState.SALE_ABLE);
					map.put("id", unitId);
					unitServices.updatePropertyUnitSaleState(map);
					
					//把该单元对应的延期签约删除
					UnitConfirmContractUtils.deleteExtensionContractByUnitId(Integer.parseInt(unitId));
					
				}
			}.execute();
		
		}catch(Exception e){
			isSucc = false;
		}
		
		CustomerUtils.writeResponse(response, isSucc + "");
		
		return null;
	}
	
	//跳到合同界面
	public String createContractDialog() throws Exception{
		
		String unitId = request.getParameter("unitId");
		selectUnit = unitServices.findPropertyUnitById(Integer.parseInt(unitId));
		
		//如果该单元为认购状态,就要查出其对应的客户,
		if(ContUnitSaleState.CONFIRM.equals(selectUnit.getSaleState())){
			
			confirm = confirmServices.findConfirmByUnitId(Integer.parseInt(unitId));
			confirmCustomer = contractCustomerServices.findContractCustomerById(confirm.getCustomerId());
		}
		
		initSel();
		
		confirmType = ContConfirmType.CONTRACT;
		
		removeSuggestion();
		
		return "createContractDialog";
	}
	
	//查看合同
	public String showContractDialog() throws Exception{
		
		int contractId = Integer.parseInt(request.getParameter("contractId"));
		
		contract = contractServices.findContractById(contractId);
		selectUnit = unitServices.findPropertyUnitById(contract.getUnitId());
		confirmCustomer = contractCustomerServices.findContractCustomerById(contract.getCustomerId());
		
		initSel();
		confirmType = ContConfirmType.CONTRACT;
		
		removeSuggestion();
		
		return "showContractDialog";
	}
	
	//修改合同
	public String updateContractDialog() throws Exception{
		
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
		
		selectUnit = unitServices.findPropertyUnitById(contract.getUnitId());
		confirmCustomer = contractCustomerServices.findContractCustomerById(contract.getCustomerId());
		
		initSel();
		confirmType = ContConfirmType.CONTRACT;
		
		return "updateContractDialog";
	}
	
	/**
	 * 新增签约客户
	 * @return
	 * @throws Exception
	 */
	public String saveContractCustomerForDialog() throws Exception{
		
		String out = "";
		
		try{
			
			CommonPojoUtils.initPojoCommonFiled(confirmCustomer);
			contractCustomerServices.addContractCustomer(confirmCustomer);
			
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("id", confirmCustomer.getId() + "");
			map.put("name", confirmCustomer.getCustomerName());
			map.put("phone", confirmCustomer.getPhone());
			map.put("gender", confirmCustomer.getGender());
			
			map.put("idcardType", confirmCustomer.getIdcardType());
			map.put("idcardNo", confirmCustomer.getIdcardNo());
			map.put("address", confirmCustomer.getAddress());
			
			out = CommonUtils.getMapJson(map);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 修改成交客户
	 * @return
	 * @throws Exception
	 */
	public String updateContractCustomerForDialog() throws Exception{
		
		int customerId = confirmCustomer.getId();
		ContractCustomer oldConfirmCustomer = contractCustomerServices.findContractCustomerById(customerId);

		confirmCustomer.setCompanyId(oldConfirmCustomer.getCompanyId());
		confirmCustomer.setProjectId(oldConfirmCustomer.getProjectId());
		confirmCustomer.setUserId(oldConfirmCustomer.getUserId());
		confirmCustomer.setConfirmType(oldConfirmCustomer.getConfirmType());
		confirmCustomer.setPreCustomerId(oldConfirmCustomer.getPreCustomerId());
		
		CommonPojoUtils.initPojoForUpdate(oldConfirmCustomer, confirmCustomer);
		
		try{
			
			contractCustomerServices.updateContractCustomer(confirmCustomer);
			
		}catch (Exception e) {
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", confirmCustomer.getCustomerName());
		map.put("phone", confirmCustomer.getPhone());
		map.put("gender", confirmCustomer.getGender());
		
		map.put("idcardType", confirmCustomer.getIdcardType());
		map.put("idcardNo", confirmCustomer.getIdcardNo());
		map.put("address", confirmCustomer.getAddress());
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
	
	//新增签约
	public String inputContract() throws Exception{
		
		boolean isSucc = true;
		
		try{
			
			new MyTransationTemplate(){

				@Override
				protected void doExecuteCallback() throws Exception {
					
					CommonPojoUtils.initPojoCommonFiled(contract);
					
					int unitId = contract.getUnitId();
					selectUnit = unitServices.findPropertyUnitById(unitId);
					
					//增加之前应该判断该单元是否可以签约
					boolean isCanChange = UnitChangeUtils.isCanChange(ContUnitChangeTypeFrom.CONTRACT, selectUnit);
					if(!isCanChange)
						throw new Exception("该单元不能签约");
					contractServices.addContract(contract);
					
					//修改单元状态
					UnitSaleStateUtils.changeSaleState(unitServices, contract.getUnitId(), ContUnitSaleState.CONTRACT);
					
					//设置折扣单中的main_id
					unitDiscountId = request.getParameter("unitDiscountId");
					if(!CommonUtils.isStrZeroEmpty(unitDiscountId)){
						discountServices.updateUnitDiscountMainId(Integer.parseInt(unitDiscountId), contract.getId(), ContConfirmType.CONTRACT);
					}
					
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
		confirmType = ContConfirmType.CONTRACT;
		
		return "inputContract";
	}
	
	//签约退房
	public String contractCheckOut() throws Exception{
		
		boolean isSucc = true;
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					int contractId = Integer.parseInt(request.getParameter("mainId"));
					String unitId = request.getParameter("unitId");
					
					UnitConfirmContractUtils.addUnitCheckOutLog(EnumOperLogType.CONTRACT_CHEKC_OUT, contractId); //增加记录
					contractServices.deleteContract(contractId); //标示删除该签约单
					
					Map<String, String> map = new HashMap<String, String>();
					map.put("saleState", ContUnitSaleState.SALE_ABLE);
					map.put("id", unitId);
					unitServices.updatePropertyUnitSaleState(map);//修改对应单元的状态
					
					//把该单元对应的延期签约删除
					UnitConfirmContractUtils.deleteExtensionContractByUnitId(Integer.parseInt(unitId));
					
				}
			}.execute();
		
		}catch(Exception e){
			isSucc = false;
		}
		
		CustomerUtils.writeResponse(response, isSucc + "");
		
		return null;
	}
	
	private void initSel(){
		
		selPriceWay = DescUtils.getInitSelForGuangZhou(selPriceWay, EnumCodeTypeName.PROPERTY_PRICE_WAY, true);
		selIsMerge = DescUtils.getInitSelEmptyAndTrueFalse(selIsMerge);
		
		selCustomerGender = DescUtils.getInitSelEmptyAndGender(selCustomerGender);
		selCustomerIdCardType = DescUtils.getInitSelForGuangZhou(selCustomerIdCardType, EnumCodeTypeName.SALEUNIT_IDCARD_TYPE, true);
		
		selPropertyType = DescUtils.getInitSelForGuangZhou(selPropertyType, EnumCodeTypeName.SALEUNIT_PROPERTY_TYPE, true);
		
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType, EnumCodeTypeName.PAY_TYPE, true); //
		
	}
	
	private void initOther(){
		
		unitDiscountId = request.getParameter("unitDiscountId");
		
		confirmCustomer = contractCustomerServices.findContractCustomerById(confirm.getCustomerId());
	}
	
	private String initSaleForUnit(PropertyUnit unit){
		
		//认购或签约的时候才去获取
		
		String ret = "";
		
		if(unit == null)
			return ret;
		
		String state = unit.getSaleState();
		
		if(ContUnitSaleState.CONFIRM.equals(state)){
			
			try{
				ret = unit.getConfirm().getSalesName();
			}catch (Exception e) {
			}
			
		}else if(ContUnitSaleState.CONTRACT.equals(state)){
			
			try{
				ret = unit.getContract().getSalesName();
			}catch (Exception e) {
			}
		}
		
		return ret;
	}
	
	/**
	 * 初始化置业计划的相关数据
	 * @param unit
	 */
	private void initCalcUrl(PropertyUnit unit){
		
		if(unit == null)
			return ;
		
		calcUrl = "<a href=\"javascript:void(0)\" style='color:#1199FF; text-decoration:underline' onclick=\"return showCalcDialog()\">查看</a>";
		
	}
	
	private Map<String, String> initCalcMap(PropertyUnit unit){
		
		calcMap = new HashMap<String, String>();
		
		if(unit == null)
			return calcMap;
		
		try{
			
			BigDecimal sumPrice = unit.getSumPrice(); //总价(元)
			
			BigDecimal sum = sumPrice.divide(new BigDecimal(10000.00));
			
			calcMap.put("sum", sum.toString()); //总价(万)
			
		}catch(Exception e){
			
		}
		
		return calcMap;
	}
	
	
	/**
	 * 查看认购  不能修改
	 * @return
	 * @throws Exception
	 */
	public String showConfirmDetail() throws Exception{
		
		int mainId = Integer.parseInt(request.getParameter("mainId"));
		//ReplaceUnit replaceUnit=replaceServices.findReplaceUnitById(mainId);
		confirm = confirmServices.findConfirmById(mainId);
		selectUnit = unitServices.findPropertyUnitById(confirm.getUnitId());
		confirmCustomer = contractCustomerServices.findContractCustomerById(confirm.getCustomerId());
		contractCustomerList=contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirm.getId(), ContConfirmType.CONFIRM);
		UnitDiscount discount = discountServices.findUnitDiscountByTypeAndMainId(ContConfirmType.CONFIRM, mainId);
		if(discount != null){
			
			unitDiscountId = discount.getId() + "";
		}else{
			
			unitDiscountId = "";
		}
		
		initSel();
		
		removeSuggestion();
		
		return "showConfirmDetail";
	}
	
	
	//查看认购  不能修改
	public String showConfirmChangeUnitDetail() throws Exception{
		
		int mainId = Integer.parseInt(request.getParameter("mainId"));
		ReplaceUnit replaceUnit=replaceServices.findReplaceUnitById(mainId);
		confirm = confirmServices.findConfirmById(replaceUnit.getConfirmId2());
		selectUnit = unitServices.findPropertyUnitById(confirm.getUnitId());
		contractCustomerList=contractCustomerServices.findContractCustomerByMainIdAndConfirmTypeNotValid(confirm.getId(), ContConfirmType.CONFIRM);
		//confirmCustomer = confirmServices.findConfirmById(confirm.getCustomerId());
		//contractCustomerList=contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirm.getId(), ContConfirmType.CONFIRM);
		UnitDiscount discount = discountServices.findUnitDiscountByTypeAndMainId(ContConfirmType.CONFIRM, mainId);
		if(discount != null){
			
			unitDiscountId = discount.getId() + "";
		}else{
			
			unitDiscountId = "";
		}
		
		initSel();
		
		removeSuggestion();
		
		return "showConfirmChangeUnitDetail";
	}
	
	///////
	
	private PropertyUnit selectUnit;
	private int id;
	
	private LinkedHashMap selPayType; //付款方式
	private LinkedHashMap selIsMerge; //是否并入合同
	private LinkedHashMap selPriceWay; //计价方式
	
	private LinkedHashMap selCustomerGender; //新建客户,性别
	private LinkedHashMap selCustomerIdCardType; //新建客户,证件类型
	
	private LinkedHashMap selPropertyType; //房产类型
	
	private String confirmType; //认购,合同类型
	
	private ContractCustomer confirmCustomer;
	
	private Confirm confirm;
	private Contract contract;
	
	private UserAccount sale;
	private String saleName; //销售名称
	
	private String calcUrl; //置业计划,链接<a href="#" style='color:#1199FF; text-decoration:underline' onclick="return showCalcDialog()">查看</a>
	private Map<String, String> calcMap; //置业计划中的默认显示(总价,首付,月供)
	
	private String unitDiscountId;
	
	List<ContractCustomer> contractCustomerList;

	
	
	
	public List<ContractCustomer> getContractCustomerList() {
		return contractCustomerList;
	}

	public void setContractCustomerList(List<ContractCustomer> contractCustomerList) {
		this.contractCustomerList = contractCustomerList;
	}
	
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	
	public String getSaleName() {
		return saleName;
	}
	
	public void setUnitDiscountId(String unitDiscountId) {
		this.unitDiscountId = unitDiscountId;
	}
	
	public String getUnitDiscountId() {
		return unitDiscountId;
	}
	
	public void setCalcUrl(String calcUrl) {
		this.calcUrl = calcUrl;
	}
	
	public String getCalcUrl() {
		return calcUrl;
	}
	
	public void setCalcMap(Map<String, String> calcMap) {
		this.calcMap = calcMap;
	}
	
	public Map<String, String> getCalcMap() {
		return calcMap;
	}
	
	public void setSale(UserAccount sale) {
		this.sale = sale;
	}
	
	public UserAccount getSale() {
		return sale;
	}
	
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	public Contract getContract() {
		return contract;
	}
	
	public void setSelPropertyType(LinkedHashMap selPropertyType) {
		this.selPropertyType = selPropertyType;
	}
	
	public LinkedHashMap getSelPropertyType() {
		return selPropertyType;
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

	public PropertyUnit getSelectUnit() {
		return selectUnit;
	}

	public void setSelectUnit(PropertyUnit selectUnit) {
		this.selectUnit = selectUnit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LinkedHashMap getSelPriceWay() {
		return selPriceWay;
	}

	public void setSelPriceWay(LinkedHashMap selPriceWay) {
		this.selPriceWay = selPriceWay;
	}
	
	
}
