package com.ihk.sale.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;

/**
 * SaleMonitorMonth的实体类
 * @author 
 *
 */
public class SaleMonitorMonth implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private Date monitorDate;
	private int projectId;
	private int companyId;
	private int phoneNum;
	private int visitorNum;
	private int houseNum;
	private BigDecimal houseArea;
	private BigDecimal houseMoney;
	private int shopNum;
	private BigDecimal shopArea;
	private BigDecimal shopMoney;
	private int parkNum;
	private BigDecimal parkArea;
	private BigDecimal parkMoney;
	private int sumNum;
	private BigDecimal sumArea;
	private BigDecimal sumMoney;
	private int undoHouseNum;
	private BigDecimal undoHouseArea;
	private BigDecimal undoHouseMoney;
	private int undoShopNum;
	private BigDecimal undoShopArea;
	private BigDecimal undoShopMoney;
	private int undoParkNum;
	private BigDecimal undoParkArea;
	private BigDecimal undoParkMoney;
	private int undoSumNum;
	private BigDecimal undoSumArea;
	private BigDecimal undoSumMoney;
	private int tempNum;
	private int rescissionNum;
	private int completeArea;
	private int completeMoney;
	private int intentionNum;
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;

	private String monitorDateString;

	public void setMonitorDateString(String monitorDateString) {
		this.monitorDateString = monitorDateString;
	}

	public String getMonitorDateString() {
		if (!CustomerUtils.isStrEmpty(this.monitorDateString)) {
			return this.monitorDateString;
		} else {
			try {
				return CustomerUtils.getDateString(this.monitorDate);
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
	}

	public String getDescCompanyName() {
		try {
			return DescUtils.getCompanyRealName(this.companyId);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getDescProjectName() {
		try {
			return DescUtils.getCompanyProjectRealName(this.getProjectId());
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getDescProjectOrderIndex() {
		try {
			return DescUtils.getDescProjectOrderIndex(this.getProjectId());
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
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

	public BigDecimal getHouseArea() {
		return houseArea == null ? new BigDecimal(0) : houseArea;
	}

	public void setHouseArea(BigDecimal houseArea) {
		this.houseArea = houseArea;
	}

	public BigDecimal getHouseMoney() {
		return houseMoney == null ? new BigDecimal(0) : houseMoney;
	}

	public void setHouseMoney(BigDecimal houseMoney) {
		this.houseMoney = houseMoney;
	}

	public int getShopNum() {
		return shopNum;
	}

	public void setShopNum(int shopNum) {
		this.shopNum = shopNum;
	}

	public BigDecimal getShopArea() {
		return shopArea == null ? new BigDecimal(0) : shopArea;
	}

	public void setShopArea(BigDecimal shopArea) {
		this.shopArea = shopArea;
	}

	public BigDecimal getShopMoney() {
		return shopMoney == null ? new BigDecimal(0) : shopMoney;
	}

	public void setShopMoney(BigDecimal shopMoney) {
		this.shopMoney = shopMoney;
	}

	public int getParkNum() {
		return parkNum;
	}

	public void setParkNum(int parkNum) {
		this.parkNum = parkNum;
	}

	public BigDecimal getParkArea() {
		return parkArea == null ? new BigDecimal(0) : parkArea;
	}

	public void setParkArea(BigDecimal parkArea) {
		this.parkArea = parkArea;
	}

	public BigDecimal getParkMoney() {
		return parkMoney == null ? new BigDecimal(0) : parkMoney;
	}

	public void setParkMoney(BigDecimal parkMoney) {
		this.parkMoney = parkMoney;
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

	public int getUndoHouseNum() {
		return undoHouseNum;
	}

	public void setUndoHouseNum(int undoHouseNum) {
		this.undoHouseNum = undoHouseNum;
	}

	public BigDecimal getUndoHouseArea() {
		return undoHouseArea == null ? new BigDecimal(0) : undoHouseArea;
	}

	public void setUndoHouseArea(BigDecimal undoHouseArea) {
		this.undoHouseArea = undoHouseArea;
	}

	public BigDecimal getUndoHouseMoney() {
		return undoHouseMoney == null ? new BigDecimal(0) : undoHouseMoney;
	}

	public void setUndoHouseMoney(BigDecimal undoHouseMoney) {
		this.undoHouseMoney = undoHouseMoney;
	}

	public int getUndoShopNum() {
		return undoShopNum;
	}

	public void setUndoShopNum(int undoShopNum) {
		this.undoShopNum = undoShopNum;
	}

	public BigDecimal getUndoShopArea() {
		return undoShopArea == null ? new BigDecimal(0) : undoShopArea;
	}

	public void setUndoShopArea(BigDecimal undoShopArea) {
		this.undoShopArea = undoShopArea;
	}

	public BigDecimal getUndoShopMoney() {
		return undoShopMoney == null ? new BigDecimal(0) : undoShopMoney;
	}

	public void setUndoShopMoney(BigDecimal undoShopMoney) {
		this.undoShopMoney = undoShopMoney;
	}

	public int getUndoParkNum() {
		return undoParkNum;
	}

	public void setUndoParkNum(int undoParkNum) {
		this.undoParkNum = undoParkNum;
	}

	public BigDecimal getUndoParkArea() {
		return undoParkArea == null ? new BigDecimal(0) : undoParkArea;
	}

	public void setUndoParkArea(BigDecimal undoParkArea) {
		this.undoParkArea = undoParkArea;
	}

	public BigDecimal getUndoParkMoney() {
		return undoParkMoney == null ? new BigDecimal(0) : undoParkMoney;
	}

	public void setUndoParkMoney(BigDecimal undoParkMoney) {
		this.undoParkMoney = undoParkMoney;
	}

	public int getUndoSumNum() {
		return undoSumNum;
	}

	public void setUndoSumNum(int undoSumNum) {
		this.undoSumNum = undoSumNum;
	}

	public BigDecimal getUndoSumArea() {
		return undoSumArea == null ? new BigDecimal(0) : undoSumArea;
	}

	public void setUndoSumArea(BigDecimal undoSumArea) {
		this.undoSumArea = undoSumArea;
	}

	public BigDecimal getUndoSumMoney() {
		return undoSumMoney == null ? new BigDecimal(0) : undoSumMoney;
	}

	public void setUndoSumMoney(BigDecimal undoSumMoney) {
		this.undoSumMoney = undoSumMoney;
	}

	public int getTempNum() {
		return tempNum;
	}

	public void setTempNum(int tempNum) {
		this.tempNum = tempNum;
	}

	public int getRescissionNum() {
		return rescissionNum;
	}

	public void setRescissionNum(int rescissionNum) {
		this.rescissionNum = rescissionNum;
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

	public int getIntentionNum() {
		return intentionNum;
	}

	public void setIntentionNum(int intentionNum) {
		this.intentionNum = intentionNum;
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

	public SaleMonitorMonth() {
	};

	public SaleMonitorMonth(int id, Date monitorDate, int projectId,
			int companyId, int phoneNum, int visitorNum, int houseNum,
			BigDecimal houseArea, BigDecimal houseMoney, int shopNum,
			BigDecimal shopArea, BigDecimal shopMoney, int parkNum,
			BigDecimal parkArea, BigDecimal parkMoney, int sumNum,
			BigDecimal sumArea, BigDecimal sumMoney, int undoHouseNum,
			BigDecimal undoHouseArea, BigDecimal undoHouseMoney,
			int undoShopNum, BigDecimal undoShopArea, BigDecimal undoShopMoney,
			int undoParkNum, BigDecimal undoParkArea, BigDecimal undoParkMoney,
			int undoSumNum, BigDecimal undoSumArea, BigDecimal undoSumMoney,
			int tempNum, int rescissionNum, int completeArea,
			int completeMoney, int intentionNum, String isDeleted,
			int createdId, Date createdTime, int modId, Date modTime) {
		super();
		this.id = id;
		this.monitorDate = monitorDate;
		this.projectId = projectId;
		this.companyId = companyId;
		this.phoneNum = phoneNum;
		this.visitorNum = visitorNum;
		this.houseNum = houseNum;
		this.houseArea = houseArea;
		this.houseMoney = houseMoney;
		this.shopNum = shopNum;
		this.shopArea = shopArea;
		this.shopMoney = shopMoney;
		this.parkNum = parkNum;
		this.parkArea = parkArea;
		this.parkMoney = parkMoney;
		this.sumNum = sumNum;
		this.sumArea = sumArea;
		this.sumMoney = sumMoney;
		this.undoHouseNum = undoHouseNum;
		this.undoHouseArea = undoHouseArea;
		this.undoHouseMoney = undoHouseMoney;
		this.undoShopNum = undoShopNum;
		this.undoShopArea = undoShopArea;
		this.undoShopMoney = undoShopMoney;
		this.undoParkNum = undoParkNum;
		this.undoParkArea = undoParkArea;
		this.undoParkMoney = undoParkMoney;
		this.undoSumNum = undoSumNum;
		this.undoSumArea = undoSumArea;
		this.undoSumMoney = undoSumMoney;
		this.tempNum = tempNum;
		this.rescissionNum = rescissionNum;
		this.completeArea = completeArea;
		this.completeMoney = completeMoney;
		this.intentionNum = intentionNum;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}

	public SaleMonitorMonth(Date monitorDate, int projectId, int companyId,
			int phoneNum, int visitorNum, int houseNum, BigDecimal houseArea,
			BigDecimal houseMoney, int shopNum, BigDecimal shopArea,
			BigDecimal shopMoney, int parkNum, BigDecimal parkArea,
			BigDecimal parkMoney, int sumNum, BigDecimal sumArea,
			BigDecimal sumMoney, int undoHouseNum, BigDecimal undoHouseArea,
			BigDecimal undoHouseMoney, int undoShopNum,
			BigDecimal undoShopArea, BigDecimal undoShopMoney, int undoParkNum,
			BigDecimal undoParkArea, BigDecimal undoParkMoney, int undoSumNum,
			BigDecimal undoSumArea, BigDecimal undoSumMoney, int tempNum,
			int rescissionNum, int completeArea, int completeMoney,
			int intentionNum, String isDeleted, int createdId,
			Date createdTime, int modId, Date modTime) {
		super();
		this.monitorDate = monitorDate;
		this.projectId = projectId;
		this.companyId = companyId;
		this.phoneNum = phoneNum;
		this.visitorNum = visitorNum;
		this.houseNum = houseNum;
		this.houseArea = houseArea;
		this.houseMoney = houseMoney;
		this.shopNum = shopNum;
		this.shopArea = shopArea;
		this.shopMoney = shopMoney;
		this.parkNum = parkNum;
		this.parkArea = parkArea;
		this.parkMoney = parkMoney;
		this.sumNum = sumNum;
		this.sumArea = sumArea;
		this.sumMoney = sumMoney;
		this.undoHouseNum = undoHouseNum;
		this.undoHouseArea = undoHouseArea;
		this.undoHouseMoney = undoHouseMoney;
		this.undoShopNum = undoShopNum;
		this.undoShopArea = undoShopArea;
		this.undoShopMoney = undoShopMoney;
		this.undoParkNum = undoParkNum;
		this.undoParkArea = undoParkArea;
		this.undoParkMoney = undoParkMoney;
		this.undoSumNum = undoSumNum;
		this.undoSumArea = undoSumArea;
		this.undoSumMoney = undoSumMoney;
		this.tempNum = tempNum;
		this.rescissionNum = rescissionNum;
		this.completeArea = completeArea;
		this.completeMoney = completeMoney;
		this.intentionNum = intentionNum;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}

}
