package com.ihk.report.data.pojo.unitsale;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;

/**
 * 销量分析：公司
 * @author 
 *
 */
public class ReportPojoXSFXByCompany implements Serializable{
	private static final long serialVersionUID = 1L;


	private String companyId;	//公司id
	private String companyName;	//公司名称
	private BigDecimal sumAmount;	//套数
	private BigDecimal sumArea;	//面积
	private BigDecimal sumMoney;	//总价
	private BigDecimal leftAmount;	//剩余套数
	private BigDecimal leftArea;	//剩余面积
	private BigDecimal leftMoney;	//剩余货值


	/**
	 * 公司id
	 * @return
	 */
	public String getCompanyId() {
		return companyId;
	}
	/**
	 * 公司id
	 * @param company_id
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * 公司名称
	 * @return
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 公司名称
	 * @param company_name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 套数
	 * @return
	 */
	public BigDecimal getSumAmount() {
		return sumAmount;
	}
	/**
	 * 套数
	 * @param sum_amount
	 */
	public void setSumAmount(BigDecimal sumAmount) {
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

	/**
	 * 剩余套数
	 * @return
	 */
	public BigDecimal getLeftAmount() {
		return leftAmount;
	}
	/**
	 * 剩余套数
	 * @param left_amount
	 */
	public void setLeftAmount(BigDecimal leftAmount) {
		this.leftAmount = leftAmount;
	}

	/**
	 * 剩余面积
	 * @return
	 */
	public BigDecimal getLeftArea() {
		return leftArea;
	}
	/**
	 * 剩余面积
	 * @param left_area
	 */
	public void setLeftArea(BigDecimal leftArea) {
		this.leftArea = leftArea;
	}

	/**
	 * 剩余货值
	 * @return
	 */
	public BigDecimal getLeftMoney() {
		return leftMoney;
	}
	/**
	 * 剩余货值
	 * @param left_money
	 */
	public void setLeftMoney(BigDecimal leftMoney) {
		this.leftMoney = leftMoney;
	}
	
    
}
