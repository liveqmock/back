package com.ihk.saleunit.action.new_;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.pojo.UnitPayBillDetail;
import com.ihk.property.data.services.IUnitPayBillDetailServices;
import com.ihk.property.data.services.IUnitPayBillServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 根据unit_pay_bill 去付款
 * 相关详细单据unit_pay_bill_detail
 * */
public class GuangzhouAppointPayForUnitAction extends SupperAction{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired IUnitPayBillServices iUnitPayBillServices;
	@Autowired IUnitPayBillDetailServices iUnitPayBillDetailServices;
	
	private int payId;
	private BigDecimal payMoney;
	private UnitPayBill unitPayBill;
	
	/**
	 * 初始化付款页面
	 * */
	public String payForUnit(){
		unitPayBill = iUnitPayBillServices.findUnitPayBillById(payId);
		return "pay_for_unit";
	}
	
	/**
	 * 付款页面提交数据
	 * */
	public String payForUnitForm(){
		unitPayBill = iUnitPayBillServices.findUnitPayBillById(payId);
		UnitPayBillDetail ud = new UnitPayBillDetail();
		ud.setBillId(unitPayBill.getId());
		ud.setPayMoney(payMoney);
		ud.setPayMan(SessionUser.getUserId());
		ud.setPayDate(new Date());
		
		ud.setIsDeleted("0");
		ud.setCreatedId(SessionUser.getUserId());
		ud.setCreatedTime(ud.getPayDate());
		ud.setModId(SessionUser.getUserId());
		ud.setModTime(ud.getPayDate());
		
		iUnitPayBillDetailServices.addUnitPayBillDetail(ud);
		unitPayBill = iUnitPayBillServices.findUnitPayBillById(payId);
		return "pay_form";
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public UnitPayBill getUnitPayBill() {
		return unitPayBill;
	}

	public void setUnitPayBill(UnitPayBill unitPayBill) {
		this.unitPayBill = unitPayBill;
	}
	
}


















