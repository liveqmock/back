package com.ihk.saleunit.action.new_;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Appoint;
import com.ihk.saleunit.data.pojo.AppointCustomer;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IAppointCustomerServices;
import com.ihk.saleunit.data.services.IAppointServices;
import com.ihk.saleunit.data.services.IConfirmBookServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 标题:客户信息
 * jsp:/crm/WebRoot/saleunit_new/guangzhou/customer_info.jsp
 */
public class GuangZhouAppointNewCustomerInfoAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	IContractCustomerServices contractCustomerServices;
	@Autowired
	IAppointCustomerServices appointCustomerServices;
	@Autowired
	IConfirmBookServices confirmBookServices;
	@Autowired
	IAppointServices appointServices;
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IContractServices contractServices;
	@Autowired
	IPropertyUnitServices unitServices;
	
	/**
	 * @param id 选择的房间ID
	 * @param unitState 选择的房间状态
	 * */
	public String customerInfo(){
		
		this.init();
		
		return "customer_info";
	}
	
	private void init(){
		
		if(id <=0)
			return ;
		
		PropertyUnit unit = unitServices.findPropertyUnitById(id);
		
		customerMap = initCustomer(unit);
		
		businessMap = initBusiness(unit);
	}
	
	/**
	 * 交易资料
	 * @param unit
	 * @return
	 */
	private Map<String, String> initBusiness(PropertyUnit unit){
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		String saleState = unit.getSaleState();
		
		int unitId = unit.getId();
		
		//只有认购与合同才有交易资料
		if(ContUnitSaleState.CONFIRM.equals(saleState)){
			
			Confirm confirm = MyPropertyUtils.getConfirmServices().findConfirmByUnitId(unitId);
			
			retMap = initBusinessMap(confirm);
			
		}else if(ContUnitSaleState.CONTRACT.equals(saleState)){
			
			Confirm confirm = MyPropertyUtils.getConfirmServices().findConfirmByUnitId(unitId);
			Contract contract = MyPropertyUtils.getContractServices().findContractByUnitId(unitId);
			
			retMap = initBusinessMap(contract, confirm); 
			
		}
		
		return retMap;
	}
	
	
	/**
	 * 客户联系资料
	 * @param unit
	 * @return
	 */
	private Map<String, String> initCustomer(PropertyUnit unit){
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		String saleState = unit.getSaleState();
		int unitId = unit.getId();
		
		if(ContUnitSaleState.APPOINT.equals(saleState)){
			
			Appoint appoint = new Appoint();
			List<Appoint> appointList = appointServices.findAppointByUnitId(unitId);
			if(!CommonUtils.isCollectionEmpty(appointList)){
				appoint = appointList.get(0);
			}
			
			appointCustomer = appointCustomerServices.findAppointCustomerById(appoint.getCustomerId());
			
			retMap = initCustomerMap(appointCustomer);
			
			return retMap;
		}else if(ContUnitSaleState.CONFIRM.equals(saleState)){
			
			Confirm confirm = new Confirm();
			ConfirmCond cond = new ConfirmCond();
			cond.setUnitId(unitId + "");
			
			List<Confirm> confirmList = confirmServices.findConfirm(cond);
			if(!CommonUtils.isCollectionEmpty(confirmList)){
				confirm = confirmList.get(0);
			}
			if(confirm.getId()==0){
				return null;
			}
			String customerIds=confirm.getCustomerIds();
			String[] customerId=customerIds.split(",");
			StringBuffer sbCustomerName = new StringBuffer();
			StringBuffer sbGenderStr = new StringBuffer();
			StringBuffer sbIdcardTypeStr = new StringBuffer();
			StringBuffer sbIdcardNo = new StringBuffer();
			StringBuffer sbPhone = new StringBuffer();
			StringBuffer sbAddress = new StringBuffer();
			for(int i=0;i<customerId.length;i++){
				if("".equals(customerId[i])){
					return retMap;
				}
				conCustomer = contractCustomerServices.findContractCustomerById(Integer.parseInt(customerId[i]));
				sbCustomerName.append(conCustomer.getCustomerName()).append(",");
				sbGenderStr.append(conCustomer.getGenderStr()).append(",");
				sbIdcardTypeStr.append(conCustomer.getIdcardTypeStr()).append(",");
				sbIdcardNo.append(conCustomer.getIdcardNo()).append(",");
				sbPhone.append(conCustomer.getMobilePhone()).append(",");
				sbAddress.append(conCustomer.getAddress()).append(",");
			}
			retMap.put("customerName", CommonUtils.removeLastChar(sbCustomerName.toString()));
			retMap.put("gender", CommonUtils.removeLastChar(sbGenderStr.toString()));
			retMap.put("idcardType", CommonUtils.removeLastChar(sbIdcardTypeStr.toString()));
			retMap.put("idcardNo", CommonUtils.removeLastChar(sbIdcardNo.toString()));
			retMap.put("phone", CommonUtils.removeLastChar(sbPhone.toString()));
			retMap.put("address", CommonUtils.removeLastChar(sbAddress.toString()));
			//retMap = initCustomerMap(conCustomer);
			return retMap;
		}else if(ContUnitSaleState.CONTRACT.equals(saleState)){
			
			Contract contract = new Contract();
			ContractCond cond = new ContractCond();
			cond.setUnitId(unitId + "");
			
			List<Contract> contractList = contractServices.findContract(cond);
			if(!CommonUtils.isCollectionEmpty(contractList)){
				contract = contractList.get(0);
			}
			if(contract.getId()==0){
				return null;
			}
			String customerIds=contract.getCustomerIds();
			String[] customerId=customerIds.split(",");
			StringBuffer sbCustomerName = new StringBuffer();
			StringBuffer sbGenderStr = new StringBuffer();
			StringBuffer sbIdcardTypeStr = new StringBuffer();
			StringBuffer sbIdcardNo = new StringBuffer();
			StringBuffer sbPhone = new StringBuffer();
			StringBuffer sbAddress = new StringBuffer();
			for(int i=0;i<customerId.length;i++){
				if("".equals(customerId[i])){
					return retMap;
				}
				conCustomer = contractCustomerServices.findContractCustomerById(Integer.parseInt(customerId[i]));
				sbCustomerName.append(conCustomer.getCustomerName()).append(",");
				sbGenderStr.append(conCustomer.getGenderStr()).append(",");
				sbIdcardTypeStr.append(conCustomer.getIdcardTypeStr()).append(",");
				sbIdcardNo.append(conCustomer.getIdcardNo()).append(",");
				sbPhone.append(conCustomer.getMobilePhone()).append(",");
				sbAddress.append(conCustomer.getAddress()).append(",");
			}
			retMap.put("customerName", CommonUtils.removeLastChar(sbCustomerName.toString()));
			retMap.put("gender", CommonUtils.removeLastChar(sbGenderStr.toString()));
			retMap.put("idcardType", CommonUtils.removeLastChar(sbIdcardTypeStr.toString()));
			retMap.put("idcardNo", CommonUtils.removeLastChar(sbIdcardNo.toString()));
			retMap.put("phone", CommonUtils.removeLastChar(sbPhone.toString()));
			retMap.put("address", CommonUtils.removeLastChar(sbAddress.toString()));
			
			return retMap;
		}else if(ContUnitSaleState.CONFIRM_BOOK.equals(saleState)){
			
			ConfirmBook confirmBook = confirmBookServices.findConfirmBookByUnitId(unitId);
			
			//conCustomer = contractCustomerServices.findContractCustomerById(confirmBook.getCustomerId());
			if(confirmBook.getId()==0){
				return null;
			}
			String customerIds=confirmBook.getCustomerIds();
			String[] customerId=customerIds.split(",");
			StringBuffer sbCustomerName = new StringBuffer();
			StringBuffer sbGenderStr = new StringBuffer();
			StringBuffer sbIdcardTypeStr = new StringBuffer();
			StringBuffer sbIdcardNo = new StringBuffer();
			StringBuffer sbPhone = new StringBuffer();
			StringBuffer sbAddress = new StringBuffer();
			for(int i=0;i<customerId.length;i++){
				if("".equals(customerId[i])){
					return retMap;
				}
				conCustomer = contractCustomerServices.findContractCustomerById(Integer.parseInt(customerId[i]));
				sbCustomerName.append(conCustomer.getCustomerName()).append(",");
				sbGenderStr.append(conCustomer.getGenderStr()).append(",");
				sbIdcardTypeStr.append(conCustomer.getIdcardTypeStr()).append(",");
				sbIdcardNo.append(conCustomer.getIdcardNo()).append(",");
				sbPhone.append(conCustomer.getMobilePhone()).append(",");
				sbAddress.append(conCustomer.getAddress()).append(",");
			}
			retMap.put("customerName", CommonUtils.removeLastChar(sbCustomerName.toString()));
			retMap.put("gender", CommonUtils.removeLastChar(sbGenderStr.toString()));
			retMap.put("idcardType", CommonUtils.removeLastChar(sbIdcardTypeStr.toString()));
			retMap.put("idcardNo", CommonUtils.removeLastChar(sbIdcardNo.toString()));
			retMap.put("phone", CommonUtils.removeLastChar(sbPhone.toString()));
			retMap.put("address", CommonUtils.removeLastChar(sbAddress.toString()));
			
			return retMap;
		}
		
		return retMap;
	}
	
	/**
	 * 成交交易资料
	 * @param confirm
	 * @return
	 */
	private Map<String, String> initBusinessMap(Confirm confirm){
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		if(confirm == null)
			return retMap;
		
		retMap.put("agreeNo", confirm.getAgreeNo()); //认购书编号
		retMap.put("confirmDate", CustomerUtils.getDateString(confirm.getWorkDate())); //认购日期
		retMap.put("state", "成交"); //状态
		
		retMap.put("payTypeStr", confirm.getPayTypeStr()); //付款方式
		retMap.put("sale", getSaleForConfirm(confirm)); //销售人员
		retMap.put("sumMoney", confirm.getSumMoney() == null ? "0" : confirm.getSumMoney().toString()); //成交总价
		
		retMap.put("discountPercent", confirm.getDiscountDetail()); //折扣
		retMap.put("discountDesc", confirm.getDiscountDesc()); //折扣说明
		
		retMap.put("buildPrice", confirm.getBuildPrice() == null ? "0" : confirm.getBuildPrice().toString()); //建筑成交单价
		retMap.put("insideUnitPrice", confirm.getInsideUnitPrice() == null ? "0" : confirm.getInsideUnitPrice().toString()); //套内成交单价
		
		//retMap.put("deliveryDate", confirm.getDeliveryDate() == null ? "" : CustomerUtils.getDateString(confirm.getDeliveryDate())); //认购约定交楼日期
		retMap.put("createDate", confirm.getCreatedTime() == null ? "" : CustomerUtils.getDateString(confirm.getCreatedTime())); //创建日期
		
		retMap.put("remark", confirm.getRemark());//认购单的备注
		
		return retMap;
	}
	
	/**
	 * 合同交易资料
	 * @param contract
	 * @return
	 */
	private Map<String, String> initBusinessMap(Contract contract, Confirm confirm){
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		if(contract == null)
			return retMap;
		
		if(confirm != null){
			
			retMap.put("agreeNo", confirm.getAgreeNo()); //认购书编号
			retMap.put("confirmDate", CustomerUtils.getDateString(confirm.getWorkDate())); //认购日期
			
			retMap.put("remark", confirm.getRemark());//认购单的备注
		}
		
		retMap.put("state", "签约");
		retMap.put("payTypeStr", contract.getPayTypeStr());
		
		retMap.put("sale", getSaleForContract(contract));
		retMap.put("sumMoney", contract.getSumMoney() == null ? "0" : contract.getSumMoney().toString());
		retMap.put("discountPercent", contract.getDiscountDetail());
		
		retMap.put("buildPrice", contract.getBuildPrice() == null ? "0" : contract.getBuildPrice().toString());
		retMap.put("insideUnitPrice", contract.getInsideUnitPrice() == null ? "0" : contract.getInsideUnitPrice().toString());
		
		retMap.put("deliveryDate", contract.getDeliveryDate() == null ? "" : CustomerUtils.getDateString(contract.getDeliveryDate())); //约定交楼日期
		retMap.put("createDate", contract.getCreatedTime() == null ? "" : CustomerUtils.getDateString(contract.getCreatedTime())); //创建日期
		
		retMap.put("discountDesc", contract.getDiscountDesc() );
		
		retMap.put("signDate", CommonUtils.getDateString(contract.getSignDate())); //签合同日期
		retMap.put("contractNo", contract.getContractNo()); //合同编号
		
		return retMap;
	}
	
	private Map<String, String> initCustomerMap(AppointCustomer appointCustomer){
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		if(appointCustomer == null)
			return retMap;
		
		retMap.put("customerName", appointCustomer.getCustomerName());
		retMap.put("gender", appointCustomer.getGenderStr());
		retMap.put("idcardType", appointCustomer.getIdcardTypeStr());
		retMap.put("idcardNo", appointCustomer.getIdcardNo());
		retMap.put("phone", appointCustomer.getPhone());
		
		return retMap;
	}
	
	private Map<String, String> initCustomerMap(Confirm confirm){
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		
		
		String customerIds=confirm.getCustomerIds();
		String[] customerId=customerIds.split(",");
		StringBuffer sbCustomerName = new StringBuffer();
		StringBuffer sbGenderStr = new StringBuffer();
		StringBuffer sbIdcardTypeStr = new StringBuffer();
		StringBuffer sbIdcardNo = new StringBuffer();
		StringBuffer sbPhone = new StringBuffer();
		StringBuffer sbAddress = new StringBuffer();
		for(int i=0;i<customerId.length;i++){
			conCustomer = contractCustomerServices.findContractCustomerById(Integer.parseInt(customerId[i]));
			sbCustomerName.append(conCustomer.getCustomerName()).append(",");
			sbGenderStr.append(conCustomer.getGenderStr()).append(",");
			sbIdcardTypeStr.append(conCustomer.getIdcardTypeStr()).append(",");
			sbIdcardNo.append(conCustomer.getIdcardNo()).append(",");
			sbPhone.append(conCustomer.getPhone()).append(",");
			sbAddress.append(conCustomer.getAddress()).append(",");
		}
		retMap.put("customerName", CommonUtils.removeLastChar(sbCustomerName.toString()));
		retMap.put("gender", CommonUtils.removeLastChar(sbGenderStr.toString()));
		retMap.put("idcardType", CommonUtils.removeLastChar(sbIdcardTypeStr.toString()));
		retMap.put("idcardNo", CommonUtils.removeLastChar(sbIdcardNo.toString()));
		retMap.put("phone", CommonUtils.removeLastChar(sbPhone.toString()));
		retMap.put("address", CommonUtils.removeLastChar(sbAddress.toString()));
		
		return retMap;
	}
	
	private Map<String, String> initCustomerMap(Contract contract){
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		
		
		String customerIds=contract.getCustomerIds();
		String[] customerId=customerIds.split(",");
		StringBuffer sbCustomerName = new StringBuffer();
		StringBuffer sbGenderStr = new StringBuffer();
		StringBuffer sbIdcardTypeStr = new StringBuffer();
		StringBuffer sbIdcardNo = new StringBuffer();
		StringBuffer sbPhone = new StringBuffer();
		StringBuffer sbAddress = new StringBuffer();
		for(int i=0;i<customerId.length;i++){
			conCustomer = contractCustomerServices.findContractCustomerById(Integer.parseInt(customerId[i]));
			sbCustomerName.append(conCustomer.getCustomerName()).append(",");
			sbGenderStr.append(conCustomer.getGenderStr()).append(",");
			sbIdcardTypeStr.append(conCustomer.getIdcardTypeStr()).append(",");
			sbIdcardNo.append(conCustomer.getIdcardNo()).append(",");
			sbPhone.append(conCustomer.getPhone()).append(",");
			sbAddress.append(conCustomer.getAddress()).append(",");
		}
		retMap.put("customerName", CommonUtils.removeLastChar(sbCustomerName.toString()));
		retMap.put("gender", CommonUtils.removeLastChar(sbGenderStr.toString()));
		retMap.put("idcardType", CommonUtils.removeLastChar(sbIdcardTypeStr.toString()));
		retMap.put("idcardNo", CommonUtils.removeLastChar(sbIdcardNo.toString()));
		retMap.put("phone", CommonUtils.removeLastChar(sbPhone.toString()));
		retMap.put("address", CommonUtils.removeLastChar(sbAddress.toString()));
		
		
		return retMap;
	}
	
	private Map<String, String> initCustomerMap(ConfirmBook confirmBook){
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		
		
		String customerIds=confirmBook.getCustomerIds();
		String[] customerId=customerIds.split(",");
		StringBuffer sbCustomerName = new StringBuffer();
		StringBuffer sbGenderStr = new StringBuffer();
		StringBuffer sbIdcardTypeStr = new StringBuffer();
		StringBuffer sbIdcardNo = new StringBuffer();
		StringBuffer sbPhone = new StringBuffer();
		StringBuffer sbAddress = new StringBuffer();
		for(int i=0;i<customerId.length;i++){
			conCustomer = contractCustomerServices.findContractCustomerById(Integer.parseInt(customerId[i]));
			sbCustomerName.append(conCustomer.getCustomerName()).append(",");
			sbGenderStr.append(conCustomer.getGenderStr()).append(",");
			sbIdcardTypeStr.append(conCustomer.getIdcardTypeStr()).append(",");
			sbIdcardNo.append(conCustomer.getIdcardNo()).append(",");
			sbPhone.append(conCustomer.getPhone()).append(",");
			sbAddress.append(conCustomer.getAddress()).append(",");
		}
		retMap.put("customerName", CommonUtils.removeLastChar(sbCustomerName.toString()));
		retMap.put("gender", CommonUtils.removeLastChar(sbGenderStr.toString()));
		retMap.put("idcardType", CommonUtils.removeLastChar(sbIdcardTypeStr.toString()));
		retMap.put("idcardNo", CommonUtils.removeLastChar(sbIdcardNo.toString()));
		retMap.put("phone", CommonUtils.removeLastChar(sbPhone.toString()));
		retMap.put("address", CommonUtils.removeLastChar(sbAddress.toString()));
		

		
		return retMap;
	}
	
	
	private String getSaleForConfirm(Confirm confirm){
		
		return confirm.getSalesName();
		
	}
	
	private String getSaleForContract(Contract contract){
		
		return contract.getSalesName();
		
		/*String creater = DescUtils.getUserRealName(contract.getCreatedId());
		String moder = DescUtils.getUserRealName(contract.getModId());
		
		if(creater.equals(moder)){
			
			return creater;
		}else{
			
			return creater + "," + moder;
		}*/
		
	}
	
	///
	
	private AppointCustomer appointCustomer; //预约客户
	private ContractCustomer conCustomer;//--合同认购临定客户
	private int id;//--选择的房间ID
	private String unitState;//--当前房间状态
	
	private Map<String, String> customerMap; //客户map
	private Map<String, String> businessMap; //交易map
	
	public void setBusinessMap(Map<String, String> businessMap) {
		this.businessMap = businessMap;
	}
	
	public Map<String, String> getBusinessMap() {
		return businessMap;
	}
	
	public AppointCustomer getAppointCustomer() {
		return appointCustomer;
	}

	public void setAppointCustomer(AppointCustomer appointCustomer) {
		this.appointCustomer = appointCustomer;
	}

	public Map<String, String> getCustomerMap() {
		return customerMap;
	}

	public void setCustomerMap(Map<String, String> customerMap) {
		this.customerMap = customerMap;
	}

	public ContractCustomer getConCustomer() {
		return conCustomer;
	}

	public void setConCustomer(ContractCustomer conCustomer) {
		this.conCustomer = conCustomer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnitState() {
		return unitState;
	}

	public void setUnitState(String unitState) {
		this.unitState = unitState;
	}
	
}





