package com.ihk.sale.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.SupperAction;

/**
 * 客户单项数据走势
 *  * 
 * 实现思路
 * 1,按时间取得数据库对应的分组明细数据(以类别,日期分组)<br>
 * 2,形成显示的表格List<List>,嵌套显示表格
 */
public class ChartCategoryNumAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ChartCategoryNumAction.class);

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
	
	//初始化公司及项目
	private void initCompanyAndProject(boolean isGet){
		initSelCompany();
		initSelProject(isGet);
	}
	
	private void initCond(){
		
		HttpSession session = request.getSession();
		
		String getComId = customerCond.getCompanyId();
		if(!CustomerUtils.isStrEmpty(getComId) && !"null".equals(getComId)){
			
			initCompanyAndProject(true);
			customerCond.setProjectIds(HengDaUtils.getProjectsByCompanyIdForHengDa(Integer.parseInt(getComId)));
		}else{
			
			initCompanyAndProject(false);
			customerCond.setProjectIds(HengDaUtils.getUserProjects());
		}
		session.setAttribute("companyId", customerCond.getCompanyId());
		session.setAttribute("projectId", customerCond.getProjectId());
		
	}
	
	private CustomerCond customerCond;

	//日期坐标行(内部List中的内容为yyyy-MM-dd,dd,MM-dd)
	private List<List> listDate;
	//分组的tr标题(内部List中的内容为val,desc)
	private List<List> listCategory;	
	//数据库分组结果
	private List<Map> listDBData;

	private String[] yAxis ;

	//下拉框(分析类型)
	private LinkedHashMap<String, String> listSelCategory;
	
	public LinkedHashMap<String, String> getListSelCategory() {
		if(listSelCategory==null){
			listSelCategory = CustomerUtils.getListSelCategory();
		}
		return listSelCategory;
	}

	//选中的分析类型
	private String selCategory;
	
	public String getSelCategory() {
		return this.selCategory;
	}
		
	public void setSelCategory(String selCategory) {
		this.selCategory = selCategory;
	}

	public CustomerCond getCustomerCond() {
		return customerCond;
	}

	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
	}

	public List<List> getListCategory() {
		return listCategory;
	}

	private String projectName;
	

	public String getProjectName() {
		if(projectName==null&& customerCond!=null){
			projectName = DescUtils.getCompanyProjectRealName(customerCond.getProjectId());
		}
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	//初始化日期
	private void initListDate(){
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
		
		logger.info("listDate:"+listDate);
	}

	//初始化分类
	private void initListCategory(){
		listCategory = new ArrayList<List>(); 
		List<CodeDtl> listCode ;

		try{
			EnumCodeTypeName.valueOf(selCategory);
			listCode = codeTypeServices.findCodeList(EnumCodeTypeName.valueOf(selCategory).name(), 5);//暂时固定id
		}
		catch(Exception ex){
			if(selCategory.equals("HOME_DISTRICT")){
				listCode = codeTypeServices.findCodeList(EnumCodeTypeName.CUSTOMER_REGION.name(), 5);//暂时固定id
			}
			else if(selCategory.equals("WORK_DISTRICT")){
				listCode = codeTypeServices.findCodeList(EnumCodeTypeName.CUSTOMER_REGION.name(), 5);//暂时固定id
			}
			else{
				return;
			}
		}

//		List<CodeDtl> listCode = codeTypeServices.findCodeList(CodeTypeName.CUSTOMER_REGION.name(), 5);//暂时固定id

		ArrayList tmpYAxis = new ArrayList();
		ArrayList tmpYAxisType = new ArrayList();
		
		for(int i=0;i<listCode.size();i++){
			List<String> val = new ArrayList<String>();
			val.add(listCode.get(i).getCodeVal());
			val.add(listCode.get(i).getCodeDesc());
			listCategory.add(val);
			
			tmpYAxis.add(listCode.get(i).getCodeDesc());
			tmpYAxisType.add("spline");
		}		

		yAxis = (String[])tmpYAxis.toArray(new String[0]);			
		
		logger.info(yAxis);
	}
	
	private String getCodeDesc(String val){
		
		String str = "";
		for(int i=0;i<listCategory.size();i++){
			if(val.equals(listCategory.get(i).get(0))){
				str = listCategory.get(i).get(1).toString();
				logger.info("doget"+str);
				i=listCategory.size();
			}
		}
		
		return str;
		
	}
	


	public String execute() throws Exception {		 
	  return showNum();
	} 
	
	//查看走势图
	public String showNum() {	
		if(selCategory==null){
			selCategory = "HOME_DISTRICT";
		}
		initListDate();		
		
		initListCategory();

		//查询数据库,形成分组(类别,日期)后的数据
		logger.info("customerCond"+customerCond);
		logger.info("customerCond.getDate1()"+customerCond.getDate1());
		customerCond.setGroupField(selCategory);
		listDBData = customerServices.findCustomerGroup(customerCond); 
		
		
		logger.info("listDBData:"+listDBData);
		
		return "success";
	}
	

	public String getChartXAxis(){
		//'11-28','11-29','11-30','12-01', '12-02', '12-03', '12-04', '12-05', '12-06', '12-07'
		String str = "";		
		str = HighChartsUtils.getDaysXAxis(customerCond.getDate1(),customerCond.getDate2());
		
		return str;
	}
	
	public String getChartSeriesData(){		
		String[] xAxis = getChartXAxis().replace("[", "").replace("]", "").replace(" ", "").replace("'", "").split(",");

		// xy轴形成的点的map（唯一对应一点）
		Map map = new HashMap(); //
		for (int i=0;i<listDBData.size(); i++) {
			if(listDBData.get(i).get("category")!=null){
				String desc = getCodeDesc(listDBData.get(i).get("category").toString());
				logger.info("do-desc");
				if(desc!=null && !desc.equals("")){
					logger.info("do-pumapx"+listDBData.get(i));
					map.put(desc+":" + listDBData.get(i).get("categoryDate").toString().substring(5), listDBData.get(i).get("num"));
					logger.info("do-pumap");
				}
			}
		}

		logger.info("map"+map);
		String str = HighChartsUtils.getChartSeriesByXY(xAxis, yAxis, map,yAxis);
		
		
		return str;
	}

	//分析表
	public String getUrlTable(){
		return "./sale_hengda/chart/customerTable.action?customerCond.date1="+customerCond.getDate1()+"&customerCond.date2="
			+customerCond.getDate2()+"&customerCond.companyId="+customerCond.getCompanyId() + "&customerCond.projectId=" + customerCond.getProjectId()
			+"&selCategory="+selCategory;
	}
		
	//比例分析
	public String getUrlPie(){
		return "./sale_hengda/chart/customerPie.action?customerCond.date1="+customerCond.getDate1()+"&customerCond.date2="
		+customerCond.getDate2()+"&customerCond.companyId="+customerCond.getCompanyId() + "&customerCond.projectId=" + customerCond.getProjectId()
		+"&selCategory="+selCategory;
	}

}
