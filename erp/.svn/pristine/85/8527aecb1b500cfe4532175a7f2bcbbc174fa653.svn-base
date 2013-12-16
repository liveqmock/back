package com.ihk.saleunit.action.new_report;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.saleunit.data.pojo.PropertyProjectPlan;
import com.ihk.saleunit.data.pojo.PropertyProjectPlanCond;
import com.ihk.saleunit.data.pojo.ReportShowTD;
import com.ihk.saleunit.data.pojo.ReportShowTR;
import com.ihk.saleunit.data.services.IPropertyProjectPlanServices;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.ReportShowUtils;

/**
 * 年度销售计划及落实情况 报表
 *
 */
public class NdxsjhReportAction extends SupperAction {

	/*
	 * 报表的计算方式：数据表的准备
	 * 1,取出楼盘项目的计划表 property_project_plan；性能：一次查询
	 * 2，形成任务的trs
	 * 
	 * 3，取出齐定的情况表，按月汇总形成数据；性能：一次查询group by
	 * 4，形成齐定的trs
	 * 
	 * 5，算出达标率，合计等trs
	 */	
	
	@Autowired
	IPropertyProjectPlanServices propertyProjectPlanServices;	//计划的情况
	//齐定的情况services TODO 在财务那边需要做好
	
	//listPlan
	//getTaskTd(int month)	
	
	//getFinishTd(int month)
	
	/**
	 * 添加td到tr
	 */
	private void addTDsToTR(ReportShowTR showTR,String trHeadTitle){
		
		for(int i=1;i<=12;i++){
			ReportShowTD td = new ReportShowTD();
			td.setxTheadText(propertyProjectPlanCond.getPlanMonth()+"_"+i+"_"+trHeadTitle);
			td.setXyValueText(String.valueOf(0));
			showTR.addTD(td);
		}		

		showTR.addTD(new ReportShowTD(String.valueOf("0")));//合计
		showTR.addTD(new ReportShowTD(String.valueOf("0")));//平均值
		showTR.addTD(new ReportShowTD(String.valueOf("0")));//剩余
	}
	
	/**
	 * 添加行(tr)到列表
	 * @param trList
	 * @param trHeadTitle
	 */
	private void addTRsToList(ArrayList<ReportShowTR> trList,String trHeadTitle){	
		ReportShowTR showTR = new ReportShowTR();
		showTR.addTD(new ReportShowTD(String.valueOf("销售任务")));
		showTR.addTD(new ReportShowTD(trHeadTitle));
		addTDsToTR(showTR,trHeadTitle);
		trList.add(showTR);
	}

	public String test() {
		if(propertyProjectPlanCond == null)
			propertyProjectPlanCond = new PropertyProjectPlanCond();
		propertyProjectPlanCond.setSearchProjectIds(propertyUnitCond.getSearchCompanyProjectIds());
		List<PropertyProjectPlan> listPlan = propertyProjectPlanServices.findPropertyProjectPlan(propertyProjectPlanCond);
						
		//步骤1：进行List的定义，直接对应于html页面的Table		
		ArrayList<ReportShowTR> trList = new ArrayList();
		
		//任务的TRS
		//进行一个list的定义		
		addTRsToList(trList,"任务套数(套)");
		addTRsToList(trList,"任务面积(㎡)");
		addTRsToList(trList,"任务金额(万元)");
		addTRsToList(trList,"任务均价(元/㎡)");
		addTRsToList(trList,"齐定套数(套)");
		addTRsToList(trList,"齐定面积(㎡)");
		addTRsToList(trList,"齐定金额(元)");
		addTRsToList(trList,"齐定均价(元/㎡)");
		addTRsToList(trList,"达标率");
		addTRsToList(trList,"累计达标率");			

		
		//循环房间，归类到项目中
		for(int i=0;i<listPlan.size();i++){
			PropertyProjectPlan plan = listPlan.get(i);
			for(int j=0;j<trList.size();j++){
				
				for(int k=0;k<trList.get(0).getTdsCount();k++){
					computeTdByUnit(trList.get(0).getTD(k),plan);	
				}
				
			}
		}
		String str = ReportShowUtils.getTrsByListTR(trList);	
		setShowTrs(str);//设置输出
		
		return "suc";
	}
	
	private void computeTdByUnit(ReportShowTD td,PropertyProjectPlan plan){
			
			if(td.getxTheadText().equalsIgnoreCase(plan.getPlanMonth()+"_"+"任务套数(套)")){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
			else if(td.getxTheadText().equalsIgnoreCase(plan.getPlanMonth()+"_"+"任务面积(㎡)")){
				ReportShowUtils.ReportShowTD_AddNum(td,plan.getPlanArea());
			}
			else if(td.getxTheadText().equalsIgnoreCase(plan.getPlanMonth()+"_"+"任务金额(万元)")){	
				ReportShowUtils.ReportShowTD_AddNum(td,plan.getPlanMoney().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
			
			else if(td.getxTheadText().equalsIgnoreCase(plan.getPlanMonth()+"_"+"齐定套数(套)")){
				
			}
			else if(td.getxTheadText().equalsIgnoreCase(plan.getPlanMonth()+"_"+"齐定面积(㎡)")){
				
			}
			else if(td.getxTheadText().equalsIgnoreCase(plan.getPlanMonth()+"_"+"齐定金额(元)")){
				
			}
			
			else if(td.getxTheadText().equalsIgnoreCase(plan.getPlanMonth()+"_"+"齐定均价(元/㎡)")){
				ReportShowUtils.ReportShowTD_AddNum(td,plan.getPlanPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
			else if(td.getxTheadText().equalsIgnoreCase(plan.getPlanMonth()+"_"+"达标率")){
				
			}
			//todo
			else if(td.getxTheadText().equalsIgnoreCase(plan.getPlanMonth()+"_"+"累计达标率")){
				
			}
		
		}

	public String ndxsjhReportFirst() throws Exception{
		
		initSearchDate();
		
		return "ndxsjhReportFirst";
	}
	
	public String ndxsjhReport() {
		initSearchDate();
		test();//测试
		return "suc";
	}
	
	private List list = new ArrayList();
	
	

	public List getList() {
		return list;
	}



	public void setList(List list) {
		this.list = list;
	}

	private String showTrs;
	public String getShowTrs(){
		return showTrs;
	}
	
	public void setShowTrs(String showTrs){
		this.showTrs = showTrs;
	}

	
	
	private void initSearchDate(){
		if (propertyUnitCond == null) {
			propertyUnitCond = new PropertyUnitCond();

			propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));
		}	
	}
	private PropertyUnitCond propertyUnitCond;
	private PropertyProjectPlanCond propertyProjectPlanCond;
	private String projectName;
	
	public PropertyUnitCond getPropertyUnitCond() {
		return propertyUnitCond;
	}

	public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
		this.propertyUnitCond = propertyUnitCond;
	}
	
	public PropertyProjectPlanCond getPropertyProjectPlanCond() {
		return propertyProjectPlanCond;
	}

	public void setPropertyProjectPlanCond(
			PropertyProjectPlanCond propertyProjectPlanCond) {
		this.propertyProjectPlanCond = propertyProjectPlanCond;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	
	
	
}
