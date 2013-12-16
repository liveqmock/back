package com.ihk.saleunit.action.new_;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContPriceWay;
import com.ihk.constanttype.ContUnitChangeTypeFrom;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.UnitDiscount;
import com.ihk.saleunit.data.pojo.UnitDiscountDetail;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IUnitDiscountDetailServices;
import com.ihk.saleunit.data.services.IUnitDiscountServices;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.exception.UnitPayBillException;
import com.ihk.utils.financial.FinancialUtils;
import com.ihk.utils.saleunit.PayWayUtils;
import com.ihk.utils.saleunit.UnitChangeUtils;
import com.ihk.utils.saleunit.UnitSaleStateUtils;
import com.ihk.utils.saleunitnew.DiscountManagerUtils;

/**
 *  大学小筑签约界面
 */
@SuppressWarnings("rawtypes")
public class GuangZhouContractXiaoZhuAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IContractServices contractServices;
	@Autowired
	IContractCustomerServices contractCustomerServices;
	@Autowired
	IUnitDiscountServices discountServices;
	@Autowired
	IUnitDiscountDetailServices discountDetailServices;
	@Autowired
	ICompanyProjectServices projectServices;
	
	/**
	 * 判断单元是否能够新建合同(签约)
	 * @return
	 * @throws Exception
	 */
	public String isCanCreateXiaoZhuContractDialog() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		
		boolean isCan = UnitSaleStateUtils.isCanCreateContract(unitId);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", isCan + "");
		
		String out = CommonUtils.getMapJson(map);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 跳到签约界面
	 * @return
	 * @throws Exception
	 */
	public String createXiaoZhuContractDialog() throws Exception{
		
		String unitId = request.getParameter("unitId");
		selectUnit = unitServices.findPropertyUnitById(Integer.parseInt(unitId));
		
		confirm = confirmServices.findConfirmByUnitId(Integer.parseInt(unitId)); //另外还用于"认购书编号","认购日期"
		
		//如果该单元为认购状态,就要查出其对应的客户,
		if(ContUnitSaleState.CONFIRM.equals(selectUnit.getSaleState())){
			
			confirmCustomer = contractCustomerServices.findContractCustomerById(confirm.getCustomerId());
		}
		
		initSel(Integer.parseInt(unitId));
		priceWay = ContPriceWay.BUILT_AREA;
		
		confirmType = ContConfirmType.CONTRACT;
		
		removeSuggestion();
		
		return "createXiaoZhuContractDialog";
	}
	
	/**
	 * 该单元为成交,要用成交的基本信息设到合同的基本信息中,再跳到新增页面
	 * @return
	 * @throws Exception
	 */
	public String createContractDialogFromConfirm() throws Exception{
		
		String unitId = request.getParameter("unitId");
		selectUnit = unitServices.findPropertyUnitById(Integer.parseInt(unitId));
		
		//设置对应的签约及单元折扣
		confirm = confirmServices.findConfirmByUnitId(Integer.parseInt(unitId)); //另外还用于"认购书编号","认购日期"...
		final UnitDiscount confirmUnitDiscount = DiscountManagerUtils.getUnitDiscountByTypeAndMainId(ContConfirmType.CONFIRM, confirm.getId());
		final int discountId = confirmUnitDiscount.getId();
		if(discountId > 0){
			//表示旧的签约有单元折扣,要对应新增一条,并修改对应的confirmType;且要增加对应折扣的明细
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {

					CommonPojoUtils.initPojoCommonFiled(confirmUnitDiscount);
					confirmUnitDiscount.setConfirmType(ContConfirmType.CONTRACT);
					confirmUnitDiscount.setMainId(0);
					
					//获取旧的单元折扣对应的明细
					List<UnitDiscountDetail> detailList = discountDetailServices.findDetailByDiscountId(discountId);
					
					discountServices.addUnitDiscount(confirmUnitDiscount);
					
					if(!CommonUtils.isCollectionEmpty(detailList)){
						
						for(UnitDiscountDetail unitDiscountDetail : detailList){
							
							CommonPojoUtils.initPojoCommonFiled(unitDiscountDetail);
							unitDiscountDetail.setDiscountId(confirmUnitDiscount.getId());
							discountDetailServices.addUnitDiscountDetail(unitDiscountDetail);
						}
						
					}
					
				}
			}.doExecuteCallback();
			
		}
		
		confirm.setUnitDiscount(confirmUnitDiscount);
		
		//如果该单元为认购状态,就要查出其对应的客户,
		if(ContUnitSaleState.CONFIRM.equals(selectUnit.getSaleState())){
			
			confirmCustomer = contractCustomerServices.findContractCustomerById(confirm.getCustomerId());
		}
		
		initSel(Integer.parseInt(unitId));
		priceWay = ContPriceWay.BUILT_AREA;
		
		confirmType = ContConfirmType.CONTRACT;
		
		removeSuggestion();
		
		return "createContractDialogFromConfirm";
	}
	
	/**
	 * 新增签约
	 * @return
	 * @throws Exception
	 */
	public String inputXiaoZhuContract() throws Exception{
		
		try{
			
			new MyTransationTemplate(){

				@Override
				protected void doExecuteCallback() throws Exception {
					
					int unitId = contract.getUnitId();
					PropertyUnit getUnit = unitServices.findPropertyUnitById(unitId);
					
					//增加之前应该判断该单元是否可以签约
					boolean isCanChange = UnitChangeUtils.isCanChange(ContUnitChangeTypeFrom.CONTRACT, selectUnit);
					if(!isCanChange)
						throw new Exception("该单元不能签合同");
					
					//判断"建筑单价","套内单价","标准总价","建筑面积","套内面积"是否变化,变化了要一并修改
					modifyUnitSomeMoney(getUnit, selectUnit);
					
					//修改单元状态
					UnitSaleStateUtils.changeSaleState(unitServices, contract.getUnitId(), ContUnitSaleState.CONTRACT);
					
					//addUnitPayBillByPayWayIdAndUnitId()最后一个参数
					Date wordDate = contract.getWorkDate();
					if(ContUnitSaleState.CONFIRM.equals(getUnit.getSaleState())){
						
						Confirm confirm = confirmServices.findConfirmByUnitId(unitId);
						if(confirm != null){
							
							wordDate = confirm.getWorkDate();
						}
					}
					
					//增加合同
					confirm = confirmServices.findConfirmByUnitId(unitId);
					contract.setConfirmId(confirm.getId());
					CommonPojoUtils.initPojoCommonFiled(contract);
					contractServices.addContract(contract);
					
					String[] customerIds=customerId.split(",");

					for(int i=0;i<customerIds.length;i++){
						
						ContractCustomer contractCustomer=contractCustomerServices.findContractCustomerById(Integer.parseInt(customerIds[i]));
						contractCustomer.setConfirmType(ContConfirmType.CONTRACT);
						contractCustomer.setMainId(contract.getId());
						contractCustomerServices.addContractCustomer(contractCustomer);
					}
					
					//增加单元付款单unit_pay_bill,合同的应付款单应该判断一下该单元是否已经有应付款单
					FinancialUtils.addUnitPayBillByPayWayIdAndUnitId(contract.getPayWayId(), contract.getUnitId(),contract.getSalePrice(), wordDate);
					
					//设置折扣单中的main_id
					unitDiscountId = request.getParameter("unitDiscountId");
					if(!CommonUtils.isStrZeroEmpty(unitDiscountId)){
						discountServices.updateUnitDiscountMainId(Integer.parseInt(unitDiscountId), contract.getId(), ContConfirmType.CONTRACT);
					}
					
					setSuggestion(CommonUtils.SUCCSUGG);
					
					setUpMarkToClose();
				}
				
			}.execute();
			
		}catch (UnitPayBillException e) {
			e.printStackTrace();
			setSuggestion(e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		initSel(contract.getUnitId());
		confirmType = ContConfirmType.CONTRACT;
		
		return "inputXiaoZhuContract";
	}
	
	/**
	 * 查看合同
	 * @return
	 * @throws Exception
	 */
	public String showXiaoZhuContractDialog() throws Exception{
		
		int contractId = Integer.parseInt(request.getParameter("contractId"));
		
		contract = contractServices.findContractById(contractId);
		selectUnit = unitServices.findPropertyUnitById(contract.getUnitId());
		confirmCustomer = contractCustomerServices.findContractCustomerById(contract.getCustomerId());
		
		initSel(contract.getUnitId());
		confirmType = ContConfirmType.CONTRACT;
		
		removeSuggestion();
		
		return "showXiaoZhuContractDialog";
	}
	
	/**
	 * 修改合同
	 * @return
	 * @throws Exception
	 */
	public String updateXiaoZhuContractDialog() throws Exception{
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					PropertyUnit getUnit = unitServices.findPropertyUnitById(contract.getUnitId());
					
					//判断"建筑单价","套内单价","标准总价","建筑面积","套内面积"是否变化
					modifyUnitSomeMoney(getUnit, selectUnit);
				 	
					Contract oldContract = contractServices.findContractById(contract.getId());
				 	CommonPojoUtils.initPojoForUpdate(oldContract, contract);
				 	
				 	//允许查看合同时修改客户，后续需要删除
				 	List<ContractCustomer> ccList= 
				 		contractCustomerServices.findContractCustomerByMainIdAndConfirmType(contract.getId(), ContConfirmType.CONTRACT);
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
						contractCustomerServices.updateContractCustomerConfirmType(Integer.parseInt(customerIds[i]), ContConfirmType.CONTRACT);
						//修改MainId
						contractCustomerServices.updateContractCustomerMainId(Integer.parseInt(customerIds[i]), contract.getId());
						
						newIdList.add(Integer.parseInt(customerIds[i]));
					}
					
					//修改对应客户的状态
					for(int i=0;i<idList.size();i++){
						
						if(!newIdList.contains(idList.get(i))){
							contractCustomerServices.deleteContractCustomer(idList.get(i));
						}
					}
				 	contractServices.updateContract(contract);
					
				 	setSuggestion(CommonUtils.SUCCSUGG);
				 	setUpMarkToClose();
					
				}
			}.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		contract = contractServices.findContractById(contract.getId());
		
		selectUnit = unitServices.findPropertyUnitById(contract.getUnitId());
		confirmCustomer = contractCustomerServices.findContractCustomerById(contract.getCustomerId());
		
		initSel(contract.getUnitId());
		confirmType = ContConfirmType.CONTRACT;
		
		return "updateXiaoZhuContractDialog";
	}
	
	/**
	 * 判断楼盘项目中该合同编号是否重复
	 * @return
	 * @throws Exception
	 */
	public String isContractNoRepeatInPropertyProject() throws Exception{
		
		JSONObject json = new JSONObject();
		
		String propertyProjectId = request.getParameter("propertyProjectId");
		String contractNo = request.getParameter("contractNo");
		
		ContractCond cond = new ContractCond();
		cond.setContractNo(contractNo);
		cond.setPropertyProjectId(Integer.parseInt(propertyProjectId));
		
		List<Contract> contractList = contractServices.findContract(cond);
		
		if(CommonUtils.isCollectionEmpty(contractList)){
			
			json.put("repeat", false);
		}else{
			
			Contract contract = contractList.get(0);
			String unitAllName = contract.getUnit().getAllName();
			
			json.put("repeat", true);
			json.put("repeatSugg", "合同编号\"" + contractNo + "\"已经属于:(" + unitAllName + ")");
		}
		
		CustomerUtils.writeResponse(response, json.toString());
		
		return null;
	}
	
	private void initSel(int unitId){
		
		selPriceWay = DescUtils.getInitSelForGuangZhou(selPriceWay, EnumCodeTypeName.PROPERTY_PRICE_WAY, true);
		selIsMerge = DescUtils.getInitSelEmptyAndTrueFalse(selIsMerge, false);
		
		selCustomerGender = DescUtils.getInitSelEmptyAndGender(selCustomerGender);
		selCustomerIdCardType = DescUtils.getInitSelForGuangZhou(selCustomerIdCardType, EnumCodeTypeName.SALEUNIT_IDCARD_TYPE, true);
		
		selPropertyType = DescUtils.getInitSelForGuangZhou(selPropertyType, EnumCodeTypeName.SALEUNIT_PROPERTY_TYPE, true);
		
		selPayType = PayWayUtils.getSelPayWayByUnitId(unitId);
		
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
	
	//
	
	private PropertyUnit selectUnit;
	
	private Confirm confirm;
	private ContractCustomer confirmCustomer;
	
	private String confirmType;
	
	private LinkedHashMap selPayType; //付款方式
	private LinkedHashMap selIsMerge; //是否并入合同
	private LinkedHashMap selPriceWay; //计价方式
	
	private LinkedHashMap selCustomerGender; //新建客户,性别
	private LinkedHashMap selCustomerIdCardType; //新建客户,证件类型
	
	private LinkedHashMap selPropertyType; //房产类型
	
	private String priceWay; //默认的计价方式,(建筑面积,1)
	
	private Contract contract;
	
	private String unitDiscountId;
	
	private String customerId;
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public String getUnitDiscountId() {
		return unitDiscountId;
	}

	public void setUnitDiscountId(String unitDiscountId) {
		this.unitDiscountId = unitDiscountId;
	}

	public void setPriceWay(String priceWay) {
		this.priceWay = priceWay;
	}
	
	public String getPriceWay() {
		return priceWay;
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

	public Confirm getConfirm() {
		return confirm;
	}

	public void setConfirm(Confirm confirm) {
		this.confirm = confirm;
	}

	public ContractCustomer getConfirmCustomer() {
		return confirmCustomer;
	}

	public void setConfirmCustomer(ContractCustomer confirmCustomer) {
		this.confirmCustomer = confirmCustomer;
	}

	public String getConfirmType() {
		return confirmType;
	}

	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}

	public void setSelectUnit(PropertyUnit selectUnit) {
		this.selectUnit = selectUnit;
	}
	
	public PropertyUnit getSelectUnit() {
		return selectUnit;
	}
	

}
