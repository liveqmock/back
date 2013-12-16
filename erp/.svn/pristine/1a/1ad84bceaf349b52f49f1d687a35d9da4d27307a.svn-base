package com.ihk.saleunit.data.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 报表显示的每个TR定义，用于直接构建报表的table，以及填充报表显示的表格
 * 以0为坐标开始
 * @author Administrator
 */
public class ReportShowTR implements Serializable{
	private static final long serialVersionUID = 1L;
    	
	private Integer tdsCount = 0;	

	/**
	 * 对应计算的模拟sql方法
	 */
	private String xyMethodSql;
	
	public Integer getTdsCount() {
		if(tdList!=null){
			tdsCount = tdList.size();
		}
		return tdsCount;
	}

	public void setTdsCount(Integer tdsCount) {
		this.tdsCount = tdsCount;
	}
	

	private String typeName = "";	


	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	private boolean isTypeSum=false;


	public boolean isTypeSum() {
		return isTypeSum;
	}

	public void setTypeSum(boolean isTypeSum) {
		this.isTypeSum = isTypeSum;
	}


	private Map<Integer,ReportShowTD> tdList;//Map的key是x顺序int类型,value是ReportShowTD

	public Map<Integer,ReportShowTD> getTdList() {
		return tdList;
	}

	public void setTdList(Map<Integer,ReportShowTD> tdList) {
		this.tdList = tdList;
	}

	public ReportShowTR(){}
	

	public ReportShowTR(String typeName){
		this.typeName = typeName;
	}
	
	public void addTD(int xOrderIndex,ReportShowTD td){
		if(tdList==null){
			tdList = new HashMap<Integer,ReportShowTD>();		
		}
		tdList.put(xOrderIndex, td);	
	}

	public void addTD(ReportShowTD td){
		int xOrderIndex = getTdsCount();
		
		addTD(xOrderIndex, td);
	}

	
	public ReportShowTD getTD(int xOrderIndex){
		if(tdList.containsKey(xOrderIndex)){
			return tdList.get(xOrderIndex);
		}
		
		return null;
	}
	

	public String getXyMethodSql() {
		return xyMethodSql;
	}

	public void setXyMethodSql(String xyMethodSql) {
		this.xyMethodSql = xyMethodSql;
	}

	

	
	
	
	
	
}
