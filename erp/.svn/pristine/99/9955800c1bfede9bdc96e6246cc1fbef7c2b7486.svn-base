package com.ihk.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;

import com.ihk.user.data.pojo.UserAccount;

/**
 * 共用帮助类
 * @author dtc
 * 2012-9-29
 */
public class CommonUtils {
	
	//表示是否删除
	public final static String DELETED = "1";  //1表示删除或作废
	
	public final static String NORMAL = "0";   //0表示正常
	
	//表示男女
	
	
	//客户状态
	public final static String CUSTOMER_STATE_ALL = "0"; //所有状态
	
	public final static String CUSTOMER_STATE_FOLLOW = "1";  //跟进中
	
	public final static String CUSTOMER_STATE_DEAL = "2"; //已成交
	
	public final static String CUSTOMER_STATE_NOT_FOLLOW = "3"; //不再跟进
	
	
	//操作提示
	public final static String SUCCSUGG = "操作成功";
	
	public final static String FAILSUGG = "操作失败,请重试";
	
	public final static String MODIFY = "该条数据录入已经超过了一天,更高权限才能修改";
	
	public final static String TOKEN = "重复提交,可能已经录入成功,请查询后再录入";
	
	
	//管理员状态
	public final static String ADMIN = "2";  //管理员
	
	public final static String MANAGER = "1"; //普通用户
	
	public final static Integer ADMININT = 2;
	
	//所有
	public final static String ALL = "全部";
	
	public final static String TRUE_STR = "1"; //是
	
	public final static String FALSE_STR = "0"; //否
	
	public final static String TRUE = "是";
	
	public final static String FALSE = "否";
	
	//性别
	public final static String MALE = "男";
	
	public final static String FEMALE = "女";
	
	
	//请选择
	public final static String EMPTY = "请选择";
	
	//一天的毫秒数
	public final static long ONE_DAY = 24 * 60 * 60 * 1000;
	
	//1千
	public final static int THOUSAND = 1000;

	//1万
	public final static int TENTHOUSAND = 10000;
	
	public final static String JSON_LEFT = "[";
	public final static String JSON_RIGHT = "]";
	
	/**
	 * session中要保存的SearchCond的参数名
	 * 原先的public final static String COND = "cond";在新的框架下,可能会出现问题,
	 * 应该根据请求参数来判断
	 * 用方法getCondSessionKey()替代
	 */
	public final static String COND = "_cond_";
	
	/**
	 * 连接符,逗号
	 */
	public final static String FILTER_LIMIT = ",";
	
	public final static String ADD_SELECT_VALUE = "-1"; 
	public final static String ADD_SELECT_TEXT = "<<  >>"; 
	
	/**
	 * userAccount登陆成功后的session key
	 */
	public final static String USER_SESSION_KEY = "loginAccount";
	
	/**
	 * 登陆用户总数application key
	 */
	public final static String APPLICATION_KEY = "userAccount_binding_listener";
	
	public static String getCompleteName(String value){
		//获取提示框中的值,格式为:天銮(1)
		
		String retValue = "";
		
		if(!isStrEmpty(value)){
			try{
				retValue = value.substring(0, value.lastIndexOf("("));
			}catch(Exception e){
				retValue = value;
			}
		}
		
		return retValue;
	}
	
	public static int getCompleteId(String value){
		//获取提示框中的id,格式为:天銮(1)
		
		int retValue = 0;
		
		if(!isStrEmpty(value)){
			try{
				int start = value.lastIndexOf("(") + 1;
				int end = value.lastIndexOf(")");
				String idStr = value.substring(start, end);
				retValue = Integer.parseInt(idStr);
			}catch(Exception e){
				retValue = 0;
			}
			
		}
		
		return retValue; //返回值为0的时候说明值有问题
	}
	
	public static int getCompleteUserIdByUserName(String name){
		
		int retValue = 0;
		
		if(!isStrEmpty(name)){
			try{
				int start = name.lastIndexOf("(") + 1;
				int end = name.lastIndexOf(")");
				String userName = name.substring(start, end);
				
				UserAccount user = DescUtils.getUserAccountByUserName(userName);
				
				retValue = user.getId();
			}catch(Exception e){
				retValue = 0;
			}
			
		}
		
		return retValue; //返回值为0的时候说明值有问题
	}
	
	public static String getNowForLocalString(){
		//获取当前日期及时间
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
	
	public static String getNowForString(){
		//获取当前日期
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	
	/**
	 * 获取日期的年月日时分秒
	 * @param date
	 * @return
	 */
	public static String getDateLocalString(Date date){
		//根据参数转成String
        if(date==null) return "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
	
	public static String getDateString(Date date){
		//根据参数转成String
        if(date==null) return "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	
	public static Date getDateFromString(String date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date parseDate = null;
		try {
			parseDate =(Date)df.parse(date);
		} catch (ParseException e) {
		}
		
		return parseDate;
	}
	
	public static String getOneWeekBeforeForString(){
		//获取当前日期的前七天
		Date date = new Date();
		Date weekLaterDate = new Date(date.getTime() - 7 * ONE_DAY);
		
		return getDateString(weekLaterDate);
	}

	public static String getOneMonthsBeforeForString(){
		//根据参数获取前30天
		Date date = new Date();
		Date tt = new Date(date.getTime() - 30 * ONE_DAY);
		
		return getDateString(tt);
	}
	
	public static String getOneWeekBeforeForString(Date date){
		//根据参数获取前七天
		Date weekLaterDate = new Date(date.getTime() - 7 * ONE_DAY);
		
		return getDateString(weekLaterDate);
	}
	
	public static String getOneDayBeforeForString(Date date){
		
		Date oneLaterDate = new Date(date.getTime() - ONE_DAY);
		
		return getDateString(oneLaterDate);
	}
	
	public static String getWeekFirstForString(){
		//获取当前日期自然周的第一天
		
		Calendar cal = Calendar.getInstance();     
	    cal.set(Calendar.DAY_OF_WEEK,cal.getActualMinimum(Calendar.DATE)); //默认为星期天  
	    long monday = cal.getTime().getTime() + ONE_DAY; //星期一 或者使用setFirstDayOfWeek
	    Date date = new Date(monday);
        
	    return  new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	public static String getLastWeekFirstForString(){
		//获取当前日期上周自然周的第一天
		
		Calendar cal = Calendar.getInstance();     
	    cal.set(Calendar.DAY_OF_WEEK,cal.getActualMinimum(Calendar.DATE)); //默认为星期天  
	    long monday = cal.getTime().getTime() - 6 * ONE_DAY; //星期一 或者使用setFirstDayOfWeek
	    Date date = new Date(monday);
        
	    return  new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	public static String getWeekEndForString(){
		//获取当前日期自然周的最后一天
		
		Calendar cal = Calendar.getInstance();     
	    cal.set(Calendar.DAY_OF_WEEK,cal.getActualMinimum(Calendar.DATE)); //默认为星期天
	    long sunday = cal.getTime().getTime() + 7 * ONE_DAY;
        
	    return  new SimpleDateFormat("yyyy-MM-dd").format(sunday);
	}
	
	public static String getLastWeekEndForString(){
		//获取当前日期上周自然周的最后一天
		
		Calendar cal = Calendar.getInstance();     
	    cal.set(Calendar.DAY_OF_WEEK,cal.getActualMinimum(Calendar.DATE)); //默认为星期天
	    long sunday = cal.getTime().getTime();
        
	    return  new SimpleDateFormat("yyyy-MM-dd").format(sunday);
	}
	
	public static String getWeekFirstForString(String srcDate){
		//获取参数日期自然周的第一天

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date parseDate = null;
		try {
			parseDate = df.parse(srcDate);
		} catch (ParseException e) {
			parseDate = new Date();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(parseDate);
		
		int index = cal.get(Calendar.DAY_OF_WEEK); //为星期几, 周日为1, 周六为7
		long dayLong = cal.getTime().getTime();
		if(index == 1){
			dayLong -= 6 * ONE_DAY;
		}else{
			dayLong += (2 - index) * ONE_DAY;
		}
		
		/*
		cal.set(Calendar.DAY_OF_WEEK,cal.getActualMinimum(Calendar.DATE)); //默认为星期天  
	    long monday = cal.getTime().getTime() + ONE_DAY; //星期一 或者使用setFirstDayOfWeek
	    Date date = new Date(monday);
		*/
		
		Date date = new Date(dayLong);
	    return  new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	public static String getWeekEndForString(String srcDate){
		//获取参数日期自然周的最后一天
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date parseDate = null;
		try {
			parseDate =(Date)df.parse(srcDate);
		} catch (ParseException e) {
			e.printStackTrace();
			parseDate = new Date();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(parseDate);
		
		int index = cal.get(Calendar.DAY_OF_WEEK); //为星期几, 周日为1, 周六为7
		long dayLong = cal.getTime().getTime();
		if(index > 1){
			dayLong += (8 - index) * ONE_DAY;
		}
		
		Date date = new Date(dayLong);
	    return  new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	public static String getMonthFirstForString(){
		//获取当前日期自然月的第一天
		
		Calendar cal = Calendar.getInstance();     
	    cal.set(Calendar.DAY_OF_MONTH,cal.getActualMinimum(Calendar.DATE));  
        
	    return  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}
	
	public static String getLastMonthFirstForString(){
		//获取当前日期自然月上月的第一天
		
		String monthEndDay = getLastMonthEndForString();
        
	    return  getMonthFirstForString(monthEndDay);
	}
	
	public static String getMonthFirstForString(String srcDate){
		//获取参数日期自然月的第一天
		int last = srcDate.lastIndexOf("-");
		return srcDate.substring(0, last) + "-01";
	}
	
	public static String getMonthEndForString(){
		//获取当前日期自然月最后一天
		
		Calendar cal = Calendar.getInstance();     
	    cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));  
        
	    return  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}
	
	public static String getMonthEndForString(String date){
		//获取参数日期自然月最后一天
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(getDateFromString(date));
	    cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));  
        
	    return  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}
	
	public static String getLastMonthEndForString(){
		//获取当前日期自然月上月最后一天
		
		Calendar cal = Calendar.getInstance();     
	    cal.set(Calendar.DAY_OF_MONTH,cal.getActualMinimum(Calendar.DATE));  
	    
	    long lastDay = cal.getTime().getTime() - ONE_DAY;
        
	    return  new SimpleDateFormat("yyyy-MM-dd").format(new Date(lastDay));
	}
	
	public static String getYearFirstForString(){
		//获取当前日期的年的第一天
		Calendar cal = Calendar.getInstance();     
	    cal.set(Calendar.DAY_OF_YEAR,cal.getActualMinimum(Calendar.DATE));  
        
	    return  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}
	
	public static String getYearFirstForString(String srcDate){
		int first = srcDate.indexOf("-");
		return srcDate.substring(0, first) + "-01-01";
		
	}
	
	public static String getYearEndForString(){
		//获取当前日期的年的最后一天
		Calendar cal = Calendar.getInstance();     
	    cal.set(Calendar.DAY_OF_YEAR,cal.getActualMinimum(Calendar.DATE));  
	    
	    String thisYear = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	    int first = thisYear.indexOf("-");
        
	    return thisYear.substring(0, first) + "-12-31";
	}
	
	public static String getYearEndForString(String srcDate){
		int first = srcDate.indexOf("-");
		return srcDate.substring(0, first) + "-12-31";
		
	}
	
	public static boolean isAfterToday(String monitorDateString){
		//判断日期是否超过今天
		boolean isAfterToday = false;
		
		Date now = new Date();
		
		String srcDateString = getDateString(now);
		String source = srcDateString + " 23:59:59";
		String desc = monitorDateString + " 00:00:00";
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date sourceDate = df.parse(source);
			Date descDate = df.parse(desc);
			
			if(sourceDate.getTime() < descDate.getTime()){
				isAfterToday = true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return isAfterToday;
	}
	
	/**
	 * 判断是否超过单天24时，scrDate 为源日期，descDate 为日标日期,改为有没有超出当天的00:00:00
	 * @param srcDate
	 * @param descDate
	 * @return
	 */
	public static boolean isOneDayLater(Date srcDate, Date descDate){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //24小时制, yyyy-MM-dd hh:mm:ss  12小时制
		String createDateTime = df.format(srcDate);
		String nowDateTime = df.format(descDate);
		
		String[] src = createDateTime.split(" ");
		String[] desc = nowDateTime.split(" ");
		
		boolean isOneDayLater = false;
		
		try{
			String srcDateString = src[0];
			String descDateString = desc[0];
			
			String source = srcDateString + " 23:59:59";
			Date sourceDate = df.parse(source);
			
			if(srcDateString.equals(descDateString) && descDate.getTime()<=sourceDate.getTime()){
				isOneDayLater = false;
			}else{
				isOneDayLater = true;
			}
			
		}catch(Exception e){
			isOneDayLater = true;
		}
		
		return isOneDayLater;
		
	}
	
	/**
	 * 判断srcDate是否超过descDate 24小时
	 * @param srcDate
	 * @param descDate
	 * @return
	 */
	public static boolean is24HoursLater(Date srcDate, Date descDate){
		
		long srcLong = srcDate.getTime();
		long descLong = descDate.getTime();
		
		if(srcLong - descLong > ONE_DAY)
			return true;
		
		return false;
	}
	
	/**
	 * 判断当前时间是否超过目标日期24小时
	 * @param descDate
	 * @return
	 */
	public static boolean is24HoursLater(Date descDate){
		return is24HoursLater(new Date(), descDate);
	}
	
	/**
	 * 获取后几天的日期
	 * @param oldDate
	 * @param afterDay
	 * @return
	 */
	public static String getAfterDate(Date oldDate, int afterDay){
		
		long oldDateLong = oldDate.getTime();
		long newDateLong = oldDateLong + (afterDay * ONE_DAY);
		
		Date newDate = new Date(newDateLong);
		
		return getDateString(newDate);
	}
	
	/**
	 * 获取参数日期的后几天日期
	 * @param oldDate
	 * @param afterDay
	 * @return
	 */
	public static Date getAfterDateForDay(Date oldDate, int afterDay){
		
		long oldDateLong = oldDate.getTime();
		long newDateLong = oldDateLong + (afterDay * ONE_DAY);
		
		Date newDate = new Date(newDateLong);
		
		return newDate;
	}
	
	/**
	 * 判断Collection是否为null或空
	 * @param coll
	 * @return
	 */
	public static boolean isCollectionEmpty(Collection<?> coll){
		
		if(coll == null || coll.size() <= 0){
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * 判断数组是否为null或空
	 * @param arr
	 * @return
	 */
	public static boolean isCollectionEmpty(Object[] arr){
		
		if(arr == null || arr.length <= 0){
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * 判断map是否为null或空
	 * @param map
	 * @return
	 */
	public static boolean isMapEmpty(Map<?, ?> map){
		
		if(map == null || map.size() <= 0){
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * 判断String是否为空
	 * @param str
	 * @return
	 */
	public static boolean isStrEmpty(String str){
		//直接用String的isEmpty()判断null是会出错
		if(str == null || "".equals(str.trim())){
			return true;
		}
		return false;
	}
	public static boolean isStrEmpty(String[] str){
		//直接用String的isEmpty()判断null是会出错
		if(str == null || str.length==0){
			return true;
		}
		return false;
	}
    public static boolean isStrEmpty(Object obj){
        //直接用String的isEmpty()判断null是会出错
        if(obj == null){
            return true;
        }
        return false;
    }

	/**
	 * 判断String是否为0或空
	 * @param str
	 * @return
	 */
	public static boolean isStrZeroEmpty(String str){
		
		if(str == null || "".equals(str.trim()) || "0".equals(str)){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 判断String是否为js的空
	 * @param str
	 * @return
	 */
	public static boolean isStrZeroJsEmpty(String str){
		
		if(str == null || "".equals(str.trim()) || "0".equals(str) || "undefined".equals(str)){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 获取下拉框select的option
	 * @param map
	 * @param selectValue
	 * @param isPutEmpty
	 * @return
	 */
	public static String getSelectContent(Map<String, String> map, String selectValue, boolean isPutEmpty){
		
		String content = "<option value=\'\'>" + EMPTY + "</option>"; //默认值
		
		StringBuffer sb = new StringBuffer();
		
		if(map != null && map.keySet().size() > 0){
			
			if(isPutEmpty){
				sb.append(content);
			}
			
			Set<String> keys = map.keySet();
			for(String key : keys){
				String value = map.get(key);
				sb.append("<option value=\'").append(key).append("\' ");
				if(key.equals(selectValue)){
					sb.append("selected='selected'");
				}
				sb.append(">").append(value).append("</option>");
				
			}
			
		}
		
		String getContent = sb.toString();
		if(!CustomerUtils.isStrEmpty(getContent)){
			
			content = getContent;
		}else{
			
			if(!isPutEmpty){
				content = "";
			}
			
		}
		
		return content;
	}
	
	public static String getSelectContent(Map<String, String> map, boolean isPutEmpty){
		
		return getSelectContent(map, "", isPutEmpty);
	}
	
	public static String getSelectContent(Map<String, String> map, String selectValue){
		
		return getSelectContent(map, selectValue, false);
	}
	
	public static String getSelectContent(Map<String, String> map){
		
		return getSelectContent(map, false);
	}
	
	/**
	 * 获取所有字段的map,value为Object
	 * @param pojo
	 * @return
	 */
	public static Map<String, Object> getPojoMap(Serializable pojo){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Field[] fields = pojo.getClass().getDeclaredFields(); //本身的字段,getFields()为其对应接口的字段
		
		for(Field field : fields){
			
			String fieldName = field.getName();
			if("serialVersionUID".equalsIgnoreCase(fieldName))
				continue;
			
			try {
				
				Object value = PropertyUtils.getProperty(pojo, fieldName);
				map.put(fieldName, value);
				
			} catch (Exception e) {
			}
		}
		
		return map;
	}

	/**
	 * 根据字段及pojo,组成map,key为字段,value为pojo对应的值
	 * @param pojo
	 * @param fields
	 * @return
	 */
	public static Map<String, String> getPojoMap(Serializable pojo, List<String> fields){
		return getPojoMap(pojo, fields, "");
	}
	
	/**
	 * 根据字段及pojo,组成map,key为字段,value为pojo对应的值
	 * @param pojo
	 * @param fields
	 * @param prefix
	 * @return
	 */
	public static Map<String, String> getPojoMap(Serializable pojo, List<String> fields, String prefix){
		
		Map<String, String> map = new HashMap<String, String>();
		for(String field : fields){
			String value = "";
			try {
				Object obj = PropertyUtils.getProperty(pojo, field);
				if(obj != null){
					value = obj.toString();
				}
				
			} catch (Exception e) {
			}
			
			map.put(prefix+field, value);
			
		}
		
		return map;
	}
	

	/**
	 * List转换成Json格式
	 * [{...},{...},{...},...]
	 * @param mapList
	 * @return
	 */
	public static String getMapJsonAnd(List<Map<String, String>> mapList){

		StringBuilder sb  = new StringBuilder();
		sb.append(JSON_LEFT);
		for(int i=0;i<mapList.size();i++){
			sb.append(getMapJson(mapList.get(i)));
			
			if(i<mapList.size()-1){
				sb.append(",");				
			}
		}
		sb.append(JSON_RIGHT);
		return sb.toString();
		
	}
	
	/**
	 * 返回map的json格式{...}
	 * @param map
	 * @return
	 */
	public static String getMapJson(Map<String, String> map){
		
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		
		StringBuffer tmp = new StringBuffer();
		for(String key : map.keySet()){
			String value = map.get(key);
			
			tmp.append("\"")
				.append(key)
				.append("\":\"")
				.append(value == null ? "" : value)
				.append("\",")
				;
			
		}
		
		String tmpStr = tmp.toString();
		int length = tmpStr.length();
		
		if(length > 0){
			tmpStr = tmpStr.substring(0, length-1);
		}
		
		sb.append(tmpStr)
			.append("}")
			;
		
		return sb.toString();
	}
	
	/**
	 * 返回[{...}]的格式
	 * @param map
	 * @return
	 */
	public static String getMapJsonAnd(Map<String, String> map){
		
		StringBuilder sb  = new StringBuilder();
		
		sb.append(JSON_LEFT).append(getMapJson(map)).append(JSON_RIGHT);
		
		return sb.toString();
		
	}
	
	public static String getListMapJsonAnd(List<Map<String, String>> listMap){
		
		StringBuffer sb = new StringBuffer();
		
		for(Map<String, String> map : listMap){
			
			sb.append(getMapJson(map)).append(",");
		}
		
		return JSON_LEFT + removeLastChar(sb.toString()) + JSON_RIGHT;
	}
	
	/**
	 * 重新设定map的key和value的名称,组装成json
	 * @param map
	 * @param keyName
	 * @param valueName
	 * @return
	 */
	public static String getMapJsonSetUpKeyAndValueName(Map<String, String> map, String keyName, String valueName){
		
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		
		Map<String, String> tmpMap = null;
		
		Set<String> keys = map.keySet();
		for(String key : keys){
			
			tmpMap = new LinkedHashMap<String, String>();
			
			String value = map.get(key);
			tmpMap.put(keyName, key);
			tmpMap.put(valueName, value);
			
			listMap.add(tmpMap);
			
		}
		
		return getListMapJsonAnd(listMap);
	}
	
	/**
	 * 重新设定map的key和value的名称,及判断check的值,组装成json
	 * @param map
	 * @param keyName
	 * @param valueName
	 * @param check
	 * @return
	 */
	public static String getMapJsonSetUpKeyAndValueNameByCheck(Map<String, String> map, String keyName, String valueName, String check){
		
		if(CommonUtils.isStrZeroEmpty(check)){
			check = "";
		}
		
		JSONArray array = new JSONArray();
		JSONObject json = null;
		
		Set<String> keys = map.keySet();
		for(String key : keys){
			
			json = new JSONObject();
			
			if(key.equals(check)){
				json.put("check", "true");
			}
			
			json.put(keyName, key);
			json.put(valueName, map.get(key));
			
			array.add(json);
		}
		
		return array.toString();
	}
	
	/**
	 * 重新设定map的key和value的名称,及判断check的值,组装成json
	 * 默认的key为id,value为text
	 * @param map
	 * @param check
	 * @return
	 */
	public static String getMapJsonSetUpKeyAndValueNameByCheck(Map<String, String> map, String check){
		
		return getMapJsonSetUpKeyAndValueNameByCheck(map, "id", "text", check);
	}
	
	/**
	 * 返回一组只包含"请选择"的json
	 * @param keyName
	 * @param valueName
	 * @return
	 */
	public static String getMapJsonForEmpty(String keyName, String valueName){
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		map.put("", CommonUtils.EMPTY);
		
		return getMapJsonSetUpKeyAndValueName(map, keyName, valueName);
	}
	
	/**
	 * 删除字符串最后一个字符
	 * @param str
	 * @return
	 */
	public static String removeLastChar(String str){
		
		if(isStrEmpty(str))
			return "";
		
		int length = str.length();
		
		if(length > 0){
			str = str.substring(0, length-1);
		}
		
		return str;
	}
	
	/**
	 * 判断源字符数组,是否包含目标字符
	 * @param srcArr
	 * @param desc
	 * @return
	 */
	public static boolean isHave(String[] srcArr, String desc){
		//如果为true就不拦截(主要用于Filter中)
		boolean isHave = false;
		
		if(isCollectionEmpty(srcArr)){
			return isHave;
		}
		
		for(String exUrl : srcArr){
			if(desc.equalsIgnoreCase(exUrl)){
				isHave = true;
				break;
			}
		}
		
		return isHave;
	}
	
	/**
	 * 根据旧的文件名,返回一个随机数的新的文件名
	 * @param oldFileName
	 * @return
	 */
	public static String getFileName(String oldFileName){
		
		int last = oldFileName.lastIndexOf(".");
		String fileType = oldFileName.substring(last, oldFileName.length());
		
		String fileName = CommonUtils.getNowTimeString();
		
		return fileName + fileType;
	}
	
	/**
	 * 求两个BigDecimal相除,返回#.##的格式,(%的格式)
	 * @param divide
	 * @param divisor
	 * @return
	 */
	public static String moneyDividePer(BigDecimal divide, BigDecimal divisor){
		
		//DecimalFormat df = new DecimalFormat("###,##0.00");
		
		String ret = "0%";
		
		if(divide == null || divisor == null || new BigDecimal(0).equals(divisor))
			return ret;
		
		//ret = divide.divide(divisor, 4, BigDecimal.ROUND_HALF_EVEN).toString();
		
		BigDecimal divValue = divide.divide(divisor, 4, BigDecimal.ROUND_HALF_EVEN);
		
		return divValue.movePointRight(2) + "%";
	}
	
	/**
	 * 求两个BigDecimal相除,返回#.##的格式
	 * @param divide
	 * @param divisor
	 * @return
	 */
	public static String moneyDivide(BigDecimal divide, BigDecimal divisor){
		
		if(divide == null || divisor == null || new BigDecimal(0).compareTo(divisor) == 0)
			return "0.00";
		
		BigDecimal divValue = divide.divide(divisor, 2, BigDecimal.ROUND_HALF_EVEN);
		
		//DecimalFormat df = new DecimalFormat("#####0.00");
		
		return divValue.toString();
		
	}
	
	/**
	 * 求两个BigDecimal相除,scale为保存位数
	 * @param divide
	 * @param divisor
	 * @param scale
	 * @return
	 */
	public static String moneyDivide(BigDecimal divide, BigDecimal divisor, int scale){
		
		if(divide == null || divisor == null || new BigDecimal(0).compareTo(divisor) == 0){
			
			return "0.00";
		}
		
		BigDecimal divValue = divide.divide(divisor, scale, BigDecimal.ROUND_HALF_EVEN);
		
		return divValue.toString();
		
	}
	
	/**
	 * 获取金额格式
	 * @param value
	 * @return
	 */
	public static String moneyString(BigDecimal value){
		
		return moneyString(value, 2);
	}
	
	/**
	 * 获取金额格式,limit为小数点后位数
	 * @param value
	 * @param limit
	 * @return
	 */
	public static String moneyString(BigDecimal value, int limit){
		
		if(isBigDecimalEmpty(value))
			return "-";
		
		String pattern = "###,##0.";
		if(limit <= 2){
			limit = 2;
		}
		
		for(int i=1; i<=limit; i++){
			pattern += "0";
		}
		
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(value);
	}

    /**
     * 获取金额格式,
     * @param value 金额
     * @param limit  为小数点后位数
     * @param formatter 自定义 格式
     * @return
     */
    public static String moneyString(BigDecimal value, int limit,String formatter){

        if(isBigDecimalEmpty(value))
            return "-";

        if(formatter==null || formatter.length()==0) formatter="###,###,###";
        DecimalFormat df = new DecimalFormat(formatter);
        return df.format(value);
    }

    /**
	 * 如果不能转换就返回0
	 * @param desc
	 * @return
	 */
	public static BigDecimal exceptionToZero(String desc){
		
		try{
			if (isStrEmpty(desc))  return new BigDecimal(0);
			return new BigDecimal(desc);
		}catch(Exception e){
			
			return new BigDecimal(0);
		}
		
	}
	
	/**
	 * 判断BigDecimal是否为null或0
	 * @param val
	 * @return
	 */
	public static boolean isBigDecimalEmpty(BigDecimal val){
		
		if(val == null || val.compareTo(new BigDecimal(0)) == 0){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 判断是否为int类型
	 * @param desc
	 * @return
	 */
	public static boolean isIntString(String desc){
		
		try{
			
			Integer.parseInt(desc);
			
			return true;
		}catch(Exception e){
			
			return false;
		}
		
	}
	
	/**
	 * 给参数加上[]
	 * @param jsonStr
	 * @return
	 */
	public static String addJsonLimit(String jsonStr){
		
		return JSON_LEFT + jsonStr + JSON_RIGHT;
	}
	
	/**
	 * 获取状态的中文
	 * @param status
	 * @return
	 */
	public static String getStatus(String status){
		
		if(CommonUtils.NORMAL.equals(status))
			return "正常";
		
		return "作废";
	}
	
	public static void out(Object obj){
		System.out.println(obj);
	}
	
	/**
	 * List转换成String ，以逗号分隔每个元素
	 * @param list
	 * @return
	 */
	public static String ListToString(List<?> list){
		if(list==null || list.size()<=0){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).toString());
			if(i<list.size()-1){
				sb.append(",");					
			}
		}
		return sb.toString();		
	}
	

	/**
	 * list中的值复制
	 * 目标list将被清空
	 * @param toList
	 * @param fromList
	 */
	public static List<Integer> getListCopy(List<Integer> fromList){
		List<Integer> toList;
		if(fromList!=null){
			toList = new ArrayList<Integer>(Arrays.asList(new Integer[fromList.size()]));
		}
		else{
			toList = null;
			return toList;
		}
		
		Collections.copy(toList, fromList);
		
		return toList;
	}

	/**
	 * 字符串转成List<Integer>,用于id String转成List
	 * @param str
	 * @param limit
	 * @return
	 */
	public static List<Integer> stringToList(String str, String limit){
		
		List<Integer> retList = new ArrayList<Integer>();
		
		if(CommonUtils.isStrEmpty(str)){
			
			return retList;
		}
		
		if(CommonUtils.isStrEmpty(limit)){
			limit = ",";
		}
		
		String[] ids = str.split(limit);
		
		if(ids == null){
			
			return retList;
		}
		
		for(String id : ids){
			
			try{
				retList.add(Integer.parseInt(id.trim()));
			}catch (Exception e) {
			}
		}
		
		return retList;
	}
	
	/**
	 * 默认为,
	 * @param str
	 * @return
	 */
	public static List<Integer> stringToList(String str){
		return stringToList(str, ",");
	}
	
	/**
	 * 根据url来确定ActionTemplate中的cond的session key
	 * 直接返回"cond",在新的easyui框架界面下(tabs),会出现问题
	 * @return
	 */
	public static String getCondSessionKey(){
		
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 返回true和false的map
	 * 可以参照DescUtils.java的getInitSelEmptyAndTrueFalse();
	 * @return
	 */
	public static Map<String, String> initSelEmptyAndTrueFalse(){
		return initSelEmptyAndTrueFalse(false);
	}
	
	/**
	 * 返回true和false的map
	 * 可以参照DescUtils.java的getInitSelEmptyAndTrueFalse();
	 * @param isPutEmpty
	 * @return
	 */
	public static Map<String, String> initSelEmptyAndTrueFalse(boolean isPutEmpty){
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		if(isPutEmpty){
			map.put("", EMPTY);
		}
		
		map.put(CommonUtils.TRUE_STR, CommonUtils.TRUE);
		map.put(CommonUtils.FALSE_STR, CommonUtils.FALSE);
		
		return map;
	}
	
	/**
	 * 返回当前时间的字符串,主要用于文件上传的随机文件名
	 * @return
	 */
	public synchronized static String getNowTimeString(){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(date);
	}
	
	/**
	 * string list转成int list
	 * @param stringList
	 * @return
	 */
	public static List<Integer> stringListToIntList(List<String> stringList){
		
		List<Integer> retList = new ArrayList<Integer>();
		
		if(isCollectionEmpty(stringList)){
			
			return retList;
		}
		
		for(String str : stringList){
			
			if(!isIntString(str))
				continue;
			
			retList.add(Integer.parseInt(str));
		}
		
		return retList;
	}
	
	/**
	 * string array转成int list
	 * @param stringList
	 * @return
	 */
	public static List<Integer> stringListToIntList(String[] stringList){
		
		List<Integer> retList = new ArrayList<Integer>();
		
		if(isCollectionEmpty(stringList)){
			
			return retList;
		}
		
		for(String str : stringList){
			
			if(!isIntString(str))
				continue;
			
			retList.add(Integer.parseInt(str));
		}
		
		return retList;
	}
	
	/**
	 * 从字符串中提取数字,若字符串中含非数字，则提取数字并+1(主要用于楼层)
	 * @param s
	 * @return
	 */
	public static int getIntFromString(String s){
		if(s.matches("^[0-9]*$")){
			return Integer.valueOf(s);
		}
		String regEx="[^0-9]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(s);
		return Integer.valueOf(m.replaceAll("").trim())+1;
	}
	
	public static void sortFloor(LinkedList<String> floor){
		Iterator<String> ite = floor.iterator();
		for(;ite.hasNext();){
			String s = ite.next();
			if(!s.matches("^[0-9]*$")){
				s.replaceAll("\\d+$", "");
			}
			
		}
		
	}
	
	/**
	 * 字符串数字截取一定的小数位,str为字符串，digit代表截取小数点后固定位数
	 * @param str
	 * @param digit
	 * @return
	 */
	public static String parseString(String str, int digit){
		if(digit==0){
			return str.split("\\.")[0];
		}else{
			return str.split("\\.")[0]+"."+str.split("\\.")[1].substring(0, digit);
		}
	}
	
	/**
	 * 判断参数是否包含中文
	 * @param str
	 * @return
	 */
	public static boolean isIncludeChinese(String str){
		
		boolean ret = false;
		
		try{
			
			Pattern p = Pattern.compile("[\u4e00-\u9fa5]"); 
			Matcher m = p.matcher(str); 
			
			ret = m.find();
		
		}catch (Exception e) {
		}
		
		return ret;
	}
	
	/**
	 * 获取两个list的交集
	 * @param <E>
	 * @param srcList
	 * @param descList
	 * @return
	 */
	public static <E> List<E> listIntersection(List<E> srcList, List<E> descList){
		
		List<E> retList = new ArrayList<E>();
		
		if(isCollectionEmpty(srcList) || isCollectionEmpty(descList)){
			
			return retList;
		}
		
		if(isCollectionEmpty(srcList)){
			
			srcList = new ArrayList<E>();
		}
		
		if(isCollectionEmpty(descList)){
			
			descList = new ArrayList<E>();
		}
		
		for(E src : srcList){
			
			if(descList.contains(src)){
				
				retList.add(src);
			}
		}
		
		return retList;
	}
	
	/**
	 * 获取两个list的并集
	 * @param <E>
	 * @param srcList
	 * @param descList
	 * @return
	 */
	public static <E> List<E> listUnion(List<E> srcList, List<E> descList){
		
		if(isCollectionEmpty(srcList)){
			
			srcList = new ArrayList<E>();
		}
		
		if(isCollectionEmpty(descList)){
			
			descList = new ArrayList<E>();
		}
		
		List<E> interList = listIntersection(srcList, descList); //交集
		
		for(E inter : interList){
			
			srcList.remove(inter);
		}
		
		descList.addAll(srcList);
		
		return descList;
	}
	
	/**
	 * 深克隆方法
	 */
	public static Object deepClone(Object object) throws IOException, ClassNotFoundException    
	{    
		//将对象写到流里    
		ByteArrayOutputStream bo=new ByteArrayOutputStream();    
		ObjectOutputStream oo=new ObjectOutputStream(bo);    
		oo.writeObject(object);    
		//从流里读出来    
		ByteArrayInputStream bi=new ByteArrayInputStream(bo.toByteArray());    
		ObjectInputStream oi=new ObjectInputStream(bi);    
		return(oi.readObject());    
	}
	
	/**
	 * Excel中对数字的格式处理，去除逗号，左右空格等等
	 */
	
	public static String excelNumberFormat(String num){
		if(num!=null){
			num = num.trim();
		}
		String formatNum = "";
		for(int i=0; i<num.length(); i++){
			if(num.charAt(i)==','){
				continue;
			}
			formatNum = formatNum + num.charAt(i);
		}
		return formatNum;

	}
	
}
