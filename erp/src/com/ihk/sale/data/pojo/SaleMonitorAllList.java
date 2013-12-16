package com.ihk.sale.data.pojo;

import java.io.Serializable;
import java.util.Date;

import com.ihk.utils.DescUtils;

/**
 * 在售数据总表
 */
public class SaleMonitorAllList implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date monitorDate; //jsp页面
	private String monitorDateString; //xls的下载
	private int projectId;
	private int companyId;
	private int phoneNum;
	private int visitorNum;
	private int houseNum;
	private int shopNum;
	private int parkNum;
	private int tempNum;
	private int completeArea;
	private int completeMoney;
	private int intentionNum; //认筹数
	
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;
	
	/**
	 * 月的
	 */
	
	private int houseNum_m;
	private int shopNum_m;
	private int parkNum_m;
	private int tempNum_m;
	private int completeArea_m;
	private int completeMoney_m;
	private int intentionNum_m; 
	
	/**
	 * 总的
	 */
	
	private int houseNum_a;
	private int shopNum_a;
	private int parkNum_a;
	private int tempNum_a;
	private int completeArea_a;
	private int completeMoney_a;
	private int intentionNum_a;
	
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
	
	public String getDescProjectOrderIndex(){
		try {
			return DescUtils.getDescProjectOrderIndex(this.getProjectId());
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public void setMonitorDateString(String monitorDateString) {
		this.monitorDateString = monitorDateString;
	}
	
	public String getMonitorDateString() {
		return monitorDateString;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getMonitorDate() {
		return monitorDate;
	}
	public void setMonitorDate(Date monitorDate) {
		this.monitorDate = monitorDate;
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
	public int getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}
	public int getShopNum() {
		return shopNum;
	}
	public void setShopNum(int shopNum) {
		this.shopNum = shopNum;
	}
	public int getParkNum() {
		return parkNum;
	}
	public void setParkNum(int parkNum) {
		this.parkNum = parkNum;
	}
	public int getTempNum() {
		return tempNum;
	}
	public void setTempNum(int tempNum) {
		this.tempNum = tempNum;
	}
	public int getCompleteArea() {
		return completeArea;
	}
	public void setCompleteArea(int completeArea) {
		this.completeArea = completeArea;
	}
	public int getCompleteMoney() {
		return completeMoney;
	}
	public void setCompleteMoney(int completeMoney) {
		this.completeMoney = completeMoney;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public int getCreatedId() {
		return createdId;
	}
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public int getModId() {
		return modId;
	}
	public void setModId(int modId) {
		this.modId = modId;
	}
	public Date getModTime() {
		return modTime;
	}
	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

	public int getHouseNum_m() {
		return houseNum_m;
	}

	public void setHouseNum_m(int houseNum_m) {
		this.houseNum_m = houseNum_m;
	}

	public int getShopNum_m() {
		return shopNum_m;
	}

	public void setShopNum_m(int shopNum_m) {
		this.shopNum_m = shopNum_m;
	}

	public int getParkNum_m() {
		return parkNum_m;
	}

	public void setParkNum_m(int parkNum_m) {
		this.parkNum_m = parkNum_m;
	}

	public int getTempNum_m() {
		return tempNum_m;
	}

	public void setTempNum_m(int tempNum_m) {
		this.tempNum_m = tempNum_m;
	}

	public int getCompleteArea_m() {
		return completeArea_m;
	}

	public void setCompleteArea_m(int completeArea_m) {
		this.completeArea_m = completeArea_m;
	}

	public int getCompleteMoney_m() {
		return completeMoney_m;
	}

	public void setCompleteMoney_m(int completeMoney_m) {
		this.completeMoney_m = completeMoney_m;
	}

	public int getHouseNum_a() {
		return houseNum_a;
	}

	public void setHouseNum_a(int houseNum_a) {
		this.houseNum_a = houseNum_a;
	}

	public int getShopNum_a() {
		return shopNum_a;
	}

	public void setShopNum_a(int shopNum_a) {
		this.shopNum_a = shopNum_a;
	}

	public int getParkNum_a() {
		return parkNum_a;
	}

	public void setParkNum_a(int parkNum_a) {
		this.parkNum_a = parkNum_a;
	}

	public int getTempNum_a() {
		return tempNum_a;
	}

	public void setTempNum_a(int tempNum_a) {
		this.tempNum_a = tempNum_a;
	}

	public int getCompleteArea_a() {
		return completeArea_a;
	}

	public void setCompleteArea_a(int completeArea_a) {
		this.completeArea_a = completeArea_a;
	}

	public int getCompleteMoney_a() {
		return completeMoney_a;
	}

	public void setCompleteMoney_a(int completeMoney_a) {
		this.completeMoney_a = completeMoney_a;
	}

	public int getIntentionNum() {
		return intentionNum;
	}

	public void setIntentionNum(int intentionNum) {
		this.intentionNum = intentionNum;
	}

	public int getIntentionNum_m() {
		return intentionNum_m;
	}

	public void setIntentionNum_m(int intentionNum_m) {
		this.intentionNum_m = intentionNum_m;
	}

	public int getIntentionNum_a() {
		return intentionNum_a;
	}

	public void setIntentionNum_a(int intentionNum_a) {
		this.intentionNum_a = intentionNum_a;
	}
	

}
