package com.ihk.utils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 该接口已废弃
 * @author dtc
 * 2012-9-29
 * 
 * 签约 合同 常常统一使用 相当属性统一
 * 
 */
public interface SupperConfirm {
	public int getCustomerId() ;//客户
	
	public String getSalesId();//销售人员
	
	public Date getSignDate();//签署日期

	public BigDecimal getSalePrice();
	
	public String getPayTypeStr();
	
	public BigDecimal getDiscountPercent();
	
	public String getPhone();
	
	public String getCustomerName();
	
	public Date getWorkDate();
}
