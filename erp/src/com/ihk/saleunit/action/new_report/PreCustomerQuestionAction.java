package com.ihk.saleunit.action.new_report;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.ReportDefineColumn;
import com.ihk.saleunit.data.pojo.ReportDefineColumnCond;
import com.ihk.saleunit.data.pojo.ReportShowTD;
import com.ihk.saleunit.data.pojo.ReportShowTR;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IReportDefineColumnServices;
import com.ihk.saleunit.data.services.IReportDefineTypeServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.ReportShowUtils;

public class PreCustomerQuestionAction extends SupperAction{
	
	@Autowired
	IPropertyProjectServices propertyProjectServices; 
	@Autowired
	IPropertyUnitServices propertyUnitServices;
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IContractServices contractServices;
	@Autowired
	IReportDefineTypeServices reportDefineTypeServices;
	@Autowired
	IReportDefineColumnServices reportDefineColumnServices;

	@Autowired ICustomerServices customerServices;

	/*
	 * 数据表的准备
	 * 1,所有单元信息；（单元表）:property_unit
	 * 2，认购表的取得；confirm
	 * 3，合同表:contract
	 * 4，报表定义表:report_define_type
	 * 5，报表定义的列:report_define_column
	 * 
	 * 在以上表格中进行重新组装得到数据
	 */
	

	/*
	 * 测试报表的组装
	 */
	public String test() {
//		List<PropertyUnit> listUnit = propertyUnitServices.findPropertyUnit(null);
//		List<Confirm> listConfirm = confirmServices.findConfirm(null);
//		List<Contract> listContract = contractServices.findContractPage(new ContractCond());
//		List<ReportDefineType> listReportDefineType = reportDefineTypeServices.findReportDefineType(new ReportDefineTypeCond());
//		List<ReportDefineColumn> listReportDefineColumn = reportDefineColumnServices.findReportDefineColumn(new ReportDefineColumnCond());
		

		List<PropertyProject> listPropertyProject = propertyProjectServices.findPropertyProject(new PropertyProjectCond());

		//报表X轴
		ReportDefineColumnCond condXColumn = new ReportDefineColumnCond();
		condXColumn.setReportName(getSelCategory1());
		List<ReportDefineColumn> listReportDefineXColumn = reportDefineColumnServices.findReportDefineColumnForY(condXColumn);	
		
		
		//重新初始化listUnit
//		ReportShowUtils.initListPropertyUnit_Confirm(listUnit,listConfirm);
//		ReportShowUtils.initListPropertyUnit_Contract(listUnit,listContract);
		
		//步骤1：进行List的定义，直接对应于html页面的Table		
		//循环unit,对Map进行填充数据		
		ArrayList<ReportShowTR> trList = new ArrayList();
		
		//表头
		ReportShowTR showTRH = new ReportShowTR("项目");
		ReportShowTD tdH = new ReportShowTD("项目");
		//tdProject.setyTypeName(listPropertyProject.get(i).getPropertyName());
		showTRH.addTD(tdH);

		for(int j=0;j<listReportDefineXColumn.size();j++){
			showTRH.addTD(new ReportShowTD(listReportDefineXColumn.get(j).getShowName()));
			
		}
		trList.add(showTRH);
		
		//形成表格
		//总货量_总套数
		//列出Y轴循环
		for(int i=0;i<listPropertyProject.size();i++){
			ReportShowTR showTR = new ReportShowTR(listPropertyProject.get(i).getPropertyName());
			ReportShowTD tdProject = new ReportShowTD(listPropertyProject.get(i).getPropertyName());
			tdProject.setyTypeName(listPropertyProject.get(i).getPropertyName());
			showTR.addTD(tdProject);

			for(int j=0;j<listReportDefineXColumn.size();j++){
				showTR.addTD(getInitShowTD(listPropertyProject.get(i).getId(),"齐定统计"));
				
			}
			trList.add(showTR);
		}		
		
		System.out.println("输出list"+trList);

		String str = ReportShowUtils.getTrsByListTR(trList);		
		
		setShowTrs(str);//设置输出
		
		System.out.println(DateTimeUtils.getNow());
		
		return "suc";
	}

	private String showTrs;
	public String getShowTrs(){
		return showTrs;
	}
	
	public void setShowTrs(String showTrs){
		this.showTrs = showTrs;
	}
	

	/**
	 * 初始化的td
	 * @param tdColumnName
	 * @return
	 */
	private ReportShowTD getInitShowTD(int y1ProjectId,String x1Text){
		ReportShowTD td = new ReportShowTD();
		td.setxTheadText(y1ProjectId+"_"+x1Text);
		td.setXyValueText("0");
		
		return td;
	}
	
	public String sqkhflReport() {
		initSearchDate();
	//	initDate();//初始化公用数据
		if(selCategory1.equals("SQKHFL_SZQY")){//所在区域
			initSZQY();
		}else if(selCategory1.equals("SQKHFL_DFLDCS")){//到访来电次数
			initDFLDCS();
		}else if(selCategory1.equals("SQKHFL_DFLDSJ")){//到访来电时间
			initDFLDSJ();
		}
		//test();//测试
		return "success";
	}


	private void initDFLDSJ() {//到访来电时间
		ArrayList<ReportShowTR> trList = new ArrayList<ReportShowTR>();
		//CustomerCond cond = new CustomerCond();
		customerCond.setDate1(new Date().toLocaleString());
		
		String[] ids = customerCond.getStrSearchProjectIds().split(",");
		List<Integer> intIds = new ArrayList<Integer>();
		for(String id : ids){
			intIds.add(Integer.parseInt(id));
		}
		customerCond.setProjectIds(intIds);
		
		List<Map> resMap = this.customerServices.countByTimeGroupByProjectId(customerCond);
		
		ReportDefineColumnCond condXColumn = new ReportDefineColumnCond();
		condXColumn.setReportName(getSelCategory1());
		List<ReportDefineColumn> listReportDefineXColumn = reportDefineColumnServices.findReportDefineColumnForY(condXColumn);	
		
		ReportShowTR showTRH = new ReportShowTR("项目");
		ReportShowTD tdH = new ReportShowTD("项目");
		showTRH.addTD(tdH);
		for(int j=0;j<listReportDefineXColumn.size();j++){
			showTRH.addTD(new ReportShowTD(listReportDefineXColumn.get(j).getShowName()));
			
		}
		trList.add(showTRH);
		
		for(Map p : resMap){
			ReportShowTR tr = new ReportShowTR();
			String projectName = DescUtils.getCompanyProjectRealName(Integer.parseInt(p.get("project_id").toString()));
			ReportShowTD td = new ReportShowTD(projectName);
			tr.addTD(td);
			td = new ReportShowTD(p.get("time1").toString());
			tr.addTD(td);
			td = new ReportShowTD(p.get("time2").toString());
			tr.addTD(td);
			td = new ReportShowTD(p.get("time3").toString());
			tr.addTD(td);
			td = new ReportShowTD(p.get("time4").toString());
			tr.addTD(td);
			trList.add(tr);
		}
		String str = ReportShowUtils.getTrsByListTR(trList);		
		setShowTrs(str);//设置输出
	}
	
	private void initDFLDCS() {//到访来电次数
		ArrayList<ReportShowTR> trList = new ArrayList<ReportShowTR>();
		//CustomerCond cond = new CustomerCond();
		//customerCond.setDate1(new Date().toLocaleString());
		
		String[] ids = customerCond.getStrSearchProjectIds().split(",");
		List<Integer> intIds = new ArrayList<Integer>();
		for(String id : ids){
			intIds.add(Integer.parseInt(id));
		}
		customerCond.setProjectIds(intIds);
		
		List<Map> resMap = this.customerServices.countByVisitCountGroupByProjectId(customerCond);
		
		ReportDefineColumnCond condXColumn = new ReportDefineColumnCond();
		condXColumn.setReportName(getSelCategory1());
		List<ReportDefineColumn> listReportDefineXColumn = reportDefineColumnServices.findReportDefineColumnForY(condXColumn);	
		
		ReportShowTR showTRH = new ReportShowTR("项目");
		ReportShowTD tdH = new ReportShowTD("项目");
		showTRH.addTD(tdH);
		for(int j=0;j<listReportDefineXColumn.size();j++){
			showTRH.addTD(new ReportShowTD(listReportDefineXColumn.get(j).getShowName()));
			
		}
		trList.add(showTRH);
		
		for(Map p : resMap){
			ReportShowTR tr = new ReportShowTR();
			String projectName = DescUtils.getCompanyProjectRealName(Integer.parseInt(p.get("project_id").toString()));
			ReportShowTD td = new ReportShowTD(projectName);
			tr.addTD(td);
			td = new ReportShowTD(p.get("con1").toString());
			tr.addTD(td);
			td = new ReportShowTD(p.get("con2").toString());
			tr.addTD(td);
			td = new ReportShowTD(p.get("con3").toString());
			tr.addTD(td);
			trList.add(tr);
		}
		
		String str = ReportShowUtils.getTrsByListTR(trList);		
		setShowTrs(str);//设置输出
	}

	private void initSZQY() {//所在区域
		ArrayList<ReportShowTR> trList = new ArrayList<ReportShowTR>();
		//CustomerCond cond = new CustomerCond();
		
		String[] ids = customerCond.getStrSearchProjectIds().split(",");
		List<Integer> intIds = new ArrayList<Integer>();
		for(String id : ids){
			intIds.add(Integer.parseInt(id));
		}
		customerCond.setProjectIds(intIds);
		
		//List<Map> resMap = this.customerServices.countByTimeGroupByProjectId(customerCond);
		
		ReportDefineColumnCond condXColumn = new ReportDefineColumnCond();
		condXColumn.setReportName(getSelCategory1());
		List<ReportDefineColumn> listReportDefineXColumn = reportDefineColumnServices.findReportDefineColumnForY(condXColumn);	
		
		ReportShowTR showTRH = new ReportShowTR("项目");
		ReportShowTD tdH = new ReportShowTD("项目");
		showTRH.addTD(tdH);
		for(int j=0;j<listReportDefineXColumn.size();j++){
			showTRH.addTD(new ReportShowTD(listReportDefineXColumn.get(j).getShowName()));
			
		}
		trList.add(showTRH);
		
		
		String str = ReportShowUtils.getTrsByListTR(trList);		
		setShowTrs(str);//设置输出
	}
	
	

	private void initSearchDate(){
		if (customerCond == null) {
			customerCond = new CustomerCond();
			customerCond.addPermissionChartProjectIds();	
			customerCond.setSearchProjectIds(customerCond.getPrivProjectIds());
			
			customerCond.setDate1(CommonUtils.getMonthFirstForString());
			customerCond.setDate2(CommonUtils.getOneDayBeforeForString(new Date()));

			if(selCategory1 == null){
				selCategory1 = "SQKHFL_SZQY";//默认 所在区域
			}
			
		}
		
		
	}

	private CustomerCond customerCond;
	private String projectName;
	//选中的分析内容1
	private String selCategory1;

	//下拉框(分析内容1)
	private LinkedHashMap<String, String> listSelCategory1;

	/**
	 * 分析内容1的列表
	 * @return
	 */
	public LinkedHashMap<String, String> getListSelCategory1() {
		if(listSelCategory1==null){
			listSelCategory1 = new LinkedHashMap<String, String>();
			
			//listSelCategory1.put("SQKHFL_WYJZ","物业价值");
			//listSelCategory1.put("SQKHFL_SZQY","所在区域");
			listSelCategory1.put("SQKHFL_DFLDCS","到访来电次数");
			listSelCategory1.put("SQKHFL_DFLDSJ","到访来电时间");

		}
		return listSelCategory1;
	}

	public CustomerCond getCustomerCond() {
		return customerCond;
	}

	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
	}

	public String getSelCategory1() {
		return selCategory1;
	}

	public void setSelCategory1(String selCategory1) {
		this.selCategory1 = selCategory1;
	}


	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
}
