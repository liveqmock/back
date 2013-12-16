package com.ihk.saleunit.action;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.saleunit.data.pojo.Appoint;
import com.ihk.saleunit.data.pojo.AppointBill;
import com.ihk.saleunit.data.pojo.AppointBillDetail;
import com.ihk.saleunit.data.services.IAppointBillDetailServices;
import com.ihk.saleunit.data.services.IAppointBillServices;
import com.ihk.saleunit.data.services.IAppointServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;

/**
 *  新建预约收款单明细
 */
@SuppressWarnings("rawtypes")
public class GuangZhouAppointBillDetailInputAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAppointBillServices appointBillServices; 
	@Autowired
	IAppointBillDetailServices detailServices;
	@Autowired
	IAppointServices appointServices;
	
	public String doSomeForInputAppointBillDetail() throws Exception{
		
		int appointBillId = Integer.parseInt(request.getParameter("appointBillId"));
		
		appointBill = appointBillServices.findAppointBillById(appointBillId);
		appoint = appointServices.findAppointById(appointBill.getAppointId());
		
		removeSuggestion();
		
		initData();
		
		return "appointBillDetailForInput";
	}
	
	public String inputAppointBillDetail() throws Exception{
		
		try{
			
			new MyTransationTemplate() {

				@Override
				protected void doExecuteCallback() throws Exception {
					
					CommonPojoUtils.initPojoCommonFiled(detail);
					detailServices.addAppointBillDetail(detail);
					
					appointBill = appointBillServices.findAppointBillById(detail.getBillId());
					
					//要把对应的金额保存到appoint中的real_money(实收预约金)
					//appoint = appointServices.findAppointByDetailId(detail.getId());
					
					appoint = appointServices.findAppointById(appointBill.getAppointId());
					appoint.setRealMoney(appoint.getRealMoney().add(detail.getPayMoney()));
					appointServices.updateAppoint(appoint);
					
					appoint = appointServices.findAppointById(appoint.getId());
					
					setSuggestion(CommonUtils.SUCCSUGG);
					
				}
				
			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		initData();
		
		return "inputAppointBillDetail";
	}
	
	private void initData(){
		
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType, EnumCodeTypeName.SALEUNIT_PAY_TYPE, true);
		selPayWay = DescUtils.getInitSelForGuangZhou(selPayWay, EnumCodeTypeName.SALEUNIT_PAY_WAY, true);
		selBankWay = DescUtils.getInitSelForGuangZhou(selBankWay, EnumCodeTypeName.SALEUNIT_BANK_WAY, true);
		
	}
	
	////////
	
	private AppointBill appointBill;
	private AppointBillDetail detail;
	private Appoint appoint;
	
	private LinkedHashMap selPayType; //款项类型
	private LinkedHashMap selPayWay; //支付方式
	private LinkedHashMap selBankWay; //银付方式
	
	public LinkedHashMap getSelPayType() {
		return selPayType;
	}

	public void setSelPayType(LinkedHashMap selPayType) {
		this.selPayType = selPayType;
	}

	public LinkedHashMap getSelPayWay() {
		return selPayWay;
	}

	public void setSelPayWay(LinkedHashMap selPayWay) {
		this.selPayWay = selPayWay;
	}

	public LinkedHashMap getSelBankWay() {
		return selBankWay;
	}

	public void setSelBankWay(LinkedHashMap selBankWay) {
		this.selBankWay = selBankWay;
	}
	
	public void setAppoint(Appoint appoint) {
		this.appoint = appoint;
	}
	
	public Appoint getAppoint() {
		return appoint;
	}
	
	public void setDetail(AppointBillDetail detail) {
		this.detail = detail;
	}
	
	public AppointBillDetail getDetail() {
		return detail;
	}
	
	public void setAppointBill(AppointBill appointBill) {
		this.appointBill = appointBill;
	}
	
	public AppointBill getAppointBill() {
		return appointBill;
	}

}
