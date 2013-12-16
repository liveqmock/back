package com.ihk.sale.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContProjectId;
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
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;

/**
 * 单项数据分析表
 * 
 * 实现思路:<br>
 * 1，根据条件，形成日期的x轴(表格的thead)<br>
 * 2,根据条件,形成类型的y轴(表格的第一列)<br>
 * 3,查询出数据库相应的数据，以日期，类型分组<br>
 * 4，根据以上基础数据，形成表格的主体内容
 */

@SuppressWarnings({"rawtypes","unchecked"})
public class ChartTableAnalysisAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ChartTableAnalysisAction.class);

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
	
	//日期坐标行(内部List中的内容为yyyy-MM-dd,dd,星期)
	private List<List> listDate;
	//分组的tr标题(内部List中的内容为val,desc)
	private List<List> listCategory;	
	//数据库分组结果
	private List<Map> listDBData;	
	//主体表格数据
	private List<List> listMainTable;	

	//数据库分组结果
	private List<Map> listDBCategoryData;	
	//主体汇总表格数据
	private List<List> listSumTable;	
	//合计总数
	private int sumTableNum =0;	

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
	
	public List<List> getListDate() {
		return listDate;
	}

	public List<List> getListCategory() {
		return listCategory;
	}

	public List<List> getListMainTable() {		
		return listMainTable;
	}

	public List<List> getListSumTable() {		
		return listSumTable;
	}
	
	
	public CustomerCond getCustomerCond() {
		return customerCond;
	}

	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
	}

	//初始化日期行
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
		DateTime[] dates = DateTimeUtils.getDates(customerCond.getDate1(),customerCond.getDate2());
		List<String> listDate = DateTimeUtils.toListStr(dates);
		List<String> listSimpleDate = DateTimeUtils.toListStr(dates,"dd");
		
		initCond();
		
		this.listDate = new ArrayList<List>();
		for(int i=0;i<listDate.size();i++){
			List<String> val = new ArrayList<String>();
			val.add(listDate.get(i));
			val.add(listSimpleDate.get(i));
			
			val.add(DateTimeUtils.getDayOfWeekStr(listDate.get(i)));
			
			this.listDate.add(val);
		}		
		
		HttpSession session = request.getSession();
		session.setAttribute("listDate", this.listDate);  //2
		session.setAttribute("customerCond", customerCond); //1
	}

	//初始化分类
	private void initListCategory(){
		listCategory = new ArrayList<List>(); 
		List<CodeDtl> listCode ;

		try{
			EnumCodeTypeName.valueOf(selCategory);
			listCode = codeTypeServices.findCodeList(EnumCodeTypeName.valueOf(selCategory).name(), ContProjectId.GUANG_ZHOU);//暂时固定id
		}
		catch(Exception ex){
			if(selCategory.equals("HOME_DISTRICT")){
				listCode = codeTypeServices.findCodeList(EnumCodeTypeName.CUSTOMER_REGION.name(), ContProjectId.GUANG_ZHOU);//暂时固定id
			}
			else if(selCategory.equals("WORK_DISTRICT")){
				listCode = codeTypeServices.findCodeList(EnumCodeTypeName.CUSTOMER_REGION.name(), ContProjectId.GUANG_ZHOU);//暂时固定id
			}
			else{
				return;
			}
		}

//		List<CodeDtl> listCode = codeTypeServices.findCodeList(CodeTypeName.CUSTOMER_REGION.name(), 5);//暂时固定id
		for(int i=0;i<listCode.size();i++){
			List<String> val = new ArrayList<String>();
			val.add(listCode.get(i).getCodeVal());
			val.add(listCode.get(i).getCodeDesc());
			listCategory.add(val);
		}
		
	}

	/*
	 * 主体分析表
	 */
	
	private void initMapMainTable() {

		// xy轴形成的点的map（唯一对应一点）
		Map map = new HashMap(); //
		for (Iterator it = listDBData.iterator(); it.hasNext();) {
			Map mEach = (Map) it.next();
			map.put(mEach.get("categoryDate")+","+mEach.get("category"), mEach.get("num"));			
		}
		
		listMainTable = new ArrayList<List>(); 
				
		for(int i=0;i<listCategory.size();i++){
			List<Object> listLine=new ArrayList<Object>();
			listLine.add(listCategory.get(i).get(1)); 
			for(int j=0;j<listDate.size();j++){
				String strKey = listDate.get(j).get(0)+","+listCategory.get(i).get(0);
				if(map.containsKey(strKey)){
					listLine.add(Integer.valueOf(map.get(strKey).toString()));
				}
				else{
					listLine.add(0);
				}
			}
			listMainTable.add(listLine); 
		}

		//添加合计行
		List<Object> listLine=new ArrayList<Object>();
		listLine.add("合计"); 
		if(listMainTable.size()>0){
			int colNum = listMainTable.get(0).size();
			for(int j=1;j<colNum;j++){
				int sum = 0;
				for(int i=0;i<listMainTable.size();i++){
					sum+=Integer.valueOf(listMainTable.get(i).get(j).toString());
				}
				listLine.add(sum);
			}
		}
		listMainTable.add(listLine); 
		
		request.getSession().setAttribute("listMainTable", listMainTable);  //3

	}
	

	/*
	 * 按类别分组的下方图表
	 */
	private void initMapSumTable() {

		// xy轴形成的点的map（唯一对应一点）
		Map map = new HashMap(); //
		for (Iterator it = listDBCategoryData.iterator(); it.hasNext();) {
			Map mEach = (Map) it.next();
			String mapKey = "";
			if(mEach.get("category")!=null){
				mapKey = mEach.get("category").toString();
			}
			map.put(mapKey, mEach.get("num"));			
		}
		
		listSumTable = new ArrayList<List>(); 
		
		for(int i=0;i<listCategory.size();i++){
			List<Object> listLine=new ArrayList<Object>();
			listLine.add(listCategory.get(i).get(1)); 
			String strKey = listCategory.get(i).get(0).toString();
			if(map.containsKey(strKey)){
				listLine.add(Integer.valueOf(map.get(strKey).toString()));
			}
			else{
				listLine.add(0);
			}
			listSumTable.add(listLine); 
		}

		//添加合计行
		List<Object> listLine=new ArrayList<Object>();
		listLine.add("合计"); 
		sumTableNum = 0;
		if(listSumTable.size()>0){
			for(int i=0;i<listSumTable.size();i++){
				sumTableNum+=Integer.valueOf(listSumTable.get(i).get(1).toString());
			}
			listLine.add(sumTableNum);
		}
		listSumTable.add(listLine); 
		
		//形成比例一列
		for(int i=0;i<listSumTable.size();i++){
			String strPercent; 
			if(sumTableNum>0){
				strPercent = String.valueOf(Integer.valueOf(listSumTable.get(i).get(1).toString())*100/sumTableNum)+"%";
			}
			else {
				strPercent = "";
			}
			listSumTable.get(i).add(strPercent);
		}
		
		logger.info("listSumTable"+listSumTable);
	}

	public String execute() throws Exception {		 
	  return showAnalysisDistrict();
	} 
	
	//查看分析区域
	public String showAnalysisDistrict() {	
		if(selCategory==null){
			selCategory = "HOME_DISTRICT";
		}
		//形成日期标题行(相当于是x轴)	
		initListDate();		
		
		//分组形成的tr标题(相当于是y轴)	
		initListCategory();

		//查询数据库,形成分组(类别,日期)后的数据
		customerCond.setGroupField(selCategory);
		listDBData = customerServices.findCustomerGroup(customerCond); 
		listDBCategoryData = customerServices.findCustomerGroupByCategory(customerCond); 
		
		//形成Map<String,List<Object>>形式（包括合计,未统计）
		initMapMainTable();	
		
		initMapSumTable();
		
		request.getSession().setAttribute("selCategory", getListSelCategory().get(selCategory)); //1
		return "success";
	}
	

	public String getChartSeriesData(){
		String str = "";
		if(sumTableNum>0){
			for(int i=0;i<listSumTable.size()-1;i++){
				str+= "['"+listSumTable.get(i).get(0)+"',"+listSumTable.get(i).get(1)+"]";
				if(i<listSumTable.size()-1){
					str+= ",";
				}
			}
		}
		else{
			str = "['无数据',1]";
		}
		return str;
	}


	//环比走势
	public String getUrlCategoryNum(){
		return "./sale_hengda/chart/categoryNum.action?customerCond.date1="+customerCond.getDate1()+"&customerCond.date2="
			+customerCond.getDate2() + "&customerCond.companyId="+customerCond.getCompanyId() + "&customerCond.projectId="+customerCond.getProjectId()
			+"&selCategory="+selCategory;
	}
		
	//比例分析
	public String getUrlPie(){
		return "./sale_hengda/chart/customerPie.action?customerCond.date1="+customerCond.getDate1()+"&customerCond.date2="
			+customerCond.getDate2() + "&customerCond.companyId="+customerCond.getCompanyId() + "&customerCond.projectId="+customerCond.getProjectId()
			+"&selCategory="+selCategory;
	}
	
	public String downLoad() throws Exception{
		
		HttpSession session = request.getSession();
		
		String selCategory = session.getAttribute("selCategory").toString();
		CustomerCond cond = (CustomerCond) session.getAttribute("customerCond");
		List<List> listDate = (List<List>) session.getAttribute("listDate");
		List<List> listMainTable = (List<List>) session.getAttribute("listMainTable");
		
		List<String> titleList = new ArrayList<String>();
		titleList.add(selCategory);
		titleList.add(cond.getDate1());
		titleList.add(cond.getDate2());
		
		//为了excel表的对应,把listMainTable中的数据转换成String
		for(int index=0; index<listMainTable.size(); index++){
			
			List mainTable = listMainTable.get(index);
			
			List<String> tmp = new ArrayList<String>();
			for(int i=0; i<mainTable.size(); i++){
				tmp.add(mainTable.get(i).toString());
			}
			
			listMainTable.remove(index);
			listMainTable.add(index, tmp);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("titleList", titleList); //标题行
		map.put("listDate", listDate);
		map.put("listMainTable", listMainTable);
		
		ReportUtils.downLoadReport(map, "customer-guangzhou-table.xls", "download-" + CustomerUtils.getNowForString() + "-.xls", response);
		
		//HengDaUtils.downLoadTemplate("listDate", listDate, "customer-guangzhou-table.xls", response);
		
		return null;
	}
}
