package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.action.new_report.cond.ZsCustomerAnalysisCond;
import com.ihk.saleunit.data.IQuestionAnswerDetailMapper;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetail;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetailCond;
import com.ihk.saleunit.data.services.IQuestionAnswerDetailServices;

/**
 * QuestionAnswerDetail的Services实现(业务实现)
 * @author 
 *
 */
@Service("questionAnswerDetailServices")
public class QuestionAnswerDetailServices implements IQuestionAnswerDetailServices {
	/**
	 * questionAnswerDetail数据访问接口
	 */
	@Autowired	 IQuestionAnswerDetailMapper questionAnswerDetailMapper;

	/**
	 * 删除一条QuestionAnswerDetail
	 * @param id
	 */
	public void deleteQuestionAnswerDetail(int id) throws RuntimeException {
		questionAnswerDetailMapper.deleteQuestionAnswerDetail(id);
	}

	/**
	 * 新增QuestionAnswerDetail
	 * @param questionAnswerDetail
	 */
	public void addQuestionAnswerDetail(QuestionAnswerDetail questionAnswerDetail) throws RuntimeException {		
		questionAnswerDetailMapper.addQuestionAnswerDetail(questionAnswerDetail);
	}

	/**
	 * 查找一条QuestionAnswerDetail
	 * @return QuestionAnswerDetail
	 * @param id 主键id
	 */
	@Override
	public QuestionAnswerDetail findQuestionAnswerDetailById(int id) throws RuntimeException {
		return questionAnswerDetailMapper.findQuestionAnswerDetailById(id);
	}

	/**
	 * 修改QuestionAnswerDetail
	 * @param questionAnswerDetail
	 */
	@Override
	public void updateQuestionAnswerDetail(QuestionAnswerDetail questionAnswerDetail) throws RuntimeException {
		questionAnswerDetailMapper.updateQuestionAnswerDetail(questionAnswerDetail);		
	}

	/**
	 * 分页查找QuestionAnswerDetail
	 * @param cond 查询条件
	 * @return QuestionAnswerDetail列表
	 */
	public List<QuestionAnswerDetail> findQuestionAnswerDetailPage(QuestionAnswerDetailCond cond) throws RuntimeException {
		int recordCount = questionAnswerDetailMapper.findQuestionAnswerDetailCount(cond);
		
		cond.recordCount = recordCount;
				
		return questionAnswerDetailMapper.findQuestionAnswerDetailPage(cond);
	}

	/**
	 * 查找全部QuestionAnswerDetail
	 * @param cond 查询条件
	 * @return QuestionAnswerDetail列表
	 */
	public List<QuestionAnswerDetail> findQuestionAnswerDetail(QuestionAnswerDetailCond cond) throws RuntimeException {
    	return questionAnswerDetailMapper.findQuestionAnswerDetail(cond);
	}

	/**
	 * 自定义问卷的回答（填写）情况（按题目汇总）
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map> findQuestionAnswerInputCount(QuestionAnswerDetailCond cond)throws RuntimeException {
    	return questionAnswerDetailMapper.findQuestionAnswerInputCount(cond);
	}

	@Override
	public List<QuestionAnswerDetail> findQuestionAnswerDetailByZsCond(
			ZsCustomerAnalysisCond cond) {
		return questionAnswerDetailMapper.findQuestionAnswerDetailByZsCond(cond);
	}

	@Override
	public List<QuestionAnswerDetail> findQuestionAnswerDetailByQuestionIdAndCustId(
			Map map) {
		return questionAnswerDetailMapper.findQuestionAnswerDetailByQuestionIdAndCustId(map);
	}
}
