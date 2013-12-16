package com.ihk.junit.import_cus.hubei.stl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerFocus;
import com.ihk.customer.data.pojo.CustomerKnown;
import com.ihk.customer.data.services.ICustomerFocusServices;
import com.ihk.customer.data.services.ICustomerKnownServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.junit.SupperJunit;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;

/**
 * 圣特力来电
 * @author dtc
 * 2013-8-14,上午09:42:30
 */
public class ImportCustomer extends SupperJunit {

	/**
	 * 导入数据
	 * @throws Exception
	 */
	@Test
	public void _import() throws Exception {
		
		final ICustomerServices customerServices = 
			(ICustomerServices) factory.getBean("customerServices");
		
		final ICustomerFocusServices customerFocusServices =
			(ICustomerFocusServices) factory.getBean("customerFocusServices");
		
		final ICustomerKnownServices customerKnownServices =
			(ICustomerKnownServices) factory.getBean("customerKnownServices");
		
		new MyTransationTemplate() {
			
			@Override
			protected void doExecuteCallback() throws Exception {
				
				//获取StlLaiDianBean
				List<String> strList = LeadingInUtils.realXls("c:\\1.xls");
				
				List<StlLaiDianBean> beanList = new ArrayList<StlLaiDianBean>();
				StlLaiDianBean bean = null;
				
				for(String str : strList){
					
					bean = StlLaiDianUtils.stringToBean(str);
					
					if(bean != null){
						
						beanList.add(bean);
					}
				}
				
				//保存客户及获知途径,关注点
				
				for(StlLaiDianBean tmp : beanList){
					
					Customer customer = beanToCustomer(tmp);
					
					if("*".equals(customer.getCustomerName()))
						continue;
					
					customerServices.saveCustomer(customer);
					
					List<CustomerFocus> focusList = LeadingInUtils.getFocusByBeanAndCustomerId(tmp, customer.getId());
					if(!CommonUtils.isCollectionEmpty(focusList)){
						
						for(CustomerFocus focus : focusList){
							
							customerFocusServices.addCustomerFocus(focus);
						}
						
					}
					
					List<CustomerKnown> knownList = LeadingInUtils.getKnownByBeanAndCustomerId(tmp, customer.getId());
					if(!CommonUtils.isCollectionEmpty(knownList)){
						
						for(CustomerKnown known : knownList){
							
							customerKnownServices.addCustomerKnown(known);
						}
					}
					
					
				}
				
			}
		}.execute();

	}
	
	/**
	 * 根据StlLaiDianBean返回Customer
	 * @param bean
	 * @return
	 */
	private Customer beanToCustomer(StlLaiDianBean bean){
		
		Customer customer = new Customer();
		
		customer.setCustomerNo(CustomerUtils.getTmpCustomerNo());
		
		customer.setCustomerName(bean.getCustomerName()); 
		customer.setVisitDate(bean.getVisitDate());
		customer.setPhone(bean.getPhone());
		
		customer.setHomeProvince(17); //居住省
		customer.setHomeCity(169); //居住市
		customer.setHomeContent(bean.getHomeContent()); 
		
		customer.setAreaNum(bean.getAreaNum()); //意向面积 
		customer.setRemark1(bean.getRemark1()); //备注
		
		customer.setCompanyId(29);
		customer.setProjectId(190);
		
		customer.setTeamId(0);
		customer.setUserId(2400);
		
		customer.setManagerId(2400);
		customer.setCustomerSource("1"); //客户来源
		
		customer.setIsDeleted(CommonUtils.NORMAL);
		customer.setCreatedId(2400);
		customer.setCreatedTime(new Date());
		customer.setModId(2400);
		customer.setModTime(new Date());
		
		return customer;
	}

	public static void main(String[] args) {
		
		List<String> list = LeadingInUtils.realXls("c:\\1.xls");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(String l : list){
			
			String phone = l.split("\\|")[2];
			if(map.containsKey(phone)){
				System.out.println(phone);
			}else{
				map.put(phone, 1);
			}
		}
		
	}

}
