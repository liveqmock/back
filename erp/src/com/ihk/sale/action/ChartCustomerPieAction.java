package com.ihk.sale.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.SupperAction;

/**
 * 客户的饼图
 * 
 * 实现思路
 * 1,按时间取得数据库对应的分组数据<br>
 * 2,形成显示的表格List<List>,嵌套显示表格
 */
public class ChartCustomerPieAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ChartCustomerPieAction.class);

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

	//分组的tr标题(内部List中的内容为val,desc)
	private List<List> listCategory;	
	//数据库分组结果
	private List<Map> listDBData;
	//主体表格数据
	private List<List> listMainTable;	
	
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

	public CustomerCond getCustomerCond() {
		return customerCond;
	}

	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
	}

	public List<List> getListCategory() {
		return listCategory;
	}

	public List<List> getListMainTable() {		
		return listMainTable;
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
	private void initSearchDate(){
		if (customerCond == null) {
			customerCond = new CustomerCond();
		}
		if (CustomerUtils.isStrEmpty(customerCond.getDate1())) {
			customerCond.setDate1(CommonUtils.getMonthFirstForString());
		}
		if (CustomerUtils.isStrEmpty(customerCond.getDate2())) {
			customerCond.setDate2(CommonUtils.getMonthEndForString());
		}
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
		for(int i=0;i<listCode.size();i++){
			List<String> val = new ArrayList<String>();
			val.add(listCode.get(i).getCodeVal());
			val.add(listCode.get(i).getCodeDesc());
			listCategory.add(val);
		}
		
	}
	

	private void initMapMainTable() {

		// xy轴形成的点的map（唯一对应一点）
		Map map = new HashMap(); //
		for (Iterator it = listDBData.iterator(); it.hasNext();) {
			Map mEach = (Map) it.next();
			String mapKey = "";
			if(mEach.get("category")!=null){
				mapKey = mEach.get("category").toString();
			}
			map.put(mapKey, mEach.get("num"));			
		}
		
		listMainTable = new ArrayList<List>(); 
		
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
			listMainTable.add(listLine); 
		}

		//添加合计行
		List<Object> listLine=new ArrayList<Object>();
		listLine.add("合计"); 
		sumTableNum = 0;
		if(listMainTable.size()>0){
			for(int i=0;i<listMainTable.size();i++){
				sumTableNum+=Integer.valueOf(listMainTable.get(i).get(1).toString());
			}
			listLine.add(sumTableNum);
		}
		listMainTable.add(listLine); 
		
		//形成比例一列
		for(int i=0;i<listMainTable.size();i++){
			String strPercent; 
			if(sumTableNum>0){
				strPercent = String.valueOf(Integer.valueOf(listMainTable.get(i).get(1).toString())*100/sumTableNum)+"%";
			}
			else {
				strPercent = "";
			}
			listMainTable.get(i).add(strPercent);
		}
		
		logger.info(listMainTable);

	}

	public String execute() throws Exception {		 
	  return showPie();
	} 
	
	//查看分析区域
	@SuppressWarnings("unchecked")
	public String showPie() {	
		if(selCategory==null){
			selCategory = "HOME_DISTRICT";
		}
		initSearchDate();		
		
		initListCategory();
		
		initCond();

		//查询数据库,形成分组(类别,日期)后的数据
		customerCond.setGroupField(selCategory);
		listDBData = customerServices.findCustomerGroupByCategory(customerCond); 
		
		initMapMainTable();
		
		return "success";
	}
	
	public String getChartSeriesData(){
		String str = "";
		if(sumTableNum>0){
			for(int i=0;i<listMainTable.size()-1;i++){
				str+= "['"+listMainTable.get(i).get(0)+"',"+listMainTable.get(i).get(1)+"]";
				if(i<listMainTable.size()-1){
					str+= ",";
				}
			}
		}
		else{
			str = "['无数据',1]";
		}
		return str;
	}


	//分析表
	public String getUrlTable(){
		return "./sale_hengda/chart/customerTable.action?customerCond.date1="+customerCond.getDate1()+"&customerCond.date2="
			+customerCond.getDate2() + "&customerCond.companyId="+customerCond.getCompanyId() + "&customerCond.projectId="+customerCond.getProjectId()
			+"&selCategory="+selCategory;
	}

	//环比走势
	public String getUrlCategoryNum(){
		return "./sale_hengda/chart/categoryNum.action?customerCond.date1="+customerCond.getDate1()+"&customerCond.date2="
			+customerCond.getDate2() + "&customerCond.companyId="+customerCond.getCompanyId() + "&customerCond.projectId="+customerCond.getProjectId()
			+"&selCategory="+selCategory;
	}
}
