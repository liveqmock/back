package com.ihk.utils.pinyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

public class PinyinBaseUtils {

	/**
	 * 中文转pinyin
	 * */
	public static String znTopinyin(String zn)
			 {
		if (zn == null || zn.trim().equals(""))
			return null;

		char[] c = zn.toCharArray();

		StringBuffer st = new StringBuffer("");

		HanyuPinyinOutputFormat formart = new HanyuPinyinOutputFormat();
		formart.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

		for (char cc : c) {
			try {
				st.append(PinyinHelper.toHanyuPinyinStringArray(cc, formart)[0]);
			} catch (Exception e) {
				// TODO 碰到数字或者英文不能解析的
				st.append(cc);
			}
		}
		return st.toString();
	}

	public static boolean isEn(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
					&& !(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * 获取字符串的各个字的首字母,大写
	 * @param str
	 * @return
	 */
	public static String getPinYinHeadChar(String str) {

		String convert = "";
		for (int j = 0; j < str.length(); j++) {
			char word = str.charAt(j);
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (pinyinArray != null) {
				convert += pinyinArray[0].charAt(0);
			} else {
				convert += word;
			}
		}
		return convert.toUpperCase();
	}
	
}
