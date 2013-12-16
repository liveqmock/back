package com.ihk.junit.import_cus.hubei.stl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
 * 圣特力来访
 * @author dtc
 * 2013-8-15,下午01:57:52
 */
public class ImportLaiFanCusotmer extends SupperJunit {
	
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
				
				List<String> strList = LeadingInUtils.realXls("c:\\2.xls");
				
				List<StlLaiFanBean> beanList = new ArrayList<StlLaiFanBean>();
				StlLaiFanBean bean = null;
				
				for(String str : strList){
					
					bean = StlLaiFanUtils.stringToBean(str);
					
					if(bean != null){
						
						beanList.add(bean);
					}
				}
				
				//保存客户及获知途径,关注点
				
				for(StlLaiFanBean tmp : beanList){
					
					try{
						
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
						
					}catch (Exception e) {
						e.printStackTrace();
						continue;
					}
					
					
				}
				
			}
		}.execute();
		
	}
	
	/**
	 * 根据StlLaiFanBean返回Customer
	 * @param bean
	 * @return
	 */
	private Customer beanToCustomer(StlLaiFanBean bean){
		
		Customer customer = new Customer();
		
		customer.setCustomerNo(CustomerUtils.getTmpCustomerNo());
		
		////
		customer.setVisitDate(bean.getVisitDate());
		customer.setCustomerName(bean.getCustomerName()); 
		customer.setPhone(bean.getPhone());
		
		customer.setHomeProvince(17); //居住省
		customer.setHomeCity(169); //居住市
		customer.setHomeContent(bean.getHomeContent()); 
		
		customer.setAge(bean.getAge()); 
		
		customer.setAreaNum(bean.getAreaNum());
		customer.setBuyUse(bean.getBuyUse());
		customer.setBuyCount(bean.getBuyCount());
		
		customer.setJobIndustry(bean.getJobIndustry());
		customer.setTrafficDesc(bean.getTrafficDesc());
		customer.setHouseType(bean.getHouseType());
		
		customer.setRating(bean.getRating());
		customer.setGender(bean.getGender());
		customer.setRemark1(bean.getRemark1());
		
		////
		customer.setCompanyId(29);
		customer.setProjectId(190); //查找依据
		
		customer.setTeamId(0);
		customer.setUserId(2400);
		
		customer.setManagerId(2400);
		customer.setCustomerSource("2");
		
		customer.setIsDeleted(CommonUtils.NORMAL);
		customer.setCreatedId(2400);
		customer.setCreatedTime(new Date());
		customer.setModId(2400);
		customer.setModTime(new Date());
		
		return customer;
	}

}
