package com.ihk.saleunit.action.customer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.IdcardLocation;
import com.ihk.customer.data.pojo.IdcardLocationCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.customer.data.services.IIdcardLocationServices;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.ContractCustomerCond;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.IProvinceServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.ProvinceCityRegionUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.autocomplete.AutoCompleteCallback;
import com.ihk.utils.autocomplete.AutoCompleteUtils;

/**
 * 表contract_customer智能提示框
 * @author dtc
 * 2012-8-10
 */
public class ContractCustomerAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IContractCustomerServices contractCustomerServices;
	@Autowired
	ICustomerServices customerServices;
	@Autowired
	IIdcardLocationServices idcardLocationServices;
	@Autowired
	IProvinceServices provinceServices;
	@Autowired
	ICityServices cityServices;
	@Autowired
	IRegionServices regionServices;
	
	public String contractCustomerList() throws Exception{
		
		AutoCompleteUtils.doComplete(this, "customerName", "id", new AutoCompleteCallback() {
			
			@Override
			public List<?> complete(String search) throws Exception {
				
				ContractCustomerCond cond = new ContractCustomerCond();
				cond.setCustomerName(search);
				cond.setConfirmType(AutoCompleteUtils.getOther(request));
				
				List<ContractCustomer> customerList = contractCustomerServices.findConfirmCustomerLikeName(cond);
				
				return customerList;
			}
		});
		
		
		/*String customerName = request.getParameter(AutoCompleteUtils.NAME);
		String confirmType = request.getParameter(AutoCompleteUtils.OTHER);
		
		if(customerName != null){
			customerName = customerName.trim();
		}
		
		ContractCustomerCond cond = new ContractCustomerCond();
		cond.setCustomerName(customerName);
		cond.setConfirmType(confirmType);
		
		List<ContractCustomer> customerList = contractCustomerServices.findConfirmCustomerLikeName(cond);
		
		String out = AutoCompleteUtils.initForList(customerList, "customerName", "id");
		
		CustomerUtils.writeResponse(response, out);*/
		
		return null;
	}
	
	public String searchCustomersForContract() throws Exception{
		
		AutoCompleteUtils.doComplete(this, "customerName", "id", new AutoCompleteCallback() {
			
			@Override
			public List<?> complete(String search) throws Exception {
				
				List<Customer> customerList =  customerServices.findCustomersForContract(search);
				
				return customerList;
			}
		});
		
		/*String name = AutoCompleteUtils.getSearch(request);
		
		List<Customer> customerList =  customerServices.findCustomersForContract(name);
		
		String out = AutoCompleteUtils.initForList(customerList, "customerName", "id");
		
		CustomerUtils.writeResponse(response, out);*/
		
		return null;
	}
	
	public String searchCustomersFromPhoneForContract() throws Exception{
		
		AutoCompleteUtils.doComplete(this, "phone", "id", new AutoCompleteCallback() {
			
			@Override
			public List<?> complete(String search) throws Exception {
				
				List<Customer> customerList =  customerServices.findCustomersFromPhoneForContract(search);
				
				return customerList;
			}
		});
		
		/*String phone = AutoCompleteUtils.getSearch(request);
		
		List<Customer> customerList =  customerServices.findCustomersFromPhoneForContract(phone);
		
		String out = AutoCompleteUtils.initForList(customerList, "phone", "id");
		
		CustomerUtils.writeResponse(response, out);*/
		
		return null;
	}
	
	public String saveContractCustomerFromCustomerId() throws Exception{
		
		String out = "";
		
		try{
			
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			
			Customer customer =  customerServices.getCustomerById(customerId);
			
			ContractCustomer contractCustomer = new ContractCustomer();
			
			contractCustomer.setConfirmType(ContConfirmType.CONTRACT);
			
			contractCustomer.setCustomerName(customer.getCustomerName());
			contractCustomer.setGender(customer.getGender());
			contractCustomer.setIdcardType(customer.getIdcardType());
			contractCustomer.setIdcardNo(customer.getIdcardNo());
			contractCustomer.setPhone(customer.getPhone());
			contractCustomer.setAddress(customer.getAddress());
			contractCustomer.setIsValid("0");
			
			CommonPojoUtils.initPojoCommonFiled(contractCustomer);
			
			contractCustomerServices.addContractCustomer(contractCustomer);
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", contractCustomer.getId() + "");
			map.put("name", contractCustomer.getCustomerName());
			map.put("phone", contractCustomer.getPhone());
			
			out = CommonUtils.getMapJson(map);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	public String getLocationFromIdCard() throws Exception{
		String idcardNo=request.getParameter("idcardNo");
		IdcardLocationCond cond= new IdcardLocationCond();
		String sixCharOfIdcardNo =idcardNo.substring(0, 6);
		cond.setIdentityId(sixCharOfIdcardNo);
		List<IdcardLocation> locationList = idcardLocationServices.findIdcardLocation(cond);
		Map<String,String> map = new HashMap<String,String>();
		String json;
		if(locationList.size()!=0){
			json = ProvinceCityRegionUtils.getJsonProvinceCityRegionFromMap(locationList,map);
			CustomerUtils.writeResponse(response, json);
		}else{
			String fourCharOfIdcardNo =idcardNo.substring(0, 4)+"00";
			cond.setIdentityId(fourCharOfIdcardNo);
			locationList = idcardLocationServices.findIdcardLocation(cond);
			if(locationList.size()!=0){
				json = ProvinceCityRegionUtils.getJsonProvinceCityRegionFromMap(locationList,map);
				CustomerUtils.writeResponse(response, json);
			}else{
				String twoCharOfIdcardNo =idcardNo.substring(0, 2)+"0000";
				cond.setIdentityId(twoCharOfIdcardNo);
				locationList = idcardLocationServices.findIdcardLocation(cond);
				if(locationList.size()!=0){
					json = ProvinceCityRegionUtils.getJsonProvinceCityRegionFromMap(locationList,map);
					CustomerUtils.writeResponse(response, json);
				}else{
					map.put("province", "");
					map.put("city", "");
					map.put("region", "");
					CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
				}
			}
		}
		return null;
	}
	
	
}
