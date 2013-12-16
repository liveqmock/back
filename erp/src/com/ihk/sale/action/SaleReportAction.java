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
import java.text.ParseException;

/**
 * 统计各个项目的销售金额的每天曲线报表
 * 
 * 
 */
public class SaleReportAction extends SupperAction {

	private static final long serialVersionUID = 4312776243869704193L;
	private static final Logger logger = Logger
			.getLogger(SaleReportAction.class);

	@Autowired
	ISaleMonitorServices isaleMonitorServices;
	@Autowired
	ICompanyProjectServices comProjectServices;

	private SaleMonitorCond saleMonitorCond;
	
	private SaleMonitor saleMonitor;
	

	public void setSaleMonitorCond(SaleMonitorCond saleCond) {
		this.saleMonitorCond = saleCond;
	}

	public SaleMonitorCond getSaleMonitorCond() {
		return saleMonitorCond;
	}
	

	private List<SaleMonitor> saleMonitorlist;

	private SaleMonitorCond cond;

	private LinkedHashMap<String, String> selProject;
	
	private LinkedHashMap<String, String> selSaleMonitor;
	
	
	public SaleMonitor getSaleMonitor() {
		return saleMonitor;
	}

	public void setSaleMonitor(SaleMonitor saleMonitor) {
		this.saleMonitor = saleMonitor;
	}

	public LinkedHashMap<String, String> getSelSaleMonitor() {
		return selSaleMonitor;
	}

	public void setSelSaleMonitor(LinkedHashMap<String, String> selSaleMonitor) {
		this.selSaleMonitor = selSaleMonitor;
	}

	public void setSelProject(LinkedHashMap<String, String> selProject) {
		this.selProject = selProject;
	}

	public LinkedHashMap<String, String> getSelProject() {
		return selProject;
	}

	public void initSelProject()  {
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
	

	
	public List<SaleMonitor> getSaleMonitorlist() {
		return saleMonitorlist;
	}

	public void setSaleMonitorlist(List<SaleMonitor> saleMonitorlist) {
		this.saleMonitorlist = saleMonitorlist;
	}

	public SaleMonitorCond getCond() {
		return cond;
	}

	public void setCond(SaleMonitorCond cond) {
		this.cond = cond;
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
		// return
		// "['11-01', '11-02', '11-03', '11-04', '11-05', '11-06', '11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']";
	}

	public void setChartSeries(String chartSeries) {
		this.chartSeries = chartSeries;
	}

	//查看各个项目的销售数据
	@SuppressWarnings("unchecked")
	public String getAllProjectMoney() {
		// 接收地址栏参数（例如项目id,日期范围，类型)
		// 查数据库
		// 1,setChartXAxis
		// 2,setChartSeries(String)
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

		List<Integer> pIds = PermissionUtils
				.getUserProjectIdListByUid(SessionUser.getUserId());
		saleMonitorCond.setProjectIds(pIds);

		List l = isaleMonitorServices.findSaleMonitorPage(saleMonitorCond);

		DateFormat format = new SimpleDateFormat("MM-dd");

		// 查询的项目id
		String[] yAxis;

		if (saleMonitorCond.getProjectId() > 0) {
			yAxis = new String[1];
			yAxis[0] = String.valueOf(saleMonitorCond.getProjectId());
		} else {
			yAxis = new String[pIds.size()];// {"21","22"};
			for (int i = 0; i < pIds.size(); i++) {
				yAxis[i] = String.valueOf(pIds.get(i));
			}
		}

		logger.debug(getDaysXAxis(saleMonitorCond.getDate1(),
				saleMonitorCond.getDate2()));

		// 日期坐标
		setChartXAxis(getDaysXAxis(saleMonitorCond.getDate1(),
				saleMonitorCond.getDate2()));// "['11-01', '11-02', '11-03', '11-04', '11-05', '11-06', '11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']");
		String[] xAxis = getChartXAxis().replace("[", "").replace("]", "")
				.replace(" ", "").replace("'", "").split(",");

		Map<String, Integer> map = new HashMap<String, Integer>(); //
		for (Iterator it = l.iterator(); it.hasNext();) {
			SaleMonitor sm = (SaleMonitor) it.next();
			String key = sm.getProjectId() + ":"
					+ format.format(sm.getMonitorDate());
			map.put(key, sm.getCompleteMoney());
		}

		setChartSeries(getChartSeriesByXY(xAxis, yAxis, map));

		return "salereportlist";
	}
	/**
	 * 日各指标数据
	 * @return
	 */
	public String saleReportTargetList(){
//		initSelProject();
//		if (saleMonitorCond == null) {
//			saleMonitorCond = new SaleMonitorCond();
//		}
		return "salereporttargetlist";
	}

	public String test1() {
		// 接收地址栏参数（例如项目id,日期范围，类型)
		// 查数据库
		// 1,setChartXAxis
		// 2,setChartSeries(String)
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

		List<Integer> pIds = PermissionUtils
				.getUserProjectIdListByUid(SessionUser.getUserId());
		saleMonitorCond.setProjectIds(pIds);

		List l = isaleMonitorServices.findSaleMonitorPage(saleMonitorCond);

		DateFormat format = new SimpleDateFormat("MM-dd");

		// 查询的项目id
		String[] yAxis;

		if (saleMonitorCond.getProjectId() > 0) {
			yAxis = new String[1];
			yAxis[0] = String.valueOf(saleMonitorCond.getProjectId());
		} else {
			yAxis = new String[pIds.size()];// {"21","22"};
			for (int i = 0; i < pIds.size(); i++) {
				yAxis[i] = String.valueOf(pIds.get(i));
			}
		}

		logger.debug(getDaysXAxis(saleMonitorCond.getDate1(),
				saleMonitorCond.getDate2()));

		// 日期坐标
		setChartXAxis(getDaysXAxis(saleMonitorCond.getDate1(),
				saleMonitorCond.getDate2()));// "['11-01', '11-02', '11-03', '11-04', '11-05', '11-06', '11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']");
		String[] xAxis = getChartXAxis().replace("[", "").replace("]", "")
				.replace(" ", "").replace("'", "").split(",");

		Map<String, Integer> map = new HashMap<String, Integer>(); //
		for (Iterator it = l.iterator(); it.hasNext();) {
			SaleMonitor sm = (SaleMonitor) it.next();
			String key = sm.getProjectId() + ":"
					+ format.format(sm.getMonitorDate());
			map.put(key, sm.getCompleteMoney());
		}

		setChartSeries(getChartSeriesByXY(xAxis, yAxis, map));

		return "testResult";
	}

	// 根据x坐标y坐标以及哈希表，得到格式字符串，用于显示曲线
	private String getChartSeriesByXY(String[] xAxis, String[] yAxis,
			Map<String, Integer> mapLine) {
		StringBuilder sb = new StringBuilder("[");

		// 循环项目
		for (int i = 0; i < yAxis.length; i++) {
			String projectName = DescUtils.getCompanyProjectRealName(Integer
					.parseInt(yAxis[i]));
			sb.append("{name:'" + projectName + "',data:[");

			// 循环日期
			for (int j = 0; j < xAxis.length; j++) {
				String keyN = yAxis[i] + ":" + xAxis[j];
				if (mapLine.containsKey(keyN)) {
					sb.append(String.valueOf(mapLine.get(keyN)));
				} else {
					sb.append("0");
				}

				if ((j + 1) < xAxis.length) {
					sb.append(",");
				}
			}

			sb.append("]}");

			if ((i + 1) < yAxis.length) {
				sb.append(",");
			}
		}

		sb.append("]");

		return sb.toString();
	}

	// 日期x坐标
	private String getDaysXAxis(String date1, String date2) {
		StringBuilder sb = new StringBuilder("[");

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat formatShow = new SimpleDateFormat("MM-dd");

		Date ddate1 = null;
		Date ddate2 = null;
		Calendar cal = Calendar.getInstance();
		try {
			ddate1 = format.parse(date1);
			ddate2 = format.parse(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 循环日期
		Calendar ca = Calendar.getInstance();
		while (ddate1.compareTo(ddate2) <= 0) {
			sb.append("'");
			sb.append(formatShow.format(ddate1));
			sb.append("'");

			ca.setTime(ddate1);
			ca.add(ca.DATE, 1);
			ddate1 = ca.getTime();

			if (ddate1.compareTo(ddate2) <= 0) {
				sb.append(",");
			}
		}

		sb.append("]");

		return sb.toString();
	}
	// 在售项目x坐标
	

}
