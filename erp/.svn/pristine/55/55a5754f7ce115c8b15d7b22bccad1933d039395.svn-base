package com.ihk.saleunit.action.new_financial;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.services.IUnitPayBillServices;
import com.ihk.saleunit.data.pojo.UnitPayDelay;
import com.ihk.saleunit.data.pojo.UnitPayDelayCond;
import com.ihk.saleunit.data.services.IUnitPayDelayServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 应收款减免延期管理
 */
public class UnitPayDelayAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	@Autowired IUnitPayBillServices  unitPayBillServices;
	@Autowired IUnitPayDelayServices unitPayDelayServices;
	private int billId; //外键
	private UnitPayBill selectBill;
	
	
	public String tabInfo(){
		billId = 1;
		selectBill = unitPayBillServices.findUnitPayBillById(billId);
		UnitPayDelayCond cond = new UnitPayDelayCond();
		cond.setBillId(billId+"");
		try {
			saveUnitPayDelay = unitPayDelayServices.findUnitPayDelay(cond).get(0);
		} catch (Exception e) {
			saveUnitPayDelay = new UnitPayDelay();
		}
		
		return "suc";
	}

	private UnitPayDelay saveUnitPayDelay;
	/**
	 * 相当于bill的额外内容
	 * */
	public String save(){
		if(saveUnitPayDelay.getId() == 0){
			try {
				CommonPojoUtils.initPojoCommonFiled(saveUnitPayDelay);
				unitPayDelayServices.addUnitPayDelay(saveUnitPayDelay);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			UnitPayDelay old = unitPayDelayServices.findUnitPayDelayById(saveUnitPayDelay.getId());
			saveUnitPayDelay.setCreatedId(old.getCreatedId());
			saveUnitPayDelay.setCreatedTime(old.getCreatedTime());
			saveUnitPayDelay.setIsDeleted("0");
			saveUnitPayDelay.setModId(SessionUser.getUserId());
			saveUnitPayDelay.setModTime(new Date());
			saveUnitPayDelay.setBillId(old.getBillId());
			
			unitPayDelayServices.updateUnitPayDelay(saveUnitPayDelay);
		}
		
		return tabInfo();
	}
	
	
	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public UnitPayBill getSelectBill() {
		return selectBill;
	}

	public void setSelectBill(UnitPayBill selectBill) {
		this.selectBill = selectBill;
	}

	public UnitPayDelay getSaveUnitPayDelay() {
		return saveUnitPayDelay;
	}

	public void setSaveUnitPayDelay(UnitPayDelay saveUnitPayDelay) {
		this.saveUnitPayDelay = saveUnitPayDelay;
	}
	
	
	
	
}
