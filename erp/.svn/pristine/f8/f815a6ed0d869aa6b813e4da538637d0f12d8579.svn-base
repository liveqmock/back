package com.ihk.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerFocus;
import com.ihk.customer.data.pojo.CustomerFollow;
import com.ihk.customer.data.pojo.CustomerKnown;
import com.ihk.customer.data.pojo.RecommendRoom;
import com.ihk.customer.data.services.ICustomerFocusServices;
import com.ihk.customer.data.services.ICustomerKnownServices;
import com.ihk.customer.data.services.IRecommendRoomServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.exception.CustomerException;
import com.ihk.utils.onlyfollow.CustomerOnlyFollowUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 客户帮助类
 * @author dtc
 * 2012-9-29
 */
public class CustomerUtils {
	
	public static void writeResponse(HttpServletResponse response, String content) throws IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter pw = response.getWriter();
		pw.write(content);
		pw.flush();
		pw.close();
		
	}
	
	public synchronized static String getTmpCustomerNo(){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MMddHHmmss");
		return df.format(date);
	}
	
	public static String getNowForString(){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	
	public static String getNowTimeForString(){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		return df.format(date);
	}
	
	public static String getDateString(Date date){
		
		if(date == null)
			return "";
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	
	public static java.sql.Date getSqlDateForNow(){
		//获取sql的当前时间,使用sql的Date,会使得保存到数据库的Date的hh mm ss都为0
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		return sqlDate;
	}
	
	public static Customer setCustomerForUserAndOther(Customer customer, UserAccount user, boolean isQuickAdd){
		//设置Customer中所拥有的UserAccount的相关属性及一些默认属性,isQuickAdd标示是否快速增加,false表示修改
		
		Date date = new Date();
		
		customer.setCustomerNo(getTmpCustomerNo()); //临时利用时间生成10位的客户编号
		customer.setIsDeleted(CommonUtils.NORMAL);  ///0表示正常,1表示删除
		customer.setCompanyId(user.getCompanyId());
		customer.setProjectId(user.getProjectId());
		customer.setTeamId(user.getTeamId());
		customer.setUserId(user.getId());
		customer.setCreatedId(user.getId());
		customer.setModId(user.getId());
		customer.setCreatedTime(date);
		customer.setModTime(date);
		
		if(isQuickAdd){
			customer.setCustomerState(CommonUtils.CUSTOMER_STATE_FOLLOW);  //暂时先为1,表示跟进中
		}
		
		return customer;
	}
	
	public static Customer setCustomerForUserAndOther(Customer customer, UserAccount user){
		//设置Customer中所拥有的UserAccount的相关属性及一些默认属性,isQuickAdd标示是否快速增加,false表示修改
		
		Date date = new Date();
		
		customer.setCustomerNo(getTmpCustomerNo()); //临时利用时间生成10位的客户编号
		customer.setIsDeleted(CommonUtils.NORMAL);  ///0表示正常,1表示删除
		customer.setCompanyId(user.getCompanyId());
		customer.setProjectId(user.getProjectId());
		customer.setTeamId(user.getTeamId());
		customer.setUserId(user.getId());
		customer.setCreatedId(user.getId());
		customer.setModId(user.getId());
		customer.setCreatedTime(date);
		customer.setModTime(date);
		
		if(isStrEmpty(customer.getCustomerState())){
			customer.setCustomerState(CommonUtils.CUSTOMER_STATE_FOLLOW);
		}
		
		return customer;
	}
	
	public static Customer setCustomerForUserAndOtherToHengDa(Customer customer, UserAccount user){
		//设置Customer中所拥有的UserAccount的相关属性及一些默认属性,isQuickAdd标示是否快速增加,false表示修改
		
		Date date = new Date();
		
		customer.setCustomerNo(getTmpCustomerNo()); //临时利用时间生成10位的客户编号
		customer.setIsDeleted(CommonUtils.NORMAL);  ///0表示正常,1表示删除
		//customer.setCompanyId(user.getCompanyId()); 页面获取
		//customer.setProjectId(user.getProjectId()); 页面获取
		customer.setTeamId(user.getTeamId());
		customer.setUserId(user.getId());
		customer.setCreatedId(user.getId());
		customer.setModId(user.getId());
		customer.setCreatedTime(date);
		customer.setModTime(date);
		
		return customer;
	}
	
	public static Customer setCustomerForUserAndOtherForHuiJingAndShanShui(Customer customer, UserAccount user){
		//设置Customer中所拥有的UserAccount的相关属性及一些默认属性
		
		Date date = new Date();
		
		customer.setCustomerNo(getTmpCustomerNo()); //临时利用时间生成10位的客户编号
		customer.setIsDeleted(CommonUtils.NORMAL);  ///0表示正常,1表示删除
		customer.setCompanyId(user.getCompanyId());
		customer.setProjectId(user.getProjectId());
		customer.setTeamId(user.getTeamId());
		//customer.setUserId(user.getId());  //从页面获取
		customer.setCreatedId(user.getId()); 
		customer.setModId(user.getId());
		//customer.setCreatedTime(date);   //从页面获取
		customer.setModTime(date);
		
		customer.setCustomerState(CommonUtils.CUSTOMER_STATE_FOLLOW);  //暂时先为1,表示跟进中
		
		return customer;
	}
	
	public static Customer setCustomerForUpdate(Customer customer, UserAccount user){
		//以后可能还会增加一些类似所属项目及组别的修改
		
		Date date = new Date();
		
		customer.setModId(user.getId());
		customer.setModTime(date);
		
		return customer;
	}
	
	public static Customer setCustomerForUpdate(Customer customer, UserAccount user, boolean isHuiJing){
		//以后可能还会增加一些类似所属项目及组别的修改
		
		if(isHuiJing){
			
			customer.setModId(user.getId());
			return customer;
			
		}else{
			return setCustomerForUpdate(customer, user);
		}
	}
	
	public static String getActionNameFromRequest(HttpServletRequest request){
		//获取action名称,供Page()使用
		String path = request.getServletPath();
		
		//String servletPath = RequestUtils.getServletPath(request); //struts2中的一个帮助类
		
		if(path != null && path.length() > 1){
			return path.substring(1, path.length());
		}else{
			return "";
		}
	}
	
	public static Customer setCustomerFromOldCustomer(Customer newCustomer, Customer oldCustomer){
		newCustomer.setCustomerNo(oldCustomer.getCustomerNo());
		newCustomer.setCompanyId(oldCustomer.getCompanyId());
		newCustomer.setProjectId(oldCustomer.getProjectId());
		newCustomer.setTeamId(oldCustomer.getTeamId());
		newCustomer.setUserId(oldCustomer.getUserId());
		newCustomer.setCreatedId(oldCustomer.getCreatedId());
		newCustomer.setCreatedTime(oldCustomer.getCreatedTime());
		newCustomer.setIsDeleted(oldCustomer.getIsDeleted());  ///0表示正常,1表示删除
		
		return newCustomer;
	}
	
	public static Customer setCustomerFromOldCustomerForGuangZhou(Customer newCustomer, Customer oldCustomer){
		newCustomer.setCustomerNo(oldCustomer.getCustomerNo());
		newCustomer.setCompanyId(oldCustomer.getCompanyId());
		newCustomer.setProjectId(oldCustomer.getProjectId());
		newCustomer.setTeamId(oldCustomer.getTeamId());
		newCustomer.setUserId(oldCustomer.getUserId());
		newCustomer.setCreatedId(oldCustomer.getCreatedId());
		newCustomer.setCreatedTime(oldCustomer.getCreatedTime());
		newCustomer.setIsDeleted(oldCustomer.getIsDeleted());  ///0表示正常,1表示删除
		newCustomer.setCustomerState(oldCustomer.getCustomerState()); //客户状态
		
		return newCustomer;
	}
	
	
	
	public static Customer setCustomerFromOldCustomerForHengDa(Customer newCustomer, Customer oldCustomer){
		newCustomer.setCustomerNo(oldCustomer.getCustomerNo());
		newCustomer.setTeamId(oldCustomer.getTeamId());
		newCustomer.setUserId(oldCustomer.getUserId());
		newCustomer.setCreatedId(oldCustomer.getCreatedId());
		newCustomer.setCreatedTime(oldCustomer.getCreatedTime());
		newCustomer.setIsDeleted(oldCustomer.getIsDeleted());  ///0表示正常,1表示删除
		
		return newCustomer;
	}
	
	public static Customer setCustomerFromOldCustomerForHuiJingAndShanShui(Customer newCustomer, Customer oldCustomer){
		newCustomer.setCustomerNo(oldCustomer.getCustomerNo());
		newCustomer.setCompanyId(oldCustomer.getCompanyId());
		newCustomer.setProjectId(oldCustomer.getProjectId());
		newCustomer.setTeamId(oldCustomer.getTeamId());
		//newCustomer.setUserId(oldCustomer.getUserId());
		newCustomer.setCreatedId(oldCustomer.getCreatedId());
		newCustomer.setCreatedTime(oldCustomer.getCreatedTime());
		newCustomer.setIsDeleted(oldCustomer.getIsDeleted());  ///0表示正常,1表示删除
		newCustomer.setCustomerState(oldCustomer.getCustomerState());
		
		return newCustomer;
	}
	
	public static RecommendRoom setRecommendRoomForUserAndOther(RecommendRoom recRoom, UserAccount user){
		Date date = new Date();
		
		recRoom.setCreatedId(user.getId());
		recRoom.setCreatedTime(date);
		recRoom.setIsDeleted(CommonUtils.NORMAL);
		recRoom.setModId(user.getId());
		recRoom.setModTime(date);
		
		return recRoom;
	}
	
	private static boolean isRecommendRoomCanAdd(RecommendRoom recRoom){
		//判断前台页面是否有增加RecommendRoom
		
		if(recRoom == null)
			return false;
		String building = recRoom.getBuilding();
		String room = recRoom.getRoom();
		int originalPrice = recRoom.getOriginalPrice();
		String discountDesc = recRoom.getDiscountDesc();
		
		if(isStrEmpty(building) || isStrEmpty(room) || originalPrice == 0 || isStrEmpty(discountDesc)){
			return false;
		}
		
		return true;		
	}
	
	public static boolean isRecommendRoomsCanAdd(List<RecommendRoom> rooms){
		//判断是否能保持进数据库
		
		boolean isCanAdd = true;
		
		try{
			for(RecommendRoom recRoom : rooms){
				if(recRoom != null){
					//其他项目中有可能没有用到该字段,如汇景国际,所以要加上该判定,
					String building = recRoom.getBuilding().trim();
					String room = recRoom.getRoom().trim();
					String discountDesc = recRoom.getDiscountDesc().trim();
					
					if(building.length() <= 0 || room.length() <= 0 || discountDesc.length() <= 0){
						isCanAdd = false;
						break;
					}
					
					if(building.length() > 10 || room.length() > 10 || discountDesc.length() > 10){
						isCanAdd = false;
						break;
					}
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			isCanAdd = false;
		}
		
		return isCanAdd;
		
	}
	
	public static void addRecommendRoomsByUser(IRecommendRoomServices recommendRoomServices,
			List<RecommendRoom> rooms, UserAccount user, Customer customer) throws Exception{
		//增加RecommendRoom
		
		for(RecommendRoom room : rooms){
			if(CustomerUtils.isRecommendRoomCanAdd(room)){
				room = CustomerUtils.setRecommendRoomForUserAndOther(room, user);
				room.setCustomerId(customer.getId());
				recommendRoomServices.addRecommendRoom(room);
			}
			
		}
		
	}
	
	public static void addRecommendRoomsByUser(IRecommendRoomServices recommendRoomServices,
			List<RecommendRoom> rooms, UserAccount user, Customer customer, boolean isCheck) throws Exception{
		if(isCheck){
			
			addRecommendRoomsByUser(recommendRoomServices, rooms, user, customer);
		}else{
			
			for(RecommendRoom room : rooms){
				room = CustomerUtils.setRecommendRoomForUserAndOther(room, user);
				room.setCustomerId(customer.getId());
				recommendRoomServices.addRecommendRoom(room);
				
			}
		}
		
		
	}
	
	public static void updateRecommendRoomsByUser(IRecommendRoomServices recommendRoomServices,
			List<RecommendRoom> rooms, UserAccount user, Customer customer) throws Exception{
		//修改或增加RecommendRoom
		
		for(RecommendRoom newRoom : rooms){
			if(newRoom != null){
				int rId = newRoom.getId();
				if(rId != 0){
					//表示修改
					
					RecommendRoom oldRoom = recommendRoomServices.findRecommendRoomById(rId);
					newRoom = setRecommendRoomForOldRecommendRoom(newRoom, oldRoom, user);
					newRoom.setCustomerId(customer.getId());
					recommendRoomServices.updateRecommendRoom(newRoom);
					
				}else{
					//表示增加
					if(CustomerUtils.isRecommendRoomCanAdd(newRoom)){
						newRoom = CustomerUtils.setRecommendRoomForUserAndOther(newRoom, user);
						newRoom.setCustomerId(customer.getId());
						recommendRoomServices.addRecommendRoom(newRoom);
					}
				}
				
			}
		}
		
	}
	
	public static RecommendRoom setRecommendRoomForOldRecommendRoom(RecommendRoom newRoom, 
			RecommendRoom oldRoom, UserAccount user){
		
		Date date = new Date();
		
		newRoom.setModId(user.getId());
		newRoom.setModTime(date);
		
		newRoom.setCreatedId(oldRoom.getCreatedId());
		newRoom.setCreatedTime(oldRoom.getCreatedTime());
		newRoom.setIsDeleted(oldRoom.getIsDeleted());
		
		return newRoom;
	}
	
	public static void addCustomerKnownsByCustomer(ICustomerKnownServices customerKnownServices,
			String[] knownFroms, Customer customer)	throws Exception{
		
		if(knownFroms != null){
			for(String knownFrom : knownFroms){
				CustomerKnown customerKnown = new CustomerKnown();
				customerKnown.setCustomerId(customer.getId());
				customerKnown.setKnownFrom(knownFrom);
				customerKnownServices.addCustomerKnown(customerKnown);
			}
		}
		
	}
	
	public static void addCustomerFocusByCustomer(ICustomerFocusServices customerFocusServices,
			String[] customerFocus, Customer customer)	throws Exception{
		
		if(customerFocus != null){
			for(String customerFocu : customerFocus){
				CustomerFocus cFocus = new CustomerFocus();
				cFocus.setCustomerId(customer.getId());
				cFocus.setFocusPoint(customerFocu);
				
				customerFocusServices.addCustomerFocus(cFocus);
			}
		}
		
	}
	
	
	@SuppressWarnings("rawtypes")
	public static String getFollowTypeHtml(Map followTypes){
		
		return getFollowTypeHtml(followTypes, null, null);
	}
	
	@SuppressWarnings("rawtypes")
	public static String getFollowTypeHtml(Map followTypes, List<CustomerFollow> follows, Customer customer){
		
		String visitCount = "";
		String rating = "";
		
		if(customer != null){
			
			LinkedHashMap selVisitCount = DescUtils.getInitSelForGuangZhou(null, EnumCodeTypeName.VISIT_COUNT, true); //来访次数
			LinkedHashMap selRating = DescUtils.getInitSelForGuangZhou(null, EnumCodeTypeName.RATING, true); //客户评级
			
			if(selVisitCount != null){
				visitCount = selVisitCount.get(customer.getVisitCount()+"") == null ? "" : selVisitCount.get(customer.getVisitCount()+"").toString();
				rating = selRating.get(customer.getRating()) == null ? "" : selRating.get(customer.getRating()).toString();
			}
		}
		
		//暂时先使用手拼的方式组织json, { "firstName": "Brett", "lastName":"McLaughlin", "email": "aaaa" }
		String now = CustomerUtils.getNowForString();
		
		StringBuffer typeSb = new StringBuffer();
		typeSb.append("<select name='customerFollow.followType' id='followType'>");
		
		for(Object key : followTypes.keySet()){
			Object value = followTypes.get(key);
			typeSb.append("<option value='")
				.append(key)
				.append("'>")
				.append(value)
				.append("</option>")
				;
			
		}
		typeSb.append("</select>");
		
		StringBuffer jsonData = new StringBuffer();
		jsonData.append("{\"createdTime\":\"")
			.append(now)
			.append("\",\"type\":\"")
			.append(typeSb.toString())
			.append("\"");
		
		if(follows != null){
			//跟进类型  	跟进人  	跟进日期  	跟进内容 
			
			jsonData.append(",\"followNote\":\"<tr bgcolor='#FFFFFF'>")
			
				.append("<td align='center' height='30px'>来访次数</td>")
				.append("<td align='center' height='30px'>").append(visitCount).append("</td>")
				.append("<td align='center' height='30px'>客户评级</td>")
				.append("<td align='center'>").append(rating).append("</td></tr>")
			
				.append("<tr class='gboxbg'><td align='center' height='30px'>跟进类型</td>")
				.append("<td align='center' height='30px'>跟进人</td>")
				.append("<td align='center' height='30px'>跟进日期</td>")
				.append("<td align='center'>跟进内容</td></tr>");
			
			for(CustomerFollow follow : follows){
				
				jsonData.append("<tr bgcolor='#FFFFFF'>")
					.append("<td align='center' height='30px'>")
					.append(follow.getDescFollowType()) //根据类型
					.append("</td>")
					.append("<td align='center' height='30px'>")
					.append(follow.getDescUserId()) //跟进人
					.append("</td>")
					.append("<td align='center' height='30px'>")
					.append(CustomerUtils.getDateString(follow.getCreatedTime())) //根据日期
					.append("</td>")
					.append("<td>&nbsp;&nbsp;") 
					.append(follow.getFollowDesc()) //根据内容
					.append("</td>")
					.append("</tr>")
					;
			}
			
			jsonData.append("\"");
			
		}
		
		jsonData.append("}");
		
		return jsonData.toString();
	}
	
	public static String getSuggForCheckPhone(String phone, List<Map<String,String>> userList){
		
		if(!userList.isEmpty()){
			Set<String> realNames = new HashSet<String>();
			for(Map<String,String> user : userList){
				for(String key : user.keySet()){
					String realName = user.get(key);
					realNames.add(realName);
				}
			}
			
			StringBuffer outSugg = new StringBuffer();
			outSugg.append("电话:")
				.append(phone)
				.append(",(")
				;
			
			if(!realNames.isEmpty()){
				for(String realName : realNames){
					outSugg.append(realName).append(",");
				}
				
			}
			
			outSugg.append(")已经在跟进.");
			
			return outSugg.toString();
			
		}
		
		return "";
	}
	
	public static CustomerFollow setCustomerFollowForUserAndOther(CustomerFollow customerFollow, 
			UserAccount user, Customer customer){
		
		Date date = new Date();
		
		customerFollow.setCustomerId(customer.getId());
		customerFollow.setFollowUser(user.getId());
		customerFollow.setIsDeleted(CommonUtils.NORMAL); //1表示删除,0表示正常
		customerFollow.setCreatedId(user.getId());
		//customerFollow.setCreatedTime(date);
		customerFollow.setModId(user.getId());
		customerFollow.setModTime(date);
		
		return customerFollow;
	}
	
	public static Map<String, String> getSelUserInProject(UserAccount user, IUserAccountServices userAccountServices) 
		throws Exception{
		//查询该项目下的所有客户
		
		String type = user.getAccountType();
		
		Map<String, String> selUser = new LinkedHashMap<String, String>();
		
		if(CommonUtils.ADMIN.equals(type)){
			int projectId = user.getProjectId();
			selUser =  userAccountServices.findUserAccountsByProjectId(projectId);
		}
		
		return selUser;
	}
	
	public static LinkedHashMap<String, String> setSelRatingForHuiJing(Map<String, String> oldSelRating){
		//为汇景中的客户初步评价增加"请选择",并置顶
		
		LinkedHashMap<String, String> retSelRating = new LinkedHashMap<String, String>();
		retSelRating.put("", CommonUtils.ALL);
		if(oldSelRating != null){
			for(String key : oldSelRating.keySet()){
				retSelRating.put(key, oldSelRating.get(key));
			}
		}
		
		return retSelRating;
	}
	
	public static Customer setCustomerForAddFromAction(HttpServletRequest request, Customer customer, UserAccount user){
		//根据不同的项目过来,进行相关的数据保存设置,要保证唯一确定action
		
		String actionFront = getActionFront(request);
		
		if(CustomerActionFront.OLDHUIJING.equals(actionFront)){
			customer = setCustomerForUserAndOtherForHuiJingAndShanShui(customer, user);
			
		}else if(CustomerActionFront.HUIJING.equals(actionFront)){
			customer = setCustomerForUserAndOtherForHuiJingAndShanShui(customer, user);
			
		}else if(CustomerActionFront.SHANSHUI.equals(actionFront)){
			customer = setCustomerForUserAndOtherForHuiJingAndShanShui(customer, user);
			
		}else if(CustomerActionFront.TIANLUAN.equals(actionFront)){
			customer = setCustomerForUserAndOther(customer, user, false);  //设置相关的属性,false表示非快速增加
			
		}else{
			customer = setCustomerForUserAndOther(customer, user);
			
		}
		
		return customer;
	}
	
	public static String getActionFront(HttpServletRequest request){
		String action = CustomerUtils.getActionNameFromRequest(request);
		//customer_oldhuijing!addCustomer.action
		
		String[] actions = action.split("!");
		if(actions.length <= 0){
			
			return action;
			
		}else{
			
			return actions[0];
		}
		
	}
	
	public static boolean isStrEmpty(String str){
		//直接用String的isEmpty()判断null是会出错
		if(str == null || "".equals(str.trim())){
			return true;
		}
		return false;
	}
	
	
	public static String arrayToString(String[] array, String limit){
		//String数组转成字符,limit为连接符
		String ret = "";
		for(String arr : array){
			if(!arr.trim().isEmpty()){
				ret += arr + limit;  //为空的时候不用加进去
			}
		}
		if(!ret.isEmpty()){
			ret = ret.substring(0, ret.length() - 1);	//去掉最后的连接符
		}
		return ret;
	}
	
	public static String arrayToString(String[] array){
		return arrayToString(array, ",");
	}
	
	public static String trimNull(String val){
		
		val = val.replace("null", "");
		
		return val;
	}
	
	public static void out(Object obj){
		System.out.println(obj);
	}
	
	/**
	 * 广州项目的分析类型
	 */
	public static  LinkedHashMap<String, String> getListSelCategory() {
		
		LinkedHashMap<String, String> listSelCategory = new LinkedHashMap<String, String>();
		//必填项
		listSelCategory.put(EnumCodeTypeName.HOME_DISTRICT.toString(),"居住区域");
		listSelCategory.put(EnumCodeTypeName.WORK_DISTRICT.toString(),"工作区域");
		//listSelCategory.put(EnumCodeTypeName.CUSTOMER_REGION.toString(),"区域");
		listSelCategory.put(EnumCodeTypeName.BUY_USE.toString(),"购房用途");
		listSelCategory.put(EnumCodeTypeName.BUY_COUNT.toString(),"置业次数");
		
		listSelCategory.put(EnumCodeTypeName.PRICE_AMOUNT.toString(),"意向总价");
		listSelCategory.put(EnumCodeTypeName.REQUEST_AREA.toString(),"意向面积");
		
		listSelCategory.put(EnumCodeTypeName.HOUSE_TYPE.toString(),"产品类型");
		listSelCategory.put(EnumCodeTypeName.CUSTOMER_SOURCE.toString(),"客户来源");
		
		
		//2013-07-11 修改下拉列表对应选择问卷的topic  by yjz
		listSelCategory.put(EnumCodeTypeName.GENDER.toString(),"性别");
		listSelCategory.put(EnumCodeTypeName.AGE_RANGE.toString(),"年龄");
		listSelCategory.put(EnumCodeTypeName.FAMILY_TYPE.toString(),"家庭结构");
		listSelCategory.put(EnumCodeTypeName.FAMILY_INCOME.toString(),"家庭收入");
		listSelCategory.put(EnumCodeTypeName.JOB_TYPE.toString(),"行业分类");
		listSelCategory.put(EnumCodeTypeName.JOB_INDUSTRY.toString(),"职业");
		listSelCategory.put(EnumCodeTypeName.BUY_AIM.toString(),"购房目的");
		listSelCategory.put(EnumCodeTypeName.PAY_TYPE.toString(),"付款方式");
		listSelCategory.put(EnumCodeTypeName.INTENT_BUYNUM.toString(),"意向套数");
		listSelCategory.put(EnumCodeTypeName.ROOM_TYPE.toString(),"意向户型");
		
		return listSelCategory;
	}
	
	
	/**
	 * 问卷对应的分析类型
	 */
	public static  LinkedHashMap<String, String> getListSelCategoryByQuestionId(int questionId) {		
		LinkedHashMap<String, String> listSelCategory = new LinkedHashMap<String, String>();
		//必填项
		listSelCategory.put(EnumCodeTypeName.HOME_DISTRICT.toString(),"居住区域");
		listSelCategory.put(EnumCodeTypeName.WORK_DISTRICT.toString(),"工作区域");
		//listSelCategory.put(EnumCodeTypeName.CUSTOMER_REGION.toString(),"区域");
		listSelCategory.put(EnumCodeTypeName.BUY_USE.toString(),"购房用途");
		listSelCategory.put(EnumCodeTypeName.BUY_COUNT.toString(),"置业次数");
		
		listSelCategory.put(EnumCodeTypeName.PRICE_AMOUNT.toString(),"意向总价");
		listSelCategory.put(EnumCodeTypeName.REQUEST_AREA.toString(),"意向面积");
		
		listSelCategory.put(EnumCodeTypeName.HOUSE_TYPE.toString(),"产品类型");
		listSelCategory.put(EnumCodeTypeName.CUSTOMER_SOURCE.toString(),"客户来源");
		if(questionId!=0){
			//2013-07-11 修改下拉列表对应选择问卷的topic  by yjz
			QuestionTopicCond cond = new QuestionTopicCond();
			cond.setQuestionId(questionId);
			List<QuestionTopic> list = DescUtils.getQuestionTopicServices().findQuestionTopic(cond);
			for(QuestionTopic qt:list){
				listSelCategory.put(qt.getId()+"",qt.getTopicName());
			}
			
		}else{
			listSelCategory.put(EnumCodeTypeName.VISIT_COUNT.toString(),"来访次数");
			listSelCategory.put(EnumCodeTypeName.GENDER.toString(),"性别");
			listSelCategory.put(EnumCodeTypeName.AGE_RANGE.toString(),"年龄");
			listSelCategory.put(EnumCodeTypeName.FAMILY_TYPE.toString(),"家庭结构");
			listSelCategory.put(EnumCodeTypeName.FAMILY_INCOME.toString(),"家庭收入");
			
			listSelCategory.put(EnumCodeTypeName.JOB_TYPE.toString(),"行业分类");
			listSelCategory.put(EnumCodeTypeName.JOB_INDUSTRY.toString(),"职业");
			
			listSelCategory.put(EnumCodeTypeName.BUY_AIM.toString(),"购房目的");
			listSelCategory.put(EnumCodeTypeName.PAY_TYPE.toString(),"付款方式");
			listSelCategory.put(EnumCodeTypeName.INTENT_BUYNUM.toString(),"意向套数");
			listSelCategory.put(EnumCodeTypeName.ROOM_TYPE.toString(),"意向户型");
			listSelCategory.put(EnumCodeTypeName.KNOWN_FROM.toString(),"认知途径");
			listSelCategory.put(EnumCodeTypeName.CUSTOMER_FOCUS.toString(),"关注点");
		}
		return listSelCategory;
	}
	
	
	/**
	 * 必填下拉框
	 * @return
	 */
	public static  Map<String, String> getListSelCategoryForMust() {
		
		Map<String, String> listSelCategory = new LinkedHashMap<String, String>();
		
		listSelCategory.put("", CommonUtils.EMPTY);
		 
		listSelCategory.put(EnumCodeTypeName.RATING.toString(),"客户评级");
		listSelCategory.put(EnumCodeTypeName.HOME_DISTRICT.toString(),"居住区域");
		listSelCategory.put(EnumCodeTypeName.WORK_DISTRICT.toString(),"工作区域");
		
		listSelCategory.put(EnumCodeTypeName.BUY_USE.toString(),"购房用途");
		listSelCategory.put(EnumCodeTypeName.BUY_COUNT.toString(),"置业次数");
		listSelCategory.put(EnumCodeTypeName.PRICE_AMOUNT.toString(),"意向总价");
		
		listSelCategory.put(EnumCodeTypeName.HOUSE_TYPE.toString(),"产品类型");
		listSelCategory.put(EnumCodeTypeName.CUSTOMER_SOURCE.toString(),"客户来源");
		listSelCategory.put(EnumCodeTypeName.REQUEST_AREA.toString(),"意向面积");
		
		return listSelCategory;
	}
	
	/**
	 * 非必填下拉框
	 * @return
	 */
	public static  Map<String, String> getListSelCategoryForNotMust() {
		
		Map<String, String> listSelCategory = new LinkedHashMap<String, String>();
		
		listSelCategory.put("", CommonUtils.EMPTY);
		
		listSelCategory.put(EnumCodeTypeName.VISIT_COUNT.toString(),"来访次数");
		listSelCategory.put(EnumCodeTypeName.GENDER.toString(),"性别");
		listSelCategory.put(EnumCodeTypeName.AGE_RANGE.toString(),"年龄");
		
		listSelCategory.put(EnumCodeTypeName.FAMILY_TYPE.toString(),"家庭结构");
		listSelCategory.put(EnumCodeTypeName.FAMILY_INCOME.toString(),"家庭收入");
		listSelCategory.put(EnumCodeTypeName.JOB_TYPE.toString(),"行业分类");
		
		listSelCategory.put(EnumCodeTypeName.JOB_INDUSTRY.toString(),"职业");
		listSelCategory.put(EnumCodeTypeName.BUY_AIM.toString(),"购房目的");
		listSelCategory.put(EnumCodeTypeName.PAY_TYPE.toString(),"付款方式");
		
		listSelCategory.put(EnumCodeTypeName.INTENT_BUYNUM.toString(),"意向套数");
		listSelCategory.put(EnumCodeTypeName.ROOM_TYPE.toString(),"意向户型");
		
		return listSelCategory;
	}
	
	/**
	 * 售前客户问卷报表的枚举选项
	 * @return
	 */
	public static LinkedHashMap<EnumCodeTypeName, String> getQuestionReportEnumCodeType(){

		LinkedHashMap<EnumCodeTypeName, String> listBaseCategory = new LinkedHashMap<EnumCodeTypeName, String>();
		//必填项
		listBaseCategory.put(EnumCodeTypeName.RATING,"客户评级");
		listBaseCategory.put(EnumCodeTypeName.HOME_DISTRICT,"居住区域");
		listBaseCategory.put(EnumCodeTypeName.WORK_DISTRICT,"工作区域");
		listBaseCategory.put(EnumCodeTypeName.BUY_USE,"购房用途");
		listBaseCategory.put(EnumCodeTypeName.BUY_COUNT,"置业次数");		
		listBaseCategory.put(EnumCodeTypeName.PRICE_AMOUNT,"意向总价");
		listBaseCategory.put(EnumCodeTypeName.REQUEST_AREA,"意向面积");		
		listBaseCategory.put(EnumCodeTypeName.HOUSE_TYPE,"产品类型");
		listBaseCategory.put(EnumCodeTypeName.CUSTOMER_SOURCE,"客户来源");

		//自定义内容(售前基本问卷)
		listBaseCategory.put(EnumCodeTypeName.VISIT_COUNT,"来访次数");
		listBaseCategory.put(EnumCodeTypeName.GENDER,"性别");
		listBaseCategory.put(EnumCodeTypeName.AGE_RANGE,"年龄");
		listBaseCategory.put(EnumCodeTypeName.FAMILY_TYPE,"家庭结构");
		listBaseCategory.put(EnumCodeTypeName.FAMILY_INCOME,"家庭收入");
		
		listBaseCategory.put(EnumCodeTypeName.JOB_TYPE,"行业分类");
		listBaseCategory.put(EnumCodeTypeName.JOB_INDUSTRY,"职业");
		
		listBaseCategory.put(EnumCodeTypeName.BUY_AIM,"购房目的");
		listBaseCategory.put(EnumCodeTypeName.PAY_TYPE,"付款方式");
		listBaseCategory.put(EnumCodeTypeName.INTENT_BUYNUM,"意向套数");
		listBaseCategory.put(EnumCodeTypeName.ROOM_TYPE,"意向户型");
		
		return listBaseCategory;
	}
	
	/**
	 * 判断当前用户是否可以查看改客户信息
	 * @param customerId 客户ID
	 * @param userId 用户ID
	 * @return true 可以查看
	 * */
	public static boolean isCanShowCustomer(int customerId) throws Exception{
		if(customerId == 0)return false;
		boolean ret = false;
		int userid = SessionUser.getUserId();
		
		List<Integer> proList = PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD);
		
		Customer thisCustomer = DescUtils.getCustomerServices().getCustomerById(customerId);
		if(thisCustomer.getUserId() == userid || proList.contains(new Integer(thisCustomer.getProjectId()))){
			ret = true;
		}else{
			throw new CustomerException("没有权限查看该用户信息");
		}
		return ret;
	}
	
	/**
	 * 判断登陆用户是否可以查看客户的电话
	 * @param customer
	 * @return
	 */
	public static boolean isCanShowCustomerPhone(Customer customer){
		
		if(customer == null || customer.getId() <= 0){
			return false;
		}
		
		//是否有查看电话的权限
		if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER_RETRIEVE_TEL, EnumDevFlag.GUANGZHOU)){
			
			return true;
		}
		
		int createdId = customer.getCreatedId(); //客户创建id
		int customerUserId = customer.getUserId(); //客户所属的用户id
		int userId = SessionUser.getUserId(); //登陆用户id
		
		if(userId == createdId || userId == customerUserId){
			
			return true;
		}
		
		List<Integer> followCustomerIdList = CustomerOnlyFollowUtils.getFollowCustomerIds(); //获取登陆者只能跟进的客户的id list
		if(CommonUtils.isCollectionEmpty(followCustomerIdList)){
			
			return false;
		}
		
		int customerId = customer.getId(); //客户id
		if(followCustomerIdList.contains(customerId)){
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * 根据客户id判断是否可以显示号码
	 * @param customerId
	 * @return
	 */
	public static boolean isCanShowCustomerPhone(int customerId){
		
		Customer customer = MyPropertyUtils.getCustomerServices().getCustomerById(customerId);
		
		return isCanShowCustomerPhone(customer);
	}
	
}
