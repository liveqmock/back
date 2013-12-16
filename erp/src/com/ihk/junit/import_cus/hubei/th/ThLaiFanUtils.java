package com.ihk.junit.import_cus.hubei.th;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihk.junit.import_cus.hubei.stl.LeadingInUtils;
import com.ihk.utils.CommonUtils;

/**
 * 天鸿来访 utils
 * @author dtc
 * 2013-8-14,上午10:15:42
 */
public class ThLaiFanUtils {
	
	/**
	 * 字符串转成对应的bean
	 * @param str <br/>
	 * 2011/11/23|邓小姐|13871562588|1|||||||||||||||||1||||1||||||||||||||||||1||1|1|1|||||||
	 * @return
	 */
	public static ThLaiFanBean stringToBean(String str){
		
		if(CommonUtils.isStrEmpty(str)){
			
			return null;
		}
		
		ThLaiFanBean bean = new ThLaiFanBean();
		
		String[] fields = str.split("\\|");
		
		/**
		 * 来访日期		客户姓名			联系电话			客户年龄						
		 * 居住区域		工作区域	 	职业							
		 * 获知途径		面积			商铺总价承受情况	
		 * 交通方式           置业用途		对本项目认同因素（复选）-->关注点											
		 */
		
		bean.setVisitDate(LeadingInUtils.changeVisitDate(fields[0]));
		bean.setCustomerName(fields[1]);
		bean.setPhone(fields[2]);
		
		bean.setAge(initAge(fields)); //客户年龄	 ok
		
		bean.setHomeContent(changeHomeContent(fields)); //居住区域 ok
		bean.setWorkContent(initWorkContent(fields)); //工作区域 ok
		
		bean.setJobIndustry(initJob(fields)); //职业 ok
		
		bean.setAreaNum(initAreaNum(fields)); //面积 ok
		
		bean.setPriceNum(initPrice(fields)); //商铺总价承受情况  ok
		
		bean.setTrafficDesc(initTra(fields)); //交通方式 ok
		
		bean.setBuyUse(initBuyUse(fields)); //  置业用途 ok
		
		bean.setKnownFroms(initKnownFroms(fields)); //获知途径 ok
		
		bean.setCustomerFocus(initCustomerFocus(fields)); //对本项目认同因素（复选）-->关注点	 ok
		
		return bean;
	}
	
	private static String initBuyUse(String[] fields) {
		
		String[] val = new String[]{"1", "2", "3", "4"};
		
		return LeadingInUtils.getValByMapAndFields(52, val, fields);
		
	}

	private static String initTra(String[] fields) {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		//私家车 -- 47	出租车	摩托车/电动	公共汽车	步行
		
		map.put(47, "私家车");
		map.put(48, "出租车");
		map.put(49, "摩托车/电动");
		map.put(50, "公共汽车");
		map.put(51, "步行");
		
		int index = 0;
		
		for(int i=47; i<=51; i++){
			
			if(!"*".equals(fields[i])){
				
				index = i;
				break;
			}
		}
		
		return index == 0 ? "" : map.get(index);
		
	}

	private static int initPrice(String[] fields) {
		
		//30	40	60	85	115	130 
		//41  -- 46
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		map.put(41, 30);
		map.put(42, 40);
		map.put(43, 60);
		map.put(44, 85);
		map.put(45, 115);
		map.put(46, 130);
		
		int index = 0;
		
		for(int i=41; i<=46; i++){
			
			if(!"*".equals(fields[i])){
				
				index = i;
				break;
			}
		}
		
		return index == 0 ? 0 : map.get(index);
	}

	private static String initJob(String[] fields) {
		//18 - 24
		
		String ret = "";
		
		for(int i=18; i<=24; i++){
			
			if(!"*".equals(fields[i])){
				
				ret = (i - 17) + "";
				break;
			}
		}
		
		return ret;
		
	}

	private static String initWorkContent(String[] fields) {
		
		String ret = "";
		
		for(int i=13; i<=17; i++){
			
			if(!"*".equals(fields[i])){
				
				ret = _initWorkContent(i);
				break;
			}
		}
		
		return ret;
	}
	
	private static String _initWorkContent(int index){
		
		String ret = "";
		
		switch (index) {
		case 13:{
			
			ret = "新城区";
			break;
		}
		case 14:{
			
			ret = "老城区";
			break;
		}
		case 15:{
					
			ret = "乡镇";
			break;
		}
		case 16:{
			
			ret = "咸宁/武汉";
			break;
		}
		case 17:{
			
			ret = "外地/沪广深";
			break;
		}
		default:
			break;
		}
		
		return ret;
	}

	/**
	 * 客户年龄					
	 * @param fields
	 * @return
	 */
	private static String initAge(String[] fields){
		
		String ret = "";
		
		for(int i=3; i<=8; i++){
			
			if(!"*".equals(fields[i])){
				
				ret = (i - 2) + "";
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
		
		for(int i=9; i<=12; i++){
			
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
		
		map.put(9, "新城区");
		map.put(10, "老城区");
		
		map.put(11, "乡镇");
		map.put(12, "外地");
		
		return map.get(index);
	}
	
	/**
	 * 需求面积
	 * @param fields
	 * @return
	 */
	private static int initAreaNum(String[] fields){
		
		int ret = 0;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//35 - 40
		//50 85	115	200	100	100
		
		map.put(35, 50);
		map.put(36, 85);
		map.put(37, 115);
		map.put(38, 200);
		map.put(39, 100);
		map.put(40, 100);
		
		for(int i=35; i<=40; i++){
			
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
		
		//公交车身	户外灯箱道旗	电视广告	外展派单	途经	 亲友介绍	6	短信	围墙/楼体	报纸9	其他 13
		
		map.put(25, "1");
		map.put(26, "2");
		map.put(27, "3");
		map.put(28, "4");
		map.put(29, "5");
		
		map.put(30, "6");
		map.put(31, "7");
		map.put(32, "8");
		map.put(33, "9");
		map.put(34, "13");
		
		List<String> knownList = new ArrayList<String>();
		
		for(int i=25; i<=34; i++){
			
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
		
		//地理位置	社区绿化景观	升值潜力	区域配套	户型设计
		//交通便利	合理价格	物业管理	建筑特色	投资收益回报	建筑质量	开发商品牌
		
		map.put(56, "1");
		map.put(57, "2");
		map.put(58, "3");
		map.put(59, "4");
		map.put(60, "5");
		
		map.put(61, "6");
		map.put(62, "7");
		map.put(63, "8");
		map.put(64, "9");
		map.put(65, "10");
		
		List<String> focusList = new ArrayList<String>();
		
		for(int i=56; i<=65; i++){
			
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
	
	public static void main(String[] args) {
		
		String str = "2011/11/28|刘先生|13797076877|*|*|*|*|*|*|*|*|*|*|1|*|*|*|*|1|*|*|*|*|*|*|*|*|*|*|*|1|*|*|*|*|*|*|*|*|*|*|*|*|1|*|1|*|*|*|*|*|*|";
		
		String[] arr = str.split("\\|");
		
		System.out.println(initCustomerFocus(arr));
		
	}

}
