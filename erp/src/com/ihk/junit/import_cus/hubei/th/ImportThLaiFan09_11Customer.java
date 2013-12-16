package com.ihk.junit.import_cus.hubei.th;

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
import com.ihk.junit.import_cus.hubei.stl.LeadingInUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;

/**
 * 6.天鸿美庐来访_09-11.xls
 * @author dtc
 * 2013-8-20,上午11:09:36
 */
public class ImportThLaiFan09_11Customer extends SupperJunit {
	
	final ICustomerServices customerServices = 
		(ICustomerServices) factory.getBean("customerServices");
	
	final ICustomerFocusServices customerFocusServices =
		(ICustomerFocusServices) factory.getBean("customerFocusServices");
	
	final ICustomerKnownServices customerKnownServices =
		(ICustomerKnownServices) factory.getBean("customerKnownServices");
	
	@Test
	public void _import() throws Exception {
		
		new MyTransationTemplate() {
			
			@Override
			protected void doExecuteCallback() throws Exception {
				
				//获取StlLaiDianBean
				List<String> strList = LeadingInUtils.realXls("c:\\6.xls");
				
				List<ThLaiFanBean> beanList = new ArrayList<ThLaiFanBean>();
				ThLaiFanBean bean = null;
				
				for(String str : strList){
					
					bean = ThLaiFanUtils.stringToBean(str);
					
					if(bean != null){
						
						beanList.add(bean);
					}
				}
				
				//保存客户及获知途径,关注点
				
				for(ThLaiFanBean tmp : beanList){
					
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
	private Customer beanToCustomer(ThLaiFanBean bean){
		
		Customer customer = new Customer();
		
		customer.setCustomerNo(CustomerUtils.getTmpCustomerNo());
		
		customer.setCustomerName(bean.getCustomerName()); 
		customer.setVisitDate(bean.getVisitDate());
		customer.setPhone(bean.getPhone());
		
		customer.setHomeProvince(17); //居住省
		customer.setHomeCity(169); //居住市
		customer.setHomeContent(bean.getHomeContent()); 
		
		customer.setWorkProvince(17);
		customer.setWorkCity(169);
		customer.setWorkContent(bean.getWorkContent());
		
		customer.setAge(bean.getAge()); //客户年龄
		
		customer.setAreaNum(bean.getAreaNum()); //意向面积
		
		customer.setJobIndustry(bean.getJobIndustry()); //职业 
		
		customer.setPriceNum(bean.getPriceNum()); //商铺总价承受情况
		
		customer.setTrafficDesc(bean.getTrafficDesc()); //交通方式
		
		customer.setBuyUse(bean.getBuyUse()); //购房用途
		
		////
		customer.setCompanyId(29);
		customer.setProjectId(187); //
		
		customer.setTeamId(0);
		customer.setUserId(2400);
		
		customer.setManagerId(2400);
		customer.setCustomerSource("2"); //客户来源,来访
		
		customer.setIsDeleted(CommonUtils.NORMAL);
		customer.setCreatedId(2400);
		customer.setCreatedTime(new Date());
		customer.setModId(2400);
		customer.setModTime(new Date());
		
		return customer;
	}
	
}