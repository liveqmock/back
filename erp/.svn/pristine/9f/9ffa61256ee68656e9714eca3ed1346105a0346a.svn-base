package com.ihk.saleunit.action.new_questions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContCompanyId;
import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.Question;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetail;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetailCond;
import com.ihk.saleunit.data.pojo.QuestionAnwser;
import com.ihk.saleunit.data.pojo.QuestionAnwserCond;
import com.ihk.saleunit.data.pojo.QuestionCond;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;
import com.ihk.saleunit.data.pojo.SaleDefaultQuestion;
import com.ihk.saleunit.data.pojo.SaleDefaultQuestionCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IQuestionAnswerDetailServices;
import com.ihk.saleunit.data.services.IQuestionAnwserServices;
import com.ihk.saleunit.data.services.IQuestionServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.saleunit.data.services.ISaleDefaultQuestionServices;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.ProvinceCond;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.IProvinceServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 销控中心 使用客户问卷
 * */
public class NewQuestionAnswerAction extends SupperAction{
	private static final long serialVersionUID = 1L;

	@Autowired IQuestionAnwserServices questionAnwserServices;
	@Autowired IQuestionTopicServices questionTopicServices;
	@Autowired IQuestionServices questionServices;
	@Autowired IQuestionAnswerDetailServices questionAnswerDetailServices;
	@Autowired IPropertyUnitServices propertyUnitServices;
	@Autowired IPropertyBuildServices propertyBuildServices; 
	@Autowired IProvinceServices provinceServices;
	@Autowired IContractCustomerServices contractCustomerServices;
	@Autowired IConfirmServices confirmServices;
	private String id;
	private List<QuestionAnwser> anwserList;
	private List<Question> quesList;
	private List<Map<String,String>> tocList;
	private Map<String, String[]> formMap;
	private String tips;
	private String path;
	private String customerId;
	private LinkedHashMap<String,String> customerList;
	
	private static List<ContractCustomer> getCustomerListByUnitId(int unitId){
		Confirm confirm=MyPropertyUtils.getConfirmServices().findConfirmByUnitId(unitId);
		if(confirm==null){
			return null;
		}
		List<ContractCustomer> ccList=MyPropertyUtils.getContractCustomerServices().findContractCustomerByMainIdAndConfirmType(confirm.getId(), ContConfirmType.CONFIRM);
		return ccList;
	}
	
	public String showAnwser(){
		SaleDefaultQuestionCond dcond = new SaleDefaultQuestionCond();
		List<ContractCustomer> ccList=getCustomerListByUnitId(Integer.parseInt(id));
		if(ccList==null) return "suc";
		List<SaleDefaultQuestion> dlist = new ArrayList<SaleDefaultQuestion>();
		for(ContractCustomer cc:ccList){
			dcond.setCustomerId(cc.getId());
			List<SaleDefaultQuestion> newSdqList=saleDefaultQuestionServices.findSaleDefaultQuestion(dcond);
			dlist.addAll(newSdqList);
		}
		
		
		
		QuestionAnwserCond cond = new QuestionAnwserCond();
		if(id.equals("0"))id = "-1";
		cond.setUnitId(id);
		List<QuestionAnwser> questionAnwserList = questionAnwserServices.findQuestionAnwser(cond);
		
		List<QuestionAnwser> anwserList=new ArrayList<QuestionAnwser>();
		
		for(SaleDefaultQuestion q : dlist){
			QuestionAnwser a = new QuestionAnwser();
			a.setId(-q.getId());
			a.setCustomerName(q.getCustomerName());
			a.setCreatedId(q.getCreatedId());
			a.setCreatedTime(q.getCreatedTime());
			a.setUnitId(q.getUnitId());
			
			anwserList.add(0,a);
		}
		anwserList.addAll(questionAnwserList);
		this.anwserList=anwserList;
		return "suc";
	}
	
	public String answerDialog() throws IOException{
		//先提供所有的问卷选择
		//在选择了问卷的时候AJAX访问 找到
		//this.tips = "";
			path = "./saleunit_new_questions/appoint/guangzhou/questionAnswerForm.action?";
			QuestionCond cond = new QuestionCond();
			if(id.equals("0")){
				quesList = new ArrayList<Question>();
				this.tips = "没有选择单元";
				this.setSuggestion("请先选择单元.");
			}else{
				List<ContractCustomer> ccList=getCustomerListByUnitId(Integer.parseInt(id));
				if(ccList==null){
					CustomerUtils.writeResponse(response, "false");
					return null;
				}
				customerList=new LinkedHashMap<String,String>();
				for(ContractCustomer cc:ccList){
					for(int i=0;i<cc.getCustomerName().split(",").length;i++){
						customerList.put(cc.getId()+","+cc.getCustomerName().split(",")[i], cc.getCustomerName().split(",")[i]);
					}
				}
				PropertyUnit un = propertyUnitServices.findPropertyUnitById(Integer.parseInt(id));
				PropertyBuild bb = propertyBuildServices.findPropertyBuildById(un.getBuildId());
				cond.setProjectId(bb.getPropertyId());
				quesList = questionServices.findQuestion(cond);
				/////////这里会在第一列放入一个通用的基本问卷 ID=61的问卷提出来作为通用问卷★★★★★
				Question q = new Question();
				//q = questionServices.findQuestionById(61);//默认自定义问卷
				q.setId(-1);
				q.setQuestionName("基本问卷");
				
				quesList.add(0, q);
			}
				
		
			
			
			
		return "suc";
		
	}
	
	/**answerDialog 辅助方法 在选择问卷的时候把问卷的内容传递过去
	 * @param id 所选择的问卷ID
	 * */
	public String anserDialogSelectChange(){
		if(Integer.parseInt(id) == -1){//默认售后问卷
			return initSaleDefaultQuestion();
		}
		tocList = initQuestionHtml(id);
		
		return "suc";
	}
	
	
	private LinkedHashMap selRating; //客户评级
	private LinkedHashMap selProvince; //省
	private LinkedHashMap selHomeCity; //居住市
	private LinkedHashMap selHomeRegion; //居住区域
	
	private LinkedHashMap selWorkCity; //工作市
	private LinkedHashMap selWorkRegion; //工作区域
	
	private LinkedHashMap selNativeCity; //工作市
	private LinkedHashMap selNativeRegion; //工作区域
	
	private LinkedHashMap selBuyUse; //购房用途
	private LinkedHashMap selBuyCount; //置业次数
	private LinkedHashMap selHouseType; //产品类型
	private LinkedHashMap selCustomerSource; //客户来源
	
	/**默认售后问卷
	 * 和售前客户问卷的固定部分类似
	 * */
	private String initSaleDefaultQuestion(){
		init();
		return "defaultQuestion";
	}
	
	private void init(){
		selBuyUse = DescUtils.getInitSelForGuangZhou(selBuyUse, EnumCodeTypeName.BUY_USE, true);
		selBuyCount = DescUtils.getInitSelForGuangZhou(selBuyCount, EnumCodeTypeName.BUY_COUNT, true);
		selHouseType = DescUtils.getInitSelForGuangZhou(selHouseType, EnumCodeTypeName.HOUSE_TYPE, true);
		selCustomerSource = DescUtils.getInitSelForGuangZhou(selCustomerSource, EnumCodeTypeName.CUSTOMER_SOURCE, true, ContCompanyId.AN_HUI); //客户来源
		selRating = DescUtils.getInitSelForGuangZhou(selRating,EnumCodeTypeName.RATING,true);
		initSelProvince();
	}
	
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
	
	private SaleDefaultQuestion customer;
	/**
	 * 提交问卷答案
	 * @throws IOException 
	 * */
	public String dialogForm() throws IOException{
		if(questionId.equals("-1")){
			addDefaultQuestion();
			this.setId(unitId);
			return answerDialog();
		}
		
		//需要 问卷的id 提交的答案 是一个Map key是问卷的明细里面的题目ID 
		addQuestion();
		this.setId(unitId);
		return answerDialog();
	}
	
	private String reMark;
	private String customerName;
	private String unitId;
	private String buildId;
	private String questionId;
	private void addQuestion(){
    	if( formMap == null|| formMap.size() == 0){
    		this.tips = "没有回答问卷!";
    		this.setSuggestion("请选择问卷进行填写.");
    		return;
    	}
//    	if(customerId == 0 ){
//    		this.tips = "请填写回答人!";
//    		this.setSuggestion("请填写回答人.");
//    		return;
//    	}
    	List<QuestionTopic> tocl = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(Integer.parseInt(questionId)));
		QuestionAnwser tqa = new QuestionAnwser();
		tqa.setQuestionId(Integer.parseInt(questionId));
		
		tqa.setIsDeleted("0");
		tqa.setCreatedId(SessionUser.getUserId());
		tqa.setCreatedTime(new Date());
		tqa.setModId(SessionUser.getUserId());
		tqa.setModTime(tqa.getCreatedTime());
		tqa.setUnitId(Integer.parseInt(unitId));
		tqa.setCustomerName(customerId.split(",")[1]);
		tqa.setRemark(reMark);
	//	tqa.setPreCustomerId(custid);
		questionAnwserServices.addQuestionAnwser(tqa);
		
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
			questionAnswerDetailServices.addQuestionAnswerDetail(anDe);
		}
		this.tips = "操作成功!";
    }
	
	@Autowired ISaleDefaultQuestionServices saleDefaultQuestionServices;
	/**
	 * 默认问卷录入
	 * */
	private void addDefaultQuestion(){
//		if(customerId == 0 ){
//    		this.tips = "请填写回答人!";
//    		this.setSuggestion("请填写回答人.");
//    		return;
//    	}
		
		customer.setUnitId(Integer.parseInt(unitId));
		customer.setCustomerId(Integer.parseInt(customerId.split(",")[0]));
		customer.setCustomerName(customerId.split(",")[1]);
		customer.setRemark(reMark);
		
		customer.setIsDeleted("0");
		customer.setCreatedId(SessionUser.getUserId());
		customer.setCreatedTime(new Date());
		customer.setModId(customer.getCreatedId());
		customer.setModTime(customer.getCreatedTime());
		saleDefaultQuestionServices.addSaleDefaultQuestion(customer);
		
		this.tips = "操作成功!";
	}
	
	private String topShow;//展示答卷名称
	/**根据答卷ID
	 * 解析出相应的 问卷 和 答案
	 *  然后 组装成已经填好的数据 
	 *  弹出
	 *  这里的ID 应该是 答卷ID
	 *  */
	public String updateAndShowDialog(){
		if(Integer.parseInt(id) < 0){//基本问卷
			path = "./saleunit_new_questions/appoint/guangzhou/updateDeForm.action";
			this.customer = this.saleDefaultQuestionServices.findSaleDefaultQuestionById(-Integer.parseInt(id));
			init();
			this.selHomeCity = this.initSelHomeCity(this.selHomeCity,customer.getHomeProvince());
			this.selHomeRegion = this.initSelHomeRegion(this.selHomeRegion,customer.getHomeCity());
			
			this.selWorkCity = this.initSelHomeCity(this.selWorkCity , customer.getWorkProvince());
			this.selWorkRegion = this.initSelHomeRegion(this.selWorkRegion , customer.getWorkCity());
			
			this.selNativeCity  = this.initSelHomeCity(this.selNativeCity , customer.getNativeProvince());
			this.selNativeRegion = this.initSelHomeRegion(this.selNativeRegion , customer.getNativeCity());
			return "defaultQuestion";
		}
		path = "./saleunit_new_questions/appoint/guangzhou/updateForm.action";
		tocList = initQuestionHtmlByAnser(id);
		return "suc";
	}
	
	public String updateDeForm(){
		SaleDefaultQuestion upQuestion = this.saleDefaultQuestionServices.findSaleDefaultQuestionById(-Integer.parseInt(id));
		if(customer.getCustomerName().equals("")){
			init();
			this.selHomeCity = this.initSelHomeCity(this.selHomeCity,upQuestion.getHomeProvince());
			this.selHomeRegion = this.initSelHomeRegion(this.selHomeRegion,upQuestion.getHomeCity());
			
			this.selWorkCity = this.initSelHomeCity(this.selWorkCity , upQuestion.getWorkProvince());
			this.selWorkRegion = this.initSelHomeRegion(this.selWorkRegion , upQuestion.getWorkCity());
			
			this.selNativeCity  = this.initSelHomeCity(this.selNativeCity , upQuestion.getNativeProvince());
			this.selNativeRegion = this.initSelHomeRegion(this.selNativeRegion , upQuestion.getNativeCity());
			this.tips = "alert('名字不能为空')";
			return "suc";
		}
		upQuestion.setModId(SessionUser.getUserId());
		upQuestion.setModTime(new Date());
		upQuestion.setRating(customer.getRating());
		upQuestion.setPhone(customer.getPhone());
		upQuestion.setHomePhone(customer.getHomePhone());
		upQuestion.setHomeProvince(customer.getHomeProvince());
		upQuestion.setHomeCity(customer.getHomeCity());
		upQuestion.setHomeRegion(customer.getHomeRegion());
		upQuestion.setHomeContent(customer.getHomeContent());
		
		upQuestion.setWorkProvince(customer.getWorkProvince());
		upQuestion.setWorkCity(customer.getWorkCity());
		upQuestion.setWorkRegion(customer.getWorkRegion());
		upQuestion.setWorkContent(customer.getWorkContent());
		
		upQuestion.setNativeProvince(customer.getNativeProvince());
		upQuestion.setNativeCity(customer.getNativeCity());
		upQuestion.setNativeRegion(customer.getNativeRegion());
		upQuestion.setNativeContent(customer.getNativeContent());
		
		upQuestion.setBuyUse(customer.getBuyUse());
		upQuestion.setBuyCount(customer.getBuyCount());
		upQuestion.setCustomerSource(customer.getCustomerSource());
		upQuestion.setRoomType(customer.getRoomType());
		
		upQuestion.setRemark(customer.getRemark());
		upQuestion.setCustomerName(customer.getCustomerName());
		
		this.saleDefaultQuestionServices.updateSaleDefaultQuestion(upQuestion);
		
		customer = upQuestion;
		init();
		this.selHomeCity = this.initSelHomeCity(this.selHomeCity,upQuestion.getHomeProvince());
		this.selHomeRegion = this.initSelHomeRegion(this.selHomeRegion,upQuestion.getHomeCity());
		
		this.selWorkCity = this.initSelHomeCity(this.selWorkCity , upQuestion.getWorkProvince());
		this.selWorkRegion = this.initSelHomeRegion(this.selWorkRegion , upQuestion.getWorkCity());
		
		this.selNativeCity  = this.initSelHomeCity(this.selNativeCity , upQuestion.getNativeProvince());
		this.selNativeRegion = this.initSelHomeRegion(this.selNativeRegion , upQuestion.getNativeCity());
		this.tips = "alert('操作成功')";
		
		return "suc";
	}
	
	public String updateForm(){
		//id = 问卷的ID
		updateQuestion();
		return updateAndShowDialog();
	}
	
	private void updateQuestion(){
	    	if( formMap == null|| formMap.size() == 0)return;
	    	
			QuestionAnwser tqa = questionAnwserServices.findQuestionAnwserById(Integer.parseInt(id));
			List<QuestionAnswerDetail> deList = questionAnswerDetailServices.findQuestionAnswerDetail(new QuestionAnswerDetailCond().setAnwserId(tqa.getId()+""));
			
			for(QuestionAnswerDetail c : deList){
				String[] anws = this.formMap.get("hh"+c.getId());
				if(anws == null || anws.length == 0){
					String[] tm = {"-1"};
					anws = tm;
				}
				String sanws = "";
				
				String[] questoc = c.getAnwserContent().split("\r\n");
				
				for(int i = 0 ; i < questoc.length; i ++){
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
					// TODO: handle exception
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
				c.setTopicId(c.getId());
				questionAnswerDetailServices.updateQuestionAnswerDetail(c);
			}
	    }
	
	/**
	 * 把QuestionAnser 表示删除
	 * */
	public String delAnser(){
		int delid = Integer.parseInt(id);
		if(delid < 0){
			this.saleDefaultQuestionServices.deleteSaleDefaultQuestion(-delid);
		}
		this.questionAnwserServices.deleteQuestionAnwser(Integer.parseInt(id));
		return null;
	}
	
	/**
	 * @param questionId 所选问卷ID 
	 * */
	private List<Map<String,String>> initQuestionHtml(String questionId){
		//1 先找到问卷详细列表
		if(questionId == null || questionId .equals("")){
			questionId = "-1";
		}
		QuestionTopicCond cond = new QuestionTopicCond();
		cond.setQuestionId(Integer.parseInt(questionId));
		List<QuestionTopic> tmpTocList = questionTopicServices.findQuestionTopic(cond);
		List<Map<String,String>> tmpMap = new  ArrayList<Map<String,String>>();
		for (QuestionTopic qtc : tmpTocList) {
			HashMap<String, String> mm = new HashMap<String, String>() ;
			mm.put("name", qtc.getTopicName());
			mm.put("group", qtc.getTopicGroup());
			mm.put("content",qtc.getInputAndOtherHtml());
			tmpMap.add(mm);
		}
		return tmpMap;
	}
	
	private QuestionAnwser upQuestionAnwser;
	private  List<Map<String,String>> initQuestionHtmlByAnser(String anserId){
		QuestionAnwser tmpquestionas =  questionAnwserServices.findQuestionAnwserById(Integer.parseInt(anserId));
		upQuestionAnwser = tmpquestionas;
		Question tmpquestion = questionServices.findQuestionById(tmpquestionas.getQuestionId());
		this.topShow = tmpquestion.getQuestionName();
		List<QuestionAnswerDetail> tempanserDe = 
			questionAnswerDetailServices.findQuestionAnswerDetail(new QuestionAnswerDetailCond().setAnwserId(anserId));
		List<Map<String,String>> tmpMap = new  ArrayList<Map<String,String>>();
		for (QuestionAnswerDetail qtc : tempanserDe) {
			HashMap<String, String> mm = new HashMap<String, String>() ;
			mm.put("name", qtc.getTopicName());
			mm.put("group", qtc.getTopicGroup());
			mm.put("content",qtc.getInputAndOtherHtml());
			tmpMap.add(mm);
		}
		return tmpMap;
	}
	
	@Autowired ICityServices cityServices;
	public LinkedHashMap initSelHomeCity(LinkedHashMap homeCity, int ques){
		if(homeCity == null){
			
			homeCity = new LinkedHashMap();
			homeCity.put("", CommonUtils.EMPTY);
			
			try {
					List<City> citys = cityServices.findCityByProvinceId(ques);
					for(City city : citys){
						homeCity.put(city.getCityId(), city.getCityName());
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return homeCity;
	}
	
	@Autowired IRegionServices regionServices;
	public LinkedHashMap initSelHomeRegion(LinkedHashMap homeRegion,int ques){
		if(homeRegion == null){
			
			homeRegion = new LinkedHashMap();
			homeRegion.put("", CommonUtils.EMPTY);
			
			try {
					
					List<Region> regions = regionServices.findRegionByCityId(ques);
					for(Region region : regions){
						homeRegion.put(region.getRegionId(), region.getRegionName());
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return homeRegion;
	}
/*********************************************************************/
	
	
	public List<QuestionAnwser> getAnwserList() {
		return anwserList;
	}

	public QuestionAnwser getUpQuestionAnwser() {
	return upQuestionAnwser;
}

public void setUpQuestionAnwser(QuestionAnwser upQuestionAnwser) {
	this.upQuestionAnwser = upQuestionAnwser;
}

	public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAnwserList(List<QuestionAnwser> anwserList) {
		this.anwserList = anwserList;
	}

	public List<Question> getQuesList() {
		return quesList;
	}

	public void setQuesList(List<Question> quesList) {
		this.quesList = quesList;
	}

	public List<Map<String, String>> getTocList() {
		return tocList;
	}

	public void setTocList(List<Map<String, String>> tocList) {
		this.tocList = tocList;
	}

	public Map<String, String[]> getFormMap() {
		return formMap;
	}

	public void setFormMap(Map<String, String[]> formMap) {
		this.formMap = formMap;
	}

	public String getTopShow() {
		return topShow;
	}

	public void setTopShow(String topShow) {
		this.topShow = topShow;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getReMark() {
		return reMark;
	}

	public void setReMark(String reMark) {
		this.reMark = reMark;
	}
	

	

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public LinkedHashMap getSelRating() {
		return selRating == null ? new LinkedHashMap<String, String>() :selRating;
	}

	public void setSelRating(LinkedHashMap selRating) {
		this.selRating = selRating;
	}

	public LinkedHashMap getSelProvince() {
		return selProvince == null ? new LinkedHashMap<String, String>() :selProvince;
	}

	public void setSelProvince(LinkedHashMap selProvince) {
		this.selProvince = selProvince;
	}

	public LinkedHashMap getSelHomeCity() {
		return selHomeCity== null ? new LinkedHashMap<String, String>() :selHomeCity;
	}

	public void setSelHomeCity(LinkedHashMap selHomeCity) {
		this.selHomeCity = selHomeCity;
	}

	public LinkedHashMap getSelHomeRegion() {
		return selHomeRegion == null ? new LinkedHashMap<String, String>() :selHomeRegion;
	}

	public void setSelHomeRegion(LinkedHashMap selHomeRegion) {
		this.selHomeRegion = selHomeRegion;
	}

	public LinkedHashMap getSelBuyUse() {
		return selBuyUse== null ? new LinkedHashMap<String, String>() :selBuyUse;
	}

	public void setSelBuyUse(LinkedHashMap selBuyUse) {
		this.selBuyUse = selBuyUse;
	}

	public LinkedHashMap getSelBuyCount() {
		return selBuyCount== null ? new LinkedHashMap<String, String>() :selBuyCount;
	}

	public void setSelBuyCount(LinkedHashMap selBuyCount) {
		this.selBuyCount = selBuyCount;
	}

	public LinkedHashMap getSelHouseType() {
		return selHouseType== null ? new LinkedHashMap<String, String>() :selHouseType;
	}

	public void setSelHouseType(LinkedHashMap selHouseType) {
		this.selHouseType = selHouseType;
	}

	public LinkedHashMap getSelCustomerSource() {
		return selCustomerSource== null ? new LinkedHashMap<String, String>() :selCustomerSource;
	}

	public void setSelCustomerSource(LinkedHashMap selCustomerSource) {
		this.selCustomerSource = selCustomerSource;
	}

	public SaleDefaultQuestion getCustomer() {
		return customer;
	}

	public void setCustomer(SaleDefaultQuestion customer) {
		this.customer = customer;
	}

	public LinkedHashMap getSelWorkCity() {
		return selWorkCity;
	}

	public void setSelWorkCity(LinkedHashMap selWorkCity) {
		this.selWorkCity = selWorkCity;
	}

	public LinkedHashMap getSelWorkRegion() {
		return selWorkRegion;
	}

	public void setSelWorkRegion(LinkedHashMap selWorkRegion) {
		this.selWorkRegion = selWorkRegion;
	}

	public LinkedHashMap getSelNativeCity() {
		return selNativeCity;
	}

	public void setSelNativeCity(LinkedHashMap selNativeCity) {
		this.selNativeCity = selNativeCity;
	}

	public LinkedHashMap getSelNativeRegion() {
		return selNativeRegion;
	}

	public void setSelNativeRegion(LinkedHashMap selNativeRegion) {
		this.selNativeRegion = selNativeRegion;
	}

	public LinkedHashMap getCustomerList() {
		return customerList;
	}

	public void setCustomerList(LinkedHashMap customerList) {
		this.customerList = customerList;
	}

	






	
	
	
	
	
}
