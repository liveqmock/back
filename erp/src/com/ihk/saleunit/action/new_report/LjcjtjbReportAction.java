package com.ihk.saleunit.action.new_report;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContTable;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.pojo.ReportShowTD;
import com.ihk.saleunit.data.pojo.ReportShowTR;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.ReportShowUtils;

/**
 * 报表:累计成交统计表
 *
 */
public class LjcjtjbReportAction extends SupperAction{
	
	//可售情况:来自“未知来源表”
	//成交:来自confirm
	//冻结:来自单元表property_unit
	//剩余:来自单元表property_unit
	
	//楼盘项目列表(1)
	//单元数量列表(2)
	
	//根据(1)(2)两个表，以及其他来源表进行表格填充

	@Autowired
	IPropertyProjectServices propertyProjectServices; 
	@Autowired
	IPropertyUnitServices propertyUnitServices;
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IContractServices contractServices;
	@Autowired
	ICompanyProjectServices companyProjectServices;
	
	public String ljcjtjbReportFirst() throws Exception{
		
		initSearchDate();
		return "ljcjtjbReportFirst";
	}

	public String ljcjtjbReport() throws Exception{
		initSearchDate();
		test();
		return "suc";
	}
	
	/**
	 * 初始化的td
	 * @param tdColumnName
	 * @return
	 */
	private ReportShowTD getInitShowTD(int y1ProjectId,String x1Text,String x2Text){
		ReportShowTD td = new ReportShowTD();
		td.setxTheadText(y1ProjectId+"_"+x1Text+"_"+x2Text);
		td.setXyValueText("0");
		
		return td;
	}
	
	/**
	 * 添加一行
	 * @param trList
	 * @param projectName
	 * @param y2SubType
	 */
	private void addTrToList(ArrayList<ReportShowTR> trList,CompanyProject companyProject){
		ReportShowTR showTR = new ReportShowTR(companyProject.getProjectName());
		ReportShowTD tdProject = new ReportShowTD(companyProject.getProjectName());
		tdProject.setyTypeName(companyProject.getProjectName());
		tdProject.setxTheadText(String.valueOf(companyProject.getId()));
		showTR.addTD(tdProject);

		showTR.addTD(getInitShowTD(companyProject.getId(),"可售","总套数"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"可售","总面积"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"可售","总金额"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"可售","总均价"));

		showTR.addTD(getInitShowTD(companyProject.getId(),"成交","齐定套数"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"成交","齐定面积"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"成交","齐定金额"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"成交","齐定均价"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"成交","销售率"));

		showTR.addTD(getInitShowTD(companyProject.getId(),"冻结","冻结套数"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"冻结","冻结面积"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"冻结","冻结总价"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"冻结","冻结均价"));

		showTR.addTD(getInitShowTD(companyProject.getId(),"剩余","可售剩余套数"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"剩余","剩余面积"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"剩余","剩余金额"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"剩余","剩余均价"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"剩余","剩余率"));
		
		trList.add(showTR);
	}

	public void setUnitCondByProjectIds(String strSearchProjectIds){
		List<Integer> projectIds = new ArrayList();
		if(strSearchProjectIds !=null||strSearchProjectIds!=""){
			for(int i=0;i<strSearchProjectIds.split(",").length;i++){
				projectIds.add(Integer.parseInt(strSearchProjectIds.split(",")[i]));
			}
			propertyUnitCond.setCompanyProjectIds(projectIds);
			if(companyProjectCond == null)
				companyProjectCond = new CompanyProjectCond();
			companyProjectCond.setProjectIds(projectIds);
		}
	}
	
	public String test() {
		setUnitCondByProjectIds(propertyUnitCond.getStrSearchCompanyProjectIds());
		List<PropertyUnit> listUnit = propertyUnitServices.findPropertyUnit(propertyUnitCond);
		
		List<CompanyProject> listCompanyProject = companyProjectServices.findCompanyProjectByCond(companyProjectCond);		
		
		//步骤1：进行List的定义，直接对应于html页面的Table				
		ArrayList<ReportShowTR> trList = new ArrayList();
		
		//形成表格
		//总货量_总套数
		//列出Y轴循环,初始化一次表格
		for(int i=0;i<listCompanyProject.size();i++){
			CompanyProject companyProject = listCompanyProject.get(i);
			addTrToList(trList,companyProject);
		}			
		
		//循环房间，归类到项目中
		for(int i=0;i<listUnit.size();i++){
			PropertyUnit unit = listUnit.get(i);
			for(int j=0;j<trList.size();j++){
				if(trList.get(j).getTD(0).getxTheadText().equalsIgnoreCase(String.valueOf(unit.getCompanyProjectId()))){
					for(int k=0;k<trList.get(j).getTdsCount();k++){
						computeTdByUnit(trList.get(j).getTD(k),unit);	
					}
				}
			}
		}
		
		ReportShowUtils.autoAddAllSumTRToListReportShow(trList,1,0);
						
		String str = ReportShowUtils.getTrsByListTR(trList);		
		
		setShowTrs(str);//设置输出		
		request.getSession().setAttribute("showTrs", showTrs);
		System.out.println("累计成交统计表表:输出完毕"+DateTimeUtils.getNow());
		
		return "suc";
	}
	
	private void computeTdByUnit(ReportShowTD td,PropertyUnit unit){
		if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"可售_总套数")){
			if(unit.getSaleState().equals(ContUnitSaleState.SALE_ABLE)){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"可售_总面积")){
			if(unit.getSaleState().equals(ContUnitSaleState.SALE_ABLE)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"可售_总金额")){	
			if(unit.getSaleState().equals(ContUnitSaleState.SALE_ABLE)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"成交_齐定套数")){
			if(unit.getSaleState().equals(ContUnitSaleState.CONTRACT)){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"成交_齐定面积")){
			if(unit.getSaleState().equals(ContUnitSaleState.CONTRACT)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"成交_齐定金额")){
			if(unit.getSaleState().equals(ContUnitSaleState.CONTRACT)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"冻结_冻结套数")){
			if(unit.getSaleState().equals(ContUnitSaleState.FROZEN)){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"冻结_冻结面积")){
			if(unit.getSaleState().equals(ContUnitSaleState.FROZEN)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"冻结_冻结总价")){
			if(unit.getSaleState().equals(ContUnitSaleState.FROZEN)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"剩余_可售剩余套数")){
			if(unit.isShengYu()){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"剩余_剩余面积")){
			if(unit.isShengYu()){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"剩余_剩余金额")){
			if(unit.isShengYu()){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
	
	}
	
	public String download() throws Exception{
		
		final StringBuffer sb = new StringBuffer();
		
		sb.append(ContTable.TABLE_START);
		sb.append("<tr class='gboxbg'>"+
				"<th rowspan='2' width='120'"+
					"style='background-image: url(/erp/images/tianluan/gboxbg.gif);'>项目</th>"+
				"<th colspan='4'>可售</th>"+
				"<th colspan='5'>成交</th>"+
				"<th colspan='4'>冻结</th>"+
				"<th colspan='5'>剩余</th>"+
				"</tr>"+
				"<tr class='gboxbg'>"+
				"<th>套数</th>"+
				"<th>面积</th>"+
				"<th>金额</th>"+
				"<th>均价</th>"+
				"<th>齐定套数</th>"+
				"<th>齐定面积</th>"+
				"<th>齐定金额</th>"+
				"<th>齐定均价</th>"+
				"<th>销售率</th>"+
				"<th>冻结套数</th>"+
				"<th>冻结面积</th>"+
				"<th>冻结总价</th>"+
				"<th>冻结均价</th>"+
				"<th>可售剩余套数</th>"+
				"<th>剩余面积</th>"+
				"<th>剩余金额</th>"+
				"<th>剩余均价</th>"+
				"<th>剩余率</th>"+
				"</tr>");
		
		
		sb.append((String)request.getSession().getAttribute("showTrs"));
		sb.append(ContTable.TALBE_END);
		String fileName = "download-" + CustomerUtils.getNowForString() + "-.xls";
		ReportUtils.downLoadReport(sb.toString(), fileName, response);
		
		return SUCCESS;
	}
	
	
	// 下拉框(分析类型)
	private LinkedHashMap<String, String> listSelCategory;
	// 选中的分析类型
	private String selCategory;
	

	private String showTrs;
	public String getShowTrs(){
		return showTrs;
	}
	
	public void setShowTrs(String showTrs){
		this.showTrs = showTrs;
	}
	
	public LinkedHashMap<String, String> getListSelCategory() {
		if(listSelCategory==null){
			listSelCategory = CustomerUtils.getListSelCategory();
		}
		return listSelCategory;
	}

	public void setListSelCategory(LinkedHashMap<String, String> listSelCategory) {
		this.listSelCategory = listSelCategory;
	}

	public String getSelCategory() {
		return selCategory;
	}

	public void setSelCategory(String selCategory) {
		this.selCategory = selCategory;
	}

	private PropertyUnitCond propertyUnitCond;
	private ConfirmCond confirmCond;
	private ContractCond contractCond;
	private CompanyProjectCond companyProjectCond;

	public CompanyProjectCond getCompanyProjectCond() {
		return companyProjectCond;
	}

	public void setCompanyProjectCond(CompanyProjectCond companyProjectCond) {
		this.companyProjectCond = companyProjectCond;
	}

	public ContractCond getContractCond() {
		return contractCond;
	}

	public void setContractCond(ContractCond contractCond) {
		this.contractCond = contractCond;
	}

	public ConfirmCond getConfirmCond() {
		return confirmCond;
	}

	public void setConfirmCond(ConfirmCond confirmCond) {
		this.confirmCond = confirmCond;
	}

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
			
			propertyUnitCond.setDate2(CommonUtils.getMonthEndForString());
		}
	}

}
