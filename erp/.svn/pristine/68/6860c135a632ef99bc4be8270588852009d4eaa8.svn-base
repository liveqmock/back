package com.ihk.saleunit.action.new_questions;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.saleunit.data.pojo.Question;
import com.ihk.saleunit.data.pojo.QuestionCond;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;
import com.ihk.saleunit.data.services.IQuestionServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.common.unit.CommonUnitPojoUtils;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;

/**
 * 自定义问卷才做
 * 售后 售前  
 * */
public class QuestionAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired IQuestionServices questionServices;
	@Autowired IQuestionTopicServices questionTopicServices;
	
	@Autowired IPropertyBuildServices propertyBuildServices;
	
	@Autowired IPropertyProjectServices propertyProjectServices;
	private List<Question> queList;
	private List<QuestionTopic> queTopicList;
	
	private String topText;
	
	private int qid;//选择的question id
	private int qtid;
	private int treeId;//选择的树的ID
	private String treeType;//树ID的类型
	
	
	private Question newQuestion;
	
	private QuestionTopic newQuestionTopic;
	
	private String tips;
	
	/**查看楼栋  分区  项目下的问卷*/
	public String selectQuestion(){
		QuestionCond cond = new QuestionCond();
		cond.setBuildId(treeId+"");
		queList = questionServices.findQuestion(cond);
		return "suc";
	}
	
	/**查看问卷的详细信息*/
	public String selectQuestionTopic(){
		QuestionTopicCond cond = new QuestionTopicCond();
		cond.setQuestionId(qid);
		queTopicList =  questionTopicServices.findQuestionTopic(cond);
		
		return "suc";
	}

	/**新建问卷 弹出框*/
	public String newQuestion(){
		PropertyProject bu = propertyProjectServices.findPropertyProjectById(treeId);
		topText = "所选楼盘:"+bu.getPropertyName();
		return "suc";
	}
	
	
	/**新建一个问卷  必要条件  treeID treeType*/
	public String newQuestionForm(){
		//页面上提交 名称 和说明
//		if(treeType.equals("project"))
//			newQuestion.setProjectId(treeId);
//		else if(treeType.equals("project"))
//			newQuestion.setAreaId(treeId);
//		else if(treeType.equals("build"))
//			newQuestion.setBuildId(treeId);
//		
		if(treeId == 0){
			tips = "请先选择一个楼盘.";
			return "suc";
		}
		if(newQuestion.getQuestionName() == null || newQuestion.getQuestionName().trim().equals("")){
			tips = "名称为空,请填写.";
			return "suc";
		}
		PropertyProject bu = propertyProjectServices.findPropertyProjectById(treeId);
		List<Question> question=questionServices.findQuestionsByProjectId(bu.getId());
		if("基本问卷".equals(newQuestion.getQuestionName())){
			tips = "基本问卷为默认售后问卷,请重新填写.";
			return "suc";
		}
		for(Question q:question){
			if(q.getQuestionName().equals(newQuestion.getQuestionName())){
				tips = "问卷题目名称已存在,请重新填写.";
				return "suc";
			}
		}
		newQuestion.setProjectId(treeId);
		
		newQuestion.setIsDeleted("0");
		newQuestion.setCreatedId(SessionUser.getUserId());
		newQuestion.setCreatedTime(new Date());
		newQuestion.setModId(SessionUser.getUserId());
		newQuestion.setModTime(newQuestion.getCreatedTime());
		
		questionServices.addQuestion(newQuestion);
		
		tips = "新建成功!";
		return "suc";
	}
	
	/**新建一个 问题 必要条件 要选择了一个问卷 */
	public String questionTocAdd(){
		
		return "suc";
	}
	
	/**新建一个 问题 必要条件 要选择了一个问卷 */
	public String questionTocAddForm(){
		try {
			newQuestionTopic.setQuestionId(qid);
			newQuestionTopic.setIsDeleted("0");
			newQuestionTopic.setCreatedId(SessionUser.getUserId());
			newQuestionTopic.setCreatedTime(new Date());
			newQuestionTopic.setModId(SessionUser.getUserId());
			newQuestionTopic.setModTime(newQuestionTopic.getCreatedTime());
			questionTopicServices.addQuestionTopic(newQuestionTopic);
		} catch (Exception e) {
			tips = "请填写完整信息!";
			return "suc";
		}
		tips = "新建问题成功!";
		return "suc";
	}
	
	
	/**修改一个 问题 必要条件 要选择了一个问卷 */
	public String questionTocMod(){
		newQuestionTopic = questionTopicServices.findQuestionTopicById(qtid);
		return "suc";
	}
	
	/**修改一个 问题 必要条件 要选择了一个问卷 */
	public String questionTocModForm(){
		try {
			QuestionTopic qt = questionTopicServices.findQuestionTopicById(newQuestionTopic.getId());
			//newQuestionTopic.setFillType(qt.getFillType());
			newQuestionTopic.setQuestionId(qt.getQuestionId());
			newQuestionTopic.setFillType(qt.getFillType());
			newQuestionTopic.setOrderIndex(qt.getOrderIndex());
			CommonPojoUtils.initPojoCommonFiled(newQuestionTopic);
			questionTopicServices.updateQuestionTopic(newQuestionTopic);
		} catch (Exception e) {
			tips = "请填写完整信息!";
			return "suc";
		}
		tips = "修改问题成功!";
		return "suc";
	}
	
	public String customerTopicOrder(){
		queTopicList = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(qid));
		return "suc";
	}
	
	public String customerTopicOrderForm(){
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
				
			}
			
			@Override
			public void modifyMethod() throws Exception {
				try {
					List<QuestionTopic> qtList=questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(qid));
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
	
	
	private int questionTocId;
	/**
	 * 删除单个问题
	 * */
	public String delQuestionToc() throws Exception{
		if(questionTocId != 0){
			questionTopicServices.deleteQuestionTopic(questionTocId);
			CustomerUtils.writeResponse(response,"删除成功.");
		}else{
			CustomerUtils.writeResponse(response,"请重新操作.");
		}
		return null;
	}
	
	/**
	 * 删除问卷
	 * */
	public String delQuestion() throws Exception{
		if(qid != 0){
			questionServices.deleteQuestion(qid);
			CustomerUtils.writeResponse(response,"删除成功.");
		}else{
			CustomerUtils.writeResponse(response,"请重新操作.");
		}
		return null;
	}
	/*********************************************************************8*/
	public List<Question> getQueList() {
		return queList;
	}

	public void setQueList(List<Question> queList) {
		this.queList = queList;
	}

	public List<QuestionTopic> getQueTopicList() {
		return queTopicList;
	}

	public void setQueTopicList(List<QuestionTopic> queTopicList) {
		this.queTopicList = queTopicList;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getQtid() {
		return qtid;
	}

	public void setQtid(int qtid) {
		this.qtid = qtid;
	}

	public int getTreeId() {
		return treeId;
	}

	public void setTreeId(int treeId) {
		this.treeId = treeId;
	}

	public String getTreeType() {
		return treeType;
	}

	public void setTreeType(String treeType) {
		this.treeType = treeType;
	}

	public Question getNewQuestion() {
		return newQuestion;
	}

	public void setNewQuestion(Question newQuestion) {
		this.newQuestion = newQuestion;
	}

	public QuestionTopic getNewQuestionTopic() {
		return newQuestionTopic;
	}

	public void setNewQuestionTopic(QuestionTopic newQuestionTopic) {
		this.newQuestionTopic = newQuestionTopic;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getTopText() {
		return topText;
	}

	public void setTopText(String topText) {
		this.topText = topText;
	}

	public int getQuestionTocId() {
		return questionTocId;
	}

	public void setQuestionTocId(int questionTocId) {
		this.questionTocId = questionTocId;
	}
	
	
	
}
