package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;

/**
 * QuestionTopic数据访问接口Mapper
 * @author 
 *
 */ 
public interface IQuestionTopicMapper {

	/**
	 * 新增QuestionTopic
	 * @param questionTopic
	 */
	public void addQuestionTopic(QuestionTopic questionTopic) ;

	/**
	 * 根据条件删除QuestionTopic
	 * @param cond 删除条件
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
	public List<QuestionTopic> findQuestionTopicPage(QuestionTopicCond cond) ;

	/**
	 * 查找全部QuestionTopic
	 * @param cond 查询条件
	 * @return QuestionTopic列表
	 */
	public List<QuestionTopic> findQuestionTopic(QuestionTopicCond cond) ;

	/**
	 * 查找符合条件的记录条数QuestionTopic
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findQuestionTopicCount(QuestionTopicCond cond) ;
	
	/**
	 * 新增公用的Topic
	 * @param qid
	 */
	public void insertBaseTopic(int qid);
	
	/**
	 * 根据模板进行拷贝
	 * @param cond
	 */
	public void copyByDemo(QuestionTopicCond cond);
}
