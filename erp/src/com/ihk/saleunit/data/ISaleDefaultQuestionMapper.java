package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.SaleDefaultQuestion;
import com.ihk.saleunit.data.pojo.SaleDefaultQuestionCond;
 
public interface ISaleDefaultQuestionMapper {

	public void addSaleDefaultQuestion(SaleDefaultQuestion saleDefaultQuestion) ;

	public void deleteSaleDefaultQuestion(int id) throws RuntimeException;

	public void updateSaleDefaultQuestion(SaleDefaultQuestion saleDefaultQuestion) throws RuntimeException;
	
	public SaleDefaultQuestion findSaleDefaultQuestionById(int id) throws RuntimeException;
	
	public List<SaleDefaultQuestion> findSaleDefaultQuestionPage(SaleDefaultQuestionCond cond) ;
    
	public List<SaleDefaultQuestion> findSaleDefaultQuestion(SaleDefaultQuestionCond cond) ;
    
	public int findSaleDefaultQuestionCount(SaleDefaultQuestionCond cond) ;
}
