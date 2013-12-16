package com.ihk.customer.action;

import java.util.ArrayList;
import java.util.Date;
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
 *  客户跟进action
 */
public class GuangZhouFollowAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICodeTypeServices codeTypeServices;
	@Autowired
	ICustomerFollowServices customerFollowServices;
	@Autowired
	ICustomerServices customerServices;
	
	/**
	 * 获取相关for跟进
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String getSomeForAddFollow() throws Exception{
		//查询相关的数据,供follow使用,如跟进类型等等
		LinkedHashMap followTypes = codeTypeServices.findCodeListForSel(EnumCodeTypeName.FOLLOW_TYPE, ContProjectId.GUANG_ZHOU);
		
		String data = CustomerUtils.getFollowTypeHtml(followTypes);
		
		CustomerUtils.writeResponse(response, data);
		
		return null;
		
	}
	
	@SuppressWarnings("rawtypes")
	public String getSomeForAddIndexFollow() throws Exception{
		//查询相关的数据,供查询页面的follow使用,如跟进类型等等
		LinkedHashMap followTypes = codeTypeServices.findCodeListForSel(EnumCodeTypeName.FOLLOW_TYPE, ContProjectId.GUANG_ZHOU);
		
		String customerId = request.getParameter("customerId");
		
		Customer customer = customerServices.getCustomerById(Integer.parseInt(customerId));
		
		List<CustomerFollow> follows = new ArrayList<CustomerFollow>();
		try{
			follows = customerFollowServices.findCustomerFollowByCustomerIdForIndex(Integer.parseInt(customerId));
		}catch(Exception e){
		}
		
		if(follows.size() > 3){
			follows = follows.subList(0, 3);
		}
		
		String data = CustomerUtils.getFollowTypeHtml(followTypes, follows, customer);
		
		CustomerUtils.writeResponse(response, data);
		
		return null;
		
	}
	
	public String addFollow() throws Exception{
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
					Customer customer = (Customer) request.getSession().getAttribute("c"); //来自GuangZhouUpdateAction line 106
					
					//临时把customerId保存到session中,跳转到queryCustomerById()中再把其删除
					int customerId = customer.getId();
					request.getSession().setAttribute("customerId", customerId);
					
					customerFollow = CustomerUtils.setCustomerFollowForUserAndOther(customerFollow, user, customer);
					customerFollowServices.addCustomerFollow(customerFollow);
					
					CustomerFollowUtils.modifyCustomerForAddCutomerFollow(customerFollow);
					
				}
			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG + ":" + e.getMessage());
		}
		
		return "queryCustomerById";
		
	}
	
	public String addFollowForIndex() throws Exception{
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					String customerId = request.getParameter("customerId");
					Customer customer = customerServices.getCustomerById(Integer.parseInt(customerId));
					UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
					
					if(customerFollow.getFollowDesc().trim().equals("")){
						throw new CustomerException("跟进不能为空");
					}
					customerFollow = CustomerUtils.setCustomerFollowForUserAndOther(customerFollow, user, customer);
					customerFollowServices.addCustomerFollow(customerFollow);
					
					Integer visitCount = customer.getVisitCount();
					if(visitCount == null){
						visitCount = 0;
					}
					
					customer.setVisitCount(visitCount + 1);
					customer.setFollowTime(new Date());  //用于查找页面的条件 "未跟进天数",及列表页"最后跟进日期"
					customerServices.updateCustomerNoCheckNolyFollow(customer);
					
					setSuggestion(CommonUtils.SUCCSUGG);
					
				}
			}.execute();
			
		}catch(CustomerException e){
			setSuggestion("跟进内容不能为空");
		}catch (Exception e) {
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return "addFollowForIndex";
	}
	
	////
	
	private CustomerFollow customerFollow;
	private String suggestion;
	
	public void setCustomerFollow(CustomerFollow customerFollow) {
		this.customerFollow = customerFollow;
	}
	
	public CustomerFollow getCustomerFollow() {
		return customerFollow;
	}
	
	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
		request.getSession().setAttribute("suggestion", suggestion);  //在汇景中跳转后也可以拿到
	}

}
