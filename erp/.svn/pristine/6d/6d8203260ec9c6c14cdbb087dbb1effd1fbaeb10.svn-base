package com.ihk.saleunit.action.new_;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.property.data.services.IUnitPayBillServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.ExtensionContract;
import com.ihk.saleunit.data.pojo.ExtensionContractCond;
import com.ihk.saleunit.data.services.IConfirmBookServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IExtensionContractServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 *  延期签约
 */
@SuppressWarnings("rawtypes")
public class GuangZhouAppointExtensionContractAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IExtensionContractServices extensionContractServices;
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IContractServices contractServices;
	@Autowired
	IConfirmBookServices confirmBookServices;
	@Autowired 
	IContractCustomerServices contractCustomerServices;
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IUnitPayBillServices billServices;
	
	/**
	 * 查看所有的延期签约
	 * @return
	 * @throws Exception
	 */
	public String showAllExtensionContract() throws Exception{
		
		exList = extensionContractServices.findExtensionContract(new ExtensionContractCond());
		
		return "showAllExtensionContract";
	}
	
	public String extensionContractList() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("id"));
		
		exList = extensionContractServices.findExtensionContractByUnitId(unitId);
		
		init(unitId);
		
		return "extensionContractList";
	}
	
	public String toAddExtensionContract() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		
		initForAdd(unitId, customerId);
		
		return "toAddExtensionContract";
	}
	
	//loadClose
	public String addExtensionContract() throws Exception{
		
		try{
		
			CommonPojoUtils.initPojoCommonFiled(extensionContract);
			
			extensionContractServices.addExtensionContract(extensionContract);
			
			setLoadClose("true");
			setSuggestion(CommonUtils.SUCCSUGG);
			
			setUpMarkToClose();
			
		}catch(Exception e){
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		initForAdd(extensionContract.getUid(), extensionContract.getCid());
		
		return "addExtensionContract";	
	}
	
	public String showExtensionContract() throws Exception{
		
		int exId = Integer.parseInt(request.getParameter("exId"));
		
		extensionContract = extensionContractServices.findExtensionContractById(exId);
		request.getSession().setAttribute("extensionContract", extensionContract); //要保存到session才能在<s:date ../>中获取到??
		payBill = billServices.findUnitPayBillLimit1ByUnitId(extensionContract.getUid()); //获取已付金额
		
		return "showExtensionContract";
	}
	
	public String toUpdateExtensionContract() throws Exception{
		
		int exId = Integer.parseInt(request.getParameter("exId"));
		
		extensionContract = extensionContractServices.findExtensionContractById(exId);
		
		initForAdd(extensionContract.getUid(), extensionContract.getCid());
		
		return "toUpdateExtensionContract";
	}
	
	public String updateExtensionContract() throws Exception{
		
		int exId = extensionContract.getId();
		
		ExtensionContract oldExtensionContract = extensionContractServices.findExtensionContractById(exId);
		
		CommonPojoUtils.initPojoForUpdate(oldExtensionContract, extensionContract);
		
		try{
			
			extensionContractServices.updateExtensionContract(extensionContract);
			
			setLoadClose("true");
			setSuggestion(CommonUtils.SUCCSUGG);
			
			setUpMarkToClose();
		
		}catch(Exception e){
		}
		
		initForAdd(extensionContract.getUid(), extensionContract.getCid());
		
		return "updateExtensionContract";
	}
	
	public String deleteEx() throws Exception{
		
		String out = "";
		
		try{
			
			int exId = Integer.parseInt(request.getParameter("exId"));
			
			extensionContractServices.deleteExtensionContract(exId);
			
			out = "true";
		
		}catch(Exception e){
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	public String getAjaxExtensionContract() throws Exception{
		
		List<ExtensionContract> exList = extensionContractServices.findExtensionContract(new ExtensionContractCond());
		
		StringBuffer sb = new StringBuffer();
		
		if(!CommonUtils.isCollectionEmpty(exList)){
			
			sb.append("截至").append(CustomerUtils.getNowForString()).append(",延期签约总数为:").append(exList.size())
				.append("(<a style='color:red' href='javascript:void(0)' onclick='showAllExtensionContract()'>查看</a>)")
				;
		}
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	private void initForAdd(int unitId, int customerId){
		
		payBill = billServices.findUnitPayBillLimit1ByUnitId(unitId); //获取已付金额
		
		unit = unitServices.findPropertyUnitById(unitId);
		String saleState = unit.getSaleState();
		
		if(ContUnitSaleState.CONFIRM.equals(saleState)){
			
			Confirm confirm = initConfirm(unitId);
			Date confirmSignDate = confirm.getSignDate() == null ? confirm.getCreatedTime() : confirm.getSignDate();
			
			signDate = CustomerUtils.getDateString(confirmSignDate);
			signDateLong = confirmSignDate.getTime();
			
		}else if(ContUnitSaleState.CONTRACT.equals(saleState)){
			
			Contract contract = initContract(unitId);
			Date contractSignDate = contract.getSignDate() == null ? contract.getCreatedTime() : contract.getSignDate();
			
			signDate = CustomerUtils.getDateString(contractSignDate);
			signDateLong = contractSignDate.getTime();
			
		}else if(ContUnitSaleState.CONFIRM_BOOK.equals(saleState)){
			
			ConfirmBook confirmBook = initConfirmBook(unitId);
			Date confirmBookSignDate = confirmBook.getCreatedTime();
			
			signDate = CustomerUtils.getDateString(confirmBookSignDate);
			signDateLong = confirmBookSignDate.getTime();
			
		}
		
		selExtensionFirst = DescUtils.getInitSelEmptyAndTrueFalse(selExtensionFirst);
		conCustomer = contractCustomerServices.findContractCustomerById(customerId);
		
		removeSuggestion();
	}
	
	private void init(int unitId){
		
		payBill = billServices.findUnitPayBillLimit1ByUnitId(unitId); //获取已付金额
		
		unit = unitServices.findPropertyUnitById(unitId);
		String saleState = unit.getSaleState();
		
		showModify = true; //默认是显示,单元状态为签约的时候隐藏,
		
		List<ContractCustomer> cusList = null;
		
		if(ContUnitSaleState.CONFIRM.equals(saleState)){
			
			Confirm confirm = initConfirm(unitId);
			
			Date confirmSignDate = confirm.getSignDate();
			signDate = CustomerUtils.getDateString(confirmSignDate); //原约定签约日期
			
			cusList = contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirm.getId(), ContConfirmType.CONFIRM);
			
			customerMap = initCustomerMap(cusList, ContConfirmType.CONFIRM);
			
			/*conCustomer = contractCustomerServices.findContractCustomerById(confirm.getCustomerId());
			if(conCustomer != null){
				conCustomer.setCustomerName("认购客户--" + conCustomer.getCustomerName());
			}*/
			
		}else if(ContUnitSaleState.CONTRACT.equals(saleState)){
			
			Contract contract = initContract(unitId);
			
			Date contractSignDate = contract.getSignDate();
			signDate = CustomerUtils.getDateString(contractSignDate); //原约定签约日期
			
			cusList = contractCustomerServices.findContractCustomerByMainIdAndConfirmType(contract.getId(), ContConfirmType.CONFIRM);
			
			customerMap = initCustomerMap(cusList, ContConfirmType.CONTRACT);
			
			/*conCustomer = contractCustomerServices.findContractCustomerById(contract.getCustomerId());
			if(conCustomer != null){
				conCustomer.setCustomerName("签约客户--" + conCustomer.getCustomerName());
			}*/
			
			showModify = false;
			
		}else if(ContUnitSaleState.CONFIRM_BOOK.equals(saleState)){
			
			ConfirmBook confirmBook = initConfirmBook(unitId);
			
			signDate = CustomerUtils.getDateString(confirmBook.getCreatedTime()); //原约定签约日期(默认为新建日期)
			
			cusList = contractCustomerServices.findContractCustomerByMainIdAndConfirmType(confirmBook.getId(), ContConfirmType.CONFIRM);
			
			customerMap = initCustomerMap(cusList, ContConfirmType.CONFIRM_BOOK);
			
			/*conCustomer = contractCustomerServices.findContractCustomerById(confirmBook.getCustomerId());
			if(conCustomer != null){
				conCustomer.setCustomerName("临定客户--" + conCustomer.getCustomerName());
			}*/
			
		}
		
		//customerMap = initCustomerMap(conCustomer);
	}
	
	private Confirm initConfirm(int unitId){
		
		Confirm confirm = new Confirm();
		ConfirmCond cond = new ConfirmCond();
		cond.setUnitId(unitId + "");
		
		List<Confirm> confirmList = confirmServices.findConfirm(cond);
		if(!CommonUtils.isCollectionEmpty(confirmList)){
			confirm = confirmList.get(0);
		}
		
		return confirm;
		
	}
	
	private Contract initContract(int unitId){
		
		Contract contract = new Contract();
		ContractCond cond = new ContractCond();
		cond.setUnitId(unitId + "");
		
		List<Contract> contractList = contractServices.findContract(cond);
		if(!CommonUtils.isCollectionEmpty(contractList)){
			contract = contractList.get(0);
		}
		
		return contract;
	}
	
	private ConfirmBook initConfirmBook(int unitId){
		
		ConfirmBook confirmBook = confirmBookServices.findConfirmBookByUnitId(unitId);
		
		return confirmBook;
	}
	
	/**
	 * 初始化客户下拉框 
	 * @param cusList
	 * @param type
	 * @return
	 */
	private Map<String, String> initCustomerMap(List<ContractCustomer> cusList, String type){
		
		Map<String, String> retMap = new LinkedHashMap<String, String>();
		
		if(CommonUtils.isCollectionEmpty(cusList)){
			
			retMap.put("", CommonUtils.EMPTY);
		}else{
			
			//"认购客户--"
			String limit = "";
			if(ContConfirmType.CONFIRM.equals(type)){
				
				limit = "成交客户--";
			}else if(ContConfirmType.CONTRACT.equals(type)){
				
				limit = "合同客户--";
			}else if(ContConfirmType.CONFIRM_BOOK.equals(type)){
				
				limit = "临定客户--";
			}
			
			for(ContractCustomer cus : cusList){
				
				retMap.put(cus.getId() + "", limit + cus.getCustomerName());
			}
		}
		
		return retMap;
	}
	
	@SuppressWarnings("unused")
	@Deprecated
	private Map<String, String> initCustomerMap(ContractCustomer conCustomer){
		
		Map<String, String> retMap = new LinkedHashMap<String, String>();
		
		if(conCustomer == null){

			retMap.put("", CommonUtils.EMPTY);
		}else{
		
			retMap.put(conCustomer.getId() + "", conCustomer.getCustomerName());
		}
		
		return retMap;
	}
	
	////
	
	private List<ExtensionContract> exList;
	
	private ExtensionContract extensionContract;
	
	private ContractCustomer conCustomer; //认购合同客户
	
	private Map<String, String> customerMap; //页面显示的当前客户
	private LinkedHashMap selExtensionFirst; //是否首次延期
	
	private String signDate; //原定签约日期(yyyy-MM-dd)格式
	private long signDateLong; //日期的毫秒数,用于时间微调
	
	private UnitPayBill payBill;
	
	private PropertyUnit unit;
	
	private String loadClose; //是否关闭上传弹出框,"true"就关闭
	
	private boolean showModify; //是否显示延期签约的"新建,修改,删除"
	
	public boolean isShowModify() {
		return showModify;
	}

	public void setShowModify(boolean showModify) {
		this.showModify = showModify;
	}

	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}
	
	public PropertyUnit getUnit() {
		return unit;
	}
	
	public void setLoadClose(String loadClose) {
		this.loadClose = loadClose;
	}
	
	public String getLoadClose() {
		return loadClose;
	}
	
	public void setPayBill(UnitPayBill payBill) {
		this.payBill = payBill;
	}
	
	public UnitPayBill getPayBill() {
		return payBill;
	}
	
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	
	public String getSignDate() {
		return signDate;
	}
	
	public void setSignDateLong(long signDateLong) {
		this.signDateLong = signDateLong;
	}
	
	public long getSignDateLong() {
		return signDateLong;
	}
	
	public void setSelExtensionFirst(LinkedHashMap selExtensionFirst) {
		this.selExtensionFirst = selExtensionFirst;
	}
	
	public LinkedHashMap getSelExtensionFirst() {
		return selExtensionFirst;
	}
	
	public void setExtensionContract(ExtensionContract extensionContract) {
		this.extensionContract = extensionContract;
	}
	
	public ExtensionContract getExtensionContract() {
		return extensionContract;
	}
	
	public void setCustomerMap(Map<String, String> customerMap) {
		this.customerMap = customerMap;
	}
	
	public Map<String, String> getCustomerMap() {
		return customerMap;
	}
	
	public void setConCustomer(ContractCustomer conCustomer) {
		this.conCustomer = conCustomer;
	}
	
	public ContractCustomer getConCustomer() {
		return conCustomer;
	}
	
	public void setExList(List<ExtensionContract> exList) {
		this.exList = exList;
	}
	
	public List<ExtensionContract> getExList() {
		return exList;
	}
	

}
