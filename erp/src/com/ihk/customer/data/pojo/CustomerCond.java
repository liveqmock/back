package com.ihk.customer.data.pojo;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.CompanyProjectPermissionCond;
import com.ihk.permission.PermissionUtils;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.IProvinceServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.utils.Md5Security;
import com.ihk.utils.SearchCond;
import com.ihk.utils.SessionUser;
/**
 * Customer的查询条件
 * @author 
 *
 */
public class CustomerCond extends CompanyProjectPermissionCond{

	private static final long serialVersionUID = -3815453437856347917L;

	private String searchName;	//客户姓名
	
	private String searchPhone;  //移动电话
	
	private String eqPhone;  //电话相等
	
	private String date1;
	
	private String date2;
	
	private String state; //客户状态
	
	//private String accountType; //用户的身份,如果为2,表示管理员,可以查找所有的客户,其他的只能查找对应的客户 
	
	/**
	 * 用户id,利用userId来判断用户身份,不空代表为普通用户,在天銮项目中,管理员进来,可以查找其下的用户的客户,也利用了该字段
	 */
	private String userId; 
	
	private String groupField; //分组字段
	
	private List<Integer> ids; //主键id的集合
	
	/**
	 * 
	 * 下面字段为汇景项目使用
	 * 
	 */
	
	private String keyword; //关键字
	
	private String userName; //跟进人员
	
	private String homePhone; //固定电话
	
	private String phoneFrom;
	
	private String rating; //客户评级
	
	private String relationDesc; //是否提及关系户,指关系内容
	
	private int projectId; 
	
	private List<Integer> orProjectIds;//或者是所管理的项目
	
	private String companyId; //恒大及广州中使用
	
	/**
	 * 广州项目使用
	 * 
	 */
	private String priceAmount;//价格区间
	
	private String price1; //意向总价
	
	private String price2;
	
	private String area1;  //意向面积
	
	private String area2;
	
	private String notFollowDay; // 未跟进天数,利用follow_time去处理 
	
	private String requestArea;//需求面积
	
	private String customerSource;//客户来源
	
	private String houseType;//产品类型
	
	private String countRow;//计算那个列的总数
	
	private List<Integer> userIds;  //所属销售 的模糊查询
	
	private String saleName; //所属销售 的值
	
	/**
	 * 从"项目客户比例"跳到"查询客户"页面的销售人员id,在CustomerMapper.xml中没有用到,只是java文件在判断使用
	 */
	private int saleId; //从"项目客户比例"跳到"查询客户"页面的销售人员id,在CustomerMapper.xml中没有用到,只是java文件在判断使用
	
	private String col1; 
	
	private String col2; //交叉分析组合中的分析类型
	
	private CustomerFollowCond followCond; //跟进日期中使用	
	
	private String homeProvince;
	private String workProvince;
	private String homeCity;
	private String workCity;
	private String homeRegion;	//居住区域
	private String workRegion;	//工作区域
	//用于售前查询
	private List<Integer> homeProvinceIds;
	private List<Integer> workProvinceIds;
	private List<Integer> homeCityIds;
	private List<Integer> workCityIds;
	private List<Integer> homeRegionIds;
	private List<Integer> workRegionIds;
	private String homeContent;
	private String workContent;
	private String homeProvinceStr;
	private String workProvinceStr;
	private String homeCityStr;
	private String workCityStr;
	private String homeRegionStr;	//居住区域
	private String workRegionStr;	//工作区域
	private String buyUse;	//购房用途
	private String buyCount;	//置业次数
	private String gender;	//性别
	private String ageRange;	//年龄
	private String familyType;	//家庭结构
	private String familyIncome;	//家庭收入
	private String jobType;	//行业分类
	private String jobIndustry;	//职业
	private String buyAim;	//购房目的
	private String payType;	//付款方式
	private String intentBuynum;	//意向套数
	private String roomType;	//意向户型
	
	private String topicId;
	
	private String customerFocus;
	private String customerKnown;
	
	private int visitCount;
	private String isDeleted;
	private String followTime1;
	private String followTime2;
	
	
	
	public String getFollowTime1() {
		return followTime1;
	}

	public void setFollowTime1(String followTime1) {
		this.followTime1 = followTime1;
	}

	public String getFollowTime2() {
		return followTime2;
	}

	public void setFollowTime2(String followTime2) {
		this.followTime2 = followTime2;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public String getCustomerFocus() {
		return customerFocus;
	}

	public void setCustomerFocus(String customerFocus) {
		this.customerFocus = customerFocus;
	}

	public String getCustomerKnown() {
		return customerKnown;
	}

	public void setCustomerKnown(String customerKnown) {
		this.customerKnown = customerKnown;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

		
	/**
	 * 创建者id 
	 */
	private int createdId;
	
	/**
	 * 只能查看,跟进,不能修改
	 */
	private List<Integer> followIds;
	
	/**
	 * 判断为HOME_DISTRICT或WORK_DISTRICT
	 * 主要用于HighChartsUtils.initCodeDtlListForHomeWorkDistrict()
	 */
	private String homeOrWork;
	
	/**
	 * 来访日期
	 */
	private String visitDate1;
	
	private String visitDate2;

	//////
	
	public String getVisitDate1() {
		return visitDate1;
	}

	public void setVisitDate1(String visitDate1) {
		this.visitDate1 = visitDate1;
	}

	public String getVisitDate2() {
		return visitDate2;
	}

	public void setVisitDate2(String visitDate2) {
		this.visitDate2 = visitDate2;
	}
	
	public void setHomeOrWork(String homeOrWork) {
		this.homeOrWork = homeOrWork;
	}

	public String getHomeOrWork() {
		return homeOrWork;
	}
	
	public void setFollowIds(List<Integer> followIds) {
		this.followIds = followIds;
	}
	
	public List<Integer> getFollowIds() {
		return followIds;
	}
	
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
	
	public int getCreatedId() {
		return createdId;
	}
	
	public void setFollowCond(CustomerFollowCond followCond) {
		this.followCond = followCond;
	}
	
	public CustomerFollowCond getFollowCond() {
		return followCond;
	}
	
	public String getCol1() {
		return col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public String getCol2() {
		return col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public int getSaleId() {
		return saleId;
	}
	
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	
	public String getSaleName() {
		return saleName;
	}
	
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	
	public List<Integer> getUserIds() {
		return userIds;
	}
	
	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}
	
	public String getCountRow() {
		return countRow;
	}

	public void setCountRow(String countRow) {
		this.countRow = countRow;
	}

	public String getPriceAmount() {
		return priceAmount;
	}

	public void setPriceAmount(String priceAmount) {
		this.priceAmount = priceAmount;
	}

	public String getRequestArea() {
		return requestArea;
	}

	public void setRequestArea(String requestArea) {
		this.requestArea = requestArea;
	}

	public String getCustomerSource() {
		return customerSource;
	}

	public void setCustomerSource(String customerSource) {
		this.customerSource = customerSource;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	public String getCompanyId() {
		return companyId;
	}
	
	public void setProjectIds(List<Integer> projectIds) {
		setCompanyProjectIds(projectIds);
	}
	
	public List<Integer> getProjectIds() {
		return getCompanyProjectIds();
	}
	

	public List<Integer> getOrProjectIds() {
		return orProjectIds;
	}

	public void setOrProjectIds(List<Integer> orProjectIds) {
		this.orProjectIds = orProjectIds;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRelationDesc() {
		return relationDesc;
	}

	public void setRelationDesc(String relationDesc) {
		this.relationDesc = relationDesc;
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

	public String getEqPhone() {
		return eqPhone;
	}

	public void setEqPhone(String eqPhone) {
		this.eqPhone = eqPhone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public int getProjectId() {
		return projectId;
	}	
	
	
	public String getGroupField() {
		return groupField;
	}

	public void setGroupField(String groupField) {
		this.groupField = groupField;
	}
	
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public CustomerCond(int projectId) {
		this.projectId = projectId;
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

	public String getNotFollowDay() {
		return notFollowDay;
	}
	
	public void setNotFollowDay(String notFollowDay) {
		this.notFollowDay = notFollowDay;
	}

	/**
	 * 默认设定created_id
	 */
	public CustomerCond() {
		super();
		this.setCreatedId(SessionUser.getUserId());
		
	}

	/////////////
	
	
	
	//利用下面的方法,就不用每次增加字段都要去手工增加
	public String getCacheKey(SearchCond cond){
		
		//String cacheKey = CacheUtils.condToString(cond);
		
		StringBuffer sb = new StringBuffer();
		
		Class<?> clazz = this.getClass();
		Field[] fs = clazz.getDeclaredFields();
		for(Field f : fs){
			String name = f.getName();
			try {
				if(name.equalsIgnoreCase("serialVersionUID"))
					continue;
				
				Object objValue = PropertyUtils.getProperty(this, name);
				sb.append(objValue);
				
			} catch (Exception e){
				
				try{
					Field fi = clazz.getDeclaredField(name); //获取该字段,并设置为可访问
					boolean isCanAccess = fi.isAccessible(); 
					if(!isCanAccess){
						fi.setAccessible(true);
					}
					
					Object objValue = fi.get(this); 
					sb.append(objValue);
					
				}catch(Exception e1){
					e1.printStackTrace();
					//sb.append("null");
				}
			}
		}

		return Md5Security.encString(sb.toString());
	}
	
	
	public String getCacheKey(){
		
		//有待商榷
		String cacheKey = this.searchName+this.searchPhone+this.date1+this.date2+this.state+this.userId+
			this.keyword + this.userName + this.homePhone + this.rating + this.relationDesc + this.projectId + 
			this.companyId + this.getProjectId() + this.priceAmount+this.requestArea+this.customerSource+this.houseType+
			this.area1 + this.area2 + this.notFollowDay +
			getSupperString();
		
		getCacheKey(null);

		return Md5Security.encString(cacheKey);
	}
	
	
	public String getCacheKeyListCount(){
		return getCacheKey()+".listcount";
	}

	/**
	 * 追加能查看的客户分析图表,项目id
	 */
	public void addPermissionChartProjectIds(){
		List<Integer> listIds = PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD);
		if(listIds!=null && listIds.size()>0){
			//表示为管理员
			addPermissionCompanyProjectIds(listIds);
		}
		else{
			setUserId(SessionUser.getUserId()+"");
		}
	}
	
	//跟进权限，追加能查看的项目id
	public void addPermissionProjectIds(){
//		List<Integer> listIds = PermissionUtils.getUserProjectIdList();
//		for(int i=0;i<listIds.size();i++){
//			if(projectIds==null){
//				projectIds = new ArrayList<Integer>();
//			}
//			if(!this.projectIds.contains(listIds.get(i))){
//				this.projectIds.add(listIds.get(i));
//			}
//		}
	}
	

	/**
	 * 页面查询项目的项目id列表
	 * @return
	 * @deprecated
	 */
	public String getStrSearchProjectIds() {
		return getStrSearchCompanyProjectIds();
	}

	/**
	 * 页面查询项目的项目名称列表
	 * @return
	 * @deprecated
	 */
	public String getStrSearchProjectNames() {	
		return getStrSearchCompanyProjectNames();
	}		

	/**
	 * 
	 * @param strSearchProjectIds
	 * @deprecated
	 */
	public void setStrSearchProjectIds(String strSearchProjectIds) {
		setStrSearchCompanyProjectIds(strSearchProjectIds);
	}

	/**
	 * 
	 * @param strSearchProjectNames
	 * @deprecated
	 */
	public void setStrSearchProjectNames(String strSearchProjectNames) {
		setStrSearchCompanyProjectNames(strSearchProjectNames);
	}

	/**
	 * 
	 * @return
	 * @deprecated
	 */
	public List<Integer> getSearchProjectIds() {
		return getSearchCompanyProjectIds();
	}

	/**
	 * 
	 * @return
	 * @deprecated
	 */
	public void setSearchProjectIds(List<Integer> asearchProjectIds) {
		setSearchCompanyProjectIds(asearchProjectIds);
	}

	/**
	 * 
	 * @deprecated
	 * @return
	 */
	public List<Integer> getPrivProjectIds() {
		return getPrivCompanyProjectIds();
	}

	/**
	 * 
	 * @return
	 * @deprecated
	 */
	public void setPrivProjectIds(List<Integer> privProjectIds) {
		setPrivCompanyProjectIds(privProjectIds);
	}

	public String getHomeRegion() {
		return homeRegion;
	}

	public void setHomeRegion(String homeRegion) {
		this.homeRegion = homeRegion;
	}

	public String getWorkRegion() {
		return workRegion;
	}

	public void setWorkRegion(String workRegion) {
		this.workRegion = workRegion;
	}

	public String getBuyUse() {
		return buyUse;
	}

	public void setBuyUse(String buyUse) {
		this.buyUse = buyUse;
	}

	public String getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(String buyCount) {
		this.buyCount = buyCount;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public String getFamilyType() {
		return familyType;
	}

	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}

	public String getFamilyIncome() {
		return familyIncome;
	}

	public void setFamilyIncome(String familyIncome) {
		this.familyIncome = familyIncome;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobIndustry() {
		return jobIndustry;
	}

	public void setJobIndustry(String jobIndustry) {
		this.jobIndustry = jobIndustry;
	}

	public String getBuyAim() {
		return buyAim;
	}

	public void setBuyAim(String buyAim) {
		this.buyAim = buyAim;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getIntentBuynum() {
		return intentBuynum;
	}

	public void setIntentBuynum(String intentBuynum) {
		this.intentBuynum = intentBuynum;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getPhoneFrom() {
		return phoneFrom;
	}

	public void setPhoneFrom(String phoneFrom) {
		this.phoneFrom = phoneFrom;
	}

	public String getHomeProvince() {
		return homeProvince;
	}

	public void setHomeProvince(String homeProvince) {
		this.homeProvince = homeProvince;
	}

	public String getWorkProvince() {
		return workProvince;
	}

	public void setWorkProvince(String workProvince) {
		this.workProvince = workProvince;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public String getWorkCity() {
		return workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}

	public String getHomeContent() {
		return homeContent;
	}

	public void setHomeContent(String homeContent) {
		this.homeContent = homeContent;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}


	@Autowired
	IProvinceServices provinceServices;
	@Autowired
	ICityServices cityServices;
	@Autowired
	IRegionServices regionServices;




	public String getHomeProvinceStr() {
		return homeProvinceStr;
	}

	public void setHomeProvinceStr(String homeProvinceStr) {
		this.homeProvinceStr = homeProvinceStr;
	}

	public String getWorkProvinceStr() {
		return workProvinceStr;
	}

	public void setWorkProvinceStr(String workProvinceStr) {
		this.workProvinceStr = workProvinceStr;
	}

	public String getHomeCityStr() {
		return homeCityStr;
	}

	public void setHomeCityStr(String homeCityStr) {
		this.homeCityStr = homeCityStr;
	}

	public String getWorkCityStr() {
		return workCityStr;
	}

	public void setWorkCityStr(String workCityStr) {
		this.workCityStr = workCityStr;
	}

	public String getHomeRegionStr() {
		return homeRegionStr;
	}

	public void setHomeRegionStr(String homeRegionStr) {
		this.homeRegionStr = homeRegionStr;
	}

	public String getWorkRegionStr() {
		return workRegionStr;
	}

	public void setWorkRegionStr(String workRegionStr) {
		this.workRegionStr = workRegionStr;
	}

	public List<Integer> getHomeProvinceIds() {
		return homeProvinceIds;
	}

	public void setHomeProvinceIds(List<Integer> homeProvinceIds) {
		this.homeProvinceIds = homeProvinceIds;
	}

	public List<Integer> getWorkProvinceIds() {
		return workProvinceIds;
	}

	public void setWorkProvinceIds(List<Integer> workProvinceIds) {
		this.workProvinceIds = workProvinceIds;
	}

	public List<Integer> getHomeCityIds() {
		return homeCityIds;
	}

	public void setHomeCityIds(List<Integer> homeCityIds) {
		this.homeCityIds = homeCityIds;
	}

	public List<Integer> getWorkCityIds() {
		return workCityIds;
	}

	public void setWorkCityIds(List<Integer> workCityIds) {
		this.workCityIds = workCityIds;
	}

	public List<Integer> getHomeRegionIds() {
		return homeRegionIds;
	}

	public void setHomeRegionIds(List<Integer> homeRegionIds) {
		this.homeRegionIds = homeRegionIds;
	}

	public List<Integer> getWorkRegionIds() {
		return workRegionIds;
	}

	public void setWorkRegionIds(List<Integer> workRegionIds) {
		this.workRegionIds = workRegionIds;
	}

	

	
}
