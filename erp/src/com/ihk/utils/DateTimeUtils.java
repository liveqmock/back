package com.ihk.utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.ReadablePeriod;

/**
 * 日期帮助类
 * @author dtc
 * 2012-9-29
 */
public class DateTimeUtils {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(DateTimeUtils.class);
	
	
	public static DateTime toDateTimeFromStr(String strDate) {
		String format= "yyyy-MM-dd";
		
		return toDateTimeFromStr(strDate,format);
	}

	public static DateTime getNow() {
		return new DateTime();
	}
	
	public static DateTime toDateTime(Date dt) {
		return new DateTime(dt);
	}	

	public static String toStr(Date dt) {
		return new DateTime(dt).toString("yyyy-MM-dd");
	}
	
	public static DateTime toDateTimeFromStr(String strDate,String format) {
		return new DateTime(getDate(strDate,format));
	}
	
	public static DateTime after(ReadablePeriod self, DateTime dateTime) {
		return dateTime.plus(self);
	}
   
	
	//从字符串得到Date
    public static Date getDate(String strDate,String timeFormat){
        SimpleDateFormat   dateFormat   =   new   SimpleDateFormat(timeFormat);
        Date   date   ;
        try{
            date = dateFormat.parse(strDate);
            date   =   new   Date(date.getTime());
        }
        catch(Exception ex){
            date = new Date();
        }

        return date;
    }
	
	//从字符串yyyy-MM-dd直接得到日期
	public static Date getDate(String strDate){  
		return getDate(strDate,"yyyy-MM-dd");
	}
	
	//得到下一天
	public static Date getNextDate(Date strDate){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(strDate);
		calendar.add(Calendar.DATE,1);
		return calendar.getTime();
	}
	
	//得到日历
	public static Calendar getCalendar(String strDate){
		return getCalendar(getDate(strDate));
	}
	
	//得到日历
	public static Calendar getCalendar(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar;
	}
	
	//得到Date 
	public static Date getDate(Calendar calendar){
		return calendar.getTime();
	}	
	
	//得到日期格式的字符串
	public static String getDateFormatStr(Date date){
    DateFormat df = DateFormat.getDateInstance();  
    return df.format(date);  
	}
	
	//得到日期格式的字符串
	public static String getDateFormatStr(Calendar calendar){
		return getDateFormatStr(getDate(calendar));
	}
	
	
	//  获得上周星期一的日期字符串
	public static String getPreMondayStr(String strDate) { 
		return getDateFormatStr(getPreMondayCalendar(getCalendar(strDate)));
	}
	
	//  获得上周星期一的日期字符串
	public static String getPreMondayStr(Calendar calendar) {  
		return getDateFormatStr(getPreMondayCalendar(calendar));
	}
	  
	// 获得上周星期一的日期  
	public static Date getPreMondayDate(Calendar calendar) {  
	    return getDate(getPreMondayCalendar(calendar));  
	} 
	
	// 获得上周星期一的日历
	public static Calendar getPreMondayCalendar(Calendar calendar) {  
	    int day = calendar.get(Calendar.DAY_OF_WEEK); 
	    calendar.add(Calendar.DATE, (2-day-7));  
	    
	    return calendar;
	}
	
	
	//  获得本周星期一的日期字符串
	public static String getMondayStr(String strDate) { 
		return getDateFormatStr(getMondayCalendar(getCalendar(strDate)));
	}
	
	//  获得本周星期一的日期字符串
	public static String getMondayStr(Calendar calendar) {
		return getDateFormatStr(getMondayCalendar(calendar));
	}
	  
	// 获得本周星期一的日期  
	public static Date getMondayDate(Calendar calendar) { 
	    return getDate(getMondayCalendar(calendar));   
	} 
	
	// 获得本周星期一的日历
	public static Calendar getMondayCalendar(Calendar calendar) {   
	    int day = calendar.get(Calendar.DAY_OF_WEEK); 
	    calendar.add(Calendar.DATE, (2-day));  
	    
	    return calendar;
	}
	
	
	//  获得本周星期日的日期字符串
	public static String getSundayStr(String strDate) { 
		return getDateFormatStr(getSundayCalendar(getCalendar(strDate)));
	}
	
	//  获得本周星期日的日期字符串
	public static String getSundayStr(Calendar calendar) { 
		return getDateFormatStr(getSundayCalendar(calendar)); 
	}
	  
	// 获得本周星期日的日期  
	public static Date getSundayDate(Calendar calendar) { 
	    return getDate(getSundayCalendar(calendar));   
	} 
	
	// 获得本周星期日的日历
	public static Calendar getSundayCalendar(Calendar calendar) {   
	    int day = calendar.get(Calendar.DAY_OF_WEEK); 
	    calendar.add(Calendar.DATE, (2-day));  
	    
	    return calendar;
	}

	//
	public static List<String> toListStr(DateTime[] dts,String format){
		ArrayList list = new ArrayList();
		for(int i=0;i<dts.length;i++){
			list.add(dts[i].toString(format));
		}
		
		return list;
	}
	
	//
	public static List<String> toListStr(DateTime[] dts){
		return toListStr(dts,"yyyy-MM-dd");
	}
	
	private static DateTime[] toDateTimes(ArrayList list){
		DateTime[] dts = new DateTime[list.size()];
		for(int i=0;i<list.size();i++)
		{
			dts[i] = DateTimeUtils.toDateTimeFromStr((String)list.get(i));
		}
		
		return dts;
	}	
	
	// 日期范围内的所有天(包括起止日期)
	public static DateTime[] getDates(String date1, String date2) {
		DateTime d1 = DateTimeUtils.toDateTimeFromStr(date1);
		DateTime d2 = DateTimeUtils.toDateTimeFromStr(date2);
		
		ArrayList list = new ArrayList();
				
		while(Days.daysBetween(d1, d2).getDays()>=0){
			list.add(d1.toString("yyyy-MM-dd"));
			d1 = d1.plusDays(1);
		}
		
		DateTime[] dts = toDateTimes(list);
		
		return dts;
	}
	
	// 日期范围内的所有星期一(包括起止日期)
	public static DateTime[] getMondays(String date1, String date2) {
		DateTime d1 = DateTimeUtils.toDateTimeFromStr(date1);
		DateTime d2 = DateTimeUtils.toDateTimeFromStr(date2);
		
		ArrayList list = new ArrayList();
		
		while(d1.dayOfWeek().get()>1){
			d1 = d1.minusDays(1);
		}
		
		while(Days.daysBetween(d1, d2).getDays()>=0){
			list.add(d1.toString("yyyy-MM-dd"));
			d1 = d1.plusWeeks(1);
		}
		
		DateTime[] dts = toDateTimes(list);
		
		return dts;
	}
	
	// 日期范围内的下一星期日(包括起止日期)
	public static DateTime[] getNextSundays(String date1, String date2) {
		DateTime d1 = DateTimeUtils.toDateTimeFromStr(date1);
		DateTime d2 = DateTimeUtils.toDateTimeFromStr(date2);
		
		ArrayList list = new ArrayList();
		
		while(d1.dayOfWeek().get()<7){
			d1 = d1.plusDays(1);
		}
		
		while(Days.daysBetween(d1, d2).getDays()>=-6){
			list.add(d1.toString("yyyy-MM-dd"));
			d1 = d1.plusWeeks(1);
		}
		
		DateTime[] dts = toDateTimes(list);
		
		return dts;
	}
	
	//取得之前的星期一
	public static String getPreMondayStr(Date dt,String format){	
		return getPreMonday(toDateTime(dt)).toString(format);	
	}
	//取得之前的星期一
	public static String getPreMondayStr(Date dt){	
		return getPreMonday(toDateTime(dt)).toString("MM-dd");	
	}
	
	//取得之前的星期一
	public static DateTime getPreMonday(DateTime dt){		
		while(dt.dayOfWeek().get()>1){
			dt = dt.minusDays(1);
		}
		
		return dt;		
	}
	
	//取得每月的1号(MM-dd)
	public static String getMonthFirstDayStrMMdd(Date dt){	
		return toDateTime(dt).toString("MM")+"-01";	
	}

	//取得每月的1号(MM-dd)
	public static String getMonthFirstDayStrMMdd(String strDate){
		return toDateTimeFromStr(strDate).toString("MM")+"-01";	
	}

	
	//取得每月的1号(MM-dd)
	public static String getMonthFirstDayStr(Date dt){	
		return toDateTime(dt).toString("yyyy-MM")+"-01";	
	}

	//取得每月的1号(MM-dd)
	public static String getMonthFirstDayStr(String strDate){
		return toDateTimeFromStr(strDate).toString("yyyy-MM")+"-01";	
	}
	
	
	// 日期范围内的所有月份的第一天(包括起止日期)
	public static DateTime[] getMonthFirstDays(String date1, String date2) {
		DateTime d1 = DateTimeUtils.toDateTimeFromStr(date1);
		DateTime d2 = DateTimeUtils.toDateTimeFromStr(date2);
		
		d1 = DateTimeUtils.toDateTimeFromStr(d1.toString("yyyy-MM")+"-01");
		
		ArrayList list = new ArrayList();
				
		while(Days.daysBetween(d1, d2).getDays()>=0){
			list.add(d1.toString("yyyy-MM-dd"));
			d1 = d1.plusMonths(1);
		}
		
		DateTime[] dts = toDateTimes(list);
		
		return dts;
	}
	

	/**
	 * 日期所处月份的最后一天
	 * @param date
	 * @return
	 */
	public static String getMonthLastDayStr(String date) {
		DateTime d1 = DateTimeUtils.toDateTimeFromStr(date).dayOfMonth().withMaximumValue();
		
		return d1.toString("yyyy-MM-dd");
	}
	
	// 日期范围内的所有月份的最后一天(包括起止日期)
	public static DateTime[] getMonthLastDays(String date1, String date2) {
		DateTime d1 = DateTimeUtils.toDateTimeFromStr(date1).dayOfMonth().withMaximumValue(); 
		DateTime d2 = DateTimeUtils.toDateTimeFromStr(date2).dayOfMonth().withMaximumValue(); 
				
		ArrayList list = new ArrayList();
				
		while(Days.daysBetween(d1, d2).getDays()>=0){
			list.add(d1.toString("yyyy-MM-dd"));
			d1 = d1.plusMonths(1).dayOfMonth().withMaximumValue();
		}
		
		DateTime[] dts = toDateTimes(list);
		
		return dts;
	}
	
	
	// 日期范围内的所有年份的第一天(包括起止日期)
	public static DateTime[] getYearFirstDays(String date1, String date2) {
		DateTime d1 = DateTimeUtils.toDateTimeFromStr(date1);
		DateTime d2 = DateTimeUtils.toDateTimeFromStr(date2);
				
		d1 = DateTimeUtils.toDateTimeFromStr(d1.toString("yyyy")+"-01-01");
		
		ArrayList list = new ArrayList();
				
		while(Days.daysBetween(d1, d2).getDays()>=0){
			list.add(d1.toString("yyyy-MM-dd"));
			d1 = d1.plusMonths(1);
		}
		
		DateTime[] dts = toDateTimes(list);
		
		return dts;
	}
	
	//两个日期之间的间距
	public static int getDaysBetween(String date1, String date2) {
		DateTime d1 = DateTimeUtils.toDateTimeFromStr(date1);
		DateTime d2 = DateTimeUtils.toDateTimeFromStr(date2);
				
		return Days.daysBetween(d1, d2).getDays();
	}

	//返回星期几的中文
	public static String getDayOfWeekStr(String strDate) {
		return getDayOfWeekStr(toDateTimeFromStr(strDate));
	}
	
	//返回星期几的中文
	public static String getDayOfWeekStr(DateTime date) {
		int d = date.getDayOfWeek();
		String str ="";
		switch(d){
			case 1:
			str = "一";
			break;
			case 2:
			str = "二";
			break;
			case 3:
			str = "三";
			break;
			case 4:
			str = "四";
			break;
			case 5:
			str = "五";
			break;
			case 6:
			str = "六";
			break;
			case 7:
			str = "日";
			break;
		}
		
		return str;
	}
	
	/**
	 * 判断目标日期是否在开始及结束日期期间,闭区间
	 * @param start
	 * @param end
	 * @param desc
	 * @return
	 * @throws Exception 
	 */
	public static boolean isDateBetween(Date start, Date end, Date desc) throws Exception{
		
		if(start == null || end == null || desc == null || desc.before(start) || desc.after(end)){
			
			return false;
		}
		
		return true;
	}
	
}