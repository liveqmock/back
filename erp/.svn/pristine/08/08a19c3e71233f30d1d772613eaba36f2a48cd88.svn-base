package com.ihk.saleunit.action.new_report;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.ReportShowTD;
import com.ihk.saleunit.data.pojo.ReportShowTR;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.ReportShowUtils;

/**
 * 项目结佣情况一览表
 *
 */
public class XmjyqkReportAction extends SupperAction{
	
	//齐定:来自“未知来源表”
	//签约:来自confirm
	//未签约:来自confirm
	//已结佣:未有来源表
	//未结佣:未有来源表
	//已对数未结佣:未有来源表
	//未对数未结佣:未有来源表
	
	//楼盘项目列表(1)
	//单元数量列表(2)
	
	//根据(1)(2)两个表，以及其他来源表进行表格填充
	
	//住宅，商业，车位，这个是必然要显示的行

	@Autowired
	ICompanyProjectServices companyProjectServices; 
	@Autowired
	IPropertyUnitServices propertyUnitServices;
	
	public String xmjyqkReportFirst() throws Exception{
		
		initSearchDate();
		return "xmjyqkReportFirst";
	}
	
	public String xmjyqkReport() throws Exception{
		initSearchDate();
		test();
		return "suc";
	}
	
	/**
	 * 初始化的td
	 * @param tdColumnName
	 * @return
	 */
	private ReportShowTD getInitShowTD(int y1ProjectId,String y2PropertyType,String x1Text,String x2Text){
		ReportShowTD td = new ReportShowTD();
		td.setxTheadText(y1ProjectId+"_"+y2PropertyType+"_"+x1Text+"_"+x2Text);
		td.setXyValueText("0");
		
		return td;
	}
	
	/**
	 * 添加一行
	 * @param trList
	 * @param projectName
	 * @param y2SubType
	 */
	private void addTrToList(ArrayList<ReportShowTR> trList,CompanyProject companyProject,String y2SubType){
		ReportShowTR showTR = new ReportShowTR(companyProject.getProjectName());
		ReportShowTD tdProject = new ReportShowTD(companyProject.getProjectName());
		tdProject.setyTypeName(companyProject.getProjectName());
		showTR.addTD(tdProject);
		showTR.addTD(new ReportShowTD(y2SubType));

		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"齐定","套数"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"齐定","面积"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"齐定","金额"));

		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"签约","套数"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"签约","面积"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"签约","金额"));
		
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"未签约","套数"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"未签约","面积"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"未签约","金额"));
		
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"已结佣","套数"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"已结佣","面积"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"已结佣","金额"));
		
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"未结佣","套数"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"未结佣","面积"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"未结佣","金额"));
		
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"已对数未结佣","套数"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"已对数未结佣","面积"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"已对数未结佣","金额"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"已对数未结佣","佣金"));
		
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"未对数未结佣","套数"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"未对数未结佣","面积"));
		showTR.addTD(getInitShowTD(companyProject.getId(),y2SubType,"未对数未结佣","金额"));
		
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
			//住宅
			addTrToList(trList,listCompanyProject.get(i),"住宅");
			
			//车位
			addTrToList(trList,listCompanyProject.get(i),"车位");
			
			//商业
			addTrToList(trList,listCompanyProject.get(i),"商业");
		}
		
		//循环房间，归类到项目中
		for(int i=0;i<listUnit.size();i++){
			PropertyUnit unit = listUnit.get(i);
			for(int j=0;j<trList.size();j++){
				
				for(int k=0;k<trList.get(j).getTdsCount();k++){
					computeTdByUnit(trList.get(j).getTD(k),unit,"住宅");	
					computeTdByUnit(trList.get(j).getTD(k),unit,"车位");	
					computeTdByUnit(trList.get(j).getTD(k),unit,"商业");
				}
				
			}
		}
		
		ReportShowUtils.autoAddAllSumTRToListReportShow(trList);
						
		String str = ReportShowUtils.getTrsByListTR(trList);		
		
		setShowTrs(str);//设置输出		

		System.out.println("项目结佣情况一览表:输出完毕"+DateTimeUtils.getNow());
		
		return "suc";
	}
	
	private void computeTdByUnit(ReportShowTD td,PropertyUnit unit,String y2SubType){
		if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"齐定_套数")){
			
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"齐定_面积")){
			
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"齐定_金额")){	
			
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"签约_套数")){
			if(unit.getSaleState().equals(ContUnitSaleState.CONTRACT)){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"签约_面积")){
			if(unit.getSaleState().equals(ContUnitSaleState.CONTRACT)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}		
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"签约_金额")){
			if(unit.getSaleState().equals(ContUnitSaleState.CONTRACT)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"未签约_套数")){
			if(!unit.getSaleState().equals(ContUnitSaleState.CONTRACT)){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"未签约_面积")){
			if(!unit.getSaleState().equals(ContUnitSaleState.CONTRACT)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"未签约_金额")){
			if(!unit.getSaleState().equals(ContUnitSaleState.CONTRACT)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"已结佣_套数")){
			if(unit.getSaleState().equals(ContUnitSaleState.IS_COMMISSION)){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"已结佣_面积")){
			if(unit.getSaleState().equals(ContUnitSaleState.IS_COMMISSION)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"已结佣_金额")){
			if(unit.getSaleState().equals(ContUnitSaleState.IS_COMMISSION)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"未结佣_套数")){
			if(!unit.getSaleState().equals(ContUnitSaleState.IS_COMMISSION)){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"未结佣_面积")){
			if(!unit.getSaleState().equals(ContUnitSaleState.IS_COMMISSION)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"未结佣_金额")){
			if(!unit.getSaleState().equals(ContUnitSaleState.IS_COMMISSION)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"已对数未结佣_套数")){
			if(!unit.getSaleState().equals(ContUnitSaleState.IS_COMMISSION)&&unit.getSaleState().equals(ContUnitSaleState.IS_CHECK)){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"已对数未结佣_面积")){
			if(!unit.getSaleState().equals(ContUnitSaleState.IS_COMMISSION)&&unit.getSaleState().equals(ContUnitSaleState.IS_CHECK)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"已对数未结佣_金额")){
			if(!unit.getSaleState().equals(ContUnitSaleState.IS_COMMISSION)&&unit.getSaleState().equals(ContUnitSaleState.IS_CHECK)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"未对数未结佣_套数")){
			if(!unit.getSaleState().equals(ContUnitSaleState.IS_COMMISSION)&&!unit.getSaleState().equals(ContUnitSaleState.IS_CHECK)){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"未对数未结佣_面积")){
			if(!unit.getSaleState().equals(ContUnitSaleState.IS_COMMISSION)&&!unit.getSaleState().equals(ContUnitSaleState.IS_CHECK)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase(unit.getCompanyProjectId()+"_"+y2SubType+"_"+"未对数未结佣_金额")){
			if(!unit.getSaleState().equals(ContUnitSaleState.IS_COMMISSION)&&!unit.getSaleState().equals(ContUnitSaleState.IS_CHECK)){
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
	
	}
	
	private PropertyUnitCond propertyUnitCond;
	private CompanyProjectCond companyProjectCond;
	
	public PropertyUnitCond getPropertyUnitCond() {
		return propertyUnitCond;
	}

	public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
		this.propertyUnitCond = propertyUnitCond;
	}

	public CompanyProjectCond getCompanyProjectCond() {
		return companyProjectCond;
	}

	public void setCompanyProjectCond(CompanyProjectCond companyProjectCond) {
		this.companyProjectCond = companyProjectCond;
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
			propertyUnitCond.setDate1(CommonUtils.getMonthFirstForString());
		}
	}


}
