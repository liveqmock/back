package com.ihk.customer.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.pojo.CustomerFocus;
import com.ihk.customer.data.pojo.CustomerFollow;
import com.ihk.customer.data.pojo.CustomerKnown;
import com.ihk.customer.data.pojo.RecommendRoom;
import com.ihk.customer.data.services.ICustomerFocusServices;
import com.ihk.customer.data.services.ICustomerFollowServices;
import com.ihk.customer.data.services.ICustomerKnownServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.customer.data.services.IRecommendRoomServices;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.ProvinceCond;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.setting.data.services.IProvinceServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerActionFront;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.Pager;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.follow.CustomerFollowUtils;
import com.ihk.utils.phone.PhoneUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 * Customer(客户) action
 */
@SuppressWarnings("rawtypes")
public class CustomerAction extends SupperAction {

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
	@Autowired
	IProvinceServices provinceServices;
	@Autowired
	ICityServices cityServices;
	@Autowired
	IRegionServices regionServices;
	@Autowired
	ICustomerFocusServices customerFocusServices;
	
	public String addCustomer() throws Exception{
		
		boolean isSucc = true;
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);

					customer = CustomerUtils.setCustomerForAddFromAction(request, customer, user); //根据不同的项目过来,进行相关的数据保存设置,要保证唯一确定action
					
					String[] knownFroms = request.getParameterValues("knownFrom"); //获知途径 customerKnownServices
					String[] customerFocus = request.getParameterValues("customerFocus") ; //关注点
					
					//要先判断所有的数据是否可以增加,如果不行,就抛出异常
					List<RecommendRoom> rooms = new ArrayList<RecommendRoom>(); //所选单元
					rooms.add(recRoom1);
					rooms.add(recRoom2);
					rooms.add(recRoom3);
					
					//所选单元为必填的时候放开下面的注释
					/*
					if(!CustomerUtils.isRecommendRoomsCanAdd(rooms)){ 
						throw new Exception("所选单元数据有问题");
					}
					*/
					
					customerServices.saveCustomer(customer);
					
					CustomerUtils.addCustomerKnownsByCustomer(customerKnownServices, knownFroms, customer);
					CustomerUtils.addRecommendRoomsByUser(recommendRoomServices, rooms, user, customer); 
					
					CustomerUtils.addCustomerFocusByCustomer(customerFocusServices, customerFocus, customer);
					 
				}
			}.execute();
			
			
		}catch(Exception e){
			e.printStackTrace();
			isSucc = false;
			
		}
		
		@SuppressWarnings("unused")
		String codeTypeSug = new String();
		if(isSucc){
			
			setSuggestion(CommonUtils.SUCCSUGG);
			codeTypeSug = "," + codeTypeServices.findCodeDescByCodeVal(EnumCodeTypeName.CUSTOMER_STATE, 
					CommonUtils.CUSTOMER_STATE_FOLLOW, getProjectId()); //另外的提示
			
		}else{
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		init(null);
		initCustomerState(); //客户状态,
		selCustomerState.remove(CommonUtils.CUSTOMER_STATE_NOT_FOLLOW); //暂时只有三个,只需移除CUSTOMER_STATE_NOT_FOLLOW
		selCustomerState.remove(CommonUtils.CUSTOMER_STATE_ALL);
		
		return "customerAdd";
	}
	
	
	//没有使用到
	@Deprecated
	public String quickAddCustomer() throws Exception{
		String customerName = request.getParameter("customerName");
		String phone = request.getParameter("phone");
		
		Customer quickCustomer = new Customer();
		quickCustomer.setCustomerName(customerName);
		quickCustomer.setPhone(phone);
		
		boolean isSucc = false;
		
		try{
		
			UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
			quickCustomer = CustomerUtils.setCustomerForUserAndOther(quickCustomer, user, true);  //设置未获取的相关属性
			customerServices.saveCustomer(quickCustomer);
			
			isSucc = true;
		
		}catch(Exception e){
			e.printStackTrace();
			isSucc = false;
		}
		
		if(isSucc){
			CustomerUtils.writeResponse(response, "succ");
		}else{
			CustomerUtils.writeResponse(response, "fail");
		}
		
		return null;
	}
	
	
	public String customerLoginOut() throws Exception{
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "loginFail";
	}
	
	
	@SuppressWarnings("unchecked")
	public String searchCustomer() throws Exception{
		
		String from = request.getParameter("from");  //按条件搜索时就为空
		
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
		
		if("left".equals(from)){
			//点击左边或顶上的"查询客户"
			session.removeAttribute("customerCond"); //清空该session
			customerCond = new CustomerCond(); 
			
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
			
		}
		
		if(!CommonUtils.ADMIN.equals(type)){
			customerCond.setUserId(user.getId() + ""); //此处如果userId不为空，表示为普通用户
		}
		customerCond.setProjectId(getProjectId());
		
		page.setCond(customerCond);
		customerList = customerServices.findCustomerSearch(customerCond); 
		
		session.setAttribute("customerCond", customerCond);   //供查找返回及下载使用
		
		/**
		 * 不同的项目进来,要初始化的数据也不同
		 */
		initSearchFromAction(user);
		
		initCustomerState();
		selCustomerState.put(CommonUtils.CUSTOMER_STATE_ALL, CommonUtils.ALL);
		this.setShowPage(page.toHtmlString());
		
		return "queryCustomerLimit";
	}
	
	public String downLoad() throws Exception{
		//导出 暂时
		
		CustomerCond downloadCond = new CustomerCond();
		
		HttpSession session = request.getSession();
		Object getCond = session.getAttribute("customerCond");
		if(getCond != null){
			downloadCond = (CustomerCond) getCond;
		}
		
		List<Customer> allCustomerList = customerServices.findCustomerForDownload(downloadCond);
		request.getSession().setAttribute("allCustomerList", allCustomerList);
		
		return "download";
	}
	
	public String queryCustomerById() throws Exception{
		
		HttpSession session = request.getSession();
		
		int id = 0;
		Object obj = session.getAttribute("customerId"); 
		if(obj != null){
			//表示从方法addFollow()或updateCustomer()过来,而且要及时删除该session
			id = Integer.parseInt(obj.toString());
			session.removeAttribute("customerId");
			
		}else{
			//表示从查看详情过来,要清空提示
			session.removeAttribute("suggestion");
			id = Integer.parseInt(request.getParameter("id"));
		}
		Customer customer = customerServices.getCustomerById(id);
		
		//跟进内容不用分页
		List<CustomerFollow> customerFollows = customerFollowServices.findCustomerFollowByCustomerId(customer.getId());
				
		////获知途径
		List<CustomerKnown> knownList = customerKnownServices.findCustomerKnownByCustomerId(id);
		List<String> list = new ArrayList<String>();
		setKnowns(list);
		for(CustomerKnown known : knownList){
			knowns.add(known.getKnownFrom());
		}
		
		//先清空session中recRoom的相关信息,不论其有没有值
		session.removeAttribute("recRoom1");
		session.removeAttribute("recRoom2");
		session.removeAttribute("recRoom3");
		List<RecommendRoom> roomList = recommendRoomServices.findRecommendRoomByCustomerId(id);
		for(int i=0; i<roomList.size(); i++){
			RecommendRoom room = roomList.get(i);
			session.setAttribute("recRoom"+(i+1), room);
			
		}
		
		//广州项目
		List<CustomerFocus> focusList = customerFocusServices.findCustomerFocusByCustomerId(id);
		List<String> focus = new ArrayList<String>();
		for(CustomerFocus f : focusList){
			focus.add(f.getFocusPoint());
		}
		
		session.setAttribute("c", customer); //要保存到session中才能拿到
		session.setAttribute("follows", customerFollows); //跟进内容
		session.setAttribute("knowns", knowns);  //获知途径
		
		session.setAttribute("focus", focus); //广州点(广州项目)
		
		initQueryCustomerById(session);
		
		init(customer);
		initCustomerState(); //客户状态,
		selCustomerState.remove(CommonUtils.CUSTOMER_STATE_ALL); 
		
		return "queryCustomerByIdForUpdate";
		
	}
	
	public String doSomeForAddCustomer() throws Exception{
		//在跳转到增加页面之前,做一些相关的操作,例如清空一些session,以及一些下拉框字典的获取
		
		HttpSession session = request.getSession();
		session.removeAttribute("c");
		
		initDoSomeForAddCustomer(session);
		
		String deleteSession = request.getParameter("deleteSession");
		if(!"false".equals(deleteSession)){
			//说明不是从增加后跳过来的,要清空session
			session.removeAttribute("suggestion");
		}
		if("input".equals(deleteSession)){
			setSuggestion("录入数据出现异常,请重新录入");
		}
		
		init(null);
		initCustomerState(); //客户状态,
		selCustomerState.remove(CommonUtils.CUSTOMER_STATE_NOT_FOLLOW); //移除CUSTOMER_STATE_NOT_FOLLOW,不再跟进
		selCustomerState.remove(CommonUtils.CUSTOMER_STATE_ALL);
		
		return "forAdd";
		
	}
	
	public String updateCustomer() throws Exception{
		boolean updateIsSucc = true;
		
		final int customerId = customer.getId();
		
		final HttpSession session = request.getSession();
		
		try{
			
			new MyTransationTemplate() {

				@Override
				protected void doExecuteCallback() throws Exception {
					
					UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
					Customer oldCustomer = customerServices.getCustomerById(customerId);
					
					customer = initUpdateCustomer(session, customer, oldCustomer);
					
					customer = CustomerUtils.setCustomerForUpdate(customer, user);  //设置修改的用户id及修改时间
					
					//获知途径 customerKnownServices,删除掉再增加
					String[] knownFroms = request.getParameterValues("knownFrom"); 
					customerKnownServices.deleteCustomerKnownByCustomerId(customerId);
					CustomerUtils.addCustomerKnownsByCustomer(customerKnownServices, knownFroms, oldCustomer);
					
					//building1 room1 original_price1 discount_desc1
					List<RecommendRoom> rooms = new ArrayList<RecommendRoom>(); //所选单元
					rooms.add(recRoom1);
					rooms.add(recRoom2);
					rooms.add(recRoom3);
					CustomerUtils.updateRecommendRoomsByUser(recommendRoomServices,rooms, user, customer);
					
					//关注点,删除掉再增加
					String[] customerFocus = request.getParameterValues("customerFocus") ; //关注点
					customerFocusServices.deleteCustomerFocusByCusotmerId(customerId);
					CustomerUtils.addCustomerFocusByCustomer(customerFocusServices, customerFocus, customer);
					
					customerServices.updateCustomer(customer);
					
					
				}
				
			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			
			updateIsSucc = false;
			
		}
		
		if(updateIsSucc){
			
			setSuggestion(CommonUtils.SUCCSUGG);
		}else{
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		session.setAttribute("customerId", customerId);
		return queryCustomerById();
		
		
	}
	
	public String getSomeForAddFollow() throws Exception{
		//查询相关的数据,供follow使用,如跟进类型等等
		LinkedHashMap followTypes = codeTypeServices.findCodeListForSel(EnumCodeTypeName.FOLLOW_TYPE, getProjectId());
		
		String data = CustomerUtils.getFollowTypeHtml(followTypes);
		
		CustomerUtils.writeResponse(response, data);
		
		return null;
		
	}
	
	public String findPhoneIsExists() throws Exception{
		String phone = request.getParameter("phone");
		int projectId = getProjectId();
		List<Map<String,String>> userList = customerServices.findPhoneIsExistsByProjectId(phone, projectId);
		
		String sugg = CustomerUtils.getSuggForCheckPhone(phone,userList);
		
		if(!sugg.isEmpty()){
			CustomerUtils.writeResponse(response, sugg);
		}
		
		return null;
	}
	
	public String addFollow() throws Exception{
		
		try{
			UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
			Customer customer = (Customer) request.getSession().getAttribute("c");
			
			//临时把customerId保存到session中,跳转到queryCustomerById()中再把其删除
			int customerId = customer.getId();
			request.getSession().setAttribute("customerId", customerId);
			
			customerFollow = CustomerUtils.setCustomerFollowForUserAndOther(customerFollow, user, customer);
			customerFollowServices.addCustomerFollow(customerFollow);
			
			CustomerFollowUtils.modifyCustomerForAddCutomerFollow(customerFollow);
			
			setSuggestion(CommonUtils.SUCCSUGG);
			
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return queryCustomerById();
		
	}
	
	public String delCustomers() throws Exception{
		String getIdStr = request.getParameter("ids");
		String[] idsStr = getIdStr.split("_");
		
		try{
			for(String idStr : idsStr){
				int id = Integer.parseInt(idStr);
				customerServices.removeCustomer(id); //只是把is_deleted标示为1,表示删除
			}
			setSuggestion(CommonUtils.SUCCSUGG);
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		//return searchCustomer();
		return "deleteCustomer";
	}
	
	public String leftDisplay() throws Exception{
		//设置左边的隐藏与显示
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("leftDisplay");
		if(obj == null){
			session.setAttribute("leftDisplay", "0");
		}else{
			String leftDisplay = obj.toString();
			if("1".equals(leftDisplay)){
				session.setAttribute("leftDisplay", "0");
			}else{
				session.setAttribute("leftDisplay", "1");
			}
		}
		
		
		return null;
	}
	
	//恒大绿洲表格分析
	public String table() throws Exception{
		
		return "table";
	}
	
	/**
	 * tmp批量处理电话归属地
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public String tmpFetchPhoneFrom() throws Exception{
		
		int pageSize = 100;
		
		CustomerCond cond = new CustomerCond();
		cond.pageSize = pageSize;
		
		int size = customerServices.tmpCount();
		int count = size/pageSize; 
		
		for(int i=0; i<=count; i++){
			
			int startLine = i*pageSize;
			
			cond.startLine = startLine;
			
			List<Customer> allCustomer = customerServices.tmpList(cond);
			allCustomer = PhoneUtils.postPhoneForcha14(allCustomer);
			
			final List<Customer> tracList = allCustomer;
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					Map<String, String> map = new HashMap<String, String>();
					for(Customer cus : tracList){
						
						map.put("id", cus.getId() + "");
						map.put("phoneFrom", cus.getPhoneFrom());
						//System.out.println(cus.getId() + "\t" + cus.getPhoneComeFrom());
						
						customerServices.updateCustomerPhoneFrom(map);
						
					}
					
				}
			}.execute();
			
		}
		
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	private void initSearchFromAction(UserAccount user) throws Exception{
		//因一些变量是在action中声明的,所有该方法就不放到CustomerUtils中,该方法中的判断可以合并
		
		String actionFront = CustomerUtils.getActionFront(request);
		if(CustomerActionFront.OLDHUIJING.equals(actionFront)){
			
			initSelRating(); ///selRating 汇景中的客户初步评价
			selRating = CustomerUtils.setSelRatingForHuiJing(selRating);
			
			initSelUserForAction("selUserForOldHuiJing", user);
			
		}else if(CustomerActionFront.HUIJING.equals(actionFront)){
			
			initSelRating(); ///selRating 汇景国际中的客户初步评价
			selRating = CustomerUtils.setSelRatingForHuiJing(selRating);
			
			initSelUserForAction("selUserForHuiJing", user);
			
		}else if(CustomerActionFront.TIANLUAN.equals(actionFront)){
			//天銮项目中，如果为管理员，在查找的时候要判断是否是查找具体某一个用户对应的客户 selUserForTianLuan
			initSelUserForAction("selUserForTianLuan", user);
			
		}else if(CustomerActionFront.SHANSHUI.equals(actionFront)){
			initSelRating(); ///selRating 山水庭苑中的客户初步评价
			selRating = CustomerUtils.setSelRatingForHuiJing(selRating);
			
			initSelUserForAction("selUserForShanShui", user);
			
		}
	}
	
	private void initSelUserForAction(String attr, UserAccount user) throws Exception{
		//设置查找中的用户信息
		if(CommonUtils.ADMIN.equals(user.getAccountType())){
			String userId = customerCond.getUserId();
			if(CustomerUtils.isStrEmpty(userId)){
				//初始化该管理员其下的用户，并保存在session中，
				HttpSession session = request.getSession();
				Object obj = session.getAttribute(attr);
				if(obj == null){
					Map<String, String> selUserFor = CustomerUtils.getSelUserInProject(user, userAccountServices);
					request.getSession().setAttribute(attr, selUserFor);
				}
			}
			
		}
	}
	
	private void initQueryCustomerById(HttpSession session) throws Exception{
		String actionFront = CustomerUtils.getActionFront(request);
		if(CustomerActionFront.OLDHUIJING.equals(actionFront)){
			
			initForHuiJingAndShanShui(session, userAccountServices);
		}else if(CustomerActionFront.HUIJING.equals(actionFront)){
			
			initForHuiJingAndShanShui(session, userAccountServices);
		}else if(CustomerActionFront.TIANLUAN.equals(actionFront)){
			
			
		}else if(CustomerActionFront.SHANSHUI.equals(actionFront)){
			
			initForHuiJingAndShanShui(session, userAccountServices);
		}
		
	}
	
	private void initDoSomeForAddCustomer(HttpSession session) throws Exception{
		String actionFront = CustomerUtils.getActionFront(request);
		if(CustomerActionFront.OLDHUIJING.equals(actionFront)){
			
			initForHuiJingAndShanShui(session, userAccountServices);
		}else if(CustomerActionFront.HUIJING.equals(actionFront)){
			
			initForHuiJingAndShanShui(session, userAccountServices);
		}else if(CustomerActionFront.TIANLUAN.equals(actionFront)){
			
			
		}else if(CustomerActionFront.SHANSHUI.equals(actionFront)){
			
			initForHuiJingAndShanShui(session, userAccountServices);
		}
	}
	
	private Customer initUpdateCustomer(HttpSession session, Customer customer, Customer oldCustomer) throws Exception{
		
		String actionFront = CustomerUtils.getActionFront(request);
		if(CustomerActionFront.OLDHUIJING.equals(actionFront)){
			
			customer = CustomerUtils.setCustomerFromOldCustomerForHuiJingAndShanShui(customer, oldCustomer); //设置页面不能获取的相关数据
		}else if(CustomerActionFront.HUIJING.equals(actionFront)){
			
			customer = CustomerUtils.setCustomerFromOldCustomerForHuiJingAndShanShui(customer, oldCustomer);
		}else if(CustomerActionFront.TIANLUAN.equals(actionFront)){
			
			customer = CustomerUtils.setCustomerFromOldCustomer(customer, oldCustomer); //设置页面不能获取的相关数据
			
		}else if(CustomerActionFront.SHANSHUI.equals(actionFront)){
			
			customer = CustomerUtils.setCustomerFromOldCustomerForHuiJingAndShanShui(customer, oldCustomer);
		}else if(CustomerActionFront.GUANGZHOU.equals(actionFront)){
			
			customer = CustomerUtils.setCustomerFromOldCustomerForGuangZhou(customer, oldCustomer); //设置页面不能获取的相关数据
		}
		
		return customer;
		
	}
	
	private void init(Customer customer){
		initGender();
		initAgeRange();
		initJobType();
		initCustomerRegion();
		initKnownFrom();
		initRequestArea();
		initRoomType();
		initPriceAmount();
		initBuyAim();
		initPayType();
		initSelFirstHour();
		initSelIntentLease();
		initSetPayBy();
		
		initForGuangZhou(customer);
		
	}
	
	private void initForGuangZhou(Customer customer){
		
		String action = CustomerUtils.getActionNameFromRequest(request);
		
		if(action.contains("guangzhou")){
			initSelBuyUse();
			initSelBuyCount();
			initSelHouseType();
			initSelCustomerSource();
			initSelVisitCount();
			initSelFamilyType();
			initSelFamilyIncome();
			initSelJobIndustry();
			initSelIntentBuynum();
			initSelCustomerFocus();
			
			initSelProvince();
			
			initSelHomeCity(customer);
			initSelHomeRegion(customer);
			initSelWorkCity(customer);
			initSelWorkRegion(customer);
		}
	}
	
	private void initForHuiJingAndShanShui(HttpSession session, IUserAccountServices userAccountServices) throws Exception{
		//initForHuiJing(session, userAccountServices, false, null);
		
		Object obj = session.getAttribute(CommonUtils.USER_SESSION_KEY);
		UserAccount user = (UserAccount) obj;
		String type = user.getAccountType();
		
		Map<String, String> selUser = CustomerUtils.getSelUserInProject(user, userAccountServices);
		selUser.remove(""); //汇景项目中的“跟进人员”没有“所有用户”的选项
		
		session.setAttribute("type", type);
		session.setAttribute("user", user);
		session.setAttribute("selUser", selUser);
		
		String now = CustomerUtils.getNowForString();
		session.setAttribute("now", now);
		
		initSelRating();  //客户初步评价,
		initSelIntentionPart(); // 意向单元,
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
	private LinkedHashMap selJobType; 	//行业结构（行业分类）
	private LinkedHashMap selCustomerRegion; 	
	private LinkedHashMap selKnownFrom;  //认知(获知)途径 
	private LinkedHashMap selRequestArea; 	//意向面积
	private LinkedHashMap selRoomType; 	 //意向户型
	private LinkedHashMap selPriceAmount; 	//意向总价
	private LinkedHashMap selBuyAim;  //购房目的
	private LinkedHashMap selPayType;  //付款方式
	private LinkedHashMap selCustomerState; //跟进状态
	private LinkedHashMap selIntentionPart; //汇景中的意向单元
	private LinkedHashMap selRating; //汇景中的客户初步评价	
	private LinkedHashMap selFirstHour; //天銮项目中的首次首次到场时间hour
	private LinkedHashMap selIntentLease; //汇景国际中的意向租期
	private LinkedHashMap selPayBy; //汇景国际中的租金支付
	
	private LinkedHashMap<String, String> selUserForTianLuan; //天銮中的所属用户
	
	//下面的字段用于广州项目
	private LinkedHashMap selBuyUse; //购房用途
	private LinkedHashMap selBuyCount; //置业次数
	private LinkedHashMap selHouseType; //产品类型
	private LinkedHashMap selCustomerSource; //客户来源
	private LinkedHashMap selVisitCount; //来访次数
	private LinkedHashMap selFamilyType; //家庭结构
	private LinkedHashMap selFamilyIncome; //家庭收入
	private LinkedHashMap selJobIndustry; //职业
	private LinkedHashMap selIntentBuynum; //意向套数
	private LinkedHashMap selCustomerFocus; //关注点
	private LinkedHashMap selProvince; //省
	private LinkedHashMap selHomeCity; //居住市
	private LinkedHashMap selHomeRegion; //居住区域
	private LinkedHashMap selWorkCity; //工作市
	private LinkedHashMap selWorkRegion; //工作区域
	
	private LinkedHashMap selKnownFrom1;  //认知(获知)途径 -->广州
	private LinkedHashMap selKnownFrom2;  //认知(获知)途径 -->广州
	private LinkedHashMap selKnownFrom3;  //认知(获知)途径 -->广州
	
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
		return SessionUser.getProjectId();
				
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
    
	@SuppressWarnings("unchecked")
	public void initKnownFrom() {  
		if(this.selKnownFrom==null){
			this.selKnownFrom = codeTypeServices.findCodeListForSel(EnumCodeTypeName.KNOWN_FROM,getProjectId());
			
			String action = CustomerUtils.getActionNameFromRequest(request);
			if(action.contains("guangzhou")){
				
				if(selKnownFrom1 == null){
					selKnownFrom1 = new LinkedHashMap();
				}
				if(selKnownFrom2 == null){
					selKnownFrom2 = new LinkedHashMap();
				}
				if(selKnownFrom3 == null){
					selKnownFrom3 = new LinkedHashMap();
				}
				
				Set keys = selKnownFrom.keySet();
				for(Object key : keys){
					Object value = selKnownFrom.get(key);
					String val = value == null ? "" : value.toString();
					String k = key.toString();
					
					if(k.startsWith("1")){
						
						selKnownFrom1.put(k, val);
					}else if(k.startsWith("2")){
						
						selKnownFrom2.put(k, val);
					}else{
						
						selKnownFrom3.put(k, val);
					}
					
					
				}
			}
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
			//this.selCustomerState = codeTypeServices.findCodeListForSel(CodeTypeName.CUSTOMER_STATE,getProjectId());
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
	
	public LinkedHashMap getSelBuyUse() {
		return selBuyUse;
	}

	public void setSelBuyUse(LinkedHashMap selBuyUse) {
		this.selBuyUse = selBuyUse;
	}

	public void initSelBuyUse(){
		if(this.selBuyUse == null){
			this.selBuyUse = codeTypeServices.findCodeListForSel(EnumCodeTypeName.BUY_AIM, getProjectId(), true);  //1
		}
	}
	
	public LinkedHashMap getSelBuyCount() {
		return selBuyCount;
	}


	public void setSelBuyCount(LinkedHashMap selBuyCount) {
		this.selBuyCount = selBuyCount;
	}

	public void initSelBuyCount(){
		if(this.selBuyCount == null){
			this.selBuyCount = codeTypeServices.findCodeListForSel(EnumCodeTypeName.BUY_COUNT, getProjectId(), true);   //2
		}
	}

	public LinkedHashMap getSelHouseType() {
		return selHouseType;
	}

	public void setSelHouseType(LinkedHashMap selHouseType) {
		this.selHouseType = selHouseType;
	}

	public void initSelHouseType(){
		if(this.selHouseType == null){
			this.selHouseType = codeTypeServices.findCodeListForSel(EnumCodeTypeName.HOUSE_TYPE, getProjectId(), true);   //3
		}
	}

	public LinkedHashMap getSelCustomerSource() {
		return selCustomerSource;
	}


	public void setSelCustomerSource(LinkedHashMap selCustomerSource) {
		this.selCustomerSource = selCustomerSource;
	}

	public void initSelCustomerSource(){
		if(this.selCustomerSource == null){
			this.selCustomerSource = codeTypeServices.findCodeListForSel(EnumCodeTypeName.CUSTOMER_SOURCE, getProjectId(), true); //4
		}
	}

	public LinkedHashMap getSelVisitCount() {
		return selVisitCount;
	}


	public void setSelVisitCount(LinkedHashMap selVisitCount) {
		this.selVisitCount = selVisitCount;
	}

	public void initSelVisitCount(){
		if(this.selVisitCount == null){
			this.selVisitCount = codeTypeServices.findCodeListForSel(EnumCodeTypeName.VISIT_COUNT, getProjectId(), true);  //5
		}
	}

	public LinkedHashMap getSelFamilyType() {
		return selFamilyType;
	}

	public void setSelFamilyType(LinkedHashMap selFamilyType) {
		this.selFamilyType = selFamilyType;
	}
	
	public void initSelFamilyType(){
		if(this.selFamilyType == null){
			this.selFamilyType = codeTypeServices.findCodeListForSel(EnumCodeTypeName.FAMILY_TYPE, getProjectId(), true);  //6
		}
	}

	public LinkedHashMap getSelFamilyIncome() {
		return selFamilyIncome;
	}

	public void setSelFamilyIncome(LinkedHashMap selFamilyIncome) {
		this.selFamilyIncome = selFamilyIncome;
	}

	public void initSelFamilyIncome(){
		if(this.selFamilyIncome == null){
			this.selFamilyIncome = codeTypeServices.findCodeListForSel(EnumCodeTypeName.FAMILY_INCOME, getProjectId(), true);  //7
		}
	}

	public LinkedHashMap getSelJobIndustry() {
		return selJobIndustry;
	}

	public void setSelJobIndustry(LinkedHashMap selJobIndustry) {
		this.selJobIndustry = selJobIndustry;
	}

	public void initSelJobIndustry(){
		if(this.selJobIndustry == null){
			this.selJobIndustry = codeTypeServices.findCodeListForSel(EnumCodeTypeName.JOB_INDUSTRY, getProjectId(), true);  //8
		}
	}

	public LinkedHashMap getSelIntentBuynum() {
		return selIntentBuynum;
	}


	public void setSelIntentBuynum(LinkedHashMap selIntentBuynum) {
		this.selIntentBuynum = selIntentBuynum;
	}
	
	public void initSelIntentBuynum(){
		if(this.selIntentBuynum == null){
			this.selIntentBuynum = codeTypeServices.findCodeListForSel(EnumCodeTypeName.INTENT_BUYNUM, getProjectId(), true); //9
		}
	}
	
	
	public LinkedHashMap getSelCustomerFocus() {
		return selCustomerFocus;
	}
	
	public void setSelCustomerFocus(LinkedHashMap selCustomerFocus) {
		this.selCustomerFocus = selCustomerFocus;
	}
	
	public void initSelCustomerFocus(){
		if(this.selCustomerFocus == null){
			this.selCustomerFocus = codeTypeServices.findCodeListForSel(EnumCodeTypeName.CUSTOMER_FOCUS, getProjectId(), true);  //10
		}
	}
	
	public LinkedHashMap getSelProvince() {
		return selProvince;
	}
	
	public void setSelProvince(LinkedHashMap selProvince) {
		this.selProvince = selProvince;
	}
	
	@SuppressWarnings("unchecked")
	public void initSelProvince(){
		if(this.selProvince == null){
			
			selProvince = new LinkedHashMap();
			selProvince.put("", CommonUtils.EMPTY);
			
			List<Province> provinceList = provinceServices.findProvince(new ProvinceCond());
			for(Province province : provinceList){
				selProvince.put(province.getProvinceId(), province.getProvinceName());
			}
		}
	}
	
	public void setSelHomeCity(LinkedHashMap selHomeCity) {
		this.selHomeCity = selHomeCity;
	}
	
	public LinkedHashMap getSelHomeCity() {
		return selHomeCity;
	}
	
	@SuppressWarnings("unchecked")
	public void initSelHomeCity(Customer customer){
		if(this.selHomeCity == null){
			
			selHomeCity = new LinkedHashMap();
			selHomeCity.put("", CommonUtils.EMPTY);
			
			try {
				if(customer != null){
					
					List<City> citys = cityServices.findCityByProvinceId(customer.getHomeProvince());
					for(City city : citys){
						selHomeCity.put(city.getCityId(), city.getCityName());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void setSelHomeRegion(LinkedHashMap selHomeRegion) {
		this.selHomeRegion = selHomeRegion;
	}
	
	public LinkedHashMap getSelHomeRegion() {
		return selHomeRegion;
	}
	
	@SuppressWarnings("unchecked")
	public void initSelHomeRegion(Customer customer){
		if(this.selHomeRegion == null){
			
			selHomeRegion = new LinkedHashMap();
			selHomeRegion.put("", CommonUtils.EMPTY);
			
			try {
				if(customer != null){
					
					List<Region> regions = regionServices.findRegionByCityId(customer.getHomeCity());
					for(Region region : regions){
						selHomeRegion.put(region.getRegionId(), region.getRegionName());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void setSelWorkCity(LinkedHashMap selWorkCity) {
		this.selWorkCity = selWorkCity;
	}
	
	public LinkedHashMap getSelWorkCity() {
		return selWorkCity;
	}
	
	@SuppressWarnings("unchecked")
	public void initSelWorkCity(Customer customer){
		if(this.selWorkCity == null){
			
			selWorkCity = new LinkedHashMap();
			selWorkCity.put("", CommonUtils.EMPTY);
			
			try {
				if(customer != null){
					
					List<City> citys = cityServices.findCityByProvinceId(customer.getWorkProvince());
					for(City city : citys){
						selWorkCity.put(city.getCityId(), city.getCityName());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void setSelWorkRegion(LinkedHashMap selWorkRegion) {
		this.selWorkRegion = selWorkRegion;
	}
	
	public LinkedHashMap getSelWorkRegion() {
		return selWorkRegion;
	}
	
	@SuppressWarnings("unchecked")
	public void initSelWorkRegion(Customer customer){
		if(this.selWorkRegion == null){
			
			selWorkRegion = new LinkedHashMap();
			selWorkRegion.put("", CommonUtils.EMPTY);
			
			try {
				if(customer != null){
					
					List<Region> regions = regionServices.findRegionByCityId(customer.getWorkCity());
					for(Region region : regions){
						selWorkRegion.put(region.getRegionId(), region.getRegionName());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
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


	public LinkedHashMap getSelKnownFrom1() {
		return selKnownFrom1;
	}


	public void setSelKnownFrom1(LinkedHashMap selKnownFrom1) {
		this.selKnownFrom1 = selKnownFrom1;
	}


	public LinkedHashMap getSelKnownFrom2() {
		return selKnownFrom2;
	}


	public void setSelKnownFrom2(LinkedHashMap selKnownFrom2) {
		this.selKnownFrom2 = selKnownFrom2;
	}


	public LinkedHashMap getSelKnownFrom3() {
		return selKnownFrom3;
	}


	public void setSelKnownFrom3(LinkedHashMap selKnownFrom3) {
		this.selKnownFrom3 = selKnownFrom3;
	}
	
	
}
