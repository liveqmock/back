package com.ihk.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * String 和  int 组合比较器
 * 
 * 按升序排列
 * 数字一定在前面  之后是非数字
 * 
 * 1可以转化为数字的按数字排列 
 * 
 * 2不可以转化为数字的按string 排列
 * @author just
 */
public class ComparatorByIntAndString implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int o1int = 0;
		int o2int = 0;
		
		try {//如果是不能转换的
			o1int = Integer.parseInt(o1);
		} catch (Exception e) {
			o1int = 999999;
		}
		try {
			o2int = Integer.parseInt(o2);
		} catch (Exception e) {
			o2int = 999999;
		}
		
		if(o1int < 999999 && o2int < 999999){//都可以是纯数字
			return (int) Math.signum(o1int - o2int);
		}
		if(o1int == 999999 && o2int == 999999){//都是不可转换的
			if(o1.trim().equals(o2.trim()))return 0;
			List<String> bijiao = new LinkedList<String>();
			bijiao.add(o1.trim());
			bijiao.add(o2.trim());
			Collections.sort(bijiao);
			if(bijiao.get(0).equals(o1.trim())){
				return -1;
			}else{
				return 1;
			}
		}
		if(o1int == 999999 && o2int < 999999){//都是不可转换的
			return -1;
		}
		if(o1int < 999999&& o2int == 999999){//都是不可转换的
			return 1;
		}
		return 0;
	}

}
