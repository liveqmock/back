package com.ihk.sale.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorCond;
import com.ihk.sale.data.services.ISaleMonitorServices;
import com.ihk.utils.SupperAction;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.SessionUser;
import com.ihk.permission.PermissionUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.HighChartsUtils;
import java.text.ParseException;
import org.joda.time.DateTime;
import com.ihk.utils.UIUtils;
import com.ihk.utils.HengDaUtils;
import java.math.RoundingMode;  

/**
 * 项目的日周月年曲线
 * 
 * 
 */
public class ChartProjectAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ChartProjectAction.class);
	
	private String[] yAxis ;
	private String[] yAxisType ;

	@Autowired
	ISaleMonitorServices saleMonitorServices;
	@Autowired
	ICompanyProjectServices comProjectServices;

	private SaleMonitorCond saleMonitorCond;

	public void setSaleMonitorCond(SaleMonitorCond saleCond) {
		this.saleMonitorCond = saleCond;
	}

	public SaleMonitorCond getSaleMonitorCond() {
		return saleMonitorCond;
	}
	
	private LinkedHashMap<String, String> listSelCompany;
	
	public void setListSelCompany(LinkedHashMap<String, String> listSelCompany) {
		this.listSelCompany = listSelCompany;
	}
	
	public LinkedHashMap<String, String> getListSelCompany() {
		return listSelCompany;
	}
	
	private void initListSelCompany(){
		listSelCompany = HengDaUtils.getSelCompany();
	}

	private LinkedHashMap<String, String> listListSelProject;

	public void setListSelProject(LinkedHashMap<String, String> listListSelProject) {
		this.listListSelProject = listListSelProject;
	}
	
	public void initListSelProject() {
		this.listListSelProject = new LinkedHashMap<String, String>();
		
		this.listListSelProject.put("", CommonUtils.ALL);
		if(saleMonitorCond.getProjectId()>0){	
			int companyId = DescUtils.getCompanyIdByProjectId(saleMonitorCond.getProjectId());		
			saleMonitorCond.setCompanyId(String.valueOf(companyId));
		}
		if(!CustomerUtils.isStrEmpty(saleMonitorCond.getCompanyId())){
			this.listListSelProject = HengDaUtils.getProjectsByCompanyId(Integer.parseInt(saleMonitorCond.getCompanyId()));
		}
	}

	public LinkedHashMap<String, String> getListSelProject() {
		return listListSelProject;
	}
	
	//统计的周期(每个周期出一个点)
	private LinkedHashMap<String, String> listSelCycel;

	public LinkedHashMap<String, String> getListSelCycel() {
		if(listSelCycel==null){
			listSelCycel = UIUtils.getListSelCycel();
		}
		return listSelCycel;
	}
	
	//周期
	private String selCycel;
	
	public String getSelCycel() {
		return this.selCycel;
	}
		
	public void setSelCycel(String selCycel) {
		this.selCycel = selCycel;
	}
	
	//曲线类型列表
	private LinkedHashMap<String, String> listSelYType;

	public LinkedHashMap<String, String> getListSelYType() {
		if(listSelYType==null){
			listSelYType = HengDaUtils.getListSelYType();
		}
		return listSelYType;
	}
	
	//选中的曲线类型
	private String selYType;
	
	public String getSelYType() {
		return this.selYType;
	}
		
	public void setSelYType(String selYType) {
		this.selYType = selYType;
	}

	//明细查询的链接
	private String detailSearchUrl;
	
	public String getDetailSearchUrl() {
		return this.detailSearchUrl;
	}
	
	//设置明细查询的链接
	private void setDetailSearchUrl(){
		detailSearchUrl = "sale_hengda/search/sale.action?saleCond.date1="+saleMonitorCond.getDate1()+"&saleCond.date2="+saleMonitorCond.getDate2()+"&saleCond.companyId="+saleMonitorCond.getCompanyId()+"&saleCond.projectId="+saleMonitorCond.getProjectId();
	}
	
	//汇总查询的链接
	private String sumSearchUrl;
	
	public String getSumSearchUrl() {
		return this.sumSearchUrl;
	}
	
	//设置汇总查询的链接
	private void setSumSearchUrl(){
		sumSearchUrl = "sale_hengda/search/all.action?saleCond.monitorDate="+saleMonitorCond.getDate1()+"&saleCond.companyId="+saleMonitorCond.getCompanyId()+"&saleCond.projectId="+saleMonitorCond.getProjectId();
	}
	
	//标题
	private String chartTitle;
	
	public String getChartTitle() {
		return this.chartTitle;
	}
		
	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}

	// x坐标
	private String chartXAxis;

	public String getChartXAxis() {
		return chartXAxis;// "['11-01', '11-02', '11-03', '11-04', '11-05', '11-06', '11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']";
	}

	public void setChartXAxis(String chartXAxis) {
		this.chartXAxis = chartXAxis;
	}
	
	// y坐标
	private String chartYAxis;

	public String getChartYAxis() {		
		if(selYType.equals("sale")){
			return "["+HighChartsUtils.getYAxisElement("销售套数","套",0,false)+","+HighChartsUtils.getYAxisElement("销售面积","平米",1,true)+","+HighChartsUtils.getYAxisElement("销售金额","万元",2,true)+"]";
		}
		else if(selYType.equals("visit")){
			return "["+HighChartsUtils.getYAxisElement("来电","组",0,false)+","+HighChartsUtils.getYAxisElement("来访","人",1,true)+"]";
		}
		else if(selYType.equals("intention")){
		}
		return "["+HighChartsUtils.getYAxisElement("认筹","次",0,false)+"]";
	}
	
	private String[] getArrayChartXAxis(){
		return getChartXAxis().replace("[", "").replace("]", "").replace(" ", "").replace("'", "").split(",");
	}

	// 具体不同曲线的值
	private String chartSeries;

	public String getChartSeries() {
		return chartSeries;// "[{name: '恒大清远',data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6,1,1,1,1,1,1,1,1,1,1,1,1,1,11,1,11,1,1,2,2,3]}, {name: '恒大安徽',data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]}, {name: '恒大广州',data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]}, {name: '恒大',data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]}]";
	}

	public void setChartSeries(String chartSeries) {
		this.chartSeries = chartSeries;
	}
	
	//初始化日曲线参数(同时也是jsp页面参数)
	private void initSaleMonitorCond(){
		if (saleMonitorCond == null) {
			saleMonitorCond = new SaleMonitorCond();
		}
		if (CustomerUtils.isStrEmpty(saleMonitorCond.getDate1())) {
			saleMonitorCond.setDate1(CommonUtils.getMonthFirstForString());
		}
		if (CustomerUtils.isStrEmpty(saleMonitorCond.getDate2())) {
			saleMonitorCond.setDate2(CommonUtils.getMonthEndForString());
		}

		if(saleMonitorCond.getProjectId()<=0){
			saleMonitorCond.setProjectId(SessionUser.getProjectId());//当前用户所属的project
		}
	}
	
	
	public String execute() throws Exception { 
		initSaleMonitorCond();	
		
		if(selCycel==null){
			int days = DateTimeUtils.getDaysBetween(saleMonitorCond.getDate1(),saleMonitorCond.getDate2());
			if(days>90){
				//如果日期跨度大于90天，周期默认为:月
				return month();
			}
			else if(days>31){
				//如果日期跨度大于31天，周期默认为:周
				return week();
			}
	  	return day();
		}
		else if(selCycel.equals("day")){
	  	return day();
		}
		else if(selCycel.equals("week")){
			return week();
		}
		else if(selCycel.equals("month")){
			return month();
		}		
		 
	  return day();
	} 
	
	//初始化y坐标
	private void initYAxis(){		
		if(selYType==null){
			selYType = "sale";
		}
		if(selYType.equals("sale")){
			yAxis = new String[]{"销售套数","销售面积","销售金额"};			
			yAxisType = new String[]{"column","spline","spline"};
		}
		else if(selYType.equals("visit")){
			yAxis = new String[]{"来电","来访"};			
			yAxisType = new String[]{"column","spline"};
		}
		else if(selYType.equals("intention")){
			yAxis = new String[]{"认筹数量"};			
			yAxisType = new String[]{"spline"};
		}
	}

	//查看日曲线
	@SuppressWarnings("unchecked")
	public String day() {
		boolean flag = comProjectServices.isProjectStateActive(9,DateTimeUtils.toDateTimeFromStr("2011-11-01"));

		boolean flag2 = comProjectServices.isProjectStateActive(9,DateTimeUtils.toDateTimeFromStr("2011-10-01"),DateTimeUtils.toDateTimeFromStr("2011-11-01"));

		logger.info("flag"+flag);
		logger.info("flag2"+flag2);
		
		initSaleMonitorCond();
		initListSelCompany();
		initListSelProject();	
		setSelCycel("day"); 						
		
		//标题
		setChartTitle("日曲线-"+DescUtils.getCompanyProjectRealName(saleMonitorCond.getProjectId() ));

		List listSale = saleMonitorServices.findSaleMonitorGroupbyProjectDate(saleMonitorCond);

		DateFormat format = new SimpleDateFormat("MM-dd");

		//坐标(Y轴)		
		initYAxis();	

		// 日期坐标(X轴)
		setChartXAxis(HighChartsUtils.getDaysXAxis(saleMonitorCond.getDate1(),saleMonitorCond.getDate2()));// "['11-01', '11-02', '11-03', '11-04', '11-05', '11-06', '11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']");
		String[] xAxis = getArrayChartXAxis();

		// xy轴形成的点的map（唯一对应一点）
		Map map = new HashMap(); //
		for (Iterator it = listSale.iterator(); it.hasNext();) {
			SaleMonitor sm = (SaleMonitor) it.next();
			if(selYType.equals("sale")){
				map.put("销售套数:" + format.format(sm.getMonitorDate()), sm.getSumNum());
				map.put("销售面积:" + format.format(sm.getMonitorDate()), sm.getSumArea());
				map.put("销售金额:" + format.format(sm.getMonitorDate()), HighChartsUtils.divideW(sm.getSumMoney(),10000,2));
			}
			else if(selYType.equals("visit")){
				map.put("来电:" + format.format(sm.getMonitorDate()), sm.getPhoneNum());
				map.put("来访:" + format.format(sm.getMonitorDate()), sm.getVisitorNum());
			}
			else if(selYType.equals("intention")){
				map.put("认筹数量:" + format.format(sm.getMonitorDate()), sm.getIntentionNum());
			}
		}

		//设置曲线
		setChartSeries(HighChartsUtils.getChartSeriesByXYMulY(xAxis, yAxis, map,yAxis,yAxisType));

		setDetailSearchUrl();//设置明细查询的链接
		setSumSearchUrl();//设置汇总的链接
		
		return "day";
	}

	//查看周曲线
	@SuppressWarnings("unchecked")
	public String week() {
		initSaleMonitorCond();
		initListSelCompany();
		initListSelProject();
		setSelCycel("week"); 						
		
		//标题
		setChartTitle("周曲线-"+DescUtils.getCompanyProjectRealName(saleMonitorCond.getProjectId() ));

		List listSale = saleMonitorServices.findSaleMonitorGroupbyProjectWeek(saleMonitorCond);

		//坐标(Y轴)		
		initYAxis();	

		// 日期坐标(X轴)
		setChartXAxis(HighChartsUtils.getDaysXAxisMonday(saleMonitorCond.getDate1(),saleMonitorCond.getDate2()));// "['11-01', '11-02', '11-03', '11-04', '11-05', '11-06', '11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']");
		String[] xAxis = getArrayChartXAxis();

		// xy轴形成的点的map（唯一对应一点）
		Map map = new HashMap(); //
		for (Iterator it = listSale.iterator(); it.hasNext();) {
			SaleMonitor sm = (SaleMonitor) it.next();
			if(selYType.equals("sale")){
				map.put("销售套数:" + DateTimeUtils.getPreMondayStr(sm.getMonitorDate()), sm.getSumNum());
				map.put("销售面积:" + DateTimeUtils.getPreMondayStr(sm.getMonitorDate()), sm.getSumArea());
				map.put("销售金额:" + DateTimeUtils.getPreMondayStr(sm.getMonitorDate()), HighChartsUtils.divideW(sm.getSumMoney(),10000,2));
			}
			else if(selYType.equals("visit")){
				map.put("来电:" + DateTimeUtils.getPreMondayStr(sm.getMonitorDate()), sm.getPhoneNum());
				map.put("来访:" + DateTimeUtils.getPreMondayStr(sm.getMonitorDate()), sm.getVisitorNum());
			}
			else if(selYType.equals("intention")){
				map.put("认筹数量:" + DateTimeUtils.getPreMondayStr(sm.getMonitorDate()), sm.getIntentionNum());
			}
		}

		//设置曲线
		setChartSeries(HighChartsUtils.getChartSeriesByXYMulY(xAxis, yAxis, map,yAxis,yAxisType));

		setDetailSearchUrl();//设置明细查询的链接
		setSumSearchUrl();//设置汇总的链接
		
		return "week";
	}


	//查看月曲线
	@SuppressWarnings("unchecked")
	public String month() {
		initSaleMonitorCond();
		initListSelCompany();
		initListSelProject();
		setSelCycel("month"); 						
		
		//标题
		setChartTitle("月曲线-"+DescUtils.getCompanyProjectRealName(saleMonitorCond.getProjectId() ));

		List listSale = saleMonitorServices.findSaleMonitorGroupbyProjectMonth(saleMonitorCond);

		//坐标(Y轴)		
		initYAxis();	

		// 日期坐标(X轴)
		setChartXAxis(HighChartsUtils.getDaysXAxisMonthFirstDay(saleMonitorCond.getDate1(),saleMonitorCond.getDate2()));// "['11-01', '11-02', '11-03', '11-04', '11-05', '11-06', '11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']");
		String[] xAxis = getArrayChartXAxis();

		// xy轴形成的点的map（唯一对应一点）
		Map map = new HashMap(); //
		for (Iterator it = listSale.iterator(); it.hasNext();) {
			SaleMonitor sm = (SaleMonitor) it.next();
			if(selYType.equals("sale")){
				map.put("销售套数:" + DateTimeUtils.getMonthFirstDayStrMMdd(sm.getMonitorDate()), sm.getSumNum());
				map.put("销售面积:" + DateTimeUtils.getMonthFirstDayStrMMdd(sm.getMonitorDate()), sm.getSumArea());
				map.put("销售金额:" + DateTimeUtils.getMonthFirstDayStrMMdd(sm.getMonitorDate()), HighChartsUtils.divideW(sm.getSumMoney(),10000,2));
			}
			else if(selYType.equals("visit")){
				map.put("来电:" + DateTimeUtils.getMonthFirstDayStrMMdd(sm.getMonitorDate()), sm.getPhoneNum());
				map.put("来访:" + DateTimeUtils.getMonthFirstDayStrMMdd(sm.getMonitorDate()), sm.getVisitorNum());
			}
			else if(selYType.equals("intention")){
				map.put("认筹数量:" + DateTimeUtils.getMonthFirstDayStrMMdd(sm.getMonitorDate()), sm.getIntentionNum());
			}
		}

		//设置曲线
		setChartSeries(HighChartsUtils.getChartSeriesByXYMulY(xAxis, yAxis, map,yAxis,yAxisType));

		setDetailSearchUrl();//设置明细查询的链接
		setSumSearchUrl();//设置汇总的链接
		
		return "month";
	}
	


}
