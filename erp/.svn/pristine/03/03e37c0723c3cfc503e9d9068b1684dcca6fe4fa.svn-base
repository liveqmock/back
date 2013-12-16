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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContCompanyId;
import com.ihk.constanttype.ContProjectId;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.constanttype.EnumInputMemoryType;
import com.ihk.constanttype.EnumOperLogType;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.Customer;
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
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.OperLog;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.ProvinceCond;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.services.IBlockServices;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.setting.data.services.IOperLogServices;
import com.ihk.setting.data.services.IProvinceServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.InputMemory;
import com.ihk.user.data.pojo.InputMemoryCond;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.IInputMemoryServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.exception.CustomerException;
import com.ihk.utils.projectid.OldProjectIdBeanUtils;


/**
 *  广州项目的录入
 */
@SuppressWarnings("rawtypes")
public class GuangZhouInputAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GuangZhouInputAction.class);
	
	@Autowired(required=false)
	ICustomerServices customerServices;  //spring的注解,自动引入set,get方法
	@Autowired
	ICustomerKnownServices customerKnownServices;
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
	IBlockServices blockServices;
	@Autowired
	ICustomerFocusServices customerFocusServices;
	@Autowired
	ICompanyProjectServices companyProjectServices; 
	@Autowired
	IInputMemoryServices inputMemoryServices;
	@Autowired 
	IOperLogServices iOperLogServices;
	@Autowired
	ICustomerFollowServices customerFollowServices;
	@Autowired
	ICompanyProjectServices comProServices;
	
	private final String CACHE_CUSTOMER_KEY = "cacheCustomer";
	
	/**
	 * 留底
	 * @return
	 * @throws Exception
	 */
//	public String doSomeForAddCustomer() throws Exception{
//		
//		//在跳转到增加页面之前,做一些相关的操作,例如清空一些session,以及一些下拉框字典的获取
//		
//		HttpSession session = request.getSession();
//		session.removeAttribute("c");
//		
//		UserAccount user = SessionUser.getSessionUser();
//		
//		String deleteSession = request.getParameter("deleteSession");
//		if(!"false".equals(deleteSession)){
//			//说明不是从增加后跳过来的,要清空session
//			session.removeAttribute("suggestion");
//			removeProCityRegAndOther();
//			
//			init(null);
//		}else{
//			//从增加过来的,设置省市区板块下拉框的值
//			
//			Customer sessionCustomer = (Customer) session.getAttribute("cacheCustomer");  //刚刚增加成功的customer
//			init(sessionCustomer);
//			
//		}
//		
//		if("input".equals(deleteSession)){
//			setSuggestion("录入数据出现异常,请重新录入");
//		}
//		if("token".equals(deleteSession)){
//			
//			setSuggestion("重复提交,可能已经录入成功,请查询后再录入");
//			operLogForInputAgain();
//		}
//		
//		//设置上次录入的项目,产品类型
//		project = initInputMemoryForProject(user);
//		/*if(project != null){
//			SessionUser.getSessionUser().setProjectId(project.getId());
//		}*/
//		houseType = initInputMemoryForHouseType(user);
//		
//		if(customer == null){
//			customer= new Customer();
//		}
//		customer.setVisitDate(CustomerUtils.getNowForString());
//		
//		//新增对汇景项目用户的判断2012.3.8
//		if(ContProjectId.isOldHuiJing(user.getProjectId())){
//			project = companyProjectServices.findCompanyProjectById(ContProjectId.OLD_HUI_JING);
//			return "forHuiJingAdd";
//		}
//		//新增对侨鑫项目用户的判断2012.5.8
//		if(ContProjectId.isQiaoXin(user.getProjectId())){
//			project = companyProjectServices.findCompanyProjectById(ContProjectId.QIAO_XIN);
//			initForQiaoXin();
//			return "forQiaoXinAdd";
//		}
//		
//			/** 大学小筑 以及 要用到自定义的项目   
//			 * 2012-9-6 暂时根据登陆的用户.. 有销控中心权限的就使用 自定义, 之后在完全使用销控中心界面之后 就放开此权限
//			 *	
//			 * 2012-10-10 所有开发CDOE为customer_guangzhou 的都迁移到新的界面  
//			 * 
//			 * 现在分为乔鑫 , 汇景 , 老的广州项目(大学小筑之前的 使用 录客额外选项为固定的界面) ,新的广州项目(大学小筑之后开的
//			 * dev_code为customer_guangzhou的所有项目 使用 自定义额外选项)
//			 * 
//			 * 2012-11-05 取消所有自定义页面 
//			 * jira key = HDXMXSGLXT-657
//			 * 都使用 return = forAdd 的页面
//			 * */
//		if(SessionUser.getCompanyId() == 21){//老的项目  项目列表要提出来
//			if(project == null)
//				project = new CompanyProject();
//			//project = companyProjectServices.findCompanyProjectById(ContProjectId.OLD_HUI_JING);
//			return "forAdd";
//		}
//		
//		if(OldProjectIdBeanUtils.isOldProjectId(SessionUser.getProjectId())){
//			project = new CompanyProject();
//			project = this.companyProjectServices.findCompanyProjectById(SessionUser.getProjectId());
//			
//			return "forAdd";
//		}
//		
//		if(project == null){
//			
//			project = DescUtils.getCompanyProjectByProjectId(user.getProjectId());
//		}
//		
//		if(project == null){
//			
//			project = new CompanyProject();
//		}
//		
//    	return "forQuestionAdd";
//		
//	}
	
	public String doSomeForAddCustomer() throws Exception{
		logger.info("xxx"+PermissionUtils.getUserProjectIdListByUid(4,EnumPrivCode.PRECUSTOMER__DELETE));
		
		//在跳转到增加页面之前,做一些相关的操作,例如清空一些session,以及一些下拉框字典的获取

		HttpSession session = request.getSession();
		session.removeAttribute("c");
		
		UserAccount user = SessionUser.getSessionUser();
		
		String deleteSession = request.getParameter("deleteSession");
		if(!"false".equals(deleteSession)){
			//说明不是从增加后跳过来的,要清空session
			session.removeAttribute("suggestion");
			removeProCityRegAndOther();
			
			init(null);
		}else{
			//从增加过来的,设置省市区板块下拉框的值
			
			Customer sessionCustomer = (Customer) session.getAttribute(CACHE_CUSTOMER_KEY);  //刚刚增加成功的customer
			init(sessionCustomer);
			
		}
		
		if("input".equals(deleteSession)){
			setSuggestion("录入数据出现异常,请重新录入");
		}
		if("token".equals(deleteSession)){
			
			setSuggestion("重复提交,可能已经录入成功,请查询后再录入");
			operLogForInputAgain();
		}
		
		//设置上次录入的项目,产品类型
		project = initInputMemoryForProject(user);
		/*if(project != null){
			SessionUser.getSessionUser().setProjectId(project.getId());
		}*/
		houseType = initInputMemoryForHouseType(user);
		
		if(customer == null){
			customer= new Customer();
		}
		customer.setVisitDate(CustomerUtils.getNowForString());
		
		//新增对汇景项目用户的判断2012.3.8
		if(ContProjectId.isOldHuiJing(user.getProjectId())){
			project = companyProjectServices.findCompanyProjectById(ContProjectId.OLD_HUI_JING);
			return "forHuiJingAdd";
		}
		//新增对侨鑫项目用户的判断2012.5.8
		if(ContProjectId.isQiaoXin(user.getProjectId())){
			project = companyProjectServices.findCompanyProjectById(ContProjectId.QIAO_XIN);
			initForQiaoXin();
			return "forQiaoXinAdd";
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
		if(SessionUser.getCompanyId() == 21 || SessionUser.getCompanyId() == 26){//安徽 以及江苏项目 使用老页面
			if(project == null)
				project = new CompanyProject();
			//project = companyProjectServices.findCompanyProjectById(ContProjectId.OLD_HUI_JING);
			return "forAdd";
		}
		
		project = new CompanyProject();
		project = this.companyProjectServices.findCompanyProjectById(SessionUser.getProjectId());
			
		
		if(project == null){
			
			project = DescUtils.getCompanyProjectByProjectId(user.getProjectId());
		}
		
		if(project == null){
			
			project = new CompanyProject();
		}
		
		
		
    	return "forQuestionAdd";
		
	}
	
	/**
	 * 2013 2 18
	 * */
	public String doSomeForAddCustomer1() throws Exception{
		logger.info("xxx"+PermissionUtils.getUserProjectIdListByUid(4,EnumPrivCode.PRECUSTOMER__DELETE));
		
		//在跳转到增加页面之前,做一些相关的操作,例如清空一些session,以及一些下拉框字典的获取
		
		HttpSession session = request.getSession();
		session.removeAttribute("c");
		
		UserAccount user = SessionUser.getSessionUser();
		
		if(project==null){
		//设置上次录入的项目,产品类型
			project = initInputMemoryForProject(user);
		}
		/*if(project != null){
			SessionUser.getSessionUser().setProjectId(project.getId());
		}*/
		QuestionCond cond = new QuestionCond();
		if(project!=null){
			cond.setCompanyProjectId(project.getId());
			questionList = questionServices.findQuestion(cond);
		}
		
		String deleteSession = request.getParameter("deleteSession");
		if(!"false".equals(deleteSession)){
			//说明不是从增加后跳过来的,要清空session
			session.removeAttribute("suggestion");
			removeProCityRegAndOther();
			
			init(null);
		}else{
			//从增加过来的,设置省市区板块下拉框的值
			
			Customer sessionCustomer = (Customer) session.getAttribute(CACHE_CUSTOMER_KEY);  //刚刚增加成功的customer
			init(sessionCustomer);
			
		}
		
		if("input".equals(deleteSession)){
			setSuggestion("录入数据出现异常,请重新录入");
		}
		if("token".equals(deleteSession)){
			
			setSuggestion("重复提交,可能已经录入成功,请查询后再录入");
			operLogForInputAgain();
		}
		
		houseType = initInputMemoryForHouseType(user);
		
		if(customer == null){
			customer= new Customer();
		}
		customer.setVisitDate(CustomerUtils.getNowForString());
		
		//新增对汇景项目用户的判断2012.3.8
		if(ContProjectId.isOldHuiJing(user.getProjectId())){
			project = companyProjectServices.findCompanyProjectById(user.getProjectId());
			return "forHuiJingAdd";
		}
		
		//新增对侨鑫项目用户的判断2012.5.8
		if(ContProjectId.isQiaoXin(user.getProjectId())){
			project = companyProjectServices.findCompanyProjectById(user.getProjectId());
			initForQiaoXin();
			return "forQiaoXinAdd";
		}
		
		//新增对中信山语湖用户的判断2013.6.9
		if(ContProjectId.SHAN_YU_HU == user.getProjectId()){
			project = companyProjectServices.findCompanyProjectById(user.getProjectId());
			initForShanYuHu();
			return "forShanYuhu";
		}
		
		if(project == null)
			project = new CompanyProject();
		//project = companyProjectServices.findCompanyProjectById(ContProjectId.OLD_HUI_JING);
		return "forAdd";
		
		
	}
	
	public String addCustomer() throws Exception{
		
		final UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					Date date = new Date();
					
					//去掉改判定2012.11.6,因智能提示框不能完全判断项目名称和id是否一致,更改判断方式2012.11.7
					String projectName = request.getParameter("projectName");
					//tmpProject = companyProjectServices.findCompanyProjectIsExistsByProjectNameAndCompanyId(projectName, ContCompanyId.GUANG_ZHOU);
					
					boolean isFit = companyProjectServices.findCompanyProjectIsFitByNameAndId(projectName, customer.getProjectId());
					if(!isFit)
						throw new CustomerException("项目名称和id不一致");
					
					tmpProject = companyProjectServices.findCompanyProjectById(customer.getProjectId());
					
					customer.setCustomerNo(CustomerUtils.getTmpCustomerNo()); //临时利用时间生成10位的客户编号
					customer.setIsDeleted(CommonUtils.NORMAL);  ///0表示正常,1表示删除
					customer.setCompanyId(tmpProject.getCompanyId());
					customer.setProjectId(tmpProject.getId());
					customer.setTeamId(user.getTeamId());
					customer.setUserId(user.getId());
					customer.setCreatedId(user.getId());
					customer.setModId(user.getId());
					customer.setCreatedTime(date);
					customer.setModTime(date);
					if(CustomerUtils.isStrEmpty(customer.getCustomerState())){
						customer.setCustomerState(CommonUtils.CUSTOMER_STATE_FOLLOW);
					}

					customer.setVisitCount(1);
					
					String[] knownFroms = request.getParameterValues("knownFrom"); //获知途径 customerKnownServices
					String[] customerFocus = request.getParameterValues("customerFocus") ; //关注点
					
					customerServices.saveCustomer(customer);
					
					CustomerUtils.addCustomerKnownsByCustomer(customerKnownServices, knownFroms, customer);
					
					CustomerUtils.addCustomerFocusByCustomer(customerFocusServices, customerFocus, customer);
					
					//缓存省市区及板块用的project id
					cacheProCityRegAndOther(customer);
					
					setSuggestion(CommonUtils.SUCCSUGG);
					
				}
			}.execute();
			
			
		}catch(CustomerException ce){
			
			setSuggestion(ce.getMessage());
			
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
			
		}
		
		try{
			//记忆项目的录入(放到事务外部,不应该因记忆内容保存的问题而影响正常的录入)
			InputMemory menory = new InputMemory();
			menory.setUserId(user.getId());
			
			menory.setMemoryType(EnumInputMemoryType.CUSTOMER_PROJECT.name());
			menory.setMemoryId(tmpProject.getId());
			inputMemoryServices.addInputMemory(menory);
			
			menory.setMemoryType(EnumInputMemoryType.CUSTOMER_HOUSE_TYPE.name());
			menory.setMemoryId(Integer.parseInt(customer.getHouseType()));
			inputMemoryServices.addInputMemory(menory);
			
		}catch(Exception e){
		}
		
		init(null);
		
		return "customerAdd";
	}
	
	private  Map<String,String[]> formMap;
	private  List<QuestionTopic> tocl;
	private  String questionid;
	
	public String validateQuestion() throws IOException{
		//判断选填中的必填内容不能为空
			//String query=request.getParameter("query");
		Map<String, String> map = new HashMap<String, String>();
			if(formMap != null){
				questionid = formMap.get("quesId")[0];
		    	tocl = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(Integer.parseInt(questionid)));
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
		map.put("mustInput", "true");
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		return null;
	}
	
	
	public String addCustomerAndQuestion() throws Exception{
		
		final UserAccount user = (UserAccount) request.getSession().getAttribute(CommonUtils.USER_SESSION_KEY);
		if(formMap != null){
			questionid = formMap.get("quesId")[0];
			tocl = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(Integer.parseInt(questionid)));
		}else{
			questionid="0";
		}
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					Date date = new Date();
					
					tmpProject = companyProjectServices.findCompanyProjectById(customer.getProjectId());
					
					customer.setCustomerNo(CustomerUtils.getTmpCustomerNo()); //临时利用时间生成10位的客户编号
					customer.setIsDeleted(CommonUtils.NORMAL);  ///0表示正常,1表示删除
					customer.setCompanyId(tmpProject.getCompanyId());
					customer.setProjectId(tmpProject.getId());
					customer.setTeamId(user.getTeamId());
					customer.setUserId(user.getId());
					customer.setCreatedId(user.getId());
					customer.setModId(user.getId());
					customer.setCreatedTime(date);
					customer.setModTime(date);
					
					if(CustomerUtils.isStrEmpty(customer.getCustomerState())){
						customer.setCustomerState(CommonUtils.CUSTOMER_STATE_FOLLOW);
					}
					
					String[] knownFroms = request.getParameterValues("knownFrom"); //获知途径 customerKnownServices
					String[] customerFocus = request.getParameterValues("customerFocus") ; //关注点
					
					customerServices.saveCustomer(customer);
					
					CustomerUtils.addCustomerKnownsByCustomer(customerKnownServices, knownFroms, customer);
					
					CustomerUtils.addCustomerFocusByCustomer(customerFocusServices, customerFocus, customer);
					
					addQuestion(customer.getId());//保存自定义选项
					
					//缓存省市区及板块用的project id
					cacheProCityRegAndOther(customer);
					
					setSuggestion(CommonUtils.SUCCSUGG);
					
				}
			}.execute();
			
			
		}catch(CustomerException ce){
			
			setSuggestion(ce.getMessage());
			
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
			
		}
		
		try{
			//记忆项目的录入(放到事务外部,不应该因记忆内容保存的问题而影响正常的录入)
			InputMemory menory = new InputMemory();
			menory.setUserId(user.getId());
			
			menory.setMemoryType(EnumInputMemoryType.CUSTOMER_PROJECT.name());
			menory.setMemoryId(tmpProject.getId());
			inputMemoryServices.addInputMemory(menory);
			
			
			/*menory.setMemoryType(EnumInputMemoryType.CUSTOMER_HOUSE_TYPE.name());
			menory.setMemoryId(Integer.parseInt(customer.getHouseType()));
			inputMemoryServices.addInputMemory(menory);*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		init(null);
		
		return "suc";
	}

	@Autowired IQuestionAnwserServices questionAnwserServices;
	@Autowired IQuestionTopicServices questionTopicServices;
	@Autowired IQuestionServices questionServices;
	@Autowired IQuestionAnswerDetailServices questionAnswerDetailServices;
    private void addQuestion(int custid){
    	//录入基本售前问卷的情况,quetionid为null
    	if(!questionid.equals("0")){ 
	    	//新建客户时，新增对应的问卷
	    	//if( formMap == null|| formMap.size() == 0)return;
			QuestionAnwser tqa = new QuestionAnwser();
			tqa.setQuestionId(Integer.parseInt(questionid));
			tqa.setIsDeleted("0");
			tqa.setCreatedId(SessionUser.getUserId());
			tqa.setCreatedTime(new Date());
			tqa.setModId(SessionUser.getUserId());
			tqa.setModTime(tqa.getCreatedTime());
			tqa.setPreCustomerId(custid);
			questionAnwserServices.addQuestionAnwser(tqa);
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
	
    private int changeProjectId;
    /**
     * 为了保证使用固定新建用户和自定义新建用户项目  进行选择的项目验证
     * @throws IOException 
     * 
     * 2012-11-05 因为全部用统一的界面  此处废弃
     * 同时修改JSP 不在触发访问
     * */
    public String changeProject() throws IOException{
    	SessionUser.getSessionUser().setProjectId(changeProjectId);
    	int coId = DescUtils.getCompanyIdByProjectId(changeProjectId);
    	if(OldProjectIdBeanUtils.isOldProjectId(changeProjectId) || coId == 21){//选的是老项目
    			CustomerUtils.writeResponse(response, "input1");
    	}else{
    			CustomerUtils.writeResponse(response, "input2");
    	}
    	return null;
    }
	////
	
	private void operLogForInputAgain(){

		try{
			int userId = SessionUser.getUserId();
			int projectId = SessionUser.getProjectId();
			String userName = SessionUser.getUserName();
			Date date = new Date();
			
			OperLog oper = new OperLog();
			oper.setLogTime(date);
			oper.setDevFlag(DescUtils.getCompanyProjectByProjectId(projectId).getDevCode());
			oper.setLogType(EnumOperLogType.INPUT_CUSTOMER_AGAIN.toString());
			
			oper.setUserId(userId);
			oper.setProjectId(projectId);
			
			oper.setLogDesc("userName = " + userName);
			
			iOperLogServices.addOperLog(oper);
			
		}catch(Exception e){
		}
	}
	
	private void init(Customer customer){
		
		selGender = DescUtils.getInitSelForGuangZhou(selGender, EnumCodeTypeName.GENDER, true);
		selAgeRange = DescUtils.getInitSelForGuangZhou(selAgeRange, EnumCodeTypeName.AGE_RANGE, true);
		selJobType = DescUtils.getInitSelForGuangZhou(selJobType, EnumCodeTypeName.JOB_TYPE, true);
		initKnownFrom(); //
		//selRequestArea = DescUtils.getInitSel(selRequestArea, CodeTypeName.REQUEST_AREA, true); 改为输入框
		selRoomType = DescUtils.getInitSelForGuangZhou(selRoomType, EnumCodeTypeName.ROOM_TYPE, true);
		//selPriceAmount = DescUtils.getInitSel(selPriceAmount, CodeTypeName.PRICE_AMOUNT, true); 改为输入框
		selBuyAim = DescUtils.getInitSelForGuangZhou(selBuyAim, EnumCodeTypeName.BUY_AIM, true);
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType, EnumCodeTypeName.PAY_TYPE, true);
		
		selBuyUse = DescUtils.getInitSelForGuangZhou(selBuyUse, EnumCodeTypeName.BUY_USE, true);
		selBuyCount = DescUtils.getInitSelForGuangZhou(selBuyCount, EnumCodeTypeName.BUY_COUNT, true);
		selHouseType = DescUtils.getInitSelForGuangZhou(selHouseType, EnumCodeTypeName.HOUSE_TYPE, true);
		//selCustomerSource = DescUtils.getInitSelForGuangZhou(selCustomerSource, EnumCodeTypeName.CUSTOMER_SOURCE, true); //客户来源
		selCustomerSource = DescUtils.getInitSelForGuangZhou(selCustomerSource, EnumCodeTypeName.CUSTOMER_SOURCE, true, ContCompanyId.AN_HUI); //客户来源
		
		selVisitCount = DescUtils.getInitSelForGuangZhou(selVisitCount, EnumCodeTypeName.VISIT_COUNT, true);
		selFamilyType = DescUtils.getInitSelForGuangZhou(selFamilyType, EnumCodeTypeName.FAMILY_TYPE, true);
		
		//selFamilyIncome = DescUtils.getInitSelForGuangZhou(selFamilyIncome, EnumCodeTypeName.FAMILY_INCOME, true); //家庭收入
		selFamilyIncome = DescUtils.getInitSelOnlyEmpty(selFamilyIncome);//根据不同的项目来获取
		
		selJobIndustry = DescUtils.getInitSelForGuangZhou(selJobIndustry, EnumCodeTypeName.JOB_INDUSTRY, true);
		selIntentBuynum = DescUtils.getInitSelForGuangZhou(selIntentBuynum, EnumCodeTypeName.INTENT_BUYNUM, true);
		selCustomerFocus = DescUtils.getInitSelForGuangZhou(selCustomerFocus, EnumCodeTypeName.CUSTOMER_FOCUS);
		
		//selRating = DescUtils.getInitSelForGuangZhou(selRating, EnumCodeTypeName.RATING, true);  //客户评级
		selRating = DescUtils.getInitSelOnlyEmpty(selRating);
		
		//2013.3.4增加,如果customer为空,就查选定项目对应的默认省份及城市,放到前台js去执行,customer_guangzhou_question.js中的selectFun()
		
		/*if(customer == null){
			
			if(project != null){
				//当customer为空,且选择的项目不为空,才获取对应的项目的默认省份及城市
				int proId = project.getProvinceId();
				int cityId = project.getCityId();
				
				if(proId != 0 && cityId != 0){
					
					customer = new Customer();
					
					customer.setHomeProvince(proId);
					customer.setHomeCity(cityId);
					
					customer.setWorkProvince(proId);
					customer.setWorkCity(cityId);
				}
				
			}
		}
		*/
		
		initSelProvince(); //
		
		initSelHomeCity(customer); //
		initSelHomeRegion(customer); //
		initSelWorkCity(customer); //
		initSelWorkRegion(customer); //
		
		initSelHomeBlock(customer);
		initSelWorkBlock(customer);
		
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
	
	private void cacheProCityRegAndOther(Customer customer){
		
		HttpSession session = request.getSession();
		session.setAttribute(CACHE_CUSTOMER_KEY, customer);
		
	}
	
	private void removeProCityRegAndOther(){
		
		HttpSession session = request.getSession();
		session.removeAttribute(CACHE_CUSTOMER_KEY);
		
	}
	
	private CompanyProject initInputMemoryForProject(UserAccount user){
		
		InputMemoryCond cond = new InputMemoryCond();
		cond.setUserId(user.getId() + "");
		cond.setMemoryType(EnumInputMemoryType.CUSTOMER_PROJECT.name());
		
		InputMemory memory = inputMemoryServices.findInputMemoryForNew(cond);
		if(memory != null){
			
			int projectId = memory.getMemoryId();
			return companyProjectServices.findCompanyProjectById(projectId);
		}else{
			
			return null;
		}
		
	}
	
	private int initInputMemoryForHouseType(UserAccount user){
		
		InputMemoryCond cond = new InputMemoryCond();
		cond.setUserId(user.getId() + "");
		cond.setMemoryType(EnumInputMemoryType.CUSTOMER_HOUSE_TYPE.name());
		
		InputMemory memory = inputMemoryServices.findInputMemoryForNew(cond);
		
		if(memory != null){
			return memory.getMemoryId();
		}
		
		return 0;
	}
	
	
	
	///
	
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
	
	private CompanyProject project; //上次录入的项目
	private int houseType; //上次录入的产品类型
	
	private CompanyProject tmpProject; //增加的时候临时保存的project
	
	private List<Question> questionList; //售前问卷列表
	private String customerId;
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public CompanyProject getTmpProject() {
		return tmpProject;
	}
	
	public void setTmpProject(CompanyProject tmpProject) {
		this.tmpProject = tmpProject;
	}
	
	public int getHouseType() {
		return houseType;
	}

	public void setHouseType(int houseType) {
		this.houseType = houseType;
	}

	public void setProject(CompanyProject project) {
		this.project = project;
	}
	
	public CompanyProject getProject() {
		return project;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
    
	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	@SuppressWarnings("unchecked")
	public void initKnownFrom() {  
		if(this.selKnownFrom==null){
			//this.selKnownFrom = codeTypeServices.findCodeListForSel(CodeTypeName.KNOWN_FROM,getProjectId());
			this.selKnownFrom = DescUtils.getInitSelForGuangZhou(selKnownFrom, EnumCodeTypeName.KNOWN_FROM);
			
			String action = CustomerUtils.getActionNameFromRequest(request);
			if(action.contains("guangzhou")){
				
				if(selKnownFrom1 == null){
					selKnownFrom1 = new LinkedHashMap();
				}
//				if(selKnownFrom2 == null){
//					selKnownFrom2 = new LinkedHashMap();
//				}
//				if(selKnownFrom3 == null){
//					selKnownFrom3 = new LinkedHashMap();
//				}
				
				Set keys = selKnownFrom.keySet();
				for(Object key : keys){
					Object value = selKnownFrom.get(key);
					String val = value == null ? "" : value.toString();
					String k = key.toString();
					
				//	if(k.startsWith("1")){
						
						selKnownFrom1.put(k, val);
//					}else if(k.startsWith("2")){
//						
//						selKnownFrom2.put(k, val);
//					}else{
//						
//						selKnownFrom3.put(k, val);
//					}
					
				}
			}
		}
	} 
	
	
	private List<QuestionTopic> tocList;
	private int proId;
	private int questId;
	private List<QuestionAnswerDetail> questionDetailList;
	
	public String findTocList(){
		try {
				if(questId!=0){
					Question ques = questionServices.findQuestionById(questId);
					tocList = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(ques.getId()));
					questId = ques.getId();
				}
		} catch (Exception e) {
			tocList = new ArrayList<QuestionTopic>();
		}
		return "question";
	}
	
	public String findExistQuestionAnswer(){
		return "suc";
	}
	
	public String findAnswerList() throws Exception{
		try {
			QuestionAnwserCond cond = new QuestionAnwserCond();
			cond.setPreCustomerId(customerId);
			cond.setQuestionId(questId+"");
			List<QuestionAnwser> alist = questionAnwserServices.findQuestionAnwser(cond);
			if(alist.size()==0){
				if(questId!=0){
					tocList = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(questId));
				}
			}else{
				QuestionAnwser anwser;
				if(alist == null || alist.size() == 0){
					anwser = new QuestionAnwser();
				}else{
					anwser = alist.get(0);
				}
				QuestionAnswerDetailCond dcond = new QuestionAnswerDetailCond();
				dcond.setAnwserId(anwser.getId()+"");
				questionDetailList = questionAnswerDetailServices.findQuestionAnswerDetail(dcond);
				
				return "answer";
			}
		} catch (Exception e) {
			tocList = new ArrayList<QuestionTopic>();
		}
		return "question";
	}
	
	public String findQuestionList(){	
		QuestionCond cond = new QuestionCond();
		cond.setCompanyProjectId(proId);
		try {
			questionList = questionServices.findQuestion(cond);
			tocList = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(questionList.get(0).getId()));
		} catch (Exception e) {
			
		}
		return "question";
	}
	
	public String pickQuestionList() throws IOException{
		String content = ""; //默认值
		String selectedQuestionId =request.getParameter("selectedQuestionId");
		String projectId = request.getParameter("proId");
		if("0".equals(projectId)||"".equals(projectId)){
			return null;
		}
		this.selKnownFrom = DescUtils.getInitSelForGuangZhou(selKnownFrom, EnumCodeTypeName.KNOWN_FROM, projectId.equals("")?"0":projectId);
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
		try{
			QuestionCond cond = new QuestionCond();
			cond.setCompanyProjectId(Integer.parseInt(projectId));
			questionList = questionServices.findQuestion(cond);
			LinkedHashMap<String, String> questionMap = new LinkedHashMap<String, String>();
			LinkedHashMap<String, String> questionSelectedMap = new LinkedHashMap<String, String>();
			StringBuffer sb = new StringBuffer();
			
			questionMap.put("0", "基本售前问卷");
			
			//questionSelectedMap.put("0", value);
			if(selectedQuestionId==null){
				for(Question question : questionList){
					questionMap.put(question.getId() + "", question.getQuestionName());
					questionSelectedMap.put(question.getId() + "", question.getAreaId()+"");
					if(question.getAreaId()==1){
						questionSelectedMap.put("0", "0");
					}
				}
				if(questionSelectedMap.get("0")==null){
					questionSelectedMap.put("0", "1");
				}
			}else{
				for(Question question : questionList){
					questionMap.put(question.getId() + "", question.getQuestionName());
					questionSelectedMap.put(question.getId() + "", "0");
					if(question.getAreaId()==1){
						questionSelectedMap.put("0", "0");
					}
				}
				questionSelectedMap.put("0", "0");
				questionSelectedMap.put(selectedQuestionId, "1");
				
			}
			
			
			if(questionMap.keySet().size() > 0){
				Set<String> keys = questionMap.keySet();
				for(String key : keys){
					String isDefault=questionSelectedMap.get(key);
					if(isDefault.equals("0")){
						String value = questionMap.get(key);
						sb.append("<option value=\"")
							.append(key)
							.append("\">")
							.append(value)
							.append("</option>")
							;
					}
					if(isDefault.equals("1")){
						String value = questionMap.get(key);
						sb.append("<option  value=\"")
							.append(key+"\"")
							.append(" selected='selected'")
							.append(">")
							.append(value)
							.append("</option>")
						;
					}
				
					
				}
				
			}
			
			String getContent = sb.toString();
			if(!CustomerUtils.isStrEmpty(getContent)){
				content = getContent;
			}
			
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		CustomerUtils.writeResponse(response, content);
		
		return null;
	}
	

	/**
	 * 根据公司去获取对应的问卷
	 * @return
	 * @throws IOException
	 */
	public String pickQuestionListCompany() throws IOException{
		String content = ""; //默认值
		String companyId = request.getParameter("companyId");
		try{
			QuestionCond cond = new QuestionCond();			
			cond.setCompanyIds(CommonUtils.stringToList(companyId));
			List<Map<String,Object>> list = questionServices.findTopCompanyQuestion(cond);
			
			LinkedHashMap<String, String> questionMap = new LinkedHashMap<String, String>();

			questionMap.put("0", "基本售前问卷");	
			for(Map<String,Object> line : list){
				questionMap.put(line.get("questionId") + "", line.get("projectName").toString()+"_"+line.get("questionName").toString()+"(回答数:"+line.get("answerCount").toString()+")");
			}
			
			StringBuffer sb = new StringBuffer();
								
			
			if(questionMap.keySet().size() > 0){
				Set<String> keys = questionMap.keySet();
				for(String key : keys){
						String value = questionMap.get(key);
						sb.append("<option value=\"")
							.append(key)
							.append("\">")
							.append(value)
							.append("</option>")
							;					
				}
				
			}
			
			String getContent = sb.toString();
			if(!CustomerUtils.isStrEmpty(getContent)){
				content = getContent;
			}
			
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		CustomerUtils.writeResponse(response, content);
		
		return null;
	}
	
	public String getBaseQuestion(){
		String projectId=request.getParameter("proId");
		selGender = DescUtils.getInitSelForGuangZhou(selGender, EnumCodeTypeName.GENDER, true, projectId);
		selAgeRange = DescUtils.getInitSelForGuangZhou(selAgeRange, EnumCodeTypeName.AGE_RANGE, true, projectId);
		selJobType = DescUtils.getInitSelForGuangZhou(selJobType, EnumCodeTypeName.JOB_TYPE, true, projectId);
		if(this.selKnownFrom==null){
			this.selKnownFrom = DescUtils.getInitSelForGuangZhou(selKnownFrom, EnumCodeTypeName.KNOWN_FROM,false ,projectId);
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
		//selRequestArea = DescUtils.getInitSel(selRequestArea, CodeTypeName.REQUEST_AREA, true); 改为输入框
		selRoomType = DescUtils.getInitSelForGuangZhou(selRoomType, EnumCodeTypeName.ROOM_TYPE, true, projectId);
		//selPriceAmount = DescUtils.getInitSel(selPriceAmount, CodeTypeName.PRICE_AMOUNT, true); 改为输入框
		selBuyAim = DescUtils.getInitSelForGuangZhou(selBuyAim, EnumCodeTypeName.BUY_AIM, true, projectId);
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType, EnumCodeTypeName.PAY_TYPE, true, projectId);
		
		selBuyUse = DescUtils.getInitSelForGuangZhou(selBuyUse, EnumCodeTypeName.BUY_USE, true, projectId);
		selBuyCount = DescUtils.getInitSelForGuangZhou(selBuyCount, EnumCodeTypeName.BUY_COUNT, true, projectId);
		selHouseType = DescUtils.getInitSelForGuangZhou(selHouseType, EnumCodeTypeName.HOUSE_TYPE, true, projectId);
		//selCustomerSource = DescUtils.getInitSelForGuangZhou(selCustomerSource, EnumCodeTypeName.CUSTOMER_SOURCE, true); //客户来源
		selCustomerSource = DescUtils.getInitSelForGuangZhou(selCustomerSource, EnumCodeTypeName.CUSTOMER_SOURCE, true, ContCompanyId.AN_HUI); //客户来源
		
		selVisitCount = DescUtils.getInitSelForGuangZhou(selVisitCount, EnumCodeTypeName.VISIT_COUNT, true, projectId);
		selFamilyType = DescUtils.getInitSelForGuangZhou(selFamilyType, EnumCodeTypeName.FAMILY_TYPE, true, projectId);
		
		//selFamilyIncome = DescUtils.getInitSelForGuangZhou(selFamilyIncome, EnumCodeTypeName.FAMILY_INCOME, true); //家庭收入
		selFamilyIncome = DescUtils.getInitSelForGuangZhou(selFamilyIncome,EnumCodeTypeName.FAMILY_INCOME, true, projectId);//根据不同的项目来获取
		
		selJobIndustry = DescUtils.getInitSelForGuangZhou(selJobIndustry, EnumCodeTypeName.JOB_INDUSTRY, true, projectId);
		selIntentBuynum = DescUtils.getInitSelForGuangZhou(selIntentBuynum, EnumCodeTypeName.INTENT_BUYNUM, true, projectId);
		selCustomerFocus = DescUtils.getInitSelForGuangZhou(selCustomerFocus, EnumCodeTypeName.CUSTOMER_FOCUS,false, projectId);
		
		//selRating = DescUtils.getInitSelForGuangZhou(selRating, EnumCodeTypeName.RATING, true);  //客户评级
		selRating = DescUtils.getInitSelOnlyEmpty(selRating);
		return "success";
	}
	
	public List<QuestionTopic> getTocList() {
		return tocList;
	}

	public void setTocList(List<QuestionTopic> tocList) {
		this.tocList = tocList;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getQuestId() {
		return questId;
	}

	public void setQuestId(int questId) {
		this.questId = questId;
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
	
	@SuppressWarnings("unchecked")
	public void initSelHomeBlock(Customer customer){
		if(this.selHomeBlock == null){
			selHomeBlock = new LinkedHashMap();
			selHomeBlock.put("", CommonUtils.EMPTY);
		}
		
	}
	
	public void setSelWorkBlock(LinkedHashMap selWorkBlock) {
		this.selWorkBlock = selWorkBlock;
	}
	
	public LinkedHashMap getSelWorkBlock() {
		return selWorkBlock;
	}
	
	@SuppressWarnings("unchecked")
	public void initSelWorkBlock(Customer customer){
		if(this.selWorkBlock == null){
			selWorkBlock = new LinkedHashMap();
			selWorkBlock.put("", CommonUtils.EMPTY);
		}
	}
	
	public void setSelRating(LinkedHashMap selRating) {
		this.selRating = selRating;
	}
	
	public LinkedHashMap getSelRating() {
		return selRating;
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

	public Map<String, String[]> getFormMap() {
		return formMap;
	}

	public void setFormMap(Map<String, String[]> formMap) {
		this.formMap = formMap;
	}

	public int getChangeProjectId() {
		return changeProjectId;
	}

	public void setChangeProjectId(int changeProjectId) {
		this.changeProjectId = changeProjectId;
	}

	public List<QuestionAnswerDetail> getQuestionDetailList() {
		return questionDetailList;
	}

	public void setQuestionDetailList(List<QuestionAnswerDetail> questionDetailList) {
		this.questionDetailList = questionDetailList;
	}
	
	
	
}
