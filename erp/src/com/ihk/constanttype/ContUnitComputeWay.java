package com.ihk.constanttype;

import java.util.LinkedHashMap;

/**
 * 单元的计价方式
 * @author dtc
 * 2012-7-3
 */
public class ContUnitComputeWay {
	
	/**
	 * 先加附加再优惠减价再折,值
	 */
	public static final String FIRST = "1";  //先加附加再优惠减价再折
	
	/**
	 * 先加附加再优惠减价再折,显示
	 */
	public static final String FIRST_SHOW = "先加附加再优惠减价再折";
	
	/**
	 * 先折再附加价再优惠减价,值
	 */
	public static final String SECOND = "2"; //先折再附加价再优惠减价
	
	/**
	 * 先折再附加价再优惠减价,显示
	 */
	public static final String SECOND_SHOW = "先折再附加价再优惠减价";
	
	/**
	 * 先优惠减价再折再附加价,值
	 */
	public static final String THIRD = "3"; //先优惠减价再折再附加价
	
	/**
	 * 先优惠减价再折再附加价,显示
	 */
	public static final String THIRD_SHOW = "先优惠减价再折再附加价";
	
	/**
	 * 获取计价方式的map
	 * @return
	 */
	public static LinkedHashMap<String, String> getWayMap(){
		
		LinkedHashMap<String, String> retMap = new LinkedHashMap<String, String>();
		
		retMap.put(FIRST, FIRST_SHOW);
		retMap.put(SECOND, SECOND_SHOW);
		retMap.put(THIRD, THIRD_SHOW);
		
		return retMap;
	}

}
