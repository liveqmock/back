package com.ihk.saleunit.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.SaleDaily;
import com.ihk.saleunit.data.services.ISaleDailyServices;
//import com.ihk.utils.SaleDailyUtils;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 录入
 */
public class GuangZhouLogInputAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ISaleDailyServices saleDailyServices; 
	
	private SaleDaily saleDaily;
	
	public void setSaleDaily(SaleDaily saleDaily) {
		this.saleDaily = saleDaily;
	}
	
	public SaleDaily getSaleDaily() {
		return saleDaily;
	}
	
	/**
	 * 执行录入
	 * @return
	 * @throws Exception
	 */
	public String inputLog() throws Exception{
		
		boolean isSucc = true;
		
		try{		
			CommonPojoUtils.initPojoCommonFiled(saleDaily);
			saleDailyServices.addSaleDaily(saleDaily);
			
		}catch(Exception e){
			e.printStackTrace();
			isSucc = false;
		}
		
		if(isSucc){
			
			setSuggestion(CommonUtils.SUCCSUGG);
		}else{
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return "inputLog";
	}
	
	/**
	 * 显示录入界面
	 * @return
	 * @throws Exception
	 */
	public String forInput() throws Exception{
		
		String deleteSession = request.getParameter("deleteSession");
		
		if(!"false".equals(deleteSession)){
			removeSuggestion();
		}
		
		if("token".equals(deleteSession)){
			setSuggestion("重复提交,可能已经录入成功,请查询后再录入");
		}
		
		return "forInput";
	}
		
	
	

}
