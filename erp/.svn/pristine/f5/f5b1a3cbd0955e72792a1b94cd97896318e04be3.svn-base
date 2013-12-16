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
 * 9.佛奥·俊贤雅居来访.xls
 * @author dtc
 * 2013-8-22,上午10:21:49
 */
public class ImportFoAoLaiFanCustomer extends SupperJunit {
	
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
				List<String> strList = LeadingInUtils.realXls("c:\\9.xls");
				
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
		 *  来访日期		客户姓名		手机		客户年龄							
		 * 您的家庭结构	您从事的职业		您目前居住区域	您目前置业是第几次置业	
		 * 您将选择的住宅面积(意向户型)		您欲购买房型，多少房屋总价与您的期望相符（万元人民币）	
		 * 您置业的用途		购房时主要参考的因素：（多选）	您获得我项目信息的主要途径（多选）		客户类型(客户评级 )
		 */
		
		customer.setCustomerNo(CustomerUtils.getTmpCustomerNo());
		
		////
		customer.setVisitDate(bean.getVisitDate());
		customer.setCustomerName(bean.getCustomerName()); 
		customer.setPhone(bean.getPhone());
		
		customer.setAge(bean.getAge()); 
		customer.setFamilyType(bean.getFamilyType());
		customer.setJobIndustry(bean.getJobIndustry());
		
		customer.setHomeProvince(17); //居住省
		customer.setHomeCity(169); //居住市
		customer.setHomeContent(bean.getHomeContent()); 
		
		customer.setBuyCount(bean.getBuyCount()); //您目前置业是第几次置业	
		
		customer.setRoomType(bean.getRoomType()); //您将选择的住宅面积(意向户型)
		customer.setPriceNum(bean.getPriceNum()); //您欲购买房型，多少房屋总价与您的期望相符（万元人民币）	
		customer.setBuyUse(bean.getBuyUse()); //  置业用途
		customer.setRating(bean.getRating()); //客户类型(客户评级 )	
		
		////
		customer.setCompanyId(29);
		customer.setProjectId(215); //查找依据
		
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

	private ThLaiFanBean stringToBean(String str) {
		
		if(CommonUtils.isStrEmpty(str)){
			
			return null;
		}
		
		/**
		 * 来访日期		客户姓名		手机		客户年龄							
		 * 您的家庭结构	您从事的职业		您目前居住区域	您目前置业是第几次置业	
		 * 您将选择的住宅面积(意向户型)		您欲购买房型，多少房屋总价与您的期望相符（万元人民币）	
		 * 您置业的用途		购房时主要参考的因素：（多选）	您获得我项目信息的主要途径（多选）		客户类型(客户评级 )	
		 */
		
		ThLaiFanBean bean = new ThLaiFanBean();
		
		String[] fields = str.split("\\|");
		
		bean.setVisitDate(LeadingInUtils.changeVisitDate(fields[0]));
		bean.setCustomerName(fields[1]);
		bean.setPhone(initPhone(fields[2]));
		
		bean.setAge(initAge(fields)); //客户年龄	 ok
		
		bean.setFamilyType(initFaType(fields)); //家庭结构 ok
		
		bean.setJobIndustry(initJob(fields)); //职业
		
		bean.setHomeContent(changeHomeContent(fields)); //居住区域 
		
		bean.setBuyCount(initBuyCount(fields)); //您目前置业是第几次置业	
		
		bean.setRoomType(initRoomType(fields)); //您将选择的住宅面积(意向户型)
		
		bean.setPriceNum(initPrice(fields)); //您欲购买房型，多少房屋总价与您的期望相符（万元人民币）	
		
		bean.setBuyUse(initBuyUse(fields)); //  置业用途
		
		bean.setKnownFroms(initKnownFroms(fields)); //您获得我项目信息的主要途径（多选）
		
		bean.setCustomerFocus(initCustomerFocus(fields)); //购房时主要参考的因素：（多选）
		
		bean.setRating(initRating(fields)); //客户类型(客户评级 )	
		
		return bean;
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
	
	private String initRating(String[] fields) {
		
		String[] val = new String[]{"1", "2", "3", "9"};
		
		return LeadingInUtils.getValByMapAndFields(93, val, fields);
	}
	
	private static String[] initKnownFroms(String[] fields){
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		//报纸广告 	户外广告牌	网络	电台	外展点	派单	活动	短信	车身广告	楼宇、围墙广告	途经	亲友介绍	其他 
		
		map.put(80, "1");
		map.put(81, "2");
		map.put(82, "3");
		map.put(83, "4");
		map.put(84, "5");
		
		map.put(85, "6");
		map.put(86, "7");
		map.put(87, "8");
		map.put(88, "9");
		map.put(89, "10");
		
		map.put(90, "11");
		map.put(91, "12");
		map.put(92, "13");
		
		List<String> knownList = new ArrayList<String>();
		
		for(int i=80; i<=92; i++){
			
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
		
		map.put(67, "1");
		map.put(68, "2");
		map.put(69, "3");
		map.put(70, "4");
		map.put(71, "5");
		
		map.put(72, "6");
		map.put(73, "7");
		map.put(74, "8");
		map.put(75, "9");
		map.put(76, "10");
		
		map.put(77, "11");
		map.put(78, "12");
		map.put(79, "13");
		
		List<String> focusList = new ArrayList<String>();
		
		for(int i=67; i<=79; i++){
			
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

	private String initBuyUse(String[] fields) {
		String[] val = new String[]{"1", "2", "3", "4"};
		
		return LeadingInUtils.getValByMapAndFields(63, val, fields);
	}

	private int initPrice(String[] fields) {
		
		String[] val = new String[]{"45", "50", "60", "65", "70", "75", "80", "85", "90", "95"};
		
		String ret = LeadingInUtils.getValByMapAndFields(53, val, fields);
		if(CommonUtils.isStrEmpty(ret)){
			ret = "0";
		}
		
		return Integer.parseInt(ret);
	}

	private String initRoomType(String[] fields) {
		String[] val = new String[]{"1", "2", "3", "4", "5"};
		
		return LeadingInUtils.getValByMapAndFields(48, val, fields);
	}

	private String initBuyCount(String[] fields) {
		
		String[] val = new String[]{"1", "2", "3", "4", "5"};
		
		return LeadingInUtils.getValByMapAndFields(43, val, fields);
	}

	private String changeHomeContent(String[] fields) {
		
		//流芳片区 26	九峰片区	鲁巷片区	卓刀泉	街道口	中南	南湖	阅马场	水果湖	中北路	徐东	青山	硚口	江岸	江汉	汉阳	其他

		String[] val = new String[]{"流芳片区", "九峰片区", "鲁巷片区", "卓刀泉", "街道口", "中南", "南湖", "阅马场", "水果湖", "中北路", "徐东",
				"青山", "硚口", "江岸", "江汉", "汉阳", "其他"};
		
		return LeadingInUtils.getValByMapAndFields(26, val, fields);
	}

	private String initJob(String[] fields) {
		
		String[] val = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
		
		return LeadingInUtils.getValByMapAndFields(15, val, fields);
	}

	private String initFaType(String[] fields) {
		String[] val = new String[]{"1", "2", "3", "4", "5"};
		
		return LeadingInUtils.getValByMapAndFields(10, val, fields);
	}

	private String initAge(String[] fields) {
		
		String[] val = new String[]{"1", "2", "3", "4", "5", "6", "7"};
		
		return LeadingInUtils.getValByMapAndFields(3, val, fields);
	}

}
