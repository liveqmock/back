package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.ISaleDefaultQuestionMapper;
import com.ihk.saleunit.data.pojo.SaleDefaultQuestion;
import com.ihk.saleunit.data.pojo.SaleDefaultQuestionCond;
import com.ihk.saleunit.data.services.ISaleDefaultQuestionServices;

@Service("saleDefaultQuestionServices")
@SuppressWarnings("unchecked")
public class SaleDefaultQuestionServices implements ISaleDefaultQuestionServices {
	@Autowired	 ISaleDefaultQuestionMapper saleDefaultQuestionMapper;

	public void deleteSaleDefaultQuestion(int id) throws RuntimeException {
		saleDefaultQuestionMapper.deleteSaleDefaultQuestion(id);
	}

	public void addSaleDefaultQuestion(SaleDefaultQuestion saleDefaultQuestion) throws RuntimeException {		
		saleDefaultQuestionMapper.addSaleDefaultQuestion(saleDefaultQuestion);
	}

	@Override
	public SaleDefaultQuestion findSaleDefaultQuestionById(int id) throws RuntimeException {
		return saleDefaultQuestionMapper.findSaleDefaultQuestionById(id);
	}

	@Override
	public void updateSaleDefaultQuestion(SaleDefaultQuestion saleDefaultQuestion) throws RuntimeException {
		saleDefaultQuestionMapper.updateSaleDefaultQuestion(saleDefaultQuestion);		
	}
	
	public List<SaleDefaultQuestion> findSaleDefaultQuestionPage(SaleDefaultQuestionCond cond) throws RuntimeException {
		int recordCount = saleDefaultQuestionMapper.findSaleDefaultQuestionCount(cond);
		
		cond.recordCount = recordCount;
				
		return saleDefaultQuestionMapper.findSaleDefaultQuestionPage(cond);
	}
    
	public List<SaleDefaultQuestion> findSaleDefaultQuestion(SaleDefaultQuestionCond cond) throws RuntimeException {
    	return saleDefaultQuestionMapper.findSaleDefaultQuestion(cond);
	}
}
