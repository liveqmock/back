package com.ihk.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

/**
 * 定时器的帮助类
 * @author dtc
 * 2012-9-29
 */
public class QuartzUtils {
	
	public static List<String> getBetweenDates(String first, String end){
		
		DateTime[] tmps = DateTimeUtils.getDates(first, end);
		List<String> retList = new ArrayList<String>();
		for(DateTime tmp : tmps){
			String date = tmp.toString("yyyy-MM-dd");
			retList.add(date);
		}
		
		return retList;
	}
	
	//更新日期与定时器执行日期之间,周表要变化的数据日期
	public static List<String> getWeekDateForUpdate(String monitorDate, String quartzDate){
		//monitorDate = '2011-11-24' quartzDate = '2011-11-27'
		
		String monitorDateWeekEnd = CommonUtils.getWeekEndForString(monitorDate);
		int betweenWeekEndDays = DateTimeUtils.getDaysBetween(monitorDate, monitorDateWeekEnd); //更新日期与其所在周末的天数
		int betweenQuartzDays = DateTimeUtils.getDaysBetween(monitorDate, quartzDate); //更新日期与定时器执行日期的天数
		
		String queryEnd = "";
		if(betweenWeekEndDays <= betweenQuartzDays){
			queryEnd = monitorDateWeekEnd;
		}else{
			queryEnd = quartzDate;
		}
		
		DateTime[] tmps = DateTimeUtils.getDates(monitorDate, queryEnd);
		List<String> retList = new ArrayList<String>();
		for(DateTime tmp : tmps){
			String date = tmp.toString("yyyy-MM-dd");
			retList.add(date);
		}
		
		return retList;
	}
	
	public static List<String> getMonthDateForUpdate(String monitorDate, String quartzDate){
		
		String monitorDateMonthEnd = CommonUtils.getMonthEndForString(monitorDate);
		int betweenMonthEndDays = DateTimeUtils.getDaysBetween(monitorDate, monitorDateMonthEnd); //更新日期与其所在月末的天数
		int betweenQuartzDays = DateTimeUtils.getDaysBetween(monitorDate, quartzDate); //更新日期与定时器执行日期的天数
		
		String queryEnd = "";
		if(betweenMonthEndDays <= betweenQuartzDays){
			queryEnd = monitorDateMonthEnd;
		}else{
			queryEnd = quartzDate;
		}
		
		DateTime[] tmps = DateTimeUtils.getDates(monitorDate, queryEnd);
		List<String> retList = new ArrayList<String>();
		for(DateTime tmp : tmps){
			String date = tmp.toString("yyyy-MM-dd");
			retList.add(date);
		}
		
		return retList;
	}
	
	public static List<String> getYearDateForUpdate(String monitorDate, String quartzDate){
		
		String monitorDateYearEnd = CommonUtils.getYearEndForString(monitorDate);
		int betweenYearEndDays = DateTimeUtils.getDaysBetween(monitorDate, monitorDateYearEnd); //更新日期与其所在年末的天数
		int betweenQuartzDays = DateTimeUtils.getDaysBetween(monitorDate, quartzDate); //更新日期与定时器执行日期的天数
		
		String queryEnd = "";
		if(betweenYearEndDays <= betweenQuartzDays){
			queryEnd = monitorDateYearEnd;
		}else{
			queryEnd = quartzDate;
		}
		
		DateTime[] tmps = DateTimeUtils.getDates(monitorDate, queryEnd);
		List<String> retList = new ArrayList<String>();
		for(DateTime tmp : tmps){
			String date = tmp.toString("yyyy-MM-dd");
			retList.add(date);
		}
		
		return retList;
	}
	
	public static String getBeforeMonitorDate(String monitorDate){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date parseDate = null;
		try {
			parseDate =(Date)df.parse(monitorDate);
		} catch (ParseException e) {
			e.printStackTrace();
			parseDate = new Date();
		}
		
		long before = parseDate.getTime() - CommonUtils.ONE_DAY;
		Date retDate = new Date(before);
		
		return CustomerUtils.getDateString(retDate);
	}
	
	public static String getBeforeDate(int beforeDay){
		Date date = new Date();
		long dateLong = date.getTime();
		long retLong = dateLong - CommonUtils.ONE_DAY * beforeDay;
		
		return CommonUtils.getDateString(new Date(retLong));
		
	}
	
	public static Date getQuartzDate(){
		Date date = new Date();
		long dateLong = date.getTime();
		long retLong = dateLong - CommonUtils.ONE_DAY;
		
		return new Date(retLong);
		
	}
	
	public static String getQuartzDateForString(){
		//获取统计的日期,为当前日期减一天
		
		return CommonUtils.getDateString(getQuartzDate());
	}
	
	public static String getQuartzWeekFirstForString(){
		
		return CommonUtils.getWeekFirstForString(getQuartzDateForString());
	}
	
	public static String getQuartzWeekEndForString(){
		
		return CommonUtils.getWeekEndForString(getQuartzDateForString());
	}
	
	public static String getQuartzMonthFirstForString(){
		
		return CommonUtils.getMonthFirstForString(getQuartzDateForString());
	}
	
	public static String getQuartzMonthEndForString(){
		Calendar cal = Calendar.getInstance();     
		cal.setTime(getQuartzDate());
	    cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));  
        
	    return  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		
	}
	
	public static String getQuartzYearFirstForString(){
		
		return CommonUtils.getYearFirstForString(getQuartzDateForString());
	}
	
	public static String getQuartzYearEndForString(){
		
		return CommonUtils.getYearEndForString(getQuartzDateForString());
	}
	
	public static boolean isWeekFirst(String srcDate){
		
		boolean isWeekFirst = false;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date parseDate = null;
		try {
			parseDate = df.parse(srcDate);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(parseDate);
			
			int index = cal.get(Calendar.DAY_OF_WEEK); //为星期几, 周日为1, 周六为7
			if(index == 2){
				isWeekFirst = true;				
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return isWeekFirst;
	}
	
	public static boolean isMonthFirst(String srcDate){
		
		return srcDate.endsWith("-01") ? true : false;
	}
	
	public static boolean isYearFirst(String srcDate){
		
		return srcDate.endsWith("-01-01") ? true : false;
	}
	
	public static String getMinDateString(String srcDateString, String descDateString){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date srcDate = null;
		Date descDate = null;
		
		try {
			srcDate = df.parse(srcDateString);
			descDate = df.parse(descDateString);
			
			if(srcDate.getTime() >= descDate.getTime()){
				return descDateString;
			}else{
				return srcDateString;
			}
			
		}catch(Exception e){
			return null;
		}
		
	}
	
	public static String getMaxDateString(String srcDateString, String descDateString){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date srcDate = null;
		Date descDate = null;
		
		try {
			srcDate = df.parse(srcDateString);
			descDate = df.parse(descDateString);
			
			if(srcDate.getTime() <= descDate.getTime()){
				return descDateString;
			}else{
				return srcDateString;
			}
			
		}catch(Exception e){
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(getQuartzDateForString());
		
		System.out.println(isWeekFirst(getQuartzDateForString()));
		
		String first = "2011-11-07";
		String end = "2012-12-26";
		List<String> dates = getYearDateForUpdate(first, end);
		for(String date : dates){
			System.out.println(date);
		}
	}
	                                                 
	                                                  
	

}
