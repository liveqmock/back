package com.ihk.customer.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumChartCycel;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProjectDate;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProjectDateCond;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXByProject;
import com.ihk.report.data.services.IReportPreCustomerServices;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.UIUtils;
import com.ihk.utils.method.ActionAjaxMethodModifyNoThrowsExceptionCallback;

/**
 * 客户的环比曲线图
 *  * 
 * 实现思路
 * 1,按时间取得数据库对应的分组明细数据(以类别,日期分组)
 * 2,形成显示的Map<String,String>,然后返回到前段jsp里面去组成highcharts的option，显示图形
 */
public class ChartCustomerNumAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ChartCustomerNumAction.class);

	@Autowired
	IReportPreCustomerServices reportPreCustomerServices;
	
	private ReportPreCustomerProjectDateCond cond;
	
	//数据库分组结果
	private List<ReportPreCustomerProjectDate> listDBData;
	
	public String index() {
		return "success";
	}

	/**
	 * 点击查询的数据返回
	 * @return
	 * @throws Exception
	 */
	public String searchAjax() throws Exception {
		//DEMO 异步返回一个Map,json的格式
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyNoThrowsExceptionCallback() {			
			
			//获取table中要显示的json
			@Override
			public void modifyMethod() throws Exception {
				cond.setReturnCount(0);
				listDBData = reportPreCustomerServices.groupByProjectDate(cond);
				
				Map<String,String> retMap = new HashMap<String,String>();
				retMap.put("chartdata", getChartData());
				setUpEasyuiAjaxForSucc("",retMap);
			}
		});
		return null;
	}
	
	/**
	 * 形成highcharts使用的格式：
	 * <br>
	 * 	Categories,Apples,Pears,Oranges,Bananas<br>
		John,8,4,6,5<br>
		Jane,3,4,2,3<br>
		Joe,86,76,79,77<br>
		Janet,3,16,13,15<br>
	 * @return
	 */
	private String getChartData(){
		String[] xAxis = getChartXAxis().replace("[", "").replace("]", "").replace(" ", "").replace("'", "").split(",");
		
		//数据库对应的项目列表
		Map<String,String> mapProject = new HashMap<String,String>(); 
		
		//数据库对应的项目,日期值
		Map<String,Integer> mapProjectDate = new HashMap<String,Integer>(); 
		
		for (int i=0;i<listDBData.size(); i++) {
			if(listDBData.get(i).getReportDate()==null){
				continue;
			}
			
			String key = "";
			String projectName = listDBData.get(i).getProjectName();

			if(selCycel.equals(EnumChartCycel.WEEK.toString().toLowerCase())){
				key = DateTimeUtils.getMondayStr(listDBData.get(i).getReportDate()).substring(5);
				if(key.substring(1, 2).equals("-")){
					key = listDBData.get(i).getProjectName()+":"+"0"+key;
				}
			}
			else if(selCycel.equals(EnumChartCycel.MONTH.toString().toLowerCase())){
				key = listDBData.get(i).getProjectName()+":"+DateTimeUtils.getMonthFirstDayStrMMdd(listDBData.get(i).getReportDate().toString());
			}
			else{
				key = listDBData.get(i).getProjectName()+":"+listDBData.get(i).getReportDate().substring(5);
			}

				
			mapProject.put(projectName, projectName);
			//累计求和
			if(mapProjectDate.containsKey(key)){
				Integer val = Integer.valueOf(mapProjectDate.get(key).toString())+ listDBData.get(i).getSumCount();
				mapProjectDate.put(key,val);				
			}
			else{
				mapProjectDate.put(key, listDBData.get(i).getSumCount());
			}	
		}
		
		String str = HighChartsUtils.getChartDataByXAndMap(xAxis, mapProject, mapProjectDate);
		
		return str;
	}

	/**
	 * 下载数据
	 * @return
	 * @throws Exception
	 */
	public String download() throws Exception {		

		return null;
	}

	public ReportPreCustomerProjectDateCond getCond() {
		return cond;
	}

	public void setCond(ReportPreCustomerProjectDateCond cond) {
		this.cond = cond;
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
	private String selCycel=EnumChartCycel.DAY.toString().toLowerCase();
	
	public String getSelCycel() {
		return this.selCycel;
	}
		
	public void setSelCycel(String selCycel) {
		this.selCycel = selCycel;
	}
		
	
	/**
	 * 用于在jsp页面直接取得categories
	 * 按日期,显示x坐标轴
	 * @return
	 */
	public String getChartXAxis(){
		String str = "";	
		
		if(selCycel.equals(EnumChartCycel.WEEK.toString().toLowerCase())){
			str = HighChartsUtils.getDaysXAxisMonday(cond.getDate1(),cond.getDate2());	
		}
		else if(selCycel.equals(EnumChartCycel.MONTH.toString().toLowerCase())){
			str = HighChartsUtils.getDaysXAxisMonthFirstDay(cond.getDate1(),cond.getDate2());				
		}
		else {
			str = HighChartsUtils.getDaysXAxis(cond.getDate1(),cond.getDate2());			
		}
		
		return str;
	}
	

}
