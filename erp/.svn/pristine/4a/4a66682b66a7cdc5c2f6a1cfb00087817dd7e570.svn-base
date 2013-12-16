package com.ihk.quartz;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorCond;
import com.ihk.sale.data.pojo.SaleMonitorMonth;
import com.ihk.sale.data.pojo.SaleMonitorWeek;
import com.ihk.sale.data.pojo.SaleMonitorWeekCond;
import com.ihk.sale.data.pojo.SaleMonitorYear;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.HengDaBeanUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.QuartzUtils;
import com.ihk.utils.SupperAction;

/**
 * 恒大定时器的action(已废弃)
 * @author peter.kuang
 *
 */
@Deprecated
public class SaleMonitorQuartzAction extends SupperAction {

	/**
	 *  手工执行定时器的内容
	 *  只能从lastDate开始,(没有值的就与上一天的数据一样)
	 *  每次执行都增加或更新周月年表到定时器要操作的日期,也就是String endQuartzDay = QuartzUtils.getQuartzDateForString(); 
	 *  
	 */
	
	private static final long serialVersionUID = 1L;
	
	private static final String lastDate = "2011-12-12";
	
	@Override
	public String execute() throws Exception {
		
		long start = System.currentTimeMillis();
		
		String firstMonitorDay = request.getParameter("firstMonitorDay");
		String endMonitorDay = request.getParameter("endMonitorDay");
		
		String quartzDate = QuartzUtils.getQuartzDateForString();  //当前日期减一天
		
		firstMonitorDay = QuartzUtils.getMaxDateString(firstMonitorDay, lastDate);
		endMonitorDay = QuartzUtils.getMinDateString(endMonitorDay, quartzDate);
		
		DateTime[] days = DateTimeUtils.getDates(firstMonitorDay, endMonitorDay);
		
		for(DateTime day : days){
			String dayString = day.toString("yyyy-MM-dd");
			
			updateSaleMonitorWeekAndMonthAndYear2(dayString);
			
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println((end - start)/1000);
		
		
		return "doQuartz";
	}
	
	private void updateSaleMonitorWeekAndMonthAndYear2(String monitorDate) throws Exception{
		
		SaleMonitorCond cond = new SaleMonitorCond();
		cond.setMonitorDate(monitorDate);
		
		List<SaleMonitor> updateSaleList = HengDaUtils.getSaleMonitorServices().findSaleMonitor(cond);
		
		for(SaleMonitor updateSale : updateSaleList){
			
			boolean isWeekFirst = QuartzUtils.isWeekFirst(monitorDate);
			if(isWeekFirst){
				
				SaleMonitorWeek weekSale = new SaleMonitorWeek();
				BeanUtils.copyProperties(updateSale, weekSale);
				
				HengDaUtils.getSaleMonitorWeekServices().addSaleMonitorWeek(weekSale);
				
			}else{
				
				SaleMonitorWeekCond weekCond = new SaleMonitorWeekCond();
				weekCond.setMonitorDate(updateSale.getMonitorDateString());
				weekCond.setProjectId(updateSale.getProjectId() + "");
				
				SaleMonitorWeek weekSale = HengDaUtils.getSaleMonitorWeekServices().findQuartzDateSaleMonitorWeek(weekCond);
				
				if(weekSale == null){
					//插入
					weekSale = new SaleMonitorWeek();
					BeanUtils.copyProperties(updateSale, weekSale);
					
					weekCond.setMonitorDate(CommonUtils.getOneDayBeforeForString(CommonUtils.getDateFromString(monitorDate))); //上一天
					SaleMonitorWeek onceWeekSale = HengDaUtils.getSaleMonitorWeekServices().findQuartzDateSaleMonitorWeek(weekCond);
					
					if(onceWeekSale == null){
						
						HengDaUtils.getSaleMonitorWeekServices().addSaleMonitorWeek(weekSale);
					}else{
						
						HengDaBeanUtils.setWeekBeanFromSale(onceWeekSale, updateSale);
						
						HengDaUtils.getSaleMonitorWeekServices().updateSaleMonitorWeek(weekSale);
					}

					
					
					
				}else{
					//更新
					
					
					
					
				}
				
			}
			
		}
		
		
	}
	
	private void updateSaleMonitorWeekAndMonthAndYear(final String monitorDate) throws Exception{
		
		new MyTransationTemplate() {
			
			@Override
			protected void doExecuteCallback() throws Exception {
				SaleMonitorCond cond = new SaleMonitorCond();
				cond.setMonitorDate(monitorDate);
				
				List<SaleMonitor> updateSaleList = HengDaUtils.getSaleMonitorServices().findSaleMonitor(cond);
				
				for(SaleMonitor updateSale : updateSaleList){
					String quartzDate = QuartzUtils.getQuartzDateForString();  //当前日期减一天   
					
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
							weekSale.setMonitorDate(CommonUtils.getDateFromString(weekDay));
							HengDaUtils.getSaleMonitorWeekServices().updateSaleMonitorWeek(weekSale);
						}
						
						
					}
					
					
					/*//月
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
							monthSale.setMonitorDate(CommonUtils.getDateFromString(monthDay));
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
							yearSale.setMonitorDate(CommonUtils.getDateFromString(yearDay));
							HengDaUtils.getSaleMonitorYearServices().updateSaleMonitorYear(yearSale);
						}
						
					}*/
				}
				
			}
			
		}.execute();
		
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
