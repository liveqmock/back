package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IQuestionTopicMapper;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;
import com.ihk.saleunit.data.services.IQuestionTopicServices;

/**
 * QuestionTopic的Services实现(业务实现)
 * @author 
 *
 */
@Service("questionTopicServices")
@SuppressWarnings("unchecked")
public class QuestionTopicServices implements IQuestionTopicServices {
	/**
	 * questionTopic数据访问接口
	 */
	@Autowired	 IQuestionTopicMapper questionTopicMapper;

	/**
	 * 删除一条QuestionTopic
	 * @param id
	 */
	public void deleteQuestionTopic(int id) throws RuntimeException {
		questionTopicMapper.deleteQuestionTopic(id);
	}

	/**
	 * 新增QuestionTopic
	 * @param questionTopic
	 */
	public void addQuestionTopic(QuestionTopic questionTopic) throws RuntimeException {		
		questionTopicMapper.addQuestionTopic(questionTopic);
	}

	/**
	 * 查找一条QuestionTopic
	 * @return QuestionTopic
	 * @param id 主键id
	 */
	@Override
	public QuestionTopic findQuestionTopicById(int id) throws RuntimeException {
		return questionTopicMapper.findQuestionTopicById(id);
	}

	/**
	 * 修改QuestionTopic
	 * @param questionTopic
	 */
	@Override
	public void updateQuestionTopic(QuestionTopic questionTopic) throws RuntimeException {
		questionTopicMapper.updateQuestionTopic(questionTopic);		
	}

	/**
	 * 分页查找QuestionTopic
	 * @param cond 查询条件
	 * @return QuestionTopic列表
	 */
	public List<QuestionTopic> findQuestionTopicPage(QuestionTopicCond cond) throws RuntimeException {
		int recordCount = questionTopicMapper.findQuestionTopicCount(cond);
		
		cond.recordCount = recordCount;
				
		return questionTopicMapper.findQuestionTopicPage(cond);
	}

	/**
	 * 查找全部QuestionTopic
	 * @param cond 查询条件
	 * @return QuestionTopic列表
	 */
	public List<QuestionTopic> findQuestionTopic(QuestionTopicCond cond) throws RuntimeException {
    	return questionTopicMapper.findQuestionTopic(cond);
	}

	/**
	 * 新增
	 */
	@Override
	public void insertBaseTopic(int qid) throws RuntimeException {
		questionTopicMapper.insertBaseTopic(qid);
		
	}

	/**
	 * 拷贝根据
	 */
	@Override
	public void copyByDemo(QuestionTopicCond cond) throws RuntimeException {
		questionTopicMapper.copyByDemo(cond);
		
	}
}
