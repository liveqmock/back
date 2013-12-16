package com.ihk.mobile.jquery;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContProjectId;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerFollow;
import com.ihk.customer.data.services.ICustomerFollowServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.exception.CustomerException;
import com.ihk.utils.follow.CustomerFollowUtils;

/**
 * 手机客户跟进
 * @author dtc
 * 2013-9-16,下午02:45:39
 */
@SuppressWarnings("rawtypes")
public class MobileCustomerFollowAction extends SupperAction{

	private static final long serialVersionUID = -4256954362570688269L;
	
	@Autowired
	ICodeTypeServices codeTypeServices;
	@Autowired
	ICustomerServices customerServices;
	@Autowired
	ICustomerFollowServices customerFollowServices;

	/**
	 * 跳到跟进客户界面
	 * @return
	 * @throws Exception
	 */
	public String toFollow() throws Exception{
		
		followTypes = codeTypeServices.findCodeListForSel(EnumCodeTypeName.FOLLOW_TYPE, ContProjectId.GUANG_ZHOU);
		
		follows = new ArrayList<CustomerFollow>();
		
		try{
			follows = customerFollowServices.findCustomerFollowByCustomerIdForIndex(customerId);
		}catch(Exception e){
		}
		
		if(!CommonUtils.isCollectionEmpty(follows) && follows.size() > 3){
			follows = follows.subList(0, 3);
		}
		
		return "toFollow";
	}
	
	/**
	 * 增加跟进内容
	 * @return
	 * @throws Exception
	 */
	public String inputCustomerFollow() throws Exception{
		
		boolean isSucc = true;
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					Customer customer = customerServices.getCustomerById(customerFollow.getCustomerId());
					UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
					
					if(customerFollow.getFollowDesc().trim().equals("")){
						failTitle = "跟进内容不能为空";
						throw new CustomerException("跟进内容不能为空");
					}
					customerFollow = CustomerUtils.setCustomerFollowForUserAndOther(customerFollow, user, customer);
					customerFollowServices.addCustomerFollow(customerFollow);
					
					CustomerFollowUtils.modifyCustomerForAddCutomerFollow(customerFollow);
					
				}
			}.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
			
			failTitle = e.getMessage();
			isSucc = false;
		}
		
		return isSucc ? "succ" : "fail";
		
	}
	
	////
	
	/**
	 * 跟进类型
	 */
	private LinkedHashMap followTypes;
	
	/**
	 * 要跟进的客户id
	 */
	private int customerId;
	
	/**
	 * 客户跟进
	 */
	private CustomerFollow customerFollow;
	
	/**
	 * 提示
	 */
	private String failTitle;
	
	/**
	 * 对应客户的历史跟进内容
	 */
	private List<CustomerFollow> follows;
	
	public void setFollows(List<CustomerFollow> follows) {
		this.follows = follows;
	}
	
	public List<CustomerFollow> getFollows() {
		return follows;
	}
	
	public void setFailTitle(String failTitle) {
		this.failTitle = failTitle;
	}
	
	public String getFailTitle() {
		return failTitle;
	}
	
	public void setCustomerFollow(CustomerFollow customerFollow) {
		this.customerFollow = customerFollow;
	}
	
	public CustomerFollow getCustomerFollow() {
		return customerFollow;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setFollowTypes(LinkedHashMap followTypes) {
		this.followTypes = followTypes;
	}
	
	public LinkedHashMap getFollowTypes() {
		return followTypes;
	}
	
}
