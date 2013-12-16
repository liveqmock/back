package com.ihk.sale.action;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.pojo.ArticleCond;
import com.ihk.article.data.services.IArticleServices;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.permission.PermissionUtils;
//import com.ihk.permission.PrivCode;
import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorCond;
//import com.ihk.sale.data.pojo.SaleMonitorWeek;
import com.ihk.sale.data.services.ISaleMonitorMonthServices;
import com.ihk.sale.data.services.ISaleMonitorServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
//import com.ihk.utils.DescUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
//import com.ihk.utils.UIUtils;

/**
 * 恒大登陆主页
 */
public class IndexSaleAction extends SupperAction{

	private static final long serialVersionUID = 1L;

	@Autowired
	ISaleMonitorMonthServices saleMonitorMonthServices;
	@Autowired
	ISaleMonitorServices saleMonitorServices;
	//@Autowired
	//ISaleMonitorServices isaleMonitorServices;
	@Autowired
	ICompanyProjectServices comProjectServices;
	@Autowired
	IArticleServices articleServices;
	private SaleMonitorCond saleMonitorCond;
	private String chartXAxis;
	private String chartSeries;
	private String chartSeries1;
	private LinkedHashMap<String, String> selProject;
	private String chartTitle;
	private List<SaleMonitor> lastMonitorList;//index页面显示最新录入
	private List<Article> lastArticleList;//index页面显示最新公告
	
	
	
	public List<SaleMonitor> getLastMonitorList() {
		return lastMonitorList;
	}

	public void setLastMonitorList(List<SaleMonitor> lastMonitorList) {
		this.lastMonitorList = lastMonitorList;
	}

	public List<Article> getLastArticleList() {
		return lastArticleList;
	}

	public void setLastArticleList(List<Article> lastArticleList) {
		this.lastArticleList = lastArticleList;
	}

	public String getChartTitle() {
		return chartTitle;
	}

	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}
	public LinkedHashMap<String, String> getSelProject() {
		return selProject;
	}

	public void setSelProject(LinkedHashMap<String, String> selProject) {
		this.selProject = selProject;
	}



	public String getChartSeries1() {
		return chartSeries1;
	}



	public void setChartSeries1(String chartSeries1) {
		this.chartSeries1 = chartSeries1;
	}



	public String getChartXAxis() {
		return chartXAxis;
	}



	public void setChartXAxis(String chartXAxis) {
		this.chartXAxis = chartXAxis;
	}



	public String getChartSeries() {
		return chartSeries;
	}



	public void setChartSeries(String chartSeries) {
		this.chartSeries = chartSeries;
	}
	
	private String[] getArrayChartXAxis(){
		return getChartXAxis().replace("[", "").replace("]", "").replace(" ", "").replace("'", "").split(",");
	}

	public void initSelProject() {
		if (this.selProject == null) {
			selProject = new LinkedHashMap<String, String>();
			selProject.put("", CommonUtils.ALL);
			List<CompanyProject> userProjects = PermissionUtils
					.getUserProjectListByUid(SessionUser.getUserId());
			
			//CompanyProject userProject = comProjectServices.findCompanyProjectById(SessionUser.getProjectId()); // 用户自身所属的项目
			//selProject.put(userProject.getId() + "", userProject.getProjectName());
			
			for (CompanyProject pro : userProjects) {
				selProject.put(pro.getId() + "", pro.getProjectName());
			}

		}
	}

//根据登陆的人给出各自的index界面
	private void initSaleMonitorCond(){
		if (saleMonitorCond == null) {
			saleMonitorCond = new SaleMonitorCond();
		}
		if (CustomerUtils.isStrEmpty(saleMonitorCond.getDate1())) {
			saleMonitorCond.setDate1(CommonUtils.getOneWeekBeforeForString());
//			saleMonitorCond.setDate1("2011-09-19");
		}
		if (CustomerUtils.isStrEmpty(saleMonitorCond.getDate2())) {
			saleMonitorCond.setDate2(CommonUtils.getNowForString());
//			saleMonitorCond.setDate2("2011-09-25");
		}

	
			saleMonitorCond.setProjectIds(PermissionUtils.getUserProjectIdList());
			saleMonitorCond.setProjectId(0);
//			saleMonitorCond.setProjectId(SessionUser.getProjectId());//当前用户所属的project
	
	}
	@SuppressWarnings("unchecked")
	public String indexForSale(){
	
		/*
		 * 如果是有2个项目或者2个以上的人
		 * */
		
		
		/*
		 * 只有一个项目的人
		 * */
//		initSelProject();
//
//		// 跟进地址栏设置参数
//		if(this.selProject==null){
//			this.selProject = UIUtils.getListSelProjectWithAll();
//		}
		initSaleMonitorCond();		 
						
		
		//标题
		setChartTitle("总销售套数 总销售金额-");

		List<SaleMonitor> listSale = saleMonitorServices.findSaleMonitor(saleMonitorCond);

		DateFormat format = new SimpleDateFormat("MM-dd");

		//坐标(Y轴)		
		String[] yAxis={"总金额","总套数"}; // 各项指标

		// 日期坐标(X轴)
		setChartXAxis(HighChartsUtils.getDaysXAxis(saleMonitorCond.getDate1(),saleMonitorCond.getDate2()));// "['11-01', '11-02', '11-03', '11-04', '11-05', '11-06', '11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']");
		String[] xAxis = getArrayChartXAxis();

		// xy轴形成的点的map（唯一对应一点）
		Map map = new HashMap(); 
		try {
			for (Iterator<SaleMonitor> it = listSale.iterator(); it.hasNext();) {
				SaleMonitor sm = (SaleMonitor) it.next();
				if(map.containsKey("总金额:" + format.format(sm.getMonitorDate()))){
//					System.out.print(format.format(sm.getMonitorDate())+"    "+map.get("总金额:" + format.format(sm.getMonitorDate()))+"  <>");
					
					map.put("总金额:" + format.format(sm.getMonitorDate()), HighChartsUtils.divideW(sm.getSumMoney(),10000,2).add((BigDecimal)map.get("总金额:" + format.format(sm.getMonitorDate()))));
//					System.out.println(format.format(sm.getMonitorDate())+"    "+map.get("总金额:" + format.format(sm.getMonitorDate())));
					
				}else{
					map.put("总金额:" + format.format(sm.getMonitorDate()),HighChartsUtils.divideW(sm.getSumMoney(),10000,2));
				}
				
				if(map.containsKey("总套数:" + format.format(sm.getMonitorDate()))){
					map.put("总套数:" + format.format(sm.getMonitorDate()), sm.getSumNum()+ (Integer)map.get("总套数:" + format.format(sm.getMonitorDate())));
				}else{
					map.put("总套数:" + format.format(sm.getMonitorDate()), sm.getSumNum());
				}	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] yAxisType = {"column","spline"};
		setChartSeries(HighChartsUtils.getChartSeriesByXYMulY(xAxis, yAxis, map,yAxis,yAxisType));//设置曲线
//		System.out.println(this.getChartSeries());
//设置最后3次 有权限项目 的monitorlist
		SaleMonitorCond cond = new SaleMonitorCond();
		cond.setOrderByFiled("11");//按录入时间排序
		cond.startLine = 0;
		cond.pageSize = 3;//拿3条纪录
		cond.setProjectIds(PermissionUtils.getUserProjectIdList());	
		lastMonitorList = saleMonitorServices.findSaleMonitorPage(cond);
//设置最后3次 有权限项目 的monitorlist ~~end		

//设置最后n 查看新闻公告		
	ArticleCond arcond = new ArticleCond();
	arcond.startLine = 0;
	arcond.pageSize = 10;//拿10条数据
	arcond.setDevFlag(EnumDevFlag.HENGDA.toString());
	lastArticleList = articleServices.findArticlePage(arcond);

//设置最后n 查看新闻公告~~~end	
		
		String time = CustomerUtils.getNowTimeForString();
		String now = CustomerUtils.getNowForString();
		request.getSession().setAttribute("datenow", now);
		request.getSession().setAttribute("time", time);
		//设置显示 全国查询 区域查询 录入数据
		String butindex = "";
		if(PermissionUtils.isMultiCompany()){
			butindex = "isMultiCompany";
		}else if(PermissionUtils.isMultiProject()){
			butindex = "isMultiProject";
		}
		request.getSession().setAttribute("butindex", butindex);
//		System.out.println("ggggggg"+butindex);
		return "indexForSale";
		
		
//		if(!PermissionUtils.hasPermission(SessionUser.getProjectId() ,PrivCode.SUM_SALE )){
//			String now = CustomerUtils.getNowForString();
//			request.getSession().setAttribute("datenow", now);
//			this.chartXAxis = "['11-01', '11-02', '11-03', '11-04', '11-05', '11-06', '11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']";
//			this.chartSeries =  "[{name: '恒大清远',data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6,1,1,1,1,1,1,1,1,1,1,1,1,1,11,1,11,1,1,2,2,3]}]";
//		return "indexForSale";
//	}
//		String now = CustomerUtils.getNowForString();
//		request.getSession().setAttribute("datenow", now);
//		this.chartXAxis = "['11-01', '11-02', '11-03', '11-04', '11-05', '11-06', '11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']";
//		this.chartSeries =  "[{name: '恒大清远',data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6,1,1,1,1,1,1,1,1,1,1,1,1,1,11,1,11,1,1,2,2,3]}, {name: '恒大安徽',data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]}, {name: '恒大广州',data: [-0.9, 17.9, 14.3, 9.0, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]}, {name: '恒大',data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]}]";
//		this.chartSeries1 =  "[{name: '恒大清远',data: [25.2, 26.5, 23.3, 18.3, 13.9, 9.6,4,3,6,3]}, {name: '恒大安徽',data: [-0.2,11.3, 17.0, 22.0, 24.8, 24.1, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]}, {name: '恒大广州',data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]}, {name: '恒大',data: [11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8, 14.2, 10.3, 6.6, 4.8]}]";
//		return "indexForSale";
//	}
	
	}
	public String firstLogin(){
		return "indexForSale";
	}
	
}