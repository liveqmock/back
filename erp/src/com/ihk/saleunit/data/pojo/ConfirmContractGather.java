package com.ihk.saleunit.data.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 成交合同汇总bean
 * @author dtc
 * 2013-1-31,下午03:05:23
 */
public class ConfirmContractGather implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int propertyId;
	private int areaId;
	private int buildId;

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

    /**
	 * 成交套数
	 */
	private int count;
	
	/**
	 * 建筑面积
	 */
	private BigDecimal buildArea;
	
	/**
	 * 建筑成交单价
	 */
	private BigDecimal buildPrice;
	
	/**
	 * 套内成交单价
	 */
	private BigDecimal insideUnitPrice;
	
	/**
	 * 成交总价
	 */
	private BigDecimal sumMoney;
	
	/**
	 * 应收金额
	 */
	private BigDecimal shouldAmount;
	
	/**
	 * 实收金额
	 */
	private BigDecimal paymentAmount;
	
	/**
	 * 成交单元单价（底价）
	 */
	private BigDecimal baseprice;
	
	/**
	 * 成交单元总价（底价）
	 */
	private BigDecimal totalBaseprice;

    private BigDecimal relationAmount;
    private BigDecimal secondLinkageAmount;
    //是否关系户
    private String isRelation;
    //是否一二手联动
    private String isSecondLinkage;

    public BigDecimal getRelationAmount() {
        return relationAmount;
    }

    public void setRelationAmount(BigDecimal relationAmount) {
        this.relationAmount = relationAmount;
    }

    public BigDecimal getSecondLinkageAmount() {
        return secondLinkageAmount;
    }

    public void setSecondLinkageAmount(BigDecimal secondLinkageAmount) {
        this.secondLinkageAmount = secondLinkageAmount;
    }

    public String getRelation() {
        return isRelation;
    }

    public void setRelation(String relation) {
        isRelation = relation;
    }

    public String getSecondLinkage() {
        return isSecondLinkage;
    }

    public void setSecondLinkage(String secondLinkage) {
        isSecondLinkage = secondLinkage;
    }

    public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public BigDecimal getBaseprice() {
		return baseprice;
	}

	public void setBaseprice(BigDecimal baseprice) {
		this.baseprice = baseprice;
	}

	public BigDecimal getTotalBaseprice() {
		return totalBaseprice;
	}

	public void setTotalBaseprice(BigDecimal totalBaseprice) {
		this.totalBaseprice = totalBaseprice;
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public BigDecimal getBuildArea() {
		return buildArea;
	}

	public void setBuildArea(BigDecimal buildArea) {
		this.buildArea = buildArea;
	}

	public BigDecimal getBuildPrice() {
		return buildPrice;
	}

	public void setBuildPrice(BigDecimal buildPrice) {
		this.buildPrice = buildPrice;
	}

	public BigDecimal getInsideUnitPrice() {
		return insideUnitPrice;
	}

	public void setInsideUnitPrice(BigDecimal insideUnitPrice) {
		this.insideUnitPrice = insideUnitPrice;
	}

	public BigDecimal getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}

	public BigDecimal getShouldAmount() {
		return shouldAmount;
	}

	public void setShouldAmount(BigDecimal shouldAmount) {
		this.shouldAmount = shouldAmount;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

}
