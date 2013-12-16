package com.ihk.utils.report;

import java.util.ArrayList;
import java.util.List;

import com.ihk.property.data.pojo.CjsjjcUnitCond;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.ReportDefineColumn;
import com.ihk.saleunit.data.pojo.ReportDefineColumnCond;
import com.ihk.saleunit.data.services.IReportDefineColumnServices;
import com.ihk.utils.CommonUtils;

/**
 * 主要用于综合报表部分
 * @author dtc
 * 2013-3-12,下午05:48:23
 */
public class ReportTableUtils {
	
	private static IReportDefineColumnServices reportDefineColumnServices;
	
	private static IPropertyUnitServices propertyUnitServices;
	
	public static IReportDefineColumnServices getReportDefineColumnServices() {
		return reportDefineColumnServices;
	}

	public void setReportDefineColumnServices(
			IReportDefineColumnServices reportDefineColumnServices) {
		ReportTableUtils.reportDefineColumnServices = reportDefineColumnServices;
	}

	public static IPropertyUnitServices getPropertyUnitServices() {
		return propertyUnitServices;
	}

	public void setPropertyUnitServices(
			IPropertyUnitServices propertyUnitServices) {
		ReportTableUtils.propertyUnitServices = propertyUnitServices;
	}

	public static List<ReportDefineColumn> initReportDefineColumnList(PropertyUnitCond propertyUnitCond, ReportDefineColumnCond yColumnCond){
		
		/*
		 * CJSJJC_LC :showName,1楼;typeName,楼层;
		 * 
		 * CJSJJC_FH :showName,1;typeName,房号;
		 * 
		 */
		
		CjsjjcUnitCond cond = new CjsjjcUnitCond();
		
		List<ReportDefineColumn> listReportDefineYColumn = new ArrayList<ReportDefineColumn>();
		
		String reportName = yColumnCond.getReportName();
		int companyProjectId = propertyUnitCond.getCompanyProjectId();
		
		cond.setReportName(reportName);
		cond.setCompanyProjectId(companyProjectId);
		
		//结果List
		List<String> list = propertyUnitServices.findForCjsjjc(cond);
		
		if("CJSJJC_LC".equals(reportName)){
			//楼层
			
			if(!CommonUtils.isCollectionEmpty(list)){
				
				ReportDefineColumn column = null;
				
				for(String floor : list){
					
					column = new ReportDefineColumn();
					column.setShowName(floor + "楼");
					column.setTypeName("楼层");
					
					listReportDefineYColumn.add(column);
					
				}
			}
			
		}else if("CJSJJC_FH".equals(reportName)){
			//房号
			
			if(!CommonUtils.isCollectionEmpty(list)){
				
				ReportDefineColumn column = null;
				
				for(String roomNo : list){
					
					column = new ReportDefineColumn();
					column.setShowName(roomNo);
					column.setTypeName("房号");
					
					listReportDefineYColumn.add(column);
					
				}
			}
			
		}else if("CJSJJC_LCx".equals(reportName)){
			//楼栋
			
			if(!CommonUtils.isCollectionEmpty(list)){
				
				ReportDefineColumn column = null;
				
				for(String buildId : list){
					
					column = new ReportDefineColumn();
					column.setShowName("[" + buildId + "]"); //getBuildIdLR
					column.setTypeName("楼栋");
					
					listReportDefineYColumn.add(column);
					
				}
			}
			
		}
		
		else{
			
			listReportDefineYColumn = reportDefineColumnServices.findReportDefineColumnForY(yColumnCond);
		}
		
		return listReportDefineYColumn;
	}

}
