package com.ihk.sale.data.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.ihk.utils.DescUtils;

/**
 *  分段汇总中的 项目销售列表
 */
public class SaleMonitorSearchTimeAll implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String monitorDate;
	private int projectId;
	private int companyId;
	private int phoneNum;  // 当天来电
	private int visitorNum; // 当天来访
	private int sumNum; //销售套数
	private BigDecimal sumArea; //销售面积
	private BigDecimal sumMoney; //销售金额(万元)
	private int intentionNum; //认筹
	
	private int sumNum_w; //销售套数
	private BigDecimal sumArea_w; //销售面积
	private BigDecimal sumMoney_w; //销售金额(万元)
	private int intentionNum_w; //认筹
	
	private int sumNum_m; //销售套数
	private BigDecimal sumArea_m; //销售面积
	private BigDecimal sumMoney_m; //销售金额(万元)
	private int intentionNum_m; //认筹
	
	private int sumNum_y; //销售套数
	private BigDecimal sumArea_y; //销售面积
	private BigDecimal sumMoney_y; //销售金额(万元)
	private int intentionNum_y; //认筹
	
	private Date lastModTime; 
	
	public String getDescCompanyName(){
		try {
			return DescUtils.getCompanyRealName(this.companyId);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public String getDescProjectName(){
		try {
			return DescUtils.getCompanyProjectRealName(this.getProjectId());
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public void setLastModTime(Date lastModTime) {
		this.lastModTime = lastModTime;
	}
	
	public Date getLastModTime() {
		return lastModTime;
	}
	
	public void setMonitorDate(String monitorDate) {
		this.monitorDate = monitorDate;
	}
	
	public String getMonitorDate() {
		return monitorDate;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getVisitorNum() {
		return visitorNum;
	}
	public void setVisitorNum(int visitorNum) {
		this.visitorNum = visitorNum;
	}
	public int getSumNum() {
		return sumNum;
	}
	public void setSumNum(int sumNum) {
		this.sumNum = sumNum;
	}
	public BigDecimal getSumArea() {
		return sumArea == null ? new BigDecimal(0) : sumArea;
	}
	public void setSumArea(BigDecimal sumArea) {
		this.sumArea = sumArea;
	}
	public BigDecimal getSumMoney() {
		return sumMoney == null ? new BigDecimal(0) : sumMoney;
	}
	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}
	public int getIntentionNum() {
		return intentionNum;
	}
	public void setIntentionNum(int intentionNum) {
		this.intentionNum = intentionNum;
	}
	public int getSumNum_w() {
		return sumNum_w;
	}
	public void setSumNum_w(int sumNum_w) {
		this.sumNum_w = sumNum_w;
	}
	public BigDecimal getSumArea_w() {
		return sumArea_w == null ? new BigDecimal(0) : sumArea_w;
	}
	public void setSumArea_w(BigDecimal sumArea_w) {
		this.sumArea_w = sumArea_w;
	}
	public BigDecimal getSumMoney_w() {
		return sumMoney_w == null ? new BigDecimal(0) : sumMoney_w;
	}
	public void setSumMoney_w(BigDecimal sumMoney_w) {
		this.sumMoney_w = sumMoney_w;
	}
	public int getIntentionNum_w() {
		return intentionNum_w;
	}
	public void setIntentionNum_w(int intentionNum_w) {
		this.intentionNum_w = intentionNum_w;
	}
	public int getSumNum_m() {
		return sumNum_m;
	}
	public void setSumNum_m(int sumNum_m) {
		this.sumNum_m = sumNum_m;
	}
	public BigDecimal getSumArea_m() {
		return sumArea_m == null ? new BigDecimal(0) : sumArea_m;
	}
	public void setSumArea_m(BigDecimal sumArea_m) {
		this.sumArea_m = sumArea_m;
	}
	public BigDecimal getSumMoney_m() {
		return sumMoney_m == null ? new BigDecimal(0) : sumMoney_m;
	}
	public void setSumMoney_m(BigDecimal sumMoney_m) {
		this.sumMoney_m = sumMoney_m;
	}
	public int getIntentionNum_m() {
		return intentionNum_m;
	}
	public void setIntentionNum_m(int intentionNum_m) {
		this.intentionNum_m = intentionNum_m;
	}
	public int getSumNum_y() {
		return sumNum_y;
	}
	public void setSumNum_y(int sumNum_y) {
		this.sumNum_y = sumNum_y;
	}
	public BigDecimal getSumArea_y() {
		return sumArea_y == null ? new BigDecimal(0) : sumArea_y;
	}
	public void setSumArea_y(BigDecimal sumArea_y) {
		this.sumArea_y = sumArea_y;
	}
	public BigDecimal getSumMoney_y() {
		return sumMoney_y == null ? new BigDecimal(0) : sumMoney_y;
	}
	public void setSumMoney_y(BigDecimal sumMoney_y) {
		this.sumMoney_y = sumMoney_y;
	}
	public int getIntentionNum_y() {
		return intentionNum_y;
	}
	public void setIntentionNum_y(int intentionNum_y) {
		this.intentionNum_y = intentionNum_y;
	}
	
}
