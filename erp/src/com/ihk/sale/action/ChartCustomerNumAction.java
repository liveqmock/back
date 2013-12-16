package com.ihk.sale.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumChartCycel;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.UIUtils;

/**
 * 客户的曲线图(来访数量图)(恒大使用)
 * 
 * 
 */
@SuppressWarnings("rawtypes")
public class ChartCustomerNumAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICodeTypeServices codeTypeServices;
	@Autowired
	ICustomerServices customerServices;
	
	private LinkedHashMap<String, String> selCompany;
	private LinkedHashMap<String, String> selProject;
	
	public void setSelProject(LinkedHashMap<String, String> selProject) {
		this.selProject = selProject;
	}
	
	public LinkedHashMap<String, String> getSelProject() {
		return selProject;
	}
	
	private void initSelProject(boolean isGet){
		selProject = new LinkedHashMap<String, String>();
		
		selProject.put("", CommonUtils.ALL);
		
		if(isGet){
			selProject = HengDaUtils.getProjectsByCompanyId(Integer.parseInt(customerCond.getCompanyId()));
		}
		
	}
	
	public void setSelCompany(LinkedHashMap<String, String> selCompany) {
		this.selCompany = selCompany;
	}
	
	public LinkedHashMap<String, String> getSelCompany() {
		return selCompany;
	}
	
	private void initSelCompany(){
		selCompany = HengDaUtils.getSelCompany();
	}
	
	private CustomerCond customerCond;

	//日期坐标行(内部List中的内容为yyyy-MM-dd,dd,MM-dd)
	private List<List> listDate;
	//数据库分组结果
	private List<Map> listDBData;
	
	private String projectName;
	

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public CustomerCond getCustomerCond() {
		return customerCond;
	}

	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
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

	//初始化公司及项目
	private void initCompanyAndProject(boolean isGet){
		initSelCompany();
		initSelProject(isGet);
	}
	
	private void initCond(){
		
		HttpSession session = request.getSession();
		
		String getComId = customerCond.getCompanyId();
		if(!CustomerUtils.isStrEmpty(getComId)){
			
			initCompanyAndProject(true);
			customerCond.setProjectIds(HengDaUtils.getProjectsByCompanyIdForHengDa(Integer.parseInt(getComId)));
		}else{
			
			initCompanyAndProject(false);
			customerCond.setProjectIds(HengDaUtils.getUserProjects());
		}
		session.setAttribute("companyId", customerCond.getCompanyId());
		session.setAttribute("projectId", customerCond.getProjectId());
		
	}

	//初始化日期
	private void initListDateAndCond(){
		
		if (customerCond == null) {
			customerCond = new CustomerCond();
		}
		if (CustomerUtils.isStrEmpty(customerCond.getDate1())) {
			customerCond.setDate1(CommonUtils.getMonthFirstForString());
		}
		if (CustomerUtils.isStrEmpty(customerCond.getDate2())) {
			customerCond.setDate2(CommonUtils.getMonthEndForString());
		}
		
		initCond();
		
		DateTime[] dates = DateTimeUtils.getDates(customerCond.getDate1(),customerCond.getDate2());
		List<String> listDate = DateTimeUtils.toListStr(dates);
		List<String> listSimpleDate = DateTimeUtils.toListStr(dates,"dd");
		List<String> listMMddDate = DateTimeUtils.toListStr(dates,"MM-dd");
		
		this.listDate = new ArrayList<List>();
		for(int i=0;i<listDate.size();i++){
			List<String> val = new ArrayList<String>();
			val.add(listDate.get(i));
			val.add(listSimpleDate.get(i));
			val.add(listMMddDate.get(i));
						
			this.listDate.add(val);
		}	
		
	}


	public String execute() throws Exception {		 
	  return showNum();
	} 
	
	//查看走势图
	public String showNum() {	
		
		initListDateAndCond();		

		//查询数据库,形成分组(日期)后的数据
		listDBData = customerServices.findCustomerGroupNum(customerCond); 		
		
		return "success";
	}
	

	public String getChartXAxis(){
		String str = "";	
		
		if(selCycel.equals(EnumChartCycel.WEEK.toString().toLowerCase())){
			str = HighChartsUtils.getDaysXAxisMonday(customerCond.getDate1(),customerCond.getDate2());	
		}
		else if(selCycel.equals(EnumChartCycel.MONTH.toString().toLowerCase())){
			str = HighChartsUtils.getDaysXAxisMonthFirstDay(customerCond.getDate1(),customerCond.getDate2());				
		}
		else {
			str = HighChartsUtils.getDaysXAxis(customerCond.getDate1(),customerCond.getDate2());			
		}
		
		return str;
	}
	
	@SuppressWarnings("unchecked")
	public String getChartSeriesData(){		
		String[] xAxis = getChartXAxis().replace("[", "").replace("]", "").replace(" ", "").replace("'", "").split(",");

		// xy轴形成的点的map（唯一对应一点）
		Map map = new HashMap(); //
		for (int i=0;i<listDBData.size(); i++) {
			String key = "";

			if(selCycel.equals(EnumChartCycel.WEEK.toString().toLowerCase())){
				key = DateTimeUtils.getMondayStr(listDBData.get(i).get("categoryDate").toString()).substring(5);
			}
			else if(selCycel.equals(EnumChartCycel.MONTH.toString().toLowerCase())){
				key = DateTimeUtils.getMonthFirstDayStrMMdd(listDBData.get(i).get("categoryDate").toString());
			}
			else{
				key = listDBData.get(i).get("categoryDate").toString().substring(5);				
			}
			
			//累计求和
			if(map.containsKey(key)){
				Integer val = Integer.valueOf(map.get(key).toString())+ Integer.valueOf(listDBData.get(i).get("num").toString());
				map.put(key,val);				
			}
			else{
				map.put(key, listDBData.get(i).get("num"));
			}			

		}

		String str = HighChartsUtils.getChartSeriesByX(xAxis, "人数", map);
		
		return str;
	}

}
