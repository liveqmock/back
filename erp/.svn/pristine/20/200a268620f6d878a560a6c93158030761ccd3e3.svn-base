package com.ihk.customer.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.exception.CustomerException;

/**
 *  判断电话是否存在
 */
public class PhoneAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Deprecated
	public String findPhoneIsExists() throws Exception{
		String phone = request.getParameter("phone");
		int userId = SessionUser.getUserId();
		
		List<Customer> list = DescUtils.findPhoneIsExistsByUserId(phone, userId);
		
		if(list == null || list.isEmpty()){
			//不存在
			
			CustomerUtils.writeResponse(response, "0");
		}else{
			
			int customerId = list.get(0).getId();
			CustomerUtils.writeResponse(response, customerId + "");
		}
		
		return null;
	}
	
	@Deprecated
	public String findHomePhoneIsExists() throws Exception{
		String homePhone = request.getParameter("homePhone");
		int userId = SessionUser.getUserId();
		
		List<Customer> list = DescUtils.findHomePhoneIsExistsByUserId(homePhone, userId);
		
		if(list == null || list.isEmpty()){
			//不存在
			
			CustomerUtils.writeResponse(response, "0");
		}else{
			
			int customerId = list.get(0).getId();
			CustomerUtils.writeResponse(response, customerId + "");
		}
		
		return null;
	}
	
	//private int customerId;jira : 695  如果是本客户就不查看 by wangmeng
	/**
	 * 该项目的号码是否存在,如果属于该用户的就可以查看,否则就只是提示
	 * @return
	 * @throws Exception
	 */
	public String findPhoneIsExistsForMap() throws Exception{
		
		String phone = request.getParameter("phone");
		phone = phone.trim();
		String projectId = request.getParameter("projectId");
		String custId = request.getParameter("customerId");
		String customerSource = request.getParameter("customerSource");
		int custIdInt;
		try {
			if(custId != null)
				custIdInt = Integer.parseInt(custId);
			else
				custIdInt = 0;
		} catch (Exception e) {
			custIdInt = 0;
		}
		List<Customer> list = new ArrayList<Customer>();
		if("2".equals(customerSource)){
			list = DescUtils.getCustomerServices().findCustomerPhoneIsExistsByProjectId(phone, projectId);
		}
		Map<String, String> map = new HashMap<String, String>();
		try {
			if(CommonUtils.isCollectionEmpty(list)){
				//不存在
				
				map.put("customerId", "0");
			}else if(list.size() > 1){
				
				Customer customer = null;
				
				int customerId  = 0;
				for(Customer cc : list){
					if(cc.getId() != custIdInt) {
						customerId = cc.getId();
						customer = cc;
						break;
					}
				}
				
				map.put("customerId", customerId + "");
				if(CustomerUtils.isCanShowCustomer(customerId)){
					map.put("show", "true");
				}
				
				map.put("userName", getUserName(customer));
				
				//2013.8.30
				map.put("isDeleted", customer.getIsDeleted());
				
			}else{
				
				Customer customer = list.get(0);
				map.put("userName", getUserName(customer));
				
				//2013.8.30
				map.put("isDeleted", customer.getIsDeleted());
				
				int customerId  = customer.getId();
				
				if (custIdInt == customerId){
					map.put("customerId", "0");
				}else{
					map.put("customerId", customerId + "");
					if(CustomerUtils.isCanShowCustomer(customerId)){
						map.put("show", "true");
					}
					
				}
				
			}
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
	
	/**
	 * 该项目的家庭号码是否存在,如果属于该用户的就可以查看,否则就只是提示
	 * @return
	 * @throws Exception
	 */
	public String findHomePhoneIsExistsForMap() throws Exception{
		String homePhone = request.getParameter("homePhone");
		homePhone=homePhone.trim();
		String projectId = request.getParameter("projectId");
		String custId = request.getParameter("customerId");
		String customerSource = request.getParameter("customerSource");
		List<Customer> list = new ArrayList<Customer>();
		if("2".equals(customerSource)){
			list = DescUtils.getCustomerServices().findCustomerHomePhoneIsExistsByProjectId(homePhone, projectId);
		}
		int custIdInt;
		try {
			if(custId != null)
				custIdInt = Integer.parseInt(custId);
			else
				custIdInt = 0;
		} catch (Exception e) {
			custIdInt = 0;
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(CommonUtils.isCollectionEmpty(list)){
			//不存在
			
			map.put("customerId", "0");
		}else if(list.size() > 1){
			
			Customer customer = null;
			
			int customerId  = 0;
			for(Customer cc : list){
				if(cc.getId() != custIdInt) {
					customerId = cc.getId();
					customer = cc;
					break;
				}
			}
			
			map.put("customerId", customerId + "");
			if(CustomerUtils.isCanShowCustomer(customerId)){
				map.put("show", "true");
			}
			
			map.put("userName", getUserName(customer));
			
			//2013.8.30
			map.put("isDeleted", customer.getIsDeleted());
			
		}else{
			
			Customer customer = list.get(0);
			map.put("userName", getUserName(customer));
			//2013.8.30
			map.put("isDeleted", customer.getIsDeleted());
			
			int customerId  = customer.getId();
			
			if (custIdInt == customerId){
				map.put("customerId", "0");
			}else{
				map.put("customerId", customerId + "");
				if(CustomerUtils.isCanShowCustomer(customerId)){
					map.put("show", "true");
				}
			}
			
			
			
			
		}
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
	
	private String getUserName(Customer customer){
		
		if(customer == null)
			return "";
		
		String userName = DescUtils.getUserRealName(customer.getUserId());
		if(CommonUtils.isStrEmpty(userName)){
			userName = "";
		}
		
		return userName;
	}
	
}
