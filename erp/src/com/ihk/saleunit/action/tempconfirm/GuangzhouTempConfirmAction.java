package com.ihk.saleunit.action.tempconfirm;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Chip;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IChipServices;
import com.ihk.saleunit.data.services.IConfirmBookServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.exception.UnitChangeException;
import com.ihk.utils.saleunit.PayWayUtils;
import com.ihk.utils.saleunit.UnitSaleStateUtils;

/**
 * 临定
 * @author dtc
 * 2012-8-2
 */
public class GuangzhouTempConfirmAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IContractCustomerServices contractCustomerServices;
	@Autowired
	IConfirmBookServices confirmBookServices;
	@Autowired
	IChipServices chipServices;
	
	public String createTempConfirmDialog() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		
		init(unitId); 
		
		removeSuggestion();
		
		return "createTempConfirmDialog";
	}
	
	public String saveTempConfirmDialog() throws Exception{
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					unit = unitServices.findPropertyUnitById(confirmBook.getUnitId());
					
					//增加之前应该判断该单元是否可以临定
					/*boolean isCanChange = UnitChangeUtils.isCanChange(ContUnitChangeTypeFrom.CONFIRM, unit);
					if(!isCanChange)
						throw new UnitChangeException("该单元不能认购");*/
					
					//修改房间的状态
					UnitSaleStateUtils.changeSaleState(unitServices, confirmBook.getUnitId(), ContUnitSaleState.CONFIRM_BOOK);
					
					//增加临定客户or修改认筹客户
					addOrChangeTempConfrimCustomer();
					
					//增加单元付款单unit_pay_bill
					//FinancialUtils.addUnitPayBillByPayWayIdAndUnitId(confirmBook.getPayWayId(), confirmBook.getUnitId(),confirmBook);
					
					//增加临定
					confirmBook.setPhone(confirmCustomer.getPhone());
					confirmBook.setCustomerId(confirmCustomer.getId());
					CommonPojoUtils.initPojoCommonFiled(confirmBook);
					confirmBookServices.addConfirmBook(confirmBook);
					
					setSuggestion(CommonUtils.SUCCSUGG);
					
					setUpMarkToClose();
					
				}
			}.execute();
			
		}catch (UnitChangeException e) {
			
			setSuggestion(e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		init(confirmBook.getUnitId());
			
		return "saveTempConfirmDialog";
	}
	
	/**
	 * 判断新增临定的时候,客户为新增还是从认筹过来的
	 * @throws Exception
	 */
	private void addOrChangeTempConfrimCustomer() throws Exception{
		
		int customerId = confirmCustomer.getId();
		
		//表示选择了认筹客户,(但还要根据姓名判断是否对该认筹客户进行了修改??)
		if(customerId > 0){
			
			contractCustomerServices.updateContractCustomerConfirmType(customerId, ContConfirmType.CONFIRM_BOOK);
			
		}else{
			
			CommonPojoUtils.initPojoCommonFiled(confirmCustomer);
			contractCustomerServices.addContractCustomer(confirmCustomer);
		}
		
	}
	
	public String showTempConfirmDialog() throws Exception{
		
		int tempConfirmId = Integer.parseInt(request.getParameter("tempConfirmId"));
		
		confirmBook =  confirmBookServices.findConfirmBookById(tempConfirmId);
		confirmCustomer = contractCustomerServices.findContractCustomerById(confirmBook.getCustomerId());
		
		init(confirmBook.getUnitId());
		
		removeSuggestion();
		
		return "showTempConfirmDialog";
	}
	
	public String updateTempConfirmDialog() throws Exception{
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
				 	ContractCustomer oldConfirmCustomer = contractCustomerServices.findContractCustomerById(confirmCustomer.getId());
				 	CommonPojoUtils.initPojoForUpdate(oldConfirmCustomer, confirmCustomer);
				 	
				 	ConfirmBook oldConfirmBook = confirmBookServices.findConfirmBookById(confirmBook.getId());
				 	CommonPojoUtils.initPojoForUpdate(oldConfirmBook, confirmBook);
				 	
				 	contractCustomerServices.updateContractCustomer(confirmCustomer);
				 	confirmBookServices.updateConfirmBook(confirmBook);
					
				 	setSuggestion(CommonUtils.SUCCSUGG);
				 	
				 	setUpMarkToClose();
					
				}
			}.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		init(confirmBook.getUnitId());
		
		return "updateTempConfirmDialog";
	}
	
	/**
	 * 初始化,包括confirmType, 对应的单元, 付款方式, 认筹情况
	 * @param unitId
	 */
	private void init(int unitId){
		
		confirmType = ContConfirmType.CONFIRM_BOOK;
		
		unit = unitServices.findPropertyUnitById(unitId);
		selPayType = PayWayUtils.getSelPayWayByUnitId(unitId);
		
		initSelChipCustomer(unitId);
		
	}
	
	private void initSelChipCustomer(int unitId){
		
		selChipCustomer = new LinkedHashMap<String, String>();
		selChipCustomer.put("", CommonUtils.EMPTY);
		
		for(int chipNo=1; chipNo<=3; chipNo++){
			
			List<Chip> chipList = chipServices.findChipByUnitIdAndChipNo(unitId, chipNo);
			
			if(!CommonUtils.isCollectionEmpty(chipList)){
				
				int size = chipList.size();
				for(int i=0; i<size; i++){
					
					Chip tmpChip = chipList.get(i);
					
					ContractCustomer chipCustomer = tmpChip.getCustomer();
					if(chipCustomer != null){
						
						selChipCustomer.put(tmpChip.getId()+"", tmpChip.getChipNo() + "," + chipCustomer.getCustomerName());
					}
					
				}
				
			}
			
		}
		
	}
	
	////
	
	private ConfirmBook confirmBook;
	
	private LinkedHashMap<String, String> selPayType; //付款方式(根据楼栋,从表pay_way中获取)
	
	private PropertyUnit unit;
	
	private String confirmType;
	
	private ContractCustomer confirmCustomer;
	
	private LinkedHashMap<String, String> selChipCustomer; //认筹单号+客户姓名
	
	public void setSelChipCustomer(LinkedHashMap<String, String> selChipCustomer) {
		this.selChipCustomer = selChipCustomer;
	}
	
	public LinkedHashMap<String, String> getSelChipCustomer() {
		return selChipCustomer;
	}
	
	public void setConfirmCustomer(ContractCustomer confirmCustomer) {
		this.confirmCustomer = confirmCustomer;
	}
	
	public ContractCustomer getConfirmCustomer() {
		return confirmCustomer;
	}
	
	public void setSelPayType(LinkedHashMap<String, String> selPayType) {
		this.selPayType = selPayType;
	}
	
	public LinkedHashMap<String, String> getSelPayType() {
		return selPayType;
	}
	
	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
	
	public String getConfirmType() {
		return confirmType;
	}
	
	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}
	
	public PropertyUnit getUnit() {
		return unit;
	}
	
	public void setConfirmBook(ConfirmBook confirmBook) {
		this.confirmBook = confirmBook;
	}
	
	public ConfirmBook getConfirmBook() {
		return confirmBook;
	}

}
