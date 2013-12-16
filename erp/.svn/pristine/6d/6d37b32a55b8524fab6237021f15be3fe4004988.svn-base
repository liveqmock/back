package com.ihk.saleunit.action.confirm;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.PayDetail;
import com.ihk.saleunit.data.pojo.PayDetailCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IPayDetailServices;
import com.ihk.utils.ActionPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;

/**
 *  付款明细
 */
@SuppressWarnings("rawtypes")
public class GuangZhouPayDetailAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPayDetailServices payDetailServices;
	@Autowired
	IConfirmServices confirmServices;
	
	public String search() throws Exception{
		
		int confirmId = Integer.parseInt(request.getParameter("confirmId"));
		confirm = confirmServices.findConfirmById(confirmId);
		
		final PayDetailCond cond = new PayDetailCond();
		cond.setConfirmType(ContConfirmType.CONFIRM);
		cond.setMainId(confirmId + "");
		
		ActionTemplate actionTemplate = new ActionTemplate(this, cond);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				payDetailList = payDetailServices.findPayDetail(cond);
				
			}
		});
		
		removeSuggestion();
		
		return "search";
	}
	
	public String forInput() throws Exception{
		
		int confirmId = Integer.parseInt(request.getParameter("confirmId"));
		initData(confirmId);
		
		removeSuggestion();
		
		return "forInput";
	}
	
	public String input() throws Exception{
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					Integer maxOrderIndex = payDetailServices.findPayDetailMaxOrderIndex();
					if(maxOrderIndex == null){
						maxOrderIndex = 0;
					}
					
					payDetail.setOrderIndex(maxOrderIndex + 1);
					payDetail.setConfirmType(ContConfirmType.CONFIRM);
					payDetail.setIsPay(CommonUtils.TRUE_STR);
					CommonPojoUtils.initPojoCommonFiled(payDetail);
					
					payDetailServices.addPayDetail(payDetail);
					
					setSuggestion(CommonUtils.SUCCSUGG);
					
				}
			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		initData(payDetail.getMainId());
		
		return "input";
	}
	
	public String getId() throws Exception {
		
		int payDetailId = Integer.parseInt(request.getParameter("payDetailId"));
		
		payDetail = payDetailServices.findPayDetailById(payDetailId);
		
		initData(payDetail.getMainId());
		
		removeSuggestion();
		
		return "getId";
	}
	
	public String update() throws Exception{
		
		PayDetail oldPayDetail = payDetailServices.findPayDetailById(payDetail.getId());
		
		CommonPojoUtils.initPojoForUpdate(oldPayDetail, payDetail);
		payDetail.setIsPay(oldPayDetail.getIsPay());
		payDetail.setConfirmType(oldPayDetail.getConfirmType());
		payDetail.setMainId(oldPayDetail.getMainId());
		payDetail.setOrderIndex(oldPayDetail.getOrderIndex());
		
		try{
			
			payDetailServices.updatePayDetail(payDetail);
			
			setSuggestion(CommonUtils.SUCCSUGG);
		}catch(Exception e){
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		payDetail = payDetailServices.findPayDetailById(oldPayDetail.getId());
		initData(payDetail.getMainId());
		
		return "update";
	}
	
	private void initData(int confirmId){
		
		confirm = confirmServices.findConfirmById(confirmId);
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType, EnumCodeTypeName.SALEUNIT_PAY_TYPE, true);
		
	}
	
	
	///
	private Confirm confirm;
	private List<PayDetail> payDetailList;
	private PayDetail payDetail;
	
	private LinkedHashMap selPayType; //款项类型
	
	public void setSelPayType(LinkedHashMap selPayType) {
		this.selPayType = selPayType;
	}
	
	public LinkedHashMap getSelPayType() {
		return selPayType;
	}
	
	public void setPayDetail(PayDetail payDetail) {
		this.payDetail = payDetail;
	}
	
	public PayDetail getPayDetail() {
		return payDetail;
	}
	
	public void setPayDetailList(List<PayDetail> payDetailList) {
		this.payDetailList = payDetailList;
	}
	
	public List<PayDetail> getPayDetailList() {
		return payDetailList;
	}
	
	public void setConfirm(Confirm confirm) {
		this.confirm = confirm;
	}
	
	public Confirm getConfirm() {
		return confirm;
	}

}
