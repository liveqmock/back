package com.ihk.property.data.pojo;

import java.util.ArrayList;
import java.util.List;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.CompanyProjectPermissionCond;
import com.ihk.permission.PermissionUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SearchCond;

/**
 * PropertyUnitCond的查询条件
 * @author peter.kuang
 * 20130731修改extends CompanyProjectPermissionCond peter
 *
 */
public class PropertyUnitCond extends CompanyProjectPermissionCond{

	private static final long serialVersionUID = 1L;
	
	//private String salesId; 
	
	private String buildId;
	private List<Integer> builIds;//用来查询pro
	private String unitNo;//模糊查询
	private String buildName;//模糊查询
	private List<Integer> ids;
	
	private String orientation;//朝向
	private String realBuildArea1;//建筑面积
	private String realBuildArea2;//建筑面积
	
	private String buildPrice1;//建筑单价
	private String buildPrice2;//建筑单价
	private String floorNum ;//楼层
	
	/**
	 *	预约,认购,合同 向导式新建第一步要用到 
	 */
	private String propertyName;
	private String propertyId;
	private String areaId;
	private List<Integer> buildIds;
	
	private String saleState;
	private int companyProjectId;

    //销售中心-列表-搜索用
    private String payName; //付款方式名称
    private String confirmDate; //认购日期
    private String sales; //销售人员

    private String checkFeeDate;
    private String repayType; //回款类型

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public String getCheckFeeDate() {
        return checkFeeDate;
    }

    public void setCheckFeeDate(String checkFeeDate) {
        this.checkFeeDate = checkFeeDate;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(String confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
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
	
	/**
	 * 公司项目ID
	 */
	private int projectId;

	private String date1;
	
	private String date2;
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public void setBuildIds(List<Integer> buildIds) {
		this.buildIds = CommonUtils.getListCopy(buildIds);
	}
	
	public List<Integer> getBuildIds() {
		return buildIds;
	}
	
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getDescPropertyId(){
		if(propertyId == null || propertyId.equals("") || propertyId.equals("0"))return "";
		return DescUtils.findPropertyNameById(Integer.parseInt(propertyId));
	}	
	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getFloorNum() {
		return floorNum;
	}

	public void setFloorNum(String floorNum) {
		this.floorNum = floorNum;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getBuildId() {
		return buildId;
	}

	public PropertyUnitCond setBuildId(String buildId) {
		this.buildId = buildId;
		return this;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids =CommonUtils.getListCopy( ids);
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getRealBuildArea1() {
		return realBuildArea1;
	}

	public void setRealBuildArea1(String realBuildArea1) {
		this.realBuildArea1 = realBuildArea1;
	}

	public String getRealBuildArea2() {
		return realBuildArea2;
	}

	public void setRealBuildArea2(String realBuildArea2) {
		this.realBuildArea2 = realBuildArea2;
	}

	public String getBuildPrice1() {
		return buildPrice1;
	}

	public void setBuildPrice1(String buildPrice1) {
		this.buildPrice1 = buildPrice1;
	}

	public String getBuildPrice2() {
		return buildPrice2;
	}

	public void setBuildPrice2(String buildPrice2) {
		this.buildPrice2 = buildPrice2;
	}

	public List<Integer> getBuilIds() {
		return builIds;
	}

	public void setBuilIds(List<Integer> builIds) {
		this.builIds =CommonUtils.getListCopy(builIds);
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
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
	
//	/**
//	 * @deprecated
//	 * @return
//	 */
//	public List<Integer> getPrivProjectIds(){
//		return getPrivCompanyProjectIds();
//	}
//
	/**
	 * @deprecated
	 * @return
	 */
	public void setSearchProjectIds(List<Integer> pids){
		setSearchCompanyProjectIds(pids);
	}
//
//	/**
//	 * @deprecated
//	 * @return
//	 */
//	public void addPermissionProjectIds(){
//		addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.SALEUNIT_CENTER_RETRIEVE));
//	}
//
	/**
	 * @deprecated
	 * @return
	 */
	public List<Integer> getSearchProjectIds(){
		return getSearchCompanyProjectIds();
	}

	/**
	 * @deprecated
	 * @return
	 */
	public String getStrSearchProjectIds(){
		return getStrSearchCompanyProjectIds();
	}

	/**
	 * @deprecated
	 * @return
	 */
	public void setStrSearchProjectIds(String ids){
		setStrSearchCompanyProjectIds(ids);
	}

	/**
	 * @deprecated
	 * @return
	 */
	public String getStrSearchProjectNames(){
		return getStrSearchCompanyProjectNames();
	}

	/**
	 * @deprecated
	 * @return
	 */
	public void setStrSearchProjectNames(String names){
		setStrSearchCompanyProjectNames(names);
	}
	
}
