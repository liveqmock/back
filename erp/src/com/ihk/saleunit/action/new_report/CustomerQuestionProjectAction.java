package com.ihk.saleunit.action.new_report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContSessionAttribute;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.collection.XLSExport;
import com.ihk.customer.data.ICustomerFollowMapper;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerFollowServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCompany;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProjectCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProject;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestion;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestionCond;
import com.ihk.report.data.services.IReportPreCustomerServices;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetail;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetailCond;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.pojo.RolePriv;
import com.ihk.user.data.pojo.RolePrivCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.AJAXUtils;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.method.ActionAjaxMethodModifyNoThrowsExceptionCallback;

/**
 * 客户问卷分类(项目)
 *
 */
public class CustomerQuestionProjectAction extends SupperAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	IReportPreCustomerServices reportPreCustomerServices ;
	@Autowired
	IQuestionTopicServices questionTopicServices ;
	@Autowired
	ICodeTypeServices codeTypeServices;
	@Autowired
	IRegionServices regionServices;
	
	private ReportPreCustomerProjectCond cond;

	private LinkedHashMap<String,String> questionList;

	public LinkedHashMap<String,String> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(LinkedHashMap<String,String> questionList) {
		this.questionList = questionList;
	}

	private int questionId;
	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	/**
	 * 直接返回查询的列表格式
	 * @return
	 * @throws Exception
	 */
	public String index() throws Exception {
		//项目问卷下拉框
		questionList=new LinkedHashMap<String,String>();
		questionList.put("0", "请选择");
		return SUCCESS;
	}
	
	/**
	 * session保存页面当前数据，用于下载
	 * @param dataList
	 */
	private void setDownloadDataInSession(List<Map<String, String>> dataList){
		request.getSession().setAttribute(ContSessionAttribute.CUSTOMER_QUESTION_PROJECT+ContSessionAttribute.DOWNLOAD_DATA, dataList);		
	}


	public void setCond(ReportPreCustomerProjectCond cond) {
		this.cond = cond;
	}

	public ReportPreCustomerProjectCond getCond() {
		return cond;
	}
	
	/**
	 * 下载数据
	 * @return
	 * @throws Exception
	 */
	public String download() throws Exception {			

		@SuppressWarnings("unchecked")
		List<Map<String, String>> dataList = (List<Map<String, String>>) request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_QUESTION_PROJECT+ContSessionAttribute.DOWNLOAD_DATA);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList); //与模板里面的循环要求对应
		
		ReportUtils.downLoadReport(map, "customer_question_project.xls", "download-客户问卷分类-项目-" + CustomerUtils.getNowForString() + ".xls", response);
		
		return null;
	}
	

	/**
	 * 点击查询的数据返回
	 * @return
	 * @throws Exception
	 */
	public String searchAjax() throws Exception {
		if(cond==null){
			cond = new ReportPreCustomerProjectCond();
		}
		
		if(cond.getSearchCompanyProjectIds().size()==0){
			return null;
		}
		
		if(this.questionId<0){
			return null;
		}
		else if(this.questionId==0){
			responseByBaseQuestion();
		}
		else{
			responseByDefineQuestion();			
		}		
		
		return null;
	}

	/**
	 * 基本售前问卷的报表输出<br>
	 * 包括必填内容与自定义内容(售前基本问卷)
	 */
	private void responseByBaseQuestion() throws Exception {
		int companyProjectId = cond.getSearchCompanyProjectIds().get(0);
		CompanyProject companyProject = DescUtils.getCompanyProjectByProjectId(companyProjectId);
		ArrayList<Integer> searchProjectIds = new ArrayList<Integer>();
		searchProjectIds.add(companyProjectId);

		//具体售前客户问卷的回答情况
		ReportPreCustomerQuestionCond questionCond = new ReportPreCustomerQuestionCond();
		questionCond.setDate1(cond.getDate1());
		questionCond.setDate2(cond.getDate2());
		questionCond.setSearchCompanyProjectIds(searchProjectIds);
		List<ReportPreCustomerQuestion> listQuestion = reportPreCustomerServices.findQuestionGroupByTopicProject(questionCond);

		//HashMap的存储格式[topicName,ReportPreCustomerQuestion]
		//HashMap性能提升，用于提升遍历性能,设置对象的主从关系
		HashMap<String,ReportPreCustomerQuestion> hmAnswer = new HashMap<String,ReportPreCustomerQuestion>();
		for(int i=0; i<listQuestion.size(); i++){
			hmAnswer.put(listQuestion.get(i).getTopicName()+"_"+listQuestion.get(i).getTopicContent(), listQuestion.get(i));
		}
		
		//必填内容
		List<Map<String, String>> retList = new ArrayList<Map<String,String>>();

		LinkedHashMap<EnumCodeTypeName, String> listBaseCategory = CustomerUtils.getQuestionReportEnumCodeType();
		
		
		for(Entry<EnumCodeTypeName,String> entryCategory:listBaseCategory.entrySet()){
			Map<String, String> map = null;
			
			//区域取区域表的数据
			if(entryCategory.getKey().equals(EnumCodeTypeName.HOME_DISTRICT)||
					entryCategory.getKey().equals(EnumCodeTypeName.WORK_DISTRICT)){				
				List<Region> listRegin = regionServices.findRegionByCityId(companyProject.getCityId());
				for(Region region:listRegin){			
					map = new HashMap<String, String>();
					map.put("topicId", entryCategory.getValue());
					map.put("topicName", entryCategory.getValue());
					map.put("topicContent", region.getRegionName());
					
					String answerKey = entryCategory.getKey()+"_"+region.getRegionId();
					
					if(hmAnswer.get(answerKey)!=null){
						ReportPreCustomerQuestion question = (ReportPreCustomerQuestion)hmAnswer.get(answerKey);
						map.put("sumCount", question.getSumCount()+"");
					}
					else{
						map.put("sumCount", "0");						
					}
					
					retList.add(map);					
				}
				
				continue;
			}
			
			//取字典表的数据
			LinkedHashMap<String,String> linkedMap = codeTypeServices.findCodeListForSel(entryCategory.getKey(),companyProjectId , false);
			for(Entry<String,String> entry:linkedMap.entrySet()){			
				map = new HashMap<String, String>();
				map.put("topicId", entryCategory.getValue());
				map.put("topicName", entryCategory.getValue());
				map.put("topicContent", entry.getValue());

				String answerKey = entryCategory.getKey()+"_"+entry.getKey();
				
				if(hmAnswer.get(answerKey)!=null){
					ReportPreCustomerQuestion question = (ReportPreCustomerQuestion)hmAnswer.get(answerKey);
					map.put("sumCount", question.getSumCount()+"");
				}
				else{
					map.put("sumCount", "0");						
				}
				retList.add(map);
			}
		}
				
		setDownloadDataInSession(retList);
		
		AJAXUtils.writeResponse(response, CommonUtils.getMapJsonAnd(retList));
		
	}
	
	/**
	 * 自定义项目问卷的报表输出
	 */
	private void responseByDefineQuestion() throws Exception {
		setCondOrderSortByRequest(cond);
		//1,根据question_id取出question_topic，形成一个空表
		//2,取出对应question下面的所有答案question_answer_detail,填写空表的数值
		//形成对应的List<Map>进行返回

		//1,问卷
		QuestionTopicCond questionTopicCond = new QuestionTopicCond();
		questionTopicCond.setQuestionId(questionId);
		List<QuestionTopic> listTopic = questionTopicServices.findQuestionTopic(questionTopicCond);

		//2,答卷
		QuestionAnswerDetailCond questionAnswerDetailCond = new QuestionAnswerDetailCond();
		questionAnswerDetailCond.setQuestionId(String.valueOf(questionId));
		questionAnswerDetailCond.setDate1(cond.getDate1());
		questionAnswerDetailCond.setDate2(cond.getDate2());
		List<QuestionAnswerDetail> listAnswer = reportPreCustomerServices.findQuestionAnswerDetail(questionAnswerDetailCond);

		//HashMap的存储格式[topicId,[listAnswer]]
		//HashMap性能提升，用于提升遍历性能,设置对象的主从关系
		HashMap<Integer,List<QuestionAnswerDetail>> hmAnswer = new HashMap<Integer,List<QuestionAnswerDetail>>();
		for(int i=0; i<listAnswer.size(); i++){
			hmAnswer.put(listAnswer.get(i).getTopicId(), new ArrayList<QuestionAnswerDetail>());
		}

		for(QuestionAnswerDetail qad : listAnswer){
			hmAnswer.get(qad.getTopicId()).add(qad);
		}
		
		List<Map<String, String>> retList = new ArrayList<Map<String,String>>();
		
		if(!CommonUtils.isCollectionEmpty(listTopic)){
			Map<String, String> map = null;
			
			//与jsp中table的表头(th field)定义一致
			for(QuestionTopic obj : listTopic){
				String[] topicContents=obj.getTopicContent().split("\\r\\n");
				for(String topicContent:topicContents){
					map = new HashMap<String, String>();

					map.put("topicId", String.valueOf(obj.getId()));
					map.put("topicName", obj.getTopicName().trim());
					map.put("topicContent", topicContent.trim());
					
					List<QuestionAnswerDetail> listAnswerOne = hmAnswer.get(obj.getId());
					int sumCount = 0;
					if(listAnswerOne!=null){
						for(QuestionAnswerDetail detailOne :listAnswerOne){
							if(detailOne.getAnwserContent().contains("1:"+topicContent)){
								sumCount++;
							}
						}
					}
					map.put("sumCount", String.valueOf(sumCount));
					
					retList.add(map);
				}
			}
		}
		
		setDownloadDataInSession(retList);
		
		AJAXUtils.writeResponse(response, CommonUtils.getMapJsonAnd(retList));
	}

}
