package com.ihk.saleunit.action.new_;

//import com.ihk.property.data.pojo.PropertyUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.CancelUnit;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.CustomerRename;
import com.ihk.saleunit.data.pojo.ReplaceUnit;
import com.ihk.saleunit.data.pojo.Tart;
import com.ihk.saleunit.data.pojo.UnitOperRecord;
import com.ihk.saleunit.data.services.ICancelUnitServices;
import com.ihk.saleunit.data.services.IConfirmBookServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.ICustomerRenameServices;
import com.ihk.saleunit.data.services.IReplaceUnitServices;
import com.ihk.saleunit.data.services.ITartServices;
import com.ihk.saleunit.data.services.IUnitOperRecordServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunitnew.UnitOperRecordUtils;

public class GuangZhouAppointUnitOperation extends SupperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int unitId;

	private PropertyUnit unit;
	
	private Confirm confirm;
	
	private Tart tart;
	
	private CustomerRename customerRename;
	
	public CustomerRename getCustomerRename() {
		return customerRename;
	}

	public void setCustomerRename(CustomerRename customerRename) {
		this.customerRename = customerRename;
	}

	private ReplaceUnit replaceUnit;
	
	private CancelUnit cancelUnit;
	
	private List<UnitOperRecord> unitOperRecordList;
	
	private UnitOperRecord unitOperRecord;
	
	private int recordId;
	
	private int mainId;
	
	List<ContractCustomer> contractCustomerList;
	
	private String oldCustomerId;
	
	private String customerId;

	private ConfirmBook confirmBook;
	
	
	
	public String getOldCustomerId() {
		return oldCustomerId;
	}

	public void setOldCustomerId(String oldCustomerId) {
		this.oldCustomerId = oldCustomerId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<ContractCustomer> getContractCustomerList() {
		return contractCustomerList;
	}

	public void setContractCustomerList(List<ContractCustomer> contractCustomerList) {
		this.contractCustomerList = contractCustomerList;
	}

	public int getMainId() {
		return mainId;
	}

	public void setMainId(int mainId) {
		this.mainId = mainId;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	private String customerName;
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	//private Date confirmDate;
	
	public UnitOperRecord getUnitOperRecord() {
		return unitOperRecord;
	}

	public void setUnitOperRecord(UnitOperRecord unitOperRecord) {
		this.unitOperRecord = unitOperRecord;
	}
	

	public List<UnitOperRecord> getUnitOperRecordList() {
		return unitOperRecordList;
	}

	public void setUnitOperRecordList(List<UnitOperRecord> unitOperRecordList) {
		this.unitOperRecordList = unitOperRecordList;
	}

	public Tart getTart() {
		return tart;
	}

	public void setTart(Tart tart) {
		this.tart = tart;
	}

	public ReplaceUnit getReplaceUnit() {
		return replaceUnit;
	}

	public void setReplaceUnit(ReplaceUnit replaceUnit) {
		this.replaceUnit = replaceUnit;
	}

	public CancelUnit getCancelUnit() {
		return cancelUnit;
	}

	public void setCancelUnit(CancelUnit cancelUnit) {
		this.cancelUnit = cancelUnit;
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

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	private int amount;
	
	private List<UnitPayBill> unitList;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public List<UnitPayBill> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<UnitPayBill> unitList) {
		this.unitList = unitList;
	}

	public ConfirmBook getConfirmBook() {
		return confirmBook;
	}

	public void setConfirmBook(ConfirmBook confirmBook) {
		this.confirmBook = confirmBook;
	}

	@Autowired
	private IPropertyUnitServices unitServices;
	@Autowired
	private IConfirmServices confirmServices;
	@Autowired
	private IReplaceUnitServices replaceUnitServices;
	@Autowired
	private ICancelUnitServices cancelUnitServices;
	@Autowired
	private ITartServices tartServices;
	@Autowired
	private IUnitOperRecordServices unitOperRecordServices;
	@Autowired
	private IContractServices contractServices;
	@Autowired
	private IContractCustomerServices contractCustomerServices;
	@Autowired
	private ICustomerRenameServices customerRenameServices;
	@Autowired
	private IConfirmBookServices confirmBookServices;
	

	public String unitOperation() {
		this.init();
		getUnitOperationList();
		return "unit_operation";
	}

	private void init() {
		unit = unitServices.findPropertyUnitById(unitId);
		confirm=confirmServices.findConfirmByUnitId(unitId);
		if(confirm!=null){
			customerName=confirm.getCustomerName();
		}
		this.getUnitOperationList();

	}

	/**
	 * 获取单元操作表格信息
	 */

	public void getUnitOperationList() {
		unitOperRecordList=unitOperRecordServices.findUnitOperRecordByUnitId(unitId);
		for(int i=1;i<=unitOperRecordList.size();i++){
			if(i<unitOperRecordList.size()){
				continue;
			}else{
				UnitOperRecord unitOperRecord=unitOperRecordList.get(i-1);
				unitOperRecord.setFlag(true);
			}
		}
	}
		
		
	/**
	 * 查看挞订信息
	 */
	public String showTartRecord(){
		//this.init();
		tart=tartServices.findTartById(mainId);
		unit=unitServices.findPropertyUnitById(tart.getUnitId());
		confirm=confirmServices.findConfirmById(tart.getMainId());
		contractCustomerList=contractCustomerServices.findContractCustomerByMainIdAndConfirmTypeNotValid(confirm.getId(), ContConfirmType.CONFIRM);
		if(confirm!=null){
			customerName=confirm.getCustomerName();
		}
		return "show_tart_record";
	}
	
	
	
	/**
	 * 
	 * @return 撤消挞订
	 * @throws Exception
	 */
	public String cancelTart() throws Exception{
		boolean isSucc=true;
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					UnitOperRecord unitOperRecord=unitOperRecordServices.findUnitOperRecordById(recordId);
					int parentId=unitOperRecord.getParentId();
					tartServices.deleteTart(unitOperRecord.getMainId());//删除挞订表信息
					
					UnitOperRecordUtils.addOperRecord(unitOperRecord.getUnitId(), ContUnitSaleState.CANCEL_TART, parentId);
					
					
					Confirm confirm=confirmServices.findConfirmByUnitIdIncludeIsDeleted(unitOperRecord.getUnitId());
					ConfirmBook confirmBook=confirmBookServices.findConfirmBookByUnitIdIncludeIsDeleted(unitOperRecord.getUnitId());
					if(confirm!=null){
						confirmServices.reloadConfirm(confirm);//恢复认购
						
						Map<String,String> map=new HashMap<String,String>();
						map.put("id", unitOperRecord.getUnitId()+"");
						map.put("saleState", ContUnitSaleState.CONFIRM);
						unitServices.updatePropertyUnitSaleState(map);//更新单元状态
						List<ContractCustomer> contractCustomer=contractCustomerServices.findContractCustomerByMainIdAndConfirmTypeNotValid(confirm.getId(), ContConfirmType.CONFIRM);
						for(ContractCustomer con:contractCustomer){
							con.setIsValid("0");
							contractCustomerServices.updateContractCustomer(con);
						}
					}else if(confirmBook!=null){
						confirmBookServices.updateConfirmBook(confirmBook);
						Map<String,String> map=new HashMap<String,String>();
						map.put("id", unitOperRecord.getUnitId()+"");
						map.put("saleState", ContUnitSaleState.CONFIRM_BOOK);
						unitServices.updatePropertyUnitSaleState(map);//更新单元状态
						List<ContractCustomer> contractCustomer=contractCustomerServices.findContractCustomerByMainIdAndConfirmTypeNotValid(confirmBook.getId(), ContConfirmType.CONFIRM_BOOK);
						for(ContractCustomer con:contractCustomer){
							con.setIsValid("0");
							contractCustomerServices.updateContractCustomer(con);
						}
					}
					
				}
			}.execute();
		
		}catch(Exception e){
			isSucc = false;
		}
		
		CustomerUtils.writeResponse(response, isSucc + "");
		
		return null;
		
		
	}
	
	
	/**
	 * 查看改名信息
	 */
	public String showCustomerRenameRecord(){

		this.init();
		customerRename=customerRenameServices.findCustomerRenameById(mainId);

		oldCustomerId=customerRename.getPrevCustomerId();
		customerId=customerRename.getNextCustomerId();

		if(confirm!=null){
			customerName=confirm.getCustomerName();
		}
		return "show_customer_rename_record";
	}
	
	
	
	/**
	 * 
	 * @return 撤消改名
	 * @throws Exception
	 */
	public String cancelCustomerRename() throws Exception{
		boolean isSucc=true;
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					UnitOperRecord unitOperRecord=unitOperRecordServices.findUnitOperRecordById(recordId);
					int parentId=unitOperRecord.getParentId();
					//删除改名表信息
					customerRenameServices.deleteCustomerRename(unitOperRecord.getMainId());
					//新增撤销改名记录
				 	UnitOperRecordUtils.addOperRecord(confirm.getUnitId(), ContUnitSaleState.CANCEL_CHANGE_CUSTOMER, parentId);
					
				 	
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
							ContractCustomer contractCustomer=contractCustomerServices.findContractCustomerById(idList.get(i));
							contractCustomer.setIsValid(CommonUtils.DELETED);
							contractCustomerServices.updateContractCustomer(contractCustomer);
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
				 	//新增撤销改名记录
				 	UnitOperRecordUtils.addOperRecord(confirm.getUnitId(), ContUnitSaleState.CANCEL_CHANGE_CUSTOMER, parentId);
				}
			}.execute();
		
		}catch(Exception e){
			isSucc = false;
		}
		
		CustomerUtils.writeResponse(response, isSucc + "");
		
		return null;
		
		
	}
	
	
	
	
	/**
	 * 查看退房信息
	 */
	public String showCancelUnitRecord(){
		//this.init();
		cancelUnit=cancelUnitServices.findCancelUnitById(mainId);
		unit=unitServices.findPropertyUnitById(cancelUnit.getUnitId());
		confirm=confirmServices.findConfirmById(cancelUnit.getMainId());
		contractCustomerList=contractCustomerServices.findContractCustomerByMainIdAndConfirmTypeNotValid(confirm.getId(), ContConfirmType.CONFIRM);
		if(confirm!=null){
			customerName=confirm.getCustomerName();
		}
		return "show_cancel_unit_record";
	}	
	
	
	
	
	/**
	 * 
	 * @return 撤消退房
	 * @throws Exception
	 */
	public String cancelCancelUnit() throws Exception{
		boolean isSucc=true;
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					UnitOperRecord unitOperRecord=unitOperRecordServices.findUnitOperRecordById(recordId);
					int parentId=unitOperRecord.getParentId();
					
					
					//System.out.println(unitOperRecordServices.findUnitOperRecordById(parentId).getOperType()+"");
					if(!"9".equals(unitOperRecordServices.findUnitOperRecordById(parentId).getOperType()+"")&&!"25".equals(unitOperRecordServices.findUnitOperRecordById(parentId).getOperType()+"")){
						cancelUnitServices.deleteCancelUnit(unitOperRecord.getMainId());//删除退房表信息
						Confirm confirm=confirmServices.findConfirmByUnitIdIncludeIsDeleted(unitOperRecord.getUnitId());//需要恢复的记录
						confirmServices.reloadConfirm(confirm);//恢复认购
						
						Map<String,String> map=new HashMap<String,String>();
						map.put("id", unitOperRecord.getUnitId()+"");
						map.put("saleState", ContUnitSaleState.CONFIRM);
						
						unitServices.updatePropertyUnitSaleState(map);//更新单元状态;
						
						List<ContractCustomer> contractCustomer=contractCustomerServices.findContractCustomerByMainIdAndConfirmTypeNotValid(confirm.getId(), ContConfirmType.CONFIRM);
						for(ContractCustomer con:contractCustomer){
							con.setIsValid("0");
							contractCustomerServices.updateContractCustomer(con);
						}
						UnitOperRecordUtils.addOperRecord(unitOperRecord.getUnitId(), ContUnitSaleState.CANCEL_CANCEL_UNIT, parentId);
						CustomerUtils.writeResponse(response, true + "");
						
					}
					if("9".equals(unitOperRecordServices.findUnitOperRecordById(parentId).getOperType()+"")||"25".equals(unitOperRecordServices.findUnitOperRecordById(parentId).getOperType()+"")){
						cancelUnitServices.deleteCancelUnit(unitOperRecord.getMainId());//删除退房表信息
						Confirm confirm=confirmServices.findConfirmByUnitIdIncludeIsDeleted(unitOperRecord.getUnitId());//需要恢复的记录
						confirmServices.reloadConfirm(confirm);//恢复认购
						
						Contract contract=contractServices.findContractByUnitIdIncludeIsDelete(unitOperRecord.getUnitId());
						contractServices.reloadContract(contract);//恢复合同
						
						Map<String,String> map=new HashMap<String,String>();
						map.put("id", unitOperRecord.getUnitId()+"");
						map.put("saleState", ContUnitSaleState.CONTRACT);
						
						unitServices.updatePropertyUnitSaleState(map);//更新单元状态;
						
						List<ContractCustomer> contractCustomer=contractCustomerServices.findContractCustomerByMainIdAndConfirmTypeNotValid(confirm.getId(), ContConfirmType.CONFIRM);
						for(ContractCustomer con:contractCustomer){
							con.setIsValid("0");
							contractCustomerServices.updateContractCustomer(con);
						}
						List<ContractCustomer> contractCustomerCon=contractCustomerServices.findContractCustomerByMainIdAndConfirmTypeNotValid(contract.getId(), ContConfirmType.CONTRACT);
						for(ContractCustomer con:contractCustomerCon){
							con.setIsValid("0");
							contractCustomerServices.updateContractCustomer(con);
						}
						UnitOperRecordUtils.addOperRecord(unitOperRecord.getUnitId(), ContUnitSaleState.CONTRACT_CANCEL_CANCEL_UNIT, parentId);
						CustomerUtils.writeResponse(response, true + "");
					}
					
					
				}
			}.execute();
		
		}catch(Exception e){
			isSucc = false;
			CustomerUtils.writeResponse(response, isSucc + "");
		}
		
		
		
		return null;
		
		
	}
	
	

	/**
	 * 查看换房新认购书信息
	 */
	public String showChangeUnitRecord(){
		//this.init();
		replaceUnit=replaceUnitServices.findReplaceUnitById(mainId);
		unit=unitServices.findPropertyUnitById(replaceUnit.getUnitId2());
		confirm=confirmServices.findConfirmById(replaceUnit.getConfirmId2());
		contractCustomerList=contractCustomerServices.findContractCustomerByMainIdAndConfirmTypeNotValid(mainId, ContConfirmType.CONFIRM);
		if(confirm!=null){
			customerName=confirm.getCustomerName();
		}
		return "show_change_unit_record";
	}	
	
	/**
	 * 
	 * @return 撤消换房
	 * @throws Exception
	 */
	public String cancelChangeUnit() throws Exception{
		boolean isSucc=true;
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					UnitOperRecord unitOperRecord=unitOperRecordServices.findUnitOperRecordById(recordId);
					int parentId=unitOperRecord.getParentId();
					int parentMainId=unitOperRecordServices.findUnitOperRecordById(parentId).getMainId();
					
					
					UnitOperRecordUtils.addOperRecord(unitOperRecord.getUnitId(), ContUnitSaleState.CANCEL_CHANGE_UNIT, parentId);
					
					ReplaceUnit replaceUnit=replaceUnitServices.findReplaceUnitById(unitOperRecord.getMainId());
					//confirmServices.findConfirmByUnitId(parentId)
					Confirm confirm1=confirmServices.findConfirmByUnitIdIncludeIsDeleted(replaceUnit.getUnitId1());
					confirmServices.reloadConfirm(confirm1);//恢复认购

					
					Confirm confirm2=confirmServices.findConfirmByUnitId(replaceUnit.getUnitId2());
					List<ContractCustomer> conList=contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirm2.getId(), ContConfirmType.CONFIRM);
					StringBuffer sb=new StringBuffer();
					for(ContractCustomer con:conList){
						sb.append(con.getId()+"").append(",");
					}
					String sbString=sb.toString();
					String[] customerIds=sbString.split(",");
					for(int i=0;i<customerIds.length;i++){
						//修改对应客户的状态
						contractCustomerServices.updateContractCustomerConfirmType(Integer.parseInt(customerIds[i]), ContConfirmType.CONFIRM);
						//修改MainId
						contractCustomerServices.updateContractCustomerMainId(Integer.parseInt(customerIds[i]), parentMainId);
					}
					
					confirmServices.deleteConfirm(confirm2.getId());// 撤消认购
					
					Map<String,String> map1=new HashMap<String,String>();
					map1.put("id", replaceUnit.getUnitId1()+"");
					map1.put("saleState", ContUnitSaleState.CONFIRM);
					
					
					
					
					
					unitServices.updatePropertyUnitSaleState(map1);//更新旧单元状态
					
					Map<String,String> map2=new HashMap<String,String>();
					map2.put("id", replaceUnit.getUnitId2()+"");
					map2.put("saleState", ContUnitSaleState.SALE_ABLE);
					
					unitServices.updatePropertyUnitSaleState(map2);//更新新单元状态
					
					replaceUnitServices.deleteReplaceUnit(unitOperRecord.getMainId());//删除换房表信息
				}
			}.execute();
		
		}catch(Exception e){
			isSucc = false;
		}
		
		CustomerUtils.writeResponse(response, isSucc + "");
		
		return null;
		
		
	}
	
	
	
	

	
}
