package com.ihk.saleunit.action;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.saleunit.data.pojo.Appoint;
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
 *  修改预约收款单明细
 */
@SuppressWarnings("rawtypes")
public class GuangZhouAppointBillDetailUpdateAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAppointBillServices appointBillServices;
	@Autowired
	IAppointBillDetailServices detailServices;
	@Autowired
	IAppointServices appointServices;
	
	public String getById() throws Exception{
		
		int detailId = Integer.parseInt(request.getParameter("detailId"));
		
		detail = detailServices.findAppointBillDetailById(detailId);
		initData();
		
		removeSuggestion();
		
		return "getById";
	}
	
	public String updateAppointBillDetail() throws Exception{
		
		final int detailId = detail.getId();
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					AppointBillDetail oldDetail = detailServices.findAppointBillDetailById(detailId);
					
					CommonPojoUtils.initPojoForUpdate(oldDetail, detail);
					detail.setBillId(oldDetail.getBillId());
					
					detailServices.updateAppointBillDetail(detail);
					
					if(detail.getPayMoney().compareTo(oldDetail.getPayMoney()) != 0){
						//表示修改了金额
						
						appoint = appointServices.findAppointByDetailId(detailId);
						appoint.setRealMoney(appoint.getRealMoney().add(detail.getPayMoney()).subtract(oldDetail.getPayMoney()));
						appointServices.updateAppoint(appoint);
					}
					
					setSuggestion(CommonUtils.SUCCSUGG);
					
				}
			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		detail = detailServices.findAppointBillDetailById(detailId);
		
		initData();
		
		return "updateAppointBillDetail";
	}
	
	private void initData(){
		
		int billId = detail.getBillId();
		int appointId = appointBillServices.findAppointBillById(billId).getAppointId();
		appoint = appointServices.findAppointById(appointId);
		
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType, EnumCodeTypeName.SALEUNIT_PAY_TYPE, true);
		selPayWay = DescUtils.getInitSelForGuangZhou(selPayWay, EnumCodeTypeName.SALEUNIT_PAY_WAY, true);
		selBankWay = DescUtils.getInitSelForGuangZhou(selBankWay, EnumCodeTypeName.SALEUNIT_BANK_WAY, true);
		
	}
	
	/////////
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

}
