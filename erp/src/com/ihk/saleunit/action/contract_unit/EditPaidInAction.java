package com.ihk.saleunit.action.contract_unit;

import java.math.BigDecimal;

import com.ihk.utils.ActionMethodModifyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.ApPayment;
import com.ihk.saleunit.data.services.IApPaymentServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

public class EditPaidInAction extends SupperAction{

	@Autowired
	IApPaymentServices apPaymentServices;
	ApPayment apPayment;
	
	public ApPayment getApPayment() {
		return apPayment;
	}

	public void setApPayment(ApPayment apPayment) {
		this.apPayment = apPayment;
	}

	//初始化
	public String editPaidIn() throws Exception {
		apPayment = apPaymentServices.findApPaymentById(Integer.parseInt(request.getParameter("id").toString()));
		ActionContext.getContext().getValueStack().set("apPayment",apPayment);
		return SUCCESS;
	}
	
	/**
	 * 编辑
	 * @return
	 * @throws Exception
	 */
	public String updatePaidIn() throws Exception {
		
		/*try{
			
			ApPayment ment = apPaymentServices.findApPaymentById(apPayment.getId());
			//ment.setReceiptdate(CommonUtils.getDateFromString(request.getParameter("dt").toString()));
            ment.setReceiptdate(apPayment.getReceiptdate());
			ment.setRemark(apPayment.getRemark());
			if(apPayment.getAmount() != null)
				ment.setAmount(new BigDecimal(apPayment.getAmount().toString()));
			apPaymentServices.updateApPayment(ment);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;*/

        return new ActionMethodModifyUtils(true) {
        			@Override
        			protected void modifyMethod() throws Exception {
                        ApPayment ment = apPaymentServices.findApPaymentById(apPayment.getId());
                        //ment.setReceiptdate(CommonUtils.getDateFromString(request.getParameter("dt").toString()));
                        ment.setReceiptdate(apPayment.getReceiptdate());
                        ment.setRemark(apPayment.getRemark());
                        if(apPayment.getAmount() != null)
                            ment.setAmount(new BigDecimal(apPayment.getAmount().toString()));
                        apPaymentServices.updateApPayment(ment);

        			}
        		}.doModify(this);
	}

    //删除
    public String deleteApPayment() throws Exception {
        apPaymentServices.deleteApPayment(Integer.parseInt(request.getParameter("id").toString()));
        return SUCCESS;
    }
}
