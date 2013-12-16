package com.ihk.junit.import_cus.dongguan.wo;

import java.util.List;

import org.junit.Test;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.services.ICustomerFocusServices;
import com.ihk.customer.data.services.ICustomerKnownServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.junit.SupperJunit;
import com.ihk.junit.import_cus.hubei.stl.LeadingInUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.MyTransationTemplate;

/**
 * 东莞wo城来访
 * @author dtc
 * 2013-8-29,上午11:02:28
 */
public class ImportWoLaiFanCustomer extends SupperJunit {

	private static final long serialVersionUID = -5726268876509782443L;
	
	final ICustomerServices customerServices = 
		(ICustomerServices) factory.getBean("customerServices");
	
	final ICustomerFocusServices customerFocusServices =
		(ICustomerFocusServices) factory.getBean("customerFocusServices");
	
	final ICustomerKnownServices customerKnownServices =
		(ICustomerKnownServices) factory.getBean("customerKnownServices");

	@Test
	public void _import() throws Exception{
		
		List<String> list = LeadingInUtils.realXls("C:\\dg\\wolaifan.xls");
		
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
						Customer cus = LeadingInUtils.stringToBean(fields, 19, 213, 28, 202, 2117, 2);
						
						/**
						 * 厚街	道滘	洪梅	沙田	长安	虎门	南城	万江	东城	莞城	虎门	长安	其他镇区	外省	其他地区	港澳台
						 */
						String[] homeContentVal = new String[]{"厚街", "道滘", "洪梅", "沙田", "长安", "虎门", 
								"南城", "万江", "东城", "莞城", "虎门",	"长安",	"其他镇区", "外省",	"其他地区",	"港澳台"};
						String homeContent = LeadingInUtils.getValByMapAndFields(3, homeContentVal, fields);
						cus.setHomeContent(homeContent); //来电区域(居住区域)	
						
						/**
						 * 年龄
						 */
						String[] ageVal = new String[]{"1", "3", "4", "5"};
						String age = LeadingInUtils.getValByMapAndFields(19, ageVal, fields);
						cus.setAge(age);
						
						/**
						 * 户籍,写到备注中
						 * 本地人 23	广东籍	外省人	港澳台	其他
						 */
						String[] fromVal = new String[]{"本地人", "广东籍", "外省人", "港澳台", "其他"};
						String from = LeadingInUtils.getValByMapAndFields(23, fromVal, fields);
						if(!CommonUtils.isStrEmpty(from)){
							cus.setRemark1("客户户籍:" + from);
						}
						
						/**
						 * 单位性质,3 2 7 8 1 22 9 6 10 30
						 */
						String[] jobIndustryVal = new String[]{"3", "2", "7", "8", "1", "22", "9", "6", "10", "30"};
						String jobIndustry = LeadingInUtils.getValByMapAndFields(28, jobIndustryVal, fields);
						cus.setJobIndustry(jobIndustry);
						
						
						
						customerServices.saveCustomer(cus);
						
						/**
						 * 电台 38	网络	户外广告	电视广告	楼体广告	短信	回访／ 电话邀约	路过	朋友介绍	内部推荐	业主介绍	业主	车行	直邮	展场	参观	其它 54
						 * 11 12 13 14 43 38 15 46 31 16 35 17 18 19 20 21 50
						 */
						String[] knownVal = {"11", "12", "13", "14", "43", "38", "15", "46", "31", "16", "35", "17", "18", "19", "20", "21", "50"};
						LeadingInUtils.addKnownByCustomerId(38, knownVal, fields, cus.getId(), customerKnownServices);
						
						/**
						 * 价格 59	面积	区域位置	交通便利性	物业管理	教育配套	区域规划	生活配套	升值潜力	学位	其他
						 */
						String[] customerFocusVal = {"46", "12", "14", "11", "43", "38", "35", "31", "22", "39", "13"};
						LeadingInUtils.addFocusByCustomerId(12, customerFocusVal, fields, cus.getId(), customerFocusServices);
						
					}
				}.execute();
				
			}catch (Exception e) {
			}
			
		}
		
	}
	
}
