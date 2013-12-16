package com.ihk.customer.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.onlyfollow.CustomerOnlyFollowUtils;

/**
 *  删除customer
 */
public class GuangZhouRecoverAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICustomerServices customerServices;  //spring的注解,自动引入set,get方法
	
	public String recoverCustomers() throws Exception{
		final int userId = Integer.parseInt(request.getParameter("copyUserId"));
		String getIdStr = request.getParameter("copyIds");
		String[] idsStr = getIdStr.split("_");
		
		try{
			for(String idStr : idsStr){
				int id = Integer.parseInt(idStr);
				Customer cus=customerServices.getCustomerById(id);
				cus.setIsDeleted("0");
				CustomerOnlyFollowUtils.isOnlyFollowCustomerById(id);
				customerServices.updateUserIdByCustomerId(userId, id);
				customerServices.updateCustomer(cus); //只是把is_deleted标示为0,表示恢复
			}
			setSuggestion(CommonUtils.SUCCSUGG);
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return "recoverCustomer";
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
