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

import com.ihk.constanttype.ContReportColumnMethod;
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
import com.ihk.utils.DescUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.ReportShowUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 * 报表：销售货量分析(按楼层)
 *
 */
public class XshlfxLcReportAction extends SupperAction {


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
	
	/**
	 * 查看项目列定义
	 */
	public String queryXshlfxLcL() {
		
		//增加报表子分类的条件
		ReportDefineColumnCond condColumn = new ReportDefineColumnCond();
		
		//从缓存当中取选择的项目
		PropertyUnitCond cond = new PropertyUnitCond();
		cond = (PropertyUnitCond) request.getSession().getAttribute("cond");
		
		if(cond==null){
			return "suc";
		}
		
		CompanyProjectCond conds = new CompanyProjectCond();
		conds.setProjectIds(cond.getSearchCompanyProjectIds());
		
		List<CompanyProject> project = companyProjectServices.findCompanyProjectByCond(conds);

		condColumn.setReportName(ContReportName.XSHLFX_LC);
		if(cond.getSearchCompanyProjectIds().size()>1){
			int companyId = DescUtils.getCompanyIdByProjectId(cond.getSearchCompanyProjectIds().get(0));
			condColumn.setCompanyId(String.valueOf(companyId));
			condColumn.setProjectId("");
		}
		else if(cond.getSearchCompanyProjectIds().size()==1){
			int companyId = DescUtils.getCompanyIdByProjectId(cond.getSearchCompanyProjectIds().get(0));
			condColumn.setProjectId(String.valueOf(cond.getSearchCompanyProjectIds().get(0)));
		}
		else{
			return "suc";//没有选择项目或者公司，直接不查询数据库输出			
		}
		List<Map> listReportDefineColumn = reportDefineColumnServices.findReportDefineColumnAndType(condColumn);
		
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
		
		condColumn.setReportName(ContReportName.XSHLFX_LC);
		if(propertyUnitCond.getSearchCompanyProjectIds().size()>1){
			int companyId = DescUtils.getCompanyIdByProjectId(propertyUnitCond.getSearchCompanyProjectIds().get(0));
			condColumn.setCompanyId(String.valueOf(companyId));
			condColumn.setProjectId(CommonUtils.NORMAL);
		}
		else if(propertyUnitCond.getSearchCompanyProjectIds().size()==1){
			int companyId = DescUtils.getCompanyIdByProjectId(propertyUnitCond.getSearchCompanyProjectIds().get(0));
			condColumn.setProjectId(String.valueOf(companyId));
		}
		else{
			return "suc";//没有选择项目或者公司，直接不查询数据库输出			
		}
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
		ArrayList<ReportShowTR> trList = new ArrayList();
		
		//形成表格(表格的结构以及td算法)
		//总货量_总套数
		//列出Y轴循环
		for(int j=0;j<listReportDefineColumn.size();j++){
			ReportDefineColumn xColumn = listReportDefineColumn.get(j);
			//按此方式，进行推广，进行一个list的定义
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
			
			//UNIT_ROOM_TYPE_FLOOR_NUM_COUNT
						
			trList.add(showTR);
		}
		
		//根据数据对td进行填充
		for(int i=0;i<listUnit.size();i++){
			PropertyUnit unit = listUnit.get(i);
		
			for(int j=0;j<trList.size();j++){
				//判断unit是否符合行的条件
				List<ReportColumnCond> listCond = ReportShowUtils.getListReportColumnCond_AND(trList.get(j).getXyMethodSql());			
				
				//目前这里写的比较固定，与method_sql的个数顺序一致
				if(listCond.size()==2){
					ReportColumnCond condRoomType = listCond.get(0);
					ReportColumnCond condFloorNum = listCond.get(1);
					
					if(ReportShowUtils.checkCond(condRoomType,ContReportTableColumn.ROOM_TYPE,ContReportColumnMethod.EQ,unit.getRoomType())//类型条件
							|| ReportShowUtils.checkCond(condFloorNum,ContReportTableColumn.FLOOR_NUM,String.valueOf(unit.getFloorNum()))){//楼层条件
						//符合条件
						for(int k=0;k<trList.get(j).getTdsCount();k++){
							computeTdByUnit(trList.get(j).getTD(k),unit);	
						}
					}							
				}	
			}
		}
		
		ReportShowUtils.autoAddSumTRToListReportShow(trList);//分组累计
		
		ReportShowUtils.autoAddAllSumTRToListReportShow(trList);//总累计
		
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
				
		//String str = ReportShowUtils.getTrsOnlyTdIndexByListTR(trList);		//用于测试td的序号
		String str = ReportShowUtils.getTrsByListTR(trList);		//getTrsByListTR
		
		setShowTrs(str);//设置输出
		request.getSession().setAttribute("showTrs", showTrs);
		request.getSession().setAttribute("trList", trList);
		
		
		//饼图
		chartSeriesData_DP = ReportShowUtils.getChartSeriesDataByType("叠拼",trList, 1,2);
		chartSeriesData_GC = ReportShowUtils.getChartSeriesDataByType("高层",trList, 1,2);
		chartSeriesData_GY = ReportShowUtils.getChartSeriesDataByType("公寓",trList, 1,2);
		
		return "suc";
	}
	
	public String searchxshlfxLcReport() throws Exception{
		
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
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getConfirm().getSumMoney());
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
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getContract().getSumMoney());
			}
		}
	
	}

	public String xshlfxLcReportFirst() throws Exception{
		
		initSearchDate();
		
		return "xshlfxLcReportFirst";
	}
	
	// 销售货量分析(按楼层)
	public String xshlfxLcReport() {
		initSearchDate();
		runReport();
		return "suc";
	}
	

	private PropertyUnitCond propertyUnitCond;	

	public PropertyUnitCond getPropertyUnitCond() {
		return propertyUnitCond;
	}

	public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
		this.propertyUnitCond = propertyUnitCond;
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
			propertyUnitCond.setSearchCompanyProjectIds(propertyUnitCond.getPrivCompanyProjectIds());
			
//			propertyUnitCond.setDate1(CommonUtils.getMonthFirstForString());
			propertyUnitCond.setDate2(CommonUtils.getMonthEndForString());
		}		
		else if(propertyUnitCond.getPrivCompanyProjectIds()==null){
			propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));	
		}
	}

	public String download() throws Exception{
		
		String[] thx = new String[]{"选项","楼层","总套数","总面积","总金额（定价）","均价","总套数","总面积","总金额（定价）","均价","总套数","总面积","总金额（定价）","均价","余货比例",
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
	private String chartSeriesData_DP = "['无数据',1]";
	private String chartSeriesData_GC = "['无数据',1]";
	private String chartSeriesData_GY = "['无数据',1]";

	/**
	 * 叠拼的数据，显示在图形中
	 * @return
	 */
	public String getChartSeriesData_DP(){
		return chartSeriesData_DP;
	}
	/**
	 * 高层的数据，显示在图形中
	 * @return
	 */
	public String getChartSeriesData_GC(){
		return chartSeriesData_GC;
	}

	/**
	 * 公寓的数据，显示在图形中
	 * @return
	 */
	public String getChartSeriesData_GY(){
		return chartSeriesData_GY;
	}
	
	
}
