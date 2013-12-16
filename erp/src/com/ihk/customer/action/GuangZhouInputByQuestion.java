package com.ihk.customer.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.Question;
import com.ihk.saleunit.data.pojo.QuestionCond;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;
import com.ihk.saleunit.data.services.IQuestionServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.utils.SupperAction;

/**
 * 带问卷的录入?
 *
 */
public class GuangZhouInputByQuestion extends SupperAction{

	
	private static final long serialVersionUID = 1L;
	
	
	@Autowired IQuestionTopicServices questionTopicServices;
	@Autowired IQuestionServices questionServices;
	private List<QuestionTopic> tocList;
	private int proId;
	
	private int questId;
	//根据选择的company_project_id 得到问卷
	public String findTocList(){
		QuestionCond cond = new QuestionCond();
		cond.setCompanyProjectId(proId);
		try {
			Question ques = questionServices.findQuestion(cond).get(0);
			tocList = questionTopicServices.findQuestionTopic(new QuestionTopicCond().setQuestionId(ques.getId()));
			questId = ques.getId();
		} catch (Exception e) {
			// TODO: handle exception
			tocList = new ArrayList<QuestionTopic>();
		}
		return "suc";
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
	
	
}
