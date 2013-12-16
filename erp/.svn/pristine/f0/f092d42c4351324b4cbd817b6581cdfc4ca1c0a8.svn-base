package com.ihk.junit.import_cus.hubei.fa;

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
import com.ihk.junit.import_cus.hubei.stl.LeadingInUtils;
import com.ihk.junit.import_cus.hubei.th.ThLaiFanBean;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;

/**
 * 10.佛奥·俊贤雅居来电.xls
 * @author dtc
 * 2013-8-22,下午01:52:26
 */
public class ImportFoAoLaiDianCustomer extends SupperJunit {
	
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
				List<String> strList = LeadingInUtils.realXls("c:\\10.xls");
				
				List<ThLaiFanBean> beanList = new ArrayList<ThLaiFanBean>();
				ThLaiFanBean bean = null;
				
				for(String str : strList){
					
					bean = stringToBean(str);
					
					if(bean != null){
						
						beanList.add(bean);
					}
				}
				
				//保存客户及获知途径,关注点
				
				for(ThLaiFanBean tmp : beanList){
					
					try{
					
						Customer customer = beanToCustomer(tmp);
						
						if(customer == null || "*".equals(customer.getCustomerName()))
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
	
	private Customer beanToCustomer(ThLaiFanBean bean) {
		
		if(bean == null){
			return null;
		}
		
		Customer customer = new Customer();
		
		/**
		 * *来电日期	客户姓名		联系方式		居住区域				
		* 需求面积(意向户型)	获知途径		咨询内容		备注
		 */
		
		customer.setCustomerNo(CustomerUtils.getTmpCustomerNo());
		
		////
		customer.setVisitDate(bean.getVisitDate());
		customer.setCustomerName(bean.getCustomerName()); 
		customer.setPhone(bean.getPhone());
		
		customer.setHomeProvince(17); //居住省
		customer.setHomeCity(169); //居住市
		customer.setHomeContent(bean.getHomeContent()); 
		
		customer.setRoomType(bean.getRoomType()); //您将选择的住宅面积(意向户型)
		String re = "*".equals(bean.getRemark1()) ? "" : bean.getRemark1();
		customer.setRemark1(re); //备注
		
		////
		customer.setCompanyId(29);
		customer.setProjectId(215); //查找依据
		
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

	private ThLaiFanBean stringToBean(String str) {
		
		if(CommonUtils.isStrEmpty(str)){
			
			return null;
		}
		
		/**
		 *来电日期	客户姓名		联系方式		居住区域				
		* 需求面积(意向户型)	获知途径		咨询内容		备注
		 */
		
		ThLaiFanBean bean = new ThLaiFanBean();
		
		String[] fields = str.split("\\|");
		
		bean.setVisitDate(LeadingInUtils.changeVisitDate(fields[0]));
		bean.setCustomerName(fields[1]);
		bean.setPhone(initPhone(fields[2]));
		
		bean.setHomeContent(changeHomeContent(fields)); //居住区域 
		
		bean.setRoomType(initRoomType(fields)); //您将选择的住宅面积(意向户型)
		
		bean.setKnownFroms(initKnownFroms(fields)); //获知途径
		
		bean.setCustomerFocus(initCustomerFocus(fields)); //咨询内容
		
		bean.setRemark1(initRemark1(fields)); //备注
		
		return bean;
	}

	private String initRemark1(String[] fields) {
		
		return fields[fields.length-1];
	}

	private String initPhone(String string) {
		
		if(CommonUtils.isStrEmpty(string)){
			
			return "";
		}
		
		if(string.trim().length() > 11){
			
			return string.trim().substring(0, 11);
		}
		
		return string.trim();
	}
	
	private static String[] initKnownFroms(String[] fields){
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		//报纸广告 	户外广告牌	网络	电台	外展点	派单	活动	短信	车身广告	楼宇、围墙广告	途经	亲友介绍	其他 
		
		map.put(25, "1");
		map.put(26, "2");
		map.put(27, "3");
		map.put(28, "4");
		map.put(29, "5");
		
		map.put(30, "6");
		map.put(31, "7");
		map.put(32, "8");
		map.put(33, "9");
		map.put(34, "10");

		map.put(35, "11");
		map.put(36, "12");
		map.put(37, "13");
		
		List<String> knownList = new ArrayList<String>();
		
		for(int i=25; i<=37; i++){
			
			if(!"*".equals(fields[i])){
				
				knownList.add(map.get(i));
				
			}
			
		}
		
		String[] ret = null;
		
		if(!CommonUtils.isCollectionEmpty(knownList)){
			
			int size = knownList.size();
			
			ret = new String[size];
			
			for(int i=0; i<size; i++){
				
				ret[i] = knownList.get(i);
			}
			
			
		}
		
		return ret == null ? new String[]{} : ret;
	}

	private static String[] initCustomerFocus(String[] fields){
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		//地理位置 67		价格	户型设计	交通配套	教育配套	生活配套	升值潜力	产品品质	园林景观	物业服务	品牌与开发商实力	智能化配套	其他
		
		map.put(38, "1");
		map.put(39, "2");
		map.put(40, "3");
		map.put(41, "4");
		map.put(42, "5");
		
		map.put(43, "6");
		map.put(44, "7");
		map.put(45, "8");
		map.put(46, "9");
		map.put(47, "10");
		
		map.put(48, "11");
		map.put(49, "12");
		map.put(50, "13");
		
		List<String> focusList = new ArrayList<String>();
		
		for(int i=38; i<=50; i++){
			
			if(!"*".equals(fields[i])){
				
				focusList.add(map.get(i));
				
			}
			
		}
		
		String[] ret = null;
		
		if(!CommonUtils.isCollectionEmpty(focusList)){
			
			int size = focusList.size();
			
			ret = new String[size];
			
			for(int i=0; i<size; i++){
				
				ret[i] = focusList.get(i);
			}
			
			
		}
		
		return ret == null ? new String[]{} : ret;
		
	}

	private String initRoomType(String[] fields) {
		String[] val = new String[]{"1", "2", "3", "4", "5"};
		
		return LeadingInUtils.getValByMapAndFields(20, val, fields);
	}

	private String changeHomeContent(String[] fields) {
		
		//流芳片区 26	九峰片区	鲁巷片区	卓刀泉	街道口	中南	南湖	阅马场	水果湖	中北路	徐东	青山	硚口	江岸	江汉	汉阳	其他

		String[] val = new String[]{"流芳片区", "九峰片区", "鲁巷片区", "卓刀泉", "街道口", "中南", "南湖", "阅马场", "水果湖", "中北路", "徐东",
				"青山", "硚口", "江岸", "江汉", "汉阳", "其他"};
		
		return LeadingInUtils.getValByMapAndFields(3, val, fields);
	}


}
