package com.ihk.sale.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;

/**
 * SaleMonitor的实体类
 * @author 
 * 此类已经非代码生成器生成
 */
public class SaleMonitor extends Object implements Serializable{
	private static final long serialVersionUID = 1L;
    
	private int id;
	private Date monitorDate;
	private int projectId;
	private int companyId;
	private int phoneNum;
	private int visitorNum;
	private int houseNum;
	private BigDecimal houseArea = new BigDecimal(0);
	private BigDecimal houseMoney = new BigDecimal(0);
	private int shopNum;
	private BigDecimal shopArea = new BigDecimal(0);
	private BigDecimal shopMoney = new BigDecimal(0);
	private int parkNum;
	private BigDecimal parkArea = new BigDecimal(0);
	private BigDecimal parkMoney = new BigDecimal(0);
	private int sumNum;
	private BigDecimal sumArea = new BigDecimal(0);
	private BigDecimal sumMoney = new BigDecimal(0);
	private int contractHouseNum;
	private BigDecimal contractHouseArea = new BigDecimal(0);
	private BigDecimal contractHouseMoney = new BigDecimal(0);
	private int contractShopNum;
	private BigDecimal contractShopArea = new BigDecimal(0);
	private BigDecimal contractShopMoney = new BigDecimal(0);
	private int contractParkNum;
	private BigDecimal contractParkArea = new BigDecimal(0);
	private BigDecimal contractParkMoney = new BigDecimal(0);
	private int contractSumNum;
	private BigDecimal contractSumArea = new BigDecimal(0);
	private BigDecimal contractSumMoney = new BigDecimal(0);
	private int undoHouseNum;
	private BigDecimal undoHouseArea = new BigDecimal(0);
	private BigDecimal undoHouseMoney = new BigDecimal(0);
	private int undoShopNum;
	private BigDecimal undoShopArea = new BigDecimal(0);
	private BigDecimal undoShopMoney = new BigDecimal(0);
	private int undoParkNum;
	private BigDecimal undoParkArea = new BigDecimal(0);
	private BigDecimal undoParkMoney = new BigDecimal(0);
	private int undoSumNum;
	private BigDecimal undoSumArea = new BigDecimal(0);
	private BigDecimal undoSumMoney = new BigDecimal(0);
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

	//扩展属性 拿到类似10-05
	public String getDayString(){	
		return DateTimeUtils.getDateFormatStr(this.monitorDate).substring(5);
	}
	public String getDescModId() throws Exception {
		return DescUtils.getUserRealName(this.modId);
	}
	public String getDescCreatedId() throws Exception {
		return DescUtils.getUserRealName(this.createdId);
		}
	
	public void setMonitorDateString(String monitorDateString) {
		this.monitorDateString = monitorDateString;
	}
	
	public String getMonitorDateString() {
		if(!CustomerUtils.isStrEmpty(this.monitorDateString)){
			return this.monitorDateString;
		}else{
			try{
				return CustomerUtils.getDateString(this.monitorDate);
			}catch(Exception e){
				e.printStackTrace();
				return "";
			}
		}
	}
	
	public String getDescCompanyName(){
		try {
			
			return DescUtils.getCompanyNameByProjectId(this.getProjectId());
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
		return houseArea;
	}

	public void setHouseArea(BigDecimal houseArea) {
		this.houseArea = houseArea;
	}
    
	public BigDecimal getHouseMoney() {
		return houseMoney;
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
		return shopArea;
	}

	public void setShopArea(BigDecimal shopArea) {
		this.shopArea = shopArea;
	}
    
	public BigDecimal getShopMoney() {
		return shopMoney;
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
		return parkArea;
	}

	public void setParkArea(BigDecimal parkArea) {
		this.parkArea = parkArea;
	}
    
	public BigDecimal getParkMoney() {
		return parkMoney;
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
		return sumArea;
	}

	public void setSumArea(BigDecimal sumArea) {
		this.sumArea = sumArea;
	}
    
	public BigDecimal getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}

    
	public int getContractHouseNum() {
		return contractHouseNum;
	}

	public void setContractHouseNum(int contractHouseNum) {
		this.contractHouseNum = contractHouseNum;
	}
    
	public BigDecimal getContractHouseArea() {
		return contractHouseArea;
	}

	public void setContractHouseArea(BigDecimal contractHouseArea) {
		this.contractHouseArea = contractHouseArea;
	}
    
	public BigDecimal getContractHouseMoney() {
		return contractHouseMoney;
	}

	public void setContractHouseMoney(BigDecimal contractHouseMoney) {
		this.contractHouseMoney = contractHouseMoney;
	}
    
	public int getContractShopNum() {
		return contractShopNum;
	}

	public void setContractShopNum(int contractShopNum) {
		this.contractShopNum = contractShopNum;
	}
    
	public BigDecimal getContractShopArea() {
		return contractShopArea;
	}

	public void setContractShopArea(BigDecimal contractShopArea) {
		this.contractShopArea = contractShopArea;
	}
    
	public BigDecimal getContractShopMoney() {
		return contractShopMoney;
	}

	public void setContractShopMoney(BigDecimal contractShopMoney) {
		this.contractShopMoney = contractShopMoney;
	}
    
	public int getContractParkNum() {
		return contractParkNum;
	}

	public void setContractParkNum(int contractParkNum) {
		this.contractParkNum = contractParkNum;
	}
    
	public BigDecimal getContractParkArea() {
		return contractParkArea;
	}

	public void setContractParkArea(BigDecimal contractParkArea) {
		this.contractParkArea = contractParkArea;
	}
    
	public BigDecimal getContractParkMoney() {
		return contractParkMoney;
	}

	public void setContractParkMoney(BigDecimal contractParkMoney) {
		this.contractParkMoney = contractParkMoney;
	}
    
	public int getContractSumNum() {
		return contractSumNum;
	}

	public void setContractSumNum(int contractSumNum) {
		this.contractSumNum = contractSumNum;
	}
    
	public BigDecimal getContractSumArea() {
		return contractSumArea;
	}

	public void setContractSumArea(BigDecimal contractSumArea) {
		this.contractSumArea = contractSumArea;
	}
    
	public BigDecimal getContractSumMoney() {
		return contractSumMoney;
	}

	public void setContractSumMoney(BigDecimal contractSumMoney) {
		this.contractSumMoney = contractSumMoney;
	}
    
	public int getUndoHouseNum() {
		return undoHouseNum;
	}

	public void setUndoHouseNum(int undoHouseNum) {
		this.undoHouseNum = undoHouseNum;
	}
    
	public BigDecimal getUndoHouseArea() {
		return undoHouseArea;
	}

	public void setUndoHouseArea(BigDecimal undoHouseArea) {
		this.undoHouseArea = undoHouseArea;
	}
    
	public BigDecimal getUndoHouseMoney() {
		return undoHouseMoney;
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
		return undoShopArea;
	}

	public void setUndoShopArea(BigDecimal undoShopArea) {
		this.undoShopArea = undoShopArea;
	}
    
	public BigDecimal getUndoShopMoney() {
		return undoShopMoney;
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
		return undoParkArea;
	}

	public void setUndoParkArea(BigDecimal undoParkArea) {
		this.undoParkArea = undoParkArea;
	}
    
	public BigDecimal getUndoParkMoney() {
		return undoParkMoney;
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
		return undoSumArea;
	}

	public void setUndoSumArea(BigDecimal undoSumArea) {
		this.undoSumArea = undoSumArea;
	}
    
	public BigDecimal getUndoSumMoney() {
		return undoSumMoney;
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
    
	
	public SaleMonitor(){};

	public SaleMonitor(    
		int id,
        		Date monitorDate,
        		int projectId,
        		int companyId,
        		int phoneNum,
        		int visitorNum,
        		int houseNum,
        		BigDecimal houseArea,
        		BigDecimal houseMoney,
        		int shopNum,
        		BigDecimal shopArea,
        		BigDecimal shopMoney,
        		int parkNum,
        		BigDecimal parkArea,
        		BigDecimal parkMoney,
        		int sumNum,
        		BigDecimal sumArea,
        		BigDecimal sumMoney,
        		int contractHouseNum,
        		BigDecimal contractHouseArea,
        		BigDecimal contractHouseMoney,
        		int contractShopNum,
        		BigDecimal contractShopArea,
        		BigDecimal contractShopMoney,
        		int contractParkNum,
        		BigDecimal contractParkArea,
        		BigDecimal contractParkMoney,
        		int contractSumNum,
        		BigDecimal contractSumArea,
        		BigDecimal contractSumMoney,
        		int undoHouseNum,
        		BigDecimal undoHouseArea,
        		BigDecimal undoHouseMoney,
        		int undoShopNum,
        		BigDecimal undoShopArea,
        		BigDecimal undoShopMoney,
        		int undoParkNum,
        		BigDecimal undoParkArea,
        		BigDecimal undoParkMoney,
        		int undoSumNum,
        		BigDecimal undoSumArea,
        		BigDecimal undoSumMoney,
        		int tempNum,
        		int rescissionNum,
        		int completeArea,
        		int completeMoney,
        		int intentionNum,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
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
		this.contractHouseNum = contractHouseNum;
		this.contractHouseArea = contractHouseArea;
		this.contractHouseMoney = contractHouseMoney;
		this.contractShopNum = contractShopNum;
		this.contractShopArea = contractShopArea;
		this.contractShopMoney = contractShopMoney;
		this.contractParkNum = contractParkNum;
		this.contractParkArea = contractParkArea;
		this.contractParkMoney = contractParkMoney;
		this.contractSumNum = contractSumNum;
		this.contractSumArea = contractSumArea;
		this.contractSumMoney = contractSumMoney;
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
	public SaleMonitor(    
		Date monitorDate,
        		int projectId,
        		int companyId,
        		int phoneNum,
        		int visitorNum,
        		int houseNum,
        		BigDecimal houseArea,
        		BigDecimal houseMoney,
        		int shopNum,
        		BigDecimal shopArea,
        		BigDecimal shopMoney,
        		int parkNum,
        		BigDecimal parkArea,
        		BigDecimal parkMoney,
        		int sumNum,
        		BigDecimal sumArea,
        		BigDecimal sumMoney,
        		int contractHouseNum,
        		BigDecimal contractHouseArea,
        		BigDecimal contractHouseMoney,
        		int contractShopNum,
        		BigDecimal contractShopArea,
        		BigDecimal contractShopMoney,
        		int contractParkNum,
        		BigDecimal contractParkArea,
        		BigDecimal contractParkMoney,
        		int contractSumNum,
        		BigDecimal contractSumArea,
        		BigDecimal contractSumMoney,
        		int undoHouseNum,
        		BigDecimal undoHouseArea,
        		BigDecimal undoHouseMoney,
        		int undoShopNum,
        		BigDecimal undoShopArea,
        		BigDecimal undoShopMoney,
        		int undoParkNum,
        		BigDecimal undoParkArea,
        		BigDecimal undoParkMoney,
        		int undoSumNum,
        		BigDecimal undoSumArea,
        		BigDecimal undoSumMoney,
        		int tempNum,
        		int rescissionNum,
        		int completeArea,
        		int completeMoney,
        		int intentionNum,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
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
		this.contractHouseNum = contractHouseNum;
		this.contractHouseArea = contractHouseArea;
		this.contractHouseMoney = contractHouseMoney;
		this.contractShopNum = contractShopNum;
		this.contractShopArea = contractShopArea;
		this.contractShopMoney = contractShopMoney;
		this.contractParkNum = contractParkNum;
		this.contractParkArea = contractParkArea;
		this.contractParkMoney = contractParkMoney;
		this.contractSumNum = contractSumNum;
		this.contractSumArea = contractSumArea;
		this.contractSumMoney = contractSumMoney;
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
