package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IQuestionMapper;
import com.ihk.saleunit.data.pojo.Question;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetail;
import com.ihk.saleunit.data.pojo.QuestionCond;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.services.IQuestionServices;

/**
 * Question的Services实现(业务实现)
 * @author 
 *
 */
@Service("questionServices")
@SuppressWarnings("unchecked")
public class QuestionServices implements IQuestionServices {
	/**
	 * question数据访问接口
	 */
	@Autowired	 IQuestionMapper questionMapper;

	/**
	 * 删除一条Question
	 * @param id
	 */
	public void deleteQuestion(int id) throws RuntimeException {
		questionMapper.deleteQuestion(id);
	}

	/**
	 * 新增Question
	 * @param question
	 */
	public void addQuestion(Question question) throws RuntimeException {		
		questionMapper.addQuestion(question);
	}

	/**
	 * 查找一条Question
	 * @return Question
	 * @param id 主键id
	 */
	@Override
	public Question findQuestionById(int id) throws RuntimeException {
		return questionMapper.findQuestionById(id);
	}

	/**
	 * 修改Question
	 * @param question
	 */
	@Override
	public void updateQuestion(Question question) throws RuntimeException {
		questionMapper.updateQuestion(question);		
	}

	/**
	 * 分页查找Question
	 * @param cond 查询条件
	 * @return Question列表
	 */
	public List<Question> findQuestionPage(QuestionCond cond) throws RuntimeException {
		int recordCount = questionMapper.findQuestionCount(cond);
		
		cond.recordCount = recordCount;
				
		return questionMapper.findQuestionPage(cond);
	}

	/**
	 * 查找全部Question
	 * @param cond 查询条件
	 * @return Question列表
	 */
	public List<Question> findQuestion(QuestionCond cond) throws RuntimeException {
    	return questionMapper.findQuestion(cond);
	}

	/**
	 * 查找一个公司里面最热门的项目问卷(回答次数最多)<br>
	 * Map的格式[projectName,questionId,questionName,answerCount]<br>
	 * [项目名称,问卷id,问卷名称,回答数量]
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Object>> findTopCompanyQuestion(QuestionCond cond) throws RuntimeException {
		cond.topNum = 20;
    	return questionMapper.findTopCompanyQuestion(cond);
	}

	
	public Question findByCompanyProjectId(int companyProjectId)throws RuntimeException{
		return questionMapper.findByCompanyProjectId(companyProjectId);
	}

	@Override
	public List<Question> findQuestionsByProjectId(int projectId)
			throws RuntimeException {
		return questionMapper.findQuestionsByProjectId(projectId);
	}

	@Override
	public void updateQuestionNameAndRemark(Question newQuestion) throws RuntimeException {
		questionMapper.updateQuestionNameAndRemark(newQuestion);
		
	}

}
