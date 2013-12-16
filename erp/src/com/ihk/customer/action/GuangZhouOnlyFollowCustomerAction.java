package com.ihk.customer.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.OnlyFollow;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.customer.data.services.IOnlyFollowServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;

/**
 * 设置客户的查看权限
 * @author dtc
 * 2012-11-29,上午11:23:18
 */
public class GuangZhouOnlyFollowCustomerAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IOnlyFollowServices onlyFollowServices;
	@Autowired
	ICustomerServices customerServices;
	
	/**
	 * 设置
	 * @return
	 * @throws Exception
	 */
	public String onlyFollowCustomers() throws Exception{
		
		final int userId = Integer.parseInt(request.getParameter("copyUserId"));
		
		String copyIds = request.getParameter("copyIds");
		
		final String[] idsStr = copyIds.split("_");
		
		try{
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					OnlyFollow onlyFollow = null;
					
					for(String id : idsStr){
						
						int customerId = Integer.parseInt(id);
						
						//应该判断一下该customer的user_id是否就为传进来的userId,如果是就应该跳过
						Customer tmp = customerServices.getCustomerById(customerId);
						if(tmp == null || tmp.getUserId() == userId)
							continue;
						
						onlyFollow = new OnlyFollow();
						onlyFollow.setUserId(userId);
						onlyFollow.setCustomerId(customerId);
						
						CommonPojoUtils.initPojoCommonFiled(onlyFollow);
						
						onlyFollowServices.addOnlyFollow(onlyFollow);
						
					}
					
					setSuggestion(CommonUtils.SUCCSUGG);
					
				}
			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return "onlyFollowCustomers";
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
