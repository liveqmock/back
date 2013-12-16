package com.ihk.utils.financial;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 分阶段合同的pojo
 * @author dtc
 * 2013-4-19,上午11:00:35
 */
public class MultManagerCommissionPojo implements Serializable{
	
	private static final long serialVersionUID = 1706343556759012741L;

	private int propertyId;
	
	private int areaId;
	
	private int buildId;
	
	/**
	 * 合同类型
	 */
	private String managerType;
	
	/**
	 * 合同开始日期
	 */
	private Date startDate;
	
	/**
	 * 合同结束日期
	 */
	private Date endDate;
	
	/**
	 * 默认佣金点数
	 */
	private BigDecimal commission;
	
	/**
	 * 关系户佣金点数
	 */
	private BigDecimal relationCommission;
	
	/**
	 * 关系户佣金金额
	 */
	private BigDecimal relationMoney;
	
	public BigDecimal getRelationCommission() {
		return relationCommission;
	}

	public void setRelationCommission(BigDecimal relationCommission) {
		this.relationCommission = relationCommission;
	}

	public BigDecimal getRelationMoney() {
		return relationMoney;
	}

	public void setRelationMoney(BigDecimal relationMoney) {
		this.relationMoney = relationMoney;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public String getManagerType() {
		return managerType;
	}

	public void setManagerType(String managerType) {
		this.managerType = managerType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}
	
	public MultManagerCommissionPojo() {
		super();
	}

	public MultManagerCommissionPojo(int propertyId, int areaId, int buildId,
			String managerType, Date startDate, Date endDate,
			BigDecimal commission) {
		super();
		this.propertyId = propertyId;
		this.areaId = areaId;
		this.buildId = buildId;
		this.managerType = managerType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.commission = commission;
		
	}

	public MultManagerCommissionPojo(int propertyId, int areaId, int buildId,
			String managerType, Date startDate, Date endDate,
			BigDecimal commission, BigDecimal relationCommission,
			BigDecimal relationMoney) {
		super();
		this.propertyId = propertyId;
		this.areaId = areaId;
		this.buildId = buildId;
		this.managerType = managerType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.commission = commission;
		this.relationCommission = relationCommission;
		this.relationMoney = relationMoney;
	}
	
}
