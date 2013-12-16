package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.SaleDefaultQuestion;
import com.ihk.saleunit.data.pojo.SaleDefaultQuestionCond;

@Transactional 
@SuppressWarnings("unchecked")
public interface ISaleDefaultQuestionServices {
	public void addSaleDefaultQuestion(SaleDefaultQuestion saleDefaultQuestion) throws RuntimeException;

	public void deleteSaleDefaultQuestion(int id) throws RuntimeException;

	public void updateSaleDefaultQuestion(SaleDefaultQuestion saleDefaultQuestion) throws RuntimeException;

	public SaleDefaultQuestion findSaleDefaultQuestionById(int id) throws RuntimeException;
    
	public List<SaleDefaultQuestion> findSaleDefaultQuestionPage(SaleDefaultQuestionCond cond) throws RuntimeException;
    
	public List<SaleDefaultQuestion> findSaleDefaultQuestion(SaleDefaultQuestionCond cond) throws RuntimeException;
}