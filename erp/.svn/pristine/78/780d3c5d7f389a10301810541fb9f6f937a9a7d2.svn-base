package com.ihk.mobile.jquery;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContProjectId;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.pojo.CustomerFollow;
import com.ihk.customer.data.services.ICustomerFollowServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.mobile.MobileCustomerUtils;
import com.ihk.utils.onlyfollow.CustomerOnlyFollowUtils;

/**
 * jquery mobile的客户录入action
 * @author dtc
 * 2013-7-23,下午02:56:16
 */
@SuppressWarnings("rawtypes")
public class MobileCustomerAction extends SupperAction{

	private static final long serialVersionUID = 2406588356684571485L;
	
	@Autowired
	ICompanyProjectServices companyProjectServices;
	@Autowired
	ICodeTypeServices codeTypeServices;
	@Autowired
	ICustomerServices customerServices;
	@Autowired
	ICustomerFollowServices customerFollowServices;
	
	/**
	 * 手机客户cond
	 */
	private static final String PHONE_CUSTOMER_COND = "phoneCusCond";
	
	/**
	 * 跳到录入界面
	 * @return
	 * @throws Exception
	 */
	public String toInputCustomer() throws Exception{
		
		init(null);
		
		return "toInputCustomer";
	}
	
	/**
	 * 保存客户
	 * @return
	 * @throws Exception
	 */
	public String inputCustomer() throws Exception{
		
		String ret = "fail";
		
		try{
			
			//先判断该项目的号码是否重复
			List<Customer> list = new ArrayList<Customer>();
			if("2".equals(customer.getCustomerSource())){
				list = DescUtils.getCustomerServices()
						.findCustomerPhoneIsExistsByProjectId(customer.getPhone().trim(), customer.getProjectId() + "");
			}
			
			if(!CommonUtils.isCollectionEmpty(list)){
				//表示已经存在该号码
				
				customer = list.get(0);
				failTitle = ("电话: " + customer.getPhone() + " 已经存在(所属销售:" + customer.getDescUserId() + ")");
				
				boolean isShow = false;
				try{
					isShow = CustomerUtils.isCanShowCustomer(customer.getId());
				}catch (Exception e) {
				}
				
				if(isShow){
					
					failTitle += (",是否查看/跟进?<br/><a data-role='button' href='./m/toUpdate.action?id=" 
							+ customer.getId() + "' data-ajax='false'>查看</a>");
					failTitle += "<a data-role='button' href='./m/toFollow.action?customerId="
							+ customer.getId() + "' data-ajax='false'>跟进</a>";
				}
				
				return ret;
			}
			
			CommonPojoUtils.initPojoCommonFiled(customer);
			customer.setCustomerNo(CustomerUtils.getTmpCustomerNo());
			customer.setUserId(SessionUser.getUserId());
			
			CompanyProject tmpProject = companyProjectServices.findCompanyProjectById(customer.getProjectId());
			
			customer.setCompanyId(tmpProject.getCompanyId());
			customer.setProjectId(tmpProject.getId());
			customer.setTeamId(SessionUser.getSessionUser().getTeamId());
			
			if(CustomerUtils.isStrEmpty(customer.getCustomerState())){
				customer.setCustomerState(CommonUtils.CUSTOMER_STATE_FOLLOW);
			}
			
			customerServices.saveCustomer(customer);
			
			questionSelectOptionHtml = MobileCustomerUtils.getQuestionSelectOptionHtml(customer.getProjectId());
			
			ret = "succ";
		
		}catch (Exception e) {
			e.printStackTrace();
			failTitle = e.getMessage();
		}
		
		return ret;
	}
	
	/**
	 * 跳到查询页面
	 * @return
	 * @throws Exception
	 */
	public String toSearch() throws Exception{
		
		selRating = codeTypeServices.findCodeListForSel(EnumCodeTypeName.RATING, SessionUser.getProjectId(), true);
		selCustomerSource = codeTypeServices.findCodeListForSel(EnumCodeTypeName.CUSTOMER_SOURCE, SessionUser.getProjectId(), true); 
		
		return "toSearch";
	}
	
	/**
	 * 主页查询按钮过来
	 * @return
	 * @throws Exception
	 */
	public String indexSearch() throws Exception{
		
		cusCond = new CustomerCond();
		
		//客户list
		initCusotmerList();
		
		return "indexSearch";
	}
	
	/**
	 * 查询客户
	 * @return
	 * @throws Exception
	 */
	public String search() throws Exception{
		
		HttpSession session = request.getSession();
		
		//判断是查询条件过来,还是分页
		if(cusCond == null){
			
			Object obj = session.getAttribute(PHONE_CUSTOMER_COND);
			if(obj == null){
				//表示分页,且没使用查询条件
				cusCond = new CustomerCond();
			}else{
				//使用了查询条件
				cusCond = (CustomerCond) obj;
			}
		}
		
		//跟进日期followTime1,followTime2
		
		//客户list
		initCusotmerList();
		
		//session保存查询条件,供分页使用
		session.setAttribute(PHONE_CUSTOMER_COND, cusCond);
		
		return "search";
		
	}
	
	/**
	 * 设置客户list
	 * @throws Exception
	 */
	private void initCusotmerList() throws Exception{
		
		//设定能查看的权限
		List<Integer> projectIds = PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD);

		if(!CommonUtils.isCollectionEmpty(projectIds)){
			
			//表示为有多个项目的人员，增加能跟进不能修改的客户的判断(管理员是可以忽略的)
			cusCond.setProjectIds(projectIds);

		}else{

			//表示为普通录入人员,但要增加能跟进不能修改的客户的判断
			int sessionUserId = SessionUser.getUserId();
			cusCond.setUserId(sessionUserId+"");

			List<Integer> followUserIds = CustomerOnlyFollowUtils.getFollowCustomerIds();
			cusCond.setFollowIds(followUserIds);

		}
		
		//增加created_id
		if(cusCond.getProjectId() <= 0){
			cusCond.setCreatedId(SessionUser.getUserId());
		}else{
			cusCond.setCreatedId(0);
		}
		
		//设置页数
		currentPage = 1;
		
		String page = request.getParameter("p");
		if(CommonUtils.isIntString(page) && Integer.parseInt(page) > 0){
			
			currentPage = Integer.parseInt(page);
		}
		
		cusCond.pageSize = 10;
		cusCond.startLine = (currentPage - 1) * 10;
		
		cusList = customerServices.findCustomerForMobile(cusCond);
		int recordCount = customerServices.findCustomerCount(cusCond);
		
		pageCount = recordCount / pageSize + (recordCount % 10 == 0 ? 0 : 1);
		
		//是否有查看电话的权限
		boolean isTel = false;
		if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER_RETRIEVE_TEL, EnumDevFlag.GUANGZHOU)){
			
			isTel = true;
		}
		request.setAttribute("isTel", isTel);
		
	}
	
	/**
	 * 跳到修改界面
	 * @return
	 * @throws Exception
	 */
	public String toUpdate() throws Exception{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		customer = customerServices.getCustomerById(id);
		
		init(customer);
		
		//是否销售
		boolean isSale = PermissionUtils.isReportOnlySale();
		request.setAttribute("isSale", isSale);
		
		//是否超过24小时
		boolean isTwentyFourLater = CommonUtils.is24HoursLater(customer.getCreatedTime());
		request.setAttribute("isTwentyFourLater", isTwentyFourLater);
		
		//是否有查看电话的权限
		boolean isTel = false;
		if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER_RETRIEVE_TEL, EnumDevFlag.GUANGZHOU)){
			
			isTel = true;
		}
		request.setAttribute("isTel", isTel);
		
		return "toUpdate";
	}
	
	/**
	 * 修改客户
	 * @return
	 * @throws Exception
	 */
	public String updateCustomer() throws Exception{
		
		String ret = "fail";
		
		try{
			
			//修改前的客户
			Customer oldCustomer = customerServices.getCustomerById(customer.getId());
			
			//先判断该项目的号码是否重复
			List<Customer> list = new ArrayList<Customer>();
			if("2".equals(customer.getCustomerSource())){
				list = DescUtils.getCustomerServices()
						.findCustomerPhoneIsExistsByProjectId(customer.getPhone().trim(), oldCustomer.getProjectId() + "");
			}
			if(!CommonUtils.isCollectionEmpty(list)){
				//表示已经存在该号码
				
				if(!customer.getPhone().equals(oldCustomer.getPhone())){
					//表示修改了手机
					
					Customer haveCustomer = list.get(0);
					
					failTitle = ("电话: " + haveCustomer.getPhone() + " 已经存在(所属销售:" + haveCustomer.getDescUserId() + ")");
					
					boolean isShow = CustomerUtils.isCanShowCustomer(haveCustomer.getId());
					if(isShow){
						
						failTitle += (",是否查看/跟进?<br/><a data-role='button' href='./m/toUpdate.action?id=" 
								+ haveCustomer.getId() + "' data-ajax='false'>查看</a>");
						failTitle += "<a data-role='button' href='./m/toFollow.action?customerId="
								+ haveCustomer.getId() + "' data-ajax='false'>跟进</a>";
						
						oldFollow = initOldFollow(haveCustomer);
					}
					
					return ret;
				}
				
			}
			
			oldCustomer.setCustomerName(customer.getCustomerName());
			oldCustomer.setRating(customer.getRating());
			
			oldCustomer.setVisitDate(customer.getVisitDate());
			oldCustomer.setPhone(customer.getPhone());
			oldCustomer.setHomePhone(customer.getHomePhone());
			
			oldCustomer.setHomeProvince(customer.getHomeProvince());
			oldCustomer.setHomeCity(customer.getHomeCity());
			oldCustomer.setHomeRegion(customer.getHomeRegion());
			oldCustomer.setHomeContent(customer.getHomeContent());
			
			oldCustomer.setWorkProvince(customer.getWorkProvince());
			oldCustomer.setWorkCity(customer.getWorkCity());
			oldCustomer.setWorkRegion(customer.getWorkRegion());
			oldCustomer.setWorkContent(customer.getWorkContent());
			
			oldCustomer.setBuyUse(customer.getBuyUse());
			oldCustomer.setBuyCount(customer.getBuyCount());
			oldCustomer.setPriceNum(customer.getPriceNum());
			
			oldCustomer.setHouseType(customer.getHouseType());
			oldCustomer.setCustomerSource(customer.getCustomerSource());
			oldCustomer.setAreaNum(customer.getAreaNum());
			
			oldCustomer.setModId(SessionUser.getUserId());
			oldCustomer.setModTime(new Date());
			
			customerServices.updateCustomer(oldCustomer);
			
			ret = "succ";
		
		}catch (Exception e) {
			e.printStackTrace();
			failTitle = e.getMessage();
		}
		
		return ret;
		
	}
	
	/**
	 * 初始化下拉框等,如果customer为null,表示新增
	 * @param customer
	 */
	private void init(Customer customer){
		
		if(SessionUser.getCompanyId() == 32){
			//中山公司
			isZhongShan = true;
		}else{
			
			isZhongShan = false;
		}
		
		projectList = companyProjectServices.findCompanyProjectsByCompanyId(SessionUser.getCompanyId());
		
		selRating = codeTypeServices.findCodeListForSel(EnumCodeTypeName.RATING, SessionUser.getProjectId(), true);
		selBuyUse = codeTypeServices.findCodeListForSel(EnumCodeTypeName.BUY_AIM, SessionUser.getProjectId(), true); 
		selFamilyIncome = codeTypeServices.findCodeListForSel(EnumCodeTypeName.FAMILY_INCOME, SessionUser.getProjectId(), true); 
		
		selBuyCount = codeTypeServices.findCodeListForSel(EnumCodeTypeName.BUY_COUNT, SessionUser.getProjectId(), true); 
		selHouseType = codeTypeServices.findCodeListForSel(EnumCodeTypeName.HOUSE_TYPE, SessionUser.getProjectId(), true); 
		selCustomerSource = codeTypeServices.findCodeListForSel(EnumCodeTypeName.CUSTOMER_SOURCE, SessionUser.getProjectId(), true); 
		
		selProvince = MobileCustomerUtils.initSelProvince();
		
		if(customer == null){
			//新增
			
			project = companyProjectServices.findCompanyProjectById(SessionUser.getProjectId());
			
			selHomeCity = MobileCustomerUtils.initSelCity(project.getProvinceId());
			selHomeRegion = MobileCustomerUtils.initSelRegion(project.getCityId());
			
			selWorkCity = MobileCustomerUtils.initSelCity(project.getProvinceId());
			selWorkRegion = MobileCustomerUtils.initSelRegion(project.getCityId());
			
		}else{
			//更新
			
			selHomeCity = MobileCustomerUtils.initSelCity(customer.getHomeProvince());
			selHomeRegion = MobileCustomerUtils.initSelRegion(customer.getHomeCity());
			
			selWorkCity = MobileCustomerUtils.initSelCity(customer.getWorkProvince());
			selWorkRegion = MobileCustomerUtils.initSelRegion(customer.getWorkCity());
			
		}
	}
	
	/**
	 * 初始化历史跟进html
	 * @param customer
	 * @return
	 */
	private String initOldFollow(Customer customer){
		
		LinkedHashMap followTypes = codeTypeServices.findCodeListForSel(EnumCodeTypeName.FOLLOW_TYPE, ContProjectId.GUANG_ZHOU);
		
		List<CustomerFollow> follows = new ArrayList<CustomerFollow>();
		try{
			follows = customerFollowServices.findCustomerFollowByCustomerIdForIndex(customer.getId());
		}catch(Exception e){
		}
		
		if(follows.size() > 3){
			follows = follows.subList(0, 3);
		}
		
		String data = CustomerUtils.getFollowTypeHtml(followTypes, follows, customer);
		
		return data;
	}
	
	////
	/**
	 * 项目下拉框
	 */
	private List<CompanyProject> projectList;
	
	/**
	 * 客户评级,根据项目获取
	 */
	private LinkedHashMap selRating;
	
	/**
	 * 购房用途
	 */
	private LinkedHashMap selBuyUse;
	
	/**
	 * 家庭收入,根据项目获取
	 */
	private LinkedHashMap selFamilyIncome;
	
	/**
	 * 置业次数
	 */
	private LinkedHashMap selBuyCount;
	
	/**
	 * 产品类型
	 */
	private LinkedHashMap selHouseType;
	
	/**
	 * 客户来源
	 */
	private LinkedHashMap selCustomerSource;
	
	/**
	 * 用户所属的项目
	 */
	private CompanyProject project;
	
	/**
	 * 问卷下拉框html
	 */
	private String questionSelectOptionHtml;
	
	/**
	 * 客户
	 */
	private Customer customer;
	
	/**
	 * 保存失败提示
	 */
	private String failTitle;
	
	/**
	 * 客户列表
	 */
	private List<Customer> cusList;
	
	/**
	 * 当前页
	 */
	private int currentPage;
	
	/**
	 * 总页数
	 */
	private int pageCount;
	
	/**
	 * 历史跟进内容
	 */
	private String oldFollow;
	
	/**
	 * 客户cond
	 */
	private CustomerCond cusCond;
	
	/**
	 * 判断是否中山公司
	 */
	private boolean isZhongShan;
	
	public boolean getIsZhongShan() {
		return isZhongShan;
	}

	public void setZhongShan(boolean isZhongShan) {
		this.isZhongShan = isZhongShan;
	}

	public void setCusCond(CustomerCond cusCond) {
		this.cusCond = cusCond;
	}
	
	public CustomerCond getCusCond() {
		return cusCond;
	}
	
	public void setOldFollow(String oldFollow) {
		this.oldFollow = oldFollow;
	}
	
	public String getOldFollow() {
		return oldFollow;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public int getPageCount() {
		return pageCount;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCusList(List<Customer> cusList) {
		this.cusList = cusList;
	}
	
	public List<Customer> getCusList() {
		return cusList;
	}
	
	public void setFailTitle(String failTitle) {
		this.failTitle = failTitle;
	}
	
	public String getFailTitle() {
		return failTitle;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setQuestionSelectOptionHtml(String questionSelectOptionHtml) {
		this.questionSelectOptionHtml = questionSelectOptionHtml;
	}
	
	public String getQuestionSelectOptionHtml() {
		return questionSelectOptionHtml;
	}
	
	public LinkedHashMap getSelBuyCount() {
		return selBuyCount;
	}

	public void setSelBuyCount(LinkedHashMap selBuyCount) {
		this.selBuyCount = selBuyCount;
	}

	public LinkedHashMap getSelHouseType() {
		return selHouseType;
	}

	public void setSelHouseType(LinkedHashMap selHouseType) {
		this.selHouseType = selHouseType;
	}

	public LinkedHashMap getSelCustomerSource() {
		return selCustomerSource;
	}

	public void setSelCustomerSource(LinkedHashMap selCustomerSource) {
		this.selCustomerSource = selCustomerSource;
	}

	public LinkedHashMap getSelFamilyIncome() {
		return selFamilyIncome;
	}

	public void setSelFamilyIncome(LinkedHashMap selFamilyIncome) {
		this.selFamilyIncome = selFamilyIncome;
	}

	public LinkedHashMap getSelBuyUse() {
		return selBuyUse;
	}

	public void setSelBuyUse(LinkedHashMap selBuyUse) {
		this.selBuyUse = selBuyUse;
	}

	public void setProject(CompanyProject project) {
		this.project = project;
	}
	
	public CompanyProject getProject() {
		return project;
	}
	
	private Map<String, String> selProvince; //省
	private Map<String, String> selHomeCity; //居住市
	private Map<String, String> selHomeRegion; //居住区域
	private Map<String, String> selWorkCity; //工作市
	private Map<String, String> selWorkRegion; //工作区域
	
	public Map<String, String> getSelProvince() {
		return selProvince;
	}

	public void setSelProvince(Map<String, String> selProvince) {
		this.selProvince = selProvince;
	}

	public Map<String, String> getSelHomeCity() {
		return selHomeCity;
	}

	public void setSelHomeCity(Map<String, String> selHomeCity) {
		this.selHomeCity = selHomeCity;
	}

	public Map<String, String> getSelHomeRegion() {
		return selHomeRegion;
	}

	public void setSelHomeRegion(Map<String, String> selHomeRegion) {
		this.selHomeRegion = selHomeRegion;
	}

	public Map<String, String> getSelWorkCity() {
		return selWorkCity;
	}

	public void setSelWorkCity(Map<String, String> selWorkCity) {
		this.selWorkCity = selWorkCity;
	}

	public Map<String, String> getSelWorkRegion() {
		return selWorkRegion;
	}

	public void setSelWorkRegion(Map<String, String> selWorkRegion) {
		this.selWorkRegion = selWorkRegion;
	}

	public LinkedHashMap getSelRating() {
		return selRating;
	}
	
	public void setSelRating(LinkedHashMap selRating) {
		this.selRating = selRating;
	}

	public List<CompanyProject> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<CompanyProject> projectList) {
		this.projectList = projectList;
	}
	
}
