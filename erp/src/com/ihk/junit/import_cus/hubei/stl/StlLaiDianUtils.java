package com.ihk.junit.import_cus.hubei.stl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihk.utils.CommonUtils;

/**
 * 圣特立来电 utils
 * @author dtc
 * 2013-8-14,上午10:15:42
 */
public class StlLaiDianUtils {
	
	/**
	 * 字符串转成对应的bean
	 * @param str <br/>
	 * 2011/11/23|邓小姐|13871562588|1|||||||||||||||||1||||1||||||||||||||||||1||1|1|1|||||||
	 * @return
	 */
	public static StlLaiDianBean stringToBean(String str){
		
		if(CommonUtils.isStrEmpty(str)){
			
			return null;
		}
		
		StlLaiDianBean bean = new StlLaiDianBean();
		
		String[] fields = str.split("\\|");
		
		bean.setVisitDate(LeadingInUtils.changeVisitDate(fields[0]));
		bean.setCustomerName(fields[1]);
		bean.setPhone(fields[2]);
		
		bean.setHomeContent(changeHomeContent(fields));
		bean.setAreaNum(initAreaNum(fields));
		
		bean.setKnownFroms(initKnownFroms(fields));
		bean.setCustomerFocus(initCustomerFocus(fields));
		
		bean.setRemark1(fields[fields.length-1].trim());
		
		return bean;
	}
	
	/**
	 * 居住区域													
	 * @param fields
	 * @return
	 */
	private static String changeHomeContent(String[] fields){
		
		String ret = "";
		
		for(int i=3; i<=16; i++){
			
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
		
		map.put(3, "纱帽");
		map.put(4, "廖家堡");
		map.put(5, "坛山");
		map.put(6, "邓南");
		
		map.put(7, "军山");
		map.put(8, "陡埠");
		map.put(9, "沌口");
		map.put(10, "汉阳");
		
		map.put(11, "武昌");
		map.put(12, "汉口");
		map.put(13, "湘口");
		map.put(14, "蔡甸");
		
		map.put(15, "洪湖");
		map.put(16, "其他");
		
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
		
		map.put(17, 45);
		map.put(18, 80);
		map.put(19, 110);
		map.put(20, 130);
		map.put(21, 155);
		map.put(22, 170);
		
		for(int i=17; i<=22; i++){
			
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
		
		map.put(23, "11");
		map.put(24, "12");
		map.put(25, "13");
		map.put(26, "14");
		map.put(27, "15");
		map.put(28, "16");
		
		map.put(29, "21");
		map.put(30, "22");
		map.put(31, "23");
		map.put(32, "24");
		map.put(33, "25");
		
		map.put(34, "31");
		
		map.put(35, "34");
		map.put(36, "35");
		map.put(37, "36");
		map.put(38, "37");
		map.put(39, "38");
		map.put(40, "39");
		
		List<String> knownList = new ArrayList<String>();
		
		for(int i=23; i<=40; i++){
			
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
		
		map.put(41, "1");
		map.put(42, "2");
		map.put(43, "3");
		map.put(44, "4");
		map.put(45, "5");
		
		map.put(46, "6");
		map.put(47, "7");
		map.put(48, "8");
		map.put(49, "9");
		map.put(50, "10");
		
		List<String> focusList = new ArrayList<String>();
		
		for(int i=41; i<=50; i++){
			
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
