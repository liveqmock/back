package com.ihk.saleunit.action.financial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.ApPayment;
import com.ihk.saleunit.data.pojo.ApPaymentCond;
import com.ihk.saleunit.data.services.IApPaymentServices;
import com.ihk.utils.SupperAction;

/**
 * 销售管理的单元实收佣金明细
 * @author dtc
 * 2013-4-1,上午11:50:02
 */
public class ApPaymentAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IApPaymentServices apPaymentServices;
	
	/**
	 * 明细列表
	 * @return
	 * @throws Exception
	 */
	public String apPaymentList() throws Exception{
		
		ApPaymentCond cond = new ApPaymentCond();
		cond.setUnitId(unitId);
		
		apList = apPaymentServices.findApPayment(cond);
		
		return "apPaymentList";
	}
	
	////
	private int unitId;
	
	private List<ApPayment> apList;
	
	public void setApList(List<ApPayment> apList) {
		this.apList = apList;
	}
	
	public List<ApPayment> getApList() {
		return apList;
	}
	
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	
	public int getUnitId() {
		return unitId;
	}

}
