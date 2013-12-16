package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;

/**
 * QuestionTopic的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IQuestionTopicServices {
	/**
	 * 新增QuestionTopic
	 * @param questionTopic
	 */
	public void addQuestionTopic(QuestionTopic questionTopic) throws RuntimeException;

	/**
	 * 删除一条QuestionTopic
	 * @param id
	 */
	public void deleteQuestionTopic(int id) throws RuntimeException;

	/**
	 * 修改QuestionTopic
	 * @param questionTopic
	 */
	public void updateQuestionTopic(QuestionTopic questionTopic) throws RuntimeException;

	/**
	 * 查找一条QuestionTopic
	 * @return QuestionTopic
	 * @param id 主键id
	 */
	public QuestionTopic findQuestionTopicById(int id) throws RuntimeException;

	/**
	 * 分页查找QuestionTopic
	 * @param cond 查询条件
	 * @return QuestionTopic列表
	 */
	public List<QuestionTopic> findQuestionTopicPage(QuestionTopicCond cond) throws RuntimeException;

	/**
	 * 查找全部QuestionTopic
	 * @param cond 查询条件
	 * @return QuestionTopic列表
	 */
	public List<QuestionTopic> findQuestionTopic(QuestionTopicCond cond) throws RuntimeException;
	
	/**
	 * 新增
	 * @param qid
	 * @throws RuntimeException
	 */
	public void insertBaseTopic(int qid)throws RuntimeException;
	
	/**
	 * 根据模板复制
	 * @param cond
	 * @throws RuntimeException
	 */
	public void copyByDemo(QuestionTopicCond cond)throws RuntimeException;
}