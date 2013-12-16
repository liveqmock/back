package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.QuestionAnwser;
import com.ihk.saleunit.data.pojo.QuestionAnwserCond;

/**
 * QuestionAnwser的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IQuestionAnwserServices {
	/**
	 * 新增QuestionAnwser
	 * @param questionAnwser
	 */
	public void addQuestionAnwser(QuestionAnwser questionAnwser) throws RuntimeException;

	/**
	 * 删除一条QuestionAnwser
	 * @param id
	 */
	public void deleteQuestionAnwser(int id) throws RuntimeException;

	/**
	 * 修改QuestionAnwser
	 * @param questionAnwser
	 */
	public void updateQuestionAnwser(QuestionAnwser questionAnwser) throws RuntimeException;

	/**
	 * 查找一条QuestionAnwser
	 * @return QuestionAnwser
	 * @param id 主键id
	 */
	public QuestionAnwser findQuestionAnwserById(int id) throws RuntimeException;

	/**
	 * 分页查找QuestionAnwser
	 * @param cond 查询条件
	 * @return QuestionAnwser列表
	 */
	public List<QuestionAnwser> findQuestionAnwserPage(QuestionAnwserCond cond) throws RuntimeException;

	/**
	 * 查找全部QuestionAnwser
	 * @param cond 查询条件
	 * @return QuestionAnwser列表
	 */
	public List<QuestionAnwser> findQuestionAnwser(QuestionAnwserCond cond) throws RuntimeException;
}