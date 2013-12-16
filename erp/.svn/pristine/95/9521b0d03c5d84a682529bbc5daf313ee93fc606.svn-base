package com.ihk.saleunit.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.Question;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetail;
import com.ihk.saleunit.data.pojo.QuestionCond;
import com.ihk.saleunit.data.pojo.QuestionTopic;

/**
 * Question的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IQuestionServices {
	/**
	 * 新增Question
	 * @param question
	 */
	public void addQuestion(Question question) throws RuntimeException;

	/**
	 * 删除一条Question
	 * @param id
	 */
	public void deleteQuestion(int id) throws RuntimeException;

	/**
	 * 修改Question
	 * @param question
	 */
	public void updateQuestion(Question question) throws RuntimeException;

	/**
	 * 查找一条Question
	 * @return Question
	 * @param id 主键id
	 */
	public Question findQuestionById(int id) throws RuntimeException;

	/**
	 * 分页查找Question
	 * @param cond 查询条件
	 * @return Question列表
	 */
	public List<Question> findQuestionPage(QuestionCond cond) throws RuntimeException;

	/**
	 * 查找全部Question
	 * @param cond 查询条件
	 * @return Question列表
	 */
	public List<Question> findQuestion(QuestionCond cond) throws RuntimeException;

	/**
	 * 查找一个公司里面最热门的项目问卷(回答次数最多)<br>
	 * Map的格式[projectName,questionId,questionName,answerCount]<br>
	 * [项目名称,问卷id,问卷名称,回答数量]
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Object>> findTopCompanyQuestion(QuestionCond cond) throws RuntimeException;
	
	/**
	 * 查找项目自定义问卷  1对1
	 * */
	public Question findByCompanyProjectId(int companyProjectId)throws RuntimeException;
	
	/**
	 * 查找项目自定义问卷  1对1
	 * */
	public List<Question> findQuestionsByProjectId(int projectId)throws RuntimeException;
	
	
	public void updateQuestionNameAndRemark(Question newQuestion) throws RuntimeException;
	
}