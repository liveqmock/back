package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IQuestionAnwserMapper;
import com.ihk.saleunit.data.pojo.QuestionAnwser;
import com.ihk.saleunit.data.pojo.QuestionAnwserCond;
import com.ihk.saleunit.data.services.IQuestionAnwserServices;

/**
 * QuestionAnwser的Services实现(业务实现)
 * @author 
 *
 */
@Service("questionAnwserServices")
@SuppressWarnings("unchecked")
public class QuestionAnwserServices implements IQuestionAnwserServices {
	/**
	 * questionAnwser数据访问接口
	 */
	@Autowired	 IQuestionAnwserMapper questionAnwserMapper;

	/**
	 * 删除一条QuestionAnwser
	 * @param id
	 */
	public void deleteQuestionAnwser(int id) throws RuntimeException {
		questionAnwserMapper.deleteQuestionAnwser(id);
	}

	/**
	 * 新增QuestionAnwser
	 * @param questionAnwser
	 */
	public void addQuestionAnwser(QuestionAnwser questionAnwser) throws RuntimeException {		
		questionAnwserMapper.addQuestionAnwser(questionAnwser);
	}

	/**
	 * 查找一条QuestionAnwser
	 * @return QuestionAnwser
	 * @param id 主键id
	 */
	@Override
	public QuestionAnwser findQuestionAnwserById(int id) throws RuntimeException {
		return questionAnwserMapper.findQuestionAnwserById(id);
	}

	/**
	 * 修改QuestionAnwser
	 * @param questionAnwser
	 */
	@Override
	public void updateQuestionAnwser(QuestionAnwser questionAnwser) throws RuntimeException {
		questionAnwserMapper.updateQuestionAnwser(questionAnwser);		
	}

	/**
	 * 分页查找QuestionAnwser
	 * @param cond 查询条件
	 * @return QuestionAnwser列表
	 */
	public List<QuestionAnwser> findQuestionAnwserPage(QuestionAnwserCond cond) throws RuntimeException {
		int recordCount = questionAnwserMapper.findQuestionAnwserCount(cond);
		
		cond.recordCount = recordCount;
				
		return questionAnwserMapper.findQuestionAnwserPage(cond);
	}

	/**
	 * 查找全部QuestionAnwser
	 * @param cond 查询条件
	 * @return QuestionAnwser列表
	 */
	public List<QuestionAnwser> findQuestionAnwser(QuestionAnwserCond cond) throws RuntimeException {
    	return questionAnwserMapper.findQuestionAnwser(cond);
	}
}
