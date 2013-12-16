package com.ihk.saleunit.action.new_init;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.pojo.CustomerFocus;
import com.ihk.customer.data.pojo.CustomerKnown;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.saleunit.data.pojo.Question;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetail;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetailCond;
import com.ihk.saleunit.data.pojo.QuestionAnwser;
import com.ihk.saleunit.data.pojo.QuestionAnwserCond;
import com.ihk.saleunit.data.pojo.QuestionCond;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;
import com.ihk.saleunit.data.pojo.ReportDefineColumn;
import com.ihk.saleunit.data.pojo.ReportDefineColumnCond;
import com.ihk.saleunit.data.pojo.ReportShowTD;
import com.ihk.saleunit.data.pojo.ReportShowTR;
import com.ihk.saleunit.data.services.IQuestionAnswerDetailServices;
import com.ihk.saleunit.data.services.IQuestionAnwserServices;
import com.ihk.saleunit.data.services.IQuestionServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.saleunit.data.services.IReportDefineColumnServices;
import com.ihk.setting.data.pojo.ProjectCode;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.setting.data.services.IProjectCodeServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.exception.RepeatTitleException;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;
import com.ihk.utils.saleunit.ReportShowUtils;
import com.ihk.utils.saleunitnew.PropertyTreeUtils;

/**
 * 售前客户问卷调查表
 *
 */
public class CustomerBeforeByQuestionAction extends SupperAction {
	private static final long serialVersionUID = 1L;
	
	
	@Autowired IQuestionServices questionServices;
	@Autowired IQuestionTopicServices questionTopicServices;
	@Autowired IReportDefineColumnServices reportDefineColumnServices;
	@Autowired IQuestionAnwserServices questionAnwserServices;
	@Autowired IQuestionAnswerDetailServices questionAnswerDetailServices;
	@Autowired ICodeTypeServices codeTypeServices;
	@Autowired ICustomerServices customerServices;
	@Autowired IProjectCodeServices projectCodeServices;
	
	private List<QuestionTopic> tocList;
	private QuestionTopic newQuestionTopic;
	
	private QuestionTopic oldQuestionTopic;
	
	
	private CustomerCond customerCond;
	
	private QuestionTopicCond questionTopicCond;
	
	private String projectName;
	
	private String selCategory1;
	
	private String showTrs;
	
	private String projectId;
	
	private int selectQuestionId;
	
	private Question newQuestion;
	
	private Question oldQuestion;
	
	private int selectTopicId;
	
	private Customer customer;
	
	private CustomerKnown knownFrom;
	
	private CustomerFocus customerFocus;
	
	private boolean flag;//判断复制和添加问卷
	
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
	private LinkedHashMap selCustomerKnownFrom;//认知途径
	private LinkedHashMap selProvince; //省
	private LinkedHashMap selHomeCity; //居住市
	private LinkedHashMap selHomeRegion; //居住区域
	private LinkedHashMap selWorkCity; //工作市
	private LinkedHashMap selWorkRegion; //工作区域
	private LinkedHashMap selRoomType;
	private LinkedHashMap selBuyAim;
	private LinkedHashMap selPayType;
	private LinkedHashMap selGender;
	private LinkedHashMap selAgeRange; 
	private LinkedHashMap selJobType; 	//行业结构（行业分类）
	
	

	public CustomerCond getCustomerCond() {
		return customerCond;
	}

	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSelCategory1() {
		return selCategory1;
	}

	public void setSelCategory1(String selCategory1) {
		this.selCategory1 = selCategory1;
	}
	
	public String getShowTrs() {
		return showTrs;
	}
	
	public void setShowTrs(String showTrs){
		this.showTrs = showTrs;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	
	public int getSelectQuestionId() {
		return selectQuestionId;
	}

	public void setSelectQuestionId(int selectQuestionId) {
		this.selectQuestionId = selectQuestionId;
	}
	
	public QuestionTopicCond getQuestionTopicCond() {
		return questionTopicCond;
	}

	public void setQuestionTopicCond(QuestionTopicCond questionTopicCond) {
		this.questionTopicCond = questionTopicCond;
	}

	public Question getNewQuestion() {
		return newQuestion;
	}

	public void setNewQuestion(Question newQuestion) {
		this.newQuestion = newQuestion;
	}
	
	public int getSelectTopicId() {
		return selectTopicId;
	}

	public void setSelectTopicId(int selectTopicId) {
		this.selectTopicId = selectTopicId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public CustomerKnown getKnownFrom() {
		return knownFrom;
	}

	public void setKnownFrom(CustomerKnown knownFrom) {
		this.knownFrom = knownFrom;
	}
	
	public LinkedHashMap getSelCustomerKnownFrom() {
		return selCustomerKnownFrom;
	}

	public void setSelCustomerKnownFrom(LinkedHashMap selCustomerKnownFrom) {
		this.selCustomerKnownFrom = selCustomerKnownFrom;
	}
	
	public void initSelCustomerKnownFrom(){
		if(this.selCustomerKnownFrom == null){
			this.selCustomerKnownFrom = codeTypeServices.findCodeListForSel(EnumCodeTypeName.KNOWN_FROM, Integer.parseInt(getProjectId()), true);  //10
			this.selCustomerKnownFrom.remove("");
		}
	}

	public CustomerFocus getCustomerFocus() {
		return customerFocus;
	}

	public void setCustomerFocus(CustomerFocus customerFocus) {
		this.customerFocus = customerFocus;
	}
	
	public LinkedHashMap getSelGender() { 
		return selGender; 
	} 
	
	public void setSelGender(LinkedHashMap selGender) { 
		this.selGender = selGender; 
	} 
    
	public void initGender() {  
		if(this.selGender==null){
			this.selGender = codeTypeServices.findCodeListForSel(EnumCodeTypeName.GENDER,Integer.parseInt(getProjectId()));
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
			this.selRoomType = codeTypeServices.findCodeListForSel(EnumCodeTypeName.ROOM_TYPE,Integer.parseInt(getProjectId()));
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
			this.selBuyAim = codeTypeServices.findCodeListForSel(EnumCodeTypeName.BUY_AIM,Integer.parseInt(getProjectId()));
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
			this.selPayType = codeTypeServices.findCodeListForSel(EnumCodeTypeName.PAY_TYPE,Integer.parseInt(getProjectId()));
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
			this.selBuyUse = codeTypeServices.findCodeListForSel(EnumCodeTypeName.BUY_AIM, Integer.parseInt(getProjectId()), true);  //1
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
			this.selBuyCount = codeTypeServices.findCodeListForSel(EnumCodeTypeName.BUY_COUNT, Integer.parseInt(getProjectId()), true);   //2
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
			this.selHouseType = codeTypeServices.findCodeListForSel(EnumCodeTypeName.HOUSE_TYPE, Integer.parseInt(getProjectId()), true);   //3
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
			this.selCustomerSource = codeTypeServices.findCodeListForSel(EnumCodeTypeName.CUSTOMER_SOURCE, Integer.parseInt(getProjectId()), true); //4
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
			this.selVisitCount = codeTypeServices.findCodeListForSel(EnumCodeTypeName.VISIT_COUNT, Integer.parseInt(getProjectId()), true);  //5
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
			this.selFamilyType = codeTypeServices.findCodeListForSel(EnumCodeTypeName.FAMILY_TYPE, Integer.parseInt(getProjectId()), true);  //6
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
			this.selFamilyIncome = codeTypeServices.findCodeListForSel(EnumCodeTypeName.FAMILY_INCOME, Integer.parseInt(getProjectId()), true);  //7
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
			this.selJobIndustry = codeTypeServices.findCodeListForSel(EnumCodeTypeName.JOB_INDUSTRY, Integer.parseInt(getProjectId()), true);  //8
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
			this.selIntentBuynum = codeTypeServices.findCodeListForSel(EnumCodeTypeName.INTENT_BUYNUM, Integer.parseInt(getProjectId()), true); //9
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
			this.selCustomerFocus = codeTypeServices.findCodeListForSel(EnumCodeTypeName.CUSTOMER_FOCUS, Integer.parseInt(getProjectId()), true);  //10
			this.selCustomerFocus.remove("");
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
			this.selAgeRange = codeTypeServices.findCodeListForSel(EnumCodeTypeName.AGE_RANGE,Integer.parseInt(getProjectId()));
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
			this.selJobType = codeTypeServices.findCodeListForSel(EnumCodeTypeName.JOB_TYPE,Integer.parseInt(getProjectId()));
		}
	} 
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public QuestionTopic getOldQuestionTopic() {
		return oldQuestionTopic;
	}

	public void setOldQuestionTopic(QuestionTopic oldQuestionTopic) {
		this.oldQuestionTopic = oldQuestionTopic;
	}

	public Question getOldQuestion() {
		return oldQuestion;
	}

	public void setOldQuestion(Question oldQuestion) {
		this.oldQuestion = oldQuestion;
	}

	/**
	 * 跳到查看问卷的tab页面
	 * @return
	 */
	public String index(){
		
		int companyProjectId = PropertyTreeUtils.getLeftTreeProjectIdSession(request);
		
		QuestionCond cond = new QuestionCond();
		
		//cond.setCompanyProjectId(SessionUser.getProjectId()); //旧的获取公司项目的方法不对
		cond.setCompanyProjectId(companyProjectId);
		
		List<Question> tqList = questionServices.findQuestion(cond);
		
		Question tq = null;
		if(tqList == null || tqList.size() == 0){
			Question nbypro = new Question();
			nbypro.setCompanyProjectId(companyProjectId);
			try {
				CommonPojoUtils.initPojoCommonFiled(nbypro);
			} catch (Exception e) {
				e.printStackTrace();
			}
			nbypro.setQuestionName("");
			questionServices.addQuestion(nbypro);
			tq = nbypro;
		}else{
			tq = tqList.get(0);
		}
		tocList = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(tq.getId()));
		return "suc";
	}

	public String dialog(){
		return "suc";
	}
	
	public String dialogModify(){
		newQuestionTopic=questionTopicServices.findQuestionTopicById(selectTopicId);
		return "suc";
	}
	
	public String dialogOrder(){
		tocList=questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(selectQuestionId));
		return "suc";
	}
	
	/**
	 * 主页查看问卷的tab页面
	 * @return
	 */
	

	public String indexMain(){
		
		initSearchDate();
		
		QuestionCond cond = new QuestionCond();
		
		//cond.setCompanyProjectId(SessionUser.getProjectId()); //旧的获取公司项目的方法不对
		if(customerCond.getProjectId()==0) return "suc";
		
		cond.setCompanyProjectId(customerCond.getProjectId());
		
		List<Question> tqList = questionServices.findQuestion(cond);
		
		Question tq = null;
		if(tqList == null || tqList.size() == 0){
			Question nbypro = new Question();
			nbypro.setCompanyProjectId(customerCond.getProjectId());
			try {
				CommonPojoUtils.initPojoCommonFiled(nbypro);
			} catch (Exception e) {
				e.printStackTrace();
			}
			nbypro.setQuestionName("");
			questionServices.addQuestion(nbypro);
			tq = nbypro;
		}else{
			tq = tqList.get(0);
		}
		tocList = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(tq.getId()));
		
		//	initDate();//初始化公用数据
			
		return "suc";
	}
	
	
	/**
	 * 主页查看问卷的tab页面,Ajax返回
	 * @return
	 */
	public String indexAjax(String projectId){
		this.setProjectId(projectId);
		initSearchDate();
		initGender();
		initAgeRange();
		initJobType();
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
		initBuyAim();
		initPayType();
		initRoomType();
		initSelCustomerKnownFrom();
		return "suc";
	}
	
	public String indexAjax(){
		this.setProjectId(SessionUser.getProjectId()+"");
		initSearchDate();
		initGender();
		initAgeRange();
		initJobType();
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
		initBuyAim();
		initPayType();
		initRoomType();
		initSelCustomerKnownFrom();
		return "suc";
	}

	public String indexMainAjax(){
		if(customerCond == null){
			customerCond = new CustomerCond();
		}
		ActionTemplate.executeAjaxPage(this, customerCond, new ActionAjaxPageCallback() {
			@Override
			public int initTotal() {		
				return 0;	
			}
			@Override
			public List<Map<String, String>> initRows() {
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();	
				if(customerCond.getProjectId()==0){	
					return retList;
				}
				QuestionCond cond = new QuestionCond();
				cond.setCompanyProjectId(customerCond.getProjectId());
				List<Question> tqList = questionServices.findQuestion(cond);
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", "0");
				map.put("questionName", "基本售前问卷");
				map.put("createId", "系统");
				DateFormat dateFormat=DateFormat.getDateInstance();
				map.put("createTime", dateFormat.format(new Date()));
				map.put("remark", "基本的售前问卷");
				for(Question q:tqList){
					if(q.getAreaId()==0){
						continue;
					}
					map.put("isDefault", "<input type='radio' name='isDefault' value='0'/>");
				}
				if(!map.containsKey("isDefault")){
					map.put("isDefault", "<input type='radio' name='isDefault' value='0' checked='checked'/>");
				}
				retList.add(map);
				if(!CommonUtils.isCollectionEmpty(tqList)){
					for(Question question : tqList){
						map = new HashMap<String, String>();
						map.put("id", question.getId() + "");
						map.put("questionName", question.getQuestionName());
						map.put("createId", question.getCreatedIdStr());
						dateFormat=DateFormat.getDateInstance();
						map.put("createTime", dateFormat.format(question.getCreatedTime()));
						map.put("remark", question.getRemark());
						map.put("isDefault", question.getIsDefault());
						retList.add(map);				
					}
				}
				return retList;
			}
		});
		return null;
	}
	
	
	public String getTopicAjax(){
		//System.out.println(selectQuestionId);
		if(questionTopicCond == null){
			questionTopicCond = new QuestionTopicCond();
			questionTopicCond.setQuestionId(selectQuestionId);
		}
		ActionTemplate.executeAjaxPage(this, questionTopicCond, new ActionAjaxPageCallback() {
			@Override
			public int initTotal() {		
				return 0;	
			}
			@Override
			public List<Map<String, String>> initRows() {
				initSearchDate();
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();	
				if(questionTopicCond.getQuestionId()==0){	
					return retList;
				}
				QuestionTopicCond cond = new QuestionTopicCond();
				cond.setQuestionId(selectQuestionId);
				List<QuestionTopic> qtList = questionTopicServices.findQuestionTopic(cond);
				if(!CommonUtils.isCollectionEmpty(qtList)){
					Map<String, String> map = null;
					for(QuestionTopic questionTopic : qtList){
						map = new HashMap<String, String>();
						map.put("id", questionTopic.getId() + "");
						map.put("topicName", questionTopic.getTopicName());
						map.put("topicContent", questionTopic.getInputAndOtherHtml());
						retList.add(map);				
					}
				}
				return retList;
			}
		});
		return null;
	}
	
	
	
	private void initSZQY() {//所在区域
		ArrayList<ReportShowTR> trList = new ArrayList<ReportShowTR>();
		//CustomerCond cond = new CustomerCond();
		
		String[] ids = customerCond.getStrSearchProjectIds().split(",");
		List<Integer> intIds = new ArrayList<Integer>();
		for(String id : ids){
			intIds.add(Integer.parseInt(id));
		}
		customerCond.setProjectIds(intIds);
		
		//List<Map> resMap = this.customerServices.countByTimeGroupByProjectId(customerCond);
		
		ReportDefineColumnCond condXColumn = new ReportDefineColumnCond();
		condXColumn.setReportName(getSelCategory1());
		List<ReportDefineColumn> listReportDefineXColumn = reportDefineColumnServices.findReportDefineColumnForY(condXColumn);	
		
		ReportShowTR showTRH = new ReportShowTR("项目");
		ReportShowTD tdH = new ReportShowTD("项目");
		showTRH.addTD(tdH);
		for(int j=0;j<listReportDefineXColumn.size();j++){
			showTRH.addTD(new ReportShowTD(listReportDefineXColumn.get(j).getShowName()));
			
		}
		trList.add(showTRH);
		
		
		String str = ReportShowUtils.getTrsByListTR(trList);		
		setShowTrs(str);//设置输出
	}
	
	private void initSearchDate(){
		if (customerCond == null) {
			customerCond = new CustomerCond();
			customerCond.addPermissionChartProjectIds();	
			customerCond.setSearchProjectIds(customerCond.getPrivProjectIds());

			if(selCategory1 == null){
				selCategory1 = "SQKHFL_SZQY";//默认 所在区域
			}
			
		}
		
		
	}
	
	public String addQuestionDialog(){
		return "suc";
	}
	
	public String modifyQuestionDialog(){
		newQuestion = questionServices.findQuestionById(selectQuestionId);
		return "suc";
	}
	
	/**
	 * 主页问卷题目排序
	 * @return
	 */
	public String formForMainOrder(){
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
				
			}
			
			@Override
			public void modifyMethod() throws Exception {
				try {
					List<QuestionTopic> qtList=questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(selectQuestionId));
					for(QuestionTopic qt:qtList){
						String newTopicId = request.getParameter("newTopicIndex"+qt.getId()+"Id");
						if(newTopicId!=null&&!"".equals(newTopicId)){
							int newTopicOrderIndex = Integer.parseInt(request.getParameter("newTopicIndex"+qt.getId()+"OrderIndex"));
							qt.setOrderIndex(newTopicOrderIndex);
							questionTopicServices.updateQuestionTopic(qt);
						}
					}
					addActionMessage("操作成功");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		return null;
	}
	
	
	public String customerBeforeModifyQuestionForm(){
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				
				setUpEasyuiAjaxForFail(e.getMessage());
				
			}

			@Override
			public void modifyMethod() throws Exception {
				if(repeatTitle(newQuestion.getQuestionName(),true,newQuestion.getCompanyProjectId(),0)){
					questionServices.updateQuestionNameAndRemark(newQuestion);
				}else{
					throw new RepeatTitleException();
				}
				
			}
		});
		return null;
	}
	
	
	
	public String customerBeforeAddQuestionForm(){
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				
				setUpEasyuiAjaxForFail(e.getMessage());
				
			}
			
			@Override
			public void modifyMethod() throws Exception {
				if(flag==true&&selectQuestionId==0){
					Question copyDefaultQuestion = new Question();
					CommonPojoUtils.initPojoCommonFiled(copyDefaultQuestion);
					copyDefaultQuestion.setQuestionName(newQuestion.getQuestionName());
					copyDefaultQuestion.setRemark(newQuestion.getRemark());
					copyDefaultQuestion.setCompanyProjectId(newQuestion.getCompanyProjectId());
					if(repeatTitle(newQuestion.getQuestionName(),true,newQuestion.getCompanyProjectId(),0)){
						questionServices.addQuestion(copyDefaultQuestion);
					}else{
						throw new RepeatTitleException();
					}
					QuestionTopic qt;
					ProjectCode pc;
					qt= new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("来访次数");
					qt.setTopicContent("首次到访\r\n二次到访\r\n多次到访");
					qt.setTopicType("1");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					String[] qts;
					qts=qt.getTopicContent().split("\r\n");
					int i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("性别");
					qt.setTopicContent("男\r\n女");
					qt.setTopicType("1");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("国籍");
					qt.setTopicContent("");
					qt.setTopicType("3");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("身份证号码");
					qt.setTopicContent("");
					qt.setTopicType("3");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("驾车车型");
					qt.setTopicContent("");
					qt.setTopicType("3");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("年龄");
					qt.setTopicContent("30岁一下\r\n30-40岁\r\n40-50岁\r\n50-60岁\r\n60岁以上");
					qt.setTopicType("1");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("地址");
					qt.setTopicContent("");
					qt.setTopicType("3");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("家庭结构");
					qt.setTopicContent("单身\r\n两口之家\r\n三口之家\r\n四口之家\r\n五口之家");
					qt.setTopicType("1");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("家庭收入");
					qt.setTopicContent("100万/年以下\r\n101-400万/年\r\n401-700万/年\r\n701-1000万/年\r\n1000万以上/年以上");
					qt.setTopicType("1");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("行业分类");
					qt.setTopicContent("服装\r\n布匹辅料\r\n电子\r\n酒店用品\r\n酒类\r\n鞋类");
					qt.setTopicType("1");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("职业");
					qt.setTopicContent("企业高管\r\n私营业主\r\n公务员\r\n职员\r\n医生\r\n老师\r\n律师\r\n文艺工作者\r\n军人\r\n退休");
					qt.setTopicType("1");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("意向购买单元1");
					qt.setTopicContent("");
					qt.setTopicType("3");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("意向购买单元2");
					qt.setTopicContent("");
					qt.setTopicType("3");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("购房目的");
					qt.setTopicContent("自主，且为第一居所\r\n自主，偶尔过来住\r\n私人会所\r\n度假\r\n投资\r\n养老\r\n给子女住\r\n给父母住\r\n自住兼投资\r\n资产保值");
					qt.setTopicType("1");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("付款方式");
					qt.setTopicContent("一次性（三个月）\r\n分期付款（一年）\r\n商业贷款\r\n公积金贷款\r\n组合贷款");
					qt.setTopicType("1");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("意向套数");
					qt.setTopicContent("1套\r\n2套\r\n3套\r\n4套\r\n5套\r\n5套以上");
					qt.setTopicType("1");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("意向户型");
					qt.setTopicContent("两房\r\n公寓/一房\r\n小三房\r\n大三房\r\n四房以上");
					qt.setTopicType("1");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("认知途径");
					qt.setTopicContent("高档酒店陌拜\r\n高档商场陌拜\r\n	4S店陌拜\r\n写字楼陌拜 \r\n高档娱乐会所陌拜 \r\n电话销售\r\n广州日报\r\n南方都市报 \r\n新快报\r\n羊晚\r\n	朋友介绍\r\n	老客户\r\n业主介绍 \r\n发展商关系户 \r\n合富关系户\r\n短信 \r\n派单 \r\n电台\r\n电视\r\n电梯广告 \r\n楼体广告\r\n户外广告牌\r\nLCD投放 \r\n途经\r\n搜房\r\n乐居\r\n房王\r\n巡展 \r\nDM");
					qt.setTopicType("2");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("关注点");
					qt.setTopicContent("价格\r\n户型面积\r\n	开盘时间\r\n交房时间 \r\n园林景观 \r\n周边配套\r\n地段\r\n交房状态 \r\n商业\r\n酒店\r\n教育\r\n物业服务\r\n交通 \r\n项目配套 \r\n发展商品牌\r\n装修标准 \r\n项目升值潜力 \r\n小区环境\r\n噪音");
					qt.setTopicType("2");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("未能成交原因");
					qt.setTopicContent("");
					qt.setTopicType("3");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					qt = new QuestionTopic();
					qt.setQuestionId(copyDefaultQuestion.getId());
					qt.setTopicName("备注");
					qt.setTopicContent("");
					qt.setTopicType("3");
					qt.setFillType("0");
					CommonPojoUtils.initPojoCommonFiled(qt);
					questionTopicServices.addQuestionTopic(qt);
					pc= new ProjectCode();
					qts=qt.getTopicContent().split("\r\n");
					i=1;
					for(String s:qts){
						pc.setProjectId(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId());
						pc.setTypeName(qt.getId()+"");
						pc.setCodeVal(""+i);
						pc.setCodeDesc(s);
						pc.setCodeOrder(i);
						pc.setIsDeleted("0");
						i++;	
						projectCodeServices.saveProjectCode(pc);
					}
					
					
				}else if(flag==true&&selectQuestionId!=0){
						Question copyQuestion=questionServices.findQuestionById(selectQuestionId);
				
						CommonPojoUtils.initPojoCommonFiled(copyQuestion);
						copyQuestion.setQuestionName(newQuestion.getQuestionName());
						copyQuestion.setRemark(newQuestion.getRemark());
						List<QuestionTopic> qtList=questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(selectQuestionId));
						if(repeatTitle(newQuestion.getQuestionName(),true,newQuestion.getCompanyProjectId(),0)){
							questionServices.addQuestion(copyQuestion);
						}else{
							throw new RepeatTitleException();
						}
						
						for(QuestionTopic qt:qtList){
							qt.setQuestionId(copyQuestion.getId());
							questionTopicServices.addQuestionTopic(qt);
							String[] arr=qt.getTopicContent().split("\\r\\n");
							List<ProjectCode> pcList=projectCodeServices.findProjectCodeByProjectIdAndTypeName(questionServices.findQuestionById(qt.getQuestionId()).getCompanyProjectId(),qt.getId()+"");
							int size = pcList.size();
							int maxCodeVal = 0;
							if(size!=0){
								maxCodeVal=Integer.parseInt(pcList.get(size-1).getCodeVal());
								Map map = new HashMap();
								map.put("companyProjectId", questionServices.findQuestionById(newQuestionTopic.getQuestionId()).getCompanyProjectId());
								map.put("topicName", newQuestionTopic.getId()+"");
								projectCodeServices.deleteAllProjectCode(map);
							}
							for(int i=0;i< arr.length; i++){
								ProjectCode projectCode=new ProjectCode();
								projectCode.setProjectId(copyQuestion.getCompanyProjectId());
								projectCode.setTypeName(qt.getId()+"");
								projectCode.setCodeVal(++maxCodeVal+"");
								projectCode.setCodeDesc(arr[i]);
								projectCode.setCodeOrder(maxCodeVal);
								projectCode.setIsDeleted("0");
								projectCodeServices.saveProjectCode(projectCode);
							}
							
						}
						
				}else{
					
						CommonPojoUtils.initPojoCommonFiled(newQuestion);
						
						if(repeatTitle(newQuestion.getQuestionName(),true,newQuestion.getCompanyProjectId(),0)){
							CustomerCond cond = new CustomerCond();
							cond.setProjectId(newQuestion.getCompanyProjectId());
							cond.setCreatedId(0);//查询条件存在问题，设置createId为0排除问题
//							List<Customer> cList = customerServices.findCustomerSearch(cond);
							questionServices.addQuestion(newQuestion);
//							for(Customer c:cList){
//								QuestionAnwser qa = new QuestionAnwser();
//								qa.setPreCustomerId(c.getId());
//								qa.setQuestionId(newQuestion.getId());
//								CommonPojoUtils.initPojoCommonFiled(qa);
//								questionAnwserServices.addQuestionAnwser(qa);
//								QuestionAnswerDetailCond qadCond = new QuestionAnswerDetailCond();
//								List<QuestionAnswerDetail> qadList=questionAnswerDetailServices.findQuestionAnswerDetail(qadCond);
//								for(QuestionAnswerDetail qad:qadList){
//									qad.setAnwserId(qa.getId());
//								}
//							}
							
						}else{
							throw new RepeatTitleException();
						}
					
					
				}
			}
		});
		return null;
	}
	
	
	/**
	 * 主页增加问卷
	 * @return
	 */
	public String addQuestion(){
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				
			}
			
			@Override
			public void modifyMethod() throws Exception {
				QuestionCond cond = new QuestionCond();
				//System.out.println(projectName);
				int projectId=PropertyTreeUtils.getLeftTreeProjectIdSession(request);
				
				cond.setCompanyProjectId(projectId);
				
				Question tq = questionServices.findQuestion(cond).get(0);
				
				if(newQuestionTopic != null){
					newQuestionTopic.setQuestionId(tq.getId());
				}
				
				try {
					CommonPojoUtils.initPojoCommonFiled(newQuestionTopic);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				questionTopicServices.addQuestionTopic(newQuestionTopic);
				addActionMessage("操作成功");
				
			}
		});
		return null;
	}
	
	
	/**
	 * 主页删除问卷
	 */
	public String deleteQuestionTable(){
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback(){

			@Override
			public void modifyMethod() throws Exception {
				try {
					QuestionTopicCond qtc = new QuestionTopicCond();
					qtc.setQuestionId(selectQuestionId);
					QuestionAnwserCond qac = new QuestionAnwserCond();
					qac.setQuestionId(selectQuestionId+"");
					Map<String,Object> map = new HashMap<String,Object>();
					List<QuestionTopic> qtList=questionTopicServices.findQuestionTopic(qtc);
					for(QuestionTopic qt:qtList){
						map.put("companyProjectId", questionServices.findQuestionById(questionTopicServices.findQuestionTopicById(qt.getId()).getQuestionId()).getCompanyProjectId());
						map.put("topicName", qt.getId()+"");
						projectCodeServices.deleteAllProjectCode(map);
						questionTopicServices.deleteQuestionTopic(qt.getId());
					}
					questionServices.deleteQuestion(selectQuestionId);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}

			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
				
			}
			
		});
		return null;
	}
	/**
	 * 主页增加问卷题目
	 * @return
	 */
	public String formForMain(){
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
				
			}
			
			@Override
			public void modifyMethod() throws Exception {
				try {
					CommonPojoUtils.initPojoCommonFiled(newQuestionTopic);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(repeatTitle(newQuestionTopic.getTopicName(),false,0,newQuestionTopic.getQuestionId())){
					if(CommonUtils.isStrEmpty(newQuestionTopic.getTopicContent())){
						newQuestionTopic.setTopicType("3");
						newQuestionTopic.setTopicContent("");
					}
					questionTopicServices.addQuestionTopic(newQuestionTopic);
					addProjectCode();
				}else{
					throw new RepeatTitleException();
				}
				
			}
		});
		return null;
	}
	
	/**
	 * 主页修改问卷题目
	 * @return
	 */
	public String formForMainModify(){
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
				
			}
			
			@Override
			public void modifyMethod() throws Exception {
				try {
					CommonPojoUtils.initPojoCommonFiled(newQuestionTopic);
					
					addActionMessage("操作成功");
				} catch (Exception e) {
					e.printStackTrace();
				}
				//System.out.println(oldQuestionTopic.getTopicName().equals(newQuestionTopic.getTopicName()));
				if(repeatTitle(newQuestionTopic.getTopicName(),false,0,newQuestionTopic.getQuestionId())||oldQuestionTopic.getTopicName().equals(newQuestionTopic.getTopicName())){
					if(CommonUtils.isStrEmpty(newQuestionTopic.getTopicContent())){
						newQuestionTopic.setTopicType("3");
						newQuestionTopic.setTopicContent("");
					}
					questionTopicServices.updateQuestionTopic(newQuestionTopic);
					addProjectCode();
				}else{
					throw new RepeatTitleException();
				}
				
				
			}
		});
		return null;
	}
	
	/**
	 * 主页删除问卷题目
	 * @return
	 */
	public String formForMainDelete(){
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void modifyMethod() throws Exception {
				try {
					Map map = new HashMap();
					map.put("companyProjectId", questionServices.findQuestionById(questionTopicServices.findQuestionTopicById(selectTopicId).getQuestionId()).getCompanyProjectId());
					map.put("topicName", selectTopicId+"");
					projectCodeServices.deleteAllProjectCode(map);
					questionTopicServices.deleteQuestionTopic(selectTopicId);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		return null;
	}
	
	
	/**
	 * 增加问卷题目
	 * @return
	 */
	public String form(){
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void modifyMethod() throws Exception {
				QuestionCond cond = new QuestionCond();
				//System.out.println(projectName);
				int projectId=PropertyTreeUtils.getLeftTreeProjectIdSession(request);
				
				cond.setCompanyProjectId(projectId);
				
				Question tq = questionServices.findQuestion(cond).get(0);
				
				if(newQuestionTopic != null){
					newQuestionTopic.setQuestionId(tq.getId());
				}
				
				try {
					CommonPojoUtils.initPojoCommonFiled(newQuestionTopic);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		return null;
	}
	
	/**
	 * 判断问卷是否已经被使用
	 * @throws IOException 
	 */
	public String questionHasBeUsed() throws IOException{
		String selectTopicId = request.getParameter("selectQuestionId");
		QuestionAnwserCond cond = new QuestionAnwserCond();
		cond.setQuestionId(selectTopicId);
		List<QuestionAnwser> qa=questionAnwserServices.findQuestionAnwser(cond);
		CustomerUtils.writeResponse(response, qa.size()+"");
		return null;
	}
	
	/**
	 * 检查问卷或题目的名字是否重复了
	 * questionOrTopic为true,检查问卷，为false检查题目
	 * 
	 */
	private boolean repeatTitle(String title ,boolean questionOrTopic ,int companyProjectId , int questionId){
		if(questionOrTopic==true){
			QuestionCond qc=new QuestionCond();
			qc.setQuestionName(title);
			qc.setCompanyProjectId(companyProjectId);
			if(questionServices.findQuestion(qc).size()!=0||"基本售前问卷".equals(title)){
				return false;
			}
		}
		if(questionOrTopic==false){
			QuestionTopicCond qtc=new QuestionTopicCond();
			qtc.setTopicName(title);
			qtc.setQuestionId(questionId);
			if(questionTopicServices.findQuestionTopic(qtc).size()!=0){
				return false;
			}
		}
		
		return true;
	}
	
	private void addProjectCode(){
		ProjectCode projectCode = new ProjectCode();
		String[] arr=newQuestionTopic.getTopicContent().split("\\r\\n");
		List<ProjectCode> pcList=projectCodeServices.findProjectCodeByProjectIdAndTypeName(questionServices.findQuestionById(newQuestionTopic.getQuestionId()).getCompanyProjectId(),newQuestionTopic.getId()+"");
		int size = pcList.size();
		int maxCodeVal = 0;
		if(size!=0){
			maxCodeVal=Integer.parseInt(pcList.get(size-1).getCodeVal());
			Map map = new HashMap();
			map.put("companyProjectId", questionServices.findQuestionById(newQuestionTopic.getQuestionId()).getCompanyProjectId());
			map.put("topicName", newQuestionTopic.getId()+"");
			projectCodeServices.deleteAllProjectCode(map);
		}
		for(int i=0;i<arr.length;i++){
			projectCode.setProjectId(questionServices.findQuestionById(newQuestionTopic.getQuestionId()).getCompanyProjectId());
			projectCode.setTypeName(newQuestionTopic.getId()+"");
			projectCode.setCodeVal(++maxCodeVal+"");
			projectCode.setCodeDesc(arr[i]);
			projectCode.setCodeOrder(maxCodeVal);
			projectCode.setIsDeleted("0");
			projectCodeServices.saveProjectCode(projectCode);
		}
	}
	
	
	private String deId;
	
	public String delByDeId(){
		int intDeId = 0;
		try {
			intDeId = Integer.parseInt(deId);
		} catch (Exception e) {
			return null;
		}
		if(intDeId != 0)
			questionTopicServices.deleteQuestionTopic(intDeId);
		
		return null;
	}
	
	public String setDefaultQuestion(){
		int id=Integer.parseInt(request.getParameter("id"));
		int projectId=Integer.parseInt(request.getParameter("projectId"));
		QuestionCond cond = new QuestionCond();
		cond.setCompanyProjectId(projectId);
		List<Question> qList=questionServices.findQuestion(cond);
		for(Question q:qList){
			q.setAreaId(0);	
			questionServices.updateQuestion(q);
		}
		Question question=questionServices.findQuestionById(id);
		if(question!=null){
			question.setAreaId(1);
		}
		questionServices.updateQuestion(question);
		return null;
	}
	
	
	public String getDeId() {
		return deId;
	}

	public void setDeId(String deId) {
		this.deId = deId;
	}

	public List<QuestionTopic> getTocList() {
		return tocList;
	}


	public void setTocList(List<QuestionTopic> tocList) {
		this.tocList = tocList;
	}

	public QuestionTopic getNewQuestionTopic() {
		return newQuestionTopic;
	}

	public void setNewQuestionTopic(QuestionTopic newQuestionTopic) {
		this.newQuestionTopic = newQuestionTopic;
	}

	
}
