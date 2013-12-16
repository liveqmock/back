package com.ihk.saleunit.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Appoint;
import com.ihk.saleunit.data.pojo.AppointBill;
import com.ihk.saleunit.data.pojo.AppointBillDetail;
import com.ihk.saleunit.data.pojo.AppointCustomer;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IAppointBillDetailServices;
import com.ihk.saleunit.data.services.IAppointBillServices;
import com.ihk.saleunit.data.services.IAppointCustomerServices;
import com.ihk.saleunit.data.services.IAppointServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.UnitSaleStateUtils;

/**
 *  修改预约排号
 */
public class GuangZhouAppointUpdateAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAppointServices appointServices;
	@Autowired
	IAppointBillServices appointBillServices; 
	@Autowired
	IAppointBillDetailServices appointBillDetailServices; 
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IContractCustomerServices contractCustomerServices;
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IAppointCustomerServices appointCustomerServices;
	
	public String getById() throws Exception{
		
		int appointId = Integer.parseInt(request.getParameter("id"));
		
		initDataToShow(appointId);
		
		String deleteSession = request.getParameter("deleteSession");
		if(!"false".equals(deleteSession)){
			
			removeSuggestion();
		}
		
		return "getById";
	}
	
	public String updateAppoint() throws Exception{
		
		int appointId = appoint.getId();

		try{
			
			Appoint oldAppoint = appointServices.findAppointById(appointId);
			
			//AppointUtils.initOtherForUpdate(oldAppoint, appoint);
			CommonPojoUtils.initPojoForUpdate(oldAppoint, appoint);
			
			appointServices.updateAppoint(appoint);
			setSuggestion(CommonUtils.SUCCSUGG);
			
		}catch(Exception e){
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		initDataToShow(appointId);
		
		return "updateAppoint";
	}
	
	public String deleteAppointBill() throws Exception{
		
		final String billId = request.getParameter("billId");
		appointId = request.getParameter("appointId"); 
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					appointBillServices.deleteAppointBill(Integer.parseInt(billId));
					
					List<AppointBillDetail> detailList = appointBillDetailServices.findDetailByAppointBillId(Integer.parseInt(billId));
					
					if(!CommonUtils.isCollectionEmpty(detailList)){
						
						BigDecimal tmpMal = new BigDecimal(0);
						for(AppointBillDetail detail : detailList){
							
							appointBillDetailServices.deleteAppointBillDetail(detail.getId());
							tmpMal = tmpMal.add(detail.getPayMoney());
							
						}
						
						if(tmpMal.compareTo(new BigDecimal(0)) != 0){
							
							Appoint tmpAppoint = appointServices.findAppointById(Integer.parseInt(appointId));
							tmpAppoint.setRealMoney(tmpAppoint.getRealMoney().subtract(tmpMal));
							
							appointServices.updateAppoint(tmpAppoint);
							
						}
						
					}
					
					setSuggestion(CommonUtils.SUCCSUGG);
					
				}
			}.execute();
			
		}catch(Exception e){
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return "deleteAppointBill";
	}
	
	public String deleteAppointDetail() throws Exception{
		
		final String detailId = request.getParameter("detailId");
		appointId = request.getParameter("appointId");
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					AppointBillDetail tmpDetail = appointBillDetailServices.findAppointBillDetailById(Integer.parseInt(detailId));
					
					BigDecimal tmpMal = tmpDetail.getPayMoney();
					
					if(tmpMal.compareTo(new BigDecimal(0)) != 0){
						
						Appoint tmpAppoint = appointServices.findAppointById(Integer.parseInt(appointId));
						tmpAppoint.setRealMoney(tmpAppoint.getRealMoney().subtract(tmpMal));
						
						appointServices.updateAppoint(tmpAppoint);
						
					}
					
					appointBillDetailServices.deleteAppointBillDetail(Integer.parseInt(detailId));
					
					setSuggestion(CommonUtils.SUCCSUGG);
					
				}
			}.execute();
			
		}catch(Exception e){
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return "deleteAppointDetail";
	}
	
	/**
	 * 预约排号转认购
	 * @return
	 * @throws Exception
	 */
	public String changeToConfirm() throws Exception{
		
		final Map<String, String> map = new HashMap<String, String>();
		boolean isSucc = true;
		
		try{
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					int appointId = Integer.parseInt(request.getParameter("appointId"));
					
					Appoint appoint = appointServices.findAppointById(appointId);
					//避免有人通过地址栏直接进行修改,在该处进行一下判断
					if(appoint == null || !appoint.getCanChangeToConfirm()){
						
						throw new Exception();
					}
					
					int getUnitId = appoint.getUnitId();
					
					PropertyUnit unit = unitServices.findPropertyUnitById(getUnitId);
					
					int appointCustomerId = appoint.getCustomerId();
					AppointCustomer appointCustomer = appointCustomerServices.findAppointCustomerById(appointCustomerId);
					
					ContractCustomer confirmCustomer = new ContractCustomer();
					confirmCustomer.setConfirmType(ContConfirmType.CONFIRM);
					confirmCustomer.setPhone(appointCustomer.getPhone());
					
					confirmCustomer.setCustomerName(appointCustomer.getCustomerName());
					confirmCustomer.setGender(appointCustomer.getGender());
					confirmCustomer.setIdcardType(appointCustomer.getIdcardType());
					confirmCustomer.setIdcardNo(appointCustomer.getIdcardNo());
					
					CommonPojoUtils.initPojoCommonFiled(confirmCustomer);
					
					contractCustomerServices.addContractCustomer(confirmCustomer);
					
					Confirm confirm = new Confirm();
					
					confirm.setCustomerId(confirmCustomer.getId()); //要把客户增加到对应的contract_customer
					confirm.setUnitId(appoint.getUnitId());
					//confirm.setSalesId(appoint.getSalesId());
					confirm.setEndDate(appoint.getEndDate());
					
					if(unit != null){
						//选择了房间
						confirm.setPriceWay(unit.getPriceWay());
						confirm.setBuildPrice(unit.getBuildPrice());
						confirm.setRenovateDesc(unit.getRenovateDesc());
						confirm.setRenovatePrice(unit.getRenovatePrice());
						confirm.setRenovateMoney(unit.getRenovateMoney());
						
						UnitSaleStateUtils.changeSaleState(unitServices, getUnitId, ContUnitSaleState.CONFIRM);
					}
					
					confirm.setPhone(appointCustomer.getPhone());
					
					CommonPojoUtils.initPojoCommonFiled(confirm);
					
					confirmServices.addConfirm(confirm);
					
					appointServices.updateAppointSetConfirmId(appointId, confirm.getId());
					
					map.put("id", confirm.getId()+"");
					
				}
			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			isSucc = false;
		}
		
		map.put("type", isSucc+"");
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
	
	/**
	 *  初始化页面要显示的数据
	 */
	private void initDataToShow(int appointId){
		
		appoint = appointServices.findAppointById(appointId);
		appointBillList = appointBillServices.findAppointBillByAppointId(appointId);
		if(detailList == null){
			detailList = new ArrayList<AppointBillDetail>();
		}
		
		for(AppointBill bill : appointBillList){
			
			try{
				
				List<AppointBillDetail> tmpDetialList = appointBillDetailServices.findDetailByAppointBillId(bill.getId());
				if(!CommonUtils.isCollectionEmpty(tmpDetialList)){
					
					detailList.addAll(tmpDetialList);
				}
				
			}catch(Exception e){
			}
			 
		}
		
	}
	
	
	////////////
	
	private Appoint appoint;
	private List<AppointBill> appointBillList;
	
	private List<AppointBillDetail> detailList;
	
	private String appointId; //删除跳转作用
	
	public void setAppointId(String appointId) {
		this.appointId = appointId;
	}
	
	public String getAppointId() {
		return appointId;
	}
	
	public void setDetailList(List<AppointBillDetail> detailList) {
		this.detailList = detailList;
	}
	
	public List<AppointBillDetail> getDetailList() {
		return detailList;
	}
	
	public void setAppointBillList(List<AppointBill> appointBillList) {
		this.appointBillList = appointBillList;
	}
	
	public List<AppointBill> getAppointBillList() {
		return appointBillList;
	}
	
	public void setAppoint(Appoint appoint) {
		this.appoint = appoint;
	}
	
	public Appoint getAppoint() {
		return appoint;
	}
	

}
