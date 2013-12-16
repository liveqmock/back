package com.ihk.test;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.ihk.quartz.SaleMonitorQuartz;
import com.ihk.utils.DateTimeUtils;

/**
 * 定时器测试类
 * @author dtc
 * 2012-9-29
 */
public class QuartzTest {
	
	public static void main(String[] args) {
		
		SaleMonitorQuartz quartz = new SaleMonitorQuartz();
		try {
			//quartzDate 2011-08-01   2011-11-23
			
			String firstQuartzDay = "2011-08-01";
			String endQuartzDay = "2011-11-23";
			
			DateTime[] days = DateTimeUtils.getDates(firstQuartzDay, endQuartzDay);
			
			for(DateTime day : days){
				String dayString = day.toString("yyyy-MM-dd");
				
				//quartz.updateSaleMonitorWeekAndMonth(dayString);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DateTime dt = new DateTime();
		System.out.println(dt.toString("yyyy-MM-dd"));
		
		System.out.println(DateTimeUtils.getDateFormatStr(new Date()));
	}

}
