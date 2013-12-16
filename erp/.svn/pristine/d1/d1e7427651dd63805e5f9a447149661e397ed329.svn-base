package com.ihk.saleunit.action.new_init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.Question;
import com.ihk.saleunit.data.pojo.QuestionCond;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;
import com.ihk.saleunit.data.services.IQuestionServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.utils.SupperAction;

/**
 * 客户问卷
 */
public class CusQuestionAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	@Autowired IQuestionServices questionServices;
	@Autowired IQuestionTopicServices questionTopicServices;
	private int buildId;
	private List<Question> queList;
	private List<Map> queMap;
	
	@SuppressWarnings("unchecked")
	public String indexTab(){
		if(buildId == 0){
			return "suc";
		}
		QuestionCond cond = new QuestionCond();
		cond.setProjectId(buildId);
		queList = questionServices.findQuestion(cond);
		
		queMap = new ArrayList<Map>();
		for(Question qq: queList){
			Map p = new HashMap<String, Object>();
			p.put("ques", qq);
			QuestionTopicCond cond1 = new QuestionTopicCond();
			cond1.setQuestionId(qq.getId());
			List<QuestionTopic> queTopicList =  questionTopicServices.findQuestionTopic(cond1);
			p.put("toc", queTopicList);
			queMap.add(p);
		}
		return "suc";
		
		
		
	}

	public List<Map> getQueMap() {
		return queMap;
	}

	public void setQueMap(List<Map> queMap) {
		this.queMap = queMap;
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}


	
	
	

}
