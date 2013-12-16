package com.ihk.customer.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContProjectId;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerFocus;
import com.ihk.customer.data.pojo.CustomerFollow;
import com.ihk.customer.data.pojo.CustomerKnown;
import com.ihk.customer.data.services.ICustomerFocusServices;
import com.ihk.customer.data.services.ICustomerFollowServices;
import com.ihk.customer.data.services.ICustomerKnownServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.saleunit.data.pojo.Question;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetail;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetailCond;
import com.ihk.saleunit.data.pojo.QuestionAnwser;
import com.ihk.saleunit.data.pojo.QuestionAnwserCond;
import com.ihk.saleunit.data.pojo.QuestionCond;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;
import com.ihk.saleunit.data.services.IQuestionAnswerDetailServices;
import com.ihk.saleunit.data.services.IQuestionAnwserServices;
import com.ihk.saleunit.data.services.IQuestionServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.setting.data.pojo.Block;
import com.ihk.setting.data.pojo.BlockCond;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.ProvinceCond;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.services.IBlockServices;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.setting.data.services.IProvinceServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.phone.PhoneUtils;

/**
 *  修改action
 */
@SuppressWarnings("rawtypes")
public class GuangZhouUpdateAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICustomerServices customerServices;  //spring的注解,自动引入set,get方法
	@Autowired
	ICustomerFollowServices customerFollowServices;
	@Autowired
	ICustomerKnownServices customerKnownServices;
	@Autowired
	ICodeTypeServices codeTypeServices;
	@Autowired
	ICustomerFocusServices customerFocusServices;
	@Autowired
	IProvinceServices provinceServices;
	@Autowired
	ICityServices cityServices;
	@Autowired
	IRegionServices regionServices;
	@Autowired
	IBlockServices blockServices;
	@Autowired
	ICompanyProjectServices comProServices;
	@Autowired IQuestionAnwserServices questionAnwserServices;
	@Autowired IQuestionAnswerDetailServices questionAnswerDetailServices;
	@Autowired IQuestionTopicServices questionTopicServices;
	@Autowired IQuestionServices questionServices;
	
	List<QuestionAnswerDetail> questionDetailList;
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
		boolean isTwentyFourLater = CommonUtils.is24HoursLater(customer.getCreatedTime());
		request.setAttribute("isTwentyFourLater", isTwentyFourLater);
		//跟进内容不用分页
		List<CustomerFollow> customerFollows = customerFollowServices.findCustomerFollowByCustomerId(customer.getId());
				
		////获知途径
		List<CustomerKnown> knownList = customerKnownServices.findCustomerKnownByCustomerId(id);
		List<String> knowns = new ArrayList<String>();
		for(CustomerKnown known : knownList){
			knowns.add(known.getKnownFrom());
		}
		
		//广州项目
		List<CustomerFocus> focusList = customerFocusServices.findCustomerFocusByCustomerId(id);
		List<String> focus = new ArrayList<String>();
		for(CustomerFocus f : focusList){
			focus.add(f.getFocusPoint());
		}
		
		String selectedProjectName = comProServices.findCompanyProjectById(customer.getProjectId()).getProjectName();
		
		session.setAttribute("c", customer); //要保存到session中才能拿到,页面以及跟进的时候使用
		session.setAttribute("follows", customerFollows); //跟进内容
		session.setAttribute("knowns", knowns);  //获知途径
		
		session.setAttribute("focus", focus); //关注点(广州项目)
		
		session.setAttribute("selectedProjectName", selectedProjectName);
		
		init(customer);
		if(PermissionUtils.isReportOnlySale()){
			session.setAttribute("userRole", "sales");
		}
		
		//新增对汇景项目用户的判断2012.3.8
		if(ContProjectId.isOldHuiJing(customer.getProjectId())){
			
			return "queryHuiJingCustomerByIdForUpdate";
		}
		//新增对侨鑫项目用户的判断2012.5.8
		if(ContProjectId.isQiaoXin(customer.getProjectId())){
			
			initForQiaoXin();
			return "queryQiaoXinCustomerByIdForUpdate";
		}
		
		//新增对中信山语湖用户的判断2013.6.9
		if(ContProjectId.SHAN_YU_HU == customer.getProjectId()){
			initForShanYuHu();
			return "queryShanYuHuCustomerByIdForUpdate";
		}
		
		
		/** 大学小筑 以及 要用到自定义的项目   
		 * 2012-9-6 暂时根据登陆的用户.. 有销控中心权限的就使用 自定义, 之后在完全使用销控中心界面之后 就放开此权限
		 *	
		 * 2012-10-10 所有开发CDOE为customer_guangzhou 的都迁移到新的界面  
		 * 
		 * 现在分为乔鑫 , 汇景 , 老的广州项目(大学小筑之前的 使用 录客额外选项为固定的界面) ,新的广州项目(大学小筑之后开的
		 * dev_code为customer_guangzhou的所有项目 使用 自定义额外选项)
		 * 
		 * 2012-11-05 取消所有自定义页面 
		 * jira key = HDXMXSGLXT-657
		 * 都使用 return = forAdd 的页面
		 * */
//		if(OldProjectIdBeanUtils.isOldProjectId(customer.getProjectId()) || customer.getCompanyId() ==21 || customer.getCompanyId() == 26){//老的项目  项目列表要提出来
//			return "queryCustomerByIdForUpdate";
//		}
		QuestionAnwserCond cond = new QuestionAnwserCond();
		cond.setPreCustomerId(customer.getId()+"");
		List<QuestionAnwser> alist = questionAnwserServices.findQuestionAnwser(cond);
		QuestionAnwser anwser;
		if(alist == null || alist.size() == 0){
			anwser = new QuestionAnwser();
		}else{
			 anwser = alist.get(0);
		}
		QuestionAnswerDetailCond dcond = new QuestionAnswerDetailCond();
		dcond.setAnwserId(anwser.getId()+"");
		questionDetailList = questionAnswerDetailServices.findQuestionAnswerDetail(dcond);
		return "queryCustomerAndQuestionByIdForUpdate";
		
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
					
					customer = CustomerUtils.setCustomerFromOldCustomerForGuangZhou(customer, oldCustomer); //设置页面不能获取的相关数据
					
					customer = CustomerUtils.setCustomerForUpdate(customer, user);  //设置修改的用户id及修改时间
					
					//获知途径 customerKnownServices,删除掉再增加
					String[] knownFroms = request.getParameterValues("knownFrom"); 
					customerKnownServices.deleteCustomerKnownByCustomerId(customerId);
					CustomerUtils.addCustomerKnownsByCustomer(customerKnownServices, knownFroms, oldCustomer);
					
					//关注点,删除掉再增加
					String[] customerFocus = request.getParameterValues("customerFocus") ; //关注点
					customerFocusServices.deleteCustomerFocusByCusotmerId(customerId);
					CustomerUtils.addCustomerFocusByCustomer(customerFocusServices, customerFocus, customer);
					
					customer = modifyPhoneFrom(customer, oldCustomer);
					
					customerServices.updateCustomer(customer);
					
				}
				
			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();

			setSuggestion(e.getMessage());
			
			updateIsSucc = false;
			
		}
		
		if(updateIsSucc){
			
			setSuggestion(CommonUtils.SUCCSUGG);
		}else{			
			setSuggestion(CommonUtils.FAILSUGG+":"+getSuggestion());
		}
		
		session.setAttribute("customerId", customerId);
		
		return "queryCustomerById";
		
	}
	

	public String validateQuestion() throws IOException{
		//判断选填中的必填内容不能为空
			//String query=request.getParameter("query");
		Map<String, String> map = new HashMap<String, String>();
			if(formMap != null){
				String questionid = formMap.get("quesId")[0];
				QuestionAnwserCond qaCond = new QuestionAnwserCond();
		    	qaCond.setPreCustomerId(customer.getId()+"");
		    	qaCond.setQuestionId(questionid+"");
		    	if(questionAnwserServices.findQuestionAnwser(qaCond).size()!=0){
		    		QuestionAnwser tqa =  questionAnwserServices.findQuestionAnwser(qaCond).get(0);
		    		List<QuestionAnswerDetail> deList = questionAnswerDetailServices.findQuestionAnswerDetail(new QuestionAnswerDetailCond().setAnwserId(tqa.getId()+""));
		    		for(QuestionAnswerDetail c : deList){
			    		if(c.getIsRequired()){
			    			String other = null;
			    			if(this.formMap.get("hhother"+c.getId())!=null){
			    				other = this.formMap.get("hhother"+c.getId())[0];
			    			}
			    			String[] anws = this.formMap.get("hh"+c.getId());
			    			//if(anws == null&&(other == null||other.trim() == "")){
			    			if(anws == null&&CommonUtils.isStrEmpty(other)){
			    				//setSuggestion("该次保存失败,选填中带*的选项不能为空");
			    				map.put("mustInput", "false");
			    				CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
			    				return null;
			    			}
			    		}
			    	}
		    	}else{
		    		List<QuestionTopic> tocl = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(Integer.parseInt(questionid)));
		    		for(QuestionTopic c : tocl){
			    		if(c.getIsRequired()){
			    			String other = null;
			    			if(this.formMap.get("hhother"+c.getId())!=null){
			    				other = this.formMap.get("hhother"+c.getId())[0];
			    			}
			    			String[] anws = this.formMap.get("hh"+c.getId());
			    			//if(anws == null&&(other == null||other.trim() == "")){
			    			if(anws == null&&CommonUtils.isStrEmpty(other)){
			    				//setSuggestion("该次保存失败,选填中带*的选项不能为空");
			    				map.put("mustInput", "false");
			    				CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
			    				return null;
			    			}else{
			    				
			    			}
			    		}
			    	}
		    	}
		    	
				
		    	
			}
		map.put("mustInput", "true");
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		return null;
	}
	
	public String updateCustomerAndQuestion() throws Exception{
		boolean updateIsSucc = true;
		
		final int customerId = customer.getId();
		
		final HttpSession session = request.getSession();
		
		try{
			
			new MyTransationTemplate() {

				@Override
				protected void doExecuteCallback() throws Exception {
					
					UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
					Customer oldCustomer = customerServices.getCustomerById(customerId);
					customer = CustomerUtils.setCustomerFromOldCustomerForGuangZhou(customer, oldCustomer); //设置页面不能获取的相关数据
					
					customer = CustomerUtils.setCustomerForUpdate(customer, user);  //设置修改的用户id及修改时间
					
					//获知途径 customerKnownServices,删除掉再增加
					String[] knownFroms = request.getParameterValues("knownFrom"); 
					customerKnownServices.deleteCustomerKnownByCustomerId(customerId);
					CustomerUtils.addCustomerKnownsByCustomer(customerKnownServices, knownFroms, customer);
					
					//关注点,删除掉再增加
					String[] customerFocus = request.getParameterValues("customerFocus") ; //关注点
					customerFocusServices.deleteCustomerFocusByCusotmerId(customerId);
					CustomerUtils.addCustomerFocusByCustomer(customerFocusServices, customerFocus, customer);
					
					customerServices.updateCustomer(customer);
					
				}
				
			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();

			setSuggestion(e.getMessage());
			
			updateIsSucc = false;
			
		}
		session.setAttribute("customerId", customerId);
		if(selectQuestionId!=0){
			QuestionAnwserCond qaCond = new QuestionAnwserCond();
	    	qaCond.setPreCustomerId(customer.getId()+"");
	    	qaCond.setQuestionId(selectQuestionId+"");
	    	if(questionAnwserServices.findQuestionAnwser(qaCond).size()!=0){
		    	updateQuestion(customer.getId(),selectQuestionId);
	    	}else{
	    		addQuestion(customer.getId(),selectQuestionId);
	    	}
    	}
		
		if(updateIsSucc){
			
			setSuggestion(CommonUtils.SUCCSUGG);
		}else{
			
			setSuggestion(CommonUtils.FAILSUGG+":"+getSuggestion());
		}
		
		
		
		return "queryCustomerById";
		
	}
	
		private  Map<String,String[]> formMap;	
		private int selectQuestionId;
	
	    public int getSelectQuestionId() {
	    	return selectQuestionId;
	    }

	    public void setSelectQuestionId(int selectQuestionId) {
	    	this.selectQuestionId = selectQuestionId;
	    }

		private void updateQuestion(int custid, int selectQuestionId) throws Exception{
	    	if( formMap == null|| formMap.size() == 0)return;
	    	
	    	QuestionAnwserCond qaCond = new QuestionAnwserCond();
	    	qaCond.setPreCustomerId(custid+"");
	    	qaCond.setQuestionId(selectQuestionId+"");
	    	QuestionAnwser tqa = null;
	    	
	    	if(questionAnwserServices.findQuestionAnwser(qaCond).size()!=0){
	    		tqa = questionAnwserServices.findQuestionAnwser(qaCond).get(0);
		    	List<QuestionAnswerDetail> deList = questionAnswerDetailServices.findQuestionAnswerDetail(new QuestionAnswerDetailCond().setAnwserId(tqa.getId()+""));
		    	
				for(QuestionAnswerDetail c : deList){
					String[] anws = this.formMap.get("hh"+c.getId());
					if(anws == null || anws.length == 0){
						String[] tm = {"-1"};
						anws = tm;
					}
					String sanws = "";
					String[] questoc;
					if(c.getAnwserContent().trim().equals("")){
						String other = "";
						try {
							other = formMap.get("hhother"+c.getId())[0];
						} catch (Exception e) {
						}
						c.setOtherOption(other);
						questionAnswerDetailServices.updateQuestionAnswerDetail(c);
					}else{
						questoc = c.getAnwserContent().split("\r\n");
						
						for(int i = 0 ; i < questoc.length ; i ++){
							for(int j = 0 ; j < anws.length ; j++){
								int para = -1;
								try {
									para = Integer.parseInt(anws[j]);
								} catch (Exception e) {
									continue;
								}
								if(para == i){
									questoc[i] = "1"+questoc[i].substring(1);
									break;
								}else{
									questoc[i] = "0"+questoc[i].substring(1);
								}
							}
							sanws += questoc[i]+ "\r\n";
						}
						String other = "";
						try {
							other = formMap.get("hhother"+c.getId())[0];
						} catch (Exception e) {
						}
						c.setTopicGroup(c.getTopicGroup());
						c.setTopicName(c.getTopicName());
						c.setTopicType(c.getTopicType());
						c.setOtherOption(other);
						c.setIsDeleted("0");
						c.setModId(SessionUser.getUserId());
						c.setModTime(new Date());
						c.setAnwserId(tqa.getId());
						c.setAnwserContent(sanws);
//						c.setTopicId(c.getId());
						questionAnswerDetailServices.updateQuestionAnswerDetail(c);
					}
				}
	    	}else{
	    		
	    	}
	    	
	    }
		
		
		 private void addQuestion(int custid,int questionid){
		    	//录入基本售前问卷的情况,quetionid为null
		    	if(questionid!=0){ 
			    	//新建客户时，新增对应的问卷
			    	//if( formMap == null|| formMap.size() == 0)return;
					QuestionAnwser tqa = new QuestionAnwser();
					tqa.setQuestionId(questionid);
					tqa.setIsDeleted("0");
					tqa.setCreatedId(SessionUser.getUserId());
					tqa.setCreatedTime(new Date());
					tqa.setModId(SessionUser.getUserId());
					tqa.setModTime(tqa.getCreatedTime());
					tqa.setPreCustomerId(custid);
					questionAnwserServices.addQuestionAnwser(tqa);
					List<QuestionTopic> tocl = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(questionid));
					//循环获取问卷题目逻辑
					for(QuestionTopic c : tocl){
						String[] anws = this.formMap.get("hh"+c.getId());
						String sanws = "";
						
						String[] questoc = c.getTopicContent().split("\r\n");
						for(int i = 0 ; i < questoc.length ;i ++){
							boolean yt = false;
							if ( anws == null || anws.length == 0){
								sanws += "0:"+questoc[i]+ "\r\n";
								continue;
							}else{
								for(String anid : anws){
									if(anid.equals(i+"")){
										sanws += "1:"+questoc[i]+ "\r\n";
										yt = true;
									}
								}
							}
							if(yt)continue;
							sanws += "0:"+questoc[i]+ "\r\n";
						}
						String other = "";
						other = formMap.get("hhother"+c.getId())[0];
						QuestionAnswerDetail anDe = new QuestionAnswerDetail();
						anDe.setTopicGroup(c.getTopicGroup());
						anDe.setTopicName(c.getTopicName());
						anDe.setTopicType(c.getTopicType());
						anDe.setOtherOption(other);
						anDe.setIsDeleted("0");
						anDe.setModId(SessionUser.getUserId());
						anDe.setModTime(new Date());
						anDe.setCreatedId(SessionUser.getUserId());
						anDe.setCreatedTime(anDe.getModTime());
						anDe.setAnwserId(tqa.getId());
						anDe.setAnwserContent(sanws);
						anDe.setTopicId(c.getId());
						anDe.setColumn13(c.getFillType());
						questionAnswerDetailServices.addQuestionAnswerDetail(anDe);			
					}
		    	}
				//新建用户时，同时新建客户对应的其他问卷(空白问卷)
		    	/*
				QuestionCond cond = new QuestionCond();
				cond.setCompanyProjectId(customer.getProjectId());
				List<Question> qList=questionServices.findQuestion(cond);
				for(Question q: qList){
					QuestionAnwser qa = new QuestionAnwser();
					if(q.getId()!=Integer.parseInt(questionid)){
						qa.setQuestionId(q.getId());
						try {
							CommonPojoUtils.initPojoCommonFiled(qa);
						} catch (Exception e) {
							e.printStackTrace();
						}
						qa.setPreCustomerId(custid);
						questionAnwserServices.addQuestionAnwser(qa);
						List<QuestionTopic> qtList = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(q.getId()));
						for(QuestionTopic qt:qtList){
							String[] anws = null;
							String sanws = "";
							
							String[] questoc = qt.getTopicContent().split("\r\n");
							for(int i = 0 ; i < questoc.length ;i ++){
								boolean yt = false;
								if ( anws == null || anws.length == 0){
									sanws += "0:"+questoc[i]+ "\r\n";
									continue;
								}else{
									for(String anid : anws){
										if(anid.equals(i+"")){
											sanws += "1:"+questoc[i]+ "\r\n";
											yt = true;
										}
									}
								}
								if(yt)continue;
								sanws += "0:"+questoc[i]+ "\r\n";
							}
							QuestionAnswerDetail qad = new QuestionAnswerDetail();
							qad.setAnwserId(qa.getId());
							qad.setTopicId(qt.getId());
							qad.setTopicName(qt.getTopicName());
							qad.setTopicType(qt.getTopicType());
							qad.setOtherOption("");
							qad.setAnwserContent(sanws);
							qad.setColumn13(qt.getFillType());
							try {
								CommonPojoUtils.initPojoCommonFiled(qad);
							} catch (Exception e) {
								e.printStackTrace();
							}
							questionAnswerDetailServices.addQuestionAnswerDetail(qad);
						}
					}
					
				}*/
				
				
				
		    }
	
	/////
	    
	//修改号码归属地
	private Customer modifyPhoneFrom(Customer newCustomer, Customer oldCustomer){
		
		if(CommonUtils.isStrEmpty(newCustomer.getPhone())){
			
			newCustomer.setPhoneFrom(oldCustomer.getPhoneFrom());
			return newCustomer;
		}
		
		if(!newCustomer.getPhone().equals(oldCustomer.getPhone())){
			
			newCustomer = PhoneUtils.postPhone(newCustomer);
		}else{
			
			newCustomer.setPhoneFrom(oldCustomer.getPhoneFrom());
		}
		
		return newCustomer;
		
	}
	
	private void init(Customer customer){
		
		selGender = DescUtils.getInitSelForGuangZhou(selGender, EnumCodeTypeName.GENDER, true, customer);
		selAgeRange = DescUtils.getInitSelForGuangZhou(selAgeRange, EnumCodeTypeName.AGE_RANGE, true, customer);
		selJobType = DescUtils.getInitSelForGuangZhou(selJobType, EnumCodeTypeName.JOB_TYPE, true, customer);
		initKnownFrom(customer); //
		//selRequestArea = DescUtils.getInitSel(selRequestArea, CodeTypeName.REQUEST_AREA, true); 改为输入框
		selRoomType = DescUtils.getInitSelForGuangZhou(selRoomType, EnumCodeTypeName.ROOM_TYPE, true, customer);
		//selPriceAmount = DescUtils.getInitSel(selPriceAmount, CodeTypeName.PRICE_AMOUNT, true); 改为输入框
		selBuyAim = DescUtils.getInitSelForGuangZhou(selBuyAim, EnumCodeTypeName.BUY_AIM, true, customer);
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType, EnumCodeTypeName.PAY_TYPE, true, customer);
		
		selBuyUse = DescUtils.getInitSelForGuangZhou(selBuyUse, EnumCodeTypeName.BUY_USE, true, customer);
		selBuyCount = DescUtils.getInitSelForGuangZhou(selBuyCount, EnumCodeTypeName.BUY_COUNT, true, customer);
		selHouseType = DescUtils.getInitSelForGuangZhou(selHouseType, EnumCodeTypeName.HOUSE_TYPE, true, customer);
		selCustomerSource = DescUtils.getInitSelForGuangZhou(selCustomerSource, EnumCodeTypeName.CUSTOMER_SOURCE, true, customer);
		
		selVisitCount = DescUtils.getInitSelForGuangZhou(selVisitCount, EnumCodeTypeName.VISIT_COUNT, true, customer);
		selFamilyType = DescUtils.getInitSelForGuangZhou(selFamilyType, EnumCodeTypeName.FAMILY_TYPE, true, customer);
		selFamilyIncome = DescUtils.getInitSelForGuangZhou(selFamilyIncome, EnumCodeTypeName.FAMILY_INCOME, true, customer); //家庭收入
		
		selJobIndustry = DescUtils.getInitSelForGuangZhou(selJobIndustry, EnumCodeTypeName.JOB_INDUSTRY, true, customer);
		selIntentBuynum = DescUtils.getInitSelForGuangZhou(selIntentBuynum, EnumCodeTypeName.INTENT_BUYNUM, true, customer);
		selCustomerFocus = DescUtils.getInitSelForGuangZhou(selCustomerFocus, EnumCodeTypeName.CUSTOMER_FOCUS, customer.getProjectId() + "");
		
		selRating = DescUtils.getInitSelForGuangZhou(selRating, EnumCodeTypeName.RATING, true, customer); //客户评级
		
		initSelProvince(); //
		
		initSelHomeCity(customer); //
		initSelHomeRegion(customer); //
		initSelWorkCity(customer); //
		initSelWorkRegion(customer); //
		
		//initSelHomeBlock(customer);
		//initSelWorkBlock(customer);
	}
	
	//侨鑫项目使用,不用每一次都调用
	private void initForQiaoXin(){
		
		//selIntentLease = DescUtils.getInitSelEmptyAndTrueFalse(selIntentLease);
		selIntentLease = DescUtils.getInitSelForGuangZhou(selIntentLease, EnumCodeTypeName.QIAOXIN_INTENT_LEASE, true);
		selWage = DescUtils.getInitSelForGuangZhou(selWage, EnumCodeTypeName.WAGE, true);
		selProductClaim = DescUtils.getInitSelForGuangZhou(selProductClaim, EnumCodeTypeName.PRODUCT_CLAIM, true);
		
	}
	
	/**
	 * 中信山语湖
	 */
	private void initForShanYuHu(){
		selProductClaim = DescUtils.getInitSelForGuangZhou(selProductClaim, EnumCodeTypeName.PRODUCT_CLAIM, true);
	}
	
	private String customerId;
	/**
	 * jira - 781
	 * @throws Exception 
	 * */
	public String updateQuestion() throws Exception{
		//获取客户
		int id = Integer.parseInt(customerId);
		Customer customer = customerServices.getCustomerById(id);
		//获取项目问卷
		int companyProjectId = customer.getProjectId();
		QuestionCond questionCond = new QuestionCond();
		questionCond.setCompanyProjectId(companyProjectId);
		List<QuestionTopic> questionTopics;
		Question question;
		QuestionAnwser anwser = null;
		try {//没有设定问卷
			question = questionServices.findByCompanyProjectId(customer.getProjectId());
			questionTopics = this.questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(question.getId()));
		
		//查找答卷 
		QuestionAnwserCond cond = new QuestionAnwserCond();
		cond.setPreCustomerId(id+"");
		List<QuestionAnwser> alist = questionAnwserServices.findQuestionAnwser(cond);
		if(alist.size() > 0)
			anwser = alist.get(0);
		
		//1 如果完全没有则新建一套没有填写的答卷
		if(anwser == null){
			anwser = new QuestionAnwser();
			anwser.setQuestionId(question.getId());
			anwser.setIsDeleted("0");
			anwser.setCreatedId(SessionUser.getUserId());
			anwser.setCreatedTime(new Date());
			anwser.setModId(SessionUser.getUserId());
			anwser.setModTime(anwser.getCreatedTime());
			anwser.setPreCustomerId(id);
			questionAnwserServices.addQuestionAnwser(anwser);
		}
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("customerId", id);
			return "suc";
		}
		
		QuestionAnswerDetailCond dcond = new QuestionAnswerDetailCond();
		dcond.setAnwserId(anwser.getId()+"");
		questionDetailList = questionAnswerDetailServices.findQuestionAnswerDetail(dcond);
		Map<Integer,QuestionAnswerDetail> qad = new HashMap<Integer, QuestionAnswerDetail>();
		for(QuestionAnswerDetail o : questionDetailList){
			qad.put(o.getTopicId(), o);
		}
		
			for(QuestionTopic c : questionTopics){
				if(qad.get(new Integer(c.getId())) != null)continue;
				
				StringBuffer sanws = new StringBuffer();
				
				String[] questoc = c.getTopicContent().split("\r\n");
				for(int i = 0 ; i < questoc.length ;i ++){
					sanws.append("0:"+questoc[i]+ "\r\n");
				}
				
				String other = "";
				QuestionAnswerDetail anDe = new QuestionAnswerDetail();
				anDe.setTopicGroup(c.getTopicGroup());
				anDe.setTopicName(c.getTopicName());
				anDe.setTopicType(c.getTopicType());
				anDe.setOtherOption(other);
				anDe.setIsDeleted("0");
				anDe.setModId(SessionUser.getUserId());
				anDe.setModTime(new Date());
				anDe.setCreatedId(SessionUser.getUserId());
				anDe.setCreatedTime(anDe.getModTime());
				anDe.setAnwserId(anwser.getId());
				anDe.setAnwserContent(sanws.toString());
				anDe.setTopicId(c.getId());
				questionAnswerDetailServices.addQuestionAnswerDetail(anDe);
			}
		request.getSession().setAttribute("customerId", id);
		return "suc";
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	private Customer customer;
	
	private LinkedHashMap selProvince; //省
	private LinkedHashMap selHomeCity; //居住市
	private LinkedHashMap selHomeRegion; //居住区域
	private LinkedHashMap selWorkCity; //工作市
	private LinkedHashMap selWorkRegion; //工作区域
	private LinkedHashMap selHomeBlock; //居住板块
	private LinkedHashMap selWorkBlock; //工作板块
	
	private LinkedHashMap selBuyUse; //购房用途
	private LinkedHashMap selBuyCount; //置业次数
	private LinkedHashMap selPriceAmount; 	//意向总价
	
	private LinkedHashMap selHouseType; //产品类型
	private LinkedHashMap selCustomerSource; //客户来源
	
	private LinkedHashMap selVisitCount; //来访次数
	private LinkedHashMap selGender; //性别
	
	private LinkedHashMap selAgeRange;  //年龄
	
	private LinkedHashMap selFamilyType; //家庭结构
	private LinkedHashMap selFamilyIncome; //家庭收入
	
	private LinkedHashMap selRating; //客户评级
	
	private LinkedHashMap selJobType; 	//行业结构（行业分类）
	private LinkedHashMap selJobIndustry; //职业
	
	private LinkedHashMap selBuyAim;  //购房目的
	private LinkedHashMap selPayType;  //付款方式
	
	private LinkedHashMap selRequestArea; 	//意向面积
	private LinkedHashMap selIntentBuynum; //意向套数
	private LinkedHashMap selRoomType; 	 //意向户型
	
	private LinkedHashMap selKnownFrom;  //认知(获知)途径 
	private LinkedHashMap selKnownFrom1;  //认知(获知)途径 -->广州
	private LinkedHashMap selKnownFrom2;  //认知(获知)途径 -->广州
	private LinkedHashMap selKnownFrom3;  //认知(获知)途径 -->广州
	
	private LinkedHashMap selCustomerFocus; //关注点
	
	private LinkedHashMap selIntentLease; //是否有名额购房(侨鑫)
	private LinkedHashMap selWage; //客户形象(侨鑫)
	private LinkedHashMap selProductClaim; //发动力(侨鑫)
	
	private String suggestion; //操作提示
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void setSelRating(LinkedHashMap selRating) {
		this.selRating = selRating;
	}
	
	public LinkedHashMap getSelRating() {
		return selRating;
	}
	
	public LinkedHashMap getSelGender() { 
		return selGender; 
	} 
	
	public void setSelGender(LinkedHashMap selGender) { 
		this.selGender = selGender; 
	} 
    
	public LinkedHashMap getSelAgeRange() { 
		return selAgeRange; 
	} 
	
	public void setSelAgeRange(LinkedHashMap selAgeRange) { 
		this.selAgeRange = selAgeRange; 
	} 
    
	public LinkedHashMap getSelJobType() { 
		return selJobType; 
	} 
	
	public void setSelJobType(LinkedHashMap selJobType) { 
		this.selJobType = selJobType; 
	} 

	public LinkedHashMap getSelKnownFrom() { 
		return selKnownFrom; 
	} 
	
	public void setSelKnownFrom(LinkedHashMap selKnownFrom) { 
		this.selKnownFrom = selKnownFrom; 
	} 
    
	@SuppressWarnings("unchecked")
	public void initKnownFrom(Customer customer) {  
		if(this.selKnownFrom==null){
			
			this.selKnownFrom = DescUtils.getInitSelForGuangZhou(selKnownFrom, EnumCodeTypeName.KNOWN_FROM, customer.getProjectId() + "");
			
			String action = CustomerUtils.getActionNameFromRequest(request);
			if(action.contains("guangzhou")){
				
				if(selKnownFrom1 == null){
					selKnownFrom1 = new LinkedHashMap();
				}
				
				Set keys = selKnownFrom.keySet();
				for(Object key : keys){
					
					Object value = selKnownFrom.get(key);
					String val = value == null ? "" : value.toString();
					String k = key.toString();
					
					selKnownFrom1.put(k, val);
					
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
    
	public LinkedHashMap getSelRoomType() { 
		return selRoomType; 
	} 
	
	public void setSelRoomType(LinkedHashMap selRoomType) { 
		this.selRoomType = selRoomType; 
	} 

	public LinkedHashMap getSelPriceAmount() { 
		return selPriceAmount; 
	} 
	
	public void setSelPriceAmount(LinkedHashMap selPriceAmount) { 
		this.selPriceAmount = selPriceAmount; 
	} 
	
	public LinkedHashMap getSelBuyAim() { 
		return selBuyAim; 
	} 
	
	public void setSelBuyAim(LinkedHashMap selBuyAim) { 
		this.selBuyAim = selBuyAim; 
	} 
    
	public LinkedHashMap getSelPayType() { 
		return selPayType; 
	} 
	
	public void setSelPayType(LinkedHashMap selPayType) { 
		this.selPayType = selPayType; 
	} 
    
	public LinkedHashMap getSelBuyUse() {
		return selBuyUse;
	}

	public void setSelBuyUse(LinkedHashMap selBuyUse) {
		this.selBuyUse = selBuyUse;
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

	public LinkedHashMap getSelVisitCount() {
		return selVisitCount;
	}

	public void setSelVisitCount(LinkedHashMap selVisitCount) {
		this.selVisitCount = selVisitCount;
	}

	public LinkedHashMap getSelFamilyType() {
		return selFamilyType;
	}

	public void setSelFamilyType(LinkedHashMap selFamilyType) {
		this.selFamilyType = selFamilyType;
	}

	public LinkedHashMap getSelFamilyIncome() {
		return selFamilyIncome;
	}

	public void setSelFamilyIncome(LinkedHashMap selFamilyIncome) {
		this.selFamilyIncome = selFamilyIncome;
	}

	public LinkedHashMap getSelJobIndustry() {
		return selJobIndustry;
	}

	public void setSelJobIndustry(LinkedHashMap selJobIndustry) {
		this.selJobIndustry = selJobIndustry;
	}

	public LinkedHashMap getSelIntentBuynum() {
		return selIntentBuynum;
	}

	public void setSelIntentBuynum(LinkedHashMap selIntentBuynum) {
		this.selIntentBuynum = selIntentBuynum;
	}
	
	public LinkedHashMap getSelCustomerFocus() {
		return selCustomerFocus;
	}
	
	public void setSelCustomerFocus(LinkedHashMap selCustomerFocus) {
		this.selCustomerFocus = selCustomerFocus;
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
	
	public void setSelHomeBlock(LinkedHashMap selHomeBlock) {
		this.selHomeBlock = selHomeBlock;
	}
	
	public LinkedHashMap getSelHomeBlock() {
		return selHomeBlock;
	}
	
	@Deprecated
	@SuppressWarnings("unchecked")
	public void initSelHomeBlock(Customer customer){
		if(this.selHomeBlock == null){
			selHomeBlock = new LinkedHashMap();
			selHomeBlock.put("", CommonUtils.EMPTY);
		}
		
		try {
			if(customer != null){
				
				BlockCond blockCond = new BlockCond();
				blockCond.setProjectId(customer.getProjectId());
				blockCond.setRegionId(customer.getHomeRegion());
				
				List<Block> blockList = blockServices.findBlockByRegionIdAndProjectId(blockCond);
				for(Block block : blockList){
					selHomeBlock.put(block.getBlockId(), block.getBlockName());
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
	}
	
	public void setSelWorkBlock(LinkedHashMap selWorkBlock) {
		this.selWorkBlock = selWorkBlock;
	}
	
	public LinkedHashMap getSelWorkBlock() {
		return selWorkBlock;
	}
	
	@Deprecated
	@SuppressWarnings("unchecked")
	public void initSelWorkBlock(Customer customer){
		if(this.selWorkBlock == null){
			selWorkBlock = new LinkedHashMap();
			selWorkBlock.put("", CommonUtils.EMPTY);
		}
		
		try {
			if(customer != null){
				
				BlockCond blockCond = new BlockCond();
				blockCond.setProjectId(customer.getProjectId());
				blockCond.setRegionId(customer.getWorkRegion());
				
				List<Block> blockList = blockServices.findBlockByRegionIdAndProjectId(blockCond);
				for(Block block : blockList){
					selWorkBlock.put(block.getBlockId(), block.getBlockName());
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
	
	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
		request.getSession().setAttribute("suggestion", suggestion);  
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
	
	public LinkedHashMap getSelIntentLease() {
		return selIntentLease;
	}

	public void setSelIntentLease(LinkedHashMap selIntentLease) {
		this.selIntentLease = selIntentLease;
	}

	public LinkedHashMap getSelWage() {
		return selWage;
	}

	public void setSelWage(LinkedHashMap selWage) {
		this.selWage = selWage;
	}

	public LinkedHashMap getSelProductClaim() {
		return selProductClaim;
	}
	
	public void setSelProductClaim(LinkedHashMap selProductClaim) {
		this.selProductClaim = selProductClaim;
	}

	public List<QuestionAnswerDetail> getQuestionDetailList() {
		return questionDetailList;
	}

	public void setQuestionDetailList(List<QuestionAnswerDetail> questionDetailList) {
		this.questionDetailList = questionDetailList;
	}

	public Map<String, String[]> getFormMap() {
		return formMap;
	}

	public void setFormMap(Map<String, String[]> formMap) {
		this.formMap = formMap;
	}

}
