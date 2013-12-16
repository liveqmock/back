package com.ihk.utils;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorMonth;
import com.ihk.sale.data.pojo.SaleMonitorWeek;
import com.ihk.sale.data.pojo.SaleMonitorYear;

/**
 * 恒大相关bean帮助类
 * @author dtc
 * 2012-9-29
 */
public class HengDaBeanUtils {
	
	public static SaleMonitorWeek setWeekBeanFromSale(SaleMonitorWeek week, SaleMonitor sale){
		
		week.setProjectId(sale.getProjectId());		
		week.setCompanyId(sale.getCompanyId());
		week.setPhoneNum(week.getPhoneNum() + sale.getPhoneNum());
		week.setVisitorNum(week.getVisitorNum() + sale.getVisitorNum());
		week.setHouseNum(week.getHouseNum() + sale.getHouseNum());
		week.setHouseArea(week.getHouseArea().add(sale.getHouseArea()));
		week.setHouseMoney(week.getHouseMoney().add(sale.getHouseMoney()));
		week.setShopNum(week.getShopNum() + sale.getShopNum());
		week.setShopArea(week.getShopArea().add(sale.getShopArea()));
		week.setShopMoney(week.getShopMoney().add(sale.getShopMoney()));
		week.setParkNum(week.getParkNum() + sale.getParkNum());
		week.setParkArea(week.getParkArea().add(sale.getParkArea()));
		week.setParkMoney(week.getParkMoney().add(sale.getParkMoney()));
		week.setSumNum(week.getSumNum() + sale.getSumNum());
		week.setSumArea(week.getSumArea().add(sale.getSumArea()));
		week.setSumMoney(week.getSumMoney().add(sale.getSumMoney()));
		week.setUndoHouseArea(week.getUndoHouseArea().add(sale.getUndoHouseArea()));
		week.setUndoHouseMoney(week.getUndoHouseMoney().add(sale.getUndoHouseMoney()));
		week.setUndoHouseNum(week.getUndoHouseNum() + sale.getUndoHouseNum());
		week.setUndoShopNum(week.getUndoShopNum() + sale.getUndoShopNum());
		week.setUndoShopArea(week.getUndoShopArea().add(sale.getUndoShopArea()));
		week.setUndoShopMoney(week.getUndoShopMoney().add(sale.getUndoShopMoney()));
		week.setUndoParkNum(week.getUndoParkNum() + sale.getUndoParkNum());
		week.setUndoParkArea(week.getUndoParkArea().add(sale.getUndoParkArea()));
		week.setUndoParkMoney(week.getUndoParkMoney().add(sale.getUndoParkMoney()));
		week.setUndoSumNum(week.getUndoSumNum() + sale.getUndoSumNum());
		week.setUndoSumArea(week.getUndoSumArea().add(sale.getUndoSumArea()));
		week.setUndoSumMoney(week.getUndoSumMoney().add(sale.getUndoSumMoney()));
		week.setTempNum(week.getTempNum() + sale.getTempNum());
		week.setRescissionNum(week.getRescissionNum() + sale.getRescissionNum());
		week.setCompleteArea(week.getCompleteArea() + sale.getCompleteArea());
		week.setCompleteMoney(week.getCompleteMoney() + sale.getCompleteMoney());
		week.setIntentionNum(week.getIntentionNum() + sale.getIntentionNum());
		week.setIsDeleted(CommonUtils.NORMAL);
		week.setCreatedId(sale.getCreatedId());
		week.setCreatedTime(sale.getCreatedTime());
		week.setModId(sale.getModId());
		week.setModTime(sale.getModTime());
		
		return week;
	}
	
	public static SaleMonitorMonth setMonthBeanFromSale(SaleMonitorMonth month, SaleMonitor sale){
		
		month.setProjectId(sale.getProjectId());		
		month.setCompanyId(sale.getCompanyId());
		month.setPhoneNum(month.getPhoneNum() + sale.getPhoneNum());
		month.setVisitorNum(month.getVisitorNum() + sale.getVisitorNum());
		month.setHouseNum(month.getHouseNum() + sale.getHouseNum());
		month.setHouseArea(month.getHouseArea().add(sale.getHouseArea()));
		month.setHouseMoney(month.getHouseMoney().add(sale.getHouseMoney()));
		month.setShopNum(month.getShopNum() + sale.getShopNum());
		month.setShopArea(month.getShopArea().add(sale.getShopArea()));
		month.setShopMoney(month.getShopMoney().add(sale.getShopMoney()));
		month.setParkNum(month.getParkNum() + sale.getParkNum());
		month.setParkArea(month.getParkArea().add(sale.getParkArea()));
		month.setParkMoney(month.getParkMoney().add(sale.getParkMoney()));
		month.setSumNum(month.getSumNum() + sale.getSumNum());
		month.setSumArea(month.getSumArea().add(sale.getSumArea()));
		month.setSumMoney(month.getSumMoney().add(sale.getSumMoney()));
		month.setUndoHouseArea(month.getUndoHouseArea().add(sale.getUndoHouseArea()));
		month.setUndoHouseMoney(month.getUndoHouseMoney().add(sale.getUndoHouseMoney()));
		month.setUndoHouseNum(month.getUndoHouseNum() + sale.getUndoHouseNum());
		month.setUndoShopNum(month.getUndoShopNum() + sale.getUndoShopNum());
		month.setUndoShopArea(month.getUndoShopArea().add(sale.getUndoShopArea()));
		month.setUndoShopMoney(month.getUndoShopMoney().add(sale.getUndoShopMoney()));
		month.setUndoParkNum(month.getUndoParkNum() + sale.getUndoParkNum());
		month.setUndoParkArea(month.getUndoParkArea().add(sale.getUndoParkArea()));
		month.setUndoParkMoney(month.getUndoParkMoney().add(sale.getUndoParkMoney()));
		month.setUndoSumNum(month.getUndoSumNum() + sale.getUndoSumNum());
		month.setUndoSumArea(month.getUndoSumArea().add(sale.getUndoSumArea()));
		month.setUndoSumMoney(month.getUndoSumMoney().add(sale.getUndoSumMoney()));
		month.setTempNum(month.getTempNum() + sale.getTempNum());
		month.setRescissionNum(month.getRescissionNum() + sale.getRescissionNum());
		month.setCompleteArea(month.getCompleteArea() + sale.getCompleteArea());
		month.setCompleteMoney(month.getCompleteMoney() + sale.getCompleteMoney());
		month.setIntentionNum(month.getIntentionNum() + sale.getIntentionNum());
		month.setIsDeleted(CommonUtils.NORMAL);
		month.setCreatedId(sale.getCreatedId());
		month.setCreatedTime(sale.getCreatedTime());
		month.setModId(sale.getModId());
		month.setModTime(sale.getModTime());
		
		return month;
	}
	
	public static SaleMonitorYear setYearBeanFromSale(SaleMonitorYear year, SaleMonitor sale){
		
		year.setProjectId(sale.getProjectId());		
		year.setCompanyId(sale.getCompanyId());
		year.setPhoneNum(year.getPhoneNum() + sale.getPhoneNum());
		year.setVisitorNum(year.getVisitorNum() + sale.getVisitorNum());
		year.setHouseNum(year.getHouseNum() + sale.getHouseNum());
		year.setHouseArea(year.getHouseArea().add(sale.getHouseArea()));
		year.setHouseMoney(year.getHouseMoney().add(sale.getHouseMoney()));
		year.setShopNum(year.getShopNum() + sale.getShopNum());
		year.setShopArea(year.getShopArea().add(sale.getShopArea()));
		year.setShopMoney(year.getShopMoney().add(sale.getShopMoney()));
		year.setParkNum(year.getParkNum() + sale.getParkNum());
		year.setParkArea(year.getParkArea().add(sale.getParkArea()));
		year.setParkMoney(year.getParkMoney().add(sale.getParkMoney()));
		year.setSumNum(year.getSumNum() + sale.getSumNum());
		year.setSumArea(year.getSumArea().add(sale.getSumArea()));
		year.setSumMoney(year.getSumMoney().add(sale.getSumMoney()));
		year.setUndoHouseArea(year.getUndoHouseArea().add(sale.getUndoHouseArea()));
		year.setUndoHouseMoney(year.getUndoHouseMoney().add(sale.getUndoHouseMoney()));
		year.setUndoHouseNum(year.getUndoHouseNum() + sale.getUndoHouseNum());
		year.setUndoShopNum(year.getUndoShopNum() + sale.getUndoShopNum());
		year.setUndoShopArea(year.getUndoShopArea().add(sale.getUndoShopArea()));
		year.setUndoShopMoney(year.getUndoShopMoney().add(sale.getUndoShopMoney()));
		year.setUndoParkNum(year.getUndoParkNum() + sale.getUndoParkNum());
		year.setUndoParkArea(year.getUndoParkArea().add(sale.getUndoParkArea()));
		year.setUndoParkMoney(year.getUndoParkMoney().add(sale.getUndoParkMoney()));
		year.setUndoSumNum(year.getUndoSumNum() + sale.getUndoSumNum());
		year.setUndoSumArea(year.getUndoSumArea().add(sale.getUndoSumArea()));
		year.setUndoSumMoney(year.getUndoSumMoney().add(sale.getUndoSumMoney()));
		year.setTempNum(year.getTempNum() + sale.getTempNum());
		year.setRescissionNum(year.getRescissionNum() + sale.getRescissionNum());
		year.setCompleteArea(year.getCompleteArea() + sale.getCompleteArea());
		year.setCompleteMoney(year.getCompleteMoney() + sale.getCompleteMoney());
		year.setIntentionNum(year.getIntentionNum() + sale.getIntentionNum());
		year.setIsDeleted(CommonUtils.NORMAL);
		year.setCreatedId(sale.getCreatedId());
		year.setCreatedTime(sale.getCreatedTime());
		year.setModId(sale.getModId());
		year.setModTime(sale.getModTime());
		
		return year;
	}
	
	public static SaleMonitorWeek addWeekBean(SaleMonitorWeek srcWeek, SaleMonitorWeek descWeek){
		//srcWeek为数据库中上一天的数据,descWeek为定时器日期获取的数据,返回的数据为两者相关数据的相加设置
		
		SaleMonitorWeek retWeek = new SaleMonitorWeek();
		
		retWeek.setMonitorDate(descWeek.getMonitorDate());
		retWeek.setProjectId(descWeek.getProjectId());		
		retWeek.setCompanyId(descWeek.getCompanyId());
		retWeek.setPhoneNum(srcWeek.getPhoneNum() + descWeek.getPhoneNum());
		retWeek.setVisitorNum(srcWeek.getVisitorNum() + descWeek.getVisitorNum());
		retWeek.setHouseNum(srcWeek.getHouseNum() + descWeek.getHouseNum());
		retWeek.setHouseArea(srcWeek.getHouseArea().add(descWeek.getHouseArea()));
		retWeek.setHouseMoney(srcWeek.getHouseMoney().add(descWeek.getHouseMoney()));
		retWeek.setShopNum(srcWeek.getShopNum() + descWeek.getShopNum());
		retWeek.setShopArea(srcWeek.getShopArea().add(descWeek.getShopArea()));
		retWeek.setShopMoney(srcWeek.getShopMoney().add(descWeek.getShopMoney()));
		retWeek.setParkNum(srcWeek.getParkNum() + descWeek.getParkNum());
		retWeek.setParkArea(srcWeek.getParkArea().add(descWeek.getParkArea()));
		retWeek.setParkMoney(srcWeek.getParkMoney().add(descWeek.getParkMoney()));
		retWeek.setSumNum(srcWeek.getSumNum() + descWeek.getSumNum());
		retWeek.setSumArea(srcWeek.getSumArea().add(descWeek.getSumArea()));
		retWeek.setSumMoney(srcWeek.getSumMoney().add(descWeek.getSumMoney()));
		retWeek.setUndoHouseArea(srcWeek.getUndoHouseArea().add(descWeek.getUndoHouseArea()));
		retWeek.setUndoHouseMoney(srcWeek.getUndoHouseMoney().add(descWeek.getUndoHouseMoney()));
		retWeek.setUndoHouseNum(srcWeek.getUndoHouseNum() + descWeek.getUndoHouseNum());
		retWeek.setUndoShopNum(srcWeek.getUndoShopNum() + descWeek.getUndoShopNum());
		retWeek.setUndoShopArea(srcWeek.getUndoShopArea().add(descWeek.getUndoShopArea()));
		retWeek.setUndoShopMoney(srcWeek.getUndoShopMoney().add(descWeek.getUndoShopMoney()));
		retWeek.setUndoParkNum(srcWeek.getUndoParkNum() + descWeek.getUndoParkNum());
		retWeek.setUndoParkArea(srcWeek.getUndoParkArea().add(descWeek.getUndoParkArea()));
		retWeek.setUndoParkMoney(srcWeek.getUndoParkMoney().add(descWeek.getUndoParkMoney()));
		retWeek.setUndoSumNum(srcWeek.getUndoSumNum() + descWeek.getUndoSumNum());
		retWeek.setUndoSumArea(srcWeek.getUndoSumArea().add(descWeek.getUndoSumArea()));
		retWeek.setUndoSumMoney(srcWeek.getUndoSumMoney().add(descWeek.getUndoSumMoney()));
		retWeek.setTempNum(srcWeek.getTempNum() + descWeek.getTempNum());
		retWeek.setRescissionNum(srcWeek.getRescissionNum() + descWeek.getRescissionNum());
		retWeek.setCompleteArea(srcWeek.getCompleteArea() + descWeek.getCompleteArea());
		retWeek.setCompleteMoney(srcWeek.getCompleteMoney() + descWeek.getCompleteMoney());
		retWeek.setIntentionNum(srcWeek.getIntentionNum() + descWeek.getIntentionNum());
		retWeek.setIsDeleted(CommonUtils.NORMAL);
		retWeek.setCreatedId(descWeek.getCreatedId());
		retWeek.setCreatedTime(descWeek.getCreatedTime());
		retWeek.setModId(descWeek.getModId());
		retWeek.setModTime(descWeek.getModTime());
		
		return retWeek;
	}
	
	public static SaleMonitorMonth addMonthBean(SaleMonitorMonth srcMonth, SaleMonitorMonth descMonth){
		
		SaleMonitorMonth retMonth = new SaleMonitorMonth();
		
		retMonth.setMonitorDate(descMonth.getMonitorDate());
		retMonth.setProjectId(descMonth.getProjectId());		
		retMonth.setCompanyId(descMonth.getCompanyId());
		retMonth.setPhoneNum(srcMonth.getPhoneNum() + descMonth.getPhoneNum());
		retMonth.setVisitorNum(srcMonth.getVisitorNum() + descMonth.getVisitorNum());
		retMonth.setHouseNum(srcMonth.getHouseNum() + descMonth.getHouseNum());
		retMonth.setHouseArea(srcMonth.getHouseArea().add(descMonth.getHouseArea()));
		retMonth.setHouseMoney(srcMonth.getHouseMoney().add(descMonth.getHouseMoney()));
		retMonth.setShopNum(srcMonth.getShopNum() + descMonth.getShopNum());
		retMonth.setShopArea(srcMonth.getShopArea().add(descMonth.getShopArea()));
		retMonth.setShopMoney(srcMonth.getShopMoney().add(descMonth.getShopMoney()));
		retMonth.setParkNum(srcMonth.getParkNum() + descMonth.getParkNum());
		retMonth.setParkArea(srcMonth.getParkArea().add(descMonth.getParkArea()));
		retMonth.setParkMoney(srcMonth.getParkMoney().add(descMonth.getParkMoney()));
		retMonth.setSumNum(srcMonth.getSumNum() + descMonth.getSumNum());
		retMonth.setSumArea(srcMonth.getSumArea().add(descMonth.getSumArea()));
		retMonth.setSumMoney(srcMonth.getSumMoney().add(descMonth.getSumMoney()));
		retMonth.setUndoHouseArea(srcMonth.getUndoHouseArea().add(descMonth.getUndoHouseArea()));
		retMonth.setUndoHouseMoney(srcMonth.getUndoHouseMoney().add(descMonth.getUndoHouseMoney()));
		retMonth.setUndoHouseNum(srcMonth.getUndoHouseNum() + descMonth.getUndoHouseNum());
		retMonth.setUndoShopNum(srcMonth.getUndoShopNum() + descMonth.getUndoShopNum());
		retMonth.setUndoShopArea(srcMonth.getUndoShopArea().add(descMonth.getUndoShopArea()));
		retMonth.setUndoShopMoney(srcMonth.getUndoShopMoney().add(descMonth.getUndoShopMoney()));
		retMonth.setUndoParkNum(srcMonth.getUndoParkNum() + descMonth.getUndoParkNum());
		retMonth.setUndoParkArea(srcMonth.getUndoParkArea().add(descMonth.getUndoParkArea()));
		retMonth.setUndoParkMoney(srcMonth.getUndoParkMoney().add(descMonth.getUndoParkMoney()));
		retMonth.setUndoSumNum(srcMonth.getUndoSumNum() + descMonth.getUndoSumNum());
		retMonth.setUndoSumArea(srcMonth.getUndoSumArea().add(descMonth.getUndoSumArea()));
		retMonth.setUndoSumMoney(srcMonth.getUndoSumMoney().add(descMonth.getUndoSumMoney()));
		retMonth.setTempNum(srcMonth.getTempNum() + descMonth.getTempNum());
		retMonth.setRescissionNum(srcMonth.getRescissionNum() + descMonth.getRescissionNum());
		retMonth.setCompleteArea(srcMonth.getCompleteArea() + descMonth.getCompleteArea());
		retMonth.setCompleteMoney(srcMonth.getCompleteMoney() + descMonth.getCompleteMoney());
		retMonth.setIntentionNum(srcMonth.getIntentionNum() + descMonth.getIntentionNum());
		retMonth.setIsDeleted(CommonUtils.NORMAL);
		retMonth.setCreatedId(descMonth.getCreatedId());
		retMonth.setCreatedTime(descMonth.getCreatedTime());
		retMonth.setModId(descMonth.getModId());
		retMonth.setModTime(descMonth.getModTime());
		
		return retMonth;
	}
	
	public static SaleMonitorYear addYearBean(SaleMonitorYear srcYear, SaleMonitorYear descYear){
		
		SaleMonitorYear retYear = new SaleMonitorYear();
		
		retYear.setMonitorDate(descYear.getMonitorDate());
		retYear.setProjectId(descYear.getProjectId());		
		retYear.setCompanyId(descYear.getCompanyId());
		retYear.setPhoneNum(srcYear.getPhoneNum() + descYear.getPhoneNum());
		retYear.setVisitorNum(srcYear.getVisitorNum() + descYear.getVisitorNum());
		retYear.setHouseNum(srcYear.getHouseNum() + descYear.getHouseNum());
		retYear.setHouseArea(srcYear.getHouseArea().add(descYear.getHouseArea()));
		retYear.setHouseMoney(srcYear.getHouseMoney().add(descYear.getHouseMoney()));
		retYear.setShopNum(srcYear.getShopNum() + descYear.getShopNum());
		retYear.setShopArea(srcYear.getShopArea().add(descYear.getShopArea()));
		retYear.setShopMoney(srcYear.getShopMoney().add(descYear.getShopMoney()));
		retYear.setParkNum(srcYear.getParkNum() + descYear.getParkNum());
		retYear.setParkArea(srcYear.getParkArea().add(descYear.getParkArea()));
		retYear.setParkMoney(srcYear.getParkMoney().add(descYear.getParkMoney()));
		retYear.setSumNum(srcYear.getSumNum() + descYear.getSumNum());
		retYear.setSumArea(srcYear.getSumArea().add(descYear.getSumArea()));
		retYear.setSumMoney(srcYear.getSumMoney().add(descYear.getSumMoney()));
		retYear.setUndoHouseArea(srcYear.getUndoHouseArea().add(descYear.getUndoHouseArea()));
		retYear.setUndoHouseMoney(srcYear.getUndoHouseMoney().add(descYear.getUndoHouseMoney()));
		retYear.setUndoHouseNum(srcYear.getUndoHouseNum() + descYear.getUndoHouseNum());
		retYear.setUndoShopNum(srcYear.getUndoShopNum() + descYear.getUndoShopNum());
		retYear.setUndoShopArea(srcYear.getUndoShopArea().add(descYear.getUndoShopArea()));
		retYear.setUndoShopMoney(srcYear.getUndoShopMoney().add(descYear.getUndoShopMoney()));
		retYear.setUndoParkNum(srcYear.getUndoParkNum() + descYear.getUndoParkNum());
		retYear.setUndoParkArea(srcYear.getUndoParkArea().add(descYear.getUndoParkArea()));
		retYear.setUndoParkMoney(srcYear.getUndoParkMoney().add(descYear.getUndoParkMoney()));
		retYear.setUndoSumNum(srcYear.getUndoSumNum() + descYear.getUndoSumNum());
		retYear.setUndoSumArea(srcYear.getUndoSumArea().add(descYear.getUndoSumArea()));
		retYear.setUndoSumMoney(srcYear.getUndoSumMoney().add(descYear.getUndoSumMoney()));
		retYear.setTempNum(srcYear.getTempNum() + descYear.getTempNum());
		retYear.setRescissionNum(srcYear.getRescissionNum() + descYear.getRescissionNum());
		retYear.setCompleteArea(srcYear.getCompleteArea() + descYear.getCompleteArea());
		retYear.setCompleteMoney(srcYear.getCompleteMoney() + descYear.getCompleteMoney());
		retYear.setIntentionNum(srcYear.getIntentionNum() + descYear.getIntentionNum());
		retYear.setIsDeleted(CommonUtils.NORMAL);
		retYear.setCreatedId(descYear.getCreatedId());
		retYear.setCreatedTime(descYear.getCreatedTime());
		retYear.setModId(descYear.getModId());
		retYear.setModTime(descYear.getModTime());
		
		return retYear;
	}

}
