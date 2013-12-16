package com.ihk.saleunit.action.new_report;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
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
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.ReportShowUtils;

/**
 * 报表:成交客户分类
 *
 */
public class CjkhflReportAction extends SupperAction {


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
	@Autowired
	ICompanyProjectServices companyProjectServices; 
	

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
	public void setUnitCondByProjectIds(String strSearchProjectIds){
		List<Integer> projectIds = new ArrayList();
		if(strSearchProjectIds !=null&&!strSearchProjectIds.equals("")){
			for(int i=0;i<strSearchProjectIds.split(",").length;i++){
				projectIds.add(Integer.parseInt(strSearchProjectIds.split(",")[i]));
			}
			propertyUnitCond.setCompanyProjectIds(projectIds);
			if(companyProjectCond == null)
				companyProjectCond = new CompanyProjectCond();
			companyProjectCond.setProjectIds(projectIds);
		}
	}

	/*
	 * 测试报表的组装
	 */
	public String runReport() {
		
		setUnitCondByProjectIds(propertyUnitCond.getStrSearchCompanyProjectIds());
		List<CompanyProject> listCompanyProject = companyProjectServices.findCompanyProjectByCond(companyProjectCond);
		List<PropertyUnit> listUnit = propertyUnitServices.findPropertyUnit(propertyUnitCond);
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
		for(int i=0;i<listCompanyProject.size();i++){
			
			ReportShowTR showTR = new ReportShowTR(listCompanyProject.get(i).getProjectName());
			ReportShowTD tdProject = new ReportShowTD(listCompanyProject.get(i).getProjectName());
			//tdProject.setyTypeName(listPropertyProject.get(i).getPropertyName());
			showTR.addTD(tdProject);

			for(int j=0;j<listReportDefineXColumn.size();j++){
				showTR.addTD(getInitShowTD(listCompanyProject.get(i).getId(),listReportDefineXColumn.get(j).getShowName()));
				
			}
			trList.add(showTR);
		}
		
		//循环房间，归类到项目中
		for(int i=0;i<listUnit.size();i++){
			PropertyUnit unit = listUnit.get(i);
			for(int j=0;j<trList.size();j++){
				
				for(int k=0;k<trList.get(j).getTdsCount();k++){
					computeTdByUnit(trList.get(j).getTD(k),unit);	
				}
				
			}
		}
		
		String str = ReportShowUtils.getTrsByListTR(trList);		
		
		setShowTrs(str);//设置输出
		
		System.out.println(DateTimeUtils.getNow());

		return "success";
	}
	
	private void computeTdByUnit(ReportShowTD td,PropertyUnit unit){
		
		if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"普通住宅类")){
			if(unit.getProductType()!=null&&unit.getProductType().equalsIgnoreCase("普通住宅类")){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"豪宅")){
			if(unit.getProductType()!=null&&unit.getProductType().equalsIgnoreCase("豪宅")){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"写字楼、商业")){	
			if(unit.getProductType()!=null&&unit.getProductType().equalsIgnoreCase("写字楼、商业")){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
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
	
	public String cjkhflReportFirst() throws Exception{
		
		initSearchDate();
		
		return "cjkhflReportFirst";
	}
	
	public String cjkhflReport() {
		initSearchDate();
		runReport();
		return "success";
	}


	private PropertyUnitCond propertyUnitCond;	

	public PropertyUnitCond getPropertyUnitCond() {
		return propertyUnitCond;
	}

	public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
		this.propertyUnitCond = propertyUnitCond;
	}
	
	private void initSearchDate(){
		if (propertyUnitCond == null) {
			propertyUnitCond = new PropertyUnitCond();

			propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));		
			propertyUnitCond.setSearchCompanyProjectIds(propertyUnitCond.getPrivCompanyProjectIds());
			
			propertyUnitCond.setDate1(CommonUtils.getMonthFirstForString());
			propertyUnitCond.setDate2(CommonUtils.getMonthEndForString());

		}

		if(selCategory1 == null){
			selCategory1 = "SQKHFL_WYJZ";//物业价值
		}
		
	}
	
	private CompanyProjectCond companyProjectCond;

	public CompanyProjectCond getCompanyProjectCond() {
		return companyProjectCond;
	}

	public void setCompanyProjectCond(CompanyProjectCond companyProjectCond) {
		this.companyProjectCond = companyProjectCond;
	}

	// 下拉框(分析类型)
	private LinkedHashMap<String, String> listSelCategory;
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
			
			//暂时使用售前客户的分类
			listSelCategory1.put("SQKHFL_WYJZ","物业价值");
			listSelCategory1.put("SQKHFL_SZQY","所在区域");
			listSelCategory1.put("SQKHFL_DFLDCS","到访来电次数");
			listSelCategory1.put("SQKHFL_DFLDSJ","到访来电时间");

		}
		return listSelCategory1;
	}


	public String getSelCategory1() {
		return selCategory1;
	}

	public void setSelCategory1(String selCategory1) {
		this.selCategory1 = selCategory1;
	}


	
	
	
}
