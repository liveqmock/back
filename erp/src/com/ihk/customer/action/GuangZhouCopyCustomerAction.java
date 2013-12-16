package com.ihk.customer.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.onlyfollow.CustomerOnlyFollowUtils;

/**
 * 复制or转移客户
 * @author dtc
 * 2012-9-25
 */
public class GuangZhouCopyCustomerAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	ICustomerServices customerServices;
	
	/**
	 * 复制客户==>转移客户(只是把customer的userId改变)
	 * @return
	 * @throws Exception
	 */
	public String copyCustomers() throws Exception{
		
		final int userId = Integer.parseInt(request.getParameter("copyUserId"));
		
		String copyIds = request.getParameter("copyIds");
		
		final String[] idsStr = copyIds.split("_");
		
		try{
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					for(String id : idsStr){
						
						int customerId = Integer.parseInt(id);
						
						CustomerOnlyFollowUtils.isOnlyFollowCustomerById(customerId);
						
						customerServices.updateUserIdByCustomerId(userId, customerId);
					}
					
					setSuggestion(CommonUtils.SUCCSUGG);
					
				}
			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG + ":" + e.getMessage());
		}
		
		return "copyCustomer";
	}
	
	////////////
	
	private String suggestion; //操作提示
	
	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
		request.getSession().setAttribute("suggestion", suggestion);  
	}

}
