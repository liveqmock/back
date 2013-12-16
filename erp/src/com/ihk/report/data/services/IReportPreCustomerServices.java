package com.ihk.report.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCompany;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCompanyCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCompanyDate;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCompanyDateCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerDate;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerDateCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerPhoneMulProject;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerPhoneMulProjectCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProject;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProjectCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProjectDate;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProjectDateCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestion;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestionCompany;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestionCompanyCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestionCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestionSalesman;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerQuestionSalesmanCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerSalesDate;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerSalesDateCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerSalesman;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerSalesmanCond;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetail;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetailCond;

/**
 *  售前客户数
 * @author peter
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IReportPreCustomerServices {

	/**
	 * 取得客户数，前几名公司的客户数
	 * @param cond
	 * @return
	 */
	public List<ReportPreCustomerCompany> groupByCompany(ReportPreCustomerCompanyCond cond) throws RuntimeException;

	/**
	 * 取得售前客户数的总和
	 * @param cond
	 * @return
	 */
	public int getSumNumber(ReportPreCustomerCond cond);

	/**
	 * 取得客户数，前几名项目的客户数
	 * @param cond
	 * @return
	 */
	public List<ReportPreCustomerProject> groupByProject(ReportPreCustomerProjectCond cond) throws RuntimeException;

	/**
	 * 取得客户数，前几名销售人员的客户数
	 * @param cond
	 * @return
	 */
	public List<ReportPreCustomerSalesman> groupBySalesman(ReportPreCustomerSalesmanCond cond) throws RuntimeException;
	
	/**
	 * 取得客户数的日期变化
	 * @param cond
	 * @return
	 */
	public List<ReportPreCustomerDate> groupByDate(ReportPreCustomerDateCond cond) throws RuntimeException;

	/**
	 * 取得客户数的环比变化(项目,日期分组)
	 * @param cond
	 * @return
	 */
	public List<ReportPreCustomerProjectDate> groupByProjectDate(ReportPreCustomerProjectDateCond cond) throws RuntimeException;


	//TODO 交叉表
	

	/**
	 * 取得(电话)跨项目客户的分组报表（活跃客户筛选报表）
	 * @param cond
	 * @return
	 */
	public List<ReportPreCustomerPhoneMulProject> phoneMulProject(ReportPreCustomerPhoneMulProjectCond cond) throws RuntimeException;

	/**
	 * 取得跨项目客户的明细报表（活跃客户筛选报表）
	 * @param cond
	 * @return
	 */
	public List<Customer> phoneMulProjectDetail(ReportPreCustomerPhoneMulProjectCond cond) throws RuntimeException;

	/**
	 * 取得客户数的环比变化(公司,日期分组)
	 * @param cond
	 * @return
	 */
	public List<ReportPreCustomerCompanyDate> groupByCompanyDate(
			ReportPreCustomerCompanyDateCond cond);

	/**
	 * 取得客户数的环比变化(销售,日期分组)
	 * @param cond
	 * @return
	 */
	public List<ReportPreCustomerSalesDate> groupBySalesDate(
			ReportPreCustomerSalesDateCond cond);

	/**
	 * 问卷的具体回答明细情况
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<QuestionAnswerDetail> findQuestionAnswerDetail(QuestionAnswerDetailCond cond) throws RuntimeException;


	/**
	 * 售前客户问卷分类(公司)
	 * @param cond
	 * @return
	 */
	public List<ReportPreCustomerQuestionCompany> findQuestionGroupByTopicCompany(
			ReportPreCustomerQuestionCompanyCond cond);
	
	/**
	 * 售前客户问卷分类(项目)
	 * @param cond
	 * @return
	 */
	public List<ReportPreCustomerQuestion> findQuestionGroupByTopicProject(
			ReportPreCustomerQuestionCond cond);

	/**
	 * 售前客户问卷分类(销售人员)
	 * @param cond
	 * @return
	 */
	public List<ReportPreCustomerQuestionSalesman> findQuestionGroupByTopicSalesman(
			ReportPreCustomerQuestionSalesmanCond cond);
	
}