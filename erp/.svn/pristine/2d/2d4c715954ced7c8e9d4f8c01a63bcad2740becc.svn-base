package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.util.List;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.SearchCond;

/**
 * ContractCustomer的查询条件
 */
public class ContractCustomerCond extends SearchCond{

	private static final long serialVersionUID = 156083025850654632L;

	/**
	 * 客户类型
	 */
	private String confirmType;
	
	/**
	 * confirmType对应的id
	 */
	private int mainId;
	
	/**
	 * 客户类型对应的表名,1为confirm;2为contract
	 */
	private String confirmTypeName;

	/**
	 * 对应的认购或签约的认购书/合同编号列名,confirm对应的是agree_no;contract对应的是contract_no
	 */
	private String agreeNoName;
	
	/**
	 * 对应的成交或合同的日期,confirm对应的是work_date;contract对应的是sign_date
	 */
	private String realDate;
	
	/**
	 * 客户姓名
	 */
	private String customerName;
	
	/**
	 * 楼栋id
	 */
	private List<Integer> buildIds;
	
	/**
	 * 开始时间
	 */
	private String date1;

	/**
	 * 结束时间
	 */
	private String date2;
	
	/**
	 *公司项目集合 
	 */
	private List<Integer> searchProjectIds;
	
	/**
	 * 公司项目集合的String,用","连接
	 */
	private String searchProjectIdStr;
	
	/**
	 * 公司项目id
	 */
	private String projectId;
	
	/**
	 * 手机号码
	 */
	private String mobilePhone;
	
	/**
	 * 是否作废
	 */
	private String isValid;
	
	private List<Integer> projectIds;
	
	/**
	 * 查询售后列表条件
	 */
	private String searchName;
	
	private String searchPhone;
	
	private String price1; //成交总价
	
	private String price2;
	
	private String area1;  //成交面积
	
	private String area2;
	
	private List<Integer> userIds;  //所属销售 的模糊查询
	
	private String saleName; //所属销售 的值	
	
	private String payType; //付款方式
	
	private String homeProvince; //居住区域省份
	
	private String homeCity; //居住区域市
	
	private String homeRegion; //居住区域区
	
	private String householdProvince; //户籍区域省份
	
	private String householdCity; //户籍区域市
	
	private String householdRegion; //户籍区域区
	
	private String homeContent;
	private String householdContent;
	private String homeProvinceStr;
	private String householdProvinceStr;
	private String homeCityStr;
	private String householdCityStr;
	private String homeRegionStr;	//居住区域
	private String householdRegionStr;	//户籍区域
	
	//用于售后查询
	private List<Integer> homeProvinceIds;
	private List<Integer> householdProvinceIds;
	private List<Integer> homeCityIds;
	private List<Integer> householdCityIds;
	private List<Integer> homeRegionIds;
	private List<Integer> householdRegionIds;
	
	public String getHomeContent() {
		return homeContent;
	}

	public void setHomeContent(String homeContent) {
		this.homeContent = homeContent;
	}

	public String getHouseholdContent() {
		return householdContent;
	}

	public void setHouseholdContent(String householdContent) {
		this.householdContent = householdContent;
	}

	public String getHomeProvinceStr() {
		return homeProvinceStr;
	}

	public void setHomeProvinceStr(String homeProvinceStr) {
		this.homeProvinceStr = homeProvinceStr;
	}

	public String getHouseholdProvinceStr() {
		return householdProvinceStr;
	}

	public void setHouseholdProvinceStr(String householdProvinceStr) {
		this.householdProvinceStr = householdProvinceStr;
	}

	public String getHomeCityStr() {
		return homeCityStr;
	}

	public void setHomeCityStr(String homeCityStr) {
		this.homeCityStr = homeCityStr;
	}

	public String getHouseholdCityStr() {
		return householdCityStr;
	}

	public void setHouseholdCityStr(String householdCityStr) {
		this.householdCityStr = householdCityStr;
	}

	public String getHomeRegionStr() {
		return homeRegionStr;
	}

	public void setHomeRegionStr(String homeRegionStr) {
		this.homeRegionStr = homeRegionStr;
	}

	public String getHouseholdRegionStr() {
		return householdRegionStr;
	}

	public void setHouseholdRegionStr(String householdRegionStr) {
		this.householdRegionStr = householdRegionStr;
	}

	public List<Integer> getHomeProvinceIds() {
		return homeProvinceIds;
	}

	public void setHomeProvinceIds(List<Integer> homeProvinceIds) {
		this.homeProvinceIds = homeProvinceIds;
	}

	public List<Integer> getHouseholdProvinceIds() {
		return householdProvinceIds;
	}

	public void setHouseholdProvinceIds(List<Integer> householdProvinceIds) {
		this.householdProvinceIds = householdProvinceIds;
	}

	public List<Integer> getHomeCityIds() {
		return homeCityIds;
	}

	public void setHomeCityIds(List<Integer> homeCityIds) {
		this.homeCityIds = homeCityIds;
	}

	public List<Integer> getHouseholdCityIds() {
		return householdCityIds;
	}

	public void setHouseholdCityIds(List<Integer> householdCityIds) {
		this.householdCityIds = householdCityIds;
	}

	public List<Integer> getHomeRegionIds() {
		return homeRegionIds;
	}

	public void setHomeRegionIds(List<Integer> homeRegionIds) {
		this.homeRegionIds = homeRegionIds;
	}

	public List<Integer> getHouseholdRegionIds() {
		return householdRegionIds;
	}

	public void setHouseholdRegionIds(List<Integer> householdRegionIds) {
		this.householdRegionIds = householdRegionIds;
	}

	/**
	 * 用户id,利用userId来判断用户身份,不空代表为普通用户,在天銮项目中,管理员进来,可以查找其下的用户的客户,也利用了该字段
	 */
	private String userId; 
	
	private List<Integer> ids; //主键id的集合
	
	private String birthday1;
	
	private String birthday2;
	
	private String createdUserId;//创建者
	
	
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}
	
	public int getMainId() {
		return mainId;
	}
	
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	
	public String getIsValid() {
		return isValid;
	}
	
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectId() {
		return projectId;
	}
	
	public void setSearchProjectIdStr(String searchProjectIdStr) {
		this.searchProjectIdStr = searchProjectIdStr;
	}
	
	public String getSearchProjectIdStr() {
		return searchProjectIdStr;
	}
	
	public void setAgreeNoName(String agreeNoName) {
		this.agreeNoName = agreeNoName;
	}
	
	public String getAgreeNoName() {
		
		if(CommonUtils.isStrEmpty(agreeNoName)){
			
			if(CommonUtils.isStrEmpty(confirmTypeName) || "confirm".equals(confirmTypeName)){
				
				agreeNoName = "agree_no";
			}else{
				
				agreeNoName = "contract_no";
			}
		}
		
		return agreeNoName;
	}
	
	public void setRealDate(String realDate) {
		this.realDate = realDate;
	}
	
	public String getRealDate() {
		if(CommonUtils.isStrEmpty(realDate)){
			
			if(CommonUtils.isStrEmpty(confirmTypeName) || "confirm".equals(confirmTypeName)){
				
				realDate = "work_date";
			}else{
				
				realDate = "sign_date";
			}
		}
		
		return realDate;
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
	
	public List<Integer> getSearchProjectIds() {
		return searchProjectIds;
	}

	public void setSearchProjectIds(List<Integer> asearchProjectIds) {
		this.searchProjectIds = CommonUtils.getListCopy(asearchProjectIds);		
	}

	public String getConfirmTypeName() {
		return confirmTypeName;
	}
	
	public void setConfirmTypeName(String confirmTypeName) {
		this.confirmTypeName = confirmTypeName;
	}
	
	public List<Integer> getBuildIds() {
		return buildIds;
	}
	
	public void setBuildIds(List<Integer> buildIds) {
		this.buildIds = buildIds;
	}

	public String getConfirmType() {
		return confirmType;
	}

	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Integer> getProjectIds() {
		return projectIds;
	}

	public void setProjectIds(List<Integer> projectIds) {
		this.projectIds = projectIds;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchPhone() {
		return searchPhone;
	}

	public void setSearchPhone(String searchPhone) {
		this.searchPhone = searchPhone;
	}

	public String getPrice1() {
		return price1;
	}

	public void setPrice1(String price1) {
		this.price1 = price1;
	}

	public String getPrice2() {
		return price2;
	}

	public void setPrice2(String price2) {
		this.price2 = price2;
	}

	public String getArea1() {
		return area1;
	}

	public void setArea1(String area1) {
		this.area1 = area1;
	}

	public String getArea2() {
		return area2;
	}

	public void setArea2(String area2) {
		this.area2 = area2;
	}

	public List<Integer> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getHouseholdProvince() {
		return householdProvince;
	}

	public void setHouseholdProvince(String householdProvince) {
		this.householdProvince = householdProvince;
	}

	public String getHomeProvince() {
		return homeProvince;
	}

	public void setHomeProvince(String homeProvince) {
		this.homeProvince = homeProvince;
	}

	public String getHouseholdCity() {
		return householdCity;
	}

	public void setHouseholdCity(String householdCity) {
		this.householdCity = householdCity;
	}

	public String getHouseholdRegion() {
		return householdRegion;
	}

	public void setHouseholdRegion(String householdRegion) {
		this.householdRegion = householdRegion;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public String getHomeRegion() {
		return homeRegion;
	}

	public void setHomeRegion(String homeRegion) {
		this.homeRegion = homeRegion;
	}

	public String getBirthday1() {
		return birthday1;
	}

	public void setBirthday1(String birthday1) {
		this.birthday1 = birthday1;
	}

	public String getBirthday2() {
		return birthday2;
	}

	public void setBirthday2(String birthday2) {
		this.birthday2 = birthday2;
	}

	public String getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}



	
	
	
}
