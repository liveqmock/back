package com.ihk.junit.import_cus.hubei.th;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerKnown;
import com.ihk.customer.data.services.ICustomerKnownServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.junit.SupperJunit;
import com.ihk.junit.import_cus.hubei.stl.LeadingInUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;

/**
 * 8.天鸿美庐来电.xls
 * @author dtc
 * 2013-8-21,下午05:49:34
 */
public class ImportThLaiDianCustomer extends SupperJunit {
	
	final ICustomerServices customerServices = 
		(ICustomerServices) factory.getBean("customerServices");
	
	final ICustomerKnownServices customerKnownServices =
		(ICustomerKnownServices) factory.getBean("customerKnownServices");
	
	@Test
	public void _import() throws Exception {
		
		new MyTransationTemplate() {
			
			@Override
			protected void doExecuteCallback() throws Exception {
				
				//获取StlLaiDianBean
				List<String> strList = LeadingInUtils.realXls("c:\\8.xls");
				
				List<ThLaiFanBean> beanList = new ArrayList<ThLaiFanBean>();
				ThLaiFanBean bean = null;
				
				for(String str : strList){
					
					bean = ThLaiDianUtils.stringToBean(str);
					
					if(bean != null){
						
						beanList.add(bean);
					}
				}
				
				//保存客户及获知途径
				
				for(ThLaiFanBean tmp : beanList){
					
					try{
					
						Customer customer = beanToCustomer(tmp);
						
						if("*".equals(customer.getCustomerName()))
							continue;
						
						customerServices.saveCustomer(customer);
						
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
		
		/**
		 * 来电日期		客户姓名		联系电话		居住区域	
		 * 需求户型		需求面积		获知途径		备注
		 */
		
		Customer customer = new Customer();
		
		customer.setCustomerNo(CustomerUtils.getTmpCustomerNo());
		
		customer.setCustomerName(bean.getCustomerName()); 
		customer.setVisitDate(bean.getVisitDate());
		customer.setPhone(bean.getPhone());
		
		customer.setHomeProvince(17); //居住省
		customer.setHomeCity(169); //居住市
		customer.setHomeContent(bean.getHomeContent()); 
		
		customer.setRoomType(bean.getRoomType()); //需求户型 
		
		customer.setAreaNum(bean.getAreaNum()); //意向面积
		
		customer.setRemark1(bean.getRemark1()); //备注
		
		////
		customer.setCompanyId(29);
		customer.setProjectId(187); //
		
		customer.setTeamId(0);
		customer.setUserId(2400);
		
		customer.setManagerId(2400);
		customer.setCustomerSource("1"); //客户来源,来电
		
		customer.setIsDeleted(CommonUtils.NORMAL);
		customer.setCreatedId(2400);
		customer.setCreatedTime(new Date());
		customer.setModId(2400);
		customer.setModTime(new Date());
		
		return customer;
	}

}
