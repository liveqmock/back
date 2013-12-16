package com.ihk.report.data.pojo.unitsale;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;

/**
 * 销量分析：销售明细
 * @author 
 *
 */
public class ReportPojoXSFXByUnit implements Serializable{
	private static final long serialVersionUID = 1L;


	private int unitId;	//单元id
	private String salesId;	//销售id
	private String salesName;	//销售名称
	private String buildId;	//楼栋id
	private String buildName;	//楼栋名称
	private String roomNo;	//房号
	private BigDecimal buildArea;	//建筑面积
	private BigDecimal insideArea;	//套内面积
	private BigDecimal sumPrice;	//标准总价
	private BigDecimal salePrice;	//成交总价
	private String workDate;	//业务日期
	private String payWay;	//付款方式
	private String discountPercent;	//优惠折扣
	private String customerName;	//客户名称
	private int mainId;	//成交ID

	
	
	public int getMainId() {
		return mainId;
	}
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}
	/**
	 * 单元id
	 * @return
	 */
	public int getUnitId() {
		return unitId;
	}
	/**
	 * 单元id
	 * @param unit_id
	 */
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	/**
	 * 销售id
	 * @return
	 */
	public String getSalesId() {
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
	 * 销售名称
	 * @return
	 */
	public String getSalesName() {
		return salesName;
	}
	/**
	 * 销售名称
	 * @param sales_name
	 */
	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	/**
	 * 楼栋id
	 * @return
	 */
	public String getBuildId() {
		return buildId;
	}
	/**
	 * 楼栋id
	 * @param build_id
	 */
	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	/**
	 * 楼栋名称
	 * @return
	 */
	public String getBuildName() {
		return buildName;
	}
	/**
	 * 楼栋名称
	 * @param build_name
	 */
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	/**
	 * 房号
	 * @return
	 */
	public String getRoomNo() {
		return roomNo;
	}
	/**
	 * 房号
	 * @param room_no
	 */
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	/**
	 * 建筑面积
	 * @return
	 */
	public BigDecimal getBuildArea() {
		return buildArea;
	}
	/**
	 * 建筑面积
	 * @param build_area
	 */
	public void setBuildArea(BigDecimal buildArea) {
		this.buildArea = buildArea;
	}

	/**
	 * 套内面积
	 * @return
	 */
	public BigDecimal getInsideArea() {
		return insideArea;
	}
	/**
	 * 套内面积
	 * @param inside_area
	 */
	public void setInsideArea(BigDecimal insideArea) {
		this.insideArea = insideArea;
	}

	/**
	 * 标准总价
	 * @return
	 */
	public BigDecimal getSumPrice() {
		return sumPrice;
	}
	/**
	 * 标准总价
	 * @param sum_price
	 */
	public void setSumPrice(BigDecimal sumPrice) {
		this.sumPrice = sumPrice;
	}

	/**
	 * 成交总价
	 * @return
	 */
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	/**
	 * 成交总价
	 * @param sale_price
	 */
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	/**
	 * 业务日期
	 * @return
	 */
	public String getWorkDate() {
		return workDate;
	}
	/**
	 * 业务日期
	 * @param work_date
	 */
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	/**
	 * 付款方式
	 * @return
	 */
	public String getPayWay() {
		return payWay;
	}
	/**
	 * 付款方式
	 * @param pay_way
	 */
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	/**
	 * 优惠折扣
	 * @return
	 */
	public String getDiscountPercent() {
		return discountPercent;
	}
	/**
	 * 优惠折扣
	 * @param discount_percent
	 */
	public void setDiscountPercent(String discountPercent) {
		this.discountPercent = discountPercent;
	}

	/**
	 * 客户名称
	 * @return
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * 客户名称
	 * @param customer_name
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
    
}
