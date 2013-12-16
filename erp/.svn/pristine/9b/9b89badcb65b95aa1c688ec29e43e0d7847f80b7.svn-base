package com.ihk.quartz;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorCond;
import com.ihk.sale.data.pojo.SaleMonitorLogbeforeCond;
import com.ihk.sale.data.pojo.SaleMonitorMonth;
import com.ihk.sale.data.pojo.SaleMonitorMonthCond;
import com.ihk.sale.data.pojo.SaleMonitorWeek;
import com.ihk.sale.data.pojo.SaleMonitorWeekCond;
import com.ihk.sale.data.pojo.SaleMonitorYear;
import com.ihk.sale.data.pojo.SaleMonitorYearCond;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.HengDaBeanUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.QuartzUtils;

/**
 * 恒大销控数据的定时器(已废弃)
 * @author peter.kuang
 *
 */
@Deprecated
public class SaleMonitorQuartz {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(SaleMonitorQuartz.class); 
	
	//做为定时器的方法,是不能有参数的
	public void updateSaleMonitorWeekAndMonth() throws Exception{
		//暂时假设为凌晨3点执行
		
		logger.info(CommonUtils.getNowForLocalString() + "定时器开始执行...");
		
		final String quartzDate = QuartzUtils.getQuartzDateForString();   //定时器要操作的日期
		final String beforeQuartzDate = QuartzUtils.getBeforeDate(2);  //非first的时候要操作的日期
		
		SaleMonitorCond cond = new SaleMonitorCond();
		cond.setMonitorDate(quartzDate);
		List<SaleMonitor> quartzSaleList = HengDaUtils.getSaleMonitorServices().findSaleMonitor(cond);  //查询定时器要操作的所有bean(monitorDate为一样的)
		
		final List<SaleMonitorWeek> saleWeekList = new ArrayList<SaleMonitorWeek>();
		final List<SaleMonitorMonth> saleMonthList = new ArrayList<SaleMonitorMonth>();
		final List<SaleMonitorYear> saleYearList = new ArrayList<SaleMonitorYear>();
		
		for(SaleMonitor quartzSale : quartzSaleList){
			SaleMonitorWeek saleWeek = new SaleMonitorWeek();
			SaleMonitorMonth saleMonth = new SaleMonitorMonth();
			SaleMonitorYear saleYear = new SaleMonitorYear();
			
			BeanUtils.copyProperties(quartzSale, saleWeek);
			BeanUtils.copyProperties(quartzSale, saleMonth);
			BeanUtils.copyProperties(quartzSale, saleYear);
			
			saleWeekList.add(saleWeek);
			saleMonthList.add(saleMonth);
			saleYearList.add(saleYear);
			
		}
		
		final boolean isWeekFirst = QuartzUtils.isWeekFirst(quartzDate);
		final boolean isMonthFirst = QuartzUtils.isMonthFirst(quartzDate);
		final boolean isYearFirst = QuartzUtils.isYearFirst(quartzDate);
		
		//正常情况下
		new MyTransationTemplate() {
			@Override
			protected void doExecuteCallback() throws Exception {
				//都要去判断表中是否有该项目该天的数据,有就更新,没就增加
				
				//week
				if(isWeekFirst){
					//不用去加周表中日期quartzDate前一天的数据
					for(SaleMonitorWeek saleMonitorWeek : saleWeekList){
						int projectId = saleMonitorWeek.getProjectId();
						
						SaleMonitorWeekCond weekCond = new SaleMonitorWeekCond();
						weekCond.setMonitorDate(quartzDate);
						weekCond.setProjectId(projectId + "");
						
						SaleMonitorWeek getSaleWeek = HengDaUtils.getSaleMonitorWeekServices()
								.findQuartzDateSaleMonitorWeek(weekCond); //周表中quartzDate的数据
						
						if(getSaleWeek == null){
						
							HengDaUtils.getSaleMonitorWeekServices().addSaleMonitorWeek(saleMonitorWeek);
						}else{
							
							saleMonitorWeek.setId(getSaleWeek.getId());
							HengDaUtils.getSaleMonitorWeekServices().updateSaleMonitorWeek(saleMonitorWeek);
						}
						
					}
					
				}else{
					//获取周表中日期quartzDate前一天的数据
					for(SaleMonitorWeek saleMonitorWeek : saleWeekList){
						int projectId = saleMonitorWeek.getProjectId();
						
						SaleMonitorWeekCond weekCond = new SaleMonitorWeekCond();
						weekCond.setMonitorDate(beforeQuartzDate);
						weekCond.setProjectId(projectId + "");
						
						SaleMonitorWeek getBeforeSaleWeek = HengDaUtils.getSaleMonitorWeekServices()
								.findQuartzDateSaleMonitorWeek(weekCond); //周表中quartzDate前一天的数据
						
						weekCond.setMonitorDate(quartzDate);
						SaleMonitorWeek getSaleWeek = HengDaUtils.getSaleMonitorWeekServices()
								.findQuartzDateSaleMonitorWeek(weekCond); //周表中quartzDate的数据
						
						//增加，修改之前要加上上一天的数据
						if(getSaleWeek == null){
							//增加
							if(getBeforeSaleWeek != null){
								
								saleMonitorWeek = HengDaBeanUtils.addWeekBean(getBeforeSaleWeek, saleMonitorWeek);
							}else{
								//同时要把相关的天数据加到周表(通过天表)
								//本周周一到beforeQuartzDate的天数据相加
								String weekFirst = QuartzUtils.getQuartzWeekFirstForString();
								List<String> tmpWeekDate = QuartzUtils.getBetweenDates(weekFirst, beforeQuartzDate);
								
								setEmptySaleWeek(tmpWeekDate, projectId);
								
							}
							
							HengDaUtils.getSaleMonitorWeekServices().addSaleMonitorWeek(saleMonitorWeek);
						}else{
							//更新
							if(getBeforeSaleWeek != null){
								
								saleMonitorWeek = HengDaBeanUtils.addWeekBean(getBeforeSaleWeek, saleMonitorWeek);  
								//参数中的bean相关数据的相加,其它属性以第二个参数为准
							}else{
								//同时要把相关的天数据加到周表(通过天表)
								//本周周一到beforeQuartzDate的天数据相加
								String weekFirst = QuartzUtils.getQuartzWeekFirstForString();
								List<String> tmpWeekDate = QuartzUtils.getBetweenDates(weekFirst, beforeQuartzDate);
								
								setEmptySaleWeek(tmpWeekDate, projectId);
								
							}
							
							saleMonitorWeek.setId(getSaleWeek.getId());
							HengDaUtils.getSaleMonitorWeekServices().updateSaleMonitorWeek(saleMonitorWeek);
						}
						
					}
					
				}
				 
				///// month
				
				if(isMonthFirst){
					
					for(SaleMonitorMonth saleMonitorMonth : saleMonthList){
						
						SaleMonitorMonthCond monthCond = new SaleMonitorMonthCond();
						monthCond.setMonitorDate(quartzDate);
						monthCond.setProjectId(saleMonitorMonth.getProjectId() + "");
						
						SaleMonitorMonth getSaleMonth = HengDaUtils.getSaleMonitorMonthServices().findQuartzDateSaleMonitorMonth(monthCond);
						
						if(getSaleMonth == null){
							
							HengDaUtils.getSaleMonitorMonthServices().addSaleMonitorMonth(saleMonitorMonth);
						}else{
							
							saleMonitorMonth.setId(getSaleMonth.getId());
							HengDaUtils.getSaleMonitorMonthServices().updateSaleMonitorMonth(saleMonitorMonth);
						}
						
					}
					
				}else{
					
					for(SaleMonitorMonth saleMonitorMonth : saleMonthList){
						int projectId = saleMonitorMonth.getProjectId();
						
						SaleMonitorMonthCond monthCond = new SaleMonitorMonthCond();
						monthCond.setMonitorDate(beforeQuartzDate);
						monthCond.setProjectId(projectId + "");
						
						SaleMonitorMonth getBeforeSaleMonth = HengDaUtils.getSaleMonitorMonthServices()
							.findQuartzDateSaleMonitorMonth(monthCond);
						
						monthCond.setMonitorDate(quartzDate);
						SaleMonitorMonth getSaleMonth = HengDaUtils.getSaleMonitorMonthServices()
							.findQuartzDateSaleMonitorMonth(monthCond);
						
						if(getSaleMonth == null){
							
							if(getBeforeSaleMonth != null){
								
								saleMonitorMonth = HengDaBeanUtils.addMonthBean(getBeforeSaleMonth, saleMonitorMonth);
							}else{
								
								String monthFirst = QuartzUtils.getQuartzMonthFirstForString();
								List<String> tmpMonthDate = QuartzUtils.getBetweenDates(monthFirst, beforeQuartzDate);
								
								setEmptySaleMonth(tmpMonthDate, projectId);
							}
							
							HengDaUtils.getSaleMonitorMonthServices().addSaleMonitorMonth(saleMonitorMonth);
						}else{
							
							if(getBeforeSaleMonth != null){
								
								saleMonitorMonth = HengDaBeanUtils.addMonthBean(getBeforeSaleMonth, saleMonitorMonth);
							}else{
								
								String monthFirst = QuartzUtils.getQuartzMonthFirstForString();
								List<String> tmpMonthDate = QuartzUtils.getBetweenDates(monthFirst, beforeQuartzDate);
								
								setEmptySaleMonth(tmpMonthDate, projectId);
							}
							
							saleMonitorMonth.setId(getSaleMonth.getId());
							HengDaUtils.getSaleMonitorMonthServices().updateSaleMonitorMonth(saleMonitorMonth);
						}
						
						
					}
					
					
				}
				
				///// year
				
				if(isYearFirst){
					
					for(SaleMonitorYear saleMonitorYear : saleYearList){
						
						SaleMonitorYearCond yearCond = new SaleMonitorYearCond();
						yearCond.setMonitorDate(quartzDate);
						yearCond.setProjectId(saleMonitorYear.getProjectId() + "");
						
						SaleMonitorYear getSaleYear = HengDaUtils.getSaleMonitorYearServices().findQuartzDateSaleMonitorYear(yearCond);
						
						if(getSaleYear == null){
							
							HengDaUtils.getSaleMonitorYearServices().addSaleMonitorYear(saleMonitorYear);
						}else{
							
							saleMonitorYear.setId(getSaleYear.getId());
							HengDaUtils.getSaleMonitorYearServices().updateSaleMonitorYear(saleMonitorYear);
						}
						
					}
					
				}else{
					
					for(SaleMonitorYear saleMonitorYear : saleYearList){
						int projectId = saleMonitorYear.getProjectId();
						
						SaleMonitorYearCond yearCond = new SaleMonitorYearCond();
						yearCond.setMonitorDate(beforeQuartzDate);
						yearCond.setProjectId(projectId + "");
						
						SaleMonitorYear getBeforeSaleYear = HengDaUtils.getSaleMonitorYearServices()
							.findQuartzDateSaleMonitorYear(yearCond);
						
						yearCond.setMonitorDate(quartzDate);
						SaleMonitorYear getSaleYear = HengDaUtils.getSaleMonitorYearServices()
							.findQuartzDateSaleMonitorYear(yearCond);
						
						if(getSaleYear == null){
							
							if(getBeforeSaleYear != null){
								
								saleMonitorYear = HengDaBeanUtils.addYearBean(getBeforeSaleYear, saleMonitorYear);
							}else{
								
								String yearFirst = QuartzUtils.getQuartzYearFirstForString();  //如果是2011年,应改为2011-08-01
								int first = yearFirst.indexOf("-");
								String year = yearFirst.substring(0, first);
								if("2011".equals(year)){
									yearFirst = "2011-08-01";
								}
								
								List<String> tmpYearDate = QuartzUtils.getBetweenDates(yearFirst, beforeQuartzDate);
								
								setEmptySaleYear(tmpYearDate, projectId);
							}
							
							HengDaUtils.getSaleMonitorYearServices().addSaleMonitorYear(saleMonitorYear);
							
						}else{
							
							if(getBeforeSaleYear != null){
								
								saleMonitorYear = HengDaBeanUtils.addYearBean(getBeforeSaleYear, saleMonitorYear);
							}else{
								
								String yearFirst = QuartzUtils.getQuartzYearFirstForString();  //如果是2011年,应改为2011-08-01
								int first = yearFirst.indexOf("-");
								String year = yearFirst.substring(0, first);
								if("2011".equals(year)){
									yearFirst = "2011-08-01";
								}
								
								List<String> tmpYearDate = QuartzUtils.getBetweenDates(yearFirst, beforeQuartzDate);
								
								setEmptySaleYear(tmpYearDate, projectId);
							}
							
							saleMonitorYear.setId(getSaleYear.getId());
							HengDaUtils.getSaleMonitorYearServices().updateSaleMonitorYear(saleMonitorYear);
						}
						
					}
				}
				
				
			}
		}.execute();
		
		
		//lock_sale权限的人修改,应该控制一定的日期内,如超过3个月就不能修改
		new MyTransationTemplate() {
			
			@Override
			protected void doExecuteCallback() throws Exception {
				SaleMonitorLogbeforeCond cond = new SaleMonitorLogbeforeCond();
				cond.setMonitorDate(quartzDate);
				
				List<SaleMonitor> updateSaleList = HengDaUtils.getSaleMonitorServices().findSaleMonitorFromLogbeforeForQuartz(cond);
				
				for(SaleMonitor updateSale : updateSaleList){
					String monitorDate = updateSale.getMonitorDateString(); //修改记录表中的修改日期
					String quartzDate = QuartzUtils.getQuartzDateForString();   //定时器要操作的日期 
					
					List<String> weekDays = QuartzUtils.getWeekDateForUpdate(monitorDate, quartzDate); //周表中要update的日期,进行了相关的处理
					List<String> monthDays = QuartzUtils.getMonthDateForUpdate(monitorDate, quartzDate);
					List<String> yearDays = QuartzUtils.getYearDateForUpdate(monitorDate, quartzDate);
					
					String weekFirst = CommonUtils.getWeekFirstForString(monitorDate);
					String monthFirst = CommonUtils.getMonthFirstForString(monitorDate);
					String yearFirst = CommonUtils.getYearFirstForString(monitorDate);
					
					//周
					for(String weekDay : weekDays){
						
						List<SaleMonitor> saleMonitorList = new ArrayList<SaleMonitor>(); //更新到周表中的一条数据的天表数据list(要进行相关的合并)
						List<String> weekUpdateDays = QuartzUtils.getBetweenDates(weekFirst, weekDay); //周表中update要用到的sale_monitor中的monitor_date
						
						SaleMonitorWeekCond weekCond = new SaleMonitorWeekCond();
						weekCond.setMonitorDate(weekDay);
						weekCond.setProjectId(updateSale.getProjectId() + "");
						
						SaleMonitorWeek weekSale = HengDaUtils.getSaleMonitorWeekServices().findQuartzDateSaleMonitorWeek(weekCond);
						
						for(String day : weekUpdateDays){
							SaleMonitorCond saleCond = new SaleMonitorCond();
							saleCond.setMonitorDate(day);
							saleCond.setProjectId(updateSale.getProjectId());
							
							SaleMonitor sale = HengDaUtils.getSaleMonitorServices().findSaleMonitorForQuartzUpdate(saleCond);
							if(sale != null){
								saleMonitorList.add(sale);
							}
							
						}
						
						if(weekSale == null){
							//插入
							weekSale = new SaleMonitorWeek();
							weekSale = setSaleWeekFromSaleList(weekSale, saleMonitorList);
							weekSale.setMonitorDate(CommonUtils.getDateFromString(weekDay));
							
							HengDaUtils.getSaleMonitorWeekServices().addSaleMonitorWeek(weekSale);
						}else{
							//更新
							
							weekSale = setSaleWeekFromSaleList(weekSale, saleMonitorList);
							HengDaUtils.getSaleMonitorWeekServices().updateSaleMonitorWeek(weekSale);
						}
						
						
					}
					
					
					//月
					for(String monthDay : monthDays){
						
						List<SaleMonitor> saleMonitorList = new ArrayList<SaleMonitor>(); 
						List<String> monthUpdateDays = QuartzUtils.getBetweenDates(monthFirst, monthDay); 
						
						SaleMonitorMonthCond monthCond = new SaleMonitorMonthCond();
						monthCond.setMonitorDate(monthDay);
						monthCond.setProjectId(updateSale.getProjectId() + "");
						
						SaleMonitorMonth monthSale = HengDaUtils.getSaleMonitorMonthServices().findQuartzDateSaleMonitorMonth(monthCond);
						
						for(String day : monthUpdateDays){
							SaleMonitorCond saleCond = new SaleMonitorCond();
							saleCond.setMonitorDate(day);
							saleCond.setProjectId(updateSale.getProjectId());
							
							SaleMonitor sale = HengDaUtils.getSaleMonitorServices().findSaleMonitorForQuartzUpdate(saleCond);
							if(sale != null){
								saleMonitorList.add(sale);
							}
							
						}
						
						if(monthSale == null){
							//插入
							monthSale = new SaleMonitorMonth();
							monthSale = setSaleMonthFromSaleList(monthSale, saleMonitorList);
							monthSale.setMonitorDate(CommonUtils.getDateFromString(monthDay));
							
							HengDaUtils.getSaleMonitorMonthServices().addSaleMonitorMonth(monthSale);
						}else{
							//更新
							
							monthSale = setSaleMonthFromSaleList(monthSale, saleMonitorList);
							HengDaUtils.getSaleMonitorMonthServices().updateSaleMonitorMonth(monthSale);
						}
						
						
					}
					
					
					//年
					for(String yearDay : yearDays){
						
						List<SaleMonitor> saleMonitorList = new ArrayList<SaleMonitor>(); 
						List<String> yearUpdateDays = QuartzUtils.getBetweenDates(yearFirst, yearDay); 
						
						SaleMonitorYearCond yearCond = new SaleMonitorYearCond();
						yearCond.setMonitorDate(yearDay);
						yearCond.setProjectId(updateSale.getProjectId() + "");
						
						SaleMonitorYear yearSale = HengDaUtils.getSaleMonitorYearServices().findQuartzDateSaleMonitorYear(yearCond);
						
						for(String day : yearUpdateDays){
							SaleMonitorCond saleCond = new SaleMonitorCond();
							saleCond.setMonitorDate(day);
							saleCond.setProjectId(updateSale.getProjectId());
							
							SaleMonitor sale = HengDaUtils.getSaleMonitorServices().findSaleMonitorForQuartzUpdate(saleCond);
							if(sale != null){
								saleMonitorList.add(sale);
							}
							
						}
						
						if(yearSale == null){
							//插入
							yearSale = new SaleMonitorYear();
							yearSale = setSaleYearFromSaleList(yearSale, saleMonitorList);
							yearSale.setMonitorDate(CommonUtils.getDateFromString(yearDay));
							
							HengDaUtils.getSaleMonitorYearServices().addSaleMonitorYear(yearSale);
						}else{
							//更新
							
							yearSale = setSaleYearFromSaleList(yearSale, saleMonitorList);
							HengDaUtils.getSaleMonitorYearServices().updateSaleMonitorYear(yearSale);
						}
						
					}
				}
				
			}
			
		}.execute();
		
	}
	
	private void setEmptySaleWeek(List<String> tmpWeekDate, int projectId) throws Exception{
		//查询并设置周表中对应项目没有的记录,tmpDate为weekFist到beforeQuartzDate的天数,当周表beforeQuartzDate的数据为null的时候才执行该方法
		
		String weekFist = tmpWeekDate.get(0);
		SaleMonitorCond cond = new SaleMonitorCond();
		cond.setProjectId(projectId);
		
		int dateSize = tmpWeekDate.size();
		for(int i=0; i<dateSize; i++){
			String getDate = tmpWeekDate.get(i);
			
			List<String> days = QuartzUtils.getBetweenDates(weekFist, getDate); //把天表中的数据相加做为getDate日期的周表
			
			List<SaleMonitor> saleMonitorList = new ArrayList<SaleMonitor>();
			for(String day : days){
				SaleMonitorCond saleCond = new SaleMonitorCond();
				saleCond.setMonitorDate(day);
				saleCond.setProjectId(projectId);
				
				SaleMonitor sale = HengDaUtils.getSaleMonitorServices().findSaleMonitorForQuartzUpdate(saleCond);
				saleMonitorList.add(sale);
				
			}
			
			SaleMonitorWeekCond weekCond = new SaleMonitorWeekCond();
			weekCond.setMonitorDate(getDate);
			weekCond.setProjectId(projectId + "");
			
			SaleMonitorWeek getDateWeek = HengDaUtils.getSaleMonitorWeekServices().findQuartzDateSaleMonitorWeek(weekCond);
			if(getDateWeek == null){
				//增加
				
				getDateWeek = new SaleMonitorWeek();
				getDateWeek = setSaleWeekFromSaleList(getDateWeek, saleMonitorList);
				getDateWeek.setMonitorDate(CommonUtils.getDateFromString(getDate));
				
				HengDaUtils.getSaleMonitorWeekServices().addSaleMonitorWeek(getDateWeek);
			}else{
				//更新
				
				getDateWeek = setSaleWeekFromSaleList(getDateWeek, saleMonitorList);
				
				HengDaUtils.getSaleMonitorWeekServices().updateSaleMonitorWeek(getDateWeek);
				
			}
			
			
		}
		
		
	}
	
	private void setEmptySaleMonth(List<String> tmpMonthDate, int projectId) throws Exception{
		
		String monthFirst = tmpMonthDate.get(0);
		SaleMonitorCond cond = new SaleMonitorCond();
		cond.setProjectId(projectId);
		
		int dateSize = tmpMonthDate.size();
		for(int i=0; i<dateSize; i++){
			String getDate = tmpMonthDate.get(i);
			
			List<String> days = QuartzUtils.getBetweenDates(monthFirst, getDate); //把天表中的数据相加做为getDate日期的月表
			
			List<SaleMonitor> saleMonitorList = new ArrayList<SaleMonitor>();
			for(String day : days){
				SaleMonitorCond saleCond = new SaleMonitorCond();
				saleCond.setMonitorDate(day);
				saleCond.setProjectId(projectId);
				
				SaleMonitor sale = HengDaUtils.getSaleMonitorServices().findSaleMonitorForQuartzUpdate(saleCond);
				saleMonitorList.add(sale);
				
			}
			
			SaleMonitorMonthCond monthCond = new SaleMonitorMonthCond();
			monthCond.setMonitorDate(getDate);
			monthCond.setProjectId(projectId + "");
			
			SaleMonitorMonth getDateMonth = HengDaUtils.getSaleMonitorMonthServices().findQuartzDateSaleMonitorMonth(monthCond);
			if(getDateMonth == null){
				//增加
				
				getDateMonth = new SaleMonitorMonth();
				getDateMonth = setSaleMonthFromSaleList(getDateMonth, saleMonitorList);
				getDateMonth.setMonitorDate(CommonUtils.getDateFromString(getDate));
				
				HengDaUtils.getSaleMonitorMonthServices().addSaleMonitorMonth(getDateMonth);
			}else{
				//更新
				
				getDateMonth = setSaleMonthFromSaleList(getDateMonth, saleMonitorList);
				
				HengDaUtils.getSaleMonitorMonthServices().updateSaleMonitorMonth(getDateMonth);
				
			}
			
			
		}
		
	}
	
	private void setEmptySaleYear(List<String> tmpYearDate, int projectId) throws Exception{
		
		String yearFirst = tmpYearDate.get(0);
		SaleMonitorCond cond = new SaleMonitorCond();
		cond.setProjectId(projectId);
		
		int dateSize = tmpYearDate.size();
		for(int i=0; i<dateSize; i++){
			String getDate = tmpYearDate.get(i);
			
			List<String> days = QuartzUtils.getBetweenDates(yearFirst, getDate); //把天表中的数据相加做为getDate日期的年表
			
			List<SaleMonitor> saleMonitorList = new ArrayList<SaleMonitor>();
			for(String day : days){
				SaleMonitorCond saleCond = new SaleMonitorCond();
				saleCond.setMonitorDate(day);
				saleCond.setProjectId(projectId);
				
				SaleMonitor sale = HengDaUtils.getSaleMonitorServices().findSaleMonitorForQuartzUpdate(saleCond);
				saleMonitorList.add(sale);
				
			}
			
			SaleMonitorYearCond yearCond = new SaleMonitorYearCond();
			yearCond.setMonitorDate(getDate);
			yearCond.setProjectId(projectId + "");
			
			SaleMonitorYear getDateYear = HengDaUtils.getSaleMonitorYearServices().findQuartzDateSaleMonitorYear(yearCond);
			if(getDateYear == null){
				//增加
				
				getDateYear = new SaleMonitorYear();
				getDateYear = setSaleYearFromSaleList(getDateYear, saleMonitorList);
				getDateYear.setMonitorDate(CommonUtils.getDateFromString(getDate));
				
				HengDaUtils.getSaleMonitorYearServices().addSaleMonitorYear(getDateYear);
			}else{
				//更新
				
				getDateYear = setSaleYearFromSaleList(getDateYear, saleMonitorList);
				
				HengDaUtils.getSaleMonitorYearServices().updateSaleMonitorYear(getDateYear);
				
			}
			
			
		}
		
	}
	
	private SaleMonitorWeek setSaleWeekFromSaleList(SaleMonitorWeek week, List<SaleMonitor> saleMonitorList){
		
		for(SaleMonitor saleMonitor : saleMonitorList){
			week = HengDaBeanUtils.setWeekBeanFromSale(week, saleMonitor);
		}
		
		return week;
	}
	
	private SaleMonitorMonth setSaleMonthFromSaleList(SaleMonitorMonth month, List<SaleMonitor> saleMonitorList) {
		
		for(SaleMonitor saleMonitor : saleMonitorList){
			month = HengDaBeanUtils.setMonthBeanFromSale(month, saleMonitor);
		}
		
		return month;
	}
	
	private SaleMonitorYear setSaleYearFromSaleList(SaleMonitorYear year, List<SaleMonitor> saleMonitorList) {
		
		for(SaleMonitor saleMonitor : saleMonitorList){
			year = HengDaBeanUtils.setYearBeanFromSale(year, saleMonitor);
		}
		
		return year;
	}
	
}
