package com.ihk.customer.action.easyui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.OnlyFollow;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.customer.data.services.IOnlyFollowServices;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.method.ActionAjaxMethodModifyNoThrowsExceptionCallback;

/**
 * 基于easyui的客源设置
 * @author dtc
 * 2013-7-16,下午05:09:17
 */
public class OnlyFollowCustomerEasyUIAction extends SupperAction{

	private static final long serialVersionUID = 9131092431854678037L;
	
	@Autowired
	IOnlyFollowServices onlyFollowServices;
	@Autowired
	IUserAccountServices userAccountServices;
	@Autowired
	ICustomerServices customerServices;
	
	/**
	 * 跳到客源设置页面
	 * @return
	 * @throws Exception
	 */
	public String toSetUpOnlyFollow() throws Exception{
		
		customerIds = request.getParameter("ids");
		List<Integer> ids = CommonUtils.stringToList(customerIds, "_");
		
		if(CommonUtils.isCollectionEmpty(ids)){
			
			return "toSetUpOnlyFollow";
		}
		
		showList = new HashMap<Customer, List<OnlyFollow>>();
		
		for(int id : ids){
			
			if(id <= 0){
				continue;
			}
			
			List<OnlyFollow> followList = onlyFollowServices.findOnlyFollowByCustomerId(id);
			
			showList.put(customerServices.getCustomerById(id), followList);
		}
		
		return "toSetUpOnlyFollow";
	}
	
	/**
	 * 客源设置
	 * @return
	 * @throws Exception
	 */
	public String setUpOnlyFollow() throws Exception{
		
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyNoThrowsExceptionCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				int userId = Integer.parseInt(request.getParameter("copyUserId"));
				
				String[] idsStr = customerIds.split("_");
				
				OnlyFollow onlyFollow = null;
				
				for(String id : idsStr){
					
					int customerId = Integer.parseInt(id);
					
					//应该判断一下该customer的user_id是否就为传进来的userId,如果是就应该跳过
					Customer tmp = customerServices.getCustomerById(customerId);
					if(tmp == null || tmp.getUserId() == userId)
						continue;
					
					//判断该UserAccount是否已经拥有对应customerId的查看,有就跳过
					if(isExists(userId, customerId))
						continue;
					
					onlyFollow = new OnlyFollow();
					onlyFollow.setUserId(userId);
					onlyFollow.setCustomerId(customerId);
					
					CommonPojoUtils.initPojoCommonFiled(onlyFollow);
					
					onlyFollowServices.addOnlyFollow(onlyFollow);
					
				}
				
			}
		});
		
		return null;
	}
	
	/**
	 * 删除一条onlyFollow
	 * @return
	 * @throws Exception
	 */
	public String deleteOnlyFollow() throws Exception{
		
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyNoThrowsExceptionCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				onlyFollowServices.deleteOnlyFollow(Integer.parseInt(request.getParameter("id")));
				
			}
		});
		
		return null;
	}
	
	/**
	 * 根据用户id及客户id,判断在onlyFollow中是否存在
	 * @param userId
	 * @param customerId
	 * @return
	 */
	private boolean isExists(int userId, int customerId){
		
		List<OnlyFollow> list = onlyFollowServices.findOnlyFollowByUserIdAndCustomerId(userId, customerId);
		if(CommonUtils.isCollectionEmpty(list)){
			
			return false;
		}
		
		return true;
	}
	
	/**
	 * 根据followList返回UserAccount list
	 * @param followList
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<UserAccount> onlyFollowListToUserAccountList(List<OnlyFollow> followList){
		
		List<UserAccount> retList = new ArrayList<UserAccount>();
		
		if(CommonUtils.isCollectionEmpty(followList)){
			
			return retList;
		}
		
		for(OnlyFollow follow : followList){
			
			retList.add(userAccountServices.findUserAccountById(follow.getUserId()));
		}
		
		return retList;
	}
	                                                        
	
	////
	
	/**
	 * 客户id对应的销售list
	 */
	private Map<Customer, List<OnlyFollow>> showList;
	
	/**
	 * 选择的客户
	 */
	private String customerIds;
	
	public void setCustomerIds(String customerIds) {
		this.customerIds = customerIds;
	}
	
	public String getCustomerIds() {
		return customerIds;
	}
	
	public void setShowList(Map<Customer, List<OnlyFollow>> showList) {
		this.showList = showList;
	}
	
	public Map<Customer, List<OnlyFollow>> getShowList() {
		return showList;
	}

}
