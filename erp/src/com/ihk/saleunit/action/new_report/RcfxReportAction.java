package com.ihk.saleunit.action.new_report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContTable;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.ReportShowTD;
import com.ihk.saleunit.data.pojo.ReportShowTR;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.ReportShowUtils;

/**
 * 认筹分析 报表
 *
 */
public class RcfxReportAction extends SupperAction {

	/*
	 * 报表的计算方式：数据表的准备
	 * 1,取出楼盘项目的房号；性能：一次查询
	 * 2，形成任务的trs
	 * 
	 * 3，意向类型；性能：一次查询(现在先固定好)
	 * 4，查询房间的楼层;
	 * 
	 * 形成表格
	 * 
	 * 5,取出认筹表，单元表，然后填充表格
	 * 
	 */	
	
	/**
	 * 每层房间数量
	 */
	private int roomCount = 0;
	
	/**
	 * 最大认筹数量
	 */
	private int chipCount = 0;
	
	/**
	 * 楼层数量
	 */
	private int floorCount = 0;
	@Autowired IPropertyUnitServices propertyUnitServices;
		
	/**
	 * 添加td到tr
	 */
	private void addTDsToTR(ReportShowTR showTR,int minU,int maxU,int chipNum,Map<Integer,Map> trUnitMap){
		for(int i=minU;i<=maxU;i++){
			for(int j=1;j<=chipNum;j++){
				String ke = "chip"+j+"Sum";
				try {
					showTR.addTD(new ReportShowTD(trUnitMap.get(i).get(ke).toString()));
				} catch (Exception e) {
					// TODO: handle exception
					showTR.addTD(new ReportShowTD(" "));
				}
				
			}
		}		
	}
	
	/**
	 * 添加行(tr)到列表
	 * @param trList
	 * @param trHeadTitle
	 */
	private void addTRsToList(ArrayList<ReportShowTR> trList,int minU,int maxU,int chipNum,int floorNum,Map<Integer,Map> trMap){	
		ReportShowTR showTR = new ReportShowTR();
		ReportShowTD td = new ReportShowTD(String.valueOf(floorNum)+"层");
		td.setyTypeName(String.valueOf(floorNum)+"层");
		showTR.addTD(td);
		addTDsToTR(showTR,minU,maxU,chipNum,trMap);
		trList.add(showTR);
	}
	

	/**
	 * 添加行(tr)到列表
	 * 表头
	 */
	private void addTRsHead1ToList(ArrayList<ReportShowTR> trList,int minU,int maxU,int chipNum){	
		ReportShowTR showTRHead1 = new ReportShowTR();
		ReportShowTD td = new ReportShowTD("房号");
		td.setyTypeName("房号");
		showTRHead1.addTD(td);
		
		for(int i=minU;i<=maxU;i++){
			for(int j=1;j<=chipNum;j++){
				ReportShowTD tdValue = new ReportShowTD(String.valueOf(i)+"房号");
				tdValue.setxTypeName(String.valueOf(i)+"房号");
				showTRHead1.addTD(tdValue);
			}
		}
		
		trList.add(showTRHead1);
	}
	

	private void addTRsHead2ToList(ArrayList<ReportShowTR> trList,int minU,int maxU,int chipNum){	
		ReportShowTR showTRHead = new ReportShowTR();
		ReportShowTD td = new ReportShowTD("意向");
		td.setyTypeName("意向");
		showTRHead.addTD(td);
		
		for(int i=minU;i<=maxU;i++){
			for(int j=1;j<=chipNum;j++){
				ReportShowTD tdValue = new ReportShowTD(String.valueOf(j)+"意向");
				showTRHead.addTD(tdValue);
			}
		}
		
		trList.add(showTRHead);
	}

	public void runReport() {
		
		roomCount = 4;
		chipCount = 3;
		floorCount = 20;
		
		if(null == propertyUnitCond){
			setShowTrs("<tr bgcolor='#FFFFFF' border='0'><td>请选择项目名称</td></tr>");//设置输出
		}
		
		List<Map> unitList = propertyUnitServices.reportForRCFX(propertyUnitCond);
		if(unitList == null || unitList.size() ==0){
			setShowTrs("<tr bgcolor='#FFFFFF' border='0'><td>查询结果为空</td></tr>");//设置输出
		}
		int minF = -999,maxF = -999,minU = -999,maxU = -999;
		
		
		for(Map p : unitList){
			
			try{
				
				if(minF == -999)minF = Integer.parseInt(p.get("floorNum").toString());
				if(maxF == -999)maxF = Integer.parseInt(p.get("floorNum").toString());
				if(minU == -999)minU = Integer.parseInt(p.get("roomNo").toString());
				if(maxU == -999)maxU = Integer.parseInt(p.get("roomNo").toString());
				
				minF = Integer.parseInt(p.get("floorNum").toString()) < minF ? Integer.parseInt(p.get("floorNum").toString()) : minF;
				maxF = Integer.parseInt(p.get("floorNum").toString()) > maxF ? Integer.parseInt(p.get("floorNum").toString()) : maxF;
				minU = Integer.parseInt(p.get("roomNo").toString()) < minU ? Integer.parseInt(p.get("roomNo").toString()) : minU;
				maxU = Integer.parseInt(p.get("roomNo").toString()) > maxU ? Integer.parseInt(p.get("roomNo").toString()) : maxU;
				
			}catch (Exception e) {
			}
			
		}
		HashMap<Integer,Map<Integer,Map>> trUnitList = new HashMap<Integer, Map<Integer,Map>>();
		for (int i = minF; i <= maxF; i++) {
			trUnitList.put(i, new HashMap<Integer,Map>());
		}
		
		for(Map p : unitList){
			try{
				trUnitList.get(Integer.parseInt(p.get("floorNum").toString())).put(Integer.parseInt(p.get("roomNo").toString()) , p);
			}catch (Exception e) {
			}
		}
		
		//步骤1：进行List的定义，直接对应于html页面的Table		
		ArrayList<ReportShowTR> trList = new ArrayList();
		//表头的两行
		addTRsHead1ToList(trList,minU,maxU,chipCount);
		addTRsHead2ToList(trList,minU,maxU,chipCount);
		
		
		
		//表格的内容
		for(int i=minF;i<=maxF;i++){//楼层
			if(i != 0){
				addTRsToList(trList,minU,maxU,chipCount,i,trUnitList.get(i));
			}
		}

		ReportShowUtils.autoFixColSpanVisiable(trList);
		String str = ReportShowUtils.getTrsByListTR(trList);
		if(str != null)
			setShowTrs(str);//设置输出
		request.getSession().setAttribute("showTrs", showTrs);
	}	
	
	public String rcfxReportFirst() throws Exception{
		
		initSearchDate();
		
		return "rcfxReportFirst";
	}

	
	public String rcfxReport() {
		initSearchDate();
		runReport();
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
	}

	public String download() throws Exception{
		
		final StringBuffer sb = new StringBuffer();
		sb.append(ContTable.TABLE_START);
		sb.append((String)request.getSession().getAttribute("showTrs"));
		sb.append(ContTable.TALBE_END);
		String fileName = "download-" + CustomerUtils.getNowForString() + "-.xls";
		ReportUtils.downLoadReport(sb.toString(), fileName, response);
		
		return SUCCESS;
	}
	
	
}
