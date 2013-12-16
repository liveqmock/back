package com.ihk.report.data.pojo.unitsale;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;

/**
 * 销量分析：销售
 * @author 
 *
 */
public class ReportPojoXSFXBySalesman implements Serializable{
	private static final long serialVersionUID = 1L;


	private String salesId;	//销售id
	private String salesName;	//销售
	private int projectId;	//项目id
	private String projectName;	//项目
	private int sumAmount;	//套数
	private BigDecimal sumArea;	//面积
	private BigDecimal sumMoney;	//总价


	/**
	 * 销售id
	 * @return
	 */
	public String getSalesId() {
		if(salesId==null){
			salesId = "";
		}
		return salesId;
	}
	/**
	 * 销售id
	 * @param sales_id
	 */
	public void setSalesId(String salesId) {
		this.salesId = salesId;
		
		if(CommonUtils.isStrEmpty(salesId)==false && CommonUtils.isStrEmpty(this.salesName)){
			String tempids[]=salesId.split(",");
			String strSalesName = "";
			for (String strId:tempids){
				if(CommonUtils.isStrEmpty(strId)){
					continue;
				}
				int id=0;
				try{
					id = Integer.parseInt(strId);
				}
				catch(Exception e){
					continue;
				}
				
				strSalesName+=DescUtils.getUserRealName(id)+",";
			}
			
			if(strSalesName.endsWith(",")){
				strSalesName = strSalesName.substring(0,strSalesName.length()-1);
			}
			
			setSalesName(strSalesName);
		}
	}

	/**
	 * 销售
	 * @return
	 */
	public String getSalesName() {
		return salesName;
	}
	/**
	 * 销售
	 * @param sales_name
	 */
	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	/**
	 * 项目id
	 * @return
	 */
	public int getProjectId() {
		return projectId;
	}
	/**
	 * 项目id
	 * @param project_id
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**
	 * 项目
	 * @return
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 项目
	 * @param project_name
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * 套数
	 * @return
	 */
	public int getSumAmount() {
		return sumAmount;
	}
	/**
	 * 套数
	 * @param sum_amount
	 */
	public void setSumAmount(int sumAmount) {
		this.sumAmount = sumAmount;
	}

	/**
	 * 面积
	 * @return
	 */
	public BigDecimal getSumArea() {
		return sumArea;
	}
	/**
	 * 面积
	 * @param sum_area
	 */
	public void setSumArea(BigDecimal sumArea) {
		this.sumArea = sumArea;
	}

	/**
	 * 总价
	 * @return
	 */
	public BigDecimal getSumMoney() {
		return sumMoney;
	}
	/**
	 * 总价
	 * @param sum_money
	 */
	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}
	
    
}
