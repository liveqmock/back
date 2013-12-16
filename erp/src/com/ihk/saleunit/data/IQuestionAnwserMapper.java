package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.QuestionAnwser;
import com.ihk.saleunit.data.pojo.QuestionAnwserCond;

/**
 * QuestionAnwser数据访问接口Mapper
 * @author 
 *
 */ 
public interface IQuestionAnwserMapper {

	/**
	 * 新增QuestionAnwser
	 * @param questionAnwser
	 */
	public void addQuestionAnwser(QuestionAnwser questionAnwser) ;

	/**
	 * 根据条件删除QuestionAnwser
	 * @param cond 删除条件
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
	public List<QuestionAnwser> findQuestionAnwserPage(QuestionAnwserCond cond) ;

	/**
	 * 查找全部QuestionAnwser
	 * @param cond 查询条件
	 * @return QuestionAnwser列表
	 */
	public List<QuestionAnwser> findQuestionAnwser(QuestionAnwserCond cond) ;

	/**
	 * 查找符合条件的记录条数QuestionAnwser
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findQuestionAnwserCount(QuestionAnwserCond cond) ;
}
