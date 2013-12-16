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

import com.ihk.utils.DescUtils;
import com.ihk.utils.HighChartsUtils;
import java.text.ParseException;

/**
 * 统计单个项目的各个指标
 * 
 * 
 */
public class ChartOneProjectAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SaleReportAction.class);

	@Autowired
	ISaleMonitorServices isaleMonitorServices;
	@Autowired
	ICompanyProjectServices comProjectServices;

	private SaleMonitorCond saleMonitorCond;

	public void setSaleMonitorCond(SaleMonitorCond saleCond) {
		this.saleMonitorCond = saleCond;
	}

	public SaleMonitorCond getSaleMonitorCond() {
		return saleMonitorCond;
	}

	private LinkedHashMap<String, String> selProject;

	public void setSelProject(LinkedHashMap<String, String> selProject) {
		this.selProject = selProject;
	}

	public LinkedHashMap<String, String> getSelProject() {
		return selProject;
	}

	public void initSelProject() {
		if (this.selProject == null) {
			selProject = new LinkedHashMap<String, String>();
			selProject.put("", CommonUtils.ALL);
			List<CompanyProject> userProjects = PermissionUtils
					.getUserProjectListByUid(SessionUser.getUserId());
			CompanyProject userProject = comProjectServices
					.findCompanyProjectById(SessionUser.getProjectId()); // 用户自身所属的项目
			selProject.put(userProject.getId() + "",
					userProject.getProjectName());
			for (CompanyProject pro : userProjects) {
				selProject.put(pro.getId() + "", pro.getProjectName());
			}

		}
	}

	// x坐标
	private String chartXAxis;

	public String getChartXAxis() {
		return chartXAxis;// "['11-01', '11-02', '11-03', '11-04', '11-05', '11-06', '11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']";
	}

	public void setChartXAxis(String chartXAxis) {
		this.chartXAxis = chartXAxis;
	}

	// 具体不同曲线的值
	private String chartSeries;

	public String getChartSeries() {
		return chartSeries;// "[{name: '恒大清远',data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6,1,1,1,1,1,1,1,1,1,1,1,1,1,11,1,11,1,1,2,2,3]}, {name: '恒大安徽',data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]}, {name: '恒大广州',data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]}, {name: '恒大',data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]}]";
	}

	public void setChartSeries(String chartSeries) {
		this.chartSeries = chartSeries;
	}
	

	//查看单个项目的各项数据
	@SuppressWarnings("unchecked")
	public String getOneProjectChart() {
		initSelProject();

		// 跟进地址栏设置参数
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

		List l = isaleMonitorServices.findSaleMonitorPage(saleMonitorCond);

		DateFormat format = new SimpleDateFormat("MM-dd");

		//坐标(Y轴)		
		String[] yAxis={"电话数","来访数","住宅数","商铺数"}; // 各项指标

		// 日期坐标(X轴)
		setChartXAxis(HighChartsUtils.getDaysXAxis(saleMonitorCond.getDate1(),saleMonitorCond.getDate2()));// "['11-01', '11-02', '11-03', '11-04', '11-05', '11-06', '11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']");
		String[] xAxis = getChartXAxis().replace("[", "").replace("]", "")
				.replace(" ", "").replace("'", "").split(",");

		// xy轴形成的点的map（唯一对应一点）
		Map<String, Integer> map = new HashMap<String, Integer>(); //
		for (Iterator it = l.iterator(); it.hasNext();) {
			SaleMonitor sm = (SaleMonitor) it.next();
			map.put("电话数:" + format.format(sm.getMonitorDate()), sm.getPhoneNum());
			map.put("来访数:" + format.format(sm.getMonitorDate()), sm.getVisitorNum());
			map.put("住宅数:" + format.format(sm.getMonitorDate()), sm.getHouseNum());
			map.put("商铺数:" + format.format(sm.getMonitorDate()), sm.getShopNum());
		}

		//设置曲线
		setChartSeries(HighChartsUtils.getChartSeriesByXY(xAxis, yAxis, map,yAxis));

		return "getOne";
	}




}
