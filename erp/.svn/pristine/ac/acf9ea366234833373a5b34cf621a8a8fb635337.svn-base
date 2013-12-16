package com.ihk.saleunit.action.new_;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.pojo.UnitPayBillCond;
import com.ihk.property.data.services.IUnitPayBillServices;
import com.ihk.utils.SupperAction;


/**
 * 付款信息
 * 表: unit_pay_bill 和 unit_pay_bill_detail
 * JSP: /crm/WebRoot/saleunit_new/guangzhou/pay_info.jsp
 * 
 */
public class GuangZhouAppointNewUnitPayBillAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	
	@Autowired IUnitPayBillServices iUnitPayBillServices;
	
	private List<UnitPayBill> unitPayBillList ;
	
	private int id;
	
	
	public String unitPayInfo(){
		this.init();
		return "unit_pay_info";
	}
	
	private void init(){
		if(id == 0){
			return;
		}
		
		UnitPayBillCond cond = new UnitPayBillCond();
		cond.setUnitId(id+"");
		unitPayBillList = iUnitPayBillServices.findUnitPayBill(cond);
		
	}

	public List<UnitPayBill> getUnitPayBillList() {
		return unitPayBillList;
	}

	public void setUnitPayBillList(List<UnitPayBill> unitPayBillList) {
		this.unitPayBillList = unitPayBillList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<UnitPayBill> getUnitPayBillList1() {
		List<UnitPayBill> unitPayBillList1 = new ArrayList<UnitPayBill>();
		for(UnitPayBill uu :  unitPayBillList){
			if(uu.getPayType().equals("1"))
				unitPayBillList1.add(uu);
		}
		return unitPayBillList1;
	} 
	public List<UnitPayBill> getUnitPayBillList2() {
		List<UnitPayBill> unitPayBillList1 = new ArrayList<UnitPayBill>();
		for(UnitPayBill uu :  unitPayBillList){
			if(uu.getPayType().equals("2"))
				unitPayBillList1.add(uu);
		}
		return unitPayBillList1;
	} 
	public List<UnitPayBill> getUnitPayBillList3() {
		List<UnitPayBill> unitPayBillList1 = new ArrayList<UnitPayBill>();
		for(UnitPayBill uu :  unitPayBillList){
			if(uu.getPayType().equals("3"))
				unitPayBillList1.add(uu);
		}
		return unitPayBillList1;
	} 
	
	public UnitPayBill getUnitPaySum() {
		UnitPayBill sum = new UnitPayBill();
		sum.setShouldPay(new BigDecimal(0));
		sum.setNotPay(new BigDecimal(0));
		sum.setHadPay(new BigDecimal(0));
		sum.setShouldPay(new BigDecimal(0));
		for(UnitPayBill uu :  unitPayBillList){
			sum.setShouldPay(uu.getShouldPay().add(sum.getShouldPay()));
			sum.setNotPay(uu.getNotPay().add(sum.getNotPay()));
			sum.setHadPay(uu.getHadPay().add(sum.getHadPay()));
		}
		return sum;
	}
}
