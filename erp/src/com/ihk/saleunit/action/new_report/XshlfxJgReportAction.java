package com.ihk.saleunit.action.new_report;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContCompanyId;
import com.ihk.constanttype.ContReportName;
import com.ihk.constanttype.ContReportTableColumn;
import com.ihk.constanttype.ContTable;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.constanttype.EnumReportOperator;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.pojo.ReportColumnCond;
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
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.ReportShowUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 * 报表：销售货量分析(按价格)
 *
 */
public class XshlfxJgReportAction extends SupperAction {
	
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
	
	private JSONObject result;
	
	/**
	 * 数据表的准备
	 * 1,所有单元信息；（单元表）:property_unit
	 * 2，认购表的取得；confirm
	 * 3，合同表:contract
	 * 4，报表定义表:report_define_type
	 * 5，报表定义的列:report_define_column
	 * 
	 * 在以上表格中进行重新组装得到数据
	 */
	
	public JSONObject getResult() {
		return result;
	}


	public void setResult(JSONObject result) {
		this.result = result;
	}
	
	public String xshlfxJgReportFirst() throws Exception{
		
		initSearchDate();
		
		return "xshlfxJgReportFirst";
	}
	
	public String xshlfxJgReport() throws Exception{
		initSearchDate();
		runReport();
		return "suc";
	}
	
	public String queryXshlfxJgJ() throws Exception {
		//增加报表子分类的条件
		ReportDefineColumnCond condColumn = new ReportDefineColumnCond();
		
		//从缓存当中取选择的项目
		PropertyUnitCond cond = new PropertyUnitCond();
		cond = (PropertyUnitCond) request.getSession().getAttribute("cond");
		
		CompanyProjectCond conds = new CompanyProjectCond();
		conds.setProjectIds(cond.getSearchCompanyProjectIds());
		
		List<CompanyProject> project = companyProjectServices.findCompanyProjectByCond(conds);
		
		if(project.size() > 0){
			condColumn.setCompanyId(String.valueOf(ContCompanyId.GUANG_ZHOU));
			condColumn.setProjectId(String.valueOf(0));
		}
		
		if(propertyUnitCond.getSearchCompanyProjectIds().size() == 1)
			condColumn.setProjectId(String.valueOf(propertyUnitCond.getSearchCompanyProjectIds().get(0)));
		
		condColumn.setReportName(ContReportName.XSHLFX_JG);
		List<Map> listReportDefineColumn = reportDefineColumnServices.findReportDefineColumnAndType(condColumn);
		if(listReportDefineColumn.size()==0 && propertyUnitCond.getSearchCompanyProjectIds().size()==1){
			//如果该项目没有设定报表列，则查找所属公司的设定
			int companyId = DescUtils.getCompanyIdByProjectId(propertyUnitCond.getSearchCompanyProjectIds().get(0));
			condColumn.setCompanyId(String.valueOf(companyId));
			condColumn.setProjectId(CommonUtils.NORMAL);
			listReportDefineColumn = reportDefineColumnServices.findReportDefineColumnAndType(condColumn);
		}
		
		//步骤1：进行List的定义，直接对应于html页面的Table		
		ArrayList<ReportShowTR> trList = new ArrayList();
		
		for(int i=0;i<project.size();i++){
			CompanyProject pro = project.get(i);
			
			for(int j=0;j<listReportDefineColumn.size();j++){
				if(listReportDefineColumn.get(j).get("projectId") == null)
					continue;
				
				if(pro.getId() == Integer.parseInt(listReportDefineColumn.get(j).get("projectId").toString()))
				{
					ReportShowTR showTR = new ReportShowTR();
					ReportShowTD td1 = new ReportShowTD();
					td1.setXyValueText(pro.getProjectName());
					showTR.addTD(td1);
					
					ReportShowTD td2 = new ReportShowTD();
					if(!listReportDefineColumn.get(j).get("companyId").toString().equals("0")){
						td2.setXyValueText("项目定义列");
					}else{
						td2.setXyValueText("公司定义列");
					}
					showTR.addTD(td2);
					
					ReportShowTD td4 = new ReportShowTD();
					td4.setXyValueText(listReportDefineColumn.get(j).get("typeName").toString());
					showTR.addTD(td4);
					
					ReportShowTD td3 = new ReportShowTD();
					td3.setXyValueText(listReportDefineColumn.get(j).get("showName").toString());
					showTR.addTD(td3);
					
					trList.add(showTR);
				}
				
			}
			
		}
			
		String str = ReportShowUtils.getTrsByListTR(trList);
		ActionContext.getContext().getValueStack().set("showTable",str);
		return "suc";
	}


	/**
	 * 报表的组装
	 * @return
	 */
	public String runReport() {	
		request.getSession().setAttribute("cond",propertyUnitCond);
		List<PropertyUnit> listUnit = propertyUnitServices.findPropertyUnit(propertyUnitCond);
		List<Confirm> listConfirm = confirmServices.findConfirm(null);
		List<Contract> listContract = contractServices.findContractPage(new ContractCond());
				
		//增加报表子分类的条件
		ReportDefineColumnCond condColumn = new ReportDefineColumnCond();
		
		CompanyProjectCond conds = new CompanyProjectCond();
		conds.setProjectIds(propertyUnitCond.getSearchCompanyProjectIds());
		
		List<CompanyProject> project = companyProjectServices.findCompanyProjectByCond(conds);
		//取得公司
		if(project.size() > 0){
			condColumn.setCompanyId(String.valueOf(String.valueOf(ContCompanyId.GUANG_ZHOU)));
			condColumn.setProjectId(String.valueOf(0));
		}
		
		if(propertyUnitCond.getSearchCompanyProjectIds().size() == 1)
			condColumn.setProjectId(String.valueOf(propertyUnitCond.getSearchCompanyProjectIds().get(0)));
		condColumn.setReportName(ContReportName.XSHLFX_JG);
		
		//需要根据公司项目来进行查询，如果是多个项目，查公司的设定
		List<ReportDefineColumn> listReportDefineColumn = reportDefineColumnServices.findReportDefineColumnForY(condColumn);
		if(listReportDefineColumn.size()==0 && propertyUnitCond.getSearchCompanyProjectIds().size()==1){
			//如果该项目没有设定报表列，则查找所属公司的设定
			int companyId = DescUtils.getCompanyIdByProjectId(propertyUnitCond.getSearchCompanyProjectIds().get(0));
			condColumn.setCompanyId(String.valueOf(companyId));
			condColumn.setProjectId(CommonUtils.NORMAL);
			listReportDefineColumn = reportDefineColumnServices.findReportDefineColumnForY(condColumn);
		}
		
		//重新初始化listUnit
		ReportShowUtils.initListPropertyUnit_Confirm(listUnit,listConfirm);
		ReportShowUtils.initListPropertyUnit_Contract(listUnit,listContract);
			
		
		//步骤1：进行List的定义，直接对应于html页面的Table		
		//循环unit,对Map进行填充数据
		
		ArrayList<ReportShowTR> trList = new ArrayList();
		
		//形成表格
		//总货量_总套数
		//列出Y轴循环
		for(int j=0;j<listReportDefineColumn.size();j++){
			ReportDefineColumn xColumn = listReportDefineColumn.get(j);
			
			ReportShowTR showTR = new ReportShowTR(xColumn.getTypeName());
			showTR.setXyMethodSql(xColumn.getMethodSql());//整行的判断是否符合条件
			
			ReportShowTD td1 = new ReportShowTD(xColumn.getTypeName());
			td1.setyTypeName(xColumn.getTypeName());
			showTR.addTD(td1);
			showTR.addTD(new ReportShowTD(xColumn.getShowName()));
			
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"总货量_总套数"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"总货量_总面积"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"总货量_总金额"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"总货量_均价"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"推出货量_总套数"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"推出货量_总面积"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"推出货量_总金额"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"推出货量_均价"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"总剩余货量_总套数"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"总剩余货量_总面积"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"总剩余货量_总金额"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"总剩余货量_均价"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"总剩余货量_余货比例","%1$,.0f%%"));
			
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"认购情况_成交套数"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"认购情况_成交面积"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"认购情况_成交金额"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"认购情况_均价"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"已签约情况_签约套数"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"已签约情况_签约面积"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"已签约情况_签约金额"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"已签约情况_均价"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"已签约情况_签约率","%1$,.0f%%"));
			
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"未签约情况_未签约套数"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"未签约情况_未签约面积"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"未签约情况_未签约金额"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"未签约情况_均价"));
			
			
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"推出剩余货量_总量"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"推出剩余货量_面积"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"推出剩余货量_金额"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"推出剩余货量_均价"));
			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"推出剩余货量_剩余率","%1$,.0f%%"));
			
			//UNIT_BUILD_PRICE_SUM_PRICE
			trList.add(showTR);
		}
			
		//测试：对List快速填充值
		for(int i=0;i<listUnit.size();i++){
			PropertyUnit unit = listUnit.get(i);
			
			for(int j=0;j<trList.size();j++){
				//判断unit是否符合行的条件
				ReportColumnCond cond = new ReportColumnCond(trList.get(j).getXyMethodSql());
				
				//支持判断的形式为：build_price[IN]18001-18500
				
//				if(cond.getColumnName().equalsIgnoreCase(ContReportTableColumn.BUILD_PRICE)
//				&& cond.getCompareMethod().equalsIgnoreCase(ContReportColumnMethod.IN)
//				&& cond.isInStartEndDecimal(unit.getBuildPrice())
//				)
				if(ReportShowUtils.checkCond(cond,ContReportTableColumn.BUILD_PRICE,String.valueOf(unit.getBuildPrice()))){
					//建筑单价符合要求
					for(int k=0;k<trList.get(j).getTdsCount();k++){
						computeTdByUnit(trList.get(j).getTD(k),unit);	
					}
				}
				else if(ReportShowUtils.checkCond(cond,ContReportTableColumn.SUM_PRICE,String.valueOf(unit.getSumPrice()))){
					//按总价格区分统计
					for(int k=0;k<trList.get(j).getTdsCount();k++){
						computeTdByUnit(trList.get(j).getTD(k),unit);	
					}
				}
			}
			
		}

		ReportShowUtils.autoAddSumTRToListReportShow(trList); //分组累计
		//ReportShowUtils.autoAddAllSumTRToListReportShow(trList);//总累计
		
		//未签约情况
		ReportShowUtils.autoComputeListReportShow(trList,24,15,19,EnumReportOperator.SUBTRACT);
		ReportShowUtils.autoComputeListReportShow(trList,25,16,20,EnumReportOperator.SUBTRACT);
		ReportShowUtils.autoComputeListReportShow(trList,26,17,21,EnumReportOperator.SUBTRACT);
		ReportShowUtils.autoComputeListReportShow(trList,27,26,25,EnumReportOperator.DIVIDE);
		
		//推出剩余货量
		ReportShowUtils.autoComputeListReportShow(trList,28,6,15,EnumReportOperator.SUBTRACT);
		ReportShowUtils.autoComputeListReportShow(trList,29,7,16,EnumReportOperator.SUBTRACT);
		ReportShowUtils.autoComputeListReportShow(trList,30,8,17,EnumReportOperator.SUBTRACT);
		ReportShowUtils.autoComputeListReportShow(trList,31,30,29,EnumReportOperator.DIVIDE);
		//ReportShowUtils.autoComputeListReportShow(trList,32,28,6,EnumReportOperator.DIVIDE);
		
		//均价计算
		ReportShowUtils.autoComputeListReportShow(trList,5,4,3,EnumReportOperator.DIVIDE);
		ReportShowUtils.autoComputeListReportShow(trList,9,8,7,EnumReportOperator.DIVIDE);
		ReportShowUtils.autoComputeListReportShow(trList,13,12,11,EnumReportOperator.DIVIDE);
		ReportShowUtils.autoComputeListReportShow(trList,18,17,16,EnumReportOperator.DIVIDE);
		ReportShowUtils.autoComputeListReportShow(trList,22,20,19,EnumReportOperator.DIVIDE);
		ReportShowUtils.autoComputeListReportShow(trList,27,26,25,EnumReportOperator.DIVIDE);
		ReportShowUtils.autoComputeListReportShow(trList,31,30,29,EnumReportOperator.DIVIDE);
		
		ReportShowUtils.autoComputeListReportShow(trList,14,10,2,EnumReportOperator.DIVIDE);
		ReportShowUtils.autoComputeListReportShow(trList,23,19,2,EnumReportOperator.DIVIDE);
		ReportShowUtils.autoComputeListReportShow(trList,32,28,2,EnumReportOperator.DIVIDE);
				
		String str = ReportShowUtils.getTrsByListTR(trList);		
		
		setShowTrs(str);//设置输出
		request.getSession().setAttribute("showTrs", showTrs);
		request.getSession().setAttribute("trList", trList);
		//饼图
		chartSeriesData_DJ = ReportShowUtils.getChartSeriesDataByType("单价区间",trList, 1,2);
		chartSeriesData_ZJ = ReportShowUtils.getChartSeriesDataByType("总价区间",trList, 1,2);
		
		System.out.println("按均价输出："+DateTimeUtils.getNow());
		
		return "suc";
	}
	

	private void computeTdByUnit(ReportShowTD td,PropertyUnit unit){
		if(td.getxTheadText().equalsIgnoreCase("总货量_总套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}else if(td.getxTheadText().equalsIgnoreCase("总货量_总面积")){			
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}else if(td.getxTheadText().equalsIgnoreCase("总货量_总金额")){			
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
		}
		else if(td.getxTheadText().equalsIgnoreCase("推出货量_总套数")){
			if(unit.isTuiHuo()){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase("推出货量_总面积")){	
			if(unit.isTuiHuo()){		
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase("推出货量_总金额")){	
			if(unit.isTuiHuo()){				
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase("总剩余货量_总套数")){
			if(unit.isShengYu()){	
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase("总剩余货量_总面积")){	
			if(unit.isShengYu()){			
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase("总剩余货量_总金额")){	
			if(unit.isShengYu()){			
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase("认购情况_成交套数")){
			if(unit.getConfirm()!=null){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase("认购情况_成交面积")){
			if(unit.getConfirm()!=null){			
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase("认购情况_成交金额")){
			if(unit.getConfirm()!=null){			
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getConfirm().getSumMoney().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase("已签约情况_签约套数")){
			if(unit.getContract()!=null){
				ReportShowUtils.ReportShowTD_Increment(td);
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase("已签约情况_签约面积")){	
			if(unit.getContract()!=null){		
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
			}
		}
		else if(td.getxTheadText().equalsIgnoreCase("已签约情况_签约金额")){		
			if(unit.getContract()!=null){	
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getContract().getSumMoney().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
		}
	
	}
	
	@SuppressWarnings("unchecked")
	public String searchxshlfxJgReport() throws Exception{
		//步骤1：进行List的定义，直接对应于html页面的Table		
		ArrayList<ReportShowTR> trList = new ArrayList();
		trList = (ArrayList<ReportShowTR>) request.getSession().getAttribute("trList");
		try{
			
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonobj = new JSONObject();
			
			StringBuilder sb = new StringBuilder("");
			for(int i=0;i<trList.size();i++){
				for(int j=0;j<trList.get(i).getTdsCount();j++){
					jsonobj.put("xs"+j, trList.get(i).getTD(j).getXyValueText());
				}
				jsonArray.add(jsonobj);
			}
			Map<String, Object> json = new HashMap<String, Object>();
			json.put("rows", jsonArray);// rows键 存放每页记录 list
			result = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "suc";
	}
		

	private String showTrs;
	public String getShowTrs(){
		return showTrs;
	}
	
	public void setShowTrs(String showTrs){
		this.showTrs = showTrs;
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
			
//			propertyUnitCond.setDate1(CommonUtils.getMonthFirstForString());
			propertyUnitCond.setDate2(CommonUtils.getMonthEndForString());
		}	
		else {
			if(propertyUnitCond.getPrivCompanyProjectIds()==null){
				propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));				
			}
		}
	}


	private String chartSeriesData_DJ = "['无数据',1]";
	private String chartSeriesData_ZJ = "['无数据',1]";

	/**
	 * 单价的数据，显示在图形中
	 * @return
	 */
	public String getChartSeriesData_DJ(){
		return chartSeriesData_DJ;
	}
	/**
	 * 总价的数据，显示在图形中
	 * @return
	 */
	public String getChartSeriesData_ZJ(){
		return chartSeriesData_ZJ;
	}

public String download() throws Exception{
		
		String[] thx = new String[]{"类别","价格区间","总套数","总面积","总金额（定价）","均价","总套数","总面积","总金额（定价）","均价","总套数","总面积","总金额（定价）","均价","余货比例",
				"成交套数","成交面积","成交金额","均价","签约套数","签约面积","签约金额","均价","签约率","未签约套数","未签约面积","未签约金额","均价","总量","面积","金额","均价","剩余率"};
		final StringBuffer sb = new StringBuffer();
		sb.append(ContTable.TABLE_START)
			.append(ContTable.TR_START);
		sb.append("<th>产品类型</th><th></th>" +
				  "<th colspan='4'>总货量</th>"+
                  "<th colspan='4'>推出货量</th>"+
                  "<th colspan='5'>总剩余货量</th>"+
                  "<th colspan='4'>认购情况</th>"+
                  "<th colspan='5'>已签约情况</th>"+
                  "<th colspan='4'>未签约情况</th>"+
                  "<th colspan='5'>推出剩余货量</th>");
		
		sb.append(ContTable.TR_END).append(ContTable.TR_START);
		for(String th : thx){
			sb.append(ContTable.TH_START)
				.append(th)
				.append(ContTable.TH_END)
				;
		}
		sb.append(ContTable.TR_END);
		sb.append((String)request.getSession().getAttribute("showTrs"));
		sb.append(ContTable.TALBE_END);
		String fileName = "download-" + CustomerUtils.getNowForString() + "-.xls";
		ReportUtils.downLoadReport(sb.toString(), fileName, response);
		
		return SUCCESS;
	}
	
}
