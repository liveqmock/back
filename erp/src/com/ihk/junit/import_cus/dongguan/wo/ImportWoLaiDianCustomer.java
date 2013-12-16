package com.ihk.junit.import_cus.dongguan.wo;

import java.util.List;

import org.junit.Test;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.services.ICustomerFocusServices;
import com.ihk.customer.data.services.ICustomerKnownServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.junit.SupperJunit;
import com.ihk.junit.import_cus.hubei.stl.LeadingInUtils;
import com.ihk.utils.MyTransationTemplate;

/**
 * 东莞wo城来电, 183
 * @author dtc
 * 2013-8-26,上午10:48:19
 */
public class ImportWoLaiDianCustomer extends SupperJunit{
	
	final ICustomerServices customerServices = 
		(ICustomerServices) factory.getBean("customerServices");
	
	final ICustomerFocusServices customerFocusServices =
		(ICustomerFocusServices) factory.getBean("customerFocusServices");
	
	final ICustomerKnownServices customerKnownServices =
		(ICustomerKnownServices) factory.getBean("customerKnownServices");
	
	@Test
	public void _import() throws Exception{
		
		List<String> list = LeadingInUtils.realXls("C:\\dg\\wolaidian.xls");
		
		for(final String str : list){
			
			try{
				
				new MyTransationTemplate() {
					
					@Override
					protected void doExecuteCallback() throws Exception {
						
						String[] fields = str.split("\\|");
						
						/**
						 * public static Customer stringToBean(String[] fields, int homeProvince, int homeCity, int companyId, int projectId,
							int userId, int customerSource)
						 */
						Customer cus = LeadingInUtils.stringToBean(fields, 19, 213, 28, 202, 2117, 1);
						
						String[] homeContentVal = new String[]{"厚街", "道滘", "洪梅", "沙田", "虎门", "万江", "南城", "东城", "其他区域"};
						String homeContent = LeadingInUtils.getValByMapAndFields(3, homeContentVal, fields);
						cus.setHomeContent(homeContent); //来电区域(居住区域)						
						
						customerServices.saveCustomer(cus);
						
						/**
						 * 路过	网络	电视	电台		短信	业主介绍	朋友介绍	企业拓展	派单	户外广告
							楼体广告						
						 */
						String[] customerFocusVal = {"46", "12", "14", "11", "43", "38", "35", "31", "22", "39", "13"};
						LeadingInUtils.addFocusByCustomerId(12, customerFocusVal, fields, cus.getId(), customerFocusServices);
						
						/**
						 * 区域位置	生活配套	交通便利性	物业管理	教育配套	区域规划	升值潜力	学位	其它
						 * 
						 * 价格		面积	区域位置	生活配套	交通便利性	物业管理	教育配套	区域规划	升值潜力	学位	其它
						 */
						String[] knownVal = {"3", "4", "5", "6", "7", "8", "9", "10", "21"};
						LeadingInUtils.addKnownByCustomerId(23, knownVal, fields, cus.getId(), customerKnownServices);
						
					}
				}.execute();
				
			}catch (Exception e) {
			}
			
		}
		
	}
	
}
