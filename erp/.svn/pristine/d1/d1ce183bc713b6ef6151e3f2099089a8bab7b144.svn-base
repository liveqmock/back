package com.ihk.saleunit.action.new_report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.pojo.ReportDefineColumn;
import com.ihk.saleunit.data.pojo.ReportDefineColumnCond;
import com.ihk.saleunit.data.pojo.ReportDefineType;
import com.ihk.saleunit.data.pojo.ReportDefineTypeCond;
import com.ihk.saleunit.data.pojo.ReportShowTD;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IReportDefineColumnServices;
import com.ihk.saleunit.data.services.IReportDefineTypeServices;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.ReportShowUtils;

/**
 * 报表布局
 *
 */
public class ReportLayoutAction extends SupperAction {


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

	public String layout() {

		return "suc";
	}

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
		List<PropertyUnit> listUnit = propertyUnitServices.findPropertyUnit(null);
		List<Confirm> listConfirm = confirmServices.findConfirm(null);
		List<Contract> listContract = contractServices.findContractPage(new ContractCond());
		List<ReportDefineType> listReportDefineType = reportDefineTypeServices.findReportDefineType(new ReportDefineTypeCond());
		List<ReportDefineColumn> listReportDefineColumn = reportDefineColumnServices.findReportDefineColumn(new ReportDefineColumnCond());
		
		
		//重新初始化listUnit
		ReportShowUtils.initListPropertyUnit_Confirm(listUnit,listConfirm);
		ReportShowUtils.initListPropertyUnit_Contract(listUnit,listContract);
		
		
//		StringBuilder sb = new StringBuilder("[");
//
//		//列出Y轴循环
//		for(int i=0;i<listReportDefineType.size();i++){
//			sb.append("<tr>");
//			sb.append("<td rowspan='"+ listReportDefineColumn.size() +"'>"+listReportDefineType.get(i).getTypeName()+"</td>");
//
//			//内循环Y轴（子分类）
//			for(int j=0;j<listReportDefineColumn.size();j++){
//				if(j>0){
//					sb.append("<tr>");
//				}
//				sb.append("<td>"+listReportDefineColumn.get(i).getShowName()+"</td>");
//				
//				//总套数
//				sb.append("<td>"+"88"+"</td>");//待实现取列表中的符合条件的一个求和值
//				//总面积
//				sb.append("<td>"+"88"+"</td>");//待实现取列表中的符合条件的一个求和值
//				
//				//...每列做一个(可以考虑算法优化)
//				
//
//				sb.append("</tr>");
//			}
//		}
		
//		//输出		
//		DateTime dt1 = DateTimeUtils.getNow();
//		
//		String str = "";
//		System.out.println("输出示范:"+sb.toString());
//		
//
//		Map<String,BigDecimal> map = new HashMap(); //
//		map.put("a",BigDecimal.valueOf(1));
//		System.out.println("输出a:"+map.get("a"));
//
//		map.put("a",map.get("a").add(BigDecimal.valueOf(1)));
//		System.out.println("输出变化后a:"+map.get("a"));
		

		//以下是合理的数据结构，需要进行拼凑（星期一讲解），由同事们进行拼凑
//		Map<String,Map> map = new HashMap(); //
//		Map<String,Object> innerMap = new HashMap(); //
//		innerMap.put("text", "应该显示的列");
//		innerMap.put("value", BigDecimal.valueOf(1));
//		
//		map.put("1", innerMap);
//		
//
//		System.out.println("输出1_text:"+map.get("1").get("text"));
//		System.out.println("输出1_value:"+map.get("1").get("value"));
//		
//		Map map2 = (Map)map.get("1");
//		map2.put("value", BigDecimal.valueOf(2));
//		System.out.println("输出1_value2:"+map.get("1").get("value"));
		
		
		
		//步骤1：进行List的定义，直接对应于html页面的Table		
		//循环unit,对Map进行填充数据
		ArrayList<ReportShowTD> tdList = new ArrayList();
		
		//形成表格
		//总货量_总套数
		//列出Y轴循环
		for(int i=0;i<listReportDefineType.size();i++){
			//内循环Y轴（子分类）
			for(int j=0;j<listReportDefineColumn.size();j++){
				ReportDefineType yType = listReportDefineType.get(i);
				ReportDefineColumn xColumn = listReportDefineColumn.get(j);
				//ReportShowTD td = ;
				
				//按此方式，进行推广，进行一个list的定义
//				tdList.add(getTD_总货量_总套数(yType.getId(),xColumn.getId(),yType.getTypeName(),i));
//				tdList.add(getTD_总货量_总面积(yType.getId(),xColumn.getId(),yType.getTypeName(),i));
//				tdList.add(getTD_总货量_总金额(yType.getId(),xColumn.getId(),yType.getTypeName(),i));
//				tdList.add(getTD_总货量_均价(yType.getId(),xColumn.getId(),yType.getTypeName(),i));
			}
		}
		
		System.out.println("输出list"+tdList);
		
		//测试：对List快速填充值
		for(int i=0;i<listUnit.size();i++){
			PropertyUnit unit = listUnit.get(i);
			
			
			for(int j=0;j<tdList.size();j++){
				ReportShowTD td = tdList.get(j);	
				
				//关键写好内部的计算方式
				//ReportShowUtils.setShowTD(td,unit);				
			}
		}
		
		
		//tdList.a
		
		//再次按照构造Map的顺序，来拼凑string进行输出
		
		//不可采用遍历的方式，应该是反向遍历，保证每个原表只是遍历一次，然后填充目标map
//			//一个表格的时间:5s
//			for(int i=1;i<10000;i++){
//				for(int j=0;j<listUnit.size();j++){
//					PropertyUnit u = listUnit.get(j); 
//					if(u.getFloorNum()>2){
//						str = u.getFloorNum()+"b";
//					}
//				}
//			}
//		System.out.println(dt1);
		System.out.println(DateTimeUtils.getNow());
		
		return "suc";
	}
	
//	private ReportShowTD getTD_总货量_总套数(int idType,int idColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+idColumn);
//		td.setxText("总套数");
//		td.setyText(yText);
//		td.setyText("unit_数量_户型");
//		td.setxOrderIndex(0);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//
//	private ReportShowTD getTD_总货量_总面积(int idType,int idColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+idColumn);
//		td.setxText("总面积");
//		td.setyText(yText);
//		td.setyText("unit_数量_面积");
//		td.setxOrderIndex(1);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//
//	private ReportShowTD getTD_总货量_总金额(int idType,int idColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+idColumn);
//		td.setxText("总金额");
//		td.setyText(yText);
//		td.setyText("unit_数量_总金额");
//		td.setxOrderIndex(2);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}
//
//	private ReportShowTD getTD_总货量_均价(int idType,int idColumn,String yText,int yOrderIndex){
//		ReportShowTD td = new ReportShowTD();
//		td.setXyID(idType+"-"+idColumn);
//		td.setxText("均价");
//		td.setyText(yText);
//		td.setyText("unit_数量_均价");
//		td.setxOrderIndex(3);
//		td.setyOrderIndex(yOrderIndex);	
//		
//		return td;
//	}

	public String table1() {
		
		return "suc";
	}

	// 年度销售计划及落实情况
	public String ndxsjhReport() {

		return "suc";
	}

	// 年度销售数据统计
	public String ndxssjtjReport() {
		return "suc";
	}

	// 销售货量分析(按楼层)
	public String xshlfxLcReport() {
		test();//测试
		return "suc";
	}

	// 总体货量分析
	public String zthlfxReport() {
		return "suc";
	}

	// 销售货量分析(按价格)
	public String xshlfxJgReport() {
		return "suc";
	}

	// 销售货量分析(按价格)
	public String xshlfxFlReport() {
		initSearchDate();
		return "suc";
	}

	// 项目结佣情况一览表
	public String xmjyqkReport() {
		return "suc";
	}

	public String rcfxReport() {
		return "suc";
	}

	public String xsryjxReport() {
		return "suc";
	}

	public String sqkhtjReport() {
		return "suc";
	}
	
	private void initSearchDate(){
		if (customerCond == null) {
			customerCond = new CustomerCond();
			
			customerCond.setDate1(CommonUtils.getMonthFirstForString());
			customerCond.setDate2(CommonUtils.getMonthEndForString());
		}
		
		
	}

	// 下拉框(分析类型)
	private LinkedHashMap<String, String> listSelCategory;
	private CustomerCond customerCond;
	private String projectName;
	// 选中的分析类型
	private String selCategory;
	

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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	
	
	
}
