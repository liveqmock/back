package com.ihk.saleunit.action;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.saleunit.data.pojo.Appoint;
import com.ihk.saleunit.data.pojo.AppointBill;
import com.ihk.saleunit.data.services.IAppointBillServices;
import com.ihk.saleunit.data.services.IAppointServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 *  新建预约收款单
 */
@SuppressWarnings("rawtypes")
public class GuangZhouAppointBillInputAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAppointBillServices appointBillServices;
	@Autowired
	IAppointServices appointServices;
	
	public String doSomeForInputAppointBill() throws Exception{
		
		appointId = request.getParameter("appointId");
		
		init(appointId);
		
		removeSuggestion();
		
		return "appointBillForInput";
	}
	
	public String inputAppointBill() throws Exception{
		
		try{
			
			CommonPojoUtils.initPojoCommonFiled(appointBill);
			appointBillServices.addAppointBill(appointBill);
			
			appointBillId = appointBill.getId();
			appointId = appointBill.getAppointId() + "";
			
			init(appointId);
			
			setSuggestion(CommonUtils.SUCCSUGG);
			
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		//跳到其对应的修改页面
		return "appointBillInput";
	}
	
	private void init(String appointId){
		
		appoint = appointServices.findAppointById(Integer.parseInt(appointId));
		
		selBillType = DescUtils.getInitSelForGuangZhou(selBillType, EnumCodeTypeName.SALEUNIT_PAPER_TYPE, true);
		
		now = CommonUtils.getNowForString();
		
	}
	
	
	//////
	private AppointBill appointBill;
	private Appoint appoint;
	
	private String appointId;
	
	private LinkedHashMap selBillType;
	
	private int appointBillId; //新增跳到修改页面使用
	
	private String now; //默认的开票日期为当前日期
	
	public void setNow(String now) {
		this.now = now;
	}
	
	public String getNow() {
		return now;
	}
	
	public void setAppointBillId(int appointBillId) {
		this.appointBillId = appointBillId;
	}
	
	public int getAppointBillId() {
		return appointBillId;
	}
	
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
	
	public void setAppointId(String appointId) {
		this.appointId = appointId;
	}
	
	public String getAppointId() {
		return appointId;
	}
	
	public void setAppointBill(AppointBill appointBill) {
		this.appointBill = appointBill;
	}
	
	public AppointBill getAppointBill() {
		return appointBill;
	}
	

}
