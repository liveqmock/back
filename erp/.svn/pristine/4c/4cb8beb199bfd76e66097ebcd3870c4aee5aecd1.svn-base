package com.ihk.saleunit.action.contract_unit;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.ApPayment;
import com.ihk.saleunit.data.pojo.ArAmount;
import com.ihk.saleunit.data.services.IArAmountServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

public class EditReceiveInAction extends SupperAction{

	@Autowired
	IArAmountServices arAmountServices;
	ArAmount arAmount;
	
	public ArAmount getArAmount() {
		return arAmount;
	}

	public void setArAmount(ArAmount arAmount) {
		this.arAmount = arAmount;
	}

	/**
	 * 编辑框初始化
	 * @return
	 * @throws Exception
	 */
	public String editReceiveIn() throws Exception {
		arAmount = arAmountServices.findArAmountById(Integer.parseInt(request.getParameter("id").toString()));
		ActionContext.getContext().getValueStack().set("arAmount",arAmount);
		return SUCCESS;
	}
	
	/**
	 * 应收管理 修改
	 * @return
	 * @throws Exception
	 */
	public String updateReceiveIn() throws Exception {
		try{
			ArAmount arAm = arAmountServices.findArAmountById(arAmount.getId());
			/*if(request.getParameter("dt") != null)
				arAm.setArDate(CommonUtils.getDateFromString(request.getParameter("dt").toString()));*/
			arAm.setRemark(arAmount.getRemark());
			if(arAmount.getAmount() != null)
				arAm.setAmount(new BigDecimal(arAmount.getAmount().toString()));
			arAmountServices.updateArAmount(arAm);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	//删除
	public String deleteReceiveIn() throws Exception {
		arAmountServices.deleteArAmount(Integer.parseInt(request.getParameter("id").toString()));
		return SUCCESS;
	}
}
