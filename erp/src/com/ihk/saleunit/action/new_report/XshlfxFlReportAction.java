package com.ihk.saleunit.action.new_report;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.ihk.constanttype.EnumReportShowTDMethod;
import com.ihk.customer.data.pojo.CustomerCond;
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
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.ReportShowUtils;

/**
 * 报表：销售货量分析(按分类)
 *
 */
public class XshlfxFlReportAction extends SupperAction {

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

	private JSONObject result;
	
	/*
	 * 数据表的准备 1,所有单元信息；（单元表）:property_unit 2，认购表的取得；confirm 3，合同表:contract
	 * 4，报表定义表:report_define_type 5，报表定义的列:report_define_column
	 * 
	 * 在以上表格中进行重新组装得到数据
	 */

	public JSONObject getResult() {
		return result;
	}


	public void setResult(JSONObject result) {
		this.result = result;
	}


	/*
	 * 测试报表的组装
	 */
	public String runReport() {		
		List<PropertyUnit> listUnit = propertyUnitServices.findPropertyUnit(propertyUnitCond);
		List<Confirm> listConfirm = confirmServices.findConfirm(null);
		List<Contract> listContract = contractServices.findContractPage(new ContractCond());
	
		
		//增加报表子分类的条件
		ReportDefineColumnCond condColumn = new ReportDefineColumnCond();
		condColumn.setReportName(ContReportName.XSHLFX_FL);
		
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
		//循环unit,对Map进行填充数据
		ArrayList<ReportShowTR> trList = new ArrayList();
		
		//形成表格
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
//			showTR.addTD(ReportShowUtils.initShowTD(xColumn,"推出剩余货量_剩余率",EnumReportShowTDMethod.UNIT_ROOM_NUM_HALL_NUM_TOILET_NUM_HOUSE_TYPE_PAY_WAY_COUNT));

			trList.add(showTR);			
		}
		
		//System.out.println("填充前:");
			
		//测试：对List快速填充值
		for(int i=0;i<listUnit.size();i++){
			PropertyUnit unit = listUnit.get(i);
			

			for(int j=0;j<trList.size();j++){
				//判断unit是否符合行的条件
				ReportShowTR tr = trList.get(j);
				List<ReportColumnCond> listCond = ReportShowUtils.getListReportColumnCond_AND(tr.getXyMethodSql());	
				
				if(tr.getTypeName().equals("规格")){
					if(listCond.size()==1){
						ReportColumnCond condRoomNum = listCond.get(0);

						if(ReportShowUtils.checkCond(condRoomNum,ContReportTableColumn.ROOM_NUM,ContReportColumnMethod.EQ,String.valueOf(unit.getRoomNum()))){
							for(int k=0;k<tr.getTdsCount();k++){
								computeTdByUnit(tr.getTD(k),unit);	
							}
						}						
					}
					else if(listCond.size()==2){
						ReportColumnCond condRoomNum = listCond.get(0);
						ReportColumnCond condToiletNum = listCond.get(1);
						if(ReportShowUtils.checkCond(condRoomNum,ContReportTableColumn.ROOM_NUM,ContReportColumnMethod.EQ,String.valueOf(unit.getRoomNum()))
								&& ReportShowUtils.checkCond(condToiletNum,ContReportTableColumn.TOILET_NUM,ContReportColumnMethod.EQ,String.valueOf(unit.getToiletNum()))){
							for(int k=0;k<tr.getTdsCount();k++){
								computeTdByUnit(tr.getTD(k),unit);	
							}			
						}	
					}
					else if(listCond.size()==3){
						ReportColumnCond condRoomNum = listCond.get(0);
						ReportColumnCond condHallNum = listCond.get(1);
						ReportColumnCond condToiletNum = listCond.get(2);
						if(ReportShowUtils.checkCond(condRoomNum,ContReportTableColumn.ROOM_NUM,ContReportColumnMethod.EQ,String.valueOf(unit.getRoomNum()))
								&& ReportShowUtils.checkCond(condHallNum,ContReportTableColumn.HALL_NUM,ContReportColumnMethod.EQ,String.valueOf(unit.getHallNum()))
								&& ReportShowUtils.checkCond(condToiletNum,ContReportTableColumn.TOILET_NUM,ContReportColumnMethod.EQ,String.valueOf(unit.getToiletNum()))){//楼层条件
							for(int k=0;k<tr.getTdsCount();k++){
								computeTdByUnit(tr.getTD(k),unit);	
							}				
						}				
					}
					
				}
				else if(tr.getTypeName().equals("户型")){
					if(listCond.size()==1){
						ReportColumnCond condRoomNum = listCond.get(0);

						if(ReportShowUtils.checkCond(condRoomNum,ContReportTableColumn.HOUSE_TYPE,ContReportColumnMethod.EQ,unit.getHouseType())){
							for(int k=0;k<tr.getTdsCount();k++){
								computeTdByUnit(tr.getTD(k),unit);	
							}
						}
						
					}
					
				}
				else if(tr.getTypeName().equals("付款方式")){
					if(listCond.size()==1){
						ReportColumnCond condRoomNum = listCond.get(0);

						if(ReportShowUtils.checkCond(condRoomNum,ContReportTableColumn.PAY_WAY_ID,ContReportColumnMethod.EQ,String.valueOf(unit.getPriceWay()))){
//							for(int k=0;k<tr.getTdsCount();k++){
//								computeTdByUnit(tr.getTD(k),unit);	
//							}
						}
						
					}
					
				}
				
			}
		}

		ReportShowUtils.autoAddSumTRToListReportShow(trList);

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
		System.out.println(DateTimeUtils.getNow());
		
		return "suc";
	}	
	

	private void computeTdByUnit(ReportShowTD td,PropertyUnit unit){
		if(td.getxTheadText().equalsIgnoreCase("总货量_总套数")){
			ReportShowUtils.ReportShowTD_Increment(td);
		}else if(td.getxTheadText().equalsIgnoreCase("总货量_总面积")){			
			ReportShowUtils.ReportShowTD_AddNum(td,unit.getBuildArea());
		}else if(td.getxTheadText().equalsIgnoreCase("总货量_总金额")){
			if(unit.getSumPrice()!=null) {
				ReportShowUtils.ReportShowTD_AddNum(td,unit.getSumPrice().divide(new BigDecimal(10000), new MathContext(9, RoundingMode.HALF_DOWN)));
			}
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
			if(unit.isTuiHuo()&&unit.getSumPrice()!=null){				
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
			if(unit.isShengYu()&&unit.getSumPrice()!=null){			
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
	
	public String xshlfxFlReportFirst() throws Exception{
		
		return "xshlfxFlReportFirst";
	}

	// 销售货量分析(按价格)
	public String xshlfxFlReport() {
		initSearchDate();
		runReport();
		return "suc";
	}
	
	public String searchxshlfxFlReport() throws Exception {
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

	public String getShowTrs() {
		return showTrs;
	}

	public void setShowTrs(String showTrs) {
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
		else{
			propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));			
		}
	}
	
public String download() throws Exception{
		
		String[] thx = new String[]{"类别","分类","总套数","总面积","总金额（定价）","均价","总套数","总面积","总金额（定价）","均价","总套数","总面积","总金额（定价）","均价","余货比例",
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
