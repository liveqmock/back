package com.ihk.mobile.jquery;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerFocus;
import com.ihk.customer.data.pojo.CustomerKnown;
import com.ihk.customer.data.services.ICustomerFocusServices;
import com.ihk.customer.data.services.ICustomerKnownServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetail;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetailCond;
import com.ihk.saleunit.data.pojo.QuestionAnwser;
import com.ihk.saleunit.data.pojo.QuestionAnwserCond;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;
import com.ihk.saleunit.data.services.IQuestionAnswerDetailServices;
import com.ihk.saleunit.data.services.IQuestionAnwserServices;
import com.ihk.saleunit.data.services.IQuestionServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.mobile.MobileCustomerUtils;

/**
 * 客户问卷action
 * @author dtc
 * 2013-7-24,下午03:10:17
 */
@SuppressWarnings("rawtypes")
public class MobileQuestionAction extends SupperAction{

	private static final long serialVersionUID = -2813830883679035397L;
	
	@Autowired
	ICodeTypeServices codeTypeServices;
	@Autowired
	ICustomerServices customerServices;
	@Autowired
	ICustomerKnownServices customerKnownServices;
	@Autowired
	ICustomerFocusServices customerFocusServices;
	@Autowired 
	IQuestionTopicServices questionTopicServices;
	@Autowired 
	IQuestionAnwserServices questionAnwserServices;
	@Autowired 
	IQuestionAnswerDetailServices questionAnswerDetailServices;
	@Autowired
	IQuestionServices questionServices;
	
	/**
	 * 跳到选择问卷类型的界面,也就是新增成功的界面
	 * @return
	 * @throws Exception
	 */
	public String toChangeQuestion() throws Exception{
		
		customer = customerServices.getCustomerById(customerId);
		
		questionSelectOptionHtml = MobileCustomerUtils.getQuestionSelectOptionHtml(customer.getProjectId());
		
		return "toChangeQuestion";
	}
	
	/**
	 * 跳到增加问卷的界面
	 * @return
	 * @throws Exception
	 */
	public String toAddQuestion() throws Exception{
		
		if(questionId == 0){
			//选择了基本问卷
			init(projectId);
			initKnownAndFocus(projectId, 0);
			
			return "default";
		}
		
		//自定义问卷
		topicList = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(questionId));
		
		return "own";
	}
	
	/**
	 * 增加默认问卷
	 * @return
	 * @throws Exception
	 */
	public String addDefaultQuestion() throws Exception{
		
		String ret = "succ";
		
		try{
		
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					String[] knownFroms = request.getParameterValues("knownFrom"); //获知途径 customerKnownServices
					String[] customerFocus = request.getParameterValues("customerFocus") ; //关注点
					
					CustomerUtils.addCustomerKnownsByCustomer(customerKnownServices, knownFroms, customer);
					CustomerUtils.addCustomerFocusByCustomer(customerFocusServices, customerFocus, customer);
					
					Customer oldCustomer = customerServices.getCustomerById(customer.getId());
					oldCustomer = initCustomerDefaultQuestion(oldCustomer, customer);
					
					customerServices.updateCustomer(oldCustomer);
					
				}
			}.execute();
		
		}catch (Exception e) {
			e.printStackTrace();
			
			ret = "fail";
			failTitle = e.getMessage();
		}
		
		return ret;
	}
	
	/**
	 * 增加自定义问卷
	 * @return
	 * @throws Exception
	 */
	public String addOwnQuestion() throws Exception{
		
		boolean isOk = validateMobileQuestion();
		if(!isOk){
			
			return "validateMobileQuestion";
		}
		
		String ret = "succ";
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					commonAddOwnQuestion();
					
					/**
					 * 2013.11.15答卷改成只保存作答的问卷答案,没作答的不用保存,
					 * 查询的时候就要判断是否作答,作答了就查询答卷,否则查询问卷
					 */
					
				}
			}.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
			
			ret = "fail";
			failTitle = e.getMessage();
		}
		
		return ret;
	}
	
	/**
	 * 跳到选择修改问卷的界面
	 * @return
	 * @throws Exception
	 */
	public String toChangeUpdateQuestion() throws Exception{
		
		questionSelectOptionHtml = MobileCustomerUtils.getQuestionSelectOptionHtml(projectId);
		
		request.setAttribute("currentPage", request.getParameter("currentPage"));
		
		return "toChangeUpdateQuestion";
	}
	
	/**
	 * 判断为修改或新增问卷 
	 */
	public String toModifyQuestion() throws Exception{
		
		if(questionId == 0){
			//选择了基本问卷
			init(projectId);
			initKnownAndFocus(projectId, customerId);
			
			customer = customerServices.getCustomerById(customerId);
			
			return "default";
		}
		
		//自定义问卷
		
		QuestionAnwserCond cond = new QuestionAnwserCond();
		cond.setPreCustomerId(customerId + "");
		cond.setQuestionId(questionId + "");
		
		List<QuestionAnwser> qaList = questionAnwserServices.findQuestionAnwser(cond);
		
		if(CommonUtils.isCollectionEmpty(qaList)){
			
			//之前没有回答过问卷的
			topicList = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(questionId));
			
			return "ownNoAnswer";
			
		}else{
			
			//之前有回答过问卷的
			QuestionAnwser anwser = qaList.get(0);
			
			QuestionAnswerDetailCond qadCond = new QuestionAnswerDetailCond();
			qadCond.setAnwserId(anwser.getId()+"");
			questionDetailList = questionAnswerDetailServices.findQuestionAnswerDetail(qadCond);
			
			request.setAttribute("anwser", anwser); //答卷
			
			return "ownHaveAnswer";
		}
		
	}
	
	/**
	 * 手机问卷验证
	 * @return
	 * @throws Exception
	 */
	private boolean validateMobileQuestion() throws Exception{
		
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		QuestionTopicCond cond = new QuestionTopicCond();
		cond.setQuestionId(questionId);
		
		List<QuestionTopic> topicList = questionTopicServices.findQuestionTopic(cond);
		
		boolean isOk = true;
		
		String[] changes = null; //单选或多选框
		String other = null; //输入框
		int id = 0; //临时id
		
		for(QuestionTopic topic : topicList){
			//判断必填项是否都已填
    		if(topic.getIsRequired()){

    			id = topic.getId();
    			
    			changes = request.getParameterValues(MobileCustomerUtils.QUESTION_TOPIC + id);
    			other = request.getParameter(MobileCustomerUtils.QUESTION_OTHER_OPTION + id);
    			
    			if(CommonUtils.isCollectionEmpty(changes) && CommonUtils.isStrEmpty(other)){
    				
    				isOk = false;
    				break;
    			}
    		}
    	}
		
		return isOk;
	}
	
	/**
	 * 修改默认问卷
	 * @return
	 * @throws Exception
	 */
	public String modifyDefaultQuestion() throws Exception{
		
		String ret = "succ";
		
		try{
		
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					//获知途径 customerKnownServices,删除掉再增加
					String[] knownFroms = request.getParameterValues("knownFrom"); 
					customerKnownServices.deleteCustomerKnownByCustomerId(customerId);
					CustomerUtils.addCustomerKnownsByCustomer(customerKnownServices, knownFroms, customer);
					
					//关注点,删除掉再增加
					String[] customerFocus = request.getParameterValues("customerFocus") ; //关注点
					customerFocusServices.deleteCustomerFocusByCusotmerId(customerId);
					CustomerUtils.addCustomerFocusByCustomer(customerFocusServices, customerFocus, customer);
					
					Customer oldCustomer = customerServices.getCustomerById(customer.getId());
					oldCustomer = initCustomerDefaultQuestion(oldCustomer, customer);
					
					customerServices.updateCustomer(oldCustomer);
					
				}
			}.execute();
		
		}catch (Exception e) {
			e.printStackTrace();
			
			ret = "fail";
			failTitle = e.getMessage();
		}
		
		return ret;
		
	}
	
	/**
	 * 修改之前没有答卷的自定义问卷
	 * 等同于新增该问卷
	 * @return
	 * @throws Exception
	 */
	public String modifyOwnNoAnswerQuestion() throws Exception{
		
		boolean isOk = validateMobileQuestion();
		if(!isOk){
			
			return "validateMobileQuestion";
		}
		
		String ret = "succ";
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					commonAddOwnQuestion();
					
				}
			}.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
			
			ret = "fail";
			failTitle = e.getMessage();
		}
		
		return ret;
		
	}
	
	/**
	 * 修改之前有答卷的自定义问卷
	 * @return
	 * @throws Exception
	 */
	public String modifyOwnHaveAnswerQuestion() throws Exception{
		
		boolean isOk = validateMobileQuestion();
		if(!isOk){
			
			return "validateMobileQuestion";
		}
		
		String ret = "succ";
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					//此时只需修改对应的答卷详细
					
					commonUpdateOwnQuestion();
					
				}
			}.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
			
			ret = "fail";
			failTitle = e.getMessage();
		}
		
		return ret;
		
	}
	
	/**
	 * 新增自定义问卷common
	 * @throws Exception
	 */
	private void commonAddOwnQuestion() throws Exception{
		
		//先获取对应问卷的所有问题
		topicList = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(questionId));
		
		if(CommonUtils.isCollectionEmpty(topicList)){
			
			return;
		}
		
		//新增一条问卷答案
		QuestionAnwser anwser = new QuestionAnwser();
		anwser.setQuestionId(questionId);
		anwser.setPreCustomerId(customerId);
		
		CommonPojoUtils.initPojoCommonFiled(anwser);
		
		questionAnwserServices.addQuestionAnwser(anwser);
		
		String[] topicArr = null; //选中的选项
		String topicOther = null; //对应的一条题目的其他输入框
		String topicContent = "";
		
		StringBuffer sb = null; //答案连接符
		QuestionAnswerDetail detail = null; //答案明细
		
		//增加选中的问卷的所选的明细
		for(QuestionTopic topic : topicList){
			
			sb = new StringBuffer();
			
			topicArr = request.getParameterValues(MobileCustomerUtils.QUESTION_TOPIC + topic.getId());
			topicOther = request.getParameter(MobileCustomerUtils.QUESTION_OTHER_OPTION + topic.getId());
			
			//表示没有选择答案
			if(CommonUtils.isCollectionEmpty(topicArr) && CommonUtils.isStrEmpty(topicOther))
				continue;
			
			//设置选中的选项为1,没选中的选项为0
			
			topicContent = topic.getTopicContent();
			String[] contents = topicContent.split("\r\n"); //该问题所有的选项
			
			for(String content : contents){
				
				if(CommonUtils.isHave(topicArr, content)){
					
					sb.append("1:").append(content).append("\r\n");
				}else{
					
					sb.append("0:").append(content).append("\r\n");
				}
				
			}
			
			detail = new QuestionAnswerDetail();
			
			detail.setAnwserId(anwser.getId());
			detail.setTopicName(topic.getTopicName());
			detail.setTopicType(topic.getTopicType());
			detail.setTopicGroup(topic.getTopicGroup());
			detail.setTopicId(topic.getId());
			detail.setAnwserContent(sb.toString());
			detail.setOtherOption(topicOther);
			
			CommonPojoUtils.initPojoCommonFiled(detail);
			
			questionAnswerDetailServices.addQuestionAnswerDetail(detail);
			
		}
		
	}
	
	/**
	 * 修改自定义问卷common
	 * @throws Exception
	 */
	private void commonUpdateOwnQuestion() throws Exception{
		
		int anwserId = Integer.parseInt(request.getParameter("anwserId"));
		
		//对应的旧的答卷详细
		QuestionAnswerDetailCond qadCond = new QuestionAnswerDetailCond();
		qadCond.setAnwserId(anwserId + "");
		questionDetailList = questionAnswerDetailServices.findQuestionAnswerDetail(qadCond);
		
		if(CommonUtils.isCollectionEmpty(questionDetailList)){
			
			return ;
		}
		
		String[] topicArr = null; //选中的选项
		String topicOther = null; //对应的一条题目的其他输入框
		
		for(QuestionAnswerDetail detail : questionDetailList){
			
			topicArr = request.getParameterValues(MobileCustomerUtils.QUESTION_TOPIC + detail.getId());
			topicOther = request.getParameter(MobileCustomerUtils.QUESTION_OTHER_OPTION + detail.getId());
			
			updateOneQuestionAnswerDetail(detail, topicArr, topicOther);
			
		}
		
	}
	
	/**
	 * 修改一条对应的详细
	 * @param detail
	 * @param topicArr
	 * @param topicOther
	 */
	private void updateOneQuestionAnswerDetail(QuestionAnswerDetail detail, String[] topicArr, String topicOther){
		
		//没有对应的答案
		if(CommonUtils.isCollectionEmpty(topicArr) && CommonUtils.isStrEmpty(topicOther)){
			return ;			
		}
		
		StringBuffer sb = new StringBuffer();
		
		//设置选中的选项为1,没选中的选项为0
		
		String anwserContent = detail.getAnwserContent();
		
		/**
		 *  0:南湖
			0:天河
			0:海珠
			0:越秀
			0:白云
			0:荔湾
			0:番禺
			0:萝岗
			0:花都
			0:港澳台
			0:省外
		 */
		//该详细所有的选项
		String[] contents = anwserContent.split("\r\n");
		
		String tmp = "";
		
		for(String content : contents){
			
			//content, 0:南湖
			
			tmp = content.substring(2);
			
			if(CommonUtils.isHave(topicArr, tmp)){
				
				sb.append("1:").append(tmp).append("\r\n");
			}else{
				
				sb.append("0:").append(tmp).append("\r\n");
			}
			
		}
		
		detail.setAnwserContent(sb.toString());
		
		if(CommonUtils.isStrEmpty(topicOther)){
			topicOther = "";
		}
		detail.setOtherOption(topicOther);
		
		questionAnswerDetailServices.updateQuestionAnswerDetail(detail);
		
	}
	
	/**
	 * 设置客户的默认问卷
	 * @param oldCustomer
	 * @param customer
	 * @return
	 * @throws Exception 
	 */
	private Customer initCustomerDefaultQuestion(Customer oldCustomer, Customer customer) throws Exception{
		
		oldCustomer.setVisitCount(customer.getVisitCount());
		oldCustomer.setGender(customer.getGender());
		oldCustomer.setNationality(customer.getNationality());
		
		oldCustomer.setIdcardNo(customer.getIdcardNo());
		oldCustomer.setTrafficDesc(customer.getTrafficDesc());
		oldCustomer.setAge(customer.getAge());
		
		oldCustomer.setAddress(customer.getAddress());
		oldCustomer.setPostcode(customer.getPostcode());
		oldCustomer.setFamilyType(customer.getFamilyType());
		
		oldCustomer.setFamilyIncome(customer.getFamilyIncome());
		oldCustomer.setJobType(customer.getJobType());
		oldCustomer.setJobIndustry(customer.getJobIndustry());
		
		oldCustomer.setIntentUnit1(customer.getIntentUnit1());
		oldCustomer.setIntentUnit2(customer.getIntentUnit2());
		oldCustomer.setBuyAim(customer.getBuyAim());
		
		oldCustomer.setPayType(customer.getPayType());
		oldCustomer.setIntentBuynum(customer.getIntentBuynum());
		oldCustomer.setRoomType(customer.getRoomType());
		
		oldCustomer.setNotBuyReson(customer.getNotBuyReson());
		oldCustomer.setRemark1(customer.getRemark1());
		
		return oldCustomer;
	}
	
	/**
	 * 获取下拉框的值
	 * @param projectId
	 */
	private void init(int projectId){
		
		selGender = DescUtils.getInitSelForGuangZhou(selGender, EnumCodeTypeName.GENDER, true);
		selAgeRange = DescUtils.getInitSelForGuangZhou(selAgeRange, EnumCodeTypeName.AGE_RANGE, true);
		selJobType = DescUtils.getInitSelForGuangZhou(selJobType, EnumCodeTypeName.JOB_TYPE, true);
		
		//selRequestArea = DescUtils.getInitSel(selRequestArea, CodeTypeName.REQUEST_AREA, true); 改为输入框
		selRoomType = DescUtils.getInitSelForGuangZhou(selRoomType, EnumCodeTypeName.ROOM_TYPE, true);
		//selPriceAmount = DescUtils.getInitSel(selPriceAmount, CodeTypeName.PRICE_AMOUNT, true); 改为输入框
		selBuyAim = DescUtils.getInitSelForGuangZhou(selBuyAim, EnumCodeTypeName.BUY_AIM, true);
		selPayType = DescUtils.getInitSelForGuangZhou(selPayType, EnumCodeTypeName.PAY_TYPE, true);
		
		selVisitCount = DescUtils.getInitSelForGuangZhou(selVisitCount, EnumCodeTypeName.VISIT_COUNT, true);
		selFamilyType = DescUtils.getInitSelForGuangZhou(selFamilyType, EnumCodeTypeName.FAMILY_TYPE, true);
		
		selFamilyIncome = codeTypeServices.findCodeListForSel(EnumCodeTypeName.FAMILY_INCOME, projectId, true); //根据不同的项目来获取
		
		selJobIndustry = DescUtils.getInitSelForGuangZhou(selJobIndustry, EnumCodeTypeName.JOB_INDUSTRY, true);
		selIntentBuynum = DescUtils.getInitSelForGuangZhou(selIntentBuynum, EnumCodeTypeName.INTENT_BUYNUM, true);
		
	}
	
	/**
	 * 获取获知途径及客户关注点的下拉框,customerId<=0表示为新增
	 * @param projectId
	 * @param customerId
	 */
	@SuppressWarnings("unchecked")
	private void initKnownAndFocus(int projectId, int customerId){
		
		selKnownFrom = codeTypeServices.findCodeListForSel(EnumCodeTypeName.KNOWN_FROM, projectId, false);
		selCustomerFocus = codeTypeServices.findCodeListForSel(EnumCodeTypeName.CUSTOMER_FOCUS, projectId, false);
		
		List<String> knownList = new ArrayList<String>();
		List<String> focusList = new ArrayList<String>();
		
		if(customerId > 0){
			
			try {
				List<CustomerKnown> knowns = customerKnownServices.findCustomerKnownByCustomerId(customerId);
				if(!CommonUtils.isCollectionEmpty(knowns)){
					
					for(CustomerKnown known : knowns){
						knownList.add(known.getKnownFrom());
					}
				}
			} catch (Exception e) {
			}
			
			try {
				List<CustomerFocus> focus = customerFocusServices.findCustomerFocusByCustomerId(customerId);
				if(!CommonUtils.isCollectionEmpty(focus)){
					
					for(CustomerFocus focu : focus){
						focusList.add(focu.getFocusPoint());
					}
				}
			} catch (Exception e) {
			}
			
		}
		
		knownFromSelectOptionHtml = MobileCustomerUtils.getCheckboxHtml(selKnownFrom, knownList, "knownFrom");
		customerFocusSelectOptionHtml = MobileCustomerUtils.getCheckboxHtml(selCustomerFocus, focusList, "customerFocus");
	}
	
	/**
	 * 客户
	 */
	private Customer customer;
	
	/**
	 * 客户id
	 */
	private int customerId;
	
	private LinkedHashMap selVisitCount; //来访次数
	private LinkedHashMap selGender; //性别
	
	private LinkedHashMap selAgeRange;  //年龄
	
	private LinkedHashMap selFamilyType; //家庭结构
	
	/**
	 * 家庭收入,根据项目id获取
	 */
	private LinkedHashMap selFamilyIncome; //家庭收入
	
	private LinkedHashMap selJobType; 	//行业结构（行业分类）
	private LinkedHashMap selJobIndustry; //职业
	
	private LinkedHashMap selBuyAim;  //购房目的
	private LinkedHashMap selPayType;  //付款方式
	
	private LinkedHashMap selRoomType; 	 //意向户型
	
	private LinkedHashMap selIntentBuynum; //意向套数
	
	private LinkedHashMap selKnownFrom;  //认知(获知)途径 
	
	private LinkedHashMap selCustomerFocus; //关注点
	
	/**
	 * 获知途径下拉框的option
	 */
	private String knownFromSelectOptionHtml;
	
	/**
	 * 关注点下拉框的option
	 */
	private String customerFocusSelectOptionHtml;
	
	/**
	 * 保存失败提示
	 */
	private String failTitle;
	
	/**
	 * 自定义问卷题目及选项
	 */
	private List<QuestionTopic> topicList;
	
	/**
	 * 问卷答案详细
	 */
	private List<QuestionAnswerDetail> questionDetailList;
	
	/**
	 * 问卷id
	 */
	private int questionId;
	
	/**
	 * 项目id
	 */
	private int projectId;
	
	/**
	 * 问卷下拉框html
	 */
	private String questionSelectOptionHtml;
	
	public void setQuestionDetailList(
			List<QuestionAnswerDetail> questionDetailList) {
		this.questionDetailList = questionDetailList;
	}
	
	public List<QuestionAnswerDetail> getQuestionDetailList() {
		return questionDetailList;
	}
	
	public void setQuestionSelectOptionHtml(String questionSelectOptionHtml) {
		this.questionSelectOptionHtml = questionSelectOptionHtml;
	}
	
	public String getQuestionSelectOptionHtml() {
		return questionSelectOptionHtml;
	}
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public int getProjectId() {
		return projectId;
	}
	
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	public int getQuestionId() {
		return questionId;
	}
	
	public void setTopicList(List<QuestionTopic> topicList) {
		this.topicList = topicList;
	}
	
	public List<QuestionTopic> getTopicList() {
		return topicList;
	}
	
	public void setFailTitle(String failTitle) {
		this.failTitle = failTitle;
	}
	
	public String getFailTitle() {
		return failTitle;
	}
	
	public void setCustomerFocusSelectOptionHtml(
			String customerFocusSelectOptionHtml) {
		this.customerFocusSelectOptionHtml = customerFocusSelectOptionHtml;
	}
	
	public String getCustomerFocusSelectOptionHtml() {
		return customerFocusSelectOptionHtml;
	}
	
	public void setKnownFromSelectOptionHtml(String knownFromSelectOptionHtml) {
		this.knownFromSelectOptionHtml = knownFromSelectOptionHtml;
	}
	
	public String getKnownFromSelectOptionHtml() {
		return knownFromSelectOptionHtml;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
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

	public LinkedHashMap getSelRoomType() {
		return selRoomType;
	}

	public void setSelRoomType(LinkedHashMap selRoomType) {
		this.selRoomType = selRoomType;
	}

	public LinkedHashMap getSelKnownFrom() {
		return selKnownFrom;
	}
	
	public void setSelKnownFrom(LinkedHashMap selKnownFrom) {
		this.selKnownFrom = selKnownFrom;
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
	
	

}
