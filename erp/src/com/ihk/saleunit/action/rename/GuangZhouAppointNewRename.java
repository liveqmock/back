package com.ihk.saleunit.action.rename;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.CustomerRename;
import com.ihk.saleunit.data.pojo.Tart;
import com.ihk.saleunit.data.pojo.UnitOperRecord;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.ICustomerRenameServices;
import com.ihk.saleunit.data.services.ITartServices;
import com.ihk.saleunit.data.services.IUnitOperRecordServices;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;
import com.ihk.utils.saleunit.PayWayUtils;
import com.ihk.utils.saleunitnew.UnitOperRecordUtils;

public class GuangZhouAppointNewRename extends SupperAction{

	/**
	 * 客户更名
	 */
	private static final long serialVersionUID = 6282884756245289252L;

	private int unitId;

	private PropertyUnit unit;
	
	private String customer;
	
	private Confirm confirm;
	
	private List<String> customerNameList;
	
	private ContractCustomer confirmCustomer;
	
	private CustomerRename customerRename;
	
	private ContractCustomer contractCustomer;
	
	private String ConfirmType;
	
	

	
	private LinkedHashMap<String, String> selPayType; //付款方式(根据楼栋,从表pay_way中获取)
	private LinkedHashMap selPriceWay; //计价方式
	private LinkedHashMap selIsMerge; //是否并入合同(是否二手成交,是否一二手联动,是否关系户共用)
	
	private LinkedHashMap selCustomerGender; //新建客户,性别
	private LinkedHashMap selCustomerIdCardType; //新建客户,证件类型
	
	private LinkedHashMap selPropertyType; //房产类型
	
	private String confirmType;
	

	
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
	
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	
	
	public void setSelPayType(LinkedHashMap<String, String> selPayType) {
		this.selPayType = selPayType;
	}
	
	public LinkedHashMap<String, String> getSelPayType() {
		return selPayType;
	}
	
	

	public String getConfirmType() {
		return ConfirmType;
	}

	public void setConfirmType(String confirmType) {
		ConfirmType = confirmType;
	}

	public ContractCustomer getContractCustomer() {
		return contractCustomer;
	}

	public void setContractCustomer(ContractCustomer contractCustomer) {
		this.contractCustomer = contractCustomer;
	}

	public CustomerRename getCustomerRename() {
		return customerRename;
	}

	public void setCustomerRename(CustomerRename customerRename) {
		this.customerRename = customerRename;
	}

	public ContractCustomer getConfirmCustomer() {
		return confirmCustomer;
	}

	public void setConfirmCustomer(ContractCustomer confirmCustomer) {
		this.confirmCustomer = confirmCustomer;
	}

	private Tart tart;
	
	private List<UnitPayBill> unitList;

	private int amount;
	
	private int tartId;
	
	private UnitOperRecord unitOperRecord;
	
	
	
	public UnitOperRecord getUnitOperRecord() {
		return unitOperRecord;
	}

	public void setUnitOperRecord(UnitOperRecord unitOperRecord) {
		this.unitOperRecord = unitOperRecord;
	}

	public int getTartId() {
		return tartId;
	}

	public void setTartId(int tartId) {
		this.tartId = tartId;
	}

	public Tart getTart() {
		return tart;
	}

	public void setTart(Tart tart) {
		this.tart = tart;
	}

	public List<String> getCustomerNameList() {
		return customerNameList;
	}

	public void setCustomerName(List<String> customerNameList) {
		this.customerNameList = customerNameList;
	}

	public Confirm getConfirm() {
		return confirm;
	}

	public void setConfirm(Confirm confirm) {
		this.confirm = confirm;
	}


	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
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

	
	
	public List<UnitPayBill> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<UnitPayBill> unitList) {
		this.unitList = unitList;
	}


	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Autowired
	private IPropertyUnitServices unitServices;
	@Autowired
	private IConfirmServices confirmServices;
	@Autowired
	private ITartServices tartServices;
	@Autowired
	private IUnitOperRecordServices unitOperRecordServices;
	@Autowired
	private ICustomerServices customerServices;
	@Autowired
	private IContractCustomerServices contractCustomerServices;
	@Autowired
	private ICustomerRenameServices customerRenameServices;
	
	
	/**
	 * 获取单元和成交信息
	 */
	private void init() {
		unit = unitServices.findPropertyUnitById(unitId);
		confirm=confirmServices.findConfirmByUnitId(unitId);
		ConfirmType=ContConfirmType.CONFIRM;
		//tart=tartServices.findTartByUnitId(unitId);
		if(confirm!=null){
			customerNameList=new ArrayList<String>();
			List<ContractCustomer> contractCustomerList = contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirm.getId(), ContConfirmType.CONFIRM);
			for(ContractCustomer ccl:contractCustomerList){
				customerNameList.add(confirm.getCustomerNameUrl(ccl.getCustomerName()));
				
			}
			confirmCustomer=confirm.getCustomerNo();
		}
	}
	
	
	/**
	 * 
	 * 新增更名
	 */
//	public String addChangeCustomerName() {
//		init();
//		return "add_change_customer_name";
//	}
	
	
	/**
	 * 跳转到修改页面
	 * @return
	 * @throws Exception
	 */
	public String addChangeCustomerName() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		
		confirm = confirmServices.findConfirmByUnitId(unitId);
		confirmCustomer = contractCustomerServices.findContractCustomerById(confirm.getCustomerId());
		
		contractCustomerList = contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirm.getCustomerId(), ContConfirmType.CONFIRM);
		
		init(confirm.getUnitId());
		
		removeSuggestion();
		
		return "add_change_customer_name";
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
	 * 
	 * 提交更名
	 */
	public String submitChangeCustomerName(){
		
		
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				
			}
			
			@Override
			public void modifyMethod() throws Exception {
				
				//Confirm oldConfirm = confirmServices.findConfirmById(confirm.getId());
				//CommonPojoUtils.initPojoForUpdate(oldConfirm, confirm);
				//confirmServices.updateConfirm(confirm);
			 	
			 	//允许查看认购时修改客户
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
					
						//ContractCustomer contractCustomer=contractCustomerServices.findContractCustomerById(idList.get(i));
						ContractCustomer contractCustomer=contractCustomerServices.findContractCustomerById(idList.get(i));
						contractCustomer.setIsValid(CommonUtils.DELETED);
						contractCustomerServices.updateContractCustomer(contractCustomer);
						//contractCustomerServices.updateContractCustomer(contractCustomer);
					}
				}
				for(Integer newIds:newIdList){
					ContractCustomer contractCustomer=contractCustomerServices.findContractCustomerById(newIds);
					contractCustomer.setIsValid(CommonUtils.NORMAL);
					contractCustomerServices.updateContractCustomer(contractCustomer);
				}
			 	setSuggestion(CommonUtils.SUCCSUGG);
			 	setUpMarkToClose();	
			 	//新增改名表
			 	customerRename.setPrevCustomerId(CommonUtils.ListToString(idList));
			 	customerRename.setNextCustomerId(CommonUtils.ListToString(newIdList));
			 	
			 	CommonPojoUtils.initPojoCommonFiled(customerRename);
			 	customerRenameServices.addCustomerRename(customerRename);
			 	//新增改名记录
			 	UnitOperRecordUtils.addOperRecord(confirm.getUnitId(), ContUnitSaleState.CHANGE_CUSTOMER, customerRename.getId());
			 	
			 	
				
			}
		});
		
		
		/*try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
				 	
//				 	Confirm oldConfirm = confirmServices.findConfirmById(confirm.getId());
//				 	CommonPojoUtils.initPojoForUpdate(oldConfirm, confirm);
//				 	confirmServices.updateConfirm(confirm);
				 	
				 	//允许查看认购时修改客户
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
				 	setSuggestion(CommonUtils.SUCCSUGG);
				 	setUpMarkToClose();	
				 	//新增改名表
				 	CommonPojoUtils.initPojoCommonFiled(customerRename);
				 	customerRenameServices.addCustomerRename(customerRename);
				 	//新增改名记录
				 	UnitOperRecordUtils.addOperRecordForRename(confirm.getUnitId(), ContUnitSaleState.CHANGE_CUSTOMER, customerRename.getId());
				}
			}.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		init(confirm.getUnitId());*/
		
		return null;
	}
	

	
}
