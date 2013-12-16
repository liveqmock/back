package com.ihk.customer.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;

/**
 *  删除customer
 */
public class GuangZhouDeleteAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICustomerServices customerServices;  //spring的注解,自动引入set,get方法
	
	public String delCustomers() throws Exception{
		String getIdStr = request.getParameter("ids");
		String[] idsStr = getIdStr.split("_");
		
		try{
			for(String idStr : idsStr){
				int id = Integer.parseInt(idStr);
				customerServices.removeCustomer(id); //只是把is_deleted标示为1,表示删除
			}
			setSuggestion(CommonUtils.SUCCSUGG);
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return "deleteCustomer";
	}
	
	
	////////
	
	private String suggestion; //操作提示
	
	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
		request.getSession().setAttribute("suggestion", suggestion);  
	}

}
