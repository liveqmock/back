package com.ihk.saleunit.data;

import java.util.List;
import java.util.Map;

import com.ihk.saleunit.action.new_report.cond.ZsCustomerAnalysisCond;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetail;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetailCond;

/**
 * QuestionAnswerDetail数据访问接口Mapper
 * @author 
 *
 */ 
public interface IQuestionAnswerDetailMapper {

	/**
	 * 新增QuestionAnswerDetail
	 * @param questionAnswerDetail
	 */
	public void addQuestionAnswerDetail(QuestionAnswerDetail questionAnswerDetail) ;

	/**
	 * 根据条件删除QuestionAnswerDetail
	 * @param cond 删除条件
	 */
	public void deleteQuestionAnswerDetail(int id) throws RuntimeException;

	/**
	 * 修改QuestionAnswerDetail
	 * @param questionAnswerDetail
	 */
	public void updateQuestionAnswerDetail(QuestionAnswerDetail questionAnswerDetail) throws RuntimeException;

	/**
	 * 查找一条QuestionAnswerDetail
	 * @return QuestionAnswerDetail
	 * @param id 主键id
	 */
	public QuestionAnswerDetail findQuestionAnswerDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找QuestionAnswerDetail
	 * @param cond 查询条件
	 * @return QuestionAnswerDetail列表
	 */
	public List<QuestionAnswerDetail> findQuestionAnswerDetailPage(QuestionAnswerDetailCond cond) ;

	/**
	 * 查找全部QuestionAnswerDetail
	 * @param cond 查询条件
	 * @return QuestionAnswerDetail列表
	 */
	public List<QuestionAnswerDetail> findQuestionAnswerDetail(QuestionAnswerDetailCond cond) ;

	/**
	 * 查找符合条件的记录条数QuestionAnswerDetail
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findQuestionAnswerDetailCount(QuestionAnswerDetailCond cond) ;

	/**
	 * 自定义问卷的回答（填写）情况（按题目汇总）
	 * Map的格式为[topicName,inputCount] 说明为:[问题,录入数量]
	 * @param cond
	 * @return
	 */
	public List<Map> findQuestionAnswerInputCount(QuestionAnswerDetailCond cond) ;
	
	/**
	 * 根据中山客户情况分析cond获取对应的QuestionAnswerDetail
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<QuestionAnswerDetail> findQuestionAnswerDetailByZsCond(ZsCustomerAnalysisCond cond) throws RuntimeException;

	public List<QuestionAnswerDetail> findQuestionAnswerDetailByQuestionIdAndCustId(
			Map map);
}
