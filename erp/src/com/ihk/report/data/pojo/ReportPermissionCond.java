package com.ihk.report.data.pojo;

import java.util.ArrayList;
import java.util.List;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.CompanyProjectPermissionCond;
import com.ihk.permission.PermissionUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SearchCond;

/**
 * 报表数据权限的查询条件
 * 作为父类
 * @author peter.kuang
 *
 */
public class ReportPermissionCond extends CompanyProjectPermissionCond{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int salesId;//销售人员id
	private String strSalesId;//销售人员id
	



	/**
	 * 销售人员id
	 * @return the salesId
	 */
	public int getSalesId() {
		return salesId;
	}
	/**
	 * 销售人员id
	 * @param salesId the salesId to set
	 */
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	/**
	 * 销售人员id
	 * @return
	 */
	public String getStrSalesId() {
		return strSalesId;
	}
	
	/**
	 * 页面控件的类型：销售人员id
	 * @param strSalesId
	 */
	public void setStrSalesId(String strSalesId) {
		this.strSalesId = strSalesId;
		
		try{
			setSalesId(Integer.valueOf(this.strSalesId));
		}
		catch(Exception ex){
			
		}
	}
	
	

	
}
