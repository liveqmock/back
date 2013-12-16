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
import com.ihk.constanttype.EnumReportOperator;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyUnitServices;
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
 * 报表:累计签约回款统计
 *
 */
public class LjqyhktjReportAction extends SupperAction{
	
	//签约:来自confirm
	//回款:来自财务未有来源表
	
	//楼盘项目列表(1)
	//单元数量列表(2)
	
	//根据(1)(2)两个表，以及其他来源表进行表格填充
	
	@Autowired
	ICompanyProjectServices companyProjectServices; 
	@Autowired
	IPropertyUnitServices propertyUnitServices;
	
	public String ljqyhktjReportFirst() throws Exception{
		
		initSearchDate();
		return "ljqyhktjReportFirst";
	}

	public String ljqyhktjReport() throws Exception{
		initSearchDate();
		test();
		return "suc";
	}
	
	/**
	 * 初始化的td
	 * @param tdColumnName
	 * @return
	 */
	private ReportShowTD getInitShowTD(int y1ProjectId,String x1Text,String x2Text,String x3Text){
		ReportShowTD td = new ReportShowTD();
		td.setxTheadText(y1ProjectId+"_"+x1Text+"_"+x2Text+"_"+x3Text);
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

		showTR.addTD(getInitShowTD(companyProject.getId(),"签约","已签合同","套数"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"签约","已签合同","面积"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"签约","已签合同","金额"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"签约","已签合同","均价"));
		
		showTR.addTD(getInitShowTD(companyProject.getId(),"签约","待签合同","套数"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"签约","待签合同","面积"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"签约","待签合同","金额"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"签约","待签合同","均价"));

		showTR.addTD(getInitShowTD(companyProject.getId(),"回款","","已收房款"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"回款","","贷款到账金额"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"回款","","已结算佣金"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"回款","","未结算佣金"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"回款","","不结佣套数"));
		showTR.addTD(getInitShowTD(companyProject.getId(),"回款","","不结佣金额"));
		
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
		//列出Y轴循环
		for(int i=0;i<listCompanyProject.size();i++){
			addTrToList(trList,listCompanyProject.get(i));
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
		
		//均价
		ReportShowUtils.autoComputeListReportShow(trList,4,3,2,EnumReportOperator.DIVIDE);
		ReportShowUtils.autoComputeListReportShow(trList,8,7,6,EnumReportOperator.DIVIDE);
						
		String str = ReportShowUtils.getTrsByListTR(trList);		
		
		setShowTrs(str);//设置输出		
		request.getSession().setAttribute("showTrs", showTrs);

		System.out.println("累计签约回款统计表:输出完毕"+DateTimeUtils.getNow());
		
		return "suc";
	}
	
	private void computeTdByUnit(ReportShowTD td,PropertyUnit unit){
		
		if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"签约_已签合同_套数")){
			if(unit.getSaleState().equals(ContUnitSaleState.CONTRACT)){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"签约_已签合同_面积")){
			if(unit.getSaleState().equals(ContUnitSaleState.CONTRACT)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"签约_已签合同_金额")){	
			if(unit.getSaleState().equals(ContUnitSaleState.CONTRACT)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"签约_已签合同_均价")){
			
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"签约_待签合同_套数")){
			if(unit.getSaleState().equals(ContUnitSaleState.CONFIRM)){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"签约_待签合同_面积")){
			if(unit.getSaleState().equals(ContUnitSaleState.CONFIRM)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"签约_待签合同_金额")){
			if(unit.getSaleState().equals(ContUnitSaleState.CONFIRM)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"签约_待签合同_均价")){
			
		}
		//todo
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"回款__已收房款")){
			
		}
		
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"回款__贷款到账金额")){
			
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"回款__已结算佣金")){
			
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"回款__未结算佣金")){
			
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"回款__不结佣套数")){
			
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+"回款__不结佣金额")){
			
		}
	
	
	}
	
	public String download() throws Exception{
		
		final StringBuffer sb = new StringBuffer();
		
		sb.append(ContTable.TABLE_START);
			
		sb.append("<tr class='gboxbg'>"+
				"<th rowspan='3' width='120' "+
					"style='background-image: url(/erp/images/tianluan/gboxbg.gif);'>项目</th>"+
				"<th colspan='8'>累计签约统计</th>"+
				"<th colspan='6' rowspan='2'>累计回款统计</th>"+
		"	</tr>"+
		"	<tr class='gboxbg'>"+
		"		<th colspan='4'>已签合同</th>"+
		"		<th colspan='4'>待签合同</th>"+
		"	</tr>"+
		"	<tr class='gboxbg'>"+
		"		<th>套数</th>"+
		"		<th>面积</th>"+
		"		<th>签约金额</th>"+
		"		<th>均价</th>"+
		"		<th>套数</th>"+
		"		<th>面积</th>"+
		"		<th>金额</th>"+
		"		<th>均价</th>"+
		"		<th>已收房款</th>"+
		"		<th>贷款到账金额</th>"+
		"		<th>已结算佣金</th>"+
		"		<th>未结算佣金</th>"+
		"		<th>不结用套数</th>"+
		"		<th>不结佣金额</th>"+
		"	</tr>");
		
		
		sb.append((String)request.getSession().getAttribute("showTrs"));
		sb.append(ContTable.TALBE_END);
		String fileName = "download-" + CustomerUtils.getNowForString() + "-.xls";
		ReportUtils.downLoadReport(sb.toString(), fileName, response);
		
		return SUCCESS;
	}
	
	private PropertyUnitCond propertyUnitCond;
	private CompanyProjectCond companyProjectCond;
	
	public CompanyProjectCond getCompanyProjectCond() {
		return companyProjectCond;
	}

	public void setCompanyProjectCond(CompanyProjectCond companyProjectCond) {
		this.companyProjectCond = companyProjectCond;
	}

	public PropertyUnitCond getPropertyUnitCond() {
		return propertyUnitCond;
	}

	public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
		this.propertyUnitCond = propertyUnitCond;
	}

	// 下拉框(分析类型)
	private LinkedHashMap<String, String> listSelCategory;
	private CustomerCond customerCond;
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

	public CustomerCond getCustomerCond() {
		return customerCond;
	}

	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
	}

	public String getSelCategory() {
		return selCategory;
	}

	public void setSelCategory(String selCategory) {
		this.selCategory = selCategory;
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
