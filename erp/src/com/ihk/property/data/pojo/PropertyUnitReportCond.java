package com.ihk.property.data.pojo;

import java.util.List;

import com.ihk.permission.CompanyProjectPermissionCond;
import com.ihk.utils.SearchCond;

/**
 * PropertyUnitCond的查询条件
 * @author peter.kuang
 *
 */
public class PropertyUnitReportCond extends CompanyProjectPermissionCond{

	private static final long serialVersionUID = 1L;
	
	private String date1;
	private String date2;
	private String date11;
	private String date22;
	private String date3;
	private String date4;
	private String date33;
	private String date44;
	private List<String> saleStates;
	private int companyProjectId;
	private String saleState;
	private List<Integer> companyProjectIds;
	private int limit1;
	private int limit2;
	private String userId;
	
	
	
	public String getDate11() {
		return date11;
	}

	public void setDate11(String date11) {
		this.date11 = date11;
	}

	public String getDate22() {
		return date22;
	}

	public void setDate22(String date22) {
		this.date22 = date22;
	}

	public String getDate33() {
		return date33;
	}

	public void setDate33(String date33) {
		this.date33 = date33;
	}

	public String getDate44() {
		return date44;
	}

	public void setDate44(String date44) {
		this.date44 = date44;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getLimit1() {
		return limit1;
	}

	public void setLimit1(int limit1) {
		this.limit1 = limit1;
	}

	public int getLimit2() {
		return limit2;
	}

	public void setLimit2(int limit2) {
		this.limit2 = limit2;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public int getCompanyProjectId() {
		return companyProjectId;
	}

	public void setCompanyProjectId(int companyProjectId) {
		this.companyProjectId = companyProjectId;
	}

	public String getSaleState() {
		return saleState;
	}

	public void setSaleState(String saleState) {
		this.saleState = saleState;
	}

	public List<String> getSaleStates() {
		return saleStates;
	}

	public void setSaleStates(List<String> saleStates) {
		this.saleStates = saleStates;
	}

	public List<Integer> getCompanyProjectIds() {
		return companyProjectIds;
	}

	public void setCompanyProjectIds(List<Integer> companyProjectIds) {
		this.companyProjectIds = companyProjectIds;
	}

	public String getDate3() {
		return date3;
	}

	public void setDate3(String date3) {
		this.date3 = date3;
	}

	public String getDate4() {
		return date4;
	}

	public void setDate4(String date4) {
		this.date4 = date4;
	}
}
