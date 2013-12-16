package com.ihk.sale.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.pojo.CustomerFollow;
import com.ihk.customer.data.pojo.RecommendRoom;
import com.ihk.customer.data.services.ICustomerFollowServices;
import com.ihk.customer.data.services.ICustomerKnownServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.customer.data.services.IRecommendRoomServices;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

/**
 *  恒大客户列表
 */
@SuppressWarnings("rawtypes")
public class CustomerIndexAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICustomerServices customerServices;  //spring的注解,自动引入set,get方法
	@Autowired
	ICustomerFollowServices customerFollowServices;
	@Autowired
	ICustomerKnownServices customerKnownServices;
	@Autowired
	IRecommendRoomServices recommendRoomServices;
	@Autowired
	ICodeTypeServices codeTypeServices;
	@Autowired
	IUserAccountServices userAccountServices;
	
	@SuppressWarnings("unchecked")
	public String customerIndex() throws Exception{
		
		String from = request.getParameter("from");  //按条件搜索时就为空
		boolean isGet = false;
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(CommonUtils.USER_SESSION_KEY);
		if(obj == null){
			//如果没有数据就跳回登陆界面
			return "loginFail";
		}
		
		UserAccount user = (UserAccount) obj;
		String type = user.getAccountType();
		session.setAttribute("type", type);  //type为用户身份2为管理员,其他为普通用户
		
		String action = CustomerUtils.getActionNameFromRequest(request);
		Pager page = new Pager(ActionContext.getContext(),pageSize,action);
		
		List<Integer> userProjectIds = HengDaUtils.getUserProjects();
		
		if("left".equals(from)){
			//点击左边或顶上的"查询客户"
			session.removeAttribute("customerCond"); //清空该session
			customerCond = new CustomerCond(); 
			
			customerCond.setProjectIds(userProjectIds);
			
		}else{
			
			Map<String, String[]> map = request.getParameterMap();
			if(map.containsKey("ob") || "return".equals(from)){
				//表示点击了排序, 返回
				Object getCond = session.getAttribute("customerCond");
				customerCond = (CustomerCond) getCond;
				
			}
			
			if(customerCond == null){ //登陆
				customerCond = new CustomerCond();
				
			}
			
			String getCompanyId = customerCond.getCompanyId();
			String getProjectId = customerCond.getProjectId() + "";
			
			if(CustomerUtils.isStrEmpty(getCompanyId) && "0".equals(getProjectId)){
				//没有选公司,没有选项目
				
				customerCond.setProjectIds(userProjectIds);
			}
			
			if(!CustomerUtils.isStrEmpty(getCompanyId) && "0".equals(getProjectId)){
				//选择了公司,没有选项目
				
				customerCond.setProjectIds(HengDaUtils.getProjectsByCompanyIdForHengDa(Integer.parseInt(getCompanyId)));
			}
			
			if(!CustomerUtils.isStrEmpty(getCompanyId) && !"0".equals(getProjectId)){
				//选择了公司,选择了项目
				List<Integer> setList = new ArrayList<Integer>();
				setList.add(Integer.parseInt(getProjectId));
				
				customerCond.setProjectIds(setList);
			}
			
			session.setAttribute("companyId", getCompanyId);
			session.setAttribute("projectId", getProjectId);
			
		}
		
		if(CustomerUtils.isStrEmpty(customerCond.getCompanyId())){
			isGet = true;
		}
		
		if(!CommonUtils.ADMIN.equals(type)){
			customerCond.setUserId(user.getId() + ""); //此处如果userId不为空，表示为普通用户
		}
		
		page.setCond(customerCond);
		customerList = customerServices.findCustomerSearch(customerCond); 
		
		session.setAttribute("customerCond", customerCond);   //供查找返回及下载使用
		
		initSelCompany();
		initSelProject(isGet);
		
		initCustomerState();
		selCustomerState.put(CommonUtils.CUSTOMER_STATE_ALL, CommonUtils.ALL);
		this.setShowPage(page.toHtmlString());
		
		return "customerIndex";
	}
	
	
	//
	private List<Customer> customerList;
	private UserAccount userAccount;	
	private Customer customer;
	private CustomerFollow customerFollow;
	private CustomerCond customerCond;  //userId, projectId 一定要有值
	
	RecommendRoom recRoom1; //所选单位1
	RecommendRoom recRoom2; //所选单位2
	RecommendRoom recRoom3; //所选单位3
		
	private LinkedHashMap selGender; 
	private LinkedHashMap selAgeRange; 	
	private LinkedHashMap selJobType; 	
	private LinkedHashMap selCustomerRegion; 	
	private LinkedHashMap selKnownFrom; 	
	private LinkedHashMap selRequestArea; 	
	private LinkedHashMap selRoomType; 	
	private LinkedHashMap selPriceAmount; 	
	private LinkedHashMap selBuyAim; 
	private LinkedHashMap selPayType; 
	private LinkedHashMap selCustomerState; //跟进状态
	private LinkedHashMap selIntentionPart; //汇景中的意向单元
	private LinkedHashMap selRating; //汇景中的客户初步评价	
	private LinkedHashMap selFirstHour; //天銮项目中的首次首次到场时间hour
	private LinkedHashMap selIntentLease; //汇景国际中的意向租期
	private LinkedHashMap selPayBy; //汇景国际中的租金支付
	
	private LinkedHashMap<String, String> selUserForTianLuan; //天銮中的所属用户
	
	private LinkedHashMap<String, String> selCompany;
	private LinkedHashMap<String, String> selProject;
	
	private String suggestion; //操作提示
	
	private List<String> knowns;
	
	private int getProjectId(){
		//管理员根据参数来设定projectId
		/*if(SessionUser.isAdmin()){
			//参数也是需要能够被管理project,才是合法projectId
			return 2;
		}
		else{
		//一般用户以账号的projectId设定projectId
			return SessionUser.getProjectId();
		}*/
		//return SessionUser.getProjectId();
		
		return HengDaUtils.getCRMCodeProjectId();
				
	}
	
	public void setSelProject(LinkedHashMap<String, String> selProject) {
		this.selProject = selProject;
	}
	
	public LinkedHashMap<String, String> getSelProject() {
		return selProject;
	}
	
	private void initSelProject(boolean isGet){
		selProject = new LinkedHashMap<String, String>();
		
		selProject.put("", CommonUtils.ALL);
		
		if(!isGet){
			selProject = HengDaUtils.getProjectsByCompanyId(Integer.parseInt(customerCond.getCompanyId()));
		}
		
	}
	
	public void setSelCompany(LinkedHashMap<String, String> selCompany) {
		this.selCompany = selCompany;
	}
	
	public LinkedHashMap<String, String> getSelCompany() {
		return selCompany;
	}
	
	private void initSelCompany(){
		selCompany = HengDaUtils.getSelCompany();
	}
	
	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
		request.getSession().setAttribute("suggestion", suggestion);  //在汇景中跳转后也可以拿到
	}

	public void setKnowns(List<String> knowns) {
		this.knowns = knowns;
	}
	
	public List<String> getKnowns() {
		return knowns;
	}
	
	public LinkedHashMap getSelGender() { 
		return selGender; 
	} 
	
	public void setSelGender(LinkedHashMap selGender) { 
		this.selGender = selGender; 
	} 
    
	public void initGender() {  
		if(this.selGender==null){
			this.selGender = codeTypeServices.findCodeListForSel(EnumCodeTypeName.GENDER,getProjectId());
		}
	} 
	
	public LinkedHashMap getSelAgeRange() { 
		return selAgeRange; 
	} 
	
	public void setSelAgeRange(LinkedHashMap selAgeRange) { 
		this.selAgeRange = selAgeRange; 
	} 
    
	public void initAgeRange() {  
		if(this.selAgeRange==null){
			this.selAgeRange = codeTypeServices.findCodeListForSel(EnumCodeTypeName.AGE_RANGE,getProjectId());
		}
	} 

	public LinkedHashMap getSelJobType() { 
		return selJobType; 
	} 
	
	public void setSelJobType(LinkedHashMap selJobType) { 
		this.selJobType = selJobType; 
	} 
    
	public void initJobType() {  
		if(this.selJobType==null){
			this.selJobType = codeTypeServices.findCodeListForSel(EnumCodeTypeName.JOB_TYPE,getProjectId());
		}
	} 

	public LinkedHashMap getSelCustomerRegion() { 
		return selCustomerRegion; 
	} 
	
	public void setSelCustomerRegion(LinkedHashMap selCustomerRegion) { 
		this.selCustomerRegion = selCustomerRegion; 
	} 
    
	public void initCustomerRegion() {  
		if(this.selCustomerRegion==null){
			this.selCustomerRegion = codeTypeServices.findCodeListForSel(EnumCodeTypeName.CUSTOMER_REGION,getProjectId());
		}
	} 

	public LinkedHashMap getSelKnownFrom() { 
		return selKnownFrom; 
	} 
	
	public void setSelKnownFrom(LinkedHashMap selKnownFrom) { 
		this.selKnownFrom = selKnownFrom; 
	} 
    
	public void initKnownFrom() {  
		if(this.selKnownFrom==null){
			this.selKnownFrom = codeTypeServices.findCodeListForSel(EnumCodeTypeName.KNOWN_FROM,getProjectId());
		}
	} 

	public LinkedHashMap getSelRequestArea() { 
		return selRequestArea; 
	} 
	
	public void setSelRequestArea(LinkedHashMap selRequestArea) { 
		this.selRequestArea = selRequestArea; 
	} 
    
	public void initRequestArea() {  
		if(this.selRequestArea==null){
			this.selRequestArea = codeTypeServices.findCodeListForSel(EnumCodeTypeName.REQUEST_AREA,getProjectId());
		}
	} 

	public LinkedHashMap getSelRoomType() { 
		return selRoomType; 
	} 
	
	public void setSelRoomType(LinkedHashMap selRoomType) { 
		this.selRoomType = selRoomType; 
	} 
    
	public void initRoomType() {  
		if(this.selRoomType==null){
			this.selRoomType = codeTypeServices.findCodeListForSel(EnumCodeTypeName.ROOM_TYPE,getProjectId());
		}
	} 

	public LinkedHashMap getSelPriceAmount() { 
		return selPriceAmount; 
	} 
	
	public void setSelPriceAmount(LinkedHashMap selPriceAmount) { 
		this.selPriceAmount = selPriceAmount; 
	} 
    
	public void initPriceAmount() {  
		if(this.selPriceAmount==null){
			this.selPriceAmount = codeTypeServices.findCodeListForSel(EnumCodeTypeName.PRICE_AMOUNT,getProjectId());
		}
	} 

	public LinkedHashMap getSelBuyAim() { 
		return selBuyAim; 
	} 
	
	public void setSelBuyAim(LinkedHashMap selBuyAim) { 
		this.selBuyAim = selBuyAim; 
	} 
    
	public void initBuyAim() {  
		if(this.selBuyAim==null){
			this.selBuyAim = codeTypeServices.findCodeListForSel(EnumCodeTypeName.BUY_AIM,getProjectId());
		}
	} 
	

	public LinkedHashMap getSelPayType() { 
		return selPayType; 
	} 
	
	public void setSelPayType(LinkedHashMap selPayType) { 
		this.selPayType = selPayType; 
	} 
    
	public void initPayType() {  
		if(this.selPayType==null){
			this.selPayType = codeTypeServices.findCodeListForSel(EnumCodeTypeName.PAY_TYPE,getProjectId());
		}
	} 
	
	public LinkedHashMap getSelCustomerState() {
		return selCustomerState;
	}

	public void setSelCustomerState(LinkedHashMap selCustomerState) {
		this.selCustomerState = selCustomerState;
	}
	
	public void initCustomerState() {  
		if(this.selCustomerState==null){
			this.selCustomerState = codeTypeServices.findCodeListForSelAll(EnumCodeTypeName.CUSTOMER_STATE,getProjectId());
		}
	} 
	
	public LinkedHashMap getSelIntentionPart() {
		return selIntentionPart;
	}
	
	public void setSelIntentionPart(LinkedHashMap selIntentionPart) {
		this.selIntentionPart = selIntentionPart;
	}
	
	public void initSelIntentionPart() {  
		if(this.selIntentionPart==null){
			this.selIntentionPart = codeTypeServices.findCodeListForSel(EnumCodeTypeName.INTENTION_PART,getProjectId());
		}
	} 
	
	public LinkedHashMap getSelRating() {
		return selRating;
	}
	
	public void setSelRating(LinkedHashMap selRating) {
		this.selRating = selRating;
	}
	
	public void initSelRating() {  
		if(this.selRating==null){
			this.selRating = codeTypeServices.findCodeListForSel(EnumCodeTypeName.RATING,getProjectId());
		}
	} 
	
	public void setSelUserForTianLuan(
			LinkedHashMap<String, String> selUserForTianLuan) {
		this.selUserForTianLuan = selUserForTianLuan;
	}
	
	public LinkedHashMap<String, String> getSelUserForTianLuan() {
		return selUserForTianLuan;
	}
	
	public void setSelFirstHour(LinkedHashMap selFirstHour) {
		this.selFirstHour = selFirstHour;
	}
	
	public LinkedHashMap getSelFirstHour() {
		return selFirstHour;
	}
	
	public void initSelFirstHour(){
		if(this.selFirstHour == null){
			this.selFirstHour = codeTypeServices.findCodeListForSel(EnumCodeTypeName.FIRST_HOUR, getProjectId());
		}
	}
	
	public LinkedHashMap getSelIntentLease() {
		return selIntentLease;
	}

	public void setSelIntentLease(LinkedHashMap selIntentLease) {
		this.selIntentLease = selIntentLease;
	}
	
	public void initSelIntentLease(){
		if(this.selIntentLease == null){
			this.selIntentLease = codeTypeServices.findCodeListForSel(EnumCodeTypeName.INTENTLEASE, getProjectId());
		}
	}

	public LinkedHashMap getSelPayBy() {
		return selPayBy;
	}

	public void setSelPayBy(LinkedHashMap selPayBy) {
		this.selPayBy = selPayBy;
	}
	
	public void initSetPayBy(){
		if(this.selPayBy == null){
			this.selPayBy = codeTypeServices.findCodeListForSel(EnumCodeTypeName.PAYBY, getProjectId());
		}
	}
	

	/////////

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public CustomerFollow getCustomerFollow() {
		return customerFollow;
	}

	public void setCustomerFollow(CustomerFollow customerFollow) {
		this.customerFollow = customerFollow;
	}
	
	public RecommendRoom getRecRoom1() {
		return recRoom1;
	}

	public void setRecRoom1(RecommendRoom recRoom1) {
		this.recRoom1 = recRoom1;
	}

	public RecommendRoom getRecRoom2() {
		return recRoom2;
	}

	public void setRecRoom2(RecommendRoom recRoom2) {
		this.recRoom2 = recRoom2;
	}

	public RecommendRoom getRecRoom3() {
		return recRoom3;
	}

	public void setRecRoom3(RecommendRoom recRoom3) {
		this.recRoom3 = recRoom3;
	}
	

	public CustomerCond getCustomerCond() {
		return customerCond;
	}

	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
	}

}
