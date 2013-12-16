package com.ihk.junit.import_cus.hubei.stl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihk.utils.CommonUtils;

/**
 * 圣特立来访 utils
 * @author dtc
 * 2013-8-15,下午03:48:20
 */
public class StlLaiFanUtils {
	
	/**
	 * 字符串转成对应的bean
	 * @param str
	 * @return
	 */
	public static StlLaiFanBean stringToBean(String str){
		
		if(CommonUtils.isStrEmpty(str)){
			
			return null;
		}
		
		StlLaiFanBean bean = new StlLaiFanBean();
		
		String[] fields = str.split("\\|");
		
		bean.setVisitDate(LeadingInUtils.changeVisitDate(fields[0]));
		bean.setCustomerName(fields[1]);
		bean.setPhone(fields[2]);
		
		bean.setAge(initAge(fields)); //年龄 ok
		
		bean.setKnownFroms(initKnownFroms(fields)); //ok
		
		bean.setHomeContent(changeHomeContent(fields)); //居住区域 ok											

		bean.setAreaNum(initAreaNum(fields));//面积需求 ok
		
		bean.setBuyUse(initBuyUse(fields));  //购买动机	ok	
		
		bean.setBuyCount(setBuyCount(fields)); //置业次数 ok		
		
		bean.setJobIndustry(setJobIndustry(fields)); //单位性质	ok					

		bean.setTrafficDesc(setTrafficDesc(fields)); //家庭汽车,手填 ok				

		bean.setHouseType(setHouseType(fields)); //产品需求	ok		
		
		bean.setCustomerFocus(initCustomerFocus(fields)); //关注因素	ok												

		bean.setRating(setRating(fields)); //客户级别 ok		
		
		bean.setRemark1(fields[fields.length-2].trim()); //备注 ok
		
		bean.setGender(setGender(fields)); //性别 ok
		
		return bean;
	}
	
	/**
	 * 性别
	 * @param fields
	 * @return
	 */
	private static String setGender(String[] fields){
		
		String val = fields[fields.length-1].trim();
		
		if(CommonUtils.isStrEmpty(val)){
			return "";
		}
		
		if("男".equals(val)){
			
			return "1";
		}
		
		return "0";
	}
	
	/**
	 * 客户级别		
	 * @param fields
	 * @return
	 */
	private static String setRating(String[] fields){
		
		String[] arr = new String[]{"1", "2", "3", "9"};
		
		return LeadingInUtils.getValByMapAndFields(89, arr, fields);
	}
	
	/**
	 * 产品需求		
	 * @param fields
	 * @return
	 */
	private static String setHouseType(String[] fields){
		
		String[] arr = new String[]{"1", "2", "3", "4"};
		
		return LeadingInUtils.getValByMapAndFields(70, arr, fields);
	}
	
	/**
	 * 家庭汽车,手填			
	 * @param fields
	 * @return
	 */
	private static String setTrafficDesc(String[] fields){
		
		String[] arr = new String[]{"1辆", "2辆", "3辆或以上", "无,未来2年之内打算", "无,暂时没打算买"};
		
		return LeadingInUtils.getValByMapAndFields(64, arr, fields);
	}
	
	/**
	 * 单位性质		
	 * @param fields
	 * @return
	 */
	private static String setJobIndustry(String[] fields){
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(58, "1");
		map.put(59, "2");
		map.put(60, "3");
		map.put(61, "4");
		
		map.put(62, "21");
		map.put(63, "22");
		map.put(64, "23");
		
		return LeadingInUtils.getValByMapAndFields(map, fields);
	}
	
	/**
	 * 置业次数
	 * @param fields
	 * @return
	 */
	private static String setBuyCount(String[] fields){
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(53, "1");
		map.put(54, "2");
		map.put(55, "3");
		map.put(56, "4");
		map.put(57, "4");
		
		return LeadingInUtils.getValByMapAndFields(map, fields);
	}
	
	/**
	 * 购买动机
	 * @param fields
	 * @return
	 */
	private static String initBuyUse(String[] fields){
		
		String ret = "";
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(50, "1");
		map.put(51, "2");
		map.put(52, "3");
		
		for(int i=50; i<=52; i++){
			
			if(!"*".equals(fields[i])){
				
				ret = map.get(i);
				break;
			}
		}
		
		return ret;
	}
	
	/**
	 * 年龄
	 * @param fields
	 * @return
	 */
	private static String initAge(String[] fields){
		
		String ret = "";
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(3, "1");
		map.put(4, "2");
		map.put(5, "3");
		map.put(6, "4");
		map.put(7, "5");
		map.put(8, "6");
		
		for(int i=3; i<=8; i++){
			
			if(!"*".equals(fields[i])){
				
				ret = map.get(i);
				break;
			}
		}
		
		return ret;
		
	}
	
	/**
	 * 居住区域													
	 * @param fields
	 * @return
	 */
	private static String changeHomeContent(String[] fields){
		
		String ret = "";
		
		for(int i=28; i<=43; i++){
			
			if(!"*".equals(fields[i])){
				
				ret = _HomeContent(i);
				break;
			}
		}
		
		return ret;
	}
	
	/**
	 * 根据下标获取对应的值
	 * @param index
	 * @return
	 */
	private static String _HomeContent(int index){
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(28, "纱帽");
		map.put(29, "廖家堡");
		map.put(30, "坛山");
		map.put(31, "邓南");
		
		map.put(32, "军山");
		map.put(33, "东城院");
		map.put(34, "湘口");
		map.put(35, "大咀");
		
		map.put(36, "乌金");
		map.put(37, "沌口");
		map.put(38, "汉阳");
		map.put(39, "武昌");
		
		map.put(40, "汉口");
		map.put(41, "蔡甸");
		
		map.put(42, "洪湖");
		map.put(43, "其他");
		
		return map.get(index);
	}
	
	/**
	 * 需求面积
	 * @param fields
	 * @return
	 * 
	 * 40-50	70-100	101-120	121-140	141-170	170以上
	 */
	private static int initAreaNum(String[] fields){
		
		int ret = 0;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		map.put(44, 45);
		map.put(45, 85);
		map.put(46, 110);
		map.put(47, 130);
		map.put(48, 155);
		map.put(49, 170);
		
		for(int i=44; i<=49; i++){
			
			if(!"*".equals(fields[i])){
				
				ret = map.get(i);
				break;
			}
		}
		
		return ret;
	}
	
	/**
	 * 获知途径
	 * @param fields
	 * @return
	 */
	private static String[] initKnownFroms(String[] fields){
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(9, "11");
		map.put(10, "12");
		map.put(11, "13");
		map.put(12, "14");
		map.put(13, "15");
		map.put(14, "16");
		
		map.put(15, "22");
		map.put(16, "23");
		map.put(17, "24");
		map.put(18, "25");
		
		map.put(19, "31");
		
		map.put(20, "21");
		
		map.put(21, "35");
		map.put(22, "40");
		
		map.put(23, "34");
		map.put(24, "41");
		map.put(25, "38");
		
		map.put(26, "42");
		map.put(27, "39");
		
		List<String> knownList = new ArrayList<String>();
		
		for(int i=9; i<=27; i++){
			
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
	
	/**
	 * 关注点
	 * @param fields
	 * @return
	 */
	private static String[] initCustomerFocus(String[] fields){
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(74, "3");
		map.put(75, "13");
		map.put(76, "8");
		map.put(77, "11");
		map.put(78, "14");
		
		map.put(79, "15");
		map.put(80, "12");
		map.put(81, "16");
		map.put(82, "17");
		map.put(83, "19");
		
		map.put(84, "20");
		map.put(85, "18");
		map.put(86, "4");
		map.put(87, "21");
		map.put(88, "22");
		
		List<String> focusList = new ArrayList<String>();
		
		for(int i=74; i<=88; i++){
			
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

}
