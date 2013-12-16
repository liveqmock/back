package com.ihk.saleunit.action;

import java.util.LinkedHashMap;
import java.util.List;

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
import com.ihk.utils.SupperAction;

/**
 *  更新预约收款单
 */
@SuppressWarnings("rawtypes")
public class GuangZhouAppointBillUpdateAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAppointBillServices appointBillServices;
	@Autowired
	IAppointBillDetailServices detailServices;
	@Autowired
	IAppointServices appointServices;
	
	public String getById() throws Exception{
		
		int appointBillId = Integer.parseInt(request.getParameter("appointBillId"));
		
		appointBill = appointBillServices.findAppointBillById(appointBillId);
		appoint = appointServices.findAppointById(appointBill.getAppointId());
		detailList = detailServices.findDetailByAppointBillId(appointBillId);
		
		String deleteSession = request.getParameter("deleteSession");
		if(!"false".equals(deleteSession)){
			
			removeSuggestion();
		}
		
		init();
		
		return "getById";
	}
	
	public String updateAppointBill() throws Exception{
		
		int appointBillId = appointBill.getId();
		
		try{
			
			AppointBill oldAppointBill = appointBillServices.findAppointBillById(appointBillId);
			
			CommonPojoUtils.initPojoForUpdate(oldAppointBill, appointBill);
			
			appointBillServices.updateAppointBill(appointBill);
			
			appoint = appointServices.findAppointById(appointBill.getAppointId());
			setSuggestion(CommonUtils.SUCCSUGG);
			
		}catch(Exception e){
			e.printStackTrace();
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		appointBill = appointBillServices.findAppointBillById(appointBillId);
		detailList = detailServices.findDetailByAppointBillId(appointBillId);
		
		init();
		
		return "updateAppointBill";
	}
	
	private void init(){
		
		selBillType = DescUtils.getInitSelForGuangZhou(selBillType, EnumCodeTypeName.SALEUNIT_PAPER_TYPE, true);
		
	}
	
	
	/////
	private AppointBill appointBill;
	private List<AppointBillDetail> detailList;
	private Appoint appoint;
	
	private LinkedHashMap selBillType;
	
	public void setSelBillType(LinkedHashMap selBillType) {
		this.selBillType = selBillType;
	}
	
	public LinkedHashMap getSelBillType() {
		return selBillType;
	}
	
	public void setAppoint(Appoint appoint) {
		this.appoint = appoint;
	}
	
	public Appoint getAppoint() {
		return appoint;
	}
	
	public void setDetailList(List<AppointBillDetail> detailList) {
		this.detailList = detailList;
	}
	
	public List<AppointBillDetail> getDetailList() {
		return detailList;
	}
	
	public void setAppointBill(AppointBill appointBill) {
		this.appointBill = appointBill;
	}
	
	public AppointBill getAppointBill() {
		return appointBill;
	}

}
