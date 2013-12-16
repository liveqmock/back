package com.ihk.customer.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContProjectId;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.saleunit.data.pojo.AppointCustomer;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.ContractCustomerCond;
import com.ihk.saleunit.data.services.IAppointCustomerServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 *  用户list提示框
 */
public class UserListAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IUserAccountServices userAccountServices;
	@Autowired
	IAppointCustomerServices appointCustomerServices;
	@Autowired
	IContractCustomerServices confirmCustomerServices;
	
	private final static String LEFT = "(";
	private final static String RIGHT = ")";
	private final static String LIMIT = "|";
	private final static String LINE = "\n";
	
	public String searchUser() throws Exception{
		
		StringBuffer sb = new StringBuffer();
		
		String name = request.getParameter("q");
		
		if(name != null){
			name = name.trim();
		}
		
		UserAccountCond cond = new UserAccountCond();
		cond.setUserName(name);
		List<UserAccount> userList = userAccountServices.findUserAccountsLikeName(name); //findGuangZhouUser
		for(UserAccount user : userList){
			
			sb.append(user.getRealName())
				.append(LEFT)
				.append(user.getUserName())
				.append(RIGHT)
				.append(LIMIT)
				.append(user.getId())
				.append(LINE);
		}
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	public String getUserIdByName() throws Exception{
		String userName = request.getParameter("userName");
		int index = userName.indexOf(LEFT);
		if(index != -1){
			userName = userName.substring(0, index);
		}
		
		UserAccount user = userAccountServices.findUserAccountByRealName(userName);
		
		if(user != null){
			
			CustomerUtils.writeResponse(response, user.getId() + "");
		}else{
			//表示不存在,返回0
			CustomerUtils.writeResponse(response, "0");
		}
		
		return null;
	}
	
	// appoint customer start
	
	public String searchAppointCustomer() throws Exception{
		
		StringBuffer sb = new StringBuffer();
		
		String name = request.getParameter("q");
		
		if(name != null){
			name = name.trim();
		}
		
		List<AppointCustomer> customerList = appointCustomerServices.findAppointCustomerLikeName(name);
		
		for(AppointCustomer customer : customerList){
			
			sb.append(customer.getCustomerName())
				.append(LIMIT)
				.append(customer.getId())
				.append(LINE);
		}
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String toAddAppointCustomer() throws Exception{
		
		StringBuffer genderSb = new StringBuffer();
		genderSb.append("<select name='appointCustomer.gender' id='appointCustomerGender' style='width:150px'>")
			.append(CommonUtils.getSelectContent(DescUtils.getInitSelEmptyAndGender(null)))
			.append("</select>");
		
		StringBuffer idCardTypeSb = new StringBuffer();
		idCardTypeSb.append("<select name='appointCustomer.idcardType' id='appointCustomerIdcardType' style='width:150px'>")
			.append(CommonUtils.getSelectContent(DescUtils.getInitSelForGuangZhou(null, EnumCodeTypeName.SALEUNIT_IDCARD_TYPE, true)))
			.append("</select>");
		
		StringBuffer jsonData = new StringBuffer();
		jsonData.append("{\"gender\":\"")
			.append(genderSb.toString())
			.append("\"")
			.append(",\"idCardType\":\"")
			.append(idCardTypeSb.toString())
			.append("\"")
			.append("}")
			;
		
		CustomerUtils.writeResponse(response, jsonData.toString());
		
		return null;
	}
	
	public String addAppointCustomer() throws Exception{
		
		String out = "";
		
		try{
			
			CommonPojoUtils.initPojoCommonFiled(appointCustomer);
			appointCustomerServices.addAppointCustomer(appointCustomer);
			out = appointCustomer.getId() + "";
			
		}catch(Exception e){
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	public String getAppointCustomerById() throws Exception{
		
		int appointCustomerId = Integer.parseInt(request.getParameter("appointCustomerId"));
		
		AppointCustomer customer = appointCustomerServices.findAppointCustomerById(appointCustomerId);
		
		CustomerUtils.writeResponse(response, customer.getCustomerName());
		
		return null;
	}
	
	public String showAppointCustomer() throws Exception{
		
		int appointCustomerId = Integer.parseInt(request.getParameter("appointCustomerId"));
		
		AppointCustomer customer = appointCustomerServices.findAppointCustomerById(appointCustomerId);
		
		//姓名, 电话, 性别, 证件类型, 证件号码
		Map<String, String> map = new HashMap<String, String>();
		map.put("customerName", customer.getCustomerName());
		map.put("phone", customer.getPhone());
		map.put("gender", DescUtils.getCodeDesc(EnumCodeTypeName.GENDER, customer.getGender(), ContProjectId.GUANG_ZHOU));
		map.put("idCardType", DescUtils.getCodeDesc(EnumCodeTypeName.SALEUNIT_IDCARD_TYPE, customer.getIdcardType(), ContProjectId.GUANG_ZHOU));
		map.put("idCardNo", customer.getIdcardNo());
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
	
	//appoint customer end
	
	//confirm customer start
	
	//查找的时候要具体区分是认购还是合同客户(除了智能提示框的列表要用不同的方法,其他的可以共用)
	public String searchConfirmCustomer() throws Exception{
		
		StringBuffer sb = new StringBuffer();
		
		String name = request.getParameter("q");
		
		if(name != null){
			name = name.trim();
		}
		
		ContractCustomerCond cond = new ContractCustomerCond();
		cond.setConfirmType(ContConfirmType.CONFIRM);
		cond.setCustomerName(name);
		
		List<ContractCustomer> customerList = confirmCustomerServices.findConfirmCustomerLikeName(cond);
		
		for(ContractCustomer customer : customerList){
			
			sb.append(customer.getCustomerName())
				.append(LIMIT)
				.append(customer.getId())
				.append(LINE);
		}
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	public String searchContractCustomer() throws Exception{
		
		StringBuffer sb = new StringBuffer();
		
		String name = request.getParameter("q");
		
		if(name != null){
			name = name.trim();
		}
		
		ContractCustomerCond cond = new ContractCustomerCond();
		cond.setConfirmType(ContConfirmType.CONTRACT);
		cond.setCustomerName(name);
		
		List<ContractCustomer> customerList = confirmCustomerServices.findConfirmCustomerLikeName(cond);
		
		for(ContractCustomer customer : customerList){
			
			sb.append(customer.getCustomerName())
				.append(LIMIT)
				.append(customer.getId())
				.append(LINE);
		}
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String toAddConfirmCustomer() throws Exception{
		
		StringBuffer genderSb = new StringBuffer();
		genderSb.append("<select name='confirmCustomer.gender' id='confirmCustomerGender' style='width:150px'>")
			.append(CommonUtils.getSelectContent(DescUtils.getInitSelEmptyAndGender(null)))
			.append("</select>");
		
		StringBuffer idCardTypeSb = new StringBuffer();
		idCardTypeSb.append("<select name='confirmCustomer.idcardType' id='confirmCustomerIdcardType' style='width:150px'>")
			.append(CommonUtils.getSelectContent(DescUtils.getInitSelForGuangZhou(null, EnumCodeTypeName.SALEUNIT_IDCARD_TYPE, true)))
			.append("</select>");
		
		String type = "";
		String confirmType = request.getParameter("type");
		if("confirm".equals(confirmType)){
			
			type = ContConfirmType.CONFIRM;
		}
		if("contract".equals(confirmType)){
			
			type = ContConfirmType.CONTRACT;
		}
		
		StringBuffer jsonData = new StringBuffer();
		jsonData.append("{\"gender\":\"")
			.append(genderSb.toString())
			.append("\"")
			.append(",\"idCardType\":\"")
			.append(idCardTypeSb.toString())
			.append("\"")
			.append(",\"type\":\"")
			.append(type)
			.append("\"")
			.append("}")
			;
		
		CustomerUtils.writeResponse(response, jsonData.toString());
		
		return null;
	}
	
	public String addConfirmCustomer() throws Exception{
		
		String out = "";
		
		try{
			
			CommonPojoUtils.initPojoCommonFiled(confirmCustomer);
			confirmCustomerServices.addContractCustomer(confirmCustomer);
			out = confirmCustomer.getId() + "";
			
		}catch(Exception e){
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	public String getConfirmCustomerById() throws Exception{
		
		int confirmCustomerId = Integer.parseInt(request.getParameter("confirmCustomerId"));
		
		ContractCustomer customer = confirmCustomerServices.findContractCustomerById(confirmCustomerId);
		
		CustomerUtils.writeResponse(response, customer.getCustomerName());
		
		return null;
	}
	
	public String showConfirmCustomer() throws Exception{
		
		int confirmCustomerId = Integer.parseInt(request.getParameter("confirmCustomerId"));
		
		ContractCustomer customer = confirmCustomerServices.findContractCustomerById(confirmCustomerId);
		
		//姓名, 性别, 证件类型, 证件号码, 电话
		Map<String, String> map = new HashMap<String, String>();
		map.put("customerName", customer.getCustomerName());
		map.put("gender", DescUtils.getCodeDesc(EnumCodeTypeName.GENDER, customer.getGender(), ContProjectId.GUANG_ZHOU));
		map.put("idCardType", DescUtils.getCodeDesc(EnumCodeTypeName.SALEUNIT_IDCARD_TYPE, customer.getIdcardType(), ContProjectId.GUANG_ZHOU));
		map.put("idCardNo", customer.getIdcardNo());
		map.put("phone", customer.getPhone());
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
	
	//confirm customer end
	
	
	/////
	
	private AppointCustomer appointCustomer;
	
	private ContractCustomer confirmCustomer;
	
	public void setConfirmCustomer(ContractCustomer confirmCustomer) {
		this.confirmCustomer = confirmCustomer;
	}
	
	public ContractCustomer getConfirmCustomer() {
		return confirmCustomer;
	}
	
	public void setAppointCustomer(AppointCustomer appointCustomer) {
		this.appointCustomer = appointCustomer;
	}
	
	public AppointCustomer getAppointCustomer() {
		return appointCustomer;
	}
	
	
	

}
