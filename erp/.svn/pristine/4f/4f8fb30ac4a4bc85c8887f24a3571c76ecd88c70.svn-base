package com.ihk.junit.import_cus.hubei.th;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihk.junit.import_cus.hubei.stl.LeadingInUtils;
import com.ihk.utils.CommonUtils;

/**
 * 天鸿来电 utils
 * @author dtc
 * 2013-8-21,下午06:04:07
 */
public class ThLaiDianUtils {
	
	/**
	 * 字符串转成对应的bean
	 * @param str <br/>
	 * 2011/01/09|柯女士|15871944912|*|1|*|*|*|*|*|*|*|1|*|*|*|*|*|*|1|*|*|*|*|*|*|*|
	 * @return
	 */
	public static ThLaiFanBean stringToBean(String str){
		
		if(CommonUtils.isStrEmpty(str)){
			
			return null;
		}
		
		ThLaiFanBean bean = new ThLaiFanBean();
		
		String[] fields = str.split("\\|");
		
		/**
		 * 来电日期		客户姓名		联系电话		居住区域	
		 * 需求户型		需求面积		获知途径		备注
		 */
		
		bean.setVisitDate(LeadingInUtils.changeVisitDate(fields[0]));
		bean.setCustomerName(fields[1]);
		bean.setPhone(fields[2]);
		
		bean.setHomeContent(changeHomeContent(fields)); //居住区域 ok
		
		bean.setRoomType(initRootType(fields)); //需求户型 ok
		
		bean.setAreaNum(initAreaNum(fields)); //需求面积 ok
		
		bean.setKnownFroms(initKnownFroms(fields)); //获知途径	
		
		bean.setRemark1(initRemark1(fields)); //备注
		
		return bean;
	}
	
	private static String initRemark1(String[] fields) {
		return null;
	}

	private static String initRootType(String[] fields) {
		
		String[] val = new String[]{"1", "2", "3", "4", "5"};
		
		return LeadingInUtils.getValByMapAndFields(7, val, fields);
	}

	/**
	 * 居住区域													
	 * @param fields
	 * @return
	 */
	private static String changeHomeContent(String[] fields){
		
		String ret = "";
		
		for(int i=3; i<=6; i++){
			
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
		
		map.put(3, "新城区");
		map.put(4, "老城区");
		
		map.put(5, "乡镇");
		map.put(6, "外地");
		
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
		
		map.put(12, 50);
		map.put(13, 90);
		map.put(14, 115);
		map.put(15, 200);
		
		for(int i=12; i<=15; i++){
			
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
		
		//报纸	户外	公交车身	电视广告	外展派单	途经	亲友介绍	乡下墙体广告	网络	其他
		
		map.put(16, "9");
		map.put(17, "10");
		map.put(18, "1");
		map.put(19, "3");
		map.put(20, "4");
		
		map.put(21, "5");
		map.put(22, "6");
		map.put(23, "11");
		map.put(24, "12");
		map.put(25, "13");
		
		List<String> knownList = new ArrayList<String>();
		
		for(int i=16; i<=25; i++){
			
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
	
	public static void main(String[] args) {
		
		
	}

}
